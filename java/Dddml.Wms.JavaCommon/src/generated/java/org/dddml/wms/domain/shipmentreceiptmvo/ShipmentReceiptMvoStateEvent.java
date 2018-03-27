package org.dddml.wms.domain.shipmentreceiptmvo;

import java.util.*;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface ShipmentReceiptMvoStateEvent extends Event
{
    ShipmentReceiptMvoEventId getShipmentReceiptMvoEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    String getProductId();

    void setProductId(String productId);

    String getAttributeSetInstanceId();

    void setAttributeSetInstanceId(String attributeSetInstanceId);

    String getLocatorId();

    void setLocatorId(String locatorId);

    String getShipmentItemSeqId();

    void setShipmentItemSeqId(String shipmentItemSeqId);

    String getShipmentPackageSeqId();

    void setShipmentPackageSeqId(String shipmentPackageSeqId);

    String getOrderId();

    void setOrderId(String orderId);

    String getOrderItemSeqId();

    void setOrderItemSeqId(String orderItemSeqId);

    String getReturnId();

    void setReturnId(String returnId);

    String getReturnItemSeqId();

    void setReturnItemSeqId(String returnItemSeqId);

    String getRejectionReasonId();

    void setRejectionReasonId(String rejectionReasonId);

    String getDamageStatusId();

    void setDamageStatusId(String damageStatusId);

    String getDamageReasonId();

    void setDamageReasonId(String damageReasonId);

    String getReceivedBy();

    void setReceivedBy(String receivedBy);

    java.sql.Timestamp getDatetimeReceived();

    void setDatetimeReceived(java.sql.Timestamp datetimeReceived);

    String getItemDescription();

    void setItemDescription(String itemDescription);

    java.math.BigDecimal getAcceptedQuantity();

    void setAcceptedQuantity(java.math.BigDecimal acceptedQuantity);

    java.math.BigDecimal getRejectedQuantity();

    void setRejectedQuantity(java.math.BigDecimal rejectedQuantity);

    java.math.BigDecimal getDamagedQuantity();

    void setDamagedQuantity(java.math.BigDecimal damagedQuantity);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

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

    String getCommandId();

    void setCommandId(String commandId);

    interface ShipmentReceiptMvoStateCreated extends ShipmentReceiptMvoStateEvent
    {
    
    }


    interface ShipmentReceiptMvoStateMergePatched extends ShipmentReceiptMvoStateEvent
    {
        Boolean getIsPropertyProductIdRemoved();

        void setIsPropertyProductIdRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetInstanceIdRemoved();

        void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed);

        Boolean getIsPropertyLocatorIdRemoved();

        void setIsPropertyLocatorIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentItemSeqIdRemoved();

        void setIsPropertyShipmentItemSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentPackageSeqIdRemoved();

        void setIsPropertyShipmentPackageSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderIdRemoved();

        void setIsPropertyOrderIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderItemSeqIdRemoved();

        void setIsPropertyOrderItemSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyReturnIdRemoved();

        void setIsPropertyReturnIdRemoved(Boolean removed);

        Boolean getIsPropertyReturnItemSeqIdRemoved();

        void setIsPropertyReturnItemSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyRejectionReasonIdRemoved();

        void setIsPropertyRejectionReasonIdRemoved(Boolean removed);

        Boolean getIsPropertyDamageStatusIdRemoved();

        void setIsPropertyDamageStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyDamageReasonIdRemoved();

        void setIsPropertyDamageReasonIdRemoved(Boolean removed);

        Boolean getIsPropertyReceivedByRemoved();

        void setIsPropertyReceivedByRemoved(Boolean removed);

        Boolean getIsPropertyDatetimeReceivedRemoved();

        void setIsPropertyDatetimeReceivedRemoved(Boolean removed);

        Boolean getIsPropertyItemDescriptionRemoved();

        void setIsPropertyItemDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyAcceptedQuantityRemoved();

        void setIsPropertyAcceptedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyRejectedQuantityRemoved();

        void setIsPropertyRejectedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyDamagedQuantityRemoved();

        void setIsPropertyDamagedQuantityRemoved(Boolean removed);

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


}

