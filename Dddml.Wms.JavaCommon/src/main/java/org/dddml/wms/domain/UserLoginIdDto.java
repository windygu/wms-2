package org.dddml.wms.domain;


public class UserLoginIdDto
{

    public UserLoginIdDto()
    {
    }

    public UserLoginId toUserLoginId()
    {
        UserLoginId v = new UserLoginId();
        v.setUserId(this.getUserId());
        v.setLoginKey(this.getLoginKey().toLoginKey());
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != UserLoginIdDto.class) {
            return false;
        }

        UserLoginIdDto other = (UserLoginIdDto)obj;
        return true 
            && (userId == other.userId || (userId != null && userId.equals(other.userId)))
            && (loginKey == other.loginKey || (loginKey != null && loginKey.equals(other.loginKey)))
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
        return hash;
    }

}

