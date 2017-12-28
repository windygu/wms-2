package org.dddml.wms.domain.attributealiasmvo;

import org.dddml.wms.domain.attribute.AttributeAliasIdDto;
import org.dddml.wms.domain.attribute.*;
import org.dddml.wms.domain.*;

public class AttributeAliasMvoStateEventIdDto
{

    public AttributeAliasMvoStateEventIdDto()
    {
    }

    public AttributeAliasMvoStateEventId toAttributeAliasMvoStateEventId()
    {
        AttributeAliasMvoStateEventId v = new AttributeAliasMvoStateEventId();
        v.setAttributeAliasId(this.getAttributeAliasId().toAttributeAliasId());
        v.setAttributeVersion(this.getAttributeVersion());
        return v;
    }

    private AttributeAliasIdDto attributeAliasId = new AttributeAliasIdDto();

    public AttributeAliasIdDto getAttributeAliasId()
    {
        return this.attributeAliasId;
    }

    public void setAttributeAliasId(AttributeAliasIdDto attributeAliasId)
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != AttributeAliasMvoStateEventIdDto.class) {
            return false;
        }

        AttributeAliasMvoStateEventIdDto other = (AttributeAliasMvoStateEventIdDto)obj;
        return true 
            && (getAttributeAliasId() == other.getAttributeAliasId() || (getAttributeAliasId() != null && getAttributeAliasId().equals(other.getAttributeAliasId())))
            && (getAttributeVersion() == other.getAttributeVersion() || (getAttributeVersion() != null && getAttributeVersion().equals(other.getAttributeVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getAttributeAliasId() != null) {
            hash += 13 * this.getAttributeAliasId().hashCode();
        }
        if (this.getAttributeVersion() != null) {
            hash += 13 * this.getAttributeVersion().hashCode();
        }
        return hash;
    }

}

