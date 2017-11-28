package org.dddml.wms.domain.inventoryitemeventtype;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInventoryItemEventTypeApplicationService implements InventoryItemEventTypeApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private InventoryItemEventTypeStateRepository stateRepository;

    protected InventoryItemEventTypeStateRepository getStateRepository() {
        return stateRepository;
    }

    private InventoryItemEventTypeStateQueryRepository stateQueryRepository;

    protected InventoryItemEventTypeStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<InventoryItemEventTypeAggregate, InventoryItemEventTypeState> aggregateEventListener;

    public AggregateEventListener<InventoryItemEventTypeAggregate, InventoryItemEventTypeState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<InventoryItemEventTypeAggregate, InventoryItemEventTypeState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractInventoryItemEventTypeApplicationService(EventStore eventStore, InventoryItemEventTypeStateRepository stateRepository, InventoryItemEventTypeStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(InventoryItemEventTypeCommand.CreateInventoryItemEventType c) {
        update(c, ar -> ar.create(c));
    }

    public void when(InventoryItemEventTypeCommand.MergePatchInventoryItemEventType c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(InventoryItemEventTypeCommand.DeleteInventoryItemEventType c) {
        update(c, ar -> ar.delete(c));
    }

    public InventoryItemEventTypeState get(String id) {
        InventoryItemEventTypeState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<InventoryItemEventTypeState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<InventoryItemEventTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<InventoryItemEventTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<InventoryItemEventTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public InventoryItemEventTypeStateEvent getStateEvent(String inventoryItemEventTypeId, long version) {
        InventoryItemEventTypeStateEvent e = (InventoryItemEventTypeStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(inventoryItemEventTypeId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(inventoryItemEventTypeId, 0);
        }
        return e;
    }

    public InventoryItemEventTypeState getHistoryState(String inventoryItemEventTypeId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractInventoryItemEventTypeStateEvent.class, toEventStoreAggregateId(inventoryItemEventTypeId), version - 1);
        return new AbstractInventoryItemEventTypeState.SimpleInventoryItemEventTypeState(eventStream.getEvents());
    }


    public InventoryItemEventTypeAggregate getInventoryItemEventTypeAggregate(InventoryItemEventTypeState state)
    {
        return new AbstractInventoryItemEventTypeAggregate.SimpleInventoryItemEventTypeAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(InventoryItemEventTypeCommand c, Consumer<InventoryItemEventTypeAggregate> action)
    {
        String aggregateId = c.getInventoryItemEventTypeId();
        InventoryItemEventTypeState state = getStateRepository().get(aggregateId, false);
        InventoryItemEventTypeAggregate aggregate = getInventoryItemEventTypeAggregate(state);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, InventoryItemEventTypeAggregate aggregate, InventoryItemEventTypeState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateCreated stateCreated) {
        String aggregateId = stateCreated.getStateEventId().getInventoryItemEventTypeId();
        InventoryItemEventTypeState state = new AbstractInventoryItemEventTypeState.SimpleInventoryItemEventTypeState();
        state.setInventoryItemEventTypeId(aggregateId);

        InventoryItemEventTypeAggregate aggregate = getInventoryItemEventTypeAggregate(state);
        ((AbstractInventoryItemEventTypeAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(InventoryItemEventTypeCommand command, EventStoreAggregateId eventStoreAggregateId, InventoryItemEventTypeState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(InventoryItemEventTypeState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractInventoryItemEventTypeStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleInventoryItemEventTypeApplicationService extends AbstractInventoryItemEventTypeApplicationService 
    {
        public SimpleInventoryItemEventTypeApplicationService(EventStore eventStore, InventoryItemEventTypeStateRepository stateRepository, InventoryItemEventTypeStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

