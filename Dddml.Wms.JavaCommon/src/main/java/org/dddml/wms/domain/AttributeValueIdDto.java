package org.dddml.wms.domain;


public class AttributeValueIdDto
{

    public AttributeValueIdDto()
    {
    }

    public AttributeValueId toAttributeValueId()
    {
        AttributeValueId v = new AttributeValueId();
        v.setAttributeId(this.getAttributeId());
        v.setValue(this.getValue());
        return v;
    }

    private String attributeId;

    public String getAttributeId()
    {
        return this.attributeId;
    }

    public void setAttributeId(String attributeId)
    {
        this.attributeId = attributeId;
    }

    private String value;

    public String getValue()
    {
        return this.value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != AttributeValueIdDto.class) {
            return false;
        }

        AttributeValueIdDto other = (AttributeValueIdDto)obj;
        return true 
            && (attributeId == other.attributeId || (attributeId != null && attributeId.equals(other.attributeId)))
            && (value == other.value || (value != null && value.equals(other.value)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.attributeId != null) {
            hash += 13 * this.attributeId.hashCode();
        }
        if (this.value != null) {
            hash += 13 * this.value.hashCode();
        }
        return hash;
    }

}

