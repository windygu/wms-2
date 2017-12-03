package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractSellableInventoryItemApplicationService implements SellableInventoryItemApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private SellableInventoryItemStateRepository stateRepository;

    protected SellableInventoryItemStateRepository getStateRepository() {
        return stateRepository;
    }

    private SellableInventoryItemStateQueryRepository stateQueryRepository;

    protected SellableInventoryItemStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<SellableInventoryItemAggregate, SellableInventoryItemState> aggregateEventListener;

    public AggregateEventListener<SellableInventoryItemAggregate, SellableInventoryItemState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<SellableInventoryItemAggregate, SellableInventoryItemState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractSellableInventoryItemApplicationService(EventStore eventStore, SellableInventoryItemStateRepository stateRepository, SellableInventoryItemStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(SellableInventoryItemCommand.CreateSellableInventoryItem c) {
        update(c, ar -> ar.create(c));
    }

    public void when(SellableInventoryItemCommand.MergePatchSellableInventoryItem c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public SellableInventoryItemState get(InventoryItemId id) {
        SellableInventoryItemState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<SellableInventoryItemState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<SellableInventoryItemState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<SellableInventoryItemState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<SellableInventoryItemState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public SellableInventoryItemStateEvent getStateEvent(InventoryItemId sellableInventoryItemId, long version) {
        SellableInventoryItemStateEvent e = (SellableInventoryItemStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(sellableInventoryItemId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(sellableInventoryItemId, 0);
        }
        return e;
    }

    public SellableInventoryItemState getHistoryState(InventoryItemId sellableInventoryItemId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractSellableInventoryItemStateEvent.class, toEventStoreAggregateId(sellableInventoryItemId), version - 1);
        return new AbstractSellableInventoryItemState.SimpleSellableInventoryItemState(eventStream.getEvents());
    }

    public SellableInventoryItemEntryState getSellableInventoryItemEntry(InventoryItemId sellableInventoryItemId, Long entrySeqId) {
        return getStateQueryRepository().getSellableInventoryItemEntry(sellableInventoryItemId, entrySeqId);
    }


    public SellableInventoryItemAggregate getSellableInventoryItemAggregate(SellableInventoryItemState state)
    {
        return new AbstractSellableInventoryItemAggregate.SimpleSellableInventoryItemAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(InventoryItemId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(SellableInventoryItemCommand c, Consumer<SellableInventoryItemAggregate> action)
    {
        InventoryItemId aggregateId = c.getSellableInventoryItemId();
        SellableInventoryItemState state = getStateRepository().get(aggregateId, false);
        SellableInventoryItemAggregate aggregate = getSellableInventoryItemAggregate(state);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, SellableInventoryItemAggregate aggregate, SellableInventoryItemState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(SellableInventoryItemStateEvent.SellableInventoryItemStateCreated stateCreated) {
        InventoryItemId aggregateId = stateCreated.getStateEventId().getSellableInventoryItemId();
        SellableInventoryItemState state = new AbstractSellableInventoryItemState.SimpleSellableInventoryItemState();
        state.setSellableInventoryItemId(aggregateId);

        SellableInventoryItemAggregate aggregate = getSellableInventoryItemAggregate(state);
        ((AbstractSellableInventoryItemAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(SellableInventoryItemCommand command, EventStoreAggregateId eventStoreAggregateId, SellableInventoryItemState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(SellableInventoryItemState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractSellableInventoryItemStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleSellableInventoryItemApplicationService extends AbstractSellableInventoryItemApplicationService 
    {
        public SimpleSellableInventoryItemApplicationService(EventStore eventStore, SellableInventoryItemStateRepository stateRepository, SellableInventoryItemStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

