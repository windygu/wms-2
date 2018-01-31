package org.dddml.wms.domain.inventoryitem;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class InventoryItemStateEventId implements Serializable
{
    private InventoryItemId inventoryItemId = new InventoryItemId();

    public InventoryItemId getInventoryItemId()
    {
        return this.inventoryItemId;
    }

    public void setInventoryItemId(InventoryItemId inventoryItemId)
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

    public String getInventoryItemIdProductId()
    {
        return getInventoryItemId().getProductId();
    }

    public void setInventoryItemIdProductId(String inventoryItemIdProductId)
    {
        getInventoryItemId().setProductId(inventoryItemIdProductId);
    }

    public String getInventoryItemIdLocatorId()
    {
        return getInventoryItemId().getLocatorId();
    }

    public void setInventoryItemIdLocatorId(String inventoryItemIdLocatorId)
    {
        getInventoryItemId().setLocatorId(inventoryItemIdLocatorId);
    }

    public String getInventoryItemIdAttributeSetInstanceId()
    {
        return getInventoryItemId().getAttributeSetInstanceId();
    }

    public void setInventoryItemIdAttributeSetInstanceId(String inventoryItemIdAttributeSetInstanceId)
    {
        getInventoryItemId().setAttributeSetInstanceId(inventoryItemIdAttributeSetInstanceId);
    }

    public InventoryItemStateEventId()
    {
    }

    public InventoryItemStateEventId(InventoryItemId inventoryItemId, Long version)
    {
        this.inventoryItemId = inventoryItemId;
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

        InventoryItemStateEventId other = (InventoryItemStateEventId)obj;
        return true 
            && (inventoryItemId == other.inventoryItemId || (inventoryItemId != null && inventoryItemId.equals(other.inventoryItemId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.inventoryItemId != null) {
            hash += 13 * this.inventoryItemId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

