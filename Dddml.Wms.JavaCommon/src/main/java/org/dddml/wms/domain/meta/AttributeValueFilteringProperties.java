package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class AttributeValueFilteringProperties
{

    private AttributeValueFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "value",
            "name",
            "description",
            "referenceId",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "attributeId",
            "attributeValueId.attributeId",
            "attributeValueId.value",
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
        aliasMap.put("value", "attributeValueId.value");
        aliasMap.put("Value", "attributeValueId.value");
        aliasMap.put("name", "name");
        aliasMap.put("Name", "name");
        aliasMap.put("description", "description");
        aliasMap.put("Description", "description");
        aliasMap.put("referenceId", "referenceId");
        aliasMap.put("ReferenceId", "referenceId");
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
        aliasMap.put("attributeId", "attributeValueId.attributeId");
        aliasMap.put("AttributeId", "attributeValueId.attributeId");
        aliasMap.put("attributeValueId.attributeId", "attributeValueId.attributeId");
        aliasMap.put("AttributeValueId.AttributeId", "attributeValueId.attributeId");
        aliasMap.put("attributeValueId.value", "attributeValueId.value");
        aliasMap.put("AttributeValueId.Value", "attributeValueId.value");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

