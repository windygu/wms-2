package org.dddml.wms.domain.ordershipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrderShipmentStateEventDtoConverter {

    public OrderShipmentStateEventDto toOrderShipmentStateEventDto(AbstractOrderShipmentStateEvent stateEvent) {
        if (stateEvent instanceof AbstractOrderShipmentStateEvent.AbstractOrderShipmentStateCreated) {
            OrderShipmentStateEvent.OrderShipmentStateCreated e = (OrderShipmentStateEvent.OrderShipmentStateCreated) stateEvent;
            return toOrderShipmentStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrderShipmentStateEvent.AbstractOrderShipmentStateMergePatched) {
            OrderShipmentStateEvent.OrderShipmentStateMergePatched e = (OrderShipmentStateEvent.OrderShipmentStateMergePatched) stateEvent;
            return toOrderShipmentStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public OrderShipmentStateEventDto.OrderShipmentStateCreatedDto toOrderShipmentStateCreatedDto(OrderShipmentStateEvent.OrderShipmentStateCreated e) {
        OrderShipmentStateEventDto.OrderShipmentStateCreatedDto dto = new OrderShipmentStateEventDto.OrderShipmentStateCreatedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setQuantity(e.getQuantity());
        dto.setActive(e.getActive());
        return dto;
    }

    public OrderShipmentStateEventDto.OrderShipmentStateMergePatchedDto toOrderShipmentStateMergePatchedDto(OrderShipmentStateEvent.OrderShipmentStateMergePatched e) {
        OrderShipmentStateEventDto.OrderShipmentStateMergePatchedDto dto = new OrderShipmentStateEventDto.OrderShipmentStateMergePatchedDto();
        dto.setStateEventId(e.getStateEventId());
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

