package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class SellableInventoryItemEntryMvoFilteringProperties
{

    private SellableInventoryItemEntryMvoFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "sellableQuantity",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "sellableInventoryItemSellableQuantity",
            "sellableInventoryItemVersion",
            "sellableInventoryItemCreatedBy",
            "sellableInventoryItemCreatedAt",
            "sellableInventoryItemUpdatedBy",
            "sellableInventoryItemUpdatedAt",
            "sellableInventoryItemEntryId.sellableInventoryItemIdProductId",
            "sellableInventoryItemEntryId.sellableInventoryItemIdLocatorId",
            "sellableInventoryItemEntryId.sellableInventoryItemIdAttributeSetInstanceId",
            "sellableInventoryItemEntryId.entrySeqId",
            "sourceEventId.sourceEntryIdInventoryItemIdProductId",
            "sourceEventId.sourceEntryIdInventoryItemIdLocatorId",
            "sourceEventId.sourceEntryIdInventoryItemIdAttributeSetInstanceId",
            "sourceEventId.sourceEntryIdEntrySeqId",
            "sourceEventId.inventoryPostingRuleId",
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
            "Long",
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
        aliasMap.put("sellableInventoryItemSellableQuantity", "sellableInventoryItemSellableQuantity");
        aliasMap.put("SellableInventoryItemSellableQuantity", "sellableInventoryItemSellableQuantity");
        aliasMap.put("sellableInventoryItemVersion", "sellableInventoryItemVersion");
        aliasMap.put("SellableInventoryItemVersion", "sellableInventoryItemVersion");
        aliasMap.put("sellableInventoryItemCreatedBy", "sellableInventoryItemCreatedBy");
        aliasMap.put("SellableInventoryItemCreatedBy", "sellableInventoryItemCreatedBy");
        aliasMap.put("sellableInventoryItemCreatedAt", "sellableInventoryItemCreatedAt");
        aliasMap.put("SellableInventoryItemCreatedAt", "sellableInventoryItemCreatedAt");
        aliasMap.put("sellableInventoryItemUpdatedBy", "sellableInventoryItemUpdatedBy");
        aliasMap.put("SellableInventoryItemUpdatedBy", "sellableInventoryItemUpdatedBy");
        aliasMap.put("sellableInventoryItemUpdatedAt", "sellableInventoryItemUpdatedAt");
        aliasMap.put("SellableInventoryItemUpdatedAt", "sellableInventoryItemUpdatedAt");
        aliasMap.put("sellableInventoryItemEntryId.sellableInventoryItemIdProductId", "sellableInventoryItemEntryId.sellableInventoryItemIdProductId");
        aliasMap.put("SellableInventoryItemEntryId.SellableInventoryItemIdProductId", "sellableInventoryItemEntryId.sellableInventoryItemIdProductId");
        aliasMap.put("sellableInventoryItemEntryId.sellableInventoryItemId.productId", "sellableInventoryItemEntryId.sellableInventoryItemIdProductId");
        aliasMap.put("SellableInventoryItemEntryId.SellableInventoryItemId.ProductId", "sellableInventoryItemEntryId.sellableInventoryItemIdProductId");
        aliasMap.put("sellableInventoryItemEntryId.sellableInventoryItemIdLocatorId", "sellableInventoryItemEntryId.sellableInventoryItemIdLocatorId");
        aliasMap.put("SellableInventoryItemEntryId.SellableInventoryItemIdLocatorId", "sellableInventoryItemEntryId.sellableInventoryItemIdLocatorId");
        aliasMap.put("sellableInventoryItemEntryId.sellableInventoryItemId.locatorId", "sellableInventoryItemEntryId.sellableInventoryItemIdLocatorId");
        aliasMap.put("SellableInventoryItemEntryId.SellableInventoryItemId.LocatorId", "sellableInventoryItemEntryId.sellableInventoryItemIdLocatorId");
        aliasMap.put("sellableInventoryItemEntryId.sellableInventoryItemIdAttributeSetInstanceId", "sellableInventoryItemEntryId.sellableInventoryItemIdAttributeSetInstanceId");
        aliasMap.put("SellableInventoryItemEntryId.SellableInventoryItemIdAttributeSetInstanceId", "sellableInventoryItemEntryId.sellableInventoryItemIdAttributeSetInstanceId");
        aliasMap.put("sellableInventoryItemEntryId.sellableInventoryItemId.attributeSetInstanceId", "sellableInventoryItemEntryId.sellableInventoryItemIdAttributeSetInstanceId");
        aliasMap.put("SellableInventoryItemEntryId.SellableInventoryItemId.AttributeSetInstanceId", "sellableInventoryItemEntryId.sellableInventoryItemIdAttributeSetInstanceId");
        aliasMap.put("sellableInventoryItemEntryId.entrySeqId", "sellableInventoryItemEntryId.entrySeqId");
        aliasMap.put("SellableInventoryItemEntryId.EntrySeqId", "sellableInventoryItemEntryId.entrySeqId");
        aliasMap.put("sourceEventId.sourceEntryIdInventoryItemIdProductId", "sourceEventId.sourceEntryIdInventoryItemIdProductId");
        aliasMap.put("SourceEventId.SourceEntryIdInventoryItemIdProductId", "sourceEventId.sourceEntryIdInventoryItemIdProductId");
        aliasMap.put("sourceEventId.sourceEntryId.inventoryItemId.productId", "sourceEventId.sourceEntryIdInventoryItemIdProductId");
        aliasMap.put("SourceEventId.SourceEntryId.InventoryItemId.ProductId", "sourceEventId.sourceEntryIdInventoryItemIdProductId");
        aliasMap.put("sourceEventId.sourceEntryIdInventoryItemIdLocatorId", "sourceEventId.sourceEntryIdInventoryItemIdLocatorId");
        aliasMap.put("SourceEventId.SourceEntryIdInventoryItemIdLocatorId", "sourceEventId.sourceEntryIdInventoryItemIdLocatorId");
        aliasMap.put("sourceEventId.sourceEntryId.inventoryItemId.locatorId", "sourceEventId.sourceEntryIdInventoryItemIdLocatorId");
        aliasMap.put("SourceEventId.SourceEntryId.InventoryItemId.LocatorId", "sourceEventId.sourceEntryIdInventoryItemIdLocatorId");
        aliasMap.put("sourceEventId.sourceEntryIdInventoryItemIdAttributeSetInstanceId", "sourceEventId.sourceEntryIdInventoryItemIdAttributeSetInstanceId");
        aliasMap.put("SourceEventId.SourceEntryIdInventoryItemIdAttributeSetInstanceId", "sourceEventId.sourceEntryIdInventoryItemIdAttributeSetInstanceId");
        aliasMap.put("sourceEventId.sourceEntryId.inventoryItemId.attributeSetInstanceId", "sourceEventId.sourceEntryIdInventoryItemIdAttributeSetInstanceId");
        aliasMap.put("SourceEventId.SourceEntryId.InventoryItemId.AttributeSetInstanceId", "sourceEventId.sourceEntryIdInventoryItemIdAttributeSetInstanceId");
        aliasMap.put("sourceEventId.sourceEntryIdEntrySeqId", "sourceEventId.sourceEntryIdEntrySeqId");
        aliasMap.put("SourceEventId.SourceEntryIdEntrySeqId", "sourceEventId.sourceEntryIdEntrySeqId");
        aliasMap.put("sourceEventId.sourceEntryId.entrySeqId", "sourceEventId.sourceEntryIdEntrySeqId");
        aliasMap.put("SourceEventId.SourceEntryId.EntrySeqId", "sourceEventId.sourceEntryIdEntrySeqId");
        aliasMap.put("sourceEventId.inventoryPostingRuleId", "sourceEventId.inventoryPostingRuleId");
        aliasMap.put("SourceEventId.InventoryPostingRuleId", "sourceEventId.inventoryPostingRuleId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

