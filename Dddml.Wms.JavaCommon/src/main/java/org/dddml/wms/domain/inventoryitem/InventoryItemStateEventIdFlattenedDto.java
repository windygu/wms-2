package org.dddml.wms.domain.inventoryitem;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class InventoryItemStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "inventoryItemIdProductId",
            "inventoryItemIdLocatorId",
            "inventoryItemIdAttributeSetInstance",
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
	
    private InventoryItemStateEventIdDto value;

    public InventoryItemStateEventIdFlattenedDto()
    {
        this(new InventoryItemStateEventIdDto());
    }

    public InventoryItemStateEventIdFlattenedDto(InventoryItemStateEventIdDto value)
    {
        this.value = value;
    }

    public InventoryItemStateEventIdDto toInventoryItemStateEventIdDto()
    {
        return this.value;
    }

    public InventoryItemStateEventId toInventoryItemStateEventId()
    {
        return this.value.toInventoryItemStateEventId();
    }

    public String getInventoryItemIdProductId()
    {
        return this.value.getInventoryItemId().getProductId();
    }

    public void setInventoryItemIdProductId(String inventoryItemIdProductId)
    {
        this.value.getInventoryItemId().setProductId(inventoryItemIdProductId);
    }

    public String getInventoryItemIdLocatorId()
    {
        return this.value.getInventoryItemId().getLocatorId();
    }

    public void setInventoryItemIdLocatorId(String inventoryItemIdLocatorId)
    {
        this.value.getInventoryItemId().setLocatorId(inventoryItemIdLocatorId);
    }

    public String getInventoryItemIdAttributeSetInstance()
    {
        return this.value.getInventoryItemId().getAttributeSetInstance();
    }

    public void setInventoryItemIdAttributeSetInstance(String inventoryItemIdAttributeSetInstance)
    {
        this.value.getInventoryItemId().setAttributeSetInstance(inventoryItemIdAttributeSetInstance);
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

        InventoryItemStateEventIdFlattenedDto other = (InventoryItemStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

