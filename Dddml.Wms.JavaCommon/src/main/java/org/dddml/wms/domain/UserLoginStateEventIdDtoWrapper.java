package org.dddml.wms.domain;


public class UserLoginStateEventIdDtoWrapper extends UserLoginStateEventIdDto
{
	
    private UserLoginStateEventId value;

    public UserLoginStateEventIdDtoWrapper()
    {
        this(new UserLoginStateEventId());
    }

    public UserLoginStateEventIdDtoWrapper(UserLoginStateEventId value)
    {
        this.value = value;
    }

    public UserLoginStateEventId toUserLoginStateEventId()
    {
        return this.value;
    }

    @Override
    public String getUserId()
    {
        return this.value.getUserId();
    }

    @Override
    public void setUserId(String userId)
    {
        this.value.setUserId(userId);
    }

    @Override
    public LoginKeyDto getLoginKey()
    {
        return new LoginKeyDtoWrapper(this.value.getLoginKey());
    }

    @Override
    public void setLoginKey(LoginKeyDto loginKey)
    {
        this.value.setLoginKey(loginKey.toLoginKey());
    }

    @Override
    public Long getUserVersion()
    {
        return this.value.getUserVersion();
    }

    @Override
    public void setUserVersion(Long userVersion)
    {
        this.value.setUserVersion(userVersion);
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == UserLoginStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        UserLoginStateEventIdDtoWrapper other = (UserLoginStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

