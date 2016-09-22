package org.dddml.wms.domain;


public class UserRoleStateEventIdDto
{

    public UserRoleStateEventIdDto()
    {
    }

    public UserRoleStateEventId toUserRoleStateEventId()
    {
        UserRoleStateEventId v = new UserRoleStateEventId();
        v.setUserId(this.getUserId());
        v.setRoleId(this.getRoleId());
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

    private String roleId;

    public String getRoleId()
    {
        return this.roleId;
    }

    public void setRoleId(String roleId)
    {
        this.roleId = roleId;
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
        if (obj == null || obj.getClass() != UserRoleStateEventIdDto.class) {
            return false;
        }

        UserRoleStateEventIdDto other = (UserRoleStateEventIdDto)obj;
        return true 
            && (userId == other.userId || (userId != null && userId.equals(other.userId)))
            && (roleId == other.roleId || (roleId != null && roleId.equals(other.roleId)))
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
        if (this.roleId != null) {
            hash += 13 * this.roleId.hashCode();
        }
        if (this.userVersion != null) {
            hash += 13 * this.userVersion.hashCode();
        }
        return hash;
    }

}

