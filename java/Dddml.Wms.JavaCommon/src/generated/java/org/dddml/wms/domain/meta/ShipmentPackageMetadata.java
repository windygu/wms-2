package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class ShipmentPackageMetadata {

    private ShipmentPackageMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "version";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "shipmentBoxTypeId",
            "dateCreated",
            "boxLength",
            "boxHeight",
            "boxWidth",
            "dimensionUomId",
            "weight",
            "weightUomId",
            "insuredValue",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "shipmentPackageId.shipmentId",
            "shipmentPackageId.shipmentPackageSeqId",
    };

    public static final String[] propertyTypes = new String[] {
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
        aliasMap.put("shipmentBoxTypeId", "shipmentBoxTypeId");
        aliasMap.put("ShipmentBoxTypeId", "shipmentBoxTypeId");
        aliasMap.put("dateCreated", "dateCreated");
        aliasMap.put("DateCreated", "dateCreated");
        aliasMap.put("boxLength", "boxLength");
        aliasMap.put("BoxLength", "boxLength");
        aliasMap.put("boxHeight", "boxHeight");
        aliasMap.put("BoxHeight", "boxHeight");
        aliasMap.put("boxWidth", "boxWidth");
        aliasMap.put("BoxWidth", "boxWidth");
        aliasMap.put("dimensionUomId", "dimensionUomId");
        aliasMap.put("DimensionUomId", "dimensionUomId");
        aliasMap.put("weight", "weight");
        aliasMap.put("Weight", "weight");
        aliasMap.put("weightUomId", "weightUomId");
        aliasMap.put("WeightUomId", "weightUomId");
        aliasMap.put("insuredValue", "insuredValue");
        aliasMap.put("InsuredValue", "insuredValue");
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
        aliasMap.put("shipmentPackageId.shipmentId", "shipmentPackageId.shipmentId");
        aliasMap.put("ShipmentPackageId.ShipmentId", "shipmentPackageId.shipmentId");
        aliasMap.put("shipmentPackageId.shipmentPackageSeqId", "shipmentPackageId.shipmentPackageSeqId");
        aliasMap.put("ShipmentPackageId.ShipmentPackageSeqId", "shipmentPackageId.shipmentPackageSeqId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

