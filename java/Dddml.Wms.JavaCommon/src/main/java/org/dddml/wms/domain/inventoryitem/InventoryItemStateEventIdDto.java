package org.dddml.wms.domain.inventoryitem;

import org.dddml.wms.domain.*;

public class InventoryItemStateEventIdDto
{

    public InventoryItemStateEventIdDto()
    {
    }

    public InventoryItemStateEventId toInventoryItemStateEventId()
    {
        InventoryItemStateEventId v = new InventoryItemStateEventId();
        v.setInventoryItemId(this.getInventoryItemId().toInventoryItemId());
        v.setVersion(this.getVersion());
        return v;
    }

    private InventoryItemIdDto inventoryItemId = new InventoryItemIdDto();

    public InventoryItemIdDto getInventoryItemId()
    {
        return this.inventoryItemId;
    }

    public void setInventoryItemId(InventoryItemIdDto inventoryItemId)
    {
        this.inventoryItemId = inventoryItemId;
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
        if (obj == null || obj.getClass() != InventoryItemStateEventIdDto.class) {
            return false;
        }

        InventoryItemStateEventIdDto other = (InventoryItemStateEventIdDto)obj;
        return true 
            && (getInventoryItemId() == other.getInventoryItemId() || (getInventoryItemId() != null && getInventoryItemId().equals(other.getInventoryItemId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getInventoryItemId() != null) {
            hash += 13 * this.getInventoryItemId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

