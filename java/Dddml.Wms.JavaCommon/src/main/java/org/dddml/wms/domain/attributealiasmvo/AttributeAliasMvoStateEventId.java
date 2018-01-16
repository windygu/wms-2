package org.dddml.wms.domain.attributealiasmvo;

import java.io.Serializable;
import org.dddml.wms.domain.attribute.AttributeAliasId;
import org.dddml.wms.domain.attribute.*;
import org.dddml.wms.domain.*;

public class AttributeAliasMvoStateEventId implements Serializable
{
    private AttributeAliasId attributeAliasId = new AttributeAliasId();

    public AttributeAliasId getAttributeAliasId()
    {
        return this.attributeAliasId;
    }

    public void setAttributeAliasId(AttributeAliasId attributeAliasId)
    {
        this.attributeAliasId = attributeAliasId;
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

    public String getAttributeAliasIdAttributeId()
    {
        return getAttributeAliasId().getAttributeId();
    }

    public void setAttributeAliasIdAttributeId(String attributeAliasIdAttributeId)
    {
        getAttributeAliasId().setAttributeId(attributeAliasIdAttributeId);
    }

    public String getAttributeAliasIdCode()
    {
        return getAttributeAliasId().getCode();
    }

    public void setAttributeAliasIdCode(String attributeAliasIdCode)
    {
        getAttributeAliasId().setCode(attributeAliasIdCode);
    }

    public AttributeAliasMvoStateEventId()
    {
    }

    public AttributeAliasMvoStateEventId(AttributeAliasId attributeAliasId, Long attributeVersion)
    {
        this.attributeAliasId = attributeAliasId;
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

        AttributeAliasMvoStateEventId other = (AttributeAliasMvoStateEventId)obj;
        return true 
            && (attributeAliasId == other.attributeAliasId || (attributeAliasId != null && attributeAliasId.equals(other.attributeAliasId)))
            && (attributeVersion == other.attributeVersion || (attributeVersion != null && attributeVersion.equals(other.attributeVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.attributeAliasId != null) {
            hash += 13 * this.attributeAliasId.hashCode();
        }
        if (this.attributeVersion != null) {
            hash += 13 * this.attributeVersion.hashCode();
        }
        return hash;
    }

}

