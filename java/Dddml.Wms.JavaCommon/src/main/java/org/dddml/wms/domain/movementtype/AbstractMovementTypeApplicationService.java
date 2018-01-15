package org.dddml.wms.domain.movementtype;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractMovementTypeApplicationService implements MovementTypeApplicationService
{
    private MovementTypeStateRepository stateRepository;

    protected MovementTypeStateRepository getStateRepository() {
        return stateRepository;
    }

    private MovementTypeStateQueryRepository stateQueryRepository;

    protected MovementTypeStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<MovementTypeAggregate, MovementTypeState> aggregateEventListener;

    public AggregateEventListener<MovementTypeAggregate, MovementTypeState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<MovementTypeAggregate, MovementTypeState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractMovementTypeApplicationService(MovementTypeStateRepository stateRepository, MovementTypeStateQueryRepository stateQueryRepository) {
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(MovementTypeCommand.CreateMovementType c) {
        update(c, ar -> ar.create(c));
    }

    public void when(MovementTypeCommand.MergePatchMovementType c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(MovementTypeCommand.DeleteMovementType c) {
        update(c, ar -> ar.delete(c));
    }

    public MovementTypeState get(String id) {
        MovementTypeState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<MovementTypeState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<MovementTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<MovementTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<MovementTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }


    public MovementTypeAggregate getMovementTypeAggregate(MovementTypeState state)
    {
        return new AbstractMovementTypeAggregate.SimpleMovementTypeAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(MovementTypeCommand c, Consumer<MovementTypeAggregate> action)
    {
        String aggregateId = c.getMovementTypeId();
        MovementTypeState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        MovementTypeAggregate aggregate = getMovementTypeAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, MovementTypeAggregate aggregate, MovementTypeState state) {
        getStateRepository().save(state);
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(MovementTypeStateEvent.MovementTypeStateCreated stateCreated) {
        String aggregateId = stateCreated.getStateEventId().getMovementTypeId();
        MovementTypeState state = new AbstractMovementTypeState.SimpleMovementTypeState();
        state.setMovementTypeId(aggregateId);

        MovementTypeAggregate aggregate = getMovementTypeAggregate(state);
        ((AbstractMovementTypeAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(MovementTypeCommand command, EventStoreAggregateId eventStoreAggregateId, MovementTypeState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(MovementTypeState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() == command.getVersion() + 1)
        {
            if (command.getCommandId() != null && command.getCommandId().equals(state.getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleMovementTypeApplicationService extends AbstractMovementTypeApplicationService 
    {
        public SimpleMovementTypeApplicationService(MovementTypeStateRepository stateRepository, MovementTypeStateQueryRepository stateQueryRepository)
        {
            super(stateRepository, stateQueryRepository);
        }
    }

}

