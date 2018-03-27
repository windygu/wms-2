package org.dddml.wms.domain.ordershipgroupmvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrderShipGroupMvoStateEventDtoConverter {

    public OrderShipGroupMvoStateEventDto toOrderShipGroupMvoStateEventDto(AbstractOrderShipGroupMvoStateEvent stateEvent) {
        if (stateEvent instanceof AbstractOrderShipGroupMvoStateEvent.AbstractOrderShipGroupMvoStateCreated) {
            OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateCreated e = (OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateCreated) stateEvent;
            return toOrderShipGroupMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrderShipGroupMvoStateEvent.AbstractOrderShipGroupMvoStateMergePatched) {
            OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateMergePatched e = (OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateMergePatched) stateEvent;
            return toOrderShipGroupMvoStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractOrderShipGroupMvoStateEvent.AbstractOrderShipGroupMvoStateDeleted) {
            OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateDeleted e = (OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateDeleted) stateEvent;
            return toOrderShipGroupMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public OrderShipGroupMvoStateEventDto.OrderShipGroupMvoStateCreatedDto toOrderShipGroupMvoStateCreatedDto(OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateCreated e) {
        OrderShipGroupMvoStateEventDto.OrderShipGroupMvoStateCreatedDto dto = new OrderShipGroupMvoStateEventDto.OrderShipGroupMvoStateCreatedDto();
        dto.setOrderShipGroupMvoEventId(e.getOrderShipGroupMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setShipmentMethodTypeId(e.getShipmentMethodTypeId());
        dto.setSupplierPartyId(e.getSupplierPartyId());
        dto.setVendorPartyId(e.getVendorPartyId());
        dto.setCarrierPartyId(e.getCarrierPartyId());
        dto.setCarrierRoleTypeId(e.getCarrierRoleTypeId());
        dto.setFacilityId(e.getFacilityId());
        dto.setContactMechId(e.getContactMechId());
        dto.setTelecomContactMechId(e.getTelecomContactMechId());
        dto.setTrackingNumber(e.getTrackingNumber());
        dto.setShippingInstructions(e.getShippingInstructions());
        dto.setMaySplit(e.getMaySplit());
        dto.setGiftMessage(e.getGiftMessage());
        dto.setIsGift(e.getIsGift());
        dto.setShipAfterDate(e.getShipAfterDate());
        dto.setShipByDate(e.getShipByDate());
        dto.setEstimatedShipDate(e.getEstimatedShipDate());
        dto.setEstimatedDeliveryDate(e.getEstimatedDeliveryDate());
        dto.setPickwaveId(e.getPickwaveId());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setOrderOrderTypeId(e.getOrderOrderTypeId());
        dto.setOrderOrderName(e.getOrderOrderName());
        dto.setOrderExternalId(e.getOrderExternalId());
        dto.setOrderSalesChannelEnumId(e.getOrderSalesChannelEnumId());
        dto.setOrderOrderDate(e.getOrderOrderDate());
        dto.setOrderPriority(e.getOrderPriority());
        dto.setOrderEntryDate(e.getOrderEntryDate());
        dto.setOrderPickSheetPrintedDate(e.getOrderPickSheetPrintedDate());
        dto.setOrderStatusId(e.getOrderStatusId());
        dto.setOrderCurrencyUom(e.getOrderCurrencyUom());
        dto.setOrderSyncStatusId(e.getOrderSyncStatusId());
        dto.setOrderBillingAccountId(e.getOrderBillingAccountId());
        dto.setOrderOriginFacilityId(e.getOrderOriginFacilityId());
        dto.setOrderWebSiteId(e.getOrderWebSiteId());
        dto.setOrderProductStoreId(e.getOrderProductStoreId());
        dto.setOrderTerminalId(e.getOrderTerminalId());
        dto.setOrderTransactionId(e.getOrderTransactionId());
        dto.setOrderAutoOrderShoppingListId(e.getOrderAutoOrderShoppingListId());
        dto.setOrderNeedsInventoryIssuance(e.getOrderNeedsInventoryIssuance());
        dto.setOrderIsRushOrder(e.getOrderIsRushOrder());
        dto.setOrderInternalCode(e.getOrderInternalCode());
        dto.setOrderRemainingSubTotal(e.getOrderRemainingSubTotal());
        dto.setOrderGrandTotal(e.getOrderGrandTotal());
        dto.setOrderInvoicePerShipment(e.getOrderInvoicePerShipment());
        dto.setOrderCreatedBy(e.getOrderCreatedBy());
        dto.setOrderCreatedAt(e.getOrderCreatedAt());
        dto.setOrderUpdatedBy(e.getOrderUpdatedBy());
        dto.setOrderUpdatedAt(e.getOrderUpdatedAt());
        dto.setOrderActive(e.getOrderActive());
        return dto;
    }

    public OrderShipGroupMvoStateEventDto.OrderShipGroupMvoStateMergePatchedDto toOrderShipGroupMvoStateMergePatchedDto(OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateMergePatched e) {
        OrderShipGroupMvoStateEventDto.OrderShipGroupMvoStateMergePatchedDto dto = new OrderShipGroupMvoStateEventDto.OrderShipGroupMvoStateMergePatchedDto();
        dto.setOrderShipGroupMvoEventId(e.getOrderShipGroupMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setShipmentMethodTypeId(e.getShipmentMethodTypeId());
        dto.setSupplierPartyId(e.getSupplierPartyId());
        dto.setVendorPartyId(e.getVendorPartyId());
        dto.setCarrierPartyId(e.getCarrierPartyId());
        dto.setCarrierRoleTypeId(e.getCarrierRoleTypeId());
        dto.setFacilityId(e.getFacilityId());
        dto.setContactMechId(e.getContactMechId());
        dto.setTelecomContactMechId(e.getTelecomContactMechId());
        dto.setTrackingNumber(e.getTrackingNumber());
        dto.setShippingInstructions(e.getShippingInstructions());
        dto.setMaySplit(e.getMaySplit());
        dto.setGiftMessage(e.getGiftMessage());
        dto.setIsGift(e.getIsGift());
        dto.setShipAfterDate(e.getShipAfterDate());
        dto.setShipByDate(e.getShipByDate());
        dto.setEstimatedShipDate(e.getEstimatedShipDate());
        dto.setEstimatedDeliveryDate(e.getEstimatedDeliveryDate());
        dto.setPickwaveId(e.getPickwaveId());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setOrderOrderTypeId(e.getOrderOrderTypeId());
        dto.setOrderOrderName(e.getOrderOrderName());
        dto.setOrderExternalId(e.getOrderExternalId());
        dto.setOrderSalesChannelEnumId(e.getOrderSalesChannelEnumId());
        dto.setOrderOrderDate(e.getOrderOrderDate());
        dto.setOrderPriority(e.getOrderPriority());
        dto.setOrderEntryDate(e.getOrderEntryDate());
        dto.setOrderPickSheetPrintedDate(e.getOrderPickSheetPrintedDate());
        dto.setOrderStatusId(e.getOrderStatusId());
        dto.setOrderCurrencyUom(e.getOrderCurrencyUom());
        dto.setOrderSyncStatusId(e.getOrderSyncStatusId());
        dto.setOrderBillingAccountId(e.getOrderBillingAccountId());
        dto.setOrderOriginFacilityId(e.getOrderOriginFacilityId());
        dto.setOrderWebSiteId(e.getOrderWebSiteId());
        dto.setOrderProductStoreId(e.getOrderProductStoreId());
        dto.setOrderTerminalId(e.getOrderTerminalId());
        dto.setOrderTransactionId(e.getOrderTransactionId());
        dto.setOrderAutoOrderShoppingListId(e.getOrderAutoOrderShoppingListId());
        dto.setOrderNeedsInventoryIssuance(e.getOrderNeedsInventoryIssuance());
        dto.setOrderIsRushOrder(e.getOrderIsRushOrder());
        dto.setOrderInternalCode(e.getOrderInternalCode());
        dto.setOrderRemainingSubTotal(e.getOrderRemainingSubTotal());
        dto.setOrderGrandTotal(e.getOrderGrandTotal());
        dto.setOrderInvoicePerShipment(e.getOrderInvoicePerShipment());
        dto.setOrderCreatedBy(e.getOrderCreatedBy());
        dto.setOrderCreatedAt(e.getOrderCreatedAt());
        dto.setOrderUpdatedBy(e.getOrderUpdatedBy());
        dto.setOrderUpdatedAt(e.getOrderUpdatedAt());
        dto.setOrderActive(e.getOrderActive());
        dto.setIsPropertyShipmentMethodTypeIdRemoved(e.getIsPropertyShipmentMethodTypeIdRemoved());
        dto.setIsPropertySupplierPartyIdRemoved(e.getIsPropertySupplierPartyIdRemoved());
        dto.setIsPropertyVendorPartyIdRemoved(e.getIsPropertyVendorPartyIdRemoved());
        dto.setIsPropertyCarrierPartyIdRemoved(e.getIsPropertyCarrierPartyIdRemoved());
        dto.setIsPropertyCarrierRoleTypeIdRemoved(e.getIsPropertyCarrierRoleTypeIdRemoved());
        dto.setIsPropertyFacilityIdRemoved(e.getIsPropertyFacilityIdRemoved());
        dto.setIsPropertyContactMechIdRemoved(e.getIsPropertyContactMechIdRemoved());
        dto.setIsPropertyTelecomContactMechIdRemoved(e.getIsPropertyTelecomContactMechIdRemoved());
        dto.setIsPropertyTrackingNumberRemoved(e.getIsPropertyTrackingNumberRemoved());
        dto.setIsPropertyShippingInstructionsRemoved(e.getIsPropertyShippingInstructionsRemoved());
        dto.setIsPropertyMaySplitRemoved(e.getIsPropertyMaySplitRemoved());
        dto.setIsPropertyGiftMessageRemoved(e.getIsPropertyGiftMessageRemoved());
        dto.setIsPropertyIsGiftRemoved(e.getIsPropertyIsGiftRemoved());
        dto.setIsPropertyShipAfterDateRemoved(e.getIsPropertyShipAfterDateRemoved());
        dto.setIsPropertyShipByDateRemoved(e.getIsPropertyShipByDateRemoved());
        dto.setIsPropertyEstimatedShipDateRemoved(e.getIsPropertyEstimatedShipDateRemoved());
        dto.setIsPropertyEstimatedDeliveryDateRemoved(e.getIsPropertyEstimatedDeliveryDateRemoved());
        dto.setIsPropertyPickwaveIdRemoved(e.getIsPropertyPickwaveIdRemoved());
        dto.setIsPropertyVersionRemoved(e.getIsPropertyVersionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        dto.setIsPropertyOrderOrderTypeIdRemoved(e.getIsPropertyOrderOrderTypeIdRemoved());
        dto.setIsPropertyOrderOrderNameRemoved(e.getIsPropertyOrderOrderNameRemoved());
        dto.setIsPropertyOrderExternalIdRemoved(e.getIsPropertyOrderExternalIdRemoved());
        dto.setIsPropertyOrderSalesChannelEnumIdRemoved(e.getIsPropertyOrderSalesChannelEnumIdRemoved());
        dto.setIsPropertyOrderOrderDateRemoved(e.getIsPropertyOrderOrderDateRemoved());
        dto.setIsPropertyOrderPriorityRemoved(e.getIsPropertyOrderPriorityRemoved());
        dto.setIsPropertyOrderEntryDateRemoved(e.getIsPropertyOrderEntryDateRemoved());
        dto.setIsPropertyOrderPickSheetPrintedDateRemoved(e.getIsPropertyOrderPickSheetPrintedDateRemoved());
        dto.setIsPropertyOrderStatusIdRemoved(e.getIsPropertyOrderStatusIdRemoved());
        dto.setIsPropertyOrderCurrencyUomRemoved(e.getIsPropertyOrderCurrencyUomRemoved());
        dto.setIsPropertyOrderSyncStatusIdRemoved(e.getIsPropertyOrderSyncStatusIdRemoved());
        dto.setIsPropertyOrderBillingAccountIdRemoved(e.getIsPropertyOrderBillingAccountIdRemoved());
        dto.setIsPropertyOrderOriginFacilityIdRemoved(e.getIsPropertyOrderOriginFacilityIdRemoved());
        dto.setIsPropertyOrderWebSiteIdRemoved(e.getIsPropertyOrderWebSiteIdRemoved());
        dto.setIsPropertyOrderProductStoreIdRemoved(e.getIsPropertyOrderProductStoreIdRemoved());
        dto.setIsPropertyOrderTerminalIdRemoved(e.getIsPropertyOrderTerminalIdRemoved());
        dto.setIsPropertyOrderTransactionIdRemoved(e.getIsPropertyOrderTransactionIdRemoved());
        dto.setIsPropertyOrderAutoOrderShoppingListIdRemoved(e.getIsPropertyOrderAutoOrderShoppingListIdRemoved());
        dto.setIsPropertyOrderNeedsInventoryIssuanceRemoved(e.getIsPropertyOrderNeedsInventoryIssuanceRemoved());
        dto.setIsPropertyOrderIsRushOrderRemoved(e.getIsPropertyOrderIsRushOrderRemoved());
        dto.setIsPropertyOrderInternalCodeRemoved(e.getIsPropertyOrderInternalCodeRemoved());
        dto.setIsPropertyOrderRemainingSubTotalRemoved(e.getIsPropertyOrderRemainingSubTotalRemoved());
        dto.setIsPropertyOrderGrandTotalRemoved(e.getIsPropertyOrderGrandTotalRemoved());
        dto.setIsPropertyOrderInvoicePerShipmentRemoved(e.getIsPropertyOrderInvoicePerShipmentRemoved());
        dto.setIsPropertyOrderCreatedByRemoved(e.getIsPropertyOrderCreatedByRemoved());
        dto.setIsPropertyOrderCreatedAtRemoved(e.getIsPropertyOrderCreatedAtRemoved());
        dto.setIsPropertyOrderUpdatedByRemoved(e.getIsPropertyOrderUpdatedByRemoved());
        dto.setIsPropertyOrderUpdatedAtRemoved(e.getIsPropertyOrderUpdatedAtRemoved());
        dto.setIsPropertyOrderActiveRemoved(e.getIsPropertyOrderActiveRemoved());
        return dto;
    }


    public OrderShipGroupMvoStateEventDto.OrderShipGroupMvoStateDeletedDto toOrderShipGroupMvoStateDeletedDto(OrderShipGroupMvoStateEvent.OrderShipGroupMvoStateDeleted e) {
        OrderShipGroupMvoStateEventDto.OrderShipGroupMvoStateDeletedDto dto = new OrderShipGroupMvoStateEventDto.OrderShipGroupMvoStateDeletedDto();
        dto.setOrderShipGroupMvoEventId(e.getOrderShipGroupMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

