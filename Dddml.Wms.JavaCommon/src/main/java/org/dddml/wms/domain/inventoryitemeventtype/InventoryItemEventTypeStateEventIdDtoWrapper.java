package org.dddml.wms.domain.inventoryitemeventtype;

import org.dddml.wms.domain.*;

public class InventoryItemEventTypeStateEventIdDtoWrapper extends InventoryItemEventTypeStateEventIdDto
{
	
    private InventoryItemEventTypeStateEventId value;

    public InventoryItemEventTypeStateEventIdDtoWrapper()
    {
        this(new InventoryItemEventTypeStateEventId());
    }

    public InventoryItemEventTypeStateEventIdDtoWrapper(InventoryItemEventTypeStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public InventoryItemEventTypeStateEventId toInventoryItemEventTypeStateEventId()
    {
        return this.value;
    }

    @Override
    public String getInventoryItemEventTypeId()
    {
        return this.value.getInventoryItemEventTypeId();
    }

    @Override
    public void setInventoryItemEventTypeId(String inventoryItemEventTypeId)
    {
        this.value.setInventoryItemEventTypeId(inventoryItemEventTypeId);
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
        if (obj.getClass() == InventoryItemEventTypeStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        InventoryItemEventTypeStateEventIdDtoWrapper other = (InventoryItemEventTypeStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

