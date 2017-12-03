package org.dddml.wms.domain.inventorypostingrule;

import org.dddml.wms.domain.*;

public class InventoryPostingRuleStateEventIdDto
{

    public InventoryPostingRuleStateEventIdDto()
    {
    }

    public InventoryPostingRuleStateEventId toInventoryPostingRuleStateEventId()
    {
        InventoryPostingRuleStateEventId v = new InventoryPostingRuleStateEventId();
        v.setInventoryPostingRuleId(this.getInventoryPostingRuleId());
        v.setVersion(this.getVersion());
        return v;
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
        if (obj == null || obj.getClass() != InventoryPostingRuleStateEventIdDto.class) {
            return false;
        }

        InventoryPostingRuleStateEventIdDto other = (InventoryPostingRuleStateEventIdDto)obj;
        return true 
            && (getInventoryPostingRuleId() == other.getInventoryPostingRuleId() || (getInventoryPostingRuleId() != null && getInventoryPostingRuleId().equals(other.getInventoryPostingRuleId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getInventoryPostingRuleId() != null) {
            hash += 13 * this.getInventoryPostingRuleId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

