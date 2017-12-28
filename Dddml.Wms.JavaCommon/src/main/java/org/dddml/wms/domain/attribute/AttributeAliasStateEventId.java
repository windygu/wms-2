package org.dddml.wms.domain.attribute;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class AttributeAliasStateEventId implements Serializable
{
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

    public AttributeAliasStateEventId()
    {
    }

    public AttributeAliasStateEventId(String attributeId, String code, Long attributeVersion)
    {
        this.attributeId = attributeId;
        this.code = code;
        this.attributeVersion = attributeVersion;
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

        AttributeAliasStateEventId other = (AttributeAliasStateEventId)obj;
        return true 
            && (attributeId == other.attributeId || (attributeId != null && attributeId.equals(other.attributeId)))
            && (code == other.code || (code != null && code.equals(other.code)))
            && (attributeVersion == other.attributeVersion || (attributeVersion != null && attributeVersion.equals(other.attributeVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.attributeId != null) {
            hash += 13 * this.attributeId.hashCode();
        }
        if (this.code != null) {
            hash += 13 * this.code.hashCode();
        }
        if (this.attributeVersion != null) {
            hash += 13 * this.attributeVersion.hashCode();
        }
        return hash;
    }

}

