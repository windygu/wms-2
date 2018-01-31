package org.dddml.wms.domain.inventoryitem;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class InventoryItemEntryStateEventId implements Serializable
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

    private Long entrySeqId;

    public Long getEntrySeqId()
    {
        return this.entrySeqId;
    }

    public void setEntrySeqId(Long entrySeqId)
    {
        this.entrySeqId = entrySeqId;
    }

    private Long inventoryItemVersion;

    public Long getInventoryItemVersion()
    {
        return this.inventoryItemVersion;
    }

    public void setInventoryItemVersion(Long inventoryItemVersion)
    {
        this.inventoryItemVersion = inventoryItemVersion;
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

    public InventoryItemEntryStateEventId()
    {
    }

    public InventoryItemEntryStateEventId(InventoryItemId inventoryItemId, Long entrySeqId, Long inventoryItemVersion)
    {
        this.inventoryItemId = inventoryItemId;
        this.entrySeqId = entrySeqId;
        this.inventoryItemVersion = inventoryItemVersion;
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

        InventoryItemEntryStateEventId other = (InventoryItemEntryStateEventId)obj;
        return true 
            && (inventoryItemId == other.inventoryItemId || (inventoryItemId != null && inventoryItemId.equals(other.inventoryItemId)))
            && (entrySeqId == other.entrySeqId || (entrySeqId != null && entrySeqId.equals(other.entrySeqId)))
            && (inventoryItemVersion == other.inventoryItemVersion || (inventoryItemVersion != null && inventoryItemVersion.equals(other.inventoryItemVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.inventoryItemId != null) {
            hash += 13 * this.inventoryItemId.hashCode();
        }
        if (this.entrySeqId != null) {
            hash += 13 * this.entrySeqId.hashCode();
        }
        if (this.inventoryItemVersion != null) {
            hash += 13 * this.inventoryItemVersion.hashCode();
        }
        return hash;
    }

}

