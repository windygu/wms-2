package org.dddml.wms.domain;


public class AttributeSetAttributeUseIdDto
{

    public AttributeSetAttributeUseIdDto()
    {
    }

    public AttributeSetAttributeUseId toAttributeSetAttributeUseId()
    {
        AttributeSetAttributeUseId v = new AttributeSetAttributeUseId();
        v.setAttributeSetId(this.getAttributeSetId());
        v.setAttributeId(this.getAttributeId());
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != AttributeSetAttributeUseIdDto.class) {
            return false;
        }

        AttributeSetAttributeUseIdDto other = (AttributeSetAttributeUseIdDto)obj;
        return true 
            && (attributeSetId == other.attributeSetId || (attributeSetId != null && attributeSetId.equals(other.attributeSetId)))
            && (attributeId == other.attributeId || (attributeId != null && attributeId.equals(other.attributeId)))
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
        return hash;
    }

}

