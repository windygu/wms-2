package org.dddml.wms.domain.ordershipment;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrderShipmentApplicationService implements OrderShipmentApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private OrderShipmentStateRepository stateRepository;

    protected OrderShipmentStateRepository getStateRepository() {
        return stateRepository;
    }

    private OrderShipmentStateQueryRepository stateQueryRepository;

    protected OrderShipmentStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<OrderShipmentAggregate, OrderShipmentState> aggregateEventListener;

    public AggregateEventListener<OrderShipmentAggregate, OrderShipmentState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<OrderShipmentAggregate, OrderShipmentState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractOrderShipmentApplicationService(EventStore eventStore, OrderShipmentStateRepository stateRepository, OrderShipmentStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(OrderShipmentCommand.CreateOrderShipment c) {
        update(c, ar -> ar.create(c));
    }

    public void when(OrderShipmentCommand.MergePatchOrderShipment c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public OrderShipmentState get(OrderShipmentId id) {
        OrderShipmentState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<OrderShipmentState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<OrderShipmentState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<OrderShipmentState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<OrderShipmentState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public OrderShipmentEvent getEvent(OrderShipmentId orderShipmentId, long version) {
        OrderShipmentEvent e = (OrderShipmentEvent)getEventStore().getEvent(toEventStoreAggregateId(orderShipmentId), version);
        if (e != null)
        { ((OrderShipmentEvent.SqlOrderShipmentEvent)e).setEventReadOnly(true); }
        else if (version == -1)
        {
            return getEvent(orderShipmentId, 0);
        }
        return e;
    }

    public OrderShipmentState getHistoryState(OrderShipmentId orderShipmentId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractOrderShipmentEvent.class, toEventStoreAggregateId(orderShipmentId), version - 1);
        return new AbstractOrderShipmentState.SimpleOrderShipmentState(eventStream.getEvents());
    }


    public OrderShipmentAggregate getOrderShipmentAggregate(OrderShipmentState state)
    {
        return new AbstractOrderShipmentAggregate.SimpleOrderShipmentAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(OrderShipmentId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(OrderShipmentCommand c, Consumer<OrderShipmentAggregate> action)
    {
        OrderShipmentId aggregateId = c.getOrderShipmentId();
        OrderShipmentState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        OrderShipmentAggregate aggregate = getOrderShipmentAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, OrderShipmentAggregate aggregate, OrderShipmentState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(OrderShipmentEvent.OrderShipmentStateCreated stateCreated) {
        OrderShipmentId aggregateId = ((OrderShipmentEvent.SqlOrderShipmentEvent)stateCreated).getOrderShipmentEventId().getOrderShipmentId();
        OrderShipmentState state = new AbstractOrderShipmentState.SimpleOrderShipmentState();
        state.setOrderShipmentId(aggregateId);

        OrderShipmentAggregate aggregate = getOrderShipmentAggregate(state);
        ((AbstractOrderShipmentAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, ((OrderShipmentEvent.SqlOrderShipmentEvent)stateCreated).getOrderShipmentEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(OrderShipmentCommand command, EventStoreAggregateId eventStoreAggregateId, OrderShipmentState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(OrderShipmentState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractOrderShipmentEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleOrderShipmentApplicationService extends AbstractOrderShipmentApplicationService 
    {
        public SimpleOrderShipmentApplicationService(EventStore eventStore, OrderShipmentStateRepository stateRepository, OrderShipmentStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

