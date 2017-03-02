package org.dddml.wms.domain;

import org.dddml.wms.domain.*;

public class OrganizationStructureIdDtoWrapper extends OrganizationStructureIdDto
{
	
    private OrganizationStructureId value;

    public OrganizationStructureIdDtoWrapper()
    {
        this(new OrganizationStructureId());
    }

    public OrganizationStructureIdDtoWrapper(OrganizationStructureId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public OrganizationStructureId toOrganizationStructureId()
    {
        return this.value;
    }

    @Override
    public String getOrganizationStructureTypeId()
    {
        return this.value.getOrganizationStructureTypeId();
    }

    @Override
    public void setOrganizationStructureTypeId(String organizationStructureTypeId)
    {
        this.value.setOrganizationStructureTypeId(organizationStructureTypeId);
    }

    @Override
    public String getParentId()
    {
        return this.value.getParentId();
    }

    @Override
    public void setParentId(String parentId)
    {
        this.value.setParentId(parentId);
    }

    @Override
    public String getSubsidiaryId()
    {
        return this.value.getSubsidiaryId();
    }

    @Override
    public void setSubsidiaryId(String subsidiaryId)
    {
        this.value.setSubsidiaryId(subsidiaryId);
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
        if (obj.getClass() == OrganizationStructureIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        OrganizationStructureIdDtoWrapper other = (OrganizationStructureIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

