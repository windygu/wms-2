package org.dddml.wms.domain;


public class UserLoginStateEventIdDto
{

    public UserLoginStateEventIdDto()
    {
    }

    public UserLoginStateEventId toUserLoginStateEventId()
    {
        UserLoginStateEventId v = new UserLoginStateEventId();
        v.setUserId(this.getUserId());
        v.setLoginKey(this.getLoginKey().toLoginKey());
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

    private LoginKeyDto loginKey = new LoginKeyDto();

    public LoginKeyDto getLoginKey()
    {
        return this.loginKey;
    }

    public void setLoginKey(LoginKeyDto loginKey)
    {
        this.loginKey = loginKey;
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
        if (obj == null || obj.getClass() != UserLoginStateEventIdDto.class) {
            return false;
        }

        UserLoginStateEventIdDto other = (UserLoginStateEventIdDto)obj;
        return true 
            && (getUserId() == other.getUserId() || (getUserId() != null && getUserId().equals(other.getUserId())))
            && (getLoginKey() == other.getLoginKey() || (getLoginKey() != null && getLoginKey().equals(other.getLoginKey())))
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
        if (this.getLoginKey() != null) {
            hash += 13 * this.getLoginKey().hashCode();
        }
        if (this.getUserVersion() != null) {
            hash += 13 * this.getUserVersion().hashCode();
        }
        return hash;
    }

}

