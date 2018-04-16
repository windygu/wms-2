package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface OrderEvent extends Event
{
    OrderEventId getOrderEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface OrderStateEvent extends OrderEvent {
        String getOrderTypeId();

        void setOrderTypeId(String orderTypeId);

        String getOrderName();

        void setOrderName(String orderName);

        String getExternalId();

        void setExternalId(String externalId);

        String getSalesChannelEnumId();

        void setSalesChannelEnumId(String salesChannelEnumId);

        java.sql.Timestamp getOrderDate();

        void setOrderDate(java.sql.Timestamp orderDate);

        String getPriority();

        void setPriority(String priority);

        java.sql.Timestamp getEntryDate();

        void setEntryDate(java.sql.Timestamp entryDate);

        java.sql.Timestamp getPickSheetPrintedDate();

        void setPickSheetPrintedDate(java.sql.Timestamp pickSheetPrintedDate);

        String getStatusId();

        void setStatusId(String statusId);

        String getCurrencyUom();

        void setCurrencyUom(String currencyUom);

        String getSyncStatusId();

        void setSyncStatusId(String syncStatusId);

        String getBillingAccountId();

        void setBillingAccountId(String billingAccountId);

        String getOriginFacilityId();

        void setOriginFacilityId(String originFacilityId);

        String getWebSiteId();

        void setWebSiteId(String webSiteId);

        String getProductStoreId();

        void setProductStoreId(String productStoreId);

        String getTerminalId();

        void setTerminalId(String terminalId);

        String getTransactionId();

        void setTransactionId(String transactionId);

        String getAutoOrderShoppingListId();

        void setAutoOrderShoppingListId(String autoOrderShoppingListId);

        String getNeedsInventoryIssuance();

        void setNeedsInventoryIssuance(String needsInventoryIssuance);

        String getIsRushOrder();

        void setIsRushOrder(String isRushOrder);

        String getInternalCode();

        void setInternalCode(String internalCode);

        java.math.BigDecimal getRemainingSubTotal();

        void setRemainingSubTotal(java.math.BigDecimal remainingSubTotal);

        java.math.BigDecimal getGrandTotal();

        void setGrandTotal(java.math.BigDecimal grandTotal);

        String getInvoicePerShipment();

        void setInvoicePerShipment(String invoicePerShipment);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface OrderStateCreated extends OrderStateEvent
    {
        Iterable<OrderRoleEvent.OrderRoleStateCreated> getOrderRoleEvents();
        
        void addOrderRoleEvent(OrderRoleEvent.OrderRoleStateCreated e);

        OrderRoleEvent.OrderRoleStateCreated newOrderRoleStateCreated(PartyRoleId partyRoleId);

        Iterable<OrderItemEvent.OrderItemStateCreated> getOrderItemEvents();
        
        void addOrderItemEvent(OrderItemEvent.OrderItemStateCreated e);

        OrderItemEvent.OrderItemStateCreated newOrderItemStateCreated(String orderItemSeqId);

        Iterable<OrderShipGroupEvent.OrderShipGroupStateCreated> getOrderShipGroupEvents();
        
        void addOrderShipGroupEvent(OrderShipGroupEvent.OrderShipGroupStateCreated e);

        OrderShipGroupEvent.OrderShipGroupStateCreated newOrderShipGroupStateCreated(Long shipGroupSeqId);

    
    }


    interface OrderStateMergePatched extends OrderStateEvent
    {
        Boolean getIsPropertyOrderTypeIdRemoved();

        void setIsPropertyOrderTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderNameRemoved();

        void setIsPropertyOrderNameRemoved(Boolean removed);

        Boolean getIsPropertyExternalIdRemoved();

        void setIsPropertyExternalIdRemoved(Boolean removed);

        Boolean getIsPropertySalesChannelEnumIdRemoved();

        void setIsPropertySalesChannelEnumIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderDateRemoved();

        void setIsPropertyOrderDateRemoved(Boolean removed);

        Boolean getIsPropertyPriorityRemoved();

        void setIsPropertyPriorityRemoved(Boolean removed);

        Boolean getIsPropertyEntryDateRemoved();

        void setIsPropertyEntryDateRemoved(Boolean removed);

        Boolean getIsPropertyPickSheetPrintedDateRemoved();

        void setIsPropertyPickSheetPrintedDateRemoved(Boolean removed);

        Boolean getIsPropertyStatusIdRemoved();

        void setIsPropertyStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyCurrencyUomRemoved();

        void setIsPropertyCurrencyUomRemoved(Boolean removed);

        Boolean getIsPropertySyncStatusIdRemoved();

        void setIsPropertySyncStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyBillingAccountIdRemoved();

        void setIsPropertyBillingAccountIdRemoved(Boolean removed);

        Boolean getIsPropertyOriginFacilityIdRemoved();

        void setIsPropertyOriginFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyWebSiteIdRemoved();

        void setIsPropertyWebSiteIdRemoved(Boolean removed);

        Boolean getIsPropertyProductStoreIdRemoved();

        void setIsPropertyProductStoreIdRemoved(Boolean removed);

        Boolean getIsPropertyTerminalIdRemoved();

        void setIsPropertyTerminalIdRemoved(Boolean removed);

        Boolean getIsPropertyTransactionIdRemoved();

        void setIsPropertyTransactionIdRemoved(Boolean removed);

        Boolean getIsPropertyAutoOrderShoppingListIdRemoved();

        void setIsPropertyAutoOrderShoppingListIdRemoved(Boolean removed);

        Boolean getIsPropertyNeedsInventoryIssuanceRemoved();

        void setIsPropertyNeedsInventoryIssuanceRemoved(Boolean removed);

        Boolean getIsPropertyIsRushOrderRemoved();

        void setIsPropertyIsRushOrderRemoved(Boolean removed);

        Boolean getIsPropertyInternalCodeRemoved();

        void setIsPropertyInternalCodeRemoved(Boolean removed);

        Boolean getIsPropertyRemainingSubTotalRemoved();

        void setIsPropertyRemainingSubTotalRemoved(Boolean removed);

        Boolean getIsPropertyGrandTotalRemoved();

        void setIsPropertyGrandTotalRemoved(Boolean removed);

        Boolean getIsPropertyInvoicePerShipmentRemoved();

        void setIsPropertyInvoicePerShipmentRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Iterable<OrderRoleEvent> getOrderRoleEvents();
        
        void addOrderRoleEvent(OrderRoleEvent e);

        OrderRoleEvent.OrderRoleStateCreated newOrderRoleStateCreated(PartyRoleId partyRoleId);

        OrderRoleEvent.OrderRoleStateMergePatched newOrderRoleStateMergePatched(PartyRoleId partyRoleId);

        OrderRoleEvent.OrderRoleStateRemoved newOrderRoleStateRemoved(PartyRoleId partyRoleId);

        Iterable<OrderItemEvent> getOrderItemEvents();
        
        void addOrderItemEvent(OrderItemEvent e);

        OrderItemEvent.OrderItemStateCreated newOrderItemStateCreated(String orderItemSeqId);

        OrderItemEvent.OrderItemStateMergePatched newOrderItemStateMergePatched(String orderItemSeqId);

        Iterable<OrderShipGroupEvent> getOrderShipGroupEvents();
        
        void addOrderShipGroupEvent(OrderShipGroupEvent e);

        OrderShipGroupEvent.OrderShipGroupStateCreated newOrderShipGroupStateCreated(Long shipGroupSeqId);

        OrderShipGroupEvent.OrderShipGroupStateMergePatched newOrderShipGroupStateMergePatched(Long shipGroupSeqId);

        OrderShipGroupEvent.OrderShipGroupStateRemoved newOrderShipGroupStateRemoved(Long shipGroupSeqId);


    }


}

