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
        e.setShipperId(c.getShipperId());
        e.setActive(c.getActive());
        ((AbstractShipmentStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (ShipmentItemCommand.CreateShipmentItem innerCommand : c.getShipmentItems())
        {
            throwOnInconsistentCommands(c, innerCommand);
            ShipmentItemStateEvent.ShipmentItemStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addShipmentItemEvent(innerEvent);
        }

        for (ShipmentReceiptCommand.CreateShipmentReceipt innerCommand : c.getShipmentReceipts())
        {
            throwOnInconsistentCommands(c, innerCommand);
            ShipmentReceiptStateEvent.ShipmentReceiptStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addShipmentReceiptEvent(innerEvent);
        }

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
        e.setShipperId(c.getShipperId());
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
        e.setIsPropertyShipperIdRemoved(c.getIsPropertyShipperIdRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractShipmentStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (ShipmentItemCommand innerCommand : c.getShipmentItemCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            ShipmentItemStateEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addShipmentItemEvent(innerEvent);
        }

        for (ShipmentReceiptCommand innerCommand : c.getShipmentReceiptCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            ShipmentReceiptStateEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addShipmentReceiptEvent(innerEvent);
        }

        return e;
    }


    protected ShipmentItemStateEvent map(ShipmentItemCommand c, ShipmentCommand outerCommand, long version, ShipmentState outerState)
    {
        ShipmentItemCommand.CreateShipmentItem create = (c.getCommandType().equals(CommandType.CREATE)) ? ((ShipmentItemCommand.CreateShipmentItem)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        ShipmentItemCommand.MergePatchShipmentItem merge = (c.getCommandType().equals(CommandType.MERGE_PATCH)) ? ((ShipmentItemCommand.MergePatchShipmentItem)c) : null;
        if(merge != null)
        {
            return mapMergePatch(merge, outerCommand, version, outerState);
        }

        throw new UnsupportedOperationException();
    }

    protected ShipmentItemStateEvent.ShipmentItemStateCreated mapCreate(ShipmentItemCommand.CreateShipmentItem c, ShipmentCommand outerCommand, Long version, ShipmentState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        ShipmentItemStateEventId stateEventId = new ShipmentItemStateEventId(c.getShipmentId(), c.getShipmentItemSeqId(), version);
        ShipmentItemStateEvent.ShipmentItemStateCreated e = newShipmentItemStateCreated(stateEventId);
        ShipmentItemState s = outerState.getShipmentItems().get(c.getShipmentItemSeqId());

        e.setProductId(c.getProductId());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setQuantity(c.getQuantity());
        e.setTargetQuantity(c.getTargetQuantity());
        e.setShipmentContentDescription(c.getShipmentContentDescription());
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected ShipmentItemStateEvent.ShipmentItemStateMergePatched mapMergePatch(ShipmentItemCommand.MergePatchShipmentItem c, ShipmentCommand outerCommand, Long version, ShipmentState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        ShipmentItemStateEventId stateEventId = new ShipmentItemStateEventId(c.getShipmentId(), c.getShipmentItemSeqId(), version);
        ShipmentItemStateEvent.ShipmentItemStateMergePatched e = newShipmentItemStateMergePatched(stateEventId);
        ShipmentItemState s = outerState.getShipmentItems().get(c.getShipmentItemSeqId());

        e.setProductId(c.getProductId());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setQuantity(c.getQuantity());
        e.setTargetQuantity(c.getTargetQuantity());
        e.setShipmentContentDescription(c.getShipmentContentDescription());
        e.setActive(c.getActive());
        e.setIsPropertyProductIdRemoved(c.getIsPropertyProductIdRemoved());
        e.setIsPropertyAttributeSetInstanceIdRemoved(c.getIsPropertyAttributeSetInstanceIdRemoved());
        e.setIsPropertyQuantityRemoved(c.getIsPropertyQuantityRemoved());
        e.setIsPropertyTargetQuantityRemoved(c.getIsPropertyTargetQuantityRemoved());
        e.setIsPropertyShipmentContentDescriptionRemoved(c.getIsPropertyShipmentContentDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////


    protected ShipmentReceiptStateEvent map(ShipmentReceiptCommand c, ShipmentCommand outerCommand, long version, ShipmentState outerState)
    {
        ShipmentReceiptCommand.CreateShipmentReceipt create = (c.getCommandType().equals(CommandType.CREATE)) ? ((ShipmentReceiptCommand.CreateShipmentReceipt)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        ShipmentReceiptCommand.MergePatchShipmentReceipt merge = (c.getCommandType().equals(CommandType.MERGE_PATCH)) ? ((ShipmentReceiptCommand.MergePatchShipmentReceipt)c) : null;
        if(merge != null)
        {
            return mapMergePatch(merge, outerCommand, version, outerState);
        }

        throw new UnsupportedOperationException();
    }

    protected ShipmentReceiptStateEvent.ShipmentReceiptStateCreated mapCreate(ShipmentReceiptCommand.CreateShipmentReceipt c, ShipmentCommand outerCommand, Long version, ShipmentState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        ShipmentReceiptStateEventId stateEventId = new ShipmentReceiptStateEventId(c.getShipmentId(), c.getReceiptSeqId(), version);
        ShipmentReceiptStateEvent.ShipmentReceiptStateCreated e = newShipmentReceiptStateCreated(stateEventId);
        ShipmentReceiptState s = outerState.getShipmentReceipts().get(c.getReceiptSeqId());

        e.setProductId(c.getProductId());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setShipmentItemSeqId(c.getShipmentItemSeqId());
        e.setRejectionReasonId(c.getRejectionReasonId());
        e.setDamageStatusId(c.getDamageStatusId());
        e.setDamageReasonId(c.getDamageReasonId());
        e.setReceivedBy(c.getReceivedBy());
        e.setDatetimeReceived(c.getDatetimeReceived());
        e.setItemDescription(c.getItemDescription());
        e.setAcceptedQuantity(c.getAcceptedQuantity());
        e.setRejectedQuantity(c.getRejectedQuantity());
        e.setDamagedQuantity(c.getDamagedQuantity());
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected ShipmentReceiptStateEvent.ShipmentReceiptStateMergePatched mapMergePatch(ShipmentReceiptCommand.MergePatchShipmentReceipt c, ShipmentCommand outerCommand, Long version, ShipmentState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        ShipmentReceiptStateEventId stateEventId = new ShipmentReceiptStateEventId(c.getShipmentId(), c.getReceiptSeqId(), version);
        ShipmentReceiptStateEvent.ShipmentReceiptStateMergePatched e = newShipmentReceiptStateMergePatched(stateEventId);
        ShipmentReceiptState s = outerState.getShipmentReceipts().get(c.getReceiptSeqId());

        e.setProductId(c.getProductId());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setShipmentItemSeqId(c.getShipmentItemSeqId());
        e.setRejectionReasonId(c.getRejectionReasonId());
        e.setDamageStatusId(c.getDamageStatusId());
        e.setDamageReasonId(c.getDamageReasonId());
        e.setReceivedBy(c.getReceivedBy());
        e.setDatetimeReceived(c.getDatetimeReceived());
        e.setItemDescription(c.getItemDescription());
        e.setAcceptedQuantity(c.getAcceptedQuantity());
        e.setRejectedQuantity(c.getRejectedQuantity());
        e.setDamagedQuantity(c.getDamagedQuantity());
        e.setActive(c.getActive());
        e.setIsPropertyProductIdRemoved(c.getIsPropertyProductIdRemoved());
        e.setIsPropertyAttributeSetInstanceIdRemoved(c.getIsPropertyAttributeSetInstanceIdRemoved());
        e.setIsPropertyShipmentItemSeqIdRemoved(c.getIsPropertyShipmentItemSeqIdRemoved());
        e.setIsPropertyRejectionReasonIdRemoved(c.getIsPropertyRejectionReasonIdRemoved());
        e.setIsPropertyDamageStatusIdRemoved(c.getIsPropertyDamageStatusIdRemoved());
        e.setIsPropertyDamageReasonIdRemoved(c.getIsPropertyDamageReasonIdRemoved());
        e.setIsPropertyReceivedByRemoved(c.getIsPropertyReceivedByRemoved());
        e.setIsPropertyDatetimeReceivedRemoved(c.getIsPropertyDatetimeReceivedRemoved());
        e.setIsPropertyItemDescriptionRemoved(c.getIsPropertyItemDescriptionRemoved());
        e.setIsPropertyAcceptedQuantityRemoved(c.getIsPropertyAcceptedQuantityRemoved());
        e.setIsPropertyRejectedQuantityRemoved(c.getIsPropertyRejectedQuantityRemoved());
        e.setIsPropertyDamagedQuantityRemoved(c.getIsPropertyDamagedQuantityRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected void throwOnInconsistentCommands(ShipmentCommand command, ShipmentItemCommand innerCommand)
    {
        AbstractShipmentCommand properties = command instanceof AbstractShipmentCommand ? (AbstractShipmentCommand) command : null;
        AbstractShipmentItemCommand innerProperties = innerCommand instanceof AbstractShipmentItemCommand ? (AbstractShipmentItemCommand) innerCommand : null;
        if (properties == null || innerProperties == null) { return; }
        String outerShipmentIdName = "ShipmentId";
        String outerShipmentIdValue = properties.getShipmentId();
        String innerShipmentIdName = "ShipmentId";
        String innerShipmentIdValue = innerProperties.getShipmentId();
        if (innerShipmentIdValue == null) {
            innerProperties.setShipmentId(outerShipmentIdValue);
        }
        else if (innerShipmentIdValue != outerShipmentIdValue 
            && (innerShipmentIdValue == null || innerShipmentIdValue != null && !innerShipmentIdValue.equals(outerShipmentIdValue))) 
        {
            throw DomainError.named("inconsistentId", "Outer %1$s %2$s NOT equals inner %3$s %4$s", outerShipmentIdName, outerShipmentIdValue, innerShipmentIdName, innerShipmentIdValue);
        }
    }// END throwOnInconsistentCommands /////////////////////

    protected void throwOnInconsistentCommands(ShipmentCommand command, ShipmentReceiptCommand innerCommand)
    {
        AbstractShipmentCommand properties = command instanceof AbstractShipmentCommand ? (AbstractShipmentCommand) command : null;
        AbstractShipmentReceiptCommand innerProperties = innerCommand instanceof AbstractShipmentReceiptCommand ? (AbstractShipmentReceiptCommand) innerCommand : null;
        if (properties == null || innerProperties == null) { return; }
        String outerShipmentIdName = "ShipmentId";
        String outerShipmentIdValue = properties.getShipmentId();
        String innerShipmentIdName = "ShipmentId";
        String innerShipmentIdValue = innerProperties.getShipmentId();
        if (innerShipmentIdValue == null) {
            innerProperties.setShipmentId(outerShipmentIdValue);
        }
        else if (innerShipmentIdValue != outerShipmentIdValue 
            && (innerShipmentIdValue == null || innerShipmentIdValue != null && !innerShipmentIdValue.equals(outerShipmentIdValue))) 
        {
            throw DomainError.named("inconsistentId", "Outer %1$s %2$s NOT equals inner %3$s %4$s", outerShipmentIdName, outerShipmentIdValue, innerShipmentIdName, innerShipmentIdValue);
        }
    }// END throwOnInconsistentCommands /////////////////////


    ////////////////////////

    protected ShipmentStateEvent.ShipmentStateCreated newShipmentStateCreated(Long version, String commandId, String requesterId) {
        ShipmentStateEventId stateEventId = new ShipmentStateEventId(this.state.getShipmentId(), version);
        ShipmentStateEvent.ShipmentStateCreated e = newShipmentStateCreated(stateEventId);
        ((AbstractShipmentStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentStateEvent.ShipmentStateMergePatched newShipmentStateMergePatched(Long version, String commandId, String requesterId) {
        ShipmentStateEventId stateEventId = new ShipmentStateEventId(this.state.getShipmentId(), version);
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

    protected ShipmentItemStateEvent.ShipmentItemStateCreated newShipmentItemStateCreated(ShipmentItemStateEventId stateEventId) {
        return new AbstractShipmentItemStateEvent.SimpleShipmentItemStateCreated(stateEventId);
    }

    protected ShipmentItemStateEvent.ShipmentItemStateMergePatched newShipmentItemStateMergePatched(ShipmentItemStateEventId stateEventId) {
        return new AbstractShipmentItemStateEvent.SimpleShipmentItemStateMergePatched(stateEventId);
    }

    protected ShipmentReceiptStateEvent.ShipmentReceiptStateCreated newShipmentReceiptStateCreated(ShipmentReceiptStateEventId stateEventId) {
        return new AbstractShipmentReceiptStateEvent.SimpleShipmentReceiptStateCreated(stateEventId);
    }

    protected ShipmentReceiptStateEvent.ShipmentReceiptStateMergePatched newShipmentReceiptStateMergePatched(ShipmentReceiptStateEventId stateEventId) {
        return new AbstractShipmentReceiptStateEvent.SimpleShipmentReceiptStateMergePatched(stateEventId);
    }

    public static class SimpleShipmentAggregate extends AbstractShipmentAggregate
    {
        public SimpleShipmentAggregate(ShipmentState state) {
            super(state);
        }

        @Override
        public void _import(String primaryOrderId, String primaryReturnId, java.sql.Timestamp estimatedReadyDate, java.sql.Timestamp estimatedShipDate, java.sql.Timestamp estimatedArrivalDate, java.sql.Timestamp latestCancelDate, java.math.BigDecimal estimatedShipCost, String currencyUomId, String handlingInstructions, String originFacilityId, String destinationFacilityId, String partyIdTo, String partyIdFrom, java.math.BigDecimal additionalShippingCharge, String addtlShippingChargeDesc, Iterable<ImportingShipmentItem> shipmentItems, Long version, String commandId, String requesterId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void receiveItem(String shipmentItemSeqId, java.util.Map<String, Object> attributeSetInstance, String rejectionReasonId, String damageStatusId, String damageReasonId, java.math.BigDecimal acceptedQuantity, java.math.BigDecimal rejectedQuantity, java.math.BigDecimal damagedQuantity, String itemDescription, Long version, String commandId, String requesterId) {
            throw new UnsupportedOperationException();
        }

    }

}

