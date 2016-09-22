package org.dddml.wms.domain;


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
            && (attributeSetInstanceExtensionFieldId == other.attributeSetInstanceExtensionFieldId || (attributeSetInstanceExtensionFieldId != null && attributeSetInstanceExtensionFieldId.equals(other.attributeSetInstanceExtensionFieldId)))
            && (attrSetInstEFGroupVersion == other.attrSetInstEFGroupVersion || (attrSetInstEFGroupVersion != null && attrSetInstEFGroupVersion.equals(other.attrSetInstEFGroupVersion)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.attributeSetInstanceExtensionFieldId != null) {
            hash += 13 * this.attributeSetInstanceExtensionFieldId.hashCode();
        }
        if (this.attrSetInstEFGroupVersion != null) {
            hash += 13 * this.attrSetInstEFGroupVersion.hashCode();
        }
        return hash;
    }

}

