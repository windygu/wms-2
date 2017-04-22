package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class AttributeSetInstanceExtensionFieldMvoFilteringProperties
{

    private AttributeSetInstanceExtensionFieldMvoFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "name",
            "type",
            "length",
            "alias",
            "description",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "attrSetInstEFGroupFieldType",
            "attrSetInstEFGroupFieldLength",
            "attrSetInstEFGroupFieldCount",
            "attrSetInstEFGroupNameFormat",
            "attrSetInstEFGroupDescription",
            "attrSetInstEFGroupVersion",
            "attrSetInstEFGroupCreatedBy",
            "attrSetInstEFGroupCreatedAt",
            "attrSetInstEFGroupUpdatedBy",
            "attrSetInstEFGroupUpdatedAt",
            "attrSetInstEFGroupActive",
            "attrSetInstEFGroupDeleted",
            "attributeSetInstanceExtensionFieldId.groupId",
            "attributeSetInstanceExtensionFieldId.index",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "String",
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
        aliasMap.put("type", "type");
        aliasMap.put("Type", "type");
        aliasMap.put("length", "length");
        aliasMap.put("Length", "length");
        aliasMap.put("alias", "alias");
        aliasMap.put("Alias", "alias");
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
        aliasMap.put("attrSetInstEFGroupFieldType", "attrSetInstEFGroupFieldType");
        aliasMap.put("AttrSetInstEFGroupFieldType", "attrSetInstEFGroupFieldType");
        aliasMap.put("attrSetInstEFGroupFieldLength", "attrSetInstEFGroupFieldLength");
        aliasMap.put("AttrSetInstEFGroupFieldLength", "attrSetInstEFGroupFieldLength");
        aliasMap.put("attrSetInstEFGroupFieldCount", "attrSetInstEFGroupFieldCount");
        aliasMap.put("AttrSetInstEFGroupFieldCount", "attrSetInstEFGroupFieldCount");
        aliasMap.put("attrSetInstEFGroupNameFormat", "attrSetInstEFGroupNameFormat");
        aliasMap.put("AttrSetInstEFGroupNameFormat", "attrSetInstEFGroupNameFormat");
        aliasMap.put("attrSetInstEFGroupDescription", "attrSetInstEFGroupDescription");
        aliasMap.put("AttrSetInstEFGroupDescription", "attrSetInstEFGroupDescription");
        aliasMap.put("attrSetInstEFGroupVersion", "attrSetInstEFGroupVersion");
        aliasMap.put("AttrSetInstEFGroupVersion", "attrSetInstEFGroupVersion");
        aliasMap.put("attrSetInstEFGroupCreatedBy", "attrSetInstEFGroupCreatedBy");
        aliasMap.put("AttrSetInstEFGroupCreatedBy", "attrSetInstEFGroupCreatedBy");
        aliasMap.put("attrSetInstEFGroupCreatedAt", "attrSetInstEFGroupCreatedAt");
        aliasMap.put("AttrSetInstEFGroupCreatedAt", "attrSetInstEFGroupCreatedAt");
        aliasMap.put("attrSetInstEFGroupUpdatedBy", "attrSetInstEFGroupUpdatedBy");
        aliasMap.put("AttrSetInstEFGroupUpdatedBy", "attrSetInstEFGroupUpdatedBy");
        aliasMap.put("attrSetInstEFGroupUpdatedAt", "attrSetInstEFGroupUpdatedAt");
        aliasMap.put("AttrSetInstEFGroupUpdatedAt", "attrSetInstEFGroupUpdatedAt");
        aliasMap.put("attrSetInstEFGroupActive", "attrSetInstEFGroupActive");
        aliasMap.put("AttrSetInstEFGroupActive", "attrSetInstEFGroupActive");
        aliasMap.put("attrSetInstEFGroupDeleted", "attrSetInstEFGroupDeleted");
        aliasMap.put("AttrSetInstEFGroupDeleted", "attrSetInstEFGroupDeleted");
        aliasMap.put("attributeSetInstanceExtensionFieldId.groupId", "attributeSetInstanceExtensionFieldId.groupId");
        aliasMap.put("AttributeSetInstanceExtensionFieldId.GroupId", "attributeSetInstanceExtensionFieldId.groupId");
        aliasMap.put("attributeSetInstanceExtensionFieldId.index", "attributeSetInstanceExtensionFieldId.index");
        aliasMap.put("AttributeSetInstanceExtensionFieldId.Index", "attributeSetInstanceExtensionFieldId.index");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

