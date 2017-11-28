package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class InventoryItemFilteringProperties
{

    private InventoryItemFilteringProperties()
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
            "inventoryItemId.productId",
            "inventoryItemId.locatorId",
            "inventoryItemId.attributeSetInstance",
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
        aliasMap.put("inventoryItemId.productId", "inventoryItemId.productId");
        aliasMap.put("InventoryItemId.ProductId", "inventoryItemId.productId");
        aliasMap.put("inventoryItemId.locatorId", "inventoryItemId.locatorId");
        aliasMap.put("InventoryItemId.LocatorId", "inventoryItemId.locatorId");
        aliasMap.put("inventoryItemId.attributeSetInstance", "inventoryItemId.attributeSetInstance");
        aliasMap.put("InventoryItemId.AttributeSetInstance", "inventoryItemId.attributeSetInstance");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

