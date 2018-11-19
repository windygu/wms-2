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

    String getOrderTypeId();

    String getOrderName();

    String getExternalId();

    String getSalesChannelEnumId();

    java.sql.Timestamp getOrderDate();

    String getPriority();

    java.sql.Timestamp getEntryDate();

    java.sql.Timestamp getPickSheetPrintedDate();

    String getStatusId();

    String getCurrencyUomId();

    String getSyncStatusId();

    String getBillingAccountId();

    String getOriginFacilityId();

    String getWebSiteId();

    String getProductStoreId();

    String getTerminalId();

    String getTransactionId();

    String getAutoOrderShoppingListId();

    String getNeedsInventoryIssuance();

    String getIsRushOrder();

    String getInternalCode();

    java.math.BigDecimal getRemainingSubTotal();

    java.math.BigDecimal getGrandTotal();

    String getInvoicePerShipment();

    Boolean get_F_B_1_();

    Boolean get_F_B_2_();

    Boolean get_F_B_3_();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    EntityStateCollection<PartyRoleId, OrderRoleState> getOrderRoles();

    EntityStateCollection<String, OrderItemState> getOrderItems();

    EntityStateCollection<String, OrderShipGroupState> getOrderShipGroups();

    interface MutableOrderState extends OrderState {
        void setOrderId(String orderId);

        void setOrderTypeId(String orderTypeId);

        void setOrderName(String orderName);

        void setExternalId(String externalId);

        void setSalesChannelEnumId(String salesChannelEnumId);

        void setOrderDate(java.sql.Timestamp orderDate);

        void setPriority(String priority);

        void setEntryDate(java.sql.Timestamp entryDate);

        void setPickSheetPrintedDate(java.sql.Timestamp pickSheetPrintedDate);

        void setStatusId(String statusId);

        void setCurrencyUomId(String currencyUomId);

        void setSyncStatusId(String syncStatusId);

        void setBillingAccountId(String billingAccountId);

        void setOriginFacilityId(String originFacilityId);

        void setWebSiteId(String webSiteId);

        void setProductStoreId(String productStoreId);

        void setTerminalId(String terminalId);

        void setTransactionId(String transactionId);

        void setAutoOrderShoppingListId(String autoOrderShoppingListId);

        void setNeedsInventoryIssuance(String needsInventoryIssuance);

        void setIsRushOrder(String isRushOrder);

        void setInternalCode(String internalCode);

        void setRemainingSubTotal(java.math.BigDecimal remainingSubTotal);

        void setGrandTotal(java.math.BigDecimal grandTotal);

        void setInvoicePerShipment(String invoicePerShipment);

        void set_F_B_1_(Boolean _F_B_1_);

        void set_F_B_2_(Boolean _F_B_2_);

        void set_F_B_3_(Boolean _F_B_3_);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);


        void mutate(Event e);

        void when(OrderEvent.OrderStateCreated e);

        void when(OrderEvent.OrderStateMergePatched e);

    }

    interface SqlOrderState extends MutableOrderState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

