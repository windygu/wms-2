package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class InventoryItemRequirementFilteringProperties
{

    private InventoryItemRequirementFilteringProperties()
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
            "inventoryItemRequirementId.productId",
            "inventoryItemRequirementId.locatorId",
            "inventoryItemRequirementId.attributeSetInstanceId",
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
        aliasMap.put("inventoryItemRequirementId.productId", "inventoryItemRequirementId.productId");
        aliasMap.put("InventoryItemRequirementId.ProductId", "inventoryItemRequirementId.productId");
        aliasMap.put("inventoryItemRequirementId.locatorId", "inventoryItemRequirementId.locatorId");
        aliasMap.put("InventoryItemRequirementId.LocatorId", "inventoryItemRequirementId.locatorId");
        aliasMap.put("inventoryItemRequirementId.attributeSetInstanceId", "inventoryItemRequirementId.attributeSetInstanceId");
        aliasMap.put("InventoryItemRequirementId.AttributeSetInstanceId", "inventoryItemRequirementId.attributeSetInstanceId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

