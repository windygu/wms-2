package org.dddml.wms.domain.inventoryitemrequirement;

import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class InventoryItemRequirementEntryStateEventDto extends AbstractEvent
{

    private InventoryItemRequirementEntryEventId inventoryItemRequirementEntryEventId;

    InventoryItemRequirementEntryEventId getStateEventId() {
        if (inventoryItemRequirementEntryEventId == null) { inventoryItemRequirementEntryEventId = new InventoryItemRequirementEntryEventId(); }
        return inventoryItemRequirementEntryEventId;
    }

    void setInventoryItemRequirementEntryEventId(InventoryItemRequirementEntryEventId eventId) {
        this.inventoryItemRequirementEntryEventId = eventId;
    }

    public Long getEntrySeqId() {
        return getStateEventId().getEntrySeqId();
    }

    public void setEntrySeqId(Long entrySeqId) {
        getStateEventId().setEntrySeqId(entrySeqId);
    }

    private BigDecimal quantity;

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    private InventoryPRTriggeredId sourceEventId;

    public InventoryPRTriggeredId getSourceEventId() {
        return this.sourceEventId;
    }

    public void setSourceEventId(InventoryPRTriggeredId sourceEventId) {
        this.sourceEventId = sourceEventId;
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

    private Long version;

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    private Boolean isPropertyQuantityRemoved;

    public Boolean getIsPropertyQuantityRemoved() {
        return this.isPropertyQuantityRemoved;
    }

    public void setIsPropertyQuantityRemoved(Boolean removed) {
        this.isPropertyQuantityRemoved = removed;
    }

    private Boolean isPropertySourceEventIdRemoved;

    public Boolean getIsPropertySourceEventIdRemoved() {
        return this.isPropertySourceEventIdRemoved;
    }

    public void setIsPropertySourceEventIdRemoved(Boolean removed) {
        this.isPropertySourceEventIdRemoved = removed;
    }


	public static class InventoryItemRequirementEntryStateCreatedDto extends InventoryItemRequirementEntryStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class InventoryItemRequirementEntryStateMergePatchedDto extends InventoryItemRequirementEntryStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class InventoryItemRequirementEntryStateRemovedDto extends InventoryItemRequirementEntryStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_REMOVED;
        }

	}


}

