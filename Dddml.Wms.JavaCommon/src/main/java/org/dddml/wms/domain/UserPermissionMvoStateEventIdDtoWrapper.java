package org.dddml.wms.domain;


public class UserPermissionMvoStateEventIdDtoWrapper extends UserPermissionMvoStateEventIdDto
{
	
    private UserPermissionMvoStateEventId value;

    public UserPermissionMvoStateEventIdDtoWrapper()
    {
        this(new UserPermissionMvoStateEventId());
    }

    public UserPermissionMvoStateEventIdDtoWrapper(UserPermissionMvoStateEventId value)
    {
        this.value = value;
    }

    public UserPermissionMvoStateEventId toUserPermissionMvoStateEventId()
    {
        return this.value;
    }

    @Override
    public UserPermissionIdDto getUserPermissionId()
    {
        return new UserPermissionIdDtoWrapper(this.value.getUserPermissionId());
    }

    @Override
    public void setUserPermissionId(UserPermissionIdDto userPermissionId)
    {
        this.value.setUserPermissionId(userPermissionId.toUserPermissionId());
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
        if (obj.getClass() == UserPermissionMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        UserPermissionMvoStateEventIdDtoWrapper other = (UserPermissionMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

    //@Override
    //public int hashCode()
    //{
    //    return value.hashCode();
    //}

}

