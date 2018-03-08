package org.dddml.wms.domain.warehouse;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class WarehouseStateEventDto extends AbstractStateEvent
{

    private WarehouseEventId stateEventId;

    WarehouseEventId getStateEventId() {
        if (stateEventId == null) { stateEventId = new WarehouseEventId(); }
        return stateEventId;
    }

    void setStateEventId(WarehouseEventId eventId) {
        this.stateEventId = eventId;
    }

    public String getWarehouseId() {
        return getStateEventId().getWarehouseId();
    }

    public void setWarehouseId(String warehouseId) {
        getStateEventId().setWarehouseId(warehouseId);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
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
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class WarehouseStateMergePatchedDto extends WarehouseStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class WarehouseStateDeletedDto extends WarehouseStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

