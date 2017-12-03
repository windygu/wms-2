package org.dddml.wms.domain.sellableinventoryitementrymvo;

import org.dddml.wms.domain.sellableinventoryitem.SellableInventoryItemEntryIdDto;
import org.dddml.wms.domain.sellableinventoryitem.*;
import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class SellableInventoryItemEntryMvoStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "sellableInventoryItemEntryIdSellableInventoryItemIdProductId",
            "sellableInventoryItemEntryIdSellableInventoryItemIdLocatorId",
            "sellableInventoryItemEntryIdSellableInventoryItemIdAttributeSetInstanceId",
            "sellableInventoryItemEntryIdEntrySeqId",
            "sellableInventoryItemVersion",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
            "String",
            "String",
            "Long",
            "Long",
        };

    public static final Map<String, String> propertyTypeMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }
	
    private SellableInventoryItemEntryMvoStateEventIdDto value;

    public SellableInventoryItemEntryMvoStateEventIdFlattenedDto()
    {
        this(new SellableInventoryItemEntryMvoStateEventIdDto());
    }

    public SellableInventoryItemEntryMvoStateEventIdFlattenedDto(SellableInventoryItemEntryMvoStateEventIdDto value)
    {
        this.value = value;
    }

    public SellableInventoryItemEntryMvoStateEventIdDto toSellableInventoryItemEntryMvoStateEventIdDto()
    {
        return this.value;
    }

    public SellableInventoryItemEntryMvoStateEventId toSellableInventoryItemEntryMvoStateEventId()
    {
        return this.value.toSellableInventoryItemEntryMvoStateEventId();
    }

    public String getSellableInventoryItemEntryIdSellableInventoryItemIdProductId()
    {
        return this.value.getSellableInventoryItemEntryId().getSellableInventoryItemId().getProductId();
    }

    public void setSellableInventoryItemEntryIdSellableInventoryItemIdProductId(String sellableInventoryItemEntryIdSellableInventoryItemIdProductId)
    {
        this.value.getSellableInventoryItemEntryId().getSellableInventoryItemId().setProductId(sellableInventoryItemEntryIdSellableInventoryItemIdProductId);
    }

    public String getSellableInventoryItemEntryIdSellableInventoryItemIdLocatorId()
    {
        return this.value.getSellableInventoryItemEntryId().getSellableInventoryItemId().getLocatorId();
    }

    public void setSellableInventoryItemEntryIdSellableInventoryItemIdLocatorId(String sellableInventoryItemEntryIdSellableInventoryItemIdLocatorId)
    {
        this.value.getSellableInventoryItemEntryId().getSellableInventoryItemId().setLocatorId(sellableInventoryItemEntryIdSellableInventoryItemIdLocatorId);
    }

    public String getSellableInventoryItemEntryIdSellableInventoryItemIdAttributeSetInstanceId()
    {
        return this.value.getSellableInventoryItemEntryId().getSellableInventoryItemId().getAttributeSetInstanceId();
    }

    public void setSellableInventoryItemEntryIdSellableInventoryItemIdAttributeSetInstanceId(String sellableInventoryItemEntryIdSellableInventoryItemIdAttributeSetInstanceId)
    {
        this.value.getSellableInventoryItemEntryId().getSellableInventoryItemId().setAttributeSetInstanceId(sellableInventoryItemEntryIdSellableInventoryItemIdAttributeSetInstanceId);
    }

    public Long getSellableInventoryItemEntryIdEntrySeqId()
    {
        return this.value.getSellableInventoryItemEntryId().getEntrySeqId();
    }

    public void setSellableInventoryItemEntryIdEntrySeqId(Long sellableInventoryItemEntryIdEntrySeqId)
    {
        this.value.getSellableInventoryItemEntryId().setEntrySeqId(sellableInventoryItemEntryIdEntrySeqId);
    }

    public Long getSellableInventoryItemVersion()
    {
        return this.value.getSellableInventoryItemVersion();
    }

    public void setSellableInventoryItemVersion(Long sellableInventoryItemVersion)
    {
        this.value.setSellableInventoryItemVersion(sellableInventoryItemVersion);
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

        SellableInventoryItemEntryMvoStateEventIdFlattenedDto other = (SellableInventoryItemEntryMvoStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

