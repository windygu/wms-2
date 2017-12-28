package org.dddml.wms.domain.attribute;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class AttributeAliasIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "attributeId",
            "code",
        };

    public static final String[] propertyTypes = new String[]{
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
	
    private AttributeAliasIdDto value;

    public AttributeAliasIdFlattenedDto()
    {
        this(new AttributeAliasIdDto());
    }

    public AttributeAliasIdFlattenedDto(AttributeAliasIdDto value)
    {
        this.value = value;
    }

    public AttributeAliasIdDto toAttributeAliasIdDto()
    {
        return this.value;
    }

    public AttributeAliasId toAttributeAliasId()
    {
        return this.value.toAttributeAliasId();
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        AttributeAliasIdFlattenedDto other = (AttributeAliasIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

