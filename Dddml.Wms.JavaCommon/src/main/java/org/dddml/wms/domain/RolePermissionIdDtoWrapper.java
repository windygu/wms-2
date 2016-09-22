package org.dddml.wms.domain;


public class RolePermissionIdDtoWrapper extends RolePermissionIdDto
{
	
    private RolePermissionId value;

    public RolePermissionIdDtoWrapper()
    {
        this(new RolePermissionId());
    }

    public RolePermissionIdDtoWrapper(RolePermissionId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public RolePermissionId toRolePermissionId()
    {
        return this.value;
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
        if (obj.getClass() == RolePermissionIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        RolePermissionIdDtoWrapper other = (RolePermissionIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

