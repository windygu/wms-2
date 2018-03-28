package org.dddml.wms.domain.orderitemshipgroupassociationmvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrderItemShipGroupAssociationMvoAggregate extends AbstractAggregate implements OrderItemShipGroupAssociationMvoAggregate
{
    private OrderItemShipGroupAssociationMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractOrderItemShipGroupAssociationMvoAggregate(OrderItemShipGroupAssociationMvoState state)
    {
        this.state = state;
    }

    public OrderItemShipGroupAssociationMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(OrderItemShipGroupAssociationMvoCommand.CreateOrderItemShipGroupAssociationMvo c)
    {
        if (c.getOrderVersion() == null) { c.setOrderVersion(OrderItemShipGroupAssociationMvoState.VERSION_NULL); }
        OrderItemShipGroupAssociationMvoStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(OrderItemShipGroupAssociationMvoCommand.MergePatchOrderItemShipGroupAssociationMvo c)
    {
        OrderItemShipGroupAssociationMvoStateEvent e = map(c);
        apply(e);
    }

    public void delete(OrderItemShipGroupAssociationMvoCommand.DeleteOrderItemShipGroupAssociationMvo c)
    {
        OrderItemShipGroupAssociationMvoStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        OrderItemShipGroupAssociationMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected OrderItemShipGroupAssociationMvoStateEvent map(OrderItemShipGroupAssociationMvoCommand.CreateOrderItemShipGroupAssociationMvo c) {
        OrderItemShipGroupAssociationMvoEventId stateEventId = new OrderItemShipGroupAssociationMvoEventId(c.getOrderItemShipGroupAssociationId(), c.getOrderVersion());
        OrderItemShipGroupAssociationMvoStateEvent.OrderItemShipGroupAssociationMvoStateCreated e = newOrderItemShipGroupAssociationMvoStateCreated(stateEventId);
        e.setQuantity(c.getQuantity());
        e.setCancelQuantity(c.getCancelQuantity());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setOrderShipGroupShipmentMethodTypeId(c.getOrderShipGroupShipmentMethodTypeId());
        e.setOrderShipGroupSupplierPartyId(c.getOrderShipGroupSupplierPartyId());
        e.setOrderShipGroupVendorPartyId(c.getOrderShipGroupVendorPartyId());
        e.setOrderShipGroupCarrierPartyId(c.getOrderShipGroupCarrierPartyId());
        e.setOrderShipGroupCarrierRoleTypeId(c.getOrderShipGroupCarrierRoleTypeId());
        e.setOrderShipGroupFacilityId(c.getOrderShipGroupFacilityId());
        e.setOrderShipGroupContactMechId(c.getOrderShipGroupContactMechId());
        e.setOrderShipGroupTelecomContactMechId(c.getOrderShipGroupTelecomContactMechId());
        e.setOrderShipGroupTrackingNumber(c.getOrderShipGroupTrackingNumber());
        e.setOrderShipGroupShippingInstructions(c.getOrderShipGroupShippingInstructions());
        e.setOrderShipGroupMaySplit(c.getOrderShipGroupMaySplit());
        e.setOrderShipGroupGiftMessage(c.getOrderShipGroupGiftMessage());
        e.setOrderShipGroupIsGift(c.getOrderShipGroupIsGift());
        e.setOrderShipGroupShipAfterDate(c.getOrderShipGroupShipAfterDate());
        e.setOrderShipGroupShipByDate(c.getOrderShipGroupShipByDate());
        e.setOrderShipGroupEstimatedShipDate(c.getOrderShipGroupEstimatedShipDate());
        e.setOrderShipGroupEstimatedDeliveryDate(c.getOrderShipGroupEstimatedDeliveryDate());
        e.setOrderShipGroupPickwaveId(c.getOrderShipGroupPickwaveId());
        e.setOrderShipGroupVersion(c.getOrderShipGroupVersion());
        e.setOrderShipGroupCreatedBy(c.getOrderShipGroupCreatedBy());
        e.setOrderShipGroupCreatedAt(c.getOrderShipGroupCreatedAt());
        e.setOrderShipGroupUpdatedBy(c.getOrderShipGroupUpdatedBy());
        e.setOrderShipGroupUpdatedAt(c.getOrderShipGroupUpdatedAt());
        e.setOrderShipGroupActive(c.getOrderShipGroupActive());
        e.setOrderShipGroupDeleted(c.getOrderShipGroupDeleted());
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
        ((AbstractOrderItemShipGroupAssociationMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderItemShipGroupAssociationMvoStateEvent map(OrderItemShipGroupAssociationMvoCommand.MergePatchOrderItemShipGroupAssociationMvo c) {
        OrderItemShipGroupAssociationMvoEventId stateEventId = new OrderItemShipGroupAssociationMvoEventId(c.getOrderItemShipGroupAssociationId(), c.getOrderVersion());
        OrderItemShipGroupAssociationMvoStateEvent.OrderItemShipGroupAssociationMvoStateMergePatched e = newOrderItemShipGroupAssociationMvoStateMergePatched(stateEventId);
        e.setQuantity(c.getQuantity());
        e.setCancelQuantity(c.getCancelQuantity());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setOrderShipGroupShipmentMethodTypeId(c.getOrderShipGroupShipmentMethodTypeId());
        e.setOrderShipGroupSupplierPartyId(c.getOrderShipGroupSupplierPartyId());
        e.setOrderShipGroupVendorPartyId(c.getOrderShipGroupVendorPartyId());
        e.setOrderShipGroupCarrierPartyId(c.getOrderShipGroupCarrierPartyId());
        e.setOrderShipGroupCarrierRoleTypeId(c.getOrderShipGroupCarrierRoleTypeId());
        e.setOrderShipGroupFacilityId(c.getOrderShipGroupFacilityId());
        e.setOrderShipGroupContactMechId(c.getOrderShipGroupContactMechId());
        e.setOrderShipGroupTelecomContactMechId(c.getOrderShipGroupTelecomContactMechId());
        e.setOrderShipGroupTrackingNumber(c.getOrderShipGroupTrackingNumber());
        e.setOrderShipGroupShippingInstructions(c.getOrderShipGroupShippingInstructions());
        e.setOrderShipGroupMaySplit(c.getOrderShipGroupMaySplit());
        e.setOrderShipGroupGiftMessage(c.getOrderShipGroupGiftMessage());
        e.setOrderShipGroupIsGift(c.getOrderShipGroupIsGift());
        e.setOrderShipGroupShipAfterDate(c.getOrderShipGroupShipAfterDate());
        e.setOrderShipGroupShipByDate(c.getOrderShipGroupShipByDate());
        e.setOrderShipGroupEstimatedShipDate(c.getOrderShipGroupEstimatedShipDate());
        e.setOrderShipGroupEstimatedDeliveryDate(c.getOrderShipGroupEstimatedDeliveryDate());
        e.setOrderShipGroupPickwaveId(c.getOrderShipGroupPickwaveId());
        e.setOrderShipGroupVersion(c.getOrderShipGroupVersion());
        e.setOrderShipGroupCreatedBy(c.getOrderShipGroupCreatedBy());
        e.setOrderShipGroupCreatedAt(c.getOrderShipGroupCreatedAt());
        e.setOrderShipGroupUpdatedBy(c.getOrderShipGroupUpdatedBy());
        e.setOrderShipGroupUpdatedAt(c.getOrderShipGroupUpdatedAt());
        e.setOrderShipGroupActive(c.getOrderShipGroupActive());
        e.setOrderShipGroupDeleted(c.getOrderShipGroupDeleted());
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
        e.setIsPropertyQuantityRemoved(c.getIsPropertyQuantityRemoved());
        e.setIsPropertyCancelQuantityRemoved(c.getIsPropertyCancelQuantityRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setIsPropertyOrderShipGroupShipmentMethodTypeIdRemoved(c.getIsPropertyOrderShipGroupShipmentMethodTypeIdRemoved());
        e.setIsPropertyOrderShipGroupSupplierPartyIdRemoved(c.getIsPropertyOrderShipGroupSupplierPartyIdRemoved());
        e.setIsPropertyOrderShipGroupVendorPartyIdRemoved(c.getIsPropertyOrderShipGroupVendorPartyIdRemoved());
        e.setIsPropertyOrderShipGroupCarrierPartyIdRemoved(c.getIsPropertyOrderShipGroupCarrierPartyIdRemoved());
        e.setIsPropertyOrderShipGroupCarrierRoleTypeIdRemoved(c.getIsPropertyOrderShipGroupCarrierRoleTypeIdRemoved());
        e.setIsPropertyOrderShipGroupFacilityIdRemoved(c.getIsPropertyOrderShipGroupFacilityIdRemoved());
        e.setIsPropertyOrderShipGroupContactMechIdRemoved(c.getIsPropertyOrderShipGroupContactMechIdRemoved());
        e.setIsPropertyOrderShipGroupTelecomContactMechIdRemoved(c.getIsPropertyOrderShipGroupTelecomContactMechIdRemoved());
        e.setIsPropertyOrderShipGroupTrackingNumberRemoved(c.getIsPropertyOrderShipGroupTrackingNumberRemoved());
        e.setIsPropertyOrderShipGroupShippingInstructionsRemoved(c.getIsPropertyOrderShipGroupShippingInstructionsRemoved());
        e.setIsPropertyOrderShipGroupMaySplitRemoved(c.getIsPropertyOrderShipGroupMaySplitRemoved());
        e.setIsPropertyOrderShipGroupGiftMessageRemoved(c.getIsPropertyOrderShipGroupGiftMessageRemoved());
        e.setIsPropertyOrderShipGroupIsGiftRemoved(c.getIsPropertyOrderShipGroupIsGiftRemoved());
        e.setIsPropertyOrderShipGroupShipAfterDateRemoved(c.getIsPropertyOrderShipGroupShipAfterDateRemoved());
        e.setIsPropertyOrderShipGroupShipByDateRemoved(c.getIsPropertyOrderShipGroupShipByDateRemoved());
        e.setIsPropertyOrderShipGroupEstimatedShipDateRemoved(c.getIsPropertyOrderShipGroupEstimatedShipDateRemoved());
        e.setIsPropertyOrderShipGroupEstimatedDeliveryDateRemoved(c.getIsPropertyOrderShipGroupEstimatedDeliveryDateRemoved());
        e.setIsPropertyOrderShipGroupPickwaveIdRemoved(c.getIsPropertyOrderShipGroupPickwaveIdRemoved());
        e.setIsPropertyOrderShipGroupVersionRemoved(c.getIsPropertyOrderShipGroupVersionRemoved());
        e.setIsPropertyOrderShipGroupCreatedByRemoved(c.getIsPropertyOrderShipGroupCreatedByRemoved());
        e.setIsPropertyOrderShipGroupCreatedAtRemoved(c.getIsPropertyOrderShipGroupCreatedAtRemoved());
        e.setIsPropertyOrderShipGroupUpdatedByRemoved(c.getIsPropertyOrderShipGroupUpdatedByRemoved());
        e.setIsPropertyOrderShipGroupUpdatedAtRemoved(c.getIsPropertyOrderShipGroupUpdatedAtRemoved());
        e.setIsPropertyOrderShipGroupActiveRemoved(c.getIsPropertyOrderShipGroupActiveRemoved());
        e.setIsPropertyOrderShipGroupDeletedRemoved(c.getIsPropertyOrderShipGroupDeletedRemoved());
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
        ((AbstractOrderItemShipGroupAssociationMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderItemShipGroupAssociationMvoStateEvent map(OrderItemShipGroupAssociationMvoCommand.DeleteOrderItemShipGroupAssociationMvo c) {
        OrderItemShipGroupAssociationMvoEventId stateEventId = new OrderItemShipGroupAssociationMvoEventId(c.getOrderItemShipGroupAssociationId(), c.getOrderVersion());
        OrderItemShipGroupAssociationMvoStateEvent.OrderItemShipGroupAssociationMvoStateDeleted e = newOrderItemShipGroupAssociationMvoStateDeleted(stateEventId);
        ((AbstractOrderItemShipGroupAssociationMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected OrderItemShipGroupAssociationMvoStateEvent.OrderItemShipGroupAssociationMvoStateCreated newOrderItemShipGroupAssociationMvoStateCreated(Long version, String commandId, String requesterId) {
        OrderItemShipGroupAssociationMvoEventId stateEventId = new OrderItemShipGroupAssociationMvoEventId(this.state.getOrderItemShipGroupAssociationId(), version);
        OrderItemShipGroupAssociationMvoStateEvent.OrderItemShipGroupAssociationMvoStateCreated e = newOrderItemShipGroupAssociationMvoStateCreated(stateEventId);
        ((AbstractOrderItemShipGroupAssociationMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderItemShipGroupAssociationMvoStateEvent.OrderItemShipGroupAssociationMvoStateMergePatched newOrderItemShipGroupAssociationMvoStateMergePatched(Long version, String commandId, String requesterId) {
        OrderItemShipGroupAssociationMvoEventId stateEventId = new OrderItemShipGroupAssociationMvoEventId(this.state.getOrderItemShipGroupAssociationId(), version);
        OrderItemShipGroupAssociationMvoStateEvent.OrderItemShipGroupAssociationMvoStateMergePatched e = newOrderItemShipGroupAssociationMvoStateMergePatched(stateEventId);
        ((AbstractOrderItemShipGroupAssociationMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderItemShipGroupAssociationMvoStateEvent.OrderItemShipGroupAssociationMvoStateDeleted newOrderItemShipGroupAssociationMvoStateDeleted(Long version, String commandId, String requesterId) {
        OrderItemShipGroupAssociationMvoEventId stateEventId = new OrderItemShipGroupAssociationMvoEventId(this.state.getOrderItemShipGroupAssociationId(), version);
        OrderItemShipGroupAssociationMvoStateEvent.OrderItemShipGroupAssociationMvoStateDeleted e = newOrderItemShipGroupAssociationMvoStateDeleted(stateEventId);
        ((AbstractOrderItemShipGroupAssociationMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderItemShipGroupAssociationMvoStateEvent.OrderItemShipGroupAssociationMvoStateCreated newOrderItemShipGroupAssociationMvoStateCreated(OrderItemShipGroupAssociationMvoEventId stateEventId) {
        return new AbstractOrderItemShipGroupAssociationMvoStateEvent.SimpleOrderItemShipGroupAssociationMvoStateCreated(stateEventId);
    }

    protected OrderItemShipGroupAssociationMvoStateEvent.OrderItemShipGroupAssociationMvoStateMergePatched newOrderItemShipGroupAssociationMvoStateMergePatched(OrderItemShipGroupAssociationMvoEventId stateEventId) {
        return new AbstractOrderItemShipGroupAssociationMvoStateEvent.SimpleOrderItemShipGroupAssociationMvoStateMergePatched(stateEventId);
    }

    protected OrderItemShipGroupAssociationMvoStateEvent.OrderItemShipGroupAssociationMvoStateDeleted newOrderItemShipGroupAssociationMvoStateDeleted(OrderItemShipGroupAssociationMvoEventId stateEventId)
    {
        return new AbstractOrderItemShipGroupAssociationMvoStateEvent.SimpleOrderItemShipGroupAssociationMvoStateDeleted(stateEventId);
    }

    public static class SimpleOrderItemShipGroupAssociationMvoAggregate extends AbstractOrderItemShipGroupAssociationMvoAggregate
    {
        public SimpleOrderItemShipGroupAssociationMvoAggregate(OrderItemShipGroupAssociationMvoState state) {
            super(state);
        }

    }

}

