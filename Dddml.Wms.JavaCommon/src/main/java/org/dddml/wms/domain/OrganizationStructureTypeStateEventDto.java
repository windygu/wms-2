package org.dddml.wms.domain;

import java.util.Date;
import org.dddml.wms.domain.AbstractStateEvent;

public class OrganizationStructureTypeStateEventDto extends AbstractStateEvent
{

    private OrganizationStructureTypeStateEventIdDto stateEventId;

    OrganizationStructureTypeStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new OrganizationStructureTypeStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(OrganizationStructureTypeStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }

    public String getId() {
        return getStateEventId().getId();
    }

    public void setId(String id) {
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


	public static class OrganizationStructureTypeStateCreatedDto extends OrganizationStructureTypeStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class OrganizationStructureTypeStateMergePatchedDto extends OrganizationStructureTypeStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class OrganizationStructureTypeStateDeletedDto extends OrganizationStructureTypeStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

