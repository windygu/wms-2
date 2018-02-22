package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class PhysicalInventoryLineMvoFilteringProperties
{

    private PhysicalInventoryLineMvoFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "bookQuantity",
            "countedQuantity",
            "processed",
            "reversalLineNumber",
            "description",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "physicalInventoryDocumentStatusId",
            "physicalInventoryWarehouseId",
            "physicalInventoryLocatorIdPattern",
            "physicalInventoryProductIdPattern",
            "physicalInventoryPosted",
            "physicalInventoryProcessed",
            "physicalInventoryProcessing",
            "physicalInventoryDocumentTypeId",
            "physicalInventoryMovementDate",
            "physicalInventoryDescription",
            "physicalInventoryIsApproved",
            "physicalInventoryApprovalAmount",
            "physicalInventoryIsQuantityUpdated",
            "physicalInventoryReversalDocumentNumber",
            "physicalInventoryVersion",
            "physicalInventoryCreatedBy",
            "physicalInventoryCreatedAt",
            "physicalInventoryUpdatedBy",
            "physicalInventoryUpdatedAt",
            "physicalInventoryActive",
            "physicalInventoryLineId.physicalInventoryDocumentNumber",
            "physicalInventoryLineId.inventoryItemIdProductId",
            "physicalInventoryLineId.inventoryItemIdLocatorId",
            "physicalInventoryLineId.inventoryItemIdAttributeSetInstanceId",
    };

    public static final String[] propertyTypes = new String[] {
            "BigDecimal",
            "BigDecimal",
            "Boolean",
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
            "Boolean",
            "Boolean",
            "String",
            "String",
            "Date",
            "String",
            "Boolean",
            "BigDecimal",
            "Boolean",
            "String",
            "Long",
            "String",
            "Date",
            "String",
            "Date",
            "Boolean",
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
        aliasMap.put("physicalInventoryDocumentStatusId", "physicalInventoryDocumentStatusId");
        aliasMap.put("PhysicalInventoryDocumentStatusId", "physicalInventoryDocumentStatusId");
        aliasMap.put("physicalInventoryWarehouseId", "physicalInventoryWarehouseId");
        aliasMap.put("PhysicalInventoryWarehouseId", "physicalInventoryWarehouseId");
        aliasMap.put("physicalInventoryLocatorIdPattern", "physicalInventoryLocatorIdPattern");
        aliasMap.put("PhysicalInventoryLocatorIdPattern", "physicalInventoryLocatorIdPattern");
        aliasMap.put("physicalInventoryProductIdPattern", "physicalInventoryProductIdPattern");
        aliasMap.put("PhysicalInventoryProductIdPattern", "physicalInventoryProductIdPattern");
        aliasMap.put("physicalInventoryPosted", "physicalInventoryPosted");
        aliasMap.put("PhysicalInventoryPosted", "physicalInventoryPosted");
        aliasMap.put("physicalInventoryProcessed", "physicalInventoryProcessed");
        aliasMap.put("PhysicalInventoryProcessed", "physicalInventoryProcessed");
        aliasMap.put("physicalInventoryProcessing", "physicalInventoryProcessing");
        aliasMap.put("PhysicalInventoryProcessing", "physicalInventoryProcessing");
        aliasMap.put("physicalInventoryDocumentTypeId", "physicalInventoryDocumentTypeId");
        aliasMap.put("PhysicalInventoryDocumentTypeId", "physicalInventoryDocumentTypeId");
        aliasMap.put("physicalInventoryMovementDate", "physicalInventoryMovementDate");
        aliasMap.put("PhysicalInventoryMovementDate", "physicalInventoryMovementDate");
        aliasMap.put("physicalInventoryDescription", "physicalInventoryDescription");
        aliasMap.put("PhysicalInventoryDescription", "physicalInventoryDescription");
        aliasMap.put("physicalInventoryIsApproved", "physicalInventoryIsApproved");
        aliasMap.put("PhysicalInventoryIsApproved", "physicalInventoryIsApproved");
        aliasMap.put("physicalInventoryApprovalAmount", "physicalInventoryApprovalAmount");
        aliasMap.put("PhysicalInventoryApprovalAmount", "physicalInventoryApprovalAmount");
        aliasMap.put("physicalInventoryIsQuantityUpdated", "physicalInventoryIsQuantityUpdated");
        aliasMap.put("PhysicalInventoryIsQuantityUpdated", "physicalInventoryIsQuantityUpdated");
        aliasMap.put("physicalInventoryReversalDocumentNumber", "physicalInventoryReversalDocumentNumber");
        aliasMap.put("PhysicalInventoryReversalDocumentNumber", "physicalInventoryReversalDocumentNumber");
        aliasMap.put("physicalInventoryVersion", "physicalInventoryVersion");
        aliasMap.put("PhysicalInventoryVersion", "physicalInventoryVersion");
        aliasMap.put("physicalInventoryCreatedBy", "physicalInventoryCreatedBy");
        aliasMap.put("PhysicalInventoryCreatedBy", "physicalInventoryCreatedBy");
        aliasMap.put("physicalInventoryCreatedAt", "physicalInventoryCreatedAt");
        aliasMap.put("PhysicalInventoryCreatedAt", "physicalInventoryCreatedAt");
        aliasMap.put("physicalInventoryUpdatedBy", "physicalInventoryUpdatedBy");
        aliasMap.put("PhysicalInventoryUpdatedBy", "physicalInventoryUpdatedBy");
        aliasMap.put("physicalInventoryUpdatedAt", "physicalInventoryUpdatedAt");
        aliasMap.put("PhysicalInventoryUpdatedAt", "physicalInventoryUpdatedAt");
        aliasMap.put("physicalInventoryActive", "physicalInventoryActive");
        aliasMap.put("PhysicalInventoryActive", "physicalInventoryActive");
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

