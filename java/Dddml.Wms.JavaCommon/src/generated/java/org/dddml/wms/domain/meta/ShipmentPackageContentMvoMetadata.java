package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class ShipmentPackageContentMvoMetadata {

    private ShipmentPackageContentMvoMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "shipmentPackageVersion";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
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
            "shipmentPackageShipmentBoxTypeId",
            "shipmentPackageDateCreated",
            "shipmentPackageBoxLength",
            "shipmentPackageBoxHeight",
            "shipmentPackageBoxWidth",
            "shipmentPackageDimensionUomId",
            "shipmentPackageWeight",
            "shipmentPackageWeightUomId",
            "shipmentPackageInsuredValue",
            "shipmentPackageVersion",
            "shipmentPackageCreatedBy",
            "shipmentPackageCreatedAt",
            "shipmentPackageUpdatedBy",
            "shipmentPackageUpdatedAt",
            "shipmentPackageActive",
            "shipmentPackageDeleted",
            "shipmentPackageContentId.shipmentPackageIdShipmentId",
            "shipmentPackageContentId.shipmentPackageIdShipmentPackageSeqId",
            "shipmentPackageContentId.shipmentItemSeqId",
    };

    public static final String[] propertyTypes = new String[] {
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
            "java.sql.Timestamp",
            "java.math.BigDecimal",
            "java.math.BigDecimal",
            "java.math.BigDecimal",
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
        aliasMap.put("shipmentPackageShipmentBoxTypeId", "shipmentPackageShipmentBoxTypeId");
        aliasMap.put("ShipmentPackageShipmentBoxTypeId", "shipmentPackageShipmentBoxTypeId");
        aliasMap.put("shipmentPackageDateCreated", "shipmentPackageDateCreated");
        aliasMap.put("ShipmentPackageDateCreated", "shipmentPackageDateCreated");
        aliasMap.put("shipmentPackageBoxLength", "shipmentPackageBoxLength");
        aliasMap.put("ShipmentPackageBoxLength", "shipmentPackageBoxLength");
        aliasMap.put("shipmentPackageBoxHeight", "shipmentPackageBoxHeight");
        aliasMap.put("ShipmentPackageBoxHeight", "shipmentPackageBoxHeight");
        aliasMap.put("shipmentPackageBoxWidth", "shipmentPackageBoxWidth");
        aliasMap.put("ShipmentPackageBoxWidth", "shipmentPackageBoxWidth");
        aliasMap.put("shipmentPackageDimensionUomId", "shipmentPackageDimensionUomId");
        aliasMap.put("ShipmentPackageDimensionUomId", "shipmentPackageDimensionUomId");
        aliasMap.put("shipmentPackageWeight", "shipmentPackageWeight");
        aliasMap.put("ShipmentPackageWeight", "shipmentPackageWeight");
        aliasMap.put("shipmentPackageWeightUomId", "shipmentPackageWeightUomId");
        aliasMap.put("ShipmentPackageWeightUomId", "shipmentPackageWeightUomId");
        aliasMap.put("shipmentPackageInsuredValue", "shipmentPackageInsuredValue");
        aliasMap.put("ShipmentPackageInsuredValue", "shipmentPackageInsuredValue");
        aliasMap.put("shipmentPackageVersion", "shipmentPackageVersion");
        aliasMap.put("ShipmentPackageVersion", "shipmentPackageVersion");
        aliasMap.put("shipmentPackageCreatedBy", "shipmentPackageCreatedBy");
        aliasMap.put("ShipmentPackageCreatedBy", "shipmentPackageCreatedBy");
        aliasMap.put("shipmentPackageCreatedAt", "shipmentPackageCreatedAt");
        aliasMap.put("ShipmentPackageCreatedAt", "shipmentPackageCreatedAt");
        aliasMap.put("shipmentPackageUpdatedBy", "shipmentPackageUpdatedBy");
        aliasMap.put("ShipmentPackageUpdatedBy", "shipmentPackageUpdatedBy");
        aliasMap.put("shipmentPackageUpdatedAt", "shipmentPackageUpdatedAt");
        aliasMap.put("ShipmentPackageUpdatedAt", "shipmentPackageUpdatedAt");
        aliasMap.put("shipmentPackageActive", "shipmentPackageActive");
        aliasMap.put("ShipmentPackageActive", "shipmentPackageActive");
        aliasMap.put("shipmentPackageDeleted", "shipmentPackageDeleted");
        aliasMap.put("ShipmentPackageDeleted", "shipmentPackageDeleted");
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
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

