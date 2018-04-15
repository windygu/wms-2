package org.dddml.wms.domain.orderitemshipgrpinvreservation;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrderItemShipGrpInvReservationApplicationService implements OrderItemShipGrpInvReservationApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private OrderItemShipGrpInvReservationStateRepository stateRepository;

    protected OrderItemShipGrpInvReservationStateRepository getStateRepository() {
        return stateRepository;
    }

    private OrderItemShipGrpInvReservationStateQueryRepository stateQueryRepository;

    protected OrderItemShipGrpInvReservationStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<OrderItemShipGrpInvReservationAggregate, OrderItemShipGrpInvReservationState> aggregateEventListener;

    public AggregateEventListener<OrderItemShipGrpInvReservationAggregate, OrderItemShipGrpInvReservationState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<OrderItemShipGrpInvReservationAggregate, OrderItemShipGrpInvReservationState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractOrderItemShipGrpInvReservationApplicationService(EventStore eventStore, OrderItemShipGrpInvReservationStateRepository stateRepository, OrderItemShipGrpInvReservationStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(OrderItemShipGrpInvReservationCommand.CreateOrderItemShipGrpInvReservation c) {
        update(c, ar -> ar.create(c));
    }

    public void when(OrderItemShipGrpInvReservationCommand.MergePatchOrderItemShipGrpInvReservation c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(OrderItemShipGrpInvReservationCommand.DeleteOrderItemShipGrpInvReservation c) {
        update(c, ar -> ar.delete(c));
    }

    public OrderItemShipGrpInvReservationState get(OrderItemShipGrpInvResId id) {
        OrderItemShipGrpInvReservationState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<OrderItemShipGrpInvReservationState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<OrderItemShipGrpInvReservationState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<OrderItemShipGrpInvReservationState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<OrderItemShipGrpInvReservationState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public OrderItemShipGrpInvReservationEvent getEvent(OrderItemShipGrpInvResId orderItemShipGrpInvResId, long version) {
        OrderItemShipGrpInvReservationEvent e = (OrderItemShipGrpInvReservationEvent)getEventStore().getEvent(toEventStoreAggregateId(orderItemShipGrpInvResId), version);
        if (e != null)
        { e.setEventReadOnly(true); }
        else if (version == -1)
        {
            return getEvent(orderItemShipGrpInvResId, 0);
        }
        return e;
    }

    public OrderItemShipGrpInvReservationState getHistoryState(OrderItemShipGrpInvResId orderItemShipGrpInvResId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractOrderItemShipGrpInvReservationEvent.class, toEventStoreAggregateId(orderItemShipGrpInvResId), version - 1);
        return new AbstractOrderItemShipGrpInvReservationState.SimpleOrderItemShipGrpInvReservationState(eventStream.getEvents());
    }


    public OrderItemShipGrpInvReservationAggregate getOrderItemShipGrpInvReservationAggregate(OrderItemShipGrpInvReservationState state)
    {
        return new AbstractOrderItemShipGrpInvReservationAggregate.SimpleOrderItemShipGrpInvReservationAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(OrderItemShipGrpInvResId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(OrderItemShipGrpInvReservationCommand c, Consumer<OrderItemShipGrpInvReservationAggregate> action)
    {
        OrderItemShipGrpInvResId aggregateId = c.getOrderItemShipGrpInvResId();
        OrderItemShipGrpInvReservationState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        OrderItemShipGrpInvReservationAggregate aggregate = getOrderItemShipGrpInvReservationAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, OrderItemShipGrpInvReservationAggregate aggregate, OrderItemShipGrpInvReservationState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateCreated stateCreated) {
        OrderItemShipGrpInvResId aggregateId = stateCreated.getOrderItemShipGrpInvReservationEventId().getOrderItemShipGrpInvResId();
        OrderItemShipGrpInvReservationState state = new AbstractOrderItemShipGrpInvReservationState.SimpleOrderItemShipGrpInvReservationState();
        state.setOrderItemShipGrpInvResId(aggregateId);

        OrderItemShipGrpInvReservationAggregate aggregate = getOrderItemShipGrpInvReservationAggregate(state);
        ((AbstractOrderItemShipGrpInvReservationAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getOrderItemShipGrpInvReservationEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(OrderItemShipGrpInvReservationCommand command, EventStoreAggregateId eventStoreAggregateId, OrderItemShipGrpInvReservationState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(OrderItemShipGrpInvReservationState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractOrderItemShipGrpInvReservationEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleOrderItemShipGrpInvReservationApplicationService extends AbstractOrderItemShipGrpInvReservationApplicationService 
    {
        public SimpleOrderItemShipGrpInvReservationApplicationService(EventStore eventStore, OrderItemShipGrpInvReservationStateRepository stateRepository, OrderItemShipGrpInvReservationStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

