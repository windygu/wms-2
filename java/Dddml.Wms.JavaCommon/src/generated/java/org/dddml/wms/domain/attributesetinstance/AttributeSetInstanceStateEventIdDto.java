package org.dddml.wms.domain.attributesetinstance;

import org.dddml.wms.domain.*;

public class AttributeSetInstanceStateEventIdDto
{

    public AttributeSetInstanceStateEventIdDto()
    {
    }

    public AttributeSetInstanceStateEventId toAttributeSetInstanceStateEventId()
    {
        AttributeSetInstanceStateEventId v = new AttributeSetInstanceStateEventId();
        v.setAttributeSetInstanceId(this.getAttributeSetInstanceId());
        v.setVersion(this.getVersion());
        return v;
    }

    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
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
        if (obj == null || obj.getClass() != AttributeSetInstanceStateEventIdDto.class) {
            return false;
        }

        AttributeSetInstanceStateEventIdDto other = (AttributeSetInstanceStateEventIdDto)obj;
        return true 
            && (getAttributeSetInstanceId() == other.getAttributeSetInstanceId() || (getAttributeSetInstanceId() != null && getAttributeSetInstanceId().equals(other.getAttributeSetInstanceId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getAttributeSetInstanceId() != null) {
            hash += 13 * this.getAttributeSetInstanceId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

