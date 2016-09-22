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

