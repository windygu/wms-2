package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class OrderMetadata {

    private OrderMetadata() {
    }

    String PROPERTY_NAME_VERSION      = "version";
    String PROPERTY_NAME_ACTIVE       = "active";
    String PROPERTY_NAME_DELETED      = "deleted";
    String PROPERTY_NAME_CREATED_BY   = "createdBy";
    String PROPERTY_NAME_CREATED_AT   = "createdAt";
    String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "orderId",
            "orderTypeId",
            "orderName",
            "externalId",
            "salesChannelEnumId",
            "orderDate",
            "priority",
            "entryDate",
            "pickSheetPrintedDate",
            "statusId",
            "currencyUom",
            "syncStatusId",
            "billingAccountId",
            "originFacilityId",
            "webSiteId",
            "productStoreId",
            "terminalId",
            "transactionId",
            "autoOrderShoppingListId",
            "needsInventoryIssuance",
            "isRushOrder",
            "internalCode",
            "remainingSubTotal",
            "grandTotal",
            "invoicePerShipment",
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
            "java.sql.Timestamp",
            "String",
            "java.sql.Timestamp",
            "java.sql.Timestamp",
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
            "java.math.BigDecimal",
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
        aliasMap.put("orderId", "orderId");
        aliasMap.put("OrderId", "orderId");
        aliasMap.put("orderTypeId", "orderTypeId");
        aliasMap.put("OrderTypeId", "orderTypeId");
        aliasMap.put("orderName", "orderName");
        aliasMap.put("OrderName", "orderName");
        aliasMap.put("externalId", "externalId");
        aliasMap.put("ExternalId", "externalId");
        aliasMap.put("salesChannelEnumId", "salesChannelEnumId");
        aliasMap.put("SalesChannelEnumId", "salesChannelEnumId");
        aliasMap.put("orderDate", "orderDate");
        aliasMap.put("OrderDate", "orderDate");
        aliasMap.put("priority", "priority");
        aliasMap.put("Priority", "priority");
        aliasMap.put("entryDate", "entryDate");
        aliasMap.put("EntryDate", "entryDate");
        aliasMap.put("pickSheetPrintedDate", "pickSheetPrintedDate");
        aliasMap.put("PickSheetPrintedDate", "pickSheetPrintedDate");
        aliasMap.put("statusId", "statusId");
        aliasMap.put("StatusId", "statusId");
        aliasMap.put("currencyUom", "currencyUom");
        aliasMap.put("CurrencyUom", "currencyUom");
        aliasMap.put("syncStatusId", "syncStatusId");
        aliasMap.put("SyncStatusId", "syncStatusId");
        aliasMap.put("billingAccountId", "billingAccountId");
        aliasMap.put("BillingAccountId", "billingAccountId");
        aliasMap.put("originFacilityId", "originFacilityId");
        aliasMap.put("OriginFacilityId", "originFacilityId");
        aliasMap.put("webSiteId", "webSiteId");
        aliasMap.put("WebSiteId", "webSiteId");
        aliasMap.put("productStoreId", "productStoreId");
        aliasMap.put("ProductStoreId", "productStoreId");
        aliasMap.put("terminalId", "terminalId");
        aliasMap.put("TerminalId", "terminalId");
        aliasMap.put("transactionId", "transactionId");
        aliasMap.put("TransactionId", "transactionId");
        aliasMap.put("autoOrderShoppingListId", "autoOrderShoppingListId");
        aliasMap.put("AutoOrderShoppingListId", "autoOrderShoppingListId");
        aliasMap.put("needsInventoryIssuance", "needsInventoryIssuance");
        aliasMap.put("NeedsInventoryIssuance", "needsInventoryIssuance");
        aliasMap.put("isRushOrder", "isRushOrder");
        aliasMap.put("IsRushOrder", "isRushOrder");
        aliasMap.put("internalCode", "internalCode");
        aliasMap.put("InternalCode", "internalCode");
        aliasMap.put("remainingSubTotal", "remainingSubTotal");
        aliasMap.put("RemainingSubTotal", "remainingSubTotal");
        aliasMap.put("grandTotal", "grandTotal");
        aliasMap.put("GrandTotal", "grandTotal");
        aliasMap.put("invoicePerShipment", "invoicePerShipment");
        aliasMap.put("InvoicePerShipment", "invoicePerShipment");
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

