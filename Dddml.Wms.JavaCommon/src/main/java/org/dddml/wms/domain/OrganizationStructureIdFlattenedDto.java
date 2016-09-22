package org.dddml.wms.domain;

import java.util.HashMap;
import java.util.Map;

public class OrganizationStructureIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "organizationStructureTypeId",
            "parentId",
            "subsidiaryId",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
            "String",
            "String",
        };

    public static final Map<String, String> propertyTypeMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }
	
    private OrganizationStructureIdDto value;

    public OrganizationStructureIdFlattenedDto()
    {
        this(new OrganizationStructureIdDto());
    }

    public OrganizationStructureIdFlattenedDto(OrganizationStructureIdDto value)
    {
        this.value = value;
    }

    public OrganizationStructureIdDto toOrganizationStructureIdDto()
    {
        return this.value;
    }

    public OrganizationStructureId toOrganizationStructureId()
    {
        return this.value.toOrganizationStructureId();
    }

    public String getOrganizationStructureTypeId()
    {
        return this.value.getOrganizationStructureTypeId();
    }

    public void setOrganizationStructureTypeId(String organizationStructureTypeId)
    {
        this.value.setOrganizationStructureTypeId(organizationStructureTypeId);
    }

    public String getParentId()
    {
        return this.value.getParentId();
    }

    public void setParentId(String parentId)
    {
        this.value.setParentId(parentId);
    }

    public String getSubsidiaryId()
    {
        return this.value.getSubsidiaryId();
    }

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
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        OrganizationStructureIdFlattenedDto other = (OrganizationStructureIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

