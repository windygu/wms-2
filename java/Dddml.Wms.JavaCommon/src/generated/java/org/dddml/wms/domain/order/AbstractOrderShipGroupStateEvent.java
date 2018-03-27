package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractOrderShipGroupStateEvent extends AbstractStateEvent implements OrderShipGroupStateEvent 
{
    private OrderShipGroupEventId orderShipGroupEventId;

    public OrderShipGroupEventId getOrderShipGroupEventId() {
        return this.orderShipGroupEventId;
    }

    public void setOrderShipGroupEventId(OrderShipGroupEventId eventId) {
        this.orderShipGroupEventId = eventId;
    }
    
    public Long getShipGroupSeqId() {
        return getOrderShipGroupEventId().getShipGroupSeqId();
    }

    public void setShipGroupSeqId(Long shipGroupSeqId) {
        getOrderShipGroupEventId().setShipGroupSeqId(shipGroupSeqId);
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

    private String shipmentMethodTypeId;

    public String getShipmentMethodTypeId()
    {
        return this.shipmentMethodTypeId;
    }

    public void setShipmentMethodTypeId(String shipmentMethodTypeId)
    {
        this.shipmentMethodTypeId = shipmentMethodTypeId;
    }

    private String supplierPartyId;

    public String getSupplierPartyId()
    {
        return this.supplierPartyId;
    }

    public void setSupplierPartyId(String supplierPartyId)
    {
        this.supplierPartyId = supplierPartyId;
    }

    private String vendorPartyId;

    public String getVendorPartyId()
    {
        return this.vendorPartyId;
    }

    public void setVendorPartyId(String vendorPartyId)
    {
        this.vendorPartyId = vendorPartyId;
    }

    private String carrierPartyId;

    public String getCarrierPartyId()
    {
        return this.carrierPartyId;
    }

    public void setCarrierPartyId(String carrierPartyId)
    {
        this.carrierPartyId = carrierPartyId;
    }

    private String carrierRoleTypeId;

    public String getCarrierRoleTypeId()
    {
        return this.carrierRoleTypeId;
    }

    public void setCarrierRoleTypeId(String carrierRoleTypeId)
    {
        this.carrierRoleTypeId = carrierRoleTypeId;
    }

    private String facilityId;

    public String getFacilityId()
    {
        return this.facilityId;
    }

    public void setFacilityId(String facilityId)
    {
        this.facilityId = facilityId;
    }

    private String contactMechId;

    public String getContactMechId()
    {
        return this.contactMechId;
    }

    public void setContactMechId(String contactMechId)
    {
        this.contactMechId = contactMechId;
    }

    private String telecomContactMechId;

    public String getTelecomContactMechId()
    {
        return this.telecomContactMechId;
    }

    public void setTelecomContactMechId(String telecomContactMechId)
    {
        this.telecomContactMechId = telecomContactMechId;
    }

    private String trackingNumber;

    public String getTrackingNumber()
    {
        return this.trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber)
    {
        this.trackingNumber = trackingNumber;
    }

    private String shippingInstructions;

    public String getShippingInstructions()
    {
        return this.shippingInstructions;
    }

    public void setShippingInstructions(String shippingInstructions)
    {
        this.shippingInstructions = shippingInstructions;
    }

    private String maySplit;

    public String getMaySplit()
    {
        return this.maySplit;
    }

    public void setMaySplit(String maySplit)
    {
        this.maySplit = maySplit;
    }

    private String giftMessage;

    public String getGiftMessage()
    {
        return this.giftMessage;
    }

    public void setGiftMessage(String giftMessage)
    {
        this.giftMessage = giftMessage;
    }

    private String isGift;

    public String getIsGift()
    {
        return this.isGift;
    }

    public void setIsGift(String isGift)
    {
        this.isGift = isGift;
    }

    private java.sql.Timestamp shipAfterDate;

    public java.sql.Timestamp getShipAfterDate()
    {
        return this.shipAfterDate;
    }

    public void setShipAfterDate(java.sql.Timestamp shipAfterDate)
    {
        this.shipAfterDate = shipAfterDate;
    }

    private java.sql.Timestamp shipByDate;

    public java.sql.Timestamp getShipByDate()
    {
        return this.shipByDate;
    }

    public void setShipByDate(java.sql.Timestamp shipByDate)
    {
        this.shipByDate = shipByDate;
    }

    private java.sql.Timestamp estimatedShipDate;

    public java.sql.Timestamp getEstimatedShipDate()
    {
        return this.estimatedShipDate;
    }

    public void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate)
    {
        this.estimatedShipDate = estimatedShipDate;
    }

    private java.sql.Timestamp estimatedDeliveryDate;

    public java.sql.Timestamp getEstimatedDeliveryDate()
    {
        return this.estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(java.sql.Timestamp estimatedDeliveryDate)
    {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
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

    protected AbstractOrderShipGroupStateEvent() {
    }

    protected AbstractOrderShipGroupStateEvent(OrderShipGroupEventId eventId) {
        this.orderShipGroupEventId = eventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractOrderShipGroupStateCreated extends AbstractOrderShipGroupStateEvent implements OrderShipGroupStateEvent.OrderShipGroupStateCreated
    {
        public AbstractOrderShipGroupStateCreated() {
            this(new OrderShipGroupEventId());
        }

        public AbstractOrderShipGroupStateCreated(OrderShipGroupEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractOrderShipGroupStateMergePatched extends AbstractOrderShipGroupStateEvent implements OrderShipGroupStateEvent.OrderShipGroupStateMergePatched
    {
        public AbstractOrderShipGroupStateMergePatched() {
            this(new OrderShipGroupEventId());
        }

        public AbstractOrderShipGroupStateMergePatched(OrderShipGroupEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyShipmentMethodTypeIdRemoved;

        public Boolean getIsPropertyShipmentMethodTypeIdRemoved() {
            return this.isPropertyShipmentMethodTypeIdRemoved;
        }

        public void setIsPropertyShipmentMethodTypeIdRemoved(Boolean removed) {
            this.isPropertyShipmentMethodTypeIdRemoved = removed;
        }

        private Boolean isPropertySupplierPartyIdRemoved;

        public Boolean getIsPropertySupplierPartyIdRemoved() {
            return this.isPropertySupplierPartyIdRemoved;
        }

        public void setIsPropertySupplierPartyIdRemoved(Boolean removed) {
            this.isPropertySupplierPartyIdRemoved = removed;
        }

        private Boolean isPropertyVendorPartyIdRemoved;

        public Boolean getIsPropertyVendorPartyIdRemoved() {
            return this.isPropertyVendorPartyIdRemoved;
        }

        public void setIsPropertyVendorPartyIdRemoved(Boolean removed) {
            this.isPropertyVendorPartyIdRemoved = removed;
        }

        private Boolean isPropertyCarrierPartyIdRemoved;

        public Boolean getIsPropertyCarrierPartyIdRemoved() {
            return this.isPropertyCarrierPartyIdRemoved;
        }

        public void setIsPropertyCarrierPartyIdRemoved(Boolean removed) {
            this.isPropertyCarrierPartyIdRemoved = removed;
        }

        private Boolean isPropertyCarrierRoleTypeIdRemoved;

        public Boolean getIsPropertyCarrierRoleTypeIdRemoved() {
            return this.isPropertyCarrierRoleTypeIdRemoved;
        }

        public void setIsPropertyCarrierRoleTypeIdRemoved(Boolean removed) {
            this.isPropertyCarrierRoleTypeIdRemoved = removed;
        }

        private Boolean isPropertyFacilityIdRemoved;

        public Boolean getIsPropertyFacilityIdRemoved() {
            return this.isPropertyFacilityIdRemoved;
        }

        public void setIsPropertyFacilityIdRemoved(Boolean removed) {
            this.isPropertyFacilityIdRemoved = removed;
        }

        private Boolean isPropertyContactMechIdRemoved;

        public Boolean getIsPropertyContactMechIdRemoved() {
            return this.isPropertyContactMechIdRemoved;
        }

        public void setIsPropertyContactMechIdRemoved(Boolean removed) {
            this.isPropertyContactMechIdRemoved = removed;
        }

        private Boolean isPropertyTelecomContactMechIdRemoved;

        public Boolean getIsPropertyTelecomContactMechIdRemoved() {
            return this.isPropertyTelecomContactMechIdRemoved;
        }

        public void setIsPropertyTelecomContactMechIdRemoved(Boolean removed) {
            this.isPropertyTelecomContactMechIdRemoved = removed;
        }

        private Boolean isPropertyTrackingNumberRemoved;

        public Boolean getIsPropertyTrackingNumberRemoved() {
            return this.isPropertyTrackingNumberRemoved;
        }

        public void setIsPropertyTrackingNumberRemoved(Boolean removed) {
            this.isPropertyTrackingNumberRemoved = removed;
        }

        private Boolean isPropertyShippingInstructionsRemoved;

        public Boolean getIsPropertyShippingInstructionsRemoved() {
            return this.isPropertyShippingInstructionsRemoved;
        }

        public void setIsPropertyShippingInstructionsRemoved(Boolean removed) {
            this.isPropertyShippingInstructionsRemoved = removed;
        }

        private Boolean isPropertyMaySplitRemoved;

        public Boolean getIsPropertyMaySplitRemoved() {
            return this.isPropertyMaySplitRemoved;
        }

        public void setIsPropertyMaySplitRemoved(Boolean removed) {
            this.isPropertyMaySplitRemoved = removed;
        }

        private Boolean isPropertyGiftMessageRemoved;

        public Boolean getIsPropertyGiftMessageRemoved() {
            return this.isPropertyGiftMessageRemoved;
        }

        public void setIsPropertyGiftMessageRemoved(Boolean removed) {
            this.isPropertyGiftMessageRemoved = removed;
        }

        private Boolean isPropertyIsGiftRemoved;

        public Boolean getIsPropertyIsGiftRemoved() {
            return this.isPropertyIsGiftRemoved;
        }

        public void setIsPropertyIsGiftRemoved(Boolean removed) {
            this.isPropertyIsGiftRemoved = removed;
        }

        private Boolean isPropertyShipAfterDateRemoved;

        public Boolean getIsPropertyShipAfterDateRemoved() {
            return this.isPropertyShipAfterDateRemoved;
        }

        public void setIsPropertyShipAfterDateRemoved(Boolean removed) {
            this.isPropertyShipAfterDateRemoved = removed;
        }

        private Boolean isPropertyShipByDateRemoved;

        public Boolean getIsPropertyShipByDateRemoved() {
            return this.isPropertyShipByDateRemoved;
        }

        public void setIsPropertyShipByDateRemoved(Boolean removed) {
            this.isPropertyShipByDateRemoved = removed;
        }

        private Boolean isPropertyEstimatedShipDateRemoved;

        public Boolean getIsPropertyEstimatedShipDateRemoved() {
            return this.isPropertyEstimatedShipDateRemoved;
        }

        public void setIsPropertyEstimatedShipDateRemoved(Boolean removed) {
            this.isPropertyEstimatedShipDateRemoved = removed;
        }

        private Boolean isPropertyEstimatedDeliveryDateRemoved;

        public Boolean getIsPropertyEstimatedDeliveryDateRemoved() {
            return this.isPropertyEstimatedDeliveryDateRemoved;
        }

        public void setIsPropertyEstimatedDeliveryDateRemoved(Boolean removed) {
            this.isPropertyEstimatedDeliveryDateRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractOrderShipGroupStateRemoved extends AbstractOrderShipGroupStateEvent implements OrderShipGroupStateEvent.OrderShipGroupStateRemoved
    {
        public AbstractOrderShipGroupStateRemoved() {
            this(new OrderShipGroupEventId());
        }

        public AbstractOrderShipGroupStateRemoved(OrderShipGroupEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.REMOVED;
        }

    }
    public static class SimpleOrderShipGroupStateCreated extends AbstractOrderShipGroupStateCreated
    {
        public SimpleOrderShipGroupStateCreated() {
        }

        public SimpleOrderShipGroupStateCreated(OrderShipGroupEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrderShipGroupStateMergePatched extends AbstractOrderShipGroupStateMergePatched
    {
        public SimpleOrderShipGroupStateMergePatched() {
        }

        public SimpleOrderShipGroupStateMergePatched(OrderShipGroupEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrderShipGroupStateRemoved extends AbstractOrderShipGroupStateRemoved
    {
        public SimpleOrderShipGroupStateRemoved() {
        }

        public SimpleOrderShipGroupStateRemoved(OrderShipGroupEventId eventId) {
            super(eventId);
        }
    }

}

