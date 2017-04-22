package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class AttributeSetInstanceExtensionFieldGroupFilteringProperties
{

    private AttributeSetInstanceExtensionFieldGroupFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "id",
            "fieldType",
            "fieldLength",
            "fieldCount",
            "nameFormat",
            "description",
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
            "Integer",
            "Integer",
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
        aliasMap.put("id", "id");
        aliasMap.put("Id", "id");
        aliasMap.put("fieldType", "fieldType");
        aliasMap.put("FieldType", "fieldType");
        aliasMap.put("fieldLength", "fieldLength");
        aliasMap.put("FieldLength", "fieldLength");
        aliasMap.put("fieldCount", "fieldCount");
        aliasMap.put("FieldCount", "fieldCount");
        aliasMap.put("nameFormat", "nameFormat");
        aliasMap.put("NameFormat", "nameFormat");
        aliasMap.put("description", "description");
        aliasMap.put("Description", "description");
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

