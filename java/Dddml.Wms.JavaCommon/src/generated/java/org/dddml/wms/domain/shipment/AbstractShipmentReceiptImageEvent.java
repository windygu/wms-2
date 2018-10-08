package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractShipmentReceiptImageEvent extends AbstractEvent implements ShipmentReceiptImageEvent.SqlShipmentReceiptImageEvent 
{
    private ShipmentReceiptImageEventId shipmentReceiptImageEventId;

    public ShipmentReceiptImageEventId getShipmentReceiptImageEventId() {
        return this.shipmentReceiptImageEventId;
    }

    public void setShipmentReceiptImageEventId(ShipmentReceiptImageEventId eventId) {
        this.shipmentReceiptImageEventId = eventId;
    }
    
    public String getSequenceId() {
        return getShipmentReceiptImageEventId().getSequenceId();
    }

    public void setSequenceId(String sequenceId) {
        getShipmentReceiptImageEventId().setSequenceId(sequenceId);
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

    protected AbstractShipmentReceiptImageEvent() {
    }

    protected AbstractShipmentReceiptImageEvent(ShipmentReceiptImageEventId eventId) {
        this.shipmentReceiptImageEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractShipmentReceiptImageStateEvent extends AbstractShipmentReceiptImageEvent implements ShipmentReceiptImageEvent.ShipmentReceiptImageStateEvent {
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

        protected AbstractShipmentReceiptImageStateEvent(ShipmentReceiptImageEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractShipmentReceiptImageStateCreated extends AbstractShipmentReceiptImageStateEvent implements ShipmentReceiptImageEvent.ShipmentReceiptImageStateCreated
    {
        public AbstractShipmentReceiptImageStateCreated() {
            this(new ShipmentReceiptImageEventId());
        }

        public AbstractShipmentReceiptImageStateCreated(ShipmentReceiptImageEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractShipmentReceiptImageStateMergePatched extends AbstractShipmentReceiptImageStateEvent implements ShipmentReceiptImageEvent.ShipmentReceiptImageStateMergePatched
    {
        public AbstractShipmentReceiptImageStateMergePatched() {
            this(new ShipmentReceiptImageEventId());
        }

        public AbstractShipmentReceiptImageStateMergePatched(ShipmentReceiptImageEventId eventId) {
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


    public static abstract class AbstractShipmentReceiptImageStateRemoved extends AbstractShipmentReceiptImageStateEvent implements ShipmentReceiptImageEvent.ShipmentReceiptImageStateRemoved
    {
        public AbstractShipmentReceiptImageStateRemoved() {
            this(new ShipmentReceiptImageEventId());
        }

        public AbstractShipmentReceiptImageStateRemoved(ShipmentReceiptImageEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.REMOVED;
        }

    }
    public static class SimpleShipmentReceiptImageStateCreated extends AbstractShipmentReceiptImageStateCreated
    {
        public SimpleShipmentReceiptImageStateCreated() {
        }

        public SimpleShipmentReceiptImageStateCreated(ShipmentReceiptImageEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleShipmentReceiptImageStateMergePatched extends AbstractShipmentReceiptImageStateMergePatched
    {
        public SimpleShipmentReceiptImageStateMergePatched() {
        }

        public SimpleShipmentReceiptImageStateMergePatched(ShipmentReceiptImageEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleShipmentReceiptImageStateRemoved extends AbstractShipmentReceiptImageStateRemoved
    {
        public SimpleShipmentReceiptImageStateRemoved() {
        }

        public SimpleShipmentReceiptImageStateRemoved(ShipmentReceiptImageEventId eventId) {
            super(eventId);
        }
    }

}

