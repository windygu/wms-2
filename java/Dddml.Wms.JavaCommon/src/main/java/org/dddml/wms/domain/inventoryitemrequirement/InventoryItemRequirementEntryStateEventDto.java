package org.dddml.wms.domain.inventoryitemrequirement;

import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class InventoryItemRequirementEntryStateEventDto extends AbstractStateEvent
{

    private InventoryItemRequirementEntryStateEventIdDto stateEventId;

    InventoryItemRequirementEntryStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new InventoryItemRequirementEntryStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(InventoryItemRequirementEntryStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
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

    private InventoryPRTriggeredIdDto sourceEventId = new InventoryPRTriggeredIdDto();

    public InventoryPRTriggeredIdDto getSourceEventId() {
        return this.sourceEventId;
    }

    public void setSourceEventId(InventoryPRTriggeredIdDto sourceEventId) {
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
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class InventoryItemRequirementEntryStateMergePatchedDto extends InventoryItemRequirementEntryStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class InventoryItemRequirementEntryStateRemovedDto extends InventoryItemRequirementEntryStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_REMOVED;
        }

	}


}

