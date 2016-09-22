package org.dddml.wms.domain;


public class RoleStateEventIdDto
{

    public RoleStateEventIdDto()
    {
    }

    public RoleStateEventId toRoleStateEventId()
    {
        RoleStateEventId v = new RoleStateEventId();
        v.setRoleId(this.getRoleId());
        v.setVersion(this.getVersion());
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
        if (obj == null || obj.getClass() != RoleStateEventIdDto.class) {
            return false;
        }

        RoleStateEventIdDto other = (RoleStateEventIdDto)obj;
        return true 
            && (getRoleId() == other.getRoleId() || (getRoleId() != null && getRoleId().equals(other.getRoleId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getRoleId() != null) {
            hash += 13 * this.getRoleId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

