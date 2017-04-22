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
            "isSOTransaction",
            "documentStatus",
            "posted",
            "processing",
            "processed",
            "documentType",
            "description",
            "orderNumber",
            "dateOrdered",
            "isPrinted",
            "movementType",
            "movementDate",
            "businessPartnerId",
            "warehouseId",
            "POReference",
            "freightAmount",
            "shipperId",
            "chargeAmount",
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
            "volume",
            "weight",
            "rmaNumber",
            "reversalNumber",
            "isDropShip",
            "dropShipBusinessPartnerId",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "freightAmount.amount",
            "freightAmount.currency",
            "chargeAmount.amount",
            "chargeAmount.currency",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
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
        aliasMap.put("documentNumber", "documentNumber");
        aliasMap.put("DocumentNumber", "documentNumber");
        aliasMap.put("isSOTransaction", "isSOTransaction");
        aliasMap.put("IsSOTransaction", "isSOTransaction");
        aliasMap.put("documentStatus", "documentStatus");
        aliasMap.put("DocumentStatus", "documentStatus");
        aliasMap.put("posted", "posted");
        aliasMap.put("Posted", "posted");
        aliasMap.put("processing", "processing");
        aliasMap.put("Processing", "processing");
        aliasMap.put("processed", "processed");
        aliasMap.put("Processed", "processed");
        aliasMap.put("documentType", "documentType");
        aliasMap.put("DocumentType", "documentType");
        aliasMap.put("description", "description");
        aliasMap.put("Description", "description");
        aliasMap.put("orderNumber", "orderNumber");
        aliasMap.put("OrderNumber", "orderNumber");
        aliasMap.put("dateOrdered", "dateOrdered");
        aliasMap.put("DateOrdered", "dateOrdered");
        aliasMap.put("isPrinted", "isPrinted");
        aliasMap.put("IsPrinted", "isPrinted");
        aliasMap.put("movementType", "movementType");
        aliasMap.put("MovementType", "movementType");
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
        aliasMap.put("volume", "volume");
        aliasMap.put("Volume", "volume");
        aliasMap.put("weight", "weight");
        aliasMap.put("Weight", "weight");
        aliasMap.put("rmaNumber", "rmaNumber");
        aliasMap.put("RmaNumber", "rmaNumber");
        aliasMap.put("reversalNumber", "reversalNumber");
        aliasMap.put("ReversalNumber", "reversalNumber");
        aliasMap.put("isDropShip", "isDropShip");
        aliasMap.put("IsDropShip", "isDropShip");
        aliasMap.put("dropShipBusinessPartnerId", "dropShipBusinessPartnerId");
        aliasMap.put("DropShipBusinessPartnerId", "dropShipBusinessPartnerId");
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
        aliasMap.put("freightAmount.amount", "freightAmount.amount");
        aliasMap.put("FreightAmount.Amount", "freightAmount.amount");
        aliasMap.put("freightAmount.currency", "freightAmount.currency");
        aliasMap.put("FreightAmount.Currency", "freightAmount.currency");
        aliasMap.put("chargeAmount.amount", "chargeAmount.amount");
        aliasMap.put("ChargeAmount.Amount", "chargeAmount.amount");
        aliasMap.put("chargeAmount.currency", "chargeAmount.currency");
        aliasMap.put("ChargeAmount.Currency", "chargeAmount.currency");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

