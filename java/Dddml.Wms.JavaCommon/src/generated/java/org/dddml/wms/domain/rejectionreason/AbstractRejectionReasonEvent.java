package org.dddml.wms.domain.rejectionreason;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractRejectionReasonEvent extends AbstractEvent implements RejectionReasonEvent.SqlRejectionReasonEvent 
{
    private RejectionReasonEventId rejectionReasonEventId;

    public RejectionReasonEventId getRejectionReasonEventId() {
        return this.rejectionReasonEventId;
    }

    public void setRejectionReasonEventId(RejectionReasonEventId eventId) {
        this.rejectionReasonEventId = eventId;
    }
    
    public String getRejectionReasonId() {
        return getRejectionReasonEventId().getRejectionReasonId();
    }

    public void setRejectionReasonId(String rejectionReasonId) {
        getRejectionReasonEventId().setRejectionReasonId(rejectionReasonId);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

    public Long getVersion() {
        return getRejectionReasonEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getRejectionReasonEventId().setVersion(version);
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

    protected AbstractRejectionReasonEvent() {
    }

    protected AbstractRejectionReasonEvent(RejectionReasonEventId eventId) {
        this.rejectionReasonEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractRejectionReasonStateEvent extends AbstractRejectionReasonEvent implements RejectionReasonEvent.RejectionReasonStateEvent {
        private String description;

        public String getDescription()
        {
            return this.description;
        }

        public void setDescription(String description)
        {
            this.description = description;
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

        protected AbstractRejectionReasonStateEvent(RejectionReasonEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractRejectionReasonStateCreated extends AbstractRejectionReasonStateEvent implements RejectionReasonEvent.RejectionReasonStateCreated
    {
        public AbstractRejectionReasonStateCreated() {
            this(new RejectionReasonEventId());
        }

        public AbstractRejectionReasonStateCreated(RejectionReasonEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractRejectionReasonStateMergePatched extends AbstractRejectionReasonStateEvent implements RejectionReasonEvent.RejectionReasonStateMergePatched
    {
        public AbstractRejectionReasonStateMergePatched() {
            this(new RejectionReasonEventId());
        }

        public AbstractRejectionReasonStateMergePatched(RejectionReasonEventId eventId) {
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

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractRejectionReasonStateDeleted extends AbstractRejectionReasonStateEvent implements RejectionReasonEvent.RejectionReasonStateDeleted
    {
        public AbstractRejectionReasonStateDeleted() {
            this(new RejectionReasonEventId());
        }

        public AbstractRejectionReasonStateDeleted(RejectionReasonEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleRejectionReasonStateCreated extends AbstractRejectionReasonStateCreated
    {
        public SimpleRejectionReasonStateCreated() {
        }

        public SimpleRejectionReasonStateCreated(RejectionReasonEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleRejectionReasonStateMergePatched extends AbstractRejectionReasonStateMergePatched
    {
        public SimpleRejectionReasonStateMergePatched() {
        }

        public SimpleRejectionReasonStateMergePatched(RejectionReasonEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleRejectionReasonStateDeleted extends AbstractRejectionReasonStateDeleted
    {
        public SimpleRejectionReasonStateDeleted() {
        }

        public SimpleRejectionReasonStateDeleted(RejectionReasonEventId eventId) {
            super(eventId);
        }
    }

}

