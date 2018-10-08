package org.dddml.wms.domain.shipmentmethodtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractShipmentMethodTypeEvent extends AbstractEvent implements ShipmentMethodTypeEvent.SqlShipmentMethodTypeEvent 
{
    private ShipmentMethodTypeEventId shipmentMethodTypeEventId;

    public ShipmentMethodTypeEventId getShipmentMethodTypeEventId() {
        return this.shipmentMethodTypeEventId;
    }

    public void setShipmentMethodTypeEventId(ShipmentMethodTypeEventId eventId) {
        this.shipmentMethodTypeEventId = eventId;
    }
    
    public String getShipmentMethodTypeId() {
        return getShipmentMethodTypeEventId().getShipmentMethodTypeId();
    }

    public void setShipmentMethodTypeId(String shipmentMethodTypeId) {
        getShipmentMethodTypeEventId().setShipmentMethodTypeId(shipmentMethodTypeId);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

    public Long getVersion() {
        return getShipmentMethodTypeEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getShipmentMethodTypeEventId().setVersion(version);
    //}

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

    protected AbstractShipmentMethodTypeEvent() {
    }

    protected AbstractShipmentMethodTypeEvent(ShipmentMethodTypeEventId eventId) {
        this.shipmentMethodTypeEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractShipmentMethodTypeStateEvent extends AbstractShipmentMethodTypeEvent implements ShipmentMethodTypeEvent.ShipmentMethodTypeStateEvent {
        private String description;

        public String getDescription()
        {
            return this.description;
        }

        public void setDescription(String description)
        {
            this.description = description;
        }

        private Long sequenceNum;

        public Long getSequenceNum()
        {
            return this.sequenceNum;
        }

        public void setSequenceNum(Long sequenceNum)
        {
            this.sequenceNum = sequenceNum;
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

        protected AbstractShipmentMethodTypeStateEvent(ShipmentMethodTypeEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractShipmentMethodTypeStateCreated extends AbstractShipmentMethodTypeStateEvent implements ShipmentMethodTypeEvent.ShipmentMethodTypeStateCreated
    {
        public AbstractShipmentMethodTypeStateCreated() {
            this(new ShipmentMethodTypeEventId());
        }

        public AbstractShipmentMethodTypeStateCreated(ShipmentMethodTypeEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractShipmentMethodTypeStateMergePatched extends AbstractShipmentMethodTypeStateEvent implements ShipmentMethodTypeEvent.ShipmentMethodTypeStateMergePatched
    {
        public AbstractShipmentMethodTypeStateMergePatched() {
            this(new ShipmentMethodTypeEventId());
        }

        public AbstractShipmentMethodTypeStateMergePatched(ShipmentMethodTypeEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved() {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed) {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertySequenceNumRemoved;

        public Boolean getIsPropertySequenceNumRemoved() {
            return this.isPropertySequenceNumRemoved;
        }

        public void setIsPropertySequenceNumRemoved(Boolean removed) {
            this.isPropertySequenceNumRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractShipmentMethodTypeStateDeleted extends AbstractShipmentMethodTypeStateEvent implements ShipmentMethodTypeEvent.ShipmentMethodTypeStateDeleted
    {
        public AbstractShipmentMethodTypeStateDeleted() {
            this(new ShipmentMethodTypeEventId());
        }

        public AbstractShipmentMethodTypeStateDeleted(ShipmentMethodTypeEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleShipmentMethodTypeStateCreated extends AbstractShipmentMethodTypeStateCreated
    {
        public SimpleShipmentMethodTypeStateCreated() {
        }

        public SimpleShipmentMethodTypeStateCreated(ShipmentMethodTypeEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleShipmentMethodTypeStateMergePatched extends AbstractShipmentMethodTypeStateMergePatched
    {
        public SimpleShipmentMethodTypeStateMergePatched() {
        }

        public SimpleShipmentMethodTypeStateMergePatched(ShipmentMethodTypeEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleShipmentMethodTypeStateDeleted extends AbstractShipmentMethodTypeStateDeleted
    {
        public SimpleShipmentMethodTypeStateDeleted() {
        }

        public SimpleShipmentMethodTypeStateDeleted(ShipmentMethodTypeEventId eventId) {
            super(eventId);
        }
    }

}

