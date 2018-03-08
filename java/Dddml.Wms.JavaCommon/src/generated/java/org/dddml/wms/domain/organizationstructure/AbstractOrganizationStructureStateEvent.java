package org.dddml.wms.domain.organizationstructure;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractOrganizationStructureStateEvent extends AbstractStateEvent implements OrganizationStructureStateEvent 
{
    private OrganizationStructureEventId organizationStructureEventId;

    public OrganizationStructureEventId getOrganizationStructureEventId() {
        return this.organizationStructureEventId;
    }

    public void setOrganizationStructureEventId(OrganizationStructureEventId eventId) {
        this.organizationStructureEventId = eventId;
    }
    
    public OrganizationStructureId getId() {
        return getOrganizationStructureEventId().getId();
    }

    public void setId(OrganizationStructureId id) {
        getOrganizationStructureEventId().setId(id);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    protected AbstractOrganizationStructureStateEvent() {
    }

    protected AbstractOrganizationStructureStateEvent(OrganizationStructureEventId eventId) {
        this.organizationStructureEventId = eventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractOrganizationStructureStateCreated extends AbstractOrganizationStructureStateEvent implements OrganizationStructureStateEvent.OrganizationStructureStateCreated
    {
        public AbstractOrganizationStructureStateCreated() {
            this(new OrganizationStructureEventId());
        }

        public AbstractOrganizationStructureStateCreated(OrganizationStructureEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractOrganizationStructureStateMergePatched extends AbstractOrganizationStructureStateEvent implements OrganizationStructureStateEvent.OrganizationStructureStateMergePatched
    {
        public AbstractOrganizationStructureStateMergePatched() {
            this(new OrganizationStructureEventId());
        }

        public AbstractOrganizationStructureStateMergePatched(OrganizationStructureEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractOrganizationStructureStateDeleted extends AbstractOrganizationStructureStateEvent implements OrganizationStructureStateEvent.OrganizationStructureStateDeleted
    {
        public AbstractOrganizationStructureStateDeleted() {
            this(new OrganizationStructureEventId());
        }

        public AbstractOrganizationStructureStateDeleted(OrganizationStructureEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleOrganizationStructureStateCreated extends AbstractOrganizationStructureStateCreated
    {
        public SimpleOrganizationStructureStateCreated() {
        }

        public SimpleOrganizationStructureStateCreated(OrganizationStructureEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrganizationStructureStateMergePatched extends AbstractOrganizationStructureStateMergePatched
    {
        public SimpleOrganizationStructureStateMergePatched() {
        }

        public SimpleOrganizationStructureStateMergePatched(OrganizationStructureEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrganizationStructureStateDeleted extends AbstractOrganizationStructureStateDeleted
    {
        public SimpleOrganizationStructureStateDeleted() {
        }

        public SimpleOrganizationStructureStateDeleted(OrganizationStructureEventId eventId) {
            super(eventId);
        }
    }

}

