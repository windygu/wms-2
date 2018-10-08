package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractPicklistItemEvent extends AbstractEvent implements PicklistItemEvent.SqlPicklistItemEvent 
{
    private PicklistItemEventId picklistItemEventId;

    public PicklistItemEventId getPicklistItemEventId() {
        return this.picklistItemEventId;
    }

    public void setPicklistItemEventId(PicklistItemEventId eventId) {
        this.picklistItemEventId = eventId;
    }
    
    public PicklistItemOrderShipGrpInvId getPicklistItemOrderShipGrpInvId() {
        return getPicklistItemEventId().getPicklistItemOrderShipGrpInvId();
    }

    public void setPicklistItemOrderShipGrpInvId(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId) {
        getPicklistItemEventId().setPicklistItemOrderShipGrpInvId(picklistItemOrderShipGrpInvId);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

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

    protected AbstractPicklistItemEvent() {
    }

    protected AbstractPicklistItemEvent(PicklistItemEventId eventId) {
        this.picklistItemEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractPicklistItemStateEvent extends AbstractPicklistItemEvent implements PicklistItemEvent.PicklistItemStateEvent {
        private Long version;

        public Long getVersion()
        {
            return this.version;
        }

        public void setVersion(Long version)
        {
            this.version = version;
        }

        private String itemStatusId;

        public String getItemStatusId()
        {
            return this.itemStatusId;
        }

        public void setItemStatusId(String itemStatusId)
        {
            this.itemStatusId = itemStatusId;
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

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        protected AbstractPicklistItemStateEvent(PicklistItemEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractPicklistItemStateCreated extends AbstractPicklistItemStateEvent implements PicklistItemEvent.PicklistItemStateCreated
    {
        public AbstractPicklistItemStateCreated() {
            this(new PicklistItemEventId());
        }

        public AbstractPicklistItemStateCreated(PicklistItemEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractPicklistItemStateMergePatched extends AbstractPicklistItemStateEvent implements PicklistItemEvent.PicklistItemStateMergePatched
    {
        public AbstractPicklistItemStateMergePatched() {
            this(new PicklistItemEventId());
        }

        public AbstractPicklistItemStateMergePatched(PicklistItemEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyItemStatusIdRemoved;

        public Boolean getIsPropertyItemStatusIdRemoved() {
            return this.isPropertyItemStatusIdRemoved;
        }

        public void setIsPropertyItemStatusIdRemoved(Boolean removed) {
            this.isPropertyItemStatusIdRemoved = removed;
        }

        private Boolean isPropertyQuantityRemoved;

        public Boolean getIsPropertyQuantityRemoved() {
            return this.isPropertyQuantityRemoved;
        }

        public void setIsPropertyQuantityRemoved(Boolean removed) {
            this.isPropertyQuantityRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractPicklistItemStateRemoved extends AbstractPicklistItemStateEvent implements PicklistItemEvent.PicklistItemStateRemoved
    {
        public AbstractPicklistItemStateRemoved() {
            this(new PicklistItemEventId());
        }

        public AbstractPicklistItemStateRemoved(PicklistItemEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.REMOVED;
        }

    }
    public static class SimplePicklistItemStateCreated extends AbstractPicklistItemStateCreated
    {
        public SimplePicklistItemStateCreated() {
        }

        public SimplePicklistItemStateCreated(PicklistItemEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePicklistItemStateMergePatched extends AbstractPicklistItemStateMergePatched
    {
        public SimplePicklistItemStateMergePatched() {
        }

        public SimplePicklistItemStateMergePatched(PicklistItemEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePicklistItemStateRemoved extends AbstractPicklistItemStateRemoved
    {
        public SimplePicklistItemStateRemoved() {
        }

        public SimplePicklistItemStateRemoved(PicklistItemEventId eventId) {
            super(eventId);
        }
    }

}

