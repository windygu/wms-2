package org.dddml.wms.domain.itemissuancemvo;

import java.util.*;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface ItemIssuanceMvoCommand extends Command
{
    ShipmentItemIssuanceId getShipmentItemIssuanceId();

    void setShipmentItemIssuanceId(ShipmentItemIssuanceId shipmentItemIssuanceId);

    Long getShipmentVersion();

    void setShipmentVersion(Long shipmentVersion);

    static void throwOnInvalidStateTransition(ItemIssuanceMvoState state, Command c) {
        if (state.getShipmentVersion() == null)
        {
            if (isCommandCreate((ItemIssuanceMvoCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((ItemIssuanceMvoCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(ItemIssuanceMvoCommand c) {
        return ((c instanceof ItemIssuanceMvoCommand.CreateItemIssuanceMvo) 
            && c.getShipmentVersion().equals(ItemIssuanceMvoState.VERSION_NULL));
    }

    interface CreateOrMergePatchItemIssuanceMvo extends ItemIssuanceMvoCommand
    {
        String getOrderId();

        void setOrderId(String orderId);

        String getOrderItemSeqId();

        void setOrderItemSeqId(String orderItemSeqId);

        Long getShipGroupSeqId();

        void setShipGroupSeqId(Long shipGroupSeqId);

        String getProductId();

        void setProductId(String productId);

        String getLocatorId();

        void setLocatorId(String locatorId);

        String getAttributeSetInstanceId();

        void setAttributeSetInstanceId(String attributeSetInstanceId);

        String getShipmentItemSeqId();

        void setShipmentItemSeqId(String shipmentItemSeqId);

        String getFixedAssetId();

        void setFixedAssetId(String fixedAssetId);

        String getMaintHistSeqId();

        void setMaintHistSeqId(String maintHistSeqId);

        java.sql.Timestamp getIssuedDateTime();

        void setIssuedDateTime(java.sql.Timestamp issuedDateTime);

        String getIssuedByUserLoginId();

        void setIssuedByUserLoginId(String issuedByUserLoginId);

        java.math.BigDecimal getQuantity();

        void setQuantity(java.math.BigDecimal quantity);

        java.math.BigDecimal getCancelQuantity();

        void setCancelQuantity(java.math.BigDecimal cancelQuantity);

        Long getVersion();

        void setVersion(Long version);

        Boolean getActive();

        void setActive(Boolean active);

        String getShipmentShipmentTypeId();

        void setShipmentShipmentTypeId(String shipmentShipmentTypeId);

        String getShipmentStatusId();

        void setShipmentStatusId(String shipmentStatusId);

        String getShipmentPrimaryOrderId();

        void setShipmentPrimaryOrderId(String shipmentPrimaryOrderId);

        String getShipmentPrimaryReturnId();

        void setShipmentPrimaryReturnId(String shipmentPrimaryReturnId);

        Long getShipmentPrimaryShipGroupSeqId();

        void setShipmentPrimaryShipGroupSeqId(Long shipmentPrimaryShipGroupSeqId);

        String getShipmentPicklistBinId();

        void setShipmentPicklistBinId(String shipmentPicklistBinId);

        java.sql.Timestamp getShipmentEstimatedReadyDate();

        void setShipmentEstimatedReadyDate(java.sql.Timestamp shipmentEstimatedReadyDate);

        java.sql.Timestamp getShipmentEstimatedShipDate();

        void setShipmentEstimatedShipDate(java.sql.Timestamp shipmentEstimatedShipDate);

        String getShipmentEstimatedShipWorkEffId();

        void setShipmentEstimatedShipWorkEffId(String shipmentEstimatedShipWorkEffId);

        java.sql.Timestamp getShipmentEstimatedArrivalDate();

        void setShipmentEstimatedArrivalDate(java.sql.Timestamp shipmentEstimatedArrivalDate);

        String getShipmentEstimatedArrivalWorkEffId();

        void setShipmentEstimatedArrivalWorkEffId(String shipmentEstimatedArrivalWorkEffId);

        java.sql.Timestamp getShipmentLatestCancelDate();

        void setShipmentLatestCancelDate(java.sql.Timestamp shipmentLatestCancelDate);

        java.math.BigDecimal getShipmentEstimatedShipCost();

        void setShipmentEstimatedShipCost(java.math.BigDecimal shipmentEstimatedShipCost);

        String getShipmentCurrencyUomId();

        void setShipmentCurrencyUomId(String shipmentCurrencyUomId);

        String getShipmentHandlingInstructions();

        void setShipmentHandlingInstructions(String shipmentHandlingInstructions);

        String getShipmentOriginFacilityId();

        void setShipmentOriginFacilityId(String shipmentOriginFacilityId);

        String getShipmentDestinationFacilityId();

        void setShipmentDestinationFacilityId(String shipmentDestinationFacilityId);

        String getShipmentOriginContactMechId();

        void setShipmentOriginContactMechId(String shipmentOriginContactMechId);

        String getShipmentOriginTelecomNumberId();

        void setShipmentOriginTelecomNumberId(String shipmentOriginTelecomNumberId);

        String getShipmentDestinationContactMechId();

        void setShipmentDestinationContactMechId(String shipmentDestinationContactMechId);

        String getShipmentDestinationTelecomNumberId();

        void setShipmentDestinationTelecomNumberId(String shipmentDestinationTelecomNumberId);

        String getShipmentPartyIdTo();

        void setShipmentPartyIdTo(String shipmentPartyIdTo);

        String getShipmentPartyIdFrom();

        void setShipmentPartyIdFrom(String shipmentPartyIdFrom);

        java.math.BigDecimal getShipmentAdditionalShippingCharge();

        void setShipmentAdditionalShippingCharge(java.math.BigDecimal shipmentAdditionalShippingCharge);

        String getShipmentAddtlShippingChargeDesc();

        void setShipmentAddtlShippingChargeDesc(String shipmentAddtlShippingChargeDesc);

        String getShipmentCreatedBy();

        void setShipmentCreatedBy(String shipmentCreatedBy);

        Date getShipmentCreatedAt();

        void setShipmentCreatedAt(Date shipmentCreatedAt);

        String getShipmentUpdatedBy();

        void setShipmentUpdatedBy(String shipmentUpdatedBy);

        Date getShipmentUpdatedAt();

        void setShipmentUpdatedAt(Date shipmentUpdatedAt);

        Boolean getShipmentActive();

        void setShipmentActive(Boolean shipmentActive);

    }

    interface CreateItemIssuanceMvo extends CreateOrMergePatchItemIssuanceMvo
    {
    }

    interface MergePatchItemIssuanceMvo extends CreateOrMergePatchItemIssuanceMvo
    {
        Boolean getIsPropertyOrderIdRemoved();

        void setIsPropertyOrderIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderItemSeqIdRemoved();

        void setIsPropertyOrderItemSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyShipGroupSeqIdRemoved();

        void setIsPropertyShipGroupSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyProductIdRemoved();

        void setIsPropertyProductIdRemoved(Boolean removed);

        Boolean getIsPropertyLocatorIdRemoved();

        void setIsPropertyLocatorIdRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetInstanceIdRemoved();

        void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentItemSeqIdRemoved();

        void setIsPropertyShipmentItemSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyFixedAssetIdRemoved();

        void setIsPropertyFixedAssetIdRemoved(Boolean removed);

        Boolean getIsPropertyMaintHistSeqIdRemoved();

        void setIsPropertyMaintHistSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyIssuedDateTimeRemoved();

        void setIsPropertyIssuedDateTimeRemoved(Boolean removed);

        Boolean getIsPropertyIssuedByUserLoginIdRemoved();

        void setIsPropertyIssuedByUserLoginIdRemoved(Boolean removed);

        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyCancelQuantityRemoved();

        void setIsPropertyCancelQuantityRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyShipmentShipmentTypeIdRemoved();

        void setIsPropertyShipmentShipmentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentStatusIdRemoved();

        void setIsPropertyShipmentStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPrimaryOrderIdRemoved();

        void setIsPropertyShipmentPrimaryOrderIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPrimaryReturnIdRemoved();

        void setIsPropertyShipmentPrimaryReturnIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPrimaryShipGroupSeqIdRemoved();

        void setIsPropertyShipmentPrimaryShipGroupSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPicklistBinIdRemoved();

        void setIsPropertyShipmentPicklistBinIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentEstimatedReadyDateRemoved();

        void setIsPropertyShipmentEstimatedReadyDateRemoved(Boolean removed);

        Boolean getIsPropertyShipmentEstimatedShipDateRemoved();

        void setIsPropertyShipmentEstimatedShipDateRemoved(Boolean removed);

        Boolean getIsPropertyShipmentEstimatedShipWorkEffIdRemoved();

        void setIsPropertyShipmentEstimatedShipWorkEffIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentEstimatedArrivalDateRemoved();

        void setIsPropertyShipmentEstimatedArrivalDateRemoved(Boolean removed);

        Boolean getIsPropertyShipmentEstimatedArrivalWorkEffIdRemoved();

        void setIsPropertyShipmentEstimatedArrivalWorkEffIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentLatestCancelDateRemoved();

        void setIsPropertyShipmentLatestCancelDateRemoved(Boolean removed);

        Boolean getIsPropertyShipmentEstimatedShipCostRemoved();

        void setIsPropertyShipmentEstimatedShipCostRemoved(Boolean removed);

        Boolean getIsPropertyShipmentCurrencyUomIdRemoved();

        void setIsPropertyShipmentCurrencyUomIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentHandlingInstructionsRemoved();

        void setIsPropertyShipmentHandlingInstructionsRemoved(Boolean removed);

        Boolean getIsPropertyShipmentOriginFacilityIdRemoved();

        void setIsPropertyShipmentOriginFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentDestinationFacilityIdRemoved();

        void setIsPropertyShipmentDestinationFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentOriginContactMechIdRemoved();

        void setIsPropertyShipmentOriginContactMechIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentOriginTelecomNumberIdRemoved();

        void setIsPropertyShipmentOriginTelecomNumberIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentDestinationContactMechIdRemoved();

        void setIsPropertyShipmentDestinationContactMechIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentDestinationTelecomNumberIdRemoved();

        void setIsPropertyShipmentDestinationTelecomNumberIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPartyIdToRemoved();

        void setIsPropertyShipmentPartyIdToRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPartyIdFromRemoved();

        void setIsPropertyShipmentPartyIdFromRemoved(Boolean removed);

        Boolean getIsPropertyShipmentAdditionalShippingChargeRemoved();

        void setIsPropertyShipmentAdditionalShippingChargeRemoved(Boolean removed);

        Boolean getIsPropertyShipmentAddtlShippingChargeDescRemoved();

        void setIsPropertyShipmentAddtlShippingChargeDescRemoved(Boolean removed);

        Boolean getIsPropertyShipmentCreatedByRemoved();

        void setIsPropertyShipmentCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyShipmentCreatedAtRemoved();

        void setIsPropertyShipmentCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyShipmentUpdatedByRemoved();

        void setIsPropertyShipmentUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyShipmentUpdatedAtRemoved();

        void setIsPropertyShipmentUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyShipmentActiveRemoved();

        void setIsPropertyShipmentActiveRemoved(Boolean removed);

    }

	interface DeleteItemIssuanceMvo extends ItemIssuanceMvoCommand
	{
	}

}

