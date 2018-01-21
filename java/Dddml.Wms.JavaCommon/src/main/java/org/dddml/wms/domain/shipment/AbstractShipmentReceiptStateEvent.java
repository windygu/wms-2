package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractShipmentReceiptStateEvent extends AbstractStateEvent implements ShipmentReceiptStateEvent 
{
    private ShipmentReceiptStateEventId stateEventId;

    public ShipmentReceiptStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(ShipmentReceiptStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public String getReceiptSeqId() {
        return getStateEventId().getReceiptSeqId();
    }

    public void setReceiptSeqId(String receiptSeqId) {
        getStateEventId().setReceiptSeqId(receiptSeqId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

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


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractShipmentReceiptStateEvent() {
    }

    protected AbstractShipmentReceiptStateEvent(ShipmentReceiptStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractShipmentReceiptStateCreated extends AbstractShipmentReceiptStateEvent implements ShipmentReceiptStateEvent.ShipmentReceiptStateCreated
    {
        public AbstractShipmentReceiptStateCreated() {
            this(new ShipmentReceiptStateEventId());
        }

        public AbstractShipmentReceiptStateCreated(ShipmentReceiptStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractShipmentReceiptStateMergePatched extends AbstractShipmentReceiptStateEvent implements ShipmentReceiptStateEvent.ShipmentReceiptStateMergePatched
    {
        public AbstractShipmentReceiptStateMergePatched() {
            this(new ShipmentReceiptStateEventId());
        }

        public AbstractShipmentReceiptStateMergePatched(ShipmentReceiptStateEventId stateEventId) {
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

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static class SimpleShipmentReceiptStateCreated extends AbstractShipmentReceiptStateCreated
    {
        public SimpleShipmentReceiptStateCreated() {
        }

        public SimpleShipmentReceiptStateCreated(ShipmentReceiptStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleShipmentReceiptStateMergePatched extends AbstractShipmentReceiptStateMergePatched
    {
        public SimpleShipmentReceiptStateMergePatched() {
        }

        public SimpleShipmentReceiptStateMergePatched(ShipmentReceiptStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

