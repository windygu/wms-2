package org.dddml.wms.domain;


public class AttributeUseMvoStateEventIdDtoWrapper extends AttributeUseMvoStateEventIdDto
{
	
    private AttributeUseMvoStateEventId value;

    public AttributeUseMvoStateEventIdDtoWrapper()
    {
        this(new AttributeUseMvoStateEventId());
    }

    public AttributeUseMvoStateEventIdDtoWrapper(AttributeUseMvoStateEventId value)
    {
        this.value = value;
    }

    public AttributeUseMvoStateEventId toAttributeUseMvoStateEventId()
    {
        return this.value;
    }

    @Override
    public AttributeSetAttributeUseIdDto getAttributeSetAttributeUseId()
    {
        return new AttributeSetAttributeUseIdDtoWrapper(this.value.getAttributeSetAttributeUseId());
    }

    @Override
    public void setAttributeSetAttributeUseId(AttributeSetAttributeUseIdDto attributeSetAttributeUseId)
    {
        this.value.setAttributeSetAttributeUseId(attributeSetAttributeUseId.toAttributeSetAttributeUseId());
    }

    @Override
    public Long getAttributeSetVersion()
    {
        return this.value.getAttributeSetVersion();
    }

    @Override
    public void setAttributeSetVersion(Long attributeSetVersion)
    {
        this.value.setAttributeSetVersion(attributeSetVersion);
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
        if (obj.getClass() == AttributeUseMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        AttributeUseMvoStateEventIdDtoWrapper other = (AttributeUseMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

