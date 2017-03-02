package org.dddml.wms.domain;

import org.dddml.wms.domain.*;

public class AttributeSetInstanceExtensionFieldGroupStateEventIdDtoWrapper extends AttributeSetInstanceExtensionFieldGroupStateEventIdDto
{
	
    private AttributeSetInstanceExtensionFieldGroupStateEventId value;

    public AttributeSetInstanceExtensionFieldGroupStateEventIdDtoWrapper()
    {
        this(new AttributeSetInstanceExtensionFieldGroupStateEventId());
    }

    public AttributeSetInstanceExtensionFieldGroupStateEventIdDtoWrapper(AttributeSetInstanceExtensionFieldGroupStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public AttributeSetInstanceExtensionFieldGroupStateEventId toAttributeSetInstanceExtensionFieldGroupStateEventId()
    {
        return this.value;
    }

    @Override
    public String getId()
    {
        return this.value.getId();
    }

    @Override
    public void setId(String id)
    {
        this.value.setId(id);
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
        if (obj.getClass() == AttributeSetInstanceExtensionFieldGroupStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        AttributeSetInstanceExtensionFieldGroupStateEventIdDtoWrapper other = (AttributeSetInstanceExtensionFieldGroupStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

