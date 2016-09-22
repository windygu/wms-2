package org.dddml.wms.domain;


public class OrganizationStructureTypeStateEventIdDto
{

    public OrganizationStructureTypeStateEventIdDto()
    {
    }

    public OrganizationStructureTypeStateEventId toOrganizationStructureTypeStateEventId()
    {
        OrganizationStructureTypeStateEventId v = new OrganizationStructureTypeStateEventId();
        v.setId(this.getId());
        v.setVersion(this.getVersion());
        return v;
    }

    private String id;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
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
        if (obj == null || obj.getClass() != OrganizationStructureTypeStateEventIdDto.class) {
            return false;
        }

        OrganizationStructureTypeStateEventIdDto other = (OrganizationStructureTypeStateEventIdDto)obj;
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

