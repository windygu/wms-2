package org.dddml.wms.domain;


public class AttributeValueStateEventIdDto
{

    public AttributeValueStateEventIdDto()
    {
    }

    public AttributeValueStateEventId toAttributeValueStateEventId()
    {
        AttributeValueStateEventId v = new AttributeValueStateEventId();
        v.setAttributeId(this.getAttributeId());
        v.setValue(this.getValue());
        v.setAttributeVersion(this.getAttributeVersion());
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

    private Long attributeVersion;

    public Long getAttributeVersion()
    {
        return this.attributeVersion;
    }

    public void setAttributeVersion(Long attributeVersion)
    {
        this.attributeVersion = attributeVersion;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != AttributeValueStateEventIdDto.class) {
            return false;
        }

        AttributeValueStateEventIdDto other = (AttributeValueStateEventIdDto)obj;
        return true 
            && (getAttributeId() == other.getAttributeId() || (getAttributeId() != null && getAttributeId().equals(other.getAttributeId())))
            && (getValue() == other.getValue() || (getValue() != null && getValue().equals(other.getValue())))
            && (getAttributeVersion() == other.getAttributeVersion() || (getAttributeVersion() != null && getAttributeVersion().equals(other.getAttributeVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getAttributeId() != null) {
            hash += 13 * this.getAttributeId().hashCode();
        }
        if (this.getValue() != null) {
            hash += 13 * this.getValue().hashCode();
        }
        if (this.getAttributeVersion() != null) {
            hash += 13 * this.getAttributeVersion().hashCode();
        }
        return hash;
    }

}

