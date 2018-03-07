package org.dddml.wms.domain.sellableinventoryitem;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class SellableInventoryItemStateEventDto extends AbstractStateEvent
{

    private SellableInventoryItemStateEventId stateEventId;

    SellableInventoryItemStateEventId getStateEventId() {
        if (stateEventId == null) { stateEventId = new SellableInventoryItemStateEventId(); }
        return this.stateEventId;
    }

    void setStateEventId(SellableInventoryItemStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }

    public InventoryItemId getSellableInventoryItemId() {
        return getStateEventId().getSellableInventoryItemId();
    }

    public void setSellableInventoryItemId(InventoryItemId sellableInventoryItemId) {
        getStateEventId().setSellableInventoryItemId(sellableInventoryItemId);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
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

