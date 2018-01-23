package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class OrderItemFilteringProperties {

    private OrderItemFilteringProperties() {
    }

    public static final String[] propertyNames = new String[]{
            "orderItemSeqId",
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
            "orderId",
            "orderItemId.orderId",
            "orderItemId.orderItemSeqId",
    };

    public static final String[] propertyTypes = new String[]{
            "String",
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
    };

    public static final Map<String, String> propertyTypeMap;

    public static final Map<String, String> aliasMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        initPropertyTypeMap();
        aliasMap = new HashMap<String, String>();
        initAliasMap();
    }

    private static void initAliasMap() {
        aliasMap.put("orderItemSeqId", "orderItemId.orderItemSeqId");
        aliasMap.put("OrderItemSeqId", "orderItemId.orderItemSeqId");
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
        aliasMap.put("orderId", "orderItemId.orderId");
        aliasMap.put("OrderId", "orderItemId.orderId");
        aliasMap.put("orderItemId.orderId", "orderItemId.orderId");
        aliasMap.put("OrderItemId.OrderId", "orderItemId.orderId");
        aliasMap.put("orderItemId.orderItemSeqId", "orderItemId.orderItemSeqId");
        aliasMap.put("OrderItemId.OrderItemSeqId", "orderItemId.orderItemSeqId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

