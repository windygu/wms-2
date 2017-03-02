package org.dddml.wms.domain;

import org.dddml.wms.domain.*;

public class AttributeStateEventIdDtoWrapper extends AttributeStateEventIdDto
{
	
    private AttributeStateEventId value;

    public AttributeStateEventIdDtoWrapper()
    {
        this(new AttributeStateEventId());
    }

    public AttributeStateEventIdDtoWrapper(AttributeStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public AttributeStateEventId toAttributeStateEventId()
    {
        return this.value;
    }

    @Override
    public String getAttributeId()
    {
        return this.value.getAttributeId();
    }

    @Override
    public void setAttributeId(String attributeId)
    {
        this.value.setAttributeId(attributeId);
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
        if (obj.getClass() == AttributeStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        AttributeStateEventIdDtoWrapper other = (AttributeStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

