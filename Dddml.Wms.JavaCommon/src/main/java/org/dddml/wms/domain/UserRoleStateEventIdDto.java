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
            && (getUserId() == other.getUserId() || (getUserId() != null && getUserId().equals(other.getUserId())))
            && (getRoleId() == other.getRoleId() || (getRoleId() != null && getRoleId().equals(other.getRoleId())))
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
        if (this.getRoleId() != null) {
            hash += 13 * this.getRoleId().hashCode();
        }
        if (this.getUserVersion() != null) {
            hash += 13 * this.getUserVersion().hashCode();
        }
        return hash;
    }

}

