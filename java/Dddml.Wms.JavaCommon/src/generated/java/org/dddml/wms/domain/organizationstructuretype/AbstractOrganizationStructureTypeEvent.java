package org.dddml.wms.domain.organizationstructuretype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractOrganizationStructureTypeEvent extends AbstractEvent implements OrganizationStructureTypeEvent 
{
    private OrganizationStructureTypeEventId organizationStructureTypeEventId;

    public OrganizationStructureTypeEventId getOrganizationStructureTypeEventId() {
        return this.organizationStructureTypeEventId;
    }

    public void setOrganizationStructureTypeEventId(OrganizationStructureTypeEventId eventId) {
        this.organizationStructureTypeEventId = eventId;
    }
    
    public String getId() {
        return getOrganizationStructureTypeEventId().getId();
    }

    public void setId(String id) {
        getOrganizationStructureTypeEventId().setId(id);
    }

    private boolean stateEventReadOnly;

    public boolean getEventReadOnly() { return this.stateEventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    protected AbstractOrganizationStructureTypeEvent() {
    }

    protected AbstractOrganizationStructureTypeEvent(OrganizationStructureTypeEventId eventId) {
        this.organizationStructureTypeEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractOrganizationStructureTypeStateCreated extends AbstractOrganizationStructureTypeEvent implements OrganizationStructureTypeEvent.OrganizationStructureTypeStateCreated
    {
        public AbstractOrganizationStructureTypeStateCreated() {
            this(new OrganizationStructureTypeEventId());
        }

        public AbstractOrganizationStructureTypeStateCreated(OrganizationStructureTypeEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractOrganizationStructureTypeStateMergePatched extends AbstractOrganizationStructureTypeEvent implements OrganizationStructureTypeEvent.OrganizationStructureTypeStateMergePatched
    {
        public AbstractOrganizationStructureTypeStateMergePatched() {
            this(new OrganizationStructureTypeEventId());
        }

        public AbstractOrganizationStructureTypeStateMergePatched(OrganizationStructureTypeEventId eventId) {
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


    public static abstract class AbstractOrganizationStructureTypeStateDeleted extends AbstractOrganizationStructureTypeEvent implements OrganizationStructureTypeEvent.OrganizationStructureTypeStateDeleted
    {
        public AbstractOrganizationStructureTypeStateDeleted() {
            this(new OrganizationStructureTypeEventId());
        }

        public AbstractOrganizationStructureTypeStateDeleted(OrganizationStructureTypeEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleOrganizationStructureTypeStateCreated extends AbstractOrganizationStructureTypeStateCreated
    {
        public SimpleOrganizationStructureTypeStateCreated() {
        }

        public SimpleOrganizationStructureTypeStateCreated(OrganizationStructureTypeEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrganizationStructureTypeStateMergePatched extends AbstractOrganizationStructureTypeStateMergePatched
    {
        public SimpleOrganizationStructureTypeStateMergePatched() {
        }

        public SimpleOrganizationStructureTypeStateMergePatched(OrganizationStructureTypeEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrganizationStructureTypeStateDeleted extends AbstractOrganizationStructureTypeStateDeleted
    {
        public SimpleOrganizationStructureTypeStateDeleted() {
        }

        public SimpleOrganizationStructureTypeStateDeleted(OrganizationStructureTypeEventId eventId) {
            super(eventId);
        }
    }

}

