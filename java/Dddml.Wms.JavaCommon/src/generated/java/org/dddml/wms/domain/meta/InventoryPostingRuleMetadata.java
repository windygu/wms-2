package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class InventoryPostingRuleMetadata {

    private InventoryPostingRuleMetadata() {
    }

    String PROPERTY_NAME_VERSION      = "version";
    String PROPERTY_NAME_ACTIVE       = "active";
    String PROPERTY_NAME_DELETED      = "deleted";
    String PROPERTY_NAME_CREATED_BY   = "createdBy";
    String PROPERTY_NAME_CREATED_AT   = "createdAt";
    String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "inventoryPostingRuleId",
            "triggerAccountName",
            "outputAccountName",
            "isOutputNegated",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "triggerInventoryItemId.productId",
            "triggerInventoryItemId.locatorId",
            "triggerInventoryItemId.attributeSetInstanceId",
            "outputInventoryItemId.productId",
            "outputInventoryItemId.locatorId",
            "outputInventoryItemId.attributeSetInstanceId",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "String",
            "String",
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
        aliasMap.put("inventoryPostingRuleId", "inventoryPostingRuleId");
        aliasMap.put("InventoryPostingRuleId", "inventoryPostingRuleId");
        aliasMap.put("triggerAccountName", "triggerAccountName");
        aliasMap.put("TriggerAccountName", "triggerAccountName");
        aliasMap.put("outputAccountName", "outputAccountName");
        aliasMap.put("OutputAccountName", "outputAccountName");
        aliasMap.put("isOutputNegated", "isOutputNegated");
        aliasMap.put("IsOutputNegated", "isOutputNegated");
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
        aliasMap.put("triggerInventoryItemId.productId", "triggerInventoryItemId.productId");
        aliasMap.put("TriggerInventoryItemId.ProductId", "triggerInventoryItemId.productId");
        aliasMap.put("triggerInventoryItemId.locatorId", "triggerInventoryItemId.locatorId");
        aliasMap.put("TriggerInventoryItemId.LocatorId", "triggerInventoryItemId.locatorId");
        aliasMap.put("triggerInventoryItemId.attributeSetInstanceId", "triggerInventoryItemId.attributeSetInstanceId");
        aliasMap.put("TriggerInventoryItemId.AttributeSetInstanceId", "triggerInventoryItemId.attributeSetInstanceId");
        aliasMap.put("outputInventoryItemId.productId", "outputInventoryItemId.productId");
        aliasMap.put("OutputInventoryItemId.ProductId", "outputInventoryItemId.productId");
        aliasMap.put("outputInventoryItemId.locatorId", "outputInventoryItemId.locatorId");
        aliasMap.put("OutputInventoryItemId.LocatorId", "outputInventoryItemId.locatorId");
        aliasMap.put("outputInventoryItemId.attributeSetInstanceId", "outputInventoryItemId.attributeSetInstanceId");
        aliasMap.put("OutputInventoryItemId.AttributeSetInstanceId", "outputInventoryItemId.attributeSetInstanceId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

