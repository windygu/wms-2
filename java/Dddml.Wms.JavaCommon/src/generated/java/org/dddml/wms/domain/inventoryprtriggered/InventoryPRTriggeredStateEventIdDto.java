package org.dddml.wms.domain.inventoryprtriggered;

import org.dddml.wms.domain.*;

public class InventoryPRTriggeredStateEventIdDto
{

    public InventoryPRTriggeredStateEventIdDto()
    {
    }

    public InventoryPRTriggeredStateEventId toInventoryPRTriggeredStateEventId()
    {
        InventoryPRTriggeredStateEventId v = new InventoryPRTriggeredStateEventId();
        v.setInventoryPRTriggeredId(this.getInventoryPRTriggeredId().toInventoryPRTriggeredId());
        v.setVersion(this.getVersion());
        return v;
    }

    private InventoryPRTriggeredIdDto inventoryPRTriggeredId = new InventoryPRTriggeredIdDto();

    public InventoryPRTriggeredIdDto getInventoryPRTriggeredId()
    {
        return this.inventoryPRTriggeredId;
    }

    public void setInventoryPRTriggeredId(InventoryPRTriggeredIdDto inventoryPRTriggeredId)
    {
        this.inventoryPRTriggeredId = inventoryPRTriggeredId;
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
        if (obj == null || obj.getClass() != InventoryPRTriggeredStateEventIdDto.class) {
            return false;
        }

        InventoryPRTriggeredStateEventIdDto other = (InventoryPRTriggeredStateEventIdDto)obj;
        return true 
            && (getInventoryPRTriggeredId() == other.getInventoryPRTriggeredId() || (getInventoryPRTriggeredId() != null && getInventoryPRTriggeredId().equals(other.getInventoryPRTriggeredId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getInventoryPRTriggeredId() != null) {
            hash += 13 * this.getInventoryPRTriggeredId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

