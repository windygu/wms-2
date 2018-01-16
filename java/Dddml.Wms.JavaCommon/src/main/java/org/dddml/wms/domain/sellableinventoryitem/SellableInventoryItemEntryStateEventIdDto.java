package org.dddml.wms.domain.sellableinventoryitem;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;

public class SellableInventoryItemEntryStateEventIdDto
{

    public SellableInventoryItemEntryStateEventIdDto()
    {
    }

    public SellableInventoryItemEntryStateEventId toSellableInventoryItemEntryStateEventId()
    {
        SellableInventoryItemEntryStateEventId v = new SellableInventoryItemEntryStateEventId();
        v.setSellableInventoryItemId(this.getSellableInventoryItemId().toInventoryItemId());
        v.setEntrySeqId(this.getEntrySeqId());
        v.setSellableInventoryItemVersion(this.getSellableInventoryItemVersion());
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

    private Long sellableInventoryItemVersion;

    public Long getSellableInventoryItemVersion()
    {
        return this.sellableInventoryItemVersion;
    }

    public void setSellableInventoryItemVersion(Long sellableInventoryItemVersion)
    {
        this.sellableInventoryItemVersion = sellableInventoryItemVersion;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != SellableInventoryItemEntryStateEventIdDto.class) {
            return false;
        }

        SellableInventoryItemEntryStateEventIdDto other = (SellableInventoryItemEntryStateEventIdDto)obj;
        return true 
            && (getSellableInventoryItemId() == other.getSellableInventoryItemId() || (getSellableInventoryItemId() != null && getSellableInventoryItemId().equals(other.getSellableInventoryItemId())))
            && (getEntrySeqId() == other.getEntrySeqId() || (getEntrySeqId() != null && getEntrySeqId().equals(other.getEntrySeqId())))
            && (getSellableInventoryItemVersion() == other.getSellableInventoryItemVersion() || (getSellableInventoryItemVersion() != null && getSellableInventoryItemVersion().equals(other.getSellableInventoryItemVersion())))
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
        if (this.getSellableInventoryItemVersion() != null) {
            hash += 13 * this.getSellableInventoryItemVersion().hashCode();
        }
        return hash;
    }

}

