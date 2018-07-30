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
        ShipmentEvent e = map(c);
        apply(e);
    }

    public void mergePatch(ShipmentCommand.MergePatchShipment c)
    {
        ShipmentEvent e = map(c);
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

    protected ShipmentEvent map(ShipmentCommand.CreateShipment c) {
        ShipmentEventId stateEventId = new ShipmentEventId(c.getShipmentId(), c.getVersion());
        ShipmentEvent.ShipmentStateCreated e = newShipmentStateCreated(stateEventId);
        e.setShipmentTypeId(c.getShipmentTypeId());
        e.setStatusId(c.getStatusId());
        e.setPrimaryOrderId(c.getPrimaryOrderId());
        e.setPrimaryReturnId(c.getPrimaryReturnId());
        e.setPrimaryShipGroupSeqId(c.getPrimaryShipGroupSeqId());
        e.setPicklistBinId(c.getPicklistBinId());
        e.setBolNumber(c.getBolNumber());
        e.setSealNumber(c.getSealNumber());
        e.setVehicleId(c.getVehicleId());
        e.setPoNumber(c.getPoNumber());
        e.setCarrier(c.getCarrier());
        e.setDateShipped(c.getDateShipped());
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
        ((AbstractShipmentEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (ShipmentImageCommand.CreateShipmentImage innerCommand : c.getShipmentImages())
        {
            throwOnInconsistentCommands(c, innerCommand);
            ShipmentImageEvent.ShipmentImageStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addShipmentImageEvent(innerEvent);
        }

        for (ShipmentItemCommand.CreateShipmentItem innerCommand : c.getShipmentItems())
        {
            throwOnInconsistentCommands(c, innerCommand);
            ShipmentItemEvent.ShipmentItemStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addShipmentItemEvent(innerEvent);
        }

        for (ShipmentReceiptCommand.CreateShipmentReceipt innerCommand : c.getShipmentReceipts())
        {
            throwOnInconsistentCommands(c, innerCommand);
            ShipmentReceiptEvent.ShipmentReceiptStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addShipmentReceiptEvent(innerEvent);
        }

        for (ItemIssuanceCommand.CreateItemIssuance innerCommand : c.getItemIssuances())
        {
            throwOnInconsistentCommands(c, innerCommand);
            ItemIssuanceEvent.ItemIssuanceStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addItemIssuanceEvent(innerEvent);
        }

        return e;
    }

    protected ShipmentEvent map(ShipmentCommand.MergePatchShipment c) {
        ShipmentEventId stateEventId = new ShipmentEventId(c.getShipmentId(), c.getVersion());
        ShipmentEvent.ShipmentStateMergePatched e = newShipmentStateMergePatched(stateEventId);
        e.setShipmentTypeId(c.getShipmentTypeId());
        e.setStatusId(c.getStatusId());
        e.setPrimaryOrderId(c.getPrimaryOrderId());
        e.setPrimaryReturnId(c.getPrimaryReturnId());
        e.setPrimaryShipGroupSeqId(c.getPrimaryShipGroupSeqId());
        e.setPicklistBinId(c.getPicklistBinId());
        e.setBolNumber(c.getBolNumber());
        e.setSealNumber(c.getSealNumber());
        e.setVehicleId(c.getVehicleId());
        e.setPoNumber(c.getPoNumber());
        e.setCarrier(c.getCarrier());
        e.setDateShipped(c.getDateShipped());
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
        e.setIsPropertyPrimaryShipGroupSeqIdRemoved(c.getIsPropertyPrimaryShipGroupSeqIdRemoved());
        e.setIsPropertyPicklistBinIdRemoved(c.getIsPropertyPicklistBinIdRemoved());
        e.setIsPropertyBolNumberRemoved(c.getIsPropertyBolNumberRemoved());
        e.setIsPropertySealNumberRemoved(c.getIsPropertySealNumberRemoved());
        e.setIsPropertyVehicleIdRemoved(c.getIsPropertyVehicleIdRemoved());
        e.setIsPropertyPoNumberRemoved(c.getIsPropertyPoNumberRemoved());
        e.setIsPropertyCarrierRemoved(c.getIsPropertyCarrierRemoved());
        e.setIsPropertyDateShippedRemoved(c.getIsPropertyDateShippedRemoved());
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
        ((AbstractShipmentEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (ShipmentImageCommand innerCommand : c.getShipmentImageCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            ShipmentImageEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addShipmentImageEvent(innerEvent);
        }

        for (ShipmentItemCommand innerCommand : c.getShipmentItemCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            ShipmentItemEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addShipmentItemEvent(innerEvent);
        }

        for (ShipmentReceiptCommand innerCommand : c.getShipmentReceiptCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            ShipmentReceiptEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addShipmentReceiptEvent(innerEvent);
        }

        for (ItemIssuanceCommand innerCommand : c.getItemIssuanceCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            ItemIssuanceEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addItemIssuanceEvent(innerEvent);
        }

        return e;
    }


    protected ShipmentImageEvent map(ShipmentImageCommand c, ShipmentCommand outerCommand, Long version, ShipmentState outerState)
    {
        ShipmentImageCommand.CreateShipmentImage create = (c.getCommandType().equals(CommandType.CREATE)) ? ((ShipmentImageCommand.CreateShipmentImage)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        ShipmentImageCommand.MergePatchShipmentImage merge = (c.getCommandType().equals(CommandType.MERGE_PATCH)) ? ((ShipmentImageCommand.MergePatchShipmentImage)c) : null;
        if(merge != null)
        {
            return mapMergePatch(merge, outerCommand, version, outerState);
        }

        ShipmentImageCommand.RemoveShipmentImage remove = (c.getCommandType().equals(CommandType.REMOVE)) ? ((ShipmentImageCommand.RemoveShipmentImage)c) : null;
        if (remove != null)
        {
            return mapRemove(remove, outerCommand, version);
        }
        throw new UnsupportedOperationException();
    }

    protected ShipmentImageEvent.ShipmentImageStateCreated mapCreate(ShipmentImageCommand.CreateShipmentImage c, ShipmentCommand outerCommand, Long version, ShipmentState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        ShipmentImageEventId stateEventId = new ShipmentImageEventId(c.getShipmentId(), c.getSequenceId(), version);
        ShipmentImageEvent.ShipmentImageStateCreated e = newShipmentImageStateCreated(stateEventId);
        ShipmentImageState s = outerState.getShipmentImages().get(c.getSequenceId());

        e.setUrl(c.getUrl());
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected ShipmentImageEvent.ShipmentImageStateMergePatched mapMergePatch(ShipmentImageCommand.MergePatchShipmentImage c, ShipmentCommand outerCommand, Long version, ShipmentState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        ShipmentImageEventId stateEventId = new ShipmentImageEventId(c.getShipmentId(), c.getSequenceId(), version);
        ShipmentImageEvent.ShipmentImageStateMergePatched e = newShipmentImageStateMergePatched(stateEventId);
        ShipmentImageState s = outerState.getShipmentImages().get(c.getSequenceId());

        e.setUrl(c.getUrl());
        e.setActive(c.getActive());
        e.setIsPropertyUrlRemoved(c.getIsPropertyUrlRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected ShipmentImageEvent.ShipmentImageStateRemoved mapRemove(ShipmentImageCommand.RemoveShipmentImage c, ShipmentCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        ShipmentImageEventId stateEventId = new ShipmentImageEventId(c.getShipmentId(), c.getSequenceId(), version);
        ShipmentImageEvent.ShipmentImageStateRemoved e = newShipmentImageStateRemoved(stateEventId);

        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        return e;

    }// END map(IRemove... ////////////////////////////


    protected ShipmentItemEvent map(ShipmentItemCommand c, ShipmentCommand outerCommand, Long version, ShipmentState outerState)
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

    protected ShipmentItemEvent.ShipmentItemStateCreated mapCreate(ShipmentItemCommand.CreateShipmentItem c, ShipmentCommand outerCommand, Long version, ShipmentState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        ShipmentItemEventId stateEventId = new ShipmentItemEventId(c.getShipmentId(), c.getShipmentItemSeqId(), version);
        ShipmentItemEvent.ShipmentItemStateCreated e = newShipmentItemStateCreated(stateEventId);
        ShipmentItemState s = outerState.getShipmentItems().get(c.getShipmentItemSeqId());

        e.setProductId(c.getProductId());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setQuantity(c.getQuantity());
        e.setShipmentContentDescription(c.getShipmentContentDescription());
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected ShipmentItemEvent.ShipmentItemStateMergePatched mapMergePatch(ShipmentItemCommand.MergePatchShipmentItem c, ShipmentCommand outerCommand, Long version, ShipmentState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        ShipmentItemEventId stateEventId = new ShipmentItemEventId(c.getShipmentId(), c.getShipmentItemSeqId(), version);
        ShipmentItemEvent.ShipmentItemStateMergePatched e = newShipmentItemStateMergePatched(stateEventId);
        ShipmentItemState s = outerState.getShipmentItems().get(c.getShipmentItemSeqId());

        e.setProductId(c.getProductId());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setQuantity(c.getQuantity());
        e.setShipmentContentDescription(c.getShipmentContentDescription());
        e.setActive(c.getActive());
        e.setIsPropertyProductIdRemoved(c.getIsPropertyProductIdRemoved());
        e.setIsPropertyAttributeSetInstanceIdRemoved(c.getIsPropertyAttributeSetInstanceIdRemoved());
        e.setIsPropertyQuantityRemoved(c.getIsPropertyQuantityRemoved());
        e.setIsPropertyShipmentContentDescriptionRemoved(c.getIsPropertyShipmentContentDescriptionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////


    protected ShipmentReceiptEvent map(ShipmentReceiptCommand c, ShipmentCommand outerCommand, Long version, ShipmentState outerState)
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

    protected ShipmentReceiptEvent.ShipmentReceiptStateCreated mapCreate(ShipmentReceiptCommand.CreateShipmentReceipt c, ShipmentCommand outerCommand, Long version, ShipmentState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        ShipmentReceiptEventId stateEventId = new ShipmentReceiptEventId(c.getShipmentId(), c.getReceiptSeqId(), version);
        ShipmentReceiptEvent.ShipmentReceiptStateCreated e = newShipmentReceiptStateCreated(stateEventId);
        ShipmentReceiptState s = outerState.getShipmentReceipts().get(c.getReceiptSeqId());

        e.setProductId(c.getProductId());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setLocatorId(c.getLocatorId());
        e.setShipmentItemSeqId(c.getShipmentItemSeqId());
        e.setShipmentPackageSeqId(c.getShipmentPackageSeqId());
        e.setOrderId(c.getOrderId());
        e.setOrderItemSeqId(c.getOrderItemSeqId());
        e.setReturnId(c.getReturnId());
        e.setReturnItemSeqId(c.getReturnItemSeqId());
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

        for (ShipmentReceiptImageCommand.CreateShipmentReceiptImage innerCommand : c.getShipmentReceiptImages())
        {
            throwOnInconsistentCommands(c, innerCommand);

            ShipmentReceiptImageEvent.ShipmentReceiptImageStateCreated innerEvent = mapCreate(innerCommand, c, version, s);
            e.addShipmentReceiptImageEvent(innerEvent);
        }

        return e;

    }// END map(ICreate... ////////////////////////////

    protected ShipmentReceiptEvent.ShipmentReceiptStateMergePatched mapMergePatch(ShipmentReceiptCommand.MergePatchShipmentReceipt c, ShipmentCommand outerCommand, Long version, ShipmentState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        ShipmentReceiptEventId stateEventId = new ShipmentReceiptEventId(c.getShipmentId(), c.getReceiptSeqId(), version);
        ShipmentReceiptEvent.ShipmentReceiptStateMergePatched e = newShipmentReceiptStateMergePatched(stateEventId);
        ShipmentReceiptState s = outerState.getShipmentReceipts().get(c.getReceiptSeqId());

        e.setProductId(c.getProductId());
        e.setAttributeSetInstanceId(c.getAttributeSetInstanceId());
        e.setLocatorId(c.getLocatorId());
        e.setShipmentItemSeqId(c.getShipmentItemSeqId());
        e.setShipmentPackageSeqId(c.getShipmentPackageSeqId());
        e.setOrderId(c.getOrderId());
        e.setOrderItemSeqId(c.getOrderItemSeqId());
        e.setReturnId(c.getReturnId());
        e.setReturnItemSeqId(c.getReturnItemSeqId());
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
        e.setIsPropertyLocatorIdRemoved(c.getIsPropertyLocatorIdRemoved());
        e.setIsPropertyShipmentItemSeqIdRemoved(c.getIsPropertyShipmentItemSeqIdRemoved());
        e.setIsPropertyShipmentPackageSeqIdRemoved(c.getIsPropertyShipmentPackageSeqIdRemoved());
        e.setIsPropertyOrderIdRemoved(c.getIsPropertyOrderIdRemoved());
        e.setIsPropertyOrderItemSeqIdRemoved(c.getIsPropertyOrderItemSeqIdRemoved());
        e.setIsPropertyReturnIdRemoved(c.getIsPropertyReturnIdRemoved());
        e.setIsPropertyReturnItemSeqIdRemoved(c.getIsPropertyReturnItemSeqIdRemoved());
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

        for (ShipmentReceiptImageCommand innerCommand : c.getShipmentReceiptImageCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);

            ShipmentReceiptImageEvent innerEvent = map(innerCommand, c, version, s);
            e.addShipmentReceiptImageEvent(innerEvent);
        }

        return e;

    }// END map(IMergePatch... ////////////////////////////


    protected ShipmentReceiptImageEvent map(ShipmentReceiptImageCommand c, ShipmentReceiptCommand outerCommand, Long version, ShipmentReceiptState outerState)
    {
        ShipmentReceiptImageCommand.CreateShipmentReceiptImage create = (c.getCommandType().equals(CommandType.CREATE)) ? ((ShipmentReceiptImageCommand.CreateShipmentReceiptImage)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        ShipmentReceiptImageCommand.MergePatchShipmentReceiptImage merge = (c.getCommandType().equals(CommandType.MERGE_PATCH)) ? ((ShipmentReceiptImageCommand.MergePatchShipmentReceiptImage)c) : null;
        if(merge != null)
        {
            return mapMergePatch(merge, outerCommand, version, outerState);
        }

        ShipmentReceiptImageCommand.RemoveShipmentReceiptImage remove = (c.getCommandType().equals(CommandType.REMOVE)) ? ((ShipmentReceiptImageCommand.RemoveShipmentReceiptImage)c) : null;
        if (remove != null)
        {
            return mapRemove(remove, outerCommand, version);
        }
        throw new UnsupportedOperationException();
    }

    protected ShipmentReceiptImageEvent.ShipmentReceiptImageStateCreated mapCreate(ShipmentReceiptImageCommand.CreateShipmentReceiptImage c, ShipmentReceiptCommand outerCommand, Long version, ShipmentReceiptState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        ShipmentReceiptImageEventId stateEventId = new ShipmentReceiptImageEventId(c.getShipmentId(), c.getShipmentReceiptReceiptSeqId(), c.getSequenceId(), version);
        ShipmentReceiptImageEvent.ShipmentReceiptImageStateCreated e = newShipmentReceiptImageStateCreated(stateEventId);
        ShipmentReceiptImageState s = outerState.getShipmentReceiptImages().get(c.getSequenceId());

        e.setUrl(c.getUrl());
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected ShipmentReceiptImageEvent.ShipmentReceiptImageStateMergePatched mapMergePatch(ShipmentReceiptImageCommand.MergePatchShipmentReceiptImage c, ShipmentReceiptCommand outerCommand, Long version, ShipmentReceiptState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        ShipmentReceiptImageEventId stateEventId = new ShipmentReceiptImageEventId(c.getShipmentId(), c.getShipmentReceiptReceiptSeqId(), c.getSequenceId(), version);
        ShipmentReceiptImageEvent.ShipmentReceiptImageStateMergePatched e = newShipmentReceiptImageStateMergePatched(stateEventId);
        ShipmentReceiptImageState s = outerState.getShipmentReceiptImages().get(c.getSequenceId());

        e.setUrl(c.getUrl());
        e.setActive(c.getActive());
        e.setIsPropertyUrlRemoved(c.getIsPropertyUrlRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected ShipmentReceiptImageEvent.ShipmentReceiptImageStateRemoved mapRemove(ShipmentReceiptImageCommand.RemoveShipmentReceiptImage c, ShipmentReceiptCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        ShipmentReceiptImageEventId stateEventId = new ShipmentReceiptImageEventId(c.getShipmentId(), c.getShipmentReceiptReceiptSeqId(), c.getSequenceId(), version);
        ShipmentReceiptImageEvent.ShipmentReceiptImageStateRemoved e = newShipmentReceiptImageStateRemoved(stateEventId);

        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        return e;

    }// END map(IRemove... ////////////////////////////


    protected ItemIssuanceEvent map(ItemIssuanceCommand c, ShipmentCommand outerCommand, Long version, ShipmentState outerState)
    {
        ItemIssuanceCommand.CreateItemIssuance create = (c.getCommandType().equals(CommandType.CREATE)) ? ((ItemIssuanceCommand.CreateItemIssuance)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        ItemIssuanceCommand.MergePatchItemIssuance merge = (c.getCommandType().equals(CommandType.MERGE_PATCH)) ? ((ItemIssuanceCommand.MergePatchItemIssuance)c) : null;
        if(merge != null)
        {
            return mapMergePatch(merge, outerCommand, version, outerState);
        }

        ItemIssuanceCommand.RemoveItemIssuance remove = (c.getCommandType().equals(CommandType.REMOVE)) ? ((ItemIssuanceCommand.RemoveItemIssuance)c) : null;
        if (remove != null)
        {
            return mapRemove(remove, outerCommand, version);
        }
        throw new UnsupportedOperationException();
    }

    protected ItemIssuanceEvent.ItemIssuanceStateCreated mapCreate(ItemIssuanceCommand.CreateItemIssuance c, ShipmentCommand outerCommand, Long version, ShipmentState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        ItemIssuanceEventId stateEventId = new ItemIssuanceEventId(c.getShipmentId(), c.getItemIssuanceSeqId(), version);
        ItemIssuanceEvent.ItemIssuanceStateCreated e = newItemIssuanceStateCreated(stateEventId);
        ItemIssuanceState s = outerState.getItemIssuances().get(c.getItemIssuanceSeqId());

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
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected ItemIssuanceEvent.ItemIssuanceStateMergePatched mapMergePatch(ItemIssuanceCommand.MergePatchItemIssuance c, ShipmentCommand outerCommand, Long version, ShipmentState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        ItemIssuanceEventId stateEventId = new ItemIssuanceEventId(c.getShipmentId(), c.getItemIssuanceSeqId(), version);
        ItemIssuanceEvent.ItemIssuanceStateMergePatched e = newItemIssuanceStateMergePatched(stateEventId);
        ItemIssuanceState s = outerState.getItemIssuances().get(c.getItemIssuanceSeqId());

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
        e.setActive(c.getActive());
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
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected ItemIssuanceEvent.ItemIssuanceStateRemoved mapRemove(ItemIssuanceCommand.RemoveItemIssuance c, ShipmentCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        ItemIssuanceEventId stateEventId = new ItemIssuanceEventId(c.getShipmentId(), c.getItemIssuanceSeqId(), version);
        ItemIssuanceEvent.ItemIssuanceStateRemoved e = newItemIssuanceStateRemoved(stateEventId);

        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        return e;

    }// END map(IRemove... ////////////////////////////

    protected void throwOnInconsistentCommands(ShipmentCommand command, ShipmentImageCommand innerCommand)
    {
        AbstractShipmentCommand properties = command instanceof AbstractShipmentCommand ? (AbstractShipmentCommand) command : null;
        AbstractShipmentImageCommand innerProperties = innerCommand instanceof AbstractShipmentImageCommand ? (AbstractShipmentImageCommand) innerCommand : null;
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

    protected void throwOnInconsistentCommands(ShipmentReceiptCommand command, ShipmentReceiptImageCommand innerCommand)
    {
        AbstractShipmentReceiptCommand properties = command instanceof AbstractShipmentReceiptCommand ? (AbstractShipmentReceiptCommand) command : null;
        AbstractShipmentReceiptImageCommand innerProperties = innerCommand instanceof AbstractShipmentReceiptImageCommand ? (AbstractShipmentReceiptImageCommand) innerCommand : null;
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
        String outerReceiptSeqIdName = "ReceiptSeqId";
        String outerReceiptSeqIdValue = properties.getReceiptSeqId();
        String innerShipmentReceiptReceiptSeqIdName = "ShipmentReceiptReceiptSeqId";
        String innerShipmentReceiptReceiptSeqIdValue = innerProperties.getShipmentReceiptReceiptSeqId();
        if (innerShipmentReceiptReceiptSeqIdValue == null) {
            innerProperties.setShipmentReceiptReceiptSeqId(outerReceiptSeqIdValue);
        }
        else if (innerShipmentReceiptReceiptSeqIdValue != outerReceiptSeqIdValue 
            && (innerShipmentReceiptReceiptSeqIdValue == null || innerShipmentReceiptReceiptSeqIdValue != null && !innerShipmentReceiptReceiptSeqIdValue.equals(outerReceiptSeqIdValue))) 
        {
            throw DomainError.named("inconsistentId", "Outer %1$s %2$s NOT equals inner %3$s %4$s", outerReceiptSeqIdName, outerReceiptSeqIdValue, innerShipmentReceiptReceiptSeqIdName, innerShipmentReceiptReceiptSeqIdValue);
        }
    }// END throwOnInconsistentCommands /////////////////////

    protected void throwOnInconsistentCommands(ShipmentCommand command, ItemIssuanceCommand innerCommand)
    {
        AbstractShipmentCommand properties = command instanceof AbstractShipmentCommand ? (AbstractShipmentCommand) command : null;
        AbstractItemIssuanceCommand innerProperties = innerCommand instanceof AbstractItemIssuanceCommand ? (AbstractItemIssuanceCommand) innerCommand : null;
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

    protected ShipmentEvent.ShipmentStateCreated newShipmentStateCreated(Long version, String commandId, String requesterId) {
        ShipmentEventId stateEventId = new ShipmentEventId(this.state.getShipmentId(), version);
        ShipmentEvent.ShipmentStateCreated e = newShipmentStateCreated(stateEventId);
        ((AbstractShipmentEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentEvent.ShipmentStateMergePatched newShipmentStateMergePatched(Long version, String commandId, String requesterId) {
        ShipmentEventId stateEventId = new ShipmentEventId(this.state.getShipmentId(), version);
        ShipmentEvent.ShipmentStateMergePatched e = newShipmentStateMergePatched(stateEventId);
        ((AbstractShipmentEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ShipmentEvent.ShipmentStateCreated newShipmentStateCreated(ShipmentEventId stateEventId) {
        return new AbstractShipmentEvent.SimpleShipmentStateCreated(stateEventId);
    }

    protected ShipmentEvent.ShipmentStateMergePatched newShipmentStateMergePatched(ShipmentEventId stateEventId) {
        return new AbstractShipmentEvent.SimpleShipmentStateMergePatched(stateEventId);
    }

    protected ShipmentImageEvent.ShipmentImageStateCreated newShipmentImageStateCreated(ShipmentImageEventId stateEventId) {
        return new AbstractShipmentImageEvent.SimpleShipmentImageStateCreated(stateEventId);
    }

    protected ShipmentImageEvent.ShipmentImageStateMergePatched newShipmentImageStateMergePatched(ShipmentImageEventId stateEventId) {
        return new AbstractShipmentImageEvent.SimpleShipmentImageStateMergePatched(stateEventId);
    }

    protected ShipmentImageEvent.ShipmentImageStateRemoved newShipmentImageStateRemoved(ShipmentImageEventId stateEventId)
    {
        return new AbstractShipmentImageEvent.SimpleShipmentImageStateRemoved(stateEventId);
    }

    protected ShipmentItemEvent.ShipmentItemStateCreated newShipmentItemStateCreated(ShipmentItemEventId stateEventId) {
        return new AbstractShipmentItemEvent.SimpleShipmentItemStateCreated(stateEventId);
    }

    protected ShipmentItemEvent.ShipmentItemStateMergePatched newShipmentItemStateMergePatched(ShipmentItemEventId stateEventId) {
        return new AbstractShipmentItemEvent.SimpleShipmentItemStateMergePatched(stateEventId);
    }

    protected ShipmentReceiptEvent.ShipmentReceiptStateCreated newShipmentReceiptStateCreated(ShipmentReceiptEventId stateEventId) {
        return new AbstractShipmentReceiptEvent.SimpleShipmentReceiptStateCreated(stateEventId);
    }

    protected ShipmentReceiptEvent.ShipmentReceiptStateMergePatched newShipmentReceiptStateMergePatched(ShipmentReceiptEventId stateEventId) {
        return new AbstractShipmentReceiptEvent.SimpleShipmentReceiptStateMergePatched(stateEventId);
    }

    protected ShipmentReceiptImageEvent.ShipmentReceiptImageStateCreated newShipmentReceiptImageStateCreated(ShipmentReceiptImageEventId stateEventId) {
        return new AbstractShipmentReceiptImageEvent.SimpleShipmentReceiptImageStateCreated(stateEventId);
    }

    protected ShipmentReceiptImageEvent.ShipmentReceiptImageStateMergePatched newShipmentReceiptImageStateMergePatched(ShipmentReceiptImageEventId stateEventId) {
        return new AbstractShipmentReceiptImageEvent.SimpleShipmentReceiptImageStateMergePatched(stateEventId);
    }

    protected ShipmentReceiptImageEvent.ShipmentReceiptImageStateRemoved newShipmentReceiptImageStateRemoved(ShipmentReceiptImageEventId stateEventId)
    {
        return new AbstractShipmentReceiptImageEvent.SimpleShipmentReceiptImageStateRemoved(stateEventId);
    }

    protected ItemIssuanceEvent.ItemIssuanceStateCreated newItemIssuanceStateCreated(ItemIssuanceEventId stateEventId) {
        return new AbstractItemIssuanceEvent.SimpleItemIssuanceStateCreated(stateEventId);
    }

    protected ItemIssuanceEvent.ItemIssuanceStateMergePatched newItemIssuanceStateMergePatched(ItemIssuanceEventId stateEventId) {
        return new AbstractItemIssuanceEvent.SimpleItemIssuanceStateMergePatched(stateEventId);
    }

    protected ItemIssuanceEvent.ItemIssuanceStateRemoved newItemIssuanceStateRemoved(ItemIssuanceEventId stateEventId)
    {
        return new AbstractItemIssuanceEvent.SimpleItemIssuanceStateRemoved(stateEventId);
    }

    public static class SimpleShipmentAggregate extends AbstractShipmentAggregate
    {
        public SimpleShipmentAggregate(ShipmentState state) {
            super(state);
        }

        @Override
        public void _import(String shipmentTypeId, String primaryOrderId, String primaryReturnId, String bolNumber, String vehicleId, String sealNumber, String poNumber, String carrier, java.sql.Timestamp dateShipped, java.sql.Timestamp estimatedReadyDate, java.sql.Timestamp estimatedShipDate, java.sql.Timestamp estimatedArrivalDate, java.sql.Timestamp latestCancelDate, java.math.BigDecimal estimatedShipCost, String currencyUomId, String handlingInstructions, String originFacilityId, String destinationFacilityId, String partyIdTo, String partyIdFrom, java.math.BigDecimal additionalShippingCharge, String addtlShippingChargeDesc, Iterable<ImportingShipmentItem> shipmentItems, Long version, String commandId, String requesterId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void ship(Long version, String commandId, String requesterId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void receiveItem(String shipmentItemSeqId, java.util.Map<String, Object> attributeSetInstance, String rejectionReasonId, String damageStatusId, String damageReasonId, java.math.BigDecimal acceptedQuantity, java.math.BigDecimal rejectedQuantity, java.math.BigDecimal damagedQuantity, String itemDescription, Long version, String commandId, String requesterId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void confirmAllItemsReceived(Long version, String commandId, String requesterId) {
            throw new UnsupportedOperationException();
        }

    }

}

