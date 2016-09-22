package org.dddml.wms.domain;


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
            && (attributeSetInstanceId == other.attributeSetInstanceId || (attributeSetInstanceId != null && attributeSetInstanceId.equals(other.attributeSetInstanceId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.attributeSetInstanceId != null) {
            hash += 13 * this.attributeSetInstanceId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

