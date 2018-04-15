package org.dddml.wms.domain.orderitemshipgroupassociationmvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrderItemShipGroupAssociationMvoStateEventDtoConverter {

    public OrderItemShipGroupAssociationMvoStateEventDto toOrderItemShipGroupAssociationMvoStateEventDto(AbstractOrderItemShipGroupAssociationMvoEvent stateEvent) {
        if (stateEvent instanceof AbstractOrderItemShipGroupAssociationMvoEvent.AbstractOrderItemShipGroupAssociationMvoStateCreated) {
            OrderItemShipGroupAssociationMvoEvent.OrderItemShipGroupAssociationMvoStateCreated e = (OrderItemShipGroupAssociationMvoEvent.OrderItemShipGroupAssociationMvoStateCreated) stateEvent;
            return toOrderItemShipGroupAssociationMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrderItemShipGroupAssociationMvoEvent.AbstractOrderItemShipGroupAssociationMvoStateMergePatched) {
            OrderItemShipGroupAssociationMvoEvent.OrderItemShipGroupAssociationMvoStateMergePatched e = (OrderItemShipGroupAssociationMvoEvent.OrderItemShipGroupAssociationMvoStateMergePatched) stateEvent;
            return toOrderItemShipGroupAssociationMvoStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractOrderItemShipGroupAssociationMvoEvent.AbstractOrderItemShipGroupAssociationMvoStateDeleted) {
            OrderItemShipGroupAssociationMvoEvent.OrderItemShipGroupAssociationMvoStateDeleted e = (OrderItemShipGroupAssociationMvoEvent.OrderItemShipGroupAssociationMvoStateDeleted) stateEvent;
            return toOrderItemShipGroupAssociationMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public OrderItemShipGroupAssociationMvoStateEventDto.OrderItemShipGroupAssociationMvoStateCreatedDto toOrderItemShipGroupAssociationMvoStateCreatedDto(OrderItemShipGroupAssociationMvoEvent.OrderItemShipGroupAssociationMvoStateCreated e) {
        OrderItemShipGroupAssociationMvoStateEventDto.OrderItemShipGroupAssociationMvoStateCreatedDto dto = new OrderItemShipGroupAssociationMvoStateEventDto.OrderItemShipGroupAssociationMvoStateCreatedDto();
        dto.setOrderItemShipGroupAssociationMvoEventId(e.getOrderItemShipGroupAssociationMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setQuantity(e.getQuantity());
        dto.setCancelQuantity(e.getCancelQuantity());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setOrderShipGroupShipmentMethodTypeId(e.getOrderShipGroupShipmentMethodTypeId());
        dto.setOrderShipGroupSupplierPartyId(e.getOrderShipGroupSupplierPartyId());
        dto.setOrderShipGroupVendorPartyId(e.getOrderShipGroupVendorPartyId());
        dto.setOrderShipGroupCarrierPartyId(e.getOrderShipGroupCarrierPartyId());
        dto.setOrderShipGroupCarrierRoleTypeId(e.getOrderShipGroupCarrierRoleTypeId());
        dto.setOrderShipGroupFacilityId(e.getOrderShipGroupFacilityId());
        dto.setOrderShipGroupContactMechId(e.getOrderShipGroupContactMechId());
        dto.setOrderShipGroupTelecomContactMechId(e.getOrderShipGroupTelecomContactMechId());
        dto.setOrderShipGroupTrackingNumber(e.getOrderShipGroupTrackingNumber());
        dto.setOrderShipGroupShippingInstructions(e.getOrderShipGroupShippingInstructions());
        dto.setOrderShipGroupMaySplit(e.getOrderShipGroupMaySplit());
        dto.setOrderShipGroupGiftMessage(e.getOrderShipGroupGiftMessage());
        dto.setOrderShipGroupIsGift(e.getOrderShipGroupIsGift());
        dto.setOrderShipGroupShipAfterDate(e.getOrderShipGroupShipAfterDate());
        dto.setOrderShipGroupShipByDate(e.getOrderShipGroupShipByDate());
        dto.setOrderShipGroupEstimatedShipDate(e.getOrderShipGroupEstimatedShipDate());
        dto.setOrderShipGroupEstimatedDeliveryDate(e.getOrderShipGroupEstimatedDeliveryDate());
        dto.setOrderShipGroupPickwaveId(e.getOrderShipGroupPickwaveId());
        dto.setOrderShipGroupVersion(e.getOrderShipGroupVersion());
        dto.setOrderShipGroupCreatedBy(e.getOrderShipGroupCreatedBy());
        dto.setOrderShipGroupCreatedAt(e.getOrderShipGroupCreatedAt());
        dto.setOrderShipGroupUpdatedBy(e.getOrderShipGroupUpdatedBy());
        dto.setOrderShipGroupUpdatedAt(e.getOrderShipGroupUpdatedAt());
        dto.setOrderShipGroupActive(e.getOrderShipGroupActive());
        dto.setOrderShipGroupDeleted(e.getOrderShipGroupDeleted());
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

    public OrderItemShipGroupAssociationMvoStateEventDto.OrderItemShipGroupAssociationMvoStateMergePatchedDto toOrderItemShipGroupAssociationMvoStateMergePatchedDto(OrderItemShipGroupAssociationMvoEvent.OrderItemShipGroupAssociationMvoStateMergePatched e) {
        OrderItemShipGroupAssociationMvoStateEventDto.OrderItemShipGroupAssociationMvoStateMergePatchedDto dto = new OrderItemShipGroupAssociationMvoStateEventDto.OrderItemShipGroupAssociationMvoStateMergePatchedDto();
        dto.setOrderItemShipGroupAssociationMvoEventId(e.getOrderItemShipGroupAssociationMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setQuantity(e.getQuantity());
        dto.setCancelQuantity(e.getCancelQuantity());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setOrderShipGroupShipmentMethodTypeId(e.getOrderShipGroupShipmentMethodTypeId());
        dto.setOrderShipGroupSupplierPartyId(e.getOrderShipGroupSupplierPartyId());
        dto.setOrderShipGroupVendorPartyId(e.getOrderShipGroupVendorPartyId());
        dto.setOrderShipGroupCarrierPartyId(e.getOrderShipGroupCarrierPartyId());
        dto.setOrderShipGroupCarrierRoleTypeId(e.getOrderShipGroupCarrierRoleTypeId());
        dto.setOrderShipGroupFacilityId(e.getOrderShipGroupFacilityId());
        dto.setOrderShipGroupContactMechId(e.getOrderShipGroupContactMechId());
        dto.setOrderShipGroupTelecomContactMechId(e.getOrderShipGroupTelecomContactMechId());
        dto.setOrderShipGroupTrackingNumber(e.getOrderShipGroupTrackingNumber());
        dto.setOrderShipGroupShippingInstructions(e.getOrderShipGroupShippingInstructions());
        dto.setOrderShipGroupMaySplit(e.getOrderShipGroupMaySplit());
        dto.setOrderShipGroupGiftMessage(e.getOrderShipGroupGiftMessage());
        dto.setOrderShipGroupIsGift(e.getOrderShipGroupIsGift());
        dto.setOrderShipGroupShipAfterDate(e.getOrderShipGroupShipAfterDate());
        dto.setOrderShipGroupShipByDate(e.getOrderShipGroupShipByDate());
        dto.setOrderShipGroupEstimatedShipDate(e.getOrderShipGroupEstimatedShipDate());
        dto.setOrderShipGroupEstimatedDeliveryDate(e.getOrderShipGroupEstimatedDeliveryDate());
        dto.setOrderShipGroupPickwaveId(e.getOrderShipGroupPickwaveId());
        dto.setOrderShipGroupVersion(e.getOrderShipGroupVersion());
        dto.setOrderShipGroupCreatedBy(e.getOrderShipGroupCreatedBy());
        dto.setOrderShipGroupCreatedAt(e.getOrderShipGroupCreatedAt());
        dto.setOrderShipGroupUpdatedBy(e.getOrderShipGroupUpdatedBy());
        dto.setOrderShipGroupUpdatedAt(e.getOrderShipGroupUpdatedAt());
        dto.setOrderShipGroupActive(e.getOrderShipGroupActive());
        dto.setOrderShipGroupDeleted(e.getOrderShipGroupDeleted());
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
        dto.setIsPropertyQuantityRemoved(e.getIsPropertyQuantityRemoved());
        dto.setIsPropertyCancelQuantityRemoved(e.getIsPropertyCancelQuantityRemoved());
        dto.setIsPropertyVersionRemoved(e.getIsPropertyVersionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        dto.setIsPropertyOrderShipGroupShipmentMethodTypeIdRemoved(e.getIsPropertyOrderShipGroupShipmentMethodTypeIdRemoved());
        dto.setIsPropertyOrderShipGroupSupplierPartyIdRemoved(e.getIsPropertyOrderShipGroupSupplierPartyIdRemoved());
        dto.setIsPropertyOrderShipGroupVendorPartyIdRemoved(e.getIsPropertyOrderShipGroupVendorPartyIdRemoved());
        dto.setIsPropertyOrderShipGroupCarrierPartyIdRemoved(e.getIsPropertyOrderShipGroupCarrierPartyIdRemoved());
        dto.setIsPropertyOrderShipGroupCarrierRoleTypeIdRemoved(e.getIsPropertyOrderShipGroupCarrierRoleTypeIdRemoved());
        dto.setIsPropertyOrderShipGroupFacilityIdRemoved(e.getIsPropertyOrderShipGroupFacilityIdRemoved());
        dto.setIsPropertyOrderShipGroupContactMechIdRemoved(e.getIsPropertyOrderShipGroupContactMechIdRemoved());
        dto.setIsPropertyOrderShipGroupTelecomContactMechIdRemoved(e.getIsPropertyOrderShipGroupTelecomContactMechIdRemoved());
        dto.setIsPropertyOrderShipGroupTrackingNumberRemoved(e.getIsPropertyOrderShipGroupTrackingNumberRemoved());
        dto.setIsPropertyOrderShipGroupShippingInstructionsRemoved(e.getIsPropertyOrderShipGroupShippingInstructionsRemoved());
        dto.setIsPropertyOrderShipGroupMaySplitRemoved(e.getIsPropertyOrderShipGroupMaySplitRemoved());
        dto.setIsPropertyOrderShipGroupGiftMessageRemoved(e.getIsPropertyOrderShipGroupGiftMessageRemoved());
        dto.setIsPropertyOrderShipGroupIsGiftRemoved(e.getIsPropertyOrderShipGroupIsGiftRemoved());
        dto.setIsPropertyOrderShipGroupShipAfterDateRemoved(e.getIsPropertyOrderShipGroupShipAfterDateRemoved());
        dto.setIsPropertyOrderShipGroupShipByDateRemoved(e.getIsPropertyOrderShipGroupShipByDateRemoved());
        dto.setIsPropertyOrderShipGroupEstimatedShipDateRemoved(e.getIsPropertyOrderShipGroupEstimatedShipDateRemoved());
        dto.setIsPropertyOrderShipGroupEstimatedDeliveryDateRemoved(e.getIsPropertyOrderShipGroupEstimatedDeliveryDateRemoved());
        dto.setIsPropertyOrderShipGroupPickwaveIdRemoved(e.getIsPropertyOrderShipGroupPickwaveIdRemoved());
        dto.setIsPropertyOrderShipGroupVersionRemoved(e.getIsPropertyOrderShipGroupVersionRemoved());
        dto.setIsPropertyOrderShipGroupCreatedByRemoved(e.getIsPropertyOrderShipGroupCreatedByRemoved());
        dto.setIsPropertyOrderShipGroupCreatedAtRemoved(e.getIsPropertyOrderShipGroupCreatedAtRemoved());
        dto.setIsPropertyOrderShipGroupUpdatedByRemoved(e.getIsPropertyOrderShipGroupUpdatedByRemoved());
        dto.setIsPropertyOrderShipGroupUpdatedAtRemoved(e.getIsPropertyOrderShipGroupUpdatedAtRemoved());
        dto.setIsPropertyOrderShipGroupActiveRemoved(e.getIsPropertyOrderShipGroupActiveRemoved());
        dto.setIsPropertyOrderShipGroupDeletedRemoved(e.getIsPropertyOrderShipGroupDeletedRemoved());
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


    public OrderItemShipGroupAssociationMvoStateEventDto.OrderItemShipGroupAssociationMvoStateDeletedDto toOrderItemShipGroupAssociationMvoStateDeletedDto(OrderItemShipGroupAssociationMvoEvent.OrderItemShipGroupAssociationMvoStateDeleted e) {
        OrderItemShipGroupAssociationMvoStateEventDto.OrderItemShipGroupAssociationMvoStateDeletedDto dto = new OrderItemShipGroupAssociationMvoStateEventDto.OrderItemShipGroupAssociationMvoStateDeletedDto();
        dto.setOrderItemShipGroupAssociationMvoEventId(e.getOrderItemShipGroupAssociationMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

