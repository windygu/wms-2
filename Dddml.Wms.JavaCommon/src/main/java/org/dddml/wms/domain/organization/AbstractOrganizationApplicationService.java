package org.dddml.wms.domain.organization;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrganizationApplicationService implements OrganizationApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private OrganizationStateRepository stateRepository;

    protected OrganizationStateRepository getStateRepository() {
        return stateRepository;
    }

    private OrganizationStateQueryRepository stateQueryRepository;

    protected OrganizationStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<OrganizationAggregate, OrganizationState> aggregateEventListener;

    public AggregateEventListener<OrganizationAggregate, OrganizationState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<OrganizationAggregate, OrganizationState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractOrganizationApplicationService(EventStore eventStore, OrganizationStateRepository stateRepository, OrganizationStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(OrganizationCommand.CreateOrganization c) {
        update(c, ar -> ar.create(c));
    }

    public void when(OrganizationCommand.MergePatchOrganization c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(OrganizationCommand.DeleteOrganization c) {
        update(c, ar -> ar.delete(c));
    }

    public OrganizationState get(String id) {
        OrganizationState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<OrganizationState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<OrganizationState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<OrganizationState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<OrganizationState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public OrganizationStateEvent getStateEvent(String partyId, long version) {
        OrganizationStateEvent e = (OrganizationStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(partyId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(partyId, 0);
        }
        return e;
    }

    public OrganizationState getHistoryState(String partyId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractOrganizationStateEvent.class, toEventStoreAggregateId(partyId), version - 1);
        return new AbstractOrganizationState.SimpleOrganizationState(eventStream.getEvents());
    }


    public OrganizationAggregate getOrganizationAggregate(OrganizationState state)
    {
        return new AbstractOrganizationAggregate.SimpleOrganizationAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(OrganizationCommand c, Consumer<OrganizationAggregate> action)
    {
        String aggregateId = c.getPartyId();
        OrganizationState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        OrganizationAggregate aggregate = getOrganizationAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, OrganizationAggregate aggregate, OrganizationState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(OrganizationStateEvent.OrganizationStateCreated stateCreated) {
        String aggregateId = stateCreated.getStateEventId().getPartyId();
        OrganizationState state = new AbstractOrganizationState.SimpleOrganizationState();
        state.setPartyId(aggregateId);

        OrganizationAggregate aggregate = getOrganizationAggregate(state);
        ((AbstractOrganizationAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(OrganizationCommand command, EventStoreAggregateId eventStoreAggregateId, OrganizationState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(OrganizationState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractOrganizationStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleOrganizationApplicationService extends AbstractOrganizationApplicationService 
    {
        public SimpleOrganizationApplicationService(EventStore eventStore, OrganizationStateRepository stateRepository, OrganizationStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

