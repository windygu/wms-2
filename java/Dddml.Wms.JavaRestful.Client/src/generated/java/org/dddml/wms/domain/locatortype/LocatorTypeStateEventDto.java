package org.dddml.wms.domain.locatortype;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class LocatorTypeStateEventDto extends AbstractEvent
{

    private LocatorTypeEventId locatorTypeEventId;

    LocatorTypeEventId getLocatorTypeEventId() {
        if (locatorTypeEventId == null) { locatorTypeEventId = new LocatorTypeEventId(); }
        return locatorTypeEventId;
    }

    void setLocatorTypeEventId(LocatorTypeEventId eventId) {
        this.locatorTypeEventId = eventId;
    }

    public String getLocatorTypeId() {
        return getLocatorTypeEventId().getLocatorTypeId();
    }

    public void setLocatorTypeId(String locatorTypeId) {
        getLocatorTypeEventId().setLocatorTypeId(locatorTypeId);
    }

    public Long getVersion() {
        return getLocatorTypeEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getLocatorTypeEventId().setVersion(version);
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


	public static class LocatorTypeStateCreatedDto extends LocatorTypeStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class LocatorTypeStateMergePatchedDto extends LocatorTypeStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class LocatorTypeStateDeletedDto extends LocatorTypeStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

