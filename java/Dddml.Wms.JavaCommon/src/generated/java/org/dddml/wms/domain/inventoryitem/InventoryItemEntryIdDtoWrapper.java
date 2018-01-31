package org.dddml.wms.domain.inventoryitem;

import org.dddml.wms.domain.*;

public class InventoryItemEntryIdDtoWrapper extends InventoryItemEntryIdDto
{
	
    private InventoryItemEntryId value;

    public InventoryItemEntryIdDtoWrapper()
    {
        this(new InventoryItemEntryId());
    }

    public InventoryItemEntryIdDtoWrapper(InventoryItemEntryId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public InventoryItemEntryId toInventoryItemEntryId()
    {
        return this.value;
    }

    @Override
    public InventoryItemIdDto getInventoryItemId()
    {
        return new InventoryItemIdDtoWrapper(this.value.getInventoryItemId());
    }

    @Override
    public void setInventoryItemId(InventoryItemIdDto inventoryItemId)
    {
        this.value.setInventoryItemId(inventoryItemId.toInventoryItemId());
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
        if (obj.getClass() == InventoryItemEntryIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        InventoryItemEntryIdDtoWrapper other = (InventoryItemEntryIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

