package org.dddml.wms.domain;


public class RoleStateEventIdDtoWrapper extends RoleStateEventIdDto
{
	
    private RoleStateEventId value;

    public RoleStateEventIdDtoWrapper()
    {
        this(new RoleStateEventId());
    }

    public RoleStateEventIdDtoWrapper(RoleStateEventId value)
    {
        this.value = value;
    }

    public RoleStateEventId toRoleStateEventId()
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
        if (obj.getClass() == RoleStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        RoleStateEventIdDtoWrapper other = (RoleStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

    //@Override
    //public int hashCode()
    //{
    //    return value.hashCode();
    //}

}

