package org.dddml.wms.domain.sellableinventoryitem;

import java.io.Serializable;
import org.dddml.wms.domain.inventoryitem.InventoryItemId;
import org.dddml.wms.domain.*;

public class SellableInventoryItemEntryId implements Serializable
{
    private InventoryItemId sellableInventoryItemId = new InventoryItemId();

    public InventoryItemId getSellableInventoryItemId()
    {
        return this.sellableInventoryItemId;
    }

    public void setSellableInventoryItemId(InventoryItemId sellableInventoryItemId)
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

    public String getSellableInventoryItemIdProductId()
    {
        return getSellableInventoryItemId().getProductId();
    }

    public void setSellableInventoryItemIdProductId(String sellableInventoryItemIdProductId)
    {
        getSellableInventoryItemId().setProductId(sellableInventoryItemIdProductId);
    }

    public String getSellableInventoryItemIdLocatorId()
    {
        return getSellableInventoryItemId().getLocatorId();
    }

    public void setSellableInventoryItemIdLocatorId(String sellableInventoryItemIdLocatorId)
    {
        getSellableInventoryItemId().setLocatorId(sellableInventoryItemIdLocatorId);
    }

    public String getSellableInventoryItemIdAttributeSetInstanceId()
    {
        return getSellableInventoryItemId().getAttributeSetInstanceId();
    }

    public void setSellableInventoryItemIdAttributeSetInstanceId(String sellableInventoryItemIdAttributeSetInstanceId)
    {
        getSellableInventoryItemId().setAttributeSetInstanceId(sellableInventoryItemIdAttributeSetInstanceId);
    }

    public SellableInventoryItemEntryId()
    {
    }

    public SellableInventoryItemEntryId(InventoryItemId sellableInventoryItemId, Long entrySeqId)
    {
        this.sellableInventoryItemId = sellableInventoryItemId;
        this.entrySeqId = entrySeqId;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        SellableInventoryItemEntryId other = (SellableInventoryItemEntryId)obj;
        return true 
            && (sellableInventoryItemId == other.sellableInventoryItemId || (sellableInventoryItemId != null && sellableInventoryItemId.equals(other.sellableInventoryItemId)))
            && (entrySeqId == other.entrySeqId || (entrySeqId != null && entrySeqId.equals(other.entrySeqId)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.sellableInventoryItemId != null) {
            hash += 13 * this.sellableInventoryItemId.hashCode();
        }
        if (this.entrySeqId != null) {
            hash += 13 * this.entrySeqId.hashCode();
        }
        return hash;
    }

}

