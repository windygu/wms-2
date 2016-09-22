package org.dddml.wms.domain;


public class UserStateEventIdDtoWrapper extends UserStateEventIdDto
{
	
    private UserStateEventId value;

    public UserStateEventIdDtoWrapper()
    {
        this(new UserStateEventId());
    }

    public UserStateEventIdDtoWrapper(UserStateEventId value)
    {
        this.value = value;
    }

    public UserStateEventId toUserStateEventId()
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
    public Long getVersion()
    {
        return this.value.getVersion();
    }

    @Override
    public void setVersion(Long version)
    {
        this.value.setVersion(version);
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
        if (obj.getClass() == UserStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        UserStateEventIdDtoWrapper other = (UserStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

