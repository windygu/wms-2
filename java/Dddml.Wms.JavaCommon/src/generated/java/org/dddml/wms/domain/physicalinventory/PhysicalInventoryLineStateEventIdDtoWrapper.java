package org.dddml.wms.domain.physicalinventory;

import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public class PhysicalInventoryLineStateEventIdDtoWrapper extends PhysicalInventoryLineStateEventIdDto
{
	
    private PhysicalInventoryLineStateEventId value;

    public PhysicalInventoryLineStateEventIdDtoWrapper()
    {
        this(new PhysicalInventoryLineStateEventId());
    }

    public PhysicalInventoryLineStateEventIdDtoWrapper(PhysicalInventoryLineStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public PhysicalInventoryLineStateEventId toPhysicalInventoryLineStateEventId()
    {
        return this.value;
    }

    @Override
    public String getPhysicalInventoryDocumentNumber()
    {
        return this.value.getPhysicalInventoryDocumentNumber();
    }

    @Override
    public void setPhysicalInventoryDocumentNumber(String physicalInventoryDocumentNumber)
    {
        this.value.setPhysicalInventoryDocumentNumber(physicalInventoryDocumentNumber);
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
    public Long getPhysicalInventoryVersion()
    {
        return this.value.getPhysicalInventoryVersion();
    }

    @Override
    public void setPhysicalInventoryVersion(Long physicalInventoryVersion)
    {
        this.value.setPhysicalInventoryVersion(physicalInventoryVersion);
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
        if (obj.getClass() == PhysicalInventoryLineStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        PhysicalInventoryLineStateEventIdDtoWrapper other = (PhysicalInventoryLineStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

