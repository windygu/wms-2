package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class AttributeUseFilteringProperties {

    private AttributeUseFilteringProperties() {
    }

    public static final String[] propertyNames = new String[]{
            "attributeId",
            "sequenceNumber",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "attributeSetId",
            "attributeSetAttributeUseId.attributeSetId",
            "attributeSetAttributeUseId.attributeId",
    };

    public static final String[] propertyTypes = new String[]{
            "String",
            "Integer",
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

    private static void initAliasMap() {
        aliasMap.put("attributeId", "attributeSetAttributeUseId.attributeId");
        aliasMap.put("AttributeId", "attributeSetAttributeUseId.attributeId");
        aliasMap.put("sequenceNumber", "sequenceNumber");
        aliasMap.put("SequenceNumber", "sequenceNumber");
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
        aliasMap.put("attributeSetId", "attributeSetAttributeUseId.attributeSetId");
        aliasMap.put("AttributeSetId", "attributeSetAttributeUseId.attributeSetId");
        aliasMap.put("attributeSetAttributeUseId.attributeSetId", "attributeSetAttributeUseId.attributeSetId");
        aliasMap.put("AttributeSetAttributeUseId.AttributeSetId", "attributeSetAttributeUseId.attributeSetId");
        aliasMap.put("attributeSetAttributeUseId.attributeId", "attributeSetAttributeUseId.attributeId");
        aliasMap.put("AttributeSetAttributeUseId.AttributeId", "attributeSetAttributeUseId.attributeId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

