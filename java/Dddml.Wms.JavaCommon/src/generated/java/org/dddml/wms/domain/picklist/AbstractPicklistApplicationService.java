package org.dddml.wms.domain.picklist;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPicklistApplicationService implements PicklistApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private PicklistStateRepository stateRepository;

    protected PicklistStateRepository getStateRepository() {
        return stateRepository;
    }

    private PicklistStateQueryRepository stateQueryRepository;

    protected PicklistStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<PicklistAggregate, PicklistState> aggregateEventListener;

    public AggregateEventListener<PicklistAggregate, PicklistState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<PicklistAggregate, PicklistState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractPicklistApplicationService(EventStore eventStore, PicklistStateRepository stateRepository, PicklistStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(PicklistCommand.CreatePicklist c) {
        update(c, ar -> ar.create(c));
    }

    public void when(PicklistCommand.MergePatchPicklist c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(PicklistCommand.DeletePicklist c) {
        update(c, ar -> ar.delete(c));
    }

    public PicklistState get(String id) {
        PicklistState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<PicklistState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<PicklistState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<PicklistState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<PicklistState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public PicklistEvent getEvent(String picklistId, long version) {
        PicklistEvent e = (PicklistEvent)getEventStore().getEvent(toEventStoreAggregateId(picklistId), version);
        if (e != null)
        { e.setEventReadOnly(true); }
        else if (version == -1)
        {
            return getEvent(picklistId, 0);
        }
        return e;
    }

    public PicklistState getHistoryState(String picklistId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractPicklistEvent.class, toEventStoreAggregateId(picklistId), version - 1);
        return new AbstractPicklistState.SimplePicklistState(eventStream.getEvents());
    }

    public PicklistRoleState getPicklistRole(String picklistId, PartyRoleId partyRoleId) {
        return getStateQueryRepository().getPicklistRole(picklistId, partyRoleId);
    }

    public Iterable<PicklistRoleState> getPicklistRoles(String picklistId, Criterion filter, List<String> orders) {
        return getStateQueryRepository().getPicklistRoles(picklistId, filter, orders);
    }


    public PicklistAggregate getPicklistAggregate(PicklistState state)
    {
        return new AbstractPicklistAggregate.SimplePicklistAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(PicklistCommand c, Consumer<PicklistAggregate> action)
    {
        String aggregateId = c.getPicklistId();
        PicklistState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        PicklistAggregate aggregate = getPicklistAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, PicklistAggregate aggregate, PicklistState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(PicklistEvent.PicklistStateCreated stateCreated) {
        String aggregateId = ((PicklistEvent.SqlPicklistEvent)stateCreated).getPicklistEventId().getPicklistId();
        PicklistState state = new AbstractPicklistState.SimplePicklistState();
        state.setPicklistId(aggregateId);

        PicklistAggregate aggregate = getPicklistAggregate(state);
        ((AbstractPicklistAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, ((PicklistEvent.SqlPicklistEvent)stateCreated).getPicklistEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(PicklistCommand command, EventStoreAggregateId eventStoreAggregateId, PicklistState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(PicklistState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractPicklistEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimplePicklistApplicationService extends AbstractPicklistApplicationService 
    {
        public SimplePicklistApplicationService(EventStore eventStore, PicklistStateRepository stateRepository, PicklistStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

