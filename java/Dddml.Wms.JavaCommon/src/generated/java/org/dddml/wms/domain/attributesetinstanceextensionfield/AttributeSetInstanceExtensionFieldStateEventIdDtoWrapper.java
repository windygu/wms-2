package org.dddml.wms.domain.attributesetinstanceextensionfield;

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
    public String getName()
    {
        return this.value.getName();
    }

    @Override
    public void setName(String name)
    {
        this.value.setName(name);
    }

    @Override
    public Long getVersion()
    {
        return this.value.getVersion();
    }

    @Override
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

