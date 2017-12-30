package org.dddml.wms.domain.uomtype;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class UomTypeStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "uomTypeId",
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
	
    private UomTypeStateEventIdDto value;

    public UomTypeStateEventIdFlattenedDto()
    {
        this(new UomTypeStateEventIdDto());
    }

    public UomTypeStateEventIdFlattenedDto(UomTypeStateEventIdDto value)
    {
        this.value = value;
    }

    public UomTypeStateEventIdDto toUomTypeStateEventIdDto()
    {
        return this.value;
    }

    public UomTypeStateEventId toUomTypeStateEventId()
    {
        return this.value.toUomTypeStateEventId();
    }

    public String getUomTypeId()
    {
        return this.value.getUomTypeId();
    }

    public void setUomTypeId(String uomTypeId)
    {
        this.value.setUomTypeId(uomTypeId);
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

        UomTypeStateEventIdFlattenedDto other = (UomTypeStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

