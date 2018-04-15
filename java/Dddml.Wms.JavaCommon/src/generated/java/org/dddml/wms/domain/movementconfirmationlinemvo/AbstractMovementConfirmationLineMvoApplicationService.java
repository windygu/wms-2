package org.dddml.wms.domain.movementconfirmationlinemvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.movementconfirmation.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractMovementConfirmationLineMvoApplicationService implements MovementConfirmationLineMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private MovementConfirmationLineMvoStateRepository stateRepository;

    protected MovementConfirmationLineMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private MovementConfirmationLineMvoStateQueryRepository stateQueryRepository;

    protected MovementConfirmationLineMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<MovementConfirmationLineMvoAggregate, MovementConfirmationLineMvoState> aggregateEventListener;

    public AggregateEventListener<MovementConfirmationLineMvoAggregate, MovementConfirmationLineMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<MovementConfirmationLineMvoAggregate, MovementConfirmationLineMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractMovementConfirmationLineMvoApplicationService(EventStore eventStore, MovementConfirmationLineMvoStateRepository stateRepository, MovementConfirmationLineMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(MovementConfirmationLineMvoCommand.CreateMovementConfirmationLineMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(MovementConfirmationLineMvoCommand.MergePatchMovementConfirmationLineMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(MovementConfirmationLineMvoCommand.DeleteMovementConfirmationLineMvo c) {
        update(c, ar -> ar.delete(c));
    }

    public MovementConfirmationLineMvoState get(MovementConfirmationLineId id) {
        MovementConfirmationLineMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<MovementConfirmationLineMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<MovementConfirmationLineMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<MovementConfirmationLineMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<MovementConfirmationLineMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public MovementConfirmationLineMvoEvent getEvent(MovementConfirmationLineId movementConfirmationLineId, long version) {
        MovementConfirmationLineMvoEvent e = (MovementConfirmationLineMvoEvent)getEventStore().getEvent(toEventStoreAggregateId(movementConfirmationLineId), version);
        if (e != null)
        { e.setEventReadOnly(true); }
        else if (version == -1)
        {
            return getEvent(movementConfirmationLineId, 0);
        }
        return e;
    }

    public MovementConfirmationLineMvoState getHistoryState(MovementConfirmationLineId movementConfirmationLineId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractMovementConfirmationLineMvoEvent.class, toEventStoreAggregateId(movementConfirmationLineId), version - 1);
        return new AbstractMovementConfirmationLineMvoState.SimpleMovementConfirmationLineMvoState(eventStream.getEvents());
    }


    public MovementConfirmationLineMvoAggregate getMovementConfirmationLineMvoAggregate(MovementConfirmationLineMvoState state)
    {
        return new AbstractMovementConfirmationLineMvoAggregate.SimpleMovementConfirmationLineMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(MovementConfirmationLineId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(MovementConfirmationLineMvoCommand c, Consumer<MovementConfirmationLineMvoAggregate> action)
    {
        MovementConfirmationLineId aggregateId = c.getMovementConfirmationLineId();
        MovementConfirmationLineMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        MovementConfirmationLineMvoAggregate aggregate = getMovementConfirmationLineMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getMovementConfirmationVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, MovementConfirmationLineMvoAggregate aggregate, MovementConfirmationLineMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(MovementConfirmationLineMvoEvent.MovementConfirmationLineMvoStateCreated stateCreated) {
        MovementConfirmationLineId aggregateId = stateCreated.getMovementConfirmationLineMvoEventId().getMovementConfirmationLineId();
        MovementConfirmationLineMvoState state = new AbstractMovementConfirmationLineMvoState.SimpleMovementConfirmationLineMvoState();
        state.setMovementConfirmationLineId(aggregateId);

        MovementConfirmationLineMvoAggregate aggregate = getMovementConfirmationLineMvoAggregate(state);
        ((AbstractMovementConfirmationLineMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getMovementConfirmationLineMvoEventId().getMovementConfirmationVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(MovementConfirmationLineMvoCommand command, EventStoreAggregateId eventStoreAggregateId, MovementConfirmationLineMvoState state)
    {
        boolean repeated = false;
        if (command.getMovementConfirmationVersion() == null) { command.setMovementConfirmationVersion(MovementConfirmationLineMvoState.VERSION_NULL); }
        if (state.getMovementConfirmationVersion() != null && state.getMovementConfirmationVersion() > command.getMovementConfirmationVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractMovementConfirmationLineMvoEvent.class, eventStoreAggregateId, command.getMovementConfirmationVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleMovementConfirmationLineMvoApplicationService extends AbstractMovementConfirmationLineMvoApplicationService 
    {
        public SimpleMovementConfirmationLineMvoApplicationService(EventStore eventStore, MovementConfirmationLineMvoStateRepository stateRepository, MovementConfirmationLineMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

