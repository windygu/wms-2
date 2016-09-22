package org.dddml.wms.domain;


public class AttributeUseMvoStateEventIdDto
{

    public AttributeUseMvoStateEventIdDto()
    {
    }

    public AttributeUseMvoStateEventId toAttributeUseMvoStateEventId()
    {
        AttributeUseMvoStateEventId v = new AttributeUseMvoStateEventId();
        v.setAttributeSetAttributeUseId(this.getAttributeSetAttributeUseId().toAttributeSetAttributeUseId());
        v.setAttributeSetVersion(this.getAttributeSetVersion());
        return v;
    }

    private AttributeSetAttributeUseIdDto attributeSetAttributeUseId = new AttributeSetAttributeUseIdDto();

    public AttributeSetAttributeUseIdDto getAttributeSetAttributeUseId()
    {
        return this.attributeSetAttributeUseId;
    }

    public void setAttributeSetAttributeUseId(AttributeSetAttributeUseIdDto attributeSetAttributeUseId)
    {
        this.attributeSetAttributeUseId = attributeSetAttributeUseId;
    }

    private Long attributeSetVersion;

    public Long getAttributeSetVersion()
    {
        return this.attributeSetVersion;
    }

    public void setAttributeSetVersion(Long attributeSetVersion)
    {
        this.attributeSetVersion = attributeSetVersion;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != AttributeUseMvoStateEventIdDto.class) {
            return false;
        }

        AttributeUseMvoStateEventIdDto other = (AttributeUseMvoStateEventIdDto)obj;
        return true 
            && (attributeSetAttributeUseId == other.attributeSetAttributeUseId || (attributeSetAttributeUseId != null && attributeSetAttributeUseId.equals(other.attributeSetAttributeUseId)))
            && (attributeSetVersion == other.attributeSetVersion || (attributeSetVersion != null && attributeSetVersion.equals(other.attributeSetVersion)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.attributeSetAttributeUseId != null) {
            hash += 13 * this.attributeSetAttributeUseId.hashCode();
        }
        if (this.attributeSetVersion != null) {
            hash += 13 * this.attributeSetVersion.hashCode();
        }
        return hash;
    }

}

