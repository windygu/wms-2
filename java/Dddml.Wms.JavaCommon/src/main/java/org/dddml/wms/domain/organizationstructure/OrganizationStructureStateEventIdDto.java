package org.dddml.wms.domain.organizationstructure;

import org.dddml.wms.domain.*;

public class OrganizationStructureStateEventIdDto
{

    public OrganizationStructureStateEventIdDto()
    {
    }

    public OrganizationStructureStateEventId toOrganizationStructureStateEventId()
    {
        OrganizationStructureStateEventId v = new OrganizationStructureStateEventId();
        v.setId(this.getId().toOrganizationStructureId());
        v.setVersion(this.getVersion());
        return v;
    }

    private OrganizationStructureIdDto id = new OrganizationStructureIdDto();

    public OrganizationStructureIdDto getId()
    {
        return this.id;
    }

    public void setId(OrganizationStructureIdDto id)
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
        if (obj == null || obj.getClass() != OrganizationStructureStateEventIdDto.class) {
            return false;
        }

        OrganizationStructureStateEventIdDto other = (OrganizationStructureStateEventIdDto)obj;
        return true 
            && (getId() == other.getId() || (getId() != null && getId().equals(other.getId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getId() != null) {
            hash += 13 * this.getId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

