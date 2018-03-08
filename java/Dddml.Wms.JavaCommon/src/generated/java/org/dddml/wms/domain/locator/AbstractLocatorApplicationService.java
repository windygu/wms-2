package org.dddml.wms.domain.locator;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractLocatorApplicationService implements LocatorApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private LocatorStateRepository stateRepository;

    protected LocatorStateRepository getStateRepository() {
        return stateRepository;
    }

    private LocatorStateQueryRepository stateQueryRepository;

    protected LocatorStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<LocatorAggregate, LocatorState> aggregateEventListener;

    public AggregateEventListener<LocatorAggregate, LocatorState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<LocatorAggregate, LocatorState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractLocatorApplicationService(EventStore eventStore, LocatorStateRepository stateRepository, LocatorStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(LocatorCommand.CreateLocator c) {
        update(c, ar -> ar.create(c));
    }

    public void when(LocatorCommand.MergePatchLocator c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(LocatorCommand.DeleteLocator c) {
        update(c, ar -> ar.delete(c));
    }

    public LocatorState get(String id) {
        LocatorState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<LocatorState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<LocatorState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<LocatorState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<LocatorState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public LocatorStateEvent getStateEvent(String locatorId, long version) {
        LocatorStateEvent e = (LocatorStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(locatorId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(locatorId, 0);
        }
        return e;
    }

    public LocatorState getHistoryState(String locatorId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractLocatorStateEvent.class, toEventStoreAggregateId(locatorId), version - 1);
        return new AbstractLocatorState.SimpleLocatorState(eventStream.getEvents());
    }


    public LocatorAggregate getLocatorAggregate(LocatorState state)
    {
        return new AbstractLocatorAggregate.SimpleLocatorAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(LocatorCommand c, Consumer<LocatorAggregate> action)
    {
        String aggregateId = c.getLocatorId();
        LocatorState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        LocatorAggregate aggregate = getLocatorAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, LocatorAggregate aggregate, LocatorState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(LocatorStateEvent.LocatorStateCreated stateCreated) {
        String aggregateId = stateCreated.getLocatorEventId().getLocatorId();
        LocatorState state = new AbstractLocatorState.SimpleLocatorState();
        state.setLocatorId(aggregateId);

        LocatorAggregate aggregate = getLocatorAggregate(state);
        ((AbstractLocatorAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getLocatorEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(LocatorCommand command, EventStoreAggregateId eventStoreAggregateId, LocatorState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(LocatorState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractLocatorStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleLocatorApplicationService extends AbstractLocatorApplicationService 
    {
        public SimpleLocatorApplicationService(EventStore eventStore, LocatorStateRepository stateRepository, LocatorStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

