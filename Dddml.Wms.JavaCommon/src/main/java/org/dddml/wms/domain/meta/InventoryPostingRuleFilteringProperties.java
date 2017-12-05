package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class InventoryPostingRuleFilteringProperties
{

    private InventoryPostingRuleFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "inventoryPostingRuleId",
            "isOutputNegated",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "trigger.productId",
            "trigger.locatorId",
            "trigger.attributeSetInstanceId",
            "output.productId",
            "output.locatorId",
            "output.attributeSetInstanceId",
    };

    public static final String[] propertyTypes = new String[] {
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
        aliasMap.put("trigger.productId", "trigger.productId");
        aliasMap.put("Trigger.ProductId", "trigger.productId");
        aliasMap.put("trigger.locatorId", "trigger.locatorId");
        aliasMap.put("Trigger.LocatorId", "trigger.locatorId");
        aliasMap.put("trigger.attributeSetInstanceId", "trigger.attributeSetInstanceId");
        aliasMap.put("Trigger.AttributeSetInstanceId", "trigger.attributeSetInstanceId");
        aliasMap.put("output.productId", "output.productId");
        aliasMap.put("Output.ProductId", "output.productId");
        aliasMap.put("output.locatorId", "output.locatorId");
        aliasMap.put("Output.LocatorId", "output.locatorId");
        aliasMap.put("output.attributeSetInstanceId", "output.attributeSetInstanceId");
        aliasMap.put("Output.AttributeSetInstanceId", "output.attributeSetInstanceId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

