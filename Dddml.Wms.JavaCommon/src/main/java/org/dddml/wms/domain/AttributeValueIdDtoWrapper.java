package org.dddml.wms.domain;


public class AttributeValueIdDtoWrapper extends AttributeValueIdDto
{
	
    private AttributeValueId value;

    public AttributeValueIdDtoWrapper()
    {
        this(new AttributeValueId());
    }

    public AttributeValueIdDtoWrapper(AttributeValueId value)
    {
        this.value = value;
    }

    public AttributeValueId toAttributeValueId()
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
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == AttributeValueIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        AttributeValueIdDtoWrapper other = (AttributeValueIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

