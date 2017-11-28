package org.dddml.wms.domain.inventoryitementrymvo;

import java.io.Serializable;
import org.dddml.wms.domain.inventoryitem.InventoryItemEntryId;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public class InventoryItemEntryMvoStateEventId implements Serializable
{
    private InventoryItemEntryId inventoryItemEntryId = new InventoryItemEntryId();

    public InventoryItemEntryId getInventoryItemEntryId()
    {
        return this.inventoryItemEntryId;
    }

    public void setInventoryItemEntryId(InventoryItemEntryId inventoryItemEntryId)
    {
        this.inventoryItemEntryId = inventoryItemEntryId;
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

    public String getInventoryItemEntryIdInventoryItemIdProductId()
    {
        return getInventoryItemEntryId().getInventoryItemId().getProductId();
    }

    public void setInventoryItemEntryIdInventoryItemIdProductId(String inventoryItemEntryIdInventoryItemIdProductId)
    {
        getInventoryItemEntryId().getInventoryItemId().setProductId(inventoryItemEntryIdInventoryItemIdProductId);
    }

    public String getInventoryItemEntryIdInventoryItemIdLocatorId()
    {
        return getInventoryItemEntryId().getInventoryItemId().getLocatorId();
    }

    public void setInventoryItemEntryIdInventoryItemIdLocatorId(String inventoryItemEntryIdInventoryItemIdLocatorId)
    {
        getInventoryItemEntryId().getInventoryItemId().setLocatorId(inventoryItemEntryIdInventoryItemIdLocatorId);
    }

    public String getInventoryItemEntryIdInventoryItemIdAttributeSetInstance()
    {
        return getInventoryItemEntryId().getInventoryItemId().getAttributeSetInstance();
    }

    public void setInventoryItemEntryIdInventoryItemIdAttributeSetInstance(String inventoryItemEntryIdInventoryItemIdAttributeSetInstance)
    {
        getInventoryItemEntryId().getInventoryItemId().setAttributeSetInstance(inventoryItemEntryIdInventoryItemIdAttributeSetInstance);
    }

    public Long getInventoryItemEntryIdEntrySeqId()
    {
        return getInventoryItemEntryId().getEntrySeqId();
    }

    public void setInventoryItemEntryIdEntrySeqId(Long inventoryItemEntryIdEntrySeqId)
    {
        getInventoryItemEntryId().setEntrySeqId(inventoryItemEntryIdEntrySeqId);
    }

    public InventoryItemEntryMvoStateEventId()
    {
    }

    public InventoryItemEntryMvoStateEventId(InventoryItemEntryId inventoryItemEntryId, Long inventoryItemVersion)
    {
        this.inventoryItemEntryId = inventoryItemEntryId;
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

        InventoryItemEntryMvoStateEventId other = (InventoryItemEntryMvoStateEventId)obj;
        return true 
            && (inventoryItemEntryId == other.inventoryItemEntryId || (inventoryItemEntryId != null && inventoryItemEntryId.equals(other.inventoryItemEntryId)))
            && (inventoryItemVersion == other.inventoryItemVersion || (inventoryItemVersion != null && inventoryItemVersion.equals(other.inventoryItemVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.inventoryItemEntryId != null) {
            hash += 13 * this.inventoryItemEntryId.hashCode();
        }
        if (this.inventoryItemVersion != null) {
            hash += 13 * this.inventoryItemVersion.hashCode();
        }
        return hash;
    }

}

