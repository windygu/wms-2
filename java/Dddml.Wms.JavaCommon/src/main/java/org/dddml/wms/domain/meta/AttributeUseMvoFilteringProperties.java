package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class AttributeUseMvoFilteringProperties
{

    private AttributeUseMvoFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "sequenceNumber",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "attributeSetAttributeSetName",
            "attributeSetOrganizationId",
            "attributeSetDescription",
            "attributeSetReferenceId",
            "attributeSetIsInstanceAttributeSet",
            "attributeSetIsMandatory",
            "attributeSetVersion",
            "attributeSetCreatedBy",
            "attributeSetCreatedAt",
            "attributeSetUpdatedBy",
            "attributeSetUpdatedAt",
            "attributeSetActive",
            "attributeSetDeleted",
            "attributeSetAttributeUseId.attributeSetId",
            "attributeSetAttributeUseId.attributeId",
    };

    public static final String[] propertyTypes = new String[] {
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
            "String",
            "Boolean",
            "Boolean",
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
        aliasMap.put("attributeSetAttributeSetName", "attributeSetAttributeSetName");
        aliasMap.put("AttributeSetAttributeSetName", "attributeSetAttributeSetName");
        aliasMap.put("attributeSetOrganizationId", "attributeSetOrganizationId");
        aliasMap.put("AttributeSetOrganizationId", "attributeSetOrganizationId");
        aliasMap.put("attributeSetDescription", "attributeSetDescription");
        aliasMap.put("AttributeSetDescription", "attributeSetDescription");
        aliasMap.put("attributeSetReferenceId", "attributeSetReferenceId");
        aliasMap.put("AttributeSetReferenceId", "attributeSetReferenceId");
        aliasMap.put("attributeSetIsInstanceAttributeSet", "attributeSetIsInstanceAttributeSet");
        aliasMap.put("AttributeSetIsInstanceAttributeSet", "attributeSetIsInstanceAttributeSet");
        aliasMap.put("attributeSetIsMandatory", "attributeSetIsMandatory");
        aliasMap.put("AttributeSetIsMandatory", "attributeSetIsMandatory");
        aliasMap.put("attributeSetVersion", "attributeSetVersion");
        aliasMap.put("AttributeSetVersion", "attributeSetVersion");
        aliasMap.put("attributeSetCreatedBy", "attributeSetCreatedBy");
        aliasMap.put("AttributeSetCreatedBy", "attributeSetCreatedBy");
        aliasMap.put("attributeSetCreatedAt", "attributeSetCreatedAt");
        aliasMap.put("AttributeSetCreatedAt", "attributeSetCreatedAt");
        aliasMap.put("attributeSetUpdatedBy", "attributeSetUpdatedBy");
        aliasMap.put("AttributeSetUpdatedBy", "attributeSetUpdatedBy");
        aliasMap.put("attributeSetUpdatedAt", "attributeSetUpdatedAt");
        aliasMap.put("AttributeSetUpdatedAt", "attributeSetUpdatedAt");
        aliasMap.put("attributeSetActive", "attributeSetActive");
        aliasMap.put("AttributeSetActive", "attributeSetActive");
        aliasMap.put("attributeSetDeleted", "attributeSetDeleted");
        aliasMap.put("AttributeSetDeleted", "attributeSetDeleted");
        aliasMap.put("attributeSetAttributeUseId.attributeSetId", "attributeSetAttributeUseId.attributeSetId");
        aliasMap.put("AttributeSetAttributeUseId.AttributeSetId", "attributeSetAttributeUseId.attributeSetId");
        aliasMap.put("attributeSetAttributeUseId.attributeId", "attributeSetAttributeUseId.attributeId");
        aliasMap.put("AttributeSetAttributeUseId.AttributeId", "attributeSetAttributeUseId.attributeId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

