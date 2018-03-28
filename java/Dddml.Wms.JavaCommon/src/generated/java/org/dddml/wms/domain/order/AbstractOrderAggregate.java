package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
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
        OrderEventId stateEventId = new OrderEventId(c.getOrderId(), c.getVersion());
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
        for (OrderRoleCommand.CreateOrderRole innerCommand : c.getOrderRoles())
        {
            throwOnInconsistentCommands(c, innerCommand);
            OrderRoleStateEvent.OrderRoleStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addOrderRoleEvent(innerEvent);
        }

        for (OrderItemCommand.CreateOrderItem innerCommand : c.getOrderItems())
        {
            throwOnInconsistentCommands(c, innerCommand);
            OrderItemStateEvent.OrderItemStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addOrderItemEvent(innerEvent);
        }

        for (OrderShipGroupCommand.CreateOrderShipGroup innerCommand : c.getOrderShipGroups())
        {
            throwOnInconsistentCommands(c, innerCommand);
            OrderShipGroupStateEvent.OrderShipGroupStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addOrderShipGroupEvent(innerEvent);
        }

        return e;
    }

    protected OrderStateEvent map(OrderCommand.MergePatchOrder c) {
        OrderEventId stateEventId = new OrderEventId(c.getOrderId(), c.getVersion());
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
        for (OrderRoleCommand innerCommand : c.getOrderRoleCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            OrderRoleStateEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addOrderRoleEvent(innerEvent);
        }

        for (OrderItemCommand innerCommand : c.getOrderItemCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            OrderItemStateEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addOrderItemEvent(innerEvent);
        }

        for (OrderShipGroupCommand innerCommand : c.getOrderShipGroupCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            OrderShipGroupStateEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addOrderShipGroupEvent(innerEvent);
        }

        return e;
    }


    protected OrderRoleStateEvent map(OrderRoleCommand c, OrderCommand outerCommand, long version, OrderState outerState)
    {
        OrderRoleCommand.CreateOrderRole create = (c.getCommandType().equals(CommandType.CREATE)) ? ((OrderRoleCommand.CreateOrderRole)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        OrderRoleCommand.MergePatchOrderRole merge = (c.getCommandType().equals(CommandType.MERGE_PATCH)) ? ((OrderRoleCommand.MergePatchOrderRole)c) : null;
        if(merge != null)
        {
            return mapMergePatch(merge, outerCommand, version, outerState);
        }

        OrderRoleCommand.RemoveOrderRole remove = (c.getCommandType().equals(CommandType.REMOVE)) ? ((OrderRoleCommand.RemoveOrderRole)c) : null;
        if (remove != null)
        {
            return mapRemove(remove, outerCommand, version);
        }
        throw new UnsupportedOperationException();
    }

    protected OrderRoleStateEvent.OrderRoleStateCreated mapCreate(OrderRoleCommand.CreateOrderRole c, OrderCommand outerCommand, Long version, OrderState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderRoleEventId stateEventId = new OrderRoleEventId(c.getOrderId(), c.getPartyRoleId(), version);
        OrderRoleStateEvent.OrderRoleStateCreated e = newOrderRoleStateCreated(stateEventId);
        OrderRoleState s = outerState.getOrderRoles().get(c.getPartyRoleId());

        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected OrderRoleStateEvent.OrderRoleStateMergePatched mapMergePatch(OrderRoleCommand.MergePatchOrderRole c, OrderCommand outerCommand, Long version, OrderState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderRoleEventId stateEventId = new OrderRoleEventId(c.getOrderId(), c.getPartyRoleId(), version);
        OrderRoleStateEvent.OrderRoleStateMergePatched e = newOrderRoleStateMergePatched(stateEventId);
        OrderRoleState s = outerState.getOrderRoles().get(c.getPartyRoleId());

        e.setActive(c.getActive());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected OrderRoleStateEvent.OrderRoleStateRemoved mapRemove(OrderRoleCommand.RemoveOrderRole c, OrderCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderRoleEventId stateEventId = new OrderRoleEventId(c.getOrderId(), c.getPartyRoleId(), version);
        OrderRoleStateEvent.OrderRoleStateRemoved e = newOrderRoleStateRemoved(stateEventId);

        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        return e;

    }// END map(IRemove... ////////////////////////////


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
        OrderItemEventId stateEventId = new OrderItemEventId(c.getOrderId(), c.getOrderItemSeqId(), version);
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
        OrderItemEventId stateEventId = new OrderItemEventId(c.getOrderId(), c.getOrderItemSeqId(), version);
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


    protected OrderShipGroupStateEvent map(OrderShipGroupCommand c, OrderCommand outerCommand, long version, OrderState outerState)
    {
        OrderShipGroupCommand.CreateOrderShipGroup create = (c.getCommandType().equals(CommandType.CREATE)) ? ((OrderShipGroupCommand.CreateOrderShipGroup)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        OrderShipGroupCommand.MergePatchOrderShipGroup merge = (c.getCommandType().equals(CommandType.MERGE_PATCH)) ? ((OrderShipGroupCommand.MergePatchOrderShipGroup)c) : null;
        if(merge != null)
        {
            return mapMergePatch(merge, outerCommand, version, outerState);
        }

        OrderShipGroupCommand.RemoveOrderShipGroup remove = (c.getCommandType().equals(CommandType.REMOVE)) ? ((OrderShipGroupCommand.RemoveOrderShipGroup)c) : null;
        if (remove != null)
        {
            return mapRemove(remove, outerCommand, version);
        }
        throw new UnsupportedOperationException();
    }

    protected OrderShipGroupStateEvent.OrderShipGroupStateCreated mapCreate(OrderShipGroupCommand.CreateOrderShipGroup c, OrderCommand outerCommand, Long version, OrderState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderShipGroupEventId stateEventId = new OrderShipGroupEventId(c.getOrderId(), c.getShipGroupSeqId(), version);
        OrderShipGroupStateEvent.OrderShipGroupStateCreated e = newOrderShipGroupStateCreated(stateEventId);
        OrderShipGroupState s = outerState.getOrderShipGroups().get(c.getShipGroupSeqId());

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
        e.setPickwaveId(c.getPickwaveId());
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        for (OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation innerCommand : c.getOrderItemShipGroupAssociations())
        {
            throwOnInconsistentCommands(c, innerCommand);

            OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateCreated innerEvent = mapCreate(innerCommand, c, version, s);
            e.addOrderItemShipGroupAssociationEvent(innerEvent);
        }

        return e;

    }// END map(ICreate... ////////////////////////////

    protected OrderShipGroupStateEvent.OrderShipGroupStateMergePatched mapMergePatch(OrderShipGroupCommand.MergePatchOrderShipGroup c, OrderCommand outerCommand, Long version, OrderState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderShipGroupEventId stateEventId = new OrderShipGroupEventId(c.getOrderId(), c.getShipGroupSeqId(), version);
        OrderShipGroupStateEvent.OrderShipGroupStateMergePatched e = newOrderShipGroupStateMergePatched(stateEventId);
        OrderShipGroupState s = outerState.getOrderShipGroups().get(c.getShipGroupSeqId());

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
        e.setPickwaveId(c.getPickwaveId());
        e.setActive(c.getActive());
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
        e.setIsPropertyPickwaveIdRemoved(c.getIsPropertyPickwaveIdRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        for (OrderItemShipGroupAssociationCommand innerCommand : c.getOrderItemShipGroupAssociationCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);

            OrderItemShipGroupAssociationStateEvent innerEvent = map(innerCommand, c, version, s);
            e.addOrderItemShipGroupAssociationEvent(innerEvent);
        }

        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected OrderShipGroupStateEvent.OrderShipGroupStateRemoved mapRemove(OrderShipGroupCommand.RemoveOrderShipGroup c, OrderCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderShipGroupEventId stateEventId = new OrderShipGroupEventId(c.getOrderId(), c.getShipGroupSeqId(), version);
        OrderShipGroupStateEvent.OrderShipGroupStateRemoved e = newOrderShipGroupStateRemoved(stateEventId);

        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        return e;

    }// END map(IRemove... ////////////////////////////


    protected OrderItemShipGroupAssociationStateEvent map(OrderItemShipGroupAssociationCommand c, OrderShipGroupCommand outerCommand, long version, OrderShipGroupState outerState)
    {
        OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation create = (c.getCommandType().equals(CommandType.CREATE)) ? ((OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation)c) : null;
        if(create != null)
        {
            return mapCreate(create, outerCommand, version, outerState);
        }

        OrderItemShipGroupAssociationCommand.MergePatchOrderItemShipGroupAssociation merge = (c.getCommandType().equals(CommandType.MERGE_PATCH)) ? ((OrderItemShipGroupAssociationCommand.MergePatchOrderItemShipGroupAssociation)c) : null;
        if(merge != null)
        {
            return mapMergePatch(merge, outerCommand, version, outerState);
        }

        OrderItemShipGroupAssociationCommand.RemoveOrderItemShipGroupAssociation remove = (c.getCommandType().equals(CommandType.REMOVE)) ? ((OrderItemShipGroupAssociationCommand.RemoveOrderItemShipGroupAssociation)c) : null;
        if (remove != null)
        {
            return mapRemove(remove, outerCommand, version);
        }
        throw new UnsupportedOperationException();
    }

    protected OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateCreated mapCreate(OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation c, OrderShipGroupCommand outerCommand, Long version, OrderShipGroupState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderItemShipGroupAssociationEventId stateEventId = new OrderItemShipGroupAssociationEventId(c.getOrderId(), c.getOrderShipGroupShipGroupSeqId(), c.getOrderItemSeqId(), version);
        OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateCreated e = newOrderItemShipGroupAssociationStateCreated(stateEventId);
        OrderItemShipGroupAssociationState s = outerState.getOrderItemShipGroupAssociations().get(c.getOrderItemSeqId());

        e.setQuantity(c.getQuantity());
        e.setCancelQuantity(c.getCancelQuantity());
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateMergePatched mapMergePatch(OrderItemShipGroupAssociationCommand.MergePatchOrderItemShipGroupAssociation c, OrderShipGroupCommand outerCommand, Long version, OrderShipGroupState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderItemShipGroupAssociationEventId stateEventId = new OrderItemShipGroupAssociationEventId(c.getOrderId(), c.getOrderShipGroupShipGroupSeqId(), c.getOrderItemSeqId(), version);
        OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateMergePatched e = newOrderItemShipGroupAssociationStateMergePatched(stateEventId);
        OrderItemShipGroupAssociationState s = outerState.getOrderItemShipGroupAssociations().get(c.getOrderItemSeqId());

        e.setQuantity(c.getQuantity());
        e.setCancelQuantity(c.getCancelQuantity());
        e.setActive(c.getActive());
        e.setIsPropertyQuantityRemoved(c.getIsPropertyQuantityRemoved());
        e.setIsPropertyCancelQuantityRemoved(c.getIsPropertyCancelQuantityRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateRemoved mapRemove(OrderItemShipGroupAssociationCommand.RemoveOrderItemShipGroupAssociation c, OrderShipGroupCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderItemShipGroupAssociationEventId stateEventId = new OrderItemShipGroupAssociationEventId(c.getOrderId(), c.getOrderShipGroupShipGroupSeqId(), c.getOrderItemSeqId(), version);
        OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateRemoved e = newOrderItemShipGroupAssociationStateRemoved(stateEventId);

        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        return e;

    }// END map(IRemove... ////////////////////////////

    protected void throwOnInconsistentCommands(OrderCommand command, OrderRoleCommand innerCommand)
    {
        AbstractOrderCommand properties = command instanceof AbstractOrderCommand ? (AbstractOrderCommand) command : null;
        AbstractOrderRoleCommand innerProperties = innerCommand instanceof AbstractOrderRoleCommand ? (AbstractOrderRoleCommand) innerCommand : null;
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

    protected void throwOnInconsistentCommands(OrderCommand command, OrderShipGroupCommand innerCommand)
    {
        AbstractOrderCommand properties = command instanceof AbstractOrderCommand ? (AbstractOrderCommand) command : null;
        AbstractOrderShipGroupCommand innerProperties = innerCommand instanceof AbstractOrderShipGroupCommand ? (AbstractOrderShipGroupCommand) innerCommand : null;
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

    protected void throwOnInconsistentCommands(OrderShipGroupCommand command, OrderItemShipGroupAssociationCommand innerCommand)
    {
        AbstractOrderShipGroupCommand properties = command instanceof AbstractOrderShipGroupCommand ? (AbstractOrderShipGroupCommand) command : null;
        AbstractOrderItemShipGroupAssociationCommand innerProperties = innerCommand instanceof AbstractOrderItemShipGroupAssociationCommand ? (AbstractOrderItemShipGroupAssociationCommand) innerCommand : null;
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
        String outerShipGroupSeqIdName = "ShipGroupSeqId";
        Long outerShipGroupSeqIdValue = properties.getShipGroupSeqId();
        String innerOrderShipGroupShipGroupSeqIdName = "OrderShipGroupShipGroupSeqId";
        Long innerOrderShipGroupShipGroupSeqIdValue = innerProperties.getOrderShipGroupShipGroupSeqId();
        if (innerOrderShipGroupShipGroupSeqIdValue == null) {
            innerProperties.setOrderShipGroupShipGroupSeqId(outerShipGroupSeqIdValue);
        }
        else if (innerOrderShipGroupShipGroupSeqIdValue != outerShipGroupSeqIdValue 
            && (innerOrderShipGroupShipGroupSeqIdValue == null || innerOrderShipGroupShipGroupSeqIdValue != null && !innerOrderShipGroupShipGroupSeqIdValue.equals(outerShipGroupSeqIdValue))) 
        {
            throw DomainError.named("inconsistentId", "Outer %1$s %2$s NOT equals inner %3$s %4$s", outerShipGroupSeqIdName, outerShipGroupSeqIdValue, innerOrderShipGroupShipGroupSeqIdName, innerOrderShipGroupShipGroupSeqIdValue);
        }
    }// END throwOnInconsistentCommands /////////////////////


    ////////////////////////

    protected OrderStateEvent.OrderStateCreated newOrderStateCreated(Long version, String commandId, String requesterId) {
        OrderEventId stateEventId = new OrderEventId(this.state.getOrderId(), version);
        OrderStateEvent.OrderStateCreated e = newOrderStateCreated(stateEventId);
        ((AbstractOrderStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderStateEvent.OrderStateMergePatched newOrderStateMergePatched(Long version, String commandId, String requesterId) {
        OrderEventId stateEventId = new OrderEventId(this.state.getOrderId(), version);
        OrderStateEvent.OrderStateMergePatched e = newOrderStateMergePatched(stateEventId);
        ((AbstractOrderStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderStateEvent.OrderStateCreated newOrderStateCreated(OrderEventId stateEventId) {
        return new AbstractOrderStateEvent.SimpleOrderStateCreated(stateEventId);
    }

    protected OrderStateEvent.OrderStateMergePatched newOrderStateMergePatched(OrderEventId stateEventId) {
        return new AbstractOrderStateEvent.SimpleOrderStateMergePatched(stateEventId);
    }

    protected OrderRoleStateEvent.OrderRoleStateCreated newOrderRoleStateCreated(OrderRoleEventId stateEventId) {
        return new AbstractOrderRoleStateEvent.SimpleOrderRoleStateCreated(stateEventId);
    }

    protected OrderRoleStateEvent.OrderRoleStateMergePatched newOrderRoleStateMergePatched(OrderRoleEventId stateEventId) {
        return new AbstractOrderRoleStateEvent.SimpleOrderRoleStateMergePatched(stateEventId);
    }

    protected OrderRoleStateEvent.OrderRoleStateRemoved newOrderRoleStateRemoved(OrderRoleEventId stateEventId)
    {
        return new AbstractOrderRoleStateEvent.SimpleOrderRoleStateRemoved(stateEventId);
    }

    protected OrderItemStateEvent.OrderItemStateCreated newOrderItemStateCreated(OrderItemEventId stateEventId) {
        return new AbstractOrderItemStateEvent.SimpleOrderItemStateCreated(stateEventId);
    }

    protected OrderItemStateEvent.OrderItemStateMergePatched newOrderItemStateMergePatched(OrderItemEventId stateEventId) {
        return new AbstractOrderItemStateEvent.SimpleOrderItemStateMergePatched(stateEventId);
    }

    protected OrderShipGroupStateEvent.OrderShipGroupStateCreated newOrderShipGroupStateCreated(OrderShipGroupEventId stateEventId) {
        return new AbstractOrderShipGroupStateEvent.SimpleOrderShipGroupStateCreated(stateEventId);
    }

    protected OrderShipGroupStateEvent.OrderShipGroupStateMergePatched newOrderShipGroupStateMergePatched(OrderShipGroupEventId stateEventId) {
        return new AbstractOrderShipGroupStateEvent.SimpleOrderShipGroupStateMergePatched(stateEventId);
    }

    protected OrderShipGroupStateEvent.OrderShipGroupStateRemoved newOrderShipGroupStateRemoved(OrderShipGroupEventId stateEventId)
    {
        return new AbstractOrderShipGroupStateEvent.SimpleOrderShipGroupStateRemoved(stateEventId);
    }

    protected OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateCreated newOrderItemShipGroupAssociationStateCreated(OrderItemShipGroupAssociationEventId stateEventId) {
        return new AbstractOrderItemShipGroupAssociationStateEvent.SimpleOrderItemShipGroupAssociationStateCreated(stateEventId);
    }

    protected OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateMergePatched newOrderItemShipGroupAssociationStateMergePatched(OrderItemShipGroupAssociationEventId stateEventId) {
        return new AbstractOrderItemShipGroupAssociationStateEvent.SimpleOrderItemShipGroupAssociationStateMergePatched(stateEventId);
    }

    protected OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateRemoved newOrderItemShipGroupAssociationStateRemoved(OrderItemShipGroupAssociationEventId stateEventId)
    {
        return new AbstractOrderItemShipGroupAssociationStateEvent.SimpleOrderItemShipGroupAssociationStateRemoved(stateEventId);
    }

    public static class SimpleOrderAggregate extends AbstractOrderAggregate
    {
        public SimpleOrderAggregate(OrderState state) {
            super(state);
        }

    }

}

