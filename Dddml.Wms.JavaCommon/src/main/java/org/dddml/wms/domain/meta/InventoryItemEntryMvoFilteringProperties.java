package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class InventoryItemEntryMvoFilteringProperties
{

    private InventoryItemEntryMvoFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "quantityOnHand",
            "quantityReserved",
            "quantityOccupied",
            "quantityVirtual",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "inventoryItemQuantityOnHand",
            "inventoryItemQuantityReserved",
            "inventoryItemQuantityOccupied",
            "inventoryItemQuantityVirtual",
            "inventoryItemVersion",
            "inventoryItemCreatedBy",
            "inventoryItemCreatedAt",
            "inventoryItemUpdatedBy",
            "inventoryItemUpdatedAt",
            "inventoryItemEntryId.inventoryItemIdProductId",
            "inventoryItemEntryId.inventoryItemIdLocatorId",
            "inventoryItemEntryId.inventoryItemIdAttributeSetInstanceId",
            "inventoryItemEntryId.entrySeqId",
            "source.inventoryItemEventTypeId",
            "source.documentNumber",
            "source.lineNumber",
    };

    public static final String[] propertyTypes = new String[] {
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
            "BigDecimal",
            "BigDecimal",
            "BigDecimal",
            "BigDecimal",
            "Long",
            "String",
            "Date",
            "String",
            "Date",
            "String",
            "String",
            "String",
            "Long",
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
        aliasMap.put("quantityOnHand", "quantityOnHand");
        aliasMap.put("QuantityOnHand", "quantityOnHand");
        aliasMap.put("quantityReserved", "quantityReserved");
        aliasMap.put("QuantityReserved", "quantityReserved");
        aliasMap.put("quantityOccupied", "quantityOccupied");
        aliasMap.put("QuantityOccupied", "quantityOccupied");
        aliasMap.put("quantityVirtual", "quantityVirtual");
        aliasMap.put("QuantityVirtual", "quantityVirtual");
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
        aliasMap.put("inventoryItemQuantityOnHand", "inventoryItemQuantityOnHand");
        aliasMap.put("InventoryItemQuantityOnHand", "inventoryItemQuantityOnHand");
        aliasMap.put("inventoryItemQuantityReserved", "inventoryItemQuantityReserved");
        aliasMap.put("InventoryItemQuantityReserved", "inventoryItemQuantityReserved");
        aliasMap.put("inventoryItemQuantityOccupied", "inventoryItemQuantityOccupied");
        aliasMap.put("InventoryItemQuantityOccupied", "inventoryItemQuantityOccupied");
        aliasMap.put("inventoryItemQuantityVirtual", "inventoryItemQuantityVirtual");
        aliasMap.put("InventoryItemQuantityVirtual", "inventoryItemQuantityVirtual");
        aliasMap.put("inventoryItemVersion", "inventoryItemVersion");
        aliasMap.put("InventoryItemVersion", "inventoryItemVersion");
        aliasMap.put("inventoryItemCreatedBy", "inventoryItemCreatedBy");
        aliasMap.put("InventoryItemCreatedBy", "inventoryItemCreatedBy");
        aliasMap.put("inventoryItemCreatedAt", "inventoryItemCreatedAt");
        aliasMap.put("InventoryItemCreatedAt", "inventoryItemCreatedAt");
        aliasMap.put("inventoryItemUpdatedBy", "inventoryItemUpdatedBy");
        aliasMap.put("InventoryItemUpdatedBy", "inventoryItemUpdatedBy");
        aliasMap.put("inventoryItemUpdatedAt", "inventoryItemUpdatedAt");
        aliasMap.put("InventoryItemUpdatedAt", "inventoryItemUpdatedAt");
        aliasMap.put("inventoryItemEntryId.inventoryItemIdProductId", "inventoryItemEntryId.inventoryItemIdProductId");
        aliasMap.put("InventoryItemEntryId.InventoryItemIdProductId", "inventoryItemEntryId.inventoryItemIdProductId");
        aliasMap.put("inventoryItemEntryId.inventoryItemId.productId", "inventoryItemEntryId.inventoryItemIdProductId");
        aliasMap.put("InventoryItemEntryId.InventoryItemId.ProductId", "inventoryItemEntryId.inventoryItemIdProductId");
        aliasMap.put("inventoryItemEntryId.inventoryItemIdLocatorId", "inventoryItemEntryId.inventoryItemIdLocatorId");
        aliasMap.put("InventoryItemEntryId.InventoryItemIdLocatorId", "inventoryItemEntryId.inventoryItemIdLocatorId");
        aliasMap.put("inventoryItemEntryId.inventoryItemId.locatorId", "inventoryItemEntryId.inventoryItemIdLocatorId");
        aliasMap.put("InventoryItemEntryId.InventoryItemId.LocatorId", "inventoryItemEntryId.inventoryItemIdLocatorId");
        aliasMap.put("inventoryItemEntryId.inventoryItemIdAttributeSetInstanceId", "inventoryItemEntryId.inventoryItemIdAttributeSetInstanceId");
        aliasMap.put("InventoryItemEntryId.InventoryItemIdAttributeSetInstanceId", "inventoryItemEntryId.inventoryItemIdAttributeSetInstanceId");
        aliasMap.put("inventoryItemEntryId.inventoryItemId.attributeSetInstanceId", "inventoryItemEntryId.inventoryItemIdAttributeSetInstanceId");
        aliasMap.put("InventoryItemEntryId.InventoryItemId.AttributeSetInstanceId", "inventoryItemEntryId.inventoryItemIdAttributeSetInstanceId");
        aliasMap.put("inventoryItemEntryId.entrySeqId", "inventoryItemEntryId.entrySeqId");
        aliasMap.put("InventoryItemEntryId.EntrySeqId", "inventoryItemEntryId.entrySeqId");
        aliasMap.put("source.inventoryItemEventTypeId", "source.inventoryItemEventTypeId");
        aliasMap.put("Source.InventoryItemEventTypeId", "source.inventoryItemEventTypeId");
        aliasMap.put("source.documentNumber", "source.documentNumber");
        aliasMap.put("Source.DocumentNumber", "source.documentNumber");
        aliasMap.put("source.lineNumber", "source.lineNumber");
        aliasMap.put("Source.LineNumber", "source.lineNumber");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

