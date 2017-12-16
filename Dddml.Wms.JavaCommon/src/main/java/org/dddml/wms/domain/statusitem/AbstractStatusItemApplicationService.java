package org.dddml.wms.domain.statusitem;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractStatusItemApplicationService implements StatusItemApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private StatusItemStateRepository stateRepository;

    protected StatusItemStateRepository getStateRepository() {
        return stateRepository;
    }

    private StatusItemStateQueryRepository stateQueryRepository;

    protected StatusItemStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<StatusItemAggregate, StatusItemState> aggregateEventListener;

    public AggregateEventListener<StatusItemAggregate, StatusItemState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<StatusItemAggregate, StatusItemState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractStatusItemApplicationService(EventStore eventStore, StatusItemStateRepository stateRepository, StatusItemStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(StatusItemCommand.CreateStatusItem c) {
        update(c, ar -> ar.create(c));
    }

    public void when(StatusItemCommand.MergePatchStatusItem c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public StatusItemState get(String id) {
        StatusItemState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<StatusItemState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<StatusItemState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<StatusItemState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<StatusItemState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public StatusItemStateEvent getStateEvent(String statusId, long version) {
        StatusItemStateEvent e = (StatusItemStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(statusId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(statusId, 0);
        }
        return e;
    }

    public StatusItemState getHistoryState(String statusId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractStatusItemStateEvent.class, toEventStoreAggregateId(statusId), version - 1);
        return new AbstractStatusItemState.SimpleStatusItemState(eventStream.getEvents());
    }


    public StatusItemAggregate getStatusItemAggregate(StatusItemState state)
    {
        return new AbstractStatusItemAggregate.SimpleStatusItemAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(StatusItemCommand c, Consumer<StatusItemAggregate> action)
    {
        String aggregateId = c.getStatusId();
        StatusItemState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        StatusItemAggregate aggregate = getStatusItemAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, StatusItemAggregate aggregate, StatusItemState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(StatusItemStateEvent.StatusItemStateCreated stateCreated) {
        String aggregateId = stateCreated.getStateEventId().getStatusId();
        StatusItemState state = new AbstractStatusItemState.SimpleStatusItemState();
        state.setStatusId(aggregateId);

        StatusItemAggregate aggregate = getStatusItemAggregate(state);
        ((AbstractStatusItemAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(StatusItemCommand command, EventStoreAggregateId eventStoreAggregateId, StatusItemState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(StatusItemState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractStatusItemStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleStatusItemApplicationService extends AbstractStatusItemApplicationService 
    {
        public SimpleStatusItemApplicationService(EventStore eventStore, StatusItemStateRepository stateRepository, StatusItemStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

