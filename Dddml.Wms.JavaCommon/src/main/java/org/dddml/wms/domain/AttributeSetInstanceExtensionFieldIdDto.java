package org.dddml.wms.domain;

import org.dddml.wms.domain.*;

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
            && (getGroupId() == other.getGroupId() || (getGroupId() != null && getGroupId().equals(other.getGroupId())))
            && (getIndex() == other.getIndex() || (getIndex() != null && getIndex().equals(other.getIndex())))
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
        return hash;
    }

}

