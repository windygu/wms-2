package org.dddml.wms.domain.sellableinventoryitem;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;

public class SellableInventoryItemStateEventIdDto
{

    public SellableInventoryItemStateEventIdDto()
    {
    }

    public SellableInventoryItemStateEventId toSellableInventoryItemStateEventId()
    {
        SellableInventoryItemStateEventId v = new SellableInventoryItemStateEventId();
        v.setSellableInventoryItemId(this.getSellableInventoryItemId().toInventoryItemId());
        v.setVersion(this.getVersion());
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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != SellableInventoryItemStateEventIdDto.class) {
            return false;
        }

        SellableInventoryItemStateEventIdDto other = (SellableInventoryItemStateEventIdDto)obj;
        return true 
            && (getSellableInventoryItemId() == other.getSellableInventoryItemId() || (getSellableInventoryItemId() != null && getSellableInventoryItemId().equals(other.getSellableInventoryItemId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getSellableInventoryItemId() != null) {
            hash += 13 * this.getSellableInventoryItemId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

