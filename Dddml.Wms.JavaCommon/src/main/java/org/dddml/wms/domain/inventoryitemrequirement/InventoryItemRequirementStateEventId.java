package org.dddml.wms.domain.inventoryitemrequirement;

import java.io.Serializable;
import org.dddml.wms.domain.inventoryitem.InventoryItemId;
import org.dddml.wms.domain.*;

public class InventoryItemRequirementStateEventId implements Serializable
{
    private InventoryItemId inventoryItemRequirementId = new InventoryItemId();

    public InventoryItemId getInventoryItemRequirementId()
    {
        return this.inventoryItemRequirementId;
    }

    public void setInventoryItemRequirementId(InventoryItemId inventoryItemRequirementId)
    {
        this.inventoryItemRequirementId = inventoryItemRequirementId;
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

    public String getInventoryItemRequirementIdProductId()
    {
        return getInventoryItemRequirementId().getProductId();
    }

    public void setInventoryItemRequirementIdProductId(String inventoryItemRequirementIdProductId)
    {
        getInventoryItemRequirementId().setProductId(inventoryItemRequirementIdProductId);
    }

    public String getInventoryItemRequirementIdLocatorId()
    {
        return getInventoryItemRequirementId().getLocatorId();
    }

    public void setInventoryItemRequirementIdLocatorId(String inventoryItemRequirementIdLocatorId)
    {
        getInventoryItemRequirementId().setLocatorId(inventoryItemRequirementIdLocatorId);
    }

    public String getInventoryItemRequirementIdAttributeSetInstanceId()
    {
        return getInventoryItemRequirementId().getAttributeSetInstanceId();
    }

    public void setInventoryItemRequirementIdAttributeSetInstanceId(String inventoryItemRequirementIdAttributeSetInstanceId)
    {
        getInventoryItemRequirementId().setAttributeSetInstanceId(inventoryItemRequirementIdAttributeSetInstanceId);
    }

    public InventoryItemRequirementStateEventId()
    {
    }

    public InventoryItemRequirementStateEventId(InventoryItemId inventoryItemRequirementId, Long version)
    {
        this.inventoryItemRequirementId = inventoryItemRequirementId;
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

        InventoryItemRequirementStateEventId other = (InventoryItemRequirementStateEventId)obj;
        return true 
            && (inventoryItemRequirementId == other.inventoryItemRequirementId || (inventoryItemRequirementId != null && inventoryItemRequirementId.equals(other.inventoryItemRequirementId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.inventoryItemRequirementId != null) {
            hash += 13 * this.inventoryItemRequirementId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

