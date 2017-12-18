package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface OrderCommand extends Command
{
    String getOrderId();

    void setOrderId(String orderId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(OrderState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((OrderCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (isCommandCreate((OrderCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(OrderCommand c) {
        return ((c instanceof OrderCommand.CreateOrder) 
            && c.getVersion().equals(OrderState.VERSION_NULL));
    }

    interface CreateOrMergePatchOrder extends OrderCommand
    {
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

        String getCurrencyUom();

        void setCurrencyUom(String currencyUom);

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

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateOrder extends CreateOrMergePatchOrder
    {
        CreateOrderItemCommands getOrderItems();

        OrderItemCommand.CreateOrderItem newCreateOrderItem();

    }

    interface MergePatchOrder extends CreateOrMergePatchOrder
    {
        Boolean getIsPropertyOrderTypeIdRemoved();

        void setIsPropertyOrderTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderNameRemoved();

        void setIsPropertyOrderNameRemoved(Boolean removed);

        Boolean getIsPropertyExternalIdRemoved();

        void setIsPropertyExternalIdRemoved(Boolean removed);

        Boolean getIsPropertySalesChannelEnumIdRemoved();

        void setIsPropertySalesChannelEnumIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderDateRemoved();

        void setIsPropertyOrderDateRemoved(Boolean removed);

        Boolean getIsPropertyPriorityRemoved();

        void setIsPropertyPriorityRemoved(Boolean removed);

        Boolean getIsPropertyEntryDateRemoved();

        void setIsPropertyEntryDateRemoved(Boolean removed);

        Boolean getIsPropertyPickSheetPrintedDateRemoved();

        void setIsPropertyPickSheetPrintedDateRemoved(Boolean removed);

        Boolean getIsPropertyStatusIdRemoved();

        void setIsPropertyStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyCurrencyUomRemoved();

        void setIsPropertyCurrencyUomRemoved(Boolean removed);

        Boolean getIsPropertySyncStatusIdRemoved();

        void setIsPropertySyncStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyBillingAccountIdRemoved();

        void setIsPropertyBillingAccountIdRemoved(Boolean removed);

        Boolean getIsPropertyOriginFacilityIdRemoved();

        void setIsPropertyOriginFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyWebSiteIdRemoved();

        void setIsPropertyWebSiteIdRemoved(Boolean removed);

        Boolean getIsPropertyProductStoreIdRemoved();

        void setIsPropertyProductStoreIdRemoved(Boolean removed);

        Boolean getIsPropertyTerminalIdRemoved();

        void setIsPropertyTerminalIdRemoved(Boolean removed);

        Boolean getIsPropertyTransactionIdRemoved();

        void setIsPropertyTransactionIdRemoved(Boolean removed);

        Boolean getIsPropertyAutoOrderShoppingListIdRemoved();

        void setIsPropertyAutoOrderShoppingListIdRemoved(Boolean removed);

        Boolean getIsPropertyNeedsInventoryIssuanceRemoved();

        void setIsPropertyNeedsInventoryIssuanceRemoved(Boolean removed);

        Boolean getIsPropertyIsRushOrderRemoved();

        void setIsPropertyIsRushOrderRemoved(Boolean removed);

        Boolean getIsPropertyInternalCodeRemoved();

        void setIsPropertyInternalCodeRemoved(Boolean removed);

        Boolean getIsPropertyRemainingSubTotalRemoved();

        void setIsPropertyRemainingSubTotalRemoved(Boolean removed);

        Boolean getIsPropertyGrandTotalRemoved();

        void setIsPropertyGrandTotalRemoved(Boolean removed);

        Boolean getIsPropertyInvoicePerShipmentRemoved();

        void setIsPropertyInvoicePerShipmentRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        OrderItemCommands getOrderItemCommands();

        OrderItemCommand.CreateOrderItem newCreateOrderItem();

        OrderItemCommand.MergePatchOrderItem newMergePatchOrderItem();

        OrderItemCommand.RemoveOrderItem newRemoveOrderItem();

    }

	interface DeleteOrder extends OrderCommand
	{
	}

    interface CreateOrderItemCommands extends Iterable<OrderItemCommand.CreateOrderItem>
    {
        void add(OrderItemCommand.CreateOrderItem c);

        void remove(OrderItemCommand.CreateOrderItem c);

        void clear();
    }

    interface OrderItemCommands extends Iterable<OrderItemCommand>
    {
        void add(OrderItemCommand c);

        void remove(OrderItemCommand c);

        void clear();
    }

}

