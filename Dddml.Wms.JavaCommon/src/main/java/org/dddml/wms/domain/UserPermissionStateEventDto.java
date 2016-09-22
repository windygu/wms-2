package org.dddml.wms.domain;

import java.util.Date;
import org.dddml.wms.domain.AbstractStateEvent;

public class UserPermissionStateEventDto extends AbstractStateEvent
{
    private String stateEventType;

    public String getStateEventType() {
        return this.stateEventType;
    }

    public void setStateEventType(String type) {
        this.stateEventType = type;
    }

    private UserPermissionStateEventIdDto stateEventId;

    UserPermissionStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new UserPermissionStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(UserPermissionStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }
    public String getPermissionId() {
        return getStateEventId().getPermissionId();
    }

    public void setPermissionId(String permissionId) {
        getStateEventId().setPermissionId(permissionId);
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

    private Long version;

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class UserPermissionStateCreatedDto extends UserPermissionStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class UserPermissionStateMergePatchedDto extends UserPermissionStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public class UserPermissionStateRemovedDto extends UserPermissionStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_REMOVED;
        }

	}


}

