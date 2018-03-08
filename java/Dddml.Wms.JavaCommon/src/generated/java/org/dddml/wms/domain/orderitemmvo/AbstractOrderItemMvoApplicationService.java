package org.dddml.wms.domain.orderitemmvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrderItemMvoApplicationService implements OrderItemMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private OrderItemMvoStateRepository stateRepository;

    protected OrderItemMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private OrderItemMvoStateQueryRepository stateQueryRepository;

    protected OrderItemMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<OrderItemMvoAggregate, OrderItemMvoState> aggregateEventListener;

    public AggregateEventListener<OrderItemMvoAggregate, OrderItemMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<OrderItemMvoAggregate, OrderItemMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractOrderItemMvoApplicationService(EventStore eventStore, OrderItemMvoStateRepository stateRepository, OrderItemMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(OrderItemMvoCommand.CreateOrderItemMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(OrderItemMvoCommand.MergePatchOrderItemMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public OrderItemMvoState get(OrderItemId id) {
        OrderItemMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<OrderItemMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<OrderItemMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<OrderItemMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<OrderItemMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public OrderItemMvoStateEvent getStateEvent(OrderItemId orderItemId, long version) {
        OrderItemMvoStateEvent e = (OrderItemMvoStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(orderItemId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(orderItemId, 0);
        }
        return e;
    }

    public OrderItemMvoState getHistoryState(OrderItemId orderItemId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractOrderItemMvoStateEvent.class, toEventStoreAggregateId(orderItemId), version - 1);
        return new AbstractOrderItemMvoState.SimpleOrderItemMvoState(eventStream.getEvents());
    }


    public OrderItemMvoAggregate getOrderItemMvoAggregate(OrderItemMvoState state)
    {
        return new AbstractOrderItemMvoAggregate.SimpleOrderItemMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(OrderItemId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(OrderItemMvoCommand c, Consumer<OrderItemMvoAggregate> action)
    {
        OrderItemId aggregateId = c.getOrderItemId();
        OrderItemMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        OrderItemMvoAggregate aggregate = getOrderItemMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getOrderVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, OrderItemMvoAggregate aggregate, OrderItemMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(OrderItemMvoStateEvent.OrderItemMvoStateCreated stateCreated) {
        OrderItemId aggregateId = stateCreated.getOrderItemMvoEventId().getOrderItemId();
        OrderItemMvoState state = new AbstractOrderItemMvoState.SimpleOrderItemMvoState();
        state.setOrderItemId(aggregateId);

        OrderItemMvoAggregate aggregate = getOrderItemMvoAggregate(state);
        ((AbstractOrderItemMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getOrderItemMvoEventId().getOrderVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(OrderItemMvoCommand command, EventStoreAggregateId eventStoreAggregateId, OrderItemMvoState state)
    {
        boolean repeated = false;
        if (command.getOrderVersion() == null) { command.setOrderVersion(OrderItemMvoState.VERSION_NULL); }
        if (state.getOrderVersion() != null && state.getOrderVersion() > command.getOrderVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractOrderItemMvoStateEvent.class, eventStoreAggregateId, command.getOrderVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleOrderItemMvoApplicationService extends AbstractOrderItemMvoApplicationService 
    {
        public SimpleOrderItemMvoApplicationService(EventStore eventStore, OrderItemMvoStateRepository stateRepository, OrderItemMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

