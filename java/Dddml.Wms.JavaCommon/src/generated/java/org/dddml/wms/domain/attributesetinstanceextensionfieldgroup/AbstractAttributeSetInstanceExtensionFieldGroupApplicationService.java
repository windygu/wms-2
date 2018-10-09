package org.dddml.wms.domain.attributesetinstanceextensionfieldgroup;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeSetInstanceExtensionFieldGroupApplicationService implements AttributeSetInstanceExtensionFieldGroupApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private AttributeSetInstanceExtensionFieldGroupStateRepository stateRepository;

    protected AttributeSetInstanceExtensionFieldGroupStateRepository getStateRepository() {
        return stateRepository;
    }

    private AttributeSetInstanceExtensionFieldGroupStateQueryRepository stateQueryRepository;

    protected AttributeSetInstanceExtensionFieldGroupStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<AttributeSetInstanceExtensionFieldGroupAggregate, AttributeSetInstanceExtensionFieldGroupState> aggregateEventListener;

    public AggregateEventListener<AttributeSetInstanceExtensionFieldGroupAggregate, AttributeSetInstanceExtensionFieldGroupState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<AttributeSetInstanceExtensionFieldGroupAggregate, AttributeSetInstanceExtensionFieldGroupState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractAttributeSetInstanceExtensionFieldGroupApplicationService(EventStore eventStore, AttributeSetInstanceExtensionFieldGroupStateRepository stateRepository, AttributeSetInstanceExtensionFieldGroupStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(AttributeSetInstanceExtensionFieldGroupCommand.CreateAttributeSetInstanceExtensionFieldGroup c) {
        update(c, ar -> ar.create(c));
    }

    public void when(AttributeSetInstanceExtensionFieldGroupCommand.MergePatchAttributeSetInstanceExtensionFieldGroup c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(AttributeSetInstanceExtensionFieldGroupCommand.DeleteAttributeSetInstanceExtensionFieldGroup c) {
        update(c, ar -> ar.delete(c));
    }

    public AttributeSetInstanceExtensionFieldGroupState get(String id) {
        AttributeSetInstanceExtensionFieldGroupState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<AttributeSetInstanceExtensionFieldGroupState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<AttributeSetInstanceExtensionFieldGroupState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<AttributeSetInstanceExtensionFieldGroupState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<AttributeSetInstanceExtensionFieldGroupState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public AttributeSetInstanceExtensionFieldGroupEvent getEvent(String id, long version) {
        AttributeSetInstanceExtensionFieldGroupEvent e = (AttributeSetInstanceExtensionFieldGroupEvent)getEventStore().getEvent(toEventStoreAggregateId(id), version);
        if (e != null) {
            ((AttributeSetInstanceExtensionFieldGroupEvent.SqlAttributeSetInstanceExtensionFieldGroupEvent)e).setEventReadOnly(true); 
        } else if (version == -1) {
            return getEvent(id, 0);
        }
        return e;
    }

    public AttributeSetInstanceExtensionFieldGroupState getHistoryState(String id, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractAttributeSetInstanceExtensionFieldGroupEvent.class, toEventStoreAggregateId(id), version - 1);
        return new AbstractAttributeSetInstanceExtensionFieldGroupState.SimpleAttributeSetInstanceExtensionFieldGroupState(eventStream.getEvents());
    }


    public AttributeSetInstanceExtensionFieldGroupAggregate getAttributeSetInstanceExtensionFieldGroupAggregate(AttributeSetInstanceExtensionFieldGroupState state)
    {
        return new AbstractAttributeSetInstanceExtensionFieldGroupAggregate.SimpleAttributeSetInstanceExtensionFieldGroupAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(AttributeSetInstanceExtensionFieldGroupCommand c, Consumer<AttributeSetInstanceExtensionFieldGroupAggregate> action)
    {
        String aggregateId = c.getId();
        AttributeSetInstanceExtensionFieldGroupState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        AttributeSetInstanceExtensionFieldGroupAggregate aggregate = getAttributeSetInstanceExtensionFieldGroupAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, AttributeSetInstanceExtensionFieldGroupAggregate aggregate, AttributeSetInstanceExtensionFieldGroupState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateCreated stateCreated) {
        String aggregateId = ((AttributeSetInstanceExtensionFieldGroupEvent.SqlAttributeSetInstanceExtensionFieldGroupEvent)stateCreated).getAttributeSetInstanceExtensionFieldGroupEventId().getId();
        AttributeSetInstanceExtensionFieldGroupState.SqlAttributeSetInstanceExtensionFieldGroupState state = new AbstractAttributeSetInstanceExtensionFieldGroupState.SimpleAttributeSetInstanceExtensionFieldGroupState();
        state.setId(aggregateId);

        AttributeSetInstanceExtensionFieldGroupAggregate aggregate = getAttributeSetInstanceExtensionFieldGroupAggregate(state);
        ((AbstractAttributeSetInstanceExtensionFieldGroupAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, ((AttributeSetInstanceExtensionFieldGroupEvent.SqlAttributeSetInstanceExtensionFieldGroupEvent)stateCreated).getAttributeSetInstanceExtensionFieldGroupEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(AttributeSetInstanceExtensionFieldGroupCommand command, EventStoreAggregateId eventStoreAggregateId, AttributeSetInstanceExtensionFieldGroupState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(AttributeSetInstanceExtensionFieldGroupState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractAttributeSetInstanceExtensionFieldGroupEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleAttributeSetInstanceExtensionFieldGroupApplicationService extends AbstractAttributeSetInstanceExtensionFieldGroupApplicationService 
    {
        public SimpleAttributeSetInstanceExtensionFieldGroupApplicationService(EventStore eventStore, AttributeSetInstanceExtensionFieldGroupStateRepository stateRepository, AttributeSetInstanceExtensionFieldGroupStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

