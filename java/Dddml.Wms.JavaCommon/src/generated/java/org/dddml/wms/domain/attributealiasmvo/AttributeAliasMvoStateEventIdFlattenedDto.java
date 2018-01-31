package org.dddml.wms.domain.attributealiasmvo;

import org.dddml.wms.domain.attribute.AttributeAliasIdDto;
import org.dddml.wms.domain.attribute.*;
import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class AttributeAliasMvoStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "attributeAliasIdAttributeId",
            "attributeAliasIdCode",
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
	
    private AttributeAliasMvoStateEventIdDto value;

    public AttributeAliasMvoStateEventIdFlattenedDto()
    {
        this(new AttributeAliasMvoStateEventIdDto());
    }

    public AttributeAliasMvoStateEventIdFlattenedDto(AttributeAliasMvoStateEventIdDto value)
    {
        this.value = value;
    }

    public AttributeAliasMvoStateEventIdDto toAttributeAliasMvoStateEventIdDto()
    {
        return this.value;
    }

    public AttributeAliasMvoStateEventId toAttributeAliasMvoStateEventId()
    {
        return this.value.toAttributeAliasMvoStateEventId();
    }

    public String getAttributeAliasIdAttributeId()
    {
        return this.value.getAttributeAliasId().getAttributeId();
    }

    public void setAttributeAliasIdAttributeId(String attributeAliasIdAttributeId)
    {
        this.value.getAttributeAliasId().setAttributeId(attributeAliasIdAttributeId);
    }

    public String getAttributeAliasIdCode()
    {
        return this.value.getAttributeAliasId().getCode();
    }

    public void setAttributeAliasIdCode(String attributeAliasIdCode)
    {
        this.value.getAttributeAliasId().setCode(attributeAliasIdCode);
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

        AttributeAliasMvoStateEventIdFlattenedDto other = (AttributeAliasMvoStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

