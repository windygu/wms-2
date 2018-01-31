package org.dddml.wms.domain.sellableinventoryitem;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class SellableInventoryItemEntryStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "sellableInventoryItemIdProductId",
            "sellableInventoryItemIdLocatorId",
            "sellableInventoryItemIdAttributeSetInstanceId",
            "entrySeqId",
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
	
    private SellableInventoryItemEntryStateEventIdDto value;

    public SellableInventoryItemEntryStateEventIdFlattenedDto()
    {
        this(new SellableInventoryItemEntryStateEventIdDto());
    }

    public SellableInventoryItemEntryStateEventIdFlattenedDto(SellableInventoryItemEntryStateEventIdDto value)
    {
        this.value = value;
    }

    public SellableInventoryItemEntryStateEventIdDto toSellableInventoryItemEntryStateEventIdDto()
    {
        return this.value;
    }

    public SellableInventoryItemEntryStateEventId toSellableInventoryItemEntryStateEventId()
    {
        return this.value.toSellableInventoryItemEntryStateEventId();
    }

    public String getSellableInventoryItemIdProductId()
    {
        return this.value.getSellableInventoryItemId().getProductId();
    }

    public void setSellableInventoryItemIdProductId(String sellableInventoryItemIdProductId)
    {
        this.value.getSellableInventoryItemId().setProductId(sellableInventoryItemIdProductId);
    }

    public String getSellableInventoryItemIdLocatorId()
    {
        return this.value.getSellableInventoryItemId().getLocatorId();
    }

    public void setSellableInventoryItemIdLocatorId(String sellableInventoryItemIdLocatorId)
    {
        this.value.getSellableInventoryItemId().setLocatorId(sellableInventoryItemIdLocatorId);
    }

    public String getSellableInventoryItemIdAttributeSetInstanceId()
    {
        return this.value.getSellableInventoryItemId().getAttributeSetInstanceId();
    }

    public void setSellableInventoryItemIdAttributeSetInstanceId(String sellableInventoryItemIdAttributeSetInstanceId)
    {
        this.value.getSellableInventoryItemId().setAttributeSetInstanceId(sellableInventoryItemIdAttributeSetInstanceId);
    }

    public Long getEntrySeqId()
    {
        return this.value.getEntrySeqId();
    }

    public void setEntrySeqId(Long entrySeqId)
    {
        this.value.setEntrySeqId(entrySeqId);
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

        SellableInventoryItemEntryStateEventIdFlattenedDto other = (SellableInventoryItemEntryStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

