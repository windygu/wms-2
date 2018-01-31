package org.dddml.wms.domain.organizationstructure;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractOrganizationStructureStateEvent extends AbstractStateEvent implements OrganizationStructureStateEvent 
{
    private OrganizationStructureStateEventId stateEventId;

    public OrganizationStructureStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(OrganizationStructureStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public OrganizationStructureId getId() {
        return getStateEventId().getId();
    }

    public void setId(OrganizationStructureId id) {
        getStateEventId().setId(id);
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

    protected AbstractOrganizationStructureStateEvent(OrganizationStructureStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractOrganizationStructureStateCreated extends AbstractOrganizationStructureStateEvent implements OrganizationStructureStateEvent.OrganizationStructureStateCreated
    {
        public AbstractOrganizationStructureStateCreated() {
            this(new OrganizationStructureStateEventId());
        }

        public AbstractOrganizationStructureStateCreated(OrganizationStructureStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractOrganizationStructureStateMergePatched extends AbstractOrganizationStructureStateEvent implements OrganizationStructureStateEvent.OrganizationStructureStateMergePatched
    {
        public AbstractOrganizationStructureStateMergePatched() {
            this(new OrganizationStructureStateEventId());
        }

        public AbstractOrganizationStructureStateMergePatched(OrganizationStructureStateEventId stateEventId) {
            super(stateEventId);
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
            this(new OrganizationStructureStateEventId());
        }

        public AbstractOrganizationStructureStateDeleted(OrganizationStructureStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleOrganizationStructureStateCreated extends AbstractOrganizationStructureStateCreated
    {
        public SimpleOrganizationStructureStateCreated() {
        }

        public SimpleOrganizationStructureStateCreated(OrganizationStructureStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleOrganizationStructureStateMergePatched extends AbstractOrganizationStructureStateMergePatched
    {
        public SimpleOrganizationStructureStateMergePatched() {
        }

        public SimpleOrganizationStructureStateMergePatched(OrganizationStructureStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleOrganizationStructureStateDeleted extends AbstractOrganizationStructureStateDeleted
    {
        public SimpleOrganizationStructureStateDeleted() {
        }

        public SimpleOrganizationStructureStateDeleted(OrganizationStructureStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

