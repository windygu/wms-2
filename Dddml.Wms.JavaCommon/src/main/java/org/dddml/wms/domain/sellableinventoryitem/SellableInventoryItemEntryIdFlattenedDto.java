package org.dddml.wms.domain.sellableinventoryitem;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class SellableInventoryItemEntryIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "sellableInventoryItemIdProductId",
            "sellableInventoryItemIdLocatorId",
            "sellableInventoryItemIdAttributeSetInstanceId",
            "entrySeqId",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
            "String",
            "String",
            "Long",
        };

    public static final Map<String, String> propertyTypeMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }
	
    private SellableInventoryItemEntryIdDto value;

    public SellableInventoryItemEntryIdFlattenedDto()
    {
        this(new SellableInventoryItemEntryIdDto());
    }

    public SellableInventoryItemEntryIdFlattenedDto(SellableInventoryItemEntryIdDto value)
    {
        this.value = value;
    }

    public SellableInventoryItemEntryIdDto toSellableInventoryItemEntryIdDto()
    {
        return this.value;
    }

    public SellableInventoryItemEntryId toSellableInventoryItemEntryId()
    {
        return this.value.toSellableInventoryItemEntryId();
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        SellableInventoryItemEntryIdFlattenedDto other = (SellableInventoryItemEntryIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

