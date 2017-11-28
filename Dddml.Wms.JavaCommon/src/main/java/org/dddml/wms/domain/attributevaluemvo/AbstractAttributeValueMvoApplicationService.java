package org.dddml.wms.domain.attributevaluemvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeValueMvoApplicationService implements AttributeValueMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private AttributeValueMvoStateRepository stateRepository;

    protected AttributeValueMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private AttributeValueMvoStateQueryRepository stateQueryRepository;

    protected AttributeValueMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<AttributeValueMvoAggregate, AttributeValueMvoState> aggregateEventListener;

    public AggregateEventListener<AttributeValueMvoAggregate, AttributeValueMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<AttributeValueMvoAggregate, AttributeValueMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractAttributeValueMvoApplicationService(EventStore eventStore, AttributeValueMvoStateRepository stateRepository, AttributeValueMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(AttributeValueMvoCommand.CreateAttributeValueMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(AttributeValueMvoCommand.MergePatchAttributeValueMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(AttributeValueMvoCommand.DeleteAttributeValueMvo c) {
        update(c, ar -> ar.delete(c));
    }

    public AttributeValueMvoState get(AttributeValueId id) {
        AttributeValueMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<AttributeValueMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<AttributeValueMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<AttributeValueMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<AttributeValueMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public AttributeValueMvoStateEvent getStateEvent(AttributeValueId attributeValueId, long version) {
        AttributeValueMvoStateEvent e = (AttributeValueMvoStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(attributeValueId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(attributeValueId, 0);
        }
        return e;
    }

    public AttributeValueMvoState getHistoryState(AttributeValueId attributeValueId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractAttributeValueMvoStateEvent.class, toEventStoreAggregateId(attributeValueId), version - 1);
        return new AbstractAttributeValueMvoState.SimpleAttributeValueMvoState(eventStream.getEvents());
    }


    public AttributeValueMvoAggregate getAttributeValueMvoAggregate(AttributeValueMvoState state)
    {
        return new AbstractAttributeValueMvoAggregate.SimpleAttributeValueMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(AttributeValueId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(AttributeValueMvoCommand c, Consumer<AttributeValueMvoAggregate> action)
    {
        AttributeValueId aggregateId = c.getAttributeValueId();
        AttributeValueMvoState state = getStateRepository().get(aggregateId, false);
        AttributeValueMvoAggregate aggregate = getAttributeValueMvoAggregate(state);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getAttributeVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, AttributeValueMvoAggregate aggregate, AttributeValueMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(AttributeValueMvoStateEvent.AttributeValueMvoStateCreated stateCreated) {
        AttributeValueId aggregateId = stateCreated.getStateEventId().getAttributeValueId();
        AttributeValueMvoState state = new AbstractAttributeValueMvoState.SimpleAttributeValueMvoState();
        state.setAttributeValueId(aggregateId);

        AttributeValueMvoAggregate aggregate = getAttributeValueMvoAggregate(state);
        ((AbstractAttributeValueMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getAttributeVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(AttributeValueMvoCommand command, EventStoreAggregateId eventStoreAggregateId, AttributeValueMvoState state)
    {
        boolean repeated = false;
        if (command.getAttributeVersion() == null) { command.setAttributeVersion(AttributeValueMvoState.VERSION_NULL); }
        if (state.getAttributeVersion() != null && state.getAttributeVersion() > command.getAttributeVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractAttributeValueMvoStateEvent.class, eventStoreAggregateId, command.getAttributeVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleAttributeValueMvoApplicationService extends AbstractAttributeValueMvoApplicationService 
    {
        public SimpleAttributeValueMvoApplicationService(EventStore eventStore, AttributeValueMvoStateRepository stateRepository, AttributeValueMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

