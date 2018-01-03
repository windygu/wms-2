package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class DamageTypeFilteringProperties
{

    private DamageTypeFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "damageTypeId",
            "description",
            "sequenceId",
            "defaultHandlingMethodId",
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
        aliasMap.put("damageTypeId", "damageTypeId");
        aliasMap.put("DamageTypeId", "damageTypeId");
        aliasMap.put("description", "description");
        aliasMap.put("Description", "description");
        aliasMap.put("sequenceId", "sequenceId");
        aliasMap.put("SequenceId", "sequenceId");
        aliasMap.put("defaultHandlingMethodId", "defaultHandlingMethodId");
        aliasMap.put("DefaultHandlingMethodId", "defaultHandlingMethodId");
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

