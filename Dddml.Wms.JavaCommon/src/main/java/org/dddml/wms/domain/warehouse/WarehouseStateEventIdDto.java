package org.dddml.wms.domain.warehouse;

import org.dddml.wms.domain.*;

public class WarehouseStateEventIdDto
{

    public WarehouseStateEventIdDto()
    {
    }

    public WarehouseStateEventId toWarehouseStateEventId()
    {
        WarehouseStateEventId v = new WarehouseStateEventId();
        v.setWarehouseId(this.getWarehouseId());
        v.setVersion(this.getVersion());
        return v;
    }

    private String warehouseId;

    public String getWarehouseId()
    {
        return this.warehouseId;
    }

    public void setWarehouseId(String warehouseId)
    {
        this.warehouseId = warehouseId;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != WarehouseStateEventIdDto.class) {
            return false;
        }

        WarehouseStateEventIdDto other = (WarehouseStateEventIdDto)obj;
        return true 
            && (getWarehouseId() == other.getWarehouseId() || (getWarehouseId() != null && getWarehouseId().equals(other.getWarehouseId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getWarehouseId() != null) {
            hash += 13 * this.getWarehouseId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

