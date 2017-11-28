package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class InventoryItemEntryFilteringProperties
{

    private InventoryItemEntryFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "entrySeqId",
            "quantityOnHandVar",
            "quantityReservedVar",
            "quantityOccupiedVar",
            "quantityVirtualVar",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "eventVO.inventoryItemEventTypeId",
            "eventVO.documentNumber",
            "inventoryItemEntryId.inventoryItemIdProductId",
            "inventoryItemEntryId.inventoryItemIdLocatorId",
            "inventoryItemEntryId.inventoryItemIdAttributeSetInstance",
            "inventoryItemEntryId.entrySeqId",
            "inventoryItemId.productId",
            "inventoryItemId.locatorId",
            "inventoryItemId.attributeSetInstance",
    };

    public static final String[] propertyTypes = new String[] {
            "Long",
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
        aliasMap.put("quantityOnHandVar", "quantityOnHandVar");
        aliasMap.put("QuantityOnHandVar", "quantityOnHandVar");
        aliasMap.put("quantityReservedVar", "quantityReservedVar");
        aliasMap.put("QuantityReservedVar", "quantityReservedVar");
        aliasMap.put("quantityOccupiedVar", "quantityOccupiedVar");
        aliasMap.put("QuantityOccupiedVar", "quantityOccupiedVar");
        aliasMap.put("quantityVirtualVar", "quantityVirtualVar");
        aliasMap.put("QuantityVirtualVar", "quantityVirtualVar");
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
        aliasMap.put("eventVO.inventoryItemEventTypeId", "eventVO.inventoryItemEventTypeId");
        aliasMap.put("EventVO.InventoryItemEventTypeId", "eventVO.inventoryItemEventTypeId");
        aliasMap.put("eventVO.documentNumber", "eventVO.documentNumber");
        aliasMap.put("EventVO.DocumentNumber", "eventVO.documentNumber");
        aliasMap.put("inventoryItemEntryId.inventoryItemIdProductId", "inventoryItemEntryId.inventoryItemIdProductId");
        aliasMap.put("InventoryItemEntryId.InventoryItemIdProductId", "inventoryItemEntryId.inventoryItemIdProductId");
        aliasMap.put("inventoryItemEntryId.inventoryItemId.productId", "inventoryItemEntryId.inventoryItemIdProductId");
        aliasMap.put("InventoryItemEntryId.InventoryItemId.ProductId", "inventoryItemEntryId.inventoryItemIdProductId");
        aliasMap.put("inventoryItemEntryId.inventoryItemIdLocatorId", "inventoryItemEntryId.inventoryItemIdLocatorId");
        aliasMap.put("InventoryItemEntryId.InventoryItemIdLocatorId", "inventoryItemEntryId.inventoryItemIdLocatorId");
        aliasMap.put("inventoryItemEntryId.inventoryItemId.locatorId", "inventoryItemEntryId.inventoryItemIdLocatorId");
        aliasMap.put("InventoryItemEntryId.InventoryItemId.LocatorId", "inventoryItemEntryId.inventoryItemIdLocatorId");
        aliasMap.put("inventoryItemEntryId.inventoryItemIdAttributeSetInstance", "inventoryItemEntryId.inventoryItemIdAttributeSetInstance");
        aliasMap.put("InventoryItemEntryId.InventoryItemIdAttributeSetInstance", "inventoryItemEntryId.inventoryItemIdAttributeSetInstance");
        aliasMap.put("inventoryItemEntryId.inventoryItemId.attributeSetInstance", "inventoryItemEntryId.inventoryItemIdAttributeSetInstance");
        aliasMap.put("InventoryItemEntryId.InventoryItemId.AttributeSetInstance", "inventoryItemEntryId.inventoryItemIdAttributeSetInstance");
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
        aliasMap.put("inventoryItemId.attributeSetInstance", "inventoryItemEntryId.inventoryItemIdAttributeSetInstance");
        aliasMap.put("InventoryItemId.AttributeSetInstance", "inventoryItemEntryId.inventoryItemIdAttributeSetInstance");
        aliasMap.put("inventoryItemId.attributeSetInstance", "inventoryItemEntryId.inventoryItemIdAttributeSetInstance");
        aliasMap.put("InventoryItemId.AttributeSetInstance", "inventoryItemEntryId.inventoryItemIdAttributeSetInstance");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

