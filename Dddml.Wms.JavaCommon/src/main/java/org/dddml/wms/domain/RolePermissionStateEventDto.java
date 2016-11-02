package org.dddml.wms.domain;

import java.util.Date;
import org.dddml.wms.domain.AbstractStateEvent;

public class RolePermissionStateEventDto extends AbstractStateEvent
{

    private RolePermissionStateEventIdDto stateEventId;

    RolePermissionStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new RolePermissionStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(RolePermissionStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }

    public RolePermissionIdDto getId() {
        return getStateEventId().getId();
    }

    public void setId(RolePermissionIdDto id) {
        getStateEventId().setId(id);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
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

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class RolePermissionStateCreatedDto extends RolePermissionStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class RolePermissionStateMergePatchedDto extends RolePermissionStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class RolePermissionStateDeletedDto extends RolePermissionStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

