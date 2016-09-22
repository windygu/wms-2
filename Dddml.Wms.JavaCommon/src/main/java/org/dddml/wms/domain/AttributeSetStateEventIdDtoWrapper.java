package org.dddml.wms.domain;


public class AttributeSetStateEventIdDtoWrapper extends AttributeSetStateEventIdDto
{
	
    private AttributeSetStateEventId value;

    public AttributeSetStateEventIdDtoWrapper()
    {
        this(new AttributeSetStateEventId());
    }

    public AttributeSetStateEventIdDtoWrapper(AttributeSetStateEventId value)
    {
        this.value = value;
    }

    public AttributeSetStateEventId toAttributeSetStateEventId()
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
        if (obj.getClass() == AttributeSetStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        AttributeSetStateEventIdDtoWrapper other = (AttributeSetStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

