package org.dddml.wms.domain.movementconfirmation;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractMovementConfirmationApplicationService implements MovementConfirmationApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private MovementConfirmationStateRepository stateRepository;

    protected MovementConfirmationStateRepository getStateRepository() {
        return stateRepository;
    }

    private MovementConfirmationStateQueryRepository stateQueryRepository;

    protected MovementConfirmationStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<MovementConfirmationAggregate, MovementConfirmationState> aggregateEventListener;

    public AggregateEventListener<MovementConfirmationAggregate, MovementConfirmationState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<MovementConfirmationAggregate, MovementConfirmationState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractMovementConfirmationApplicationService(EventStore eventStore, MovementConfirmationStateRepository stateRepository, MovementConfirmationStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(MovementConfirmationCommand.CreateMovementConfirmation c) {
        update(c, ar -> ar.create(c));
    }

    public void when(MovementConfirmationCommand.MergePatchMovementConfirmation c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(MovementConfirmationCommand.DeleteMovementConfirmation c) {
        update(c, ar -> ar.delete(c));
    }

    public void when(MovementConfirmationCommands.DocumentAction c) {
        update(c, ar -> ar.documentAction(c.getValue(), c.getVersion(), c.getCommandId(), c.getRequesterId(), c));
    }

    public MovementConfirmationState get(String id) {
        MovementConfirmationState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<MovementConfirmationState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<MovementConfirmationState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<MovementConfirmationState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<MovementConfirmationState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public MovementConfirmationEvent getEvent(String documentNumber, long version) {
        MovementConfirmationEvent e = (MovementConfirmationEvent)getEventStore().getEvent(toEventStoreAggregateId(documentNumber), version);
        if (e != null) {
            ((MovementConfirmationEvent.SqlMovementConfirmationEvent)e).setEventReadOnly(true); 
        } else if (version == -1) {
            return getEvent(documentNumber, 0);
        }
        return e;
    }

    public MovementConfirmationState getHistoryState(String documentNumber, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractMovementConfirmationEvent.class, toEventStoreAggregateId(documentNumber), version - 1);
        return new AbstractMovementConfirmationState.SimpleMovementConfirmationState(eventStream.getEvents());
    }

    public MovementConfirmationLineState getMovementConfirmationLine(String movementConfirmationDocumentNumber, String lineNumber) {
        return getStateQueryRepository().getMovementConfirmationLine(movementConfirmationDocumentNumber, lineNumber);
    }

    public Iterable<MovementConfirmationLineState> getMovementConfirmationLines(String movementConfirmationDocumentNumber, Criterion filter, List<String> orders) {
        return getStateQueryRepository().getMovementConfirmationLines(movementConfirmationDocumentNumber, filter, orders);
    }


    public MovementConfirmationAggregate getMovementConfirmationAggregate(MovementConfirmationState state)
    {
        return new AbstractMovementConfirmationAggregate.SimpleMovementConfirmationAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(MovementConfirmationCommand c, Consumer<MovementConfirmationAggregate> action)
    {
        String aggregateId = c.getDocumentNumber();
        MovementConfirmationState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        MovementConfirmationAggregate aggregate = getMovementConfirmationAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, MovementConfirmationAggregate aggregate, MovementConfirmationState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(MovementConfirmationEvent.MovementConfirmationStateCreated stateCreated) {
        String aggregateId = ((MovementConfirmationEvent.SqlMovementConfirmationEvent)stateCreated).getMovementConfirmationEventId().getDocumentNumber();
        MovementConfirmationState.SqlMovementConfirmationState state = new AbstractMovementConfirmationState.SimpleMovementConfirmationState();
        state.setDocumentNumber(aggregateId);

        MovementConfirmationAggregate aggregate = getMovementConfirmationAggregate(state);
        ((AbstractMovementConfirmationAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, ((MovementConfirmationEvent.SqlMovementConfirmationEvent)stateCreated).getMovementConfirmationEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(MovementConfirmationCommand command, EventStoreAggregateId eventStoreAggregateId, MovementConfirmationState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(MovementConfirmationState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractMovementConfirmationEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleMovementConfirmationApplicationService extends AbstractMovementConfirmationApplicationService 
    {
        public SimpleMovementConfirmationApplicationService(EventStore eventStore, MovementConfirmationStateRepository stateRepository, MovementConfirmationStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

