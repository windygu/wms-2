package org.dddml.wms.domain;


public class AttributeUseStateEventIdDtoWrapper extends AttributeUseStateEventIdDto
{
	
    private AttributeUseStateEventId value;

    public AttributeUseStateEventIdDtoWrapper()
    {
        this(new AttributeUseStateEventId());
    }

    public AttributeUseStateEventIdDtoWrapper(AttributeUseStateEventId value)
    {
        this.value = value;
    }

    public AttributeUseStateEventId toAttributeUseStateEventId()
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
        if (obj.getClass() == AttributeUseStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        AttributeUseStateEventIdDtoWrapper other = (AttributeUseStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

