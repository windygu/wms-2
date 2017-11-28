package org.dddml.wms.domain.inventoryitemeventtype;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class InventoryItemEventTypeStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "inventoryItemEventTypeId",
            "version",
        };

    public static final String[] propertyTypes = new String[]{
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
	
    private InventoryItemEventTypeStateEventIdDto value;

    public InventoryItemEventTypeStateEventIdFlattenedDto()
    {
        this(new InventoryItemEventTypeStateEventIdDto());
    }

    public InventoryItemEventTypeStateEventIdFlattenedDto(InventoryItemEventTypeStateEventIdDto value)
    {
        this.value = value;
    }

    public InventoryItemEventTypeStateEventIdDto toInventoryItemEventTypeStateEventIdDto()
    {
        return this.value;
    }

    public InventoryItemEventTypeStateEventId toInventoryItemEventTypeStateEventId()
    {
        return this.value.toInventoryItemEventTypeStateEventId();
    }

    public String getInventoryItemEventTypeId()
    {
        return this.value.getInventoryItemEventTypeId();
    }

    public void setInventoryItemEventTypeId(String inventoryItemEventTypeId)
    {
        this.value.setInventoryItemEventTypeId(inventoryItemEventTypeId);
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

        InventoryItemEventTypeStateEventIdFlattenedDto other = (InventoryItemEventTypeStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

