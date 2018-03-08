package org.dddml.wms.domain.movement;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractMovementApplicationService implements MovementApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private MovementStateRepository stateRepository;

    protected MovementStateRepository getStateRepository() {
        return stateRepository;
    }

    private MovementStateQueryRepository stateQueryRepository;

    protected MovementStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<MovementAggregate, MovementState> aggregateEventListener;

    public AggregateEventListener<MovementAggregate, MovementState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<MovementAggregate, MovementState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractMovementApplicationService(EventStore eventStore, MovementStateRepository stateRepository, MovementStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(MovementCommand.CreateMovement c) {
        update(c, ar -> ar.create(c));
    }

    public void when(MovementCommand.MergePatchMovement c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(MovementCommand.DeleteMovement c) {
        update(c, ar -> ar.delete(c));
    }

    public void when(MovementCommands.DocumentAction c) {
        update(c, ar -> ar.documentAction(c.getValue(), c.getVersion(), c.getCommandId(), c.getRequesterId()));
    }

    public MovementState get(String id) {
        MovementState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<MovementState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<MovementState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<MovementState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<MovementState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public MovementStateEvent getStateEvent(String documentNumber, long version) {
        MovementStateEvent e = (MovementStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(documentNumber), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(documentNumber, 0);
        }
        return e;
    }

    public MovementState getHistoryState(String documentNumber, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractMovementStateEvent.class, toEventStoreAggregateId(documentNumber), version - 1);
        return new AbstractMovementState.SimpleMovementState(eventStream.getEvents());
    }

    public MovementLineState getMovementLine(String movementDocumentNumber, String lineNumber) {
        return getStateQueryRepository().getMovementLine(movementDocumentNumber, lineNumber);
    }


    public MovementAggregate getMovementAggregate(MovementState state)
    {
        return new AbstractMovementAggregate.SimpleMovementAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(MovementCommand c, Consumer<MovementAggregate> action)
    {
        String aggregateId = c.getDocumentNumber();
        MovementState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        MovementAggregate aggregate = getMovementAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, MovementAggregate aggregate, MovementState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(MovementStateEvent.MovementStateCreated stateCreated) {
        String aggregateId = stateCreated.getMovementEventId().getDocumentNumber();
        MovementState state = new AbstractMovementState.SimpleMovementState();
        state.setDocumentNumber(aggregateId);

        MovementAggregate aggregate = getMovementAggregate(state);
        ((AbstractMovementAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getMovementEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(MovementCommand command, EventStoreAggregateId eventStoreAggregateId, MovementState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(MovementState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractMovementStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleMovementApplicationService extends AbstractMovementApplicationService 
    {
        public SimpleMovementApplicationService(EventStore eventStore, MovementStateRepository stateRepository, MovementStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

