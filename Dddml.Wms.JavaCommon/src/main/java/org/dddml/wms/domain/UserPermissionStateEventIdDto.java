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
            && (getUserId() == other.getUserId() || (getUserId() != null && getUserId().equals(other.getUserId())))
            && (getPermissionId() == other.getPermissionId() || (getPermissionId() != null && getPermissionId().equals(other.getPermissionId())))
            && (getUserVersion() == other.getUserVersion() || (getUserVersion() != null && getUserVersion().equals(other.getUserVersion())))
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
        if (this.getUserVersion() != null) {
            hash += 13 * this.getUserVersion().hashCode();
        }
        return hash;
    }

}

