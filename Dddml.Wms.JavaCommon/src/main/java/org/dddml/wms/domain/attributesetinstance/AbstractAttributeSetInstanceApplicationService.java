package org.dddml.wms.domain.attributesetinstance;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeSetInstanceApplicationService implements AttributeSetInstanceApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private AttributeSetInstanceStateRepository stateRepository;

    protected AttributeSetInstanceStateRepository getStateRepository() {
        return stateRepository;
    }

    private AttributeSetInstanceStateQueryRepository stateQueryRepository;

    private IdGenerator<String, AttributeSetInstanceCommand.CreateAttributeSetInstance, AttributeSetInstanceState> attributeSetInstanceIdGenerator;

    protected IdGenerator<String, AttributeSetInstanceCommand.CreateAttributeSetInstance, AttributeSetInstanceState> getIdGenerator() {
        return attributeSetInstanceIdGenerator;
    }
    protected AttributeSetInstanceStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    public AbstractAttributeSetInstanceApplicationService(EventStore eventStore, AttributeSetInstanceStateRepository stateRepository, AttributeSetInstanceStateQueryRepository stateQueryRepository, IdGenerator<String, AttributeSetInstanceCommand.CreateAttributeSetInstance, AttributeSetInstanceState> idGenerator) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
        this.attributeSetInstanceIdGenerator = idGenerator;
    }

    public String createWithoutId(AttributeSetInstanceCommand.CreateAttributeSetInstance c) {
        String idObj = getIdGenerator().generateId(c);
        AttributeSetInstanceState state = getStateRepository().get(idObj, true);
        if (state != null) {
            if (getIdGenerator().equals(c, state)) {
                return state.getAttributeSetInstanceId();
            }

            if (getIdGenerator().isSurrogateIdEnabled()) {
                idObj = getIdGenerator().getNextId();
            } else {
                throw DomainError.named("instanceExist", "the instance already exist, Id: %1$s , aggreate name: %2$s ", idObj, "AttributeSetInstance");
            }
        }
        c.setAttributeSetInstanceId(idObj);
        when(c);
        return idObj;
   
    }

    public void when(AttributeSetInstanceCommand.CreateAttributeSetInstance c) {
        update(c, ar -> ar.create(c));
    }

    public AttributeSetInstanceState get(String id) {
        AttributeSetInstanceState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<AttributeSetInstanceState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<AttributeSetInstanceState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<AttributeSetInstanceState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<AttributeSetInstanceState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public AttributeSetInstanceStateEvent getStateEvent(String attributeSetInstanceId, long version) {
        AttributeSetInstanceStateEvent e = (AttributeSetInstanceStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(attributeSetInstanceId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(attributeSetInstanceId, 0);
        }
        return e;
    }

    public AttributeSetInstanceState getHistoryState(String attributeSetInstanceId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractAttributeSetInstanceStateEvent.class, toEventStoreAggregateId(attributeSetInstanceId), version - 1);
        return new AbstractAttributeSetInstanceState.SimpleAttributeSetInstanceState(eventStream.getEvents());
    }


    public AttributeSetInstanceAggregate getAttributeSetInstanceAggregate(AttributeSetInstanceState state)
    {
        return new AbstractAttributeSetInstanceAggregate.SimpleAttributeSetInstanceAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(AttributeSetInstanceCommand c, Consumer<AttributeSetInstanceAggregate> action)
    {
        String aggregateId = c.getAttributeSetInstanceId();
        AttributeSetInstanceState state = getStateRepository().get(aggregateId, false);
        AttributeSetInstanceAggregate aggregate = getAttributeSetInstanceAggregate(state);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        getEventStore().appendEvents(eventStoreAggregateId, c.getVersion(), // State version may be null!
            aggregate.getChanges(), (events) -> {});

    }

    protected boolean isRepeatedCommand(AttributeSetInstanceCommand command, EventStoreAggregateId eventStoreAggregateId, AttributeSetInstanceState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(AttributeSetInstanceState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractAttributeSetInstanceStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleAttributeSetInstanceApplicationService extends AbstractAttributeSetInstanceApplicationService 
    {
        public SimpleAttributeSetInstanceApplicationService(EventStore eventStore, AttributeSetInstanceStateRepository stateRepository, AttributeSetInstanceStateQueryRepository stateQueryRepository, IdGenerator<String, AttributeSetInstanceCommand.CreateAttributeSetInstance, AttributeSetInstanceState> idGenerator)
        {
            super(eventStore, stateRepository, stateQueryRepository, idGenerator);
        }
    }

}

