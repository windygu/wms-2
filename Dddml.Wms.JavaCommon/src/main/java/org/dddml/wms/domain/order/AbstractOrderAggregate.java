package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrderAggregate extends AbstractAggregate implements OrderAggregate
{
    private OrderState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractOrderAggregate(OrderState state)
    {
        this.state = state;
    }

    public OrderState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(OrderCommand.CreateOrder c)
    {
        if (c.getVersion() == null) { c.setVersion(OrderState.VERSION_NULL); }
        OrderStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(OrderCommand.MergePatchOrder c)
    {
        OrderStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        OrderCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected OrderStateEvent map(OrderCommand.CreateOrder c) {
        OrderStateEventId stateEventId = new OrderStateEventId(c.getOrderId(), c.getVersion());
        OrderStateEvent.OrderStateCreated e = newOrderStateCreated(stateEventId);
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
        ((AbstractOrderStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (OrderItemCommand.CreateOrderItem innerCommand : c.getOrderItems())
        {
            throwOnInconsistentCommands(c, innerCommand);
            OrderItemStateEvent.OrderItemStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addOrderItemEvent(innerEvent);
        }

        return e;
    }

    protected OrderStateEvent map(OrderCommand.MergePatchOrder c) {
        OrderStateEventId stateEventId = new OrderStateEventId(c.getOrderId(), c.getVersion());
        OrderStateEvent.OrderStateMergePatched e = newOrderStateMergePatched(stateEventId);
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
        ((AbstractOrderStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (OrderItemCommand innerCommand : c.getOrderItemCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            OrderItemStateEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addOrderItemEvent(innerEvent);
        }

        return e;
    }


    protected OrderItemStateEvent map(OrderItemCommand c, OrderCommand outerCommand, long version, OrderState outerState)
    {
        OrderItemCommand.CreateOrderItem create = (c.getCommandType().equals(CommandType.CREATE)) ? ((OrderItemCommand.CreateOrderItem)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        OrderItemCommand.MergePatchOrderItem merge = (c.getCommandType().equals(CommandType.MERGE_PATCH)) ? ((OrderItemCommand.MergePatchOrderItem)c) : null;
        if(merge != null)
        {
            return mapMergePatch(merge, outerCommand, version, outerState);
        }

        throw new UnsupportedOperationException();
    }

    protected OrderItemStateEvent.OrderItemStateCreated mapCreate(OrderItemCommand.CreateOrderItem c, OrderCommand outerCommand, Long version, OrderState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderItemStateEventId stateEventId = new OrderItemStateEventId(c.getOrderId(), c.getOrderItemSeqId(), version);
        OrderItemStateEvent.OrderItemStateCreated e = newOrderItemStateCreated(stateEventId);
        OrderItemState s = outerState.getOrderItems().get(c.getOrderItemSeqId());

        e.setProductId(c.getProductId());
        e.setExternalProductId(c.getExternalProductId());
        e.setQuantity(c.getQuantity());
        e.setCancelQuantity(c.getCancelQuantity());
        e.setSelectedAmount(c.getSelectedAmount());
        e.setExternalId(c.getExternalId());
        e.setOrderItemTypeId(c.getOrderItemTypeId());
        e.setOrderItemGroupSeqId(c.getOrderItemGroupSeqId());
        e.setIsItemGroupPrimary(c.getIsItemGroupPrimary());
        e.setFromInventoryItemId(c.getFromInventoryItemId());
        e.setIsPromo(c.getIsPromo());
        e.setQuoteId(c.getQuoteId());
        e.setQuoteItemSeqId(c.getQuoteItemSeqId());
        e.setShoppingListId(c.getShoppingListId());
        e.setShoppingListItemSeqId(c.getShoppingListItemSeqId());
        e.setUnitPrice(c.getUnitPrice());
        e.setUnitListPrice(c.getUnitListPrice());
        e.setUnitAverageCost(c.getUnitAverageCost());
        e.setUnitRecurringPrice(c.getUnitRecurringPrice());
        e.setIsModifiedPrice(c.getIsModifiedPrice());
        e.setRecurringFreqUomId(c.getRecurringFreqUomId());
        e.setItemDescription(c.getItemDescription());
        e.setComments(c.getComments());
        e.setCorrespondingPoId(c.getCorrespondingPoId());
        e.setStatusId(c.getStatusId());
        e.setSyncStatusId(c.getSyncStatusId());
        e.setEstimatedShipDate(c.getEstimatedShipDate());
        e.setEstimatedDeliveryDate(c.getEstimatedDeliveryDate());
        e.setAutoCancelDate(c.getAutoCancelDate());
        e.setDontCancelSetDate(c.getDontCancelSetDate());
        e.setDontCancelSetBy(c.getDontCancelSetBy());
        e.setShipBeforeDate(c.getShipBeforeDate());
        e.setShipAfterDate(c.getShipAfterDate());
        e.setCancelBackOrderDate(c.getCancelBackOrderDate());
        e.setOverrideGlAccountId(c.getOverrideGlAccountId());
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected OrderItemStateEvent.OrderItemStateMergePatched mapMergePatch(OrderItemCommand.MergePatchOrderItem c, OrderCommand outerCommand, Long version, OrderState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderItemStateEventId stateEventId = new OrderItemStateEventId(c.getOrderId(), c.getOrderItemSeqId(), version);
        OrderItemStateEvent.OrderItemStateMergePatched e = newOrderItemStateMergePatched(stateEventId);
        OrderItemState s = outerState.getOrderItems().get(c.getOrderItemSeqId());

        e.setProductId(c.getProductId());
        e.setExternalProductId(c.getExternalProductId());
        e.setQuantity(c.getQuantity());
        e.setCancelQuantity(c.getCancelQuantity());
        e.setSelectedAmount(c.getSelectedAmount());
        e.setExternalId(c.getExternalId());
        e.setOrderItemTypeId(c.getOrderItemTypeId());
        e.setOrderItemGroupSeqId(c.getOrderItemGroupSeqId());
        e.setIsItemGroupPrimary(c.getIsItemGroupPrimary());
        e.setFromInventoryItemId(c.getFromInventoryItemId());
        e.setIsPromo(c.getIsPromo());
        e.setQuoteId(c.getQuoteId());
        e.setQuoteItemSeqId(c.getQuoteItemSeqId());
        e.setShoppingListId(c.getShoppingListId());
        e.setShoppingListItemSeqId(c.getShoppingListItemSeqId());
        e.setUnitPrice(c.getUnitPrice());
        e.setUnitListPrice(c.getUnitListPrice());
        e.setUnitAverageCost(c.getUnitAverageCost());
        e.setUnitRecurringPrice(c.getUnitRecurringPrice());
        e.setIsModifiedPrice(c.getIsModifiedPrice());
        e.setRecurringFreqUomId(c.getRecurringFreqUomId());
        e.setItemDescription(c.getItemDescription());
        e.setComments(c.getComments());
        e.setCorrespondingPoId(c.getCorrespondingPoId());
        e.setStatusId(c.getStatusId());
        e.setSyncStatusId(c.getSyncStatusId());
        e.setEstimatedShipDate(c.getEstimatedShipDate());
        e.setEstimatedDeliveryDate(c.getEstimatedDeliveryDate());
        e.setAutoCancelDate(c.getAutoCancelDate());
        e.setDontCancelSetDate(c.getDontCancelSetDate());
        e.setDontCancelSetBy(c.getDontCancelSetBy());
        e.setShipBeforeDate(c.getShipBeforeDate());
        e.setShipAfterDate(c.getShipAfterDate());
        e.setCancelBackOrderDate(c.getCancelBackOrderDate());
        e.setOverrideGlAccountId(c.getOverrideGlAccountId());
        e.setActive(c.getActive());
        e.setIsPropertyProductIdRemoved(c.getIsPropertyProductIdRemoved());
        e.setIsPropertyExternalProductIdRemoved(c.getIsPropertyExternalProductIdRemoved());
        e.setIsPropertyQuantityRemoved(c.getIsPropertyQuantityRemoved());
        e.setIsPropertyCancelQuantityRemoved(c.getIsPropertyCancelQuantityRemoved());
        e.setIsPropertySelectedAmountRemoved(c.getIsPropertySelectedAmountRemoved());
        e.setIsPropertyExternalIdRemoved(c.getIsPropertyExternalIdRemoved());
        e.setIsPropertyOrderItemTypeIdRemoved(c.getIsPropertyOrderItemTypeIdRemoved());
        e.setIsPropertyOrderItemGroupSeqIdRemoved(c.getIsPropertyOrderItemGroupSeqIdRemoved());
        e.setIsPropertyIsItemGroupPrimaryRemoved(c.getIsPropertyIsItemGroupPrimaryRemoved());
        e.setIsPropertyFromInventoryItemIdRemoved(c.getIsPropertyFromInventoryItemIdRemoved());
        e.setIsPropertyIsPromoRemoved(c.getIsPropertyIsPromoRemoved());
        e.setIsPropertyQuoteIdRemoved(c.getIsPropertyQuoteIdRemoved());
        e.setIsPropertyQuoteItemSeqIdRemoved(c.getIsPropertyQuoteItemSeqIdRemoved());
        e.setIsPropertyShoppingListIdRemoved(c.getIsPropertyShoppingListIdRemoved());
        e.setIsPropertyShoppingListItemSeqIdRemoved(c.getIsPropertyShoppingListItemSeqIdRemoved());
        e.setIsPropertyUnitPriceRemoved(c.getIsPropertyUnitPriceRemoved());
        e.setIsPropertyUnitListPriceRemoved(c.getIsPropertyUnitListPriceRemoved());
        e.setIsPropertyUnitAverageCostRemoved(c.getIsPropertyUnitAverageCostRemoved());
        e.setIsPropertyUnitRecurringPriceRemoved(c.getIsPropertyUnitRecurringPriceRemoved());
        e.setIsPropertyIsModifiedPriceRemoved(c.getIsPropertyIsModifiedPriceRemoved());
        e.setIsPropertyRecurringFreqUomIdRemoved(c.getIsPropertyRecurringFreqUomIdRemoved());
        e.setIsPropertyItemDescriptionRemoved(c.getIsPropertyItemDescriptionRemoved());
        e.setIsPropertyCommentsRemoved(c.getIsPropertyCommentsRemoved());
        e.setIsPropertyCorrespondingPoIdRemoved(c.getIsPropertyCorrespondingPoIdRemoved());
        e.setIsPropertyStatusIdRemoved(c.getIsPropertyStatusIdRemoved());
        e.setIsPropertySyncStatusIdRemoved(c.getIsPropertySyncStatusIdRemoved());
        e.setIsPropertyEstimatedShipDateRemoved(c.getIsPropertyEstimatedShipDateRemoved());
        e.setIsPropertyEstimatedDeliveryDateRemoved(c.getIsPropertyEstimatedDeliveryDateRemoved());
        e.setIsPropertyAutoCancelDateRemoved(c.getIsPropertyAutoCancelDateRemoved());
        e.setIsPropertyDontCancelSetDateRemoved(c.getIsPropertyDontCancelSetDateRemoved());
        e.setIsPropertyDontCancelSetByRemoved(c.getIsPropertyDontCancelSetByRemoved());
        e.setIsPropertyShipBeforeDateRemoved(c.getIsPropertyShipBeforeDateRemoved());
        e.setIsPropertyShipAfterDateRemoved(c.getIsPropertyShipAfterDateRemoved());
        e.setIsPropertyCancelBackOrderDateRemoved(c.getIsPropertyCancelBackOrderDateRemoved());
        e.setIsPropertyOverrideGlAccountIdRemoved(c.getIsPropertyOverrideGlAccountIdRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected void throwOnInconsistentCommands(OrderCommand command, OrderItemCommand innerCommand)
    {
        AbstractOrderCommand properties = command instanceof AbstractOrderCommand ? (AbstractOrderCommand) command : null;
        AbstractOrderItemCommand innerProperties = innerCommand instanceof AbstractOrderItemCommand ? (AbstractOrderItemCommand) innerCommand : null;
        if (properties == null || innerProperties == null) { return; }
        String outerOrderIdName = "OrderId";
        String outerOrderIdValue = properties.getOrderId();
        String innerOrderIdName = "OrderId";
        String innerOrderIdValue = innerProperties.getOrderId();
        if (innerOrderIdValue == null) {
            innerProperties.setOrderId(outerOrderIdValue);
        }
        else if (innerOrderIdValue != outerOrderIdValue 
            && (innerOrderIdValue == null || innerOrderIdValue != null && !innerOrderIdValue.equals(outerOrderIdValue))) 
        {
            throw DomainError.named("inconsistentId", "Outer %1$s %2$s NOT equals inner %3$s %4$s", outerOrderIdName, outerOrderIdValue, innerOrderIdName, innerOrderIdValue);
        }
    }// END throwOnInconsistentCommands /////////////////////


    ////////////////////////

    protected OrderStateEvent.OrderStateCreated newOrderStateCreated(String commandId, String requesterId) {
        OrderStateEventId stateEventId = new OrderStateEventId(this.state.getOrderId(), this.state.getVersion());
        OrderStateEvent.OrderStateCreated e = newOrderStateCreated(stateEventId);
        ((AbstractOrderStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderStateEvent.OrderStateMergePatched newOrderStateMergePatched(String commandId, String requesterId) {
        OrderStateEventId stateEventId = new OrderStateEventId(this.state.getOrderId(), this.state.getVersion());
        OrderStateEvent.OrderStateMergePatched e = newOrderStateMergePatched(stateEventId);
        ((AbstractOrderStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderStateEvent.OrderStateCreated newOrderStateCreated(OrderStateEventId stateEventId) {
        return new AbstractOrderStateEvent.SimpleOrderStateCreated(stateEventId);
    }

    protected OrderStateEvent.OrderStateMergePatched newOrderStateMergePatched(OrderStateEventId stateEventId) {
        return new AbstractOrderStateEvent.SimpleOrderStateMergePatched(stateEventId);
    }

    protected OrderItemStateEvent.OrderItemStateCreated newOrderItemStateCreated(OrderItemStateEventId stateEventId) {
        return new AbstractOrderItemStateEvent.SimpleOrderItemStateCreated(stateEventId);
    }

    protected OrderItemStateEvent.OrderItemStateMergePatched newOrderItemStateMergePatched(OrderItemStateEventId stateEventId) {
        return new AbstractOrderItemStateEvent.SimpleOrderItemStateMergePatched(stateEventId);
    }


    public static class SimpleOrderAggregate extends AbstractOrderAggregate
    {
        public SimpleOrderAggregate(OrderState state) {
            super(state);
        }

    }

}

