package org.dddml.wms.domain.attribute;

import org.dddml.wms.domain.*;

public class AttributeAliasIdDto
{

    public AttributeAliasIdDto()
    {
    }

    public AttributeAliasId toAttributeAliasId()
    {
        AttributeAliasId v = new AttributeAliasId();
        v.setAttributeId(this.getAttributeId());
        v.setCode(this.getCode());
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

    private String code;

    public String getCode()
    {
        return this.code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != AttributeAliasIdDto.class) {
            return false;
        }

        AttributeAliasIdDto other = (AttributeAliasIdDto)obj;
        return true 
            && (getAttributeId() == other.getAttributeId() || (getAttributeId() != null && getAttributeId().equals(other.getAttributeId())))
            && (getCode() == other.getCode() || (getCode() != null && getCode().equals(other.getCode())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getAttributeId() != null) {
            hash += 13 * this.getAttributeId().hashCode();
        }
        if (this.getCode() != null) {
            hash += 13 * this.getCode().hashCode();
        }
        return hash;
    }

}

