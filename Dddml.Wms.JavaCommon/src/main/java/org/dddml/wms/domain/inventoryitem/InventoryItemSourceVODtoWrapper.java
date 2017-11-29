package org.dddml.wms.domain.inventoryitem;

import org.dddml.wms.domain.*;

public class InventoryItemSourceVODtoWrapper extends InventoryItemSourceVODto
{
	
    private InventoryItemSourceVO value;

    public InventoryItemSourceVODtoWrapper()
    {
        this(new InventoryItemSourceVO());
    }

    public InventoryItemSourceVODtoWrapper(InventoryItemSourceVO value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public InventoryItemSourceVO toInventoryItemSourceVO()
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
    public String getLineNumber()
    {
        return this.value.getLineNumber();
    }

    @Override
    public void setLineNumber(String lineNumber)
    {
        this.value.setLineNumber(lineNumber);
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
        if (obj.getClass() == InventoryItemSourceVODto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        InventoryItemSourceVODtoWrapper other = (InventoryItemSourceVODtoWrapper)obj;
        return value.equals(other.value);
    }

}

