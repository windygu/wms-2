package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class OrderItemShipGroupAssociationMetadata {

    private OrderItemShipGroupAssociationMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "version";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "orderItemSeqId",
            "quantity",
            "cancelQuantity",
            "numberOfPackages",
            "numberOfContainers",
            "numberOfPakagesPerContainer",
            "orderItemShipGroupAssociationKey",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "orderId",
            "orderShipGroupShipGroupSeqId",
            "orderItemShipGroupAssociationId.orderId",
            "orderItemShipGroupAssociationId.orderShipGroupShipGroupSeqId",
            "orderItemShipGroupAssociationId.orderItemSeqId",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "java.math.BigDecimal",
            "java.math.BigDecimal",
            "Integer",
            "Integer",
            "Integer",
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
        aliasMap.put("orderItemSeqId", "orderItemShipGroupAssociationId.orderItemSeqId");
        aliasMap.put("OrderItemSeqId", "orderItemShipGroupAssociationId.orderItemSeqId");
        aliasMap.put("quantity", "quantity");
        aliasMap.put("Quantity", "quantity");
        aliasMap.put("cancelQuantity", "cancelQuantity");
        aliasMap.put("CancelQuantity", "cancelQuantity");
        aliasMap.put("numberOfPackages", "numberOfPackages");
        aliasMap.put("NumberOfPackages", "numberOfPackages");
        aliasMap.put("numberOfContainers", "numberOfContainers");
        aliasMap.put("NumberOfContainers", "numberOfContainers");
        aliasMap.put("numberOfPakagesPerContainer", "numberOfPakagesPerContainer");
        aliasMap.put("NumberOfPakagesPerContainer", "numberOfPakagesPerContainer");
        aliasMap.put("orderItemShipGroupAssociationKey", "orderItemShipGroupAssociationKey");
        aliasMap.put("OrderItemShipGroupAssociationKey", "orderItemShipGroupAssociationKey");
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
        aliasMap.put("orderId", "orderItemShipGroupAssociationId.orderId");
        aliasMap.put("OrderId", "orderItemShipGroupAssociationId.orderId");
        aliasMap.put("orderShipGroupShipGroupSeqId", "orderItemShipGroupAssociationId.orderShipGroupShipGroupSeqId");
        aliasMap.put("OrderShipGroupShipGroupSeqId", "orderItemShipGroupAssociationId.orderShipGroupShipGroupSeqId");
        aliasMap.put("orderItemShipGroupAssociationId.orderId", "orderItemShipGroupAssociationId.orderId");
        aliasMap.put("OrderItemShipGroupAssociationId.OrderId", "orderItemShipGroupAssociationId.orderId");
        aliasMap.put("orderItemShipGroupAssociationId.orderShipGroupShipGroupSeqId", "orderItemShipGroupAssociationId.orderShipGroupShipGroupSeqId");
        aliasMap.put("OrderItemShipGroupAssociationId.OrderShipGroupShipGroupSeqId", "orderItemShipGroupAssociationId.orderShipGroupShipGroupSeqId");
        aliasMap.put("orderItemShipGroupAssociationId.orderItemSeqId", "orderItemShipGroupAssociationId.orderItemSeqId");
        aliasMap.put("OrderItemShipGroupAssociationId.OrderItemSeqId", "orderItemShipGroupAssociationId.orderItemSeqId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

