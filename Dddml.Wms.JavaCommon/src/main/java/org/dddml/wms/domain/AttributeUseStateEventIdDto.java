package org.dddml.wms.domain;


public class AttributeUseStateEventIdDto
{

    public AttributeUseStateEventIdDto()
    {
    }

    public AttributeUseStateEventId toAttributeUseStateEventId()
    {
        AttributeUseStateEventId v = new AttributeUseStateEventId();
        v.setAttributeSetId(this.getAttributeSetId());
        v.setAttributeId(this.getAttributeId());
        v.setAttributeSetVersion(this.getAttributeSetVersion());
        return v;
    }

    private String attributeSetId;

    public String getAttributeSetId()
    {
        return this.attributeSetId;
    }

    public void setAttributeSetId(String attributeSetId)
    {
        this.attributeSetId = attributeSetId;
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
        if (obj == null || obj.getClass() != AttributeUseStateEventIdDto.class) {
            return false;
        }

        AttributeUseStateEventIdDto other = (AttributeUseStateEventIdDto)obj;
        return true 
            && (attributeSetId == other.attributeSetId || (attributeSetId != null && attributeSetId.equals(other.attributeSetId)))
            && (attributeId == other.attributeId || (attributeId != null && attributeId.equals(other.attributeId)))
            && (attributeSetVersion == other.attributeSetVersion || (attributeSetVersion != null && attributeSetVersion.equals(other.attributeSetVersion)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.attributeSetId != null) {
            hash += 13 * this.attributeSetId.hashCode();
        }
        if (this.attributeId != null) {
            hash += 13 * this.attributeId.hashCode();
        }
        if (this.attributeSetVersion != null) {
            hash += 13 * this.attributeSetVersion.hashCode();
        }
        return hash;
    }

}

