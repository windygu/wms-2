package org.dddml.wms.domain;

import org.dddml.wms.domain.*;

public class AttributeStateEventIdDto
{

    public AttributeStateEventIdDto()
    {
    }

    public AttributeStateEventId toAttributeStateEventId()
    {
        AttributeStateEventId v = new AttributeStateEventId();
        v.setAttributeId(this.getAttributeId());
        v.setVersion(this.getVersion());
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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != AttributeStateEventIdDto.class) {
            return false;
        }

        AttributeStateEventIdDto other = (AttributeStateEventIdDto)obj;
        return true 
            && (getAttributeId() == other.getAttributeId() || (getAttributeId() != null && getAttributeId().equals(other.getAttributeId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getAttributeId() != null) {
            hash += 13 * this.getAttributeId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

