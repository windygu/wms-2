package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface OrderItemStateEvent extends Event
{
    OrderItemEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    Long getVersion();

    void setVersion(Long version);

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

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface OrderItemStateCreated extends OrderItemStateEvent
    {
    
    }


    interface OrderItemStateMergePatched extends OrderItemStateEvent
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

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }


}

