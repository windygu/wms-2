package org.dddml.wms.domain;


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

