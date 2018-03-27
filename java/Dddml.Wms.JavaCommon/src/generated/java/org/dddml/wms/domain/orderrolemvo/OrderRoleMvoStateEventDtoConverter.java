package org.dddml.wms.domain.orderrolemvo;

import java.util.*;
import org.dddml.wms.domain.order.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrderRoleMvoStateEventDtoConverter {

    public OrderRoleMvoStateEventDto toOrderRoleMvoStateEventDto(AbstractOrderRoleMvoStateEvent stateEvent) {
        if (stateEvent instanceof AbstractOrderRoleMvoStateEvent.AbstractOrderRoleMvoStateCreated) {
            OrderRoleMvoStateEvent.OrderRoleMvoStateCreated e = (OrderRoleMvoStateEvent.OrderRoleMvoStateCreated) stateEvent;
            return toOrderRoleMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrderRoleMvoStateEvent.AbstractOrderRoleMvoStateMergePatched) {
            OrderRoleMvoStateEvent.OrderRoleMvoStateMergePatched e = (OrderRoleMvoStateEvent.OrderRoleMvoStateMergePatched) stateEvent;
            return toOrderRoleMvoStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractOrderRoleMvoStateEvent.AbstractOrderRoleMvoStateDeleted) {
            OrderRoleMvoStateEvent.OrderRoleMvoStateDeleted e = (OrderRoleMvoStateEvent.OrderRoleMvoStateDeleted) stateEvent;
            return toOrderRoleMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public OrderRoleMvoStateEventDto.OrderRoleMvoStateCreatedDto toOrderRoleMvoStateCreatedDto(OrderRoleMvoStateEvent.OrderRoleMvoStateCreated e) {
        OrderRoleMvoStateEventDto.OrderRoleMvoStateCreatedDto dto = new OrderRoleMvoStateEventDto.OrderRoleMvoStateCreatedDto();
        dto.setOrderRoleMvoEventId(e.getOrderRoleMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
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

    public OrderRoleMvoStateEventDto.OrderRoleMvoStateMergePatchedDto toOrderRoleMvoStateMergePatchedDto(OrderRoleMvoStateEvent.OrderRoleMvoStateMergePatched e) {
        OrderRoleMvoStateEventDto.OrderRoleMvoStateMergePatchedDto dto = new OrderRoleMvoStateEventDto.OrderRoleMvoStateMergePatchedDto();
        dto.setOrderRoleMvoEventId(e.getOrderRoleMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
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


    public OrderRoleMvoStateEventDto.OrderRoleMvoStateDeletedDto toOrderRoleMvoStateDeletedDto(OrderRoleMvoStateEvent.OrderRoleMvoStateDeleted e) {
        OrderRoleMvoStateEventDto.OrderRoleMvoStateDeletedDto dto = new OrderRoleMvoStateEventDto.OrderRoleMvoStateDeletedDto();
        dto.setOrderRoleMvoEventId(e.getOrderRoleMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

