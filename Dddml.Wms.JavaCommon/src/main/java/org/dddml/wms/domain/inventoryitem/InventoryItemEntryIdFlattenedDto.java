package org.dddml.wms.domain.inventoryitem;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class InventoryItemEntryIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "inventoryItemIdProductId",
            "inventoryItemIdLocatorId",
            "inventoryItemIdAttributeSetInstance",
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
	
    private InventoryItemEntryIdDto value;

    public InventoryItemEntryIdFlattenedDto()
    {
        this(new InventoryItemEntryIdDto());
    }

    public InventoryItemEntryIdFlattenedDto(InventoryItemEntryIdDto value)
    {
        this.value = value;
    }

    public InventoryItemEntryIdDto toInventoryItemEntryIdDto()
    {
        return this.value;
    }

    public InventoryItemEntryId toInventoryItemEntryId()
    {
        return this.value.toInventoryItemEntryId();
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

        InventoryItemEntryIdFlattenedDto other = (InventoryItemEntryIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

