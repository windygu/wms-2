package org.dddml.wms.domain.attribute;

import org.dddml.wms.domain.*;

public class AttributeAliasStateEventIdDtoWrapper extends AttributeAliasStateEventIdDto
{
	
    private AttributeAliasStateEventId value;

    public AttributeAliasStateEventIdDtoWrapper()
    {
        this(new AttributeAliasStateEventId());
    }

    public AttributeAliasStateEventIdDtoWrapper(AttributeAliasStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public AttributeAliasStateEventId toAttributeAliasStateEventId()
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
        if (obj.getClass() == AttributeAliasStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        AttributeAliasStateEventIdDtoWrapper other = (AttributeAliasStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

