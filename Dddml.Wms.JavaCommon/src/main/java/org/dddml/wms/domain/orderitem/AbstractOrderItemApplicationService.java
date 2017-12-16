package org.dddml.wms.domain.orderitem;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrderItemApplicationService implements OrderItemApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private OrderItemStateRepository stateRepository;

    protected OrderItemStateRepository getStateRepository() {
        return stateRepository;
    }

    private OrderItemStateQueryRepository stateQueryRepository;

    protected OrderItemStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<OrderItemAggregate, OrderItemState> aggregateEventListener;

    public AggregateEventListener<OrderItemAggregate, OrderItemState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<OrderItemAggregate, OrderItemState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractOrderItemApplicationService(EventStore eventStore, OrderItemStateRepository stateRepository, OrderItemStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(OrderItemCommand.CreateOrderItem c) {
        update(c, ar -> ar.create(c));
    }

    public void when(OrderItemCommand.MergePatchOrderItem c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public OrderItemState get(OrderItemId id) {
        OrderItemState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<OrderItemState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<OrderItemState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<OrderItemState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<OrderItemState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public OrderItemStateEvent getStateEvent(OrderItemId orderItemId, long version) {
        OrderItemStateEvent e = (OrderItemStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(orderItemId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(orderItemId, 0);
        }
        return e;
    }

    public OrderItemState getHistoryState(OrderItemId orderItemId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractOrderItemStateEvent.class, toEventStoreAggregateId(orderItemId), version - 1);
        return new AbstractOrderItemState.SimpleOrderItemState(eventStream.getEvents());
    }


    public OrderItemAggregate getOrderItemAggregate(OrderItemState state)
    {
        return new AbstractOrderItemAggregate.SimpleOrderItemAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(OrderItemId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(OrderItemCommand c, Consumer<OrderItemAggregate> action)
    {
        OrderItemId aggregateId = c.getOrderItemId();
        OrderItemState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        OrderItemAggregate aggregate = getOrderItemAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, OrderItemAggregate aggregate, OrderItemState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(OrderItemStateEvent.OrderItemStateCreated stateCreated) {
        OrderItemId aggregateId = stateCreated.getStateEventId().getOrderItemId();
        OrderItemState state = new AbstractOrderItemState.SimpleOrderItemState();
        state.setOrderItemId(aggregateId);

        OrderItemAggregate aggregate = getOrderItemAggregate(state);
        ((AbstractOrderItemAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(OrderItemCommand command, EventStoreAggregateId eventStoreAggregateId, OrderItemState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(OrderItemState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractOrderItemStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleOrderItemApplicationService extends AbstractOrderItemApplicationService 
    {
        public SimpleOrderItemApplicationService(EventStore eventStore, OrderItemStateRepository stateRepository, OrderItemStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

