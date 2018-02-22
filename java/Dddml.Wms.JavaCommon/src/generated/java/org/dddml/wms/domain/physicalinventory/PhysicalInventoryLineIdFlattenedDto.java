package org.dddml.wms.domain.physicalinventory;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class PhysicalInventoryLineIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "physicalInventoryDocumentNumber",
            "inventoryItemIdProductId",
            "inventoryItemIdLocatorId",
            "inventoryItemIdAttributeSetInstanceId",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
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
	
    private PhysicalInventoryLineIdDto value;

    public PhysicalInventoryLineIdFlattenedDto()
    {
        this(new PhysicalInventoryLineIdDto());
    }

    public PhysicalInventoryLineIdFlattenedDto(PhysicalInventoryLineIdDto value)
    {
        this.value = value;
    }

    public PhysicalInventoryLineIdDto toPhysicalInventoryLineIdDto()
    {
        return this.value;
    }

    public PhysicalInventoryLineId toPhysicalInventoryLineId()
    {
        return this.value.toPhysicalInventoryLineId();
    }

    public String getPhysicalInventoryDocumentNumber()
    {
        return this.value.getPhysicalInventoryDocumentNumber();
    }

    public void setPhysicalInventoryDocumentNumber(String physicalInventoryDocumentNumber)
    {
        this.value.setPhysicalInventoryDocumentNumber(physicalInventoryDocumentNumber);
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

    public String getInventoryItemIdAttributeSetInstanceId()
    {
        return this.value.getInventoryItemId().getAttributeSetInstanceId();
    }

    public void setInventoryItemIdAttributeSetInstanceId(String inventoryItemIdAttributeSetInstanceId)
    {
        this.value.getInventoryItemId().setAttributeSetInstanceId(inventoryItemIdAttributeSetInstanceId);
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

        PhysicalInventoryLineIdFlattenedDto other = (PhysicalInventoryLineIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

