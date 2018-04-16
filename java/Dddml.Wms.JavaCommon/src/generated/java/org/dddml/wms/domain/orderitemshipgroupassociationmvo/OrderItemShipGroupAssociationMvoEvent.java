package org.dddml.wms.domain.orderitemshipgroupassociationmvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface OrderItemShipGroupAssociationMvoEvent extends Event
{
    OrderItemShipGroupAssociationMvoEventId getOrderItemShipGroupAssociationMvoEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface OrderItemShipGroupAssociationMvoStateEvent extends OrderItemShipGroupAssociationMvoEvent {
        java.math.BigDecimal getQuantity();

        void setQuantity(java.math.BigDecimal quantity);

        java.math.BigDecimal getCancelQuantity();

        void setCancelQuantity(java.math.BigDecimal cancelQuantity);

        Long getVersion();

        void setVersion(Long version);

        Boolean getActive();

        void setActive(Boolean active);

        String getOrderShipGroupShipmentMethodTypeId();

        void setOrderShipGroupShipmentMethodTypeId(String orderShipGroupShipmentMethodTypeId);

        String getOrderShipGroupSupplierPartyId();

        void setOrderShipGroupSupplierPartyId(String orderShipGroupSupplierPartyId);

        String getOrderShipGroupVendorPartyId();

        void setOrderShipGroupVendorPartyId(String orderShipGroupVendorPartyId);

        String getOrderShipGroupCarrierPartyId();

        void setOrderShipGroupCarrierPartyId(String orderShipGroupCarrierPartyId);

        String getOrderShipGroupCarrierRoleTypeId();

        void setOrderShipGroupCarrierRoleTypeId(String orderShipGroupCarrierRoleTypeId);

        String getOrderShipGroupFacilityId();

        void setOrderShipGroupFacilityId(String orderShipGroupFacilityId);

        String getOrderShipGroupContactMechId();

        void setOrderShipGroupContactMechId(String orderShipGroupContactMechId);

        String getOrderShipGroupTelecomContactMechId();

        void setOrderShipGroupTelecomContactMechId(String orderShipGroupTelecomContactMechId);

        String getOrderShipGroupTrackingNumber();

        void setOrderShipGroupTrackingNumber(String orderShipGroupTrackingNumber);

        String getOrderShipGroupShippingInstructions();

        void setOrderShipGroupShippingInstructions(String orderShipGroupShippingInstructions);

        String getOrderShipGroupMaySplit();

        void setOrderShipGroupMaySplit(String orderShipGroupMaySplit);

        String getOrderShipGroupGiftMessage();

        void setOrderShipGroupGiftMessage(String orderShipGroupGiftMessage);

        String getOrderShipGroupIsGift();

        void setOrderShipGroupIsGift(String orderShipGroupIsGift);

        java.sql.Timestamp getOrderShipGroupShipAfterDate();

        void setOrderShipGroupShipAfterDate(java.sql.Timestamp orderShipGroupShipAfterDate);

        java.sql.Timestamp getOrderShipGroupShipByDate();

        void setOrderShipGroupShipByDate(java.sql.Timestamp orderShipGroupShipByDate);

        java.sql.Timestamp getOrderShipGroupEstimatedShipDate();

        void setOrderShipGroupEstimatedShipDate(java.sql.Timestamp orderShipGroupEstimatedShipDate);

        java.sql.Timestamp getOrderShipGroupEstimatedDeliveryDate();

        void setOrderShipGroupEstimatedDeliveryDate(java.sql.Timestamp orderShipGroupEstimatedDeliveryDate);

        Long getOrderShipGroupPickwaveId();

        void setOrderShipGroupPickwaveId(Long orderShipGroupPickwaveId);

        Long getOrderShipGroupVersion();

        void setOrderShipGroupVersion(Long orderShipGroupVersion);

        String getOrderShipGroupCreatedBy();

        void setOrderShipGroupCreatedBy(String orderShipGroupCreatedBy);

        Date getOrderShipGroupCreatedAt();

        void setOrderShipGroupCreatedAt(Date orderShipGroupCreatedAt);

        String getOrderShipGroupUpdatedBy();

        void setOrderShipGroupUpdatedBy(String orderShipGroupUpdatedBy);

        Date getOrderShipGroupUpdatedAt();

        void setOrderShipGroupUpdatedAt(Date orderShipGroupUpdatedAt);

        Boolean getOrderShipGroupActive();

        void setOrderShipGroupActive(Boolean orderShipGroupActive);

        Boolean getOrderShipGroupDeleted();

        void setOrderShipGroupDeleted(Boolean orderShipGroupDeleted);

        String getOrderOrderTypeId();

        void setOrderOrderTypeId(String orderOrderTypeId);

        String getOrderOrderName();

        void setOrderOrderName(String orderOrderName);

        String getOrderExternalId();

        void setOrderExternalId(String orderExternalId);

        String getOrderSalesChannelEnumId();

        void setOrderSalesChannelEnumId(String orderSalesChannelEnumId);

        java.sql.Timestamp getOrderOrderDate();

        void setOrderOrderDate(java.sql.Timestamp orderOrderDate);

        String getOrderPriority();

        void setOrderPriority(String orderPriority);

        java.sql.Timestamp getOrderEntryDate();

        void setOrderEntryDate(java.sql.Timestamp orderEntryDate);

        java.sql.Timestamp getOrderPickSheetPrintedDate();

        void setOrderPickSheetPrintedDate(java.sql.Timestamp orderPickSheetPrintedDate);

        String getOrderStatusId();

        void setOrderStatusId(String orderStatusId);

        String getOrderCurrencyUom();

        void setOrderCurrencyUom(String orderCurrencyUom);

        String getOrderSyncStatusId();

        void setOrderSyncStatusId(String orderSyncStatusId);

        String getOrderBillingAccountId();

        void setOrderBillingAccountId(String orderBillingAccountId);

        String getOrderOriginFacilityId();

        void setOrderOriginFacilityId(String orderOriginFacilityId);

        String getOrderWebSiteId();

        void setOrderWebSiteId(String orderWebSiteId);

        String getOrderProductStoreId();

        void setOrderProductStoreId(String orderProductStoreId);

        String getOrderTerminalId();

        void setOrderTerminalId(String orderTerminalId);

        String getOrderTransactionId();

        void setOrderTransactionId(String orderTransactionId);

        String getOrderAutoOrderShoppingListId();

        void setOrderAutoOrderShoppingListId(String orderAutoOrderShoppingListId);

        String getOrderNeedsInventoryIssuance();

        void setOrderNeedsInventoryIssuance(String orderNeedsInventoryIssuance);

        String getOrderIsRushOrder();

        void setOrderIsRushOrder(String orderIsRushOrder);

        String getOrderInternalCode();

        void setOrderInternalCode(String orderInternalCode);

        java.math.BigDecimal getOrderRemainingSubTotal();

        void setOrderRemainingSubTotal(java.math.BigDecimal orderRemainingSubTotal);

        java.math.BigDecimal getOrderGrandTotal();

        void setOrderGrandTotal(java.math.BigDecimal orderGrandTotal);

        String getOrderInvoicePerShipment();

        void setOrderInvoicePerShipment(String orderInvoicePerShipment);

        String getOrderCreatedBy();

        void setOrderCreatedBy(String orderCreatedBy);

        Date getOrderCreatedAt();

        void setOrderCreatedAt(Date orderCreatedAt);

        String getOrderUpdatedBy();

        void setOrderUpdatedBy(String orderUpdatedBy);

        Date getOrderUpdatedAt();

        void setOrderUpdatedAt(Date orderUpdatedAt);

        Boolean getOrderActive();

        void setOrderActive(Boolean orderActive);

    }

    interface OrderItemShipGroupAssociationMvoStateCreated extends OrderItemShipGroupAssociationMvoStateEvent
    {
    
    }


    interface OrderItemShipGroupAssociationMvoStateMergePatched extends OrderItemShipGroupAssociationMvoStateEvent
    {
        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyCancelQuantityRemoved();

        void setIsPropertyCancelQuantityRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupShipmentMethodTypeIdRemoved();

        void setIsPropertyOrderShipGroupShipmentMethodTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupSupplierPartyIdRemoved();

        void setIsPropertyOrderShipGroupSupplierPartyIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupVendorPartyIdRemoved();

        void setIsPropertyOrderShipGroupVendorPartyIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupCarrierPartyIdRemoved();

        void setIsPropertyOrderShipGroupCarrierPartyIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupCarrierRoleTypeIdRemoved();

        void setIsPropertyOrderShipGroupCarrierRoleTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupFacilityIdRemoved();

        void setIsPropertyOrderShipGroupFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupContactMechIdRemoved();

        void setIsPropertyOrderShipGroupContactMechIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupTelecomContactMechIdRemoved();

        void setIsPropertyOrderShipGroupTelecomContactMechIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupTrackingNumberRemoved();

        void setIsPropertyOrderShipGroupTrackingNumberRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupShippingInstructionsRemoved();

        void setIsPropertyOrderShipGroupShippingInstructionsRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupMaySplitRemoved();

        void setIsPropertyOrderShipGroupMaySplitRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupGiftMessageRemoved();

        void setIsPropertyOrderShipGroupGiftMessageRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupIsGiftRemoved();

        void setIsPropertyOrderShipGroupIsGiftRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupShipAfterDateRemoved();

        void setIsPropertyOrderShipGroupShipAfterDateRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupShipByDateRemoved();

        void setIsPropertyOrderShipGroupShipByDateRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupEstimatedShipDateRemoved();

        void setIsPropertyOrderShipGroupEstimatedShipDateRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupEstimatedDeliveryDateRemoved();

        void setIsPropertyOrderShipGroupEstimatedDeliveryDateRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupPickwaveIdRemoved();

        void setIsPropertyOrderShipGroupPickwaveIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupVersionRemoved();

        void setIsPropertyOrderShipGroupVersionRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupCreatedByRemoved();

        void setIsPropertyOrderShipGroupCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupCreatedAtRemoved();

        void setIsPropertyOrderShipGroupCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupUpdatedByRemoved();

        void setIsPropertyOrderShipGroupUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupUpdatedAtRemoved();

        void setIsPropertyOrderShipGroupUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupActiveRemoved();

        void setIsPropertyOrderShipGroupActiveRemoved(Boolean removed);

        Boolean getIsPropertyOrderShipGroupDeletedRemoved();

        void setIsPropertyOrderShipGroupDeletedRemoved(Boolean removed);

        Boolean getIsPropertyOrderOrderTypeIdRemoved();

        void setIsPropertyOrderOrderTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderOrderNameRemoved();

        void setIsPropertyOrderOrderNameRemoved(Boolean removed);

        Boolean getIsPropertyOrderExternalIdRemoved();

        void setIsPropertyOrderExternalIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderSalesChannelEnumIdRemoved();

        void setIsPropertyOrderSalesChannelEnumIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderOrderDateRemoved();

        void setIsPropertyOrderOrderDateRemoved(Boolean removed);

        Boolean getIsPropertyOrderPriorityRemoved();

        void setIsPropertyOrderPriorityRemoved(Boolean removed);

        Boolean getIsPropertyOrderEntryDateRemoved();

        void setIsPropertyOrderEntryDateRemoved(Boolean removed);

        Boolean getIsPropertyOrderPickSheetPrintedDateRemoved();

        void setIsPropertyOrderPickSheetPrintedDateRemoved(Boolean removed);

        Boolean getIsPropertyOrderStatusIdRemoved();

        void setIsPropertyOrderStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderCurrencyUomRemoved();

        void setIsPropertyOrderCurrencyUomRemoved(Boolean removed);

        Boolean getIsPropertyOrderSyncStatusIdRemoved();

        void setIsPropertyOrderSyncStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderBillingAccountIdRemoved();

        void setIsPropertyOrderBillingAccountIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderOriginFacilityIdRemoved();

        void setIsPropertyOrderOriginFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderWebSiteIdRemoved();

        void setIsPropertyOrderWebSiteIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderProductStoreIdRemoved();

        void setIsPropertyOrderProductStoreIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderTerminalIdRemoved();

        void setIsPropertyOrderTerminalIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderTransactionIdRemoved();

        void setIsPropertyOrderTransactionIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderAutoOrderShoppingListIdRemoved();

        void setIsPropertyOrderAutoOrderShoppingListIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderNeedsInventoryIssuanceRemoved();

        void setIsPropertyOrderNeedsInventoryIssuanceRemoved(Boolean removed);

        Boolean getIsPropertyOrderIsRushOrderRemoved();

        void setIsPropertyOrderIsRushOrderRemoved(Boolean removed);

        Boolean getIsPropertyOrderInternalCodeRemoved();

        void setIsPropertyOrderInternalCodeRemoved(Boolean removed);

        Boolean getIsPropertyOrderRemainingSubTotalRemoved();

        void setIsPropertyOrderRemainingSubTotalRemoved(Boolean removed);

        Boolean getIsPropertyOrderGrandTotalRemoved();

        void setIsPropertyOrderGrandTotalRemoved(Boolean removed);

        Boolean getIsPropertyOrderInvoicePerShipmentRemoved();

        void setIsPropertyOrderInvoicePerShipmentRemoved(Boolean removed);

        Boolean getIsPropertyOrderCreatedByRemoved();

        void setIsPropertyOrderCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyOrderCreatedAtRemoved();

        void setIsPropertyOrderCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyOrderUpdatedByRemoved();

        void setIsPropertyOrderUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyOrderUpdatedAtRemoved();

        void setIsPropertyOrderUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyOrderActiveRemoved();

        void setIsPropertyOrderActiveRemoved(Boolean removed);


    }

    interface OrderItemShipGroupAssociationMvoStateDeleted extends OrderItemShipGroupAssociationMvoStateEvent
    {
    }


}

