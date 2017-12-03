package org.dddml.wms.domain.inventoryprtriggered;

import org.dddml.wms.domain.inventoryitem.InventoryItemEntryIdDto;
import org.dddml.wms.domain.*;

public class InventoryPRTriggeredIdDto
{

    public InventoryPRTriggeredIdDto()
    {
    }

    public InventoryPRTriggeredId toInventoryPRTriggeredId()
    {
        InventoryPRTriggeredId v = new InventoryPRTriggeredId();
        v.setSourceEntryId(this.getSourceEntryId().toInventoryItemEntryId());
        v.setInventoryPostingRuleId(this.getInventoryPostingRuleId());
        return v;
    }

    private InventoryItemEntryIdDto sourceEntryId = new InventoryItemEntryIdDto();

    public InventoryItemEntryIdDto getSourceEntryId()
    {
        return this.sourceEntryId;
    }

    public void setSourceEntryId(InventoryItemEntryIdDto sourceEntryId)
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != InventoryPRTriggeredIdDto.class) {
            return false;
        }

        InventoryPRTriggeredIdDto other = (InventoryPRTriggeredIdDto)obj;
        return true 
            && (getSourceEntryId() == other.getSourceEntryId() || (getSourceEntryId() != null && getSourceEntryId().equals(other.getSourceEntryId())))
            && (getInventoryPostingRuleId() == other.getInventoryPostingRuleId() || (getInventoryPostingRuleId() != null && getInventoryPostingRuleId().equals(other.getInventoryPostingRuleId())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getSourceEntryId() != null) {
            hash += 13 * this.getSourceEntryId().hashCode();
        }
        if (this.getInventoryPostingRuleId() != null) {
            hash += 13 * this.getInventoryPostingRuleId().hashCode();
        }
        return hash;
    }

}

