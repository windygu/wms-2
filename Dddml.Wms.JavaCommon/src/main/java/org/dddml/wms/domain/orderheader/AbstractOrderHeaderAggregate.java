package org.dddml.wms.domain.orderheader;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrderHeaderAggregate extends AbstractAggregate implements OrderHeaderAggregate
{
    private OrderHeaderState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractOrderHeaderAggregate(OrderHeaderState state)
    {
        this.state = state;
    }

    public OrderHeaderState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(OrderHeaderCommand.CreateOrderHeader c)
    {
        if (c.getVersion() == null) { c.setVersion(OrderHeaderState.VERSION_NULL); }
        OrderHeaderStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(OrderHeaderCommand.MergePatchOrderHeader c)
    {
        OrderHeaderStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        OrderHeaderCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected OrderHeaderStateEvent map(OrderHeaderCommand.CreateOrderHeader c) {
        OrderHeaderStateEventId stateEventId = new OrderHeaderStateEventId(c.getOrderId(), c.getVersion());
        OrderHeaderStateEvent.OrderHeaderStateCreated e = newOrderHeaderStateCreated(stateEventId);
        e.setOrderTypeId(c.getOrderTypeId());
        e.setOrderName(c.getOrderName());
        e.setExternalId(c.getExternalId());
        e.setSalesChannelEnumId(c.getSalesChannelEnumId());
        e.setOrderDate(c.getOrderDate());
        e.setPriority(c.getPriority());
        e.setEntryDate(c.getEntryDate());
        e.setPickSheetPrintedDate(c.getPickSheetPrintedDate());
        e.setStatusId(c.getStatusId());
        e.setCurrencyUom(c.getCurrencyUom());
        e.setSyncStatusId(c.getSyncStatusId());
        e.setBillingAccountId(c.getBillingAccountId());
        e.setOriginFacilityId(c.getOriginFacilityId());
        e.setWebSiteId(c.getWebSiteId());
        e.setProductStoreId(c.getProductStoreId());
        e.setTerminalId(c.getTerminalId());
        e.setTransactionId(c.getTransactionId());
        e.setAutoOrderShoppingListId(c.getAutoOrderShoppingListId());
        e.setNeedsInventoryIssuance(c.getNeedsInventoryIssuance());
        e.setIsRushOrder(c.getIsRushOrder());
        e.setInternalCode(c.getInternalCode());
        e.setRemainingSubTotal(c.getRemainingSubTotal());
        e.setGrandTotal(c.getGrandTotal());
        e.setInvoicePerShipment(c.getInvoicePerShipment());
        e.setActive(c.getActive());
        ((AbstractOrderHeaderStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderHeaderStateEvent map(OrderHeaderCommand.MergePatchOrderHeader c) {
        OrderHeaderStateEventId stateEventId = new OrderHeaderStateEventId(c.getOrderId(), c.getVersion());
        OrderHeaderStateEvent.OrderHeaderStateMergePatched e = newOrderHeaderStateMergePatched(stateEventId);
        e.setOrderTypeId(c.getOrderTypeId());
        e.setOrderName(c.getOrderName());
        e.setExternalId(c.getExternalId());
        e.setSalesChannelEnumId(c.getSalesChannelEnumId());
        e.setOrderDate(c.getOrderDate());
        e.setPriority(c.getPriority());
        e.setEntryDate(c.getEntryDate());
        e.setPickSheetPrintedDate(c.getPickSheetPrintedDate());
        e.setStatusId(c.getStatusId());
        e.setCurrencyUom(c.getCurrencyUom());
        e.setSyncStatusId(c.getSyncStatusId());
        e.setBillingAccountId(c.getBillingAccountId());
        e.setOriginFacilityId(c.getOriginFacilityId());
        e.setWebSiteId(c.getWebSiteId());
        e.setProductStoreId(c.getProductStoreId());
        e.setTerminalId(c.getTerminalId());
        e.setTransactionId(c.getTransactionId());
        e.setAutoOrderShoppingListId(c.getAutoOrderShoppingListId());
        e.setNeedsInventoryIssuance(c.getNeedsInventoryIssuance());
        e.setIsRushOrder(c.getIsRushOrder());
        e.setInternalCode(c.getInternalCode());
        e.setRemainingSubTotal(c.getRemainingSubTotal());
        e.setGrandTotal(c.getGrandTotal());
        e.setInvoicePerShipment(c.getInvoicePerShipment());
        e.setActive(c.getActive());
        e.setIsPropertyOrderTypeIdRemoved(c.getIsPropertyOrderTypeIdRemoved());
        e.setIsPropertyOrderNameRemoved(c.getIsPropertyOrderNameRemoved());
        e.setIsPropertyExternalIdRemoved(c.getIsPropertyExternalIdRemoved());
        e.setIsPropertySalesChannelEnumIdRemoved(c.getIsPropertySalesChannelEnumIdRemoved());
        e.setIsPropertyOrderDateRemoved(c.getIsPropertyOrderDateRemoved());
        e.setIsPropertyPriorityRemoved(c.getIsPropertyPriorityRemoved());
        e.setIsPropertyEntryDateRemoved(c.getIsPropertyEntryDateRemoved());
        e.setIsPropertyPickSheetPrintedDateRemoved(c.getIsPropertyPickSheetPrintedDateRemoved());
        e.setIsPropertyStatusIdRemoved(c.getIsPropertyStatusIdRemoved());
        e.setIsPropertyCurrencyUomRemoved(c.getIsPropertyCurrencyUomRemoved());
        e.setIsPropertySyncStatusIdRemoved(c.getIsPropertySyncStatusIdRemoved());
        e.setIsPropertyBillingAccountIdRemoved(c.getIsPropertyBillingAccountIdRemoved());
        e.setIsPropertyOriginFacilityIdRemoved(c.getIsPropertyOriginFacilityIdRemoved());
        e.setIsPropertyWebSiteIdRemoved(c.getIsPropertyWebSiteIdRemoved());
        e.setIsPropertyProductStoreIdRemoved(c.getIsPropertyProductStoreIdRemoved());
        e.setIsPropertyTerminalIdRemoved(c.getIsPropertyTerminalIdRemoved());
        e.setIsPropertyTransactionIdRemoved(c.getIsPropertyTransactionIdRemoved());
        e.setIsPropertyAutoOrderShoppingListIdRemoved(c.getIsPropertyAutoOrderShoppingListIdRemoved());
        e.setIsPropertyNeedsInventoryIssuanceRemoved(c.getIsPropertyNeedsInventoryIssuanceRemoved());
        e.setIsPropertyIsRushOrderRemoved(c.getIsPropertyIsRushOrderRemoved());
        e.setIsPropertyInternalCodeRemoved(c.getIsPropertyInternalCodeRemoved());
        e.setIsPropertyRemainingSubTotalRemoved(c.getIsPropertyRemainingSubTotalRemoved());
        e.setIsPropertyGrandTotalRemoved(c.getIsPropertyGrandTotalRemoved());
        e.setIsPropertyInvoicePerShipmentRemoved(c.getIsPropertyInvoicePerShipmentRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractOrderHeaderStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected OrderHeaderStateEvent.OrderHeaderStateCreated newOrderHeaderStateCreated(String commandId, String requesterId) {
        OrderHeaderStateEventId stateEventId = new OrderHeaderStateEventId(this.state.getOrderId(), this.state.getVersion());
        OrderHeaderStateEvent.OrderHeaderStateCreated e = newOrderHeaderStateCreated(stateEventId);
        ((AbstractOrderHeaderStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderHeaderStateEvent.OrderHeaderStateMergePatched newOrderHeaderStateMergePatched(String commandId, String requesterId) {
        OrderHeaderStateEventId stateEventId = new OrderHeaderStateEventId(this.state.getOrderId(), this.state.getVersion());
        OrderHeaderStateEvent.OrderHeaderStateMergePatched e = newOrderHeaderStateMergePatched(stateEventId);
        ((AbstractOrderHeaderStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderHeaderStateEvent.OrderHeaderStateCreated newOrderHeaderStateCreated(OrderHeaderStateEventId stateEventId) {
        return new AbstractOrderHeaderStateEvent.SimpleOrderHeaderStateCreated(stateEventId);
    }

    protected OrderHeaderStateEvent.OrderHeaderStateMergePatched newOrderHeaderStateMergePatched(OrderHeaderStateEventId stateEventId) {
        return new AbstractOrderHeaderStateEvent.SimpleOrderHeaderStateMergePatched(stateEventId);
    }


    public static class SimpleOrderHeaderAggregate extends AbstractOrderHeaderAggregate
    {
        public SimpleOrderHeaderAggregate(OrderHeaderState state) {
            super(state);
        }

    }

}

