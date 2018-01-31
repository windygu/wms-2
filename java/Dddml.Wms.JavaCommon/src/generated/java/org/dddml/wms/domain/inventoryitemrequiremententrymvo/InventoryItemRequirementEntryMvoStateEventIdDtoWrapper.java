package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import org.dddml.wms.domain.inventoryitemrequirement.*;
import org.dddml.wms.domain.*;

public class InventoryItemRequirementEntryMvoStateEventIdDtoWrapper extends InventoryItemRequirementEntryMvoStateEventIdDto
{
	
    private InventoryItemRequirementEntryMvoStateEventId value;

    public InventoryItemRequirementEntryMvoStateEventIdDtoWrapper()
    {
        this(new InventoryItemRequirementEntryMvoStateEventId());
    }

    public InventoryItemRequirementEntryMvoStateEventIdDtoWrapper(InventoryItemRequirementEntryMvoStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public InventoryItemRequirementEntryMvoStateEventId toInventoryItemRequirementEntryMvoStateEventId()
    {
        return this.value;
    }

    @Override
    public InventoryItemRequirementEntryIdDto getInventoryItemRequirementEntryId()
    {
        return new InventoryItemRequirementEntryIdDtoWrapper(this.value.getInventoryItemRequirementEntryId());
    }

    @Override
    public void setInventoryItemRequirementEntryId(InventoryItemRequirementEntryIdDto inventoryItemRequirementEntryId)
    {
        this.value.setInventoryItemRequirementEntryId(inventoryItemRequirementEntryId.toInventoryItemRequirementEntryId());
    }

    @Override
    public Long getInventoryItemRequirementVersion()
    {
        return this.value.getInventoryItemRequirementVersion();
    }

    @Override
    public void setInventoryItemRequirementVersion(Long inventoryItemRequirementVersion)
    {
        this.value.setInventoryItemRequirementVersion(inventoryItemRequirementVersion);
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
        if (obj.getClass() == InventoryItemRequirementEntryMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        InventoryItemRequirementEntryMvoStateEventIdDtoWrapper other = (InventoryItemRequirementEntryMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

