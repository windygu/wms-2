package org.dddml.wms.domain.itemissuancemvo;

import java.util.*;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractItemIssuanceMvoAggregate extends AbstractAggregate implements ItemIssuanceMvoAggregate
{
    private ItemIssuanceMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractItemIssuanceMvoAggregate(ItemIssuanceMvoState state)
    {
        this.state = state;
    }

    public ItemIssuanceMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(ItemIssuanceMvoCommand.CreateItemIssuanceMvo c)
    {
        if (c.getShipmentVersion() == null) { c.setShipmentVersion(ItemIssuanceMvoState.VERSION_NULL); }
        ItemIssuanceMvoStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(ItemIssuanceMvoCommand.MergePatchItemIssuanceMvo c)
    {
        ItemIssuanceMvoStateEvent e = map(c);
        apply(e);
    }

    public void delete(ItemIssuanceMvoCommand.DeleteItemIssuanceMvo c)
    {
        ItemIssuanceMvoStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        ItemIssuanceMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected ItemIssuanceMvoStateEvent map(ItemIssuanceMvoCommand.CreateItemIssuanceMvo c) {
        ItemIssuanceMvoEventId stateEventId = new ItemIssuanceMvoEventId(c.getShipmentItemIssuanceId(), c.getShipmentVersion());
        ItemIssuanceMvoStateEvent.ItemIssuanceMvoStateCreated e = newItemIssuanceMvoStateCreated(stateEventId);
        e.setOrderId(c.getOrderId());
        e.setOrderItemSeqId(c.getOrderItemSeqId());
        e.setShipGroupSeqId(c.getShipGroupSeqId());
        e.setProductId(c.getProductId());
        e.setLocatorId(c.getLocatorId());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setShipmentItemSeqId(c.getShipmentItemSeqId());
        e.setFixedAssetId(c.getFixedAssetId());
        e.setMaintHistSeqId(c.getMaintHistSeqId());
        e.setIssuedDateTime(c.getIssuedDateTime());
        e.setIssuedByUserLoginId(c.getIssuedByUserLoginId());
        e.setQuantity(c.getQuantity());
        e.setCancelQuantity(c.getCancelQuantity());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setShipmentShipmentTypeId(c.getShipmentShipmentTypeId());
        e.setShipmentStatusId(c.getShipmentStatusId());
        e.setShipmentPrimaryOrderId(c.getShipmentPrimaryOrderId());
        e.setShipmentPrimaryReturnId(c.getShipmentPrimaryReturnId());
        e.setShipmentPrimaryShipGroupSeqId(c.getShipmentPrimaryShipGroupSeqId());
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
        ((AbstractItemIssuanceMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ItemIssuanceMvoStateEvent map(ItemIssuanceMvoCommand.MergePatchItemIssuanceMvo c) {
        ItemIssuanceMvoEventId stateEventId = new ItemIssuanceMvoEventId(c.getShipmentItemIssuanceId(), c.getShipmentVersion());
        ItemIssuanceMvoStateEvent.ItemIssuanceMvoStateMergePatched e = newItemIssuanceMvoStateMergePatched(stateEventId);
        e.setOrderId(c.getOrderId());
        e.setOrderItemSeqId(c.getOrderItemSeqId());
        e.setShipGroupSeqId(c.getShipGroupSeqId());
        e.setProductId(c.getProductId());
        e.setLocatorId(c.getLocatorId());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setShipmentItemSeqId(c.getShipmentItemSeqId());
        e.setFixedAssetId(c.getFixedAssetId());
        e.setMaintHistSeqId(c.getMaintHistSeqId());
        e.setIssuedDateTime(c.getIssuedDateTime());
        e.setIssuedByUserLoginId(c.getIssuedByUserLoginId());
        e.setQuantity(c.getQuantity());
        e.setCancelQuantity(c.getCancelQuantity());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setShipmentShipmentTypeId(c.getShipmentShipmentTypeId());
        e.setShipmentStatusId(c.getShipmentStatusId());
        e.setShipmentPrimaryOrderId(c.getShipmentPrimaryOrderId());
        e.setShipmentPrimaryReturnId(c.getShipmentPrimaryReturnId());
        e.setShipmentPrimaryShipGroupSeqId(c.getShipmentPrimaryShipGroupSeqId());
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
        e.setIsPropertyOrderIdRemoved(c.getIsPropertyOrderIdRemoved());
        e.setIsPropertyOrderItemSeqIdRemoved(c.getIsPropertyOrderItemSeqIdRemoved());
        e.setIsPropertyShipGroupSeqIdRemoved(c.getIsPropertyShipGroupSeqIdRemoved());
        e.setIsPropertyProductIdRemoved(c.getIsPropertyProductIdRemoved());
        e.setIsPropertyLocatorIdRemoved(c.getIsPropertyLocatorIdRemoved());
        e.setIsPropertyAttributeSetInstanceIdRemoved(c.getIsPropertyAttributeSetInstanceIdRemoved());
        e.setIsPropertyShipmentItemSeqIdRemoved(c.getIsPropertyShipmentItemSeqIdRemoved());
        e.setIsPropertyFixedAssetIdRemoved(c.getIsPropertyFixedAssetIdRemoved());
        e.setIsPropertyMaintHistSeqIdRemoved(c.getIsPropertyMaintHistSeqIdRemoved());
        e.setIsPropertyIssuedDateTimeRemoved(c.getIsPropertyIssuedDateTimeRemoved());
        e.setIsPropertyIssuedByUserLoginIdRemoved(c.getIsPropertyIssuedByUserLoginIdRemoved());
        e.setIsPropertyQuantityRemoved(c.getIsPropertyQuantityRemoved());
        e.setIsPropertyCancelQuantityRemoved(c.getIsPropertyCancelQuantityRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setIsPropertyShipmentShipmentTypeIdRemoved(c.getIsPropertyShipmentShipmentTypeIdRemoved());
        e.setIsPropertyShipmentStatusIdRemoved(c.getIsPropertyShipmentStatusIdRemoved());
        e.setIsPropertyShipmentPrimaryOrderIdRemoved(c.getIsPropertyShipmentPrimaryOrderIdRemoved());
        e.setIsPropertyShipmentPrimaryReturnIdRemoved(c.getIsPropertyShipmentPrimaryReturnIdRemoved());
        e.setIsPropertyShipmentPrimaryShipGroupSeqIdRemoved(c.getIsPropertyShipmentPrimaryShipGroupSeqIdRemoved());
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
        ((AbstractItemIssuanceMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ItemIssuanceMvoStateEvent map(ItemIssuanceMvoCommand.DeleteItemIssuanceMvo c) {
        ItemIssuanceMvoEventId stateEventId = new ItemIssuanceMvoEventId(c.getShipmentItemIssuanceId(), c.getShipmentVersion());
        ItemIssuanceMvoStateEvent.ItemIssuanceMvoStateDeleted e = newItemIssuanceMvoStateDeleted(stateEventId);
        ((AbstractItemIssuanceMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected ItemIssuanceMvoStateEvent.ItemIssuanceMvoStateCreated newItemIssuanceMvoStateCreated(Long version, String commandId, String requesterId) {
        ItemIssuanceMvoEventId stateEventId = new ItemIssuanceMvoEventId(this.state.getShipmentItemIssuanceId(), version);
        ItemIssuanceMvoStateEvent.ItemIssuanceMvoStateCreated e = newItemIssuanceMvoStateCreated(stateEventId);
        ((AbstractItemIssuanceMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ItemIssuanceMvoStateEvent.ItemIssuanceMvoStateMergePatched newItemIssuanceMvoStateMergePatched(Long version, String commandId, String requesterId) {
        ItemIssuanceMvoEventId stateEventId = new ItemIssuanceMvoEventId(this.state.getShipmentItemIssuanceId(), version);
        ItemIssuanceMvoStateEvent.ItemIssuanceMvoStateMergePatched e = newItemIssuanceMvoStateMergePatched(stateEventId);
        ((AbstractItemIssuanceMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ItemIssuanceMvoStateEvent.ItemIssuanceMvoStateDeleted newItemIssuanceMvoStateDeleted(Long version, String commandId, String requesterId) {
        ItemIssuanceMvoEventId stateEventId = new ItemIssuanceMvoEventId(this.state.getShipmentItemIssuanceId(), version);
        ItemIssuanceMvoStateEvent.ItemIssuanceMvoStateDeleted e = newItemIssuanceMvoStateDeleted(stateEventId);
        ((AbstractItemIssuanceMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ItemIssuanceMvoStateEvent.ItemIssuanceMvoStateCreated newItemIssuanceMvoStateCreated(ItemIssuanceMvoEventId stateEventId) {
        return new AbstractItemIssuanceMvoStateEvent.SimpleItemIssuanceMvoStateCreated(stateEventId);
    }

    protected ItemIssuanceMvoStateEvent.ItemIssuanceMvoStateMergePatched newItemIssuanceMvoStateMergePatched(ItemIssuanceMvoEventId stateEventId) {
        return new AbstractItemIssuanceMvoStateEvent.SimpleItemIssuanceMvoStateMergePatched(stateEventId);
    }

    protected ItemIssuanceMvoStateEvent.ItemIssuanceMvoStateDeleted newItemIssuanceMvoStateDeleted(ItemIssuanceMvoEventId stateEventId)
    {
        return new AbstractItemIssuanceMvoStateEvent.SimpleItemIssuanceMvoStateDeleted(stateEventId);
    }

    public static class SimpleItemIssuanceMvoAggregate extends AbstractItemIssuanceMvoAggregate
    {
        public SimpleItemIssuanceMvoAggregate(ItemIssuanceMvoState state) {
            super(state);
        }

    }

}

