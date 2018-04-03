package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class InOutLineMvoMetadata {

    private InOutLineMvoMetadata() {
    }

    String PROPERTY_NAME_VERSION      = "inOutVersion";
    String PROPERTY_NAME_ACTIVE       = "active";
    String PROPERTY_NAME_DELETED      = "deleted";
    String PROPERTY_NAME_CREATED_BY   = "createdBy";
    String PROPERTY_NAME_CREATED_AT   = "createdAt";
    String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "locatorId",
            "productId",
            "attributeSetInstanceId",
            "description",
            "quantityUomId",
            "movementQuantity",
            "pickedQuantity",
            "isInvoiced",
            "processed",
            "rmaLineNumber",
            "reversalLineNumber",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "inOutDocumentStatusId",
            "inOutPosted",
            "inOutProcessed",
            "inOutProcessing",
            "inOutDocumentTypeId",
            "inOutDescription",
            "inOutOrderId",
            "inOutDateOrdered",
            "inOutIsPrinted",
            "inOutMovementTypeId",
            "inOutMovementDate",
            "inOutBusinessPartnerId",
            "inOutWarehouseId",
            "inOutPOReference",
            "inOutFreightAmount",
            "inOutShipperId",
            "inOutChargeAmount",
            "inOutDatePrinted",
            "inOutCreatedFrom",
            "inOutSalesRepresentativeId",
            "inOutNumberOfPackages",
            "inOutPickDate",
            "inOutShipDate",
            "inOutTrackingNumber",
            "inOutDateReceived",
            "inOutIsInTransit",
            "inOutIsApproved",
            "inOutIsInDispute",
            "inOutRmaDocumentNumber",
            "inOutReversalDocumentNumber",
            "inOutVersion",
            "inOutCreatedBy",
            "inOutCreatedAt",
            "inOutUpdatedBy",
            "inOutUpdatedAt",
            "inOutActive",
            "inOutLineId.inOutDocumentNumber",
            "inOutLineId.lineNumber",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "String",
            "String",
            "String",
            "String",
            "BigDecimal",
            "BigDecimal",
            "Boolean",
            "Boolean",
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
            "Boolean",
            "Boolean",
            "String",
            "String",
            "String",
            "String",
            "Date",
            "Boolean",
            "String",
            "Date",
            "String",
            "String",
            "String",
            "BigDecimal",
            "String",
            "BigDecimal",
            "Date",
            "String",
            "String",
            "Integer",
            "Date",
            "Date",
            "String",
            "Date",
            "Boolean",
            "Boolean",
            "Boolean",
            "String",
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
        aliasMap.put("locatorId", "locatorId");
        aliasMap.put("LocatorId", "locatorId");
        aliasMap.put("productId", "productId");
        aliasMap.put("ProductId", "productId");
        aliasMap.put("attributeSetInstanceId", "attributeSetInstanceId");
        aliasMap.put("AttributeSetInstanceId", "attributeSetInstanceId");
        aliasMap.put("description", "description");
        aliasMap.put("Description", "description");
        aliasMap.put("quantityUomId", "quantityUomId");
        aliasMap.put("QuantityUomId", "quantityUomId");
        aliasMap.put("movementQuantity", "movementQuantity");
        aliasMap.put("MovementQuantity", "movementQuantity");
        aliasMap.put("pickedQuantity", "pickedQuantity");
        aliasMap.put("PickedQuantity", "pickedQuantity");
        aliasMap.put("isInvoiced", "isInvoiced");
        aliasMap.put("IsInvoiced", "isInvoiced");
        aliasMap.put("processed", "processed");
        aliasMap.put("Processed", "processed");
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
        aliasMap.put("inOutDocumentStatusId", "inOutDocumentStatusId");
        aliasMap.put("InOutDocumentStatusId", "inOutDocumentStatusId");
        aliasMap.put("inOutPosted", "inOutPosted");
        aliasMap.put("InOutPosted", "inOutPosted");
        aliasMap.put("inOutProcessed", "inOutProcessed");
        aliasMap.put("InOutProcessed", "inOutProcessed");
        aliasMap.put("inOutProcessing", "inOutProcessing");
        aliasMap.put("InOutProcessing", "inOutProcessing");
        aliasMap.put("inOutDocumentTypeId", "inOutDocumentTypeId");
        aliasMap.put("InOutDocumentTypeId", "inOutDocumentTypeId");
        aliasMap.put("inOutDescription", "inOutDescription");
        aliasMap.put("InOutDescription", "inOutDescription");
        aliasMap.put("inOutOrderId", "inOutOrderId");
        aliasMap.put("InOutOrderId", "inOutOrderId");
        aliasMap.put("inOutDateOrdered", "inOutDateOrdered");
        aliasMap.put("InOutDateOrdered", "inOutDateOrdered");
        aliasMap.put("inOutIsPrinted", "inOutIsPrinted");
        aliasMap.put("InOutIsPrinted", "inOutIsPrinted");
        aliasMap.put("inOutMovementTypeId", "inOutMovementTypeId");
        aliasMap.put("InOutMovementTypeId", "inOutMovementTypeId");
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
        aliasMap.put("inOutCreatedFrom", "inOutCreatedFrom");
        aliasMap.put("InOutCreatedFrom", "inOutCreatedFrom");
        aliasMap.put("inOutSalesRepresentativeId", "inOutSalesRepresentativeId");
        aliasMap.put("InOutSalesRepresentativeId", "inOutSalesRepresentativeId");
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
        aliasMap.put("inOutRmaDocumentNumber", "inOutRmaDocumentNumber");
        aliasMap.put("InOutRmaDocumentNumber", "inOutRmaDocumentNumber");
        aliasMap.put("inOutReversalDocumentNumber", "inOutReversalDocumentNumber");
        aliasMap.put("InOutReversalDocumentNumber", "inOutReversalDocumentNumber");
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
        aliasMap.put("inOutLineId.inOutDocumentNumber", "inOutLineId.inOutDocumentNumber");
        aliasMap.put("InOutLineId.InOutDocumentNumber", "inOutLineId.inOutDocumentNumber");
        aliasMap.put("inOutLineId.lineNumber", "inOutLineId.lineNumber");
        aliasMap.put("InOutLineId.LineNumber", "inOutLineId.lineNumber");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

