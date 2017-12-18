package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class OrderItemStateEventDto extends AbstractStateEvent
{

    private OrderItemStateEventIdDto stateEventId;

    OrderItemStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new OrderItemStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(OrderItemStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }

    public String getOrderItemSeqId() {
        return getStateEventId().getOrderItemSeqId();
    }

    public void setOrderItemSeqId(String orderItemSeqId) {
        getStateEventId().setOrderItemSeqId(orderItemSeqId);
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

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    private Long version;

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
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

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class OrderItemStateCreatedDto extends OrderItemStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class OrderItemStateMergePatchedDto extends OrderItemStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class OrderItemStateRemovedDto extends OrderItemStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_REMOVED;
        }

	}


}

