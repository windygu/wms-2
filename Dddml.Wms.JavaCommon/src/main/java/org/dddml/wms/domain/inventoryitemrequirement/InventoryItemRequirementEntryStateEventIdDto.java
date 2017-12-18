package org.dddml.wms.domain.inventoryitemrequirement;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;

public class InventoryItemRequirementEntryStateEventIdDto
{

    public InventoryItemRequirementEntryStateEventIdDto()
    {
    }

    public InventoryItemRequirementEntryStateEventId toInventoryItemRequirementEntryStateEventId()
    {
        InventoryItemRequirementEntryStateEventId v = new InventoryItemRequirementEntryStateEventId();
        v.setInventoryItemRequirementId(this.getInventoryItemRequirementId().toInventoryItemId());
        v.setEntrySeqId(this.getEntrySeqId());
        v.setInventoryItemRequirementVersion(this.getInventoryItemRequirementVersion());
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

    private Long entrySeqId;

    public Long getEntrySeqId()
    {
        return this.entrySeqId;
    }

    public void setEntrySeqId(Long entrySeqId)
    {
        this.entrySeqId = entrySeqId;
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
        if (obj == null || obj.getClass() != InventoryItemRequirementEntryStateEventIdDto.class) {
            return false;
        }

        InventoryItemRequirementEntryStateEventIdDto other = (InventoryItemRequirementEntryStateEventIdDto)obj;
        return true 
            && (getInventoryItemRequirementId() == other.getInventoryItemRequirementId() || (getInventoryItemRequirementId() != null && getInventoryItemRequirementId().equals(other.getInventoryItemRequirementId())))
            && (getEntrySeqId() == other.getEntrySeqId() || (getEntrySeqId() != null && getEntrySeqId().equals(other.getEntrySeqId())))
            && (getInventoryItemRequirementVersion() == other.getInventoryItemRequirementVersion() || (getInventoryItemRequirementVersion() != null && getInventoryItemRequirementVersion().equals(other.getInventoryItemRequirementVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getInventoryItemRequirementId() != null) {
            hash += 13 * this.getInventoryItemRequirementId().hashCode();
        }
        if (this.getEntrySeqId() != null) {
            hash += 13 * this.getEntrySeqId().hashCode();
        }
        if (this.getInventoryItemRequirementVersion() != null) {
            hash += 13 * this.getInventoryItemRequirementVersion().hashCode();
        }
        return hash;
    }

}

