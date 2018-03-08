package org.dddml.wms.domain.organizationstructure;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class OrganizationStructureStateEventDto extends AbstractStateEvent
{

    private OrganizationStructureEventId stateEventId;

    OrganizationStructureEventId getStateEventId() {
        if (stateEventId == null) { stateEventId = new OrganizationStructureEventId(); }
        return stateEventId;
    }

    void setStateEventId(OrganizationStructureEventId eventId) {
        this.stateEventId = eventId;
    }

    public OrganizationStructureId getId() {
        return getStateEventId().getId();
    }

    public void setId(OrganizationStructureId id) {
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


	public static class OrganizationStructureStateCreatedDto extends OrganizationStructureStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class OrganizationStructureStateMergePatchedDto extends OrganizationStructureStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class OrganizationStructureStateDeletedDto extends OrganizationStructureStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

