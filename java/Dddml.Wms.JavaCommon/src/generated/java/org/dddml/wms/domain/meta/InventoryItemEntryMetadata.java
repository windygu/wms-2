package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class InventoryItemEntryMetadata {

    private InventoryItemEntryMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "version";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "entrySeqId",
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
            "source.documentTypeId",
            "source.documentNumber",
            "source.lineNumber",
            "source.lineSubSeqId",
            "inventoryItemEntryId.inventoryItemIdProductId",
            "inventoryItemEntryId.inventoryItemIdLocatorId",
            "inventoryItemEntryId.inventoryItemIdAttributeSetInstanceId",
            "inventoryItemEntryId.entrySeqId",
            "inventoryItemId.productId",
            "inventoryItemId.locatorId",
            "inventoryItemId.attributeSetInstanceId",
    };

    public static final String[] propertyTypes = new String[] {
            "Long",
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
            "Integer",
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
        aliasMap.put("entrySeqId", "inventoryItemEntryId.entrySeqId");
        aliasMap.put("EntrySeqId", "inventoryItemEntryId.entrySeqId");
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
        aliasMap.put("source.documentTypeId", "source.documentTypeId");
        aliasMap.put("Source.DocumentTypeId", "source.documentTypeId");
        aliasMap.put("source.documentNumber", "source.documentNumber");
        aliasMap.put("Source.DocumentNumber", "source.documentNumber");
        aliasMap.put("source.lineNumber", "source.lineNumber");
        aliasMap.put("Source.LineNumber", "source.lineNumber");
        aliasMap.put("source.lineSubSeqId", "source.lineSubSeqId");
        aliasMap.put("Source.LineSubSeqId", "source.lineSubSeqId");
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
        aliasMap.put("inventoryItemId.productId", "inventoryItemEntryId.inventoryItemIdProductId");
        aliasMap.put("InventoryItemId.ProductId", "inventoryItemEntryId.inventoryItemIdProductId");
        aliasMap.put("inventoryItemId.productId", "inventoryItemEntryId.inventoryItemIdProductId");
        aliasMap.put("InventoryItemId.ProductId", "inventoryItemEntryId.inventoryItemIdProductId");
        aliasMap.put("inventoryItemId.locatorId", "inventoryItemEntryId.inventoryItemIdLocatorId");
        aliasMap.put("InventoryItemId.LocatorId", "inventoryItemEntryId.inventoryItemIdLocatorId");
        aliasMap.put("inventoryItemId.locatorId", "inventoryItemEntryId.inventoryItemIdLocatorId");
        aliasMap.put("InventoryItemId.LocatorId", "inventoryItemEntryId.inventoryItemIdLocatorId");
        aliasMap.put("inventoryItemId.attributeSetInstanceId", "inventoryItemEntryId.inventoryItemIdAttributeSetInstanceId");
        aliasMap.put("InventoryItemId.AttributeSetInstanceId", "inventoryItemEntryId.inventoryItemIdAttributeSetInstanceId");
        aliasMap.put("inventoryItemId.attributeSetInstanceId", "inventoryItemEntryId.inventoryItemIdAttributeSetInstanceId");
        aliasMap.put("InventoryItemId.AttributeSetInstanceId", "inventoryItemEntryId.inventoryItemIdAttributeSetInstanceId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

