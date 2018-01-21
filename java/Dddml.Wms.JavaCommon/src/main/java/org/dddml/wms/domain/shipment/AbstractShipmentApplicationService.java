package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractShipmentApplicationService implements ShipmentApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private ShipmentStateRepository stateRepository;

    protected ShipmentStateRepository getStateRepository() {
        return stateRepository;
    }

    private ShipmentStateQueryRepository stateQueryRepository;

    protected ShipmentStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<ShipmentAggregate, ShipmentState> aggregateEventListener;

    public AggregateEventListener<ShipmentAggregate, ShipmentState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<ShipmentAggregate, ShipmentState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractShipmentApplicationService(EventStore eventStore, ShipmentStateRepository stateRepository, ShipmentStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(ShipmentCommand.CreateShipment c) {
        update(c, ar -> ar.create(c));
    }

    public void when(ShipmentCommand.MergePatchShipment c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(ShipmentCommands.Import c) {
        update(c, ar -> ar._import(c.getPrimaryOrderId(), c.getPrimaryReturnId(), c.getEstimatedReadyDate(), c.getEstimatedShipDate(), c.getEstimatedArrivalDate(), c.getLatestCancelDate(), c.getEstimatedShipCost(), c.getCurrencyUomId(), c.getHandlingInstructions(), c.getOriginFacilityId(), c.getDestinationFacilityId(), c.getPartyIdTo(), c.getPartyIdFrom(), c.getAdditionalShippingCharge(), c.getAddtlShippingChargeDesc(), c.getShipmentItems(), c.getVersion(), c.getCommandId(), c.getRequesterId()));
    }

    public void when(ShipmentCommands.ReceiveItem c) {
        update(c, ar -> ar.receiveItem(c.getShipmentItemSeqId(), c.getAttributeSetInstance(), c.getRejectionReasonId(), c.getDamageStatusId(), c.getDamageReasonId(), c.getAcceptedQuantity(), c.getRejectedQuantity(), c.getDamagedQuantity(), c.getItemDescription(), c.getVersion(), c.getCommandId(), c.getRequesterId()));
    }

    public ShipmentState get(String id) {
        ShipmentState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<ShipmentState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<ShipmentState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ShipmentState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ShipmentState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public ShipmentStateEvent getStateEvent(String shipmentId, long version) {
        ShipmentStateEvent e = (ShipmentStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(shipmentId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(shipmentId, 0);
        }
        return e;
    }

    public ShipmentState getHistoryState(String shipmentId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractShipmentStateEvent.class, toEventStoreAggregateId(shipmentId), version - 1);
        return new AbstractShipmentState.SimpleShipmentState(eventStream.getEvents());
    }

    public ShipmentItemState getShipmentItem(String shipmentId, String shipmentItemSeqId) {
        return getStateQueryRepository().getShipmentItem(shipmentId, shipmentItemSeqId);
    }

    public ShipmentReceiptState getShipmentReceipt(String shipmentId, String receiptSeqId) {
        return getStateQueryRepository().getShipmentReceipt(shipmentId, receiptSeqId);
    }


    public ShipmentAggregate getShipmentAggregate(ShipmentState state)
    {
        return new AbstractShipmentAggregate.SimpleShipmentAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(ShipmentCommand c, Consumer<ShipmentAggregate> action)
    {
        String aggregateId = c.getShipmentId();
        ShipmentState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        ShipmentAggregate aggregate = getShipmentAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, ShipmentAggregate aggregate, ShipmentState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(ShipmentStateEvent.ShipmentStateCreated stateCreated) {
        String aggregateId = stateCreated.getStateEventId().getShipmentId();
        ShipmentState state = new AbstractShipmentState.SimpleShipmentState();
        state.setShipmentId(aggregateId);

        ShipmentAggregate aggregate = getShipmentAggregate(state);
        ((AbstractShipmentAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(ShipmentCommand command, EventStoreAggregateId eventStoreAggregateId, ShipmentState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(ShipmentState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractShipmentStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleShipmentApplicationService extends AbstractShipmentApplicationService 
    {
        public SimpleShipmentApplicationService(EventStore eventStore, ShipmentStateRepository stateRepository, ShipmentStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

