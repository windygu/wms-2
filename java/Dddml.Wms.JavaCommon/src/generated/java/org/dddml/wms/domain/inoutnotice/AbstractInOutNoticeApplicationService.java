package org.dddml.wms.domain.inoutnotice;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInOutNoticeApplicationService implements InOutNoticeApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private InOutNoticeStateRepository stateRepository;

    protected InOutNoticeStateRepository getStateRepository() {
        return stateRepository;
    }

    private InOutNoticeStateQueryRepository stateQueryRepository;

    protected InOutNoticeStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<InOutNoticeAggregate, InOutNoticeState> aggregateEventListener;

    public AggregateEventListener<InOutNoticeAggregate, InOutNoticeState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<InOutNoticeAggregate, InOutNoticeState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractInOutNoticeApplicationService(EventStore eventStore, InOutNoticeStateRepository stateRepository, InOutNoticeStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(InOutNoticeCommand.CreateInOutNotice c) {
        update(c, ar -> ar.create(c));
    }

    public void when(InOutNoticeCommand.MergePatchInOutNotice c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(InOutNoticeCommand.DeleteInOutNotice c) {
        update(c, ar -> ar.delete(c));
    }

    public void when(InOutNoticeCommands.InOutNoticeAction c) {
        update(c, ar -> ar.inOutNoticeAction(c.getValue(), c.getVersion(), c.getCommandId(), c.getRequesterId()));
    }

    public InOutNoticeState get(String id) {
        InOutNoticeState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<InOutNoticeState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<InOutNoticeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<InOutNoticeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<InOutNoticeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public InOutNoticeEvent getEvent(String inOutNoticeId, long version) {
        InOutNoticeEvent e = (InOutNoticeEvent)getEventStore().getEvent(toEventStoreAggregateId(inOutNoticeId), version);
        if (e != null)
        { e.setEventReadOnly(true); }
        else if (version == -1)
        {
            return getEvent(inOutNoticeId, 0);
        }
        return e;
    }

    public InOutNoticeState getHistoryState(String inOutNoticeId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractInOutNoticeEvent.class, toEventStoreAggregateId(inOutNoticeId), version - 1);
        return new AbstractInOutNoticeState.SimpleInOutNoticeState(eventStream.getEvents());
    }


    public InOutNoticeAggregate getInOutNoticeAggregate(InOutNoticeState state)
    {
        return new AbstractInOutNoticeAggregate.SimpleInOutNoticeAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(InOutNoticeCommand c, Consumer<InOutNoticeAggregate> action)
    {
        String aggregateId = c.getInOutNoticeId();
        InOutNoticeState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        InOutNoticeAggregate aggregate = getInOutNoticeAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, InOutNoticeAggregate aggregate, InOutNoticeState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(InOutNoticeEvent.InOutNoticeStateCreated stateCreated) {
        String aggregateId = ((InOutNoticeEvent.SqlInOutNoticeEvent)stateCreated).getInOutNoticeEventId().getInOutNoticeId();
        InOutNoticeState state = new AbstractInOutNoticeState.SimpleInOutNoticeState();
        state.setInOutNoticeId(aggregateId);

        InOutNoticeAggregate aggregate = getInOutNoticeAggregate(state);
        ((AbstractInOutNoticeAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, ((InOutNoticeEvent.SqlInOutNoticeEvent)stateCreated).getInOutNoticeEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(InOutNoticeCommand command, EventStoreAggregateId eventStoreAggregateId, InOutNoticeState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(InOutNoticeState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractInOutNoticeEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleInOutNoticeApplicationService extends AbstractInOutNoticeApplicationService 
    {
        public SimpleInOutNoticeApplicationService(EventStore eventStore, InOutNoticeStateRepository stateRepository, InOutNoticeStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

