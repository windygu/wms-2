package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class ShipmentPackageContentMetadata {

    private ShipmentPackageContentMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "version";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "shipmentItemSeqId",
            "quantity",
            "subProductId",
            "subProductQuantity",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "shipmentPackageContentId.shipmentPackageIdShipmentId",
            "shipmentPackageContentId.shipmentPackageIdShipmentPackageSeqId",
            "shipmentPackageContentId.shipmentItemSeqId",
            "shipmentPackageId.shipmentId",
            "shipmentPackageId.shipmentPackageSeqId",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "java.math.BigDecimal",
            "String",
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
        aliasMap.put("shipmentItemSeqId", "shipmentPackageContentId.shipmentItemSeqId");
        aliasMap.put("ShipmentItemSeqId", "shipmentPackageContentId.shipmentItemSeqId");
        aliasMap.put("quantity", "quantity");
        aliasMap.put("Quantity", "quantity");
        aliasMap.put("subProductId", "subProductId");
        aliasMap.put("SubProductId", "subProductId");
        aliasMap.put("subProductQuantity", "subProductQuantity");
        aliasMap.put("SubProductQuantity", "subProductQuantity");
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
        aliasMap.put("shipmentPackageContentId.shipmentPackageIdShipmentId", "shipmentPackageContentId.shipmentPackageIdShipmentId");
        aliasMap.put("ShipmentPackageContentId.ShipmentPackageIdShipmentId", "shipmentPackageContentId.shipmentPackageIdShipmentId");
        aliasMap.put("shipmentPackageContentId.shipmentPackageId.shipmentId", "shipmentPackageContentId.shipmentPackageIdShipmentId");
        aliasMap.put("ShipmentPackageContentId.ShipmentPackageId.ShipmentId", "shipmentPackageContentId.shipmentPackageIdShipmentId");
        aliasMap.put("shipmentPackageContentId.shipmentPackageIdShipmentPackageSeqId", "shipmentPackageContentId.shipmentPackageIdShipmentPackageSeqId");
        aliasMap.put("ShipmentPackageContentId.ShipmentPackageIdShipmentPackageSeqId", "shipmentPackageContentId.shipmentPackageIdShipmentPackageSeqId");
        aliasMap.put("shipmentPackageContentId.shipmentPackageId.shipmentPackageSeqId", "shipmentPackageContentId.shipmentPackageIdShipmentPackageSeqId");
        aliasMap.put("ShipmentPackageContentId.ShipmentPackageId.ShipmentPackageSeqId", "shipmentPackageContentId.shipmentPackageIdShipmentPackageSeqId");
        aliasMap.put("shipmentPackageContentId.shipmentItemSeqId", "shipmentPackageContentId.shipmentItemSeqId");
        aliasMap.put("ShipmentPackageContentId.ShipmentItemSeqId", "shipmentPackageContentId.shipmentItemSeqId");
        aliasMap.put("shipmentPackageId.shipmentId", "shipmentPackageContentId.shipmentPackageIdShipmentId");
        aliasMap.put("ShipmentPackageId.ShipmentId", "shipmentPackageContentId.shipmentPackageIdShipmentId");
        aliasMap.put("shipmentPackageId.shipmentId", "shipmentPackageContentId.shipmentPackageIdShipmentId");
        aliasMap.put("ShipmentPackageId.ShipmentId", "shipmentPackageContentId.shipmentPackageIdShipmentId");
        aliasMap.put("shipmentPackageId.shipmentPackageSeqId", "shipmentPackageContentId.shipmentPackageIdShipmentPackageSeqId");
        aliasMap.put("ShipmentPackageId.ShipmentPackageSeqId", "shipmentPackageContentId.shipmentPackageIdShipmentPackageSeqId");
        aliasMap.put("shipmentPackageId.shipmentPackageSeqId", "shipmentPackageContentId.shipmentPackageIdShipmentPackageSeqId");
        aliasMap.put("ShipmentPackageId.ShipmentPackageSeqId", "shipmentPackageContentId.shipmentPackageIdShipmentPackageSeqId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

