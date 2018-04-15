package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class ShipmentItemMvoMetadata {

    private ShipmentItemMvoMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "shipmentVersion";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "productId",
            "attributeSetInstanceId",
            "quantity",
            "shipmentContentDescription",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "shipmentShipmentTypeId",
            "shipmentStatusId",
            "shipmentPrimaryOrderId",
            "shipmentPrimaryReturnId",
            "shipmentPrimaryShipGroupSeqId",
            "shipmentPicklistBinId",
            "shipmentEstimatedReadyDate",
            "shipmentEstimatedShipDate",
            "shipmentEstimatedShipWorkEffId",
            "shipmentEstimatedArrivalDate",
            "shipmentEstimatedArrivalWorkEffId",
            "shipmentLatestCancelDate",
            "shipmentEstimatedShipCost",
            "shipmentCurrencyUomId",
            "shipmentHandlingInstructions",
            "shipmentOriginFacilityId",
            "shipmentDestinationFacilityId",
            "shipmentOriginContactMechId",
            "shipmentOriginTelecomNumberId",
            "shipmentDestinationContactMechId",
            "shipmentDestinationTelecomNumberId",
            "shipmentPartyIdTo",
            "shipmentPartyIdFrom",
            "shipmentAdditionalShippingCharge",
            "shipmentAddtlShippingChargeDesc",
            "shipmentVersion",
            "shipmentCreatedBy",
            "shipmentCreatedAt",
            "shipmentUpdatedBy",
            "shipmentUpdatedAt",
            "shipmentActive",
            "shipmentItemId.shipmentId",
            "shipmentItemId.shipmentItemSeqId",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "String",
            "java.math.BigDecimal",
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
            "Long",
            "String",
            "java.sql.Timestamp",
            "java.sql.Timestamp",
            "String",
            "java.sql.Timestamp",
            "String",
            "java.sql.Timestamp",
            "java.math.BigDecimal",
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
            "java.math.BigDecimal",
            "String",
            "Long",
            "String",
            "Date",
            "String",
            "Date",
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
        aliasMap.put("productId", "productId");
        aliasMap.put("ProductId", "productId");
        aliasMap.put("attributeSetInstanceId", "attributeSetInstanceId");
        aliasMap.put("AttributeSetInstanceId", "attributeSetInstanceId");
        aliasMap.put("quantity", "quantity");
        aliasMap.put("Quantity", "quantity");
        aliasMap.put("shipmentContentDescription", "shipmentContentDescription");
        aliasMap.put("ShipmentContentDescription", "shipmentContentDescription");
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
        aliasMap.put("shipmentShipmentTypeId", "shipmentShipmentTypeId");
        aliasMap.put("ShipmentShipmentTypeId", "shipmentShipmentTypeId");
        aliasMap.put("shipmentStatusId", "shipmentStatusId");
        aliasMap.put("ShipmentStatusId", "shipmentStatusId");
        aliasMap.put("shipmentPrimaryOrderId", "shipmentPrimaryOrderId");
        aliasMap.put("ShipmentPrimaryOrderId", "shipmentPrimaryOrderId");
        aliasMap.put("shipmentPrimaryReturnId", "shipmentPrimaryReturnId");
        aliasMap.put("ShipmentPrimaryReturnId", "shipmentPrimaryReturnId");
        aliasMap.put("shipmentPrimaryShipGroupSeqId", "shipmentPrimaryShipGroupSeqId");
        aliasMap.put("ShipmentPrimaryShipGroupSeqId", "shipmentPrimaryShipGroupSeqId");
        aliasMap.put("shipmentPicklistBinId", "shipmentPicklistBinId");
        aliasMap.put("ShipmentPicklistBinId", "shipmentPicklistBinId");
        aliasMap.put("shipmentEstimatedReadyDate", "shipmentEstimatedReadyDate");
        aliasMap.put("ShipmentEstimatedReadyDate", "shipmentEstimatedReadyDate");
        aliasMap.put("shipmentEstimatedShipDate", "shipmentEstimatedShipDate");
        aliasMap.put("ShipmentEstimatedShipDate", "shipmentEstimatedShipDate");
        aliasMap.put("shipmentEstimatedShipWorkEffId", "shipmentEstimatedShipWorkEffId");
        aliasMap.put("ShipmentEstimatedShipWorkEffId", "shipmentEstimatedShipWorkEffId");
        aliasMap.put("shipmentEstimatedArrivalDate", "shipmentEstimatedArrivalDate");
        aliasMap.put("ShipmentEstimatedArrivalDate", "shipmentEstimatedArrivalDate");
        aliasMap.put("shipmentEstimatedArrivalWorkEffId", "shipmentEstimatedArrivalWorkEffId");
        aliasMap.put("ShipmentEstimatedArrivalWorkEffId", "shipmentEstimatedArrivalWorkEffId");
        aliasMap.put("shipmentLatestCancelDate", "shipmentLatestCancelDate");
        aliasMap.put("ShipmentLatestCancelDate", "shipmentLatestCancelDate");
        aliasMap.put("shipmentEstimatedShipCost", "shipmentEstimatedShipCost");
        aliasMap.put("ShipmentEstimatedShipCost", "shipmentEstimatedShipCost");
        aliasMap.put("shipmentCurrencyUomId", "shipmentCurrencyUomId");
        aliasMap.put("ShipmentCurrencyUomId", "shipmentCurrencyUomId");
        aliasMap.put("shipmentHandlingInstructions", "shipmentHandlingInstructions");
        aliasMap.put("ShipmentHandlingInstructions", "shipmentHandlingInstructions");
        aliasMap.put("shipmentOriginFacilityId", "shipmentOriginFacilityId");
        aliasMap.put("ShipmentOriginFacilityId", "shipmentOriginFacilityId");
        aliasMap.put("shipmentDestinationFacilityId", "shipmentDestinationFacilityId");
        aliasMap.put("ShipmentDestinationFacilityId", "shipmentDestinationFacilityId");
        aliasMap.put("shipmentOriginContactMechId", "shipmentOriginContactMechId");
        aliasMap.put("ShipmentOriginContactMechId", "shipmentOriginContactMechId");
        aliasMap.put("shipmentOriginTelecomNumberId", "shipmentOriginTelecomNumberId");
        aliasMap.put("ShipmentOriginTelecomNumberId", "shipmentOriginTelecomNumberId");
        aliasMap.put("shipmentDestinationContactMechId", "shipmentDestinationContactMechId");
        aliasMap.put("ShipmentDestinationContactMechId", "shipmentDestinationContactMechId");
        aliasMap.put("shipmentDestinationTelecomNumberId", "shipmentDestinationTelecomNumberId");
        aliasMap.put("ShipmentDestinationTelecomNumberId", "shipmentDestinationTelecomNumberId");
        aliasMap.put("shipmentPartyIdTo", "shipmentPartyIdTo");
        aliasMap.put("ShipmentPartyIdTo", "shipmentPartyIdTo");
        aliasMap.put("shipmentPartyIdFrom", "shipmentPartyIdFrom");
        aliasMap.put("ShipmentPartyIdFrom", "shipmentPartyIdFrom");
        aliasMap.put("shipmentAdditionalShippingCharge", "shipmentAdditionalShippingCharge");
        aliasMap.put("ShipmentAdditionalShippingCharge", "shipmentAdditionalShippingCharge");
        aliasMap.put("shipmentAddtlShippingChargeDesc", "shipmentAddtlShippingChargeDesc");
        aliasMap.put("ShipmentAddtlShippingChargeDesc", "shipmentAddtlShippingChargeDesc");
        aliasMap.put("shipmentVersion", "shipmentVersion");
        aliasMap.put("ShipmentVersion", "shipmentVersion");
        aliasMap.put("shipmentCreatedBy", "shipmentCreatedBy");
        aliasMap.put("ShipmentCreatedBy", "shipmentCreatedBy");
        aliasMap.put("shipmentCreatedAt", "shipmentCreatedAt");
        aliasMap.put("ShipmentCreatedAt", "shipmentCreatedAt");
        aliasMap.put("shipmentUpdatedBy", "shipmentUpdatedBy");
        aliasMap.put("ShipmentUpdatedBy", "shipmentUpdatedBy");
        aliasMap.put("shipmentUpdatedAt", "shipmentUpdatedAt");
        aliasMap.put("ShipmentUpdatedAt", "shipmentUpdatedAt");
        aliasMap.put("shipmentActive", "shipmentActive");
        aliasMap.put("ShipmentActive", "shipmentActive");
        aliasMap.put("shipmentItemId.shipmentId", "shipmentItemId.shipmentId");
        aliasMap.put("ShipmentItemId.ShipmentId", "shipmentItemId.shipmentId");
        aliasMap.put("shipmentItemId.shipmentItemSeqId", "shipmentItemId.shipmentItemSeqId");
        aliasMap.put("ShipmentItemId.ShipmentItemSeqId", "shipmentItemId.shipmentItemSeqId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

