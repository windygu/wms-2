package org.dddml.wms.domain.shipmentitemmvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractShipmentItemMvoApplicationService implements ShipmentItemMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private ShipmentItemMvoStateRepository stateRepository;

    protected ShipmentItemMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private ShipmentItemMvoStateQueryRepository stateQueryRepository;

    protected ShipmentItemMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<ShipmentItemMvoAggregate, ShipmentItemMvoState> aggregateEventListener;

    public AggregateEventListener<ShipmentItemMvoAggregate, ShipmentItemMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<ShipmentItemMvoAggregate, ShipmentItemMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractShipmentItemMvoApplicationService(EventStore eventStore, ShipmentItemMvoStateRepository stateRepository, ShipmentItemMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(ShipmentItemMvoCommand.CreateShipmentItemMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(ShipmentItemMvoCommand.MergePatchShipmentItemMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public ShipmentItemMvoState get(ShipmentItemId id) {
        ShipmentItemMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<ShipmentItemMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<ShipmentItemMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ShipmentItemMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ShipmentItemMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public ShipmentItemMvoStateEvent getStateEvent(ShipmentItemId shipmentItemId, long version) {
        ShipmentItemMvoStateEvent e = (ShipmentItemMvoStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(shipmentItemId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(shipmentItemId, 0);
        }
        return e;
    }

    public ShipmentItemMvoState getHistoryState(ShipmentItemId shipmentItemId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractShipmentItemMvoStateEvent.class, toEventStoreAggregateId(shipmentItemId), version - 1);
        return new AbstractShipmentItemMvoState.SimpleShipmentItemMvoState(eventStream.getEvents());
    }


    public ShipmentItemMvoAggregate getShipmentItemMvoAggregate(ShipmentItemMvoState state)
    {
        return new AbstractShipmentItemMvoAggregate.SimpleShipmentItemMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(ShipmentItemId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(ShipmentItemMvoCommand c, Consumer<ShipmentItemMvoAggregate> action)
    {
        ShipmentItemId aggregateId = c.getShipmentItemId();
        ShipmentItemMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        ShipmentItemMvoAggregate aggregate = getShipmentItemMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getShipmentVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, ShipmentItemMvoAggregate aggregate, ShipmentItemMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(ShipmentItemMvoStateEvent.ShipmentItemMvoStateCreated stateCreated) {
        ShipmentItemId aggregateId = stateCreated.getShipmentItemMvoEventId().getShipmentItemId();
        ShipmentItemMvoState state = new AbstractShipmentItemMvoState.SimpleShipmentItemMvoState();
        state.setShipmentItemId(aggregateId);

        ShipmentItemMvoAggregate aggregate = getShipmentItemMvoAggregate(state);
        ((AbstractShipmentItemMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getShipmentItemMvoEventId().getShipmentVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(ShipmentItemMvoCommand command, EventStoreAggregateId eventStoreAggregateId, ShipmentItemMvoState state)
    {
        boolean repeated = false;
        if (command.getShipmentVersion() == null) { command.setShipmentVersion(ShipmentItemMvoState.VERSION_NULL); }
        if (state.getShipmentVersion() != null && state.getShipmentVersion() > command.getShipmentVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractShipmentItemMvoStateEvent.class, eventStoreAggregateId, command.getShipmentVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleShipmentItemMvoApplicationService extends AbstractShipmentItemMvoApplicationService 
    {
        public SimpleShipmentItemMvoApplicationService(EventStore eventStore, ShipmentItemMvoStateRepository stateRepository, ShipmentItemMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

