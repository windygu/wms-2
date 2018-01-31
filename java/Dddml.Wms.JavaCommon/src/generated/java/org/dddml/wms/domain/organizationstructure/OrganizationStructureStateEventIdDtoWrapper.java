package org.dddml.wms.domain.organizationstructure;

import org.dddml.wms.domain.*;

public class OrganizationStructureStateEventIdDtoWrapper extends OrganizationStructureStateEventIdDto
{
	
    private OrganizationStructureStateEventId value;

    public OrganizationStructureStateEventIdDtoWrapper()
    {
        this(new OrganizationStructureStateEventId());
    }

    public OrganizationStructureStateEventIdDtoWrapper(OrganizationStructureStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public OrganizationStructureStateEventId toOrganizationStructureStateEventId()
    {
        return this.value;
    }

    @Override
    public OrganizationStructureIdDto getId()
    {
        return new OrganizationStructureIdDtoWrapper(this.value.getId());
    }

    @Override
    public void setId(OrganizationStructureIdDto id)
    {
        this.value.setId(id.toOrganizationStructureId());
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
        if (obj.getClass() == OrganizationStructureStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        OrganizationStructureStateEventIdDtoWrapper other = (OrganizationStructureStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

