package org.dddml.wms.domain;


public class UserPermissionIdDto
{

    public UserPermissionIdDto()
    {
    }

    public UserPermissionId toUserPermissionId()
    {
        UserPermissionId v = new UserPermissionId();
        v.setUserId(this.getUserId());
        v.setPermissionId(this.getPermissionId());
        return v;
    }

    private String userId;

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    private String permissionId;

    public String getPermissionId()
    {
        return this.permissionId;
    }

    public void setPermissionId(String permissionId)
    {
        this.permissionId = permissionId;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != UserPermissionIdDto.class) {
            return false;
        }

        UserPermissionIdDto other = (UserPermissionIdDto)obj;
        return true 
            && (getUserId() == other.getUserId() || (getUserId() != null && getUserId().equals(other.getUserId())))
            && (getPermissionId() == other.getPermissionId() || (getPermissionId() != null && getPermissionId().equals(other.getPermissionId())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getUserId() != null) {
            hash += 13 * this.getUserId().hashCode();
        }
        if (this.getPermissionId() != null) {
            hash += 13 * this.getPermissionId().hashCode();
        }
        return hash;
    }

}

