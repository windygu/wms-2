package org.dddml.wms.domain.attributealiasmvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeAliasMvoApplicationService implements AttributeAliasMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private AttributeAliasMvoStateRepository stateRepository;

    protected AttributeAliasMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private AttributeAliasMvoStateQueryRepository stateQueryRepository;

    protected AttributeAliasMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<AttributeAliasMvoAggregate, AttributeAliasMvoState> aggregateEventListener;

    public AggregateEventListener<AttributeAliasMvoAggregate, AttributeAliasMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<AttributeAliasMvoAggregate, AttributeAliasMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractAttributeAliasMvoApplicationService(EventStore eventStore, AttributeAliasMvoStateRepository stateRepository, AttributeAliasMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(AttributeAliasMvoCommand.CreateAttributeAliasMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(AttributeAliasMvoCommand.MergePatchAttributeAliasMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(AttributeAliasMvoCommand.DeleteAttributeAliasMvo c) {
        update(c, ar -> ar.delete(c));
    }

    public AttributeAliasMvoState get(AttributeAliasId id) {
        AttributeAliasMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<AttributeAliasMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<AttributeAliasMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<AttributeAliasMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<AttributeAliasMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public AttributeAliasMvoStateEvent getStateEvent(AttributeAliasId attributeAliasId, long version) {
        AttributeAliasMvoStateEvent e = (AttributeAliasMvoStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(attributeAliasId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(attributeAliasId, 0);
        }
        return e;
    }

    public AttributeAliasMvoState getHistoryState(AttributeAliasId attributeAliasId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractAttributeAliasMvoStateEvent.class, toEventStoreAggregateId(attributeAliasId), version - 1);
        return new AbstractAttributeAliasMvoState.SimpleAttributeAliasMvoState(eventStream.getEvents());
    }


    public AttributeAliasMvoAggregate getAttributeAliasMvoAggregate(AttributeAliasMvoState state)
    {
        return new AbstractAttributeAliasMvoAggregate.SimpleAttributeAliasMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(AttributeAliasId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(AttributeAliasMvoCommand c, Consumer<AttributeAliasMvoAggregate> action)
    {
        AttributeAliasId aggregateId = c.getAttributeAliasId();
        AttributeAliasMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        AttributeAliasMvoAggregate aggregate = getAttributeAliasMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getAttributeVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, AttributeAliasMvoAggregate aggregate, AttributeAliasMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(AttributeAliasMvoStateEvent.AttributeAliasMvoStateCreated stateCreated) {
        AttributeAliasId aggregateId = stateCreated.getAttributeAliasMvoEventId().getAttributeAliasId();
        AttributeAliasMvoState state = new AbstractAttributeAliasMvoState.SimpleAttributeAliasMvoState();
        state.setAttributeAliasId(aggregateId);

        AttributeAliasMvoAggregate aggregate = getAttributeAliasMvoAggregate(state);
        ((AbstractAttributeAliasMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getAttributeAliasMvoEventId().getAttributeVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(AttributeAliasMvoCommand command, EventStoreAggregateId eventStoreAggregateId, AttributeAliasMvoState state)
    {
        boolean repeated = false;
        if (command.getAttributeVersion() == null) { command.setAttributeVersion(AttributeAliasMvoState.VERSION_NULL); }
        if (state.getAttributeVersion() != null && state.getAttributeVersion() > command.getAttributeVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractAttributeAliasMvoStateEvent.class, eventStoreAggregateId, command.getAttributeVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleAttributeAliasMvoApplicationService extends AbstractAttributeAliasMvoApplicationService 
    {
        public SimpleAttributeAliasMvoApplicationService(EventStore eventStore, AttributeAliasMvoStateRepository stateRepository, AttributeAliasMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

