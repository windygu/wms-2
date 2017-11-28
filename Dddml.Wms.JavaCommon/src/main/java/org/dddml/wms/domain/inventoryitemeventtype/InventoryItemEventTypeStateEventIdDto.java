package org.dddml.wms.domain.inventoryitemeventtype;

import org.dddml.wms.domain.*;

public class InventoryItemEventTypeStateEventIdDto
{

    public InventoryItemEventTypeStateEventIdDto()
    {
    }

    public InventoryItemEventTypeStateEventId toInventoryItemEventTypeStateEventId()
    {
        InventoryItemEventTypeStateEventId v = new InventoryItemEventTypeStateEventId();
        v.setInventoryItemEventTypeId(this.getInventoryItemEventTypeId());
        v.setVersion(this.getVersion());
        return v;
    }

    private String inventoryItemEventTypeId;

    public String getInventoryItemEventTypeId()
    {
        return this.inventoryItemEventTypeId;
    }

    public void setInventoryItemEventTypeId(String inventoryItemEventTypeId)
    {
        this.inventoryItemEventTypeId = inventoryItemEventTypeId;
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
        if (obj == null || obj.getClass() != InventoryItemEventTypeStateEventIdDto.class) {
            return false;
        }

        InventoryItemEventTypeStateEventIdDto other = (InventoryItemEventTypeStateEventIdDto)obj;
        return true 
            && (getInventoryItemEventTypeId() == other.getInventoryItemEventTypeId() || (getInventoryItemEventTypeId() != null && getInventoryItemEventTypeId().equals(other.getInventoryItemEventTypeId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getInventoryItemEventTypeId() != null) {
            hash += 13 * this.getInventoryItemEventTypeId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

