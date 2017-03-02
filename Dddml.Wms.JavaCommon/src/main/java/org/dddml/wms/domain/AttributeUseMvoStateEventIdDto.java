package org.dddml.wms.domain;

import org.dddml.wms.domain.*;

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
            && (getAttributeSetAttributeUseId() == other.getAttributeSetAttributeUseId() || (getAttributeSetAttributeUseId() != null && getAttributeSetAttributeUseId().equals(other.getAttributeSetAttributeUseId())))
            && (getAttributeSetVersion() == other.getAttributeSetVersion() || (getAttributeSetVersion() != null && getAttributeSetVersion().equals(other.getAttributeSetVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getAttributeSetAttributeUseId() != null) {
            hash += 13 * this.getAttributeSetAttributeUseId().hashCode();
        }
        if (this.getAttributeSetVersion() != null) {
            hash += 13 * this.getAttributeSetVersion().hashCode();
        }
        return hash;
    }

}

