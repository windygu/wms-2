package org.dddml.wms.domain.inventoryitementrymvo;

import org.dddml.wms.domain.inventoryitem.InventoryItemEntryIdDto;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class InventoryItemEntryMvoStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "inventoryItemEntryIdInventoryItemIdProductId",
            "inventoryItemEntryIdInventoryItemIdLocatorId",
            "inventoryItemEntryIdInventoryItemIdAttributeSetInstance",
            "inventoryItemEntryIdEntrySeqId",
            "inventoryItemVersion",
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
	
    private InventoryItemEntryMvoStateEventIdDto value;

    public InventoryItemEntryMvoStateEventIdFlattenedDto()
    {
        this(new InventoryItemEntryMvoStateEventIdDto());
    }

    public InventoryItemEntryMvoStateEventIdFlattenedDto(InventoryItemEntryMvoStateEventIdDto value)
    {
        this.value = value;
    }

    public InventoryItemEntryMvoStateEventIdDto toInventoryItemEntryMvoStateEventIdDto()
    {
        return this.value;
    }

    public InventoryItemEntryMvoStateEventId toInventoryItemEntryMvoStateEventId()
    {
        return this.value.toInventoryItemEntryMvoStateEventId();
    }

    public String getInventoryItemEntryIdInventoryItemIdProductId()
    {
        return this.value.getInventoryItemEntryId().getInventoryItemId().getProductId();
    }

    public void setInventoryItemEntryIdInventoryItemIdProductId(String inventoryItemEntryIdInventoryItemIdProductId)
    {
        this.value.getInventoryItemEntryId().getInventoryItemId().setProductId(inventoryItemEntryIdInventoryItemIdProductId);
    }

    public String getInventoryItemEntryIdInventoryItemIdLocatorId()
    {
        return this.value.getInventoryItemEntryId().getInventoryItemId().getLocatorId();
    }

    public void setInventoryItemEntryIdInventoryItemIdLocatorId(String inventoryItemEntryIdInventoryItemIdLocatorId)
    {
        this.value.getInventoryItemEntryId().getInventoryItemId().setLocatorId(inventoryItemEntryIdInventoryItemIdLocatorId);
    }

    public String getInventoryItemEntryIdInventoryItemIdAttributeSetInstance()
    {
        return this.value.getInventoryItemEntryId().getInventoryItemId().getAttributeSetInstance();
    }

    public void setInventoryItemEntryIdInventoryItemIdAttributeSetInstance(String inventoryItemEntryIdInventoryItemIdAttributeSetInstance)
    {
        this.value.getInventoryItemEntryId().getInventoryItemId().setAttributeSetInstance(inventoryItemEntryIdInventoryItemIdAttributeSetInstance);
    }

    public Long getInventoryItemEntryIdEntrySeqId()
    {
        return this.value.getInventoryItemEntryId().getEntrySeqId();
    }

    public void setInventoryItemEntryIdEntrySeqId(Long inventoryItemEntryIdEntrySeqId)
    {
        this.value.getInventoryItemEntryId().setEntrySeqId(inventoryItemEntryIdEntrySeqId);
    }

    public Long getInventoryItemVersion()
    {
        return this.value.getInventoryItemVersion();
    }

    public void setInventoryItemVersion(Long inventoryItemVersion)
    {
        this.value.setInventoryItemVersion(inventoryItemVersion);
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

        InventoryItemEntryMvoStateEventIdFlattenedDto other = (InventoryItemEntryMvoStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

