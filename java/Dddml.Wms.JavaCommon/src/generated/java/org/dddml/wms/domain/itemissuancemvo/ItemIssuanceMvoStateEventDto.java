package org.dddml.wms.domain.itemissuancemvo;

import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class ItemIssuanceMvoStateEventDto extends AbstractEvent
{

    private ItemIssuanceMvoEventId itemIssuanceMvoEventId;

    ItemIssuanceMvoEventId getStateEventId() {
        if (itemIssuanceMvoEventId == null) { itemIssuanceMvoEventId = new ItemIssuanceMvoEventId(); }
        return itemIssuanceMvoEventId;
    }

    void setItemIssuanceMvoEventId(ItemIssuanceMvoEventId eventId) {
        this.itemIssuanceMvoEventId = eventId;
    }

    public ShipmentItemIssuanceId getShipmentItemIssuanceId() {
        return getStateEventId().getShipmentItemIssuanceId();
    }

    public void setShipmentItemIssuanceId(ShipmentItemIssuanceId shipmentItemIssuanceId) {
        getStateEventId().setShipmentItemIssuanceId(shipmentItemIssuanceId);
    }

    public Long getShipmentVersion() {
        return getStateEventId().getShipmentVersion();
    }
    
    public void getShipmentVersion(Long shipmentVersion) {
        getStateEventId().setShipmentVersion(shipmentVersion);
    }

    private String orderId;

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    private String orderItemSeqId;

    public String getOrderItemSeqId() {
        return this.orderItemSeqId;
    }

    public void setOrderItemSeqId(String orderItemSeqId) {
        this.orderItemSeqId = orderItemSeqId;
    }

    private Long shipGroupSeqId;

    public Long getShipGroupSeqId() {
        return this.shipGroupSeqId;
    }

    public void setShipGroupSeqId(Long shipGroupSeqId) {
        this.shipGroupSeqId = shipGroupSeqId;
    }

    private String productId;

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    private String locatorId;

    public String getLocatorId() {
        return this.locatorId;
    }

    public void setLocatorId(String locatorId) {
        this.locatorId = locatorId;
    }

    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId() {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId) {
        this.attributeSetInstanceId = attributeSetInstanceId;
    }

    private String shipmentItemSeqId;

    public String getShipmentItemSeqId() {
        return this.shipmentItemSeqId;
    }

    public void setShipmentItemSeqId(String shipmentItemSeqId) {
        this.shipmentItemSeqId = shipmentItemSeqId;
    }

    private String fixedAssetId;

    public String getFixedAssetId() {
        return this.fixedAssetId;
    }

    public void setFixedAssetId(String fixedAssetId) {
        this.fixedAssetId = fixedAssetId;
    }

    private String maintHistSeqId;

    public String getMaintHistSeqId() {
        return this.maintHistSeqId;
    }

    public void setMaintHistSeqId(String maintHistSeqId) {
        this.maintHistSeqId = maintHistSeqId;
    }

    private java.sql.Timestamp issuedDateTime;

    public java.sql.Timestamp getIssuedDateTime() {
        return this.issuedDateTime;
    }

    public void setIssuedDateTime(java.sql.Timestamp issuedDateTime) {
        this.issuedDateTime = issuedDateTime;
    }

    private String issuedByUserLoginId;

    public String getIssuedByUserLoginId() {
        return this.issuedByUserLoginId;
    }

    public void setIssuedByUserLoginId(String issuedByUserLoginId) {
        this.issuedByUserLoginId = issuedByUserLoginId;
    }

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity) {
        this.quantity = quantity;
    }

    private java.math.BigDecimal cancelQuantity;

    public java.math.BigDecimal getCancelQuantity() {
        return this.cancelQuantity;
    }

    public void setCancelQuantity(java.math.BigDecimal cancelQuantity) {
        this.cancelQuantity = cancelQuantity;
    }

    private Long version;

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private String shipmentShipmentTypeId;

    public String getShipmentShipmentTypeId() {
        return this.shipmentShipmentTypeId;
    }

    public void setShipmentShipmentTypeId(String shipmentShipmentTypeId) {
        this.shipmentShipmentTypeId = shipmentShipmentTypeId;
    }

    private String shipmentStatusId;

    public String getShipmentStatusId() {
        return this.shipmentStatusId;
    }

    public void setShipmentStatusId(String shipmentStatusId) {
        this.shipmentStatusId = shipmentStatusId;
    }

    private String shipmentPrimaryOrderId;

    public String getShipmentPrimaryOrderId() {
        return this.shipmentPrimaryOrderId;
    }

    public void setShipmentPrimaryOrderId(String shipmentPrimaryOrderId) {
        this.shipmentPrimaryOrderId = shipmentPrimaryOrderId;
    }

    private String shipmentPrimaryReturnId;

    public String getShipmentPrimaryReturnId() {
        return this.shipmentPrimaryReturnId;
    }

    public void setShipmentPrimaryReturnId(String shipmentPrimaryReturnId) {
        this.shipmentPrimaryReturnId = shipmentPrimaryReturnId;
    }

    private Long shipmentPrimaryShipGroupSeqId;

    public Long getShipmentPrimaryShipGroupSeqId() {
        return this.shipmentPrimaryShipGroupSeqId;
    }

    public void setShipmentPrimaryShipGroupSeqId(Long shipmentPrimaryShipGroupSeqId) {
        this.shipmentPrimaryShipGroupSeqId = shipmentPrimaryShipGroupSeqId;
    }

    private String shipmentPicklistBinId;

    public String getShipmentPicklistBinId() {
        return this.shipmentPicklistBinId;
    }

    public void setShipmentPicklistBinId(String shipmentPicklistBinId) {
        this.shipmentPicklistBinId = shipmentPicklistBinId;
    }

    private java.sql.Timestamp shipmentEstimatedReadyDate;

    public java.sql.Timestamp getShipmentEstimatedReadyDate() {
        return this.shipmentEstimatedReadyDate;
    }

    public void setShipmentEstimatedReadyDate(java.sql.Timestamp shipmentEstimatedReadyDate) {
        this.shipmentEstimatedReadyDate = shipmentEstimatedReadyDate;
    }

    private java.sql.Timestamp shipmentEstimatedShipDate;

    public java.sql.Timestamp getShipmentEstimatedShipDate() {
        return this.shipmentEstimatedShipDate;
    }

    public void setShipmentEstimatedShipDate(java.sql.Timestamp shipmentEstimatedShipDate) {
        this.shipmentEstimatedShipDate = shipmentEstimatedShipDate;
    }

    private String shipmentEstimatedShipWorkEffId;

    public String getShipmentEstimatedShipWorkEffId() {
        return this.shipmentEstimatedShipWorkEffId;
    }

    public void setShipmentEstimatedShipWorkEffId(String shipmentEstimatedShipWorkEffId) {
        this.shipmentEstimatedShipWorkEffId = shipmentEstimatedShipWorkEffId;
    }

    private java.sql.Timestamp shipmentEstimatedArrivalDate;

    public java.sql.Timestamp getShipmentEstimatedArrivalDate() {
        return this.shipmentEstimatedArrivalDate;
    }

    public void setShipmentEstimatedArrivalDate(java.sql.Timestamp shipmentEstimatedArrivalDate) {
        this.shipmentEstimatedArrivalDate = shipmentEstimatedArrivalDate;
    }

    private String shipmentEstimatedArrivalWorkEffId;

    public String getShipmentEstimatedArrivalWorkEffId() {
        return this.shipmentEstimatedArrivalWorkEffId;
    }

    public void setShipmentEstimatedArrivalWorkEffId(String shipmentEstimatedArrivalWorkEffId) {
        this.shipmentEstimatedArrivalWorkEffId = shipmentEstimatedArrivalWorkEffId;
    }

    private java.sql.Timestamp shipmentLatestCancelDate;

    public java.sql.Timestamp getShipmentLatestCancelDate() {
        return this.shipmentLatestCancelDate;
    }

    public void setShipmentLatestCancelDate(java.sql.Timestamp shipmentLatestCancelDate) {
        this.shipmentLatestCancelDate = shipmentLatestCancelDate;
    }

    private java.math.BigDecimal shipmentEstimatedShipCost;

    public java.math.BigDecimal getShipmentEstimatedShipCost() {
        return this.shipmentEstimatedShipCost;
    }

    public void setShipmentEstimatedShipCost(java.math.BigDecimal shipmentEstimatedShipCost) {
        this.shipmentEstimatedShipCost = shipmentEstimatedShipCost;
    }

    private String shipmentCurrencyUomId;

    public String getShipmentCurrencyUomId() {
        return this.shipmentCurrencyUomId;
    }

    public void setShipmentCurrencyUomId(String shipmentCurrencyUomId) {
        this.shipmentCurrencyUomId = shipmentCurrencyUomId;
    }

    private String shipmentHandlingInstructions;

    public String getShipmentHandlingInstructions() {
        return this.shipmentHandlingInstructions;
    }

    public void setShipmentHandlingInstructions(String shipmentHandlingInstructions) {
        this.shipmentHandlingInstructions = shipmentHandlingInstructions;
    }

    private String shipmentOriginFacilityId;

    public String getShipmentOriginFacilityId() {
        return this.shipmentOriginFacilityId;
    }

    public void setShipmentOriginFacilityId(String shipmentOriginFacilityId) {
        this.shipmentOriginFacilityId = shipmentOriginFacilityId;
    }

    private String shipmentDestinationFacilityId;

    public String getShipmentDestinationFacilityId() {
        return this.shipmentDestinationFacilityId;
    }

    public void setShipmentDestinationFacilityId(String shipmentDestinationFacilityId) {
        this.shipmentDestinationFacilityId = shipmentDestinationFacilityId;
    }

    private String shipmentOriginContactMechId;

    public String getShipmentOriginContactMechId() {
        return this.shipmentOriginContactMechId;
    }

    public void setShipmentOriginContactMechId(String shipmentOriginContactMechId) {
        this.shipmentOriginContactMechId = shipmentOriginContactMechId;
    }

    private String shipmentOriginTelecomNumberId;

    public String getShipmentOriginTelecomNumberId() {
        return this.shipmentOriginTelecomNumberId;
    }

    public void setShipmentOriginTelecomNumberId(String shipmentOriginTelecomNumberId) {
        this.shipmentOriginTelecomNumberId = shipmentOriginTelecomNumberId;
    }

    private String shipmentDestinationContactMechId;

    public String getShipmentDestinationContactMechId() {
        return this.shipmentDestinationContactMechId;
    }

    public void setShipmentDestinationContactMechId(String shipmentDestinationContactMechId) {
        this.shipmentDestinationContactMechId = shipmentDestinationContactMechId;
    }

    private String shipmentDestinationTelecomNumberId;

    public String getShipmentDestinationTelecomNumberId() {
        return this.shipmentDestinationTelecomNumberId;
    }

    public void setShipmentDestinationTelecomNumberId(String shipmentDestinationTelecomNumberId) {
        this.shipmentDestinationTelecomNumberId = shipmentDestinationTelecomNumberId;
    }

    private String shipmentPartyIdTo;

    public String getShipmentPartyIdTo() {
        return this.shipmentPartyIdTo;
    }

    public void setShipmentPartyIdTo(String shipmentPartyIdTo) {
        this.shipmentPartyIdTo = shipmentPartyIdTo;
    }

    private String shipmentPartyIdFrom;

    public String getShipmentPartyIdFrom() {
        return this.shipmentPartyIdFrom;
    }

    public void setShipmentPartyIdFrom(String shipmentPartyIdFrom) {
        this.shipmentPartyIdFrom = shipmentPartyIdFrom;
    }

    private java.math.BigDecimal shipmentAdditionalShippingCharge;

    public java.math.BigDecimal getShipmentAdditionalShippingCharge() {
        return this.shipmentAdditionalShippingCharge;
    }

    public void setShipmentAdditionalShippingCharge(java.math.BigDecimal shipmentAdditionalShippingCharge) {
        this.shipmentAdditionalShippingCharge = shipmentAdditionalShippingCharge;
    }

    private String shipmentAddtlShippingChargeDesc;

    public String getShipmentAddtlShippingChargeDesc() {
        return this.shipmentAddtlShippingChargeDesc;
    }

    public void setShipmentAddtlShippingChargeDesc(String shipmentAddtlShippingChargeDesc) {
        this.shipmentAddtlShippingChargeDesc = shipmentAddtlShippingChargeDesc;
    }

    private String shipmentCreatedBy;

    public String getShipmentCreatedBy() {
        return this.shipmentCreatedBy;
    }

    public void setShipmentCreatedBy(String shipmentCreatedBy) {
        this.shipmentCreatedBy = shipmentCreatedBy;
    }

    private Date shipmentCreatedAt;

    public Date getShipmentCreatedAt() {
        return this.shipmentCreatedAt;
    }

    public void setShipmentCreatedAt(Date shipmentCreatedAt) {
        this.shipmentCreatedAt = shipmentCreatedAt;
    }

    private String shipmentUpdatedBy;

    public String getShipmentUpdatedBy() {
        return this.shipmentUpdatedBy;
    }

    public void setShipmentUpdatedBy(String shipmentUpdatedBy) {
        this.shipmentUpdatedBy = shipmentUpdatedBy;
    }

    private Date shipmentUpdatedAt;

    public Date getShipmentUpdatedAt() {
        return this.shipmentUpdatedAt;
    }

    public void setShipmentUpdatedAt(Date shipmentUpdatedAt) {
        this.shipmentUpdatedAt = shipmentUpdatedAt;
    }

    private Boolean shipmentActive;

    public Boolean getShipmentActive() {
        return this.shipmentActive;
    }

    public void setShipmentActive(Boolean shipmentActive) {
        this.shipmentActive = shipmentActive;
    }

    private String createdBy;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private Boolean isPropertyOrderIdRemoved;

    public Boolean getIsPropertyOrderIdRemoved() {
        return this.isPropertyOrderIdRemoved;
    }

    public void setIsPropertyOrderIdRemoved(Boolean removed) {
        this.isPropertyOrderIdRemoved = removed;
    }

    private Boolean isPropertyOrderItemSeqIdRemoved;

    public Boolean getIsPropertyOrderItemSeqIdRemoved() {
        return this.isPropertyOrderItemSeqIdRemoved;
    }

    public void setIsPropertyOrderItemSeqIdRemoved(Boolean removed) {
        this.isPropertyOrderItemSeqIdRemoved = removed;
    }

    private Boolean isPropertyShipGroupSeqIdRemoved;

    public Boolean getIsPropertyShipGroupSeqIdRemoved() {
        return this.isPropertyShipGroupSeqIdRemoved;
    }

    public void setIsPropertyShipGroupSeqIdRemoved(Boolean removed) {
        this.isPropertyShipGroupSeqIdRemoved = removed;
    }

    private Boolean isPropertyProductIdRemoved;

    public Boolean getIsPropertyProductIdRemoved() {
        return this.isPropertyProductIdRemoved;
    }

    public void setIsPropertyProductIdRemoved(Boolean removed) {
        this.isPropertyProductIdRemoved = removed;
    }

    private Boolean isPropertyLocatorIdRemoved;

    public Boolean getIsPropertyLocatorIdRemoved() {
        return this.isPropertyLocatorIdRemoved;
    }

    public void setIsPropertyLocatorIdRemoved(Boolean removed) {
        this.isPropertyLocatorIdRemoved = removed;
    }

    private Boolean isPropertyAttributeSetInstanceIdRemoved;

    public Boolean getIsPropertyAttributeSetInstanceIdRemoved() {
        return this.isPropertyAttributeSetInstanceIdRemoved;
    }

    public void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed) {
        this.isPropertyAttributeSetInstanceIdRemoved = removed;
    }

    private Boolean isPropertyShipmentItemSeqIdRemoved;

    public Boolean getIsPropertyShipmentItemSeqIdRemoved() {
        return this.isPropertyShipmentItemSeqIdRemoved;
    }

    public void setIsPropertyShipmentItemSeqIdRemoved(Boolean removed) {
        this.isPropertyShipmentItemSeqIdRemoved = removed;
    }

    private Boolean isPropertyFixedAssetIdRemoved;

    public Boolean getIsPropertyFixedAssetIdRemoved() {
        return this.isPropertyFixedAssetIdRemoved;
    }

    public void setIsPropertyFixedAssetIdRemoved(Boolean removed) {
        this.isPropertyFixedAssetIdRemoved = removed;
    }

    private Boolean isPropertyMaintHistSeqIdRemoved;

    public Boolean getIsPropertyMaintHistSeqIdRemoved() {
        return this.isPropertyMaintHistSeqIdRemoved;
    }

    public void setIsPropertyMaintHistSeqIdRemoved(Boolean removed) {
        this.isPropertyMaintHistSeqIdRemoved = removed;
    }

    private Boolean isPropertyIssuedDateTimeRemoved;

    public Boolean getIsPropertyIssuedDateTimeRemoved() {
        return this.isPropertyIssuedDateTimeRemoved;
    }

    public void setIsPropertyIssuedDateTimeRemoved(Boolean removed) {
        this.isPropertyIssuedDateTimeRemoved = removed;
    }

    private Boolean isPropertyIssuedByUserLoginIdRemoved;

    public Boolean getIsPropertyIssuedByUserLoginIdRemoved() {
        return this.isPropertyIssuedByUserLoginIdRemoved;
    }

    public void setIsPropertyIssuedByUserLoginIdRemoved(Boolean removed) {
        this.isPropertyIssuedByUserLoginIdRemoved = removed;
    }

    private Boolean isPropertyQuantityRemoved;

    public Boolean getIsPropertyQuantityRemoved() {
        return this.isPropertyQuantityRemoved;
    }

    public void setIsPropertyQuantityRemoved(Boolean removed) {
        this.isPropertyQuantityRemoved = removed;
    }

    private Boolean isPropertyCancelQuantityRemoved;

    public Boolean getIsPropertyCancelQuantityRemoved() {
        return this.isPropertyCancelQuantityRemoved;
    }

    public void setIsPropertyCancelQuantityRemoved(Boolean removed) {
        this.isPropertyCancelQuantityRemoved = removed;
    }

    private Boolean isPropertyVersionRemoved;

    public Boolean getIsPropertyVersionRemoved() {
        return this.isPropertyVersionRemoved;
    }

    public void setIsPropertyVersionRemoved(Boolean removed) {
        this.isPropertyVersionRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }

    private Boolean isPropertyShipmentShipmentTypeIdRemoved;

    public Boolean getIsPropertyShipmentShipmentTypeIdRemoved() {
        return this.isPropertyShipmentShipmentTypeIdRemoved;
    }

    public void setIsPropertyShipmentShipmentTypeIdRemoved(Boolean removed) {
        this.isPropertyShipmentShipmentTypeIdRemoved = removed;
    }

    private Boolean isPropertyShipmentStatusIdRemoved;

    public Boolean getIsPropertyShipmentStatusIdRemoved() {
        return this.isPropertyShipmentStatusIdRemoved;
    }

    public void setIsPropertyShipmentStatusIdRemoved(Boolean removed) {
        this.isPropertyShipmentStatusIdRemoved = removed;
    }

    private Boolean isPropertyShipmentPrimaryOrderIdRemoved;

    public Boolean getIsPropertyShipmentPrimaryOrderIdRemoved() {
        return this.isPropertyShipmentPrimaryOrderIdRemoved;
    }

    public void setIsPropertyShipmentPrimaryOrderIdRemoved(Boolean removed) {
        this.isPropertyShipmentPrimaryOrderIdRemoved = removed;
    }

    private Boolean isPropertyShipmentPrimaryReturnIdRemoved;

    public Boolean getIsPropertyShipmentPrimaryReturnIdRemoved() {
        return this.isPropertyShipmentPrimaryReturnIdRemoved;
    }

    public void setIsPropertyShipmentPrimaryReturnIdRemoved(Boolean removed) {
        this.isPropertyShipmentPrimaryReturnIdRemoved = removed;
    }

    private Boolean isPropertyShipmentPrimaryShipGroupSeqIdRemoved;

    public Boolean getIsPropertyShipmentPrimaryShipGroupSeqIdRemoved() {
        return this.isPropertyShipmentPrimaryShipGroupSeqIdRemoved;
    }

    public void setIsPropertyShipmentPrimaryShipGroupSeqIdRemoved(Boolean removed) {
        this.isPropertyShipmentPrimaryShipGroupSeqIdRemoved = removed;
    }

    private Boolean isPropertyShipmentPicklistBinIdRemoved;

    public Boolean getIsPropertyShipmentPicklistBinIdRemoved() {
        return this.isPropertyShipmentPicklistBinIdRemoved;
    }

    public void setIsPropertyShipmentPicklistBinIdRemoved(Boolean removed) {
        this.isPropertyShipmentPicklistBinIdRemoved = removed;
    }

    private Boolean isPropertyShipmentEstimatedReadyDateRemoved;

    public Boolean getIsPropertyShipmentEstimatedReadyDateRemoved() {
        return this.isPropertyShipmentEstimatedReadyDateRemoved;
    }

    public void setIsPropertyShipmentEstimatedReadyDateRemoved(Boolean removed) {
        this.isPropertyShipmentEstimatedReadyDateRemoved = removed;
    }

    private Boolean isPropertyShipmentEstimatedShipDateRemoved;

    public Boolean getIsPropertyShipmentEstimatedShipDateRemoved() {
        return this.isPropertyShipmentEstimatedShipDateRemoved;
    }

    public void setIsPropertyShipmentEstimatedShipDateRemoved(Boolean removed) {
        this.isPropertyShipmentEstimatedShipDateRemoved = removed;
    }

    private Boolean isPropertyShipmentEstimatedShipWorkEffIdRemoved;

    public Boolean getIsPropertyShipmentEstimatedShipWorkEffIdRemoved() {
        return this.isPropertyShipmentEstimatedShipWorkEffIdRemoved;
    }

    public void setIsPropertyShipmentEstimatedShipWorkEffIdRemoved(Boolean removed) {
        this.isPropertyShipmentEstimatedShipWorkEffIdRemoved = removed;
    }

    private Boolean isPropertyShipmentEstimatedArrivalDateRemoved;

    public Boolean getIsPropertyShipmentEstimatedArrivalDateRemoved() {
        return this.isPropertyShipmentEstimatedArrivalDateRemoved;
    }

    public void setIsPropertyShipmentEstimatedArrivalDateRemoved(Boolean removed) {
        this.isPropertyShipmentEstimatedArrivalDateRemoved = removed;
    }

    private Boolean isPropertyShipmentEstimatedArrivalWorkEffIdRemoved;

    public Boolean getIsPropertyShipmentEstimatedArrivalWorkEffIdRemoved() {
        return this.isPropertyShipmentEstimatedArrivalWorkEffIdRemoved;
    }

    public void setIsPropertyShipmentEstimatedArrivalWorkEffIdRemoved(Boolean removed) {
        this.isPropertyShipmentEstimatedArrivalWorkEffIdRemoved = removed;
    }

    private Boolean isPropertyShipmentLatestCancelDateRemoved;

    public Boolean getIsPropertyShipmentLatestCancelDateRemoved() {
        return this.isPropertyShipmentLatestCancelDateRemoved;
    }

    public void setIsPropertyShipmentLatestCancelDateRemoved(Boolean removed) {
        this.isPropertyShipmentLatestCancelDateRemoved = removed;
    }

    private Boolean isPropertyShipmentEstimatedShipCostRemoved;

    public Boolean getIsPropertyShipmentEstimatedShipCostRemoved() {
        return this.isPropertyShipmentEstimatedShipCostRemoved;
    }

    public void setIsPropertyShipmentEstimatedShipCostRemoved(Boolean removed) {
        this.isPropertyShipmentEstimatedShipCostRemoved = removed;
    }

    private Boolean isPropertyShipmentCurrencyUomIdRemoved;

    public Boolean getIsPropertyShipmentCurrencyUomIdRemoved() {
        return this.isPropertyShipmentCurrencyUomIdRemoved;
    }

    public void setIsPropertyShipmentCurrencyUomIdRemoved(Boolean removed) {
        this.isPropertyShipmentCurrencyUomIdRemoved = removed;
    }

    private Boolean isPropertyShipmentHandlingInstructionsRemoved;

    public Boolean getIsPropertyShipmentHandlingInstructionsRemoved() {
        return this.isPropertyShipmentHandlingInstructionsRemoved;
    }

    public void setIsPropertyShipmentHandlingInstructionsRemoved(Boolean removed) {
        this.isPropertyShipmentHandlingInstructionsRemoved = removed;
    }

    private Boolean isPropertyShipmentOriginFacilityIdRemoved;

    public Boolean getIsPropertyShipmentOriginFacilityIdRemoved() {
        return this.isPropertyShipmentOriginFacilityIdRemoved;
    }

    public void setIsPropertyShipmentOriginFacilityIdRemoved(Boolean removed) {
        this.isPropertyShipmentOriginFacilityIdRemoved = removed;
    }

    private Boolean isPropertyShipmentDestinationFacilityIdRemoved;

    public Boolean getIsPropertyShipmentDestinationFacilityIdRemoved() {
        return this.isPropertyShipmentDestinationFacilityIdRemoved;
    }

    public void setIsPropertyShipmentDestinationFacilityIdRemoved(Boolean removed) {
        this.isPropertyShipmentDestinationFacilityIdRemoved = removed;
    }

    private Boolean isPropertyShipmentOriginContactMechIdRemoved;

    public Boolean getIsPropertyShipmentOriginContactMechIdRemoved() {
        return this.isPropertyShipmentOriginContactMechIdRemoved;
    }

    public void setIsPropertyShipmentOriginContactMechIdRemoved(Boolean removed) {
        this.isPropertyShipmentOriginContactMechIdRemoved = removed;
    }

    private Boolean isPropertyShipmentOriginTelecomNumberIdRemoved;

    public Boolean getIsPropertyShipmentOriginTelecomNumberIdRemoved() {
        return this.isPropertyShipmentOriginTelecomNumberIdRemoved;
    }

    public void setIsPropertyShipmentOriginTelecomNumberIdRemoved(Boolean removed) {
        this.isPropertyShipmentOriginTelecomNumberIdRemoved = removed;
    }

    private Boolean isPropertyShipmentDestinationContactMechIdRemoved;

    public Boolean getIsPropertyShipmentDestinationContactMechIdRemoved() {
        return this.isPropertyShipmentDestinationContactMechIdRemoved;
    }

    public void setIsPropertyShipmentDestinationContactMechIdRemoved(Boolean removed) {
        this.isPropertyShipmentDestinationContactMechIdRemoved = removed;
    }

    private Boolean isPropertyShipmentDestinationTelecomNumberIdRemoved;

    public Boolean getIsPropertyShipmentDestinationTelecomNumberIdRemoved() {
        return this.isPropertyShipmentDestinationTelecomNumberIdRemoved;
    }

    public void setIsPropertyShipmentDestinationTelecomNumberIdRemoved(Boolean removed) {
        this.isPropertyShipmentDestinationTelecomNumberIdRemoved = removed;
    }

    private Boolean isPropertyShipmentPartyIdToRemoved;

    public Boolean getIsPropertyShipmentPartyIdToRemoved() {
        return this.isPropertyShipmentPartyIdToRemoved;
    }

    public void setIsPropertyShipmentPartyIdToRemoved(Boolean removed) {
        this.isPropertyShipmentPartyIdToRemoved = removed;
    }

    private Boolean isPropertyShipmentPartyIdFromRemoved;

    public Boolean getIsPropertyShipmentPartyIdFromRemoved() {
        return this.isPropertyShipmentPartyIdFromRemoved;
    }

    public void setIsPropertyShipmentPartyIdFromRemoved(Boolean removed) {
        this.isPropertyShipmentPartyIdFromRemoved = removed;
    }

    private Boolean isPropertyShipmentAdditionalShippingChargeRemoved;

    public Boolean getIsPropertyShipmentAdditionalShippingChargeRemoved() {
        return this.isPropertyShipmentAdditionalShippingChargeRemoved;
    }

    public void setIsPropertyShipmentAdditionalShippingChargeRemoved(Boolean removed) {
        this.isPropertyShipmentAdditionalShippingChargeRemoved = removed;
    }

    private Boolean isPropertyShipmentAddtlShippingChargeDescRemoved;

    public Boolean getIsPropertyShipmentAddtlShippingChargeDescRemoved() {
        return this.isPropertyShipmentAddtlShippingChargeDescRemoved;
    }

    public void setIsPropertyShipmentAddtlShippingChargeDescRemoved(Boolean removed) {
        this.isPropertyShipmentAddtlShippingChargeDescRemoved = removed;
    }

    private Boolean isPropertyShipmentCreatedByRemoved;

    public Boolean getIsPropertyShipmentCreatedByRemoved() {
        return this.isPropertyShipmentCreatedByRemoved;
    }

    public void setIsPropertyShipmentCreatedByRemoved(Boolean removed) {
        this.isPropertyShipmentCreatedByRemoved = removed;
    }

    private Boolean isPropertyShipmentCreatedAtRemoved;

    public Boolean getIsPropertyShipmentCreatedAtRemoved() {
        return this.isPropertyShipmentCreatedAtRemoved;
    }

    public void setIsPropertyShipmentCreatedAtRemoved(Boolean removed) {
        this.isPropertyShipmentCreatedAtRemoved = removed;
    }

    private Boolean isPropertyShipmentUpdatedByRemoved;

    public Boolean getIsPropertyShipmentUpdatedByRemoved() {
        return this.isPropertyShipmentUpdatedByRemoved;
    }

    public void setIsPropertyShipmentUpdatedByRemoved(Boolean removed) {
        this.isPropertyShipmentUpdatedByRemoved = removed;
    }

    private Boolean isPropertyShipmentUpdatedAtRemoved;

    public Boolean getIsPropertyShipmentUpdatedAtRemoved() {
        return this.isPropertyShipmentUpdatedAtRemoved;
    }

    public void setIsPropertyShipmentUpdatedAtRemoved(Boolean removed) {
        this.isPropertyShipmentUpdatedAtRemoved = removed;
    }

    private Boolean isPropertyShipmentActiveRemoved;

    public Boolean getIsPropertyShipmentActiveRemoved() {
        return this.isPropertyShipmentActiveRemoved;
    }

    public void setIsPropertyShipmentActiveRemoved(Boolean removed) {
        this.isPropertyShipmentActiveRemoved = removed;
    }


	public static class ItemIssuanceMvoStateCreatedDto extends ItemIssuanceMvoStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class ItemIssuanceMvoStateMergePatchedDto extends ItemIssuanceMvoStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class ItemIssuanceMvoStateDeletedDto extends ItemIssuanceMvoStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

