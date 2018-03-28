package org.dddml.wms.domain.orderitemshipgroupassociationmvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractOrderItemShipGroupAssociationMvoStateCommandConverter<TCreateOrderItemShipGroupAssociationMvo extends OrderItemShipGroupAssociationMvoCommand.CreateOrderItemShipGroupAssociationMvo, TMergePatchOrderItemShipGroupAssociationMvo extends OrderItemShipGroupAssociationMvoCommand.MergePatchOrderItemShipGroupAssociationMvo, TDeleteOrderItemShipGroupAssociationMvo extends OrderItemShipGroupAssociationMvoCommand.DeleteOrderItemShipGroupAssociationMvo>
{
    public OrderItemShipGroupAssociationMvoCommand toCreateOrMergePatchOrderItemShipGroupAssociationMvo(OrderItemShipGroupAssociationMvoState state)
    {
        //where TCreateOrderItemShipGroupAssociationMvo : ICreateOrderItemShipGroupAssociationMvo, new()
        //where TMergePatchOrderItemShipGroupAssociationMvo : IMergePatchOrderItemShipGroupAssociationMvo, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateOrderItemShipGroupAssociationMvo(state);
        }
        else 
        {
            return toMergePatchOrderItemShipGroupAssociationMvo(state);
        }
    }

    public TDeleteOrderItemShipGroupAssociationMvo toDeleteOrderItemShipGroupAssociationMvo(OrderItemShipGroupAssociationMvoState state) //where TDeleteOrderItemShipGroupAssociationMvo : IDeleteOrderItemShipGroupAssociationMvo, new()
    {
        TDeleteOrderItemShipGroupAssociationMvo cmd = newDeleteOrderItemShipGroupAssociationMvo();
        cmd.setOrderItemShipGroupAssociationId(state.getOrderItemShipGroupAssociationId());
        cmd.setOrderVersion(state.getOrderVersion());

        return cmd;
    }

    public TMergePatchOrderItemShipGroupAssociationMvo toMergePatchOrderItemShipGroupAssociationMvo(OrderItemShipGroupAssociationMvoState state) //where TMergePatchOrderItemShipGroupAssociationMvo : IMergePatchOrderItemShipGroupAssociationMvo, new()
    {
        TMergePatchOrderItemShipGroupAssociationMvo cmd = newMergePatchOrderItemShipGroupAssociationMvo();

        cmd.setOrderVersion(state.getOrderVersion());

        cmd.setOrderItemShipGroupAssociationId(state.getOrderItemShipGroupAssociationId());
        cmd.setQuantity(state.getQuantity());
        cmd.setCancelQuantity(state.getCancelQuantity());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setOrderShipGroupShipmentMethodTypeId(state.getOrderShipGroupShipmentMethodTypeId());
        cmd.setOrderShipGroupSupplierPartyId(state.getOrderShipGroupSupplierPartyId());
        cmd.setOrderShipGroupVendorPartyId(state.getOrderShipGroupVendorPartyId());
        cmd.setOrderShipGroupCarrierPartyId(state.getOrderShipGroupCarrierPartyId());
        cmd.setOrderShipGroupCarrierRoleTypeId(state.getOrderShipGroupCarrierRoleTypeId());
        cmd.setOrderShipGroupFacilityId(state.getOrderShipGroupFacilityId());
        cmd.setOrderShipGroupContactMechId(state.getOrderShipGroupContactMechId());
        cmd.setOrderShipGroupTelecomContactMechId(state.getOrderShipGroupTelecomContactMechId());
        cmd.setOrderShipGroupTrackingNumber(state.getOrderShipGroupTrackingNumber());
        cmd.setOrderShipGroupShippingInstructions(state.getOrderShipGroupShippingInstructions());
        cmd.setOrderShipGroupMaySplit(state.getOrderShipGroupMaySplit());
        cmd.setOrderShipGroupGiftMessage(state.getOrderShipGroupGiftMessage());
        cmd.setOrderShipGroupIsGift(state.getOrderShipGroupIsGift());
        cmd.setOrderShipGroupShipAfterDate(state.getOrderShipGroupShipAfterDate());
        cmd.setOrderShipGroupShipByDate(state.getOrderShipGroupShipByDate());
        cmd.setOrderShipGroupEstimatedShipDate(state.getOrderShipGroupEstimatedShipDate());
        cmd.setOrderShipGroupEstimatedDeliveryDate(state.getOrderShipGroupEstimatedDeliveryDate());
        cmd.setOrderShipGroupPickwaveId(state.getOrderShipGroupPickwaveId());
        cmd.setOrderShipGroupVersion(state.getOrderShipGroupVersion());
        cmd.setOrderShipGroupCreatedBy(state.getOrderShipGroupCreatedBy());
        cmd.setOrderShipGroupCreatedAt(state.getOrderShipGroupCreatedAt());
        cmd.setOrderShipGroupUpdatedBy(state.getOrderShipGroupUpdatedBy());
        cmd.setOrderShipGroupUpdatedAt(state.getOrderShipGroupUpdatedAt());
        cmd.setOrderShipGroupActive(state.getOrderShipGroupActive());
        cmd.setOrderShipGroupDeleted(state.getOrderShipGroupDeleted());
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
            
        if (state.getQuantity() == null) { cmd.setIsPropertyQuantityRemoved(true); }
        if (state.getCancelQuantity() == null) { cmd.setIsPropertyCancelQuantityRemoved(true); }
        if (state.getVersion() == null) { cmd.setIsPropertyVersionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        if (state.getOrderShipGroupShipmentMethodTypeId() == null) { cmd.setIsPropertyOrderShipGroupShipmentMethodTypeIdRemoved(true); }
        if (state.getOrderShipGroupSupplierPartyId() == null) { cmd.setIsPropertyOrderShipGroupSupplierPartyIdRemoved(true); }
        if (state.getOrderShipGroupVendorPartyId() == null) { cmd.setIsPropertyOrderShipGroupVendorPartyIdRemoved(true); }
        if (state.getOrderShipGroupCarrierPartyId() == null) { cmd.setIsPropertyOrderShipGroupCarrierPartyIdRemoved(true); }
        if (state.getOrderShipGroupCarrierRoleTypeId() == null) { cmd.setIsPropertyOrderShipGroupCarrierRoleTypeIdRemoved(true); }
        if (state.getOrderShipGroupFacilityId() == null) { cmd.setIsPropertyOrderShipGroupFacilityIdRemoved(true); }
        if (state.getOrderShipGroupContactMechId() == null) { cmd.setIsPropertyOrderShipGroupContactMechIdRemoved(true); }
        if (state.getOrderShipGroupTelecomContactMechId() == null) { cmd.setIsPropertyOrderShipGroupTelecomContactMechIdRemoved(true); }
        if (state.getOrderShipGroupTrackingNumber() == null) { cmd.setIsPropertyOrderShipGroupTrackingNumberRemoved(true); }
        if (state.getOrderShipGroupShippingInstructions() == null) { cmd.setIsPropertyOrderShipGroupShippingInstructionsRemoved(true); }
        if (state.getOrderShipGroupMaySplit() == null) { cmd.setIsPropertyOrderShipGroupMaySplitRemoved(true); }
        if (state.getOrderShipGroupGiftMessage() == null) { cmd.setIsPropertyOrderShipGroupGiftMessageRemoved(true); }
        if (state.getOrderShipGroupIsGift() == null) { cmd.setIsPropertyOrderShipGroupIsGiftRemoved(true); }
        if (state.getOrderShipGroupShipAfterDate() == null) { cmd.setIsPropertyOrderShipGroupShipAfterDateRemoved(true); }
        if (state.getOrderShipGroupShipByDate() == null) { cmd.setIsPropertyOrderShipGroupShipByDateRemoved(true); }
        if (state.getOrderShipGroupEstimatedShipDate() == null) { cmd.setIsPropertyOrderShipGroupEstimatedShipDateRemoved(true); }
        if (state.getOrderShipGroupEstimatedDeliveryDate() == null) { cmd.setIsPropertyOrderShipGroupEstimatedDeliveryDateRemoved(true); }
        if (state.getOrderShipGroupPickwaveId() == null) { cmd.setIsPropertyOrderShipGroupPickwaveIdRemoved(true); }
        if (state.getOrderShipGroupVersion() == null) { cmd.setIsPropertyOrderShipGroupVersionRemoved(true); }
        if (state.getOrderShipGroupCreatedBy() == null) { cmd.setIsPropertyOrderShipGroupCreatedByRemoved(true); }
        if (state.getOrderShipGroupCreatedAt() == null) { cmd.setIsPropertyOrderShipGroupCreatedAtRemoved(true); }
        if (state.getOrderShipGroupUpdatedBy() == null) { cmd.setIsPropertyOrderShipGroupUpdatedByRemoved(true); }
        if (state.getOrderShipGroupUpdatedAt() == null) { cmd.setIsPropertyOrderShipGroupUpdatedAtRemoved(true); }
        if (state.getOrderShipGroupActive() == null) { cmd.setIsPropertyOrderShipGroupActiveRemoved(true); }
        if (state.getOrderShipGroupDeleted() == null) { cmd.setIsPropertyOrderShipGroupDeletedRemoved(true); }
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

    public TCreateOrderItemShipGroupAssociationMvo toCreateOrderItemShipGroupAssociationMvo(OrderItemShipGroupAssociationMvoState state) //where TCreateOrderItemShipGroupAssociationMvo : ICreateOrderItemShipGroupAssociationMvo, new()
    {
        TCreateOrderItemShipGroupAssociationMvo cmd = newCreateOrderItemShipGroupAssociationMvo();

        cmd.setOrderVersion(state.getOrderVersion());
        cmd.setOrderItemShipGroupAssociationId(state.getOrderItemShipGroupAssociationId());
        cmd.setQuantity(state.getQuantity());
        cmd.setCancelQuantity(state.getCancelQuantity());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setOrderShipGroupShipmentMethodTypeId(state.getOrderShipGroupShipmentMethodTypeId());
        cmd.setOrderShipGroupSupplierPartyId(state.getOrderShipGroupSupplierPartyId());
        cmd.setOrderShipGroupVendorPartyId(state.getOrderShipGroupVendorPartyId());
        cmd.setOrderShipGroupCarrierPartyId(state.getOrderShipGroupCarrierPartyId());
        cmd.setOrderShipGroupCarrierRoleTypeId(state.getOrderShipGroupCarrierRoleTypeId());
        cmd.setOrderShipGroupFacilityId(state.getOrderShipGroupFacilityId());
        cmd.setOrderShipGroupContactMechId(state.getOrderShipGroupContactMechId());
        cmd.setOrderShipGroupTelecomContactMechId(state.getOrderShipGroupTelecomContactMechId());
        cmd.setOrderShipGroupTrackingNumber(state.getOrderShipGroupTrackingNumber());
        cmd.setOrderShipGroupShippingInstructions(state.getOrderShipGroupShippingInstructions());
        cmd.setOrderShipGroupMaySplit(state.getOrderShipGroupMaySplit());
        cmd.setOrderShipGroupGiftMessage(state.getOrderShipGroupGiftMessage());
        cmd.setOrderShipGroupIsGift(state.getOrderShipGroupIsGift());
        cmd.setOrderShipGroupShipAfterDate(state.getOrderShipGroupShipAfterDate());
        cmd.setOrderShipGroupShipByDate(state.getOrderShipGroupShipByDate());
        cmd.setOrderShipGroupEstimatedShipDate(state.getOrderShipGroupEstimatedShipDate());
        cmd.setOrderShipGroupEstimatedDeliveryDate(state.getOrderShipGroupEstimatedDeliveryDate());
        cmd.setOrderShipGroupPickwaveId(state.getOrderShipGroupPickwaveId());
        cmd.setOrderShipGroupVersion(state.getOrderShipGroupVersion());
        cmd.setOrderShipGroupCreatedBy(state.getOrderShipGroupCreatedBy());
        cmd.setOrderShipGroupCreatedAt(state.getOrderShipGroupCreatedAt());
        cmd.setOrderShipGroupUpdatedBy(state.getOrderShipGroupUpdatedBy());
        cmd.setOrderShipGroupUpdatedAt(state.getOrderShipGroupUpdatedAt());
        cmd.setOrderShipGroupActive(state.getOrderShipGroupActive());
        cmd.setOrderShipGroupDeleted(state.getOrderShipGroupDeleted());
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

    protected abstract TCreateOrderItemShipGroupAssociationMvo newCreateOrderItemShipGroupAssociationMvo();

    protected abstract TMergePatchOrderItemShipGroupAssociationMvo newMergePatchOrderItemShipGroupAssociationMvo(); 

    protected abstract TDeleteOrderItemShipGroupAssociationMvo newDeleteOrderItemShipGroupAssociationMvo();

    public static class SimpleOrderItemShipGroupAssociationMvoStateCommandConverter extends AbstractOrderItemShipGroupAssociationMvoStateCommandConverter<AbstractOrderItemShipGroupAssociationMvoCommand.SimpleCreateOrderItemShipGroupAssociationMvo, AbstractOrderItemShipGroupAssociationMvoCommand.SimpleMergePatchOrderItemShipGroupAssociationMvo, AbstractOrderItemShipGroupAssociationMvoCommand.SimpleDeleteOrderItemShipGroupAssociationMvo>
    {
        @Override
        protected AbstractOrderItemShipGroupAssociationMvoCommand.SimpleCreateOrderItemShipGroupAssociationMvo newCreateOrderItemShipGroupAssociationMvo() {
            return new AbstractOrderItemShipGroupAssociationMvoCommand.SimpleCreateOrderItemShipGroupAssociationMvo();
        }

        @Override
        protected AbstractOrderItemShipGroupAssociationMvoCommand.SimpleMergePatchOrderItemShipGroupAssociationMvo newMergePatchOrderItemShipGroupAssociationMvo() {
            return new AbstractOrderItemShipGroupAssociationMvoCommand.SimpleMergePatchOrderItemShipGroupAssociationMvo();
        }

        @Override
        protected AbstractOrderItemShipGroupAssociationMvoCommand.SimpleDeleteOrderItemShipGroupAssociationMvo newDeleteOrderItemShipGroupAssociationMvo() {
            return new AbstractOrderItemShipGroupAssociationMvoCommand.SimpleDeleteOrderItemShipGroupAssociationMvo();
        }


    }

}

