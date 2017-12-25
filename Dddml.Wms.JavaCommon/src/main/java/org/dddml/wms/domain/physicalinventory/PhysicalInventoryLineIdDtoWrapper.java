package org.dddml.wms.domain.physicalinventory;

import org.dddml.wms.domain.*;

public class PhysicalInventoryLineIdDtoWrapper extends PhysicalInventoryLineIdDto
{
	
    private PhysicalInventoryLineId value;

    public PhysicalInventoryLineIdDtoWrapper()
    {
        this(new PhysicalInventoryLineId());
    }

    public PhysicalInventoryLineIdDtoWrapper(PhysicalInventoryLineId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public PhysicalInventoryLineId toPhysicalInventoryLineId()
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
        if (obj.getClass() == PhysicalInventoryLineIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        PhysicalInventoryLineIdDtoWrapper other = (PhysicalInventoryLineIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

