package org.dddml.wms.domain;


public class UserPermissionStateEventIdDto
{

    public UserPermissionStateEventIdDto()
    {
    }

    public UserPermissionStateEventId toUserPermissionStateEventId()
    {
        UserPermissionStateEventId v = new UserPermissionStateEventId();
        v.setUserId(this.getUserId());
        v.setPermissionId(this.getPermissionId());
        v.setUserVersion(this.getUserVersion());
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

    private Long userVersion;

    public Long getUserVersion()
    {
        return this.userVersion;
    }

    public void setUserVersion(Long userVersion)
    {
        this.userVersion = userVersion;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != UserPermissionStateEventIdDto.class) {
            return false;
        }

        UserPermissionStateEventIdDto other = (UserPermissionStateEventIdDto)obj;
        return true 
            && (userId == other.userId || (userId != null && userId.equals(other.userId)))
            && (permissionId == other.permissionId || (permissionId != null && permissionId.equals(other.permissionId)))
            && (userVersion == other.userVersion || (userVersion != null && userVersion.equals(other.userVersion)))
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
        if (this.userVersion != null) {
            hash += 13 * this.userVersion.hashCode();
        }
        return hash;
    }

}

