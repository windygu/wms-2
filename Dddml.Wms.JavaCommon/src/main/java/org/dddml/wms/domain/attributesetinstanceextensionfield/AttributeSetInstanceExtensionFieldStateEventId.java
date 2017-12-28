package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class AttributeSetInstanceExtensionFieldStateEventId implements Serializable
{
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

    public AttributeSetInstanceExtensionFieldStateEventId()
    {
    }

    public AttributeSetInstanceExtensionFieldStateEventId(String name, Long version)
    {
        this.name = name;
        this.version = version;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        AttributeSetInstanceExtensionFieldStateEventId other = (AttributeSetInstanceExtensionFieldStateEventId)obj;
        return true 
            && (name == other.name || (name != null && name.equals(other.name)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.name != null) {
            hash += 13 * this.name.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

