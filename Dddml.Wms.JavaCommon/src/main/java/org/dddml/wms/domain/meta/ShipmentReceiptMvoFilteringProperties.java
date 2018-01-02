package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class ShipmentReceiptMvoFilteringProperties
{

    private ShipmentReceiptMvoFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "productId",
            "shipmentItemSeqId",
            "rejectionReasonId",
            "damageStatusId",
            "damageReasonId",
            "itemDescription",
            "acceptedQuantity",
            "rejectedQuantity",
            "damagedQuantity",
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
            "shipmentReceiptId.shipmentId",
            "shipmentReceiptId.receiptSeqId",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
            "java.math.BigDecimal",
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
            "String",
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
        aliasMap.put("shipmentItemSeqId", "shipmentItemSeqId");
        aliasMap.put("ShipmentItemSeqId", "shipmentItemSeqId");
        aliasMap.put("rejectionReasonId", "rejectionReasonId");
        aliasMap.put("RejectionReasonId", "rejectionReasonId");
        aliasMap.put("damageStatusId", "damageStatusId");
        aliasMap.put("DamageStatusId", "damageStatusId");
        aliasMap.put("damageReasonId", "damageReasonId");
        aliasMap.put("DamageReasonId", "damageReasonId");
        aliasMap.put("itemDescription", "itemDescription");
        aliasMap.put("ItemDescription", "itemDescription");
        aliasMap.put("acceptedQuantity", "acceptedQuantity");
        aliasMap.put("AcceptedQuantity", "acceptedQuantity");
        aliasMap.put("rejectedQuantity", "rejectedQuantity");
        aliasMap.put("RejectedQuantity", "rejectedQuantity");
        aliasMap.put("damagedQuantity", "damagedQuantity");
        aliasMap.put("DamagedQuantity", "damagedQuantity");
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
        aliasMap.put("shipmentReceiptId.shipmentId", "shipmentReceiptId.shipmentId");
        aliasMap.put("ShipmentReceiptId.ShipmentId", "shipmentReceiptId.shipmentId");
        aliasMap.put("shipmentReceiptId.receiptSeqId", "shipmentReceiptId.receiptSeqId");
        aliasMap.put("ShipmentReceiptId.ReceiptSeqId", "shipmentReceiptId.receiptSeqId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

