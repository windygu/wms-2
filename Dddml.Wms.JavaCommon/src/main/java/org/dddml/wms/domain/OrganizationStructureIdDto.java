package org.dddml.wms.domain;


public class OrganizationStructureIdDto
{

    public OrganizationStructureIdDto()
    {
    }

    public OrganizationStructureId toOrganizationStructureId()
    {
        OrganizationStructureId v = new OrganizationStructureId();
        v.setOrganizationStructureTypeId(this.getOrganizationStructureTypeId());
        v.setParentId(this.getParentId());
        v.setSubsidiaryId(this.getSubsidiaryId());
        return v;
    }

    private String organizationStructureTypeId;

    public String getOrganizationStructureTypeId()
    {
        return this.organizationStructureTypeId;
    }

    public void setOrganizationStructureTypeId(String organizationStructureTypeId)
    {
        this.organizationStructureTypeId = organizationStructureTypeId;
    }

    private String parentId;

    public String getParentId()
    {
        return this.parentId;
    }

    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }

    private String subsidiaryId;

    public String getSubsidiaryId()
    {
        return this.subsidiaryId;
    }

    public void setSubsidiaryId(String subsidiaryId)
    {
        this.subsidiaryId = subsidiaryId;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != OrganizationStructureIdDto.class) {
            return false;
        }

        OrganizationStructureIdDto other = (OrganizationStructureIdDto)obj;
        return true 
            && (organizationStructureTypeId == other.organizationStructureTypeId || (organizationStructureTypeId != null && organizationStructureTypeId.equals(other.organizationStructureTypeId)))
            && (parentId == other.parentId || (parentId != null && parentId.equals(other.parentId)))
            && (subsidiaryId == other.subsidiaryId || (subsidiaryId != null && subsidiaryId.equals(other.subsidiaryId)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.organizationStructureTypeId != null) {
            hash += 13 * this.organizationStructureTypeId.hashCode();
        }
        if (this.parentId != null) {
            hash += 13 * this.parentId.hashCode();
        }
        if (this.subsidiaryId != null) {
            hash += 13 * this.subsidiaryId.hashCode();
        }
        return hash;
    }

}

