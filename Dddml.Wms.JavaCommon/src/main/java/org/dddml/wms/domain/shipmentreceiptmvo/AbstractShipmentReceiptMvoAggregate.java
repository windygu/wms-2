package org.dddml.wms.domain.shipmentreceiptmvo;

import java.util.*;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractShipmentReceiptMvoAggregate extends AbstractAggregate implements ShipmentReceiptMvoAggregate
{
    private ShipmentReceiptMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractShipmentReceiptMvoAggregate(ShipmentReceiptMvoState state)
    {
        this.state = state;
    }

    public ShipmentReceiptMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(ShipmentReceiptMvoCommand.CreateShipmentReceiptMvo c)
    {
        if (c.getShipmentVersion() == null) { c.setShipmentVersion(ShipmentReceiptMvoState.VERSION_NULL); }
        ShipmentReceiptMvoStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(ShipmentReceiptMvoCommand.MergePatchShipmentReceiptMvo c)
    {
        ShipmentReceiptMvoStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        ShipmentReceiptMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected ShipmentReceiptMvoStateEvent map(ShipmentReceiptMvoCommand.CreateShipmentReceiptMvo c) {
        ShipmentReceiptMvoStateEventId stateEventId = new ShipmentReceiptMvoStateEventId(c.getShipmentReceiptId(), c.getShipmentVersion());
        ShipmentReceiptMvoStateEvent.ShipmentReceiptMvoStateCreated e = newShipmentReceiptMvoStateCreated(stateEventId);
        e.setProductId(c.getProductId());
        e.setShipmentItemSeqId(c.getShipmentItemSeqId());
        e.setRejectionId(c.getRejectionId());
        e.setItemDescription(c.getItemDescription());
        e.setAcceptedQuantity(c.getAcceptedQuantity());
        e.setRejectedQuantity(c.getRejectedQuantity());
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
        e.setShipmentCreatedBy(c.getShipmentCreatedBy());
        e.setShipmentCreatedAt(c.getShipmentCreatedAt());
        e.setShipmentUpdatedBy(c.getShipmentUpdatedBy());
        e.setShipmentUpdatedAt(c.getShipmentUpdatedAt());
        e.setShipmentActive(c.getShipmentActive());
        ((AbstractShipmentReceiptMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentReceiptMvoStateEvent map(ShipmentReceiptMvoCommand.MergePatchShipmentReceiptMvo c) {
        ShipmentReceiptMvoStateEventId stateEventId = new ShipmentReceiptMvoStateEventId(c.getShipmentReceiptId(), c.getShipmentVersion());
        ShipmentReceiptMvoStateEvent.ShipmentReceiptMvoStateMergePatched e = newShipmentReceiptMvoStateMergePatched(stateEventId);
        e.setProductId(c.getProductId());
        e.setShipmentItemSeqId(c.getShipmentItemSeqId());
        e.setRejectionId(c.getRejectionId());
        e.setItemDescription(c.getItemDescription());
        e.setAcceptedQuantity(c.getAcceptedQuantity());
        e.setRejectedQuantity(c.getRejectedQuantity());
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
        e.setShipmentCreatedBy(c.getShipmentCreatedBy());
        e.setShipmentCreatedAt(c.getShipmentCreatedAt());
        e.setShipmentUpdatedBy(c.getShipmentUpdatedBy());
        e.setShipmentUpdatedAt(c.getShipmentUpdatedAt());
        e.setShipmentActive(c.getShipmentActive());
        e.setIsPropertyProductIdRemoved(c.getIsPropertyProductIdRemoved());
        e.setIsPropertyShipmentItemSeqIdRemoved(c.getIsPropertyShipmentItemSeqIdRemoved());
        e.setIsPropertyRejectionIdRemoved(c.getIsPropertyRejectionIdRemoved());
        e.setIsPropertyItemDescriptionRemoved(c.getIsPropertyItemDescriptionRemoved());
        e.setIsPropertyAcceptedQuantityRemoved(c.getIsPropertyAcceptedQuantityRemoved());
        e.setIsPropertyRejectedQuantityRemoved(c.getIsPropertyRejectedQuantityRemoved());
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
        e.setIsPropertyShipmentCreatedByRemoved(c.getIsPropertyShipmentCreatedByRemoved());
        e.setIsPropertyShipmentCreatedAtRemoved(c.getIsPropertyShipmentCreatedAtRemoved());
        e.setIsPropertyShipmentUpdatedByRemoved(c.getIsPropertyShipmentUpdatedByRemoved());
        e.setIsPropertyShipmentUpdatedAtRemoved(c.getIsPropertyShipmentUpdatedAtRemoved());
        e.setIsPropertyShipmentActiveRemoved(c.getIsPropertyShipmentActiveRemoved());
        ((AbstractShipmentReceiptMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected ShipmentReceiptMvoStateEvent.ShipmentReceiptMvoStateCreated newShipmentReceiptMvoStateCreated(String commandId, String requesterId) {
        ShipmentReceiptMvoStateEventId stateEventId = new ShipmentReceiptMvoStateEventId(this.state.getShipmentReceiptId(), this.state.getShipmentVersion());
        ShipmentReceiptMvoStateEvent.ShipmentReceiptMvoStateCreated e = newShipmentReceiptMvoStateCreated(stateEventId);
        ((AbstractShipmentReceiptMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentReceiptMvoStateEvent.ShipmentReceiptMvoStateMergePatched newShipmentReceiptMvoStateMergePatched(String commandId, String requesterId) {
        ShipmentReceiptMvoStateEventId stateEventId = new ShipmentReceiptMvoStateEventId(this.state.getShipmentReceiptId(), this.state.getShipmentVersion());
        ShipmentReceiptMvoStateEvent.ShipmentReceiptMvoStateMergePatched e = newShipmentReceiptMvoStateMergePatched(stateEventId);
        ((AbstractShipmentReceiptMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentReceiptMvoStateEvent.ShipmentReceiptMvoStateCreated newShipmentReceiptMvoStateCreated(ShipmentReceiptMvoStateEventId stateEventId) {
        return new AbstractShipmentReceiptMvoStateEvent.SimpleShipmentReceiptMvoStateCreated(stateEventId);
    }

    protected ShipmentReceiptMvoStateEvent.ShipmentReceiptMvoStateMergePatched newShipmentReceiptMvoStateMergePatched(ShipmentReceiptMvoStateEventId stateEventId) {
        return new AbstractShipmentReceiptMvoStateEvent.SimpleShipmentReceiptMvoStateMergePatched(stateEventId);
    }


    public static class SimpleShipmentReceiptMvoAggregate extends AbstractShipmentReceiptMvoAggregate
    {
        public SimpleShipmentReceiptMvoAggregate(ShipmentReceiptMvoState state) {
            super(state);
        }

    }

}

