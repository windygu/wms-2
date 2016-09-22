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
            && (getOrganizationStructureTypeId() == other.getOrganizationStructureTypeId() || (getOrganizationStructureTypeId() != null && getOrganizationStructureTypeId().equals(other.getOrganizationStructureTypeId())))
            && (getParentId() == other.getParentId() || (getParentId() != null && getParentId().equals(other.getParentId())))
            && (getSubsidiaryId() == other.getSubsidiaryId() || (getSubsidiaryId() != null && getSubsidiaryId().equals(other.getSubsidiaryId())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getOrganizationStructureTypeId() != null) {
            hash += 13 * this.getOrganizationStructureTypeId().hashCode();
        }
        if (this.getParentId() != null) {
            hash += 13 * this.getParentId().hashCode();
        }
        if (this.getSubsidiaryId() != null) {
            hash += 13 * this.getSubsidiaryId().hashCode();
        }
        return hash;
    }

}

