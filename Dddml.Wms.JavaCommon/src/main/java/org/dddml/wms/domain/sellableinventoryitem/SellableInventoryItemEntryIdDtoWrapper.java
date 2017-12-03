package org.dddml.wms.domain.sellableinventoryitem;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;

public class SellableInventoryItemEntryIdDtoWrapper extends SellableInventoryItemEntryIdDto
{
	
    private SellableInventoryItemEntryId value;

    public SellableInventoryItemEntryIdDtoWrapper()
    {
        this(new SellableInventoryItemEntryId());
    }

    public SellableInventoryItemEntryIdDtoWrapper(SellableInventoryItemEntryId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public SellableInventoryItemEntryId toSellableInventoryItemEntryId()
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
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == SellableInventoryItemEntryIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        SellableInventoryItemEntryIdDtoWrapper other = (SellableInventoryItemEntryIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

