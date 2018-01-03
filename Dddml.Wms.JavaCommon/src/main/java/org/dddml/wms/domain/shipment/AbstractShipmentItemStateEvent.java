package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractShipmentItemStateEvent extends AbstractStateEvent implements ShipmentItemStateEvent 
{
    private ShipmentItemStateEventId stateEventId;

    public ShipmentItemStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(ShipmentItemStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public String getShipmentItemSeqId() {
        return getStateEventId().getShipmentItemSeqId();
    }

    public void setShipmentItemSeqId(String shipmentItemSeqId) {
        getStateEventId().setShipmentItemSeqId(shipmentItemSeqId);
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

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    private java.math.BigDecimal targetQuantity;

    public java.math.BigDecimal getTargetQuantity()
    {
        return this.targetQuantity;
    }

    public void setTargetQuantity(java.math.BigDecimal targetQuantity)
    {
        this.targetQuantity = targetQuantity;
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

    protected AbstractShipmentItemStateEvent() {
    }

    protected AbstractShipmentItemStateEvent(ShipmentItemStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractShipmentItemStateCreated extends AbstractShipmentItemStateEvent implements ShipmentItemStateEvent.ShipmentItemStateCreated
    {
        public AbstractShipmentItemStateCreated() {
            this(new ShipmentItemStateEventId());
        }

        public AbstractShipmentItemStateCreated(ShipmentItemStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractShipmentItemStateMergePatched extends AbstractShipmentItemStateEvent implements ShipmentItemStateEvent.ShipmentItemStateMergePatched
    {
        public AbstractShipmentItemStateMergePatched() {
            this(new ShipmentItemStateEventId());
        }

        public AbstractShipmentItemStateMergePatched(ShipmentItemStateEventId stateEventId) {
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

        private Boolean isPropertyQuantityRemoved;

        public Boolean getIsPropertyQuantityRemoved() {
            return this.isPropertyQuantityRemoved;
        }

        public void setIsPropertyQuantityRemoved(Boolean removed) {
            this.isPropertyQuantityRemoved = removed;
        }

        private Boolean isPropertyTargetQuantityRemoved;

        public Boolean getIsPropertyTargetQuantityRemoved() {
            return this.isPropertyTargetQuantityRemoved;
        }

        public void setIsPropertyTargetQuantityRemoved(Boolean removed) {
            this.isPropertyTargetQuantityRemoved = removed;
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

        public SimpleShipmentItemStateCreated(ShipmentItemStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleShipmentItemStateMergePatched extends AbstractShipmentItemStateMergePatched
    {
        public SimpleShipmentItemStateMergePatched() {
        }

        public SimpleShipmentItemStateMergePatched(ShipmentItemStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

