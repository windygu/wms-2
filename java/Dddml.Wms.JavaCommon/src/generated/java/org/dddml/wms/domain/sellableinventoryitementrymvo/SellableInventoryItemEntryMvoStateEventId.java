package org.dddml.wms.domain.sellableinventoryitementrymvo;

import java.io.Serializable;
import org.dddml.wms.domain.sellableinventoryitem.SellableInventoryItemEntryId;
import org.dddml.wms.domain.sellableinventoryitem.*;
import org.dddml.wms.domain.*;

public class SellableInventoryItemEntryMvoStateEventId implements Serializable
{
    private SellableInventoryItemEntryId sellableInventoryItemEntryId = new SellableInventoryItemEntryId();

    public SellableInventoryItemEntryId getSellableInventoryItemEntryId()
    {
        return this.sellableInventoryItemEntryId;
    }

    public void setSellableInventoryItemEntryId(SellableInventoryItemEntryId sellableInventoryItemEntryId)
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

    public String getSellableInventoryItemEntryIdSellableInventoryItemIdProductId()
    {
        return getSellableInventoryItemEntryId().getSellableInventoryItemId().getProductId();
    }

    public void setSellableInventoryItemEntryIdSellableInventoryItemIdProductId(String sellableInventoryItemEntryIdSellableInventoryItemIdProductId)
    {
        getSellableInventoryItemEntryId().getSellableInventoryItemId().setProductId(sellableInventoryItemEntryIdSellableInventoryItemIdProductId);
    }

    public String getSellableInventoryItemEntryIdSellableInventoryItemIdLocatorId()
    {
        return getSellableInventoryItemEntryId().getSellableInventoryItemId().getLocatorId();
    }

    public void setSellableInventoryItemEntryIdSellableInventoryItemIdLocatorId(String sellableInventoryItemEntryIdSellableInventoryItemIdLocatorId)
    {
        getSellableInventoryItemEntryId().getSellableInventoryItemId().setLocatorId(sellableInventoryItemEntryIdSellableInventoryItemIdLocatorId);
    }

    public String getSellableInventoryItemEntryIdSellableInventoryItemIdAttributeSetInstanceId()
    {
        return getSellableInventoryItemEntryId().getSellableInventoryItemId().getAttributeSetInstanceId();
    }

    public void setSellableInventoryItemEntryIdSellableInventoryItemIdAttributeSetInstanceId(String sellableInventoryItemEntryIdSellableInventoryItemIdAttributeSetInstanceId)
    {
        getSellableInventoryItemEntryId().getSellableInventoryItemId().setAttributeSetInstanceId(sellableInventoryItemEntryIdSellableInventoryItemIdAttributeSetInstanceId);
    }

    public Long getSellableInventoryItemEntryIdEntrySeqId()
    {
        return getSellableInventoryItemEntryId().getEntrySeqId();
    }

    public void setSellableInventoryItemEntryIdEntrySeqId(Long sellableInventoryItemEntryIdEntrySeqId)
    {
        getSellableInventoryItemEntryId().setEntrySeqId(sellableInventoryItemEntryIdEntrySeqId);
    }

    public SellableInventoryItemEntryMvoStateEventId()
    {
    }

    public SellableInventoryItemEntryMvoStateEventId(SellableInventoryItemEntryId sellableInventoryItemEntryId, Long sellableInventoryItemVersion)
    {
        this.sellableInventoryItemEntryId = sellableInventoryItemEntryId;
        this.sellableInventoryItemVersion = sellableInventoryItemVersion;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        SellableInventoryItemEntryMvoStateEventId other = (SellableInventoryItemEntryMvoStateEventId)obj;
        return true 
            && (sellableInventoryItemEntryId == other.sellableInventoryItemEntryId || (sellableInventoryItemEntryId != null && sellableInventoryItemEntryId.equals(other.sellableInventoryItemEntryId)))
            && (sellableInventoryItemVersion == other.sellableInventoryItemVersion || (sellableInventoryItemVersion != null && sellableInventoryItemVersion.equals(other.sellableInventoryItemVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.sellableInventoryItemEntryId != null) {
            hash += 13 * this.sellableInventoryItemEntryId.hashCode();
        }
        if (this.sellableInventoryItemVersion != null) {
            hash += 13 * this.sellableInventoryItemVersion.hashCode();
        }
        return hash;
    }

}

