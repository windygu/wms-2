package org.dddml.wms.domain.sellableinventoryitementrymvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractSellableInventoryItemEntryMvoApplicationService implements SellableInventoryItemEntryMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private SellableInventoryItemEntryMvoStateRepository stateRepository;

    protected SellableInventoryItemEntryMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private SellableInventoryItemEntryMvoStateQueryRepository stateQueryRepository;

    protected SellableInventoryItemEntryMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<SellableInventoryItemEntryMvoAggregate, SellableInventoryItemEntryMvoState> aggregateEventListener;

    public AggregateEventListener<SellableInventoryItemEntryMvoAggregate, SellableInventoryItemEntryMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<SellableInventoryItemEntryMvoAggregate, SellableInventoryItemEntryMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractSellableInventoryItemEntryMvoApplicationService(EventStore eventStore, SellableInventoryItemEntryMvoStateRepository stateRepository, SellableInventoryItemEntryMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(SellableInventoryItemEntryMvoCommand.CreateSellableInventoryItemEntryMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(SellableInventoryItemEntryMvoCommand.MergePatchSellableInventoryItemEntryMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public SellableInventoryItemEntryMvoState get(SellableInventoryItemEntryId id) {
        SellableInventoryItemEntryMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<SellableInventoryItemEntryMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<SellableInventoryItemEntryMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<SellableInventoryItemEntryMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<SellableInventoryItemEntryMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public SellableInventoryItemEntryMvoStateEvent getStateEvent(SellableInventoryItemEntryId sellableInventoryItemEntryId, long version) {
        SellableInventoryItemEntryMvoStateEvent e = (SellableInventoryItemEntryMvoStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(sellableInventoryItemEntryId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(sellableInventoryItemEntryId, 0);
        }
        return e;
    }

    public SellableInventoryItemEntryMvoState getHistoryState(SellableInventoryItemEntryId sellableInventoryItemEntryId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractSellableInventoryItemEntryMvoStateEvent.class, toEventStoreAggregateId(sellableInventoryItemEntryId), version - 1);
        return new AbstractSellableInventoryItemEntryMvoState.SimpleSellableInventoryItemEntryMvoState(eventStream.getEvents());
    }


    public SellableInventoryItemEntryMvoAggregate getSellableInventoryItemEntryMvoAggregate(SellableInventoryItemEntryMvoState state)
    {
        return new AbstractSellableInventoryItemEntryMvoAggregate.SimpleSellableInventoryItemEntryMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(SellableInventoryItemEntryId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(SellableInventoryItemEntryMvoCommand c, Consumer<SellableInventoryItemEntryMvoAggregate> action)
    {
        SellableInventoryItemEntryId aggregateId = c.getSellableInventoryItemEntryId();
        SellableInventoryItemEntryMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        SellableInventoryItemEntryMvoAggregate aggregate = getSellableInventoryItemEntryMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getSellableInventoryItemVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, SellableInventoryItemEntryMvoAggregate aggregate, SellableInventoryItemEntryMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateCreated stateCreated) {
        SellableInventoryItemEntryId aggregateId = stateCreated.getStateEventId().getSellableInventoryItemEntryId();
        SellableInventoryItemEntryMvoState state = new AbstractSellableInventoryItemEntryMvoState.SimpleSellableInventoryItemEntryMvoState();
        state.setSellableInventoryItemEntryId(aggregateId);

        SellableInventoryItemEntryMvoAggregate aggregate = getSellableInventoryItemEntryMvoAggregate(state);
        ((AbstractSellableInventoryItemEntryMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getSellableInventoryItemVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(SellableInventoryItemEntryMvoCommand command, EventStoreAggregateId eventStoreAggregateId, SellableInventoryItemEntryMvoState state)
    {
        boolean repeated = false;
        if (command.getSellableInventoryItemVersion() == null) { command.setSellableInventoryItemVersion(SellableInventoryItemEntryMvoState.VERSION_NULL); }
        if (state.getSellableInventoryItemVersion() != null && state.getSellableInventoryItemVersion() > command.getSellableInventoryItemVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractSellableInventoryItemEntryMvoStateEvent.class, eventStoreAggregateId, command.getSellableInventoryItemVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleSellableInventoryItemEntryMvoApplicationService extends AbstractSellableInventoryItemEntryMvoApplicationService 
    {
        public SimpleSellableInventoryItemEntryMvoApplicationService(EventStore eventStore, SellableInventoryItemEntryMvoStateRepository stateRepository, SellableInventoryItemEntryMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

