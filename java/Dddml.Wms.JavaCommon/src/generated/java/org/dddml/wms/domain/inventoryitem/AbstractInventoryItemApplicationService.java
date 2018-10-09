package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInventoryItemApplicationService implements InventoryItemApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private InventoryItemStateRepository stateRepository;

    protected InventoryItemStateRepository getStateRepository() {
        return stateRepository;
    }

    private InventoryItemStateQueryRepository stateQueryRepository;

    protected InventoryItemStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<InventoryItemAggregate, InventoryItemState> aggregateEventListener;

    public AggregateEventListener<InventoryItemAggregate, InventoryItemState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<InventoryItemAggregate, InventoryItemState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractInventoryItemApplicationService(EventStore eventStore, InventoryItemStateRepository stateRepository, InventoryItemStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(InventoryItemCommand.CreateInventoryItem c) {
        update(c, ar -> ar.create(c));
    }

    public void when(InventoryItemCommand.MergePatchInventoryItem c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public InventoryItemState get(InventoryItemId id) {
        InventoryItemState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<InventoryItemState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<InventoryItemState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<InventoryItemState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<InventoryItemState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public InventoryItemEvent getEvent(InventoryItemId inventoryItemId, long version) {
        InventoryItemEvent e = (InventoryItemEvent)getEventStore().getEvent(toEventStoreAggregateId(inventoryItemId), version);
        if (e != null) {
            ((InventoryItemEvent.SqlInventoryItemEvent)e).setEventReadOnly(true); 
        } else if (version == -1) {
            return getEvent(inventoryItemId, 0);
        }
        return e;
    }

    public InventoryItemState getHistoryState(InventoryItemId inventoryItemId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractInventoryItemEvent.class, toEventStoreAggregateId(inventoryItemId), version - 1);
        return new AbstractInventoryItemState.SimpleInventoryItemState(eventStream.getEvents());
    }

    public InventoryItemEntryState getInventoryItemEntry(InventoryItemId inventoryItemId, Long entrySeqId) {
        return getStateQueryRepository().getInventoryItemEntry(inventoryItemId, entrySeqId);
    }

    public Iterable<InventoryItemEntryState> getInventoryItemEntries(InventoryItemId inventoryItemId, Criterion filter, List<String> orders) {
        return getStateQueryRepository().getInventoryItemEntries(inventoryItemId, filter, orders);
    }


    public InventoryItemAggregate getInventoryItemAggregate(InventoryItemState state)
    {
        return new AbstractInventoryItemAggregate.SimpleInventoryItemAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(InventoryItemId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(InventoryItemCommand c, Consumer<InventoryItemAggregate> action)
    {
        InventoryItemId aggregateId = c.getInventoryItemId();
        InventoryItemState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        InventoryItemAggregate aggregate = getInventoryItemAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, InventoryItemAggregate aggregate, InventoryItemState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(InventoryItemEvent.InventoryItemStateCreated stateCreated) {
        InventoryItemId aggregateId = ((InventoryItemEvent.SqlInventoryItemEvent)stateCreated).getInventoryItemEventId().getInventoryItemId();
        InventoryItemState.SqlInventoryItemState state = new AbstractInventoryItemState.SimpleInventoryItemState();
        state.setInventoryItemId(aggregateId);

        InventoryItemAggregate aggregate = getInventoryItemAggregate(state);
        ((AbstractInventoryItemAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, ((InventoryItemEvent.SqlInventoryItemEvent)stateCreated).getInventoryItemEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(InventoryItemCommand command, EventStoreAggregateId eventStoreAggregateId, InventoryItemState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(InventoryItemState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractInventoryItemEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleInventoryItemApplicationService extends AbstractInventoryItemApplicationService 
    {
        public SimpleInventoryItemApplicationService(EventStore eventStore, InventoryItemStateRepository stateRepository, InventoryItemStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

