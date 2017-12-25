package org.dddml.wms.domain.physicalinventorylinemvo;

import org.dddml.wms.domain.physicalinventory.*;
import org.dddml.wms.domain.*;

public class PhysicalInventoryLineMvoStateEventIdDtoWrapper extends PhysicalInventoryLineMvoStateEventIdDto
{
	
    private PhysicalInventoryLineMvoStateEventId value;

    public PhysicalInventoryLineMvoStateEventIdDtoWrapper()
    {
        this(new PhysicalInventoryLineMvoStateEventId());
    }

    public PhysicalInventoryLineMvoStateEventIdDtoWrapper(PhysicalInventoryLineMvoStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public PhysicalInventoryLineMvoStateEventId toPhysicalInventoryLineMvoStateEventId()
    {
        return this.value;
    }

    @Override
    public PhysicalInventoryLineIdDto getPhysicalInventoryLineId()
    {
        return new PhysicalInventoryLineIdDtoWrapper(this.value.getPhysicalInventoryLineId());
    }

    @Override
    public void setPhysicalInventoryLineId(PhysicalInventoryLineIdDto physicalInventoryLineId)
    {
        this.value.setPhysicalInventoryLineId(physicalInventoryLineId.toPhysicalInventoryLineId());
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
        if (obj.getClass() == PhysicalInventoryLineMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        PhysicalInventoryLineMvoStateEventIdDtoWrapper other = (PhysicalInventoryLineMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

