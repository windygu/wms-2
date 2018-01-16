package org.dddml.wms.domain.inventoryitemrequirement;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class InventoryItemRequirementStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "inventoryItemRequirementIdProductId",
            "inventoryItemRequirementIdLocatorId",
            "inventoryItemRequirementIdAttributeSetInstanceId",
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
	
    private InventoryItemRequirementStateEventIdDto value;

    public InventoryItemRequirementStateEventIdFlattenedDto()
    {
        this(new InventoryItemRequirementStateEventIdDto());
    }

    public InventoryItemRequirementStateEventIdFlattenedDto(InventoryItemRequirementStateEventIdDto value)
    {
        this.value = value;
    }

    public InventoryItemRequirementStateEventIdDto toInventoryItemRequirementStateEventIdDto()
    {
        return this.value;
    }

    public InventoryItemRequirementStateEventId toInventoryItemRequirementStateEventId()
    {
        return this.value.toInventoryItemRequirementStateEventId();
    }

    public String getInventoryItemRequirementIdProductId()
    {
        return this.value.getInventoryItemRequirementId().getProductId();
    }

    public void setInventoryItemRequirementIdProductId(String inventoryItemRequirementIdProductId)
    {
        this.value.getInventoryItemRequirementId().setProductId(inventoryItemRequirementIdProductId);
    }

    public String getInventoryItemRequirementIdLocatorId()
    {
        return this.value.getInventoryItemRequirementId().getLocatorId();
    }

    public void setInventoryItemRequirementIdLocatorId(String inventoryItemRequirementIdLocatorId)
    {
        this.value.getInventoryItemRequirementId().setLocatorId(inventoryItemRequirementIdLocatorId);
    }

    public String getInventoryItemRequirementIdAttributeSetInstanceId()
    {
        return this.value.getInventoryItemRequirementId().getAttributeSetInstanceId();
    }

    public void setInventoryItemRequirementIdAttributeSetInstanceId(String inventoryItemRequirementIdAttributeSetInstanceId)
    {
        this.value.getInventoryItemRequirementId().setAttributeSetInstanceId(inventoryItemRequirementIdAttributeSetInstanceId);
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

        InventoryItemRequirementStateEventIdFlattenedDto other = (InventoryItemRequirementStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

