package org.dddml.wms.domain;


public class RolePermissionIdDto
{

    public RolePermissionIdDto()
    {
    }

    public RolePermissionId toRolePermissionId()
    {
        RolePermissionId v = new RolePermissionId();
        v.setRoleId(this.getRoleId());
        v.setPermissionId(this.getPermissionId());
        return v;
    }

    private String roleId;

    public String getRoleId()
    {
        return this.roleId;
    }

    public void setRoleId(String roleId)
    {
        this.roleId = roleId;
    }

    private String permissionId;

    public String getPermissionId()
    {
        return this.permissionId;
    }

    public void setPermissionId(String permissionId)
    {
        this.permissionId = permissionId;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != RolePermissionIdDto.class) {
            return false;
        }

        RolePermissionIdDto other = (RolePermissionIdDto)obj;
        return true 
            && (getRoleId() == other.getRoleId() || (getRoleId() != null && getRoleId().equals(other.getRoleId())))
            && (getPermissionId() == other.getPermissionId() || (getPermissionId() != null && getPermissionId().equals(other.getPermissionId())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getRoleId() != null) {
            hash += 13 * this.getRoleId().hashCode();
        }
        if (this.getPermissionId() != null) {
            hash += 13 * this.getPermissionId().hashCode();
        }
        return hash;
    }

}

