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
            && (getUserLoginId() == other.getUserLoginId() || (getUserLoginId() != null && getUserLoginId().equals(other.getUserLoginId())))
            && (getUserVersion() == other.getUserVersion() || (getUserVersion() != null && getUserVersion().equals(other.getUserVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getUserLoginId() != null) {
            hash += 13 * this.getUserLoginId().hashCode();
        }
        if (this.getUserVersion() != null) {
            hash += 13 * this.getUserVersion().hashCode();
        }
        return hash;
    }

}

