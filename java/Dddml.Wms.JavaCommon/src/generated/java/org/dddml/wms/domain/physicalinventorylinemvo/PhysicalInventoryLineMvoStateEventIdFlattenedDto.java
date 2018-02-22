package org.dddml.wms.domain.physicalinventorylinemvo;

import org.dddml.wms.domain.physicalinventory.PhysicalInventoryLineIdDto;
import org.dddml.wms.domain.physicalinventory.*;
import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class PhysicalInventoryLineMvoStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "physicalInventoryLineIdPhysicalInventoryDocumentNumber",
            "physicalInventoryLineIdInventoryItemIdProductId",
            "physicalInventoryLineIdInventoryItemIdLocatorId",
            "physicalInventoryLineIdInventoryItemIdAttributeSetInstanceId",
            "physicalInventoryVersion",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
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
	
    private PhysicalInventoryLineMvoStateEventIdDto value;

    public PhysicalInventoryLineMvoStateEventIdFlattenedDto()
    {
        this(new PhysicalInventoryLineMvoStateEventIdDto());
    }

    public PhysicalInventoryLineMvoStateEventIdFlattenedDto(PhysicalInventoryLineMvoStateEventIdDto value)
    {
        this.value = value;
    }

    public PhysicalInventoryLineMvoStateEventIdDto toPhysicalInventoryLineMvoStateEventIdDto()
    {
        return this.value;
    }

    public PhysicalInventoryLineMvoStateEventId toPhysicalInventoryLineMvoStateEventId()
    {
        return this.value.toPhysicalInventoryLineMvoStateEventId();
    }

    public String getPhysicalInventoryLineIdPhysicalInventoryDocumentNumber()
    {
        return this.value.getPhysicalInventoryLineId().getPhysicalInventoryDocumentNumber();
    }

    public void setPhysicalInventoryLineIdPhysicalInventoryDocumentNumber(String physicalInventoryLineIdPhysicalInventoryDocumentNumber)
    {
        this.value.getPhysicalInventoryLineId().setPhysicalInventoryDocumentNumber(physicalInventoryLineIdPhysicalInventoryDocumentNumber);
    }

    public String getPhysicalInventoryLineIdInventoryItemIdProductId()
    {
        return this.value.getPhysicalInventoryLineId().getInventoryItemId().getProductId();
    }

    public void setPhysicalInventoryLineIdInventoryItemIdProductId(String physicalInventoryLineIdInventoryItemIdProductId)
    {
        this.value.getPhysicalInventoryLineId().getInventoryItemId().setProductId(physicalInventoryLineIdInventoryItemIdProductId);
    }

    public String getPhysicalInventoryLineIdInventoryItemIdLocatorId()
    {
        return this.value.getPhysicalInventoryLineId().getInventoryItemId().getLocatorId();
    }

    public void setPhysicalInventoryLineIdInventoryItemIdLocatorId(String physicalInventoryLineIdInventoryItemIdLocatorId)
    {
        this.value.getPhysicalInventoryLineId().getInventoryItemId().setLocatorId(physicalInventoryLineIdInventoryItemIdLocatorId);
    }

    public String getPhysicalInventoryLineIdInventoryItemIdAttributeSetInstanceId()
    {
        return this.value.getPhysicalInventoryLineId().getInventoryItemId().getAttributeSetInstanceId();
    }

    public void setPhysicalInventoryLineIdInventoryItemIdAttributeSetInstanceId(String physicalInventoryLineIdInventoryItemIdAttributeSetInstanceId)
    {
        this.value.getPhysicalInventoryLineId().getInventoryItemId().setAttributeSetInstanceId(physicalInventoryLineIdInventoryItemIdAttributeSetInstanceId);
    }

    public Long getPhysicalInventoryVersion()
    {
        return this.value.getPhysicalInventoryVersion();
    }

    public void setPhysicalInventoryVersion(Long physicalInventoryVersion)
    {
        this.value.setPhysicalInventoryVersion(physicalInventoryVersion);
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

        PhysicalInventoryLineMvoStateEventIdFlattenedDto other = (PhysicalInventoryLineMvoStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

