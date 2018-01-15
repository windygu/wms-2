package org.dddml.wms.domain.sellableinventoryitem;

import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public class SellableInventoryItemStateEventIdDtoWrapper extends SellableInventoryItemStateEventIdDto
{
	
    private SellableInventoryItemStateEventId value;

    public SellableInventoryItemStateEventIdDtoWrapper()
    {
        this(new SellableInventoryItemStateEventId());
    }

    public SellableInventoryItemStateEventIdDtoWrapper(SellableInventoryItemStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public SellableInventoryItemStateEventId toSellableInventoryItemStateEventId()
    {
        return this.value;
    }

    @Override
    public InventoryItemIdDto getSellableInventoryItemId()
    {
        return new InventoryItemIdDtoWrapper(this.value.getSellableInventoryItemId());
    }

    @Override
    public void setSellableInventoryItemId(InventoryItemIdDto sellableInventoryItemId)
    {
        this.value.setSellableInventoryItemId(sellableInventoryItemId.toInventoryItemId());
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
        if (obj.getClass() == SellableInventoryItemStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        SellableInventoryItemStateEventIdDtoWrapper other = (SellableInventoryItemStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

