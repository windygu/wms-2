package org.dddml.wms.domain.orderrolemvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractOrderRoleMvoStateCommandConverter<TCreateOrderRoleMvo extends OrderRoleMvoCommand.CreateOrderRoleMvo, TMergePatchOrderRoleMvo extends OrderRoleMvoCommand.MergePatchOrderRoleMvo, TDeleteOrderRoleMvo extends OrderRoleMvoCommand.DeleteOrderRoleMvo>
{
    public OrderRoleMvoCommand toCreateOrMergePatchOrderRoleMvo(OrderRoleMvoState state)
    {
        //where TCreateOrderRoleMvo : ICreateOrderRoleMvo, new()
        //where TMergePatchOrderRoleMvo : IMergePatchOrderRoleMvo, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateOrderRoleMvo(state);
        }
        else 
        {
            return toMergePatchOrderRoleMvo(state);
        }
    }

    public TDeleteOrderRoleMvo toDeleteOrderRoleMvo(OrderRoleMvoState state) //where TDeleteOrderRoleMvo : IDeleteOrderRoleMvo, new()
    {
        TDeleteOrderRoleMvo cmd = newDeleteOrderRoleMvo();
        cmd.setOrderRoleId(state.getOrderRoleId());
        cmd.setOrderVersion(state.getOrderVersion());

        return cmd;
    }

    public TMergePatchOrderRoleMvo toMergePatchOrderRoleMvo(OrderRoleMvoState state) //where TMergePatchOrderRoleMvo : IMergePatchOrderRoleMvo, new()
    {
        TMergePatchOrderRoleMvo cmd = newMergePatchOrderRoleMvo();

        cmd.setOrderVersion(state.getOrderVersion());

        cmd.setOrderRoleId(state.getOrderRoleId());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setOrderOrderTypeId(state.getOrderOrderTypeId());
        cmd.setOrderOrderName(state.getOrderOrderName());
        cmd.setOrderExternalId(state.getOrderExternalId());
        cmd.setOrderSalesChannelEnumId(state.getOrderSalesChannelEnumId());
        cmd.setOrderOrderDate(state.getOrderOrderDate());
        cmd.setOrderPriority(state.getOrderPriority());
        cmd.setOrderEntryDate(state.getOrderEntryDate());
        cmd.setOrderPickSheetPrintedDate(state.getOrderPickSheetPrintedDate());
        cmd.setOrderStatusId(state.getOrderStatusId());
        cmd.setOrderCurrencyUom(state.getOrderCurrencyUom());
        cmd.setOrderSyncStatusId(state.getOrderSyncStatusId());
        cmd.setOrderBillingAccountId(state.getOrderBillingAccountId());
        cmd.setOrderOriginFacilityId(state.getOrderOriginFacilityId());
        cmd.setOrderWebSiteId(state.getOrderWebSiteId());
        cmd.setOrderProductStoreId(state.getOrderProductStoreId());
        cmd.setOrderTerminalId(state.getOrderTerminalId());
        cmd.setOrderTransactionId(state.getOrderTransactionId());
        cmd.setOrderAutoOrderShoppingListId(state.getOrderAutoOrderShoppingListId());
        cmd.setOrderNeedsInventoryIssuance(state.getOrderNeedsInventoryIssuance());
        cmd.setOrderIsRushOrder(state.getOrderIsRushOrder());
        cmd.setOrderInternalCode(state.getOrderInternalCode());
        cmd.setOrderRemainingSubTotal(state.getOrderRemainingSubTotal());
        cmd.setOrderGrandTotal(state.getOrderGrandTotal());
        cmd.setOrderInvoicePerShipment(state.getOrderInvoicePerShipment());
        cmd.setOrderCreatedBy(state.getOrderCreatedBy());
        cmd.setOrderCreatedAt(state.getOrderCreatedAt());
        cmd.setOrderUpdatedBy(state.getOrderUpdatedBy());
        cmd.setOrderUpdatedAt(state.getOrderUpdatedAt());
        cmd.setOrderActive(state.getOrderActive());
            
        if (state.getVersion() == null) { cmd.setIsPropertyVersionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        if (state.getOrderOrderTypeId() == null) { cmd.setIsPropertyOrderOrderTypeIdRemoved(true); }
        if (state.getOrderOrderName() == null) { cmd.setIsPropertyOrderOrderNameRemoved(true); }
        if (state.getOrderExternalId() == null) { cmd.setIsPropertyOrderExternalIdRemoved(true); }
        if (state.getOrderSalesChannelEnumId() == null) { cmd.setIsPropertyOrderSalesChannelEnumIdRemoved(true); }
        if (state.getOrderOrderDate() == null) { cmd.setIsPropertyOrderOrderDateRemoved(true); }
        if (state.getOrderPriority() == null) { cmd.setIsPropertyOrderPriorityRemoved(true); }
        if (state.getOrderEntryDate() == null) { cmd.setIsPropertyOrderEntryDateRemoved(true); }
        if (state.getOrderPickSheetPrintedDate() == null) { cmd.setIsPropertyOrderPickSheetPrintedDateRemoved(true); }
        if (state.getOrderStatusId() == null) { cmd.setIsPropertyOrderStatusIdRemoved(true); }
        if (state.getOrderCurrencyUom() == null) { cmd.setIsPropertyOrderCurrencyUomRemoved(true); }
        if (state.getOrderSyncStatusId() == null) { cmd.setIsPropertyOrderSyncStatusIdRemoved(true); }
        if (state.getOrderBillingAccountId() == null) { cmd.setIsPropertyOrderBillingAccountIdRemoved(true); }
        if (state.getOrderOriginFacilityId() == null) { cmd.setIsPropertyOrderOriginFacilityIdRemoved(true); }
        if (state.getOrderWebSiteId() == null) { cmd.setIsPropertyOrderWebSiteIdRemoved(true); }
        if (state.getOrderProductStoreId() == null) { cmd.setIsPropertyOrderProductStoreIdRemoved(true); }
        if (state.getOrderTerminalId() == null) { cmd.setIsPropertyOrderTerminalIdRemoved(true); }
        if (state.getOrderTransactionId() == null) { cmd.setIsPropertyOrderTransactionIdRemoved(true); }
        if (state.getOrderAutoOrderShoppingListId() == null) { cmd.setIsPropertyOrderAutoOrderShoppingListIdRemoved(true); }
        if (state.getOrderNeedsInventoryIssuance() == null) { cmd.setIsPropertyOrderNeedsInventoryIssuanceRemoved(true); }
        if (state.getOrderIsRushOrder() == null) { cmd.setIsPropertyOrderIsRushOrderRemoved(true); }
        if (state.getOrderInternalCode() == null) { cmd.setIsPropertyOrderInternalCodeRemoved(true); }
        if (state.getOrderRemainingSubTotal() == null) { cmd.setIsPropertyOrderRemainingSubTotalRemoved(true); }
        if (state.getOrderGrandTotal() == null) { cmd.setIsPropertyOrderGrandTotalRemoved(true); }
        if (state.getOrderInvoicePerShipment() == null) { cmd.setIsPropertyOrderInvoicePerShipmentRemoved(true); }
        if (state.getOrderCreatedBy() == null) { cmd.setIsPropertyOrderCreatedByRemoved(true); }
        if (state.getOrderCreatedAt() == null) { cmd.setIsPropertyOrderCreatedAtRemoved(true); }
        if (state.getOrderUpdatedBy() == null) { cmd.setIsPropertyOrderUpdatedByRemoved(true); }
        if (state.getOrderUpdatedAt() == null) { cmd.setIsPropertyOrderUpdatedAtRemoved(true); }
        if (state.getOrderActive() == null) { cmd.setIsPropertyOrderActiveRemoved(true); }
        return cmd;
    }

    public TCreateOrderRoleMvo toCreateOrderRoleMvo(OrderRoleMvoState state) //where TCreateOrderRoleMvo : ICreateOrderRoleMvo, new()
    {
        TCreateOrderRoleMvo cmd = newCreateOrderRoleMvo();

        cmd.setOrderVersion(state.getOrderVersion());
        cmd.setOrderRoleId(state.getOrderRoleId());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setOrderOrderTypeId(state.getOrderOrderTypeId());
        cmd.setOrderOrderName(state.getOrderOrderName());
        cmd.setOrderExternalId(state.getOrderExternalId());
        cmd.setOrderSalesChannelEnumId(state.getOrderSalesChannelEnumId());
        cmd.setOrderOrderDate(state.getOrderOrderDate());
        cmd.setOrderPriority(state.getOrderPriority());
        cmd.setOrderEntryDate(state.getOrderEntryDate());
        cmd.setOrderPickSheetPrintedDate(state.getOrderPickSheetPrintedDate());
        cmd.setOrderStatusId(state.getOrderStatusId());
        cmd.setOrderCurrencyUom(state.getOrderCurrencyUom());
        cmd.setOrderSyncStatusId(state.getOrderSyncStatusId());
        cmd.setOrderBillingAccountId(state.getOrderBillingAccountId());
        cmd.setOrderOriginFacilityId(state.getOrderOriginFacilityId());
        cmd.setOrderWebSiteId(state.getOrderWebSiteId());
        cmd.setOrderProductStoreId(state.getOrderProductStoreId());
        cmd.setOrderTerminalId(state.getOrderTerminalId());
        cmd.setOrderTransactionId(state.getOrderTransactionId());
        cmd.setOrderAutoOrderShoppingListId(state.getOrderAutoOrderShoppingListId());
        cmd.setOrderNeedsInventoryIssuance(state.getOrderNeedsInventoryIssuance());
        cmd.setOrderIsRushOrder(state.getOrderIsRushOrder());
        cmd.setOrderInternalCode(state.getOrderInternalCode());
        cmd.setOrderRemainingSubTotal(state.getOrderRemainingSubTotal());
        cmd.setOrderGrandTotal(state.getOrderGrandTotal());
        cmd.setOrderInvoicePerShipment(state.getOrderInvoicePerShipment());
        cmd.setOrderCreatedBy(state.getOrderCreatedBy());
        cmd.setOrderCreatedAt(state.getOrderCreatedAt());
        cmd.setOrderUpdatedBy(state.getOrderUpdatedBy());
        cmd.setOrderUpdatedAt(state.getOrderUpdatedAt());
        cmd.setOrderActive(state.getOrderActive());
        return cmd;
    }

    protected abstract TCreateOrderRoleMvo newCreateOrderRoleMvo();

    protected abstract TMergePatchOrderRoleMvo newMergePatchOrderRoleMvo(); 

    protected abstract TDeleteOrderRoleMvo newDeleteOrderRoleMvo();

    public static class SimpleOrderRoleMvoStateCommandConverter extends AbstractOrderRoleMvoStateCommandConverter<AbstractOrderRoleMvoCommand.SimpleCreateOrderRoleMvo, AbstractOrderRoleMvoCommand.SimpleMergePatchOrderRoleMvo, AbstractOrderRoleMvoCommand.SimpleDeleteOrderRoleMvo>
    {
        @Override
        protected AbstractOrderRoleMvoCommand.SimpleCreateOrderRoleMvo newCreateOrderRoleMvo() {
            return new AbstractOrderRoleMvoCommand.SimpleCreateOrderRoleMvo();
        }

        @Override
        protected AbstractOrderRoleMvoCommand.SimpleMergePatchOrderRoleMvo newMergePatchOrderRoleMvo() {
            return new AbstractOrderRoleMvoCommand.SimpleMergePatchOrderRoleMvo();
        }

        @Override
        protected AbstractOrderRoleMvoCommand.SimpleDeleteOrderRoleMvo newDeleteOrderRoleMvo() {
            return new AbstractOrderRoleMvoCommand.SimpleDeleteOrderRoleMvo();
        }


    }

}

