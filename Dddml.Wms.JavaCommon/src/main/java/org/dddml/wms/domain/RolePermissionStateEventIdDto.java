package org.dddml.wms.domain;


public class RolePermissionStateEventIdDto
{

    public RolePermissionStateEventIdDto()
    {
    }

    public RolePermissionStateEventId toRolePermissionStateEventId()
    {
        RolePermissionStateEventId v = new RolePermissionStateEventId();
        v.setId(this.getId().toRolePermissionId());
        v.setVersion(this.getVersion());
        return v;
    }

    private RolePermissionIdDto id = new RolePermissionIdDto();

    public RolePermissionIdDto getId()
    {
        return this.id;
    }

    public void setId(RolePermissionIdDto id)
    {
        this.id = id;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != RolePermissionStateEventIdDto.class) {
            return false;
        }

        RolePermissionStateEventIdDto other = (RolePermissionStateEventIdDto)obj;
        return true 
            && (id == other.id || (id != null && id.equals(other.id)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.id != null) {
            hash += 13 * this.id.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

