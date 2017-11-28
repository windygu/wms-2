package org.dddml.wms.domain.inventoryitem;

import org.dddml.wms.domain.*;

public class InventoryItemEventVODtoWrapper extends InventoryItemEventVODto
{
	
    private InventoryItemEventVO value;

    public InventoryItemEventVODtoWrapper()
    {
        this(new InventoryItemEventVO());
    }

    public InventoryItemEventVODtoWrapper(InventoryItemEventVO value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public InventoryItemEventVO toInventoryItemEventVO()
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
    public String getDocumentNumber()
    {
        return this.value.getDocumentNumber();
    }

    @Override
    public void setDocumentNumber(String documentNumber)
    {
        this.value.setDocumentNumber(documentNumber);
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
        if (obj.getClass() == InventoryItemEventVODto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        InventoryItemEventVODtoWrapper other = (InventoryItemEventVODtoWrapper)obj;
        return value.equals(other.value);
    }

}

