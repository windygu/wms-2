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
            && (getGroupId() == other.getGroupId() || (getGroupId() != null && getGroupId().equals(other.getGroupId())))
            && (getIndex() == other.getIndex() || (getIndex() != null && getIndex().equals(other.getIndex())))
            && (getAttributeSetInstanceExtensionFieldGroupVersion() == other.getAttributeSetInstanceExtensionFieldGroupVersion() || (getAttributeSetInstanceExtensionFieldGroupVersion() != null && getAttributeSetInstanceExtensionFieldGroupVersion().equals(other.getAttributeSetInstanceExtensionFieldGroupVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getGroupId() != null) {
            hash += 13 * this.getGroupId().hashCode();
        }
        if (this.getIndex() != null) {
            hash += 13 * this.getIndex().hashCode();
        }
        if (this.getAttributeSetInstanceExtensionFieldGroupVersion() != null) {
            hash += 13 * this.getAttributeSetInstanceExtensionFieldGroupVersion().hashCode();
        }
        return hash;
    }

}

