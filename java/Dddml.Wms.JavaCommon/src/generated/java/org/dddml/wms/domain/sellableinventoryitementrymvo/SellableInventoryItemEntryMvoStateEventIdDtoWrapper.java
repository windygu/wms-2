package org.dddml.wms.domain.sellableinventoryitementrymvo;

import org.dddml.wms.domain.sellableinventoryitem.*;
import org.dddml.wms.domain.*;

public class SellableInventoryItemEntryMvoStateEventIdDtoWrapper extends SellableInventoryItemEntryMvoStateEventIdDto
{
	
    private SellableInventoryItemEntryMvoStateEventId value;

    public SellableInventoryItemEntryMvoStateEventIdDtoWrapper()
    {
        this(new SellableInventoryItemEntryMvoStateEventId());
    }

    public SellableInventoryItemEntryMvoStateEventIdDtoWrapper(SellableInventoryItemEntryMvoStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public SellableInventoryItemEntryMvoStateEventId toSellableInventoryItemEntryMvoStateEventId()
    {
        return this.value;
    }

    @Override
    public SellableInventoryItemEntryIdDto getSellableInventoryItemEntryId()
    {
        return new SellableInventoryItemEntryIdDtoWrapper(this.value.getSellableInventoryItemEntryId());
    }

    @Override
    public void setSellableInventoryItemEntryId(SellableInventoryItemEntryIdDto sellableInventoryItemEntryId)
    {
        this.value.setSellableInventoryItemEntryId(sellableInventoryItemEntryId.toSellableInventoryItemEntryId());
    }

    @Override
    public Long getSellableInventoryItemVersion()
    {
        return this.value.getSellableInventoryItemVersion();
    }

    @Override
    public void setSellableInventoryItemVersion(Long sellableInventoryItemVersion)
    {
        this.value.setSellableInventoryItemVersion(sellableInventoryItemVersion);
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
        if (obj.getClass() == SellableInventoryItemEntryMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        SellableInventoryItemEntryMvoStateEventIdDtoWrapper other = (SellableInventoryItemEntryMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

