package org.dddml.wms.domain.shipmentitem;

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
    
    public ShipmentItemId getShipmentItemId() {
        return getStateEventId().getShipmentItemId();
    }

    public void setShipmentItemId(ShipmentItemId shipmentItemId) {
        getStateEventId().setShipmentItemId(shipmentItemId);
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

