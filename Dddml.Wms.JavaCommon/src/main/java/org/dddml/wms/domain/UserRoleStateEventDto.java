package org.dddml.wms.domain;

import java.util.Date;
import org.dddml.wms.domain.AbstractStateEvent;

public class UserRoleStateEventDto extends AbstractStateEvent
{

    private UserRoleStateEventIdDto stateEventId;

    UserRoleStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new UserRoleStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(UserRoleStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }

    public String getRoleId() {
        return getStateEventId().getRoleId();
    }

    public void setRoleId(String roleId) {
        getStateEventId().setRoleId(roleId);
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

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class UserRoleStateCreatedDto extends UserRoleStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class UserRoleStateMergePatchedDto extends UserRoleStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class UserRoleStateRemovedDto extends UserRoleStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_REMOVED;
        }

	}


}

