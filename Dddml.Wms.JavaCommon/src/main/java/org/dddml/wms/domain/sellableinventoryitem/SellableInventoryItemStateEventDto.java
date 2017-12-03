package org.dddml.wms.domain.sellableinventoryitem;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class SellableInventoryItemStateEventDto extends AbstractStateEvent
{

    private SellableInventoryItemStateEventIdDto stateEventId;

    SellableInventoryItemStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new SellableInventoryItemStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(SellableInventoryItemStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }

    public InventoryItemIdDto getSellableInventoryItemId() {
        return getStateEventId().getSellableInventoryItemId();
    }

    public void setSellableInventoryItemId(InventoryItemIdDto sellableInventoryItemId) {
        getStateEventId().setSellableInventoryItemId(sellableInventoryItemId);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
    }

    private BigDecimal quantitySellable;

    public BigDecimal getQuantitySellable() {
        return this.quantitySellable;
    }

    public void setQuantitySellable(BigDecimal quantitySellable) {
        this.quantitySellable = quantitySellable;
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

    private Boolean isPropertyQuantitySellableRemoved;

    public Boolean getIsPropertyQuantitySellableRemoved() {
        return this.isPropertyQuantitySellableRemoved;
    }

    public void setIsPropertyQuantitySellableRemoved(Boolean removed) {
        this.isPropertyQuantitySellableRemoved = removed;
    }


    private SellableInventoryItemEntryStateEventDto[] sellableInventoryItemEntryEvents;

    public SellableInventoryItemEntryStateEventDto[] getSellableInventoryItemEntryEvents() {
        return this.sellableInventoryItemEntryEvents;
    }

    public void setSellableInventoryItemEntryEvents(SellableInventoryItemEntryStateEventDto[] events) {
        this.sellableInventoryItemEntryEvents = events;
    }


	public static class SellableInventoryItemStateCreatedDto extends SellableInventoryItemStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class SellableInventoryItemStateMergePatchedDto extends SellableInventoryItemStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class SellableInventoryItemStateDeletedDto extends SellableInventoryItemStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

