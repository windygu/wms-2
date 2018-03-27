package org.dddml.wms.domain.ordershipgroupmvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrderShipGroupMvoApplicationService implements OrderShipGroupMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private OrderShipGroupMvoStateRepository stateRepository;

    protected OrderShipGroupMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private OrderShipGroupMvoStateQueryRepository stateQueryRepository;

    protected OrderShipGroupMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<OrderShipGroupMvoAggregate, OrderShipGroupMvoState> aggregateEventListener;

    public AggregateEventListener<OrderShipGroupMvoAggregate, OrderShipGroupMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<OrderShipGroupMvoAggregate, OrderShipGroupMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractOrderShipGroupMvoApplicationService(EventStore eventStore, OrderShipGroupMvoStateRepository stateRepository, OrderShipGroupMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(OrderShipGroupMvoCommand.CreateOrderShipGroupMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(OrderShipGroupMvoCommand.MergePatchOrderShipGroupMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(OrderShipGroupMvoCommand.DeleteOrderShipGroupMvo c) {
        update(c, ar -> ar.delete(c));
    }

    public OrderShipGroupMvoState get(OrderShipGroupId id) {
        OrderShipGroupMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<OrderShipGroupMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<OrderShipGroupMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<OrderShipGroupMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<OrderShipGroupMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public OrderShipGroupMvoStateEvent getStateEvent(OrderShipGroupId orderShipGroupId, long version) {
        OrderShipGroupMvoStateEvent e = (OrderShipGroupMvoStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(orderShipGroupId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(orderShipGroupId, 0);
        }
        return e;
    }

    public OrderShipGroupMvoState getHistoryState(OrderShipGroupId orderShipGroupId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractOrderShipGroupMvoStateEvent.class, toEventStoreAggregateId(orderShipGroupId), version - 1);
        return new AbstractOrderShipGroupMvoState.SimpleOrderShipGroupMvoState(eventStream.getEvents());
    }


    public OrderShipGroupMvoAggregate getOrderShipGroupMvoAggregate(OrderShipGroupMvoState state)
    {
        return new AbstractOrderShipGroupMvoAggregate.SimpleOrderShipGroupMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(OrderShipGroupId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(OrderShipGroupMvoCommand c, Consumer<OrderShipGroupMvoAggregate> action)
    {
        OrderShipGroupId aggregateId = c.getOrderShipGroupId();
        OrderShipGroupMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        OrderShipGroupMvoAggregate aggregate = getOrderShipGroupMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getOrderVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, OrderShipGroupMvoAggregate aggregate, OrderShipGroupMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateCreated stateCreated) {
        OrderShipGroupId aggregateId = stateCreated.getOrderShipGroupMvoEventId().getOrderShipGroupId();
        OrderShipGroupMvoState state = new AbstractOrderShipGroupMvoState.SimpleOrderShipGroupMvoState();
        state.setOrderShipGroupId(aggregateId);

        OrderShipGroupMvoAggregate aggregate = getOrderShipGroupMvoAggregate(state);
        ((AbstractOrderShipGroupMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getOrderShipGroupMvoEventId().getOrderVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(OrderShipGroupMvoCommand command, EventStoreAggregateId eventStoreAggregateId, OrderShipGroupMvoState state)
    {
        boolean repeated = false;
        if (command.getOrderVersion() == null) { command.setOrderVersion(OrderShipGroupMvoState.VERSION_NULL); }
        if (state.getOrderVersion() != null && state.getOrderVersion() > command.getOrderVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractOrderShipGroupMvoStateEvent.class, eventStoreAggregateId, command.getOrderVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleOrderShipGroupMvoApplicationService extends AbstractOrderShipGroupMvoApplicationService 
    {
        public SimpleOrderShipGroupMvoApplicationService(EventStore eventStore, OrderShipGroupMvoStateRepository stateRepository, OrderShipGroupMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

