package org.dddml.wms.domain.attributesetinstanceextensionfield;

import org.dddml.wms.domain.*;

public class AttributeSetInstanceExtensionFieldStateEventIdDto
{

    public AttributeSetInstanceExtensionFieldStateEventIdDto()
    {
    }

    public AttributeSetInstanceExtensionFieldStateEventId toAttributeSetInstanceExtensionFieldStateEventId()
    {
        AttributeSetInstanceExtensionFieldStateEventId v = new AttributeSetInstanceExtensionFieldStateEventId();
        v.setName(this.getName());
        v.setVersion(this.getVersion());
        return v;
    }

    private String name;

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
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
        if (obj == null || obj.getClass() != AttributeSetInstanceExtensionFieldStateEventIdDto.class) {
            return false;
        }

        AttributeSetInstanceExtensionFieldStateEventIdDto other = (AttributeSetInstanceExtensionFieldStateEventIdDto)obj;
        return true 
            && (getName() == other.getName() || (getName() != null && getName().equals(other.getName())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getName() != null) {
            hash += 13 * this.getName().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

