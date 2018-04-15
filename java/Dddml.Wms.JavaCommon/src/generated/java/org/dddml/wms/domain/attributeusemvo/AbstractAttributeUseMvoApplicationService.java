package org.dddml.wms.domain.attributeusemvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.attributeset.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeUseMvoApplicationService implements AttributeUseMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private AttributeUseMvoStateRepository stateRepository;

    protected AttributeUseMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private AttributeUseMvoStateQueryRepository stateQueryRepository;

    protected AttributeUseMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<AttributeUseMvoAggregate, AttributeUseMvoState> aggregateEventListener;

    public AggregateEventListener<AttributeUseMvoAggregate, AttributeUseMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<AttributeUseMvoAggregate, AttributeUseMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractAttributeUseMvoApplicationService(EventStore eventStore, AttributeUseMvoStateRepository stateRepository, AttributeUseMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(AttributeUseMvoCommand.CreateAttributeUseMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(AttributeUseMvoCommand.MergePatchAttributeUseMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(AttributeUseMvoCommand.DeleteAttributeUseMvo c) {
        update(c, ar -> ar.delete(c));
    }

    public AttributeUseMvoState get(AttributeSetAttributeUseId id) {
        AttributeUseMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<AttributeUseMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<AttributeUseMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<AttributeUseMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<AttributeUseMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public AttributeUseMvoEvent getEvent(AttributeSetAttributeUseId attributeSetAttributeUseId, long version) {
        AttributeUseMvoEvent e = (AttributeUseMvoEvent)getEventStore().getEvent(toEventStoreAggregateId(attributeSetAttributeUseId), version);
        if (e != null)
        { e.setEventReadOnly(true); }
        else if (version == -1)
        {
            return getEvent(attributeSetAttributeUseId, 0);
        }
        return e;
    }

    public AttributeUseMvoState getHistoryState(AttributeSetAttributeUseId attributeSetAttributeUseId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractAttributeUseMvoEvent.class, toEventStoreAggregateId(attributeSetAttributeUseId), version - 1);
        return new AbstractAttributeUseMvoState.SimpleAttributeUseMvoState(eventStream.getEvents());
    }


    public AttributeUseMvoAggregate getAttributeUseMvoAggregate(AttributeUseMvoState state)
    {
        return new AbstractAttributeUseMvoAggregate.SimpleAttributeUseMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(AttributeSetAttributeUseId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(AttributeUseMvoCommand c, Consumer<AttributeUseMvoAggregate> action)
    {
        AttributeSetAttributeUseId aggregateId = c.getAttributeSetAttributeUseId();
        AttributeUseMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        AttributeUseMvoAggregate aggregate = getAttributeUseMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getAttributeSetVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, AttributeUseMvoAggregate aggregate, AttributeUseMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(AttributeUseMvoEvent.AttributeUseMvoStateCreated stateCreated) {
        AttributeSetAttributeUseId aggregateId = stateCreated.getAttributeUseMvoEventId().getAttributeSetAttributeUseId();
        AttributeUseMvoState state = new AbstractAttributeUseMvoState.SimpleAttributeUseMvoState();
        state.setAttributeSetAttributeUseId(aggregateId);

        AttributeUseMvoAggregate aggregate = getAttributeUseMvoAggregate(state);
        ((AbstractAttributeUseMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getAttributeUseMvoEventId().getAttributeSetVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(AttributeUseMvoCommand command, EventStoreAggregateId eventStoreAggregateId, AttributeUseMvoState state)
    {
        boolean repeated = false;
        if (command.getAttributeSetVersion() == null) { command.setAttributeSetVersion(AttributeUseMvoState.VERSION_NULL); }
        if (state.getAttributeSetVersion() != null && state.getAttributeSetVersion() > command.getAttributeSetVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractAttributeUseMvoEvent.class, eventStoreAggregateId, command.getAttributeSetVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleAttributeUseMvoApplicationService extends AbstractAttributeUseMvoApplicationService 
    {
        public SimpleAttributeUseMvoApplicationService(EventStore eventStore, AttributeUseMvoStateRepository stateRepository, AttributeUseMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

