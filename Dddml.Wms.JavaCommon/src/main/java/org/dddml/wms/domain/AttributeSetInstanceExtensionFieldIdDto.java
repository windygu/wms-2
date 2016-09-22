package org.dddml.wms.domain;


public class AttributeSetInstanceExtensionFieldIdDto
{

    public AttributeSetInstanceExtensionFieldIdDto()
    {
    }

    public AttributeSetInstanceExtensionFieldId toAttributeSetInstanceExtensionFieldId()
    {
        AttributeSetInstanceExtensionFieldId v = new AttributeSetInstanceExtensionFieldId();
        v.setGroupId(this.getGroupId());
        v.setIndex(this.getIndex());
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != AttributeSetInstanceExtensionFieldIdDto.class) {
            return false;
        }

        AttributeSetInstanceExtensionFieldIdDto other = (AttributeSetInstanceExtensionFieldIdDto)obj;
        return true 
            && (groupId == other.groupId || (groupId != null && groupId.equals(other.groupId)))
            && (index == other.index || (index != null && index.equals(other.index)))
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
        return hash;
    }

}

