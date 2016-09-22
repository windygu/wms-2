package org.dddml.wms.domain;


public class AttributeSetInstanceExtensionFieldStateEventIdDto
{

    public AttributeSetInstanceExtensionFieldStateEventIdDto()
    {
    }

    public AttributeSetInstanceExtensionFieldStateEventId toAttributeSetInstanceExtensionFieldStateEventId()
    {
        AttributeSetInstanceExtensionFieldStateEventId v = new AttributeSetInstanceExtensionFieldStateEventId();
        v.setGroupId(this.getGroupId());
        v.setIndex(this.getIndex());
        v.setAttributeSetInstanceExtensionFieldGroupVersion(this.getAttributeSetInstanceExtensionFieldGroupVersion());
        return v;
    }

    private String groupId;

    public String getGroupId()
    {
        return this.groupId;
    }

    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
    }

    private String index;

    public String getIndex()
    {
        return this.index;
    }

    public void setIndex(String index)
    {
        this.index = index;
    }

    private Long attributeSetInstanceExtensionFieldGroupVersion;

    public Long getAttributeSetInstanceExtensionFieldGroupVersion()
    {
        return this.attributeSetInstanceExtensionFieldGroupVersion;
    }

    public void setAttributeSetInstanceExtensionFieldGroupVersion(Long attributeSetInstanceExtensionFieldGroupVersion)
    {
        this.attributeSetInstanceExtensionFieldGroupVersion = attributeSetInstanceExtensionFieldGroupVersion;
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
            && (groupId == other.groupId || (groupId != null && groupId.equals(other.groupId)))
            && (index == other.index || (index != null && index.equals(other.index)))
            && (attributeSetInstanceExtensionFieldGroupVersion == other.attributeSetInstanceExtensionFieldGroupVersion || (attributeSetInstanceExtensionFieldGroupVersion != null && attributeSetInstanceExtensionFieldGroupVersion.equals(other.attributeSetInstanceExtensionFieldGroupVersion)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.groupId != null) {
            hash += 13 * this.groupId.hashCode();
        }
        if (this.index != null) {
            hash += 13 * this.index.hashCode();
        }
        if (this.attributeSetInstanceExtensionFieldGroupVersion != null) {
            hash += 13 * this.attributeSetInstanceExtensionFieldGroupVersion.hashCode();
        }
        return hash;
    }

}

