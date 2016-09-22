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
            && (getUserId() == other.getUserId() || (getUserId() != null && getUserId().equals(other.getUserId())))
            && (getLoginKey() == other.getLoginKey() || (getLoginKey() != null && getLoginKey().equals(other.getLoginKey())))
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
        return hash;
    }

}

