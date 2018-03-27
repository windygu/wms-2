package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class OrderRoleMvoFilteringProperties
{

    private OrderRoleMvoFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
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
            "orderRoleId.orderId",
            "orderRoleId.partyRoleIdPartyId",
            "orderRoleId.partyRoleIdRoleTypeId",
    };

    public static final String[] propertyTypes = new String[] {
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
        aliasMap.put("orderRoleId.orderId", "orderRoleId.orderId");
        aliasMap.put("OrderRoleId.OrderId", "orderRoleId.orderId");
        aliasMap.put("orderRoleId.partyRoleIdPartyId", "orderRoleId.partyRoleIdPartyId");
        aliasMap.put("OrderRoleId.PartyRoleIdPartyId", "orderRoleId.partyRoleIdPartyId");
        aliasMap.put("orderRoleId.partyRoleId.partyId", "orderRoleId.partyRoleIdPartyId");
        aliasMap.put("OrderRoleId.PartyRoleId.PartyId", "orderRoleId.partyRoleIdPartyId");
        aliasMap.put("orderRoleId.partyRoleIdRoleTypeId", "orderRoleId.partyRoleIdRoleTypeId");
        aliasMap.put("OrderRoleId.PartyRoleIdRoleTypeId", "orderRoleId.partyRoleIdRoleTypeId");
        aliasMap.put("orderRoleId.partyRoleId.roleTypeId", "orderRoleId.partyRoleIdRoleTypeId");
        aliasMap.put("OrderRoleId.PartyRoleId.RoleTypeId", "orderRoleId.partyRoleIdRoleTypeId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

