package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class InventoryItemEntryMvoFilteringProperties
{

    private InventoryItemEntryMvoFilteringProperties()
    {
    }

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
            "inventoryItemOnHandQuantity",
            "inventoryItemInTransitQuantity",
            "inventoryItemReservedQuantity",
            "inventoryItemOccupiedQuantity",
            "inventoryItemVirtualQuantity",
            "inventoryItemVersion",
            "inventoryItemCreatedBy",
            "inventoryItemCreatedAt",
            "inventoryItemUpdatedBy",
            "inventoryItemUpdatedAt",
            "inventoryItemEntryId.inventoryItemIdProductId",
            "inventoryItemEntryId.inventoryItemIdLocatorId",
            "inventoryItemEntryId.inventoryItemIdAttributeSetInstanceId",
            "inventoryItemEntryId.entrySeqId",
            "source.documentTypeId",
            "source.documentNumber",
            "source.lineNumber",
            "source.lineSubSeqId",
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
            "String",
            "String",
            "String",
            "Long",
            "String",
            "String",
            "String",
            "Integer",
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
        aliasMap.put("inventoryItemOnHandQuantity", "inventoryItemOnHandQuantity");
        aliasMap.put("InventoryItemOnHandQuantity", "inventoryItemOnHandQuantity");
        aliasMap.put("inventoryItemInTransitQuantity", "inventoryItemInTransitQuantity");
        aliasMap.put("InventoryItemInTransitQuantity", "inventoryItemInTransitQuantity");
        aliasMap.put("inventoryItemReservedQuantity", "inventoryItemReservedQuantity");
        aliasMap.put("InventoryItemReservedQuantity", "inventoryItemReservedQuantity");
        aliasMap.put("inventoryItemOccupiedQuantity", "inventoryItemOccupiedQuantity");
        aliasMap.put("InventoryItemOccupiedQuantity", "inventoryItemOccupiedQuantity");
        aliasMap.put("inventoryItemVirtualQuantity", "inventoryItemVirtualQuantity");
        aliasMap.put("InventoryItemVirtualQuantity", "inventoryItemVirtualQuantity");
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
        aliasMap.put("source.documentTypeId", "source.documentTypeId");
        aliasMap.put("Source.DocumentTypeId", "source.documentTypeId");
        aliasMap.put("source.documentNumber", "source.documentNumber");
        aliasMap.put("Source.DocumentNumber", "source.documentNumber");
        aliasMap.put("source.lineNumber", "source.lineNumber");
        aliasMap.put("Source.LineNumber", "source.lineNumber");
        aliasMap.put("source.lineSubSeqId", "source.lineSubSeqId");
        aliasMap.put("Source.LineSubSeqId", "source.lineSubSeqId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

