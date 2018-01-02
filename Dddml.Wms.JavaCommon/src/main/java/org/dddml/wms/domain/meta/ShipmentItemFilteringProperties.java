package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class ShipmentItemFilteringProperties
{

    private ShipmentItemFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "shipmentItemSeqId",
            "productId",
            "attributeSetInstanceId",
            "quantity",
            "shipmentContentDescription",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "shipmentId",
            "shipmentItemId.shipmentId",
            "shipmentItemId.shipmentItemSeqId",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "String",
            "String",
            "java.math.BigDecimal",
            "String",
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
        aliasMap.put("shipmentItemSeqId", "shipmentItemId.shipmentItemSeqId");
        aliasMap.put("ShipmentItemSeqId", "shipmentItemId.shipmentItemSeqId");
        aliasMap.put("productId", "productId");
        aliasMap.put("ProductId", "productId");
        aliasMap.put("attributeSetInstanceId", "attributeSetInstanceId");
        aliasMap.put("AttributeSetInstanceId", "attributeSetInstanceId");
        aliasMap.put("quantity", "quantity");
        aliasMap.put("Quantity", "quantity");
        aliasMap.put("shipmentContentDescription", "shipmentContentDescription");
        aliasMap.put("ShipmentContentDescription", "shipmentContentDescription");
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
        aliasMap.put("shipmentId", "shipmentItemId.shipmentId");
        aliasMap.put("ShipmentId", "shipmentItemId.shipmentId");
        aliasMap.put("shipmentItemId.shipmentId", "shipmentItemId.shipmentId");
        aliasMap.put("ShipmentItemId.ShipmentId", "shipmentItemId.shipmentId");
        aliasMap.put("shipmentItemId.shipmentItemSeqId", "shipmentItemId.shipmentItemSeqId");
        aliasMap.put("ShipmentItemId.ShipmentItemSeqId", "shipmentItemId.shipmentItemSeqId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

