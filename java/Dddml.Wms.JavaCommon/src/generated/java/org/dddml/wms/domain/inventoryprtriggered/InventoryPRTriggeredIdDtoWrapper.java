package org.dddml.wms.domain.inventoryprtriggered;

import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public class InventoryPRTriggeredIdDtoWrapper extends InventoryPRTriggeredIdDto
{
	
    private InventoryPRTriggeredId value;

    public InventoryPRTriggeredIdDtoWrapper()
    {
        this(new InventoryPRTriggeredId());
    }

    public InventoryPRTriggeredIdDtoWrapper(InventoryPRTriggeredId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public InventoryPRTriggeredId toInventoryPRTriggeredId()
    {
        return this.value;
    }

    @Override
    public InventoryItemEntryIdDto getSourceEntryId()
    {
        return new InventoryItemEntryIdDtoWrapper(this.value.getSourceEntryId());
    }

    @Override
    public void setSourceEntryId(InventoryItemEntryIdDto sourceEntryId)
    {
        this.value.setSourceEntryId(sourceEntryId.toInventoryItemEntryId());
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
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == InventoryPRTriggeredIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        InventoryPRTriggeredIdDtoWrapper other = (InventoryPRTriggeredIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

