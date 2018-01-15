package org.dddml.wms.domain.inventorypostingrule;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class InventoryPostingRuleStateEventId implements Serializable
{
    private String inventoryPostingRuleId;

    public String getInventoryPostingRuleId()
    {
        return this.inventoryPostingRuleId;
    }

    public void setInventoryPostingRuleId(String inventoryPostingRuleId)
    {
        this.inventoryPostingRuleId = inventoryPostingRuleId;
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

    public InventoryPostingRuleStateEventId()
    {
    }

    public InventoryPostingRuleStateEventId(String inventoryPostingRuleId, Long version)
    {
        this.inventoryPostingRuleId = inventoryPostingRuleId;
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

        InventoryPostingRuleStateEventId other = (InventoryPostingRuleStateEventId)obj;
        return true 
            && (inventoryPostingRuleId == other.inventoryPostingRuleId || (inventoryPostingRuleId != null && inventoryPostingRuleId.equals(other.inventoryPostingRuleId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.inventoryPostingRuleId != null) {
            hash += 13 * this.inventoryPostingRuleId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

