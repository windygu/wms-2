package org.dddml.wms.domain.inventorypostingrule;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInventoryPostingRuleApplicationService implements InventoryPostingRuleApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private InventoryPostingRuleStateRepository stateRepository;

    protected InventoryPostingRuleStateRepository getStateRepository() {
        return stateRepository;
    }

    private InventoryPostingRuleStateQueryRepository stateQueryRepository;

    protected InventoryPostingRuleStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<InventoryPostingRuleAggregate, InventoryPostingRuleState> aggregateEventListener;

    public AggregateEventListener<InventoryPostingRuleAggregate, InventoryPostingRuleState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<InventoryPostingRuleAggregate, InventoryPostingRuleState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractInventoryPostingRuleApplicationService(EventStore eventStore, InventoryPostingRuleStateRepository stateRepository, InventoryPostingRuleStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(InventoryPostingRuleCommand.CreateInventoryPostingRule c) {
        update(c, ar -> ar.create(c));
    }

    public void when(InventoryPostingRuleCommand.MergePatchInventoryPostingRule c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(InventoryPostingRuleCommand.DeleteInventoryPostingRule c) {
        update(c, ar -> ar.delete(c));
    }

    public InventoryPostingRuleState get(String id) {
        InventoryPostingRuleState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<InventoryPostingRuleState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<InventoryPostingRuleState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<InventoryPostingRuleState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<InventoryPostingRuleState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public InventoryPostingRuleStateEvent getStateEvent(String inventoryPostingRuleId, long version) {
        InventoryPostingRuleStateEvent e = (InventoryPostingRuleStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(inventoryPostingRuleId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(inventoryPostingRuleId, 0);
        }
        return e;
    }

    public InventoryPostingRuleState getHistoryState(String inventoryPostingRuleId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractInventoryPostingRuleStateEvent.class, toEventStoreAggregateId(inventoryPostingRuleId), version - 1);
        return new AbstractInventoryPostingRuleState.SimpleInventoryPostingRuleState(eventStream.getEvents());
    }


    public InventoryPostingRuleAggregate getInventoryPostingRuleAggregate(InventoryPostingRuleState state)
    {
        return new AbstractInventoryPostingRuleAggregate.SimpleInventoryPostingRuleAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(InventoryPostingRuleCommand c, Consumer<InventoryPostingRuleAggregate> action)
    {
        String aggregateId = c.getInventoryPostingRuleId();
        InventoryPostingRuleState state = getStateRepository().get(aggregateId, false);
        InventoryPostingRuleAggregate aggregate = getInventoryPostingRuleAggregate(state);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, InventoryPostingRuleAggregate aggregate, InventoryPostingRuleState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(InventoryPostingRuleStateEvent.InventoryPostingRuleStateCreated stateCreated) {
        String aggregateId = stateCreated.getStateEventId().getInventoryPostingRuleId();
        InventoryPostingRuleState state = new AbstractInventoryPostingRuleState.SimpleInventoryPostingRuleState();
        state.setInventoryPostingRuleId(aggregateId);

        InventoryPostingRuleAggregate aggregate = getInventoryPostingRuleAggregate(state);
        ((AbstractInventoryPostingRuleAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(InventoryPostingRuleCommand command, EventStoreAggregateId eventStoreAggregateId, InventoryPostingRuleState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(InventoryPostingRuleState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractInventoryPostingRuleStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleInventoryPostingRuleApplicationService extends AbstractInventoryPostingRuleApplicationService 
    {
        public SimpleInventoryPostingRuleApplicationService(EventStore eventStore, InventoryPostingRuleStateRepository stateRepository, InventoryPostingRuleStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

