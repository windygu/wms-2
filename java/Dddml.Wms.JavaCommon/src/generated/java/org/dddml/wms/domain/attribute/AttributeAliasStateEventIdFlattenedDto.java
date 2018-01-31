package org.dddml.wms.domain.attribute;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class AttributeAliasStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "attributeId",
            "code",
            "attributeVersion",
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
	
    private AttributeAliasStateEventIdDto value;

    public AttributeAliasStateEventIdFlattenedDto()
    {
        this(new AttributeAliasStateEventIdDto());
    }

    public AttributeAliasStateEventIdFlattenedDto(AttributeAliasStateEventIdDto value)
    {
        this.value = value;
    }

    public AttributeAliasStateEventIdDto toAttributeAliasStateEventIdDto()
    {
        return this.value;
    }

    public AttributeAliasStateEventId toAttributeAliasStateEventId()
    {
        return this.value.toAttributeAliasStateEventId();
    }

    public String getAttributeId()
    {
        return this.value.getAttributeId();
    }

    public void setAttributeId(String attributeId)
    {
        this.value.setAttributeId(attributeId);
    }

    public String getCode()
    {
        return this.value.getCode();
    }

    public void setCode(String code)
    {
        this.value.setCode(code);
    }

    public Long getAttributeVersion()
    {
        return this.value.getAttributeVersion();
    }

    public void setAttributeVersion(Long attributeVersion)
    {
        this.value.setAttributeVersion(attributeVersion);
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

        AttributeAliasStateEventIdFlattenedDto other = (AttributeAliasStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

