package org.dddml.wms.domain.inventoryitem;

import org.dddml.wms.domain.*;

public class InventoryItemEntryIdDto
{

    public InventoryItemEntryIdDto()
    {
    }

    public InventoryItemEntryId toInventoryItemEntryId()
    {
        InventoryItemEntryId v = new InventoryItemEntryId();
        v.setInventoryItemId(this.getInventoryItemId().toInventoryItemId());
        v.setEntrySeqId(this.getEntrySeqId());
        return v;
    }

    private InventoryItemIdDto inventoryItemId = new InventoryItemIdDto();

    public InventoryItemIdDto getInventoryItemId()
    {
        return this.inventoryItemId;
    }

    public void setInventoryItemId(InventoryItemIdDto inventoryItemId)
    {
        this.inventoryItemId = inventoryItemId;
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
        if (obj == null || obj.getClass() != InventoryItemEntryIdDto.class) {
            return false;
        }

        InventoryItemEntryIdDto other = (InventoryItemEntryIdDto)obj;
        return true 
            && (getInventoryItemId() == other.getInventoryItemId() || (getInventoryItemId() != null && getInventoryItemId().equals(other.getInventoryItemId())))
            && (getEntrySeqId() == other.getEntrySeqId() || (getEntrySeqId() != null && getEntrySeqId().equals(other.getEntrySeqId())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getInventoryItemId() != null) {
            hash += 13 * this.getInventoryItemId().hashCode();
        }
        if (this.getEntrySeqId() != null) {
            hash += 13 * this.getEntrySeqId().hashCode();
        }
        return hash;
    }

}

