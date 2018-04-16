package org.dddml.wms.domain.orderrolemvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractOrderRoleMvoEvent extends AbstractEvent implements OrderRoleMvoEvent 
{
    private OrderRoleMvoEventId orderRoleMvoEventId;

    public OrderRoleMvoEventId getOrderRoleMvoEventId() {
        return this.orderRoleMvoEventId;
    }

    public void setOrderRoleMvoEventId(OrderRoleMvoEventId eventId) {
        this.orderRoleMvoEventId = eventId;
    }
    
    public OrderRoleId getOrderRoleId() {
        return getOrderRoleMvoEventId().getOrderRoleId();
    }

    public void setOrderRoleId(OrderRoleId orderRoleId) {
        getOrderRoleMvoEventId().setOrderRoleId(orderRoleId);
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

    protected AbstractOrderRoleMvoEvent() {
    }

    protected AbstractOrderRoleMvoEvent(OrderRoleMvoEventId eventId) {
        this.orderRoleMvoEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractOrderRoleMvoStateEvent extends AbstractOrderRoleMvoEvent implements OrderRoleMvoEvent.OrderRoleMvoStateEvent {
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

        protected AbstractOrderRoleMvoStateEvent(OrderRoleMvoEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractOrderRoleMvoStateCreated extends AbstractOrderRoleMvoStateEvent implements OrderRoleMvoEvent.OrderRoleMvoStateCreated
    {
        public AbstractOrderRoleMvoStateCreated() {
            this(new OrderRoleMvoEventId());
        }

        public AbstractOrderRoleMvoStateCreated(OrderRoleMvoEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractOrderRoleMvoStateMergePatched extends AbstractOrderRoleMvoStateEvent implements OrderRoleMvoEvent.OrderRoleMvoStateMergePatched
    {
        public AbstractOrderRoleMvoStateMergePatched() {
            this(new OrderRoleMvoEventId());
        }

        public AbstractOrderRoleMvoStateMergePatched(OrderRoleMvoEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
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

    }


    public static abstract class AbstractOrderRoleMvoStateDeleted extends AbstractOrderRoleMvoStateEvent implements OrderRoleMvoEvent.OrderRoleMvoStateDeleted
    {
        public AbstractOrderRoleMvoStateDeleted() {
            this(new OrderRoleMvoEventId());
        }

        public AbstractOrderRoleMvoStateDeleted(OrderRoleMvoEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleOrderRoleMvoStateCreated extends AbstractOrderRoleMvoStateCreated
    {
        public SimpleOrderRoleMvoStateCreated() {
        }

        public SimpleOrderRoleMvoStateCreated(OrderRoleMvoEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrderRoleMvoStateMergePatched extends AbstractOrderRoleMvoStateMergePatched
    {
        public SimpleOrderRoleMvoStateMergePatched() {
        }

        public SimpleOrderRoleMvoStateMergePatched(OrderRoleMvoEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrderRoleMvoStateDeleted extends AbstractOrderRoleMvoStateDeleted
    {
        public SimpleOrderRoleMvoStateDeleted() {
        }

        public SimpleOrderRoleMvoStateDeleted(OrderRoleMvoEventId eventId) {
            super(eventId);
        }
    }

}

