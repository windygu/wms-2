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
            && (attributeId == other.attributeId || (attributeId != null && attributeId.equals(other.attributeId)))
            && (value == other.value || (value != null && value.equals(other.value)))
            && (attributeVersion == other.attributeVersion || (attributeVersion != null && attributeVersion.equals(other.attributeVersion)))
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
        if (this.attributeVersion != null) {
            hash += 13 * this.attributeVersion.hashCode();
        }
        return hash;
    }

}

