package org.dddml.wms.domain.statusitem;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractStatusItemStateEvent extends AbstractStateEvent implements StatusItemStateEvent 
{
    private StatusItemEventId stateEventId;

    public StatusItemEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(StatusItemEventId eventId) {
        this.stateEventId = eventId;
    }
    
    public String getStatusId() {
        return getStateEventId().getStatusId();
    }

    public void setStatusId(String statusId) {
        getStateEventId().setStatusId(statusId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private String statusTypeId;

    public String getStatusTypeId()
    {
        return this.statusTypeId;
    }

    public void setStatusTypeId(String statusTypeId)
    {
        this.statusTypeId = statusTypeId;
    }

    private String statusCode;

    public String getStatusCode()
    {
        return this.statusCode;
    }

    public void setStatusCode(String statusCode)
    {
        this.statusCode = statusCode;
    }

    private String sequenceId;

    public String getSequenceId()
    {
        return this.sequenceId;
    }

    public void setSequenceId(String sequenceId)
    {
        this.sequenceId = sequenceId;
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

    protected AbstractStatusItemStateEvent() {
    }

    protected AbstractStatusItemStateEvent(StatusItemEventId eventId) {
        this.stateEventId = eventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractStatusItemStateCreated extends AbstractStatusItemStateEvent implements StatusItemStateEvent.StatusItemStateCreated
    {
        public AbstractStatusItemStateCreated() {
            this(new StatusItemEventId());
        }

        public AbstractStatusItemStateCreated(StatusItemEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractStatusItemStateMergePatched extends AbstractStatusItemStateEvent implements StatusItemStateEvent.StatusItemStateMergePatched
    {
        public AbstractStatusItemStateMergePatched() {
            this(new StatusItemEventId());
        }

        public AbstractStatusItemStateMergePatched(StatusItemEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyStatusTypeIdRemoved;

        public Boolean getIsPropertyStatusTypeIdRemoved() {
            return this.isPropertyStatusTypeIdRemoved;
        }

        public void setIsPropertyStatusTypeIdRemoved(Boolean removed) {
            this.isPropertyStatusTypeIdRemoved = removed;
        }

        private Boolean isPropertyStatusCodeRemoved;

        public Boolean getIsPropertyStatusCodeRemoved() {
            return this.isPropertyStatusCodeRemoved;
        }

        public void setIsPropertyStatusCodeRemoved(Boolean removed) {
            this.isPropertyStatusCodeRemoved = removed;
        }

        private Boolean isPropertySequenceIdRemoved;

        public Boolean getIsPropertySequenceIdRemoved() {
            return this.isPropertySequenceIdRemoved;
        }

        public void setIsPropertySequenceIdRemoved(Boolean removed) {
            this.isPropertySequenceIdRemoved = removed;
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


    public static class SimpleStatusItemStateCreated extends AbstractStatusItemStateCreated
    {
        public SimpleStatusItemStateCreated() {
        }

        public SimpleStatusItemStateCreated(StatusItemEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleStatusItemStateMergePatched extends AbstractStatusItemStateMergePatched
    {
        public SimpleStatusItemStateMergePatched() {
        }

        public SimpleStatusItemStateMergePatched(StatusItemEventId eventId) {
            super(eventId);
        }
    }

}

