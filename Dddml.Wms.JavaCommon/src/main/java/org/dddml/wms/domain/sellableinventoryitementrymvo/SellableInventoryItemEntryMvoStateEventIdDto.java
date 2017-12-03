package org.dddml.wms.domain.sellableinventoryitementrymvo;

import org.dddml.wms.domain.sellableinventoryitem.SellableInventoryItemEntryIdDto;
import org.dddml.wms.domain.sellableinventoryitem.*;
import org.dddml.wms.domain.*;

public class SellableInventoryItemEntryMvoStateEventIdDto
{

    public SellableInventoryItemEntryMvoStateEventIdDto()
    {
    }

    public SellableInventoryItemEntryMvoStateEventId toSellableInventoryItemEntryMvoStateEventId()
    {
        SellableInventoryItemEntryMvoStateEventId v = new SellableInventoryItemEntryMvoStateEventId();
        v.setSellableInventoryItemEntryId(this.getSellableInventoryItemEntryId().toSellableInventoryItemEntryId());
        v.setSellableInventoryItemVersion(this.getSellableInventoryItemVersion());
        return v;
    }

    private SellableInventoryItemEntryIdDto sellableInventoryItemEntryId = new SellableInventoryItemEntryIdDto();

    public SellableInventoryItemEntryIdDto getSellableInventoryItemEntryId()
    {
        return this.sellableInventoryItemEntryId;
    }

    public void setSellableInventoryItemEntryId(SellableInventoryItemEntryIdDto sellableInventoryItemEntryId)
    {
        this.sellableInventoryItemEntryId = sellableInventoryItemEntryId;
    }

    private Long sellableInventoryItemVersion;

    public Long getSellableInventoryItemVersion()
    {
        return this.sellableInventoryItemVersion;
    }

    public void setSellableInventoryItemVersion(Long sellableInventoryItemVersion)
    {
        this.sellableInventoryItemVersion = sellableInventoryItemVersion;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != SellableInventoryItemEntryMvoStateEventIdDto.class) {
            return false;
        }

        SellableInventoryItemEntryMvoStateEventIdDto other = (SellableInventoryItemEntryMvoStateEventIdDto)obj;
        return true 
            && (getSellableInventoryItemEntryId() == other.getSellableInventoryItemEntryId() || (getSellableInventoryItemEntryId() != null && getSellableInventoryItemEntryId().equals(other.getSellableInventoryItemEntryId())))
            && (getSellableInventoryItemVersion() == other.getSellableInventoryItemVersion() || (getSellableInventoryItemVersion() != null && getSellableInventoryItemVersion().equals(other.getSellableInventoryItemVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getSellableInventoryItemEntryId() != null) {
            hash += 13 * this.getSellableInventoryItemEntryId().hashCode();
        }
        if (this.getSellableInventoryItemVersion() != null) {
            hash += 13 * this.getSellableInventoryItemVersion().hashCode();
        }
        return hash;
    }

}

