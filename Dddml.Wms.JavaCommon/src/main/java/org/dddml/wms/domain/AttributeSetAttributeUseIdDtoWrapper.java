package org.dddml.wms.domain;

import org.dddml.wms.domain.*;

public class AttributeSetAttributeUseIdDtoWrapper extends AttributeSetAttributeUseIdDto
{
	
    private AttributeSetAttributeUseId value;

    public AttributeSetAttributeUseIdDtoWrapper()
    {
        this(new AttributeSetAttributeUseId());
    }

    public AttributeSetAttributeUseIdDtoWrapper(AttributeSetAttributeUseId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public AttributeSetAttributeUseId toAttributeSetAttributeUseId()
    {
        return this.value;
    }

    @Override
    public String getAttributeSetId()
    {
        return this.value.getAttributeSetId();
    }

    @Override
    public void setAttributeSetId(String attributeSetId)
    {
        this.value.setAttributeSetId(attributeSetId);
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
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == AttributeSetAttributeUseIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        AttributeSetAttributeUseIdDtoWrapper other = (AttributeSetAttributeUseIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

