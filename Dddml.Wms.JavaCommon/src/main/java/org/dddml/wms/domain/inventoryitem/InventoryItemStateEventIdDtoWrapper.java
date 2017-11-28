package org.dddml.wms.domain.inventoryitem;

import org.dddml.wms.domain.*;

public class InventoryItemStateEventIdDtoWrapper extends InventoryItemStateEventIdDto
{
	
    private InventoryItemStateEventId value;

    public InventoryItemStateEventIdDtoWrapper()
    {
        this(new InventoryItemStateEventId());
    }

    public InventoryItemStateEventIdDtoWrapper(InventoryItemStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public InventoryItemStateEventId toInventoryItemStateEventId()
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
        if (obj.getClass() == InventoryItemStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        InventoryItemStateEventIdDtoWrapper other = (InventoryItemStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

