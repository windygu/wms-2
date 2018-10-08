package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractShipmentItemEvent extends AbstractEvent implements ShipmentItemEvent.SqlShipmentItemEvent 
{
    private ShipmentItemEventId shipmentItemEventId;

    public ShipmentItemEventId getShipmentItemEventId() {
        return this.shipmentItemEventId;
    }

    public void setShipmentItemEventId(ShipmentItemEventId eventId) {
        this.shipmentItemEventId = eventId;
    }
    
    public String getShipmentItemSeqId() {
        return getShipmentItemEventId().getShipmentItemSeqId();
    }

    public void setShipmentItemSeqId(String shipmentItemSeqId) {
        getShipmentItemEventId().setShipmentItemSeqId(shipmentItemSeqId);
    }

    private boolean stateEventReadOnly;

    public boolean getEventReadOnly() { return this.stateEventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractShipmentItemEvent() {
    }

    protected AbstractShipmentItemEvent(ShipmentItemEventId eventId) {
        this.shipmentItemEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractShipmentItemStateEvent extends AbstractShipmentItemEvent implements ShipmentItemEvent.ShipmentItemStateEvent {
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

        private java.math.BigDecimal quantity;

        public java.math.BigDecimal getQuantity()
        {
            return this.quantity;
        }

        public void setQuantity(java.math.BigDecimal quantity)
        {
            this.quantity = quantity;
        }

        private String shipmentContentDescription;

        public String getShipmentContentDescription()
        {
            return this.shipmentContentDescription;
        }

        public void setShipmentContentDescription(String shipmentContentDescription)
        {
            this.shipmentContentDescription = shipmentContentDescription;
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

        protected AbstractShipmentItemStateEvent(ShipmentItemEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractShipmentItemStateCreated extends AbstractShipmentItemStateEvent implements ShipmentItemEvent.ShipmentItemStateCreated
    {
        public AbstractShipmentItemStateCreated() {
            this(new ShipmentItemEventId());
        }

        public AbstractShipmentItemStateCreated(ShipmentItemEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractShipmentItemStateMergePatched extends AbstractShipmentItemStateEvent implements ShipmentItemEvent.ShipmentItemStateMergePatched
    {
        public AbstractShipmentItemStateMergePatched() {
            this(new ShipmentItemEventId());
        }

        public AbstractShipmentItemStateMergePatched(ShipmentItemEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
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

        private Boolean isPropertyQuantityRemoved;

        public Boolean getIsPropertyQuantityRemoved() {
            return this.isPropertyQuantityRemoved;
        }

        public void setIsPropertyQuantityRemoved(Boolean removed) {
            this.isPropertyQuantityRemoved = removed;
        }

        private Boolean isPropertyShipmentContentDescriptionRemoved;

        public Boolean getIsPropertyShipmentContentDescriptionRemoved() {
            return this.isPropertyShipmentContentDescriptionRemoved;
        }

        public void setIsPropertyShipmentContentDescriptionRemoved(Boolean removed) {
            this.isPropertyShipmentContentDescriptionRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static class SimpleShipmentItemStateCreated extends AbstractShipmentItemStateCreated
    {
        public SimpleShipmentItemStateCreated() {
        }

        public SimpleShipmentItemStateCreated(ShipmentItemEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleShipmentItemStateMergePatched extends AbstractShipmentItemStateMergePatched
    {
        public SimpleShipmentItemStateMergePatched() {
        }

        public SimpleShipmentItemStateMergePatched(ShipmentItemEventId eventId) {
            super(eventId);
        }
    }

}

