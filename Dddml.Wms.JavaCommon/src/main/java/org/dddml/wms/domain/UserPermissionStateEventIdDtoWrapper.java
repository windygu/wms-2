package org.dddml.wms.domain;


public class UserPermissionStateEventIdDtoWrapper extends UserPermissionStateEventIdDto
{
	
    private UserPermissionStateEventId value;

    public UserPermissionStateEventIdDtoWrapper()
    {
        this(new UserPermissionStateEventId());
    }

    public UserPermissionStateEventIdDtoWrapper(UserPermissionStateEventId value)
    {
        this.value = value;
    }

    public UserPermissionStateEventId toUserPermissionStateEventId()
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
        if (obj.getClass() == UserPermissionStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        UserPermissionStateEventIdDtoWrapper other = (UserPermissionStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

    //@Override
    //public int hashCode()
    //{
    //    return value.hashCode();
    //}

}

