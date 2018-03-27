package org.dddml.wms.domain.picklistitemmvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.picklistbin.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPicklistItemMvoApplicationService implements PicklistItemMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private PicklistItemMvoStateRepository stateRepository;

    protected PicklistItemMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private PicklistItemMvoStateQueryRepository stateQueryRepository;

    protected PicklistItemMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<PicklistItemMvoAggregate, PicklistItemMvoState> aggregateEventListener;

    public AggregateEventListener<PicklistItemMvoAggregate, PicklistItemMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<PicklistItemMvoAggregate, PicklistItemMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractPicklistItemMvoApplicationService(EventStore eventStore, PicklistItemMvoStateRepository stateRepository, PicklistItemMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(PicklistItemMvoCommand.CreatePicklistItemMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(PicklistItemMvoCommand.MergePatchPicklistItemMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(PicklistItemMvoCommand.DeletePicklistItemMvo c) {
        update(c, ar -> ar.delete(c));
    }

    public PicklistItemMvoState get(PicklistBinPicklistItemId id) {
        PicklistItemMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<PicklistItemMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<PicklistItemMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<PicklistItemMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<PicklistItemMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public PicklistItemMvoStateEvent getStateEvent(PicklistBinPicklistItemId picklistBinPicklistItemId, long version) {
        PicklistItemMvoStateEvent e = (PicklistItemMvoStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(picklistBinPicklistItemId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(picklistBinPicklistItemId, 0);
        }
        return e;
    }

    public PicklistItemMvoState getHistoryState(PicklistBinPicklistItemId picklistBinPicklistItemId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractPicklistItemMvoStateEvent.class, toEventStoreAggregateId(picklistBinPicklistItemId), version - 1);
        return new AbstractPicklistItemMvoState.SimplePicklistItemMvoState(eventStream.getEvents());
    }


    public PicklistItemMvoAggregate getPicklistItemMvoAggregate(PicklistItemMvoState state)
    {
        return new AbstractPicklistItemMvoAggregate.SimplePicklistItemMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(PicklistBinPicklistItemId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(PicklistItemMvoCommand c, Consumer<PicklistItemMvoAggregate> action)
    {
        PicklistBinPicklistItemId aggregateId = c.getPicklistBinPicklistItemId();
        PicklistItemMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        PicklistItemMvoAggregate aggregate = getPicklistItemMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getPicklistBinVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, PicklistItemMvoAggregate aggregate, PicklistItemMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(PicklistItemMvoStateEvent.PicklistItemMvoStateCreated stateCreated) {
        PicklistBinPicklistItemId aggregateId = stateCreated.getPicklistItemMvoEventId().getPicklistBinPicklistItemId();
        PicklistItemMvoState state = new AbstractPicklistItemMvoState.SimplePicklistItemMvoState();
        state.setPicklistBinPicklistItemId(aggregateId);

        PicklistItemMvoAggregate aggregate = getPicklistItemMvoAggregate(state);
        ((AbstractPicklistItemMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getPicklistItemMvoEventId().getPicklistBinVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(PicklistItemMvoCommand command, EventStoreAggregateId eventStoreAggregateId, PicklistItemMvoState state)
    {
        boolean repeated = false;
        if (command.getPicklistBinVersion() == null) { command.setPicklistBinVersion(PicklistItemMvoState.VERSION_NULL); }
        if (state.getPicklistBinVersion() != null && state.getPicklistBinVersion() > command.getPicklistBinVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractPicklistItemMvoStateEvent.class, eventStoreAggregateId, command.getPicklistBinVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimplePicklistItemMvoApplicationService extends AbstractPicklistItemMvoApplicationService 
    {
        public SimplePicklistItemMvoApplicationService(EventStore eventStore, PicklistItemMvoStateRepository stateRepository, PicklistItemMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

