package org.dddml.wms.domain.orderrolemvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrderRoleMvoApplicationService implements OrderRoleMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private OrderRoleMvoStateRepository stateRepository;

    protected OrderRoleMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private OrderRoleMvoStateQueryRepository stateQueryRepository;

    protected OrderRoleMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<OrderRoleMvoAggregate, OrderRoleMvoState> aggregateEventListener;

    public AggregateEventListener<OrderRoleMvoAggregate, OrderRoleMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<OrderRoleMvoAggregate, OrderRoleMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractOrderRoleMvoApplicationService(EventStore eventStore, OrderRoleMvoStateRepository stateRepository, OrderRoleMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(OrderRoleMvoCommand.CreateOrderRoleMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(OrderRoleMvoCommand.MergePatchOrderRoleMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(OrderRoleMvoCommand.DeleteOrderRoleMvo c) {
        update(c, ar -> ar.delete(c));
    }

    public OrderRoleMvoState get(OrderRoleId id) {
        OrderRoleMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<OrderRoleMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<OrderRoleMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<OrderRoleMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<OrderRoleMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public OrderRoleMvoEvent getEvent(OrderRoleId orderRoleId, long version) {
        OrderRoleMvoEvent e = (OrderRoleMvoEvent)getEventStore().getEvent(toEventStoreAggregateId(orderRoleId), version);
        if (e != null)
        { e.setEventReadOnly(true); }
        else if (version == -1)
        {
            return getEvent(orderRoleId, 0);
        }
        return e;
    }

    public OrderRoleMvoState getHistoryState(OrderRoleId orderRoleId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractOrderRoleMvoEvent.class, toEventStoreAggregateId(orderRoleId), version - 1);
        return new AbstractOrderRoleMvoState.SimpleOrderRoleMvoState(eventStream.getEvents());
    }


    public OrderRoleMvoAggregate getOrderRoleMvoAggregate(OrderRoleMvoState state)
    {
        return new AbstractOrderRoleMvoAggregate.SimpleOrderRoleMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(OrderRoleId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(OrderRoleMvoCommand c, Consumer<OrderRoleMvoAggregate> action)
    {
        OrderRoleId aggregateId = c.getOrderRoleId();
        OrderRoleMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        OrderRoleMvoAggregate aggregate = getOrderRoleMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getOrderVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, OrderRoleMvoAggregate aggregate, OrderRoleMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(OrderRoleMvoEvent.OrderRoleMvoStateCreated stateCreated) {
        OrderRoleId aggregateId = stateCreated.getOrderRoleMvoEventId().getOrderRoleId();
        OrderRoleMvoState state = new AbstractOrderRoleMvoState.SimpleOrderRoleMvoState();
        state.setOrderRoleId(aggregateId);

        OrderRoleMvoAggregate aggregate = getOrderRoleMvoAggregate(state);
        ((AbstractOrderRoleMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getOrderRoleMvoEventId().getOrderVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(OrderRoleMvoCommand command, EventStoreAggregateId eventStoreAggregateId, OrderRoleMvoState state)
    {
        boolean repeated = false;
        if (command.getOrderVersion() == null) { command.setOrderVersion(OrderRoleMvoState.VERSION_NULL); }
        if (state.getOrderVersion() != null && state.getOrderVersion() > command.getOrderVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractOrderRoleMvoEvent.class, eventStoreAggregateId, command.getOrderVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleOrderRoleMvoApplicationService extends AbstractOrderRoleMvoApplicationService 
    {
        public SimpleOrderRoleMvoApplicationService(EventStore eventStore, OrderRoleMvoStateRepository stateRepository, OrderRoleMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

