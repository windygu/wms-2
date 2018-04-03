package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class PhysicalInventoryLineMetadata {

    private PhysicalInventoryLineMetadata() {
    }

    String PROPERTY_NAME_VERSION      = "version";
    String PROPERTY_NAME_ACTIVE       = "active";
    String PROPERTY_NAME_DELETED      = "deleted";
    String PROPERTY_NAME_CREATED_BY   = "createdBy";
    String PROPERTY_NAME_CREATED_AT   = "createdAt";
    String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "bookQuantity",
            "countedQuantity",
            "processed",
            "lineNumber",
            "reversalLineNumber",
            "description",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "physicalInventoryDocumentNumber",
            "inventoryItemId.productId",
            "inventoryItemId.locatorId",
            "inventoryItemId.attributeSetInstanceId",
            "physicalInventoryLineId.physicalInventoryDocumentNumber",
            "physicalInventoryLineId.inventoryItemIdProductId",
            "physicalInventoryLineId.inventoryItemIdLocatorId",
            "physicalInventoryLineId.inventoryItemIdAttributeSetInstanceId",
    };

    public static final String[] propertyTypes = new String[] {
            "BigDecimal",
            "BigDecimal",
            "Boolean",
            "String",
            "Long",
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
            "String",
            "String",
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
        aliasMap.put("bookQuantity", "bookQuantity");
        aliasMap.put("BookQuantity", "bookQuantity");
        aliasMap.put("countedQuantity", "countedQuantity");
        aliasMap.put("CountedQuantity", "countedQuantity");
        aliasMap.put("processed", "processed");
        aliasMap.put("Processed", "processed");
        aliasMap.put("lineNumber", "lineNumber");
        aliasMap.put("LineNumber", "lineNumber");
        aliasMap.put("reversalLineNumber", "reversalLineNumber");
        aliasMap.put("ReversalLineNumber", "reversalLineNumber");
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
        aliasMap.put("physicalInventoryDocumentNumber", "physicalInventoryLineId.physicalInventoryDocumentNumber");
        aliasMap.put("PhysicalInventoryDocumentNumber", "physicalInventoryLineId.physicalInventoryDocumentNumber");
        aliasMap.put("inventoryItemId.productId", "physicalInventoryLineId.inventoryItemIdProductId");
        aliasMap.put("InventoryItemId.ProductId", "physicalInventoryLineId.inventoryItemIdProductId");
        aliasMap.put("inventoryItemId.productId", "physicalInventoryLineId.inventoryItemIdProductId");
        aliasMap.put("InventoryItemId.ProductId", "physicalInventoryLineId.inventoryItemIdProductId");
        aliasMap.put("inventoryItemId.locatorId", "physicalInventoryLineId.inventoryItemIdLocatorId");
        aliasMap.put("InventoryItemId.LocatorId", "physicalInventoryLineId.inventoryItemIdLocatorId");
        aliasMap.put("inventoryItemId.locatorId", "physicalInventoryLineId.inventoryItemIdLocatorId");
        aliasMap.put("InventoryItemId.LocatorId", "physicalInventoryLineId.inventoryItemIdLocatorId");
        aliasMap.put("inventoryItemId.attributeSetInstanceId", "physicalInventoryLineId.inventoryItemIdAttributeSetInstanceId");
        aliasMap.put("InventoryItemId.AttributeSetInstanceId", "physicalInventoryLineId.inventoryItemIdAttributeSetInstanceId");
        aliasMap.put("inventoryItemId.attributeSetInstanceId", "physicalInventoryLineId.inventoryItemIdAttributeSetInstanceId");
        aliasMap.put("InventoryItemId.AttributeSetInstanceId", "physicalInventoryLineId.inventoryItemIdAttributeSetInstanceId");
        aliasMap.put("physicalInventoryLineId.physicalInventoryDocumentNumber", "physicalInventoryLineId.physicalInventoryDocumentNumber");
        aliasMap.put("PhysicalInventoryLineId.PhysicalInventoryDocumentNumber", "physicalInventoryLineId.physicalInventoryDocumentNumber");
        aliasMap.put("physicalInventoryLineId.inventoryItemIdProductId", "physicalInventoryLineId.inventoryItemIdProductId");
        aliasMap.put("PhysicalInventoryLineId.InventoryItemIdProductId", "physicalInventoryLineId.inventoryItemIdProductId");
        aliasMap.put("physicalInventoryLineId.inventoryItemId.productId", "physicalInventoryLineId.inventoryItemIdProductId");
        aliasMap.put("PhysicalInventoryLineId.InventoryItemId.ProductId", "physicalInventoryLineId.inventoryItemIdProductId");
        aliasMap.put("physicalInventoryLineId.inventoryItemIdLocatorId", "physicalInventoryLineId.inventoryItemIdLocatorId");
        aliasMap.put("PhysicalInventoryLineId.InventoryItemIdLocatorId", "physicalInventoryLineId.inventoryItemIdLocatorId");
        aliasMap.put("physicalInventoryLineId.inventoryItemId.locatorId", "physicalInventoryLineId.inventoryItemIdLocatorId");
        aliasMap.put("PhysicalInventoryLineId.InventoryItemId.LocatorId", "physicalInventoryLineId.inventoryItemIdLocatorId");
        aliasMap.put("physicalInventoryLineId.inventoryItemIdAttributeSetInstanceId", "physicalInventoryLineId.inventoryItemIdAttributeSetInstanceId");
        aliasMap.put("PhysicalInventoryLineId.InventoryItemIdAttributeSetInstanceId", "physicalInventoryLineId.inventoryItemIdAttributeSetInstanceId");
        aliasMap.put("physicalInventoryLineId.inventoryItemId.attributeSetInstanceId", "physicalInventoryLineId.inventoryItemIdAttributeSetInstanceId");
        aliasMap.put("PhysicalInventoryLineId.InventoryItemId.AttributeSetInstanceId", "physicalInventoryLineId.inventoryItemIdAttributeSetInstanceId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

