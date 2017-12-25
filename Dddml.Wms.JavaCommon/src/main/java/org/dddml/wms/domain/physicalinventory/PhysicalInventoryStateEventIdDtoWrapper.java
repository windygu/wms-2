package org.dddml.wms.domain.physicalinventory;

import org.dddml.wms.domain.*;

public class PhysicalInventoryStateEventIdDtoWrapper extends PhysicalInventoryStateEventIdDto
{
	
    private PhysicalInventoryStateEventId value;

    public PhysicalInventoryStateEventIdDtoWrapper()
    {
        this(new PhysicalInventoryStateEventId());
    }

    public PhysicalInventoryStateEventIdDtoWrapper(PhysicalInventoryStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public PhysicalInventoryStateEventId toPhysicalInventoryStateEventId()
    {
        return this.value;
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
        if (obj.getClass() == PhysicalInventoryStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        PhysicalInventoryStateEventIdDtoWrapper other = (PhysicalInventoryStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

