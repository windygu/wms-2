package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractOrderStateEvent extends AbstractStateEvent implements OrderStateEvent 
{
    private OrderStateEventId stateEventId;

    public OrderStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(OrderStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public String getOrderId() {
        return getStateEventId().getOrderId();
    }

    public void setOrderId(String orderId) {
        getStateEventId().setOrderId(orderId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractOrderStateEvent() {
    }

    protected AbstractOrderStateEvent(OrderStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }

    protected OrderItemStateEventDao getOrderItemStateEventDao() {
        return (OrderItemStateEventDao)ApplicationContext.current.get("OrderItemStateEventDao");
    }

    protected OrderItemStateEventId newOrderItemStateEventId(String orderItemSeqId)
    {
        OrderItemStateEventId stateEventId = new OrderItemStateEventId(this.getStateEventId().getOrderId(), 
            orderItemSeqId, 
            this.getStateEventId().getVersion());
        return stateEventId;
    }

    protected void throwOnInconsistentEventIds(OrderItemStateEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(OrderStateEvent oe, OrderItemStateEvent e)
    {
        if (!oe.getStateEventId().getOrderId().equals(e.getStateEventId().getOrderId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id OrderId %1$s but inner id OrderId %2$s", 
                oe.getStateEventId().getOrderId(), e.getStateEventId().getOrderId());
        }
    }

    public OrderItemStateEvent.OrderItemStateCreated newOrderItemStateCreated(String orderItemSeqId) {
        return new AbstractOrderItemStateEvent.SimpleOrderItemStateCreated(newOrderItemStateEventId(orderItemSeqId));
    }

    public OrderItemStateEvent.OrderItemStateMergePatched newOrderItemStateMergePatched(String orderItemSeqId) {
        return new AbstractOrderItemStateEvent.SimpleOrderItemStateMergePatched(newOrderItemStateEventId(orderItemSeqId));
    }

    public OrderItemStateEvent.OrderItemStateRemoved newOrderItemStateRemoved(String orderItemSeqId) {
        return new AbstractOrderItemStateEvent.SimpleOrderItemStateRemoved(newOrderItemStateEventId(orderItemSeqId));
    }


    public abstract String getStateEventType();


    public static abstract class AbstractOrderStateCreated extends AbstractOrderStateEvent implements OrderStateEvent.OrderStateCreated, Saveable
    {
        public AbstractOrderStateCreated() {
            this(new OrderStateEventId());
        }

        public AbstractOrderStateCreated(OrderStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

        private Map<OrderItemStateEventId, OrderItemStateEvent.OrderItemStateCreated> orderItemEvents = new HashMap<OrderItemStateEventId, OrderItemStateEvent.OrderItemStateCreated>();
        
        private Iterable<OrderItemStateEvent.OrderItemStateCreated> readOnlyOrderItemEvents;

        public Iterable<OrderItemStateEvent.OrderItemStateCreated> getOrderItemEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.orderItemEvents.values();
            }
            else
            {
                if (readOnlyOrderItemEvents != null) { return readOnlyOrderItemEvents; }
                OrderItemStateEventDao eventDao = getOrderItemStateEventDao();
                List<OrderItemStateEvent.OrderItemStateCreated> eL = new ArrayList<OrderItemStateEvent.OrderItemStateCreated>();
                for (OrderItemStateEvent e : eventDao.findByOrderStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((OrderItemStateEvent.OrderItemStateCreated)e);
                }
                return (readOnlyOrderItemEvents = eL);
            }
        }

        public void setOrderItemEvents(Iterable<OrderItemStateEvent.OrderItemStateCreated> es)
        {
            if (es != null)
            {
                for (OrderItemStateEvent.OrderItemStateCreated e : es)
                {
                    addOrderItemEvent(e);
                }
            }
            else { this.orderItemEvents.clear(); }
        }
        
        public void addOrderItemEvent(OrderItemStateEvent.OrderItemStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.orderItemEvents.put(e.getStateEventId(), e);
        }

        public void save()
        {
            for (OrderItemStateEvent.OrderItemStateCreated e : this.getOrderItemEvents()) {
                getOrderItemStateEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractOrderStateMergePatched extends AbstractOrderStateEvent implements OrderStateEvent.OrderStateMergePatched, Saveable
    {
        public AbstractOrderStateMergePatched() {
            this(new OrderStateEventId());
        }

        public AbstractOrderStateMergePatched(OrderStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyOrderTypeIdRemoved;

        public Boolean getIsPropertyOrderTypeIdRemoved() {
            return this.isPropertyOrderTypeIdRemoved;
        }

        public void setIsPropertyOrderTypeIdRemoved(Boolean removed) {
            this.isPropertyOrderTypeIdRemoved = removed;
        }

        private Boolean isPropertyOrderNameRemoved;

        public Boolean getIsPropertyOrderNameRemoved() {
            return this.isPropertyOrderNameRemoved;
        }

        public void setIsPropertyOrderNameRemoved(Boolean removed) {
            this.isPropertyOrderNameRemoved = removed;
        }

        private Boolean isPropertyExternalIdRemoved;

        public Boolean getIsPropertyExternalIdRemoved() {
            return this.isPropertyExternalIdRemoved;
        }

        public void setIsPropertyExternalIdRemoved(Boolean removed) {
            this.isPropertyExternalIdRemoved = removed;
        }

        private Boolean isPropertySalesChannelEnumIdRemoved;

        public Boolean getIsPropertySalesChannelEnumIdRemoved() {
            return this.isPropertySalesChannelEnumIdRemoved;
        }

        public void setIsPropertySalesChannelEnumIdRemoved(Boolean removed) {
            this.isPropertySalesChannelEnumIdRemoved = removed;
        }

        private Boolean isPropertyOrderDateRemoved;

        public Boolean getIsPropertyOrderDateRemoved() {
            return this.isPropertyOrderDateRemoved;
        }

        public void setIsPropertyOrderDateRemoved(Boolean removed) {
            this.isPropertyOrderDateRemoved = removed;
        }

        private Boolean isPropertyPriorityRemoved;

        public Boolean getIsPropertyPriorityRemoved() {
            return this.isPropertyPriorityRemoved;
        }

        public void setIsPropertyPriorityRemoved(Boolean removed) {
            this.isPropertyPriorityRemoved = removed;
        }

        private Boolean isPropertyEntryDateRemoved;

        public Boolean getIsPropertyEntryDateRemoved() {
            return this.isPropertyEntryDateRemoved;
        }

        public void setIsPropertyEntryDateRemoved(Boolean removed) {
            this.isPropertyEntryDateRemoved = removed;
        }

        private Boolean isPropertyPickSheetPrintedDateRemoved;

        public Boolean getIsPropertyPickSheetPrintedDateRemoved() {
            return this.isPropertyPickSheetPrintedDateRemoved;
        }

        public void setIsPropertyPickSheetPrintedDateRemoved(Boolean removed) {
            this.isPropertyPickSheetPrintedDateRemoved = removed;
        }

        private Boolean isPropertyStatusIdRemoved;

        public Boolean getIsPropertyStatusIdRemoved() {
            return this.isPropertyStatusIdRemoved;
        }

        public void setIsPropertyStatusIdRemoved(Boolean removed) {
            this.isPropertyStatusIdRemoved = removed;
        }

        private Boolean isPropertyCurrencyUomRemoved;

        public Boolean getIsPropertyCurrencyUomRemoved() {
            return this.isPropertyCurrencyUomRemoved;
        }

        public void setIsPropertyCurrencyUomRemoved(Boolean removed) {
            this.isPropertyCurrencyUomRemoved = removed;
        }

        private Boolean isPropertySyncStatusIdRemoved;

        public Boolean getIsPropertySyncStatusIdRemoved() {
            return this.isPropertySyncStatusIdRemoved;
        }

        public void setIsPropertySyncStatusIdRemoved(Boolean removed) {
            this.isPropertySyncStatusIdRemoved = removed;
        }

        private Boolean isPropertyBillingAccountIdRemoved;

        public Boolean getIsPropertyBillingAccountIdRemoved() {
            return this.isPropertyBillingAccountIdRemoved;
        }

        public void setIsPropertyBillingAccountIdRemoved(Boolean removed) {
            this.isPropertyBillingAccountIdRemoved = removed;
        }

        private Boolean isPropertyOriginFacilityIdRemoved;

        public Boolean getIsPropertyOriginFacilityIdRemoved() {
            return this.isPropertyOriginFacilityIdRemoved;
        }

        public void setIsPropertyOriginFacilityIdRemoved(Boolean removed) {
            this.isPropertyOriginFacilityIdRemoved = removed;
        }

        private Boolean isPropertyWebSiteIdRemoved;

        public Boolean getIsPropertyWebSiteIdRemoved() {
            return this.isPropertyWebSiteIdRemoved;
        }

        public void setIsPropertyWebSiteIdRemoved(Boolean removed) {
            this.isPropertyWebSiteIdRemoved = removed;
        }

        private Boolean isPropertyProductStoreIdRemoved;

        public Boolean getIsPropertyProductStoreIdRemoved() {
            return this.isPropertyProductStoreIdRemoved;
        }

        public void setIsPropertyProductStoreIdRemoved(Boolean removed) {
            this.isPropertyProductStoreIdRemoved = removed;
        }

        private Boolean isPropertyTerminalIdRemoved;

        public Boolean getIsPropertyTerminalIdRemoved() {
            return this.isPropertyTerminalIdRemoved;
        }

        public void setIsPropertyTerminalIdRemoved(Boolean removed) {
            this.isPropertyTerminalIdRemoved = removed;
        }

        private Boolean isPropertyTransactionIdRemoved;

        public Boolean getIsPropertyTransactionIdRemoved() {
            return this.isPropertyTransactionIdRemoved;
        }

        public void setIsPropertyTransactionIdRemoved(Boolean removed) {
            this.isPropertyTransactionIdRemoved = removed;
        }

        private Boolean isPropertyAutoOrderShoppingListIdRemoved;

        public Boolean getIsPropertyAutoOrderShoppingListIdRemoved() {
            return this.isPropertyAutoOrderShoppingListIdRemoved;
        }

        public void setIsPropertyAutoOrderShoppingListIdRemoved(Boolean removed) {
            this.isPropertyAutoOrderShoppingListIdRemoved = removed;
        }

        private Boolean isPropertyNeedsInventoryIssuanceRemoved;

        public Boolean getIsPropertyNeedsInventoryIssuanceRemoved() {
            return this.isPropertyNeedsInventoryIssuanceRemoved;
        }

        public void setIsPropertyNeedsInventoryIssuanceRemoved(Boolean removed) {
            this.isPropertyNeedsInventoryIssuanceRemoved = removed;
        }

        private Boolean isPropertyIsRushOrderRemoved;

        public Boolean getIsPropertyIsRushOrderRemoved() {
            return this.isPropertyIsRushOrderRemoved;
        }

        public void setIsPropertyIsRushOrderRemoved(Boolean removed) {
            this.isPropertyIsRushOrderRemoved = removed;
        }

        private Boolean isPropertyInternalCodeRemoved;

        public Boolean getIsPropertyInternalCodeRemoved() {
            return this.isPropertyInternalCodeRemoved;
        }

        public void setIsPropertyInternalCodeRemoved(Boolean removed) {
            this.isPropertyInternalCodeRemoved = removed;
        }

        private Boolean isPropertyRemainingSubTotalRemoved;

        public Boolean getIsPropertyRemainingSubTotalRemoved() {
            return this.isPropertyRemainingSubTotalRemoved;
        }

        public void setIsPropertyRemainingSubTotalRemoved(Boolean removed) {
            this.isPropertyRemainingSubTotalRemoved = removed;
        }

        private Boolean isPropertyGrandTotalRemoved;

        public Boolean getIsPropertyGrandTotalRemoved() {
            return this.isPropertyGrandTotalRemoved;
        }

        public void setIsPropertyGrandTotalRemoved(Boolean removed) {
            this.isPropertyGrandTotalRemoved = removed;
        }

        private Boolean isPropertyInvoicePerShipmentRemoved;

        public Boolean getIsPropertyInvoicePerShipmentRemoved() {
            return this.isPropertyInvoicePerShipmentRemoved;
        }

        public void setIsPropertyInvoicePerShipmentRemoved(Boolean removed) {
            this.isPropertyInvoicePerShipmentRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

        private Map<OrderItemStateEventId, OrderItemStateEvent> orderItemEvents = new HashMap<OrderItemStateEventId, OrderItemStateEvent>();
        
        private Iterable<OrderItemStateEvent> readOnlyOrderItemEvents;

        public Iterable<OrderItemStateEvent> getOrderItemEvents()
        {
            if (!getStateEventReadOnly())
            {
                return this.orderItemEvents.values();
            }
            else
            {
                if (readOnlyOrderItemEvents != null) { return readOnlyOrderItemEvents; }
                OrderItemStateEventDao eventDao = getOrderItemStateEventDao();
                List<OrderItemStateEvent> eL = new ArrayList<OrderItemStateEvent>();
                for (OrderItemStateEvent e : eventDao.findByOrderStateEventId(this.getStateEventId()))
                {
                    e.setStateEventReadOnly(true);
                    eL.add((OrderItemStateEvent)e);
                }
                return (readOnlyOrderItemEvents = eL);
            }
        }

        public void setOrderItemEvents(Iterable<OrderItemStateEvent> es)
        {
            if (es != null)
            {
                for (OrderItemStateEvent e : es)
                {
                    addOrderItemEvent(e);
                }
            }
            else { this.orderItemEvents.clear(); }
        }
        
        public void addOrderItemEvent(OrderItemStateEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.orderItemEvents.put(e.getStateEventId(), e);
        }

        public void save()
        {
            for (OrderItemStateEvent e : this.getOrderItemEvents()) {
                getOrderItemStateEventDao().save(e);
            }
        }
    }


    public static class SimpleOrderStateCreated extends AbstractOrderStateCreated
    {
        public SimpleOrderStateCreated() {
        }

        public SimpleOrderStateCreated(OrderStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleOrderStateMergePatched extends AbstractOrderStateMergePatched
    {
        public SimpleOrderStateMergePatched() {
        }

        public SimpleOrderStateMergePatched(OrderStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

