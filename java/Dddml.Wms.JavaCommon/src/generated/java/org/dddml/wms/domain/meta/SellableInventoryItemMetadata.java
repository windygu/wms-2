package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class SellableInventoryItemMetadata {

    private SellableInventoryItemMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "version";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "sellableQuantity",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "sellableInventoryItemId.productId",
            "sellableInventoryItemId.locatorId",
            "sellableInventoryItemId.attributeSetInstanceId",
    };

    public static final String[] propertyTypes = new String[] {
            "BigDecimal",
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
        aliasMap.put("sellableQuantity", "sellableQuantity");
        aliasMap.put("SellableQuantity", "sellableQuantity");
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
        aliasMap.put("sellableInventoryItemId.productId", "sellableInventoryItemId.productId");
        aliasMap.put("SellableInventoryItemId.ProductId", "sellableInventoryItemId.productId");
        aliasMap.put("sellableInventoryItemId.locatorId", "sellableInventoryItemId.locatorId");
        aliasMap.put("SellableInventoryItemId.LocatorId", "sellableInventoryItemId.locatorId");
        aliasMap.put("sellableInventoryItemId.attributeSetInstanceId", "sellableInventoryItemId.attributeSetInstanceId");
        aliasMap.put("SellableInventoryItemId.AttributeSetInstanceId", "sellableInventoryItemId.attributeSetInstanceId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

