package org.dddml.wms.domain.attributeset;

import org.dddml.wms.domain.*;

public class AttributeSetStateEventIdDto
{

    public AttributeSetStateEventIdDto()
    {
    }

    public AttributeSetStateEventId toAttributeSetStateEventId()
    {
        AttributeSetStateEventId v = new AttributeSetStateEventId();
        v.setAttributeSetId(this.getAttributeSetId());
        v.setVersion(this.getVersion());
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
        if (obj == null || obj.getClass() != AttributeSetStateEventIdDto.class) {
            return false;
        }

        AttributeSetStateEventIdDto other = (AttributeSetStateEventIdDto)obj;
        return true 
            && (getAttributeSetId() == other.getAttributeSetId() || (getAttributeSetId() != null && getAttributeSetId().equals(other.getAttributeSetId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getAttributeSetId() != null) {
            hash += 13 * this.getAttributeSetId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

