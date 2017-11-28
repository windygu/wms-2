package org.dddml.wms.domain.inventoryitem;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class InventoryItemIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "productId",
            "locatorId",
            "attributeSetInstance",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
            "String",
            "String",
        };

    public static final Map<String, String> propertyTypeMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }
	
    private InventoryItemIdDto value;

    public InventoryItemIdFlattenedDto()
    {
        this(new InventoryItemIdDto());
    }

    public InventoryItemIdFlattenedDto(InventoryItemIdDto value)
    {
        this.value = value;
    }

    public InventoryItemIdDto toInventoryItemIdDto()
    {
        return this.value;
    }

    public InventoryItemId toInventoryItemId()
    {
        return this.value.toInventoryItemId();
    }

    public String getProductId()
    {
        return this.value.getProductId();
    }

    public void setProductId(String productId)
    {
        this.value.setProductId(productId);
    }

    public String getLocatorId()
    {
        return this.value.getLocatorId();
    }

    public void setLocatorId(String locatorId)
    {
        this.value.setLocatorId(locatorId);
    }

    public String getAttributeSetInstance()
    {
        return this.value.getAttributeSetInstance();
    }

    public void setAttributeSetInstance(String attributeSetInstance)
    {
        this.value.setAttributeSetInstance(attributeSetInstance);
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

        InventoryItemIdFlattenedDto other = (InventoryItemIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

