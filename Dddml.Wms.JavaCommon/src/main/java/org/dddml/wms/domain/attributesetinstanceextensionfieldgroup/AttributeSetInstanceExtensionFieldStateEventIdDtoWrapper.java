package org.dddml.wms.domain.attributesetinstanceextensionfieldgroup;

import org.dddml.wms.domain.*;

public class AttributeSetInstanceExtensionFieldStateEventIdDtoWrapper extends AttributeSetInstanceExtensionFieldStateEventIdDto
{
	
    private AttributeSetInstanceExtensionFieldStateEventId value;

    public AttributeSetInstanceExtensionFieldStateEventIdDtoWrapper()
    {
        this(new AttributeSetInstanceExtensionFieldStateEventId());
    }

    public AttributeSetInstanceExtensionFieldStateEventIdDtoWrapper(AttributeSetInstanceExtensionFieldStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public AttributeSetInstanceExtensionFieldStateEventId toAttributeSetInstanceExtensionFieldStateEventId()
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
    public Long getAttributeSetInstanceExtensionFieldGroupVersion()
    {
        return this.value.getAttributeSetInstanceExtensionFieldGroupVersion();
    }

    @Override
    public void setAttributeSetInstanceExtensionFieldGroupVersion(Long attributeSetInstanceExtensionFieldGroupVersion)
    {
        this.value.setAttributeSetInstanceExtensionFieldGroupVersion(attributeSetInstanceExtensionFieldGroupVersion);
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
        if (obj.getClass() == AttributeSetInstanceExtensionFieldStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        AttributeSetInstanceExtensionFieldStateEventIdDtoWrapper other = (AttributeSetInstanceExtensionFieldStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

