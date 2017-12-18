package org.dddml.wms.domain.orderitemmvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.orderitemmvo.OrderItemMvoStateEvent.*;

public abstract class AbstractOrderItemMvoState implements OrderItemMvoState
{

    private OrderItemId orderItemId;

    public OrderItemId getOrderItemId()
    {
        return this.orderItemId;
    }

    public void setOrderItemId(OrderItemId orderItemId)
    {
        this.orderItemId = orderItemId;
    }

    private String productId;

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    private String externalProductId;

    public String getExternalProductId()
    {
        return this.externalProductId;
    }

    public void setExternalProductId(String externalProductId)
    {
        this.externalProductId = externalProductId;
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

    private java.math.BigDecimal selectedAmount;

    public java.math.BigDecimal getSelectedAmount()
    {
        return this.selectedAmount;
    }

    public void setSelectedAmount(java.math.BigDecimal selectedAmount)
    {
        this.selectedAmount = selectedAmount;
    }

    private String externalId;

    public String getExternalId()
    {
        return this.externalId;
    }

    public void setExternalId(String externalId)
    {
        this.externalId = externalId;
    }

    private String orderItemTypeId;

    public String getOrderItemTypeId()
    {
        return this.orderItemTypeId;
    }

    public void setOrderItemTypeId(String orderItemTypeId)
    {
        this.orderItemTypeId = orderItemTypeId;
    }

    private String orderItemGroupSeqId;

    public String getOrderItemGroupSeqId()
    {
        return this.orderItemGroupSeqId;
    }

    public void setOrderItemGroupSeqId(String orderItemGroupSeqId)
    {
        this.orderItemGroupSeqId = orderItemGroupSeqId;
    }

    private String isItemGroupPrimary;

    public String getIsItemGroupPrimary()
    {
        return this.isItemGroupPrimary;
    }

    public void setIsItemGroupPrimary(String isItemGroupPrimary)
    {
        this.isItemGroupPrimary = isItemGroupPrimary;
    }

    private String fromInventoryItemId;

    public String getFromInventoryItemId()
    {
        return this.fromInventoryItemId;
    }

    public void setFromInventoryItemId(String fromInventoryItemId)
    {
        this.fromInventoryItemId = fromInventoryItemId;
    }

    private String isPromo;

    public String getIsPromo()
    {
        return this.isPromo;
    }

    public void setIsPromo(String isPromo)
    {
        this.isPromo = isPromo;
    }

    private String quoteId;

    public String getQuoteId()
    {
        return this.quoteId;
    }

    public void setQuoteId(String quoteId)
    {
        this.quoteId = quoteId;
    }

    private String quoteItemSeqId;

    public String getQuoteItemSeqId()
    {
        return this.quoteItemSeqId;
    }

    public void setQuoteItemSeqId(String quoteItemSeqId)
    {
        this.quoteItemSeqId = quoteItemSeqId;
    }

    private String shoppingListId;

    public String getShoppingListId()
    {
        return this.shoppingListId;
    }

    public void setShoppingListId(String shoppingListId)
    {
        this.shoppingListId = shoppingListId;
    }

    private String shoppingListItemSeqId;

    public String getShoppingListItemSeqId()
    {
        return this.shoppingListItemSeqId;
    }

    public void setShoppingListItemSeqId(String shoppingListItemSeqId)
    {
        this.shoppingListItemSeqId = shoppingListItemSeqId;
    }

    private java.math.BigDecimal unitPrice;

    public java.math.BigDecimal getUnitPrice()
    {
        return this.unitPrice;
    }

    public void setUnitPrice(java.math.BigDecimal unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    private java.math.BigDecimal unitListPrice;

    public java.math.BigDecimal getUnitListPrice()
    {
        return this.unitListPrice;
    }

    public void setUnitListPrice(java.math.BigDecimal unitListPrice)
    {
        this.unitListPrice = unitListPrice;
    }

    private java.math.BigDecimal unitAverageCost;

    public java.math.BigDecimal getUnitAverageCost()
    {
        return this.unitAverageCost;
    }

    public void setUnitAverageCost(java.math.BigDecimal unitAverageCost)
    {
        this.unitAverageCost = unitAverageCost;
    }

    private java.math.BigDecimal unitRecurringPrice;

    public java.math.BigDecimal getUnitRecurringPrice()
    {
        return this.unitRecurringPrice;
    }

    public void setUnitRecurringPrice(java.math.BigDecimal unitRecurringPrice)
    {
        this.unitRecurringPrice = unitRecurringPrice;
    }

    private String isModifiedPrice;

    public String getIsModifiedPrice()
    {
        return this.isModifiedPrice;
    }

    public void setIsModifiedPrice(String isModifiedPrice)
    {
        this.isModifiedPrice = isModifiedPrice;
    }

    private String recurringFreqUomId;

    public String getRecurringFreqUomId()
    {
        return this.recurringFreqUomId;
    }

    public void setRecurringFreqUomId(String recurringFreqUomId)
    {
        this.recurringFreqUomId = recurringFreqUomId;
    }

    private String itemDescription;

    public String getItemDescription()
    {
        return this.itemDescription;
    }

    public void setItemDescription(String itemDescription)
    {
        this.itemDescription = itemDescription;
    }

    private String comments;

    public String getComments()
    {
        return this.comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    private String correspondingPoId;

    public String getCorrespondingPoId()
    {
        return this.correspondingPoId;
    }

    public void setCorrespondingPoId(String correspondingPoId)
    {
        this.correspondingPoId = correspondingPoId;
    }

    private String statusId;

    public String getStatusId()
    {
        return this.statusId;
    }

    public void setStatusId(String statusId)
    {
        this.statusId = statusId;
    }

    private String syncStatusId;

    public String getSyncStatusId()
    {
        return this.syncStatusId;
    }

    public void setSyncStatusId(String syncStatusId)
    {
        this.syncStatusId = syncStatusId;
    }

    private java.sql.Timestamp estimatedShipDate;

    public java.sql.Timestamp getEstimatedShipDate()
    {
        return this.estimatedShipDate;
    }

    public void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate)
    {
        this.estimatedShipDate = estimatedShipDate;
    }

    private java.sql.Timestamp estimatedDeliveryDate;

    public java.sql.Timestamp getEstimatedDeliveryDate()
    {
        return this.estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(java.sql.Timestamp estimatedDeliveryDate)
    {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    private java.sql.Timestamp autoCancelDate;

    public java.sql.Timestamp getAutoCancelDate()
    {
        return this.autoCancelDate;
    }

    public void setAutoCancelDate(java.sql.Timestamp autoCancelDate)
    {
        this.autoCancelDate = autoCancelDate;
    }

    private java.sql.Timestamp dontCancelSetDate;

    public java.sql.Timestamp getDontCancelSetDate()
    {
        return this.dontCancelSetDate;
    }

    public void setDontCancelSetDate(java.sql.Timestamp dontCancelSetDate)
    {
        this.dontCancelSetDate = dontCancelSetDate;
    }

    private String dontCancelSetBy;

    public String getDontCancelSetBy()
    {
        return this.dontCancelSetBy;
    }

    public void setDontCancelSetBy(String dontCancelSetBy)
    {
        this.dontCancelSetBy = dontCancelSetBy;
    }

    private java.sql.Timestamp shipBeforeDate;

    public java.sql.Timestamp getShipBeforeDate()
    {
        return this.shipBeforeDate;
    }

    public void setShipBeforeDate(java.sql.Timestamp shipBeforeDate)
    {
        this.shipBeforeDate = shipBeforeDate;
    }

    private java.sql.Timestamp shipAfterDate;

    public java.sql.Timestamp getShipAfterDate()
    {
        return this.shipAfterDate;
    }

    public void setShipAfterDate(java.sql.Timestamp shipAfterDate)
    {
        this.shipAfterDate = shipAfterDate;
    }

    private java.sql.Timestamp cancelBackOrderDate;

    public java.sql.Timestamp getCancelBackOrderDate()
    {
        return this.cancelBackOrderDate;
    }

    public void setCancelBackOrderDate(java.sql.Timestamp cancelBackOrderDate)
    {
        this.cancelBackOrderDate = cancelBackOrderDate;
    }

    private String overrideGlAccountId;

    public String getOverrideGlAccountId()
    {
        return this.overrideGlAccountId;
    }

    public void setOverrideGlAccountId(String overrideGlAccountId)
    {
        this.overrideGlAccountId = overrideGlAccountId;
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

    public AbstractOrderItemMvoState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setOrderItemId(((OrderItemMvoStateEvent) events.get(0)).getStateEventId().getOrderItemId());
            for (Event e : events) {
                mutate(e);
                this.setOrderVersion(this.getOrderVersion() + 1);
            }
        }
    }


    public AbstractOrderItemMvoState() {
        this(false);
    }

    public AbstractOrderItemMvoState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof OrderItemMvoStateCreated) {
            when((OrderItemMvoStateCreated) e);
        } else if (e instanceof OrderItemMvoStateMergePatched) {
            when((OrderItemMvoStateMergePatched) e);
        } else if (e instanceof OrderItemMvoStateDeleted) {
            when((OrderItemMvoStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(OrderItemMvoStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setProductId(e.getProductId());
        this.setExternalProductId(e.getExternalProductId());
        this.setQuantity(e.getQuantity());
        this.setCancelQuantity(e.getCancelQuantity());
        this.setSelectedAmount(e.getSelectedAmount());
        this.setExternalId(e.getExternalId());
        this.setOrderItemTypeId(e.getOrderItemTypeId());
        this.setOrderItemGroupSeqId(e.getOrderItemGroupSeqId());
        this.setIsItemGroupPrimary(e.getIsItemGroupPrimary());
        this.setFromInventoryItemId(e.getFromInventoryItemId());
        this.setIsPromo(e.getIsPromo());
        this.setQuoteId(e.getQuoteId());
        this.setQuoteItemSeqId(e.getQuoteItemSeqId());
        this.setShoppingListId(e.getShoppingListId());
        this.setShoppingListItemSeqId(e.getShoppingListItemSeqId());
        this.setUnitPrice(e.getUnitPrice());
        this.setUnitListPrice(e.getUnitListPrice());
        this.setUnitAverageCost(e.getUnitAverageCost());
        this.setUnitRecurringPrice(e.getUnitRecurringPrice());
        this.setIsModifiedPrice(e.getIsModifiedPrice());
        this.setRecurringFreqUomId(e.getRecurringFreqUomId());
        this.setItemDescription(e.getItemDescription());
        this.setComments(e.getComments());
        this.setCorrespondingPoId(e.getCorrespondingPoId());
        this.setStatusId(e.getStatusId());
        this.setSyncStatusId(e.getSyncStatusId());
        this.setEstimatedShipDate(e.getEstimatedShipDate());
        this.setEstimatedDeliveryDate(e.getEstimatedDeliveryDate());
        this.setAutoCancelDate(e.getAutoCancelDate());
        this.setDontCancelSetDate(e.getDontCancelSetDate());
        this.setDontCancelSetBy(e.getDontCancelSetBy());
        this.setShipBeforeDate(e.getShipBeforeDate());
        this.setShipAfterDate(e.getShipAfterDate());
        this.setCancelBackOrderDate(e.getCancelBackOrderDate());
        this.setOverrideGlAccountId(e.getOverrideGlAccountId());
        this.setVersion(e.getVersion());
        this.setActive(e.getActive());
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

    public void when(OrderItemMvoStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getProductId() == null)
        {
            if (e.getIsPropertyProductIdRemoved() != null && e.getIsPropertyProductIdRemoved())
            {
                this.setProductId(null);
            }
        }
        else
        {
            this.setProductId(e.getProductId());
        }
        if (e.getExternalProductId() == null)
        {
            if (e.getIsPropertyExternalProductIdRemoved() != null && e.getIsPropertyExternalProductIdRemoved())
            {
                this.setExternalProductId(null);
            }
        }
        else
        {
            this.setExternalProductId(e.getExternalProductId());
        }
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
        if (e.getSelectedAmount() == null)
        {
            if (e.getIsPropertySelectedAmountRemoved() != null && e.getIsPropertySelectedAmountRemoved())
            {
                this.setSelectedAmount(null);
            }
        }
        else
        {
            this.setSelectedAmount(e.getSelectedAmount());
        }
        if (e.getExternalId() == null)
        {
            if (e.getIsPropertyExternalIdRemoved() != null && e.getIsPropertyExternalIdRemoved())
            {
                this.setExternalId(null);
            }
        }
        else
        {
            this.setExternalId(e.getExternalId());
        }
        if (e.getOrderItemTypeId() == null)
        {
            if (e.getIsPropertyOrderItemTypeIdRemoved() != null && e.getIsPropertyOrderItemTypeIdRemoved())
            {
                this.setOrderItemTypeId(null);
            }
        }
        else
        {
            this.setOrderItemTypeId(e.getOrderItemTypeId());
        }
        if (e.getOrderItemGroupSeqId() == null)
        {
            if (e.getIsPropertyOrderItemGroupSeqIdRemoved() != null && e.getIsPropertyOrderItemGroupSeqIdRemoved())
            {
                this.setOrderItemGroupSeqId(null);
            }
        }
        else
        {
            this.setOrderItemGroupSeqId(e.getOrderItemGroupSeqId());
        }
        if (e.getIsItemGroupPrimary() == null)
        {
            if (e.getIsPropertyIsItemGroupPrimaryRemoved() != null && e.getIsPropertyIsItemGroupPrimaryRemoved())
            {
                this.setIsItemGroupPrimary(null);
            }
        }
        else
        {
            this.setIsItemGroupPrimary(e.getIsItemGroupPrimary());
        }
        if (e.getFromInventoryItemId() == null)
        {
            if (e.getIsPropertyFromInventoryItemIdRemoved() != null && e.getIsPropertyFromInventoryItemIdRemoved())
            {
                this.setFromInventoryItemId(null);
            }
        }
        else
        {
            this.setFromInventoryItemId(e.getFromInventoryItemId());
        }
        if (e.getIsPromo() == null)
        {
            if (e.getIsPropertyIsPromoRemoved() != null && e.getIsPropertyIsPromoRemoved())
            {
                this.setIsPromo(null);
            }
        }
        else
        {
            this.setIsPromo(e.getIsPromo());
        }
        if (e.getQuoteId() == null)
        {
            if (e.getIsPropertyQuoteIdRemoved() != null && e.getIsPropertyQuoteIdRemoved())
            {
                this.setQuoteId(null);
            }
        }
        else
        {
            this.setQuoteId(e.getQuoteId());
        }
        if (e.getQuoteItemSeqId() == null)
        {
            if (e.getIsPropertyQuoteItemSeqIdRemoved() != null && e.getIsPropertyQuoteItemSeqIdRemoved())
            {
                this.setQuoteItemSeqId(null);
            }
        }
        else
        {
            this.setQuoteItemSeqId(e.getQuoteItemSeqId());
        }
        if (e.getShoppingListId() == null)
        {
            if (e.getIsPropertyShoppingListIdRemoved() != null && e.getIsPropertyShoppingListIdRemoved())
            {
                this.setShoppingListId(null);
            }
        }
        else
        {
            this.setShoppingListId(e.getShoppingListId());
        }
        if (e.getShoppingListItemSeqId() == null)
        {
            if (e.getIsPropertyShoppingListItemSeqIdRemoved() != null && e.getIsPropertyShoppingListItemSeqIdRemoved())
            {
                this.setShoppingListItemSeqId(null);
            }
        }
        else
        {
            this.setShoppingListItemSeqId(e.getShoppingListItemSeqId());
        }
        if (e.getUnitPrice() == null)
        {
            if (e.getIsPropertyUnitPriceRemoved() != null && e.getIsPropertyUnitPriceRemoved())
            {
                this.setUnitPrice(null);
            }
        }
        else
        {
            this.setUnitPrice(e.getUnitPrice());
        }
        if (e.getUnitListPrice() == null)
        {
            if (e.getIsPropertyUnitListPriceRemoved() != null && e.getIsPropertyUnitListPriceRemoved())
            {
                this.setUnitListPrice(null);
            }
        }
        else
        {
            this.setUnitListPrice(e.getUnitListPrice());
        }
        if (e.getUnitAverageCost() == null)
        {
            if (e.getIsPropertyUnitAverageCostRemoved() != null && e.getIsPropertyUnitAverageCostRemoved())
            {
                this.setUnitAverageCost(null);
            }
        }
        else
        {
            this.setUnitAverageCost(e.getUnitAverageCost());
        }
        if (e.getUnitRecurringPrice() == null)
        {
            if (e.getIsPropertyUnitRecurringPriceRemoved() != null && e.getIsPropertyUnitRecurringPriceRemoved())
            {
                this.setUnitRecurringPrice(null);
            }
        }
        else
        {
            this.setUnitRecurringPrice(e.getUnitRecurringPrice());
        }
        if (e.getIsModifiedPrice() == null)
        {
            if (e.getIsPropertyIsModifiedPriceRemoved() != null && e.getIsPropertyIsModifiedPriceRemoved())
            {
                this.setIsModifiedPrice(null);
            }
        }
        else
        {
            this.setIsModifiedPrice(e.getIsModifiedPrice());
        }
        if (e.getRecurringFreqUomId() == null)
        {
            if (e.getIsPropertyRecurringFreqUomIdRemoved() != null && e.getIsPropertyRecurringFreqUomIdRemoved())
            {
                this.setRecurringFreqUomId(null);
            }
        }
        else
        {
            this.setRecurringFreqUomId(e.getRecurringFreqUomId());
        }
        if (e.getItemDescription() == null)
        {
            if (e.getIsPropertyItemDescriptionRemoved() != null && e.getIsPropertyItemDescriptionRemoved())
            {
                this.setItemDescription(null);
            }
        }
        else
        {
            this.setItemDescription(e.getItemDescription());
        }
        if (e.getComments() == null)
        {
            if (e.getIsPropertyCommentsRemoved() != null && e.getIsPropertyCommentsRemoved())
            {
                this.setComments(null);
            }
        }
        else
        {
            this.setComments(e.getComments());
        }
        if (e.getCorrespondingPoId() == null)
        {
            if (e.getIsPropertyCorrespondingPoIdRemoved() != null && e.getIsPropertyCorrespondingPoIdRemoved())
            {
                this.setCorrespondingPoId(null);
            }
        }
        else
        {
            this.setCorrespondingPoId(e.getCorrespondingPoId());
        }
        if (e.getStatusId() == null)
        {
            if (e.getIsPropertyStatusIdRemoved() != null && e.getIsPropertyStatusIdRemoved())
            {
                this.setStatusId(null);
            }
        }
        else
        {
            this.setStatusId(e.getStatusId());
        }
        if (e.getSyncStatusId() == null)
        {
            if (e.getIsPropertySyncStatusIdRemoved() != null && e.getIsPropertySyncStatusIdRemoved())
            {
                this.setSyncStatusId(null);
            }
        }
        else
        {
            this.setSyncStatusId(e.getSyncStatusId());
        }
        if (e.getEstimatedShipDate() == null)
        {
            if (e.getIsPropertyEstimatedShipDateRemoved() != null && e.getIsPropertyEstimatedShipDateRemoved())
            {
                this.setEstimatedShipDate(null);
            }
        }
        else
        {
            this.setEstimatedShipDate(e.getEstimatedShipDate());
        }
        if (e.getEstimatedDeliveryDate() == null)
        {
            if (e.getIsPropertyEstimatedDeliveryDateRemoved() != null && e.getIsPropertyEstimatedDeliveryDateRemoved())
            {
                this.setEstimatedDeliveryDate(null);
            }
        }
        else
        {
            this.setEstimatedDeliveryDate(e.getEstimatedDeliveryDate());
        }
        if (e.getAutoCancelDate() == null)
        {
            if (e.getIsPropertyAutoCancelDateRemoved() != null && e.getIsPropertyAutoCancelDateRemoved())
            {
                this.setAutoCancelDate(null);
            }
        }
        else
        {
            this.setAutoCancelDate(e.getAutoCancelDate());
        }
        if (e.getDontCancelSetDate() == null)
        {
            if (e.getIsPropertyDontCancelSetDateRemoved() != null && e.getIsPropertyDontCancelSetDateRemoved())
            {
                this.setDontCancelSetDate(null);
            }
        }
        else
        {
            this.setDontCancelSetDate(e.getDontCancelSetDate());
        }
        if (e.getDontCancelSetBy() == null)
        {
            if (e.getIsPropertyDontCancelSetByRemoved() != null && e.getIsPropertyDontCancelSetByRemoved())
            {
                this.setDontCancelSetBy(null);
            }
        }
        else
        {
            this.setDontCancelSetBy(e.getDontCancelSetBy());
        }
        if (e.getShipBeforeDate() == null)
        {
            if (e.getIsPropertyShipBeforeDateRemoved() != null && e.getIsPropertyShipBeforeDateRemoved())
            {
                this.setShipBeforeDate(null);
            }
        }
        else
        {
            this.setShipBeforeDate(e.getShipBeforeDate());
        }
        if (e.getShipAfterDate() == null)
        {
            if (e.getIsPropertyShipAfterDateRemoved() != null && e.getIsPropertyShipAfterDateRemoved())
            {
                this.setShipAfterDate(null);
            }
        }
        else
        {
            this.setShipAfterDate(e.getShipAfterDate());
        }
        if (e.getCancelBackOrderDate() == null)
        {
            if (e.getIsPropertyCancelBackOrderDateRemoved() != null && e.getIsPropertyCancelBackOrderDateRemoved())
            {
                this.setCancelBackOrderDate(null);
            }
        }
        else
        {
            this.setCancelBackOrderDate(e.getCancelBackOrderDate());
        }
        if (e.getOverrideGlAccountId() == null)
        {
            if (e.getIsPropertyOverrideGlAccountIdRemoved() != null && e.getIsPropertyOverrideGlAccountIdRemoved())
            {
                this.setOverrideGlAccountId(null);
            }
        }
        else
        {
            this.setOverrideGlAccountId(e.getOverrideGlAccountId());
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

    public void when(OrderItemMvoStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(OrderItemMvoStateEvent stateEvent)
    {
        OrderItemId stateEntityId = this.getOrderItemId(); // Aggregate Id
        OrderItemId eventEntityId = stateEvent.getStateEventId().getOrderItemId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getOrderVersion();
        Long eventVersion = stateEvent.getStateEventId().getOrderVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getOrderVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(OrderItemMvoState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleOrderItemMvoState extends AbstractOrderItemMvoState
    {

        public SimpleOrderItemMvoState() {
        }

        public SimpleOrderItemMvoState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleOrderItemMvoState(List<Event> events) {
            super(events);
        }

    }


}

