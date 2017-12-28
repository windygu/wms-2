package org.dddml.wms.domain.attributesetinstanceextensionfield;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class AttributeSetInstanceExtensionFieldStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "name",
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
	
    private AttributeSetInstanceExtensionFieldStateEventIdDto value;

    public AttributeSetInstanceExtensionFieldStateEventIdFlattenedDto()
    {
        this(new AttributeSetInstanceExtensionFieldStateEventIdDto());
    }

    public AttributeSetInstanceExtensionFieldStateEventIdFlattenedDto(AttributeSetInstanceExtensionFieldStateEventIdDto value)
    {
        this.value = value;
    }

    public AttributeSetInstanceExtensionFieldStateEventIdDto toAttributeSetInstanceExtensionFieldStateEventIdDto()
    {
        return this.value;
    }

    public AttributeSetInstanceExtensionFieldStateEventId toAttributeSetInstanceExtensionFieldStateEventId()
    {
        return this.value.toAttributeSetInstanceExtensionFieldStateEventId();
    }

    public String getName()
    {
        return this.value.getName();
    }

    public void setName(String name)
    {
        this.value.setName(name);
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

        AttributeSetInstanceExtensionFieldStateEventIdFlattenedDto other = (AttributeSetInstanceExtensionFieldStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

