package org.dddml.wms.domain.roletype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractRoleTypeEvent extends AbstractEvent implements RoleTypeEvent.SqlRoleTypeEvent 
{
    private RoleTypeEventId roleTypeEventId;

    public RoleTypeEventId getRoleTypeEventId() {
        return this.roleTypeEventId;
    }

    public void setRoleTypeEventId(RoleTypeEventId eventId) {
        this.roleTypeEventId = eventId;
    }
    
    public String getRoleTypeId() {
        return getRoleTypeEventId().getRoleTypeId();
    }

    public void setRoleTypeId(String roleTypeId) {
        getRoleTypeEventId().setRoleTypeId(roleTypeId);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

    public Long getVersion() {
        return getRoleTypeEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getRoleTypeEventId().setVersion(version);
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

    protected AbstractRoleTypeEvent() {
    }

    protected AbstractRoleTypeEvent(RoleTypeEventId eventId) {
        this.roleTypeEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractRoleTypeStateEvent extends AbstractRoleTypeEvent implements RoleTypeEvent.RoleTypeStateEvent {
        private String parentTypeId;

        public String getParentTypeId()
        {
            return this.parentTypeId;
        }

        public void setParentTypeId(String parentTypeId)
        {
            this.parentTypeId = parentTypeId;
        }

        private String hasTable;

        public String getHasTable()
        {
            return this.hasTable;
        }

        public void setHasTable(String hasTable)
        {
            this.hasTable = hasTable;
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

        protected AbstractRoleTypeStateEvent(RoleTypeEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractRoleTypeStateCreated extends AbstractRoleTypeStateEvent implements RoleTypeEvent.RoleTypeStateCreated
    {
        public AbstractRoleTypeStateCreated() {
            this(new RoleTypeEventId());
        }

        public AbstractRoleTypeStateCreated(RoleTypeEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractRoleTypeStateMergePatched extends AbstractRoleTypeStateEvent implements RoleTypeEvent.RoleTypeStateMergePatched
    {
        public AbstractRoleTypeStateMergePatched() {
            this(new RoleTypeEventId());
        }

        public AbstractRoleTypeStateMergePatched(RoleTypeEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyParentTypeIdRemoved;

        public Boolean getIsPropertyParentTypeIdRemoved() {
            return this.isPropertyParentTypeIdRemoved;
        }

        public void setIsPropertyParentTypeIdRemoved(Boolean removed) {
            this.isPropertyParentTypeIdRemoved = removed;
        }

        private Boolean isPropertyHasTableRemoved;

        public Boolean getIsPropertyHasTableRemoved() {
            return this.isPropertyHasTableRemoved;
        }

        public void setIsPropertyHasTableRemoved(Boolean removed) {
            this.isPropertyHasTableRemoved = removed;
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


    public static abstract class AbstractRoleTypeStateDeleted extends AbstractRoleTypeStateEvent implements RoleTypeEvent.RoleTypeStateDeleted
    {
        public AbstractRoleTypeStateDeleted() {
            this(new RoleTypeEventId());
        }

        public AbstractRoleTypeStateDeleted(RoleTypeEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleRoleTypeStateCreated extends AbstractRoleTypeStateCreated
    {
        public SimpleRoleTypeStateCreated() {
        }

        public SimpleRoleTypeStateCreated(RoleTypeEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleRoleTypeStateMergePatched extends AbstractRoleTypeStateMergePatched
    {
        public SimpleRoleTypeStateMergePatched() {
        }

        public SimpleRoleTypeStateMergePatched(RoleTypeEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleRoleTypeStateDeleted extends AbstractRoleTypeStateDeleted
    {
        public SimpleRoleTypeStateDeleted() {
        }

        public SimpleRoleTypeStateDeleted(RoleTypeEventId eventId) {
            super(eventId);
        }
    }

}

