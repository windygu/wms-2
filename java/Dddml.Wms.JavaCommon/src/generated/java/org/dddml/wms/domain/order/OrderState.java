package org.dddml.wms.domain.order;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.order.OrderEvent.*;

public interface OrderState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getOrderId();

    void setOrderId(String orderId);

    String getOrderTypeId();

    void setOrderTypeId(String orderTypeId);

    String getOrderName();

    void setOrderName(String orderName);

    String getExternalId();

    void setExternalId(String externalId);

    String getSalesChannelEnumId();

    void setSalesChannelEnumId(String salesChannelEnumId);

    java.sql.Timestamp getOrderDate();

    void setOrderDate(java.sql.Timestamp orderDate);

    String getPriority();

    void setPriority(String priority);

    java.sql.Timestamp getEntryDate();

    void setEntryDate(java.sql.Timestamp entryDate);

    java.sql.Timestamp getPickSheetPrintedDate();

    void setPickSheetPrintedDate(java.sql.Timestamp pickSheetPrintedDate);

    String getStatusId();

    void setStatusId(String statusId);

    String getCurrencyUomId();

    void setCurrencyUomId(String currencyUomId);

    String getSyncStatusId();

    void setSyncStatusId(String syncStatusId);

    String getBillingAccountId();

    void setBillingAccountId(String billingAccountId);

    String getOriginFacilityId();

    void setOriginFacilityId(String originFacilityId);

    String getWebSiteId();

    void setWebSiteId(String webSiteId);

    String getProductStoreId();

    void setProductStoreId(String productStoreId);

    String getTerminalId();

    void setTerminalId(String terminalId);

    String getTransactionId();

    void setTransactionId(String transactionId);

    String getAutoOrderShoppingListId();

    void setAutoOrderShoppingListId(String autoOrderShoppingListId);

    String getNeedsInventoryIssuance();

    void setNeedsInventoryIssuance(String needsInventoryIssuance);

    String getIsRushOrder();

    void setIsRushOrder(String isRushOrder);

    String getInternalCode();

    void setInternalCode(String internalCode);

    java.math.BigDecimal getRemainingSubTotal();

    void setRemainingSubTotal(java.math.BigDecimal remainingSubTotal);

    java.math.BigDecimal getGrandTotal();

    void setGrandTotal(java.math.BigDecimal grandTotal);

    String getInvoicePerShipment();

    void setInvoicePerShipment(String invoicePerShipment);

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


    boolean isStateUnsaved();

    boolean getForReapplying();

    OrderRoleStates getOrderRoles();

    OrderItemStates getOrderItems();

    OrderShipGroupStates getOrderShipGroups();


    void mutate(Event e);

    void when(OrderEvent.OrderStateCreated e);

    void when(OrderEvent.OrderStateMergePatched e);

    
}

