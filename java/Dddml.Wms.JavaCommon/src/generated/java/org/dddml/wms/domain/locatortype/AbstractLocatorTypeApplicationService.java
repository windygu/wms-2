package org.dddml.wms.domain.locatortype;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractLocatorTypeApplicationService implements LocatorTypeApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private LocatorTypeStateRepository stateRepository;

    protected LocatorTypeStateRepository getStateRepository() {
        return stateRepository;
    }

    private LocatorTypeStateQueryRepository stateQueryRepository;

    protected LocatorTypeStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<LocatorTypeAggregate, LocatorTypeState> aggregateEventListener;

    public AggregateEventListener<LocatorTypeAggregate, LocatorTypeState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<LocatorTypeAggregate, LocatorTypeState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractLocatorTypeApplicationService(EventStore eventStore, LocatorTypeStateRepository stateRepository, LocatorTypeStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(LocatorTypeCommand.CreateLocatorType c) {
        update(c, ar -> ar.create(c));
    }

    public void when(LocatorTypeCommand.MergePatchLocatorType c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(LocatorTypeCommand.DeleteLocatorType c) {
        update(c, ar -> ar.delete(c));
    }

    public LocatorTypeState get(String id) {
        LocatorTypeState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<LocatorTypeState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<LocatorTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<LocatorTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<LocatorTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public LocatorTypeStateEvent getStateEvent(String locatorTypeId, long version) {
        LocatorTypeStateEvent e = (LocatorTypeStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(locatorTypeId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(locatorTypeId, 0);
        }
        return e;
    }

    public LocatorTypeState getHistoryState(String locatorTypeId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractLocatorTypeStateEvent.class, toEventStoreAggregateId(locatorTypeId), version - 1);
        return new AbstractLocatorTypeState.SimpleLocatorTypeState(eventStream.getEvents());
    }


    public LocatorTypeAggregate getLocatorTypeAggregate(LocatorTypeState state)
    {
        return new AbstractLocatorTypeAggregate.SimpleLocatorTypeAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(LocatorTypeCommand c, Consumer<LocatorTypeAggregate> action)
    {
        String aggregateId = c.getLocatorTypeId();
        LocatorTypeState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        LocatorTypeAggregate aggregate = getLocatorTypeAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, LocatorTypeAggregate aggregate, LocatorTypeState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(LocatorTypeStateEvent.LocatorTypeStateCreated stateCreated) {
        String aggregateId = stateCreated.getLocatorTypeEventId().getLocatorTypeId();
        LocatorTypeState state = new AbstractLocatorTypeState.SimpleLocatorTypeState();
        state.setLocatorTypeId(aggregateId);

        LocatorTypeAggregate aggregate = getLocatorTypeAggregate(state);
        ((AbstractLocatorTypeAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getLocatorTypeEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(LocatorTypeCommand command, EventStoreAggregateId eventStoreAggregateId, LocatorTypeState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(LocatorTypeState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractLocatorTypeStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleLocatorTypeApplicationService extends AbstractLocatorTypeApplicationService 
    {
        public SimpleLocatorTypeApplicationService(EventStore eventStore, LocatorTypeStateRepository stateRepository, LocatorTypeStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

