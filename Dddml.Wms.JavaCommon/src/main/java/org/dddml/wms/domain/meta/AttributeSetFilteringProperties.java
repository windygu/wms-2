package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class AttributeSetFilteringProperties
{

    private AttributeSetFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "attributeSetId",
            "attributeSetName",
            "organizationId",
            "description",
            "serialNumberAttributeId",
            "lotAttributeId",
            "referenceId",
            "isInstanceAttributeSet",
            "isMandatory",
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
        aliasMap.put("attributeSetId", "attributeSetId");
        aliasMap.put("AttributeSetId", "attributeSetId");
        aliasMap.put("attributeSetName", "attributeSetName");
        aliasMap.put("AttributeSetName", "attributeSetName");
        aliasMap.put("organizationId", "organizationId");
        aliasMap.put("OrganizationId", "organizationId");
        aliasMap.put("description", "description");
        aliasMap.put("Description", "description");
        aliasMap.put("serialNumberAttributeId", "serialNumberAttributeId");
        aliasMap.put("SerialNumberAttributeId", "serialNumberAttributeId");
        aliasMap.put("lotAttributeId", "lotAttributeId");
        aliasMap.put("LotAttributeId", "lotAttributeId");
        aliasMap.put("referenceId", "referenceId");
        aliasMap.put("ReferenceId", "referenceId");
        aliasMap.put("isInstanceAttributeSet", "isInstanceAttributeSet");
        aliasMap.put("IsInstanceAttributeSet", "isInstanceAttributeSet");
        aliasMap.put("isMandatory", "isMandatory");
        aliasMap.put("IsMandatory", "isMandatory");
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

