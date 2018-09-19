package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class InOutNoticeMetadata {

    private InOutNoticeMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "version";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "inOutNoticeId",
            "warehouseId",
            "inOutNoticeType",
            "telecomContactMechId",
            "trackingNumber",
            "contactPartyId",
            "vehiclePlateNumber",
            "shippingInstructions",
            "estimatedShipDate",
            "estimatedDeliveryDate",
            "isScheduleNeeded",
            "statusId",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "java.sql.Timestamp",
            "java.sql.Timestamp",
            "Boolean",
            "String",
            "Long",
            "String",
            "Date",
            "String",
            "Date",
            "Boolean",
            "Boolean",
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
        aliasMap.put("inOutNoticeId", "inOutNoticeId");
        aliasMap.put("InOutNoticeId", "inOutNoticeId");
        aliasMap.put("warehouseId", "warehouseId");
        aliasMap.put("WarehouseId", "warehouseId");
        aliasMap.put("inOutNoticeType", "inOutNoticeType");
        aliasMap.put("InOutNoticeType", "inOutNoticeType");
        aliasMap.put("telecomContactMechId", "telecomContactMechId");
        aliasMap.put("TelecomContactMechId", "telecomContactMechId");
        aliasMap.put("trackingNumber", "trackingNumber");
        aliasMap.put("TrackingNumber", "trackingNumber");
        aliasMap.put("contactPartyId", "contactPartyId");
        aliasMap.put("ContactPartyId", "contactPartyId");
        aliasMap.put("vehiclePlateNumber", "vehiclePlateNumber");
        aliasMap.put("VehiclePlateNumber", "vehiclePlateNumber");
        aliasMap.put("shippingInstructions", "shippingInstructions");
        aliasMap.put("ShippingInstructions", "shippingInstructions");
        aliasMap.put("estimatedShipDate", "estimatedShipDate");
        aliasMap.put("EstimatedShipDate", "estimatedShipDate");
        aliasMap.put("estimatedDeliveryDate", "estimatedDeliveryDate");
        aliasMap.put("EstimatedDeliveryDate", "estimatedDeliveryDate");
        aliasMap.put("isScheduleNeeded", "isScheduleNeeded");
        aliasMap.put("IsScheduleNeeded", "isScheduleNeeded");
        aliasMap.put("statusId", "statusId");
        aliasMap.put("StatusId", "statusId");
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
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

