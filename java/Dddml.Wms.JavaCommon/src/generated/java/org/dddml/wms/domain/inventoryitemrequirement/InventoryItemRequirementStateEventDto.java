package org.dddml.wms.domain.inventoryitemrequirement;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class InventoryItemRequirementStateEventDto extends AbstractEvent
{

    private InventoryItemRequirementEventId inventoryItemRequirementEventId;

    InventoryItemRequirementEventId getStateEventId() {
        if (inventoryItemRequirementEventId == null) { inventoryItemRequirementEventId = new InventoryItemRequirementEventId(); }
        return inventoryItemRequirementEventId;
    }

    void setInventoryItemRequirementEventId(InventoryItemRequirementEventId eventId) {
        this.inventoryItemRequirementEventId = eventId;
    }

    public InventoryItemId getInventoryItemRequirementId() {
        return getStateEventId().getInventoryItemRequirementId();
    }

    public void setInventoryItemRequirementId(InventoryItemId inventoryItemRequirementId) {
        getStateEventId().setInventoryItemRequirementId(inventoryItemRequirementId);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
    }

    private BigDecimal quantity;

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
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

    private Boolean isPropertyQuantityRemoved;

    public Boolean getIsPropertyQuantityRemoved() {
        return this.isPropertyQuantityRemoved;
    }

    public void setIsPropertyQuantityRemoved(Boolean removed) {
        this.isPropertyQuantityRemoved = removed;
    }


    private InventoryItemRequirementEntryStateEventDto[] inventoryItemRequirementEntryEvents;

    public InventoryItemRequirementEntryStateEventDto[] getInventoryItemRequirementEntryEvents() {
        return this.inventoryItemRequirementEntryEvents;
    }

    public void setInventoryItemRequirementEntryEvents(InventoryItemRequirementEntryStateEventDto[] events) {
        this.inventoryItemRequirementEntryEvents = events;
    }


	public static class InventoryItemRequirementStateCreatedDto extends InventoryItemRequirementStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class InventoryItemRequirementStateMergePatchedDto extends InventoryItemRequirementStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class InventoryItemRequirementStateDeletedDto extends InventoryItemRequirementStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

