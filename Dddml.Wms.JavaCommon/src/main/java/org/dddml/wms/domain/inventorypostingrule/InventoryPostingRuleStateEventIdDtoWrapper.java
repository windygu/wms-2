package org.dddml.wms.domain.inventorypostingrule;

import org.dddml.wms.domain.*;

public class InventoryPostingRuleStateEventIdDtoWrapper extends InventoryPostingRuleStateEventIdDto
{
	
    private InventoryPostingRuleStateEventId value;

    public InventoryPostingRuleStateEventIdDtoWrapper()
    {
        this(new InventoryPostingRuleStateEventId());
    }

    public InventoryPostingRuleStateEventIdDtoWrapper(InventoryPostingRuleStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public InventoryPostingRuleStateEventId toInventoryPostingRuleStateEventId()
    {
        return this.value;
    }

    @Override
    public String getInventoryPostingRuleId()
    {
        return this.value.getInventoryPostingRuleId();
    }

    @Override
    public void setInventoryPostingRuleId(String inventoryPostingRuleId)
    {
        this.value.setInventoryPostingRuleId(inventoryPostingRuleId);
    }

    @Override
    public Long getVersion()
    {
        return this.value.getVersion();
    }

    @Override
    public void setVersion(Long version)
    {
        this.value.setVersion(version);
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == InventoryPostingRuleStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        InventoryPostingRuleStateEventIdDtoWrapper other = (InventoryPostingRuleStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

