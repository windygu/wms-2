package org.dddml.wms.domain.movementlinemvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractMovementLineMvoApplicationService implements MovementLineMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private MovementLineMvoStateRepository stateRepository;

    protected MovementLineMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private MovementLineMvoStateQueryRepository stateQueryRepository;

    protected MovementLineMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<MovementLineMvoAggregate, MovementLineMvoState> aggregateEventListener;

    public AggregateEventListener<MovementLineMvoAggregate, MovementLineMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<MovementLineMvoAggregate, MovementLineMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractMovementLineMvoApplicationService(EventStore eventStore, MovementLineMvoStateRepository stateRepository, MovementLineMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(MovementLineMvoCommand.CreateMovementLineMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(MovementLineMvoCommand.MergePatchMovementLineMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(MovementLineMvoCommand.DeleteMovementLineMvo c) {
        update(c, ar -> ar.delete(c));
    }

    public MovementLineMvoState get(MovementLineId id) {
        MovementLineMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<MovementLineMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<MovementLineMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<MovementLineMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<MovementLineMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public MovementLineMvoStateEvent getStateEvent(MovementLineId movementLineId, long version) {
        MovementLineMvoStateEvent e = (MovementLineMvoStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(movementLineId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(movementLineId, 0);
        }
        return e;
    }

    public MovementLineMvoState getHistoryState(MovementLineId movementLineId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractMovementLineMvoStateEvent.class, toEventStoreAggregateId(movementLineId), version - 1);
        return new AbstractMovementLineMvoState.SimpleMovementLineMvoState(eventStream.getEvents());
    }


    public MovementLineMvoAggregate getMovementLineMvoAggregate(MovementLineMvoState state)
    {
        return new AbstractMovementLineMvoAggregate.SimpleMovementLineMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(MovementLineId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(MovementLineMvoCommand c, Consumer<MovementLineMvoAggregate> action)
    {
        MovementLineId aggregateId = c.getMovementLineId();
        MovementLineMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        MovementLineMvoAggregate aggregate = getMovementLineMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getMovementVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, MovementLineMvoAggregate aggregate, MovementLineMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(MovementLineMvoStateEvent.MovementLineMvoStateCreated stateCreated) {
        MovementLineId aggregateId = stateCreated.getStateEventId().getMovementLineId();
        MovementLineMvoState state = new AbstractMovementLineMvoState.SimpleMovementLineMvoState();
        state.setMovementLineId(aggregateId);

        MovementLineMvoAggregate aggregate = getMovementLineMvoAggregate(state);
        ((AbstractMovementLineMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getMovementVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(MovementLineMvoCommand command, EventStoreAggregateId eventStoreAggregateId, MovementLineMvoState state)
    {
        boolean repeated = false;
        if (command.getMovementVersion() == null) { command.setMovementVersion(MovementLineMvoState.VERSION_NULL); }
        if (state.getMovementVersion() != null && state.getMovementVersion() > command.getMovementVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractMovementLineMvoStateEvent.class, eventStoreAggregateId, command.getMovementVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleMovementLineMvoApplicationService extends AbstractMovementLineMvoApplicationService 
    {
        public SimpleMovementLineMvoApplicationService(EventStore eventStore, MovementLineMvoStateRepository stateRepository, MovementLineMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

