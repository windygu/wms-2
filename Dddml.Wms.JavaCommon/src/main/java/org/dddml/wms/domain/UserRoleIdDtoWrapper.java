package org.dddml.wms.domain;


public class UserRoleIdDtoWrapper extends UserRoleIdDto
{
	
    private UserRoleId value;

    public UserRoleIdDtoWrapper()
    {
        this(new UserRoleId());
    }

    public UserRoleIdDtoWrapper(UserRoleId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public UserRoleId toUserRoleId()
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
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == UserRoleIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        UserRoleIdDtoWrapper other = (UserRoleIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

