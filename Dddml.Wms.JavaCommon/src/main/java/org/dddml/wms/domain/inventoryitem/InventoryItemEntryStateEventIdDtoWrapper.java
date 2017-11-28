package org.dddml.wms.domain.inventoryitem;

import org.dddml.wms.domain.*;

public class InventoryItemEntryStateEventIdDtoWrapper extends InventoryItemEntryStateEventIdDto
{
	
    private InventoryItemEntryStateEventId value;

    public InventoryItemEntryStateEventIdDtoWrapper()
    {
        this(new InventoryItemEntryStateEventId());
    }

    public InventoryItemEntryStateEventIdDtoWrapper(InventoryItemEntryStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public InventoryItemEntryStateEventId toInventoryItemEntryStateEventId()
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
    public Long getInventoryItemVersion()
    {
        return this.value.getInventoryItemVersion();
    }

    @Override
    public void setInventoryItemVersion(Long inventoryItemVersion)
    {
        this.value.setInventoryItemVersion(inventoryItemVersion);
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
        if (obj.getClass() == InventoryItemEntryStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        InventoryItemEntryStateEventIdDtoWrapper other = (InventoryItemEntryStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

