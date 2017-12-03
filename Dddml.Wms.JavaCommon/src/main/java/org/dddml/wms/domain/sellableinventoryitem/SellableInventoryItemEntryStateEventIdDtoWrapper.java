package org.dddml.wms.domain.sellableinventoryitem;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;

public class SellableInventoryItemEntryStateEventIdDtoWrapper extends SellableInventoryItemEntryStateEventIdDto
{
	
    private SellableInventoryItemEntryStateEventId value;

    public SellableInventoryItemEntryStateEventIdDtoWrapper()
    {
        this(new SellableInventoryItemEntryStateEventId());
    }

    public SellableInventoryItemEntryStateEventIdDtoWrapper(SellableInventoryItemEntryStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public SellableInventoryItemEntryStateEventId toSellableInventoryItemEntryStateEventId()
    {
        return this.value;
    }

    @Override
    public InventoryItemIdDto getSellableInventoryItemId()
    {
        return new InventoryItemIdDtoWrapper(this.value.getSellableInventoryItemId());
    }

    @Override
    public void setSellableInventoryItemId(InventoryItemIdDto sellableInventoryItemId)
    {
        this.value.setSellableInventoryItemId(sellableInventoryItemId.toInventoryItemId());
    }

    @Override
    public Long getEntrySeqId()
    {
        return this.value.getEntrySeqId();
    }

    @Override
    public void setEntrySeqId(Long entrySeqId)
    {
        this.value.setEntrySeqId(entrySeqId);
    }

    @Override
    public Long getSellableInventoryItemVersion()
    {
        return this.value.getSellableInventoryItemVersion();
    }

    @Override
    public void setSellableInventoryItemVersion(Long sellableInventoryItemVersion)
    {
        this.value.setSellableInventoryItemVersion(sellableInventoryItemVersion);
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == SellableInventoryItemEntryStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        SellableInventoryItemEntryStateEventIdDtoWrapper other = (SellableInventoryItemEntryStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

