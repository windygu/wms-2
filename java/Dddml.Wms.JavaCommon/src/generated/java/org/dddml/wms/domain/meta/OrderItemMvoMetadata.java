package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class OrderItemMvoMetadata {

    private OrderItemMvoMetadata() {
    }

    public static final String PROPERTY_NAME_VERSION      = "orderVersion";
    public static final String PROPERTY_NAME_ACTIVE       = "active";
    public static final String PROPERTY_NAME_DELETED      = "deleted";
    public static final String PROPERTY_NAME_CREATED_BY   = "createdBy";
    public static final String PROPERTY_NAME_CREATED_AT   = "createdAt";
    public static final String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    public static final String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "productId",
            "externalProductId",
            "quantity",
            "cancelQuantity",
            "selectedAmount",
            "externalId",
            "orderItemTypeId",
            "orderItemGroupSeqId",
            "isItemGroupPrimary",
            "fromInventoryItemId",
            "isPromo",
            "quoteId",
            "quoteItemSeqId",
            "shoppingListId",
            "shoppingListItemSeqId",
            "unitPrice",
            "unitListPrice",
            "unitAverageCost",
            "unitRecurringPrice",
            "isModifiedPrice",
            "recurringFreqUomId",
            "itemDescription",
            "comments",
            "correspondingPoId",
            "statusId",
            "syncStatusId",
            "estimatedShipDate",
            "estimatedDeliveryDate",
            "autoCancelDate",
            "dontCancelSetDate",
            "dontCancelSetBy",
            "shipBeforeDate",
            "shipAfterDate",
            "cancelBackOrderDate",
            "overrideGlAccountId",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "orderOrderTypeId",
            "orderOrderName",
            "orderExternalId",
            "orderSalesChannelEnumId",
            "orderOrderDate",
            "orderPriority",
            "orderEntryDate",
            "orderPickSheetPrintedDate",
            "orderStatusId",
            "orderCurrencyUom",
            "orderSyncStatusId",
            "orderBillingAccountId",
            "orderOriginFacilityId",
            "orderWebSiteId",
            "orderProductStoreId",
            "orderTerminalId",
            "orderTransactionId",
            "orderAutoOrderShoppingListId",
            "orderNeedsInventoryIssuance",
            "orderIsRushOrder",
            "orderInternalCode",
            "orderRemainingSubTotal",
            "orderGrandTotal",
            "orderInvoicePerShipment",
            "orderVersion",
            "orderCreatedBy",
            "orderCreatedAt",
            "orderUpdatedBy",
            "orderUpdatedAt",
            "orderActive",
            "orderItemId.orderId",
            "orderItemId.orderItemSeqId",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "String",
            "java.math.BigDecimal",
            "java.math.BigDecimal",
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
            "java.math.BigDecimal",
            "java.math.BigDecimal",
            "java.math.BigDecimal",
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
            "String",
            "java.sql.Timestamp",
            "java.sql.Timestamp",
            "java.sql.Timestamp",
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
        aliasMap.put("externalProductId", "externalProductId");
        aliasMap.put("ExternalProductId", "externalProductId");
        aliasMap.put("quantity", "quantity");
        aliasMap.put("Quantity", "quantity");
        aliasMap.put("cancelQuantity", "cancelQuantity");
        aliasMap.put("CancelQuantity", "cancelQuantity");
        aliasMap.put("selectedAmount", "selectedAmount");
        aliasMap.put("SelectedAmount", "selectedAmount");
        aliasMap.put("externalId", "externalId");
        aliasMap.put("ExternalId", "externalId");
        aliasMap.put("orderItemTypeId", "orderItemTypeId");
        aliasMap.put("OrderItemTypeId", "orderItemTypeId");
        aliasMap.put("orderItemGroupSeqId", "orderItemGroupSeqId");
        aliasMap.put("OrderItemGroupSeqId", "orderItemGroupSeqId");
        aliasMap.put("isItemGroupPrimary", "isItemGroupPrimary");
        aliasMap.put("IsItemGroupPrimary", "isItemGroupPrimary");
        aliasMap.put("fromInventoryItemId", "fromInventoryItemId");
        aliasMap.put("FromInventoryItemId", "fromInventoryItemId");
        aliasMap.put("isPromo", "isPromo");
        aliasMap.put("IsPromo", "isPromo");
        aliasMap.put("quoteId", "quoteId");
        aliasMap.put("QuoteId", "quoteId");
        aliasMap.put("quoteItemSeqId", "quoteItemSeqId");
        aliasMap.put("QuoteItemSeqId", "quoteItemSeqId");
        aliasMap.put("shoppingListId", "shoppingListId");
        aliasMap.put("ShoppingListId", "shoppingListId");
        aliasMap.put("shoppingListItemSeqId", "shoppingListItemSeqId");
        aliasMap.put("ShoppingListItemSeqId", "shoppingListItemSeqId");
        aliasMap.put("unitPrice", "unitPrice");
        aliasMap.put("UnitPrice", "unitPrice");
        aliasMap.put("unitListPrice", "unitListPrice");
        aliasMap.put("UnitListPrice", "unitListPrice");
        aliasMap.put("unitAverageCost", "unitAverageCost");
        aliasMap.put("UnitAverageCost", "unitAverageCost");
        aliasMap.put("unitRecurringPrice", "unitRecurringPrice");
        aliasMap.put("UnitRecurringPrice", "unitRecurringPrice");
        aliasMap.put("isModifiedPrice", "isModifiedPrice");
        aliasMap.put("IsModifiedPrice", "isModifiedPrice");
        aliasMap.put("recurringFreqUomId", "recurringFreqUomId");
        aliasMap.put("RecurringFreqUomId", "recurringFreqUomId");
        aliasMap.put("itemDescription", "itemDescription");
        aliasMap.put("ItemDescription", "itemDescription");
        aliasMap.put("comments", "comments");
        aliasMap.put("Comments", "comments");
        aliasMap.put("correspondingPoId", "correspondingPoId");
        aliasMap.put("CorrespondingPoId", "correspondingPoId");
        aliasMap.put("statusId", "statusId");
        aliasMap.put("StatusId", "statusId");
        aliasMap.put("syncStatusId", "syncStatusId");
        aliasMap.put("SyncStatusId", "syncStatusId");
        aliasMap.put("estimatedShipDate", "estimatedShipDate");
        aliasMap.put("EstimatedShipDate", "estimatedShipDate");
        aliasMap.put("estimatedDeliveryDate", "estimatedDeliveryDate");
        aliasMap.put("EstimatedDeliveryDate", "estimatedDeliveryDate");
        aliasMap.put("autoCancelDate", "autoCancelDate");
        aliasMap.put("AutoCancelDate", "autoCancelDate");
        aliasMap.put("dontCancelSetDate", "dontCancelSetDate");
        aliasMap.put("DontCancelSetDate", "dontCancelSetDate");
        aliasMap.put("dontCancelSetBy", "dontCancelSetBy");
        aliasMap.put("DontCancelSetBy", "dontCancelSetBy");
        aliasMap.put("shipBeforeDate", "shipBeforeDate");
        aliasMap.put("ShipBeforeDate", "shipBeforeDate");
        aliasMap.put("shipAfterDate", "shipAfterDate");
        aliasMap.put("ShipAfterDate", "shipAfterDate");
        aliasMap.put("cancelBackOrderDate", "cancelBackOrderDate");
        aliasMap.put("CancelBackOrderDate", "cancelBackOrderDate");
        aliasMap.put("overrideGlAccountId", "overrideGlAccountId");
        aliasMap.put("OverrideGlAccountId", "overrideGlAccountId");
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
        aliasMap.put("orderOrderTypeId", "orderOrderTypeId");
        aliasMap.put("OrderOrderTypeId", "orderOrderTypeId");
        aliasMap.put("orderOrderName", "orderOrderName");
        aliasMap.put("OrderOrderName", "orderOrderName");
        aliasMap.put("orderExternalId", "orderExternalId");
        aliasMap.put("OrderExternalId", "orderExternalId");
        aliasMap.put("orderSalesChannelEnumId", "orderSalesChannelEnumId");
        aliasMap.put("OrderSalesChannelEnumId", "orderSalesChannelEnumId");
        aliasMap.put("orderOrderDate", "orderOrderDate");
        aliasMap.put("OrderOrderDate", "orderOrderDate");
        aliasMap.put("orderPriority", "orderPriority");
        aliasMap.put("OrderPriority", "orderPriority");
        aliasMap.put("orderEntryDate", "orderEntryDate");
        aliasMap.put("OrderEntryDate", "orderEntryDate");
        aliasMap.put("orderPickSheetPrintedDate", "orderPickSheetPrintedDate");
        aliasMap.put("OrderPickSheetPrintedDate", "orderPickSheetPrintedDate");
        aliasMap.put("orderStatusId", "orderStatusId");
        aliasMap.put("OrderStatusId", "orderStatusId");
        aliasMap.put("orderCurrencyUom", "orderCurrencyUom");
        aliasMap.put("OrderCurrencyUom", "orderCurrencyUom");
        aliasMap.put("orderSyncStatusId", "orderSyncStatusId");
        aliasMap.put("OrderSyncStatusId", "orderSyncStatusId");
        aliasMap.put("orderBillingAccountId", "orderBillingAccountId");
        aliasMap.put("OrderBillingAccountId", "orderBillingAccountId");
        aliasMap.put("orderOriginFacilityId", "orderOriginFacilityId");
        aliasMap.put("OrderOriginFacilityId", "orderOriginFacilityId");
        aliasMap.put("orderWebSiteId", "orderWebSiteId");
        aliasMap.put("OrderWebSiteId", "orderWebSiteId");
        aliasMap.put("orderProductStoreId", "orderProductStoreId");
        aliasMap.put("OrderProductStoreId", "orderProductStoreId");
        aliasMap.put("orderTerminalId", "orderTerminalId");
        aliasMap.put("OrderTerminalId", "orderTerminalId");
        aliasMap.put("orderTransactionId", "orderTransactionId");
        aliasMap.put("OrderTransactionId", "orderTransactionId");
        aliasMap.put("orderAutoOrderShoppingListId", "orderAutoOrderShoppingListId");
        aliasMap.put("OrderAutoOrderShoppingListId", "orderAutoOrderShoppingListId");
        aliasMap.put("orderNeedsInventoryIssuance", "orderNeedsInventoryIssuance");
        aliasMap.put("OrderNeedsInventoryIssuance", "orderNeedsInventoryIssuance");
        aliasMap.put("orderIsRushOrder", "orderIsRushOrder");
        aliasMap.put("OrderIsRushOrder", "orderIsRushOrder");
        aliasMap.put("orderInternalCode", "orderInternalCode");
        aliasMap.put("OrderInternalCode", "orderInternalCode");
        aliasMap.put("orderRemainingSubTotal", "orderRemainingSubTotal");
        aliasMap.put("OrderRemainingSubTotal", "orderRemainingSubTotal");
        aliasMap.put("orderGrandTotal", "orderGrandTotal");
        aliasMap.put("OrderGrandTotal", "orderGrandTotal");
        aliasMap.put("orderInvoicePerShipment", "orderInvoicePerShipment");
        aliasMap.put("OrderInvoicePerShipment", "orderInvoicePerShipment");
        aliasMap.put("orderVersion", "orderVersion");
        aliasMap.put("OrderVersion", "orderVersion");
        aliasMap.put("orderCreatedBy", "orderCreatedBy");
        aliasMap.put("OrderCreatedBy", "orderCreatedBy");
        aliasMap.put("orderCreatedAt", "orderCreatedAt");
        aliasMap.put("OrderCreatedAt", "orderCreatedAt");
        aliasMap.put("orderUpdatedBy", "orderUpdatedBy");
        aliasMap.put("OrderUpdatedBy", "orderUpdatedBy");
        aliasMap.put("orderUpdatedAt", "orderUpdatedAt");
        aliasMap.put("OrderUpdatedAt", "orderUpdatedAt");
        aliasMap.put("orderActive", "orderActive");
        aliasMap.put("OrderActive", "orderActive");
        aliasMap.put("orderItemId.orderId", "orderItemId.orderId");
        aliasMap.put("OrderItemId.OrderId", "orderItemId.orderId");
        aliasMap.put("orderItemId.orderItemSeqId", "orderItemId.orderItemSeqId");
        aliasMap.put("OrderItemId.OrderItemSeqId", "orderItemId.orderItemSeqId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

