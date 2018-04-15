package org.dddml.wms.domain.orderitemshipgrpinvreservation;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrderItemShipGrpInvReservationStateEventDtoConverter {

    public OrderItemShipGrpInvReservationStateEventDto toOrderItemShipGrpInvReservationStateEventDto(AbstractOrderItemShipGrpInvReservationEvent stateEvent) {
        if (stateEvent instanceof AbstractOrderItemShipGrpInvReservationEvent.AbstractOrderItemShipGrpInvReservationStateCreated) {
            OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateCreated e = (OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateCreated) stateEvent;
            return toOrderItemShipGrpInvReservationStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrderItemShipGrpInvReservationEvent.AbstractOrderItemShipGrpInvReservationStateMergePatched) {
            OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateMergePatched e = (OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateMergePatched) stateEvent;
            return toOrderItemShipGrpInvReservationStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractOrderItemShipGrpInvReservationEvent.AbstractOrderItemShipGrpInvReservationStateDeleted) {
            OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateDeleted e = (OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateDeleted) stateEvent;
            return toOrderItemShipGrpInvReservationStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public OrderItemShipGrpInvReservationStateEventDto.OrderItemShipGrpInvReservationStateCreatedDto toOrderItemShipGrpInvReservationStateCreatedDto(OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateCreated e) {
        OrderItemShipGrpInvReservationStateEventDto.OrderItemShipGrpInvReservationStateCreatedDto dto = new OrderItemShipGrpInvReservationStateEventDto.OrderItemShipGrpInvReservationStateCreatedDto();
        dto.setOrderItemShipGrpInvReservationEventId(e.getOrderItemShipGrpInvReservationEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setReserveOrderEnumId(e.getReserveOrderEnumId());
        dto.setQuantity(e.getQuantity());
        dto.setQuantityNotAvailable(e.getQuantityNotAvailable());
        dto.setReservedDatetime(e.getReservedDatetime());
        dto.setCreatedDatetime(e.getCreatedDatetime());
        dto.setPromisedDatetime(e.getPromisedDatetime());
        dto.setCurrentPromisedDate(e.getCurrentPromisedDate());
        dto.setPriority(e.getPriority());
        dto.setSequenceId(e.getSequenceId());
        dto.setOldPickStartDate(e.getOldPickStartDate());
        dto.setActive(e.getActive());
        return dto;
    }

    public OrderItemShipGrpInvReservationStateEventDto.OrderItemShipGrpInvReservationStateMergePatchedDto toOrderItemShipGrpInvReservationStateMergePatchedDto(OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateMergePatched e) {
        OrderItemShipGrpInvReservationStateEventDto.OrderItemShipGrpInvReservationStateMergePatchedDto dto = new OrderItemShipGrpInvReservationStateEventDto.OrderItemShipGrpInvReservationStateMergePatchedDto();
        dto.setOrderItemShipGrpInvReservationEventId(e.getOrderItemShipGrpInvReservationEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setReserveOrderEnumId(e.getReserveOrderEnumId());
        dto.setQuantity(e.getQuantity());
        dto.setQuantityNotAvailable(e.getQuantityNotAvailable());
        dto.setReservedDatetime(e.getReservedDatetime());
        dto.setCreatedDatetime(e.getCreatedDatetime());
        dto.setPromisedDatetime(e.getPromisedDatetime());
        dto.setCurrentPromisedDate(e.getCurrentPromisedDate());
        dto.setPriority(e.getPriority());
        dto.setSequenceId(e.getSequenceId());
        dto.setOldPickStartDate(e.getOldPickStartDate());
        dto.setActive(e.getActive());
        dto.setIsPropertyReserveOrderEnumIdRemoved(e.getIsPropertyReserveOrderEnumIdRemoved());
        dto.setIsPropertyQuantityRemoved(e.getIsPropertyQuantityRemoved());
        dto.setIsPropertyQuantityNotAvailableRemoved(e.getIsPropertyQuantityNotAvailableRemoved());
        dto.setIsPropertyReservedDatetimeRemoved(e.getIsPropertyReservedDatetimeRemoved());
        dto.setIsPropertyCreatedDatetimeRemoved(e.getIsPropertyCreatedDatetimeRemoved());
        dto.setIsPropertyPromisedDatetimeRemoved(e.getIsPropertyPromisedDatetimeRemoved());
        dto.setIsPropertyCurrentPromisedDateRemoved(e.getIsPropertyCurrentPromisedDateRemoved());
        dto.setIsPropertyPriorityRemoved(e.getIsPropertyPriorityRemoved());
        dto.setIsPropertySequenceIdRemoved(e.getIsPropertySequenceIdRemoved());
        dto.setIsPropertyOldPickStartDateRemoved(e.getIsPropertyOldPickStartDateRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public OrderItemShipGrpInvReservationStateEventDto.OrderItemShipGrpInvReservationStateDeletedDto toOrderItemShipGrpInvReservationStateDeletedDto(OrderItemShipGrpInvReservationEvent.OrderItemShipGrpInvReservationStateDeleted e) {
        OrderItemShipGrpInvReservationStateEventDto.OrderItemShipGrpInvReservationStateDeletedDto dto = new OrderItemShipGrpInvReservationStateEventDto.OrderItemShipGrpInvReservationStateDeletedDto();
        dto.setOrderItemShipGrpInvReservationEventId(e.getOrderItemShipGrpInvReservationEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

