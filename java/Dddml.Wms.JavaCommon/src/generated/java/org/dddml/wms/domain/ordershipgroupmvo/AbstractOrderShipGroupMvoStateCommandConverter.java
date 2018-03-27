package org.dddml.wms.domain.ordershipgroupmvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractOrderShipGroupMvoStateCommandConverter<TCreateOrderShipGroupMvo extends OrderShipGroupMvoCommand.CreateOrderShipGroupMvo, TMergePatchOrderShipGroupMvo extends OrderShipGroupMvoCommand.MergePatchOrderShipGroupMvo, TDeleteOrderShipGroupMvo extends OrderShipGroupMvoCommand.DeleteOrderShipGroupMvo>
{
    public OrderShipGroupMvoCommand toCreateOrMergePatchOrderShipGroupMvo(OrderShipGroupMvoState state)
    {
        //where TCreateOrderShipGroupMvo : ICreateOrderShipGroupMvo, new()
        //where TMergePatchOrderShipGroupMvo : IMergePatchOrderShipGroupMvo, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateOrderShipGroupMvo(state);
        }
        else 
        {
            return toMergePatchOrderShipGroupMvo(state);
        }
    }

    public TDeleteOrderShipGroupMvo toDeleteOrderShipGroupMvo(OrderShipGroupMvoState state) //where TDeleteOrderShipGroupMvo : IDeleteOrderShipGroupMvo, new()
    {
        TDeleteOrderShipGroupMvo cmd = newDeleteOrderShipGroupMvo();
        cmd.setOrderShipGroupId(state.getOrderShipGroupId());
        cmd.setOrderVersion(state.getOrderVersion());

        return cmd;
    }

    public TMergePatchOrderShipGroupMvo toMergePatchOrderShipGroupMvo(OrderShipGroupMvoState state) //where TMergePatchOrderShipGroupMvo : IMergePatchOrderShipGroupMvo, new()
    {
        TMergePatchOrderShipGroupMvo cmd = newMergePatchOrderShipGroupMvo();

        cmd.setOrderVersion(state.getOrderVersion());

        cmd.setOrderShipGroupId(state.getOrderShipGroupId());
        cmd.setShipmentMethodTypeId(state.getShipmentMethodTypeId());
        cmd.setSupplierPartyId(state.getSupplierPartyId());
        cmd.setVendorPartyId(state.getVendorPartyId());
        cmd.setCarrierPartyId(state.getCarrierPartyId());
        cmd.setCarrierRoleTypeId(state.getCarrierRoleTypeId());
        cmd.setFacilityId(state.getFacilityId());
        cmd.setContactMechId(state.getContactMechId());
        cmd.setTelecomContactMechId(state.getTelecomContactMechId());
        cmd.setTrackingNumber(state.getTrackingNumber());
        cmd.setShippingInstructions(state.getShippingInstructions());
        cmd.setMaySplit(state.getMaySplit());
        cmd.setGiftMessage(state.getGiftMessage());
        cmd.setIsGift(state.getIsGift());
        cmd.setShipAfterDate(state.getShipAfterDate());
        cmd.setShipByDate(state.getShipByDate());
        cmd.setEstimatedShipDate(state.getEstimatedShipDate());
        cmd.setEstimatedDeliveryDate(state.getEstimatedDeliveryDate());
        cmd.setPickwaveId(state.getPickwaveId());
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
            
        if (state.getShipmentMethodTypeId() == null) { cmd.setIsPropertyShipmentMethodTypeIdRemoved(true); }
        if (state.getSupplierPartyId() == null) { cmd.setIsPropertySupplierPartyIdRemoved(true); }
        if (state.getVendorPartyId() == null) { cmd.setIsPropertyVendorPartyIdRemoved(true); }
        if (state.getCarrierPartyId() == null) { cmd.setIsPropertyCarrierPartyIdRemoved(true); }
        if (state.getCarrierRoleTypeId() == null) { cmd.setIsPropertyCarrierRoleTypeIdRemoved(true); }
        if (state.getFacilityId() == null) { cmd.setIsPropertyFacilityIdRemoved(true); }
        if (state.getContactMechId() == null) { cmd.setIsPropertyContactMechIdRemoved(true); }
        if (state.getTelecomContactMechId() == null) { cmd.setIsPropertyTelecomContactMechIdRemoved(true); }
        if (state.getTrackingNumber() == null) { cmd.setIsPropertyTrackingNumberRemoved(true); }
        if (state.getShippingInstructions() == null) { cmd.setIsPropertyShippingInstructionsRemoved(true); }
        if (state.getMaySplit() == null) { cmd.setIsPropertyMaySplitRemoved(true); }
        if (state.getGiftMessage() == null) { cmd.setIsPropertyGiftMessageRemoved(true); }
        if (state.getIsGift() == null) { cmd.setIsPropertyIsGiftRemoved(true); }
        if (state.getShipAfterDate() == null) { cmd.setIsPropertyShipAfterDateRemoved(true); }
        if (state.getShipByDate() == null) { cmd.setIsPropertyShipByDateRemoved(true); }
        if (state.getEstimatedShipDate() == null) { cmd.setIsPropertyEstimatedShipDateRemoved(true); }
        if (state.getEstimatedDeliveryDate() == null) { cmd.setIsPropertyEstimatedDeliveryDateRemoved(true); }
        if (state.getPickwaveId() == null) { cmd.setIsPropertyPickwaveIdRemoved(true); }
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

    public TCreateOrderShipGroupMvo toCreateOrderShipGroupMvo(OrderShipGroupMvoState state) //where TCreateOrderShipGroupMvo : ICreateOrderShipGroupMvo, new()
    {
        TCreateOrderShipGroupMvo cmd = newCreateOrderShipGroupMvo();

        cmd.setOrderVersion(state.getOrderVersion());
        cmd.setOrderShipGroupId(state.getOrderShipGroupId());
        cmd.setShipmentMethodTypeId(state.getShipmentMethodTypeId());
        cmd.setSupplierPartyId(state.getSupplierPartyId());
        cmd.setVendorPartyId(state.getVendorPartyId());
        cmd.setCarrierPartyId(state.getCarrierPartyId());
        cmd.setCarrierRoleTypeId(state.getCarrierRoleTypeId());
        cmd.setFacilityId(state.getFacilityId());
        cmd.setContactMechId(state.getContactMechId());
        cmd.setTelecomContactMechId(state.getTelecomContactMechId());
        cmd.setTrackingNumber(state.getTrackingNumber());
        cmd.setShippingInstructions(state.getShippingInstructions());
        cmd.setMaySplit(state.getMaySplit());
        cmd.setGiftMessage(state.getGiftMessage());
        cmd.setIsGift(state.getIsGift());
        cmd.setShipAfterDate(state.getShipAfterDate());
        cmd.setShipByDate(state.getShipByDate());
        cmd.setEstimatedShipDate(state.getEstimatedShipDate());
        cmd.setEstimatedDeliveryDate(state.getEstimatedDeliveryDate());
        cmd.setPickwaveId(state.getPickwaveId());
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

    protected abstract TCreateOrderShipGroupMvo newCreateOrderShipGroupMvo();

    protected abstract TMergePatchOrderShipGroupMvo newMergePatchOrderShipGroupMvo(); 

    protected abstract TDeleteOrderShipGroupMvo newDeleteOrderShipGroupMvo();

    public static class SimpleOrderShipGroupMvoStateCommandConverter extends AbstractOrderShipGroupMvoStateCommandConverter<AbstractOrderShipGroupMvoCommand.SimpleCreateOrderShipGroupMvo, AbstractOrderShipGroupMvoCommand.SimpleMergePatchOrderShipGroupMvo, AbstractOrderShipGroupMvoCommand.SimpleDeleteOrderShipGroupMvo>
    {
        @Override
        protected AbstractOrderShipGroupMvoCommand.SimpleCreateOrderShipGroupMvo newCreateOrderShipGroupMvo() {
            return new AbstractOrderShipGroupMvoCommand.SimpleCreateOrderShipGroupMvo();
        }

        @Override
        protected AbstractOrderShipGroupMvoCommand.SimpleMergePatchOrderShipGroupMvo newMergePatchOrderShipGroupMvo() {
            return new AbstractOrderShipGroupMvoCommand.SimpleMergePatchOrderShipGroupMvo();
        }

        @Override
        protected AbstractOrderShipGroupMvoCommand.SimpleDeleteOrderShipGroupMvo newDeleteOrderShipGroupMvo() {
            return new AbstractOrderShipGroupMvoCommand.SimpleDeleteOrderShipGroupMvo();
        }


    }

}

