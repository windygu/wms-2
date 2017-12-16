package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class InOutFilteringProperties
{

    private InOutFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "documentNumber",
            "documentStatus",
            "posted",
            "processing",
            "processed",
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
            "shipperId",
            "datePrinted",
            "salesRepresentative",
            "numberOfPackages",
            "pickDate",
            "shipDate",
            "trackingNumber",
            "dateReceived",
            "isInTransit",
            "isApproved",
            "isInDispute",
            "rmaNumber",
            "reversalNumber",
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
            "Boolean",
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
            "String",
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
        aliasMap.put("documentStatus", "documentStatus");
        aliasMap.put("DocumentStatus", "documentStatus");
        aliasMap.put("posted", "posted");
        aliasMap.put("Posted", "posted");
        aliasMap.put("processing", "processing");
        aliasMap.put("Processing", "processing");
        aliasMap.put("processed", "processed");
        aliasMap.put("Processed", "processed");
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
        aliasMap.put("shipperId", "shipperId");
        aliasMap.put("ShipperId", "shipperId");
        aliasMap.put("datePrinted", "datePrinted");
        aliasMap.put("DatePrinted", "datePrinted");
        aliasMap.put("salesRepresentative", "salesRepresentative");
        aliasMap.put("SalesRepresentative", "salesRepresentative");
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
        aliasMap.put("rmaNumber", "rmaNumber");
        aliasMap.put("RmaNumber", "rmaNumber");
        aliasMap.put("reversalNumber", "reversalNumber");
        aliasMap.put("ReversalNumber", "reversalNumber");
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

