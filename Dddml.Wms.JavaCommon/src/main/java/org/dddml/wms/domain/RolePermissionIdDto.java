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
            && (roleId == other.roleId || (roleId != null && roleId.equals(other.roleId)))
            && (permissionId == other.permissionId || (permissionId != null && permissionId.equals(other.permissionId)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.roleId != null) {
            hash += 13 * this.roleId.hashCode();
        }
        if (this.permissionId != null) {
            hash += 13 * this.permissionId.hashCode();
        }
        return hash;
    }

}

