package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractOrderItemStateCommandConverter<TCreateOrderItem extends OrderItemCommand.CreateOrderItem, TMergePatchOrderItem extends OrderItemCommand.MergePatchOrderItem, TRemoveOrderItem extends OrderItemCommand.RemoveOrderItem>
{
    public OrderItemCommand toCreateOrMergePatchOrderItem(OrderItemState state)
    {
        //where TCreateOrderItem : ICreateOrderItem, new()
        //where TMergePatchOrderItem : IMergePatchOrderItem, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateOrderItem(state);
        }
        else 
        {
            return toMergePatchOrderItem(state);
        }
    }

    public TRemoveOrderItem toRemoveOrderItem(OrderItemState state) //where TRemoveOrderItem : IRemoveOrderItem, new()
    {
        TRemoveOrderItem cmd = newRemoveOrderItem();
        cmd.setOrderItemSeqId(state.getOrderItemSeqId());
        return cmd;
    }

    public TMergePatchOrderItem toMergePatchOrderItem(OrderItemState state) //where TMergePatchOrderItem : IMergePatchOrderItem, new()
    {
        TMergePatchOrderItem cmd = newMergePatchOrderItem();

        cmd.setOrderItemSeqId(state.getOrderItemSeqId());
        cmd.setProductId(state.getProductId());
        cmd.setExternalProductId(state.getExternalProductId());
        cmd.setQuantity(state.getQuantity());
        cmd.setCancelQuantity(state.getCancelQuantity());
        cmd.setSelectedAmount(state.getSelectedAmount());
        cmd.setExternalId(state.getExternalId());
        cmd.setOrderItemTypeId(state.getOrderItemTypeId());
        cmd.setOrderItemGroupSeqId(state.getOrderItemGroupSeqId());
        cmd.setIsItemGroupPrimary(state.getIsItemGroupPrimary());
        cmd.setFromInventoryItemId(state.getFromInventoryItemId());
        cmd.setIsPromo(state.getIsPromo());
        cmd.setQuoteId(state.getQuoteId());
        cmd.setQuoteItemSeqId(state.getQuoteItemSeqId());
        cmd.setShoppingListId(state.getShoppingListId());
        cmd.setShoppingListItemSeqId(state.getShoppingListItemSeqId());
        cmd.setUnitPrice(state.getUnitPrice());
        cmd.setUnitListPrice(state.getUnitListPrice());
        cmd.setUnitAverageCost(state.getUnitAverageCost());
        cmd.setUnitRecurringPrice(state.getUnitRecurringPrice());
        cmd.setIsModifiedPrice(state.getIsModifiedPrice());
        cmd.setRecurringFreqUomId(state.getRecurringFreqUomId());
        cmd.setItemDescription(state.getItemDescription());
        cmd.setComments(state.getComments());
        cmd.setCorrespondingPoId(state.getCorrespondingPoId());
        cmd.setStatusId(state.getStatusId());
        cmd.setSyncStatusId(state.getSyncStatusId());
        cmd.setEstimatedShipDate(state.getEstimatedShipDate());
        cmd.setEstimatedDeliveryDate(state.getEstimatedDeliveryDate());
        cmd.setAutoCancelDate(state.getAutoCancelDate());
        cmd.setDontCancelSetDate(state.getDontCancelSetDate());
        cmd.setDontCancelSetBy(state.getDontCancelSetBy());
        cmd.setShipBeforeDate(state.getShipBeforeDate());
        cmd.setShipAfterDate(state.getShipAfterDate());
        cmd.setCancelBackOrderDate(state.getCancelBackOrderDate());
        cmd.setOverrideGlAccountId(state.getOverrideGlAccountId());
        cmd.setActive(state.getActive());
        cmd.setOrderId(state.getOrderId());
            
        if (state.getProductId() == null) { cmd.setIsPropertyProductIdRemoved(true); }
        if (state.getExternalProductId() == null) { cmd.setIsPropertyExternalProductIdRemoved(true); }
        if (state.getQuantity() == null) { cmd.setIsPropertyQuantityRemoved(true); }
        if (state.getCancelQuantity() == null) { cmd.setIsPropertyCancelQuantityRemoved(true); }
        if (state.getSelectedAmount() == null) { cmd.setIsPropertySelectedAmountRemoved(true); }
        if (state.getExternalId() == null) { cmd.setIsPropertyExternalIdRemoved(true); }
        if (state.getOrderItemTypeId() == null) { cmd.setIsPropertyOrderItemTypeIdRemoved(true); }
        if (state.getOrderItemGroupSeqId() == null) { cmd.setIsPropertyOrderItemGroupSeqIdRemoved(true); }
        if (state.getIsItemGroupPrimary() == null) { cmd.setIsPropertyIsItemGroupPrimaryRemoved(true); }
        if (state.getFromInventoryItemId() == null) { cmd.setIsPropertyFromInventoryItemIdRemoved(true); }
        if (state.getIsPromo() == null) { cmd.setIsPropertyIsPromoRemoved(true); }
        if (state.getQuoteId() == null) { cmd.setIsPropertyQuoteIdRemoved(true); }
        if (state.getQuoteItemSeqId() == null) { cmd.setIsPropertyQuoteItemSeqIdRemoved(true); }
        if (state.getShoppingListId() == null) { cmd.setIsPropertyShoppingListIdRemoved(true); }
        if (state.getShoppingListItemSeqId() == null) { cmd.setIsPropertyShoppingListItemSeqIdRemoved(true); }
        if (state.getUnitPrice() == null) { cmd.setIsPropertyUnitPriceRemoved(true); }
        if (state.getUnitListPrice() == null) { cmd.setIsPropertyUnitListPriceRemoved(true); }
        if (state.getUnitAverageCost() == null) { cmd.setIsPropertyUnitAverageCostRemoved(true); }
        if (state.getUnitRecurringPrice() == null) { cmd.setIsPropertyUnitRecurringPriceRemoved(true); }
        if (state.getIsModifiedPrice() == null) { cmd.setIsPropertyIsModifiedPriceRemoved(true); }
        if (state.getRecurringFreqUomId() == null) { cmd.setIsPropertyRecurringFreqUomIdRemoved(true); }
        if (state.getItemDescription() == null) { cmd.setIsPropertyItemDescriptionRemoved(true); }
        if (state.getComments() == null) { cmd.setIsPropertyCommentsRemoved(true); }
        if (state.getCorrespondingPoId() == null) { cmd.setIsPropertyCorrespondingPoIdRemoved(true); }
        if (state.getStatusId() == null) { cmd.setIsPropertyStatusIdRemoved(true); }
        if (state.getSyncStatusId() == null) { cmd.setIsPropertySyncStatusIdRemoved(true); }
        if (state.getEstimatedShipDate() == null) { cmd.setIsPropertyEstimatedShipDateRemoved(true); }
        if (state.getEstimatedDeliveryDate() == null) { cmd.setIsPropertyEstimatedDeliveryDateRemoved(true); }
        if (state.getAutoCancelDate() == null) { cmd.setIsPropertyAutoCancelDateRemoved(true); }
        if (state.getDontCancelSetDate() == null) { cmd.setIsPropertyDontCancelSetDateRemoved(true); }
        if (state.getDontCancelSetBy() == null) { cmd.setIsPropertyDontCancelSetByRemoved(true); }
        if (state.getShipBeforeDate() == null) { cmd.setIsPropertyShipBeforeDateRemoved(true); }
        if (state.getShipAfterDate() == null) { cmd.setIsPropertyShipAfterDateRemoved(true); }
        if (state.getCancelBackOrderDate() == null) { cmd.setIsPropertyCancelBackOrderDateRemoved(true); }
        if (state.getOverrideGlAccountId() == null) { cmd.setIsPropertyOverrideGlAccountIdRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateOrderItem toCreateOrderItem(OrderItemState state) //where TCreateOrderItem : ICreateOrderItem, new()
    {
        TCreateOrderItem cmd = newCreateOrderItem();

        cmd.setOrderItemSeqId(state.getOrderItemSeqId());
        cmd.setProductId(state.getProductId());
        cmd.setExternalProductId(state.getExternalProductId());
        cmd.setQuantity(state.getQuantity());
        cmd.setCancelQuantity(state.getCancelQuantity());
        cmd.setSelectedAmount(state.getSelectedAmount());
        cmd.setExternalId(state.getExternalId());
        cmd.setOrderItemTypeId(state.getOrderItemTypeId());
        cmd.setOrderItemGroupSeqId(state.getOrderItemGroupSeqId());
        cmd.setIsItemGroupPrimary(state.getIsItemGroupPrimary());
        cmd.setFromInventoryItemId(state.getFromInventoryItemId());
        cmd.setIsPromo(state.getIsPromo());
        cmd.setQuoteId(state.getQuoteId());
        cmd.setQuoteItemSeqId(state.getQuoteItemSeqId());
        cmd.setShoppingListId(state.getShoppingListId());
        cmd.setShoppingListItemSeqId(state.getShoppingListItemSeqId());
        cmd.setUnitPrice(state.getUnitPrice());
        cmd.setUnitListPrice(state.getUnitListPrice());
        cmd.setUnitAverageCost(state.getUnitAverageCost());
        cmd.setUnitRecurringPrice(state.getUnitRecurringPrice());
        cmd.setIsModifiedPrice(state.getIsModifiedPrice());
        cmd.setRecurringFreqUomId(state.getRecurringFreqUomId());
        cmd.setItemDescription(state.getItemDescription());
        cmd.setComments(state.getComments());
        cmd.setCorrespondingPoId(state.getCorrespondingPoId());
        cmd.setStatusId(state.getStatusId());
        cmd.setSyncStatusId(state.getSyncStatusId());
        cmd.setEstimatedShipDate(state.getEstimatedShipDate());
        cmd.setEstimatedDeliveryDate(state.getEstimatedDeliveryDate());
        cmd.setAutoCancelDate(state.getAutoCancelDate());
        cmd.setDontCancelSetDate(state.getDontCancelSetDate());
        cmd.setDontCancelSetBy(state.getDontCancelSetBy());
        cmd.setShipBeforeDate(state.getShipBeforeDate());
        cmd.setShipAfterDate(state.getShipAfterDate());
        cmd.setCancelBackOrderDate(state.getCancelBackOrderDate());
        cmd.setOverrideGlAccountId(state.getOverrideGlAccountId());
        cmd.setActive(state.getActive());
        cmd.setOrderId(state.getOrderId());
        return cmd;
    }

    protected abstract TCreateOrderItem newCreateOrderItem();

    protected abstract TMergePatchOrderItem newMergePatchOrderItem(); 

    protected abstract TRemoveOrderItem newRemoveOrderItem();

    public static class SimpleOrderItemStateCommandConverter extends AbstractOrderItemStateCommandConverter<AbstractOrderItemCommand.SimpleCreateOrderItem, AbstractOrderItemCommand.SimpleMergePatchOrderItem, AbstractOrderItemCommand.SimpleRemoveOrderItem>
    {
        @Override
        protected AbstractOrderItemCommand.SimpleCreateOrderItem newCreateOrderItem() {
            return new AbstractOrderItemCommand.SimpleCreateOrderItem();
        }

        @Override
        protected AbstractOrderItemCommand.SimpleMergePatchOrderItem newMergePatchOrderItem() {
            return new AbstractOrderItemCommand.SimpleMergePatchOrderItem();
        }

        @Override
        protected AbstractOrderItemCommand.SimpleRemoveOrderItem newRemoveOrderItem() {
            return new AbstractOrderItemCommand.SimpleRemoveOrderItem();
        }


    }

}

