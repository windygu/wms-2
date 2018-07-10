package org.dddml.wms.domain.warehouse;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class WarehouseStateEventDto extends AbstractEvent
{

    private WarehouseEventId warehouseEventId;

    WarehouseEventId getWarehouseEventId() {
        if (warehouseEventId == null) { warehouseEventId = new WarehouseEventId(); }
        return warehouseEventId;
    }

    void setWarehouseEventId(WarehouseEventId eventId) {
        this.warehouseEventId = eventId;
    }

    public String getWarehouseId() {
        return getWarehouseEventId().getWarehouseId();
    }

    public void setWarehouseId(String warehouseId) {
        getWarehouseEventId().setWarehouseId(warehouseId);
    }

    public Long getVersion() {
        return getWarehouseEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getWarehouseEventId().setVersion(version);
    }

    private String warehouseName;

    public String getWarehouseName() {
        return this.warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Boolean isInTransit;

    public Boolean getIsInTransit() {
        return this.isInTransit;
    }

    public void setIsInTransit(Boolean isInTransit) {
        this.isInTransit = isInTransit;
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

    private Boolean isPropertyWarehouseNameRemoved;

    public Boolean getIsPropertyWarehouseNameRemoved() {
        return this.isPropertyWarehouseNameRemoved;
    }

    public void setIsPropertyWarehouseNameRemoved(Boolean removed) {
        this.isPropertyWarehouseNameRemoved = removed;
    }

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved() {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed) {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertyIsInTransitRemoved;

    public Boolean getIsPropertyIsInTransitRemoved() {
        return this.isPropertyIsInTransitRemoved;
    }

    public void setIsPropertyIsInTransitRemoved(Boolean removed) {
        this.isPropertyIsInTransitRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class WarehouseStateCreatedDto extends WarehouseStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class WarehouseStateMergePatchedDto extends WarehouseStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class WarehouseStateDeletedDto extends WarehouseStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

