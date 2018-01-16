package org.dddml.wms.domain.attribute;

import org.dddml.wms.domain.*;

public class AttributeAliasStateEventIdDto
{

    public AttributeAliasStateEventIdDto()
    {
    }

    public AttributeAliasStateEventId toAttributeAliasStateEventId()
    {
        AttributeAliasStateEventId v = new AttributeAliasStateEventId();
        v.setAttributeId(this.getAttributeId());
        v.setCode(this.getCode());
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

    private String code;

    public String getCode()
    {
        return this.code;
    }

    public void setCode(String code)
    {
        this.code = code;
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
        if (obj == null || obj.getClass() != AttributeAliasStateEventIdDto.class) {
            return false;
        }

        AttributeAliasStateEventIdDto other = (AttributeAliasStateEventIdDto)obj;
        return true 
            && (getAttributeId() == other.getAttributeId() || (getAttributeId() != null && getAttributeId().equals(other.getAttributeId())))
            && (getCode() == other.getCode() || (getCode() != null && getCode().equals(other.getCode())))
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
        if (this.getCode() != null) {
            hash += 13 * this.getCode().hashCode();
        }
        if (this.getAttributeVersion() != null) {
            hash += 13 * this.getAttributeVersion().hashCode();
        }
        return hash;
    }

}

