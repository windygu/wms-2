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
            && (userId == other.userId || (userId != null && userId.equals(other.userId)))
            && (loginKey == other.loginKey || (loginKey != null && loginKey.equals(other.loginKey)))
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
        if (this.loginKey != null) {
            hash += 13 * this.loginKey.hashCode();
        }
        if (this.userVersion != null) {
            hash += 13 * this.userVersion.hashCode();
        }
        return hash;
    }

}

