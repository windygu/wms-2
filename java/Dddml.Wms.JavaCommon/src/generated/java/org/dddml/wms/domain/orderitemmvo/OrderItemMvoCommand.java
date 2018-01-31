package org.dddml.wms.domain.orderitemmvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface OrderItemMvoCommand extends Command
{
    OrderItemId getOrderItemId();

    void setOrderItemId(OrderItemId orderItemId);

    Long getOrderVersion();

    void setOrderVersion(Long orderVersion);

    static void throwOnInvalidStateTransition(OrderItemMvoState state, Command c) {
        if (state.getOrderVersion() == null)
        {
            if (isCommandCreate((OrderItemMvoCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (isCommandCreate((OrderItemMvoCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(OrderItemMvoCommand c) {
        return ((c instanceof OrderItemMvoCommand.CreateOrderItemMvo) 
            && c.getOrderVersion().equals(OrderItemMvoState.VERSION_NULL));
    }

    interface CreateOrMergePatchOrderItemMvo extends OrderItemMvoCommand
    {
        String getProductId();

        void setProductId(String productId);

        String getExternalProductId();

        void setExternalProductId(String externalProductId);

        java.math.BigDecimal getQuantity();

        void setQuantity(java.math.BigDecimal quantity);

        java.math.BigDecimal getCancelQuantity();

        void setCancelQuantity(java.math.BigDecimal cancelQuantity);

        java.math.BigDecimal getSelectedAmount();

        void setSelectedAmount(java.math.BigDecimal selectedAmount);

        String getExternalId();

        void setExternalId(String externalId);

        String getOrderItemTypeId();

        void setOrderItemTypeId(String orderItemTypeId);

        String getOrderItemGroupSeqId();

        void setOrderItemGroupSeqId(String orderItemGroupSeqId);

        String getIsItemGroupPrimary();

        void setIsItemGroupPrimary(String isItemGroupPrimary);

        String getFromInventoryItemId();

        void setFromInventoryItemId(String fromInventoryItemId);

        String getIsPromo();

        void setIsPromo(String isPromo);

        String getQuoteId();

        void setQuoteId(String quoteId);

        String getQuoteItemSeqId();

        void setQuoteItemSeqId(String quoteItemSeqId);

        String getShoppingListId();

        void setShoppingListId(String shoppingListId);

        String getShoppingListItemSeqId();

        void setShoppingListItemSeqId(String shoppingListItemSeqId);

        java.math.BigDecimal getUnitPrice();

        void setUnitPrice(java.math.BigDecimal unitPrice);

        java.math.BigDecimal getUnitListPrice();

        void setUnitListPrice(java.math.BigDecimal unitListPrice);

        java.math.BigDecimal getUnitAverageCost();

        void setUnitAverageCost(java.math.BigDecimal unitAverageCost);

        java.math.BigDecimal getUnitRecurringPrice();

        void setUnitRecurringPrice(java.math.BigDecimal unitRecurringPrice);

        String getIsModifiedPrice();

        void setIsModifiedPrice(String isModifiedPrice);

        String getRecurringFreqUomId();

        void setRecurringFreqUomId(String recurringFreqUomId);

        String getItemDescription();

        void setItemDescription(String itemDescription);

        String getComments();

        void setComments(String comments);

        String getCorrespondingPoId();

        void setCorrespondingPoId(String correspondingPoId);

        String getStatusId();

        void setStatusId(String statusId);

        String getSyncStatusId();

        void setSyncStatusId(String syncStatusId);

        java.sql.Timestamp getEstimatedShipDate();

        void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate);

        java.sql.Timestamp getEstimatedDeliveryDate();

        void setEstimatedDeliveryDate(java.sql.Timestamp estimatedDeliveryDate);

        java.sql.Timestamp getAutoCancelDate();

        void setAutoCancelDate(java.sql.Timestamp autoCancelDate);

        java.sql.Timestamp getDontCancelSetDate();

        void setDontCancelSetDate(java.sql.Timestamp dontCancelSetDate);

        String getDontCancelSetBy();

        void setDontCancelSetBy(String dontCancelSetBy);

        java.sql.Timestamp getShipBeforeDate();

        void setShipBeforeDate(java.sql.Timestamp shipBeforeDate);

        java.sql.Timestamp getShipAfterDate();

        void setShipAfterDate(java.sql.Timestamp shipAfterDate);

        java.sql.Timestamp getCancelBackOrderDate();

        void setCancelBackOrderDate(java.sql.Timestamp cancelBackOrderDate);

        String getOverrideGlAccountId();

        void setOverrideGlAccountId(String overrideGlAccountId);

        Long getVersion();

        void setVersion(Long version);

        Boolean getActive();

        void setActive(Boolean active);

        String getOrderOrderTypeId();

        void setOrderOrderTypeId(String orderOrderTypeId);

        String getOrderOrderName();

        void setOrderOrderName(String orderOrderName);

        String getOrderExternalId();

        void setOrderExternalId(String orderExternalId);

        String getOrderSalesChannelEnumId();

        void setOrderSalesChannelEnumId(String orderSalesChannelEnumId);

        java.sql.Timestamp getOrderOrderDate();

        void setOrderOrderDate(java.sql.Timestamp orderOrderDate);

        String getOrderPriority();

        void setOrderPriority(String orderPriority);

        java.sql.Timestamp getOrderEntryDate();

        void setOrderEntryDate(java.sql.Timestamp orderEntryDate);

        java.sql.Timestamp getOrderPickSheetPrintedDate();

        void setOrderPickSheetPrintedDate(java.sql.Timestamp orderPickSheetPrintedDate);

        String getOrderStatusId();

        void setOrderStatusId(String orderStatusId);

        String getOrderCurrencyUom();

        void setOrderCurrencyUom(String orderCurrencyUom);

        String getOrderSyncStatusId();

        void setOrderSyncStatusId(String orderSyncStatusId);

        String getOrderBillingAccountId();

        void setOrderBillingAccountId(String orderBillingAccountId);

        String getOrderOriginFacilityId();

        void setOrderOriginFacilityId(String orderOriginFacilityId);

        String getOrderWebSiteId();

        void setOrderWebSiteId(String orderWebSiteId);

        String getOrderProductStoreId();

        void setOrderProductStoreId(String orderProductStoreId);

        String getOrderTerminalId();

        void setOrderTerminalId(String orderTerminalId);

        String getOrderTransactionId();

        void setOrderTransactionId(String orderTransactionId);

        String getOrderAutoOrderShoppingListId();

        void setOrderAutoOrderShoppingListId(String orderAutoOrderShoppingListId);

        String getOrderNeedsInventoryIssuance();

        void setOrderNeedsInventoryIssuance(String orderNeedsInventoryIssuance);

        String getOrderIsRushOrder();

        void setOrderIsRushOrder(String orderIsRushOrder);

        String getOrderInternalCode();

        void setOrderInternalCode(String orderInternalCode);

        java.math.BigDecimal getOrderRemainingSubTotal();

        void setOrderRemainingSubTotal(java.math.BigDecimal orderRemainingSubTotal);

        java.math.BigDecimal getOrderGrandTotal();

        void setOrderGrandTotal(java.math.BigDecimal orderGrandTotal);

        String getOrderInvoicePerShipment();

        void setOrderInvoicePerShipment(String orderInvoicePerShipment);

        String getOrderCreatedBy();

        void setOrderCreatedBy(String orderCreatedBy);

        Date getOrderCreatedAt();

        void setOrderCreatedAt(Date orderCreatedAt);

        String getOrderUpdatedBy();

        void setOrderUpdatedBy(String orderUpdatedBy);

        Date getOrderUpdatedAt();

        void setOrderUpdatedAt(Date orderUpdatedAt);

        Boolean getOrderActive();

        void setOrderActive(Boolean orderActive);

    }

    interface CreateOrderItemMvo extends CreateOrMergePatchOrderItemMvo
    {
    }

    interface MergePatchOrderItemMvo extends CreateOrMergePatchOrderItemMvo
    {
        Boolean getIsPropertyProductIdRemoved();

        void setIsPropertyProductIdRemoved(Boolean removed);

        Boolean getIsPropertyExternalProductIdRemoved();

        void setIsPropertyExternalProductIdRemoved(Boolean removed);

        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyCancelQuantityRemoved();

        void setIsPropertyCancelQuantityRemoved(Boolean removed);

        Boolean getIsPropertySelectedAmountRemoved();

        void setIsPropertySelectedAmountRemoved(Boolean removed);

        Boolean getIsPropertyExternalIdRemoved();

        void setIsPropertyExternalIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderItemTypeIdRemoved();

        void setIsPropertyOrderItemTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderItemGroupSeqIdRemoved();

        void setIsPropertyOrderItemGroupSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyIsItemGroupPrimaryRemoved();

        void setIsPropertyIsItemGroupPrimaryRemoved(Boolean removed);

        Boolean getIsPropertyFromInventoryItemIdRemoved();

        void setIsPropertyFromInventoryItemIdRemoved(Boolean removed);

        Boolean getIsPropertyIsPromoRemoved();

        void setIsPropertyIsPromoRemoved(Boolean removed);

        Boolean getIsPropertyQuoteIdRemoved();

        void setIsPropertyQuoteIdRemoved(Boolean removed);

        Boolean getIsPropertyQuoteItemSeqIdRemoved();

        void setIsPropertyQuoteItemSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyShoppingListIdRemoved();

        void setIsPropertyShoppingListIdRemoved(Boolean removed);

        Boolean getIsPropertyShoppingListItemSeqIdRemoved();

        void setIsPropertyShoppingListItemSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyUnitPriceRemoved();

        void setIsPropertyUnitPriceRemoved(Boolean removed);

        Boolean getIsPropertyUnitListPriceRemoved();

        void setIsPropertyUnitListPriceRemoved(Boolean removed);

        Boolean getIsPropertyUnitAverageCostRemoved();

        void setIsPropertyUnitAverageCostRemoved(Boolean removed);

        Boolean getIsPropertyUnitRecurringPriceRemoved();

        void setIsPropertyUnitRecurringPriceRemoved(Boolean removed);

        Boolean getIsPropertyIsModifiedPriceRemoved();

        void setIsPropertyIsModifiedPriceRemoved(Boolean removed);

        Boolean getIsPropertyRecurringFreqUomIdRemoved();

        void setIsPropertyRecurringFreqUomIdRemoved(Boolean removed);

        Boolean getIsPropertyItemDescriptionRemoved();

        void setIsPropertyItemDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyCommentsRemoved();

        void setIsPropertyCommentsRemoved(Boolean removed);

        Boolean getIsPropertyCorrespondingPoIdRemoved();

        void setIsPropertyCorrespondingPoIdRemoved(Boolean removed);

        Boolean getIsPropertyStatusIdRemoved();

        void setIsPropertyStatusIdRemoved(Boolean removed);

        Boolean getIsPropertySyncStatusIdRemoved();

        void setIsPropertySyncStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyEstimatedShipDateRemoved();

        void setIsPropertyEstimatedShipDateRemoved(Boolean removed);

        Boolean getIsPropertyEstimatedDeliveryDateRemoved();

        void setIsPropertyEstimatedDeliveryDateRemoved(Boolean removed);

        Boolean getIsPropertyAutoCancelDateRemoved();

        void setIsPropertyAutoCancelDateRemoved(Boolean removed);

        Boolean getIsPropertyDontCancelSetDateRemoved();

        void setIsPropertyDontCancelSetDateRemoved(Boolean removed);

        Boolean getIsPropertyDontCancelSetByRemoved();

        void setIsPropertyDontCancelSetByRemoved(Boolean removed);

        Boolean getIsPropertyShipBeforeDateRemoved();

        void setIsPropertyShipBeforeDateRemoved(Boolean removed);

        Boolean getIsPropertyShipAfterDateRemoved();

        void setIsPropertyShipAfterDateRemoved(Boolean removed);

        Boolean getIsPropertyCancelBackOrderDateRemoved();

        void setIsPropertyCancelBackOrderDateRemoved(Boolean removed);

        Boolean getIsPropertyOverrideGlAccountIdRemoved();

        void setIsPropertyOverrideGlAccountIdRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyOrderOrderTypeIdRemoved();

        void setIsPropertyOrderOrderTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderOrderNameRemoved();

        void setIsPropertyOrderOrderNameRemoved(Boolean removed);

        Boolean getIsPropertyOrderExternalIdRemoved();

        void setIsPropertyOrderExternalIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderSalesChannelEnumIdRemoved();

        void setIsPropertyOrderSalesChannelEnumIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderOrderDateRemoved();

        void setIsPropertyOrderOrderDateRemoved(Boolean removed);

        Boolean getIsPropertyOrderPriorityRemoved();

        void setIsPropertyOrderPriorityRemoved(Boolean removed);

        Boolean getIsPropertyOrderEntryDateRemoved();

        void setIsPropertyOrderEntryDateRemoved(Boolean removed);

        Boolean getIsPropertyOrderPickSheetPrintedDateRemoved();

        void setIsPropertyOrderPickSheetPrintedDateRemoved(Boolean removed);

        Boolean getIsPropertyOrderStatusIdRemoved();

        void setIsPropertyOrderStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderCurrencyUomRemoved();

        void setIsPropertyOrderCurrencyUomRemoved(Boolean removed);

        Boolean getIsPropertyOrderSyncStatusIdRemoved();

        void setIsPropertyOrderSyncStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderBillingAccountIdRemoved();

        void setIsPropertyOrderBillingAccountIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderOriginFacilityIdRemoved();

        void setIsPropertyOrderOriginFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderWebSiteIdRemoved();

        void setIsPropertyOrderWebSiteIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderProductStoreIdRemoved();

        void setIsPropertyOrderProductStoreIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderTerminalIdRemoved();

        void setIsPropertyOrderTerminalIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderTransactionIdRemoved();

        void setIsPropertyOrderTransactionIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderAutoOrderShoppingListIdRemoved();

        void setIsPropertyOrderAutoOrderShoppingListIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderNeedsInventoryIssuanceRemoved();

        void setIsPropertyOrderNeedsInventoryIssuanceRemoved(Boolean removed);

        Boolean getIsPropertyOrderIsRushOrderRemoved();

        void setIsPropertyOrderIsRushOrderRemoved(Boolean removed);

        Boolean getIsPropertyOrderInternalCodeRemoved();

        void setIsPropertyOrderInternalCodeRemoved(Boolean removed);

        Boolean getIsPropertyOrderRemainingSubTotalRemoved();

        void setIsPropertyOrderRemainingSubTotalRemoved(Boolean removed);

        Boolean getIsPropertyOrderGrandTotalRemoved();

        void setIsPropertyOrderGrandTotalRemoved(Boolean removed);

        Boolean getIsPropertyOrderInvoicePerShipmentRemoved();

        void setIsPropertyOrderInvoicePerShipmentRemoved(Boolean removed);

        Boolean getIsPropertyOrderCreatedByRemoved();

        void setIsPropertyOrderCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyOrderCreatedAtRemoved();

        void setIsPropertyOrderCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyOrderUpdatedByRemoved();

        void setIsPropertyOrderUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyOrderUpdatedAtRemoved();

        void setIsPropertyOrderUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyOrderActiveRemoved();

        void setIsPropertyOrderActiveRemoved(Boolean removed);

    }

	interface DeleteOrderItemMvo extends OrderItemMvoCommand
	{
	}

}

