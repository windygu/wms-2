package org.dddml.wms.domain.picklistrolemvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.picklist.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPicklistRoleMvoApplicationService implements PicklistRoleMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private PicklistRoleMvoStateRepository stateRepository;

    protected PicklistRoleMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private PicklistRoleMvoStateQueryRepository stateQueryRepository;

    protected PicklistRoleMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<PicklistRoleMvoAggregate, PicklistRoleMvoState> aggregateEventListener;

    public AggregateEventListener<PicklistRoleMvoAggregate, PicklistRoleMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<PicklistRoleMvoAggregate, PicklistRoleMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractPicklistRoleMvoApplicationService(EventStore eventStore, PicklistRoleMvoStateRepository stateRepository, PicklistRoleMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(PicklistRoleMvoCommand.CreatePicklistRoleMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(PicklistRoleMvoCommand.MergePatchPicklistRoleMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(PicklistRoleMvoCommand.DeletePicklistRoleMvo c) {
        update(c, ar -> ar.delete(c));
    }

    public PicklistRoleMvoState get(PicklistRoleId id) {
        PicklistRoleMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<PicklistRoleMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<PicklistRoleMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<PicklistRoleMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<PicklistRoleMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public PicklistRoleMvoStateEvent getStateEvent(PicklistRoleId picklistRoleId, long version) {
        PicklistRoleMvoStateEvent e = (PicklistRoleMvoStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(picklistRoleId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(picklistRoleId, 0);
        }
        return e;
    }

    public PicklistRoleMvoState getHistoryState(PicklistRoleId picklistRoleId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractPicklistRoleMvoStateEvent.class, toEventStoreAggregateId(picklistRoleId), version - 1);
        return new AbstractPicklistRoleMvoState.SimplePicklistRoleMvoState(eventStream.getEvents());
    }


    public PicklistRoleMvoAggregate getPicklistRoleMvoAggregate(PicklistRoleMvoState state)
    {
        return new AbstractPicklistRoleMvoAggregate.SimplePicklistRoleMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(PicklistRoleId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(PicklistRoleMvoCommand c, Consumer<PicklistRoleMvoAggregate> action)
    {
        PicklistRoleId aggregateId = c.getPicklistRoleId();
        PicklistRoleMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        PicklistRoleMvoAggregate aggregate = getPicklistRoleMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getPicklistVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, PicklistRoleMvoAggregate aggregate, PicklistRoleMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(PicklistRoleMvoStateEvent.PicklistRoleMvoStateCreated stateCreated) {
        PicklistRoleId aggregateId = stateCreated.getPicklistRoleMvoEventId().getPicklistRoleId();
        PicklistRoleMvoState state = new AbstractPicklistRoleMvoState.SimplePicklistRoleMvoState();
        state.setPicklistRoleId(aggregateId);

        PicklistRoleMvoAggregate aggregate = getPicklistRoleMvoAggregate(state);
        ((AbstractPicklistRoleMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getPicklistRoleMvoEventId().getPicklistVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(PicklistRoleMvoCommand command, EventStoreAggregateId eventStoreAggregateId, PicklistRoleMvoState state)
    {
        boolean repeated = false;
        if (command.getPicklistVersion() == null) { command.setPicklistVersion(PicklistRoleMvoState.VERSION_NULL); }
        if (state.getPicklistVersion() != null && state.getPicklistVersion() > command.getPicklistVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractPicklistRoleMvoStateEvent.class, eventStoreAggregateId, command.getPicklistVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimplePicklistRoleMvoApplicationService extends AbstractPicklistRoleMvoApplicationService 
    {
        public SimplePicklistRoleMvoApplicationService(EventStore eventStore, PicklistRoleMvoStateRepository stateRepository, PicklistRoleMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

