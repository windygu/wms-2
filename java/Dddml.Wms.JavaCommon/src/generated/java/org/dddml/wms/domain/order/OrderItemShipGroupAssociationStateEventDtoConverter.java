package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrderItemShipGroupAssociationStateEventDtoConverter {

    public OrderItemShipGroupAssociationStateEventDto toOrderItemShipGroupAssociationStateEventDto(AbstractOrderItemShipGroupAssociationStateEvent stateEvent) {
        if (stateEvent instanceof AbstractOrderItemShipGroupAssociationStateEvent.AbstractOrderItemShipGroupAssociationStateCreated) {
            OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateCreated e = (OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateCreated) stateEvent;
            return toOrderItemShipGroupAssociationStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrderItemShipGroupAssociationStateEvent.AbstractOrderItemShipGroupAssociationStateMergePatched) {
            OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateMergePatched e = (OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateMergePatched) stateEvent;
            return toOrderItemShipGroupAssociationStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractOrderItemShipGroupAssociationStateEvent.AbstractOrderItemShipGroupAssociationStateRemoved) {
            OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateRemoved e = (OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateRemoved) stateEvent;
            return toOrderItemShipGroupAssociationStateRemovedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public OrderItemShipGroupAssociationStateEventDto.OrderItemShipGroupAssociationStateCreatedDto toOrderItemShipGroupAssociationStateCreatedDto(OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateCreated e) {
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

    public OrderItemShipGroupAssociationStateEventDto.OrderItemShipGroupAssociationStateMergePatchedDto toOrderItemShipGroupAssociationStateMergePatchedDto(OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateMergePatched e) {
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


    public OrderItemShipGroupAssociationStateEventDto.OrderItemShipGroupAssociationStateRemovedDto toOrderItemShipGroupAssociationStateRemovedDto(OrderItemShipGroupAssociationStateEvent.OrderItemShipGroupAssociationStateRemoved e) {
        OrderItemShipGroupAssociationStateEventDto.OrderItemShipGroupAssociationStateRemovedDto dto = new OrderItemShipGroupAssociationStateEventDto.OrderItemShipGroupAssociationStateRemovedDto();
        dto.setOrderItemShipGroupAssociationEventId(e.getOrderItemShipGroupAssociationEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

