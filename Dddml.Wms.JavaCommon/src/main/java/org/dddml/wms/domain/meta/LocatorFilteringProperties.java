package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class LocatorFilteringProperties
{

    private LocatorFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "locatorId",
            "warehouseId",
            "parentLocatorId",
            "locatorType",
            "priorityNumber",
            "isDefault",
            "x",
            "y",
            "z",
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
            "Boolean",
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
        aliasMap.put("locatorId", "locatorId");
        aliasMap.put("LocatorId", "locatorId");
        aliasMap.put("warehouseId", "warehouseId");
        aliasMap.put("WarehouseId", "warehouseId");
        aliasMap.put("parentLocatorId", "parentLocatorId");
        aliasMap.put("ParentLocatorId", "parentLocatorId");
        aliasMap.put("locatorType", "locatorType");
        aliasMap.put("LocatorType", "locatorType");
        aliasMap.put("priorityNumber", "priorityNumber");
        aliasMap.put("PriorityNumber", "priorityNumber");
        aliasMap.put("isDefault", "isDefault");
        aliasMap.put("IsDefault", "isDefault");
        aliasMap.put("x", "x");
        aliasMap.put("X", "x");
        aliasMap.put("y", "y");
        aliasMap.put("Y", "y");
        aliasMap.put("z", "z");
        aliasMap.put("Z", "z");
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

