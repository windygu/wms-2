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
            && (getAttributeSetId() == other.getAttributeSetId() || (getAttributeSetId() != null && getAttributeSetId().equals(other.getAttributeSetId())))
            && (getAttributeId() == other.getAttributeId() || (getAttributeId() != null && getAttributeId().equals(other.getAttributeId())))
            && (getAttributeSetVersion() == other.getAttributeSetVersion() || (getAttributeSetVersion() != null && getAttributeSetVersion().equals(other.getAttributeSetVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getAttributeSetId() != null) {
            hash += 13 * this.getAttributeSetId().hashCode();
        }
        if (this.getAttributeId() != null) {
            hash += 13 * this.getAttributeId().hashCode();
        }
        if (this.getAttributeSetVersion() != null) {
            hash += 13 * this.getAttributeSetVersion().hashCode();
        }
        return hash;
    }

}

