package org.dddml.wms.domain.shipmentreceiptmvo;

import java.util.*;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractShipmentReceiptMvoStateEvent extends AbstractStateEvent implements ShipmentReceiptMvoStateEvent 
{
    private ShipmentReceiptMvoStateEventId stateEventId;

    public ShipmentReceiptMvoStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(ShipmentReceiptMvoStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public ShipmentReceiptId getShipmentReceiptId() {
        return getStateEventId().getShipmentReceiptId();
    }

    public void setShipmentReceiptId(ShipmentReceiptId shipmentReceiptId) {
        getStateEventId().setShipmentReceiptId(shipmentReceiptId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private String productId;

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
    }

    private String shipmentItemSeqId;

    public String getShipmentItemSeqId()
    {
        return this.shipmentItemSeqId;
    }

    public void setShipmentItemSeqId(String shipmentItemSeqId)
    {
        this.shipmentItemSeqId = shipmentItemSeqId;
    }

    private String rejectionReasonId;

    public String getRejectionReasonId()
    {
        return this.rejectionReasonId;
    }

    public void setRejectionReasonId(String rejectionReasonId)
    {
        this.rejectionReasonId = rejectionReasonId;
    }

    private String damageStatusId;

    public String getDamageStatusId()
    {
        return this.damageStatusId;
    }

    public void setDamageStatusId(String damageStatusId)
    {
        this.damageStatusId = damageStatusId;
    }

    private String damageReasonId;

    public String getDamageReasonId()
    {
        return this.damageReasonId;
    }

    public void setDamageReasonId(String damageReasonId)
    {
        this.damageReasonId = damageReasonId;
    }

    private String receivedBy;

    public String getReceivedBy()
    {
        return this.receivedBy;
    }

    public void setReceivedBy(String receivedBy)
    {
        this.receivedBy = receivedBy;
    }

    private java.sql.Timestamp datetimeReceived;

    public java.sql.Timestamp getDatetimeReceived()
    {
        return this.datetimeReceived;
    }

    public void setDatetimeReceived(java.sql.Timestamp datetimeReceived)
    {
        this.datetimeReceived = datetimeReceived;
    }

    private String itemDescription;

    public String getItemDescription()
    {
        return this.itemDescription;
    }

    public void setItemDescription(String itemDescription)
    {
        this.itemDescription = itemDescription;
    }

    private java.math.BigDecimal acceptedQuantity;

    public java.math.BigDecimal getAcceptedQuantity()
    {
        return this.acceptedQuantity;
    }

    public void setAcceptedQuantity(java.math.BigDecimal acceptedQuantity)
    {
        this.acceptedQuantity = acceptedQuantity;
    }

    private java.math.BigDecimal rejectedQuantity;

    public java.math.BigDecimal getRejectedQuantity()
    {
        return this.rejectedQuantity;
    }

    public void setRejectedQuantity(java.math.BigDecimal rejectedQuantity)
    {
        this.rejectedQuantity = rejectedQuantity;
    }

    private java.math.BigDecimal damagedQuantity;

    public java.math.BigDecimal getDamagedQuantity()
    {
        return this.damagedQuantity;
    }

    public void setDamagedQuantity(java.math.BigDecimal damagedQuantity)
    {
        this.damagedQuantity = damagedQuantity;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private String shipmentShipmentTypeId;

    public String getShipmentShipmentTypeId()
    {
        return this.shipmentShipmentTypeId;
    }

    public void setShipmentShipmentTypeId(String shipmentShipmentTypeId)
    {
        this.shipmentShipmentTypeId = shipmentShipmentTypeId;
    }

    private String shipmentStatusId;

    public String getShipmentStatusId()
    {
        return this.shipmentStatusId;
    }

    public void setShipmentStatusId(String shipmentStatusId)
    {
        this.shipmentStatusId = shipmentStatusId;
    }

    private String shipmentPrimaryOrderId;

    public String getShipmentPrimaryOrderId()
    {
        return this.shipmentPrimaryOrderId;
    }

    public void setShipmentPrimaryOrderId(String shipmentPrimaryOrderId)
    {
        this.shipmentPrimaryOrderId = shipmentPrimaryOrderId;
    }

    private String shipmentPrimaryReturnId;

    public String getShipmentPrimaryReturnId()
    {
        return this.shipmentPrimaryReturnId;
    }

    public void setShipmentPrimaryReturnId(String shipmentPrimaryReturnId)
    {
        this.shipmentPrimaryReturnId = shipmentPrimaryReturnId;
    }

    private String shipmentPicklistBinId;

    public String getShipmentPicklistBinId()
    {
        return this.shipmentPicklistBinId;
    }

    public void setShipmentPicklistBinId(String shipmentPicklistBinId)
    {
        this.shipmentPicklistBinId = shipmentPicklistBinId;
    }

    private java.sql.Timestamp shipmentEstimatedReadyDate;

    public java.sql.Timestamp getShipmentEstimatedReadyDate()
    {
        return this.shipmentEstimatedReadyDate;
    }

    public void setShipmentEstimatedReadyDate(java.sql.Timestamp shipmentEstimatedReadyDate)
    {
        this.shipmentEstimatedReadyDate = shipmentEstimatedReadyDate;
    }

    private java.sql.Timestamp shipmentEstimatedShipDate;

    public java.sql.Timestamp getShipmentEstimatedShipDate()
    {
        return this.shipmentEstimatedShipDate;
    }

    public void setShipmentEstimatedShipDate(java.sql.Timestamp shipmentEstimatedShipDate)
    {
        this.shipmentEstimatedShipDate = shipmentEstimatedShipDate;
    }

    private String shipmentEstimatedShipWorkEffId;

    public String getShipmentEstimatedShipWorkEffId()
    {
        return this.shipmentEstimatedShipWorkEffId;
    }

    public void setShipmentEstimatedShipWorkEffId(String shipmentEstimatedShipWorkEffId)
    {
        this.shipmentEstimatedShipWorkEffId = shipmentEstimatedShipWorkEffId;
    }

    private java.sql.Timestamp shipmentEstimatedArrivalDate;

    public java.sql.Timestamp getShipmentEstimatedArrivalDate()
    {
        return this.shipmentEstimatedArrivalDate;
    }

    public void setShipmentEstimatedArrivalDate(java.sql.Timestamp shipmentEstimatedArrivalDate)
    {
        this.shipmentEstimatedArrivalDate = shipmentEstimatedArrivalDate;
    }

    private String shipmentEstimatedArrivalWorkEffId;

    public String getShipmentEstimatedArrivalWorkEffId()
    {
        return this.shipmentEstimatedArrivalWorkEffId;
    }

    public void setShipmentEstimatedArrivalWorkEffId(String shipmentEstimatedArrivalWorkEffId)
    {
        this.shipmentEstimatedArrivalWorkEffId = shipmentEstimatedArrivalWorkEffId;
    }

    private java.sql.Timestamp shipmentLatestCancelDate;

    public java.sql.Timestamp getShipmentLatestCancelDate()
    {
        return this.shipmentLatestCancelDate;
    }

    public void setShipmentLatestCancelDate(java.sql.Timestamp shipmentLatestCancelDate)
    {
        this.shipmentLatestCancelDate = shipmentLatestCancelDate;
    }

    private java.math.BigDecimal shipmentEstimatedShipCost;

    public java.math.BigDecimal getShipmentEstimatedShipCost()
    {
        return this.shipmentEstimatedShipCost;
    }

    public void setShipmentEstimatedShipCost(java.math.BigDecimal shipmentEstimatedShipCost)
    {
        this.shipmentEstimatedShipCost = shipmentEstimatedShipCost;
    }

    private String shipmentCurrencyUomId;

    public String getShipmentCurrencyUomId()
    {
        return this.shipmentCurrencyUomId;
    }

    public void setShipmentCurrencyUomId(String shipmentCurrencyUomId)
    {
        this.shipmentCurrencyUomId = shipmentCurrencyUomId;
    }

    private String shipmentHandlingInstructions;

    public String getShipmentHandlingInstructions()
    {
        return this.shipmentHandlingInstructions;
    }

    public void setShipmentHandlingInstructions(String shipmentHandlingInstructions)
    {
        this.shipmentHandlingInstructions = shipmentHandlingInstructions;
    }

    private String shipmentOriginFacilityId;

    public String getShipmentOriginFacilityId()
    {
        return this.shipmentOriginFacilityId;
    }

    public void setShipmentOriginFacilityId(String shipmentOriginFacilityId)
    {
        this.shipmentOriginFacilityId = shipmentOriginFacilityId;
    }

    private String shipmentDestinationFacilityId;

    public String getShipmentDestinationFacilityId()
    {
        return this.shipmentDestinationFacilityId;
    }

    public void setShipmentDestinationFacilityId(String shipmentDestinationFacilityId)
    {
        this.shipmentDestinationFacilityId = shipmentDestinationFacilityId;
    }

    private String shipmentOriginContactMechId;

    public String getShipmentOriginContactMechId()
    {
        return this.shipmentOriginContactMechId;
    }

    public void setShipmentOriginContactMechId(String shipmentOriginContactMechId)
    {
        this.shipmentOriginContactMechId = shipmentOriginContactMechId;
    }

    private String shipmentOriginTelecomNumberId;

    public String getShipmentOriginTelecomNumberId()
    {
        return this.shipmentOriginTelecomNumberId;
    }

    public void setShipmentOriginTelecomNumberId(String shipmentOriginTelecomNumberId)
    {
        this.shipmentOriginTelecomNumberId = shipmentOriginTelecomNumberId;
    }

    private String shipmentDestinationContactMechId;

    public String getShipmentDestinationContactMechId()
    {
        return this.shipmentDestinationContactMechId;
    }

    public void setShipmentDestinationContactMechId(String shipmentDestinationContactMechId)
    {
        this.shipmentDestinationContactMechId = shipmentDestinationContactMechId;
    }

    private String shipmentDestinationTelecomNumberId;

    public String getShipmentDestinationTelecomNumberId()
    {
        return this.shipmentDestinationTelecomNumberId;
    }

    public void setShipmentDestinationTelecomNumberId(String shipmentDestinationTelecomNumberId)
    {
        this.shipmentDestinationTelecomNumberId = shipmentDestinationTelecomNumberId;
    }

    private String shipmentPartyIdTo;

    public String getShipmentPartyIdTo()
    {
        return this.shipmentPartyIdTo;
    }

    public void setShipmentPartyIdTo(String shipmentPartyIdTo)
    {
        this.shipmentPartyIdTo = shipmentPartyIdTo;
    }

    private String shipmentPartyIdFrom;

    public String getShipmentPartyIdFrom()
    {
        return this.shipmentPartyIdFrom;
    }

    public void setShipmentPartyIdFrom(String shipmentPartyIdFrom)
    {
        this.shipmentPartyIdFrom = shipmentPartyIdFrom;
    }

    private java.math.BigDecimal shipmentAdditionalShippingCharge;

    public java.math.BigDecimal getShipmentAdditionalShippingCharge()
    {
        return this.shipmentAdditionalShippingCharge;
    }

    public void setShipmentAdditionalShippingCharge(java.math.BigDecimal shipmentAdditionalShippingCharge)
    {
        this.shipmentAdditionalShippingCharge = shipmentAdditionalShippingCharge;
    }

    private String shipmentAddtlShippingChargeDesc;

    public String getShipmentAddtlShippingChargeDesc()
    {
        return this.shipmentAddtlShippingChargeDesc;
    }

    public void setShipmentAddtlShippingChargeDesc(String shipmentAddtlShippingChargeDesc)
    {
        this.shipmentAddtlShippingChargeDesc = shipmentAddtlShippingChargeDesc;
    }

    private String shipmentShipperId;

    public String getShipmentShipperId()
    {
        return this.shipmentShipperId;
    }

    public void setShipmentShipperId(String shipmentShipperId)
    {
        this.shipmentShipperId = shipmentShipperId;
    }

    private String shipmentCreatedBy;

    public String getShipmentCreatedBy()
    {
        return this.shipmentCreatedBy;
    }

    public void setShipmentCreatedBy(String shipmentCreatedBy)
    {
        this.shipmentCreatedBy = shipmentCreatedBy;
    }

    private Date shipmentCreatedAt;

    public Date getShipmentCreatedAt()
    {
        return this.shipmentCreatedAt;
    }

    public void setShipmentCreatedAt(Date shipmentCreatedAt)
    {
        this.shipmentCreatedAt = shipmentCreatedAt;
    }

    private String shipmentUpdatedBy;

    public String getShipmentUpdatedBy()
    {
        return this.shipmentUpdatedBy;
    }

    public void setShipmentUpdatedBy(String shipmentUpdatedBy)
    {
        this.shipmentUpdatedBy = shipmentUpdatedBy;
    }

    private Date shipmentUpdatedAt;

    public Date getShipmentUpdatedAt()
    {
        return this.shipmentUpdatedAt;
    }

    public void setShipmentUpdatedAt(Date shipmentUpdatedAt)
    {
        this.shipmentUpdatedAt = shipmentUpdatedAt;
    }

    private Boolean shipmentActive;

    public Boolean getShipmentActive()
    {
        return this.shipmentActive;
    }

    public void setShipmentActive(Boolean shipmentActive)
    {
        this.shipmentActive = shipmentActive;
    }


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractShipmentReceiptMvoStateEvent() {
    }

    protected AbstractShipmentReceiptMvoStateEvent(ShipmentReceiptMvoStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractShipmentReceiptMvoStateCreated extends AbstractShipmentReceiptMvoStateEvent implements ShipmentReceiptMvoStateEvent.ShipmentReceiptMvoStateCreated
    {
        public AbstractShipmentReceiptMvoStateCreated() {
            this(new ShipmentReceiptMvoStateEventId());
        }

        public AbstractShipmentReceiptMvoStateCreated(ShipmentReceiptMvoStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractShipmentReceiptMvoStateMergePatched extends AbstractShipmentReceiptMvoStateEvent implements ShipmentReceiptMvoStateEvent.ShipmentReceiptMvoStateMergePatched
    {
        public AbstractShipmentReceiptMvoStateMergePatched() {
            this(new ShipmentReceiptMvoStateEventId());
        }

        public AbstractShipmentReceiptMvoStateMergePatched(ShipmentReceiptMvoStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyProductIdRemoved;

        public Boolean getIsPropertyProductIdRemoved() {
            return this.isPropertyProductIdRemoved;
        }

        public void setIsPropertyProductIdRemoved(Boolean removed) {
            this.isPropertyProductIdRemoved = removed;
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

        private Boolean isPropertyRejectionReasonIdRemoved;

        public Boolean getIsPropertyRejectionReasonIdRemoved() {
            return this.isPropertyRejectionReasonIdRemoved;
        }

        public void setIsPropertyRejectionReasonIdRemoved(Boolean removed) {
            this.isPropertyRejectionReasonIdRemoved = removed;
        }

        private Boolean isPropertyDamageStatusIdRemoved;

        public Boolean getIsPropertyDamageStatusIdRemoved() {
            return this.isPropertyDamageStatusIdRemoved;
        }

        public void setIsPropertyDamageStatusIdRemoved(Boolean removed) {
            this.isPropertyDamageStatusIdRemoved = removed;
        }

        private Boolean isPropertyDamageReasonIdRemoved;

        public Boolean getIsPropertyDamageReasonIdRemoved() {
            return this.isPropertyDamageReasonIdRemoved;
        }

        public void setIsPropertyDamageReasonIdRemoved(Boolean removed) {
            this.isPropertyDamageReasonIdRemoved = removed;
        }

        private Boolean isPropertyReceivedByRemoved;

        public Boolean getIsPropertyReceivedByRemoved() {
            return this.isPropertyReceivedByRemoved;
        }

        public void setIsPropertyReceivedByRemoved(Boolean removed) {
            this.isPropertyReceivedByRemoved = removed;
        }

        private Boolean isPropertyDatetimeReceivedRemoved;

        public Boolean getIsPropertyDatetimeReceivedRemoved() {
            return this.isPropertyDatetimeReceivedRemoved;
        }

        public void setIsPropertyDatetimeReceivedRemoved(Boolean removed) {
            this.isPropertyDatetimeReceivedRemoved = removed;
        }

        private Boolean isPropertyItemDescriptionRemoved;

        public Boolean getIsPropertyItemDescriptionRemoved() {
            return this.isPropertyItemDescriptionRemoved;
        }

        public void setIsPropertyItemDescriptionRemoved(Boolean removed) {
            this.isPropertyItemDescriptionRemoved = removed;
        }

        private Boolean isPropertyAcceptedQuantityRemoved;

        public Boolean getIsPropertyAcceptedQuantityRemoved() {
            return this.isPropertyAcceptedQuantityRemoved;
        }

        public void setIsPropertyAcceptedQuantityRemoved(Boolean removed) {
            this.isPropertyAcceptedQuantityRemoved = removed;
        }

        private Boolean isPropertyRejectedQuantityRemoved;

        public Boolean getIsPropertyRejectedQuantityRemoved() {
            return this.isPropertyRejectedQuantityRemoved;
        }

        public void setIsPropertyRejectedQuantityRemoved(Boolean removed) {
            this.isPropertyRejectedQuantityRemoved = removed;
        }

        private Boolean isPropertyDamagedQuantityRemoved;

        public Boolean getIsPropertyDamagedQuantityRemoved() {
            return this.isPropertyDamagedQuantityRemoved;
        }

        public void setIsPropertyDamagedQuantityRemoved(Boolean removed) {
            this.isPropertyDamagedQuantityRemoved = removed;
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

        private Boolean isPropertyShipmentShipperIdRemoved;

        public Boolean getIsPropertyShipmentShipperIdRemoved() {
            return this.isPropertyShipmentShipperIdRemoved;
        }

        public void setIsPropertyShipmentShipperIdRemoved(Boolean removed) {
            this.isPropertyShipmentShipperIdRemoved = removed;
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

    }


    public static class SimpleShipmentReceiptMvoStateCreated extends AbstractShipmentReceiptMvoStateCreated
    {
        public SimpleShipmentReceiptMvoStateCreated() {
        }

        public SimpleShipmentReceiptMvoStateCreated(ShipmentReceiptMvoStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleShipmentReceiptMvoStateMergePatched extends AbstractShipmentReceiptMvoStateMergePatched
    {
        public SimpleShipmentReceiptMvoStateMergePatched() {
        }

        public SimpleShipmentReceiptMvoStateMergePatched(ShipmentReceiptMvoStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

