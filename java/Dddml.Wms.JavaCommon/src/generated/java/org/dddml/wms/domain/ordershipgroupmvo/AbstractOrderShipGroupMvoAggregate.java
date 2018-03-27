package org.dddml.wms.domain.ordershipgroupmvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractOrderShipGroupMvoAggregate extends AbstractAggregate implements OrderShipGroupMvoAggregate
{
    private OrderShipGroupMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractOrderShipGroupMvoAggregate(OrderShipGroupMvoState state)
    {
        this.state = state;
    }

    public OrderShipGroupMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(OrderShipGroupMvoCommand.CreateOrderShipGroupMvo c)
    {
        if (c.getOrderVersion() == null) { c.setOrderVersion(OrderShipGroupMvoState.VERSION_NULL); }
        OrderShipGroupMvoStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(OrderShipGroupMvoCommand.MergePatchOrderShipGroupMvo c)
    {
        OrderShipGroupMvoStateEvent e = map(c);
        apply(e);
    }

    public void delete(OrderShipGroupMvoCommand.DeleteOrderShipGroupMvo c)
    {
        OrderShipGroupMvoStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        OrderShipGroupMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected OrderShipGroupMvoStateEvent map(OrderShipGroupMvoCommand.CreateOrderShipGroupMvo c) {
        OrderShipGroupMvoEventId stateEventId = new OrderShipGroupMvoEventId(c.getOrderShipGroupId(), c.getOrderVersion());
        OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateCreated e = newOrderShipGroupMvoStateCreated(stateEventId);
        e.setShipmentMethodTypeId(c.getShipmentMethodTypeId());
        e.setSupplierPartyId(c.getSupplierPartyId());
        e.setVendorPartyId(c.getVendorPartyId());
        e.setCarrierPartyId(c.getCarrierPartyId());
        e.setCarrierRoleTypeId(c.getCarrierRoleTypeId());
        e.setFacilityId(c.getFacilityId());
        e.setContactMechId(c.getContactMechId());
        e.setTelecomContactMechId(c.getTelecomContactMechId());
        e.setTrackingNumber(c.getTrackingNumber());
        e.setShippingInstructions(c.getShippingInstructions());
        e.setMaySplit(c.getMaySplit());
        e.setGiftMessage(c.getGiftMessage());
        e.setIsGift(c.getIsGift());
        e.setShipAfterDate(c.getShipAfterDate());
        e.setShipByDate(c.getShipByDate());
        e.setEstimatedShipDate(c.getEstimatedShipDate());
        e.setEstimatedDeliveryDate(c.getEstimatedDeliveryDate());
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
        ((AbstractOrderShipGroupMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderShipGroupMvoStateEvent map(OrderShipGroupMvoCommand.MergePatchOrderShipGroupMvo c) {
        OrderShipGroupMvoEventId stateEventId = new OrderShipGroupMvoEventId(c.getOrderShipGroupId(), c.getOrderVersion());
        OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateMergePatched e = newOrderShipGroupMvoStateMergePatched(stateEventId);
        e.setShipmentMethodTypeId(c.getShipmentMethodTypeId());
        e.setSupplierPartyId(c.getSupplierPartyId());
        e.setVendorPartyId(c.getVendorPartyId());
        e.setCarrierPartyId(c.getCarrierPartyId());
        e.setCarrierRoleTypeId(c.getCarrierRoleTypeId());
        e.setFacilityId(c.getFacilityId());
        e.setContactMechId(c.getContactMechId());
        e.setTelecomContactMechId(c.getTelecomContactMechId());
        e.setTrackingNumber(c.getTrackingNumber());
        e.setShippingInstructions(c.getShippingInstructions());
        e.setMaySplit(c.getMaySplit());
        e.setGiftMessage(c.getGiftMessage());
        e.setIsGift(c.getIsGift());
        e.setShipAfterDate(c.getShipAfterDate());
        e.setShipByDate(c.getShipByDate());
        e.setEstimatedShipDate(c.getEstimatedShipDate());
        e.setEstimatedDeliveryDate(c.getEstimatedDeliveryDate());
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
        e.setIsPropertyShipmentMethodTypeIdRemoved(c.getIsPropertyShipmentMethodTypeIdRemoved());
        e.setIsPropertySupplierPartyIdRemoved(c.getIsPropertySupplierPartyIdRemoved());
        e.setIsPropertyVendorPartyIdRemoved(c.getIsPropertyVendorPartyIdRemoved());
        e.setIsPropertyCarrierPartyIdRemoved(c.getIsPropertyCarrierPartyIdRemoved());
        e.setIsPropertyCarrierRoleTypeIdRemoved(c.getIsPropertyCarrierRoleTypeIdRemoved());
        e.setIsPropertyFacilityIdRemoved(c.getIsPropertyFacilityIdRemoved());
        e.setIsPropertyContactMechIdRemoved(c.getIsPropertyContactMechIdRemoved());
        e.setIsPropertyTelecomContactMechIdRemoved(c.getIsPropertyTelecomContactMechIdRemoved());
        e.setIsPropertyTrackingNumberRemoved(c.getIsPropertyTrackingNumberRemoved());
        e.setIsPropertyShippingInstructionsRemoved(c.getIsPropertyShippingInstructionsRemoved());
        e.setIsPropertyMaySplitRemoved(c.getIsPropertyMaySplitRemoved());
        e.setIsPropertyGiftMessageRemoved(c.getIsPropertyGiftMessageRemoved());
        e.setIsPropertyIsGiftRemoved(c.getIsPropertyIsGiftRemoved());
        e.setIsPropertyShipAfterDateRemoved(c.getIsPropertyShipAfterDateRemoved());
        e.setIsPropertyShipByDateRemoved(c.getIsPropertyShipByDateRemoved());
        e.setIsPropertyEstimatedShipDateRemoved(c.getIsPropertyEstimatedShipDateRemoved());
        e.setIsPropertyEstimatedDeliveryDateRemoved(c.getIsPropertyEstimatedDeliveryDateRemoved());
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
        ((AbstractOrderShipGroupMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderShipGroupMvoStateEvent map(OrderShipGroupMvoCommand.DeleteOrderShipGroupMvo c) {
        OrderShipGroupMvoEventId stateEventId = new OrderShipGroupMvoEventId(c.getOrderShipGroupId(), c.getOrderVersion());
        OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateDeleted e = newOrderShipGroupMvoStateDeleted(stateEventId);
        ((AbstractOrderShipGroupMvoStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateCreated newOrderShipGroupMvoStateCreated(Long version, String commandId, String requesterId) {
        OrderShipGroupMvoEventId stateEventId = new OrderShipGroupMvoEventId(this.state.getOrderShipGroupId(), version);
        OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateCreated e = newOrderShipGroupMvoStateCreated(stateEventId);
        ((AbstractOrderShipGroupMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateMergePatched newOrderShipGroupMvoStateMergePatched(Long version, String commandId, String requesterId) {
        OrderShipGroupMvoEventId stateEventId = new OrderShipGroupMvoEventId(this.state.getOrderShipGroupId(), version);
        OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateMergePatched e = newOrderShipGroupMvoStateMergePatched(stateEventId);
        ((AbstractOrderShipGroupMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateDeleted newOrderShipGroupMvoStateDeleted(Long version, String commandId, String requesterId) {
        OrderShipGroupMvoEventId stateEventId = new OrderShipGroupMvoEventId(this.state.getOrderShipGroupId(), version);
        OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateDeleted e = newOrderShipGroupMvoStateDeleted(stateEventId);
        ((AbstractOrderShipGroupMvoStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateCreated newOrderShipGroupMvoStateCreated(OrderShipGroupMvoEventId stateEventId) {
        return new AbstractOrderShipGroupMvoStateEvent.SimpleOrderShipGroupMvoStateCreated(stateEventId);
    }

    protected OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateMergePatched newOrderShipGroupMvoStateMergePatched(OrderShipGroupMvoEventId stateEventId) {
        return new AbstractOrderShipGroupMvoStateEvent.SimpleOrderShipGroupMvoStateMergePatched(stateEventId);
    }

    protected OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateDeleted newOrderShipGroupMvoStateDeleted(OrderShipGroupMvoEventId stateEventId)
    {
        return new AbstractOrderShipGroupMvoStateEvent.SimpleOrderShipGroupMvoStateDeleted(stateEventId);
    }

    public static class SimpleOrderShipGroupMvoAggregate extends AbstractOrderShipGroupMvoAggregate
    {
        public SimpleOrderShipGroupMvoAggregate(OrderShipGroupMvoState state) {
            super(state);
        }

    }

}

