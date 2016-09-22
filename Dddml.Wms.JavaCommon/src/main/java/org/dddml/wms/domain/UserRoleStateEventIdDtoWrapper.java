package org.dddml.wms.domain;


public class UserRoleStateEventIdDtoWrapper extends UserRoleStateEventIdDto
{
	
    private UserRoleStateEventId value;

    public UserRoleStateEventIdDtoWrapper()
    {
        this(new UserRoleStateEventId());
    }

    public UserRoleStateEventIdDtoWrapper(UserRoleStateEventId value)
    {
        this.value = value;
    }

    public UserRoleStateEventId toUserRoleStateEventId()
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
    public String getRoleId()
    {
        return this.value.getRoleId();
    }

    @Override
    public void setRoleId(String roleId)
    {
        this.value.setRoleId(roleId);
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
        if (obj.getClass() == UserRoleStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        UserRoleStateEventIdDtoWrapper other = (UserRoleStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

