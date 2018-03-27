package org.dddml.wms.domain.roletype;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class RoleTypeStateEventDto extends AbstractStateEvent
{

    private RoleTypeEventId roleTypeEventId;

    RoleTypeEventId getStateEventId() {
        if (roleTypeEventId == null) { roleTypeEventId = new RoleTypeEventId(); }
        return roleTypeEventId;
    }

    void setRoleTypeEventId(RoleTypeEventId eventId) {
        this.roleTypeEventId = eventId;
    }

    public String getRoleTypeId() {
        return getStateEventId().getRoleTypeId();
    }

    public void setRoleTypeId(String roleTypeId) {
        getStateEventId().setRoleTypeId(roleTypeId);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
    }

    private String parentTypeId;

    public String getParentTypeId() {
        return this.parentTypeId;
    }

    public void setParentTypeId(String parentTypeId) {
        this.parentTypeId = parentTypeId;
    }

    private String hasTable;

    public String getHasTable() {
        return this.hasTable;
    }

    public void setHasTable(String hasTable) {
        this.hasTable = hasTable;
    }

    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private String createdBy;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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


	public static class RoleTypeStateCreatedDto extends RoleTypeStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class RoleTypeStateMergePatchedDto extends RoleTypeStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class RoleTypeStateDeletedDto extends RoleTypeStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

