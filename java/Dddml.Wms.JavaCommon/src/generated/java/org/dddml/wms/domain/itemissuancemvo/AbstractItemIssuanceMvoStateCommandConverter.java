package org.dddml.wms.domain.itemissuancemvo;

import java.util.*;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractItemIssuanceMvoStateCommandConverter<TCreateItemIssuanceMvo extends ItemIssuanceMvoCommand.CreateItemIssuanceMvo, TMergePatchItemIssuanceMvo extends ItemIssuanceMvoCommand.MergePatchItemIssuanceMvo, TDeleteItemIssuanceMvo extends ItemIssuanceMvoCommand.DeleteItemIssuanceMvo>
{
    public ItemIssuanceMvoCommand toCreateOrMergePatchItemIssuanceMvo(ItemIssuanceMvoState state)
    {
        //where TCreateItemIssuanceMvo : ICreateItemIssuanceMvo, new()
        //where TMergePatchItemIssuanceMvo : IMergePatchItemIssuanceMvo, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateItemIssuanceMvo(state);
        }
        else 
        {
            return toMergePatchItemIssuanceMvo(state);
        }
    }

    public TDeleteItemIssuanceMvo toDeleteItemIssuanceMvo(ItemIssuanceMvoState state) //where TDeleteItemIssuanceMvo : IDeleteItemIssuanceMvo, new()
    {
        TDeleteItemIssuanceMvo cmd = newDeleteItemIssuanceMvo();
        cmd.setShipmentItemIssuanceId(state.getShipmentItemIssuanceId());
        cmd.setShipmentVersion(state.getShipmentVersion());

        return cmd;
    }

    public TMergePatchItemIssuanceMvo toMergePatchItemIssuanceMvo(ItemIssuanceMvoState state) //where TMergePatchItemIssuanceMvo : IMergePatchItemIssuanceMvo, new()
    {
        TMergePatchItemIssuanceMvo cmd = newMergePatchItemIssuanceMvo();

        cmd.setShipmentVersion(state.getShipmentVersion());

        cmd.setShipmentItemIssuanceId(state.getShipmentItemIssuanceId());
        cmd.setOrderId(state.getOrderId());
        cmd.setOrderItemSeqId(state.getOrderItemSeqId());
        cmd.setShipGroupSeqId(state.getShipGroupSeqId());
        cmd.setProductId(state.getProductId());
        cmd.setLocatorId(state.getLocatorId());
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setShipmentItemSeqId(state.getShipmentItemSeqId());
        cmd.setFixedAssetId(state.getFixedAssetId());
        cmd.setMaintHistSeqId(state.getMaintHistSeqId());
        cmd.setIssuedDateTime(state.getIssuedDateTime());
        cmd.setIssuedByUserLoginId(state.getIssuedByUserLoginId());
        cmd.setQuantity(state.getQuantity());
        cmd.setCancelQuantity(state.getCancelQuantity());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setShipmentShipmentTypeId(state.getShipmentShipmentTypeId());
        cmd.setShipmentStatusId(state.getShipmentStatusId());
        cmd.setShipmentPrimaryOrderId(state.getShipmentPrimaryOrderId());
        cmd.setShipmentPrimaryReturnId(state.getShipmentPrimaryReturnId());
        cmd.setShipmentPrimaryShipGroupSeqId(state.getShipmentPrimaryShipGroupSeqId());
        cmd.setShipmentPicklistBinId(state.getShipmentPicklistBinId());
        cmd.setShipmentEstimatedReadyDate(state.getShipmentEstimatedReadyDate());
        cmd.setShipmentEstimatedShipDate(state.getShipmentEstimatedShipDate());
        cmd.setShipmentEstimatedShipWorkEffId(state.getShipmentEstimatedShipWorkEffId());
        cmd.setShipmentEstimatedArrivalDate(state.getShipmentEstimatedArrivalDate());
        cmd.setShipmentEstimatedArrivalWorkEffId(state.getShipmentEstimatedArrivalWorkEffId());
        cmd.setShipmentLatestCancelDate(state.getShipmentLatestCancelDate());
        cmd.setShipmentEstimatedShipCost(state.getShipmentEstimatedShipCost());
        cmd.setShipmentCurrencyUomId(state.getShipmentCurrencyUomId());
        cmd.setShipmentHandlingInstructions(state.getShipmentHandlingInstructions());
        cmd.setShipmentOriginFacilityId(state.getShipmentOriginFacilityId());
        cmd.setShipmentDestinationFacilityId(state.getShipmentDestinationFacilityId());
        cmd.setShipmentOriginContactMechId(state.getShipmentOriginContactMechId());
        cmd.setShipmentOriginTelecomNumberId(state.getShipmentOriginTelecomNumberId());
        cmd.setShipmentDestinationContactMechId(state.getShipmentDestinationContactMechId());
        cmd.setShipmentDestinationTelecomNumberId(state.getShipmentDestinationTelecomNumberId());
        cmd.setShipmentPartyIdTo(state.getShipmentPartyIdTo());
        cmd.setShipmentPartyIdFrom(state.getShipmentPartyIdFrom());
        cmd.setShipmentAdditionalShippingCharge(state.getShipmentAdditionalShippingCharge());
        cmd.setShipmentAddtlShippingChargeDesc(state.getShipmentAddtlShippingChargeDesc());
        cmd.setShipmentCreatedBy(state.getShipmentCreatedBy());
        cmd.setShipmentCreatedAt(state.getShipmentCreatedAt());
        cmd.setShipmentUpdatedBy(state.getShipmentUpdatedBy());
        cmd.setShipmentUpdatedAt(state.getShipmentUpdatedAt());
        cmd.setShipmentActive(state.getShipmentActive());
            
        if (state.getOrderId() == null) { cmd.setIsPropertyOrderIdRemoved(true); }
        if (state.getOrderItemSeqId() == null) { cmd.setIsPropertyOrderItemSeqIdRemoved(true); }
        if (state.getShipGroupSeqId() == null) { cmd.setIsPropertyShipGroupSeqIdRemoved(true); }
        if (state.getProductId() == null) { cmd.setIsPropertyProductIdRemoved(true); }
        if (state.getLocatorId() == null) { cmd.setIsPropertyLocatorIdRemoved(true); }
        if (state.getAttributeSetInstanceId() == null) { cmd.setIsPropertyAttributeSetInstanceIdRemoved(true); }
        if (state.getShipmentItemSeqId() == null) { cmd.setIsPropertyShipmentItemSeqIdRemoved(true); }
        if (state.getFixedAssetId() == null) { cmd.setIsPropertyFixedAssetIdRemoved(true); }
        if (state.getMaintHistSeqId() == null) { cmd.setIsPropertyMaintHistSeqIdRemoved(true); }
        if (state.getIssuedDateTime() == null) { cmd.setIsPropertyIssuedDateTimeRemoved(true); }
        if (state.getIssuedByUserLoginId() == null) { cmd.setIsPropertyIssuedByUserLoginIdRemoved(true); }
        if (state.getQuantity() == null) { cmd.setIsPropertyQuantityRemoved(true); }
        if (state.getCancelQuantity() == null) { cmd.setIsPropertyCancelQuantityRemoved(true); }
        if (state.getVersion() == null) { cmd.setIsPropertyVersionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        if (state.getShipmentShipmentTypeId() == null) { cmd.setIsPropertyShipmentShipmentTypeIdRemoved(true); }
        if (state.getShipmentStatusId() == null) { cmd.setIsPropertyShipmentStatusIdRemoved(true); }
        if (state.getShipmentPrimaryOrderId() == null) { cmd.setIsPropertyShipmentPrimaryOrderIdRemoved(true); }
        if (state.getShipmentPrimaryReturnId() == null) { cmd.setIsPropertyShipmentPrimaryReturnIdRemoved(true); }
        if (state.getShipmentPrimaryShipGroupSeqId() == null) { cmd.setIsPropertyShipmentPrimaryShipGroupSeqIdRemoved(true); }
        if (state.getShipmentPicklistBinId() == null) { cmd.setIsPropertyShipmentPicklistBinIdRemoved(true); }
        if (state.getShipmentEstimatedReadyDate() == null) { cmd.setIsPropertyShipmentEstimatedReadyDateRemoved(true); }
        if (state.getShipmentEstimatedShipDate() == null) { cmd.setIsPropertyShipmentEstimatedShipDateRemoved(true); }
        if (state.getShipmentEstimatedShipWorkEffId() == null) { cmd.setIsPropertyShipmentEstimatedShipWorkEffIdRemoved(true); }
        if (state.getShipmentEstimatedArrivalDate() == null) { cmd.setIsPropertyShipmentEstimatedArrivalDateRemoved(true); }
        if (state.getShipmentEstimatedArrivalWorkEffId() == null) { cmd.setIsPropertyShipmentEstimatedArrivalWorkEffIdRemoved(true); }
        if (state.getShipmentLatestCancelDate() == null) { cmd.setIsPropertyShipmentLatestCancelDateRemoved(true); }
        if (state.getShipmentEstimatedShipCost() == null) { cmd.setIsPropertyShipmentEstimatedShipCostRemoved(true); }
        if (state.getShipmentCurrencyUomId() == null) { cmd.setIsPropertyShipmentCurrencyUomIdRemoved(true); }
        if (state.getShipmentHandlingInstructions() == null) { cmd.setIsPropertyShipmentHandlingInstructionsRemoved(true); }
        if (state.getShipmentOriginFacilityId() == null) { cmd.setIsPropertyShipmentOriginFacilityIdRemoved(true); }
        if (state.getShipmentDestinationFacilityId() == null) { cmd.setIsPropertyShipmentDestinationFacilityIdRemoved(true); }
        if (state.getShipmentOriginContactMechId() == null) { cmd.setIsPropertyShipmentOriginContactMechIdRemoved(true); }
        if (state.getShipmentOriginTelecomNumberId() == null) { cmd.setIsPropertyShipmentOriginTelecomNumberIdRemoved(true); }
        if (state.getShipmentDestinationContactMechId() == null) { cmd.setIsPropertyShipmentDestinationContactMechIdRemoved(true); }
        if (state.getShipmentDestinationTelecomNumberId() == null) { cmd.setIsPropertyShipmentDestinationTelecomNumberIdRemoved(true); }
        if (state.getShipmentPartyIdTo() == null) { cmd.setIsPropertyShipmentPartyIdToRemoved(true); }
        if (state.getShipmentPartyIdFrom() == null) { cmd.setIsPropertyShipmentPartyIdFromRemoved(true); }
        if (state.getShipmentAdditionalShippingCharge() == null) { cmd.setIsPropertyShipmentAdditionalShippingChargeRemoved(true); }
        if (state.getShipmentAddtlShippingChargeDesc() == null) { cmd.setIsPropertyShipmentAddtlShippingChargeDescRemoved(true); }
        if (state.getShipmentCreatedBy() == null) { cmd.setIsPropertyShipmentCreatedByRemoved(true); }
        if (state.getShipmentCreatedAt() == null) { cmd.setIsPropertyShipmentCreatedAtRemoved(true); }
        if (state.getShipmentUpdatedBy() == null) { cmd.setIsPropertyShipmentUpdatedByRemoved(true); }
        if (state.getShipmentUpdatedAt() == null) { cmd.setIsPropertyShipmentUpdatedAtRemoved(true); }
        if (state.getShipmentActive() == null) { cmd.setIsPropertyShipmentActiveRemoved(true); }
        return cmd;
    }

    public TCreateItemIssuanceMvo toCreateItemIssuanceMvo(ItemIssuanceMvoState state) //where TCreateItemIssuanceMvo : ICreateItemIssuanceMvo, new()
    {
        TCreateItemIssuanceMvo cmd = newCreateItemIssuanceMvo();

        cmd.setShipmentVersion(state.getShipmentVersion());
        cmd.setShipmentItemIssuanceId(state.getShipmentItemIssuanceId());
        cmd.setOrderId(state.getOrderId());
        cmd.setOrderItemSeqId(state.getOrderItemSeqId());
        cmd.setShipGroupSeqId(state.getShipGroupSeqId());
        cmd.setProductId(state.getProductId());
        cmd.setLocatorId(state.getLocatorId());
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setShipmentItemSeqId(state.getShipmentItemSeqId());
        cmd.setFixedAssetId(state.getFixedAssetId());
        cmd.setMaintHistSeqId(state.getMaintHistSeqId());
        cmd.setIssuedDateTime(state.getIssuedDateTime());
        cmd.setIssuedByUserLoginId(state.getIssuedByUserLoginId());
        cmd.setQuantity(state.getQuantity());
        cmd.setCancelQuantity(state.getCancelQuantity());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setShipmentShipmentTypeId(state.getShipmentShipmentTypeId());
        cmd.setShipmentStatusId(state.getShipmentStatusId());
        cmd.setShipmentPrimaryOrderId(state.getShipmentPrimaryOrderId());
        cmd.setShipmentPrimaryReturnId(state.getShipmentPrimaryReturnId());
        cmd.setShipmentPrimaryShipGroupSeqId(state.getShipmentPrimaryShipGroupSeqId());
        cmd.setShipmentPicklistBinId(state.getShipmentPicklistBinId());
        cmd.setShipmentEstimatedReadyDate(state.getShipmentEstimatedReadyDate());
        cmd.setShipmentEstimatedShipDate(state.getShipmentEstimatedShipDate());
        cmd.setShipmentEstimatedShipWorkEffId(state.getShipmentEstimatedShipWorkEffId());
        cmd.setShipmentEstimatedArrivalDate(state.getShipmentEstimatedArrivalDate());
        cmd.setShipmentEstimatedArrivalWorkEffId(state.getShipmentEstimatedArrivalWorkEffId());
        cmd.setShipmentLatestCancelDate(state.getShipmentLatestCancelDate());
        cmd.setShipmentEstimatedShipCost(state.getShipmentEstimatedShipCost());
        cmd.setShipmentCurrencyUomId(state.getShipmentCurrencyUomId());
        cmd.setShipmentHandlingInstructions(state.getShipmentHandlingInstructions());
        cmd.setShipmentOriginFacilityId(state.getShipmentOriginFacilityId());
        cmd.setShipmentDestinationFacilityId(state.getShipmentDestinationFacilityId());
        cmd.setShipmentOriginContactMechId(state.getShipmentOriginContactMechId());
        cmd.setShipmentOriginTelecomNumberId(state.getShipmentOriginTelecomNumberId());
        cmd.setShipmentDestinationContactMechId(state.getShipmentDestinationContactMechId());
        cmd.setShipmentDestinationTelecomNumberId(state.getShipmentDestinationTelecomNumberId());
        cmd.setShipmentPartyIdTo(state.getShipmentPartyIdTo());
        cmd.setShipmentPartyIdFrom(state.getShipmentPartyIdFrom());
        cmd.setShipmentAdditionalShippingCharge(state.getShipmentAdditionalShippingCharge());
        cmd.setShipmentAddtlShippingChargeDesc(state.getShipmentAddtlShippingChargeDesc());
        cmd.setShipmentCreatedBy(state.getShipmentCreatedBy());
        cmd.setShipmentCreatedAt(state.getShipmentCreatedAt());
        cmd.setShipmentUpdatedBy(state.getShipmentUpdatedBy());
        cmd.setShipmentUpdatedAt(state.getShipmentUpdatedAt());
        cmd.setShipmentActive(state.getShipmentActive());
        return cmd;
    }

    protected abstract TCreateItemIssuanceMvo newCreateItemIssuanceMvo();

    protected abstract TMergePatchItemIssuanceMvo newMergePatchItemIssuanceMvo(); 

    protected abstract TDeleteItemIssuanceMvo newDeleteItemIssuanceMvo();

    public static class SimpleItemIssuanceMvoStateCommandConverter extends AbstractItemIssuanceMvoStateCommandConverter<AbstractItemIssuanceMvoCommand.SimpleCreateItemIssuanceMvo, AbstractItemIssuanceMvoCommand.SimpleMergePatchItemIssuanceMvo, AbstractItemIssuanceMvoCommand.SimpleDeleteItemIssuanceMvo>
    {
        @Override
        protected AbstractItemIssuanceMvoCommand.SimpleCreateItemIssuanceMvo newCreateItemIssuanceMvo() {
            return new AbstractItemIssuanceMvoCommand.SimpleCreateItemIssuanceMvo();
        }

        @Override
        protected AbstractItemIssuanceMvoCommand.SimpleMergePatchItemIssuanceMvo newMergePatchItemIssuanceMvo() {
            return new AbstractItemIssuanceMvoCommand.SimpleMergePatchItemIssuanceMvo();
        }

        @Override
        protected AbstractItemIssuanceMvoCommand.SimpleDeleteItemIssuanceMvo newDeleteItemIssuanceMvo() {
            return new AbstractItemIssuanceMvoCommand.SimpleDeleteItemIssuanceMvo();
        }


    }

}

