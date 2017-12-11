package org.dddml.wms.domain.attributesetinstanceextensionfieldmvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.attributesetinstanceextensionfieldgroup.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeSetInstanceExtensionFieldMvoApplicationService implements AttributeSetInstanceExtensionFieldMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private AttributeSetInstanceExtensionFieldMvoStateRepository stateRepository;

    protected AttributeSetInstanceExtensionFieldMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private AttributeSetInstanceExtensionFieldMvoStateQueryRepository stateQueryRepository;

    protected AttributeSetInstanceExtensionFieldMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<AttributeSetInstanceExtensionFieldMvoAggregate, AttributeSetInstanceExtensionFieldMvoState> aggregateEventListener;

    public AggregateEventListener<AttributeSetInstanceExtensionFieldMvoAggregate, AttributeSetInstanceExtensionFieldMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<AttributeSetInstanceExtensionFieldMvoAggregate, AttributeSetInstanceExtensionFieldMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractAttributeSetInstanceExtensionFieldMvoApplicationService(EventStore eventStore, AttributeSetInstanceExtensionFieldMvoStateRepository stateRepository, AttributeSetInstanceExtensionFieldMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(AttributeSetInstanceExtensionFieldMvoCommand.CreateAttributeSetInstanceExtensionFieldMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(AttributeSetInstanceExtensionFieldMvoCommand.MergePatchAttributeSetInstanceExtensionFieldMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(AttributeSetInstanceExtensionFieldMvoCommand.DeleteAttributeSetInstanceExtensionFieldMvo c) {
        update(c, ar -> ar.delete(c));
    }

    public AttributeSetInstanceExtensionFieldMvoState get(AttributeSetInstanceExtensionFieldId id) {
        AttributeSetInstanceExtensionFieldMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<AttributeSetInstanceExtensionFieldMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<AttributeSetInstanceExtensionFieldMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<AttributeSetInstanceExtensionFieldMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<AttributeSetInstanceExtensionFieldMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public AttributeSetInstanceExtensionFieldMvoStateEvent getStateEvent(AttributeSetInstanceExtensionFieldId attributeSetInstanceExtensionFieldId, long version) {
        AttributeSetInstanceExtensionFieldMvoStateEvent e = (AttributeSetInstanceExtensionFieldMvoStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(attributeSetInstanceExtensionFieldId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(attributeSetInstanceExtensionFieldId, 0);
        }
        return e;
    }

    public AttributeSetInstanceExtensionFieldMvoState getHistoryState(AttributeSetInstanceExtensionFieldId attributeSetInstanceExtensionFieldId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractAttributeSetInstanceExtensionFieldMvoStateEvent.class, toEventStoreAggregateId(attributeSetInstanceExtensionFieldId), version - 1);
        return new AbstractAttributeSetInstanceExtensionFieldMvoState.SimpleAttributeSetInstanceExtensionFieldMvoState(eventStream.getEvents());
    }


    public AttributeSetInstanceExtensionFieldMvoAggregate getAttributeSetInstanceExtensionFieldMvoAggregate(AttributeSetInstanceExtensionFieldMvoState state)
    {
        return new AbstractAttributeSetInstanceExtensionFieldMvoAggregate.SimpleAttributeSetInstanceExtensionFieldMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(AttributeSetInstanceExtensionFieldId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(AttributeSetInstanceExtensionFieldMvoCommand c, Consumer<AttributeSetInstanceExtensionFieldMvoAggregate> action)
    {
        AttributeSetInstanceExtensionFieldId aggregateId = c.getAttributeSetInstanceExtensionFieldId();
        AttributeSetInstanceExtensionFieldMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        AttributeSetInstanceExtensionFieldMvoAggregate aggregate = getAttributeSetInstanceExtensionFieldMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getAttrSetInstEFGroupVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, AttributeSetInstanceExtensionFieldMvoAggregate aggregate, AttributeSetInstanceExtensionFieldMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(AttributeSetInstanceExtensionFieldMvoStateEvent.AttributeSetInstanceExtensionFieldMvoStateCreated stateCreated) {
        AttributeSetInstanceExtensionFieldId aggregateId = stateCreated.getStateEventId().getAttributeSetInstanceExtensionFieldId();
        AttributeSetInstanceExtensionFieldMvoState state = new AbstractAttributeSetInstanceExtensionFieldMvoState.SimpleAttributeSetInstanceExtensionFieldMvoState();
        state.setAttributeSetInstanceExtensionFieldId(aggregateId);

        AttributeSetInstanceExtensionFieldMvoAggregate aggregate = getAttributeSetInstanceExtensionFieldMvoAggregate(state);
        ((AbstractAttributeSetInstanceExtensionFieldMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getAttrSetInstEFGroupVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(AttributeSetInstanceExtensionFieldMvoCommand command, EventStoreAggregateId eventStoreAggregateId, AttributeSetInstanceExtensionFieldMvoState state)
    {
        boolean repeated = false;
        if (command.getAttrSetInstEFGroupVersion() == null) { command.setAttrSetInstEFGroupVersion(AttributeSetInstanceExtensionFieldMvoState.VERSION_NULL); }
        if (state.getAttrSetInstEFGroupVersion() != null && state.getAttrSetInstEFGroupVersion() > command.getAttrSetInstEFGroupVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractAttributeSetInstanceExtensionFieldMvoStateEvent.class, eventStoreAggregateId, command.getAttrSetInstEFGroupVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleAttributeSetInstanceExtensionFieldMvoApplicationService extends AbstractAttributeSetInstanceExtensionFieldMvoApplicationService 
    {
        public SimpleAttributeSetInstanceExtensionFieldMvoApplicationService(EventStore eventStore, AttributeSetInstanceExtensionFieldMvoStateRepository stateRepository, AttributeSetInstanceExtensionFieldMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

