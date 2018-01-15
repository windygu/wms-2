package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class InventoryItemRequirementEntryMvoFilteringProperties
{

    private InventoryItemRequirementEntryMvoFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "quantity",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "inventoryItemRequirementQuantity",
            "inventoryItemRequirementVersion",
            "inventoryItemRequirementCreatedBy",
            "inventoryItemRequirementCreatedAt",
            "inventoryItemRequirementUpdatedBy",
            "inventoryItemRequirementUpdatedAt",
            "inventoryItemRequirementEntryId.inventoryItemRequirementIdProductId",
            "inventoryItemRequirementEntryId.inventoryItemRequirementIdLocatorId",
            "inventoryItemRequirementEntryId.inventoryItemRequirementIdAttributeSetInstanceId",
            "inventoryItemRequirementEntryId.entrySeqId",
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
        aliasMap.put("quantity", "quantity");
        aliasMap.put("Quantity", "quantity");
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
        aliasMap.put("inventoryItemRequirementQuantity", "inventoryItemRequirementQuantity");
        aliasMap.put("InventoryItemRequirementQuantity", "inventoryItemRequirementQuantity");
        aliasMap.put("inventoryItemRequirementVersion", "inventoryItemRequirementVersion");
        aliasMap.put("InventoryItemRequirementVersion", "inventoryItemRequirementVersion");
        aliasMap.put("inventoryItemRequirementCreatedBy", "inventoryItemRequirementCreatedBy");
        aliasMap.put("InventoryItemRequirementCreatedBy", "inventoryItemRequirementCreatedBy");
        aliasMap.put("inventoryItemRequirementCreatedAt", "inventoryItemRequirementCreatedAt");
        aliasMap.put("InventoryItemRequirementCreatedAt", "inventoryItemRequirementCreatedAt");
        aliasMap.put("inventoryItemRequirementUpdatedBy", "inventoryItemRequirementUpdatedBy");
        aliasMap.put("InventoryItemRequirementUpdatedBy", "inventoryItemRequirementUpdatedBy");
        aliasMap.put("inventoryItemRequirementUpdatedAt", "inventoryItemRequirementUpdatedAt");
        aliasMap.put("InventoryItemRequirementUpdatedAt", "inventoryItemRequirementUpdatedAt");
        aliasMap.put("inventoryItemRequirementEntryId.inventoryItemRequirementIdProductId", "inventoryItemRequirementEntryId.inventoryItemRequirementIdProductId");
        aliasMap.put("InventoryItemRequirementEntryId.InventoryItemRequirementIdProductId", "inventoryItemRequirementEntryId.inventoryItemRequirementIdProductId");
        aliasMap.put("inventoryItemRequirementEntryId.inventoryItemRequirementId.productId", "inventoryItemRequirementEntryId.inventoryItemRequirementIdProductId");
        aliasMap.put("InventoryItemRequirementEntryId.InventoryItemRequirementId.ProductId", "inventoryItemRequirementEntryId.inventoryItemRequirementIdProductId");
        aliasMap.put("inventoryItemRequirementEntryId.inventoryItemRequirementIdLocatorId", "inventoryItemRequirementEntryId.inventoryItemRequirementIdLocatorId");
        aliasMap.put("InventoryItemRequirementEntryId.InventoryItemRequirementIdLocatorId", "inventoryItemRequirementEntryId.inventoryItemRequirementIdLocatorId");
        aliasMap.put("inventoryItemRequirementEntryId.inventoryItemRequirementId.locatorId", "inventoryItemRequirementEntryId.inventoryItemRequirementIdLocatorId");
        aliasMap.put("InventoryItemRequirementEntryId.InventoryItemRequirementId.LocatorId", "inventoryItemRequirementEntryId.inventoryItemRequirementIdLocatorId");
        aliasMap.put("inventoryItemRequirementEntryId.inventoryItemRequirementIdAttributeSetInstanceId", "inventoryItemRequirementEntryId.inventoryItemRequirementIdAttributeSetInstanceId");
        aliasMap.put("InventoryItemRequirementEntryId.InventoryItemRequirementIdAttributeSetInstanceId", "inventoryItemRequirementEntryId.inventoryItemRequirementIdAttributeSetInstanceId");
        aliasMap.put("inventoryItemRequirementEntryId.inventoryItemRequirementId.attributeSetInstanceId", "inventoryItemRequirementEntryId.inventoryItemRequirementIdAttributeSetInstanceId");
        aliasMap.put("InventoryItemRequirementEntryId.InventoryItemRequirementId.AttributeSetInstanceId", "inventoryItemRequirementEntryId.inventoryItemRequirementIdAttributeSetInstanceId");
        aliasMap.put("inventoryItemRequirementEntryId.entrySeqId", "inventoryItemRequirementEntryId.entrySeqId");
        aliasMap.put("InventoryItemRequirementEntryId.EntrySeqId", "inventoryItemRequirementEntryId.entrySeqId");
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

