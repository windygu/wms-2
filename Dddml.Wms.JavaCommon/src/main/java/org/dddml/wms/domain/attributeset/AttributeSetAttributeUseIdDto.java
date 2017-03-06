package org.dddml.wms.domain.attributeset;

import org.dddml.wms.domain.*;

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
            && (getAttributeSetId() == other.getAttributeSetId() || (getAttributeSetId() != null && getAttributeSetId().equals(other.getAttributeSetId())))
            && (getAttributeId() == other.getAttributeId() || (getAttributeId() != null && getAttributeId().equals(other.getAttributeId())))
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
        return hash;
    }

}

