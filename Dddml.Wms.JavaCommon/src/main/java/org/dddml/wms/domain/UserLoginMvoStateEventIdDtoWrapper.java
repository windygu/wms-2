package org.dddml.wms.domain;


public class UserLoginMvoStateEventIdDtoWrapper extends UserLoginMvoStateEventIdDto
{
	
    private UserLoginMvoStateEventId value;

    public UserLoginMvoStateEventIdDtoWrapper()
    {
        this(new UserLoginMvoStateEventId());
    }

    public UserLoginMvoStateEventIdDtoWrapper(UserLoginMvoStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public UserLoginMvoStateEventId toUserLoginMvoStateEventId()
    {
        return this.value;
    }

    @Override
    public UserLoginIdDto getUserLoginId()
    {
        return new UserLoginIdDtoWrapper(this.value.getUserLoginId());
    }

    @Override
    public void setUserLoginId(UserLoginIdDto userLoginId)
    {
        this.value.setUserLoginId(userLoginId.toUserLoginId());
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
        if (obj.getClass() == UserLoginMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        UserLoginMvoStateEventIdDtoWrapper other = (UserLoginMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

