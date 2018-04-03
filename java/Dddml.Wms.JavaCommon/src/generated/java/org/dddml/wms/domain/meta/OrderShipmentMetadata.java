package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class OrderShipmentMetadata {

    private OrderShipmentMetadata() {
    }

    String PROPERTY_NAME_VERSION      = "version";
    String PROPERTY_NAME_ACTIVE       = "active";
    String PROPERTY_NAME_DELETED      = "deleted";
    String PROPERTY_NAME_CREATED_BY   = "createdBy";
    String PROPERTY_NAME_CREATED_AT   = "createdAt";
    String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "quantity",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "orderShipmentId.orderId",
            "orderShipmentId.orderItemSeqId",
            "orderShipmentId.shipGroupSeqId",
            "orderShipmentId.shipmentId",
            "orderShipmentId.shipmentItemSeqId",
    };

    public static final String[] propertyTypes = new String[] {
            "java.math.BigDecimal",
            "Long",
            "String",
            "Date",
            "String",
            "Date",
            "Boolean",
            "Boolean",
            "String",
            "String",
            "Long",
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
        aliasMap.put("orderShipmentId.orderId", "orderShipmentId.orderId");
        aliasMap.put("OrderShipmentId.OrderId", "orderShipmentId.orderId");
        aliasMap.put("orderShipmentId.orderItemSeqId", "orderShipmentId.orderItemSeqId");
        aliasMap.put("OrderShipmentId.OrderItemSeqId", "orderShipmentId.orderItemSeqId");
        aliasMap.put("orderShipmentId.shipGroupSeqId", "orderShipmentId.shipGroupSeqId");
        aliasMap.put("OrderShipmentId.ShipGroupSeqId", "orderShipmentId.shipGroupSeqId");
        aliasMap.put("orderShipmentId.shipmentId", "orderShipmentId.shipmentId");
        aliasMap.put("OrderShipmentId.ShipmentId", "orderShipmentId.shipmentId");
        aliasMap.put("orderShipmentId.shipmentItemSeqId", "orderShipmentId.shipmentItemSeqId");
        aliasMap.put("OrderShipmentId.ShipmentItemSeqId", "orderShipmentId.shipmentItemSeqId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

