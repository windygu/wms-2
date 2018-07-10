package org.dddml.wms.domain.sellableinventoryitem;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class SellableInventoryItemStateEventDto extends AbstractEvent
{

    private SellableInventoryItemEventId sellableInventoryItemEventId;

    SellableInventoryItemEventId getSellableInventoryItemEventId() {
        if (sellableInventoryItemEventId == null) { sellableInventoryItemEventId = new SellableInventoryItemEventId(); }
        return sellableInventoryItemEventId;
    }

    void setSellableInventoryItemEventId(SellableInventoryItemEventId eventId) {
        this.sellableInventoryItemEventId = eventId;
    }

    public InventoryItemId getSellableInventoryItemId() {
        return getSellableInventoryItemEventId().getSellableInventoryItemId();
    }

    public void setSellableInventoryItemId(InventoryItemId sellableInventoryItemId) {
        getSellableInventoryItemEventId().setSellableInventoryItemId(sellableInventoryItemId);
    }

    public Long getVersion() {
        return getSellableInventoryItemEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getSellableInventoryItemEventId().setVersion(version);
    }

    private BigDecimal sellableQuantity;

    public BigDecimal getSellableQuantity() {
        return this.sellableQuantity;
    }

    public void setSellableQuantity(BigDecimal sellableQuantity) {
        this.sellableQuantity = sellableQuantity;
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

    private Boolean isPropertySellableQuantityRemoved;

    public Boolean getIsPropertySellableQuantityRemoved() {
        return this.isPropertySellableQuantityRemoved;
    }

    public void setIsPropertySellableQuantityRemoved(Boolean removed) {
        this.isPropertySellableQuantityRemoved = removed;
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
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class SellableInventoryItemStateMergePatchedDto extends SellableInventoryItemStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class SellableInventoryItemStateDeletedDto extends SellableInventoryItemStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

