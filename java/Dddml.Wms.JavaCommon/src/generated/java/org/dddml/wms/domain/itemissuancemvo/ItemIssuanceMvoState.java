package org.dddml.wms.domain.itemissuancemvo;

import java.util.Set;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.itemissuancemvo.ItemIssuanceMvoEvent.*;

public interface ItemIssuanceMvoState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    ShipmentItemIssuanceId getShipmentItemIssuanceId();

    void setShipmentItemIssuanceId(ShipmentItemIssuanceId shipmentItemIssuanceId);

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

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);

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

    Long getShipmentVersion();

    void setShipmentVersion(Long shipmentVersion);

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


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(ItemIssuanceMvoEvent.ItemIssuanceMvoStateCreated e);

    void when(ItemIssuanceMvoEvent.ItemIssuanceMvoStateMergePatched e);

    void when(ItemIssuanceMvoEvent.ItemIssuanceMvoStateDeleted e);
    
}

