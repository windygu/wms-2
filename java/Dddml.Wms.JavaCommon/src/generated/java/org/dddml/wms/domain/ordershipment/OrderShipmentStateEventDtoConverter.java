package org.dddml.wms.domain.ordershipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrderShipmentStateEventDtoConverter {

    public OrderShipmentStateEventDto toOrderShipmentStateEventDto(AbstractOrderShipmentEvent stateEvent) {
        if (stateEvent instanceof AbstractOrderShipmentEvent.AbstractOrderShipmentStateCreated) {
            OrderShipmentEvent.OrderShipmentStateCreated e = (OrderShipmentEvent.OrderShipmentStateCreated) stateEvent;
            return toOrderShipmentStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrderShipmentEvent.AbstractOrderShipmentStateMergePatched) {
            OrderShipmentEvent.OrderShipmentStateMergePatched e = (OrderShipmentEvent.OrderShipmentStateMergePatched) stateEvent;
            return toOrderShipmentStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public OrderShipmentStateEventDto.OrderShipmentStateCreatedDto toOrderShipmentStateCreatedDto(OrderShipmentEvent.OrderShipmentStateCreated e) {
        OrderShipmentStateEventDto.OrderShipmentStateCreatedDto dto = new OrderShipmentStateEventDto.OrderShipmentStateCreatedDto();
        dto.setOrderShipmentEventId(e.getOrderShipmentEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setQuantity(e.getQuantity());
        dto.setActive(e.getActive());
        return dto;
    }

    public OrderShipmentStateEventDto.OrderShipmentStateMergePatchedDto toOrderShipmentStateMergePatchedDto(OrderShipmentEvent.OrderShipmentStateMergePatched e) {
        OrderShipmentStateEventDto.OrderShipmentStateMergePatchedDto dto = new OrderShipmentStateEventDto.OrderShipmentStateMergePatchedDto();
        dto.setOrderShipmentEventId(e.getOrderShipmentEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setQuantity(e.getQuantity());
        dto.setActive(e.getActive());
        dto.setIsPropertyQuantityRemoved(e.getIsPropertyQuantityRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


}

