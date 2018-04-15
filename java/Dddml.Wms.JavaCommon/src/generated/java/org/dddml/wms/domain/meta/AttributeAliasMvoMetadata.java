package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class AttributeAliasMvoMetadata {

    private AttributeAliasMvoMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "attributeVersion";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "name",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "attributeAttributeName",
            "attributeOrganizationId",
            "attributeDescription",
            "attributeIsMandatory",
            "attributeAttributeValueType",
            "attributeAttributeValueLength",
            "attributeIsList",
            "attributeFieldName",
            "attributeReferenceId",
            "attributeVersion",
            "attributeCreatedBy",
            "attributeCreatedAt",
            "attributeUpdatedBy",
            "attributeUpdatedAt",
            "attributeActive",
            "attributeDeleted",
            "attributeAliasId.attributeId",
            "attributeAliasId.code",
    };

    public static final String[] propertyTypes = new String[] {
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
        aliasMap.put("name", "name");
        aliasMap.put("Name", "name");
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
        aliasMap.put("attributeAttributeName", "attributeAttributeName");
        aliasMap.put("AttributeAttributeName", "attributeAttributeName");
        aliasMap.put("attributeOrganizationId", "attributeOrganizationId");
        aliasMap.put("AttributeOrganizationId", "attributeOrganizationId");
        aliasMap.put("attributeDescription", "attributeDescription");
        aliasMap.put("AttributeDescription", "attributeDescription");
        aliasMap.put("attributeIsMandatory", "attributeIsMandatory");
        aliasMap.put("AttributeIsMandatory", "attributeIsMandatory");
        aliasMap.put("attributeAttributeValueType", "attributeAttributeValueType");
        aliasMap.put("AttributeAttributeValueType", "attributeAttributeValueType");
        aliasMap.put("attributeAttributeValueLength", "attributeAttributeValueLength");
        aliasMap.put("AttributeAttributeValueLength", "attributeAttributeValueLength");
        aliasMap.put("attributeIsList", "attributeIsList");
        aliasMap.put("AttributeIsList", "attributeIsList");
        aliasMap.put("attributeFieldName", "attributeFieldName");
        aliasMap.put("AttributeFieldName", "attributeFieldName");
        aliasMap.put("attributeReferenceId", "attributeReferenceId");
        aliasMap.put("AttributeReferenceId", "attributeReferenceId");
        aliasMap.put("attributeVersion", "attributeVersion");
        aliasMap.put("AttributeVersion", "attributeVersion");
        aliasMap.put("attributeCreatedBy", "attributeCreatedBy");
        aliasMap.put("AttributeCreatedBy", "attributeCreatedBy");
        aliasMap.put("attributeCreatedAt", "attributeCreatedAt");
        aliasMap.put("AttributeCreatedAt", "attributeCreatedAt");
        aliasMap.put("attributeUpdatedBy", "attributeUpdatedBy");
        aliasMap.put("AttributeUpdatedBy", "attributeUpdatedBy");
        aliasMap.put("attributeUpdatedAt", "attributeUpdatedAt");
        aliasMap.put("AttributeUpdatedAt", "attributeUpdatedAt");
        aliasMap.put("attributeActive", "attributeActive");
        aliasMap.put("AttributeActive", "attributeActive");
        aliasMap.put("attributeDeleted", "attributeDeleted");
        aliasMap.put("AttributeDeleted", "attributeDeleted");
        aliasMap.put("attributeAliasId.attributeId", "attributeAliasId.attributeId");
        aliasMap.put("AttributeAliasId.AttributeId", "attributeAliasId.attributeId");
        aliasMap.put("attributeAliasId.code", "attributeAliasId.code");
        aliasMap.put("AttributeAliasId.Code", "attributeAliasId.code");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

