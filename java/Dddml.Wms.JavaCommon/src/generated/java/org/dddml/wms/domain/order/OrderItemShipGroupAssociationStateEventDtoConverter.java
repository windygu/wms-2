package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrderItemShipGroupAssociationStateEventDtoConverter {

    public OrderItemShipGroupAssociationStateEventDto toOrderItemShipGroupAssociationStateEventDto(AbstractOrderItemShipGroupAssociationEvent stateEvent) {
        if (stateEvent instanceof AbstractOrderItemShipGroupAssociationEvent.AbstractOrderItemShipGroupAssociationStateCreated) {
            OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated e = (OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated) stateEvent;
            return toOrderItemShipGroupAssociationStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrderItemShipGroupAssociationEvent.AbstractOrderItemShipGroupAssociationStateMergePatched) {
            OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateMergePatched e = (OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateMergePatched) stateEvent;
            return toOrderItemShipGroupAssociationStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractOrderItemShipGroupAssociationEvent.AbstractOrderItemShipGroupAssociationStateRemoved) {
            OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved e = (OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved) stateEvent;
            return toOrderItemShipGroupAssociationStateRemovedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public OrderItemShipGroupAssociationStateEventDto.OrderItemShipGroupAssociationStateCreatedDto toOrderItemShipGroupAssociationStateCreatedDto(OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated e) {
        OrderItemShipGroupAssociationStateEventDto.OrderItemShipGroupAssociationStateCreatedDto dto = new OrderItemShipGroupAssociationStateEventDto.OrderItemShipGroupAssociationStateCreatedDto();
        dto.setOrderItemShipGroupAssociationEventId(e.getOrderItemShipGroupAssociationEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setQuantity(e.getQuantity());
        dto.setCancelQuantity(e.getCancelQuantity());
        dto.setActive(e.getActive());
        return dto;
    }

    public OrderItemShipGroupAssociationStateEventDto.OrderItemShipGroupAssociationStateMergePatchedDto toOrderItemShipGroupAssociationStateMergePatchedDto(OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateMergePatched e) {
        OrderItemShipGroupAssociationStateEventDto.OrderItemShipGroupAssociationStateMergePatchedDto dto = new OrderItemShipGroupAssociationStateEventDto.OrderItemShipGroupAssociationStateMergePatchedDto();
        dto.setOrderItemShipGroupAssociationEventId(e.getOrderItemShipGroupAssociationEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setQuantity(e.getQuantity());
        dto.setCancelQuantity(e.getCancelQuantity());
        dto.setActive(e.getActive());
        dto.setIsPropertyQuantityRemoved(e.getIsPropertyQuantityRemoved());
        dto.setIsPropertyCancelQuantityRemoved(e.getIsPropertyCancelQuantityRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public OrderItemShipGroupAssociationStateEventDto.OrderItemShipGroupAssociationStateRemovedDto toOrderItemShipGroupAssociationStateRemovedDto(OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved e) {
        OrderItemShipGroupAssociationStateEventDto.OrderItemShipGroupAssociationStateRemovedDto dto = new OrderItemShipGroupAssociationStateEventDto.OrderItemShipGroupAssociationStateRemovedDto();
        dto.setOrderItemShipGroupAssociationEventId(e.getOrderItemShipGroupAssociationEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

