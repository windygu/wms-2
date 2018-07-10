package org.dddml.wms.domain.orderitemshipgroupassociationmvo;

import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class OrderItemShipGroupAssociationMvoStateEventDto extends AbstractEvent
{

    private OrderItemShipGroupAssociationMvoEventId orderItemShipGroupAssociationMvoEventId;

    OrderItemShipGroupAssociationMvoEventId getOrderItemShipGroupAssociationMvoEventId() {
        if (orderItemShipGroupAssociationMvoEventId == null) { orderItemShipGroupAssociationMvoEventId = new OrderItemShipGroupAssociationMvoEventId(); }
        return orderItemShipGroupAssociationMvoEventId;
    }

    void setOrderItemShipGroupAssociationMvoEventId(OrderItemShipGroupAssociationMvoEventId eventId) {
        this.orderItemShipGroupAssociationMvoEventId = eventId;
    }

    public OrderItemShipGroupAssociationId getOrderItemShipGroupAssociationId() {
        return getOrderItemShipGroupAssociationMvoEventId().getOrderItemShipGroupAssociationId();
    }

    public void setOrderItemShipGroupAssociationId(OrderItemShipGroupAssociationId orderItemShipGroupAssociationId) {
        getOrderItemShipGroupAssociationMvoEventId().setOrderItemShipGroupAssociationId(orderItemShipGroupAssociationId);
    }

    public Long getOrderVersion() {
        return getOrderItemShipGroupAssociationMvoEventId().getOrderVersion();
    }
    
    public void getOrderVersion(Long orderVersion) {
        getOrderItemShipGroupAssociationMvoEventId().setOrderVersion(orderVersion);
    }

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity) {
        this.quantity = quantity;
    }

    private java.math.BigDecimal cancelQuantity;

    public java.math.BigDecimal getCancelQuantity() {
        return this.cancelQuantity;
    }

    public void setCancelQuantity(java.math.BigDecimal cancelQuantity) {
        this.cancelQuantity = cancelQuantity;
    }

    private Long version;

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private String orderShipGroupShipmentMethodTypeId;

    public String getOrderShipGroupShipmentMethodTypeId() {
        return this.orderShipGroupShipmentMethodTypeId;
    }

    public void setOrderShipGroupShipmentMethodTypeId(String orderShipGroupShipmentMethodTypeId) {
        this.orderShipGroupShipmentMethodTypeId = orderShipGroupShipmentMethodTypeId;
    }

    private String orderShipGroupSupplierPartyId;

    public String getOrderShipGroupSupplierPartyId() {
        return this.orderShipGroupSupplierPartyId;
    }

    public void setOrderShipGroupSupplierPartyId(String orderShipGroupSupplierPartyId) {
        this.orderShipGroupSupplierPartyId = orderShipGroupSupplierPartyId;
    }

    private String orderShipGroupVendorPartyId;

    public String getOrderShipGroupVendorPartyId() {
        return this.orderShipGroupVendorPartyId;
    }

    public void setOrderShipGroupVendorPartyId(String orderShipGroupVendorPartyId) {
        this.orderShipGroupVendorPartyId = orderShipGroupVendorPartyId;
    }

    private String orderShipGroupCarrierPartyId;

    public String getOrderShipGroupCarrierPartyId() {
        return this.orderShipGroupCarrierPartyId;
    }

    public void setOrderShipGroupCarrierPartyId(String orderShipGroupCarrierPartyId) {
        this.orderShipGroupCarrierPartyId = orderShipGroupCarrierPartyId;
    }

    private String orderShipGroupCarrierRoleTypeId;

    public String getOrderShipGroupCarrierRoleTypeId() {
        return this.orderShipGroupCarrierRoleTypeId;
    }

    public void setOrderShipGroupCarrierRoleTypeId(String orderShipGroupCarrierRoleTypeId) {
        this.orderShipGroupCarrierRoleTypeId = orderShipGroupCarrierRoleTypeId;
    }

    private String orderShipGroupFacilityId;

    public String getOrderShipGroupFacilityId() {
        return this.orderShipGroupFacilityId;
    }

    public void setOrderShipGroupFacilityId(String orderShipGroupFacilityId) {
        this.orderShipGroupFacilityId = orderShipGroupFacilityId;
    }

    private String orderShipGroupContactMechId;

    public String getOrderShipGroupContactMechId() {
        return this.orderShipGroupContactMechId;
    }

    public void setOrderShipGroupContactMechId(String orderShipGroupContactMechId) {
        this.orderShipGroupContactMechId = orderShipGroupContactMechId;
    }

    private String orderShipGroupTelecomContactMechId;

    public String getOrderShipGroupTelecomContactMechId() {
        return this.orderShipGroupTelecomContactMechId;
    }

    public void setOrderShipGroupTelecomContactMechId(String orderShipGroupTelecomContactMechId) {
        this.orderShipGroupTelecomContactMechId = orderShipGroupTelecomContactMechId;
    }

    private String orderShipGroupTrackingNumber;

    public String getOrderShipGroupTrackingNumber() {
        return this.orderShipGroupTrackingNumber;
    }

    public void setOrderShipGroupTrackingNumber(String orderShipGroupTrackingNumber) {
        this.orderShipGroupTrackingNumber = orderShipGroupTrackingNumber;
    }

    private String orderShipGroupShippingInstructions;

    public String getOrderShipGroupShippingInstructions() {
        return this.orderShipGroupShippingInstructions;
    }

    public void setOrderShipGroupShippingInstructions(String orderShipGroupShippingInstructions) {
        this.orderShipGroupShippingInstructions = orderShipGroupShippingInstructions;
    }

    private String orderShipGroupMaySplit;

    public String getOrderShipGroupMaySplit() {
        return this.orderShipGroupMaySplit;
    }

    public void setOrderShipGroupMaySplit(String orderShipGroupMaySplit) {
        this.orderShipGroupMaySplit = orderShipGroupMaySplit;
    }

    private String orderShipGroupGiftMessage;

    public String getOrderShipGroupGiftMessage() {
        return this.orderShipGroupGiftMessage;
    }

    public void setOrderShipGroupGiftMessage(String orderShipGroupGiftMessage) {
        this.orderShipGroupGiftMessage = orderShipGroupGiftMessage;
    }

    private String orderShipGroupIsGift;

    public String getOrderShipGroupIsGift() {
        return this.orderShipGroupIsGift;
    }

    public void setOrderShipGroupIsGift(String orderShipGroupIsGift) {
        this.orderShipGroupIsGift = orderShipGroupIsGift;
    }

    private java.sql.Timestamp orderShipGroupShipAfterDate;

    public java.sql.Timestamp getOrderShipGroupShipAfterDate() {
        return this.orderShipGroupShipAfterDate;
    }

    public void setOrderShipGroupShipAfterDate(java.sql.Timestamp orderShipGroupShipAfterDate) {
        this.orderShipGroupShipAfterDate = orderShipGroupShipAfterDate;
    }

    private java.sql.Timestamp orderShipGroupShipByDate;

    public java.sql.Timestamp getOrderShipGroupShipByDate() {
        return this.orderShipGroupShipByDate;
    }

    public void setOrderShipGroupShipByDate(java.sql.Timestamp orderShipGroupShipByDate) {
        this.orderShipGroupShipByDate = orderShipGroupShipByDate;
    }

    private java.sql.Timestamp orderShipGroupEstimatedShipDate;

    public java.sql.Timestamp getOrderShipGroupEstimatedShipDate() {
        return this.orderShipGroupEstimatedShipDate;
    }

    public void setOrderShipGroupEstimatedShipDate(java.sql.Timestamp orderShipGroupEstimatedShipDate) {
        this.orderShipGroupEstimatedShipDate = orderShipGroupEstimatedShipDate;
    }

    private java.sql.Timestamp orderShipGroupEstimatedDeliveryDate;

    public java.sql.Timestamp getOrderShipGroupEstimatedDeliveryDate() {
        return this.orderShipGroupEstimatedDeliveryDate;
    }

    public void setOrderShipGroupEstimatedDeliveryDate(java.sql.Timestamp orderShipGroupEstimatedDeliveryDate) {
        this.orderShipGroupEstimatedDeliveryDate = orderShipGroupEstimatedDeliveryDate;
    }

    private Long orderShipGroupPickwaveId;

    public Long getOrderShipGroupPickwaveId() {
        return this.orderShipGroupPickwaveId;
    }

    public void setOrderShipGroupPickwaveId(Long orderShipGroupPickwaveId) {
        this.orderShipGroupPickwaveId = orderShipGroupPickwaveId;
    }

    private Long orderShipGroupVersion;

    public Long getOrderShipGroupVersion() {
        return this.orderShipGroupVersion;
    }

    public void setOrderShipGroupVersion(Long orderShipGroupVersion) {
        this.orderShipGroupVersion = orderShipGroupVersion;
    }

    private String orderShipGroupCreatedBy;

    public String getOrderShipGroupCreatedBy() {
        return this.orderShipGroupCreatedBy;
    }

    public void setOrderShipGroupCreatedBy(String orderShipGroupCreatedBy) {
        this.orderShipGroupCreatedBy = orderShipGroupCreatedBy;
    }

    private Date orderShipGroupCreatedAt;

    public Date getOrderShipGroupCreatedAt() {
        return this.orderShipGroupCreatedAt;
    }

    public void setOrderShipGroupCreatedAt(Date orderShipGroupCreatedAt) {
        this.orderShipGroupCreatedAt = orderShipGroupCreatedAt;
    }

    private String orderShipGroupUpdatedBy;

    public String getOrderShipGroupUpdatedBy() {
        return this.orderShipGroupUpdatedBy;
    }

    public void setOrderShipGroupUpdatedBy(String orderShipGroupUpdatedBy) {
        this.orderShipGroupUpdatedBy = orderShipGroupUpdatedBy;
    }

    private Date orderShipGroupUpdatedAt;

    public Date getOrderShipGroupUpdatedAt() {
        return this.orderShipGroupUpdatedAt;
    }

    public void setOrderShipGroupUpdatedAt(Date orderShipGroupUpdatedAt) {
        this.orderShipGroupUpdatedAt = orderShipGroupUpdatedAt;
    }

    private Boolean orderShipGroupActive;

    public Boolean getOrderShipGroupActive() {
        return this.orderShipGroupActive;
    }

    public void setOrderShipGroupActive(Boolean orderShipGroupActive) {
        this.orderShipGroupActive = orderShipGroupActive;
    }

    private Boolean orderShipGroupDeleted;

    public Boolean getOrderShipGroupDeleted() {
        return this.orderShipGroupDeleted;
    }

    public void setOrderShipGroupDeleted(Boolean orderShipGroupDeleted) {
        this.orderShipGroupDeleted = orderShipGroupDeleted;
    }

    private String orderOrderTypeId;

    public String getOrderOrderTypeId() {
        return this.orderOrderTypeId;
    }

    public void setOrderOrderTypeId(String orderOrderTypeId) {
        this.orderOrderTypeId = orderOrderTypeId;
    }

    private String orderOrderName;

    public String getOrderOrderName() {
        return this.orderOrderName;
    }

    public void setOrderOrderName(String orderOrderName) {
        this.orderOrderName = orderOrderName;
    }

    private String orderExternalId;

    public String getOrderExternalId() {
        return this.orderExternalId;
    }

    public void setOrderExternalId(String orderExternalId) {
        this.orderExternalId = orderExternalId;
    }

    private String orderSalesChannelEnumId;

    public String getOrderSalesChannelEnumId() {
        return this.orderSalesChannelEnumId;
    }

    public void setOrderSalesChannelEnumId(String orderSalesChannelEnumId) {
        this.orderSalesChannelEnumId = orderSalesChannelEnumId;
    }

    private java.sql.Timestamp orderOrderDate;

    public java.sql.Timestamp getOrderOrderDate() {
        return this.orderOrderDate;
    }

    public void setOrderOrderDate(java.sql.Timestamp orderOrderDate) {
        this.orderOrderDate = orderOrderDate;
    }

    private String orderPriority;

    public String getOrderPriority() {
        return this.orderPriority;
    }

    public void setOrderPriority(String orderPriority) {
        this.orderPriority = orderPriority;
    }

    private java.sql.Timestamp orderEntryDate;

    public java.sql.Timestamp getOrderEntryDate() {
        return this.orderEntryDate;
    }

    public void setOrderEntryDate(java.sql.Timestamp orderEntryDate) {
        this.orderEntryDate = orderEntryDate;
    }

    private java.sql.Timestamp orderPickSheetPrintedDate;

    public java.sql.Timestamp getOrderPickSheetPrintedDate() {
        return this.orderPickSheetPrintedDate;
    }

    public void setOrderPickSheetPrintedDate(java.sql.Timestamp orderPickSheetPrintedDate) {
        this.orderPickSheetPrintedDate = orderPickSheetPrintedDate;
    }

    private String orderStatusId;

    public String getOrderStatusId() {
        return this.orderStatusId;
    }

    public void setOrderStatusId(String orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    private String orderCurrencyUom;

    public String getOrderCurrencyUom() {
        return this.orderCurrencyUom;
    }

    public void setOrderCurrencyUom(String orderCurrencyUom) {
        this.orderCurrencyUom = orderCurrencyUom;
    }

    private String orderSyncStatusId;

    public String getOrderSyncStatusId() {
        return this.orderSyncStatusId;
    }

    public void setOrderSyncStatusId(String orderSyncStatusId) {
        this.orderSyncStatusId = orderSyncStatusId;
    }

    private String orderBillingAccountId;

    public String getOrderBillingAccountId() {
        return this.orderBillingAccountId;
    }

    public void setOrderBillingAccountId(String orderBillingAccountId) {
        this.orderBillingAccountId = orderBillingAccountId;
    }

    private String orderOriginFacilityId;

    public String getOrderOriginFacilityId() {
        return this.orderOriginFacilityId;
    }

    public void setOrderOriginFacilityId(String orderOriginFacilityId) {
        this.orderOriginFacilityId = orderOriginFacilityId;
    }

    private String orderWebSiteId;

    public String getOrderWebSiteId() {
        return this.orderWebSiteId;
    }

    public void setOrderWebSiteId(String orderWebSiteId) {
        this.orderWebSiteId = orderWebSiteId;
    }

    private String orderProductStoreId;

    public String getOrderProductStoreId() {
        return this.orderProductStoreId;
    }

    public void setOrderProductStoreId(String orderProductStoreId) {
        this.orderProductStoreId = orderProductStoreId;
    }

    private String orderTerminalId;

    public String getOrderTerminalId() {
        return this.orderTerminalId;
    }

    public void setOrderTerminalId(String orderTerminalId) {
        this.orderTerminalId = orderTerminalId;
    }

    private String orderTransactionId;

    public String getOrderTransactionId() {
        return this.orderTransactionId;
    }

    public void setOrderTransactionId(String orderTransactionId) {
        this.orderTransactionId = orderTransactionId;
    }

    private String orderAutoOrderShoppingListId;

    public String getOrderAutoOrderShoppingListId() {
        return this.orderAutoOrderShoppingListId;
    }

    public void setOrderAutoOrderShoppingListId(String orderAutoOrderShoppingListId) {
        this.orderAutoOrderShoppingListId = orderAutoOrderShoppingListId;
    }

    private String orderNeedsInventoryIssuance;

    public String getOrderNeedsInventoryIssuance() {
        return this.orderNeedsInventoryIssuance;
    }

    public void setOrderNeedsInventoryIssuance(String orderNeedsInventoryIssuance) {
        this.orderNeedsInventoryIssuance = orderNeedsInventoryIssuance;
    }

    private String orderIsRushOrder;

    public String getOrderIsRushOrder() {
        return this.orderIsRushOrder;
    }

    public void setOrderIsRushOrder(String orderIsRushOrder) {
        this.orderIsRushOrder = orderIsRushOrder;
    }

    private String orderInternalCode;

    public String getOrderInternalCode() {
        return this.orderInternalCode;
    }

    public void setOrderInternalCode(String orderInternalCode) {
        this.orderInternalCode = orderInternalCode;
    }

    private java.math.BigDecimal orderRemainingSubTotal;

    public java.math.BigDecimal getOrderRemainingSubTotal() {
        return this.orderRemainingSubTotal;
    }

    public void setOrderRemainingSubTotal(java.math.BigDecimal orderRemainingSubTotal) {
        this.orderRemainingSubTotal = orderRemainingSubTotal;
    }

    private java.math.BigDecimal orderGrandTotal;

    public java.math.BigDecimal getOrderGrandTotal() {
        return this.orderGrandTotal;
    }

    public void setOrderGrandTotal(java.math.BigDecimal orderGrandTotal) {
        this.orderGrandTotal = orderGrandTotal;
    }

    private String orderInvoicePerShipment;

    public String getOrderInvoicePerShipment() {
        return this.orderInvoicePerShipment;
    }

    public void setOrderInvoicePerShipment(String orderInvoicePerShipment) {
        this.orderInvoicePerShipment = orderInvoicePerShipment;
    }

    private String orderCreatedBy;

    public String getOrderCreatedBy() {
        return this.orderCreatedBy;
    }

    public void setOrderCreatedBy(String orderCreatedBy) {
        this.orderCreatedBy = orderCreatedBy;
    }

    private Date orderCreatedAt;

    public Date getOrderCreatedAt() {
        return this.orderCreatedAt;
    }

    public void setOrderCreatedAt(Date orderCreatedAt) {
        this.orderCreatedAt = orderCreatedAt;
    }

    private String orderUpdatedBy;

    public String getOrderUpdatedBy() {
        return this.orderUpdatedBy;
    }

    public void setOrderUpdatedBy(String orderUpdatedBy) {
        this.orderUpdatedBy = orderUpdatedBy;
    }

    private Date orderUpdatedAt;

    public Date getOrderUpdatedAt() {
        return this.orderUpdatedAt;
    }

    public void setOrderUpdatedAt(Date orderUpdatedAt) {
        this.orderUpdatedAt = orderUpdatedAt;
    }

    private Boolean orderActive;

    public Boolean getOrderActive() {
        return this.orderActive;
    }

    public void setOrderActive(Boolean orderActive) {
        this.orderActive = orderActive;
    }

    private String createdBy;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private Boolean isPropertyQuantityRemoved;

    public Boolean getIsPropertyQuantityRemoved() {
        return this.isPropertyQuantityRemoved;
    }

    public void setIsPropertyQuantityRemoved(Boolean removed) {
        this.isPropertyQuantityRemoved = removed;
    }

    private Boolean isPropertyCancelQuantityRemoved;

    public Boolean getIsPropertyCancelQuantityRemoved() {
        return this.isPropertyCancelQuantityRemoved;
    }

    public void setIsPropertyCancelQuantityRemoved(Boolean removed) {
        this.isPropertyCancelQuantityRemoved = removed;
    }

    private Boolean isPropertyVersionRemoved;

    public Boolean getIsPropertyVersionRemoved() {
        return this.isPropertyVersionRemoved;
    }

    public void setIsPropertyVersionRemoved(Boolean removed) {
        this.isPropertyVersionRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupShipmentMethodTypeIdRemoved;

    public Boolean getIsPropertyOrderShipGroupShipmentMethodTypeIdRemoved() {
        return this.isPropertyOrderShipGroupShipmentMethodTypeIdRemoved;
    }

    public void setIsPropertyOrderShipGroupShipmentMethodTypeIdRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupShipmentMethodTypeIdRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupSupplierPartyIdRemoved;

    public Boolean getIsPropertyOrderShipGroupSupplierPartyIdRemoved() {
        return this.isPropertyOrderShipGroupSupplierPartyIdRemoved;
    }

    public void setIsPropertyOrderShipGroupSupplierPartyIdRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupSupplierPartyIdRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupVendorPartyIdRemoved;

    public Boolean getIsPropertyOrderShipGroupVendorPartyIdRemoved() {
        return this.isPropertyOrderShipGroupVendorPartyIdRemoved;
    }

    public void setIsPropertyOrderShipGroupVendorPartyIdRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupVendorPartyIdRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupCarrierPartyIdRemoved;

    public Boolean getIsPropertyOrderShipGroupCarrierPartyIdRemoved() {
        return this.isPropertyOrderShipGroupCarrierPartyIdRemoved;
    }

    public void setIsPropertyOrderShipGroupCarrierPartyIdRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupCarrierPartyIdRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupCarrierRoleTypeIdRemoved;

    public Boolean getIsPropertyOrderShipGroupCarrierRoleTypeIdRemoved() {
        return this.isPropertyOrderShipGroupCarrierRoleTypeIdRemoved;
    }

    public void setIsPropertyOrderShipGroupCarrierRoleTypeIdRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupCarrierRoleTypeIdRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupFacilityIdRemoved;

    public Boolean getIsPropertyOrderShipGroupFacilityIdRemoved() {
        return this.isPropertyOrderShipGroupFacilityIdRemoved;
    }

    public void setIsPropertyOrderShipGroupFacilityIdRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupFacilityIdRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupContactMechIdRemoved;

    public Boolean getIsPropertyOrderShipGroupContactMechIdRemoved() {
        return this.isPropertyOrderShipGroupContactMechIdRemoved;
    }

    public void setIsPropertyOrderShipGroupContactMechIdRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupContactMechIdRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupTelecomContactMechIdRemoved;

    public Boolean getIsPropertyOrderShipGroupTelecomContactMechIdRemoved() {
        return this.isPropertyOrderShipGroupTelecomContactMechIdRemoved;
    }

    public void setIsPropertyOrderShipGroupTelecomContactMechIdRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupTelecomContactMechIdRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupTrackingNumberRemoved;

    public Boolean getIsPropertyOrderShipGroupTrackingNumberRemoved() {
        return this.isPropertyOrderShipGroupTrackingNumberRemoved;
    }

    public void setIsPropertyOrderShipGroupTrackingNumberRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupTrackingNumberRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupShippingInstructionsRemoved;

    public Boolean getIsPropertyOrderShipGroupShippingInstructionsRemoved() {
        return this.isPropertyOrderShipGroupShippingInstructionsRemoved;
    }

    public void setIsPropertyOrderShipGroupShippingInstructionsRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupShippingInstructionsRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupMaySplitRemoved;

    public Boolean getIsPropertyOrderShipGroupMaySplitRemoved() {
        return this.isPropertyOrderShipGroupMaySplitRemoved;
    }

    public void setIsPropertyOrderShipGroupMaySplitRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupMaySplitRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupGiftMessageRemoved;

    public Boolean getIsPropertyOrderShipGroupGiftMessageRemoved() {
        return this.isPropertyOrderShipGroupGiftMessageRemoved;
    }

    public void setIsPropertyOrderShipGroupGiftMessageRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupGiftMessageRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupIsGiftRemoved;

    public Boolean getIsPropertyOrderShipGroupIsGiftRemoved() {
        return this.isPropertyOrderShipGroupIsGiftRemoved;
    }

    public void setIsPropertyOrderShipGroupIsGiftRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupIsGiftRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupShipAfterDateRemoved;

    public Boolean getIsPropertyOrderShipGroupShipAfterDateRemoved() {
        return this.isPropertyOrderShipGroupShipAfterDateRemoved;
    }

    public void setIsPropertyOrderShipGroupShipAfterDateRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupShipAfterDateRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupShipByDateRemoved;

    public Boolean getIsPropertyOrderShipGroupShipByDateRemoved() {
        return this.isPropertyOrderShipGroupShipByDateRemoved;
    }

    public void setIsPropertyOrderShipGroupShipByDateRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupShipByDateRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupEstimatedShipDateRemoved;

    public Boolean getIsPropertyOrderShipGroupEstimatedShipDateRemoved() {
        return this.isPropertyOrderShipGroupEstimatedShipDateRemoved;
    }

    public void setIsPropertyOrderShipGroupEstimatedShipDateRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupEstimatedShipDateRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupEstimatedDeliveryDateRemoved;

    public Boolean getIsPropertyOrderShipGroupEstimatedDeliveryDateRemoved() {
        return this.isPropertyOrderShipGroupEstimatedDeliveryDateRemoved;
    }

    public void setIsPropertyOrderShipGroupEstimatedDeliveryDateRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupEstimatedDeliveryDateRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupPickwaveIdRemoved;

    public Boolean getIsPropertyOrderShipGroupPickwaveIdRemoved() {
        return this.isPropertyOrderShipGroupPickwaveIdRemoved;
    }

    public void setIsPropertyOrderShipGroupPickwaveIdRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupPickwaveIdRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupVersionRemoved;

    public Boolean getIsPropertyOrderShipGroupVersionRemoved() {
        return this.isPropertyOrderShipGroupVersionRemoved;
    }

    public void setIsPropertyOrderShipGroupVersionRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupVersionRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupCreatedByRemoved;

    public Boolean getIsPropertyOrderShipGroupCreatedByRemoved() {
        return this.isPropertyOrderShipGroupCreatedByRemoved;
    }

    public void setIsPropertyOrderShipGroupCreatedByRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupCreatedByRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupCreatedAtRemoved;

    public Boolean getIsPropertyOrderShipGroupCreatedAtRemoved() {
        return this.isPropertyOrderShipGroupCreatedAtRemoved;
    }

    public void setIsPropertyOrderShipGroupCreatedAtRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupCreatedAtRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupUpdatedByRemoved;

    public Boolean getIsPropertyOrderShipGroupUpdatedByRemoved() {
        return this.isPropertyOrderShipGroupUpdatedByRemoved;
    }

    public void setIsPropertyOrderShipGroupUpdatedByRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupUpdatedByRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupUpdatedAtRemoved;

    public Boolean getIsPropertyOrderShipGroupUpdatedAtRemoved() {
        return this.isPropertyOrderShipGroupUpdatedAtRemoved;
    }

    public void setIsPropertyOrderShipGroupUpdatedAtRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupUpdatedAtRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupActiveRemoved;

    public Boolean getIsPropertyOrderShipGroupActiveRemoved() {
        return this.isPropertyOrderShipGroupActiveRemoved;
    }

    public void setIsPropertyOrderShipGroupActiveRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupActiveRemoved = removed;
    }

    private Boolean isPropertyOrderShipGroupDeletedRemoved;

    public Boolean getIsPropertyOrderShipGroupDeletedRemoved() {
        return this.isPropertyOrderShipGroupDeletedRemoved;
    }

    public void setIsPropertyOrderShipGroupDeletedRemoved(Boolean removed) {
        this.isPropertyOrderShipGroupDeletedRemoved = removed;
    }

    private Boolean isPropertyOrderOrderTypeIdRemoved;

    public Boolean getIsPropertyOrderOrderTypeIdRemoved() {
        return this.isPropertyOrderOrderTypeIdRemoved;
    }

    public void setIsPropertyOrderOrderTypeIdRemoved(Boolean removed) {
        this.isPropertyOrderOrderTypeIdRemoved = removed;
    }

    private Boolean isPropertyOrderOrderNameRemoved;

    public Boolean getIsPropertyOrderOrderNameRemoved() {
        return this.isPropertyOrderOrderNameRemoved;
    }

    public void setIsPropertyOrderOrderNameRemoved(Boolean removed) {
        this.isPropertyOrderOrderNameRemoved = removed;
    }

    private Boolean isPropertyOrderExternalIdRemoved;

    public Boolean getIsPropertyOrderExternalIdRemoved() {
        return this.isPropertyOrderExternalIdRemoved;
    }

    public void setIsPropertyOrderExternalIdRemoved(Boolean removed) {
        this.isPropertyOrderExternalIdRemoved = removed;
    }

    private Boolean isPropertyOrderSalesChannelEnumIdRemoved;

    public Boolean getIsPropertyOrderSalesChannelEnumIdRemoved() {
        return this.isPropertyOrderSalesChannelEnumIdRemoved;
    }

    public void setIsPropertyOrderSalesChannelEnumIdRemoved(Boolean removed) {
        this.isPropertyOrderSalesChannelEnumIdRemoved = removed;
    }

    private Boolean isPropertyOrderOrderDateRemoved;

    public Boolean getIsPropertyOrderOrderDateRemoved() {
        return this.isPropertyOrderOrderDateRemoved;
    }

    public void setIsPropertyOrderOrderDateRemoved(Boolean removed) {
        this.isPropertyOrderOrderDateRemoved = removed;
    }

    private Boolean isPropertyOrderPriorityRemoved;

    public Boolean getIsPropertyOrderPriorityRemoved() {
        return this.isPropertyOrderPriorityRemoved;
    }

    public void setIsPropertyOrderPriorityRemoved(Boolean removed) {
        this.isPropertyOrderPriorityRemoved = removed;
    }

    private Boolean isPropertyOrderEntryDateRemoved;

    public Boolean getIsPropertyOrderEntryDateRemoved() {
        return this.isPropertyOrderEntryDateRemoved;
    }

    public void setIsPropertyOrderEntryDateRemoved(Boolean removed) {
        this.isPropertyOrderEntryDateRemoved = removed;
    }

    private Boolean isPropertyOrderPickSheetPrintedDateRemoved;

    public Boolean getIsPropertyOrderPickSheetPrintedDateRemoved() {
        return this.isPropertyOrderPickSheetPrintedDateRemoved;
    }

    public void setIsPropertyOrderPickSheetPrintedDateRemoved(Boolean removed) {
        this.isPropertyOrderPickSheetPrintedDateRemoved = removed;
    }

    private Boolean isPropertyOrderStatusIdRemoved;

    public Boolean getIsPropertyOrderStatusIdRemoved() {
        return this.isPropertyOrderStatusIdRemoved;
    }

    public void setIsPropertyOrderStatusIdRemoved(Boolean removed) {
        this.isPropertyOrderStatusIdRemoved = removed;
    }

    private Boolean isPropertyOrderCurrencyUomRemoved;

    public Boolean getIsPropertyOrderCurrencyUomRemoved() {
        return this.isPropertyOrderCurrencyUomRemoved;
    }

    public void setIsPropertyOrderCurrencyUomRemoved(Boolean removed) {
        this.isPropertyOrderCurrencyUomRemoved = removed;
    }

    private Boolean isPropertyOrderSyncStatusIdRemoved;

    public Boolean getIsPropertyOrderSyncStatusIdRemoved() {
        return this.isPropertyOrderSyncStatusIdRemoved;
    }

    public void setIsPropertyOrderSyncStatusIdRemoved(Boolean removed) {
        this.isPropertyOrderSyncStatusIdRemoved = removed;
    }

    private Boolean isPropertyOrderBillingAccountIdRemoved;

    public Boolean getIsPropertyOrderBillingAccountIdRemoved() {
        return this.isPropertyOrderBillingAccountIdRemoved;
    }

    public void setIsPropertyOrderBillingAccountIdRemoved(Boolean removed) {
        this.isPropertyOrderBillingAccountIdRemoved = removed;
    }

    private Boolean isPropertyOrderOriginFacilityIdRemoved;

    public Boolean getIsPropertyOrderOriginFacilityIdRemoved() {
        return this.isPropertyOrderOriginFacilityIdRemoved;
    }

    public void setIsPropertyOrderOriginFacilityIdRemoved(Boolean removed) {
        this.isPropertyOrderOriginFacilityIdRemoved = removed;
    }

    private Boolean isPropertyOrderWebSiteIdRemoved;

    public Boolean getIsPropertyOrderWebSiteIdRemoved() {
        return this.isPropertyOrderWebSiteIdRemoved;
    }

    public void setIsPropertyOrderWebSiteIdRemoved(Boolean removed) {
        this.isPropertyOrderWebSiteIdRemoved = removed;
    }

    private Boolean isPropertyOrderProductStoreIdRemoved;

    public Boolean getIsPropertyOrderProductStoreIdRemoved() {
        return this.isPropertyOrderProductStoreIdRemoved;
    }

    public void setIsPropertyOrderProductStoreIdRemoved(Boolean removed) {
        this.isPropertyOrderProductStoreIdRemoved = removed;
    }

    private Boolean isPropertyOrderTerminalIdRemoved;

    public Boolean getIsPropertyOrderTerminalIdRemoved() {
        return this.isPropertyOrderTerminalIdRemoved;
    }

    public void setIsPropertyOrderTerminalIdRemoved(Boolean removed) {
        this.isPropertyOrderTerminalIdRemoved = removed;
    }

    private Boolean isPropertyOrderTransactionIdRemoved;

    public Boolean getIsPropertyOrderTransactionIdRemoved() {
        return this.isPropertyOrderTransactionIdRemoved;
    }

    public void setIsPropertyOrderTransactionIdRemoved(Boolean removed) {
        this.isPropertyOrderTransactionIdRemoved = removed;
    }

    private Boolean isPropertyOrderAutoOrderShoppingListIdRemoved;

    public Boolean getIsPropertyOrderAutoOrderShoppingListIdRemoved() {
        return this.isPropertyOrderAutoOrderShoppingListIdRemoved;
    }

    public void setIsPropertyOrderAutoOrderShoppingListIdRemoved(Boolean removed) {
        this.isPropertyOrderAutoOrderShoppingListIdRemoved = removed;
    }

    private Boolean isPropertyOrderNeedsInventoryIssuanceRemoved;

    public Boolean getIsPropertyOrderNeedsInventoryIssuanceRemoved() {
        return this.isPropertyOrderNeedsInventoryIssuanceRemoved;
    }

    public void setIsPropertyOrderNeedsInventoryIssuanceRemoved(Boolean removed) {
        this.isPropertyOrderNeedsInventoryIssuanceRemoved = removed;
    }

    private Boolean isPropertyOrderIsRushOrderRemoved;

    public Boolean getIsPropertyOrderIsRushOrderRemoved() {
        return this.isPropertyOrderIsRushOrderRemoved;
    }

    public void setIsPropertyOrderIsRushOrderRemoved(Boolean removed) {
        this.isPropertyOrderIsRushOrderRemoved = removed;
    }

    private Boolean isPropertyOrderInternalCodeRemoved;

    public Boolean getIsPropertyOrderInternalCodeRemoved() {
        return this.isPropertyOrderInternalCodeRemoved;
    }

    public void setIsPropertyOrderInternalCodeRemoved(Boolean removed) {
        this.isPropertyOrderInternalCodeRemoved = removed;
    }

    private Boolean isPropertyOrderRemainingSubTotalRemoved;

    public Boolean getIsPropertyOrderRemainingSubTotalRemoved() {
        return this.isPropertyOrderRemainingSubTotalRemoved;
    }

    public void setIsPropertyOrderRemainingSubTotalRemoved(Boolean removed) {
        this.isPropertyOrderRemainingSubTotalRemoved = removed;
    }

    private Boolean isPropertyOrderGrandTotalRemoved;

    public Boolean getIsPropertyOrderGrandTotalRemoved() {
        return this.isPropertyOrderGrandTotalRemoved;
    }

    public void setIsPropertyOrderGrandTotalRemoved(Boolean removed) {
        this.isPropertyOrderGrandTotalRemoved = removed;
    }

    private Boolean isPropertyOrderInvoicePerShipmentRemoved;

    public Boolean getIsPropertyOrderInvoicePerShipmentRemoved() {
        return this.isPropertyOrderInvoicePerShipmentRemoved;
    }

    public void setIsPropertyOrderInvoicePerShipmentRemoved(Boolean removed) {
        this.isPropertyOrderInvoicePerShipmentRemoved = removed;
    }

    private Boolean isPropertyOrderCreatedByRemoved;

    public Boolean getIsPropertyOrderCreatedByRemoved() {
        return this.isPropertyOrderCreatedByRemoved;
    }

    public void setIsPropertyOrderCreatedByRemoved(Boolean removed) {
        this.isPropertyOrderCreatedByRemoved = removed;
    }

    private Boolean isPropertyOrderCreatedAtRemoved;

    public Boolean getIsPropertyOrderCreatedAtRemoved() {
        return this.isPropertyOrderCreatedAtRemoved;
    }

    public void setIsPropertyOrderCreatedAtRemoved(Boolean removed) {
        this.isPropertyOrderCreatedAtRemoved = removed;
    }

    private Boolean isPropertyOrderUpdatedByRemoved;

    public Boolean getIsPropertyOrderUpdatedByRemoved() {
        return this.isPropertyOrderUpdatedByRemoved;
    }

    public void setIsPropertyOrderUpdatedByRemoved(Boolean removed) {
        this.isPropertyOrderUpdatedByRemoved = removed;
    }

    private Boolean isPropertyOrderUpdatedAtRemoved;

    public Boolean getIsPropertyOrderUpdatedAtRemoved() {
        return this.isPropertyOrderUpdatedAtRemoved;
    }

    public void setIsPropertyOrderUpdatedAtRemoved(Boolean removed) {
        this.isPropertyOrderUpdatedAtRemoved = removed;
    }

    private Boolean isPropertyOrderActiveRemoved;

    public Boolean getIsPropertyOrderActiveRemoved() {
        return this.isPropertyOrderActiveRemoved;
    }

    public void setIsPropertyOrderActiveRemoved(Boolean removed) {
        this.isPropertyOrderActiveRemoved = removed;
    }


	public static class OrderItemShipGroupAssociationMvoStateCreatedDto extends OrderItemShipGroupAssociationMvoStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class OrderItemShipGroupAssociationMvoStateMergePatchedDto extends OrderItemShipGroupAssociationMvoStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class OrderItemShipGroupAssociationMvoStateDeletedDto extends OrderItemShipGroupAssociationMvoStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

