package org.dddml.wms.domain.sellableinventoryitem;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;

public class SellableInventoryItemEntryIdDto
{

    public SellableInventoryItemEntryIdDto()
    {
    }

    public SellableInventoryItemEntryId toSellableInventoryItemEntryId()
    {
        SellableInventoryItemEntryId v = new SellableInventoryItemEntryId();
        v.setSellableInventoryItemId(this.getSellableInventoryItemId().toInventoryItemId());
        v.setEntrySeqId(this.getEntrySeqId());
        return v;
    }

    private InventoryItemIdDto sellableInventoryItemId = new InventoryItemIdDto();

    public InventoryItemIdDto getSellableInventoryItemId()
    {
        return this.sellableInventoryItemId;
    }

    public void setSellableInventoryItemId(InventoryItemIdDto sellableInventoryItemId)
    {
        this.sellableInventoryItemId = sellableInventoryItemId;
    }

    private Long entrySeqId;

    public Long getEntrySeqId()
    {
        return this.entrySeqId;
    }

    public void setEntrySeqId(Long entrySeqId)
    {
        this.entrySeqId = entrySeqId;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != SellableInventoryItemEntryIdDto.class) {
            return false;
        }

        SellableInventoryItemEntryIdDto other = (SellableInventoryItemEntryIdDto)obj;
        return true 
            && (getSellableInventoryItemId() == other.getSellableInventoryItemId() || (getSellableInventoryItemId() != null && getSellableInventoryItemId().equals(other.getSellableInventoryItemId())))
            && (getEntrySeqId() == other.getEntrySeqId() || (getEntrySeqId() != null && getEntrySeqId().equals(other.getEntrySeqId())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getSellableInventoryItemId() != null) {
            hash += 13 * this.getSellableInventoryItemId().hashCode();
        }
        if (this.getEntrySeqId() != null) {
            hash += 13 * this.getEntrySeqId().hashCode();
        }
        return hash;
    }

}

