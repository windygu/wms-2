package org.dddml.wms.domain.inventoryitemeventtype;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class InventoryItemEventTypeStateEventDto extends AbstractStateEvent
{

    private InventoryItemEventTypeStateEventIdDto stateEventId;

    InventoryItemEventTypeStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new InventoryItemEventTypeStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(InventoryItemEventTypeStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }

    public String getInventoryItemEventTypeId() {
        return getStateEventId().getInventoryItemEventTypeId();
    }

    public void setInventoryItemEventTypeId(String inventoryItemEventTypeId) {
        getStateEventId().setInventoryItemEventTypeId(inventoryItemEventTypeId);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
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


	public static class InventoryItemEventTypeStateCreatedDto extends InventoryItemEventTypeStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class InventoryItemEventTypeStateMergePatchedDto extends InventoryItemEventTypeStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class InventoryItemEventTypeStateDeletedDto extends InventoryItemEventTypeStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

