package org.dddml.wms.domain.orderitemmvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrderItemMvoAggregate extends AbstractAggregate implements OrderItemMvoAggregate
{
    private OrderItemMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractOrderItemMvoAggregate(OrderItemMvoState state)
    {
        this.state = state;
    }

    public OrderItemMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(OrderItemMvoCommand.CreateOrderItemMvo c)
    {
        if (c.getOrderVersion() == null) { c.setOrderVersion(OrderItemMvoState.VERSION_NULL); }
        OrderItemMvoEvent e = map(c);
        apply(e);
    }

    public void mergePatch(OrderItemMvoCommand.MergePatchOrderItemMvo c)
    {
        OrderItemMvoEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        OrderItemMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected OrderItemMvoEvent map(OrderItemMvoCommand.CreateOrderItemMvo c) {
        OrderItemMvoEventId stateEventId = new OrderItemMvoEventId(c.getOrderItemId(), c.getOrderVersion());
        OrderItemMvoEvent.OrderItemMvoStateCreated e = newOrderItemMvoStateCreated(stateEventId);
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
        ((AbstractOrderItemMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderItemMvoEvent map(OrderItemMvoCommand.MergePatchOrderItemMvo c) {
        OrderItemMvoEventId stateEventId = new OrderItemMvoEventId(c.getOrderItemId(), c.getOrderVersion());
        OrderItemMvoEvent.OrderItemMvoStateMergePatched e = newOrderItemMvoStateMergePatched(stateEventId);
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
        ((AbstractOrderItemMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected OrderItemMvoEvent.OrderItemMvoStateCreated newOrderItemMvoStateCreated(Long version, String commandId, String requesterId) {
        OrderItemMvoEventId stateEventId = new OrderItemMvoEventId(this.state.getOrderItemId(), version);
        OrderItemMvoEvent.OrderItemMvoStateCreated e = newOrderItemMvoStateCreated(stateEventId);
        ((AbstractOrderItemMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderItemMvoEvent.OrderItemMvoStateMergePatched newOrderItemMvoStateMergePatched(Long version, String commandId, String requesterId) {
        OrderItemMvoEventId stateEventId = new OrderItemMvoEventId(this.state.getOrderItemId(), version);
        OrderItemMvoEvent.OrderItemMvoStateMergePatched e = newOrderItemMvoStateMergePatched(stateEventId);
        ((AbstractOrderItemMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderItemMvoEvent.OrderItemMvoStateCreated newOrderItemMvoStateCreated(OrderItemMvoEventId stateEventId) {
        return new AbstractOrderItemMvoEvent.SimpleOrderItemMvoStateCreated(stateEventId);
    }

    protected OrderItemMvoEvent.OrderItemMvoStateMergePatched newOrderItemMvoStateMergePatched(OrderItemMvoEventId stateEventId) {
        return new AbstractOrderItemMvoEvent.SimpleOrderItemMvoStateMergePatched(stateEventId);
    }

    public static class SimpleOrderItemMvoAggregate extends AbstractOrderItemMvoAggregate
    {
        public SimpleOrderItemMvoAggregate(OrderItemMvoState state) {
            super(state);
        }

    }

}

