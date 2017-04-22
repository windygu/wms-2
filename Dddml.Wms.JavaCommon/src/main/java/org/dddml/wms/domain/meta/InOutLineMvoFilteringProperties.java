package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class InOutLineMvoFilteringProperties
{

    private InOutLineMvoFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "description",
            "locatorId",
            "productId",
            "uomId",
            "movementQuantity",
            "confirmedQuantity",
            "scrappedQuantity",
            "targetQuantity",
            "pickedQuantity",
            "isInvoiced",
            "attributeSetInstanceId",
            "isDescription",
            "processed",
            "quantityEntered",
            "rmaLineNumber",
            "reversalLineNumber",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "inOutIsSOTransaction",
            "inOutDocumentStatus",
            "inOutPosted",
            "inOutProcessing",
            "inOutProcessed",
            "inOutDocumentType",
            "inOutDescription",
            "inOutOrderNumber",
            "inOutDateOrdered",
            "inOutIsPrinted",
            "inOutMovementType",
            "inOutMovementDate",
            "inOutBusinessPartnerId",
            "inOutWarehouseId",
            "inOutPOReference",
            "inOutFreightAmount",
            "inOutShipperId",
            "inOutChargeAmount",
            "inOutDatePrinted",
            "inOutSalesRepresentative",
            "inOutNumberOfPackages",
            "inOutPickDate",
            "inOutShipDate",
            "inOutTrackingNumber",
            "inOutDateReceived",
            "inOutIsInTransit",
            "inOutIsApproved",
            "inOutIsInDispute",
            "inOutVolume",
            "inOutWeight",
            "inOutRmaNumber",
            "inOutReversalNumber",
            "inOutIsDropShip",
            "inOutDropShipBusinessPartnerId",
            "inOutVersion",
            "inOutCreatedBy",
            "inOutCreatedAt",
            "inOutUpdatedBy",
            "inOutUpdatedAt",
            "inOutActive",
            "inOutDeleted",
            "inOutLineId.inOutDocumentNumber",
            "inOutLineId.lineNumber",
            "inOutFreightAmount.amount",
            "inOutFreightAmount.currency",
            "inOutChargeAmount.amount",
            "inOutChargeAmount.currency",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "String",
            "String",
            "String",
            "BigDecimal",
            "BigDecimal",
            "BigDecimal",
            "BigDecimal",
            "BigDecimal",
            "Boolean",
            "String",
            "Boolean",
            "Boolean",
            "BigDecimal",
            "Long",
            "Long",
            "Long",
            "String",
            "Date",
            "String",
            "Date",
            "Boolean",
            "Boolean",
            "Boolean",
            "String",
            "Boolean",
            "Boolean",
            "Boolean",
            "Integer",
            "String",
            "String",
            "Date",
            "Boolean",
            "String",
            "Date",
            "String",
            "String",
            "String",
            "Money",
            "String",
            "Money",
            "Date",
            "String",
            "Integer",
            "Date",
            "Date",
            "String",
            "Date",
            "Boolean",
            "Boolean",
            "Boolean",
            "BigDecimal",
            "BigDecimal",
            "String",
            "String",
            "Boolean",
            "String",
            "Long",
            "String",
            "Date",
            "String",
            "Date",
            "Boolean",
            "Boolean",
            "String",
            "Long",
            "BigDecimal",
            "String",
            "BigDecimal",
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
        aliasMap.put("description", "description");
        aliasMap.put("Description", "description");
        aliasMap.put("locatorId", "locatorId");
        aliasMap.put("LocatorId", "locatorId");
        aliasMap.put("productId", "productId");
        aliasMap.put("ProductId", "productId");
        aliasMap.put("uomId", "uomId");
        aliasMap.put("UomId", "uomId");
        aliasMap.put("movementQuantity", "movementQuantity");
        aliasMap.put("MovementQuantity", "movementQuantity");
        aliasMap.put("confirmedQuantity", "confirmedQuantity");
        aliasMap.put("ConfirmedQuantity", "confirmedQuantity");
        aliasMap.put("scrappedQuantity", "scrappedQuantity");
        aliasMap.put("ScrappedQuantity", "scrappedQuantity");
        aliasMap.put("targetQuantity", "targetQuantity");
        aliasMap.put("TargetQuantity", "targetQuantity");
        aliasMap.put("pickedQuantity", "pickedQuantity");
        aliasMap.put("PickedQuantity", "pickedQuantity");
        aliasMap.put("isInvoiced", "isInvoiced");
        aliasMap.put("IsInvoiced", "isInvoiced");
        aliasMap.put("attributeSetInstanceId", "attributeSetInstanceId");
        aliasMap.put("AttributeSetInstanceId", "attributeSetInstanceId");
        aliasMap.put("isDescription", "isDescription");
        aliasMap.put("IsDescription", "isDescription");
        aliasMap.put("processed", "processed");
        aliasMap.put("Processed", "processed");
        aliasMap.put("quantityEntered", "quantityEntered");
        aliasMap.put("QuantityEntered", "quantityEntered");
        aliasMap.put("rmaLineNumber", "rmaLineNumber");
        aliasMap.put("RmaLineNumber", "rmaLineNumber");
        aliasMap.put("reversalLineNumber", "reversalLineNumber");
        aliasMap.put("ReversalLineNumber", "reversalLineNumber");
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
        aliasMap.put("inOutIsSOTransaction", "inOutIsSOTransaction");
        aliasMap.put("InOutIsSOTransaction", "inOutIsSOTransaction");
        aliasMap.put("inOutDocumentStatus", "inOutDocumentStatus");
        aliasMap.put("InOutDocumentStatus", "inOutDocumentStatus");
        aliasMap.put("inOutPosted", "inOutPosted");
        aliasMap.put("InOutPosted", "inOutPosted");
        aliasMap.put("inOutProcessing", "inOutProcessing");
        aliasMap.put("InOutProcessing", "inOutProcessing");
        aliasMap.put("inOutProcessed", "inOutProcessed");
        aliasMap.put("InOutProcessed", "inOutProcessed");
        aliasMap.put("inOutDocumentType", "inOutDocumentType");
        aliasMap.put("InOutDocumentType", "inOutDocumentType");
        aliasMap.put("inOutDescription", "inOutDescription");
        aliasMap.put("InOutDescription", "inOutDescription");
        aliasMap.put("inOutOrderNumber", "inOutOrderNumber");
        aliasMap.put("InOutOrderNumber", "inOutOrderNumber");
        aliasMap.put("inOutDateOrdered", "inOutDateOrdered");
        aliasMap.put("InOutDateOrdered", "inOutDateOrdered");
        aliasMap.put("inOutIsPrinted", "inOutIsPrinted");
        aliasMap.put("InOutIsPrinted", "inOutIsPrinted");
        aliasMap.put("inOutMovementType", "inOutMovementType");
        aliasMap.put("InOutMovementType", "inOutMovementType");
        aliasMap.put("inOutMovementDate", "inOutMovementDate");
        aliasMap.put("InOutMovementDate", "inOutMovementDate");
        aliasMap.put("inOutBusinessPartnerId", "inOutBusinessPartnerId");
        aliasMap.put("InOutBusinessPartnerId", "inOutBusinessPartnerId");
        aliasMap.put("inOutWarehouseId", "inOutWarehouseId");
        aliasMap.put("InOutWarehouseId", "inOutWarehouseId");
        aliasMap.put("inOutPOReference", "inOutPOReference");
        aliasMap.put("InOutPOReference", "inOutPOReference");
        aliasMap.put("inOutFreightAmount", "inOutFreightAmount");
        aliasMap.put("InOutFreightAmount", "inOutFreightAmount");
        aliasMap.put("inOutShipperId", "inOutShipperId");
        aliasMap.put("InOutShipperId", "inOutShipperId");
        aliasMap.put("inOutChargeAmount", "inOutChargeAmount");
        aliasMap.put("InOutChargeAmount", "inOutChargeAmount");
        aliasMap.put("inOutDatePrinted", "inOutDatePrinted");
        aliasMap.put("InOutDatePrinted", "inOutDatePrinted");
        aliasMap.put("inOutSalesRepresentative", "inOutSalesRepresentative");
        aliasMap.put("InOutSalesRepresentative", "inOutSalesRepresentative");
        aliasMap.put("inOutNumberOfPackages", "inOutNumberOfPackages");
        aliasMap.put("InOutNumberOfPackages", "inOutNumberOfPackages");
        aliasMap.put("inOutPickDate", "inOutPickDate");
        aliasMap.put("InOutPickDate", "inOutPickDate");
        aliasMap.put("inOutShipDate", "inOutShipDate");
        aliasMap.put("InOutShipDate", "inOutShipDate");
        aliasMap.put("inOutTrackingNumber", "inOutTrackingNumber");
        aliasMap.put("InOutTrackingNumber", "inOutTrackingNumber");
        aliasMap.put("inOutDateReceived", "inOutDateReceived");
        aliasMap.put("InOutDateReceived", "inOutDateReceived");
        aliasMap.put("inOutIsInTransit", "inOutIsInTransit");
        aliasMap.put("InOutIsInTransit", "inOutIsInTransit");
        aliasMap.put("inOutIsApproved", "inOutIsApproved");
        aliasMap.put("InOutIsApproved", "inOutIsApproved");
        aliasMap.put("inOutIsInDispute", "inOutIsInDispute");
        aliasMap.put("InOutIsInDispute", "inOutIsInDispute");
        aliasMap.put("inOutVolume", "inOutVolume");
        aliasMap.put("InOutVolume", "inOutVolume");
        aliasMap.put("inOutWeight", "inOutWeight");
        aliasMap.put("InOutWeight", "inOutWeight");
        aliasMap.put("inOutRmaNumber", "inOutRmaNumber");
        aliasMap.put("InOutRmaNumber", "inOutRmaNumber");
        aliasMap.put("inOutReversalNumber", "inOutReversalNumber");
        aliasMap.put("InOutReversalNumber", "inOutReversalNumber");
        aliasMap.put("inOutIsDropShip", "inOutIsDropShip");
        aliasMap.put("InOutIsDropShip", "inOutIsDropShip");
        aliasMap.put("inOutDropShipBusinessPartnerId", "inOutDropShipBusinessPartnerId");
        aliasMap.put("InOutDropShipBusinessPartnerId", "inOutDropShipBusinessPartnerId");
        aliasMap.put("inOutVersion", "inOutVersion");
        aliasMap.put("InOutVersion", "inOutVersion");
        aliasMap.put("inOutCreatedBy", "inOutCreatedBy");
        aliasMap.put("InOutCreatedBy", "inOutCreatedBy");
        aliasMap.put("inOutCreatedAt", "inOutCreatedAt");
        aliasMap.put("InOutCreatedAt", "inOutCreatedAt");
        aliasMap.put("inOutUpdatedBy", "inOutUpdatedBy");
        aliasMap.put("InOutUpdatedBy", "inOutUpdatedBy");
        aliasMap.put("inOutUpdatedAt", "inOutUpdatedAt");
        aliasMap.put("InOutUpdatedAt", "inOutUpdatedAt");
        aliasMap.put("inOutActive", "inOutActive");
        aliasMap.put("InOutActive", "inOutActive");
        aliasMap.put("inOutDeleted", "inOutDeleted");
        aliasMap.put("InOutDeleted", "inOutDeleted");
        aliasMap.put("inOutLineId.inOutDocumentNumber", "inOutLineId.inOutDocumentNumber");
        aliasMap.put("InOutLineId.InOutDocumentNumber", "inOutLineId.inOutDocumentNumber");
        aliasMap.put("inOutLineId.lineNumber", "inOutLineId.lineNumber");
        aliasMap.put("InOutLineId.LineNumber", "inOutLineId.lineNumber");
        aliasMap.put("inOutFreightAmount.amount", "inOutFreightAmount.amount");
        aliasMap.put("InOutFreightAmount.Amount", "inOutFreightAmount.amount");
        aliasMap.put("inOutFreightAmount.currency", "inOutFreightAmount.currency");
        aliasMap.put("InOutFreightAmount.Currency", "inOutFreightAmount.currency");
        aliasMap.put("inOutChargeAmount.amount", "inOutChargeAmount.amount");
        aliasMap.put("InOutChargeAmount.Amount", "inOutChargeAmount.amount");
        aliasMap.put("inOutChargeAmount.currency", "inOutChargeAmount.currency");
        aliasMap.put("InOutChargeAmount.Currency", "inOutChargeAmount.currency");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

