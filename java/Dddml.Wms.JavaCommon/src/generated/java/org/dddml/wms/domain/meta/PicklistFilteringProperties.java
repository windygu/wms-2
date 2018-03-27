package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class PicklistFilteringProperties
{

    private PicklistFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "picklistId",
            "description",
            "facilityId",
            "shipmentMethodTypeId",
            "statusId",
            "picklistDate",
            "createdByUserLogin",
            "lastModifiedByUserLogin",
            "version",
            "createdAt",
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
            "java.sql.Timestamp",
            "String",
            "String",
            "Long",
            "Date",
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
        aliasMap.put("picklistId", "picklistId");
        aliasMap.put("PicklistId", "picklistId");
        aliasMap.put("description", "description");
        aliasMap.put("Description", "description");
        aliasMap.put("facilityId", "facilityId");
        aliasMap.put("FacilityId", "facilityId");
        aliasMap.put("shipmentMethodTypeId", "shipmentMethodTypeId");
        aliasMap.put("ShipmentMethodTypeId", "shipmentMethodTypeId");
        aliasMap.put("statusId", "statusId");
        aliasMap.put("StatusId", "statusId");
        aliasMap.put("picklistDate", "picklistDate");
        aliasMap.put("PicklistDate", "picklistDate");
        aliasMap.put("createdByUserLogin", "createdByUserLogin");
        aliasMap.put("CreatedByUserLogin", "createdByUserLogin");
        aliasMap.put("lastModifiedByUserLogin", "lastModifiedByUserLogin");
        aliasMap.put("LastModifiedByUserLogin", "lastModifiedByUserLogin");
        aliasMap.put("version", "version");
        aliasMap.put("Version", "version");
        aliasMap.put("createdAt", "createdAt");
        aliasMap.put("CreatedAt", "createdAt");
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

