package org.dddml.wms.domain;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class AttributeSetInstanceExtensionFieldIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "groupId",
            "index",
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
	
    private AttributeSetInstanceExtensionFieldIdDto value;

    public AttributeSetInstanceExtensionFieldIdFlattenedDto()
    {
        this(new AttributeSetInstanceExtensionFieldIdDto());
    }

    public AttributeSetInstanceExtensionFieldIdFlattenedDto(AttributeSetInstanceExtensionFieldIdDto value)
    {
        this.value = value;
    }

    public AttributeSetInstanceExtensionFieldIdDto toAttributeSetInstanceExtensionFieldIdDto()
    {
        return this.value;
    }

    public AttributeSetInstanceExtensionFieldId toAttributeSetInstanceExtensionFieldId()
    {
        return this.value.toAttributeSetInstanceExtensionFieldId();
    }

    public String getGroupId()
    {
        return this.value.getGroupId();
    }

    public void setGroupId(String groupId)
    {
        this.value.setGroupId(groupId);
    }

    public String getIndex()
    {
        return this.value.getIndex();
    }

    public void setIndex(String index)
    {
        this.value.setIndex(index);
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

        AttributeSetInstanceExtensionFieldIdFlattenedDto other = (AttributeSetInstanceExtensionFieldIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

