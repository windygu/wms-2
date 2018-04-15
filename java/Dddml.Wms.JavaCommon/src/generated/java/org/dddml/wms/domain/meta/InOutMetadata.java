package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class InOutMetadata {

    private InOutMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "version";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "documentNumber",
            "documentStatusId",
            "posted",
            "processed",
            "processing",
            "documentTypeId",
            "description",
            "orderId",
            "dateOrdered",
            "isPrinted",
            "movementTypeId",
            "movementDate",
            "businessPartnerId",
            "warehouseId",
            "POReference",
            "freightAmount",
            "shipperId",
            "chargeAmount",
            "datePrinted",
            "createdFrom",
            "salesRepresentativeId",
            "numberOfPackages",
            "pickDate",
            "shipDate",
            "trackingNumber",
            "dateReceived",
            "isInTransit",
            "isApproved",
            "isInDispute",
            "rmaDocumentNumber",
            "reversalDocumentNumber",
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
        aliasMap.put("documentNumber", "documentNumber");
        aliasMap.put("DocumentNumber", "documentNumber");
        aliasMap.put("documentStatusId", "documentStatusId");
        aliasMap.put("DocumentStatusId", "documentStatusId");
        aliasMap.put("posted", "posted");
        aliasMap.put("Posted", "posted");
        aliasMap.put("processed", "processed");
        aliasMap.put("Processed", "processed");
        aliasMap.put("processing", "processing");
        aliasMap.put("Processing", "processing");
        aliasMap.put("documentTypeId", "documentTypeId");
        aliasMap.put("DocumentTypeId", "documentTypeId");
        aliasMap.put("description", "description");
        aliasMap.put("Description", "description");
        aliasMap.put("orderId", "orderId");
        aliasMap.put("OrderId", "orderId");
        aliasMap.put("dateOrdered", "dateOrdered");
        aliasMap.put("DateOrdered", "dateOrdered");
        aliasMap.put("isPrinted", "isPrinted");
        aliasMap.put("IsPrinted", "isPrinted");
        aliasMap.put("movementTypeId", "movementTypeId");
        aliasMap.put("MovementTypeId", "movementTypeId");
        aliasMap.put("movementDate", "movementDate");
        aliasMap.put("MovementDate", "movementDate");
        aliasMap.put("businessPartnerId", "businessPartnerId");
        aliasMap.put("BusinessPartnerId", "businessPartnerId");
        aliasMap.put("warehouseId", "warehouseId");
        aliasMap.put("WarehouseId", "warehouseId");
        aliasMap.put("poReference", "poReference");
        aliasMap.put("POReference", "poReference");
        aliasMap.put("freightAmount", "freightAmount");
        aliasMap.put("FreightAmount", "freightAmount");
        aliasMap.put("shipperId", "shipperId");
        aliasMap.put("ShipperId", "shipperId");
        aliasMap.put("chargeAmount", "chargeAmount");
        aliasMap.put("ChargeAmount", "chargeAmount");
        aliasMap.put("datePrinted", "datePrinted");
        aliasMap.put("DatePrinted", "datePrinted");
        aliasMap.put("createdFrom", "createdFrom");
        aliasMap.put("CreatedFrom", "createdFrom");
        aliasMap.put("salesRepresentativeId", "salesRepresentativeId");
        aliasMap.put("SalesRepresentativeId", "salesRepresentativeId");
        aliasMap.put("numberOfPackages", "numberOfPackages");
        aliasMap.put("NumberOfPackages", "numberOfPackages");
        aliasMap.put("pickDate", "pickDate");
        aliasMap.put("PickDate", "pickDate");
        aliasMap.put("shipDate", "shipDate");
        aliasMap.put("ShipDate", "shipDate");
        aliasMap.put("trackingNumber", "trackingNumber");
        aliasMap.put("TrackingNumber", "trackingNumber");
        aliasMap.put("dateReceived", "dateReceived");
        aliasMap.put("DateReceived", "dateReceived");
        aliasMap.put("isInTransit", "isInTransit");
        aliasMap.put("IsInTransit", "isInTransit");
        aliasMap.put("isApproved", "isApproved");
        aliasMap.put("IsApproved", "isApproved");
        aliasMap.put("isInDispute", "isInDispute");
        aliasMap.put("IsInDispute", "isInDispute");
        aliasMap.put("rmaDocumentNumber", "rmaDocumentNumber");
        aliasMap.put("RmaDocumentNumber", "rmaDocumentNumber");
        aliasMap.put("reversalDocumentNumber", "reversalDocumentNumber");
        aliasMap.put("ReversalDocumentNumber", "reversalDocumentNumber");
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

