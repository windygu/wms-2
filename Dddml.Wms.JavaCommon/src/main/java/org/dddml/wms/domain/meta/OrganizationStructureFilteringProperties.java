package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class OrganizationStructureFilteringProperties
{

    private OrganizationStructureFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "id.organizationStructureTypeId",
            "id.parentId",
            "id.subsidiaryId",
    };

    public static final String[] propertyTypes = new String[] {
            "Long",
            "String",
            "Date",
            "String",
            "Date",
            "Boolean",
            "Boolean",
            "String",
            "String",
            "String",
    };

    public static final Map<String, String> propertyTypeMap;

    public static final Map<String, String> aliasMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        initPropertyTypeMap();
        aliasMap = new HashMap<String, String>();
        initAliasMap();
    }

    private static  void initAliasMap() {
        aliasMap.put("version", "version");
        aliasMap.put("Version", "version");
        aliasMap.put("createdBy", "createdBy");
        aliasMap.put("CreatedBy", "createdBy");
        aliasMap.put("createdAt", "createdAt");
        aliasMap.put("CreatedAt", "createdAt");
        aliasMap.put("updatedBy", "updatedBy");
        aliasMap.put("UpdatedBy", "updatedBy");
        aliasMap.put("updatedAt", "updatedAt");
        aliasMap.put("UpdatedAt", "updatedAt");
        aliasMap.put("active", "active");
        aliasMap.put("Active", "active");
        aliasMap.put("deleted", "deleted");
        aliasMap.put("Deleted", "deleted");
        aliasMap.put("id.organizationStructureTypeId", "id.organizationStructureTypeId");
        aliasMap.put("Id.OrganizationStructureTypeId", "id.organizationStructureTypeId");
        aliasMap.put("id.parentId", "id.parentId");
        aliasMap.put("Id.ParentId", "id.parentId");
        aliasMap.put("id.subsidiaryId", "id.subsidiaryId");
        aliasMap.put("Id.SubsidiaryId", "id.subsidiaryId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

