package org.dddml.wms.domain.physicalinventory;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class PhysicalInventoryLineStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "physicalInventoryDocumentNumber",
            "lineNumber",
            "physicalInventoryVersion",
        };

    public static final String[] propertyTypes = new String[]{
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
	
    private PhysicalInventoryLineStateEventIdDto value;

    public PhysicalInventoryLineStateEventIdFlattenedDto()
    {
        this(new PhysicalInventoryLineStateEventIdDto());
    }

    public PhysicalInventoryLineStateEventIdFlattenedDto(PhysicalInventoryLineStateEventIdDto value)
    {
        this.value = value;
    }

    public PhysicalInventoryLineStateEventIdDto toPhysicalInventoryLineStateEventIdDto()
    {
        return this.value;
    }

    public PhysicalInventoryLineStateEventId toPhysicalInventoryLineStateEventId()
    {
        return this.value.toPhysicalInventoryLineStateEventId();
    }

    public String getPhysicalInventoryDocumentNumber()
    {
        return this.value.getPhysicalInventoryDocumentNumber();
    }

    public void setPhysicalInventoryDocumentNumber(String physicalInventoryDocumentNumber)
    {
        this.value.setPhysicalInventoryDocumentNumber(physicalInventoryDocumentNumber);
    }

    public String getLineNumber()
    {
        return this.value.getLineNumber();
    }

    public void setLineNumber(String lineNumber)
    {
        this.value.setLineNumber(lineNumber);
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

        PhysicalInventoryLineStateEventIdFlattenedDto other = (PhysicalInventoryLineStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

