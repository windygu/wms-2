package org.dddml.wms.domain.attribute;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class AttributeAliasId implements Serializable
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

    public AttributeAliasId()
    {
    }

    public AttributeAliasId(String attributeId, String code)
    {
        this.attributeId = attributeId;
        this.code = code;
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

        AttributeAliasId other = (AttributeAliasId)obj;
        return true 
            && (attributeId == other.attributeId || (attributeId != null && attributeId.equals(other.attributeId)))
            && (code == other.code || (code != null && code.equals(other.code)))
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
        return hash;
    }

}

