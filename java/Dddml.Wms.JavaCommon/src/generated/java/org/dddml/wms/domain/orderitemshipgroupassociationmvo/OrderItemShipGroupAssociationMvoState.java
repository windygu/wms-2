package org.dddml.wms.domain.orderitemshipgroupassociationmvo;

import java.util.Set;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.orderitemshipgroupassociationmvo.OrderItemShipGroupAssociationMvoStateEvent.*;

public interface OrderItemShipGroupAssociationMvoState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    OrderItemShipGroupAssociationId getOrderItemShipGroupAssociationId();

    void setOrderItemShipGroupAssociationId(OrderItemShipGroupAssociationId orderItemShipGroupAssociationId);

    java.math.BigDecimal getQuantity();

    void setQuantity(java.math.BigDecimal quantity);

    java.math.BigDecimal getCancelQuantity();

    void setCancelQuantity(java.math.BigDecimal cancelQuantity);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);

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

    Long getOrderVersion();

    void setOrderVersion(Long orderVersion);

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


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(OrderItemShipGroupAssociationMvoStateEvent.OrderItemShipGroupAssociationMvoStateCreated e);

    void when(OrderItemShipGroupAssociationMvoStateEvent.OrderItemShipGroupAssociationMvoStateMergePatched e);

    void when(OrderItemShipGroupAssociationMvoStateEvent.OrderItemShipGroupAssociationMvoStateDeleted e);
    
}

