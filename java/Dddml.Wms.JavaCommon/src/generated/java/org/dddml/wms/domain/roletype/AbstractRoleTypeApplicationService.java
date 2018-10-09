package org.dddml.wms.domain.roletype;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractRoleTypeApplicationService implements RoleTypeApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private RoleTypeStateRepository stateRepository;

    protected RoleTypeStateRepository getStateRepository() {
        return stateRepository;
    }

    private RoleTypeStateQueryRepository stateQueryRepository;

    protected RoleTypeStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<RoleTypeAggregate, RoleTypeState> aggregateEventListener;

    public AggregateEventListener<RoleTypeAggregate, RoleTypeState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<RoleTypeAggregate, RoleTypeState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractRoleTypeApplicationService(EventStore eventStore, RoleTypeStateRepository stateRepository, RoleTypeStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(RoleTypeCommand.CreateRoleType c) {
        update(c, ar -> ar.create(c));
    }

    public void when(RoleTypeCommand.MergePatchRoleType c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(RoleTypeCommand.DeleteRoleType c) {
        update(c, ar -> ar.delete(c));
    }

    public RoleTypeState get(String id) {
        RoleTypeState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<RoleTypeState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<RoleTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<RoleTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<RoleTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public RoleTypeEvent getEvent(String roleTypeId, long version) {
        RoleTypeEvent e = (RoleTypeEvent)getEventStore().getEvent(toEventStoreAggregateId(roleTypeId), version);
        if (e != null) {
            ((RoleTypeEvent.SqlRoleTypeEvent)e).setEventReadOnly(true); 
        } else if (version == -1) {
            return getEvent(roleTypeId, 0);
        }
        return e;
    }

    public RoleTypeState getHistoryState(String roleTypeId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractRoleTypeEvent.class, toEventStoreAggregateId(roleTypeId), version - 1);
        return new AbstractRoleTypeState.SimpleRoleTypeState(eventStream.getEvents());
    }


    public RoleTypeAggregate getRoleTypeAggregate(RoleTypeState state)
    {
        return new AbstractRoleTypeAggregate.SimpleRoleTypeAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(RoleTypeCommand c, Consumer<RoleTypeAggregate> action)
    {
        String aggregateId = c.getRoleTypeId();
        RoleTypeState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        RoleTypeAggregate aggregate = getRoleTypeAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, RoleTypeAggregate aggregate, RoleTypeState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(RoleTypeEvent.RoleTypeStateCreated stateCreated) {
        String aggregateId = ((RoleTypeEvent.SqlRoleTypeEvent)stateCreated).getRoleTypeEventId().getRoleTypeId();
        RoleTypeState.SqlRoleTypeState state = new AbstractRoleTypeState.SimpleRoleTypeState();
        state.setRoleTypeId(aggregateId);

        RoleTypeAggregate aggregate = getRoleTypeAggregate(state);
        ((AbstractRoleTypeAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, ((RoleTypeEvent.SqlRoleTypeEvent)stateCreated).getRoleTypeEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(RoleTypeCommand command, EventStoreAggregateId eventStoreAggregateId, RoleTypeState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(RoleTypeState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractRoleTypeEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleRoleTypeApplicationService extends AbstractRoleTypeApplicationService 
    {
        public SimpleRoleTypeApplicationService(EventStore eventStore, RoleTypeStateRepository stateRepository, RoleTypeStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

