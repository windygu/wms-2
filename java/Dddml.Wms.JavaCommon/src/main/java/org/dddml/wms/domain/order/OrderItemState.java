package org.dddml.wms.domain.order;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.order.OrderItemStateEvent.*;

public interface OrderItemState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    OrderItemId getOrderItemId();

    void setOrderItemId(OrderItemId orderItemId);

    String getOrderItemSeqId();

    void setOrderItemSeqId(String orderItemSeqId);

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

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getOrderId();

    void setOrderId(String orderId);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(OrderItemStateEvent.OrderItemStateCreated e);

    void when(OrderItemStateEvent.OrderItemStateMergePatched e);

    
}

