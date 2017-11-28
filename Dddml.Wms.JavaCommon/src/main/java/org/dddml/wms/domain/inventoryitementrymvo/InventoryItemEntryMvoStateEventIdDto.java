package org.dddml.wms.domain.inventoryitementrymvo;

import org.dddml.wms.domain.inventoryitem.InventoryItemEntryIdDto;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public class InventoryItemEntryMvoStateEventIdDto
{

    public InventoryItemEntryMvoStateEventIdDto()
    {
    }

    public InventoryItemEntryMvoStateEventId toInventoryItemEntryMvoStateEventId()
    {
        InventoryItemEntryMvoStateEventId v = new InventoryItemEntryMvoStateEventId();
        v.setInventoryItemEntryId(this.getInventoryItemEntryId().toInventoryItemEntryId());
        v.setInventoryItemVersion(this.getInventoryItemVersion());
        return v;
    }

    private InventoryItemEntryIdDto inventoryItemEntryId = new InventoryItemEntryIdDto();

    public InventoryItemEntryIdDto getInventoryItemEntryId()
    {
        return this.inventoryItemEntryId;
    }

    public void setInventoryItemEntryId(InventoryItemEntryIdDto inventoryItemEntryId)
    {
        this.inventoryItemEntryId = inventoryItemEntryId;
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
        if (obj == null || obj.getClass() != InventoryItemEntryMvoStateEventIdDto.class) {
            return false;
        }

        InventoryItemEntryMvoStateEventIdDto other = (InventoryItemEntryMvoStateEventIdDto)obj;
        return true 
            && (getInventoryItemEntryId() == other.getInventoryItemEntryId() || (getInventoryItemEntryId() != null && getInventoryItemEntryId().equals(other.getInventoryItemEntryId())))
            && (getInventoryItemVersion() == other.getInventoryItemVersion() || (getInventoryItemVersion() != null && getInventoryItemVersion().equals(other.getInventoryItemVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getInventoryItemEntryId() != null) {
            hash += 13 * this.getInventoryItemEntryId().hashCode();
        }
        if (this.getInventoryItemVersion() != null) {
            hash += 13 * this.getInventoryItemVersion().hashCode();
        }
        return hash;
    }

}

