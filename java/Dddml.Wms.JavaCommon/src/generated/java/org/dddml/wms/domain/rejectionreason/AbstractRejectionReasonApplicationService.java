package org.dddml.wms.domain.rejectionreason;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractRejectionReasonApplicationService implements RejectionReasonApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private RejectionReasonStateRepository stateRepository;

    protected RejectionReasonStateRepository getStateRepository() {
        return stateRepository;
    }

    private RejectionReasonStateQueryRepository stateQueryRepository;

    protected RejectionReasonStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<RejectionReasonAggregate, RejectionReasonState> aggregateEventListener;

    public AggregateEventListener<RejectionReasonAggregate, RejectionReasonState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<RejectionReasonAggregate, RejectionReasonState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractRejectionReasonApplicationService(EventStore eventStore, RejectionReasonStateRepository stateRepository, RejectionReasonStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(RejectionReasonCommand.CreateRejectionReason c) {
        update(c, ar -> ar.create(c));
    }

    public void when(RejectionReasonCommand.MergePatchRejectionReason c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(RejectionReasonCommand.DeleteRejectionReason c) {
        update(c, ar -> ar.delete(c));
    }

    public RejectionReasonState get(String id) {
        RejectionReasonState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<RejectionReasonState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<RejectionReasonState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<RejectionReasonState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<RejectionReasonState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public RejectionReasonEvent getEvent(String rejectionReasonId, long version) {
        RejectionReasonEvent e = (RejectionReasonEvent)getEventStore().getEvent(toEventStoreAggregateId(rejectionReasonId), version);
        if (e != null) {
            ((RejectionReasonEvent.SqlRejectionReasonEvent)e).setEventReadOnly(true); 
        } else if (version == -1) {
            return getEvent(rejectionReasonId, 0);
        }
        return e;
    }

    public RejectionReasonState getHistoryState(String rejectionReasonId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractRejectionReasonEvent.class, toEventStoreAggregateId(rejectionReasonId), version - 1);
        return new AbstractRejectionReasonState.SimpleRejectionReasonState(eventStream.getEvents());
    }


    public RejectionReasonAggregate getRejectionReasonAggregate(RejectionReasonState state)
    {
        return new AbstractRejectionReasonAggregate.SimpleRejectionReasonAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(RejectionReasonCommand c, Consumer<RejectionReasonAggregate> action)
    {
        String aggregateId = c.getRejectionReasonId();
        RejectionReasonState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        RejectionReasonAggregate aggregate = getRejectionReasonAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, RejectionReasonAggregate aggregate, RejectionReasonState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(RejectionReasonEvent.RejectionReasonStateCreated stateCreated) {
        String aggregateId = ((RejectionReasonEvent.SqlRejectionReasonEvent)stateCreated).getRejectionReasonEventId().getRejectionReasonId();
        RejectionReasonState state = new AbstractRejectionReasonState.SimpleRejectionReasonState();
        state.setRejectionReasonId(aggregateId);

        RejectionReasonAggregate aggregate = getRejectionReasonAggregate(state);
        ((AbstractRejectionReasonAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, ((RejectionReasonEvent.SqlRejectionReasonEvent)stateCreated).getRejectionReasonEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(RejectionReasonCommand command, EventStoreAggregateId eventStoreAggregateId, RejectionReasonState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(RejectionReasonState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractRejectionReasonEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleRejectionReasonApplicationService extends AbstractRejectionReasonApplicationService 
    {
        public SimpleRejectionReasonApplicationService(EventStore eventStore, RejectionReasonStateRepository stateRepository, RejectionReasonStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

