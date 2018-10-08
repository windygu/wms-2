package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPicklistBinApplicationService implements PicklistBinApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private PicklistBinStateRepository stateRepository;

    protected PicklistBinStateRepository getStateRepository() {
        return stateRepository;
    }

    private PicklistBinStateQueryRepository stateQueryRepository;

    protected PicklistBinStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<PicklistBinAggregate, PicklistBinState> aggregateEventListener;

    public AggregateEventListener<PicklistBinAggregate, PicklistBinState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<PicklistBinAggregate, PicklistBinState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractPicklistBinApplicationService(EventStore eventStore, PicklistBinStateRepository stateRepository, PicklistBinStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(PicklistBinCommand.CreatePicklistBin c) {
        update(c, ar -> ar.create(c));
    }

    public void when(PicklistBinCommand.MergePatchPicklistBin c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(PicklistBinCommand.DeletePicklistBin c) {
        update(c, ar -> ar.delete(c));
    }

    public PicklistBinState get(String id) {
        PicklistBinState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<PicklistBinState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<PicklistBinState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<PicklistBinState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<PicklistBinState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public PicklistBinEvent getEvent(String picklistBinId, long version) {
        PicklistBinEvent e = (PicklistBinEvent)getEventStore().getEvent(toEventStoreAggregateId(picklistBinId), version);
        if (e != null)
        { e.setEventReadOnly(true); }
        else if (version == -1)
        {
            return getEvent(picklistBinId, 0);
        }
        return e;
    }

    public PicklistBinState getHistoryState(String picklistBinId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractPicklistBinEvent.class, toEventStoreAggregateId(picklistBinId), version - 1);
        return new AbstractPicklistBinState.SimplePicklistBinState(eventStream.getEvents());
    }

    public PicklistItemState getPicklistItem(String picklistBinId, PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId) {
        return getStateQueryRepository().getPicklistItem(picklistBinId, picklistItemOrderShipGrpInvId);
    }

    public Iterable<PicklistItemState> getPicklistItems(String picklistBinId, Criterion filter, List<String> orders) {
        return getStateQueryRepository().getPicklistItems(picklistBinId, filter, orders);
    }


    public PicklistBinAggregate getPicklistBinAggregate(PicklistBinState state)
    {
        return new AbstractPicklistBinAggregate.SimplePicklistBinAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(PicklistBinCommand c, Consumer<PicklistBinAggregate> action)
    {
        String aggregateId = c.getPicklistBinId();
        PicklistBinState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        PicklistBinAggregate aggregate = getPicklistBinAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, PicklistBinAggregate aggregate, PicklistBinState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(PicklistBinEvent.PicklistBinStateCreated stateCreated) {
        String aggregateId = ((PicklistBinEvent.SqlPicklistBinEvent)stateCreated).getPicklistBinEventId().getPicklistBinId();
        PicklistBinState state = new AbstractPicklistBinState.SimplePicklistBinState();
        state.setPicklistBinId(aggregateId);

        PicklistBinAggregate aggregate = getPicklistBinAggregate(state);
        ((AbstractPicklistBinAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, ((PicklistBinEvent.SqlPicklistBinEvent)stateCreated).getPicklistBinEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(PicklistBinCommand command, EventStoreAggregateId eventStoreAggregateId, PicklistBinState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(PicklistBinState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractPicklistBinEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimplePicklistBinApplicationService extends AbstractPicklistBinApplicationService 
    {
        public SimplePicklistBinApplicationService(EventStore eventStore, PicklistBinStateRepository stateRepository, PicklistBinStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

