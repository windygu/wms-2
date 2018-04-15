package org.dddml.wms.domain.shipmentreceiptmvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractShipmentReceiptMvoApplicationService implements ShipmentReceiptMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private ShipmentReceiptMvoStateRepository stateRepository;

    protected ShipmentReceiptMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private ShipmentReceiptMvoStateQueryRepository stateQueryRepository;

    protected ShipmentReceiptMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<ShipmentReceiptMvoAggregate, ShipmentReceiptMvoState> aggregateEventListener;

    public AggregateEventListener<ShipmentReceiptMvoAggregate, ShipmentReceiptMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<ShipmentReceiptMvoAggregate, ShipmentReceiptMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractShipmentReceiptMvoApplicationService(EventStore eventStore, ShipmentReceiptMvoStateRepository stateRepository, ShipmentReceiptMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(ShipmentReceiptMvoCommand.CreateShipmentReceiptMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(ShipmentReceiptMvoCommand.MergePatchShipmentReceiptMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public ShipmentReceiptMvoState get(ShipmentReceiptId id) {
        ShipmentReceiptMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<ShipmentReceiptMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<ShipmentReceiptMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ShipmentReceiptMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ShipmentReceiptMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public ShipmentReceiptMvoEvent getEvent(ShipmentReceiptId shipmentReceiptId, long version) {
        ShipmentReceiptMvoEvent e = (ShipmentReceiptMvoEvent)getEventStore().getEvent(toEventStoreAggregateId(shipmentReceiptId), version);
        if (e != null)
        { e.setEventReadOnly(true); }
        else if (version == -1)
        {
            return getEvent(shipmentReceiptId, 0);
        }
        return e;
    }

    public ShipmentReceiptMvoState getHistoryState(ShipmentReceiptId shipmentReceiptId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractShipmentReceiptMvoEvent.class, toEventStoreAggregateId(shipmentReceiptId), version - 1);
        return new AbstractShipmentReceiptMvoState.SimpleShipmentReceiptMvoState(eventStream.getEvents());
    }


    public ShipmentReceiptMvoAggregate getShipmentReceiptMvoAggregate(ShipmentReceiptMvoState state)
    {
        return new AbstractShipmentReceiptMvoAggregate.SimpleShipmentReceiptMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(ShipmentReceiptId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(ShipmentReceiptMvoCommand c, Consumer<ShipmentReceiptMvoAggregate> action)
    {
        ShipmentReceiptId aggregateId = c.getShipmentReceiptId();
        ShipmentReceiptMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        ShipmentReceiptMvoAggregate aggregate = getShipmentReceiptMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getShipmentVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, ShipmentReceiptMvoAggregate aggregate, ShipmentReceiptMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(ShipmentReceiptMvoEvent.ShipmentReceiptMvoStateCreated stateCreated) {
        ShipmentReceiptId aggregateId = stateCreated.getShipmentReceiptMvoEventId().getShipmentReceiptId();
        ShipmentReceiptMvoState state = new AbstractShipmentReceiptMvoState.SimpleShipmentReceiptMvoState();
        state.setShipmentReceiptId(aggregateId);

        ShipmentReceiptMvoAggregate aggregate = getShipmentReceiptMvoAggregate(state);
        ((AbstractShipmentReceiptMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getShipmentReceiptMvoEventId().getShipmentVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(ShipmentReceiptMvoCommand command, EventStoreAggregateId eventStoreAggregateId, ShipmentReceiptMvoState state)
    {
        boolean repeated = false;
        if (command.getShipmentVersion() == null) { command.setShipmentVersion(ShipmentReceiptMvoState.VERSION_NULL); }
        if (state.getShipmentVersion() != null && state.getShipmentVersion() > command.getShipmentVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractShipmentReceiptMvoEvent.class, eventStoreAggregateId, command.getShipmentVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleShipmentReceiptMvoApplicationService extends AbstractShipmentReceiptMvoApplicationService 
    {
        public SimpleShipmentReceiptMvoApplicationService(EventStore eventStore, ShipmentReceiptMvoStateRepository stateRepository, ShipmentReceiptMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

