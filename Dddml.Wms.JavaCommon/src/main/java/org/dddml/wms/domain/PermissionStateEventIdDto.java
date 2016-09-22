package org.dddml.wms.domain;


public class PermissionStateEventIdDto
{

    public PermissionStateEventIdDto()
    {
    }

    public PermissionStateEventId toPermissionStateEventId()
    {
        PermissionStateEventId v = new PermissionStateEventId();
        v.setPermissionId(this.getPermissionId());
        v.setVersion(this.getVersion());
        return v;
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
        if (obj == null || obj.getClass() != PermissionStateEventIdDto.class) {
            return false;
        }

        PermissionStateEventIdDto other = (PermissionStateEventIdDto)obj;
        return true 
            && (getPermissionId() == other.getPermissionId() || (getPermissionId() != null && getPermissionId().equals(other.getPermissionId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getPermissionId() != null) {
            hash += 13 * this.getPermissionId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

