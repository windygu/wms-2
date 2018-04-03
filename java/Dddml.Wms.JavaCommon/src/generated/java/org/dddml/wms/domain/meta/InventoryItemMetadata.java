package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class InventoryItemMetadata {

    private InventoryItemMetadata() {
    }

    String PROPERTY_NAME_VERSION      = "version";
    String PROPERTY_NAME_ACTIVE       = "active";
    String PROPERTY_NAME_DELETED      = "deleted";
    String PROPERTY_NAME_CREATED_BY   = "createdBy";
    String PROPERTY_NAME_CREATED_AT   = "createdAt";
    String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "onHandQuantity",
            "inTransitQuantity",
            "reservedQuantity",
            "occupiedQuantity",
            "virtualQuantity",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "inventoryItemId.productId",
            "inventoryItemId.locatorId",
            "inventoryItemId.attributeSetInstanceId",
    };

    public static final String[] propertyTypes = new String[] {
            "BigDecimal",
            "BigDecimal",
            "BigDecimal",
            "BigDecimal",
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
        aliasMap.put("onHandQuantity", "onHandQuantity");
        aliasMap.put("OnHandQuantity", "onHandQuantity");
        aliasMap.put("inTransitQuantity", "inTransitQuantity");
        aliasMap.put("InTransitQuantity", "inTransitQuantity");
        aliasMap.put("reservedQuantity", "reservedQuantity");
        aliasMap.put("ReservedQuantity", "reservedQuantity");
        aliasMap.put("occupiedQuantity", "occupiedQuantity");
        aliasMap.put("OccupiedQuantity", "occupiedQuantity");
        aliasMap.put("virtualQuantity", "virtualQuantity");
        aliasMap.put("VirtualQuantity", "virtualQuantity");
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
        aliasMap.put("inventoryItemId.productId", "inventoryItemId.productId");
        aliasMap.put("InventoryItemId.ProductId", "inventoryItemId.productId");
        aliasMap.put("inventoryItemId.locatorId", "inventoryItemId.locatorId");
        aliasMap.put("InventoryItemId.LocatorId", "inventoryItemId.locatorId");
        aliasMap.put("inventoryItemId.attributeSetInstanceId", "inventoryItemId.attributeSetInstanceId");
        aliasMap.put("InventoryItemId.AttributeSetInstanceId", "inventoryItemId.attributeSetInstanceId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

