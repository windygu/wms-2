package org.dddml.wms.domain.orderitemmvo;

import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class OrderItemMvoStateEventDto extends AbstractEvent
{

    private OrderItemMvoEventId orderItemMvoEventId;

    OrderItemMvoEventId getOrderItemMvoEventId() {
        if (orderItemMvoEventId == null) { orderItemMvoEventId = new OrderItemMvoEventId(); }
        return orderItemMvoEventId;
    }

    void setOrderItemMvoEventId(OrderItemMvoEventId eventId) {
        this.orderItemMvoEventId = eventId;
    }

    public OrderItemId getOrderItemId() {
        return getOrderItemMvoEventId().getOrderItemId();
    }

    public void setOrderItemId(OrderItemId orderItemId) {
        getOrderItemMvoEventId().setOrderItemId(orderItemId);
    }

    public Long getOrderVersion() {
        return getOrderItemMvoEventId().getOrderVersion();
    }
    
    public void getOrderVersion(Long orderVersion) {
        getOrderItemMvoEventId().setOrderVersion(orderVersion);
    }

    private String productId;

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    private String externalProductId;

    public String getExternalProductId() {
        return this.externalProductId;
    }

    public void setExternalProductId(String externalProductId) {
        this.externalProductId = externalProductId;
    }

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity) {
        this.quantity = quantity;
    }

    private java.math.BigDecimal cancelQuantity;

    public java.math.BigDecimal getCancelQuantity() {
        return this.cancelQuantity;
    }

    public void setCancelQuantity(java.math.BigDecimal cancelQuantity) {
        this.cancelQuantity = cancelQuantity;
    }

    private java.math.BigDecimal selectedAmount;

    public java.math.BigDecimal getSelectedAmount() {
        return this.selectedAmount;
    }

    public void setSelectedAmount(java.math.BigDecimal selectedAmount) {
        this.selectedAmount = selectedAmount;
    }

    private String externalId;

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    private String orderItemTypeId;

    public String getOrderItemTypeId() {
        return this.orderItemTypeId;
    }

    public void setOrderItemTypeId(String orderItemTypeId) {
        this.orderItemTypeId = orderItemTypeId;
    }

    private String orderItemGroupSeqId;

    public String getOrderItemGroupSeqId() {
        return this.orderItemGroupSeqId;
    }

    public void setOrderItemGroupSeqId(String orderItemGroupSeqId) {
        this.orderItemGroupSeqId = orderItemGroupSeqId;
    }

    private String isItemGroupPrimary;

    public String getIsItemGroupPrimary() {
        return this.isItemGroupPrimary;
    }

    public void setIsItemGroupPrimary(String isItemGroupPrimary) {
        this.isItemGroupPrimary = isItemGroupPrimary;
    }

    private String fromInventoryItemId;

    public String getFromInventoryItemId() {
        return this.fromInventoryItemId;
    }

    public void setFromInventoryItemId(String fromInventoryItemId) {
        this.fromInventoryItemId = fromInventoryItemId;
    }

    private String isPromo;

    public String getIsPromo() {
        return this.isPromo;
    }

    public void setIsPromo(String isPromo) {
        this.isPromo = isPromo;
    }

    private String quoteId;

    public String getQuoteId() {
        return this.quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    private String quoteItemSeqId;

    public String getQuoteItemSeqId() {
        return this.quoteItemSeqId;
    }

    public void setQuoteItemSeqId(String quoteItemSeqId) {
        this.quoteItemSeqId = quoteItemSeqId;
    }

    private String shoppingListId;

    public String getShoppingListId() {
        return this.shoppingListId;
    }

    public void setShoppingListId(String shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    private String shoppingListItemSeqId;

    public String getShoppingListItemSeqId() {
        return this.shoppingListItemSeqId;
    }

    public void setShoppingListItemSeqId(String shoppingListItemSeqId) {
        this.shoppingListItemSeqId = shoppingListItemSeqId;
    }

    private java.math.BigDecimal unitPrice;

    public java.math.BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(java.math.BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    private java.math.BigDecimal unitListPrice;

    public java.math.BigDecimal getUnitListPrice() {
        return this.unitListPrice;
    }

    public void setUnitListPrice(java.math.BigDecimal unitListPrice) {
        this.unitListPrice = unitListPrice;
    }

    private java.math.BigDecimal unitAverageCost;

    public java.math.BigDecimal getUnitAverageCost() {
        return this.unitAverageCost;
    }

    public void setUnitAverageCost(java.math.BigDecimal unitAverageCost) {
        this.unitAverageCost = unitAverageCost;
    }

    private java.math.BigDecimal unitRecurringPrice;

    public java.math.BigDecimal getUnitRecurringPrice() {
        return this.unitRecurringPrice;
    }

    public void setUnitRecurringPrice(java.math.BigDecimal unitRecurringPrice) {
        this.unitRecurringPrice = unitRecurringPrice;
    }

    private String isModifiedPrice;

    public String getIsModifiedPrice() {
        return this.isModifiedPrice;
    }

    public void setIsModifiedPrice(String isModifiedPrice) {
        this.isModifiedPrice = isModifiedPrice;
    }

    private String recurringFreqUomId;

    public String getRecurringFreqUomId() {
        return this.recurringFreqUomId;
    }

    public void setRecurringFreqUomId(String recurringFreqUomId) {
        this.recurringFreqUomId = recurringFreqUomId;
    }

    private String itemDescription;

    public String getItemDescription() {
        return this.itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    private String comments;

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    private String correspondingPoId;

    public String getCorrespondingPoId() {
        return this.correspondingPoId;
    }

    public void setCorrespondingPoId(String correspondingPoId) {
        this.correspondingPoId = correspondingPoId;
    }

    private String statusId;

    public String getStatusId() {
        return this.statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    private String syncStatusId;

    public String getSyncStatusId() {
        return this.syncStatusId;
    }

    public void setSyncStatusId(String syncStatusId) {
        this.syncStatusId = syncStatusId;
    }

    private java.sql.Timestamp estimatedShipDate;

    public java.sql.Timestamp getEstimatedShipDate() {
        return this.estimatedShipDate;
    }

    public void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate) {
        this.estimatedShipDate = estimatedShipDate;
    }

    private java.sql.Timestamp estimatedDeliveryDate;

    public java.sql.Timestamp getEstimatedDeliveryDate() {
        return this.estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(java.sql.Timestamp estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    private java.sql.Timestamp autoCancelDate;

    public java.sql.Timestamp getAutoCancelDate() {
        return this.autoCancelDate;
    }

    public void setAutoCancelDate(java.sql.Timestamp autoCancelDate) {
        this.autoCancelDate = autoCancelDate;
    }

    private java.sql.Timestamp dontCancelSetDate;

    public java.sql.Timestamp getDontCancelSetDate() {
        return this.dontCancelSetDate;
    }

    public void setDontCancelSetDate(java.sql.Timestamp dontCancelSetDate) {
        this.dontCancelSetDate = dontCancelSetDate;
    }

    private String dontCancelSetBy;

    public String getDontCancelSetBy() {
        return this.dontCancelSetBy;
    }

    public void setDontCancelSetBy(String dontCancelSetBy) {
        this.dontCancelSetBy = dontCancelSetBy;
    }

    private java.sql.Timestamp shipBeforeDate;

    public java.sql.Timestamp getShipBeforeDate() {
        return this.shipBeforeDate;
    }

    public void setShipBeforeDate(java.sql.Timestamp shipBeforeDate) {
        this.shipBeforeDate = shipBeforeDate;
    }

    private java.sql.Timestamp shipAfterDate;

    public java.sql.Timestamp getShipAfterDate() {
        return this.shipAfterDate;
    }

    public void setShipAfterDate(java.sql.Timestamp shipAfterDate) {
        this.shipAfterDate = shipAfterDate;
    }

    private java.sql.Timestamp cancelBackOrderDate;

    public java.sql.Timestamp getCancelBackOrderDate() {
        return this.cancelBackOrderDate;
    }

    public void setCancelBackOrderDate(java.sql.Timestamp cancelBackOrderDate) {
        this.cancelBackOrderDate = cancelBackOrderDate;
    }

    private String overrideGlAccountId;

    public String getOverrideGlAccountId() {
        return this.overrideGlAccountId;
    }

    public void setOverrideGlAccountId(String overrideGlAccountId) {
        this.overrideGlAccountId = overrideGlAccountId;
    }

    private Long version;

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private String orderOrderTypeId;

    public String getOrderOrderTypeId() {
        return this.orderOrderTypeId;
    }

    public void setOrderOrderTypeId(String orderOrderTypeId) {
        this.orderOrderTypeId = orderOrderTypeId;
    }

    private String orderOrderName;

    public String getOrderOrderName() {
        return this.orderOrderName;
    }

    public void setOrderOrderName(String orderOrderName) {
        this.orderOrderName = orderOrderName;
    }

    private String orderExternalId;

    public String getOrderExternalId() {
        return this.orderExternalId;
    }

    public void setOrderExternalId(String orderExternalId) {
        this.orderExternalId = orderExternalId;
    }

    private String orderSalesChannelEnumId;

    public String getOrderSalesChannelEnumId() {
        return this.orderSalesChannelEnumId;
    }

    public void setOrderSalesChannelEnumId(String orderSalesChannelEnumId) {
        this.orderSalesChannelEnumId = orderSalesChannelEnumId;
    }

    private java.sql.Timestamp orderOrderDate;

    public java.sql.Timestamp getOrderOrderDate() {
        return this.orderOrderDate;
    }

    public void setOrderOrderDate(java.sql.Timestamp orderOrderDate) {
        this.orderOrderDate = orderOrderDate;
    }

    private String orderPriority;

    public String getOrderPriority() {
        return this.orderPriority;
    }

    public void setOrderPriority(String orderPriority) {
        this.orderPriority = orderPriority;
    }

    private java.sql.Timestamp orderEntryDate;

    public java.sql.Timestamp getOrderEntryDate() {
        return this.orderEntryDate;
    }

    public void setOrderEntryDate(java.sql.Timestamp orderEntryDate) {
        this.orderEntryDate = orderEntryDate;
    }

    private java.sql.Timestamp orderPickSheetPrintedDate;

    public java.sql.Timestamp getOrderPickSheetPrintedDate() {
        return this.orderPickSheetPrintedDate;
    }

    public void setOrderPickSheetPrintedDate(java.sql.Timestamp orderPickSheetPrintedDate) {
        this.orderPickSheetPrintedDate = orderPickSheetPrintedDate;
    }

    private String orderStatusId;

    public String getOrderStatusId() {
        return this.orderStatusId;
    }

    public void setOrderStatusId(String orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    private String orderCurrencyUom;

    public String getOrderCurrencyUom() {
        return this.orderCurrencyUom;
    }

    public void setOrderCurrencyUom(String orderCurrencyUom) {
        this.orderCurrencyUom = orderCurrencyUom;
    }

    private String orderSyncStatusId;

    public String getOrderSyncStatusId() {
        return this.orderSyncStatusId;
    }

    public void setOrderSyncStatusId(String orderSyncStatusId) {
        this.orderSyncStatusId = orderSyncStatusId;
    }

    private String orderBillingAccountId;

    public String getOrderBillingAccountId() {
        return this.orderBillingAccountId;
    }

    public void setOrderBillingAccountId(String orderBillingAccountId) {
        this.orderBillingAccountId = orderBillingAccountId;
    }

    private String orderOriginFacilityId;

    public String getOrderOriginFacilityId() {
        return this.orderOriginFacilityId;
    }

    public void setOrderOriginFacilityId(String orderOriginFacilityId) {
        this.orderOriginFacilityId = orderOriginFacilityId;
    }

    private String orderWebSiteId;

    public String getOrderWebSiteId() {
        return this.orderWebSiteId;
    }

    public void setOrderWebSiteId(String orderWebSiteId) {
        this.orderWebSiteId = orderWebSiteId;
    }

    private String orderProductStoreId;

    public String getOrderProductStoreId() {
        return this.orderProductStoreId;
    }

    public void setOrderProductStoreId(String orderProductStoreId) {
        this.orderProductStoreId = orderProductStoreId;
    }

    private String orderTerminalId;

    public String getOrderTerminalId() {
        return this.orderTerminalId;
    }

    public void setOrderTerminalId(String orderTerminalId) {
        this.orderTerminalId = orderTerminalId;
    }

    private String orderTransactionId;

    public String getOrderTransactionId() {
        return this.orderTransactionId;
    }

    public void setOrderTransactionId(String orderTransactionId) {
        this.orderTransactionId = orderTransactionId;
    }

    private String orderAutoOrderShoppingListId;

    public String getOrderAutoOrderShoppingListId() {
        return this.orderAutoOrderShoppingListId;
    }

    public void setOrderAutoOrderShoppingListId(String orderAutoOrderShoppingListId) {
        this.orderAutoOrderShoppingListId = orderAutoOrderShoppingListId;
    }

    private String orderNeedsInventoryIssuance;

    public String getOrderNeedsInventoryIssuance() {
        return this.orderNeedsInventoryIssuance;
    }

    public void setOrderNeedsInventoryIssuance(String orderNeedsInventoryIssuance) {
        this.orderNeedsInventoryIssuance = orderNeedsInventoryIssuance;
    }

    private String orderIsRushOrder;

    public String getOrderIsRushOrder() {
        return this.orderIsRushOrder;
    }

    public void setOrderIsRushOrder(String orderIsRushOrder) {
        this.orderIsRushOrder = orderIsRushOrder;
    }

    private String orderInternalCode;

    public String getOrderInternalCode() {
        return this.orderInternalCode;
    }

    public void setOrderInternalCode(String orderInternalCode) {
        this.orderInternalCode = orderInternalCode;
    }

    private java.math.BigDecimal orderRemainingSubTotal;

    public java.math.BigDecimal getOrderRemainingSubTotal() {
        return this.orderRemainingSubTotal;
    }

    public void setOrderRemainingSubTotal(java.math.BigDecimal orderRemainingSubTotal) {
        this.orderRemainingSubTotal = orderRemainingSubTotal;
    }

    private java.math.BigDecimal orderGrandTotal;

    public java.math.BigDecimal getOrderGrandTotal() {
        return this.orderGrandTotal;
    }

    public void setOrderGrandTotal(java.math.BigDecimal orderGrandTotal) {
        this.orderGrandTotal = orderGrandTotal;
    }

    private String orderInvoicePerShipment;

    public String getOrderInvoicePerShipment() {
        return this.orderInvoicePerShipment;
    }

    public void setOrderInvoicePerShipment(String orderInvoicePerShipment) {
        this.orderInvoicePerShipment = orderInvoicePerShipment;
    }

    private String orderCreatedBy;

    public String getOrderCreatedBy() {
        return this.orderCreatedBy;
    }

    public void setOrderCreatedBy(String orderCreatedBy) {
        this.orderCreatedBy = orderCreatedBy;
    }

    private Date orderCreatedAt;

    public Date getOrderCreatedAt() {
        return this.orderCreatedAt;
    }

    public void setOrderCreatedAt(Date orderCreatedAt) {
        this.orderCreatedAt = orderCreatedAt;
    }

    private String orderUpdatedBy;

    public String getOrderUpdatedBy() {
        return this.orderUpdatedBy;
    }

    public void setOrderUpdatedBy(String orderUpdatedBy) {
        this.orderUpdatedBy = orderUpdatedBy;
    }

    private Date orderUpdatedAt;

    public Date getOrderUpdatedAt() {
        return this.orderUpdatedAt;
    }

    public void setOrderUpdatedAt(Date orderUpdatedAt) {
        this.orderUpdatedAt = orderUpdatedAt;
    }

    private Boolean orderActive;

    public Boolean getOrderActive() {
        return this.orderActive;
    }

    public void setOrderActive(Boolean orderActive) {
        this.orderActive = orderActive;
    }

    private String createdBy;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private Boolean isPropertyProductIdRemoved;

    public Boolean getIsPropertyProductIdRemoved() {
        return this.isPropertyProductIdRemoved;
    }

    public void setIsPropertyProductIdRemoved(Boolean removed) {
        this.isPropertyProductIdRemoved = removed;
    }

    private Boolean isPropertyExternalProductIdRemoved;

    public Boolean getIsPropertyExternalProductIdRemoved() {
        return this.isPropertyExternalProductIdRemoved;
    }

    public void setIsPropertyExternalProductIdRemoved(Boolean removed) {
        this.isPropertyExternalProductIdRemoved = removed;
    }

    private Boolean isPropertyQuantityRemoved;

    public Boolean getIsPropertyQuantityRemoved() {
        return this.isPropertyQuantityRemoved;
    }

    public void setIsPropertyQuantityRemoved(Boolean removed) {
        this.isPropertyQuantityRemoved = removed;
    }

    private Boolean isPropertyCancelQuantityRemoved;

    public Boolean getIsPropertyCancelQuantityRemoved() {
        return this.isPropertyCancelQuantityRemoved;
    }

    public void setIsPropertyCancelQuantityRemoved(Boolean removed) {
        this.isPropertyCancelQuantityRemoved = removed;
    }

    private Boolean isPropertySelectedAmountRemoved;

    public Boolean getIsPropertySelectedAmountRemoved() {
        return this.isPropertySelectedAmountRemoved;
    }

    public void setIsPropertySelectedAmountRemoved(Boolean removed) {
        this.isPropertySelectedAmountRemoved = removed;
    }

    private Boolean isPropertyExternalIdRemoved;

    public Boolean getIsPropertyExternalIdRemoved() {
        return this.isPropertyExternalIdRemoved;
    }

    public void setIsPropertyExternalIdRemoved(Boolean removed) {
        this.isPropertyExternalIdRemoved = removed;
    }

    private Boolean isPropertyOrderItemTypeIdRemoved;

    public Boolean getIsPropertyOrderItemTypeIdRemoved() {
        return this.isPropertyOrderItemTypeIdRemoved;
    }

    public void setIsPropertyOrderItemTypeIdRemoved(Boolean removed) {
        this.isPropertyOrderItemTypeIdRemoved = removed;
    }

    private Boolean isPropertyOrderItemGroupSeqIdRemoved;

    public Boolean getIsPropertyOrderItemGroupSeqIdRemoved() {
        return this.isPropertyOrderItemGroupSeqIdRemoved;
    }

    public void setIsPropertyOrderItemGroupSeqIdRemoved(Boolean removed) {
        this.isPropertyOrderItemGroupSeqIdRemoved = removed;
    }

    private Boolean isPropertyIsItemGroupPrimaryRemoved;

    public Boolean getIsPropertyIsItemGroupPrimaryRemoved() {
        return this.isPropertyIsItemGroupPrimaryRemoved;
    }

    public void setIsPropertyIsItemGroupPrimaryRemoved(Boolean removed) {
        this.isPropertyIsItemGroupPrimaryRemoved = removed;
    }

    private Boolean isPropertyFromInventoryItemIdRemoved;

    public Boolean getIsPropertyFromInventoryItemIdRemoved() {
        return this.isPropertyFromInventoryItemIdRemoved;
    }

    public void setIsPropertyFromInventoryItemIdRemoved(Boolean removed) {
        this.isPropertyFromInventoryItemIdRemoved = removed;
    }

    private Boolean isPropertyIsPromoRemoved;

    public Boolean getIsPropertyIsPromoRemoved() {
        return this.isPropertyIsPromoRemoved;
    }

    public void setIsPropertyIsPromoRemoved(Boolean removed) {
        this.isPropertyIsPromoRemoved = removed;
    }

    private Boolean isPropertyQuoteIdRemoved;

    public Boolean getIsPropertyQuoteIdRemoved() {
        return this.isPropertyQuoteIdRemoved;
    }

    public void setIsPropertyQuoteIdRemoved(Boolean removed) {
        this.isPropertyQuoteIdRemoved = removed;
    }

    private Boolean isPropertyQuoteItemSeqIdRemoved;

    public Boolean getIsPropertyQuoteItemSeqIdRemoved() {
        return this.isPropertyQuoteItemSeqIdRemoved;
    }

    public void setIsPropertyQuoteItemSeqIdRemoved(Boolean removed) {
        this.isPropertyQuoteItemSeqIdRemoved = removed;
    }

    private Boolean isPropertyShoppingListIdRemoved;

    public Boolean getIsPropertyShoppingListIdRemoved() {
        return this.isPropertyShoppingListIdRemoved;
    }

    public void setIsPropertyShoppingListIdRemoved(Boolean removed) {
        this.isPropertyShoppingListIdRemoved = removed;
    }

    private Boolean isPropertyShoppingListItemSeqIdRemoved;

    public Boolean getIsPropertyShoppingListItemSeqIdRemoved() {
        return this.isPropertyShoppingListItemSeqIdRemoved;
    }

    public void setIsPropertyShoppingListItemSeqIdRemoved(Boolean removed) {
        this.isPropertyShoppingListItemSeqIdRemoved = removed;
    }

    private Boolean isPropertyUnitPriceRemoved;

    public Boolean getIsPropertyUnitPriceRemoved() {
        return this.isPropertyUnitPriceRemoved;
    }

    public void setIsPropertyUnitPriceRemoved(Boolean removed) {
        this.isPropertyUnitPriceRemoved = removed;
    }

    private Boolean isPropertyUnitListPriceRemoved;

    public Boolean getIsPropertyUnitListPriceRemoved() {
        return this.isPropertyUnitListPriceRemoved;
    }

    public void setIsPropertyUnitListPriceRemoved(Boolean removed) {
        this.isPropertyUnitListPriceRemoved = removed;
    }

    private Boolean isPropertyUnitAverageCostRemoved;

    public Boolean getIsPropertyUnitAverageCostRemoved() {
        return this.isPropertyUnitAverageCostRemoved;
    }

    public void setIsPropertyUnitAverageCostRemoved(Boolean removed) {
        this.isPropertyUnitAverageCostRemoved = removed;
    }

    private Boolean isPropertyUnitRecurringPriceRemoved;

    public Boolean getIsPropertyUnitRecurringPriceRemoved() {
        return this.isPropertyUnitRecurringPriceRemoved;
    }

    public void setIsPropertyUnitRecurringPriceRemoved(Boolean removed) {
        this.isPropertyUnitRecurringPriceRemoved = removed;
    }

    private Boolean isPropertyIsModifiedPriceRemoved;

    public Boolean getIsPropertyIsModifiedPriceRemoved() {
        return this.isPropertyIsModifiedPriceRemoved;
    }

    public void setIsPropertyIsModifiedPriceRemoved(Boolean removed) {
        this.isPropertyIsModifiedPriceRemoved = removed;
    }

    private Boolean isPropertyRecurringFreqUomIdRemoved;

    public Boolean getIsPropertyRecurringFreqUomIdRemoved() {
        return this.isPropertyRecurringFreqUomIdRemoved;
    }

    public void setIsPropertyRecurringFreqUomIdRemoved(Boolean removed) {
        this.isPropertyRecurringFreqUomIdRemoved = removed;
    }

    private Boolean isPropertyItemDescriptionRemoved;

    public Boolean getIsPropertyItemDescriptionRemoved() {
        return this.isPropertyItemDescriptionRemoved;
    }

    public void setIsPropertyItemDescriptionRemoved(Boolean removed) {
        this.isPropertyItemDescriptionRemoved = removed;
    }

    private Boolean isPropertyCommentsRemoved;

    public Boolean getIsPropertyCommentsRemoved() {
        return this.isPropertyCommentsRemoved;
    }

    public void setIsPropertyCommentsRemoved(Boolean removed) {
        this.isPropertyCommentsRemoved = removed;
    }

    private Boolean isPropertyCorrespondingPoIdRemoved;

    public Boolean getIsPropertyCorrespondingPoIdRemoved() {
        return this.isPropertyCorrespondingPoIdRemoved;
    }

    public void setIsPropertyCorrespondingPoIdRemoved(Boolean removed) {
        this.isPropertyCorrespondingPoIdRemoved = removed;
    }

    private Boolean isPropertyStatusIdRemoved;

    public Boolean getIsPropertyStatusIdRemoved() {
        return this.isPropertyStatusIdRemoved;
    }

    public void setIsPropertyStatusIdRemoved(Boolean removed) {
        this.isPropertyStatusIdRemoved = removed;
    }

    private Boolean isPropertySyncStatusIdRemoved;

    public Boolean getIsPropertySyncStatusIdRemoved() {
        return this.isPropertySyncStatusIdRemoved;
    }

    public void setIsPropertySyncStatusIdRemoved(Boolean removed) {
        this.isPropertySyncStatusIdRemoved = removed;
    }

    private Boolean isPropertyEstimatedShipDateRemoved;

    public Boolean getIsPropertyEstimatedShipDateRemoved() {
        return this.isPropertyEstimatedShipDateRemoved;
    }

    public void setIsPropertyEstimatedShipDateRemoved(Boolean removed) {
        this.isPropertyEstimatedShipDateRemoved = removed;
    }

    private Boolean isPropertyEstimatedDeliveryDateRemoved;

    public Boolean getIsPropertyEstimatedDeliveryDateRemoved() {
        return this.isPropertyEstimatedDeliveryDateRemoved;
    }

    public void setIsPropertyEstimatedDeliveryDateRemoved(Boolean removed) {
        this.isPropertyEstimatedDeliveryDateRemoved = removed;
    }

    private Boolean isPropertyAutoCancelDateRemoved;

    public Boolean getIsPropertyAutoCancelDateRemoved() {
        return this.isPropertyAutoCancelDateRemoved;
    }

    public void setIsPropertyAutoCancelDateRemoved(Boolean removed) {
        this.isPropertyAutoCancelDateRemoved = removed;
    }

    private Boolean isPropertyDontCancelSetDateRemoved;

    public Boolean getIsPropertyDontCancelSetDateRemoved() {
        return this.isPropertyDontCancelSetDateRemoved;
    }

    public void setIsPropertyDontCancelSetDateRemoved(Boolean removed) {
        this.isPropertyDontCancelSetDateRemoved = removed;
    }

    private Boolean isPropertyDontCancelSetByRemoved;

    public Boolean getIsPropertyDontCancelSetByRemoved() {
        return this.isPropertyDontCancelSetByRemoved;
    }

    public void setIsPropertyDontCancelSetByRemoved(Boolean removed) {
        this.isPropertyDontCancelSetByRemoved = removed;
    }

    private Boolean isPropertyShipBeforeDateRemoved;

    public Boolean getIsPropertyShipBeforeDateRemoved() {
        return this.isPropertyShipBeforeDateRemoved;
    }

    public void setIsPropertyShipBeforeDateRemoved(Boolean removed) {
        this.isPropertyShipBeforeDateRemoved = removed;
    }

    private Boolean isPropertyShipAfterDateRemoved;

    public Boolean getIsPropertyShipAfterDateRemoved() {
        return this.isPropertyShipAfterDateRemoved;
    }

    public void setIsPropertyShipAfterDateRemoved(Boolean removed) {
        this.isPropertyShipAfterDateRemoved = removed;
    }

    private Boolean isPropertyCancelBackOrderDateRemoved;

    public Boolean getIsPropertyCancelBackOrderDateRemoved() {
        return this.isPropertyCancelBackOrderDateRemoved;
    }

    public void setIsPropertyCancelBackOrderDateRemoved(Boolean removed) {
        this.isPropertyCancelBackOrderDateRemoved = removed;
    }

    private Boolean isPropertyOverrideGlAccountIdRemoved;

    public Boolean getIsPropertyOverrideGlAccountIdRemoved() {
        return this.isPropertyOverrideGlAccountIdRemoved;
    }

    public void setIsPropertyOverrideGlAccountIdRemoved(Boolean removed) {
        this.isPropertyOverrideGlAccountIdRemoved = removed;
    }

    private Boolean isPropertyVersionRemoved;

    public Boolean getIsPropertyVersionRemoved() {
        return this.isPropertyVersionRemoved;
    }

    public void setIsPropertyVersionRemoved(Boolean removed) {
        this.isPropertyVersionRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }

    private Boolean isPropertyOrderOrderTypeIdRemoved;

    public Boolean getIsPropertyOrderOrderTypeIdRemoved() {
        return this.isPropertyOrderOrderTypeIdRemoved;
    }

    public void setIsPropertyOrderOrderTypeIdRemoved(Boolean removed) {
        this.isPropertyOrderOrderTypeIdRemoved = removed;
    }

    private Boolean isPropertyOrderOrderNameRemoved;

    public Boolean getIsPropertyOrderOrderNameRemoved() {
        return this.isPropertyOrderOrderNameRemoved;
    }

    public void setIsPropertyOrderOrderNameRemoved(Boolean removed) {
        this.isPropertyOrderOrderNameRemoved = removed;
    }

    private Boolean isPropertyOrderExternalIdRemoved;

    public Boolean getIsPropertyOrderExternalIdRemoved() {
        return this.isPropertyOrderExternalIdRemoved;
    }

    public void setIsPropertyOrderExternalIdRemoved(Boolean removed) {
        this.isPropertyOrderExternalIdRemoved = removed;
    }

    private Boolean isPropertyOrderSalesChannelEnumIdRemoved;

    public Boolean getIsPropertyOrderSalesChannelEnumIdRemoved() {
        return this.isPropertyOrderSalesChannelEnumIdRemoved;
    }

    public void setIsPropertyOrderSalesChannelEnumIdRemoved(Boolean removed) {
        this.isPropertyOrderSalesChannelEnumIdRemoved = removed;
    }

    private Boolean isPropertyOrderOrderDateRemoved;

    public Boolean getIsPropertyOrderOrderDateRemoved() {
        return this.isPropertyOrderOrderDateRemoved;
    }

    public void setIsPropertyOrderOrderDateRemoved(Boolean removed) {
        this.isPropertyOrderOrderDateRemoved = removed;
    }

    private Boolean isPropertyOrderPriorityRemoved;

    public Boolean getIsPropertyOrderPriorityRemoved() {
        return this.isPropertyOrderPriorityRemoved;
    }

    public void setIsPropertyOrderPriorityRemoved(Boolean removed) {
        this.isPropertyOrderPriorityRemoved = removed;
    }

    private Boolean isPropertyOrderEntryDateRemoved;

    public Boolean getIsPropertyOrderEntryDateRemoved() {
        return this.isPropertyOrderEntryDateRemoved;
    }

    public void setIsPropertyOrderEntryDateRemoved(Boolean removed) {
        this.isPropertyOrderEntryDateRemoved = removed;
    }

    private Boolean isPropertyOrderPickSheetPrintedDateRemoved;

    public Boolean getIsPropertyOrderPickSheetPrintedDateRemoved() {
        return this.isPropertyOrderPickSheetPrintedDateRemoved;
    }

    public void setIsPropertyOrderPickSheetPrintedDateRemoved(Boolean removed) {
        this.isPropertyOrderPickSheetPrintedDateRemoved = removed;
    }

    private Boolean isPropertyOrderStatusIdRemoved;

    public Boolean getIsPropertyOrderStatusIdRemoved() {
        return this.isPropertyOrderStatusIdRemoved;
    }

    public void setIsPropertyOrderStatusIdRemoved(Boolean removed) {
        this.isPropertyOrderStatusIdRemoved = removed;
    }

    private Boolean isPropertyOrderCurrencyUomRemoved;

    public Boolean getIsPropertyOrderCurrencyUomRemoved() {
        return this.isPropertyOrderCurrencyUomRemoved;
    }

    public void setIsPropertyOrderCurrencyUomRemoved(Boolean removed) {
        this.isPropertyOrderCurrencyUomRemoved = removed;
    }

    private Boolean isPropertyOrderSyncStatusIdRemoved;

    public Boolean getIsPropertyOrderSyncStatusIdRemoved() {
        return this.isPropertyOrderSyncStatusIdRemoved;
    }

    public void setIsPropertyOrderSyncStatusIdRemoved(Boolean removed) {
        this.isPropertyOrderSyncStatusIdRemoved = removed;
    }

    private Boolean isPropertyOrderBillingAccountIdRemoved;

    public Boolean getIsPropertyOrderBillingAccountIdRemoved() {
        return this.isPropertyOrderBillingAccountIdRemoved;
    }

    public void setIsPropertyOrderBillingAccountIdRemoved(Boolean removed) {
        this.isPropertyOrderBillingAccountIdRemoved = removed;
    }

    private Boolean isPropertyOrderOriginFacilityIdRemoved;

    public Boolean getIsPropertyOrderOriginFacilityIdRemoved() {
        return this.isPropertyOrderOriginFacilityIdRemoved;
    }

    public void setIsPropertyOrderOriginFacilityIdRemoved(Boolean removed) {
        this.isPropertyOrderOriginFacilityIdRemoved = removed;
    }

    private Boolean isPropertyOrderWebSiteIdRemoved;

    public Boolean getIsPropertyOrderWebSiteIdRemoved() {
        return this.isPropertyOrderWebSiteIdRemoved;
    }

    public void setIsPropertyOrderWebSiteIdRemoved(Boolean removed) {
        this.isPropertyOrderWebSiteIdRemoved = removed;
    }

    private Boolean isPropertyOrderProductStoreIdRemoved;

    public Boolean getIsPropertyOrderProductStoreIdRemoved() {
        return this.isPropertyOrderProductStoreIdRemoved;
    }

    public void setIsPropertyOrderProductStoreIdRemoved(Boolean removed) {
        this.isPropertyOrderProductStoreIdRemoved = removed;
    }

    private Boolean isPropertyOrderTerminalIdRemoved;

    public Boolean getIsPropertyOrderTerminalIdRemoved() {
        return this.isPropertyOrderTerminalIdRemoved;
    }

    public void setIsPropertyOrderTerminalIdRemoved(Boolean removed) {
        this.isPropertyOrderTerminalIdRemoved = removed;
    }

    private Boolean isPropertyOrderTransactionIdRemoved;

    public Boolean getIsPropertyOrderTransactionIdRemoved() {
        return this.isPropertyOrderTransactionIdRemoved;
    }

    public void setIsPropertyOrderTransactionIdRemoved(Boolean removed) {
        this.isPropertyOrderTransactionIdRemoved = removed;
    }

    private Boolean isPropertyOrderAutoOrderShoppingListIdRemoved;

    public Boolean getIsPropertyOrderAutoOrderShoppingListIdRemoved() {
        return this.isPropertyOrderAutoOrderShoppingListIdRemoved;
    }

    public void setIsPropertyOrderAutoOrderShoppingListIdRemoved(Boolean removed) {
        this.isPropertyOrderAutoOrderShoppingListIdRemoved = removed;
    }

    private Boolean isPropertyOrderNeedsInventoryIssuanceRemoved;

    public Boolean getIsPropertyOrderNeedsInventoryIssuanceRemoved() {
        return this.isPropertyOrderNeedsInventoryIssuanceRemoved;
    }

    public void setIsPropertyOrderNeedsInventoryIssuanceRemoved(Boolean removed) {
        this.isPropertyOrderNeedsInventoryIssuanceRemoved = removed;
    }

    private Boolean isPropertyOrderIsRushOrderRemoved;

    public Boolean getIsPropertyOrderIsRushOrderRemoved() {
        return this.isPropertyOrderIsRushOrderRemoved;
    }

    public void setIsPropertyOrderIsRushOrderRemoved(Boolean removed) {
        this.isPropertyOrderIsRushOrderRemoved = removed;
    }

    private Boolean isPropertyOrderInternalCodeRemoved;

    public Boolean getIsPropertyOrderInternalCodeRemoved() {
        return this.isPropertyOrderInternalCodeRemoved;
    }

    public void setIsPropertyOrderInternalCodeRemoved(Boolean removed) {
        this.isPropertyOrderInternalCodeRemoved = removed;
    }

    private Boolean isPropertyOrderRemainingSubTotalRemoved;

    public Boolean getIsPropertyOrderRemainingSubTotalRemoved() {
        return this.isPropertyOrderRemainingSubTotalRemoved;
    }

    public void setIsPropertyOrderRemainingSubTotalRemoved(Boolean removed) {
        this.isPropertyOrderRemainingSubTotalRemoved = removed;
    }

    private Boolean isPropertyOrderGrandTotalRemoved;

    public Boolean getIsPropertyOrderGrandTotalRemoved() {
        return this.isPropertyOrderGrandTotalRemoved;
    }

    public void setIsPropertyOrderGrandTotalRemoved(Boolean removed) {
        this.isPropertyOrderGrandTotalRemoved = removed;
    }

    private Boolean isPropertyOrderInvoicePerShipmentRemoved;

    public Boolean getIsPropertyOrderInvoicePerShipmentRemoved() {
        return this.isPropertyOrderInvoicePerShipmentRemoved;
    }

    public void setIsPropertyOrderInvoicePerShipmentRemoved(Boolean removed) {
        this.isPropertyOrderInvoicePerShipmentRemoved = removed;
    }

    private Boolean isPropertyOrderCreatedByRemoved;

    public Boolean getIsPropertyOrderCreatedByRemoved() {
        return this.isPropertyOrderCreatedByRemoved;
    }

    public void setIsPropertyOrderCreatedByRemoved(Boolean removed) {
        this.isPropertyOrderCreatedByRemoved = removed;
    }

    private Boolean isPropertyOrderCreatedAtRemoved;

    public Boolean getIsPropertyOrderCreatedAtRemoved() {
        return this.isPropertyOrderCreatedAtRemoved;
    }

    public void setIsPropertyOrderCreatedAtRemoved(Boolean removed) {
        this.isPropertyOrderCreatedAtRemoved = removed;
    }

    private Boolean isPropertyOrderUpdatedByRemoved;

    public Boolean getIsPropertyOrderUpdatedByRemoved() {
        return this.isPropertyOrderUpdatedByRemoved;
    }

    public void setIsPropertyOrderUpdatedByRemoved(Boolean removed) {
        this.isPropertyOrderUpdatedByRemoved = removed;
    }

    private Boolean isPropertyOrderUpdatedAtRemoved;

    public Boolean getIsPropertyOrderUpdatedAtRemoved() {
        return this.isPropertyOrderUpdatedAtRemoved;
    }

    public void setIsPropertyOrderUpdatedAtRemoved(Boolean removed) {
        this.isPropertyOrderUpdatedAtRemoved = removed;
    }

    private Boolean isPropertyOrderActiveRemoved;

    public Boolean getIsPropertyOrderActiveRemoved() {
        return this.isPropertyOrderActiveRemoved;
    }

    public void setIsPropertyOrderActiveRemoved(Boolean removed) {
        this.isPropertyOrderActiveRemoved = removed;
    }


	public static class OrderItemMvoStateCreatedDto extends OrderItemMvoStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class OrderItemMvoStateMergePatchedDto extends OrderItemMvoStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class OrderItemMvoStateDeletedDto extends OrderItemMvoStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

