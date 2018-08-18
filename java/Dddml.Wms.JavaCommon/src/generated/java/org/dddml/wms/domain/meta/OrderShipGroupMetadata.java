package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class OrderShipGroupMetadata {

    private OrderShipGroupMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "version";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "shipGroupSeqId",
            "shipmentMethodTypeId",
            "supplierPartyId",
            "vendorPartyId",
            "carrierPartyId",
            "carrierRoleTypeId",
            "facilityId",
            "contactMechId",
            "telecomContactMechId",
            "contactPartyId",
            "trackingNumber",
            "shippingInstructions",
            "maySplit",
            "giftMessage",
            "isGift",
            "shipAfterDate",
            "shipByDate",
            "estimatedShipDate",
            "estimatedDeliveryDate",
            "pickwaveId",
            "numberOfPackages",
            "numberOfContainers",
            "numberOfPakagesPerContainer",
            "statusId",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "orderId",
            "orderShipGroupId.orderId",
            "orderShipGroupId.shipGroupSeqId",
    };

    public static final String[] propertyTypes = new String[] {
            "Long",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
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
            "java.sql.Timestamp",
            "java.sql.Timestamp",
            "Long",
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
            "Long",
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
        aliasMap.put("shipGroupSeqId", "orderShipGroupId.shipGroupSeqId");
        aliasMap.put("ShipGroupSeqId", "orderShipGroupId.shipGroupSeqId");
        aliasMap.put("shipmentMethodTypeId", "shipmentMethodTypeId");
        aliasMap.put("ShipmentMethodTypeId", "shipmentMethodTypeId");
        aliasMap.put("supplierPartyId", "supplierPartyId");
        aliasMap.put("SupplierPartyId", "supplierPartyId");
        aliasMap.put("vendorPartyId", "vendorPartyId");
        aliasMap.put("VendorPartyId", "vendorPartyId");
        aliasMap.put("carrierPartyId", "carrierPartyId");
        aliasMap.put("CarrierPartyId", "carrierPartyId");
        aliasMap.put("carrierRoleTypeId", "carrierRoleTypeId");
        aliasMap.put("CarrierRoleTypeId", "carrierRoleTypeId");
        aliasMap.put("facilityId", "facilityId");
        aliasMap.put("FacilityId", "facilityId");
        aliasMap.put("contactMechId", "contactMechId");
        aliasMap.put("ContactMechId", "contactMechId");
        aliasMap.put("telecomContactMechId", "telecomContactMechId");
        aliasMap.put("TelecomContactMechId", "telecomContactMechId");
        aliasMap.put("contactPartyId", "contactPartyId");
        aliasMap.put("ContactPartyId", "contactPartyId");
        aliasMap.put("trackingNumber", "trackingNumber");
        aliasMap.put("TrackingNumber", "trackingNumber");
        aliasMap.put("shippingInstructions", "shippingInstructions");
        aliasMap.put("ShippingInstructions", "shippingInstructions");
        aliasMap.put("maySplit", "maySplit");
        aliasMap.put("MaySplit", "maySplit");
        aliasMap.put("giftMessage", "giftMessage");
        aliasMap.put("GiftMessage", "giftMessage");
        aliasMap.put("isGift", "isGift");
        aliasMap.put("IsGift", "isGift");
        aliasMap.put("shipAfterDate", "shipAfterDate");
        aliasMap.put("ShipAfterDate", "shipAfterDate");
        aliasMap.put("shipByDate", "shipByDate");
        aliasMap.put("ShipByDate", "shipByDate");
        aliasMap.put("estimatedShipDate", "estimatedShipDate");
        aliasMap.put("EstimatedShipDate", "estimatedShipDate");
        aliasMap.put("estimatedDeliveryDate", "estimatedDeliveryDate");
        aliasMap.put("EstimatedDeliveryDate", "estimatedDeliveryDate");
        aliasMap.put("pickwaveId", "pickwaveId");
        aliasMap.put("PickwaveId", "pickwaveId");
        aliasMap.put("numberOfPackages", "numberOfPackages");
        aliasMap.put("NumberOfPackages", "numberOfPackages");
        aliasMap.put("numberOfContainers", "numberOfContainers");
        aliasMap.put("NumberOfContainers", "numberOfContainers");
        aliasMap.put("numberOfPakagesPerContainer", "numberOfPakagesPerContainer");
        aliasMap.put("NumberOfPakagesPerContainer", "numberOfPakagesPerContainer");
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
        aliasMap.put("orderId", "orderShipGroupId.orderId");
        aliasMap.put("OrderId", "orderShipGroupId.orderId");
        aliasMap.put("orderShipGroupId.orderId", "orderShipGroupId.orderId");
        aliasMap.put("OrderShipGroupId.OrderId", "orderShipGroupId.orderId");
        aliasMap.put("orderShipGroupId.shipGroupSeqId", "orderShipGroupId.shipGroupSeqId");
        aliasMap.put("OrderShipGroupId.ShipGroupSeqId", "orderShipGroupId.shipGroupSeqId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

