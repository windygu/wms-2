package org.dddml.wms.domain.inventoryitemrequirement;

import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public class InventoryItemRequirementEntryIdDtoWrapper extends InventoryItemRequirementEntryIdDto
{
	
    private InventoryItemRequirementEntryId value;

    public InventoryItemRequirementEntryIdDtoWrapper()
    {
        this(new InventoryItemRequirementEntryId());
    }

    public InventoryItemRequirementEntryIdDtoWrapper(InventoryItemRequirementEntryId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public InventoryItemRequirementEntryId toInventoryItemRequirementEntryId()
    {
        return this.value;
    }

    @Override
    public InventoryItemIdDto getInventoryItemRequirementId()
    {
        return new InventoryItemIdDtoWrapper(this.value.getInventoryItemRequirementId());
    }

    @Override
    public void setInventoryItemRequirementId(InventoryItemIdDto inventoryItemRequirementId)
    {
        this.value.setInventoryItemRequirementId(inventoryItemRequirementId.toInventoryItemId());
    }

    @Override
    public Long getEntrySeqId()
    {
        return this.value.getEntrySeqId();
    }

    @Override
    public void setEntrySeqId(Long entrySeqId)
    {
        this.value.setEntrySeqId(entrySeqId);
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
        if (obj.getClass() == InventoryItemRequirementEntryIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        InventoryItemRequirementEntryIdDtoWrapper other = (InventoryItemRequirementEntryIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

