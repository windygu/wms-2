package org.dddml.wms.domain;

import org.dddml.wms.domain.*;

public class AttributeSetInstanceExtensionFieldIdDtoWrapper extends AttributeSetInstanceExtensionFieldIdDto
{
	
    private AttributeSetInstanceExtensionFieldId value;

    public AttributeSetInstanceExtensionFieldIdDtoWrapper()
    {
        this(new AttributeSetInstanceExtensionFieldId());
    }

    public AttributeSetInstanceExtensionFieldIdDtoWrapper(AttributeSetInstanceExtensionFieldId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public AttributeSetInstanceExtensionFieldId toAttributeSetInstanceExtensionFieldId()
    {
        return this.value;
    }

    @Override
    public String getGroupId()
    {
        return this.value.getGroupId();
    }

    @Override
    public void setGroupId(String groupId)
    {
        this.value.setGroupId(groupId);
    }

    @Override
    public String getIndex()
    {
        return this.value.getIndex();
    }

    @Override
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
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == AttributeSetInstanceExtensionFieldIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        AttributeSetInstanceExtensionFieldIdDtoWrapper other = (AttributeSetInstanceExtensionFieldIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

