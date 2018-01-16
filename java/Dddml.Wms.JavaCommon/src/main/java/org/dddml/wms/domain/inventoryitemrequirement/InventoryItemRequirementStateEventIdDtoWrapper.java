package org.dddml.wms.domain.inventoryitemrequirement;

import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public class InventoryItemRequirementStateEventIdDtoWrapper extends InventoryItemRequirementStateEventIdDto
{
	
    private InventoryItemRequirementStateEventId value;

    public InventoryItemRequirementStateEventIdDtoWrapper()
    {
        this(new InventoryItemRequirementStateEventId());
    }

    public InventoryItemRequirementStateEventIdDtoWrapper(InventoryItemRequirementStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public InventoryItemRequirementStateEventId toInventoryItemRequirementStateEventId()
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
        if (obj.getClass() == InventoryItemRequirementStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        InventoryItemRequirementStateEventIdDtoWrapper other = (InventoryItemRequirementStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

