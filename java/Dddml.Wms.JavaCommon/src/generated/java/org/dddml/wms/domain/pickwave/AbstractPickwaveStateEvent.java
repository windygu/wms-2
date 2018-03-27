package org.dddml.wms.domain.pickwave;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractPickwaveStateEvent extends AbstractStateEvent implements PickwaveStateEvent 
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

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    protected AbstractPickwaveStateEvent() {
    }

    protected AbstractPickwaveStateEvent(PickwaveEventId eventId) {
        this.pickwaveEventId = eventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractPickwaveStateCreated extends AbstractPickwaveStateEvent implements PickwaveStateEvent.PickwaveStateCreated
    {
        public AbstractPickwaveStateCreated() {
            this(new PickwaveEventId());
        }

        public AbstractPickwaveStateCreated(PickwaveEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractPickwaveStateMergePatched extends AbstractPickwaveStateEvent implements PickwaveStateEvent.PickwaveStateMergePatched
    {
        public AbstractPickwaveStateMergePatched() {
            this(new PickwaveEventId());
        }

        public AbstractPickwaveStateMergePatched(PickwaveEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
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


    public static abstract class AbstractPickwaveStateDeleted extends AbstractPickwaveStateEvent implements PickwaveStateEvent.PickwaveStateDeleted
    {
        public AbstractPickwaveStateDeleted() {
            this(new PickwaveEventId());
        }

        public AbstractPickwaveStateDeleted(PickwaveEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
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

