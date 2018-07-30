package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class ShipmentReceiptImageMetadata {

    private ShipmentReceiptImageMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "version";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "sequenceId",
            "url",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "shipmentId",
            "shipmentReceiptReceiptSeqId",
            "shipmentReceiptImageId.shipmentId",
            "shipmentReceiptImageId.shipmentReceiptReceiptSeqId",
            "shipmentReceiptImageId.sequenceId",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
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
        aliasMap.put("sequenceId", "shipmentReceiptImageId.sequenceId");
        aliasMap.put("SequenceId", "shipmentReceiptImageId.sequenceId");
        aliasMap.put("url", "url");
        aliasMap.put("Url", "url");
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
        aliasMap.put("shipmentId", "shipmentReceiptImageId.shipmentId");
        aliasMap.put("ShipmentId", "shipmentReceiptImageId.shipmentId");
        aliasMap.put("shipmentReceiptReceiptSeqId", "shipmentReceiptImageId.shipmentReceiptReceiptSeqId");
        aliasMap.put("ShipmentReceiptReceiptSeqId", "shipmentReceiptImageId.shipmentReceiptReceiptSeqId");
        aliasMap.put("shipmentReceiptImageId.shipmentId", "shipmentReceiptImageId.shipmentId");
        aliasMap.put("ShipmentReceiptImageId.ShipmentId", "shipmentReceiptImageId.shipmentId");
        aliasMap.put("shipmentReceiptImageId.shipmentReceiptReceiptSeqId", "shipmentReceiptImageId.shipmentReceiptReceiptSeqId");
        aliasMap.put("ShipmentReceiptImageId.ShipmentReceiptReceiptSeqId", "shipmentReceiptImageId.shipmentReceiptReceiptSeqId");
        aliasMap.put("shipmentReceiptImageId.sequenceId", "shipmentReceiptImageId.sequenceId");
        aliasMap.put("ShipmentReceiptImageId.SequenceId", "shipmentReceiptImageId.sequenceId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

