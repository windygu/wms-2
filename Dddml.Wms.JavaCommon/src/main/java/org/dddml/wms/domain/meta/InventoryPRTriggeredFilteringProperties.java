package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class InventoryPRTriggeredFilteringProperties
{

    private InventoryPRTriggeredFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "isProcessed",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "inventoryPRTriggeredId.sourceEntryIdInventoryItemIdProductId",
            "inventoryPRTriggeredId.sourceEntryIdInventoryItemIdLocatorId",
            "inventoryPRTriggeredId.sourceEntryIdInventoryItemIdAttributeSetInstanceId",
            "inventoryPRTriggeredId.sourceEntryIdEntrySeqId",
            "inventoryPRTriggeredId.inventoryPostingRuleId",
    };

    public static final String[] propertyTypes = new String[] {
            "Boolean",
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
        aliasMap.put("isProcessed", "isProcessed");
        aliasMap.put("IsProcessed", "isProcessed");
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
        aliasMap.put("inventoryPRTriggeredId.sourceEntryIdInventoryItemIdProductId", "inventoryPRTriggeredId.sourceEntryIdInventoryItemIdProductId");
        aliasMap.put("InventoryPRTriggeredId.SourceEntryIdInventoryItemIdProductId", "inventoryPRTriggeredId.sourceEntryIdInventoryItemIdProductId");
        aliasMap.put("inventoryPRTriggeredId.sourceEntryId.inventoryItemId.productId", "inventoryPRTriggeredId.sourceEntryIdInventoryItemIdProductId");
        aliasMap.put("InventoryPRTriggeredId.SourceEntryId.InventoryItemId.ProductId", "inventoryPRTriggeredId.sourceEntryIdInventoryItemIdProductId");
        aliasMap.put("inventoryPRTriggeredId.sourceEntryIdInventoryItemIdLocatorId", "inventoryPRTriggeredId.sourceEntryIdInventoryItemIdLocatorId");
        aliasMap.put("InventoryPRTriggeredId.SourceEntryIdInventoryItemIdLocatorId", "inventoryPRTriggeredId.sourceEntryIdInventoryItemIdLocatorId");
        aliasMap.put("inventoryPRTriggeredId.sourceEntryId.inventoryItemId.locatorId", "inventoryPRTriggeredId.sourceEntryIdInventoryItemIdLocatorId");
        aliasMap.put("InventoryPRTriggeredId.SourceEntryId.InventoryItemId.LocatorId", "inventoryPRTriggeredId.sourceEntryIdInventoryItemIdLocatorId");
        aliasMap.put("inventoryPRTriggeredId.sourceEntryIdInventoryItemIdAttributeSetInstanceId", "inventoryPRTriggeredId.sourceEntryIdInventoryItemIdAttributeSetInstanceId");
        aliasMap.put("InventoryPRTriggeredId.SourceEntryIdInventoryItemIdAttributeSetInstanceId", "inventoryPRTriggeredId.sourceEntryIdInventoryItemIdAttributeSetInstanceId");
        aliasMap.put("inventoryPRTriggeredId.sourceEntryId.inventoryItemId.attributeSetInstanceId", "inventoryPRTriggeredId.sourceEntryIdInventoryItemIdAttributeSetInstanceId");
        aliasMap.put("InventoryPRTriggeredId.SourceEntryId.InventoryItemId.AttributeSetInstanceId", "inventoryPRTriggeredId.sourceEntryIdInventoryItemIdAttributeSetInstanceId");
        aliasMap.put("inventoryPRTriggeredId.sourceEntryIdEntrySeqId", "inventoryPRTriggeredId.sourceEntryIdEntrySeqId");
        aliasMap.put("InventoryPRTriggeredId.SourceEntryIdEntrySeqId", "inventoryPRTriggeredId.sourceEntryIdEntrySeqId");
        aliasMap.put("inventoryPRTriggeredId.sourceEntryId.entrySeqId", "inventoryPRTriggeredId.sourceEntryIdEntrySeqId");
        aliasMap.put("InventoryPRTriggeredId.SourceEntryId.EntrySeqId", "inventoryPRTriggeredId.sourceEntryIdEntrySeqId");
        aliasMap.put("inventoryPRTriggeredId.inventoryPostingRuleId", "inventoryPRTriggeredId.inventoryPostingRuleId");
        aliasMap.put("InventoryPRTriggeredId.InventoryPostingRuleId", "inventoryPRTriggeredId.inventoryPostingRuleId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

