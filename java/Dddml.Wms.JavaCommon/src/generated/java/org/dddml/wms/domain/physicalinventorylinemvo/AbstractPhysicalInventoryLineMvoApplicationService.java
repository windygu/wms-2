package org.dddml.wms.domain.physicalinventorylinemvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPhysicalInventoryLineMvoApplicationService implements PhysicalInventoryLineMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private PhysicalInventoryLineMvoStateRepository stateRepository;

    protected PhysicalInventoryLineMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private PhysicalInventoryLineMvoStateQueryRepository stateQueryRepository;

    protected PhysicalInventoryLineMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<PhysicalInventoryLineMvoAggregate, PhysicalInventoryLineMvoState> aggregateEventListener;

    public AggregateEventListener<PhysicalInventoryLineMvoAggregate, PhysicalInventoryLineMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<PhysicalInventoryLineMvoAggregate, PhysicalInventoryLineMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractPhysicalInventoryLineMvoApplicationService(EventStore eventStore, PhysicalInventoryLineMvoStateRepository stateRepository, PhysicalInventoryLineMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(PhysicalInventoryLineMvoCommand.CreatePhysicalInventoryLineMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(PhysicalInventoryLineMvoCommand.MergePatchPhysicalInventoryLineMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(PhysicalInventoryLineMvoCommand.DeletePhysicalInventoryLineMvo c) {
        update(c, ar -> ar.delete(c));
    }

    public PhysicalInventoryLineMvoState get(PhysicalInventoryLineId id) {
        PhysicalInventoryLineMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<PhysicalInventoryLineMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<PhysicalInventoryLineMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<PhysicalInventoryLineMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<PhysicalInventoryLineMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public PhysicalInventoryLineMvoStateEvent getStateEvent(PhysicalInventoryLineId physicalInventoryLineId, long version) {
        PhysicalInventoryLineMvoStateEvent e = (PhysicalInventoryLineMvoStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(physicalInventoryLineId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(physicalInventoryLineId, 0);
        }
        return e;
    }

    public PhysicalInventoryLineMvoState getHistoryState(PhysicalInventoryLineId physicalInventoryLineId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractPhysicalInventoryLineMvoStateEvent.class, toEventStoreAggregateId(physicalInventoryLineId), version - 1);
        return new AbstractPhysicalInventoryLineMvoState.SimplePhysicalInventoryLineMvoState(eventStream.getEvents());
    }


    public PhysicalInventoryLineMvoAggregate getPhysicalInventoryLineMvoAggregate(PhysicalInventoryLineMvoState state)
    {
        return new AbstractPhysicalInventoryLineMvoAggregate.SimplePhysicalInventoryLineMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(PhysicalInventoryLineId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(PhysicalInventoryLineMvoCommand c, Consumer<PhysicalInventoryLineMvoAggregate> action)
    {
        PhysicalInventoryLineId aggregateId = c.getPhysicalInventoryLineId();
        PhysicalInventoryLineMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        PhysicalInventoryLineMvoAggregate aggregate = getPhysicalInventoryLineMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getPhysicalInventoryVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, PhysicalInventoryLineMvoAggregate aggregate, PhysicalInventoryLineMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateCreated stateCreated) {
        PhysicalInventoryLineId aggregateId = stateCreated.getPhysicalInventoryLineMvoEventId().getPhysicalInventoryLineId();
        PhysicalInventoryLineMvoState state = new AbstractPhysicalInventoryLineMvoState.SimplePhysicalInventoryLineMvoState();
        state.setPhysicalInventoryLineId(aggregateId);

        PhysicalInventoryLineMvoAggregate aggregate = getPhysicalInventoryLineMvoAggregate(state);
        ((AbstractPhysicalInventoryLineMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getPhysicalInventoryLineMvoEventId().getPhysicalInventoryVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(PhysicalInventoryLineMvoCommand command, EventStoreAggregateId eventStoreAggregateId, PhysicalInventoryLineMvoState state)
    {
        boolean repeated = false;
        if (command.getPhysicalInventoryVersion() == null) { command.setPhysicalInventoryVersion(PhysicalInventoryLineMvoState.VERSION_NULL); }
        if (state.getPhysicalInventoryVersion() != null && state.getPhysicalInventoryVersion() > command.getPhysicalInventoryVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractPhysicalInventoryLineMvoStateEvent.class, eventStoreAggregateId, command.getPhysicalInventoryVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimplePhysicalInventoryLineMvoApplicationService extends AbstractPhysicalInventoryLineMvoApplicationService 
    {
        public SimplePhysicalInventoryLineMvoApplicationService(EventStore eventStore, PhysicalInventoryLineMvoStateRepository stateRepository, PhysicalInventoryLineMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

