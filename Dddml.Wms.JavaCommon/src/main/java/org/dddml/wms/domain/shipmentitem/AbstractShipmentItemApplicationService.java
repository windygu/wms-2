package org.dddml.wms.domain.shipmentitem;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractShipmentItemApplicationService implements ShipmentItemApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private ShipmentItemStateRepository stateRepository;

    protected ShipmentItemStateRepository getStateRepository() {
        return stateRepository;
    }

    private ShipmentItemStateQueryRepository stateQueryRepository;

    protected ShipmentItemStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<ShipmentItemAggregate, ShipmentItemState> aggregateEventListener;

    public AggregateEventListener<ShipmentItemAggregate, ShipmentItemState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<ShipmentItemAggregate, ShipmentItemState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractShipmentItemApplicationService(EventStore eventStore, ShipmentItemStateRepository stateRepository, ShipmentItemStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(ShipmentItemCommand.CreateShipmentItem c) {
        update(c, ar -> ar.create(c));
    }

    public void when(ShipmentItemCommand.MergePatchShipmentItem c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public ShipmentItemState get(ShipmentItemId id) {
        ShipmentItemState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<ShipmentItemState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<ShipmentItemState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ShipmentItemState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ShipmentItemState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public ShipmentItemStateEvent getStateEvent(ShipmentItemId shipmentItemId, long version) {
        ShipmentItemStateEvent e = (ShipmentItemStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(shipmentItemId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(shipmentItemId, 0);
        }
        return e;
    }

    public ShipmentItemState getHistoryState(ShipmentItemId shipmentItemId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractShipmentItemStateEvent.class, toEventStoreAggregateId(shipmentItemId), version - 1);
        return new AbstractShipmentItemState.SimpleShipmentItemState(eventStream.getEvents());
    }


    public ShipmentItemAggregate getShipmentItemAggregate(ShipmentItemState state)
    {
        return new AbstractShipmentItemAggregate.SimpleShipmentItemAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(ShipmentItemId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(ShipmentItemCommand c, Consumer<ShipmentItemAggregate> action)
    {
        ShipmentItemId aggregateId = c.getShipmentItemId();
        ShipmentItemState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        ShipmentItemAggregate aggregate = getShipmentItemAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, ShipmentItemAggregate aggregate, ShipmentItemState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(ShipmentItemStateEvent.ShipmentItemStateCreated stateCreated) {
        ShipmentItemId aggregateId = stateCreated.getStateEventId().getShipmentItemId();
        ShipmentItemState state = new AbstractShipmentItemState.SimpleShipmentItemState();
        state.setShipmentItemId(aggregateId);

        ShipmentItemAggregate aggregate = getShipmentItemAggregate(state);
        ((AbstractShipmentItemAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(ShipmentItemCommand command, EventStoreAggregateId eventStoreAggregateId, ShipmentItemState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(ShipmentItemState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractShipmentItemStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleShipmentItemApplicationService extends AbstractShipmentItemApplicationService 
    {
        public SimpleShipmentItemApplicationService(EventStore eventStore, ShipmentItemStateRepository stateRepository, ShipmentItemStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

