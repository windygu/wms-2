package org.dddml.wms.domain;


public class UserRoleMvoStateEventIdDto
{

    public UserRoleMvoStateEventIdDto()
    {
    }

    public UserRoleMvoStateEventId toUserRoleMvoStateEventId()
    {
        UserRoleMvoStateEventId v = new UserRoleMvoStateEventId();
        v.setUserRoleId(this.getUserRoleId().toUserRoleId());
        v.setUserVersion(this.getUserVersion());
        return v;
    }

    private UserRoleIdDto userRoleId = new UserRoleIdDto();

    public UserRoleIdDto getUserRoleId()
    {
        return this.userRoleId;
    }

    public void setUserRoleId(UserRoleIdDto userRoleId)
    {
        this.userRoleId = userRoleId;
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
        if (obj == null || obj.getClass() != UserRoleMvoStateEventIdDto.class) {
            return false;
        }

        UserRoleMvoStateEventIdDto other = (UserRoleMvoStateEventIdDto)obj;
        return true 
            && (getUserRoleId() == other.getUserRoleId() || (getUserRoleId() != null && getUserRoleId().equals(other.getUserRoleId())))
            && (getUserVersion() == other.getUserVersion() || (getUserVersion() != null && getUserVersion().equals(other.getUserVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getUserRoleId() != null) {
            hash += 13 * this.getUserRoleId().hashCode();
        }
        if (this.getUserVersion() != null) {
            hash += 13 * this.getUserVersion().hashCode();
        }
        return hash;
    }

}

