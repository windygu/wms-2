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
            && (userId == other.userId || (userId != null && userId.equals(other.userId)))
            && (permissionId == other.permissionId || (permissionId != null && permissionId.equals(other.permissionId)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.userId != null) {
            hash += 13 * this.userId.hashCode();
        }
        if (this.permissionId != null) {
            hash += 13 * this.permissionId.hashCode();
        }
        return hash;
    }

}

