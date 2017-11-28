package org.dddml.wms.domain.inventoryitemeventtype;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class InventoryItemEventTypeStateEventId implements Serializable
{
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

    public InventoryItemEventTypeStateEventId()
    {
    }

    public InventoryItemEventTypeStateEventId(String inventoryItemEventTypeId, Long version)
    {
        this.inventoryItemEventTypeId = inventoryItemEventTypeId;
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

        InventoryItemEventTypeStateEventId other = (InventoryItemEventTypeStateEventId)obj;
        return true 
            && (inventoryItemEventTypeId == other.inventoryItemEventTypeId || (inventoryItemEventTypeId != null && inventoryItemEventTypeId.equals(other.inventoryItemEventTypeId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.inventoryItemEventTypeId != null) {
            hash += 13 * this.inventoryItemEventTypeId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

