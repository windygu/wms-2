package org.dddml.wms.domain.orderitemshipgroupassociationmvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrderItemShipGroupAssociationMvoApplicationService implements OrderItemShipGroupAssociationMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private OrderItemShipGroupAssociationMvoStateRepository stateRepository;

    protected OrderItemShipGroupAssociationMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private OrderItemShipGroupAssociationMvoStateQueryRepository stateQueryRepository;

    protected OrderItemShipGroupAssociationMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<OrderItemShipGroupAssociationMvoAggregate, OrderItemShipGroupAssociationMvoState> aggregateEventListener;

    public AggregateEventListener<OrderItemShipGroupAssociationMvoAggregate, OrderItemShipGroupAssociationMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<OrderItemShipGroupAssociationMvoAggregate, OrderItemShipGroupAssociationMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractOrderItemShipGroupAssociationMvoApplicationService(EventStore eventStore, OrderItemShipGroupAssociationMvoStateRepository stateRepository, OrderItemShipGroupAssociationMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(OrderItemShipGroupAssociationMvoCommand.CreateOrderItemShipGroupAssociationMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(OrderItemShipGroupAssociationMvoCommand.MergePatchOrderItemShipGroupAssociationMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(OrderItemShipGroupAssociationMvoCommand.DeleteOrderItemShipGroupAssociationMvo c) {
        update(c, ar -> ar.delete(c));
    }

    public OrderItemShipGroupAssociationMvoState get(OrderItemShipGroupAssociationId id) {
        OrderItemShipGroupAssociationMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<OrderItemShipGroupAssociationMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<OrderItemShipGroupAssociationMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<OrderItemShipGroupAssociationMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<OrderItemShipGroupAssociationMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public OrderItemShipGroupAssociationMvoStateEvent getStateEvent(OrderItemShipGroupAssociationId orderItemShipGroupAssociationId, long version) {
        OrderItemShipGroupAssociationMvoStateEvent e = (OrderItemShipGroupAssociationMvoStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(orderItemShipGroupAssociationId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(orderItemShipGroupAssociationId, 0);
        }
        return e;
    }

    public OrderItemShipGroupAssociationMvoState getHistoryState(OrderItemShipGroupAssociationId orderItemShipGroupAssociationId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractOrderItemShipGroupAssociationMvoStateEvent.class, toEventStoreAggregateId(orderItemShipGroupAssociationId), version - 1);
        return new AbstractOrderItemShipGroupAssociationMvoState.SimpleOrderItemShipGroupAssociationMvoState(eventStream.getEvents());
    }


    public OrderItemShipGroupAssociationMvoAggregate getOrderItemShipGroupAssociationMvoAggregate(OrderItemShipGroupAssociationMvoState state)
    {
        return new AbstractOrderItemShipGroupAssociationMvoAggregate.SimpleOrderItemShipGroupAssociationMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(OrderItemShipGroupAssociationId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(OrderItemShipGroupAssociationMvoCommand c, Consumer<OrderItemShipGroupAssociationMvoAggregate> action)
    {
        OrderItemShipGroupAssociationId aggregateId = c.getOrderItemShipGroupAssociationId();
        OrderItemShipGroupAssociationMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        OrderItemShipGroupAssociationMvoAggregate aggregate = getOrderItemShipGroupAssociationMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getOrderVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, OrderItemShipGroupAssociationMvoAggregate aggregate, OrderItemShipGroupAssociationMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(OrderItemShipGroupAssociationMvoStateEvent.OrderItemShipGroupAssociationMvoStateCreated stateCreated) {
        OrderItemShipGroupAssociationId aggregateId = stateCreated.getOrderItemShipGroupAssociationMvoEventId().getOrderItemShipGroupAssociationId();
        OrderItemShipGroupAssociationMvoState state = new AbstractOrderItemShipGroupAssociationMvoState.SimpleOrderItemShipGroupAssociationMvoState();
        state.setOrderItemShipGroupAssociationId(aggregateId);

        OrderItemShipGroupAssociationMvoAggregate aggregate = getOrderItemShipGroupAssociationMvoAggregate(state);
        ((AbstractOrderItemShipGroupAssociationMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getOrderItemShipGroupAssociationMvoEventId().getOrderVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(OrderItemShipGroupAssociationMvoCommand command, EventStoreAggregateId eventStoreAggregateId, OrderItemShipGroupAssociationMvoState state)
    {
        boolean repeated = false;
        if (command.getOrderVersion() == null) { command.setOrderVersion(OrderItemShipGroupAssociationMvoState.VERSION_NULL); }
        if (state.getOrderVersion() != null && state.getOrderVersion() > command.getOrderVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractOrderItemShipGroupAssociationMvoStateEvent.class, eventStoreAggregateId, command.getOrderVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleOrderItemShipGroupAssociationMvoApplicationService extends AbstractOrderItemShipGroupAssociationMvoApplicationService 
    {
        public SimpleOrderItemShipGroupAssociationMvoApplicationService(EventStore eventStore, OrderItemShipGroupAssociationMvoStateRepository stateRepository, OrderItemShipGroupAssociationMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

