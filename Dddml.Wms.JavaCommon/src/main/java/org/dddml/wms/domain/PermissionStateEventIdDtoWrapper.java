package org.dddml.wms.domain;


public class PermissionStateEventIdDtoWrapper extends PermissionStateEventIdDto
{
	
    private PermissionStateEventId value;

    public PermissionStateEventIdDtoWrapper()
    {
        this(new PermissionStateEventId());
    }

    public PermissionStateEventIdDtoWrapper(PermissionStateEventId value)
    {
        this.value = value;
    }

    public PermissionStateEventId toPermissionStateEventId()
    {
        return this.value;
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
        if (obj.getClass() == PermissionStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        PermissionStateEventIdDtoWrapper other = (PermissionStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

