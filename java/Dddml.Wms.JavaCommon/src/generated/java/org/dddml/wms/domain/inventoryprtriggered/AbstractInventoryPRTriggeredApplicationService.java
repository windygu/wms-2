package org.dddml.wms.domain.inventoryprtriggered;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInventoryPRTriggeredApplicationService implements InventoryPRTriggeredApplicationService
{
    private InventoryPRTriggeredStateRepository stateRepository;

    protected InventoryPRTriggeredStateRepository getStateRepository() {
        return stateRepository;
    }

    private InventoryPRTriggeredStateQueryRepository stateQueryRepository;

    protected InventoryPRTriggeredStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<InventoryPRTriggeredAggregate, InventoryPRTriggeredState> aggregateEventListener;

    public AggregateEventListener<InventoryPRTriggeredAggregate, InventoryPRTriggeredState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<InventoryPRTriggeredAggregate, InventoryPRTriggeredState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractInventoryPRTriggeredApplicationService(InventoryPRTriggeredStateRepository stateRepository, InventoryPRTriggeredStateQueryRepository stateQueryRepository) {
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(InventoryPRTriggeredCommand.CreateInventoryPRTriggered c) {
        update(c, ar -> ar.create(c));
    }

    public void when(InventoryPRTriggeredCommand.MergePatchInventoryPRTriggered c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public InventoryPRTriggeredState get(InventoryPRTriggeredId id) {
        InventoryPRTriggeredState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<InventoryPRTriggeredState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<InventoryPRTriggeredState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<InventoryPRTriggeredState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<InventoryPRTriggeredState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }


    public InventoryPRTriggeredAggregate getInventoryPRTriggeredAggregate(InventoryPRTriggeredState state)
    {
        return new AbstractInventoryPRTriggeredAggregate.SimpleInventoryPRTriggeredAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(InventoryPRTriggeredId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(InventoryPRTriggeredCommand c, Consumer<InventoryPRTriggeredAggregate> action)
    {
        InventoryPRTriggeredId aggregateId = c.getInventoryPRTriggeredId();
        InventoryPRTriggeredState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        InventoryPRTriggeredAggregate aggregate = getInventoryPRTriggeredAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, InventoryPRTriggeredAggregate aggregate, InventoryPRTriggeredState state) {
        getStateRepository().save(state);
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(InventoryPRTriggeredEvent.InventoryPRTriggeredStateCreated stateCreated) {
        InventoryPRTriggeredId aggregateId = ((InventoryPRTriggeredEvent.SqlInventoryPRTriggeredEvent)stateCreated).getInventoryPRTriggeredEventId().getInventoryPRTriggeredId();
        InventoryPRTriggeredState state = new AbstractInventoryPRTriggeredState.SimpleInventoryPRTriggeredState();
        state.setInventoryPRTriggeredId(aggregateId);

        InventoryPRTriggeredAggregate aggregate = getInventoryPRTriggeredAggregate(state);
        ((AbstractInventoryPRTriggeredAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, ((InventoryPRTriggeredEvent.SqlInventoryPRTriggeredEvent)stateCreated).getInventoryPRTriggeredEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(InventoryPRTriggeredCommand command, EventStoreAggregateId eventStoreAggregateId, InventoryPRTriggeredState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(InventoryPRTriggeredState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() == command.getVersion() + 1)
        {
            if (command.getCommandId() != null && command.getCommandId().equals(state.getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleInventoryPRTriggeredApplicationService extends AbstractInventoryPRTriggeredApplicationService 
    {
        public SimpleInventoryPRTriggeredApplicationService(InventoryPRTriggeredStateRepository stateRepository, InventoryPRTriggeredStateQueryRepository stateQueryRepository)
        {
            super(stateRepository, stateQueryRepository);
        }
    }

}

