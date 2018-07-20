package org.dddml.wms.domain.orderrolemvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface OrderRoleMvoCommand extends Command
{
    OrderRoleId getOrderRoleId();

    void setOrderRoleId(OrderRoleId orderRoleId);

    Long getOrderVersion();

    void setOrderVersion(Long orderVersion);

    static void throwOnInvalidStateTransition(OrderRoleMvoState state, Command c) {
        if (state.getOrderVersion() == null)
        {
            if (isCommandCreate((OrderRoleMvoCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((OrderRoleMvoCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(OrderRoleMvoCommand c) {
        return ((c instanceof OrderRoleMvoCommand.CreateOrderRoleMvo) 
            && c.getOrderVersion().equals(OrderRoleMvoState.VERSION_NULL));
    }

    interface CreateOrMergePatchOrderRoleMvo extends OrderRoleMvoCommand
    {
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

    interface CreateOrderRoleMvo extends CreateOrMergePatchOrderRoleMvo
    {
    }

    interface MergePatchOrderRoleMvo extends CreateOrMergePatchOrderRoleMvo
    {
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

	interface DeleteOrderRoleMvo extends OrderRoleMvoCommand
	{
	}

}

