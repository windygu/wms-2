package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeApplicationService implements AttributeApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private AttributeStateRepository stateRepository;

    protected AttributeStateRepository getStateRepository() {
        return stateRepository;
    }

    private AttributeStateQueryRepository stateQueryRepository;

    protected AttributeStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<AttributeAggregate, AttributeState> aggregateEventListener;

    public AggregateEventListener<AttributeAggregate, AttributeState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<AttributeAggregate, AttributeState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractAttributeApplicationService(EventStore eventStore, AttributeStateRepository stateRepository, AttributeStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(AttributeCommand.CreateAttribute c) {
        update(c, ar -> ar.create(c));
    }

    public void when(AttributeCommand.MergePatchAttribute c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(AttributeCommand.DeleteAttribute c) {
        update(c, ar -> ar.delete(c));
    }

    public AttributeState get(String id) {
        AttributeState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<AttributeState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<AttributeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<AttributeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<AttributeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public AttributeEvent getEvent(String attributeId, long version) {
        AttributeEvent e = (AttributeEvent)getEventStore().getEvent(toEventStoreAggregateId(attributeId), version);
        if (e != null)
        { e.setEventReadOnly(true); }
        else if (version == -1)
        {
            return getEvent(attributeId, 0);
        }
        return e;
    }

    public AttributeState getHistoryState(String attributeId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractAttributeEvent.class, toEventStoreAggregateId(attributeId), version - 1);
        return new AbstractAttributeState.SimpleAttributeState(eventStream.getEvents());
    }

    public AttributeValueState getAttributeValue(String attributeId, String value) {
        return getStateQueryRepository().getAttributeValue(attributeId, value);
    }

    public Iterable<AttributeValueState> getAttributeValues(String attributeId, Criterion filter, List<String> orders) {
        return getStateQueryRepository().getAttributeValues(attributeId, filter, orders);
    }

    public AttributeAliasState getAttributeAlias(String attributeId, String code) {
        return getStateQueryRepository().getAttributeAlias(attributeId, code);
    }

    public Iterable<AttributeAliasState> getAttributeAlias(String attributeId, Criterion filter, List<String> orders) {
        return getStateQueryRepository().getAttributeAlias(attributeId, filter, orders);
    }


    public AttributeAggregate getAttributeAggregate(AttributeState state)
    {
        return new AbstractAttributeAggregate.SimpleAttributeAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(AttributeCommand c, Consumer<AttributeAggregate> action)
    {
        String aggregateId = c.getAttributeId();
        AttributeState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        AttributeAggregate aggregate = getAttributeAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, AttributeAggregate aggregate, AttributeState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(AttributeEvent.AttributeStateCreated stateCreated) {
        String aggregateId = ((AttributeEvent.SqlAttributeEvent)stateCreated).getAttributeEventId().getAttributeId();
        AttributeState state = new AbstractAttributeState.SimpleAttributeState();
        state.setAttributeId(aggregateId);

        AttributeAggregate aggregate = getAttributeAggregate(state);
        ((AbstractAttributeAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, ((AttributeEvent.SqlAttributeEvent)stateCreated).getAttributeEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(AttributeCommand command, EventStoreAggregateId eventStoreAggregateId, AttributeState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(AttributeState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractAttributeEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleAttributeApplicationService extends AbstractAttributeApplicationService 
    {
        public SimpleAttributeApplicationService(EventStore eventStore, AttributeStateRepository stateRepository, AttributeStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

