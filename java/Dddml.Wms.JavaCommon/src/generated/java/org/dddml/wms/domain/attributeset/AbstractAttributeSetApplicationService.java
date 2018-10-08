package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeSetApplicationService implements AttributeSetApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private AttributeSetStateRepository stateRepository;

    protected AttributeSetStateRepository getStateRepository() {
        return stateRepository;
    }

    private AttributeSetStateQueryRepository stateQueryRepository;

    protected AttributeSetStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<AttributeSetAggregate, AttributeSetState> aggregateEventListener;

    public AggregateEventListener<AttributeSetAggregate, AttributeSetState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<AttributeSetAggregate, AttributeSetState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractAttributeSetApplicationService(EventStore eventStore, AttributeSetStateRepository stateRepository, AttributeSetStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(AttributeSetCommand.CreateAttributeSet c) {
        update(c, ar -> ar.create(c));
    }

    public void when(AttributeSetCommand.MergePatchAttributeSet c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(AttributeSetCommand.DeleteAttributeSet c) {
        update(c, ar -> ar.delete(c));
    }

    public AttributeSetState get(String id) {
        AttributeSetState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<AttributeSetState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<AttributeSetState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<AttributeSetState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<AttributeSetState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public AttributeSetEvent getEvent(String attributeSetId, long version) {
        AttributeSetEvent e = (AttributeSetEvent)getEventStore().getEvent(toEventStoreAggregateId(attributeSetId), version);
        if (e != null)
        { e.setEventReadOnly(true); }
        else if (version == -1)
        {
            return getEvent(attributeSetId, 0);
        }
        return e;
    }

    public AttributeSetState getHistoryState(String attributeSetId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractAttributeSetEvent.class, toEventStoreAggregateId(attributeSetId), version - 1);
        return new AbstractAttributeSetState.SimpleAttributeSetState(eventStream.getEvents());
    }

    public AttributeUseState getAttributeUse(String attributeSetId, String attributeId) {
        return getStateQueryRepository().getAttributeUse(attributeSetId, attributeId);
    }

    public Iterable<AttributeUseState> getAttributeUses(String attributeSetId, Criterion filter, List<String> orders) {
        return getStateQueryRepository().getAttributeUses(attributeSetId, filter, orders);
    }


    public AttributeSetAggregate getAttributeSetAggregate(AttributeSetState state)
    {
        return new AbstractAttributeSetAggregate.SimpleAttributeSetAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(AttributeSetCommand c, Consumer<AttributeSetAggregate> action)
    {
        String aggregateId = c.getAttributeSetId();
        AttributeSetState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        AttributeSetAggregate aggregate = getAttributeSetAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, AttributeSetAggregate aggregate, AttributeSetState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(AttributeSetEvent.AttributeSetStateCreated stateCreated) {
        String aggregateId = ((AttributeSetEvent.SqlAttributeSetEvent)stateCreated).getAttributeSetEventId().getAttributeSetId();
        AttributeSetState state = new AbstractAttributeSetState.SimpleAttributeSetState();
        state.setAttributeSetId(aggregateId);

        AttributeSetAggregate aggregate = getAttributeSetAggregate(state);
        ((AbstractAttributeSetAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, ((AttributeSetEvent.SqlAttributeSetEvent)stateCreated).getAttributeSetEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(AttributeSetCommand command, EventStoreAggregateId eventStoreAggregateId, AttributeSetState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(AttributeSetState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractAttributeSetEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleAttributeSetApplicationService extends AbstractAttributeSetApplicationService 
    {
        public SimpleAttributeSetApplicationService(EventStore eventStore, AttributeSetStateRepository stateRepository, AttributeSetStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

