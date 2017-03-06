package org.dddml.wms.domain.attributevaluemvo;

import org.dddml.wms.domain.attribute.AttributeValueIdDto;
import org.dddml.wms.domain.attribute.*;
import org.dddml.wms.domain.*;

public class AttributeValueMvoStateEventIdDtoWrapper extends AttributeValueMvoStateEventIdDto
{
	
    private AttributeValueMvoStateEventId value;

    public AttributeValueMvoStateEventIdDtoWrapper()
    {
        this(new AttributeValueMvoStateEventId());
    }

    public AttributeValueMvoStateEventIdDtoWrapper(AttributeValueMvoStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public AttributeValueMvoStateEventId toAttributeValueMvoStateEventId()
    {
        return this.value;
    }

    @Override
    public AttributeValueIdDto getAttributeValueId()
    {
        return new AttributeValueIdDtoWrapper(this.value.getAttributeValueId());
    }

    @Override
    public void setAttributeValueId(AttributeValueIdDto attributeValueId)
    {
        this.value.setAttributeValueId(attributeValueId.toAttributeValueId());
    }

    @Override
    public Long getAttributeVersion()
    {
        return this.value.getAttributeVersion();
    }

    @Override
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
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == AttributeValueMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        AttributeValueMvoStateEventIdDtoWrapper other = (AttributeValueMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

