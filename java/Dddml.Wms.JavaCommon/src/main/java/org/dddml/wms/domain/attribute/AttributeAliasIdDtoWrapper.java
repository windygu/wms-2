package org.dddml.wms.domain.attribute;

import org.dddml.wms.domain.*;

public class AttributeAliasIdDtoWrapper extends AttributeAliasIdDto
{
	
    private AttributeAliasId value;

    public AttributeAliasIdDtoWrapper()
    {
        this(new AttributeAliasId());
    }

    public AttributeAliasIdDtoWrapper(AttributeAliasId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public AttributeAliasId toAttributeAliasId()
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
    public String getCode()
    {
        return this.value.getCode();
    }

    @Override
    public void setCode(String code)
    {
        this.value.setCode(code);
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
        if (obj.getClass() == AttributeAliasIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        AttributeAliasIdDtoWrapper other = (AttributeAliasIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

