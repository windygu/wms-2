package org.dddml.wms.domain.attributealiasmvo;

import org.dddml.wms.domain.attribute.*;
import org.dddml.wms.domain.*;

public class AttributeAliasMvoStateEventIdDtoWrapper extends AttributeAliasMvoStateEventIdDto
{
	
    private AttributeAliasMvoStateEventId value;

    public AttributeAliasMvoStateEventIdDtoWrapper()
    {
        this(new AttributeAliasMvoStateEventId());
    }

    public AttributeAliasMvoStateEventIdDtoWrapper(AttributeAliasMvoStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public AttributeAliasMvoStateEventId toAttributeAliasMvoStateEventId()
    {
        return this.value;
    }

    @Override
    public AttributeAliasIdDto getAttributeAliasId()
    {
        return new AttributeAliasIdDtoWrapper(this.value.getAttributeAliasId());
    }

    @Override
    public void setAttributeAliasId(AttributeAliasIdDto attributeAliasId)
    {
        this.value.setAttributeAliasId(attributeAliasId.toAttributeAliasId());
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
        if (obj.getClass() == AttributeAliasMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        AttributeAliasMvoStateEventIdDtoWrapper other = (AttributeAliasMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

