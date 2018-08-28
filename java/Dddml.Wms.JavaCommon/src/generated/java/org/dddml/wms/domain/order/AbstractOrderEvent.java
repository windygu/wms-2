package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractOrderEvent extends AbstractEvent implements OrderEvent 
{
    private OrderEventId orderEventId;

    public OrderEventId getOrderEventId() {
        return this.orderEventId;
    }

    public void setOrderEventId(OrderEventId eventId) {
        this.orderEventId = eventId;
    }
    
    public String getOrderId() {
        return getOrderEventId().getOrderId();
    }

    public void setOrderId(String orderId) {
        getOrderEventId().setOrderId(orderId);
    }

    private boolean stateEventReadOnly;

    public boolean getEventReadOnly() { return this.stateEventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractOrderEvent() {
    }

    protected AbstractOrderEvent(OrderEventId eventId) {
        this.orderEventId = eventId;
    }

    protected OrderRoleEventDao getOrderRoleEventDao() {
        return (OrderRoleEventDao)ApplicationContext.current.get("OrderRoleEventDao");
    }

    protected OrderRoleEventId newOrderRoleEventId(PartyRoleId partyRoleId)
    {
        OrderRoleEventId eventId = new OrderRoleEventId(this.getOrderEventId().getOrderId(), 
            partyRoleId, 
            this.getOrderEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(OrderRoleEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(OrderEvent oe, OrderRoleEvent e)
    {
        if (!oe.getOrderEventId().getOrderId().equals(e.getOrderRoleEventId().getOrderId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id OrderId %1$s but inner id OrderId %2$s", 
                oe.getOrderEventId().getOrderId(), e.getOrderRoleEventId().getOrderId());
        }
    }

    protected OrderItemEventDao getOrderItemEventDao() {
        return (OrderItemEventDao)ApplicationContext.current.get("OrderItemEventDao");
    }

    protected OrderItemEventId newOrderItemEventId(String orderItemSeqId)
    {
        OrderItemEventId eventId = new OrderItemEventId(this.getOrderEventId().getOrderId(), 
            orderItemSeqId, 
            this.getOrderEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(OrderItemEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(OrderEvent oe, OrderItemEvent e)
    {
        if (!oe.getOrderEventId().getOrderId().equals(e.getOrderItemEventId().getOrderId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id OrderId %1$s but inner id OrderId %2$s", 
                oe.getOrderEventId().getOrderId(), e.getOrderItemEventId().getOrderId());
        }
    }

    protected OrderShipGroupEventDao getOrderShipGroupEventDao() {
        return (OrderShipGroupEventDao)ApplicationContext.current.get("OrderShipGroupEventDao");
    }

    protected OrderShipGroupEventId newOrderShipGroupEventId(String shipGroupSeqId)
    {
        OrderShipGroupEventId eventId = new OrderShipGroupEventId(this.getOrderEventId().getOrderId(), 
            shipGroupSeqId, 
            this.getOrderEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(OrderShipGroupEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(OrderEvent oe, OrderShipGroupEvent e)
    {
        if (!oe.getOrderEventId().getOrderId().equals(e.getOrderShipGroupEventId().getOrderId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id OrderId %1$s but inner id OrderId %2$s", 
                oe.getOrderEventId().getOrderId(), e.getOrderShipGroupEventId().getOrderId());
        }
    }

    public OrderRoleEvent.OrderRoleStateCreated newOrderRoleStateCreated(PartyRoleId partyRoleId) {
        return new AbstractOrderRoleEvent.SimpleOrderRoleStateCreated(newOrderRoleEventId(partyRoleId));
    }

    public OrderRoleEvent.OrderRoleStateMergePatched newOrderRoleStateMergePatched(PartyRoleId partyRoleId) {
        return new AbstractOrderRoleEvent.SimpleOrderRoleStateMergePatched(newOrderRoleEventId(partyRoleId));
    }

    public OrderRoleEvent.OrderRoleStateRemoved newOrderRoleStateRemoved(PartyRoleId partyRoleId) {
        return new AbstractOrderRoleEvent.SimpleOrderRoleStateRemoved(newOrderRoleEventId(partyRoleId));
    }

    public OrderItemEvent.OrderItemStateCreated newOrderItemStateCreated(String orderItemSeqId) {
        return new AbstractOrderItemEvent.SimpleOrderItemStateCreated(newOrderItemEventId(orderItemSeqId));
    }

    public OrderItemEvent.OrderItemStateMergePatched newOrderItemStateMergePatched(String orderItemSeqId) {
        return new AbstractOrderItemEvent.SimpleOrderItemStateMergePatched(newOrderItemEventId(orderItemSeqId));
    }

    public OrderShipGroupEvent.OrderShipGroupStateCreated newOrderShipGroupStateCreated(String shipGroupSeqId) {
        return new AbstractOrderShipGroupEvent.SimpleOrderShipGroupStateCreated(newOrderShipGroupEventId(shipGroupSeqId));
    }

    public OrderShipGroupEvent.OrderShipGroupStateMergePatched newOrderShipGroupStateMergePatched(String shipGroupSeqId) {
        return new AbstractOrderShipGroupEvent.SimpleOrderShipGroupStateMergePatched(newOrderShipGroupEventId(shipGroupSeqId));
    }

    public OrderShipGroupEvent.OrderShipGroupStateRemoved newOrderShipGroupStateRemoved(String shipGroupSeqId) {
        return new AbstractOrderShipGroupEvent.SimpleOrderShipGroupStateRemoved(newOrderShipGroupEventId(shipGroupSeqId));
    }


    public abstract String getEventType();


    public static abstract class AbstractOrderStateEvent extends AbstractOrderEvent implements OrderEvent.OrderStateEvent {
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

        private String currencyUomId;

        public String getCurrencyUomId()
        {
            return this.currencyUomId;
        }

        public void setCurrencyUomId(String currencyUomId)
        {
            this.currencyUomId = currencyUomId;
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

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        protected AbstractOrderStateEvent(OrderEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractOrderStateCreated extends AbstractOrderStateEvent implements OrderEvent.OrderStateCreated, Saveable
    {
        public AbstractOrderStateCreated() {
            this(new OrderEventId());
        }

        public AbstractOrderStateCreated(OrderEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

        private Map<OrderRoleEventId, OrderRoleEvent.OrderRoleStateCreated> orderRoleEvents = new HashMap<OrderRoleEventId, OrderRoleEvent.OrderRoleStateCreated>();
        
        private Iterable<OrderRoleEvent.OrderRoleStateCreated> readOnlyOrderRoleEvents;

        public Iterable<OrderRoleEvent.OrderRoleStateCreated> getOrderRoleEvents()
        {
            if (!getEventReadOnly())
            {
                return this.orderRoleEvents.values();
            }
            else
            {
                if (readOnlyOrderRoleEvents != null) { return readOnlyOrderRoleEvents; }
                OrderRoleEventDao eventDao = getOrderRoleEventDao();
                List<OrderRoleEvent.OrderRoleStateCreated> eL = new ArrayList<OrderRoleEvent.OrderRoleStateCreated>();
                for (OrderRoleEvent e : eventDao.findByOrderEventId(this.getOrderEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((OrderRoleEvent.OrderRoleStateCreated)e);
                }
                return (readOnlyOrderRoleEvents = eL);
            }
        }

        public void setOrderRoleEvents(Iterable<OrderRoleEvent.OrderRoleStateCreated> es)
        {
            if (es != null)
            {
                for (OrderRoleEvent.OrderRoleStateCreated e : es)
                {
                    addOrderRoleEvent(e);
                }
            }
            else { this.orderRoleEvents.clear(); }
        }
        
        public void addOrderRoleEvent(OrderRoleEvent.OrderRoleStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.orderRoleEvents.put(e.getOrderRoleEventId(), e);
        }

        private Map<OrderItemEventId, OrderItemEvent.OrderItemStateCreated> orderItemEvents = new HashMap<OrderItemEventId, OrderItemEvent.OrderItemStateCreated>();
        
        private Iterable<OrderItemEvent.OrderItemStateCreated> readOnlyOrderItemEvents;

        public Iterable<OrderItemEvent.OrderItemStateCreated> getOrderItemEvents()
        {
            if (!getEventReadOnly())
            {
                return this.orderItemEvents.values();
            }
            else
            {
                if (readOnlyOrderItemEvents != null) { return readOnlyOrderItemEvents; }
                OrderItemEventDao eventDao = getOrderItemEventDao();
                List<OrderItemEvent.OrderItemStateCreated> eL = new ArrayList<OrderItemEvent.OrderItemStateCreated>();
                for (OrderItemEvent e : eventDao.findByOrderEventId(this.getOrderEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((OrderItemEvent.OrderItemStateCreated)e);
                }
                return (readOnlyOrderItemEvents = eL);
            }
        }

        public void setOrderItemEvents(Iterable<OrderItemEvent.OrderItemStateCreated> es)
        {
            if (es != null)
            {
                for (OrderItemEvent.OrderItemStateCreated e : es)
                {
                    addOrderItemEvent(e);
                }
            }
            else { this.orderItemEvents.clear(); }
        }
        
        public void addOrderItemEvent(OrderItemEvent.OrderItemStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.orderItemEvents.put(e.getOrderItemEventId(), e);
        }

        private Map<OrderShipGroupEventId, OrderShipGroupEvent.OrderShipGroupStateCreated> orderShipGroupEvents = new HashMap<OrderShipGroupEventId, OrderShipGroupEvent.OrderShipGroupStateCreated>();
        
        private Iterable<OrderShipGroupEvent.OrderShipGroupStateCreated> readOnlyOrderShipGroupEvents;

        public Iterable<OrderShipGroupEvent.OrderShipGroupStateCreated> getOrderShipGroupEvents()
        {
            if (!getEventReadOnly())
            {
                return this.orderShipGroupEvents.values();
            }
            else
            {
                if (readOnlyOrderShipGroupEvents != null) { return readOnlyOrderShipGroupEvents; }
                OrderShipGroupEventDao eventDao = getOrderShipGroupEventDao();
                List<OrderShipGroupEvent.OrderShipGroupStateCreated> eL = new ArrayList<OrderShipGroupEvent.OrderShipGroupStateCreated>();
                for (OrderShipGroupEvent e : eventDao.findByOrderEventId(this.getOrderEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((OrderShipGroupEvent.OrderShipGroupStateCreated)e);
                }
                return (readOnlyOrderShipGroupEvents = eL);
            }
        }

        public void setOrderShipGroupEvents(Iterable<OrderShipGroupEvent.OrderShipGroupStateCreated> es)
        {
            if (es != null)
            {
                for (OrderShipGroupEvent.OrderShipGroupStateCreated e : es)
                {
                    addOrderShipGroupEvent(e);
                }
            }
            else { this.orderShipGroupEvents.clear(); }
        }
        
        public void addOrderShipGroupEvent(OrderShipGroupEvent.OrderShipGroupStateCreated e)
        {
            throwOnInconsistentEventIds(e);
            this.orderShipGroupEvents.put(e.getOrderShipGroupEventId(), e);
        }

        public void save()
        {
            for (OrderRoleEvent.OrderRoleStateCreated e : this.getOrderRoleEvents()) {
                getOrderRoleEventDao().save(e);
            }
            for (OrderItemEvent.OrderItemStateCreated e : this.getOrderItemEvents()) {
                getOrderItemEventDao().save(e);
            }
            for (OrderShipGroupEvent.OrderShipGroupStateCreated e : this.getOrderShipGroupEvents()) {
                getOrderShipGroupEventDao().save(e);
            }
        }
    }


    public static abstract class AbstractOrderStateMergePatched extends AbstractOrderStateEvent implements OrderEvent.OrderStateMergePatched, Saveable
    {
        public AbstractOrderStateMergePatched() {
            this(new OrderEventId());
        }

        public AbstractOrderStateMergePatched(OrderEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
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

        private Boolean isPropertyCurrencyUomIdRemoved;

        public Boolean getIsPropertyCurrencyUomIdRemoved() {
            return this.isPropertyCurrencyUomIdRemoved;
        }

        public void setIsPropertyCurrencyUomIdRemoved(Boolean removed) {
            this.isPropertyCurrencyUomIdRemoved = removed;
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

        private Map<OrderRoleEventId, OrderRoleEvent> orderRoleEvents = new HashMap<OrderRoleEventId, OrderRoleEvent>();
        
        private Iterable<OrderRoleEvent> readOnlyOrderRoleEvents;

        public Iterable<OrderRoleEvent> getOrderRoleEvents()
        {
            if (!getEventReadOnly())
            {
                return this.orderRoleEvents.values();
            }
            else
            {
                if (readOnlyOrderRoleEvents != null) { return readOnlyOrderRoleEvents; }
                OrderRoleEventDao eventDao = getOrderRoleEventDao();
                List<OrderRoleEvent> eL = new ArrayList<OrderRoleEvent>();
                for (OrderRoleEvent e : eventDao.findByOrderEventId(this.getOrderEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((OrderRoleEvent)e);
                }
                return (readOnlyOrderRoleEvents = eL);
            }
        }

        public void setOrderRoleEvents(Iterable<OrderRoleEvent> es)
        {
            if (es != null)
            {
                for (OrderRoleEvent e : es)
                {
                    addOrderRoleEvent(e);
                }
            }
            else { this.orderRoleEvents.clear(); }
        }
        
        public void addOrderRoleEvent(OrderRoleEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.orderRoleEvents.put(e.getOrderRoleEventId(), e);
        }

        private Map<OrderItemEventId, OrderItemEvent> orderItemEvents = new HashMap<OrderItemEventId, OrderItemEvent>();
        
        private Iterable<OrderItemEvent> readOnlyOrderItemEvents;

        public Iterable<OrderItemEvent> getOrderItemEvents()
        {
            if (!getEventReadOnly())
            {
                return this.orderItemEvents.values();
            }
            else
            {
                if (readOnlyOrderItemEvents != null) { return readOnlyOrderItemEvents; }
                OrderItemEventDao eventDao = getOrderItemEventDao();
                List<OrderItemEvent> eL = new ArrayList<OrderItemEvent>();
                for (OrderItemEvent e : eventDao.findByOrderEventId(this.getOrderEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((OrderItemEvent)e);
                }
                return (readOnlyOrderItemEvents = eL);
            }
        }

        public void setOrderItemEvents(Iterable<OrderItemEvent> es)
        {
            if (es != null)
            {
                for (OrderItemEvent e : es)
                {
                    addOrderItemEvent(e);
                }
            }
            else { this.orderItemEvents.clear(); }
        }
        
        public void addOrderItemEvent(OrderItemEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.orderItemEvents.put(e.getOrderItemEventId(), e);
        }

        private Map<OrderShipGroupEventId, OrderShipGroupEvent> orderShipGroupEvents = new HashMap<OrderShipGroupEventId, OrderShipGroupEvent>();
        
        private Iterable<OrderShipGroupEvent> readOnlyOrderShipGroupEvents;

        public Iterable<OrderShipGroupEvent> getOrderShipGroupEvents()
        {
            if (!getEventReadOnly())
            {
                return this.orderShipGroupEvents.values();
            }
            else
            {
                if (readOnlyOrderShipGroupEvents != null) { return readOnlyOrderShipGroupEvents; }
                OrderShipGroupEventDao eventDao = getOrderShipGroupEventDao();
                List<OrderShipGroupEvent> eL = new ArrayList<OrderShipGroupEvent>();
                for (OrderShipGroupEvent e : eventDao.findByOrderEventId(this.getOrderEventId()))
                {
                    e.setEventReadOnly(true);
                    eL.add((OrderShipGroupEvent)e);
                }
                return (readOnlyOrderShipGroupEvents = eL);
            }
        }

        public void setOrderShipGroupEvents(Iterable<OrderShipGroupEvent> es)
        {
            if (es != null)
            {
                for (OrderShipGroupEvent e : es)
                {
                    addOrderShipGroupEvent(e);
                }
            }
            else { this.orderShipGroupEvents.clear(); }
        }
        
        public void addOrderShipGroupEvent(OrderShipGroupEvent e)
        {
            throwOnInconsistentEventIds(e);
            this.orderShipGroupEvents.put(e.getOrderShipGroupEventId(), e);
        }

        public void save()
        {
            for (OrderRoleEvent e : this.getOrderRoleEvents()) {
                getOrderRoleEventDao().save(e);
            }
            for (OrderItemEvent e : this.getOrderItemEvents()) {
                getOrderItemEventDao().save(e);
            }
            for (OrderShipGroupEvent e : this.getOrderShipGroupEvents()) {
                getOrderShipGroupEventDao().save(e);
            }
        }
    }


    public static class SimpleOrderStateCreated extends AbstractOrderStateCreated
    {
        public SimpleOrderStateCreated() {
        }

        public SimpleOrderStateCreated(OrderEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrderStateMergePatched extends AbstractOrderStateMergePatched
    {
        public SimpleOrderStateMergePatched() {
        }

        public SimpleOrderStateMergePatched(OrderEventId eventId) {
            super(eventId);
        }
    }

}

