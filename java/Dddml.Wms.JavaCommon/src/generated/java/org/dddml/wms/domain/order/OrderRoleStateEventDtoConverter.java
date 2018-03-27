package org.dddml.wms.domain.order;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class OrderRoleStateEventDtoConverter {

    public OrderRoleStateEventDto toOrderRoleStateEventDto(AbstractOrderRoleStateEvent stateEvent) {
        if (stateEvent instanceof AbstractOrderRoleStateEvent.AbstractOrderRoleStateCreated) {
            OrderRoleStateEvent.OrderRoleStateCreated e = (OrderRoleStateEvent.OrderRoleStateCreated) stateEvent;
            return toOrderRoleStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractOrderRoleStateEvent.AbstractOrderRoleStateMergePatched) {
            OrderRoleStateEvent.OrderRoleStateMergePatched e = (OrderRoleStateEvent.OrderRoleStateMergePatched) stateEvent;
            return toOrderRoleStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractOrderRoleStateEvent.AbstractOrderRoleStateRemoved) {
            OrderRoleStateEvent.OrderRoleStateRemoved e = (OrderRoleStateEvent.OrderRoleStateRemoved) stateEvent;
            return toOrderRoleStateRemovedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public OrderRoleStateEventDto.OrderRoleStateCreatedDto toOrderRoleStateCreatedDto(OrderRoleStateEvent.OrderRoleStateCreated e) {
        OrderRoleStateEventDto.OrderRoleStateCreatedDto dto = new OrderRoleStateEventDto.OrderRoleStateCreatedDto();
        dto.setOrderRoleEventId(e.getOrderRoleEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        return dto;
    }

    public OrderRoleStateEventDto.OrderRoleStateMergePatchedDto toOrderRoleStateMergePatchedDto(OrderRoleStateEvent.OrderRoleStateMergePatched e) {
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


    public OrderRoleStateEventDto.OrderRoleStateRemovedDto toOrderRoleStateRemovedDto(OrderRoleStateEvent.OrderRoleStateRemoved e) {
        OrderRoleStateEventDto.OrderRoleStateRemovedDto dto = new OrderRoleStateEventDto.OrderRoleStateRemovedDto();
        dto.setOrderRoleEventId(e.getOrderRoleEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

