package org.dddml.wms.domain.orderitemshipgroupassociationmvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class OrderItemShipGroupAssociationMvoStateDto
{

    private OrderItemShipGroupAssociationId orderItemShipGroupAssociationId;

    public OrderItemShipGroupAssociationId getOrderItemShipGroupAssociationId()
    {
        return this.orderItemShipGroupAssociationId;
    }

    public void setOrderItemShipGroupAssociationId(OrderItemShipGroupAssociationId orderItemShipGroupAssociationId)
    {
        this.orderItemShipGroupAssociationId = orderItemShipGroupAssociationId;
    }

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    private java.math.BigDecimal cancelQuantity;

    public java.math.BigDecimal getCancelQuantity()
    {
        return this.cancelQuantity;
    }

    public void setCancelQuantity(java.math.BigDecimal cancelQuantity)
    {
        this.cancelQuantity = cancelQuantity;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private String orderShipGroupShipmentMethodTypeId;

    public String getOrderShipGroupShipmentMethodTypeId()
    {
        return this.orderShipGroupShipmentMethodTypeId;
    }

    public void setOrderShipGroupShipmentMethodTypeId(String orderShipGroupShipmentMethodTypeId)
    {
        this.orderShipGroupShipmentMethodTypeId = orderShipGroupShipmentMethodTypeId;
    }

    private String orderShipGroupSupplierPartyId;

    public String getOrderShipGroupSupplierPartyId()
    {
        return this.orderShipGroupSupplierPartyId;
    }

    public void setOrderShipGroupSupplierPartyId(String orderShipGroupSupplierPartyId)
    {
        this.orderShipGroupSupplierPartyId = orderShipGroupSupplierPartyId;
    }

    private String orderShipGroupVendorPartyId;

    public String getOrderShipGroupVendorPartyId()
    {
        return this.orderShipGroupVendorPartyId;
    }

    public void setOrderShipGroupVendorPartyId(String orderShipGroupVendorPartyId)
    {
        this.orderShipGroupVendorPartyId = orderShipGroupVendorPartyId;
    }

    private String orderShipGroupCarrierPartyId;

    public String getOrderShipGroupCarrierPartyId()
    {
        return this.orderShipGroupCarrierPartyId;
    }

    public void setOrderShipGroupCarrierPartyId(String orderShipGroupCarrierPartyId)
    {
        this.orderShipGroupCarrierPartyId = orderShipGroupCarrierPartyId;
    }

    private String orderShipGroupCarrierRoleTypeId;

    public String getOrderShipGroupCarrierRoleTypeId()
    {
        return this.orderShipGroupCarrierRoleTypeId;
    }

    public void setOrderShipGroupCarrierRoleTypeId(String orderShipGroupCarrierRoleTypeId)
    {
        this.orderShipGroupCarrierRoleTypeId = orderShipGroupCarrierRoleTypeId;
    }

    private String orderShipGroupFacilityId;

    public String getOrderShipGroupFacilityId()
    {
        return this.orderShipGroupFacilityId;
    }

    public void setOrderShipGroupFacilityId(String orderShipGroupFacilityId)
    {
        this.orderShipGroupFacilityId = orderShipGroupFacilityId;
    }

    private String orderShipGroupContactMechId;

    public String getOrderShipGroupContactMechId()
    {
        return this.orderShipGroupContactMechId;
    }

    public void setOrderShipGroupContactMechId(String orderShipGroupContactMechId)
    {
        this.orderShipGroupContactMechId = orderShipGroupContactMechId;
    }

    private String orderShipGroupTelecomContactMechId;

    public String getOrderShipGroupTelecomContactMechId()
    {
        return this.orderShipGroupTelecomContactMechId;
    }

    public void setOrderShipGroupTelecomContactMechId(String orderShipGroupTelecomContactMechId)
    {
        this.orderShipGroupTelecomContactMechId = orderShipGroupTelecomContactMechId;
    }

    private String orderShipGroupTrackingNumber;

    public String getOrderShipGroupTrackingNumber()
    {
        return this.orderShipGroupTrackingNumber;
    }

    public void setOrderShipGroupTrackingNumber(String orderShipGroupTrackingNumber)
    {
        this.orderShipGroupTrackingNumber = orderShipGroupTrackingNumber;
    }

    private String orderShipGroupShippingInstructions;

    public String getOrderShipGroupShippingInstructions()
    {
        return this.orderShipGroupShippingInstructions;
    }

    public void setOrderShipGroupShippingInstructions(String orderShipGroupShippingInstructions)
    {
        this.orderShipGroupShippingInstructions = orderShipGroupShippingInstructions;
    }

    private String orderShipGroupMaySplit;

    public String getOrderShipGroupMaySplit()
    {
        return this.orderShipGroupMaySplit;
    }

    public void setOrderShipGroupMaySplit(String orderShipGroupMaySplit)
    {
        this.orderShipGroupMaySplit = orderShipGroupMaySplit;
    }

    private String orderShipGroupGiftMessage;

    public String getOrderShipGroupGiftMessage()
    {
        return this.orderShipGroupGiftMessage;
    }

    public void setOrderShipGroupGiftMessage(String orderShipGroupGiftMessage)
    {
        this.orderShipGroupGiftMessage = orderShipGroupGiftMessage;
    }

    private String orderShipGroupIsGift;

    public String getOrderShipGroupIsGift()
    {
        return this.orderShipGroupIsGift;
    }

    public void setOrderShipGroupIsGift(String orderShipGroupIsGift)
    {
        this.orderShipGroupIsGift = orderShipGroupIsGift;
    }

    private java.sql.Timestamp orderShipGroupShipAfterDate;

    public java.sql.Timestamp getOrderShipGroupShipAfterDate()
    {
        return this.orderShipGroupShipAfterDate;
    }

    public void setOrderShipGroupShipAfterDate(java.sql.Timestamp orderShipGroupShipAfterDate)
    {
        this.orderShipGroupShipAfterDate = orderShipGroupShipAfterDate;
    }

    private java.sql.Timestamp orderShipGroupShipByDate;

    public java.sql.Timestamp getOrderShipGroupShipByDate()
    {
        return this.orderShipGroupShipByDate;
    }

    public void setOrderShipGroupShipByDate(java.sql.Timestamp orderShipGroupShipByDate)
    {
        this.orderShipGroupShipByDate = orderShipGroupShipByDate;
    }

    private java.sql.Timestamp orderShipGroupEstimatedShipDate;

    public java.sql.Timestamp getOrderShipGroupEstimatedShipDate()
    {
        return this.orderShipGroupEstimatedShipDate;
    }

    public void setOrderShipGroupEstimatedShipDate(java.sql.Timestamp orderShipGroupEstimatedShipDate)
    {
        this.orderShipGroupEstimatedShipDate = orderShipGroupEstimatedShipDate;
    }

    private java.sql.Timestamp orderShipGroupEstimatedDeliveryDate;

    public java.sql.Timestamp getOrderShipGroupEstimatedDeliveryDate()
    {
        return this.orderShipGroupEstimatedDeliveryDate;
    }

    public void setOrderShipGroupEstimatedDeliveryDate(java.sql.Timestamp orderShipGroupEstimatedDeliveryDate)
    {
        this.orderShipGroupEstimatedDeliveryDate = orderShipGroupEstimatedDeliveryDate;
    }

    private Long orderShipGroupPickwaveId;

    public Long getOrderShipGroupPickwaveId()
    {
        return this.orderShipGroupPickwaveId;
    }

    public void setOrderShipGroupPickwaveId(Long orderShipGroupPickwaveId)
    {
        this.orderShipGroupPickwaveId = orderShipGroupPickwaveId;
    }

    private Long orderShipGroupVersion;

    public Long getOrderShipGroupVersion()
    {
        return this.orderShipGroupVersion;
    }

    public void setOrderShipGroupVersion(Long orderShipGroupVersion)
    {
        this.orderShipGroupVersion = orderShipGroupVersion;
    }

    private String orderShipGroupCreatedBy;

    public String getOrderShipGroupCreatedBy()
    {
        return this.orderShipGroupCreatedBy;
    }

    public void setOrderShipGroupCreatedBy(String orderShipGroupCreatedBy)
    {
        this.orderShipGroupCreatedBy = orderShipGroupCreatedBy;
    }

    private Date orderShipGroupCreatedAt;

    public Date getOrderShipGroupCreatedAt()
    {
        return this.orderShipGroupCreatedAt;
    }

    public void setOrderShipGroupCreatedAt(Date orderShipGroupCreatedAt)
    {
        this.orderShipGroupCreatedAt = orderShipGroupCreatedAt;
    }

    private String orderShipGroupUpdatedBy;

    public String getOrderShipGroupUpdatedBy()
    {
        return this.orderShipGroupUpdatedBy;
    }

    public void setOrderShipGroupUpdatedBy(String orderShipGroupUpdatedBy)
    {
        this.orderShipGroupUpdatedBy = orderShipGroupUpdatedBy;
    }

    private Date orderShipGroupUpdatedAt;

    public Date getOrderShipGroupUpdatedAt()
    {
        return this.orderShipGroupUpdatedAt;
    }

    public void setOrderShipGroupUpdatedAt(Date orderShipGroupUpdatedAt)
    {
        this.orderShipGroupUpdatedAt = orderShipGroupUpdatedAt;
    }

    private Boolean orderShipGroupActive;

    public Boolean getOrderShipGroupActive()
    {
        return this.orderShipGroupActive;
    }

    public void setOrderShipGroupActive(Boolean orderShipGroupActive)
    {
        this.orderShipGroupActive = orderShipGroupActive;
    }

    private Boolean orderShipGroupDeleted;

    public Boolean getOrderShipGroupDeleted()
    {
        return this.orderShipGroupDeleted;
    }

    public void setOrderShipGroupDeleted(Boolean orderShipGroupDeleted)
    {
        this.orderShipGroupDeleted = orderShipGroupDeleted;
    }

    private String orderOrderTypeId;

    public String getOrderOrderTypeId()
    {
        return this.orderOrderTypeId;
    }

    public void setOrderOrderTypeId(String orderOrderTypeId)
    {
        this.orderOrderTypeId = orderOrderTypeId;
    }

    private String orderOrderName;

    public String getOrderOrderName()
    {
        return this.orderOrderName;
    }

    public void setOrderOrderName(String orderOrderName)
    {
        this.orderOrderName = orderOrderName;
    }

    private String orderExternalId;

    public String getOrderExternalId()
    {
        return this.orderExternalId;
    }

    public void setOrderExternalId(String orderExternalId)
    {
        this.orderExternalId = orderExternalId;
    }

    private String orderSalesChannelEnumId;

    public String getOrderSalesChannelEnumId()
    {
        return this.orderSalesChannelEnumId;
    }

    public void setOrderSalesChannelEnumId(String orderSalesChannelEnumId)
    {
        this.orderSalesChannelEnumId = orderSalesChannelEnumId;
    }

    private java.sql.Timestamp orderOrderDate;

    public java.sql.Timestamp getOrderOrderDate()
    {
        return this.orderOrderDate;
    }

    public void setOrderOrderDate(java.sql.Timestamp orderOrderDate)
    {
        this.orderOrderDate = orderOrderDate;
    }

    private String orderPriority;

    public String getOrderPriority()
    {
        return this.orderPriority;
    }

    public void setOrderPriority(String orderPriority)
    {
        this.orderPriority = orderPriority;
    }

    private java.sql.Timestamp orderEntryDate;

    public java.sql.Timestamp getOrderEntryDate()
    {
        return this.orderEntryDate;
    }

    public void setOrderEntryDate(java.sql.Timestamp orderEntryDate)
    {
        this.orderEntryDate = orderEntryDate;
    }

    private java.sql.Timestamp orderPickSheetPrintedDate;

    public java.sql.Timestamp getOrderPickSheetPrintedDate()
    {
        return this.orderPickSheetPrintedDate;
    }

    public void setOrderPickSheetPrintedDate(java.sql.Timestamp orderPickSheetPrintedDate)
    {
        this.orderPickSheetPrintedDate = orderPickSheetPrintedDate;
    }

    private String orderStatusId;

    public String getOrderStatusId()
    {
        return this.orderStatusId;
    }

    public void setOrderStatusId(String orderStatusId)
    {
        this.orderStatusId = orderStatusId;
    }

    private String orderCurrencyUom;

    public String getOrderCurrencyUom()
    {
        return this.orderCurrencyUom;
    }

    public void setOrderCurrencyUom(String orderCurrencyUom)
    {
        this.orderCurrencyUom = orderCurrencyUom;
    }

    private String orderSyncStatusId;

    public String getOrderSyncStatusId()
    {
        return this.orderSyncStatusId;
    }

    public void setOrderSyncStatusId(String orderSyncStatusId)
    {
        this.orderSyncStatusId = orderSyncStatusId;
    }

    private String orderBillingAccountId;

    public String getOrderBillingAccountId()
    {
        return this.orderBillingAccountId;
    }

    public void setOrderBillingAccountId(String orderBillingAccountId)
    {
        this.orderBillingAccountId = orderBillingAccountId;
    }

    private String orderOriginFacilityId;

    public String getOrderOriginFacilityId()
    {
        return this.orderOriginFacilityId;
    }

    public void setOrderOriginFacilityId(String orderOriginFacilityId)
    {
        this.orderOriginFacilityId = orderOriginFacilityId;
    }

    private String orderWebSiteId;

    public String getOrderWebSiteId()
    {
        return this.orderWebSiteId;
    }

    public void setOrderWebSiteId(String orderWebSiteId)
    {
        this.orderWebSiteId = orderWebSiteId;
    }

    private String orderProductStoreId;

    public String getOrderProductStoreId()
    {
        return this.orderProductStoreId;
    }

    public void setOrderProductStoreId(String orderProductStoreId)
    {
        this.orderProductStoreId = orderProductStoreId;
    }

    private String orderTerminalId;

    public String getOrderTerminalId()
    {
        return this.orderTerminalId;
    }

    public void setOrderTerminalId(String orderTerminalId)
    {
        this.orderTerminalId = orderTerminalId;
    }

    private String orderTransactionId;

    public String getOrderTransactionId()
    {
        return this.orderTransactionId;
    }

    public void setOrderTransactionId(String orderTransactionId)
    {
        this.orderTransactionId = orderTransactionId;
    }

    private String orderAutoOrderShoppingListId;

    public String getOrderAutoOrderShoppingListId()
    {
        return this.orderAutoOrderShoppingListId;
    }

    public void setOrderAutoOrderShoppingListId(String orderAutoOrderShoppingListId)
    {
        this.orderAutoOrderShoppingListId = orderAutoOrderShoppingListId;
    }

    private String orderNeedsInventoryIssuance;

    public String getOrderNeedsInventoryIssuance()
    {
        return this.orderNeedsInventoryIssuance;
    }

    public void setOrderNeedsInventoryIssuance(String orderNeedsInventoryIssuance)
    {
        this.orderNeedsInventoryIssuance = orderNeedsInventoryIssuance;
    }

    private String orderIsRushOrder;

    public String getOrderIsRushOrder()
    {
        return this.orderIsRushOrder;
    }

    public void setOrderIsRushOrder(String orderIsRushOrder)
    {
        this.orderIsRushOrder = orderIsRushOrder;
    }

    private String orderInternalCode;

    public String getOrderInternalCode()
    {
        return this.orderInternalCode;
    }

    public void setOrderInternalCode(String orderInternalCode)
    {
        this.orderInternalCode = orderInternalCode;
    }

    private java.math.BigDecimal orderRemainingSubTotal;

    public java.math.BigDecimal getOrderRemainingSubTotal()
    {
        return this.orderRemainingSubTotal;
    }

    public void setOrderRemainingSubTotal(java.math.BigDecimal orderRemainingSubTotal)
    {
        this.orderRemainingSubTotal = orderRemainingSubTotal;
    }

    private java.math.BigDecimal orderGrandTotal;

    public java.math.BigDecimal getOrderGrandTotal()
    {
        return this.orderGrandTotal;
    }

    public void setOrderGrandTotal(java.math.BigDecimal orderGrandTotal)
    {
        this.orderGrandTotal = orderGrandTotal;
    }

    private String orderInvoicePerShipment;

    public String getOrderInvoicePerShipment()
    {
        return this.orderInvoicePerShipment;
    }

    public void setOrderInvoicePerShipment(String orderInvoicePerShipment)
    {
        this.orderInvoicePerShipment = orderInvoicePerShipment;
    }

    private String orderCreatedBy;

    public String getOrderCreatedBy()
    {
        return this.orderCreatedBy;
    }

    public void setOrderCreatedBy(String orderCreatedBy)
    {
        this.orderCreatedBy = orderCreatedBy;
    }

    private Date orderCreatedAt;

    public Date getOrderCreatedAt()
    {
        return this.orderCreatedAt;
    }

    public void setOrderCreatedAt(Date orderCreatedAt)
    {
        this.orderCreatedAt = orderCreatedAt;
    }

    private String orderUpdatedBy;

    public String getOrderUpdatedBy()
    {
        return this.orderUpdatedBy;
    }

    public void setOrderUpdatedBy(String orderUpdatedBy)
    {
        this.orderUpdatedBy = orderUpdatedBy;
    }

    private Date orderUpdatedAt;

    public Date getOrderUpdatedAt()
    {
        return this.orderUpdatedAt;
    }

    public void setOrderUpdatedAt(Date orderUpdatedAt)
    {
        this.orderUpdatedAt = orderUpdatedAt;
    }

    private Boolean orderActive;

    public Boolean getOrderActive()
    {
        return this.orderActive;
    }

    public void setOrderActive(Boolean orderActive)
    {
        this.orderActive = orderActive;
    }

    private Long orderVersion;

    public Long getOrderVersion()
    {
        return this.orderVersion;
    }

    public void setOrderVersion(Long orderVersion)
    {
        this.orderVersion = orderVersion;
    }

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

}

