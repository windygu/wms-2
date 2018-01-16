package org.dddml.wms.domain.inventoryitemrequirement;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;

public class InventoryItemRequirementStateEventIdDto
{

    public InventoryItemRequirementStateEventIdDto()
    {
    }

    public InventoryItemRequirementStateEventId toInventoryItemRequirementStateEventId()
    {
        InventoryItemRequirementStateEventId v = new InventoryItemRequirementStateEventId();
        v.setInventoryItemRequirementId(this.getInventoryItemRequirementId().toInventoryItemId());
        v.setVersion(this.getVersion());
        return v;
    }

    private InventoryItemIdDto inventoryItemRequirementId = new InventoryItemIdDto();

    public InventoryItemIdDto getInventoryItemRequirementId()
    {
        return this.inventoryItemRequirementId;
    }

    public void setInventoryItemRequirementId(InventoryItemIdDto inventoryItemRequirementId)
    {
        this.inventoryItemRequirementId = inventoryItemRequirementId;
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
        if (obj == null || obj.getClass() != InventoryItemRequirementStateEventIdDto.class) {
            return false;
        }

        InventoryItemRequirementStateEventIdDto other = (InventoryItemRequirementStateEventIdDto)obj;
        return true 
            && (getInventoryItemRequirementId() == other.getInventoryItemRequirementId() || (getInventoryItemRequirementId() != null && getInventoryItemRequirementId().equals(other.getInventoryItemRequirementId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getInventoryItemRequirementId() != null) {
            hash += 13 * this.getInventoryItemRequirementId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

