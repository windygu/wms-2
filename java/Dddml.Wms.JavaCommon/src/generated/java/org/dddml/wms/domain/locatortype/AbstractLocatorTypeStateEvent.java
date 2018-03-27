package org.dddml.wms.domain.locatortype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractLocatorTypeStateEvent extends AbstractStateEvent implements LocatorTypeStateEvent 
{
    private LocatorTypeEventId locatorTypeEventId;

    public LocatorTypeEventId getLocatorTypeEventId() {
        return this.locatorTypeEventId;
    }

    public void setLocatorTypeEventId(LocatorTypeEventId eventId) {
        this.locatorTypeEventId = eventId;
    }
    
    public String getLocatorTypeId() {
        return getLocatorTypeEventId().getLocatorTypeId();
    }

    public void setLocatorTypeId(String locatorTypeId) {
        getLocatorTypeEventId().setLocatorTypeId(locatorTypeId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    protected AbstractLocatorTypeStateEvent() {
    }

    protected AbstractLocatorTypeStateEvent(LocatorTypeEventId eventId) {
        this.locatorTypeEventId = eventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractLocatorTypeStateCreated extends AbstractLocatorTypeStateEvent implements LocatorTypeStateEvent.LocatorTypeStateCreated
    {
        public AbstractLocatorTypeStateCreated() {
            this(new LocatorTypeEventId());
        }

        public AbstractLocatorTypeStateCreated(LocatorTypeEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractLocatorTypeStateMergePatched extends AbstractLocatorTypeStateEvent implements LocatorTypeStateEvent.LocatorTypeStateMergePatched
    {
        public AbstractLocatorTypeStateMergePatched() {
            this(new LocatorTypeEventId());
        }

        public AbstractLocatorTypeStateMergePatched(LocatorTypeEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
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


    public static abstract class AbstractLocatorTypeStateDeleted extends AbstractLocatorTypeStateEvent implements LocatorTypeStateEvent.LocatorTypeStateDeleted
    {
        public AbstractLocatorTypeStateDeleted() {
            this(new LocatorTypeEventId());
        }

        public AbstractLocatorTypeStateDeleted(LocatorTypeEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleLocatorTypeStateCreated extends AbstractLocatorTypeStateCreated
    {
        public SimpleLocatorTypeStateCreated() {
        }

        public SimpleLocatorTypeStateCreated(LocatorTypeEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleLocatorTypeStateMergePatched extends AbstractLocatorTypeStateMergePatched
    {
        public SimpleLocatorTypeStateMergePatched() {
        }

        public SimpleLocatorTypeStateMergePatched(LocatorTypeEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleLocatorTypeStateDeleted extends AbstractLocatorTypeStateDeleted
    {
        public SimpleLocatorTypeStateDeleted() {
        }

        public SimpleLocatorTypeStateDeleted(LocatorTypeEventId eventId) {
            super(eventId);
        }
    }

}

