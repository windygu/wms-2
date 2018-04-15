package org.dddml.wms.domain.inventoryitementrymvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInventoryItemEntryMvoApplicationService implements InventoryItemEntryMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private InventoryItemEntryMvoStateRepository stateRepository;

    protected InventoryItemEntryMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private InventoryItemEntryMvoStateQueryRepository stateQueryRepository;

    protected InventoryItemEntryMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<InventoryItemEntryMvoAggregate, InventoryItemEntryMvoState> aggregateEventListener;

    public AggregateEventListener<InventoryItemEntryMvoAggregate, InventoryItemEntryMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<InventoryItemEntryMvoAggregate, InventoryItemEntryMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractInventoryItemEntryMvoApplicationService(EventStore eventStore, InventoryItemEntryMvoStateRepository stateRepository, InventoryItemEntryMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(InventoryItemEntryMvoCommand.CreateInventoryItemEntryMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(InventoryItemEntryMvoCommand.MergePatchInventoryItemEntryMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public InventoryItemEntryMvoState get(InventoryItemEntryId id) {
        InventoryItemEntryMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<InventoryItemEntryMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<InventoryItemEntryMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<InventoryItemEntryMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<InventoryItemEntryMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public InventoryItemEntryMvoEvent getEvent(InventoryItemEntryId inventoryItemEntryId, long version) {
        InventoryItemEntryMvoEvent e = (InventoryItemEntryMvoEvent)getEventStore().getEvent(toEventStoreAggregateId(inventoryItemEntryId), version);
        if (e != null)
        { e.setEventReadOnly(true); }
        else if (version == -1)
        {
            return getEvent(inventoryItemEntryId, 0);
        }
        return e;
    }

    public InventoryItemEntryMvoState getHistoryState(InventoryItemEntryId inventoryItemEntryId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractInventoryItemEntryMvoEvent.class, toEventStoreAggregateId(inventoryItemEntryId), version - 1);
        return new AbstractInventoryItemEntryMvoState.SimpleInventoryItemEntryMvoState(eventStream.getEvents());
    }


    public InventoryItemEntryMvoAggregate getInventoryItemEntryMvoAggregate(InventoryItemEntryMvoState state)
    {
        return new AbstractInventoryItemEntryMvoAggregate.SimpleInventoryItemEntryMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(InventoryItemEntryId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(InventoryItemEntryMvoCommand c, Consumer<InventoryItemEntryMvoAggregate> action)
    {
        InventoryItemEntryId aggregateId = c.getInventoryItemEntryId();
        InventoryItemEntryMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        InventoryItemEntryMvoAggregate aggregate = getInventoryItemEntryMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getInventoryItemVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, InventoryItemEntryMvoAggregate aggregate, InventoryItemEntryMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(InventoryItemEntryMvoEvent.InventoryItemEntryMvoStateCreated stateCreated) {
        InventoryItemEntryId aggregateId = stateCreated.getInventoryItemEntryMvoEventId().getInventoryItemEntryId();
        InventoryItemEntryMvoState state = new AbstractInventoryItemEntryMvoState.SimpleInventoryItemEntryMvoState();
        state.setInventoryItemEntryId(aggregateId);

        InventoryItemEntryMvoAggregate aggregate = getInventoryItemEntryMvoAggregate(state);
        ((AbstractInventoryItemEntryMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getInventoryItemEntryMvoEventId().getInventoryItemVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(InventoryItemEntryMvoCommand command, EventStoreAggregateId eventStoreAggregateId, InventoryItemEntryMvoState state)
    {
        boolean repeated = false;
        if (command.getInventoryItemVersion() == null) { command.setInventoryItemVersion(InventoryItemEntryMvoState.VERSION_NULL); }
        if (state.getInventoryItemVersion() != null && state.getInventoryItemVersion() > command.getInventoryItemVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractInventoryItemEntryMvoEvent.class, eventStoreAggregateId, command.getInventoryItemVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleInventoryItemEntryMvoApplicationService extends AbstractInventoryItemEntryMvoApplicationService 
    {
        public SimpleInventoryItemEntryMvoApplicationService(EventStore eventStore, InventoryItemEntryMvoStateRepository stateRepository, InventoryItemEntryMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

