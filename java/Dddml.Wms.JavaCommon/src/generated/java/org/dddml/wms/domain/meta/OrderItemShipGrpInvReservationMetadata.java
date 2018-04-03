package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class OrderItemShipGrpInvReservationMetadata {

    private OrderItemShipGrpInvReservationMetadata() {
    }

    String PROPERTY_NAME_VERSION      = "version";
    String PROPERTY_NAME_ACTIVE       = "active";
    String PROPERTY_NAME_DELETED      = "deleted";
    String PROPERTY_NAME_CREATED_BY   = "createdBy";
    String PROPERTY_NAME_CREATED_AT   = "createdAt";
    String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "reserveOrderEnumId",
            "quantity",
            "quantityNotAvailable",
            "reservedDatetime",
            "createdDatetime",
            "promisedDatetime",
            "currentPromisedDate",
            "priority",
            "sequenceId",
            "oldPickStartDate",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "orderItemShipGrpInvResId.orderId",
            "orderItemShipGrpInvResId.shipGroupSeqId",
            "orderItemShipGrpInvResId.orderItemSeqId",
            "orderItemShipGrpInvResId.productId",
            "orderItemShipGrpInvResId.locatorId",
            "orderItemShipGrpInvResId.attributeSetInstanceId",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "java.math.BigDecimal",
            "java.math.BigDecimal",
            "java.sql.Timestamp",
            "java.sql.Timestamp",
            "java.sql.Timestamp",
            "java.sql.Timestamp",
            "String",
            "Long",
            "java.sql.Timestamp",
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
        aliasMap.put("reserveOrderEnumId", "reserveOrderEnumId");
        aliasMap.put("ReserveOrderEnumId", "reserveOrderEnumId");
        aliasMap.put("quantity", "quantity");
        aliasMap.put("Quantity", "quantity");
        aliasMap.put("quantityNotAvailable", "quantityNotAvailable");
        aliasMap.put("QuantityNotAvailable", "quantityNotAvailable");
        aliasMap.put("reservedDatetime", "reservedDatetime");
        aliasMap.put("ReservedDatetime", "reservedDatetime");
        aliasMap.put("createdDatetime", "createdDatetime");
        aliasMap.put("CreatedDatetime", "createdDatetime");
        aliasMap.put("promisedDatetime", "promisedDatetime");
        aliasMap.put("PromisedDatetime", "promisedDatetime");
        aliasMap.put("currentPromisedDate", "currentPromisedDate");
        aliasMap.put("CurrentPromisedDate", "currentPromisedDate");
        aliasMap.put("priority", "priority");
        aliasMap.put("Priority", "priority");
        aliasMap.put("sequenceId", "sequenceId");
        aliasMap.put("SequenceId", "sequenceId");
        aliasMap.put("oldPickStartDate", "oldPickStartDate");
        aliasMap.put("OldPickStartDate", "oldPickStartDate");
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
        aliasMap.put("orderItemShipGrpInvResId.orderId", "orderItemShipGrpInvResId.orderId");
        aliasMap.put("OrderItemShipGrpInvResId.OrderId", "orderItemShipGrpInvResId.orderId");
        aliasMap.put("orderItemShipGrpInvResId.shipGroupSeqId", "orderItemShipGrpInvResId.shipGroupSeqId");
        aliasMap.put("OrderItemShipGrpInvResId.ShipGroupSeqId", "orderItemShipGrpInvResId.shipGroupSeqId");
        aliasMap.put("orderItemShipGrpInvResId.orderItemSeqId", "orderItemShipGrpInvResId.orderItemSeqId");
        aliasMap.put("OrderItemShipGrpInvResId.OrderItemSeqId", "orderItemShipGrpInvResId.orderItemSeqId");
        aliasMap.put("orderItemShipGrpInvResId.productId", "orderItemShipGrpInvResId.productId");
        aliasMap.put("OrderItemShipGrpInvResId.ProductId", "orderItemShipGrpInvResId.productId");
        aliasMap.put("orderItemShipGrpInvResId.locatorId", "orderItemShipGrpInvResId.locatorId");
        aliasMap.put("OrderItemShipGrpInvResId.LocatorId", "orderItemShipGrpInvResId.locatorId");
        aliasMap.put("orderItemShipGrpInvResId.attributeSetInstanceId", "orderItemShipGrpInvResId.attributeSetInstanceId");
        aliasMap.put("OrderItemShipGrpInvResId.AttributeSetInstanceId", "orderItemShipGrpInvResId.attributeSetInstanceId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

