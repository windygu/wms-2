package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class ItemIssuanceMetadata {

    private ItemIssuanceMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "version";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "itemIssuanceSeqId",
            "orderId",
            "orderItemSeqId",
            "shipGroupSeqId",
            "productId",
            "locatorId",
            "attributeSetInstanceId",
            "shipmentItemSeqId",
            "fixedAssetId",
            "maintHistSeqId",
            "issuedDateTime",
            "issuedByUserLoginId",
            "quantity",
            "cancelQuantity",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "shipmentId",
            "shipmentItemIssuanceId.shipmentId",
            "shipmentItemIssuanceId.itemIssuanceSeqId",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "String",
            "String",
            "Long",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "java.sql.Timestamp",
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
        aliasMap.put("itemIssuanceSeqId", "shipmentItemIssuanceId.itemIssuanceSeqId");
        aliasMap.put("ItemIssuanceSeqId", "shipmentItemIssuanceId.itemIssuanceSeqId");
        aliasMap.put("orderId", "orderId");
        aliasMap.put("OrderId", "orderId");
        aliasMap.put("orderItemSeqId", "orderItemSeqId");
        aliasMap.put("OrderItemSeqId", "orderItemSeqId");
        aliasMap.put("shipGroupSeqId", "shipGroupSeqId");
        aliasMap.put("ShipGroupSeqId", "shipGroupSeqId");
        aliasMap.put("productId", "productId");
        aliasMap.put("ProductId", "productId");
        aliasMap.put("locatorId", "locatorId");
        aliasMap.put("LocatorId", "locatorId");
        aliasMap.put("attributeSetInstanceId", "attributeSetInstanceId");
        aliasMap.put("AttributeSetInstanceId", "attributeSetInstanceId");
        aliasMap.put("shipmentItemSeqId", "shipmentItemSeqId");
        aliasMap.put("ShipmentItemSeqId", "shipmentItemSeqId");
        aliasMap.put("fixedAssetId", "fixedAssetId");
        aliasMap.put("FixedAssetId", "fixedAssetId");
        aliasMap.put("maintHistSeqId", "maintHistSeqId");
        aliasMap.put("MaintHistSeqId", "maintHistSeqId");
        aliasMap.put("issuedDateTime", "issuedDateTime");
        aliasMap.put("IssuedDateTime", "issuedDateTime");
        aliasMap.put("issuedByUserLoginId", "issuedByUserLoginId");
        aliasMap.put("IssuedByUserLoginId", "issuedByUserLoginId");
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
        aliasMap.put("shipmentId", "shipmentItemIssuanceId.shipmentId");
        aliasMap.put("ShipmentId", "shipmentItemIssuanceId.shipmentId");
        aliasMap.put("shipmentItemIssuanceId.shipmentId", "shipmentItemIssuanceId.shipmentId");
        aliasMap.put("ShipmentItemIssuanceId.ShipmentId", "shipmentItemIssuanceId.shipmentId");
        aliasMap.put("shipmentItemIssuanceId.itemIssuanceSeqId", "shipmentItemIssuanceId.itemIssuanceSeqId");
        aliasMap.put("ShipmentItemIssuanceId.ItemIssuanceSeqId", "shipmentItemIssuanceId.itemIssuanceSeqId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

