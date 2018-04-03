package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;


public final class OrderItemShipGroupAssociationMvoMetadata {

    private OrderItemShipGroupAssociationMvoMetadata() {
    }

    String PROPERTY_NAME_VERSION      = "orderVersion";
    String PROPERTY_NAME_ACTIVE       = "active";
    String PROPERTY_NAME_DELETED      = "deleted";
    String PROPERTY_NAME_CREATED_BY   = "createdBy";
    String PROPERTY_NAME_CREATED_AT   = "createdAt";
    String PROPERTY_NAME_UPDATED_BY   = "updatedBy";
    String PROPERTY_NAME_UPDATED_AT   = "updatedAt";

    public static final String[] propertyNames = new String[] {
            "quantity",
            "cancelQuantity",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "orderShipGroupShipmentMethodTypeId",
            "orderShipGroupSupplierPartyId",
            "orderShipGroupVendorPartyId",
            "orderShipGroupCarrierPartyId",
            "orderShipGroupCarrierRoleTypeId",
            "orderShipGroupFacilityId",
            "orderShipGroupContactMechId",
            "orderShipGroupTelecomContactMechId",
            "orderShipGroupTrackingNumber",
            "orderShipGroupShippingInstructions",
            "orderShipGroupMaySplit",
            "orderShipGroupGiftMessage",
            "orderShipGroupIsGift",
            "orderShipGroupShipAfterDate",
            "orderShipGroupShipByDate",
            "orderShipGroupEstimatedShipDate",
            "orderShipGroupEstimatedDeliveryDate",
            "orderShipGroupPickwaveId",
            "orderShipGroupVersion",
            "orderShipGroupCreatedBy",
            "orderShipGroupCreatedAt",
            "orderShipGroupUpdatedBy",
            "orderShipGroupUpdatedAt",
            "orderShipGroupActive",
            "orderShipGroupDeleted",
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
            "orderItemShipGroupAssociationId.orderId",
            "orderItemShipGroupAssociationId.orderShipGroupShipGroupSeqId",
            "orderItemShipGroupAssociationId.orderItemSeqId",
    };

