package org.dddml.wms.domain.pickwave;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPickwaveApplicationService implements PickwaveApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private PickwaveStateRepository stateRepository;

    protected PickwaveStateRepository getStateRepository() {
        return stateRepository;
    }

    private PickwaveStateQueryRepository stateQueryRepository;

    protected PickwaveStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<PickwaveAggregate, PickwaveState> aggregateEventListener;

    public AggregateEventListener<PickwaveAggregate, PickwaveState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<PickwaveAggregate, PickwaveState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractPickwaveApplicationService(EventStore eventStore, PickwaveStateRepository stateRepository, PickwaveStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(PickwaveCommand.CreatePickwave c) {
        update(c, ar -> ar.create(c));
    }

    public void when(PickwaveCommand.MergePatchPickwave c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(PickwaveCommand.DeletePickwave c) {
        update(c, ar -> ar.delete(c));
    }

    public PickwaveState get(Long id) {
        PickwaveState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<PickwaveState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<PickwaveState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<PickwaveState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<PickwaveState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public PickwaveEvent getEvent(Long pickwaveId, long version) {
        PickwaveEvent e = (PickwaveEvent)getEventStore().getEvent(toEventStoreAggregateId(pickwaveId), version);
        if (e != null) {
            ((PickwaveEvent.SqlPickwaveEvent)e).setEventReadOnly(true); 
        } else if (version == -1) {
            return getEvent(pickwaveId, 0);
        }
        return e;
    }

    public PickwaveState getHistoryState(Long pickwaveId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractPickwaveEvent.class, toEventStoreAggregateId(pickwaveId), version - 1);
        return new AbstractPickwaveState.SimplePickwaveState(eventStream.getEvents());
    }


    public PickwaveAggregate getPickwaveAggregate(PickwaveState state)
    {
        return new AbstractPickwaveAggregate.SimplePickwaveAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(Long aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(PickwaveCommand c, Consumer<PickwaveAggregate> action)
    {
        Long aggregateId = c.getPickwaveId();
        PickwaveState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        PickwaveAggregate aggregate = getPickwaveAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, PickwaveAggregate aggregate, PickwaveState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(PickwaveEvent.PickwaveStateCreated stateCreated) {
        Long aggregateId = ((PickwaveEvent.SqlPickwaveEvent)stateCreated).getPickwaveEventId().getPickwaveId();
        PickwaveState.SqlPickwaveState state = new AbstractPickwaveState.SimplePickwaveState();
        state.setPickwaveId(aggregateId);

        PickwaveAggregate aggregate = getPickwaveAggregate(state);
        ((AbstractPickwaveAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, ((PickwaveEvent.SqlPickwaveEvent)stateCreated).getPickwaveEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(PickwaveCommand command, EventStoreAggregateId eventStoreAggregateId, PickwaveState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(PickwaveState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractPickwaveEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimplePickwaveApplicationService extends AbstractPickwaveApplicationService 
    {
        public SimplePickwaveApplicationService(EventStore eventStore, PickwaveStateRepository stateRepository, PickwaveStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

