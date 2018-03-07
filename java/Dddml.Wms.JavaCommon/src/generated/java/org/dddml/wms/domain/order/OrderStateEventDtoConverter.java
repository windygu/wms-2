package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrderStateEventDtoConverter {

    public OrderStateEventDto toOrderStateEventDto(AbstractOrderStateEvent stateEvent) {
        if (stateEvent instanceof AbstractOrderStateEvent.AbstractOrderStateCreated) {
            OrderStateEvent.OrderStateCreated e = (OrderStateEvent.OrderStateCreated) stateEvent;
            return toOrderStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrderStateEvent.AbstractOrderStateMergePatched) {
            OrderStateEvent.OrderStateMergePatched e = (OrderStateEvent.OrderStateMergePatched) stateEvent;
            return toOrderStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public OrderStateEventDto.OrderStateCreatedDto toOrderStateCreatedDto(OrderStateEvent.OrderStateCreated e) {
        OrderStateEventDto.OrderStateCreatedDto dto = new OrderStateEventDto.OrderStateCreatedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setOrderTypeId(e.getOrderTypeId());
        dto.setOrderName(e.getOrderName());
        dto.setExternalId(e.getExternalId());
        dto.setSalesChannelEnumId(e.getSalesChannelEnumId());
        dto.setOrderDate(e.getOrderDate());
        dto.setPriority(e.getPriority());
        dto.setEntryDate(e.getEntryDate());
        dto.setPickSheetPrintedDate(e.getPickSheetPrintedDate());
        dto.setStatusId(e.getStatusId());
        dto.setCurrencyUom(e.getCurrencyUom());
        dto.setSyncStatusId(e.getSyncStatusId());
        dto.setBillingAccountId(e.getBillingAccountId());
        dto.setOriginFacilityId(e.getOriginFacilityId());
        dto.setWebSiteId(e.getWebSiteId());
        dto.setProductStoreId(e.getProductStoreId());
        dto.setTerminalId(e.getTerminalId());
        dto.setTransactionId(e.getTransactionId());
        dto.setAutoOrderShoppingListId(e.getAutoOrderShoppingListId());
        dto.setNeedsInventoryIssuance(e.getNeedsInventoryIssuance());
        dto.setIsRushOrder(e.getIsRushOrder());
        dto.setInternalCode(e.getInternalCode());
        dto.setRemainingSubTotal(e.getRemainingSubTotal());
        dto.setGrandTotal(e.getGrandTotal());
        dto.setInvoicePerShipment(e.getInvoicePerShipment());
        dto.setActive(e.getActive());
        List<OrderItemStateEventDto.OrderItemStateCreatedDto> orderItemEvents = new ArrayList<>();
        for (OrderItemStateEvent.OrderItemStateCreated ee : e.getOrderItemEvents()) {
            OrderItemStateEventDto.OrderItemStateCreatedDto eeDto = getOrderItemStateEventDtoConverter().toOrderItemStateCreatedDto(ee);
            orderItemEvents.add(eeDto);
        }
        dto.setOrderItemEvents(orderItemEvents.toArray(new OrderItemStateEventDto.OrderItemStateCreatedDto[0]));

        return dto;
    }

    public OrderStateEventDto.OrderStateMergePatchedDto toOrderStateMergePatchedDto(OrderStateEvent.OrderStateMergePatched e) {
        OrderStateEventDto.OrderStateMergePatchedDto dto = new OrderStateEventDto.OrderStateMergePatchedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setOrderTypeId(e.getOrderTypeId());
        dto.setOrderName(e.getOrderName());
        dto.setExternalId(e.getExternalId());
        dto.setSalesChannelEnumId(e.getSalesChannelEnumId());
        dto.setOrderDate(e.getOrderDate());
        dto.setPriority(e.getPriority());
        dto.setEntryDate(e.getEntryDate());
        dto.setPickSheetPrintedDate(e.getPickSheetPrintedDate());
        dto.setStatusId(e.getStatusId());
        dto.setCurrencyUom(e.getCurrencyUom());
        dto.setSyncStatusId(e.getSyncStatusId());
        dto.setBillingAccountId(e.getBillingAccountId());
        dto.setOriginFacilityId(e.getOriginFacilityId());
        dto.setWebSiteId(e.getWebSiteId());
        dto.setProductStoreId(e.getProductStoreId());
        dto.setTerminalId(e.getTerminalId());
        dto.setTransactionId(e.getTransactionId());
        dto.setAutoOrderShoppingListId(e.getAutoOrderShoppingListId());
        dto.setNeedsInventoryIssuance(e.getNeedsInventoryIssuance());
        dto.setIsRushOrder(e.getIsRushOrder());
        dto.setInternalCode(e.getInternalCode());
        dto.setRemainingSubTotal(e.getRemainingSubTotal());
        dto.setGrandTotal(e.getGrandTotal());
        dto.setInvoicePerShipment(e.getInvoicePerShipment());
        dto.setActive(e.getActive());
        dto.setIsPropertyOrderTypeIdRemoved(e.getIsPropertyOrderTypeIdRemoved());
        dto.setIsPropertyOrderNameRemoved(e.getIsPropertyOrderNameRemoved());
        dto.setIsPropertyExternalIdRemoved(e.getIsPropertyExternalIdRemoved());
        dto.setIsPropertySalesChannelEnumIdRemoved(e.getIsPropertySalesChannelEnumIdRemoved());
        dto.setIsPropertyOrderDateRemoved(e.getIsPropertyOrderDateRemoved());
        dto.setIsPropertyPriorityRemoved(e.getIsPropertyPriorityRemoved());
        dto.setIsPropertyEntryDateRemoved(e.getIsPropertyEntryDateRemoved());
        dto.setIsPropertyPickSheetPrintedDateRemoved(e.getIsPropertyPickSheetPrintedDateRemoved());
        dto.setIsPropertyStatusIdRemoved(e.getIsPropertyStatusIdRemoved());
        dto.setIsPropertyCurrencyUomRemoved(e.getIsPropertyCurrencyUomRemoved());
        dto.setIsPropertySyncStatusIdRemoved(e.getIsPropertySyncStatusIdRemoved());
        dto.setIsPropertyBillingAccountIdRemoved(e.getIsPropertyBillingAccountIdRemoved());
        dto.setIsPropertyOriginFacilityIdRemoved(e.getIsPropertyOriginFacilityIdRemoved());
        dto.setIsPropertyWebSiteIdRemoved(e.getIsPropertyWebSiteIdRemoved());
        dto.setIsPropertyProductStoreIdRemoved(e.getIsPropertyProductStoreIdRemoved());
        dto.setIsPropertyTerminalIdRemoved(e.getIsPropertyTerminalIdRemoved());
        dto.setIsPropertyTransactionIdRemoved(e.getIsPropertyTransactionIdRemoved());
        dto.setIsPropertyAutoOrderShoppingListIdRemoved(e.getIsPropertyAutoOrderShoppingListIdRemoved());
        dto.setIsPropertyNeedsInventoryIssuanceRemoved(e.getIsPropertyNeedsInventoryIssuanceRemoved());
        dto.setIsPropertyIsRushOrderRemoved(e.getIsPropertyIsRushOrderRemoved());
        dto.setIsPropertyInternalCodeRemoved(e.getIsPropertyInternalCodeRemoved());
        dto.setIsPropertyRemainingSubTotalRemoved(e.getIsPropertyRemainingSubTotalRemoved());
        dto.setIsPropertyGrandTotalRemoved(e.getIsPropertyGrandTotalRemoved());
        dto.setIsPropertyInvoicePerShipmentRemoved(e.getIsPropertyInvoicePerShipmentRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        List<OrderItemStateEventDto> orderItemEvents = new ArrayList<>();
        for (OrderItemStateEvent ee : e.getOrderItemEvents()) {
            OrderItemStateEventDto eeDto = getOrderItemStateEventDtoConverter().toOrderItemStateEventDto((AbstractOrderItemStateEvent) ee);
            orderItemEvents.add(eeDto);
        }
        dto.setOrderItemEvents(orderItemEvents.toArray(new OrderItemStateEventDto[0]));

        return dto;
    }


    protected OrderItemStateEventDtoConverter getOrderItemStateEventDtoConverter() {
        return new OrderItemStateEventDtoConverter();
    }

}

