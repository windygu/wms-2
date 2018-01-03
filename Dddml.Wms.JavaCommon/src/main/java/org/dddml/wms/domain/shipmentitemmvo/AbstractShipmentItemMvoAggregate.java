package org.dddml.wms.domain.shipmentitemmvo;

import java.util.*;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractShipmentItemMvoAggregate extends AbstractAggregate implements ShipmentItemMvoAggregate
{
    private ShipmentItemMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractShipmentItemMvoAggregate(ShipmentItemMvoState state)
    {
        this.state = state;
    }

    public ShipmentItemMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(ShipmentItemMvoCommand.CreateShipmentItemMvo c)
    {
        if (c.getShipmentVersion() == null) { c.setShipmentVersion(ShipmentItemMvoState.VERSION_NULL); }
        ShipmentItemMvoStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(ShipmentItemMvoCommand.MergePatchShipmentItemMvo c)
    {
        ShipmentItemMvoStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        ShipmentItemMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected ShipmentItemMvoStateEvent map(ShipmentItemMvoCommand.CreateShipmentItemMvo c) {
        ShipmentItemMvoStateEventId stateEventId = new ShipmentItemMvoStateEventId(c.getShipmentItemId(), c.getShipmentVersion());
        ShipmentItemMvoStateEvent.ShipmentItemMvoStateCreated e = newShipmentItemMvoStateCreated(stateEventId);
        e.setProductId(c.getProductId());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setQuantity(c.getQuantity());
        e.setTargetQuantity(c.getTargetQuantity());
        e.setShipmentContentDescription(c.getShipmentContentDescription());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setShipmentShipmentTypeId(c.getShipmentShipmentTypeId());
        e.setShipmentStatusId(c.getShipmentStatusId());
        e.setShipmentPrimaryOrderId(c.getShipmentPrimaryOrderId());
        e.setShipmentPrimaryReturnId(c.getShipmentPrimaryReturnId());
        e.setShipmentPicklistBinId(c.getShipmentPicklistBinId());
        e.setShipmentEstimatedReadyDate(c.getShipmentEstimatedReadyDate());
        e.setShipmentEstimatedShipDate(c.getShipmentEstimatedShipDate());
        e.setShipmentEstimatedShipWorkEffId(c.getShipmentEstimatedShipWorkEffId());
        e.setShipmentEstimatedArrivalDate(c.getShipmentEstimatedArrivalDate());
        e.setShipmentEstimatedArrivalWorkEffId(c.getShipmentEstimatedArrivalWorkEffId());
        e.setShipmentLatestCancelDate(c.getShipmentLatestCancelDate());
        e.setShipmentEstimatedShipCost(c.getShipmentEstimatedShipCost());
        e.setShipmentCurrencyUomId(c.getShipmentCurrencyUomId());
        e.setShipmentHandlingInstructions(c.getShipmentHandlingInstructions());
        e.setShipmentOriginFacilityId(c.getShipmentOriginFacilityId());
        e.setShipmentDestinationFacilityId(c.getShipmentDestinationFacilityId());
        e.setShipmentOriginContactMechId(c.getShipmentOriginContactMechId());
        e.setShipmentOriginTelecomNumberId(c.getShipmentOriginTelecomNumberId());
        e.setShipmentDestinationContactMechId(c.getShipmentDestinationContactMechId());
        e.setShipmentDestinationTelecomNumberId(c.getShipmentDestinationTelecomNumberId());
        e.setShipmentPartyIdTo(c.getShipmentPartyIdTo());
        e.setShipmentPartyIdFrom(c.getShipmentPartyIdFrom());
        e.setShipmentAdditionalShippingCharge(c.getShipmentAdditionalShippingCharge());
        e.setShipmentAddtlShippingChargeDesc(c.getShipmentAddtlShippingChargeDesc());
        e.setShipmentShipperId(c.getShipmentShipperId());
        e.setShipmentCreatedBy(c.getShipmentCreatedBy());
        e.setShipmentCreatedAt(c.getShipmentCreatedAt());
        e.setShipmentUpdatedBy(c.getShipmentUpdatedBy());
        e.setShipmentUpdatedAt(c.getShipmentUpdatedAt());
        e.setShipmentActive(c.getShipmentActive());
        ((AbstractShipmentItemMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentItemMvoStateEvent map(ShipmentItemMvoCommand.MergePatchShipmentItemMvo c) {
        ShipmentItemMvoStateEventId stateEventId = new ShipmentItemMvoStateEventId(c.getShipmentItemId(), c.getShipmentVersion());
        ShipmentItemMvoStateEvent.ShipmentItemMvoStateMergePatched e = newShipmentItemMvoStateMergePatched(stateEventId);
        e.setProductId(c.getProductId());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setQuantity(c.getQuantity());
        e.setTargetQuantity(c.getTargetQuantity());
        e.setShipmentContentDescription(c.getShipmentContentDescription());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setShipmentShipmentTypeId(c.getShipmentShipmentTypeId());
        e.setShipmentStatusId(c.getShipmentStatusId());
        e.setShipmentPrimaryOrderId(c.getShipmentPrimaryOrderId());
        e.setShipmentPrimaryReturnId(c.getShipmentPrimaryReturnId());
        e.setShipmentPicklistBinId(c.getShipmentPicklistBinId());
        e.setShipmentEstimatedReadyDate(c.getShipmentEstimatedReadyDate());
        e.setShipmentEstimatedShipDate(c.getShipmentEstimatedShipDate());
        e.setShipmentEstimatedShipWorkEffId(c.getShipmentEstimatedShipWorkEffId());
        e.setShipmentEstimatedArrivalDate(c.getShipmentEstimatedArrivalDate());
        e.setShipmentEstimatedArrivalWorkEffId(c.getShipmentEstimatedArrivalWorkEffId());
        e.setShipmentLatestCancelDate(c.getShipmentLatestCancelDate());
        e.setShipmentEstimatedShipCost(c.getShipmentEstimatedShipCost());
        e.setShipmentCurrencyUomId(c.getShipmentCurrencyUomId());
        e.setShipmentHandlingInstructions(c.getShipmentHandlingInstructions());
        e.setShipmentOriginFacilityId(c.getShipmentOriginFacilityId());
        e.setShipmentDestinationFacilityId(c.getShipmentDestinationFacilityId());
        e.setShipmentOriginContactMechId(c.getShipmentOriginContactMechId());
        e.setShipmentOriginTelecomNumberId(c.getShipmentOriginTelecomNumberId());
        e.setShipmentDestinationContactMechId(c.getShipmentDestinationContactMechId());
        e.setShipmentDestinationTelecomNumberId(c.getShipmentDestinationTelecomNumberId());
        e.setShipmentPartyIdTo(c.getShipmentPartyIdTo());
        e.setShipmentPartyIdFrom(c.getShipmentPartyIdFrom());
        e.setShipmentAdditionalShippingCharge(c.getShipmentAdditionalShippingCharge());
        e.setShipmentAddtlShippingChargeDesc(c.getShipmentAddtlShippingChargeDesc());
        e.setShipmentShipperId(c.getShipmentShipperId());
        e.setShipmentCreatedBy(c.getShipmentCreatedBy());
        e.setShipmentCreatedAt(c.getShipmentCreatedAt());
        e.setShipmentUpdatedBy(c.getShipmentUpdatedBy());
        e.setShipmentUpdatedAt(c.getShipmentUpdatedAt());
        e.setShipmentActive(c.getShipmentActive());
        e.setIsPropertyProductIdRemoved(c.getIsPropertyProductIdRemoved());
        e.setIsPropertyAttributeSetInstanceIdRemoved(c.getIsPropertyAttributeSetInstanceIdRemoved());
        e.setIsPropertyQuantityRemoved(c.getIsPropertyQuantityRemoved());
        e.setIsPropertyTargetQuantityRemoved(c.getIsPropertyTargetQuantityRemoved());
        e.setIsPropertyShipmentContentDescriptionRemoved(c.getIsPropertyShipmentContentDescriptionRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setIsPropertyShipmentShipmentTypeIdRemoved(c.getIsPropertyShipmentShipmentTypeIdRemoved());
        e.setIsPropertyShipmentStatusIdRemoved(c.getIsPropertyShipmentStatusIdRemoved());
        e.setIsPropertyShipmentPrimaryOrderIdRemoved(c.getIsPropertyShipmentPrimaryOrderIdRemoved());
        e.setIsPropertyShipmentPrimaryReturnIdRemoved(c.getIsPropertyShipmentPrimaryReturnIdRemoved());
        e.setIsPropertyShipmentPicklistBinIdRemoved(c.getIsPropertyShipmentPicklistBinIdRemoved());
        e.setIsPropertyShipmentEstimatedReadyDateRemoved(c.getIsPropertyShipmentEstimatedReadyDateRemoved());
        e.setIsPropertyShipmentEstimatedShipDateRemoved(c.getIsPropertyShipmentEstimatedShipDateRemoved());
        e.setIsPropertyShipmentEstimatedShipWorkEffIdRemoved(c.getIsPropertyShipmentEstimatedShipWorkEffIdRemoved());
        e.setIsPropertyShipmentEstimatedArrivalDateRemoved(c.getIsPropertyShipmentEstimatedArrivalDateRemoved());
        e.setIsPropertyShipmentEstimatedArrivalWorkEffIdRemoved(c.getIsPropertyShipmentEstimatedArrivalWorkEffIdRemoved());
        e.setIsPropertyShipmentLatestCancelDateRemoved(c.getIsPropertyShipmentLatestCancelDateRemoved());
        e.setIsPropertyShipmentEstimatedShipCostRemoved(c.getIsPropertyShipmentEstimatedShipCostRemoved());
        e.setIsPropertyShipmentCurrencyUomIdRemoved(c.getIsPropertyShipmentCurrencyUomIdRemoved());
        e.setIsPropertyShipmentHandlingInstructionsRemoved(c.getIsPropertyShipmentHandlingInstructionsRemoved());
        e.setIsPropertyShipmentOriginFacilityIdRemoved(c.getIsPropertyShipmentOriginFacilityIdRemoved());
        e.setIsPropertyShipmentDestinationFacilityIdRemoved(c.getIsPropertyShipmentDestinationFacilityIdRemoved());
        e.setIsPropertyShipmentOriginContactMechIdRemoved(c.getIsPropertyShipmentOriginContactMechIdRemoved());
        e.setIsPropertyShipmentOriginTelecomNumberIdRemoved(c.getIsPropertyShipmentOriginTelecomNumberIdRemoved());
        e.setIsPropertyShipmentDestinationContactMechIdRemoved(c.getIsPropertyShipmentDestinationContactMechIdRemoved());
        e.setIsPropertyShipmentDestinationTelecomNumberIdRemoved(c.getIsPropertyShipmentDestinationTelecomNumberIdRemoved());
        e.setIsPropertyShipmentPartyIdToRemoved(c.getIsPropertyShipmentPartyIdToRemoved());
        e.setIsPropertyShipmentPartyIdFromRemoved(c.getIsPropertyShipmentPartyIdFromRemoved());
        e.setIsPropertyShipmentAdditionalShippingChargeRemoved(c.getIsPropertyShipmentAdditionalShippingChargeRemoved());
        e.setIsPropertyShipmentAddtlShippingChargeDescRemoved(c.getIsPropertyShipmentAddtlShippingChargeDescRemoved());
        e.setIsPropertyShipmentShipperIdRemoved(c.getIsPropertyShipmentShipperIdRemoved());
        e.setIsPropertyShipmentCreatedByRemoved(c.getIsPropertyShipmentCreatedByRemoved());
        e.setIsPropertyShipmentCreatedAtRemoved(c.getIsPropertyShipmentCreatedAtRemoved());
        e.setIsPropertyShipmentUpdatedByRemoved(c.getIsPropertyShipmentUpdatedByRemoved());
        e.setIsPropertyShipmentUpdatedAtRemoved(c.getIsPropertyShipmentUpdatedAtRemoved());
        e.setIsPropertyShipmentActiveRemoved(c.getIsPropertyShipmentActiveRemoved());
        ((AbstractShipmentItemMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected ShipmentItemMvoStateEvent.ShipmentItemMvoStateCreated newShipmentItemMvoStateCreated(String commandId, String requesterId) {
        ShipmentItemMvoStateEventId stateEventId = new ShipmentItemMvoStateEventId(this.state.getShipmentItemId(), this.state.getShipmentVersion());
        ShipmentItemMvoStateEvent.ShipmentItemMvoStateCreated e = newShipmentItemMvoStateCreated(stateEventId);
        ((AbstractShipmentItemMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentItemMvoStateEvent.ShipmentItemMvoStateMergePatched newShipmentItemMvoStateMergePatched(String commandId, String requesterId) {
        ShipmentItemMvoStateEventId stateEventId = new ShipmentItemMvoStateEventId(this.state.getShipmentItemId(), this.state.getShipmentVersion());
        ShipmentItemMvoStateEvent.ShipmentItemMvoStateMergePatched e = newShipmentItemMvoStateMergePatched(stateEventId);
        ((AbstractShipmentItemMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentItemMvoStateEvent.ShipmentItemMvoStateCreated newShipmentItemMvoStateCreated(ShipmentItemMvoStateEventId stateEventId) {
        return new AbstractShipmentItemMvoStateEvent.SimpleShipmentItemMvoStateCreated(stateEventId);
    }

    protected ShipmentItemMvoStateEvent.ShipmentItemMvoStateMergePatched newShipmentItemMvoStateMergePatched(ShipmentItemMvoStateEventId stateEventId) {
        return new AbstractShipmentItemMvoStateEvent.SimpleShipmentItemMvoStateMergePatched(stateEventId);
    }


    public static class SimpleShipmentItemMvoAggregate extends AbstractShipmentItemMvoAggregate
    {
        public SimpleShipmentItemMvoAggregate(ShipmentItemMvoState state) {
            super(state);
        }

    }

}

