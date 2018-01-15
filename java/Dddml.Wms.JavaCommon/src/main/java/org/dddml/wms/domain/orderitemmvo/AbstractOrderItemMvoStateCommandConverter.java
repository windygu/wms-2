package org.dddml.wms.domain.orderitemmvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractOrderItemMvoStateCommandConverter<TCreateOrderItemMvo extends OrderItemMvoCommand.CreateOrderItemMvo, TMergePatchOrderItemMvo extends OrderItemMvoCommand.MergePatchOrderItemMvo, TDeleteOrderItemMvo extends OrderItemMvoCommand.DeleteOrderItemMvo>
{
    public OrderItemMvoCommand toCreateOrMergePatchOrderItemMvo(OrderItemMvoState state)
    {
        //where TCreateOrderItemMvo : ICreateOrderItemMvo, new()
        //where TMergePatchOrderItemMvo : IMergePatchOrderItemMvo, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateOrderItemMvo(state);
        }
        else 
        {
            return toMergePatchOrderItemMvo(state);
        }
    }

    public TDeleteOrderItemMvo toDeleteOrderItemMvo(OrderItemMvoState state) //where TDeleteOrderItemMvo : IDeleteOrderItemMvo, new()
    {
        TDeleteOrderItemMvo cmd = newDeleteOrderItemMvo();
        cmd.setOrderItemId(state.getOrderItemId());
        cmd.setOrderVersion(state.getOrderVersion());

        return cmd;
    }

    public TMergePatchOrderItemMvo toMergePatchOrderItemMvo(OrderItemMvoState state) //where TMergePatchOrderItemMvo : IMergePatchOrderItemMvo, new()
    {
        TMergePatchOrderItemMvo cmd = newMergePatchOrderItemMvo();

        cmd.setOrderVersion(state.getOrderVersion());

        cmd.setOrderItemId(state.getOrderItemId());
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
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setOrderOrderTypeId(state.getOrderOrderTypeId());
        cmd.setOrderOrderName(state.getOrderOrderName());
        cmd.setOrderExternalId(state.getOrderExternalId());
        cmd.setOrderSalesChannelEnumId(state.getOrderSalesChannelEnumId());
        cmd.setOrderOrderDate(state.getOrderOrderDate());
        cmd.setOrderPriority(state.getOrderPriority());
        cmd.setOrderEntryDate(state.getOrderEntryDate());
        cmd.setOrderPickSheetPrintedDate(state.getOrderPickSheetPrintedDate());
        cmd.setOrderStatusId(state.getOrderStatusId());
        cmd.setOrderCurrencyUom(state.getOrderCurrencyUom());
        cmd.setOrderSyncStatusId(state.getOrderSyncStatusId());
        cmd.setOrderBillingAccountId(state.getOrderBillingAccountId());
        cmd.setOrderOriginFacilityId(state.getOrderOriginFacilityId());
        cmd.setOrderWebSiteId(state.getOrderWebSiteId());
        cmd.setOrderProductStoreId(state.getOrderProductStoreId());
        cmd.setOrderTerminalId(state.getOrderTerminalId());
        cmd.setOrderTransactionId(state.getOrderTransactionId());
        cmd.setOrderAutoOrderShoppingListId(state.getOrderAutoOrderShoppingListId());
        cmd.setOrderNeedsInventoryIssuance(state.getOrderNeedsInventoryIssuance());
        cmd.setOrderIsRushOrder(state.getOrderIsRushOrder());
        cmd.setOrderInternalCode(state.getOrderInternalCode());
        cmd.setOrderRemainingSubTotal(state.getOrderRemainingSubTotal());
        cmd.setOrderGrandTotal(state.getOrderGrandTotal());
        cmd.setOrderInvoicePerShipment(state.getOrderInvoicePerShipment());
        cmd.setOrderCreatedBy(state.getOrderCreatedBy());
        cmd.setOrderCreatedAt(state.getOrderCreatedAt());
        cmd.setOrderUpdatedBy(state.getOrderUpdatedBy());
        cmd.setOrderUpdatedAt(state.getOrderUpdatedAt());
        cmd.setOrderActive(state.getOrderActive());
            
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
        if (state.getVersion() == null) { cmd.setIsPropertyVersionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        if (state.getOrderOrderTypeId() == null) { cmd.setIsPropertyOrderOrderTypeIdRemoved(true); }
        if (state.getOrderOrderName() == null) { cmd.setIsPropertyOrderOrderNameRemoved(true); }
        if (state.getOrderExternalId() == null) { cmd.setIsPropertyOrderExternalIdRemoved(true); }
        if (state.getOrderSalesChannelEnumId() == null) { cmd.setIsPropertyOrderSalesChannelEnumIdRemoved(true); }
        if (state.getOrderOrderDate() == null) { cmd.setIsPropertyOrderOrderDateRemoved(true); }
        if (state.getOrderPriority() == null) { cmd.setIsPropertyOrderPriorityRemoved(true); }
        if (state.getOrderEntryDate() == null) { cmd.setIsPropertyOrderEntryDateRemoved(true); }
        if (state.getOrderPickSheetPrintedDate() == null) { cmd.setIsPropertyOrderPickSheetPrintedDateRemoved(true); }
        if (state.getOrderStatusId() == null) { cmd.setIsPropertyOrderStatusIdRemoved(true); }
        if (state.getOrderCurrencyUom() == null) { cmd.setIsPropertyOrderCurrencyUomRemoved(true); }
        if (state.getOrderSyncStatusId() == null) { cmd.setIsPropertyOrderSyncStatusIdRemoved(true); }
        if (state.getOrderBillingAccountId() == null) { cmd.setIsPropertyOrderBillingAccountIdRemoved(true); }
        if (state.getOrderOriginFacilityId() == null) { cmd.setIsPropertyOrderOriginFacilityIdRemoved(true); }
        if (state.getOrderWebSiteId() == null) { cmd.setIsPropertyOrderWebSiteIdRemoved(true); }
        if (state.getOrderProductStoreId() == null) { cmd.setIsPropertyOrderProductStoreIdRemoved(true); }
        if (state.getOrderTerminalId() == null) { cmd.setIsPropertyOrderTerminalIdRemoved(true); }
        if (state.getOrderTransactionId() == null) { cmd.setIsPropertyOrderTransactionIdRemoved(true); }
        if (state.getOrderAutoOrderShoppingListId() == null) { cmd.setIsPropertyOrderAutoOrderShoppingListIdRemoved(true); }
        if (state.getOrderNeedsInventoryIssuance() == null) { cmd.setIsPropertyOrderNeedsInventoryIssuanceRemoved(true); }
        if (state.getOrderIsRushOrder() == null) { cmd.setIsPropertyOrderIsRushOrderRemoved(true); }
        if (state.getOrderInternalCode() == null) { cmd.setIsPropertyOrderInternalCodeRemoved(true); }
        if (state.getOrderRemainingSubTotal() == null) { cmd.setIsPropertyOrderRemainingSubTotalRemoved(true); }
        if (state.getOrderGrandTotal() == null) { cmd.setIsPropertyOrderGrandTotalRemoved(true); }
        if (state.getOrderInvoicePerShipment() == null) { cmd.setIsPropertyOrderInvoicePerShipmentRemoved(true); }
        if (state.getOrderCreatedBy() == null) { cmd.setIsPropertyOrderCreatedByRemoved(true); }
        if (state.getOrderCreatedAt() == null) { cmd.setIsPropertyOrderCreatedAtRemoved(true); }
        if (state.getOrderUpdatedBy() == null) { cmd.setIsPropertyOrderUpdatedByRemoved(true); }
        if (state.getOrderUpdatedAt() == null) { cmd.setIsPropertyOrderUpdatedAtRemoved(true); }
        if (state.getOrderActive() == null) { cmd.setIsPropertyOrderActiveRemoved(true); }
        return cmd;
    }

    public TCreateOrderItemMvo toCreateOrderItemMvo(OrderItemMvoState state) //where TCreateOrderItemMvo : ICreateOrderItemMvo, new()
    {
        TCreateOrderItemMvo cmd = newCreateOrderItemMvo();

        cmd.setOrderVersion(state.getOrderVersion());
        cmd.setOrderItemId(state.getOrderItemId());
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
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setOrderOrderTypeId(state.getOrderOrderTypeId());
        cmd.setOrderOrderName(state.getOrderOrderName());
        cmd.setOrderExternalId(state.getOrderExternalId());
        cmd.setOrderSalesChannelEnumId(state.getOrderSalesChannelEnumId());
        cmd.setOrderOrderDate(state.getOrderOrderDate());
        cmd.setOrderPriority(state.getOrderPriority());
        cmd.setOrderEntryDate(state.getOrderEntryDate());
        cmd.setOrderPickSheetPrintedDate(state.getOrderPickSheetPrintedDate());
        cmd.setOrderStatusId(state.getOrderStatusId());
        cmd.setOrderCurrencyUom(state.getOrderCurrencyUom());
        cmd.setOrderSyncStatusId(state.getOrderSyncStatusId());
        cmd.setOrderBillingAccountId(state.getOrderBillingAccountId());
        cmd.setOrderOriginFacilityId(state.getOrderOriginFacilityId());
        cmd.setOrderWebSiteId(state.getOrderWebSiteId());
        cmd.setOrderProductStoreId(state.getOrderProductStoreId());
        cmd.setOrderTerminalId(state.getOrderTerminalId());
        cmd.setOrderTransactionId(state.getOrderTransactionId());
        cmd.setOrderAutoOrderShoppingListId(state.getOrderAutoOrderShoppingListId());
        cmd.setOrderNeedsInventoryIssuance(state.getOrderNeedsInventoryIssuance());
        cmd.setOrderIsRushOrder(state.getOrderIsRushOrder());
        cmd.setOrderInternalCode(state.getOrderInternalCode());
        cmd.setOrderRemainingSubTotal(state.getOrderRemainingSubTotal());
        cmd.setOrderGrandTotal(state.getOrderGrandTotal());
        cmd.setOrderInvoicePerShipment(state.getOrderInvoicePerShipment());
        cmd.setOrderCreatedBy(state.getOrderCreatedBy());
        cmd.setOrderCreatedAt(state.getOrderCreatedAt());
        cmd.setOrderUpdatedBy(state.getOrderUpdatedBy());
        cmd.setOrderUpdatedAt(state.getOrderUpdatedAt());
        cmd.setOrderActive(state.getOrderActive());
        return cmd;
    }

    protected abstract TCreateOrderItemMvo newCreateOrderItemMvo();

    protected abstract TMergePatchOrderItemMvo newMergePatchOrderItemMvo(); 

    protected abstract TDeleteOrderItemMvo newDeleteOrderItemMvo();

    public static class SimpleOrderItemMvoStateCommandConverter extends AbstractOrderItemMvoStateCommandConverter<AbstractOrderItemMvoCommand.SimpleCreateOrderItemMvo, AbstractOrderItemMvoCommand.SimpleMergePatchOrderItemMvo, AbstractOrderItemMvoCommand.SimpleDeleteOrderItemMvo>
    {
        @Override
        protected AbstractOrderItemMvoCommand.SimpleCreateOrderItemMvo newCreateOrderItemMvo() {
            return new AbstractOrderItemMvoCommand.SimpleCreateOrderItemMvo();
        }

        @Override
        protected AbstractOrderItemMvoCommand.SimpleMergePatchOrderItemMvo newMergePatchOrderItemMvo() {
            return new AbstractOrderItemMvoCommand.SimpleMergePatchOrderItemMvo();
        }

        @Override
        protected AbstractOrderItemMvoCommand.SimpleDeleteOrderItemMvo newDeleteOrderItemMvo() {
            return new AbstractOrderItemMvoCommand.SimpleDeleteOrderItemMvo();
        }


    }

}

