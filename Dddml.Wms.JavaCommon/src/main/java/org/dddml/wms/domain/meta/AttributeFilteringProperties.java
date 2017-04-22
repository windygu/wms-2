package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class AttributeFilteringProperties
{

    private AttributeFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "attributeId",
            "name",
            "organizationId",
            "description",
            "isMandatory",
            "isInstanceAttribute",
            "attributeValueType",
            "attributeValueLength",
            "isList",
            "fieldName",
            "referenceId",
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
            "Boolean",
            "Boolean",
            "String",
            "Integer",
            "Boolean",
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
        aliasMap.put("attributeId", "attributeId");
        aliasMap.put("AttributeId", "attributeId");
        aliasMap.put("name", "name");
        aliasMap.put("Name", "name");
        aliasMap.put("organizationId", "organizationId");
        aliasMap.put("OrganizationId", "organizationId");
        aliasMap.put("description", "description");
        aliasMap.put("Description", "description");
        aliasMap.put("isMandatory", "isMandatory");
        aliasMap.put("IsMandatory", "isMandatory");
        aliasMap.put("isInstanceAttribute", "isInstanceAttribute");
        aliasMap.put("IsInstanceAttribute", "isInstanceAttribute");
        aliasMap.put("attributeValueType", "attributeValueType");
        aliasMap.put("AttributeValueType", "attributeValueType");
        aliasMap.put("attributeValueLength", "attributeValueLength");
        aliasMap.put("AttributeValueLength", "attributeValueLength");
        aliasMap.put("isList", "isList");
        aliasMap.put("IsList", "isList");
        aliasMap.put("fieldName", "fieldName");
        aliasMap.put("FieldName", "fieldName");
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
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

