package org.dddml.wms.domain.organizationstructuretype;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrganizationStructureTypeApplicationService implements OrganizationStructureTypeApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private OrganizationStructureTypeStateRepository stateRepository;

    protected OrganizationStructureTypeStateRepository getStateRepository() {
        return stateRepository;
    }

    private OrganizationStructureTypeStateQueryRepository stateQueryRepository;

    protected OrganizationStructureTypeStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<OrganizationStructureTypeAggregate, OrganizationStructureTypeState> aggregateEventListener;

    public AggregateEventListener<OrganizationStructureTypeAggregate, OrganizationStructureTypeState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<OrganizationStructureTypeAggregate, OrganizationStructureTypeState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractOrganizationStructureTypeApplicationService(EventStore eventStore, OrganizationStructureTypeStateRepository stateRepository, OrganizationStructureTypeStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(OrganizationStructureTypeCommand.CreateOrganizationStructureType c) {
        update(c, ar -> ar.create(c));
    }

    public void when(OrganizationStructureTypeCommand.MergePatchOrganizationStructureType c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(OrganizationStructureTypeCommand.DeleteOrganizationStructureType c) {
        update(c, ar -> ar.delete(c));
    }

    public OrganizationStructureTypeState get(String id) {
        OrganizationStructureTypeState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<OrganizationStructureTypeState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<OrganizationStructureTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<OrganizationStructureTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<OrganizationStructureTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public OrganizationStructureTypeStateEvent getStateEvent(String id, long version) {
        OrganizationStructureTypeStateEvent e = (OrganizationStructureTypeStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(id), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(id, 0);
        }
        return e;
    }

    public OrganizationStructureTypeState getHistoryState(String id, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractOrganizationStructureTypeStateEvent.class, toEventStoreAggregateId(id), version - 1);
        return new AbstractOrganizationStructureTypeState.SimpleOrganizationStructureTypeState(eventStream.getEvents());
    }


    public OrganizationStructureTypeAggregate getOrganizationStructureTypeAggregate(OrganizationStructureTypeState state)
    {
        return new AbstractOrganizationStructureTypeAggregate.SimpleOrganizationStructureTypeAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(OrganizationStructureTypeCommand c, Consumer<OrganizationStructureTypeAggregate> action)
    {
        String aggregateId = c.getId();
        OrganizationStructureTypeState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        OrganizationStructureTypeAggregate aggregate = getOrganizationStructureTypeAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, OrganizationStructureTypeAggregate aggregate, OrganizationStructureTypeState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(OrganizationStructureTypeStateEvent.OrganizationStructureTypeStateCreated stateCreated) {
        String aggregateId = stateCreated.getOrganizationStructureTypeEventId().getId();
        OrganizationStructureTypeState state = new AbstractOrganizationStructureTypeState.SimpleOrganizationStructureTypeState();
        state.setId(aggregateId);

        OrganizationStructureTypeAggregate aggregate = getOrganizationStructureTypeAggregate(state);
        ((AbstractOrganizationStructureTypeAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getOrganizationStructureTypeEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(OrganizationStructureTypeCommand command, EventStoreAggregateId eventStoreAggregateId, OrganizationStructureTypeState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(OrganizationStructureTypeState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractOrganizationStructureTypeStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleOrganizationStructureTypeApplicationService extends AbstractOrganizationStructureTypeApplicationService 
    {
        public SimpleOrganizationStructureTypeApplicationService(EventStore eventStore, OrganizationStructureTypeStateRepository stateRepository, OrganizationStructureTypeStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

