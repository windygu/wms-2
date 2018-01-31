package org.dddml.wms.domain.inventoryprtriggered;

import java.io.Serializable;
import org.dddml.wms.domain.inventoryitem.InventoryItemEntryId;
import org.dddml.wms.domain.*;

public class InventoryPRTriggeredId implements Serializable
{
    private InventoryItemEntryId sourceEntryId = new InventoryItemEntryId();

    public InventoryItemEntryId getSourceEntryId()
    {
        return this.sourceEntryId;
    }

    public void setSourceEntryId(InventoryItemEntryId sourceEntryId)
    {
        this.sourceEntryId = sourceEntryId;
    }

    private String inventoryPostingRuleId;

    public String getInventoryPostingRuleId()
    {
        return this.inventoryPostingRuleId;
    }

    public void setInventoryPostingRuleId(String inventoryPostingRuleId)
    {
        this.inventoryPostingRuleId = inventoryPostingRuleId;
    }

    public String getSourceEntryIdInventoryItemIdProductId()
    {
        return getSourceEntryId().getInventoryItemId().getProductId();
    }

    public void setSourceEntryIdInventoryItemIdProductId(String sourceEntryIdInventoryItemIdProductId)
    {
        getSourceEntryId().getInventoryItemId().setProductId(sourceEntryIdInventoryItemIdProductId);
    }

    public String getSourceEntryIdInventoryItemIdLocatorId()
    {
        return getSourceEntryId().getInventoryItemId().getLocatorId();
    }

    public void setSourceEntryIdInventoryItemIdLocatorId(String sourceEntryIdInventoryItemIdLocatorId)
    {
        getSourceEntryId().getInventoryItemId().setLocatorId(sourceEntryIdInventoryItemIdLocatorId);
    }

    public String getSourceEntryIdInventoryItemIdAttributeSetInstanceId()
    {
        return getSourceEntryId().getInventoryItemId().getAttributeSetInstanceId();
    }

    public void setSourceEntryIdInventoryItemIdAttributeSetInstanceId(String sourceEntryIdInventoryItemIdAttributeSetInstanceId)
    {
        getSourceEntryId().getInventoryItemId().setAttributeSetInstanceId(sourceEntryIdInventoryItemIdAttributeSetInstanceId);
    }

    public Long getSourceEntryIdEntrySeqId()
    {
        return getSourceEntryId().getEntrySeqId();
    }

    public void setSourceEntryIdEntrySeqId(Long sourceEntryIdEntrySeqId)
    {
        getSourceEntryId().setEntrySeqId(sourceEntryIdEntrySeqId);
    }

    public InventoryPRTriggeredId()
    {
    }

    public InventoryPRTriggeredId(InventoryItemEntryId sourceEntryId, String inventoryPostingRuleId)
    {
        this.sourceEntryId = sourceEntryId;
        this.inventoryPostingRuleId = inventoryPostingRuleId;
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

        InventoryPRTriggeredId other = (InventoryPRTriggeredId)obj;
        return true 
            && (sourceEntryId == other.sourceEntryId || (sourceEntryId != null && sourceEntryId.equals(other.sourceEntryId)))
            && (inventoryPostingRuleId == other.inventoryPostingRuleId || (inventoryPostingRuleId != null && inventoryPostingRuleId.equals(other.inventoryPostingRuleId)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.sourceEntryId != null) {
            hash += 13 * this.sourceEntryId.hashCode();
        }
        if (this.inventoryPostingRuleId != null) {
            hash += 13 * this.inventoryPostingRuleId.hashCode();
        }
        return hash;
    }

}

