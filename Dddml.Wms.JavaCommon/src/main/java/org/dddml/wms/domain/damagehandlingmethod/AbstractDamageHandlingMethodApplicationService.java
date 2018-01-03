package org.dddml.wms.domain.damagehandlingmethod;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractDamageHandlingMethodApplicationService implements DamageHandlingMethodApplicationService
{
    private DamageHandlingMethodStateRepository stateRepository;

    protected DamageHandlingMethodStateRepository getStateRepository() {
        return stateRepository;
    }

    private DamageHandlingMethodStateQueryRepository stateQueryRepository;

    protected DamageHandlingMethodStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<DamageHandlingMethodAggregate, DamageHandlingMethodState> aggregateEventListener;

    public AggregateEventListener<DamageHandlingMethodAggregate, DamageHandlingMethodState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<DamageHandlingMethodAggregate, DamageHandlingMethodState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractDamageHandlingMethodApplicationService(DamageHandlingMethodStateRepository stateRepository, DamageHandlingMethodStateQueryRepository stateQueryRepository) {
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(DamageHandlingMethodCommand.CreateDamageHandlingMethod c) {
        update(c, ar -> ar.create(c));
    }

    public void when(DamageHandlingMethodCommand.MergePatchDamageHandlingMethod c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(DamageHandlingMethodCommand.DeleteDamageHandlingMethod c) {
        update(c, ar -> ar.delete(c));
    }

    public DamageHandlingMethodState get(String id) {
        DamageHandlingMethodState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<DamageHandlingMethodState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<DamageHandlingMethodState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<DamageHandlingMethodState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<DamageHandlingMethodState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }


    public DamageHandlingMethodAggregate getDamageHandlingMethodAggregate(DamageHandlingMethodState state)
    {
        return new AbstractDamageHandlingMethodAggregate.SimpleDamageHandlingMethodAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(DamageHandlingMethodCommand c, Consumer<DamageHandlingMethodAggregate> action)
    {
        String aggregateId = c.getDamageHandlingMethodId();
        DamageHandlingMethodState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        DamageHandlingMethodAggregate aggregate = getDamageHandlingMethodAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, DamageHandlingMethodAggregate aggregate, DamageHandlingMethodState state) {
        getStateRepository().save(state);
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(DamageHandlingMethodStateEvent.DamageHandlingMethodStateCreated stateCreated) {
        String aggregateId = stateCreated.getStateEventId().getDamageHandlingMethodId();
        DamageHandlingMethodState state = new AbstractDamageHandlingMethodState.SimpleDamageHandlingMethodState();
        state.setDamageHandlingMethodId(aggregateId);

        DamageHandlingMethodAggregate aggregate = getDamageHandlingMethodAggregate(state);
        ((AbstractDamageHandlingMethodAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(DamageHandlingMethodCommand command, EventStoreAggregateId eventStoreAggregateId, DamageHandlingMethodState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(DamageHandlingMethodState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() == command.getVersion() + 1)
        {
            if (command.getCommandId() != null && command.getCommandId().equals(state.getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleDamageHandlingMethodApplicationService extends AbstractDamageHandlingMethodApplicationService 
    {
        public SimpleDamageHandlingMethodApplicationService(DamageHandlingMethodStateRepository stateRepository, DamageHandlingMethodStateQueryRepository stateQueryRepository)
        {
            super(stateRepository, stateQueryRepository);
        }
    }

}

