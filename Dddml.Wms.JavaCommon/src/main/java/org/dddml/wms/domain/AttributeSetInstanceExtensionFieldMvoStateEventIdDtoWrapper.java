package org.dddml.wms.domain;


public class AttributeSetInstanceExtensionFieldMvoStateEventIdDtoWrapper extends AttributeSetInstanceExtensionFieldMvoStateEventIdDto
{
	
    private AttributeSetInstanceExtensionFieldMvoStateEventId value;

    public AttributeSetInstanceExtensionFieldMvoStateEventIdDtoWrapper()
    {
        this(new AttributeSetInstanceExtensionFieldMvoStateEventId());
    }

    public AttributeSetInstanceExtensionFieldMvoStateEventIdDtoWrapper(AttributeSetInstanceExtensionFieldMvoStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public AttributeSetInstanceExtensionFieldMvoStateEventId toAttributeSetInstanceExtensionFieldMvoStateEventId()
    {
        return this.value;
    }

    @Override
    public AttributeSetInstanceExtensionFieldIdDto getAttributeSetInstanceExtensionFieldId()
    {
        return new AttributeSetInstanceExtensionFieldIdDtoWrapper(this.value.getAttributeSetInstanceExtensionFieldId());
    }

    @Override
    public void setAttributeSetInstanceExtensionFieldId(AttributeSetInstanceExtensionFieldIdDto attributeSetInstanceExtensionFieldId)
    {
        this.value.setAttributeSetInstanceExtensionFieldId(attributeSetInstanceExtensionFieldId.toAttributeSetInstanceExtensionFieldId());
    }

    @Override
    public Long getAttrSetInstEFGroupVersion()
    {
        return this.value.getAttrSetInstEFGroupVersion();
    }

    @Override
    public void setAttrSetInstEFGroupVersion(Long attrSetInstEFGroupVersion)
    {
        this.value.setAttrSetInstEFGroupVersion(attrSetInstEFGroupVersion);
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == AttributeSetInstanceExtensionFieldMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        AttributeSetInstanceExtensionFieldMvoStateEventIdDtoWrapper other = (AttributeSetInstanceExtensionFieldMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

