package org.dddml.wms.domain.inventoryitemrequirement;

import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public class InventoryItemRequirementEntryStateEventIdDtoWrapper extends InventoryItemRequirementEntryStateEventIdDto
{
	
    private InventoryItemRequirementEntryStateEventId value;

    public InventoryItemRequirementEntryStateEventIdDtoWrapper()
    {
        this(new InventoryItemRequirementEntryStateEventId());
    }

    public InventoryItemRequirementEntryStateEventIdDtoWrapper(InventoryItemRequirementEntryStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public InventoryItemRequirementEntryStateEventId toInventoryItemRequirementEntryStateEventId()
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
        if (obj.getClass() == InventoryItemRequirementEntryStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        InventoryItemRequirementEntryStateEventIdDtoWrapper other = (InventoryItemRequirementEntryStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

