package org.dddml.wms.domain.damagetype;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractDamageTypeApplicationService implements DamageTypeApplicationService
{
    private DamageTypeStateRepository stateRepository;

    protected DamageTypeStateRepository getStateRepository() {
        return stateRepository;
    }

    private DamageTypeStateQueryRepository stateQueryRepository;

    protected DamageTypeStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<DamageTypeAggregate, DamageTypeState> aggregateEventListener;

    public AggregateEventListener<DamageTypeAggregate, DamageTypeState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<DamageTypeAggregate, DamageTypeState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractDamageTypeApplicationService(DamageTypeStateRepository stateRepository, DamageTypeStateQueryRepository stateQueryRepository) {
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(DamageTypeCommand.CreateDamageType c) {
        update(c, ar -> ar.create(c));
    }

    public void when(DamageTypeCommand.MergePatchDamageType c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(DamageTypeCommand.DeleteDamageType c) {
        update(c, ar -> ar.delete(c));
    }

    public DamageTypeState get(String id) {
        DamageTypeState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<DamageTypeState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<DamageTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<DamageTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<DamageTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }


    public DamageTypeAggregate getDamageTypeAggregate(DamageTypeState state)
    {
        return new AbstractDamageTypeAggregate.SimpleDamageTypeAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(DamageTypeCommand c, Consumer<DamageTypeAggregate> action)
    {
        String aggregateId = c.getDamageTypeId();
        DamageTypeState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        DamageTypeAggregate aggregate = getDamageTypeAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, DamageTypeAggregate aggregate, DamageTypeState state) {
        getStateRepository().save(state);
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(DamageTypeStateEvent.DamageTypeStateCreated stateCreated) {
        String aggregateId = stateCreated.getStateEventId().getDamageTypeId();
        DamageTypeState state = new AbstractDamageTypeState.SimpleDamageTypeState();
        state.setDamageTypeId(aggregateId);

        DamageTypeAggregate aggregate = getDamageTypeAggregate(state);
        ((AbstractDamageTypeAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(DamageTypeCommand command, EventStoreAggregateId eventStoreAggregateId, DamageTypeState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(DamageTypeState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() == command.getVersion() + 1)
        {
            if (command.getCommandId() != null && command.getCommandId().equals(state.getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleDamageTypeApplicationService extends AbstractDamageTypeApplicationService 
    {
        public SimpleDamageTypeApplicationService(DamageTypeStateRepository stateRepository, DamageTypeStateQueryRepository stateQueryRepository)
        {
            super(stateRepository, stateQueryRepository);
        }
    }

}

