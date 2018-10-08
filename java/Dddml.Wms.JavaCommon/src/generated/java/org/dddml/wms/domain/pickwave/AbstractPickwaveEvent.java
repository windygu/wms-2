package org.dddml.wms.domain.pickwave;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractPickwaveEvent extends AbstractEvent implements PickwaveEvent.SqlPickwaveEvent 
{
    private PickwaveEventId pickwaveEventId;

    public PickwaveEventId getPickwaveEventId() {
        return this.pickwaveEventId;
    }

    public void setPickwaveEventId(PickwaveEventId eventId) {
        this.pickwaveEventId = eventId;
    }
    
    public Long getPickwaveId() {
        return getPickwaveEventId().getPickwaveId();
    }

    public void setPickwaveId(Long pickwaveId) {
        getPickwaveEventId().setPickwaveId(pickwaveId);
    }

    public Long getVersion() {
        return getPickwaveEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getPickwaveEventId().setVersion(version);
    //}

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

    protected AbstractPickwaveEvent() {
    }

    protected AbstractPickwaveEvent(PickwaveEventId eventId) {
        this.pickwaveEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractPickwaveStateEvent extends AbstractPickwaveEvent implements PickwaveEvent.PickwaveStateEvent {
        private String statusId;

        public String getStatusId()
        {
            return this.statusId;
        }

        public void setStatusId(String statusId)
        {
            this.statusId = statusId;
        }

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

        protected AbstractPickwaveStateEvent(PickwaveEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractPickwaveStateCreated extends AbstractPickwaveStateEvent implements PickwaveEvent.PickwaveStateCreated
    {
        public AbstractPickwaveStateCreated() {
            this(new PickwaveEventId());
        }

        public AbstractPickwaveStateCreated(PickwaveEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractPickwaveStateMergePatched extends AbstractPickwaveStateEvent implements PickwaveEvent.PickwaveStateMergePatched
    {
        public AbstractPickwaveStateMergePatched() {
            this(new PickwaveEventId());
        }

        public AbstractPickwaveStateMergePatched(PickwaveEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyStatusIdRemoved;

        public Boolean getIsPropertyStatusIdRemoved() {
            return this.isPropertyStatusIdRemoved;
        }

        public void setIsPropertyStatusIdRemoved(Boolean removed) {
            this.isPropertyStatusIdRemoved = removed;
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


    public static abstract class AbstractPickwaveStateDeleted extends AbstractPickwaveStateEvent implements PickwaveEvent.PickwaveStateDeleted
    {
        public AbstractPickwaveStateDeleted() {
            this(new PickwaveEventId());
        }

        public AbstractPickwaveStateDeleted(PickwaveEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimplePickwaveStateCreated extends AbstractPickwaveStateCreated
    {
        public SimplePickwaveStateCreated() {
        }

        public SimplePickwaveStateCreated(PickwaveEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePickwaveStateMergePatched extends AbstractPickwaveStateMergePatched
    {
        public SimplePickwaveStateMergePatched() {
        }

        public SimplePickwaveStateMergePatched(PickwaveEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePickwaveStateDeleted extends AbstractPickwaveStateDeleted
    {
        public SimplePickwaveStateDeleted() {
        }

        public SimplePickwaveStateDeleted(PickwaveEventId eventId) {
            super(eventId);
        }
    }

}

