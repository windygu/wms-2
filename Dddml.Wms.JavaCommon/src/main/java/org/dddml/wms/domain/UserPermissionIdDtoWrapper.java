package org.dddml.wms.domain;


public class UserPermissionIdDtoWrapper extends UserPermissionIdDto
{
	
    private UserPermissionId value;

    public UserPermissionIdDtoWrapper()
    {
        this(new UserPermissionId());
    }

    public UserPermissionIdDtoWrapper(UserPermissionId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public UserPermissionId toUserPermissionId()
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
    public String getPermissionId()
    {
        return this.value.getPermissionId();
    }

    @Override
    public void setPermissionId(String permissionId)
    {
        this.value.setPermissionId(permissionId);
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
        if (obj.getClass() == UserPermissionIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        UserPermissionIdDtoWrapper other = (UserPermissionIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

