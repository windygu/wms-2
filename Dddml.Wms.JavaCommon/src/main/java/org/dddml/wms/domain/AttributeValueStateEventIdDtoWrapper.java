package org.dddml.wms.domain;


public class AttributeValueStateEventIdDtoWrapper extends AttributeValueStateEventIdDto
{
	
    private AttributeValueStateEventId value;

    public AttributeValueStateEventIdDtoWrapper()
    {
        this(new AttributeValueStateEventId());
    }

    public AttributeValueStateEventIdDtoWrapper(AttributeValueStateEventId value)
    {
        this.value = value;
    }

    public AttributeValueStateEventId toAttributeValueStateEventId()
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
    public String getValue()
    {
        return this.value.getValue();
    }

    @Override
    public void setValue(String value)
    {
        this.value.setValue(value);
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
        if (obj.getClass() == AttributeValueStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        AttributeValueStateEventIdDtoWrapper other = (AttributeValueStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

