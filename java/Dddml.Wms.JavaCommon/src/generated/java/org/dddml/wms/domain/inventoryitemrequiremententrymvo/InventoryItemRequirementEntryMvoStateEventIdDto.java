package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import org.dddml.wms.domain.inventoryitemrequirement.InventoryItemRequirementEntryIdDto;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import org.dddml.wms.domain.*;

public class InventoryItemRequirementEntryMvoStateEventIdDto
{

    public InventoryItemRequirementEntryMvoStateEventIdDto()
    {
    }

    public InventoryItemRequirementEntryMvoStateEventId toInventoryItemRequirementEntryMvoStateEventId()
    {
        InventoryItemRequirementEntryMvoStateEventId v = new InventoryItemRequirementEntryMvoStateEventId();
        v.setInventoryItemRequirementEntryId(this.getInventoryItemRequirementEntryId().toInventoryItemRequirementEntryId());
        v.setInventoryItemRequirementVersion(this.getInventoryItemRequirementVersion());
        return v;
    }

    private InventoryItemRequirementEntryIdDto inventoryItemRequirementEntryId = new InventoryItemRequirementEntryIdDto();

    public InventoryItemRequirementEntryIdDto getInventoryItemRequirementEntryId()
    {
        return this.inventoryItemRequirementEntryId;
    }

    public void setInventoryItemRequirementEntryId(InventoryItemRequirementEntryIdDto inventoryItemRequirementEntryId)
    {
        this.inventoryItemRequirementEntryId = inventoryItemRequirementEntryId;
    }

    private Long inventoryItemRequirementVersion;

    public Long getInventoryItemRequirementVersion()
    {
        return this.inventoryItemRequirementVersion;
    }

    public void setInventoryItemRequirementVersion(Long inventoryItemRequirementVersion)
    {
        this.inventoryItemRequirementVersion = inventoryItemRequirementVersion;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != InventoryItemRequirementEntryMvoStateEventIdDto.class) {
            return false;
        }

        InventoryItemRequirementEntryMvoStateEventIdDto other = (InventoryItemRequirementEntryMvoStateEventIdDto)obj;
        return true 
            && (getInventoryItemRequirementEntryId() == other.getInventoryItemRequirementEntryId() || (getInventoryItemRequirementEntryId() != null && getInventoryItemRequirementEntryId().equals(other.getInventoryItemRequirementEntryId())))
            && (getInventoryItemRequirementVersion() == other.getInventoryItemRequirementVersion() || (getInventoryItemRequirementVersion() != null && getInventoryItemRequirementVersion().equals(other.getInventoryItemRequirementVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getInventoryItemRequirementEntryId() != null) {
            hash += 13 * this.getInventoryItemRequirementEntryId().hashCode();
        }
        if (this.getInventoryItemRequirementVersion() != null) {
            hash += 13 * this.getInventoryItemRequirementVersion().hashCode();
        }
        return hash;
    }

}

