package org.dddml.wms.domain.facility;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractFacilityApplicationService implements FacilityApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private FacilityStateRepository stateRepository;

    protected FacilityStateRepository getStateRepository() {
        return stateRepository;
    }

    private FacilityStateQueryRepository stateQueryRepository;

    protected FacilityStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<FacilityAggregate, FacilityState> aggregateEventListener;

    public AggregateEventListener<FacilityAggregate, FacilityState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<FacilityAggregate, FacilityState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractFacilityApplicationService(EventStore eventStore, FacilityStateRepository stateRepository, FacilityStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(FacilityCommand.CreateFacility c) {
        update(c, ar -> ar.create(c));
    }

    public void when(FacilityCommand.MergePatchFacility c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(FacilityCommand.DeleteFacility c) {
        update(c, ar -> ar.delete(c));
    }

    public FacilityState get(String id) {
        FacilityState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<FacilityState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<FacilityState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<FacilityState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<FacilityState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public FacilityEvent getEvent(String facilityId, long version) {
        FacilityEvent e = (FacilityEvent)getEventStore().getEvent(toEventStoreAggregateId(facilityId), version);
        if (e != null)
        { ((FacilityEvent.SqlFacilityEvent)e).setEventReadOnly(true); }
        else if (version == -1)
        {
            return getEvent(facilityId, 0);
        }
        return e;
    }

    public FacilityState getHistoryState(String facilityId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractFacilityEvent.class, toEventStoreAggregateId(facilityId), version - 1);
        return new AbstractFacilityState.SimpleFacilityState(eventStream.getEvents());
    }


    public FacilityAggregate getFacilityAggregate(FacilityState state)
    {
        return new AbstractFacilityAggregate.SimpleFacilityAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(FacilityCommand c, Consumer<FacilityAggregate> action)
    {
        String aggregateId = c.getFacilityId();
        FacilityState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        FacilityAggregate aggregate = getFacilityAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, FacilityAggregate aggregate, FacilityState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(FacilityEvent.FacilityStateCreated stateCreated) {
        String aggregateId = ((FacilityEvent.SqlFacilityEvent)stateCreated).getFacilityEventId().getFacilityId();
        FacilityState state = new AbstractFacilityState.SimpleFacilityState();
        state.setFacilityId(aggregateId);

        FacilityAggregate aggregate = getFacilityAggregate(state);
        ((AbstractFacilityAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, ((FacilityEvent.SqlFacilityEvent)stateCreated).getFacilityEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(FacilityCommand command, EventStoreAggregateId eventStoreAggregateId, FacilityState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(FacilityState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractFacilityEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleFacilityApplicationService extends AbstractFacilityApplicationService 
    {
        public SimpleFacilityApplicationService(EventStore eventStore, FacilityStateRepository stateRepository, FacilityStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

