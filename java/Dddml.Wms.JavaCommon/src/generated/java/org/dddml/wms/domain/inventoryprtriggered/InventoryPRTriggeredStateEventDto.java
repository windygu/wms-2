package org.dddml.wms.domain.inventoryprtriggered;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class InventoryPRTriggeredStateEventDto extends AbstractStateEvent
{

    private InventoryPRTriggeredEventId stateEventId;

    InventoryPRTriggeredEventId getStateEventId() {
        if (stateEventId == null) { stateEventId = new InventoryPRTriggeredEventId(); }
        return stateEventId;
    }

    void setStateEventId(InventoryPRTriggeredEventId eventId) {
        this.stateEventId = eventId;
    }

    public InventoryPRTriggeredId getInventoryPRTriggeredId() {
        return getStateEventId().getInventoryPRTriggeredId();
    }

    public void setInventoryPRTriggeredId(InventoryPRTriggeredId inventoryPRTriggeredId) {
        getStateEventId().setInventoryPRTriggeredId(inventoryPRTriggeredId);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
    }

    private Boolean isProcessed;

    public Boolean getIsProcessed() {
        return this.isProcessed;
    }

    public void setIsProcessed(Boolean isProcessed) {
        this.isProcessed = isProcessed;
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

    private Boolean isPropertyIsProcessedRemoved;

    public Boolean getIsPropertyIsProcessedRemoved() {
        return this.isPropertyIsProcessedRemoved;
    }

    public void setIsPropertyIsProcessedRemoved(Boolean removed) {
        this.isPropertyIsProcessedRemoved = removed;
    }


	public static class InventoryPRTriggeredStateCreatedDto extends InventoryPRTriggeredStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class InventoryPRTriggeredStateMergePatchedDto extends InventoryPRTriggeredStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class InventoryPRTriggeredStateDeletedDto extends InventoryPRTriggeredStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

