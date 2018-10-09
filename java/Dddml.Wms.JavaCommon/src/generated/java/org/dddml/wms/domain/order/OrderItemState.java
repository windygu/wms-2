package org.dddml.wms.domain.order;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.order.OrderItemEvent.*;

public interface OrderItemState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getOrderItemSeqId();

    String getProductId();

    String getExternalProductId();

    java.math.BigDecimal getQuantity();

    java.math.BigDecimal getCancelQuantity();

    java.math.BigDecimal getSelectedAmount();

    String getExternalId();

    String getOrderItemTypeId();

    String getOrderItemGroupSeqId();

    String getIsItemGroupPrimary();

    String getFromInventoryItemId();

    String getIsPromo();

    String getQuoteId();

    String getQuoteItemSeqId();

    String getShoppingListId();

    String getShoppingListItemSeqId();

    java.math.BigDecimal getUnitPrice();

    java.math.BigDecimal getUnitListPrice();

    java.math.BigDecimal getUnitAverageCost();

    java.math.BigDecimal getUnitRecurringPrice();

    String getIsModifiedPrice();

    String getRecurringFreqUomId();

    String getItemDescription();

    String getComments();

    String getCorrespondingPoId();

    String getStatusId();

    String getSyncStatusId();

    java.sql.Timestamp getEstimatedShipDate();

    java.sql.Timestamp getEstimatedDeliveryDate();

    java.sql.Timestamp getAutoCancelDate();

    java.sql.Timestamp getDontCancelSetDate();

    String getDontCancelSetBy();

    java.sql.Timestamp getShipBeforeDate();

    java.sql.Timestamp getShipAfterDate();

    java.sql.Timestamp getCancelBackOrderDate();

    String getOverrideGlAccountId();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    String getOrderId();

    interface MutableOrderItemState extends OrderItemState {
        void setOrderItemId(OrderItemId orderItemId);

        void setOrderItemSeqId(String orderItemSeqId);

        void setProductId(String productId);

        void setExternalProductId(String externalProductId);

        void setQuantity(java.math.BigDecimal quantity);

        void setCancelQuantity(java.math.BigDecimal cancelQuantity);

        void setSelectedAmount(java.math.BigDecimal selectedAmount);

        void setExternalId(String externalId);

        void setOrderItemTypeId(String orderItemTypeId);

        void setOrderItemGroupSeqId(String orderItemGroupSeqId);

        void setIsItemGroupPrimary(String isItemGroupPrimary);

        void setFromInventoryItemId(String fromInventoryItemId);

        void setIsPromo(String isPromo);

        void setQuoteId(String quoteId);

        void setQuoteItemSeqId(String quoteItemSeqId);

        void setShoppingListId(String shoppingListId);

        void setShoppingListItemSeqId(String shoppingListItemSeqId);

        void setUnitPrice(java.math.BigDecimal unitPrice);

        void setUnitListPrice(java.math.BigDecimal unitListPrice);

        void setUnitAverageCost(java.math.BigDecimal unitAverageCost);

        void setUnitRecurringPrice(java.math.BigDecimal unitRecurringPrice);

        void setIsModifiedPrice(String isModifiedPrice);

        void setRecurringFreqUomId(String recurringFreqUomId);

        void setItemDescription(String itemDescription);

        void setComments(String comments);

        void setCorrespondingPoId(String correspondingPoId);

        void setStatusId(String statusId);

        void setSyncStatusId(String syncStatusId);

        void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate);

        void setEstimatedDeliveryDate(java.sql.Timestamp estimatedDeliveryDate);

        void setAutoCancelDate(java.sql.Timestamp autoCancelDate);

        void setDontCancelSetDate(java.sql.Timestamp dontCancelSetDate);

        void setDontCancelSetBy(String dontCancelSetBy);

        void setShipBeforeDate(java.sql.Timestamp shipBeforeDate);

        void setShipAfterDate(java.sql.Timestamp shipAfterDate);

        void setCancelBackOrderDate(java.sql.Timestamp cancelBackOrderDate);

        void setOverrideGlAccountId(String overrideGlAccountId);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setOrderId(String orderId);


        void mutate(Event e);

        void when(OrderItemEvent.OrderItemStateCreated e);

        void when(OrderItemEvent.OrderItemStateMergePatched e);

    }

    interface SqlOrderItemState extends MutableOrderItemState {
        OrderItemId getOrderItemId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

