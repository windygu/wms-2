package org.dddml.wms.domain.order;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrderRoleStateEventDtoConverter {

    public OrderRoleStateEventDto toOrderRoleStateEventDto(AbstractOrderRoleEvent stateEvent) {
        if (stateEvent instanceof AbstractOrderRoleEvent.AbstractOrderRoleStateCreated) {
            OrderRoleEvent.OrderRoleStateCreated e = (OrderRoleEvent.OrderRoleStateCreated) stateEvent;
            return toOrderRoleStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrderRoleEvent.AbstractOrderRoleStateMergePatched) {
            OrderRoleEvent.OrderRoleStateMergePatched e = (OrderRoleEvent.OrderRoleStateMergePatched) stateEvent;
            return toOrderRoleStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractOrderRoleEvent.AbstractOrderRoleStateRemoved) {
            OrderRoleEvent.OrderRoleStateRemoved e = (OrderRoleEvent.OrderRoleStateRemoved) stateEvent;
            return toOrderRoleStateRemovedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public OrderRoleStateEventDto.OrderRoleStateCreatedDto toOrderRoleStateCreatedDto(OrderRoleEvent.OrderRoleStateCreated e) {
        OrderRoleStateEventDto.OrderRoleStateCreatedDto dto = new OrderRoleStateEventDto.OrderRoleStateCreatedDto();
        dto.setOrderRoleEventId(e.getOrderRoleEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        return dto;
    }

    public OrderRoleStateEventDto.OrderRoleStateMergePatchedDto toOrderRoleStateMergePatchedDto(OrderRoleEvent.OrderRoleStateMergePatched e) {
        OrderRoleStateEventDto.OrderRoleStateMergePatchedDto dto = new OrderRoleStateEventDto.OrderRoleStateMergePatchedDto();
        dto.setOrderRoleEventId(e.getOrderRoleEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public OrderRoleStateEventDto.OrderRoleStateRemovedDto toOrderRoleStateRemovedDto(OrderRoleEvent.OrderRoleStateRemoved e) {
        OrderRoleStateEventDto.OrderRoleStateRemovedDto dto = new OrderRoleStateEventDto.OrderRoleStateRemovedDto();
        dto.setOrderRoleEventId(e.getOrderRoleEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

