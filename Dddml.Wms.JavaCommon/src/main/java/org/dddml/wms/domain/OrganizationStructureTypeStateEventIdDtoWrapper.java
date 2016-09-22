package org.dddml.wms.domain;


public class OrganizationStructureTypeStateEventIdDtoWrapper extends OrganizationStructureTypeStateEventIdDto
{
	
    private OrganizationStructureTypeStateEventId value;

    public OrganizationStructureTypeStateEventIdDtoWrapper()
    {
        this(new OrganizationStructureTypeStateEventId());
    }

    public OrganizationStructureTypeStateEventIdDtoWrapper(OrganizationStructureTypeStateEventId value)
    {
        this.value = value;
    }

    public OrganizationStructureTypeStateEventId toOrganizationStructureTypeStateEventId()
    {
        return this.value;
    }

    @Override
    public String getId()
    {
        return this.value.getId();
    }

    @Override
    public void setId(String id)
    {
        this.value.setId(id);
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
        if (obj.getClass() == OrganizationStructureTypeStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        OrganizationStructureTypeStateEventIdDtoWrapper other = (OrganizationStructureTypeStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

