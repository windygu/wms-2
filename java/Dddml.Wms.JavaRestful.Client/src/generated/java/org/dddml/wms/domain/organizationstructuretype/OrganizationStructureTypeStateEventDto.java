package org.dddml.wms.domain.organizationstructuretype;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class OrganizationStructureTypeStateEventDto extends AbstractEvent
{

    private OrganizationStructureTypeEventId organizationStructureTypeEventId;

    OrganizationStructureTypeEventId getOrganizationStructureTypeEventId() {
        if (organizationStructureTypeEventId == null) { organizationStructureTypeEventId = new OrganizationStructureTypeEventId(); }
        return organizationStructureTypeEventId;
    }

    void setOrganizationStructureTypeEventId(OrganizationStructureTypeEventId eventId) {
        this.organizationStructureTypeEventId = eventId;
    }

    public String getId() {
        return getOrganizationStructureTypeEventId().getId();
    }

    public void setId(String id) {
        getOrganizationStructureTypeEventId().setId(id);
    }

    public Long getVersion() {
        return getOrganizationStructureTypeEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getOrganizationStructureTypeEventId().setVersion(version);
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


	public static class OrganizationStructureTypeStateCreatedDto extends OrganizationStructureTypeStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class OrganizationStructureTypeStateMergePatchedDto extends OrganizationStructureTypeStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class OrganizationStructureTypeStateDeletedDto extends OrganizationStructureTypeStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

