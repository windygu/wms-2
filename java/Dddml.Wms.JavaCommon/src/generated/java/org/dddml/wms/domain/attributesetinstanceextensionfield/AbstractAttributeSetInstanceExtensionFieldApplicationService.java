package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeSetInstanceExtensionFieldApplicationService implements AttributeSetInstanceExtensionFieldApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private AttributeSetInstanceExtensionFieldStateRepository stateRepository;

    protected AttributeSetInstanceExtensionFieldStateRepository getStateRepository() {
        return stateRepository;
    }

    private AttributeSetInstanceExtensionFieldStateQueryRepository stateQueryRepository;

    protected AttributeSetInstanceExtensionFieldStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<AttributeSetInstanceExtensionFieldAggregate, AttributeSetInstanceExtensionFieldState> aggregateEventListener;

    public AggregateEventListener<AttributeSetInstanceExtensionFieldAggregate, AttributeSetInstanceExtensionFieldState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<AttributeSetInstanceExtensionFieldAggregate, AttributeSetInstanceExtensionFieldState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractAttributeSetInstanceExtensionFieldApplicationService(EventStore eventStore, AttributeSetInstanceExtensionFieldStateRepository stateRepository, AttributeSetInstanceExtensionFieldStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(AttributeSetInstanceExtensionFieldCommand.CreateAttributeSetInstanceExtensionField c) {
        update(c, ar -> ar.create(c));
    }

    public void when(AttributeSetInstanceExtensionFieldCommand.MergePatchAttributeSetInstanceExtensionField c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(AttributeSetInstanceExtensionFieldCommand.DeleteAttributeSetInstanceExtensionField c) {
        update(c, ar -> ar.delete(c));
    }

    public AttributeSetInstanceExtensionFieldState get(String id) {
        AttributeSetInstanceExtensionFieldState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<AttributeSetInstanceExtensionFieldState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<AttributeSetInstanceExtensionFieldState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<AttributeSetInstanceExtensionFieldState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<AttributeSetInstanceExtensionFieldState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public AttributeSetInstanceExtensionFieldStateEvent getStateEvent(String name, long version) {
        AttributeSetInstanceExtensionFieldStateEvent e = (AttributeSetInstanceExtensionFieldStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(name), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(name, 0);
        }
        return e;
    }

    public AttributeSetInstanceExtensionFieldState getHistoryState(String name, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractAttributeSetInstanceExtensionFieldStateEvent.class, toEventStoreAggregateId(name), version - 1);
        return new AbstractAttributeSetInstanceExtensionFieldState.SimpleAttributeSetInstanceExtensionFieldState(eventStream.getEvents());
    }


    public AttributeSetInstanceExtensionFieldAggregate getAttributeSetInstanceExtensionFieldAggregate(AttributeSetInstanceExtensionFieldState state)
    {
        return new AbstractAttributeSetInstanceExtensionFieldAggregate.SimpleAttributeSetInstanceExtensionFieldAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(AttributeSetInstanceExtensionFieldCommand c, Consumer<AttributeSetInstanceExtensionFieldAggregate> action)
    {
        String aggregateId = c.getName();
        AttributeSetInstanceExtensionFieldState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        AttributeSetInstanceExtensionFieldAggregate aggregate = getAttributeSetInstanceExtensionFieldAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, AttributeSetInstanceExtensionFieldAggregate aggregate, AttributeSetInstanceExtensionFieldState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateCreated stateCreated) {
        String aggregateId = stateCreated.getAttributeSetInstanceExtensionFieldEventId().getName();
        AttributeSetInstanceExtensionFieldState state = new AbstractAttributeSetInstanceExtensionFieldState.SimpleAttributeSetInstanceExtensionFieldState();
        state.setName(aggregateId);

        AttributeSetInstanceExtensionFieldAggregate aggregate = getAttributeSetInstanceExtensionFieldAggregate(state);
        ((AbstractAttributeSetInstanceExtensionFieldAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getAttributeSetInstanceExtensionFieldEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(AttributeSetInstanceExtensionFieldCommand command, EventStoreAggregateId eventStoreAggregateId, AttributeSetInstanceExtensionFieldState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(AttributeSetInstanceExtensionFieldState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractAttributeSetInstanceExtensionFieldStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleAttributeSetInstanceExtensionFieldApplicationService extends AbstractAttributeSetInstanceExtensionFieldApplicationService 
    {
        public SimpleAttributeSetInstanceExtensionFieldApplicationService(EventStore eventStore, AttributeSetInstanceExtensionFieldStateRepository stateRepository, AttributeSetInstanceExtensionFieldStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

