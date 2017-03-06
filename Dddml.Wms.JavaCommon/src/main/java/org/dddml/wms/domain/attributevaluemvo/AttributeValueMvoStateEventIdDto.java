package org.dddml.wms.domain.attributevaluemvo;

import org.dddml.wms.domain.attribute.AttributeValueIdDto;
import org.dddml.wms.domain.attribute.*;
import org.dddml.wms.domain.*;

public class AttributeValueMvoStateEventIdDto
{

    public AttributeValueMvoStateEventIdDto()
    {
    }

    public AttributeValueMvoStateEventId toAttributeValueMvoStateEventId()
    {
        AttributeValueMvoStateEventId v = new AttributeValueMvoStateEventId();
        v.setAttributeValueId(this.getAttributeValueId().toAttributeValueId());
        v.setAttributeVersion(this.getAttributeVersion());
        return v;
    }

    private AttributeValueIdDto attributeValueId = new AttributeValueIdDto();

    public AttributeValueIdDto getAttributeValueId()
    {
        return this.attributeValueId;
    }

    public void setAttributeValueId(AttributeValueIdDto attributeValueId)
    {
        this.attributeValueId = attributeValueId;
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
        if (obj == null || obj.getClass() != AttributeValueMvoStateEventIdDto.class) {
            return false;
        }

        AttributeValueMvoStateEventIdDto other = (AttributeValueMvoStateEventIdDto)obj;
        return true 
            && (getAttributeValueId() == other.getAttributeValueId() || (getAttributeValueId() != null && getAttributeValueId().equals(other.getAttributeValueId())))
            && (getAttributeVersion() == other.getAttributeVersion() || (getAttributeVersion() != null && getAttributeVersion().equals(other.getAttributeVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getAttributeValueId() != null) {
            hash += 13 * this.getAttributeValueId().hashCode();
        }
        if (this.getAttributeVersion() != null) {
            hash += 13 * this.getAttributeVersion().hashCode();
        }
        return hash;
    }

}

