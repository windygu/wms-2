package org.dddml.wms.domain.physicalinventorylinemvo;

import org.dddml.wms.domain.physicalinventory.PhysicalInventoryLineIdDto;
import org.dddml.wms.domain.physicalinventory.*;
import org.dddml.wms.domain.*;

public class PhysicalInventoryLineMvoStateEventIdDto
{

    public PhysicalInventoryLineMvoStateEventIdDto()
    {
    }

    public PhysicalInventoryLineMvoStateEventId toPhysicalInventoryLineMvoStateEventId()
    {
        PhysicalInventoryLineMvoStateEventId v = new PhysicalInventoryLineMvoStateEventId();
        v.setPhysicalInventoryLineId(this.getPhysicalInventoryLineId().toPhysicalInventoryLineId());
        v.setPhysicalInventoryVersion(this.getPhysicalInventoryVersion());
        return v;
    }

    private PhysicalInventoryLineIdDto physicalInventoryLineId = new PhysicalInventoryLineIdDto();

    public PhysicalInventoryLineIdDto getPhysicalInventoryLineId()
    {
        return this.physicalInventoryLineId;
    }

    public void setPhysicalInventoryLineId(PhysicalInventoryLineIdDto physicalInventoryLineId)
    {
        this.physicalInventoryLineId = physicalInventoryLineId;
    }

    private Long physicalInventoryVersion;

    public Long getPhysicalInventoryVersion()
    {
        return this.physicalInventoryVersion;
    }

    public void setPhysicalInventoryVersion(Long physicalInventoryVersion)
    {
        this.physicalInventoryVersion = physicalInventoryVersion;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != PhysicalInventoryLineMvoStateEventIdDto.class) {
            return false;
        }

        PhysicalInventoryLineMvoStateEventIdDto other = (PhysicalInventoryLineMvoStateEventIdDto)obj;
        return true 
            && (getPhysicalInventoryLineId() == other.getPhysicalInventoryLineId() || (getPhysicalInventoryLineId() != null && getPhysicalInventoryLineId().equals(other.getPhysicalInventoryLineId())))
            && (getPhysicalInventoryVersion() == other.getPhysicalInventoryVersion() || (getPhysicalInventoryVersion() != null && getPhysicalInventoryVersion().equals(other.getPhysicalInventoryVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getPhysicalInventoryLineId() != null) {
            hash += 13 * this.getPhysicalInventoryLineId().hashCode();
        }
        if (this.getPhysicalInventoryVersion() != null) {
            hash += 13 * this.getPhysicalInventoryVersion().hashCode();
        }
        return hash;
    }

}

