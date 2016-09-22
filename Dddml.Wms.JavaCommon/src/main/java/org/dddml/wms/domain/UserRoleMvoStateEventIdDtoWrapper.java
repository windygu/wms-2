package org.dddml.wms.domain;


public class UserRoleMvoStateEventIdDtoWrapper extends UserRoleMvoStateEventIdDto
{
	
    private UserRoleMvoStateEventId value;

    public UserRoleMvoStateEventIdDtoWrapper()
    {
        this(new UserRoleMvoStateEventId());
    }

    public UserRoleMvoStateEventIdDtoWrapper(UserRoleMvoStateEventId value)
    {
        this.value = value;
    }

    public UserRoleMvoStateEventId toUserRoleMvoStateEventId()
    {
        return this.value;
    }

    @Override
    public UserRoleIdDto getUserRoleId()
    {
        return new UserRoleIdDtoWrapper(this.value.getUserRoleId());
    }

    @Override
    public void setUserRoleId(UserRoleIdDto userRoleId)
    {
        this.value.setUserRoleId(userRoleId.toUserRoleId());
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
        if (obj.getClass() == UserRoleMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        UserRoleMvoStateEventIdDtoWrapper other = (UserRoleMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

