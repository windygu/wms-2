package org.dddml.wms.domain.organizationstructure;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrganizationStructureApplicationService implements OrganizationStructureApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private OrganizationStructureStateRepository stateRepository;

    protected OrganizationStructureStateRepository getStateRepository() {
        return stateRepository;
    }

    private OrganizationStructureStateQueryRepository stateQueryRepository;

    protected OrganizationStructureStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<OrganizationStructureAggregate, OrganizationStructureState> aggregateEventListener;

    public AggregateEventListener<OrganizationStructureAggregate, OrganizationStructureState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<OrganizationStructureAggregate, OrganizationStructureState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractOrganizationStructureApplicationService(EventStore eventStore, OrganizationStructureStateRepository stateRepository, OrganizationStructureStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(OrganizationStructureCommand.CreateOrganizationStructure c) {
        update(c, ar -> ar.create(c));
    }

    public void when(OrganizationStructureCommand.MergePatchOrganizationStructure c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(OrganizationStructureCommand.DeleteOrganizationStructure c) {
        update(c, ar -> ar.delete(c));
    }

    public OrganizationStructureState get(OrganizationStructureId id) {
        OrganizationStructureState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<OrganizationStructureState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<OrganizationStructureState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<OrganizationStructureState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<OrganizationStructureState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public OrganizationStructureEvent getEvent(OrganizationStructureId id, long version) {
        OrganizationStructureEvent e = (OrganizationStructureEvent)getEventStore().getEvent(toEventStoreAggregateId(id), version);
        if (e != null)
        { e.setEventReadOnly(true); }
        else if (version == -1)
        {
            return getEvent(id, 0);
        }
        return e;
    }

    public OrganizationStructureState getHistoryState(OrganizationStructureId id, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractOrganizationStructureEvent.class, toEventStoreAggregateId(id), version - 1);
        return new AbstractOrganizationStructureState.SimpleOrganizationStructureState(eventStream.getEvents());
    }


    public OrganizationStructureAggregate getOrganizationStructureAggregate(OrganizationStructureState state)
    {
        return new AbstractOrganizationStructureAggregate.SimpleOrganizationStructureAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(OrganizationStructureId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(OrganizationStructureCommand c, Consumer<OrganizationStructureAggregate> action)
    {
        OrganizationStructureId aggregateId = c.getId();
        OrganizationStructureState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        OrganizationStructureAggregate aggregate = getOrganizationStructureAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, OrganizationStructureAggregate aggregate, OrganizationStructureState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(OrganizationStructureEvent.OrganizationStructureStateCreated stateCreated) {
        OrganizationStructureId aggregateId = stateCreated.getOrganizationStructureEventId().getId();
        OrganizationStructureState state = new AbstractOrganizationStructureState.SimpleOrganizationStructureState();
        state.setId(aggregateId);

        OrganizationStructureAggregate aggregate = getOrganizationStructureAggregate(state);
        ((AbstractOrganizationStructureAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getOrganizationStructureEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(OrganizationStructureCommand command, EventStoreAggregateId eventStoreAggregateId, OrganizationStructureState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(OrganizationStructureState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractOrganizationStructureEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleOrganizationStructureApplicationService extends AbstractOrganizationStructureApplicationService 
    {
        public SimpleOrganizationStructureApplicationService(EventStore eventStore, OrganizationStructureStateRepository stateRepository, OrganizationStructureStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