    public static final String[] propertyTypes = new String[] {
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
            "String",
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
            "Long",
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
            "Long",
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
        aliasMap.put("quantity", "quantity");
        aliasMap.put("Quantity", "quantity");
        aliasMap.put("cancelQuantity", "cancelQuantity");
        aliasMap.put("CancelQuantity", "cancelQuantity");
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
        aliasMap.put("orderShipGroupShipmentMethodTypeId", "orderShipGroupShipmentMethodTypeId");
        aliasMap.put("OrderShipGroupShipmentMethodTypeId", "orderShipGroupShipmentMethodTypeId");
        aliasMap.put("orderShipGroupSupplierPartyId", "orderShipGroupSupplierPartyId");
        aliasMap.put("OrderShipGroupSupplierPartyId", "orderShipGroupSupplierPartyId");
        aliasMap.put("orderShipGroupVendorPartyId", "orderShipGroupVendorPartyId");
        aliasMap.put("OrderShipGroupVendorPartyId", "orderShipGroupVendorPartyId");
        aliasMap.put("orderShipGroupCarrierPartyId", "orderShipGroupCarrierPartyId");
        aliasMap.put("OrderShipGroupCarrierPartyId", "orderShipGroupCarrierPartyId");
        aliasMap.put("orderShipGroupCarrierRoleTypeId", "orderShipGroupCarrierRoleTypeId");
        aliasMap.put("OrderShipGroupCarrierRoleTypeId", "orderShipGroupCarrierRoleTypeId");
        aliasMap.put("orderShipGroupFacilityId", "orderShipGroupFacilityId");
        aliasMap.put("OrderShipGroupFacilityId", "orderShipGroupFacilityId");
        aliasMap.put("orderShipGroupContactMechId", "orderShipGroupContactMechId");
        aliasMap.put("OrderShipGroupContactMechId", "orderShipGroupContactMechId");
        aliasMap.put("orderShipGroupTelecomContactMechId", "orderShipGroupTelecomContactMechId");
        aliasMap.put("OrderShipGroupTelecomContactMechId", "orderShipGroupTelecomContactMechId");
        aliasMap.put("orderShipGroupTrackingNumber", "orderShipGroupTrackingNumber");
        aliasMap.put("OrderShipGroupTrackingNumber", "orderShipGroupTrackingNumber");
        aliasMap.put("orderShipGroupShippingInstructions", "orderShipGroupShippingInstructions");
        aliasMap.put("OrderShipGroupShippingInstructions", "orderShipGroupShippingInstructions");
        aliasMap.put("orderShipGroupMaySplit", "orderShipGroupMaySplit");
        aliasMap.put("OrderShipGroupMaySplit", "orderShipGroupMaySplit");
        aliasMap.put("orderShipGroupGiftMessage", "orderShipGroupGiftMessage");
        aliasMap.put("OrderShipGroupGiftMessage", "orderShipGroupGiftMessage");
        aliasMap.put("orderShipGroupIsGift", "orderShipGroupIsGift");
        aliasMap.put("OrderShipGroupIsGift", "orderShipGroupIsGift");
        aliasMap.put("orderShipGroupShipAfterDate", "orderShipGroupShipAfterDate");
        aliasMap.put("OrderShipGroupShipAfterDate", "orderShipGroupShipAfterDate");
        aliasMap.put("orderShipGroupShipByDate", "orderShipGroupShipByDate");
        aliasMap.put("OrderShipGroupShipByDate", "orderShipGroupShipByDate");
        aliasMap.put("orderShipGroupEstimatedShipDate", "orderShipGroupEstimatedShipDate");
        aliasMap.put("OrderShipGroupEstimatedShipDate", "orderShipGroupEstimatedShipDate");
        aliasMap.put("orderShipGroupEstimatedDeliveryDate", "orderShipGroupEstimatedDeliveryDate");
        aliasMap.put("OrderShipGroupEstimatedDeliveryDate", "orderShipGroupEstimatedDeliveryDate");
        aliasMap.put("orderShipGroupPickwaveId", "orderShipGroupPickwaveId");
        aliasMap.put("OrderShipGroupPickwaveId", "orderShipGroupPickwaveId");
        aliasMap.put("orderShipGroupVersion", "orderShipGroupVersion");
        aliasMap.put("OrderShipGroupVersion", "orderShipGroupVersion");
        aliasMap.put("orderShipGroupCreatedBy", "orderShipGroupCreatedBy");
        aliasMap.put("OrderShipGroupCreatedBy", "orderShipGroupCreatedBy");
        aliasMap.put("orderShipGroupCreatedAt", "orderShipGroupCreatedAt");
        aliasMap.put("OrderShipGroupCreatedAt", "orderShipGroupCreatedAt");
        aliasMap.put("orderShipGroupUpdatedBy", "orderShipGroupUpdatedBy");
        aliasMap.put("OrderShipGroupUpdatedBy", "orderShipGroupUpdatedBy");
        aliasMap.put("orderShipGroupUpdatedAt", "orderShipGroupUpdatedAt");
        aliasMap.put("OrderShipGroupUpdatedAt", "orderShipGroupUpdatedAt");
        aliasMap.put("orderShipGroupActive", "orderShipGroupActive");
        aliasMap.put("OrderShipGroupActive", "orderShipGroupActive");
        aliasMap.put("orderShipGroupDeleted", "orderShipGroupDeleted");
        aliasMap.put("OrderShipGroupDeleted", "orderShipGroupDeleted");
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
        aliasMap.put("orderItemShipGroupAssociationId.orderId", "orderItemShipGroupAssociationId.orderId");
        aliasMap.put("OrderItemShipGroupAssociationId.OrderId", "orderItemShipGroupAssociationId.orderId");
        aliasMap.put("orderItemShipGroupAssociationId.orderShipGroupShipGroupSeqId", "orderItemShipGroupAssociationId.orderShipGroupShipGroupSeqId");
        aliasMap.put("OrderItemShipGroupAssociationId.OrderShipGroupShipGroupSeqId", "orderItemShipGroupAssociationId.orderShipGroupShipGroupSeqId");
        aliasMap.put("orderItemShipGroupAssociationId.orderItemSeqId", "orderItemShipGroupAssociationId.orderItemSeqId");
        aliasMap.put("OrderItemShipGroupAssociationId.OrderItemSeqId", "orderItemShipGroupAssociationId.orderItemSeqId");
    }

    private static void initPropertyTypeMap() {
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }

}

