package org.dddml.wms.domain.sellableinventoryitem;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class SellableInventoryItemStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "sellableInventoryItemIdProductId",
            "sellableInventoryItemIdLocatorId",
            "sellableInventoryItemIdAttributeSetInstanceId",
            "version",
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
	
    private SellableInventoryItemStateEventIdDto value;

    public SellableInventoryItemStateEventIdFlattenedDto()
    {
        this(new SellableInventoryItemStateEventIdDto());
    }

    public SellableInventoryItemStateEventIdFlattenedDto(SellableInventoryItemStateEventIdDto value)
    {
        this.value = value;
    }

    public SellableInventoryItemStateEventIdDto toSellableInventoryItemStateEventIdDto()
    {
        return this.value;
    }

    public SellableInventoryItemStateEventId toSellableInventoryItemStateEventId()
    {
        return this.value.toSellableInventoryItemStateEventId();
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

    public Long getVersion()
    {
        return this.value.getVersion();
    }

    public void setVersion(Long version)
    {
        this.value.setVersion(version);
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

        SellableInventoryItemStateEventIdFlattenedDto other = (SellableInventoryItemStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

