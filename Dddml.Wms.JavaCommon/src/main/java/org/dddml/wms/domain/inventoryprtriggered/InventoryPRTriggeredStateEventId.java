package org.dddml.wms.domain.inventoryprtriggered;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class InventoryPRTriggeredStateEventId implements Serializable
{
    private InventoryPRTriggeredId inventoryPRTriggeredId = new InventoryPRTriggeredId();

    public InventoryPRTriggeredId getInventoryPRTriggeredId()
    {
        return this.inventoryPRTriggeredId;
    }

    public void setInventoryPRTriggeredId(InventoryPRTriggeredId inventoryPRTriggeredId)
    {
        this.inventoryPRTriggeredId = inventoryPRTriggeredId;
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

    public String getInventoryPRTriggeredIdSourceEntryIdInventoryItemIdProductId()
    {
        return getInventoryPRTriggeredId().getSourceEntryId().getInventoryItemId().getProductId();
    }

    public void setInventoryPRTriggeredIdSourceEntryIdInventoryItemIdProductId(String inventoryPRTriggeredIdSourceEntryIdInventoryItemIdProductId)
    {
        getInventoryPRTriggeredId().getSourceEntryId().getInventoryItemId().setProductId(inventoryPRTriggeredIdSourceEntryIdInventoryItemIdProductId);
    }

    public String getInventoryPRTriggeredIdSourceEntryIdInventoryItemIdLocatorId()
    {
        return getInventoryPRTriggeredId().getSourceEntryId().getInventoryItemId().getLocatorId();
    }

    public void setInventoryPRTriggeredIdSourceEntryIdInventoryItemIdLocatorId(String inventoryPRTriggeredIdSourceEntryIdInventoryItemIdLocatorId)
    {
        getInventoryPRTriggeredId().getSourceEntryId().getInventoryItemId().setLocatorId(inventoryPRTriggeredIdSourceEntryIdInventoryItemIdLocatorId);
    }

    public String getInventoryPRTriggeredIdSourceEntryIdInventoryItemIdAttributeSetInstanceId()
    {
        return getInventoryPRTriggeredId().getSourceEntryId().getInventoryItemId().getAttributeSetInstanceId();
    }

    public void setInventoryPRTriggeredIdSourceEntryIdInventoryItemIdAttributeSetInstanceId(String inventoryPRTriggeredIdSourceEntryIdInventoryItemIdAttributeSetInstanceId)
    {
        getInventoryPRTriggeredId().getSourceEntryId().getInventoryItemId().setAttributeSetInstanceId(inventoryPRTriggeredIdSourceEntryIdInventoryItemIdAttributeSetInstanceId);
    }

    public Long getInventoryPRTriggeredIdSourceEntryIdEntrySeqId()
    {
        return getInventoryPRTriggeredId().getSourceEntryId().getEntrySeqId();
    }

    public void setInventoryPRTriggeredIdSourceEntryIdEntrySeqId(Long inventoryPRTriggeredIdSourceEntryIdEntrySeqId)
    {
        getInventoryPRTriggeredId().getSourceEntryId().setEntrySeqId(inventoryPRTriggeredIdSourceEntryIdEntrySeqId);
    }

    public String getInventoryPRTriggeredIdInventoryPostingRuleId()
    {
        return getInventoryPRTriggeredId().getInventoryPostingRuleId();
    }

    public void setInventoryPRTriggeredIdInventoryPostingRuleId(String inventoryPRTriggeredIdInventoryPostingRuleId)
    {
        getInventoryPRTriggeredId().setInventoryPostingRuleId(inventoryPRTriggeredIdInventoryPostingRuleId);
    }

    public InventoryPRTriggeredStateEventId()
    {
    }

    public InventoryPRTriggeredStateEventId(InventoryPRTriggeredId inventoryPRTriggeredId, Long version)
    {
        this.inventoryPRTriggeredId = inventoryPRTriggeredId;
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

        InventoryPRTriggeredStateEventId other = (InventoryPRTriggeredStateEventId)obj;
        return true 
            && (inventoryPRTriggeredId == other.inventoryPRTriggeredId || (inventoryPRTriggeredId != null && inventoryPRTriggeredId.equals(other.inventoryPRTriggeredId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.inventoryPRTriggeredId != null) {
            hash += 13 * this.inventoryPRTriggeredId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

