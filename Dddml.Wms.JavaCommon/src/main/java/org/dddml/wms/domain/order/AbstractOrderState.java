package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.order.OrderStateEvent.*;

public abstract class AbstractOrderState implements OrderState, Saveable
{

    private String orderId;

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    private String orderTypeId;

    public String getOrderTypeId()
    {
        return this.orderTypeId;
    }

    public void setOrderTypeId(String orderTypeId)
    {
        this.orderTypeId = orderTypeId;
    }

    private String orderName;

    public String getOrderName()
    {
        return this.orderName;
    }

    public void setOrderName(String orderName)
    {
        this.orderName = orderName;
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

    private String salesChannelEnumId;

    public String getSalesChannelEnumId()
    {
        return this.salesChannelEnumId;
    }

    public void setSalesChannelEnumId(String salesChannelEnumId)
    {
        this.salesChannelEnumId = salesChannelEnumId;
    }

    private java.sql.Timestamp orderDate;

    public java.sql.Timestamp getOrderDate()
    {
        return this.orderDate;
    }

    public void setOrderDate(java.sql.Timestamp orderDate)
    {
        this.orderDate = orderDate;
    }

    private String priority;

    public String getPriority()
    {
        return this.priority;
    }

    public void setPriority(String priority)
    {
        this.priority = priority;
    }

    private java.sql.Timestamp entryDate;

    public java.sql.Timestamp getEntryDate()
    {
        return this.entryDate;
    }

    public void setEntryDate(java.sql.Timestamp entryDate)
    {
        this.entryDate = entryDate;
    }

    private java.sql.Timestamp pickSheetPrintedDate;

    public java.sql.Timestamp getPickSheetPrintedDate()
    {
        return this.pickSheetPrintedDate;
    }

    public void setPickSheetPrintedDate(java.sql.Timestamp pickSheetPrintedDate)
    {
        this.pickSheetPrintedDate = pickSheetPrintedDate;
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

    private String currencyUom;

    public String getCurrencyUom()
    {
        return this.currencyUom;
    }

    public void setCurrencyUom(String currencyUom)
    {
        this.currencyUom = currencyUom;
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

    private String billingAccountId;

    public String getBillingAccountId()
    {
        return this.billingAccountId;
    }

    public void setBillingAccountId(String billingAccountId)
    {
        this.billingAccountId = billingAccountId;
    }

    private String originFacilityId;

    public String getOriginFacilityId()
    {
        return this.originFacilityId;
    }

    public void setOriginFacilityId(String originFacilityId)
    {
        this.originFacilityId = originFacilityId;
    }

    private String webSiteId;

    public String getWebSiteId()
    {
        return this.webSiteId;
    }

    public void setWebSiteId(String webSiteId)
    {
        this.webSiteId = webSiteId;
    }

    private String productStoreId;

    public String getProductStoreId()
    {
        return this.productStoreId;
    }

    public void setProductStoreId(String productStoreId)
    {
        this.productStoreId = productStoreId;
    }

    private String terminalId;

    public String getTerminalId()
    {
        return this.terminalId;
    }

    public void setTerminalId(String terminalId)
    {
        this.terminalId = terminalId;
    }

    private String transactionId;

    public String getTransactionId()
    {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId)
    {
        this.transactionId = transactionId;
    }

    private String autoOrderShoppingListId;

    public String getAutoOrderShoppingListId()
    {
        return this.autoOrderShoppingListId;
    }

    public void setAutoOrderShoppingListId(String autoOrderShoppingListId)
    {
        this.autoOrderShoppingListId = autoOrderShoppingListId;
    }

    private String needsInventoryIssuance;

    public String getNeedsInventoryIssuance()
    {
        return this.needsInventoryIssuance;
    }

    public void setNeedsInventoryIssuance(String needsInventoryIssuance)
    {
        this.needsInventoryIssuance = needsInventoryIssuance;
    }

    private String isRushOrder;

    public String getIsRushOrder()
    {
        return this.isRushOrder;
    }

    public void setIsRushOrder(String isRushOrder)
    {
        this.isRushOrder = isRushOrder;
    }

    private String internalCode;

    public String getInternalCode()
    {
        return this.internalCode;
    }

    public void setInternalCode(String internalCode)
    {
        this.internalCode = internalCode;
    }

    private java.math.BigDecimal remainingSubTotal;

    public java.math.BigDecimal getRemainingSubTotal()
    {
        return this.remainingSubTotal;
    }

    public void setRemainingSubTotal(java.math.BigDecimal remainingSubTotal)
    {
        this.remainingSubTotal = remainingSubTotal;
    }

    private java.math.BigDecimal grandTotal;

    public java.math.BigDecimal getGrandTotal()
    {
        return this.grandTotal;
    }

    public void setGrandTotal(java.math.BigDecimal grandTotal)
    {
        this.grandTotal = grandTotal;
    }

    private String invoicePerShipment;

    public String getInvoicePerShipment()
    {
        return this.invoicePerShipment;
    }

    public void setInvoicePerShipment(String invoicePerShipment)
    {
        this.invoicePerShipment = invoicePerShipment;
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

    public boolean isStateUnsaved() 
    {
        return this.getVersion() == null;
    }

    private OrderItemStates orderItems;

    public OrderItemStates getOrderItems()
    {
        return this.orderItems;
    }

    public void setOrderItems(OrderItemStates orderItems)
    {
        this.orderItems = orderItems;
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

    public AbstractOrderState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setOrderId(((OrderStateEvent) events.get(0)).getStateEventId().getOrderId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractOrderState() {
        this(false);
    }

    public AbstractOrderState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
        orderItems = new SimpleOrderItemStates(this);
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof OrderStateCreated) {
            when((OrderStateCreated) e);
        } else if (e instanceof OrderStateMergePatched) {
            when((OrderStateMergePatched) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(OrderStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setOrderTypeId(e.getOrderTypeId());
        this.setOrderName(e.getOrderName());
        this.setExternalId(e.getExternalId());
        this.setSalesChannelEnumId(e.getSalesChannelEnumId());
        this.setOrderDate(e.getOrderDate());
        this.setPriority(e.getPriority());
        this.setEntryDate(e.getEntryDate());
        this.setPickSheetPrintedDate(e.getPickSheetPrintedDate());
        this.setStatusId(e.getStatusId());
        this.setCurrencyUom(e.getCurrencyUom());
        this.setSyncStatusId(e.getSyncStatusId());
        this.setBillingAccountId(e.getBillingAccountId());
        this.setOriginFacilityId(e.getOriginFacilityId());
        this.setWebSiteId(e.getWebSiteId());
        this.setProductStoreId(e.getProductStoreId());
        this.setTerminalId(e.getTerminalId());
        this.setTransactionId(e.getTransactionId());
        this.setAutoOrderShoppingListId(e.getAutoOrderShoppingListId());
        this.setNeedsInventoryIssuance(e.getNeedsInventoryIssuance());
        this.setIsRushOrder(e.getIsRushOrder());
        this.setInternalCode(e.getInternalCode());
        this.setRemainingSubTotal(e.getRemainingSubTotal());
        this.setGrandTotal(e.getGrandTotal());
        this.setInvoicePerShipment(e.getInvoicePerShipment());
        this.setActive(e.getActive());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

        for (OrderItemStateEvent.OrderItemStateCreated innerEvent : e.getOrderItemEvents()) {
            OrderItemState innerState = this.getOrderItems().get(innerEvent.getStateEventId().getOrderItemSeqId());
            innerState.mutate(innerEvent);
        }
    }

    public void when(OrderStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getOrderTypeId() == null)
        {
            if (e.getIsPropertyOrderTypeIdRemoved() != null && e.getIsPropertyOrderTypeIdRemoved())
            {
                this.setOrderTypeId(null);
            }
        }
        else
        {
            this.setOrderTypeId(e.getOrderTypeId());
        }
        if (e.getOrderName() == null)
        {
            if (e.getIsPropertyOrderNameRemoved() != null && e.getIsPropertyOrderNameRemoved())
            {
                this.setOrderName(null);
            }
        }
        else
        {
            this.setOrderName(e.getOrderName());
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
        if (e.getSalesChannelEnumId() == null)
        {
            if (e.getIsPropertySalesChannelEnumIdRemoved() != null && e.getIsPropertySalesChannelEnumIdRemoved())
            {
                this.setSalesChannelEnumId(null);
            }
        }
        else
        {
            this.setSalesChannelEnumId(e.getSalesChannelEnumId());
        }
        if (e.getOrderDate() == null)
        {
            if (e.getIsPropertyOrderDateRemoved() != null && e.getIsPropertyOrderDateRemoved())
            {
                this.setOrderDate(null);
            }
        }
        else
        {
            this.setOrderDate(e.getOrderDate());
        }
        if (e.getPriority() == null)
        {
            if (e.getIsPropertyPriorityRemoved() != null && e.getIsPropertyPriorityRemoved())
            {
                this.setPriority(null);
            }
        }
        else
        {
            this.setPriority(e.getPriority());
        }
        if (e.getEntryDate() == null)
        {
            if (e.getIsPropertyEntryDateRemoved() != null && e.getIsPropertyEntryDateRemoved())
            {
                this.setEntryDate(null);
            }
        }
        else
        {
            this.setEntryDate(e.getEntryDate());
        }
        if (e.getPickSheetPrintedDate() == null)
        {
            if (e.getIsPropertyPickSheetPrintedDateRemoved() != null && e.getIsPropertyPickSheetPrintedDateRemoved())
            {
                this.setPickSheetPrintedDate(null);
            }
        }
        else
        {
            this.setPickSheetPrintedDate(e.getPickSheetPrintedDate());
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
        if (e.getCurrencyUom() == null)
        {
            if (e.getIsPropertyCurrencyUomRemoved() != null && e.getIsPropertyCurrencyUomRemoved())
            {
                this.setCurrencyUom(null);
            }
        }
        else
        {
            this.setCurrencyUom(e.getCurrencyUom());
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
        if (e.getBillingAccountId() == null)
        {
            if (e.getIsPropertyBillingAccountIdRemoved() != null && e.getIsPropertyBillingAccountIdRemoved())
            {
                this.setBillingAccountId(null);
            }
        }
        else
        {
            this.setBillingAccountId(e.getBillingAccountId());
        }
        if (e.getOriginFacilityId() == null)
        {
            if (e.getIsPropertyOriginFacilityIdRemoved() != null && e.getIsPropertyOriginFacilityIdRemoved())
            {
                this.setOriginFacilityId(null);
            }
        }
        else
        {
            this.setOriginFacilityId(e.getOriginFacilityId());
        }
        if (e.getWebSiteId() == null)
        {
            if (e.getIsPropertyWebSiteIdRemoved() != null && e.getIsPropertyWebSiteIdRemoved())
            {
                this.setWebSiteId(null);
            }
        }
        else
        {
            this.setWebSiteId(e.getWebSiteId());
        }
        if (e.getProductStoreId() == null)
        {
            if (e.getIsPropertyProductStoreIdRemoved() != null && e.getIsPropertyProductStoreIdRemoved())
            {
                this.setProductStoreId(null);
            }
        }
        else
        {
            this.setProductStoreId(e.getProductStoreId());
        }
        if (e.getTerminalId() == null)
        {
            if (e.getIsPropertyTerminalIdRemoved() != null && e.getIsPropertyTerminalIdRemoved())
            {
                this.setTerminalId(null);
            }
        }
        else
        {
            this.setTerminalId(e.getTerminalId());
        }
        if (e.getTransactionId() == null)
        {
            if (e.getIsPropertyTransactionIdRemoved() != null && e.getIsPropertyTransactionIdRemoved())
            {
                this.setTransactionId(null);
            }
        }
        else
        {
            this.setTransactionId(e.getTransactionId());
        }
        if (e.getAutoOrderShoppingListId() == null)
        {
            if (e.getIsPropertyAutoOrderShoppingListIdRemoved() != null && e.getIsPropertyAutoOrderShoppingListIdRemoved())
            {
                this.setAutoOrderShoppingListId(null);
            }
        }
        else
        {
            this.setAutoOrderShoppingListId(e.getAutoOrderShoppingListId());
        }
        if (e.getNeedsInventoryIssuance() == null)
        {
            if (e.getIsPropertyNeedsInventoryIssuanceRemoved() != null && e.getIsPropertyNeedsInventoryIssuanceRemoved())
            {
                this.setNeedsInventoryIssuance(null);
            }
        }
        else
        {
            this.setNeedsInventoryIssuance(e.getNeedsInventoryIssuance());
        }
        if (e.getIsRushOrder() == null)
        {
            if (e.getIsPropertyIsRushOrderRemoved() != null && e.getIsPropertyIsRushOrderRemoved())
            {
                this.setIsRushOrder(null);
            }
        }
        else
        {
            this.setIsRushOrder(e.getIsRushOrder());
        }
        if (e.getInternalCode() == null)
        {
            if (e.getIsPropertyInternalCodeRemoved() != null && e.getIsPropertyInternalCodeRemoved())
            {
                this.setInternalCode(null);
            }
        }
        else
        {
            this.setInternalCode(e.getInternalCode());
        }
        if (e.getRemainingSubTotal() == null)
        {
            if (e.getIsPropertyRemainingSubTotalRemoved() != null && e.getIsPropertyRemainingSubTotalRemoved())
            {
                this.setRemainingSubTotal(null);
            }
        }
        else
        {
            this.setRemainingSubTotal(e.getRemainingSubTotal());
        }
        if (e.getGrandTotal() == null)
        {
            if (e.getIsPropertyGrandTotalRemoved() != null && e.getIsPropertyGrandTotalRemoved())
            {
                this.setGrandTotal(null);
            }
        }
        else
        {
            this.setGrandTotal(e.getGrandTotal());
        }
        if (e.getInvoicePerShipment() == null)
        {
            if (e.getIsPropertyInvoicePerShipmentRemoved() != null && e.getIsPropertyInvoicePerShipmentRemoved())
            {
                this.setInvoicePerShipment(null);
            }
        }
        else
        {
            this.setInvoicePerShipment(e.getInvoicePerShipment());
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

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        for (OrderItemStateEvent innerEvent : e.getOrderItemEvents()) {
            OrderItemState innerState = this.getOrderItems().get(innerEvent.getStateEventId().getOrderItemSeqId());
            innerState.mutate(innerEvent);
            if (innerEvent instanceof OrderItemStateEvent.OrderItemStateRemoved)
            {
                //OrderItemStateEvent.OrderItemStateRemoved removed = (OrderItemStateEvent.OrderItemStateRemoved)innerEvent;
                this.getOrderItems().remove(innerState);
            }
        }
    }

    public void save()
    {
        orderItems.save();

    }

    protected void throwOnWrongEvent(OrderStateEvent stateEvent)
    {
        String stateEntityId = this.getOrderId(); // Aggregate Id
        String eventEntityId = stateEvent.getStateEventId().getOrderId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getStateEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(OrderState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleOrderState extends AbstractOrderState
    {

        public SimpleOrderState() {
        }

        public SimpleOrderState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleOrderState(List<Event> events) {
            super(events);
        }

    }

    static class SimpleOrderItemStates extends AbstractOrderItemStates
    {
        public SimpleOrderItemStates(AbstractOrderState outerState)
        {
            super(outerState);
        }
    }


}

