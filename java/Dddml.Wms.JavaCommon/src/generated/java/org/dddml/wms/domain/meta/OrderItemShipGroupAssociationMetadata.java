package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class OrderItemShipGroupAssociationMetadata {

    private OrderItemShipGroupAssociationMetadata() {
    }

    String PROPERTY_NAME_VERSION      = "version";
    String PROPERTY_NAME_ACTIVE       = "active";
    String PROPERTY_NAME_DELETED      = "deleted";
    String PROPERTY_NAME_CREATED_BY   = "createdBy";
    String PROPERTY_NAME_CREATED_AT   = "createdAt";
    String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "orderItemSeqId",
            "quantity",
            "cancelQuantity",
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
            "Long",
            "String",
            "Date",
            "String",
            "Date",
            "Boolean",
            "Boolean",
            "String",
            "Long",
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
        aliasMap.put("orderItemSeqId", "orderItemShipGroupAssociationId.orderItemSeqId");
        aliasMap.put("OrderItemSeqId", "orderItemShipGroupAssociationId.orderItemSeqId");
        aliasMap.put("quantity", "quantity");
        aliasMap.put("Quantity", "quantity");
        aliasMap.put("cancelQuantity", "cancelQuantity");
        aliasMap.put("CancelQuantity", "cancelQuantity");
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

