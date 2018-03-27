package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractShipmentPackageContentStateEvent extends AbstractStateEvent implements ShipmentPackageContentStateEvent 
{
    private ShipmentPackageContentEventId shipmentPackageContentEventId;

    public ShipmentPackageContentEventId getShipmentPackageContentEventId() {
        return this.shipmentPackageContentEventId;
    }

    public void setShipmentPackageContentEventId(ShipmentPackageContentEventId eventId) {
        this.shipmentPackageContentEventId = eventId;
    }
    
    public String getShipmentItemSeqId() {
        return getShipmentPackageContentEventId().getShipmentItemSeqId();
    }

    public void setShipmentItemSeqId(String shipmentItemSeqId) {
        getShipmentPackageContentEventId().setShipmentItemSeqId(shipmentItemSeqId);
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

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    private String subProductId;

    public String getSubProductId()
    {
        return this.subProductId;
    }

    public void setSubProductId(String subProductId)
    {
        this.subProductId = subProductId;
    }

    private java.math.BigDecimal subProductQuantity;

    public java.math.BigDecimal getSubProductQuantity()
    {
        return this.subProductQuantity;
    }

    public void setSubProductQuantity(java.math.BigDecimal subProductQuantity)
    {
        this.subProductQuantity = subProductQuantity;
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

    protected AbstractShipmentPackageContentStateEvent() {
    }

    protected AbstractShipmentPackageContentStateEvent(ShipmentPackageContentEventId eventId) {
        this.shipmentPackageContentEventId = eventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractShipmentPackageContentStateCreated extends AbstractShipmentPackageContentStateEvent implements ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated
    {
        public AbstractShipmentPackageContentStateCreated() {
            this(new ShipmentPackageContentEventId());
        }

        public AbstractShipmentPackageContentStateCreated(ShipmentPackageContentEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractShipmentPackageContentStateMergePatched extends AbstractShipmentPackageContentStateEvent implements ShipmentPackageContentStateEvent.ShipmentPackageContentStateMergePatched
    {
        public AbstractShipmentPackageContentStateMergePatched() {
            this(new ShipmentPackageContentEventId());
        }

        public AbstractShipmentPackageContentStateMergePatched(ShipmentPackageContentEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyQuantityRemoved;

        public Boolean getIsPropertyQuantityRemoved() {
            return this.isPropertyQuantityRemoved;
        }

        public void setIsPropertyQuantityRemoved(Boolean removed) {
            this.isPropertyQuantityRemoved = removed;
        }

        private Boolean isPropertySubProductIdRemoved;

        public Boolean getIsPropertySubProductIdRemoved() {
            return this.isPropertySubProductIdRemoved;
        }

        public void setIsPropertySubProductIdRemoved(Boolean removed) {
            this.isPropertySubProductIdRemoved = removed;
        }

        private Boolean isPropertySubProductQuantityRemoved;

        public Boolean getIsPropertySubProductQuantityRemoved() {
            return this.isPropertySubProductQuantityRemoved;
        }

        public void setIsPropertySubProductQuantityRemoved(Boolean removed) {
            this.isPropertySubProductQuantityRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractShipmentPackageContentStateRemoved extends AbstractShipmentPackageContentStateEvent implements ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved
    {
        public AbstractShipmentPackageContentStateRemoved() {
            this(new ShipmentPackageContentEventId());
        }

        public AbstractShipmentPackageContentStateRemoved(ShipmentPackageContentEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.REMOVED;
        }

    }
    public static class SimpleShipmentPackageContentStateCreated extends AbstractShipmentPackageContentStateCreated
    {
        public SimpleShipmentPackageContentStateCreated() {
        }

        public SimpleShipmentPackageContentStateCreated(ShipmentPackageContentEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleShipmentPackageContentStateMergePatched extends AbstractShipmentPackageContentStateMergePatched
    {
        public SimpleShipmentPackageContentStateMergePatched() {
        }

        public SimpleShipmentPackageContentStateMergePatched(ShipmentPackageContentEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleShipmentPackageContentStateRemoved extends AbstractShipmentPackageContentStateRemoved
    {
        public SimpleShipmentPackageContentStateRemoved() {
        }

        public SimpleShipmentPackageContentStateRemoved(ShipmentPackageContentEventId eventId) {
            super(eventId);
        }
    }

}

