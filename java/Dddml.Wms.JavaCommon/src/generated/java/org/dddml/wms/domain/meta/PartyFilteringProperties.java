package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class PartyFilteringProperties
{

    private PartyFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "partyId",
            "partyTypeId",
            "primaryRoleTypeId",
            "organizationName",
            "description",
            "type",
            "isSummary",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "Boolean",
            "Long",
            "String",
            "Date",
            "String",
            "Date",
            "Boolean",
            "Boolean",
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
        aliasMap.put("partyId", "partyId");
        aliasMap.put("PartyId", "partyId");
        aliasMap.put("partyTypeId", "partyTypeId");
        aliasMap.put("PartyTypeId", "partyTypeId");
        aliasMap.put("primaryRoleTypeId", "primaryRoleTypeId");
        aliasMap.put("PrimaryRoleTypeId", "primaryRoleTypeId");
        aliasMap.put("organizationName", "organizationName");
        aliasMap.put("OrganizationName", "organizationName");
        aliasMap.put("description", "description");
        aliasMap.put("Description", "description");
        aliasMap.put("type", "type");
        aliasMap.put("Type", "type");
        aliasMap.put("isSummary", "isSummary");
        aliasMap.put("IsSummary", "isSummary");
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
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

