package org.dddml.wms.domain;


public class UserLoginIdDtoWrapper extends UserLoginIdDto
{
	
    private UserLoginId value;

    public UserLoginIdDtoWrapper()
    {
        this(new UserLoginId());
    }

    public UserLoginIdDtoWrapper(UserLoginId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public UserLoginId toUserLoginId()
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
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == UserLoginIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        UserLoginIdDtoWrapper other = (UserLoginIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

