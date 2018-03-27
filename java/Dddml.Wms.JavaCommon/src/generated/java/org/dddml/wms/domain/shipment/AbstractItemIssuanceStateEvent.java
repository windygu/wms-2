package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractItemIssuanceStateEvent extends AbstractStateEvent implements ItemIssuanceStateEvent 
{
    private ItemIssuanceEventId itemIssuanceEventId;

    public ItemIssuanceEventId getItemIssuanceEventId() {
        return this.itemIssuanceEventId;
    }

    public void setItemIssuanceEventId(ItemIssuanceEventId eventId) {
        this.itemIssuanceEventId = eventId;
    }
    
    public String getItemIssuanceSeqId() {
        return getItemIssuanceEventId().getItemIssuanceSeqId();
    }

    public void setItemIssuanceSeqId(String itemIssuanceSeqId) {
        getItemIssuanceEventId().setItemIssuanceSeqId(itemIssuanceSeqId);
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

    private String orderId;

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    private String orderItemSeqId;

    public String getOrderItemSeqId()
    {
        return this.orderItemSeqId;
    }

    public void setOrderItemSeqId(String orderItemSeqId)
    {
        this.orderItemSeqId = orderItemSeqId;
    }

    private Long shipGroupSeqId;

    public Long getShipGroupSeqId()
    {
        return this.shipGroupSeqId;
    }

    public void setShipGroupSeqId(Long shipGroupSeqId)
    {
        this.shipGroupSeqId = shipGroupSeqId;
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

    private String locatorId;

    public String getLocatorId()
    {
        return this.locatorId;
    }

    public void setLocatorId(String locatorId)
    {
        this.locatorId = locatorId;
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

    private String fixedAssetId;

    public String getFixedAssetId()
    {
        return this.fixedAssetId;
    }

    public void setFixedAssetId(String fixedAssetId)
    {
        this.fixedAssetId = fixedAssetId;
    }

    private String maintHistSeqId;

    public String getMaintHistSeqId()
    {
        return this.maintHistSeqId;
    }

    public void setMaintHistSeqId(String maintHistSeqId)
    {
        this.maintHistSeqId = maintHistSeqId;
    }

    private java.sql.Timestamp issuedDateTime;

    public java.sql.Timestamp getIssuedDateTime()
    {
        return this.issuedDateTime;
    }

    public void setIssuedDateTime(java.sql.Timestamp issuedDateTime)
    {
        this.issuedDateTime = issuedDateTime;
    }

    private String issuedByUserLoginId;

    public String getIssuedByUserLoginId()
    {
        return this.issuedByUserLoginId;
    }

    public void setIssuedByUserLoginId(String issuedByUserLoginId)
    {
        this.issuedByUserLoginId = issuedByUserLoginId;
    }

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    private java.math.BigDecimal cancelQuantity;

    public java.math.BigDecimal getCancelQuantity()
    {
        return this.cancelQuantity;
    }

    public void setCancelQuantity(java.math.BigDecimal cancelQuantity)
    {
        this.cancelQuantity = cancelQuantity;
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

    protected AbstractItemIssuanceStateEvent() {
    }

    protected AbstractItemIssuanceStateEvent(ItemIssuanceEventId eventId) {
        this.itemIssuanceEventId = eventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractItemIssuanceStateCreated extends AbstractItemIssuanceStateEvent implements ItemIssuanceStateEvent.ItemIssuanceStateCreated
    {
        public AbstractItemIssuanceStateCreated() {
            this(new ItemIssuanceEventId());
        }

        public AbstractItemIssuanceStateCreated(ItemIssuanceEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractItemIssuanceStateMergePatched extends AbstractItemIssuanceStateEvent implements ItemIssuanceStateEvent.ItemIssuanceStateMergePatched
    {
        public AbstractItemIssuanceStateMergePatched() {
            this(new ItemIssuanceEventId());
        }

        public AbstractItemIssuanceStateMergePatched(ItemIssuanceEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
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

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractItemIssuanceStateRemoved extends AbstractItemIssuanceStateEvent implements ItemIssuanceStateEvent.ItemIssuanceStateRemoved
    {
        public AbstractItemIssuanceStateRemoved() {
            this(new ItemIssuanceEventId());
        }

        public AbstractItemIssuanceStateRemoved(ItemIssuanceEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.REMOVED;
        }

    }
    public static class SimpleItemIssuanceStateCreated extends AbstractItemIssuanceStateCreated
    {
        public SimpleItemIssuanceStateCreated() {
        }

        public SimpleItemIssuanceStateCreated(ItemIssuanceEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleItemIssuanceStateMergePatched extends AbstractItemIssuanceStateMergePatched
    {
        public SimpleItemIssuanceStateMergePatched() {
        }

        public SimpleItemIssuanceStateMergePatched(ItemIssuanceEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleItemIssuanceStateRemoved extends AbstractItemIssuanceStateRemoved
    {
        public SimpleItemIssuanceStateRemoved() {
        }

        public SimpleItemIssuanceStateRemoved(ItemIssuanceEventId eventId) {
            super(eventId);
        }
    }

}

