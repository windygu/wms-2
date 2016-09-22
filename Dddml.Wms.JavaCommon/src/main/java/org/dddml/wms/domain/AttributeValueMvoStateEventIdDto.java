package org.dddml.wms.domain;


public class AttributeValueMvoStateEventIdDto
{

    public AttributeValueMvoStateEventIdDto()
    {
    }

    public AttributeValueMvoStateEventId toAttributeValueMvoStateEventId()
    {
        AttributeValueMvoStateEventId v = new AttributeValueMvoStateEventId();
        v.setAttributeValueId(this.getAttributeValueId().toAttributeValueId());
        v.setAttributeVersion(this.getAttributeVersion());
        return v;
    }

    private AttributeValueIdDto attributeValueId = new AttributeValueIdDto();

    public AttributeValueIdDto getAttributeValueId()
    {
        return this.attributeValueId;
    }

    public void setAttributeValueId(AttributeValueIdDto attributeValueId)
    {
        this.attributeValueId = attributeValueId;
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
        if (obj == null || obj.getClass() != AttributeValueMvoStateEventIdDto.class) {
            return false;
        }

        AttributeValueMvoStateEventIdDto other = (AttributeValueMvoStateEventIdDto)obj;
        return true 
            && (attributeValueId == other.attributeValueId || (attributeValueId != null && attributeValueId.equals(other.attributeValueId)))
            && (attributeVersion == other.attributeVersion || (attributeVersion != null && attributeVersion.equals(other.attributeVersion)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.attributeValueId != null) {
            hash += 13 * this.attributeValueId.hashCode();
        }
        if (this.attributeVersion != null) {
            hash += 13 * this.attributeVersion.hashCode();
        }
        return hash;
    }

}

