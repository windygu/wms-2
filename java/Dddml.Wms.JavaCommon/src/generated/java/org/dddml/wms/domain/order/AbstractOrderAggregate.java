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
        OrderEvent e = map(c);
        apply(e);
    }

    public void mergePatch(OrderCommand.MergePatchOrder c)
    {
        OrderEvent e = map(c);
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

    protected OrderEvent map(OrderCommand.CreateOrder c) {
        OrderEventId stateEventId = new OrderEventId(c.getOrderId(), c.getVersion());
        OrderEvent.OrderStateCreated e = newOrderStateCreated(stateEventId);
        e.setOrderTypeId(c.getOrderTypeId());
        e.setOrderName(c.getOrderName());
        e.setExternalId(c.getExternalId());
        e.setSalesChannelEnumId(c.getSalesChannelEnumId());
        e.setOrderDate(c.getOrderDate());
        e.setPriority(c.getPriority());
        e.setEntryDate(c.getEntryDate());
        e.setPickSheetPrintedDate(c.getPickSheetPrintedDate());
        e.setStatusId(c.getStatusId());
        e.setCurrencyUomId(c.getCurrencyUomId());
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
        ((AbstractOrderEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (OrderRoleCommand.CreateOrderRole innerCommand : c.getOrderRoles())
        {
            throwOnInconsistentCommands(c, innerCommand);
            OrderRoleEvent.OrderRoleStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addOrderRoleEvent(innerEvent);
        }

        for (OrderItemCommand.CreateOrderItem innerCommand : c.getOrderItems())
        {
            throwOnInconsistentCommands(c, innerCommand);
            OrderItemEvent.OrderItemStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addOrderItemEvent(innerEvent);
        }

        for (OrderShipGroupCommand.CreateOrderShipGroup innerCommand : c.getOrderShipGroups())
        {
            throwOnInconsistentCommands(c, innerCommand);
            OrderShipGroupEvent.OrderShipGroupStateCreated innerEvent = mapCreate(innerCommand, c, version, this.state);
            e.addOrderShipGroupEvent(innerEvent);
        }

        return e;
    }

    protected OrderEvent map(OrderCommand.MergePatchOrder c) {
        OrderEventId stateEventId = new OrderEventId(c.getOrderId(), c.getVersion());
        OrderEvent.OrderStateMergePatched e = newOrderStateMergePatched(stateEventId);
        e.setOrderTypeId(c.getOrderTypeId());
        e.setOrderName(c.getOrderName());
        e.setExternalId(c.getExternalId());
        e.setSalesChannelEnumId(c.getSalesChannelEnumId());
        e.setOrderDate(c.getOrderDate());
        e.setPriority(c.getPriority());
        e.setEntryDate(c.getEntryDate());
        e.setPickSheetPrintedDate(c.getPickSheetPrintedDate());
        e.setStatusId(c.getStatusId());
        e.setCurrencyUomId(c.getCurrencyUomId());
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
        e.setIsPropertyCurrencyUomIdRemoved(c.getIsPropertyCurrencyUomIdRemoved());
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
        ((AbstractOrderEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        Long version = c.getVersion();
        for (OrderRoleCommand innerCommand : c.getOrderRoleCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            OrderRoleEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addOrderRoleEvent(innerEvent);
        }

        for (OrderItemCommand innerCommand : c.getOrderItemCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            OrderItemEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addOrderItemEvent(innerEvent);
        }

        for (OrderShipGroupCommand innerCommand : c.getOrderShipGroupCommands())
        {
            throwOnInconsistentCommands(c, innerCommand);
            OrderShipGroupEvent innerEvent = map(innerCommand, c, version, this.state);
            e.addOrderShipGroupEvent(innerEvent);
        }

        return e;
    }


    protected OrderRoleEvent map(OrderRoleCommand c, OrderCommand outerCommand, Long version, OrderState outerState)
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

    protected OrderRoleEvent.OrderRoleStateCreated mapCreate(OrderRoleCommand.CreateOrderRole c, OrderCommand outerCommand, Long version, OrderState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderRoleEventId stateEventId = new OrderRoleEventId(c.getOrderId(), c.getPartyRoleId(), version);
        OrderRoleEvent.OrderRoleStateCreated e = newOrderRoleStateCreated(stateEventId);
        OrderRoleState s = outerState.getOrderRoles().get(c.getPartyRoleId());

        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected OrderRoleEvent.OrderRoleStateMergePatched mapMergePatch(OrderRoleCommand.MergePatchOrderRole c, OrderCommand outerCommand, Long version, OrderState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderRoleEventId stateEventId = new OrderRoleEventId(c.getOrderId(), c.getPartyRoleId(), version);
        OrderRoleEvent.OrderRoleStateMergePatched e = newOrderRoleStateMergePatched(stateEventId);
        OrderRoleState s = outerState.getOrderRoles().get(c.getPartyRoleId());

        e.setActive(c.getActive());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected OrderRoleEvent.OrderRoleStateRemoved mapRemove(OrderRoleCommand.RemoveOrderRole c, OrderCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderRoleEventId stateEventId = new OrderRoleEventId(c.getOrderId(), c.getPartyRoleId(), version);
        OrderRoleEvent.OrderRoleStateRemoved e = newOrderRoleStateRemoved(stateEventId);

        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        return e;

    }// END map(IRemove... ////////////////////////////


    protected OrderItemEvent map(OrderItemCommand c, OrderCommand outerCommand, Long version, OrderState outerState)
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

    protected OrderItemEvent.OrderItemStateCreated mapCreate(OrderItemCommand.CreateOrderItem c, OrderCommand outerCommand, Long version, OrderState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderItemEventId stateEventId = new OrderItemEventId(c.getOrderId(), c.getOrderItemSeqId(), version);
        OrderItemEvent.OrderItemStateCreated e = newOrderItemStateCreated(stateEventId);
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

    protected OrderItemEvent.OrderItemStateMergePatched mapMergePatch(OrderItemCommand.MergePatchOrderItem c, OrderCommand outerCommand, Long version, OrderState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderItemEventId stateEventId = new OrderItemEventId(c.getOrderId(), c.getOrderItemSeqId(), version);
        OrderItemEvent.OrderItemStateMergePatched e = newOrderItemStateMergePatched(stateEventId);
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


    protected OrderShipGroupEvent map(OrderShipGroupCommand c, OrderCommand outerCommand, Long version, OrderState outerState)
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

    protected OrderShipGroupEvent.OrderShipGroupStateCreated mapCreate(OrderShipGroupCommand.CreateOrderShipGroup c, OrderCommand outerCommand, Long version, OrderState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderShipGroupEventId stateEventId = new OrderShipGroupEventId(c.getOrderId(), c.getShipGroupSeqId(), version);
        OrderShipGroupEvent.OrderShipGroupStateCreated e = newOrderShipGroupStateCreated(stateEventId);
        OrderShipGroupState s = outerState.getOrderShipGroups().get(c.getShipGroupSeqId());

        e.setShipmentMethodTypeId(c.getShipmentMethodTypeId());
        e.setSupplierPartyId(c.getSupplierPartyId());
        e.setVendorPartyId(c.getVendorPartyId());
        e.setCarrierPartyId(c.getCarrierPartyId());
        e.setCarrierRoleTypeId(c.getCarrierRoleTypeId());
        e.setFacilityId(c.getFacilityId());
        e.setDestinationFacilityId(c.getDestinationFacilityId());
        e.setContactMechId(c.getContactMechId());
        e.setTelecomContactMechId(c.getTelecomContactMechId());
        e.setTrackingNumber(c.getTrackingNumber());
        e.setMaySplit(c.getMaySplit());
        e.setGiftMessage(c.getGiftMessage());
        e.setIsGift(c.getIsGift());
        e.setShipAfterDate(c.getShipAfterDate());
        e.setShipByDate(c.getShipByDate());
        e.setEstimatedShipDate(c.getEstimatedShipDate());
        e.setEstimatedDeliveryDate(c.getEstimatedDeliveryDate());
        e.setPickwaveId(c.getPickwaveId());
        newOrderShipGroupOrderShipGroupActionCommandAndExecute(c, s, e);
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        for (OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation innerCommand : c.getOrderItemShipGroupAssociations())
        {
            throwOnInconsistentCommands(c, innerCommand);

            OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated innerEvent = mapCreate(innerCommand, c, version, s);
            e.addOrderItemShipGroupAssociationEvent(innerEvent);
        }

        return e;

    }// END map(ICreate... ////////////////////////////

    protected OrderShipGroupEvent.OrderShipGroupStateMergePatched mapMergePatch(OrderShipGroupCommand.MergePatchOrderShipGroup c, OrderCommand outerCommand, Long version, OrderState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderShipGroupEventId stateEventId = new OrderShipGroupEventId(c.getOrderId(), c.getShipGroupSeqId(), version);
        OrderShipGroupEvent.OrderShipGroupStateMergePatched e = newOrderShipGroupStateMergePatched(stateEventId);
        OrderShipGroupState s = outerState.getOrderShipGroups().get(c.getShipGroupSeqId());

        e.setShipmentMethodTypeId(c.getShipmentMethodTypeId());
        e.setSupplierPartyId(c.getSupplierPartyId());
        e.setVendorPartyId(c.getVendorPartyId());
        e.setCarrierPartyId(c.getCarrierPartyId());
        e.setCarrierRoleTypeId(c.getCarrierRoleTypeId());
        e.setFacilityId(c.getFacilityId());
        e.setDestinationFacilityId(c.getDestinationFacilityId());
        e.setContactMechId(c.getContactMechId());
        e.setTelecomContactMechId(c.getTelecomContactMechId());
        e.setTrackingNumber(c.getTrackingNumber());
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
        e.setIsPropertyDestinationFacilityIdRemoved(c.getIsPropertyDestinationFacilityIdRemoved());
        e.setIsPropertyContactMechIdRemoved(c.getIsPropertyContactMechIdRemoved());
        e.setIsPropertyTelecomContactMechIdRemoved(c.getIsPropertyTelecomContactMechIdRemoved());
        e.setIsPropertyTrackingNumberRemoved(c.getIsPropertyTrackingNumberRemoved());
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

            OrderItemShipGroupAssociationEvent innerEvent = map(innerCommand, c, version, s);
            e.addOrderItemShipGroupAssociationEvent(innerEvent);
        }

        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected OrderShipGroupEvent.OrderShipGroupStateRemoved mapRemove(OrderShipGroupCommand.RemoveOrderShipGroup c, OrderCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderShipGroupEventId stateEventId = new OrderShipGroupEventId(c.getOrderId(), c.getShipGroupSeqId(), version);
        OrderShipGroupEvent.OrderShipGroupStateRemoved e = newOrderShipGroupStateRemoved(stateEventId);

        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

        return e;

    }// END map(IRemove... ////////////////////////////


    protected OrderItemShipGroupAssociationEvent map(OrderItemShipGroupAssociationCommand c, OrderShipGroupCommand outerCommand, Long version, OrderShipGroupState outerState)
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

    protected OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated mapCreate(OrderItemShipGroupAssociationCommand.CreateOrderItemShipGroupAssociation c, OrderShipGroupCommand outerCommand, Long version, OrderShipGroupState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderItemShipGroupAssociationEventId stateEventId = new OrderItemShipGroupAssociationEventId(c.getOrderId(), c.getOrderShipGroupShipGroupSeqId(), c.getOrderItemSeqId(), version);
        OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated e = newOrderItemShipGroupAssociationStateCreated(stateEventId);
        OrderItemShipGroupAssociationState s = outerState.getOrderItemShipGroupAssociations().get(c.getOrderItemSeqId());

        e.setQuantity(c.getQuantity());
        e.setCancelQuantity(c.getCancelQuantity());
        e.setNumberOfPackages(c.getNumberOfPackages());
        e.setNumberOfContainers(c.getNumberOfContainers());
        e.setNumberOfPakagesPerContainer(c.getNumberOfPakagesPerContainer());
        e.setOrderItemShipGroupAssociationKey(c.getOrderItemShipGroupAssociationKey());
        e.setActive(c.getActive());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(ICreate... ////////////////////////////

    protected OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateMergePatched mapMergePatch(OrderItemShipGroupAssociationCommand.MergePatchOrderItemShipGroupAssociation c, OrderShipGroupCommand outerCommand, Long version, OrderShipGroupState outerState)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderItemShipGroupAssociationEventId stateEventId = new OrderItemShipGroupAssociationEventId(c.getOrderId(), c.getOrderShipGroupShipGroupSeqId(), c.getOrderItemSeqId(), version);
        OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateMergePatched e = newOrderItemShipGroupAssociationStateMergePatched(stateEventId);
        OrderItemShipGroupAssociationState s = outerState.getOrderItemShipGroupAssociations().get(c.getOrderItemSeqId());

        e.setQuantity(c.getQuantity());
        e.setCancelQuantity(c.getCancelQuantity());
        e.setNumberOfPackages(c.getNumberOfPackages());
        e.setNumberOfContainers(c.getNumberOfContainers());
        e.setNumberOfPakagesPerContainer(c.getNumberOfPakagesPerContainer());
        e.setOrderItemShipGroupAssociationKey(c.getOrderItemShipGroupAssociationKey());
        e.setActive(c.getActive());
        e.setIsPropertyQuantityRemoved(c.getIsPropertyQuantityRemoved());
        e.setIsPropertyCancelQuantityRemoved(c.getIsPropertyCancelQuantityRemoved());
        e.setIsPropertyNumberOfPackagesRemoved(c.getIsPropertyNumberOfPackagesRemoved());
        e.setIsPropertyNumberOfContainersRemoved(c.getIsPropertyNumberOfContainersRemoved());
        e.setIsPropertyNumberOfPakagesPerContainerRemoved(c.getIsPropertyNumberOfPakagesPerContainerRemoved());
        e.setIsPropertyOrderItemShipGroupAssociationKeyRemoved(c.getIsPropertyOrderItemShipGroupAssociationKeyRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;

    }// END map(IMergePatch... ////////////////////////////

    protected OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved mapRemove(OrderItemShipGroupAssociationCommand.RemoveOrderItemShipGroupAssociation c, OrderShipGroupCommand outerCommand, Long version)
    {
        ((AbstractCommand)c).setRequesterId(outerCommand.getRequesterId());
        OrderItemShipGroupAssociationEventId stateEventId = new OrderItemShipGroupAssociationEventId(c.getOrderId(), c.getOrderShipGroupShipGroupSeqId(), c.getOrderItemSeqId(), version);
        OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved e = newOrderItemShipGroupAssociationStateRemoved(stateEventId);

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
        String outerShipGroupSeqIdValue = properties.getShipGroupSeqId();
        String innerOrderShipGroupShipGroupSeqIdName = "OrderShipGroupShipGroupSeqId";
        String innerOrderShipGroupShipGroupSeqIdValue = innerProperties.getOrderShipGroupShipGroupSeqId();
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

    protected OrderEvent.OrderStateCreated newOrderStateCreated(Long version, String commandId, String requesterId) {
        OrderEventId stateEventId = new OrderEventId(this.state.getOrderId(), version);
        OrderEvent.OrderStateCreated e = newOrderStateCreated(stateEventId);
        ((AbstractOrderEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderEvent.OrderStateMergePatched newOrderStateMergePatched(Long version, String commandId, String requesterId) {
        OrderEventId stateEventId = new OrderEventId(this.state.getOrderId(), version);
        OrderEvent.OrderStateMergePatched e = newOrderStateMergePatched(stateEventId);
        ((AbstractOrderEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected OrderEvent.OrderStateCreated newOrderStateCreated(OrderEventId stateEventId) {
        return new AbstractOrderEvent.SimpleOrderStateCreated(stateEventId);
    }

    protected OrderEvent.OrderStateMergePatched newOrderStateMergePatched(OrderEventId stateEventId) {
        return new AbstractOrderEvent.SimpleOrderStateMergePatched(stateEventId);
    }

    protected OrderRoleEvent.OrderRoleStateCreated newOrderRoleStateCreated(OrderRoleEventId stateEventId) {
        return new AbstractOrderRoleEvent.SimpleOrderRoleStateCreated(stateEventId);
    }

    protected OrderRoleEvent.OrderRoleStateMergePatched newOrderRoleStateMergePatched(OrderRoleEventId stateEventId) {
        return new AbstractOrderRoleEvent.SimpleOrderRoleStateMergePatched(stateEventId);
    }

    protected OrderRoleEvent.OrderRoleStateRemoved newOrderRoleStateRemoved(OrderRoleEventId stateEventId)
    {
        return new AbstractOrderRoleEvent.SimpleOrderRoleStateRemoved(stateEventId);
    }

    protected OrderItemEvent.OrderItemStateCreated newOrderItemStateCreated(OrderItemEventId stateEventId) {
        return new AbstractOrderItemEvent.SimpleOrderItemStateCreated(stateEventId);
    }

    protected OrderItemEvent.OrderItemStateMergePatched newOrderItemStateMergePatched(OrderItemEventId stateEventId) {
        return new AbstractOrderItemEvent.SimpleOrderItemStateMergePatched(stateEventId);
    }

    protected OrderShipGroupEvent.OrderShipGroupStateCreated newOrderShipGroupStateCreated(OrderShipGroupEventId stateEventId) {
        return new AbstractOrderShipGroupEvent.SimpleOrderShipGroupStateCreated(stateEventId);
    }

    protected OrderShipGroupEvent.OrderShipGroupStateMergePatched newOrderShipGroupStateMergePatched(OrderShipGroupEventId stateEventId) {
        return new AbstractOrderShipGroupEvent.SimpleOrderShipGroupStateMergePatched(stateEventId);
    }

    protected OrderShipGroupEvent.OrderShipGroupStateRemoved newOrderShipGroupStateRemoved(OrderShipGroupEventId stateEventId)
    {
        return new AbstractOrderShipGroupEvent.SimpleOrderShipGroupStateRemoved(stateEventId);
    }

    protected OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated newOrderItemShipGroupAssociationStateCreated(OrderItemShipGroupAssociationEventId stateEventId) {
        return new AbstractOrderItemShipGroupAssociationEvent.SimpleOrderItemShipGroupAssociationStateCreated(stateEventId);
    }

    protected OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateMergePatched newOrderItemShipGroupAssociationStateMergePatched(OrderItemShipGroupAssociationEventId stateEventId) {
        return new AbstractOrderItemShipGroupAssociationEvent.SimpleOrderItemShipGroupAssociationStateMergePatched(stateEventId);
    }

    protected OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved newOrderItemShipGroupAssociationStateRemoved(OrderItemShipGroupAssociationEventId stateEventId)
    {
        return new AbstractOrderItemShipGroupAssociationEvent.SimpleOrderItemShipGroupAssociationStateRemoved(stateEventId);
    }

    protected void newOrderShipGroupOrderShipGroupActionCommandAndExecute(OrderShipGroupCommand.CreateOrderShipGroup c, OrderShipGroupState s, OrderShipGroupEvent.OrderShipGroupStateCreated e)
    {
        PropertyCommandHandler<String, String> pCommandHandler = this.getOrderShipGroupOrderShipGroupActionCommandHandler();
        String pCmdContent = null;
        PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<String, String>();
        pCmd.setContent(pCmdContent);
        pCmd.setStateGetter(() -> s.getOrderShipGroupStatusId());
        pCmd.setStateSetter(p -> e.setOrderShipGroupStatusId(p));
        pCmd.setOuterCommandType(CommandType.CREATE);
        pCmd.setContext(getState());
        pCommandHandler.execute(pCmd);
    }

    public class SimpleOrderShipGroupOrderShipGroupActionCommandHandler implements PropertyCommandHandler<String, String> {

        public void execute(PropertyCommand<String, String> command) {
            if (Objects.equals(null, command.getStateGetter().get()) && Objects.equals(null, command.getContent())) {
                command.getStateSetter().accept("SHIP_GRP_CREATED");
                return;
            }
            if (Objects.equals("SHIP_GRP_CREATED", command.getStateGetter().get()) && Objects.equals("Approve", command.getContent())) {
                command.getStateSetter().accept("SHIP_GRP_APPROVED");
                return;
            }
            if (Objects.equals("SHIP_GRP_APPROVED", command.getStateGetter().get()) && Objects.equals("Complete", command.getContent())) {
                command.getStateSetter().accept("SHIP_GRP_COMPLETED");
                return;
            }
            if (Objects.equals("SHIP_GRP_CREATED", command.getStateGetter().get()) && Objects.equals("Reject", command.getContent())) {
                command.getStateSetter().accept("SHIP_GRP_REJECTED");
                return;
            }
            if (Objects.equals("SHIP_GRP_CREATED", command.getStateGetter().get()) && Objects.equals("Cancel", command.getContent())) {
                command.getStateSetter().accept("SHIP_GRP_CANCELLED");
                return;
            }
            throw new IllegalArgumentException(String.format("State: %1$s, command: %2$s", command.getStateGetter().get(), command.getContent()));
        }
    }

    private PropertyCommandHandler<String, String> orderShipGroupOrderShipGroupActionCommandHandler = new SimpleOrderShipGroupOrderShipGroupActionCommandHandler();

    public void setOrderShipGroupOrderShipGroupActionCommandHandler(PropertyCommandHandler<String, String> h) {
        this.orderShipGroupOrderShipGroupActionCommandHandler = h;
    }

    protected PropertyCommandHandler<String, String> getOrderShipGroupOrderShipGroupActionCommandHandler() {
        Object h = ApplicationContext.current.get("OrderShipGroupOrderShipGroupActionCommandHandler");
        if (h instanceof PropertyCommandHandler) {
            return (PropertyCommandHandler<String, String>) h;
        }
        return this.orderShipGroupOrderShipGroupActionCommandHandler;
    }

    public static class SimpleOrderAggregate extends AbstractOrderAggregate
    {
        public SimpleOrderAggregate(OrderState state) {
            super(state);
        }

        @Override
        public void orderShipGroupAction(String shipGroupSeqId, String value, Long version, String commandId, String requesterId) {
            OrderEvent.OrderStateMergePatched eventOfOrder = newOrderStateMergePatched(version, commandId, requesterId);
            OrderShipGroupEvent.OrderShipGroupStateMergePatched eventOfOrderShipGroup = newOrderShipGroupStateMergePatched(new OrderShipGroupEventId(this.getState().getOrderId(), shipGroupSeqId, version));
            eventOfOrder.addOrderShipGroupEvent(eventOfOrderShipGroup);
            doOrderShipGroupAction(shipGroupSeqId, value, s -> eventOfOrderShipGroup.setOrderShipGroupStatusId(s));
            apply(eventOfOrder);
        }

        protected  void doOrderShipGroupAction(String shipGroupSeqId, String value, java.util.function.Consumer<String> setOrderShipGroupStatusId) {
            PropertyCommandHandler<String, String> pCommandHandler = this.getOrderShipGroupOrderShipGroupActionCommandHandler();
            PropertyCommand<String, String> pCmd = new AbstractPropertyCommand.SimplePropertyCommand<>();
            pCmd.setContent(value);
            pCmd.setStateGetter(() -> this.getState().getOrderShipGroups().get(shipGroupSeqId).getOrderShipGroupStatusId());
            pCmd.setStateSetter(setOrderShipGroupStatusId);
            pCmd.setOuterCommandType("OrderShipGroupAction");
            pCmd.setContext(getState());
            pCommandHandler.execute(pCmd);
        }

    }

}

