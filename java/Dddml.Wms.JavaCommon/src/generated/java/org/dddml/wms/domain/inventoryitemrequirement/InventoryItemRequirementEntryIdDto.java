package org.dddml.wms.domain.inventoryitemrequirement;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;

public class InventoryItemRequirementEntryIdDto
{

    public InventoryItemRequirementEntryIdDto()
    {
    }

    public InventoryItemRequirementEntryId toInventoryItemRequirementEntryId()
    {
        InventoryItemRequirementEntryId v = new InventoryItemRequirementEntryId();
        v.setInventoryItemRequirementId(this.getInventoryItemRequirementId().toInventoryItemId());
        v.setEntrySeqId(this.getEntrySeqId());
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != InventoryItemRequirementEntryIdDto.class) {
            return false;
        }

        InventoryItemRequirementEntryIdDto other = (InventoryItemRequirementEntryIdDto)obj;
        return true 
            && (getInventoryItemRequirementId() == other.getInventoryItemRequirementId() || (getInventoryItemRequirementId() != null && getInventoryItemRequirementId().equals(other.getInventoryItemRequirementId())))
            && (getEntrySeqId() == other.getEntrySeqId() || (getEntrySeqId() != null && getEntrySeqId().equals(other.getEntrySeqId())))
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
        return hash;
    }

}

