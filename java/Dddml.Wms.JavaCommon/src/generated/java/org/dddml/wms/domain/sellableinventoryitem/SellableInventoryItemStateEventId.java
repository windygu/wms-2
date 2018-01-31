package org.dddml.wms.domain.sellableinventoryitem;

import java.io.Serializable;
import org.dddml.wms.domain.inventoryitem.InventoryItemId;
import org.dddml.wms.domain.*;

public class SellableInventoryItemStateEventId implements Serializable
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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
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

    public SellableInventoryItemStateEventId()
    {
    }

    public SellableInventoryItemStateEventId(InventoryItemId sellableInventoryItemId, Long version)
    {
        this.sellableInventoryItemId = sellableInventoryItemId;
        this.version = version;
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

        SellableInventoryItemStateEventId other = (SellableInventoryItemStateEventId)obj;
        return true 
            && (sellableInventoryItemId == other.sellableInventoryItemId || (sellableInventoryItemId != null && sellableInventoryItemId.equals(other.sellableInventoryItemId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.sellableInventoryItemId != null) {
            hash += 13 * this.sellableInventoryItemId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

