package org.dddml.wms.domain.orderrolemvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrderRoleMvoAggregate extends AbstractAggregate implements OrderRoleMvoAggregate
{
    private OrderRoleMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractOrderRoleMvoAggregate(OrderRoleMvoState state)
    {
        this.state = state;
    }

    public OrderRoleMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(OrderRoleMvoCommand.CreateOrderRoleMvo c)
    {
        if (c.getOrderVersion() == null) { c.setOrderVersion(OrderRoleMvoState.VERSION_NULL); }
        OrderRoleMvoStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(OrderRoleMvoCommand.MergePatchOrderRoleMvo c)
    {
        OrderRoleMvoStateEvent e = map(c);
        apply(e);
    }

    public void delete(OrderRoleMvoCommand.DeleteOrderRoleMvo c)
    {
        OrderRoleMvoStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        OrderRoleMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected OrderRoleMvoStateEvent map(OrderRoleMvoCommand.CreateOrderRoleMvo c) {
        OrderRoleMvoEventId stateEventId = new OrderRoleMvoEventId(c.getOrderRoleId(), c.getOrderVersion());
        OrderRoleMvoStateEvent.OrderRoleMvoStateCreated e = newOrderRoleMvoStateCreated(stateEventId);
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setOrderOrderTypeId(c.getOrderOrderTypeId());
        e.setOrderOrderName(c.getOrderOrderName());
        e.setOrderExternalId(c.getOrderExternalId());
        e.setOrderSalesChannelEnumId(c.getOrderSalesChannelEnumId());
        e.setOrderOrderDate(c.getOrderOrderDate());
        e.setOrderPriority(c.getOrderPriority());
        e.setOrderEntryDate(c.getOrderEntryDate());
        e.setOrderPickSheetPrintedDate(c.getOrderPickSheetPrintedDate());
        e.setOrderStatusId(c.getOrderStatusId());
        e.setOrderCurrencyUom(c.getOrderCurrencyUom());
        e.setOrderSyncStatusId(c.getOrderSyncStatusId());
        e.setOrderBillingAccountId(c.getOrderBillingAccountId());
        e.setOrderOriginFacilityId(c.getOrderOriginFacilityId());
        e.setOrderWebSiteId(c.getOrderWebSiteId());
        e.setOrderProductStoreId(c.getOrderProductStoreId());
        e.setOrderTerminalId(c.getOrderTerminalId());
        e.setOrderTransactionId(c.getOrderTransactionId());
        e.setOrderAutoOrderShoppingListId(c.getOrderAutoOrderShoppingListId());
        e.setOrderNeedsInventoryIssuance(c.getOrderNeedsInventoryIssuance());
        e.setOrderIsRushOrder(c.getOrderIsRushOrder());
        e.setOrderInternalCode(c.getOrderInternalCode());
        e.setOrderRemainingSubTotal(c.getOrderRemainingSubTotal());
        e.setOrderGrandTotal(c.getOrderGrandTotal());
        e.setOrderInvoicePerShipment(c.getOrderInvoicePerShipment());
        e.setOrderCreatedBy(c.getOrderCreatedBy());
        e.setOrderCreatedAt(c.getOrderCreatedAt());
        e.setOrderUpdatedBy(c.getOrderUpdatedBy());
        e.setOrderUpdatedAt(c.getOrderUpdatedAt());
        e.setOrderActive(c.getOrderActive());
        ((AbstractOrderRoleMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderRoleMvoStateEvent map(OrderRoleMvoCommand.MergePatchOrderRoleMvo c) {
        OrderRoleMvoEventId stateEventId = new OrderRoleMvoEventId(c.getOrderRoleId(), c.getOrderVersion());
        OrderRoleMvoStateEvent.OrderRoleMvoStateMergePatched e = newOrderRoleMvoStateMergePatched(stateEventId);
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setOrderOrderTypeId(c.getOrderOrderTypeId());
        e.setOrderOrderName(c.getOrderOrderName());
        e.setOrderExternalId(c.getOrderExternalId());
        e.setOrderSalesChannelEnumId(c.getOrderSalesChannelEnumId());
        e.setOrderOrderDate(c.getOrderOrderDate());
        e.setOrderPriority(c.getOrderPriority());
        e.setOrderEntryDate(c.getOrderEntryDate());
        e.setOrderPickSheetPrintedDate(c.getOrderPickSheetPrintedDate());
        e.setOrderStatusId(c.getOrderStatusId());
        e.setOrderCurrencyUom(c.getOrderCurrencyUom());
        e.setOrderSyncStatusId(c.getOrderSyncStatusId());
        e.setOrderBillingAccountId(c.getOrderBillingAccountId());
        e.setOrderOriginFacilityId(c.getOrderOriginFacilityId());
        e.setOrderWebSiteId(c.getOrderWebSiteId());
        e.setOrderProductStoreId(c.getOrderProductStoreId());
        e.setOrderTerminalId(c.getOrderTerminalId());
        e.setOrderTransactionId(c.getOrderTransactionId());
        e.setOrderAutoOrderShoppingListId(c.getOrderAutoOrderShoppingListId());
        e.setOrderNeedsInventoryIssuance(c.getOrderNeedsInventoryIssuance());
        e.setOrderIsRushOrder(c.getOrderIsRushOrder());
        e.setOrderInternalCode(c.getOrderInternalCode());
        e.setOrderRemainingSubTotal(c.getOrderRemainingSubTotal());
        e.setOrderGrandTotal(c.getOrderGrandTotal());
        e.setOrderInvoicePerShipment(c.getOrderInvoicePerShipment());
        e.setOrderCreatedBy(c.getOrderCreatedBy());
        e.setOrderCreatedAt(c.getOrderCreatedAt());
        e.setOrderUpdatedBy(c.getOrderUpdatedBy());
        e.setOrderUpdatedAt(c.getOrderUpdatedAt());
        e.setOrderActive(c.getOrderActive());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setIsPropertyOrderOrderTypeIdRemoved(c.getIsPropertyOrderOrderTypeIdRemoved());
        e.setIsPropertyOrderOrderNameRemoved(c.getIsPropertyOrderOrderNameRemoved());
        e.setIsPropertyOrderExternalIdRemoved(c.getIsPropertyOrderExternalIdRemoved());
        e.setIsPropertyOrderSalesChannelEnumIdRemoved(c.getIsPropertyOrderSalesChannelEnumIdRemoved());
        e.setIsPropertyOrderOrderDateRemoved(c.getIsPropertyOrderOrderDateRemoved());
        e.setIsPropertyOrderPriorityRemoved(c.getIsPropertyOrderPriorityRemoved());
        e.setIsPropertyOrderEntryDateRemoved(c.getIsPropertyOrderEntryDateRemoved());
        e.setIsPropertyOrderPickSheetPrintedDateRemoved(c.getIsPropertyOrderPickSheetPrintedDateRemoved());
        e.setIsPropertyOrderStatusIdRemoved(c.getIsPropertyOrderStatusIdRemoved());
        e.setIsPropertyOrderCurrencyUomRemoved(c.getIsPropertyOrderCurrencyUomRemoved());
        e.setIsPropertyOrderSyncStatusIdRemoved(c.getIsPropertyOrderSyncStatusIdRemoved());
        e.setIsPropertyOrderBillingAccountIdRemoved(c.getIsPropertyOrderBillingAccountIdRemoved());
        e.setIsPropertyOrderOriginFacilityIdRemoved(c.getIsPropertyOrderOriginFacilityIdRemoved());
        e.setIsPropertyOrderWebSiteIdRemoved(c.getIsPropertyOrderWebSiteIdRemoved());
        e.setIsPropertyOrderProductStoreIdRemoved(c.getIsPropertyOrderProductStoreIdRemoved());
        e.setIsPropertyOrderTerminalIdRemoved(c.getIsPropertyOrderTerminalIdRemoved());
        e.setIsPropertyOrderTransactionIdRemoved(c.getIsPropertyOrderTransactionIdRemoved());
        e.setIsPropertyOrderAutoOrderShoppingListIdRemoved(c.getIsPropertyOrderAutoOrderShoppingListIdRemoved());
        e.setIsPropertyOrderNeedsInventoryIssuanceRemoved(c.getIsPropertyOrderNeedsInventoryIssuanceRemoved());
        e.setIsPropertyOrderIsRushOrderRemoved(c.getIsPropertyOrderIsRushOrderRemoved());
        e.setIsPropertyOrderInternalCodeRemoved(c.getIsPropertyOrderInternalCodeRemoved());
        e.setIsPropertyOrderRemainingSubTotalRemoved(c.getIsPropertyOrderRemainingSubTotalRemoved());
        e.setIsPropertyOrderGrandTotalRemoved(c.getIsPropertyOrderGrandTotalRemoved());
        e.setIsPropertyOrderInvoicePerShipmentRemoved(c.getIsPropertyOrderInvoicePerShipmentRemoved());
        e.setIsPropertyOrderCreatedByRemoved(c.getIsPropertyOrderCreatedByRemoved());
        e.setIsPropertyOrderCreatedAtRemoved(c.getIsPropertyOrderCreatedAtRemoved());
        e.setIsPropertyOrderUpdatedByRemoved(c.getIsPropertyOrderUpdatedByRemoved());
        e.setIsPropertyOrderUpdatedAtRemoved(c.getIsPropertyOrderUpdatedAtRemoved());
        e.setIsPropertyOrderActiveRemoved(c.getIsPropertyOrderActiveRemoved());
        ((AbstractOrderRoleMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderRoleMvoStateEvent map(OrderRoleMvoCommand.DeleteOrderRoleMvo c) {
        OrderRoleMvoEventId stateEventId = new OrderRoleMvoEventId(c.getOrderRoleId(), c.getOrderVersion());
        OrderRoleMvoStateEvent.OrderRoleMvoStateDeleted e = newOrderRoleMvoStateDeleted(stateEventId);
        ((AbstractOrderRoleMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected OrderRoleMvoStateEvent.OrderRoleMvoStateCreated newOrderRoleMvoStateCreated(Long version, String commandId, String requesterId) {
        OrderRoleMvoEventId stateEventId = new OrderRoleMvoEventId(this.state.getOrderRoleId(), version);
        OrderRoleMvoStateEvent.OrderRoleMvoStateCreated e = newOrderRoleMvoStateCreated(stateEventId);
        ((AbstractOrderRoleMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderRoleMvoStateEvent.OrderRoleMvoStateMergePatched newOrderRoleMvoStateMergePatched(Long version, String commandId, String requesterId) {
        OrderRoleMvoEventId stateEventId = new OrderRoleMvoEventId(this.state.getOrderRoleId(), version);
        OrderRoleMvoStateEvent.OrderRoleMvoStateMergePatched e = newOrderRoleMvoStateMergePatched(stateEventId);
        ((AbstractOrderRoleMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderRoleMvoStateEvent.OrderRoleMvoStateDeleted newOrderRoleMvoStateDeleted(Long version, String commandId, String requesterId) {
        OrderRoleMvoEventId stateEventId = new OrderRoleMvoEventId(this.state.getOrderRoleId(), version);
        OrderRoleMvoStateEvent.OrderRoleMvoStateDeleted e = newOrderRoleMvoStateDeleted(stateEventId);
        ((AbstractOrderRoleMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderRoleMvoStateEvent.OrderRoleMvoStateCreated newOrderRoleMvoStateCreated(OrderRoleMvoEventId stateEventId) {
        return new AbstractOrderRoleMvoStateEvent.SimpleOrderRoleMvoStateCreated(stateEventId);
    }

    protected OrderRoleMvoStateEvent.OrderRoleMvoStateMergePatched newOrderRoleMvoStateMergePatched(OrderRoleMvoEventId stateEventId) {
        return new AbstractOrderRoleMvoStateEvent.SimpleOrderRoleMvoStateMergePatched(stateEventId);
    }

    protected OrderRoleMvoStateEvent.OrderRoleMvoStateDeleted newOrderRoleMvoStateDeleted(OrderRoleMvoEventId stateEventId)
    {
        return new AbstractOrderRoleMvoStateEvent.SimpleOrderRoleMvoStateDeleted(stateEventId);
    }

    public static class SimpleOrderRoleMvoAggregate extends AbstractOrderRoleMvoAggregate
    {
        public SimpleOrderRoleMvoAggregate(OrderRoleMvoState state) {
            super(state);
        }

    }

}

