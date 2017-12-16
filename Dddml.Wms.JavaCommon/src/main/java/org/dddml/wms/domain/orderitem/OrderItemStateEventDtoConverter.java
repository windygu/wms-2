package org.dddml.wms.domain.orderitem;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrderItemStateEventDtoConverter {

    public OrderItemStateEventDto toOrderItemStateEventDto(AbstractOrderItemStateEvent stateEvent) {
        if (stateEvent instanceof AbstractOrderItemStateEvent.AbstractOrderItemStateCreated) {
            OrderItemStateEvent.OrderItemStateCreated e = (OrderItemStateEvent.OrderItemStateCreated) stateEvent;
            return toOrderItemStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrderItemStateEvent.AbstractOrderItemStateMergePatched) {
            OrderItemStateEvent.OrderItemStateMergePatched e = (OrderItemStateEvent.OrderItemStateMergePatched) stateEvent;
            return toOrderItemStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public OrderItemStateEventDto.OrderItemStateCreatedDto toOrderItemStateCreatedDto(OrderItemStateEvent.OrderItemStateCreated e) {
        OrderItemStateEventDto.OrderItemStateCreatedDto dto = new OrderItemStateEventDto.OrderItemStateCreatedDto();
        dto.setStateEventId(new OrderItemStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setProductId(e.getProductId());
        dto.setExternalProductId(e.getExternalProductId());
        dto.setQuantity(e.getQuantity());
        dto.setCancelQuantity(e.getCancelQuantity());
        dto.setSelectedAmount(e.getSelectedAmount());
        dto.setExternalId(e.getExternalId());
        dto.setOrderItemTypeId(e.getOrderItemTypeId());
        dto.setOrderItemGroupSeqId(e.getOrderItemGroupSeqId());
        dto.setIsItemGroupPrimary(e.getIsItemGroupPrimary());
        dto.setFromInventoryItemId(e.getFromInventoryItemId());
        dto.setIsPromo(e.getIsPromo());
        dto.setQuoteId(e.getQuoteId());
        dto.setQuoteItemSeqId(e.getQuoteItemSeqId());
        dto.setShoppingListId(e.getShoppingListId());
        dto.setShoppingListItemSeqId(e.getShoppingListItemSeqId());
        dto.setUnitPrice(e.getUnitPrice());
        dto.setUnitListPrice(e.getUnitListPrice());
        dto.setUnitAverageCost(e.getUnitAverageCost());
        dto.setUnitRecurringPrice(e.getUnitRecurringPrice());
        dto.setIsModifiedPrice(e.getIsModifiedPrice());
        dto.setRecurringFreqUomId(e.getRecurringFreqUomId());
        dto.setItemDescription(e.getItemDescription());
        dto.setComments(e.getComments());
        dto.setCorrespondingPoId(e.getCorrespondingPoId());
        dto.setSyncStatusId(e.getSyncStatusId());
        dto.setEstimatedShipDate(e.getEstimatedShipDate());
        dto.setEstimatedDeliveryDate(e.getEstimatedDeliveryDate());
        dto.setAutoCancelDate(e.getAutoCancelDate());
        dto.setDontCancelSetDate(e.getDontCancelSetDate());
        dto.setDontCancelSetBy(e.getDontCancelSetBy());
        dto.setShipBeforeDate(e.getShipBeforeDate());
        dto.setShipAfterDate(e.getShipAfterDate());
        dto.setCancelBackOrderDate(e.getCancelBackOrderDate());
        dto.setOverrideGlAccountId(e.getOverrideGlAccountId());
        dto.setActive(e.getActive());
        return dto;
    }

    public OrderItemStateEventDto.OrderItemStateMergePatchedDto toOrderItemStateMergePatchedDto(OrderItemStateEvent.OrderItemStateMergePatched e) {
        OrderItemStateEventDto.OrderItemStateMergePatchedDto dto = new OrderItemStateEventDto.OrderItemStateMergePatchedDto();
        dto.setStateEventId(new OrderItemStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setProductId(e.getProductId());
        dto.setExternalProductId(e.getExternalProductId());
        dto.setQuantity(e.getQuantity());
        dto.setCancelQuantity(e.getCancelQuantity());
        dto.setSelectedAmount(e.getSelectedAmount());
        dto.setExternalId(e.getExternalId());
        dto.setOrderItemTypeId(e.getOrderItemTypeId());
        dto.setOrderItemGroupSeqId(e.getOrderItemGroupSeqId());
        dto.setIsItemGroupPrimary(e.getIsItemGroupPrimary());
        dto.setFromInventoryItemId(e.getFromInventoryItemId());
        dto.setIsPromo(e.getIsPromo());
        dto.setQuoteId(e.getQuoteId());
        dto.setQuoteItemSeqId(e.getQuoteItemSeqId());
        dto.setShoppingListId(e.getShoppingListId());
        dto.setShoppingListItemSeqId(e.getShoppingListItemSeqId());
        dto.setUnitPrice(e.getUnitPrice());
        dto.setUnitListPrice(e.getUnitListPrice());
        dto.setUnitAverageCost(e.getUnitAverageCost());
        dto.setUnitRecurringPrice(e.getUnitRecurringPrice());
        dto.setIsModifiedPrice(e.getIsModifiedPrice());
        dto.setRecurringFreqUomId(e.getRecurringFreqUomId());
        dto.setItemDescription(e.getItemDescription());
        dto.setComments(e.getComments());
        dto.setCorrespondingPoId(e.getCorrespondingPoId());
        dto.setSyncStatusId(e.getSyncStatusId());
        dto.setEstimatedShipDate(e.getEstimatedShipDate());
        dto.setEstimatedDeliveryDate(e.getEstimatedDeliveryDate());
        dto.setAutoCancelDate(e.getAutoCancelDate());
        dto.setDontCancelSetDate(e.getDontCancelSetDate());
        dto.setDontCancelSetBy(e.getDontCancelSetBy());
        dto.setShipBeforeDate(e.getShipBeforeDate());
        dto.setShipAfterDate(e.getShipAfterDate());
        dto.setCancelBackOrderDate(e.getCancelBackOrderDate());
        dto.setOverrideGlAccountId(e.getOverrideGlAccountId());
        dto.setActive(e.getActive());
        dto.setIsPropertyProductIdRemoved(e.getIsPropertyProductIdRemoved());
        dto.setIsPropertyExternalProductIdRemoved(e.getIsPropertyExternalProductIdRemoved());
        dto.setIsPropertyQuantityRemoved(e.getIsPropertyQuantityRemoved());
        dto.setIsPropertyCancelQuantityRemoved(e.getIsPropertyCancelQuantityRemoved());
        dto.setIsPropertySelectedAmountRemoved(e.getIsPropertySelectedAmountRemoved());
        dto.setIsPropertyExternalIdRemoved(e.getIsPropertyExternalIdRemoved());
        dto.setIsPropertyOrderItemTypeIdRemoved(e.getIsPropertyOrderItemTypeIdRemoved());
        dto.setIsPropertyOrderItemGroupSeqIdRemoved(e.getIsPropertyOrderItemGroupSeqIdRemoved());
        dto.setIsPropertyIsItemGroupPrimaryRemoved(e.getIsPropertyIsItemGroupPrimaryRemoved());
        dto.setIsPropertyFromInventoryItemIdRemoved(e.getIsPropertyFromInventoryItemIdRemoved());
        dto.setIsPropertyIsPromoRemoved(e.getIsPropertyIsPromoRemoved());
        dto.setIsPropertyQuoteIdRemoved(e.getIsPropertyQuoteIdRemoved());
        dto.setIsPropertyQuoteItemSeqIdRemoved(e.getIsPropertyQuoteItemSeqIdRemoved());
        dto.setIsPropertyShoppingListIdRemoved(e.getIsPropertyShoppingListIdRemoved());
        dto.setIsPropertyShoppingListItemSeqIdRemoved(e.getIsPropertyShoppingListItemSeqIdRemoved());
        dto.setIsPropertyUnitPriceRemoved(e.getIsPropertyUnitPriceRemoved());
        dto.setIsPropertyUnitListPriceRemoved(e.getIsPropertyUnitListPriceRemoved());
        dto.setIsPropertyUnitAverageCostRemoved(e.getIsPropertyUnitAverageCostRemoved());
        dto.setIsPropertyUnitRecurringPriceRemoved(e.getIsPropertyUnitRecurringPriceRemoved());
        dto.setIsPropertyIsModifiedPriceRemoved(e.getIsPropertyIsModifiedPriceRemoved());
        dto.setIsPropertyRecurringFreqUomIdRemoved(e.getIsPropertyRecurringFreqUomIdRemoved());
        dto.setIsPropertyItemDescriptionRemoved(e.getIsPropertyItemDescriptionRemoved());
        dto.setIsPropertyCommentsRemoved(e.getIsPropertyCommentsRemoved());
        dto.setIsPropertyCorrespondingPoIdRemoved(e.getIsPropertyCorrespondingPoIdRemoved());
        dto.setIsPropertySyncStatusIdRemoved(e.getIsPropertySyncStatusIdRemoved());
        dto.setIsPropertyEstimatedShipDateRemoved(e.getIsPropertyEstimatedShipDateRemoved());
        dto.setIsPropertyEstimatedDeliveryDateRemoved(e.getIsPropertyEstimatedDeliveryDateRemoved());
        dto.setIsPropertyAutoCancelDateRemoved(e.getIsPropertyAutoCancelDateRemoved());
        dto.setIsPropertyDontCancelSetDateRemoved(e.getIsPropertyDontCancelSetDateRemoved());
        dto.setIsPropertyDontCancelSetByRemoved(e.getIsPropertyDontCancelSetByRemoved());
        dto.setIsPropertyShipBeforeDateRemoved(e.getIsPropertyShipBeforeDateRemoved());
        dto.setIsPropertyShipAfterDateRemoved(e.getIsPropertyShipAfterDateRemoved());
        dto.setIsPropertyCancelBackOrderDateRemoved(e.getIsPropertyCancelBackOrderDateRemoved());
        dto.setIsPropertyOverrideGlAccountIdRemoved(e.getIsPropertyOverrideGlAccountIdRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


}

