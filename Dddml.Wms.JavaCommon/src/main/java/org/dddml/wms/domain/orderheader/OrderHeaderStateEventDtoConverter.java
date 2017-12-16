package org.dddml.wms.domain.orderheader;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrderHeaderStateEventDtoConverter {

    public OrderHeaderStateEventDto toOrderHeaderStateEventDto(AbstractOrderHeaderStateEvent stateEvent) {
        if (stateEvent instanceof AbstractOrderHeaderStateEvent.AbstractOrderHeaderStateCreated) {
            OrderHeaderStateEvent.OrderHeaderStateCreated e = (OrderHeaderStateEvent.OrderHeaderStateCreated) stateEvent;
            return toOrderHeaderStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrderHeaderStateEvent.AbstractOrderHeaderStateMergePatched) {
            OrderHeaderStateEvent.OrderHeaderStateMergePatched e = (OrderHeaderStateEvent.OrderHeaderStateMergePatched) stateEvent;
            return toOrderHeaderStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public OrderHeaderStateEventDto.OrderHeaderStateCreatedDto toOrderHeaderStateCreatedDto(OrderHeaderStateEvent.OrderHeaderStateCreated e) {
        OrderHeaderStateEventDto.OrderHeaderStateCreatedDto dto = new OrderHeaderStateEventDto.OrderHeaderStateCreatedDto();
        dto.setStateEventId(new OrderHeaderStateEventIdDtoWrapper(e.getStateEventId()));
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
        return dto;
    }

    public OrderHeaderStateEventDto.OrderHeaderStateMergePatchedDto toOrderHeaderStateMergePatchedDto(OrderHeaderStateEvent.OrderHeaderStateMergePatched e) {
        OrderHeaderStateEventDto.OrderHeaderStateMergePatchedDto dto = new OrderHeaderStateEventDto.OrderHeaderStateMergePatchedDto();
        dto.setStateEventId(new OrderHeaderStateEventIdDtoWrapper(e.getStateEventId()));
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
        return dto;
    }


}

