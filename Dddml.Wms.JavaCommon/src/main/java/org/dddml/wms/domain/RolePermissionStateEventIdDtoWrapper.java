package org.dddml.wms.domain;


public class RolePermissionStateEventIdDtoWrapper extends RolePermissionStateEventIdDto
{
	
    private RolePermissionStateEventId value;

    public RolePermissionStateEventIdDtoWrapper()
    {
        this(new RolePermissionStateEventId());
    }

    public RolePermissionStateEventIdDtoWrapper(RolePermissionStateEventId value)
    {
        this.value = value;
    }

    public RolePermissionStateEventId toRolePermissionStateEventId()
    {
        return this.value;
    }

    @Override
    public RolePermissionIdDto getId()
    {
        return new RolePermissionIdDtoWrapper(this.value.getId());
    }

    @Override
    public void setId(RolePermissionIdDto id)
    {
        this.value.setId(id.toRolePermissionId());
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
        if (obj.getClass() == RolePermissionStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        RolePermissionStateEventIdDtoWrapper other = (RolePermissionStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

