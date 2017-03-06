package org.dddml.wms.domain.attributesetinstanceextensionfieldmvo;

import org.dddml.wms.domain.attributesetinstanceextensionfieldgroup.AttributeSetInstanceExtensionFieldIdDto;
import org.dddml.wms.domain.attributesetinstanceextensionfieldgroup.*;
import org.dddml.wms.domain.*;

public class AttributeSetInstanceExtensionFieldMvoStateEventIdDto
{

    public AttributeSetInstanceExtensionFieldMvoStateEventIdDto()
    {
    }

    public AttributeSetInstanceExtensionFieldMvoStateEventId toAttributeSetInstanceExtensionFieldMvoStateEventId()
    {
        AttributeSetInstanceExtensionFieldMvoStateEventId v = new AttributeSetInstanceExtensionFieldMvoStateEventId();
        v.setAttributeSetInstanceExtensionFieldId(this.getAttributeSetInstanceExtensionFieldId().toAttributeSetInstanceExtensionFieldId());
        v.setAttrSetInstEFGroupVersion(this.getAttrSetInstEFGroupVersion());
        return v;
    }

    private AttributeSetInstanceExtensionFieldIdDto attributeSetInstanceExtensionFieldId = new AttributeSetInstanceExtensionFieldIdDto();

    public AttributeSetInstanceExtensionFieldIdDto getAttributeSetInstanceExtensionFieldId()
    {
        return this.attributeSetInstanceExtensionFieldId;
    }

    public void setAttributeSetInstanceExtensionFieldId(AttributeSetInstanceExtensionFieldIdDto attributeSetInstanceExtensionFieldId)
    {
        this.attributeSetInstanceExtensionFieldId = attributeSetInstanceExtensionFieldId;
    }

    private Long attrSetInstEFGroupVersion;

    public Long getAttrSetInstEFGroupVersion()
    {
        return this.attrSetInstEFGroupVersion;
    }

    public void setAttrSetInstEFGroupVersion(Long attrSetInstEFGroupVersion)
    {
        this.attrSetInstEFGroupVersion = attrSetInstEFGroupVersion;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != AttributeSetInstanceExtensionFieldMvoStateEventIdDto.class) {
            return false;
        }

        AttributeSetInstanceExtensionFieldMvoStateEventIdDto other = (AttributeSetInstanceExtensionFieldMvoStateEventIdDto)obj;
        return true 
            && (getAttributeSetInstanceExtensionFieldId() == other.getAttributeSetInstanceExtensionFieldId() || (getAttributeSetInstanceExtensionFieldId() != null && getAttributeSetInstanceExtensionFieldId().equals(other.getAttributeSetInstanceExtensionFieldId())))
            && (getAttrSetInstEFGroupVersion() == other.getAttrSetInstEFGroupVersion() || (getAttrSetInstEFGroupVersion() != null && getAttrSetInstEFGroupVersion().equals(other.getAttrSetInstEFGroupVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getAttributeSetInstanceExtensionFieldId() != null) {
            hash += 13 * this.getAttributeSetInstanceExtensionFieldId().hashCode();
        }
        if (this.getAttrSetInstEFGroupVersion() != null) {
            hash += 13 * this.getAttrSetInstEFGroupVersion().hashCode();
        }
        return hash;
    }

}

