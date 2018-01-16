package org.dddml.wms.domain.inventoryprtriggered;

import org.dddml.wms.domain.*;

public class InventoryPRTriggeredStateEventIdDtoWrapper extends InventoryPRTriggeredStateEventIdDto
{
	
    private InventoryPRTriggeredStateEventId value;

    public InventoryPRTriggeredStateEventIdDtoWrapper()
    {
        this(new InventoryPRTriggeredStateEventId());
    }

    public InventoryPRTriggeredStateEventIdDtoWrapper(InventoryPRTriggeredStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public InventoryPRTriggeredStateEventId toInventoryPRTriggeredStateEventId()
    {
        return this.value;
    }

    @Override
    public InventoryPRTriggeredIdDto getInventoryPRTriggeredId()
    {
        return new InventoryPRTriggeredIdDtoWrapper(this.value.getInventoryPRTriggeredId());
    }

    @Override
    public void setInventoryPRTriggeredId(InventoryPRTriggeredIdDto inventoryPRTriggeredId)
    {
        this.value.setInventoryPRTriggeredId(inventoryPRTriggeredId.toInventoryPRTriggeredId());
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
        if (obj.getClass() == InventoryPRTriggeredStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        InventoryPRTriggeredStateEventIdDtoWrapper other = (InventoryPRTriggeredStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

