package org.dddml.wms.domain.orderitemshipgroupassociationmvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.orderitemshipgroupassociationmvo.OrderItemShipGroupAssociationMvoEvent.*;

public abstract class AbstractOrderItemShipGroupAssociationMvoState implements OrderItemShipGroupAssociationMvoState
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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Boolean deleted;

    public Boolean getDeleted()
    {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
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

    private Long orderVersion;

    public Long getOrderVersion()
    {
        return this.orderVersion;
    }

    public void setOrderVersion(Long orderVersion)
    {
        this.orderVersion = orderVersion;
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

    public boolean isStateUnsaved() 
    {
        return this.getOrderVersion() == null;
    }

    private Boolean stateReadOnly;

    public Boolean getStateReadOnly() { return this.stateReadOnly; }

    public void setStateReadOnly(Boolean readOnly) { this.stateReadOnly = readOnly; }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    public AbstractOrderItemShipGroupAssociationMvoState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setOrderItemShipGroupAssociationId(((OrderItemShipGroupAssociationMvoEvent) events.get(0)).getOrderItemShipGroupAssociationMvoEventId().getOrderItemShipGroupAssociationId());
            for (Event e : events) {
                mutate(e);
                this.setOrderVersion(this.getOrderVersion() + 1);
            }
        }
    }


    public AbstractOrderItemShipGroupAssociationMvoState() {
        this(false);
    }

    public AbstractOrderItemShipGroupAssociationMvoState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof OrderItemShipGroupAssociationMvoStateCreated) {
            when((OrderItemShipGroupAssociationMvoStateCreated) e);
        } else if (e instanceof OrderItemShipGroupAssociationMvoStateMergePatched) {
            when((OrderItemShipGroupAssociationMvoStateMergePatched) e);
        } else if (e instanceof OrderItemShipGroupAssociationMvoStateDeleted) {
            when((OrderItemShipGroupAssociationMvoStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(OrderItemShipGroupAssociationMvoStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setQuantity(e.getQuantity());
        this.setCancelQuantity(e.getCancelQuantity());
        this.setVersion(e.getVersion());
        this.setActive(e.getActive());
        this.setOrderShipGroupShipmentMethodTypeId(e.getOrderShipGroupShipmentMethodTypeId());
        this.setOrderShipGroupSupplierPartyId(e.getOrderShipGroupSupplierPartyId());
        this.setOrderShipGroupVendorPartyId(e.getOrderShipGroupVendorPartyId());
        this.setOrderShipGroupCarrierPartyId(e.getOrderShipGroupCarrierPartyId());
        this.setOrderShipGroupCarrierRoleTypeId(e.getOrderShipGroupCarrierRoleTypeId());
        this.setOrderShipGroupFacilityId(e.getOrderShipGroupFacilityId());
        this.setOrderShipGroupContactMechId(e.getOrderShipGroupContactMechId());
        this.setOrderShipGroupTelecomContactMechId(e.getOrderShipGroupTelecomContactMechId());
        this.setOrderShipGroupTrackingNumber(e.getOrderShipGroupTrackingNumber());
        this.setOrderShipGroupShippingInstructions(e.getOrderShipGroupShippingInstructions());
        this.setOrderShipGroupMaySplit(e.getOrderShipGroupMaySplit());
        this.setOrderShipGroupGiftMessage(e.getOrderShipGroupGiftMessage());
        this.setOrderShipGroupIsGift(e.getOrderShipGroupIsGift());
        this.setOrderShipGroupShipAfterDate(e.getOrderShipGroupShipAfterDate());
        this.setOrderShipGroupShipByDate(e.getOrderShipGroupShipByDate());
        this.setOrderShipGroupEstimatedShipDate(e.getOrderShipGroupEstimatedShipDate());
        this.setOrderShipGroupEstimatedDeliveryDate(e.getOrderShipGroupEstimatedDeliveryDate());
        this.setOrderShipGroupPickwaveId(e.getOrderShipGroupPickwaveId());
        this.setOrderShipGroupVersion(e.getOrderShipGroupVersion());
        this.setOrderShipGroupCreatedBy(e.getOrderShipGroupCreatedBy());
        this.setOrderShipGroupCreatedAt(e.getOrderShipGroupCreatedAt());
        this.setOrderShipGroupUpdatedBy(e.getOrderShipGroupUpdatedBy());
        this.setOrderShipGroupUpdatedAt(e.getOrderShipGroupUpdatedAt());
        this.setOrderShipGroupActive(e.getOrderShipGroupActive());
        this.setOrderShipGroupDeleted(e.getOrderShipGroupDeleted());
        this.setOrderOrderTypeId(e.getOrderOrderTypeId());
        this.setOrderOrderName(e.getOrderOrderName());
        this.setOrderExternalId(e.getOrderExternalId());
        this.setOrderSalesChannelEnumId(e.getOrderSalesChannelEnumId());
        this.setOrderOrderDate(e.getOrderOrderDate());
        this.setOrderPriority(e.getOrderPriority());
        this.setOrderEntryDate(e.getOrderEntryDate());
        this.setOrderPickSheetPrintedDate(e.getOrderPickSheetPrintedDate());
        this.setOrderStatusId(e.getOrderStatusId());
        this.setOrderCurrencyUom(e.getOrderCurrencyUom());
        this.setOrderSyncStatusId(e.getOrderSyncStatusId());
        this.setOrderBillingAccountId(e.getOrderBillingAccountId());
        this.setOrderOriginFacilityId(e.getOrderOriginFacilityId());
        this.setOrderWebSiteId(e.getOrderWebSiteId());
        this.setOrderProductStoreId(e.getOrderProductStoreId());
        this.setOrderTerminalId(e.getOrderTerminalId());
        this.setOrderTransactionId(e.getOrderTransactionId());
        this.setOrderAutoOrderShoppingListId(e.getOrderAutoOrderShoppingListId());
        this.setOrderNeedsInventoryIssuance(e.getOrderNeedsInventoryIssuance());
        this.setOrderIsRushOrder(e.getOrderIsRushOrder());
        this.setOrderInternalCode(e.getOrderInternalCode());
        this.setOrderRemainingSubTotal(e.getOrderRemainingSubTotal());
        this.setOrderGrandTotal(e.getOrderGrandTotal());
        this.setOrderInvoicePerShipment(e.getOrderInvoicePerShipment());
        this.setOrderCreatedBy(e.getOrderCreatedBy());
        this.setOrderCreatedAt(e.getOrderCreatedAt());
        this.setOrderUpdatedBy(e.getOrderUpdatedBy());
        this.setOrderUpdatedAt(e.getOrderUpdatedAt());
        this.setOrderActive(e.getOrderActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(OrderItemShipGroupAssociationMvoStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getQuantity() == null)
        {
            if (e.getIsPropertyQuantityRemoved() != null && e.getIsPropertyQuantityRemoved())
            {
                this.setQuantity(null);
            }
        }
        else
        {
            this.setQuantity(e.getQuantity());
        }
        if (e.getCancelQuantity() == null)
        {
            if (e.getIsPropertyCancelQuantityRemoved() != null && e.getIsPropertyCancelQuantityRemoved())
            {
                this.setCancelQuantity(null);
            }
        }
        else
        {
            this.setCancelQuantity(e.getCancelQuantity());
        }
        if (e.getVersion() == null)
        {
            if (e.getIsPropertyVersionRemoved() != null && e.getIsPropertyVersionRemoved())
            {
                this.setVersion(null);
            }
        }
        else
        {
            this.setVersion(e.getVersion());
        }
        if (e.getActive() == null)
        {
            if (e.getIsPropertyActiveRemoved() != null && e.getIsPropertyActiveRemoved())
            {
                this.setActive(null);
            }
        }
        else
        {
            this.setActive(e.getActive());
        }
        if (e.getOrderShipGroupShipmentMethodTypeId() == null)
        {
            if (e.getIsPropertyOrderShipGroupShipmentMethodTypeIdRemoved() != null && e.getIsPropertyOrderShipGroupShipmentMethodTypeIdRemoved())
            {
                this.setOrderShipGroupShipmentMethodTypeId(null);
            }
        }
        else
        {
            this.setOrderShipGroupShipmentMethodTypeId(e.getOrderShipGroupShipmentMethodTypeId());
        }
        if (e.getOrderShipGroupSupplierPartyId() == null)
        {
            if (e.getIsPropertyOrderShipGroupSupplierPartyIdRemoved() != null && e.getIsPropertyOrderShipGroupSupplierPartyIdRemoved())
            {
                this.setOrderShipGroupSupplierPartyId(null);
            }
        }
        else
        {
            this.setOrderShipGroupSupplierPartyId(e.getOrderShipGroupSupplierPartyId());
        }
        if (e.getOrderShipGroupVendorPartyId() == null)
        {
            if (e.getIsPropertyOrderShipGroupVendorPartyIdRemoved() != null && e.getIsPropertyOrderShipGroupVendorPartyIdRemoved())
            {
                this.setOrderShipGroupVendorPartyId(null);
            }
        }
        else
        {
            this.setOrderShipGroupVendorPartyId(e.getOrderShipGroupVendorPartyId());
        }
        if (e.getOrderShipGroupCarrierPartyId() == null)
        {
            if (e.getIsPropertyOrderShipGroupCarrierPartyIdRemoved() != null && e.getIsPropertyOrderShipGroupCarrierPartyIdRemoved())
            {
                this.setOrderShipGroupCarrierPartyId(null);
            }
        }
        else
        {
            this.setOrderShipGroupCarrierPartyId(e.getOrderShipGroupCarrierPartyId());
        }
        if (e.getOrderShipGroupCarrierRoleTypeId() == null)
        {
            if (e.getIsPropertyOrderShipGroupCarrierRoleTypeIdRemoved() != null && e.getIsPropertyOrderShipGroupCarrierRoleTypeIdRemoved())
            {
                this.setOrderShipGroupCarrierRoleTypeId(null);
            }
        }
        else
        {
            this.setOrderShipGroupCarrierRoleTypeId(e.getOrderShipGroupCarrierRoleTypeId());
        }
        if (e.getOrderShipGroupFacilityId() == null)
        {
            if (e.getIsPropertyOrderShipGroupFacilityIdRemoved() != null && e.getIsPropertyOrderShipGroupFacilityIdRemoved())
            {
                this.setOrderShipGroupFacilityId(null);
            }
        }
        else
        {
            this.setOrderShipGroupFacilityId(e.getOrderShipGroupFacilityId());
        }
        if (e.getOrderShipGroupContactMechId() == null)
        {
            if (e.getIsPropertyOrderShipGroupContactMechIdRemoved() != null && e.getIsPropertyOrderShipGroupContactMechIdRemoved())
            {
                this.setOrderShipGroupContactMechId(null);
            }
        }
        else
        {
            this.setOrderShipGroupContactMechId(e.getOrderShipGroupContactMechId());
        }
        if (e.getOrderShipGroupTelecomContactMechId() == null)
        {
            if (e.getIsPropertyOrderShipGroupTelecomContactMechIdRemoved() != null && e.getIsPropertyOrderShipGroupTelecomContactMechIdRemoved())
            {
                this.setOrderShipGroupTelecomContactMechId(null);
            }
        }
        else
        {
            this.setOrderShipGroupTelecomContactMechId(e.getOrderShipGroupTelecomContactMechId());
        }
        if (e.getOrderShipGroupTrackingNumber() == null)
        {
            if (e.getIsPropertyOrderShipGroupTrackingNumberRemoved() != null && e.getIsPropertyOrderShipGroupTrackingNumberRemoved())
            {
                this.setOrderShipGroupTrackingNumber(null);
            }
        }
        else
        {
            this.setOrderShipGroupTrackingNumber(e.getOrderShipGroupTrackingNumber());
        }
        if (e.getOrderShipGroupShippingInstructions() == null)
        {
            if (e.getIsPropertyOrderShipGroupShippingInstructionsRemoved() != null && e.getIsPropertyOrderShipGroupShippingInstructionsRemoved())
            {
                this.setOrderShipGroupShippingInstructions(null);
            }
        }
        else
        {
            this.setOrderShipGroupShippingInstructions(e.getOrderShipGroupShippingInstructions());
        }
        if (e.getOrderShipGroupMaySplit() == null)
        {
            if (e.getIsPropertyOrderShipGroupMaySplitRemoved() != null && e.getIsPropertyOrderShipGroupMaySplitRemoved())
            {
                this.setOrderShipGroupMaySplit(null);
            }
        }
        else
        {
            this.setOrderShipGroupMaySplit(e.getOrderShipGroupMaySplit());
        }
        if (e.getOrderShipGroupGiftMessage() == null)
        {
            if (e.getIsPropertyOrderShipGroupGiftMessageRemoved() != null && e.getIsPropertyOrderShipGroupGiftMessageRemoved())
            {
                this.setOrderShipGroupGiftMessage(null);
            }
        }
        else
        {
            this.setOrderShipGroupGiftMessage(e.getOrderShipGroupGiftMessage());
        }
        if (e.getOrderShipGroupIsGift() == null)
        {
            if (e.getIsPropertyOrderShipGroupIsGiftRemoved() != null && e.getIsPropertyOrderShipGroupIsGiftRemoved())
            {
                this.setOrderShipGroupIsGift(null);
            }
        }
        else
        {
            this.setOrderShipGroupIsGift(e.getOrderShipGroupIsGift());
        }
        if (e.getOrderShipGroupShipAfterDate() == null)
        {
            if (e.getIsPropertyOrderShipGroupShipAfterDateRemoved() != null && e.getIsPropertyOrderShipGroupShipAfterDateRemoved())
            {
                this.setOrderShipGroupShipAfterDate(null);
            }
        }
        else
        {
            this.setOrderShipGroupShipAfterDate(e.getOrderShipGroupShipAfterDate());
        }
        if (e.getOrderShipGroupShipByDate() == null)
        {
            if (e.getIsPropertyOrderShipGroupShipByDateRemoved() != null && e.getIsPropertyOrderShipGroupShipByDateRemoved())
            {
                this.setOrderShipGroupShipByDate(null);
            }
        }
        else
        {
            this.setOrderShipGroupShipByDate(e.getOrderShipGroupShipByDate());
        }
        if (e.getOrderShipGroupEstimatedShipDate() == null)
        {
            if (e.getIsPropertyOrderShipGroupEstimatedShipDateRemoved() != null && e.getIsPropertyOrderShipGroupEstimatedShipDateRemoved())
            {
                this.setOrderShipGroupEstimatedShipDate(null);
            }
        }
        else
        {
            this.setOrderShipGroupEstimatedShipDate(e.getOrderShipGroupEstimatedShipDate());
        }
        if (e.getOrderShipGroupEstimatedDeliveryDate() == null)
        {
            if (e.getIsPropertyOrderShipGroupEstimatedDeliveryDateRemoved() != null && e.getIsPropertyOrderShipGroupEstimatedDeliveryDateRemoved())
            {
                this.setOrderShipGroupEstimatedDeliveryDate(null);
            }
        }
        else
        {
            this.setOrderShipGroupEstimatedDeliveryDate(e.getOrderShipGroupEstimatedDeliveryDate());
        }
        if (e.getOrderShipGroupPickwaveId() == null)
        {
            if (e.getIsPropertyOrderShipGroupPickwaveIdRemoved() != null && e.getIsPropertyOrderShipGroupPickwaveIdRemoved())
            {
                this.setOrderShipGroupPickwaveId(null);
            }
        }
        else
        {
            this.setOrderShipGroupPickwaveId(e.getOrderShipGroupPickwaveId());
        }
        if (e.getOrderShipGroupVersion() == null)
        {
            if (e.getIsPropertyOrderShipGroupVersionRemoved() != null && e.getIsPropertyOrderShipGroupVersionRemoved())
            {
                this.setOrderShipGroupVersion(null);
            }
        }
        else
        {
            this.setOrderShipGroupVersion(e.getOrderShipGroupVersion());
        }
        if (e.getOrderShipGroupCreatedBy() == null)
        {
            if (e.getIsPropertyOrderShipGroupCreatedByRemoved() != null && e.getIsPropertyOrderShipGroupCreatedByRemoved())
            {
                this.setOrderShipGroupCreatedBy(null);
            }
        }
        else
        {
            this.setOrderShipGroupCreatedBy(e.getOrderShipGroupCreatedBy());
        }
        if (e.getOrderShipGroupCreatedAt() == null)
        {
            if (e.getIsPropertyOrderShipGroupCreatedAtRemoved() != null && e.getIsPropertyOrderShipGroupCreatedAtRemoved())
            {
                this.setOrderShipGroupCreatedAt(null);
            }
        }
        else
        {
            this.setOrderShipGroupCreatedAt(e.getOrderShipGroupCreatedAt());
        }
        if (e.getOrderShipGroupUpdatedBy() == null)
        {
            if (e.getIsPropertyOrderShipGroupUpdatedByRemoved() != null && e.getIsPropertyOrderShipGroupUpdatedByRemoved())
            {
                this.setOrderShipGroupUpdatedBy(null);
            }
        }
        else
        {
            this.setOrderShipGroupUpdatedBy(e.getOrderShipGroupUpdatedBy());
        }
        if (e.getOrderShipGroupUpdatedAt() == null)
        {
            if (e.getIsPropertyOrderShipGroupUpdatedAtRemoved() != null && e.getIsPropertyOrderShipGroupUpdatedAtRemoved())
            {
                this.setOrderShipGroupUpdatedAt(null);
            }
        }
        else
        {
            this.setOrderShipGroupUpdatedAt(e.getOrderShipGroupUpdatedAt());
        }
        if (e.getOrderShipGroupActive() == null)
        {
            if (e.getIsPropertyOrderShipGroupActiveRemoved() != null && e.getIsPropertyOrderShipGroupActiveRemoved())
            {
                this.setOrderShipGroupActive(null);
            }
        }
        else
        {
            this.setOrderShipGroupActive(e.getOrderShipGroupActive());
        }
        if (e.getOrderShipGroupDeleted() == null)
        {
            if (e.getIsPropertyOrderShipGroupDeletedRemoved() != null && e.getIsPropertyOrderShipGroupDeletedRemoved())
            {
                this.setOrderShipGroupDeleted(null);
            }
        }
        else
        {
            this.setOrderShipGroupDeleted(e.getOrderShipGroupDeleted());
        }
        if (e.getOrderOrderTypeId() == null)
        {
            if (e.getIsPropertyOrderOrderTypeIdRemoved() != null && e.getIsPropertyOrderOrderTypeIdRemoved())
            {
                this.setOrderOrderTypeId(null);
            }
        }
        else
        {
            this.setOrderOrderTypeId(e.getOrderOrderTypeId());
        }
        if (e.getOrderOrderName() == null)
        {
            if (e.getIsPropertyOrderOrderNameRemoved() != null && e.getIsPropertyOrderOrderNameRemoved())
            {
                this.setOrderOrderName(null);
            }
        }
        else
        {
            this.setOrderOrderName(e.getOrderOrderName());
        }
        if (e.getOrderExternalId() == null)
        {
            if (e.getIsPropertyOrderExternalIdRemoved() != null && e.getIsPropertyOrderExternalIdRemoved())
            {
                this.setOrderExternalId(null);
            }
        }
        else
        {
            this.setOrderExternalId(e.getOrderExternalId());
        }
        if (e.getOrderSalesChannelEnumId() == null)
        {
            if (e.getIsPropertyOrderSalesChannelEnumIdRemoved() != null && e.getIsPropertyOrderSalesChannelEnumIdRemoved())
            {
                this.setOrderSalesChannelEnumId(null);
            }
        }
        else
        {
            this.setOrderSalesChannelEnumId(e.getOrderSalesChannelEnumId());
        }
        if (e.getOrderOrderDate() == null)
        {
            if (e.getIsPropertyOrderOrderDateRemoved() != null && e.getIsPropertyOrderOrderDateRemoved())
            {
                this.setOrderOrderDate(null);
            }
        }
        else
        {
            this.setOrderOrderDate(e.getOrderOrderDate());
        }
        if (e.getOrderPriority() == null)
        {
            if (e.getIsPropertyOrderPriorityRemoved() != null && e.getIsPropertyOrderPriorityRemoved())
            {
                this.setOrderPriority(null);
            }
        }
        else
        {
            this.setOrderPriority(e.getOrderPriority());
        }
        if (e.getOrderEntryDate() == null)
        {
            if (e.getIsPropertyOrderEntryDateRemoved() != null && e.getIsPropertyOrderEntryDateRemoved())
            {
                this.setOrderEntryDate(null);
            }
        }
        else
        {
            this.setOrderEntryDate(e.getOrderEntryDate());
        }
        if (e.getOrderPickSheetPrintedDate() == null)
        {
            if (e.getIsPropertyOrderPickSheetPrintedDateRemoved() != null && e.getIsPropertyOrderPickSheetPrintedDateRemoved())
            {
                this.setOrderPickSheetPrintedDate(null);
            }
        }
        else
        {
            this.setOrderPickSheetPrintedDate(e.getOrderPickSheetPrintedDate());
        }
        if (e.getOrderStatusId() == null)
        {
            if (e.getIsPropertyOrderStatusIdRemoved() != null && e.getIsPropertyOrderStatusIdRemoved())
            {
                this.setOrderStatusId(null);
            }
        }
        else
        {
            this.setOrderStatusId(e.getOrderStatusId());
        }
        if (e.getOrderCurrencyUom() == null)
        {
            if (e.getIsPropertyOrderCurrencyUomRemoved() != null && e.getIsPropertyOrderCurrencyUomRemoved())
            {
                this.setOrderCurrencyUom(null);
            }
        }
        else
        {
            this.setOrderCurrencyUom(e.getOrderCurrencyUom());
        }
        if (e.getOrderSyncStatusId() == null)
        {
            if (e.getIsPropertyOrderSyncStatusIdRemoved() != null && e.getIsPropertyOrderSyncStatusIdRemoved())
            {
                this.setOrderSyncStatusId(null);
            }
        }
        else
        {
            this.setOrderSyncStatusId(e.getOrderSyncStatusId());
        }
        if (e.getOrderBillingAccountId() == null)
        {
            if (e.getIsPropertyOrderBillingAccountIdRemoved() != null && e.getIsPropertyOrderBillingAccountIdRemoved())
            {
                this.setOrderBillingAccountId(null);
            }
        }
        else
        {
            this.setOrderBillingAccountId(e.getOrderBillingAccountId());
        }
        if (e.getOrderOriginFacilityId() == null)
        {
            if (e.getIsPropertyOrderOriginFacilityIdRemoved() != null && e.getIsPropertyOrderOriginFacilityIdRemoved())
            {
                this.setOrderOriginFacilityId(null);
            }
        }
        else
        {
            this.setOrderOriginFacilityId(e.getOrderOriginFacilityId());
        }
        if (e.getOrderWebSiteId() == null)
        {
            if (e.getIsPropertyOrderWebSiteIdRemoved() != null && e.getIsPropertyOrderWebSiteIdRemoved())
            {
                this.setOrderWebSiteId(null);
            }
        }
        else
        {
            this.setOrderWebSiteId(e.getOrderWebSiteId());
        }
        if (e.getOrderProductStoreId() == null)
        {
            if (e.getIsPropertyOrderProductStoreIdRemoved() != null && e.getIsPropertyOrderProductStoreIdRemoved())
            {
                this.setOrderProductStoreId(null);
            }
        }
        else
        {
            this.setOrderProductStoreId(e.getOrderProductStoreId());
        }
        if (e.getOrderTerminalId() == null)
        {
            if (e.getIsPropertyOrderTerminalIdRemoved() != null && e.getIsPropertyOrderTerminalIdRemoved())
            {
                this.setOrderTerminalId(null);
            }
        }
        else
        {
            this.setOrderTerminalId(e.getOrderTerminalId());
        }
        if (e.getOrderTransactionId() == null)
        {
            if (e.getIsPropertyOrderTransactionIdRemoved() != null && e.getIsPropertyOrderTransactionIdRemoved())
            {
                this.setOrderTransactionId(null);
            }
        }
        else
        {
            this.setOrderTransactionId(e.getOrderTransactionId());
        }
        if (e.getOrderAutoOrderShoppingListId() == null)
        {
            if (e.getIsPropertyOrderAutoOrderShoppingListIdRemoved() != null && e.getIsPropertyOrderAutoOrderShoppingListIdRemoved())
            {
                this.setOrderAutoOrderShoppingListId(null);
            }
        }
        else
        {
            this.setOrderAutoOrderShoppingListId(e.getOrderAutoOrderShoppingListId());
        }
        if (e.getOrderNeedsInventoryIssuance() == null)
        {
            if (e.getIsPropertyOrderNeedsInventoryIssuanceRemoved() != null && e.getIsPropertyOrderNeedsInventoryIssuanceRemoved())
            {
                this.setOrderNeedsInventoryIssuance(null);
            }
        }
        else
        {
            this.setOrderNeedsInventoryIssuance(e.getOrderNeedsInventoryIssuance());
        }
        if (e.getOrderIsRushOrder() == null)
        {
            if (e.getIsPropertyOrderIsRushOrderRemoved() != null && e.getIsPropertyOrderIsRushOrderRemoved())
            {
                this.setOrderIsRushOrder(null);
            }
        }
        else
        {
            this.setOrderIsRushOrder(e.getOrderIsRushOrder());
        }
        if (e.getOrderInternalCode() == null)
        {
            if (e.getIsPropertyOrderInternalCodeRemoved() != null && e.getIsPropertyOrderInternalCodeRemoved())
            {
                this.setOrderInternalCode(null);
            }
        }
        else
        {
            this.setOrderInternalCode(e.getOrderInternalCode());
        }
        if (e.getOrderRemainingSubTotal() == null)
        {
            if (e.getIsPropertyOrderRemainingSubTotalRemoved() != null && e.getIsPropertyOrderRemainingSubTotalRemoved())
            {
                this.setOrderRemainingSubTotal(null);
            }
        }
        else
        {
            this.setOrderRemainingSubTotal(e.getOrderRemainingSubTotal());
        }
        if (e.getOrderGrandTotal() == null)
        {
            if (e.getIsPropertyOrderGrandTotalRemoved() != null && e.getIsPropertyOrderGrandTotalRemoved())
            {
                this.setOrderGrandTotal(null);
            }
        }
        else
        {
            this.setOrderGrandTotal(e.getOrderGrandTotal());
        }
        if (e.getOrderInvoicePerShipment() == null)
        {
            if (e.getIsPropertyOrderInvoicePerShipmentRemoved() != null && e.getIsPropertyOrderInvoicePerShipmentRemoved())
            {
                this.setOrderInvoicePerShipment(null);
            }
        }
        else
        {
            this.setOrderInvoicePerShipment(e.getOrderInvoicePerShipment());
        }
        if (e.getOrderCreatedBy() == null)
        {
            if (e.getIsPropertyOrderCreatedByRemoved() != null && e.getIsPropertyOrderCreatedByRemoved())
            {
                this.setOrderCreatedBy(null);
            }
        }
        else
        {
            this.setOrderCreatedBy(e.getOrderCreatedBy());
        }
        if (e.getOrderCreatedAt() == null)
        {
            if (e.getIsPropertyOrderCreatedAtRemoved() != null && e.getIsPropertyOrderCreatedAtRemoved())
            {
                this.setOrderCreatedAt(null);
            }
        }
        else
        {
            this.setOrderCreatedAt(e.getOrderCreatedAt());
        }
        if (e.getOrderUpdatedBy() == null)
        {
            if (e.getIsPropertyOrderUpdatedByRemoved() != null && e.getIsPropertyOrderUpdatedByRemoved())
            {
                this.setOrderUpdatedBy(null);
            }
        }
        else
        {
            this.setOrderUpdatedBy(e.getOrderUpdatedBy());
        }
        if (e.getOrderUpdatedAt() == null)
        {
            if (e.getIsPropertyOrderUpdatedAtRemoved() != null && e.getIsPropertyOrderUpdatedAtRemoved())
            {
                this.setOrderUpdatedAt(null);
            }
        }
        else
        {
            this.setOrderUpdatedAt(e.getOrderUpdatedAt());
        }
        if (e.getOrderActive() == null)
        {
            if (e.getIsPropertyOrderActiveRemoved() != null && e.getIsPropertyOrderActiveRemoved())
            {
                this.setOrderActive(null);
            }
        }
        else
        {
            this.setOrderActive(e.getOrderActive());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(OrderItemShipGroupAssociationMvoStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(OrderItemShipGroupAssociationMvoEvent stateEvent)
    {
        OrderItemShipGroupAssociationId stateEntityId = this.getOrderItemShipGroupAssociationId(); // Aggregate Id
        OrderItemShipGroupAssociationId eventEntityId = stateEvent.getOrderItemShipGroupAssociationMvoEventId().getOrderItemShipGroupAssociationId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getOrderVersion();
        Long eventVersion = stateEvent.getOrderItemShipGroupAssociationMvoEventId().getOrderVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getOrderItemShipGroupAssociationMvoEventId().getOrderVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(OrderItemShipGroupAssociationMvoState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleOrderItemShipGroupAssociationMvoState extends AbstractOrderItemShipGroupAssociationMvoState
    {

        public SimpleOrderItemShipGroupAssociationMvoState() {
        }

        public SimpleOrderItemShipGroupAssociationMvoState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleOrderItemShipGroupAssociationMvoState(List<Event> events) {
            super(events);
        }

    }


}

