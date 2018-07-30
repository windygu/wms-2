package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractShipmentImageEvent extends AbstractEvent implements ShipmentImageEvent 
{
    private ShipmentImageEventId shipmentImageEventId;

    public ShipmentImageEventId getShipmentImageEventId() {
        return this.shipmentImageEventId;
    }

    public void setShipmentImageEventId(ShipmentImageEventId eventId) {
        this.shipmentImageEventId = eventId;
    }
    
    public String getSequenceId() {
        return getShipmentImageEventId().getSequenceId();
    }

    public void setSequenceId(String sequenceId) {
        getShipmentImageEventId().setSequenceId(sequenceId);
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

    protected AbstractShipmentImageEvent() {
    }

    protected AbstractShipmentImageEvent(ShipmentImageEventId eventId) {
        this.shipmentImageEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractShipmentImageStateEvent extends AbstractShipmentImageEvent implements ShipmentImageEvent.ShipmentImageStateEvent {
        private Long version;

        public Long getVersion()
        {
            return this.version;
        }

        public void setVersion(Long version)
        {
            this.version = version;
        }

        private String url;

        public String getUrl()
        {
            return this.url;
        }

        public void setUrl(String url)
        {
            this.url = url;
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

        protected AbstractShipmentImageStateEvent(ShipmentImageEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractShipmentImageStateCreated extends AbstractShipmentImageStateEvent implements ShipmentImageEvent.ShipmentImageStateCreated
    {
        public AbstractShipmentImageStateCreated() {
            this(new ShipmentImageEventId());
        }

        public AbstractShipmentImageStateCreated(ShipmentImageEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractShipmentImageStateMergePatched extends AbstractShipmentImageStateEvent implements ShipmentImageEvent.ShipmentImageStateMergePatched
    {
        public AbstractShipmentImageStateMergePatched() {
            this(new ShipmentImageEventId());
        }

        public AbstractShipmentImageStateMergePatched(ShipmentImageEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyUrlRemoved;

        public Boolean getIsPropertyUrlRemoved() {
            return this.isPropertyUrlRemoved;
        }

        public void setIsPropertyUrlRemoved(Boolean removed) {
            this.isPropertyUrlRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractShipmentImageStateRemoved extends AbstractShipmentImageStateEvent implements ShipmentImageEvent.ShipmentImageStateRemoved
    {
        public AbstractShipmentImageStateRemoved() {
            this(new ShipmentImageEventId());
        }

        public AbstractShipmentImageStateRemoved(ShipmentImageEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.REMOVED;
        }

    }
    public static class SimpleShipmentImageStateCreated extends AbstractShipmentImageStateCreated
    {
        public SimpleShipmentImageStateCreated() {
        }

        public SimpleShipmentImageStateCreated(ShipmentImageEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleShipmentImageStateMergePatched extends AbstractShipmentImageStateMergePatched
    {
        public SimpleShipmentImageStateMergePatched() {
        }

        public SimpleShipmentImageStateMergePatched(ShipmentImageEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleShipmentImageStateRemoved extends AbstractShipmentImageStateRemoved
    {
        public SimpleShipmentImageStateRemoved() {
        }

        public SimpleShipmentImageStateRemoved(ShipmentImageEventId eventId) {
            super(eventId);
        }
    }

}

