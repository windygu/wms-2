package org.dddml.wms.domain.inventoryitementrymvo;

import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public class InventoryItemEntryMvoStateEventIdDtoWrapper extends InventoryItemEntryMvoStateEventIdDto
{
	
    private InventoryItemEntryMvoStateEventId value;

    public InventoryItemEntryMvoStateEventIdDtoWrapper()
    {
        this(new InventoryItemEntryMvoStateEventId());
    }

    public InventoryItemEntryMvoStateEventIdDtoWrapper(InventoryItemEntryMvoStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public InventoryItemEntryMvoStateEventId toInventoryItemEntryMvoStateEventId()
    {
        return this.value;
    }

    @Override
    public InventoryItemEntryIdDto getInventoryItemEntryId()
    {
        return new InventoryItemEntryIdDtoWrapper(this.value.getInventoryItemEntryId());
    }

    @Override
    public void setInventoryItemEntryId(InventoryItemEntryIdDto inventoryItemEntryId)
    {
        this.value.setInventoryItemEntryId(inventoryItemEntryId.toInventoryItemEntryId());
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
        if (obj.getClass() == InventoryItemEntryMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        InventoryItemEntryMvoStateEventIdDtoWrapper other = (InventoryItemEntryMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

