package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractShipmentAggregate extends AbstractAggregate implements ShipmentAggregate
{
    private ShipmentState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractShipmentAggregate(ShipmentState state)
    {
        this.state = state;
    }

    public ShipmentState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(ShipmentCommand.CreateShipment c)
    {
        if (c.getVersion() == null) { c.setVersion(ShipmentState.VERSION_NULL); }
        ShipmentStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(ShipmentCommand.MergePatchShipment c)
    {
        ShipmentStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        ShipmentCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected ShipmentStateEvent map(ShipmentCommand.CreateShipment c) {
        ShipmentStateEventId stateEventId = new ShipmentStateEventId(c.getShipmentId(), c.getVersion());
        ShipmentStateEvent.ShipmentStateCreated e = newShipmentStateCreated(stateEventId);
        e.setShipmentTypeId(c.getShipmentTypeId());
        e.setStatusId(c.getStatusId());
        e.setPrimaryOrderId(c.getPrimaryOrderId());
        e.setPrimaryReturnId(c.getPrimaryReturnId());
        e.setPicklistBinId(c.getPicklistBinId());
        e.setEstimatedReadyDate(c.getEstimatedReadyDate());
        e.setEstimatedShipDate(c.getEstimatedShipDate());
        e.setEstimatedShipWorkEffId(c.getEstimatedShipWorkEffId());
        e.setEstimatedArrivalDate(c.getEstimatedArrivalDate());
        e.setEstimatedArrivalWorkEffId(c.getEstimatedArrivalWorkEffId());
        e.setLatestCancelDate(c.getLatestCancelDate());
        e.setEstimatedShipCost(c.getEstimatedShipCost());
        e.setCurrencyUomId(c.getCurrencyUomId());
        e.setHandlingInstructions(c.getHandlingInstructions());
        e.setOriginFacilityId(c.getOriginFacilityId());
        e.setDestinationFacilityId(c.getDestinationFacilityId());
        e.setOriginContactMechId(c.getOriginContactMechId());
        e.setOriginTelecomNumberId(c.getOriginTelecomNumberId());
        e.setDestinationContactMechId(c.getDestinationContactMechId());
        e.setDestinationTelecomNumberId(c.getDestinationTelecomNumberId());
        e.setPartyIdTo(c.getPartyIdTo());
        e.setPartyIdFrom(c.getPartyIdFrom());
        e.setAdditionalShippingCharge(c.getAdditionalShippingCharge());
        e.setAddtlShippingChargeDesc(c.getAddtlShippingChargeDesc());
        e.setActive(c.getActive());
        ((AbstractShipmentStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentStateEvent map(ShipmentCommand.MergePatchShipment c) {
        ShipmentStateEventId stateEventId = new ShipmentStateEventId(c.getShipmentId(), c.getVersion());
        ShipmentStateEvent.ShipmentStateMergePatched e = newShipmentStateMergePatched(stateEventId);
        e.setShipmentTypeId(c.getShipmentTypeId());
        e.setStatusId(c.getStatusId());
        e.setPrimaryOrderId(c.getPrimaryOrderId());
        e.setPrimaryReturnId(c.getPrimaryReturnId());
        e.setPicklistBinId(c.getPicklistBinId());
        e.setEstimatedReadyDate(c.getEstimatedReadyDate());
        e.setEstimatedShipDate(c.getEstimatedShipDate());
        e.setEstimatedShipWorkEffId(c.getEstimatedShipWorkEffId());
        e.setEstimatedArrivalDate(c.getEstimatedArrivalDate());
        e.setEstimatedArrivalWorkEffId(c.getEstimatedArrivalWorkEffId());
        e.setLatestCancelDate(c.getLatestCancelDate());
        e.setEstimatedShipCost(c.getEstimatedShipCost());
        e.setCurrencyUomId(c.getCurrencyUomId());
        e.setHandlingInstructions(c.getHandlingInstructions());
        e.setOriginFacilityId(c.getOriginFacilityId());
        e.setDestinationFacilityId(c.getDestinationFacilityId());
        e.setOriginContactMechId(c.getOriginContactMechId());
        e.setOriginTelecomNumberId(c.getOriginTelecomNumberId());
        e.setDestinationContactMechId(c.getDestinationContactMechId());
        e.setDestinationTelecomNumberId(c.getDestinationTelecomNumberId());
        e.setPartyIdTo(c.getPartyIdTo());
        e.setPartyIdFrom(c.getPartyIdFrom());
        e.setAdditionalShippingCharge(c.getAdditionalShippingCharge());
        e.setAddtlShippingChargeDesc(c.getAddtlShippingChargeDesc());
        e.setActive(c.getActive());
        e.setIsPropertyShipmentTypeIdRemoved(c.getIsPropertyShipmentTypeIdRemoved());
        e.setIsPropertyStatusIdRemoved(c.getIsPropertyStatusIdRemoved());
        e.setIsPropertyPrimaryOrderIdRemoved(c.getIsPropertyPrimaryOrderIdRemoved());
        e.setIsPropertyPrimaryReturnIdRemoved(c.getIsPropertyPrimaryReturnIdRemoved());
        e.setIsPropertyPicklistBinIdRemoved(c.getIsPropertyPicklistBinIdRemoved());
        e.setIsPropertyEstimatedReadyDateRemoved(c.getIsPropertyEstimatedReadyDateRemoved());
        e.setIsPropertyEstimatedShipDateRemoved(c.getIsPropertyEstimatedShipDateRemoved());
        e.setIsPropertyEstimatedShipWorkEffIdRemoved(c.getIsPropertyEstimatedShipWorkEffIdRemoved());
        e.setIsPropertyEstimatedArrivalDateRemoved(c.getIsPropertyEstimatedArrivalDateRemoved());
        e.setIsPropertyEstimatedArrivalWorkEffIdRemoved(c.getIsPropertyEstimatedArrivalWorkEffIdRemoved());
        e.setIsPropertyLatestCancelDateRemoved(c.getIsPropertyLatestCancelDateRemoved());
        e.setIsPropertyEstimatedShipCostRemoved(c.getIsPropertyEstimatedShipCostRemoved());
        e.setIsPropertyCurrencyUomIdRemoved(c.getIsPropertyCurrencyUomIdRemoved());
        e.setIsPropertyHandlingInstructionsRemoved(c.getIsPropertyHandlingInstructionsRemoved());
        e.setIsPropertyOriginFacilityIdRemoved(c.getIsPropertyOriginFacilityIdRemoved());
        e.setIsPropertyDestinationFacilityIdRemoved(c.getIsPropertyDestinationFacilityIdRemoved());
        e.setIsPropertyOriginContactMechIdRemoved(c.getIsPropertyOriginContactMechIdRemoved());
        e.setIsPropertyOriginTelecomNumberIdRemoved(c.getIsPropertyOriginTelecomNumberIdRemoved());
        e.setIsPropertyDestinationContactMechIdRemoved(c.getIsPropertyDestinationContactMechIdRemoved());
        e.setIsPropertyDestinationTelecomNumberIdRemoved(c.getIsPropertyDestinationTelecomNumberIdRemoved());
        e.setIsPropertyPartyIdToRemoved(c.getIsPropertyPartyIdToRemoved());
        e.setIsPropertyPartyIdFromRemoved(c.getIsPropertyPartyIdFromRemoved());
        e.setIsPropertyAdditionalShippingChargeRemoved(c.getIsPropertyAdditionalShippingChargeRemoved());
        e.setIsPropertyAddtlShippingChargeDescRemoved(c.getIsPropertyAddtlShippingChargeDescRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractShipmentStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected ShipmentStateEvent.ShipmentStateCreated newShipmentStateCreated(String commandId, String requesterId) {
        ShipmentStateEventId stateEventId = new ShipmentStateEventId(this.state.getShipmentId(), this.state.getVersion());
        ShipmentStateEvent.ShipmentStateCreated e = newShipmentStateCreated(stateEventId);
        ((AbstractShipmentStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentStateEvent.ShipmentStateMergePatched newShipmentStateMergePatched(String commandId, String requesterId) {
        ShipmentStateEventId stateEventId = new ShipmentStateEventId(this.state.getShipmentId(), this.state.getVersion());
        ShipmentStateEvent.ShipmentStateMergePatched e = newShipmentStateMergePatched(stateEventId);
        ((AbstractShipmentStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentStateEvent.ShipmentStateCreated newShipmentStateCreated(ShipmentStateEventId stateEventId) {
        return new AbstractShipmentStateEvent.SimpleShipmentStateCreated(stateEventId);
    }

    protected ShipmentStateEvent.ShipmentStateMergePatched newShipmentStateMergePatched(ShipmentStateEventId stateEventId) {
        return new AbstractShipmentStateEvent.SimpleShipmentStateMergePatched(stateEventId);
    }


    public static class SimpleShipmentAggregate extends AbstractShipmentAggregate
    {
        public SimpleShipmentAggregate(ShipmentState state) {
            super(state);
        }

    }

}

