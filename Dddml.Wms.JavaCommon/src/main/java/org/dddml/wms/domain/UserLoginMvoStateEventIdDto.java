package org.dddml.wms.domain;


public class UserLoginMvoStateEventIdDto
{

    public UserLoginMvoStateEventIdDto()
    {
    }

    public UserLoginMvoStateEventId toUserLoginMvoStateEventId()
    {
        UserLoginMvoStateEventId v = new UserLoginMvoStateEventId();
        v.setUserLoginId(this.getUserLoginId().toUserLoginId());
        v.setUserVersion(this.getUserVersion());
        return v;
    }

    private UserLoginIdDto userLoginId = new UserLoginIdDto();

    public UserLoginIdDto getUserLoginId()
    {
        return this.userLoginId;
    }

    public void setUserLoginId(UserLoginIdDto userLoginId)
    {
        this.userLoginId = userLoginId;
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
        if (obj == null || obj.getClass() != UserLoginMvoStateEventIdDto.class) {
            return false;
        }

        UserLoginMvoStateEventIdDto other = (UserLoginMvoStateEventIdDto)obj;
        return true 
            && (userLoginId == other.userLoginId || (userLoginId != null && userLoginId.equals(other.userLoginId)))
            && (userVersion == other.userVersion || (userVersion != null && userVersion.equals(other.userVersion)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.userLoginId != null) {
            hash += 13 * this.userLoginId.hashCode();
        }
        if (this.userVersion != null) {
            hash += 13 * this.userVersion.hashCode();
        }
        return hash;
    }

}

