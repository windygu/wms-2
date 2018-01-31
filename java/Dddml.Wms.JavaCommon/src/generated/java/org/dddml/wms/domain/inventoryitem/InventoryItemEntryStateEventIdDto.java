package org.dddml.wms.domain.inventoryitem;

import org.dddml.wms.domain.*;

public class InventoryItemEntryStateEventIdDto
{

    public InventoryItemEntryStateEventIdDto()
    {
    }

    public InventoryItemEntryStateEventId toInventoryItemEntryStateEventId()
    {
        InventoryItemEntryStateEventId v = new InventoryItemEntryStateEventId();
        v.setInventoryItemId(this.getInventoryItemId().toInventoryItemId());
        v.setEntrySeqId(this.getEntrySeqId());
        v.setInventoryItemVersion(this.getInventoryItemVersion());
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

    private Long inventoryItemVersion;

    public Long getInventoryItemVersion()
    {
        return this.inventoryItemVersion;
    }

    public void setInventoryItemVersion(Long inventoryItemVersion)
    {
        this.inventoryItemVersion = inventoryItemVersion;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != InventoryItemEntryStateEventIdDto.class) {
            return false;
        }

        InventoryItemEntryStateEventIdDto other = (InventoryItemEntryStateEventIdDto)obj;
        return true 
            && (getInventoryItemId() == other.getInventoryItemId() || (getInventoryItemId() != null && getInventoryItemId().equals(other.getInventoryItemId())))
            && (getEntrySeqId() == other.getEntrySeqId() || (getEntrySeqId() != null && getEntrySeqId().equals(other.getEntrySeqId())))
            && (getInventoryItemVersion() == other.getInventoryItemVersion() || (getInventoryItemVersion() != null && getInventoryItemVersion().equals(other.getInventoryItemVersion())))
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
        if (this.getInventoryItemVersion() != null) {
            hash += 13 * this.getInventoryItemVersion().hashCode();
        }
        return hash;
    }

}

