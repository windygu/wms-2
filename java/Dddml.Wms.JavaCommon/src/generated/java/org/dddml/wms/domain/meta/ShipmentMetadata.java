package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class ShipmentMetadata {

    private ShipmentMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "version";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "shipmentId",
            "shipmentTypeId",
            "statusId",
            "primaryOrderId",
            "primaryReturnId",
            "primaryShipGroupSeqId",
            "onlyOneOrder",
            "onlyOneOrderShipGroup",
            "picklistBinId",
            "bolNumber",
            "sealNumber",
            "vehicleId",
            "externalOrderNumber",
            "carrier",
            "dateShipped",
            "isCreatedFromPackingList",
            "isScheduleNeeded",
            "estimatedReadyDate",
            "estimatedShipDate",
            "estimatedShipWorkEffId",
            "estimatedArrivalDate",
            "estimatedArrivalWorkEffId",
            "latestCancelDate",
            "estimatedShipCost",
            "currencyUomId",
            "handlingInstructions",
            "originFacilityId",
            "destinationFacilityId",
            "originContactMechId",
            "originTelecomNumberId",
            "destinationContactMechId",
            "destinationTelecomNumberId",
            "partyIdTo",
            "partyIdFrom",
            "additionalShippingCharge",
            "addtlShippingChargeDesc",
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
            "Boolean",
            "Boolean",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "java.sql.Timestamp",
            "Boolean",
            "Boolean",
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
        aliasMap.put("shipmentId", "shipmentId");
        aliasMap.put("ShipmentId", "shipmentId");
        aliasMap.put("shipmentTypeId", "shipmentTypeId");
        aliasMap.put("ShipmentTypeId", "shipmentTypeId");
        aliasMap.put("statusId", "statusId");
        aliasMap.put("StatusId", "statusId");
        aliasMap.put("primaryOrderId", "primaryOrderId");
        aliasMap.put("PrimaryOrderId", "primaryOrderId");
        aliasMap.put("primaryReturnId", "primaryReturnId");
        aliasMap.put("PrimaryReturnId", "primaryReturnId");
        aliasMap.put("primaryShipGroupSeqId", "primaryShipGroupSeqId");
        aliasMap.put("PrimaryShipGroupSeqId", "primaryShipGroupSeqId");
        aliasMap.put("onlyOneOrder", "onlyOneOrder");
        aliasMap.put("OnlyOneOrder", "onlyOneOrder");
        aliasMap.put("onlyOneOrderShipGroup", "onlyOneOrderShipGroup");
        aliasMap.put("OnlyOneOrderShipGroup", "onlyOneOrderShipGroup");
        aliasMap.put("picklistBinId", "picklistBinId");
        aliasMap.put("PicklistBinId", "picklistBinId");
        aliasMap.put("bolNumber", "bolNumber");
        aliasMap.put("BolNumber", "bolNumber");
        aliasMap.put("sealNumber", "sealNumber");
        aliasMap.put("SealNumber", "sealNumber");
        aliasMap.put("vehicleId", "vehicleId");
        aliasMap.put("VehicleId", "vehicleId");
        aliasMap.put("externalOrderNumber", "externalOrderNumber");
        aliasMap.put("ExternalOrderNumber", "externalOrderNumber");
        aliasMap.put("carrier", "carrier");
        aliasMap.put("Carrier", "carrier");
        aliasMap.put("dateShipped", "dateShipped");
        aliasMap.put("DateShipped", "dateShipped");
        aliasMap.put("isCreatedFromPackingList", "isCreatedFromPackingList");
        aliasMap.put("IsCreatedFromPackingList", "isCreatedFromPackingList");
        aliasMap.put("isScheduleNeeded", "isScheduleNeeded");
        aliasMap.put("IsScheduleNeeded", "isScheduleNeeded");
        aliasMap.put("estimatedReadyDate", "estimatedReadyDate");
        aliasMap.put("EstimatedReadyDate", "estimatedReadyDate");
        aliasMap.put("estimatedShipDate", "estimatedShipDate");
        aliasMap.put("EstimatedShipDate", "estimatedShipDate");
        aliasMap.put("estimatedShipWorkEffId", "estimatedShipWorkEffId");
        aliasMap.put("EstimatedShipWorkEffId", "estimatedShipWorkEffId");
        aliasMap.put("estimatedArrivalDate", "estimatedArrivalDate");
        aliasMap.put("EstimatedArrivalDate", "estimatedArrivalDate");
        aliasMap.put("estimatedArrivalWorkEffId", "estimatedArrivalWorkEffId");
        aliasMap.put("EstimatedArrivalWorkEffId", "estimatedArrivalWorkEffId");
        aliasMap.put("latestCancelDate", "latestCancelDate");
        aliasMap.put("LatestCancelDate", "latestCancelDate");
        aliasMap.put("estimatedShipCost", "estimatedShipCost");
        aliasMap.put("EstimatedShipCost", "estimatedShipCost");
        aliasMap.put("currencyUomId", "currencyUomId");
        aliasMap.put("CurrencyUomId", "currencyUomId");
        aliasMap.put("handlingInstructions", "handlingInstructions");
        aliasMap.put("HandlingInstructions", "handlingInstructions");
        aliasMap.put("originFacilityId", "originFacilityId");
        aliasMap.put("OriginFacilityId", "originFacilityId");
        aliasMap.put("destinationFacilityId", "destinationFacilityId");
        aliasMap.put("DestinationFacilityId", "destinationFacilityId");
        aliasMap.put("originContactMechId", "originContactMechId");
        aliasMap.put("OriginContactMechId", "originContactMechId");
        aliasMap.put("originTelecomNumberId", "originTelecomNumberId");
        aliasMap.put("OriginTelecomNumberId", "originTelecomNumberId");
        aliasMap.put("destinationContactMechId", "destinationContactMechId");
        aliasMap.put("DestinationContactMechId", "destinationContactMechId");
        aliasMap.put("destinationTelecomNumberId", "destinationTelecomNumberId");
        aliasMap.put("DestinationTelecomNumberId", "destinationTelecomNumberId");
        aliasMap.put("partyIdTo", "partyIdTo");
        aliasMap.put("PartyIdTo", "partyIdTo");
        aliasMap.put("partyIdFrom", "partyIdFrom");
        aliasMap.put("PartyIdFrom", "partyIdFrom");
        aliasMap.put("additionalShippingCharge", "additionalShippingCharge");
        aliasMap.put("AdditionalShippingCharge", "additionalShippingCharge");
        aliasMap.put("addtlShippingChargeDesc", "addtlShippingChargeDesc");
        aliasMap.put("AddtlShippingChargeDesc", "addtlShippingChargeDesc");
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

