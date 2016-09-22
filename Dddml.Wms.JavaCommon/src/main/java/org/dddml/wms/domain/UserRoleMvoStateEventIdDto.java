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
            && (userRoleId == other.userRoleId || (userRoleId != null && userRoleId.equals(other.userRoleId)))
            && (userVersion == other.userVersion || (userVersion != null && userVersion.equals(other.userVersion)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.userRoleId != null) {
            hash += 13 * this.userRoleId.hashCode();
        }
        if (this.userVersion != null) {
            hash += 13 * this.userVersion.hashCode();
        }
        return hash;
    }

}

