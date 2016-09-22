package org.dddml.wms.domain;


public class OrganizationStateEventIdDtoWrapper extends OrganizationStateEventIdDto
{
	
    private OrganizationStateEventId value;

    public OrganizationStateEventIdDtoWrapper()
    {
        this(new OrganizationStateEventId());
    }

    public OrganizationStateEventIdDtoWrapper(OrganizationStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public OrganizationStateEventId toOrganizationStateEventId()
    {
        return this.value;
    }

    @Override
    public String getOrganizationId()
    {
        return this.value.getOrganizationId();
    }

    @Override
    public void setOrganizationId(String organizationId)
    {
        this.value.setOrganizationId(organizationId);
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
        if (obj.getClass() == OrganizationStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        OrganizationStateEventIdDtoWrapper other = (OrganizationStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

