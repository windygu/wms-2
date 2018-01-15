package org.dddml.wms.domain.sellableinventoryitem;

import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class SellableInventoryItemEntryStateEventDto extends AbstractStateEvent
{

    private SellableInventoryItemEntryStateEventIdDto stateEventId;

    SellableInventoryItemEntryStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new SellableInventoryItemEntryStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(SellableInventoryItemEntryStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }

    public Long getEntrySeqId() {
        return getStateEventId().getEntrySeqId();
    }

    public void setEntrySeqId(Long entrySeqId) {
        getStateEventId().setEntrySeqId(entrySeqId);
    }

    private BigDecimal sellableQuantity;

    public BigDecimal getSellableQuantity() {
        return this.sellableQuantity;
    }

    public void setSellableQuantity(BigDecimal sellableQuantity) {
        this.sellableQuantity = sellableQuantity;
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

    private Boolean isPropertySellableQuantityRemoved;

    public Boolean getIsPropertySellableQuantityRemoved() {
        return this.isPropertySellableQuantityRemoved;
    }

    public void setIsPropertySellableQuantityRemoved(Boolean removed) {
        this.isPropertySellableQuantityRemoved = removed;
    }

    private Boolean isPropertySourceEventIdRemoved;

    public Boolean getIsPropertySourceEventIdRemoved() {
        return this.isPropertySourceEventIdRemoved;
    }

    public void setIsPropertySourceEventIdRemoved(Boolean removed) {
        this.isPropertySourceEventIdRemoved = removed;
    }


	public static class SellableInventoryItemEntryStateCreatedDto extends SellableInventoryItemEntryStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class SellableInventoryItemEntryStateMergePatchedDto extends SellableInventoryItemEntryStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class SellableInventoryItemEntryStateRemovedDto extends SellableInventoryItemEntryStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_REMOVED;
        }

	}


}

