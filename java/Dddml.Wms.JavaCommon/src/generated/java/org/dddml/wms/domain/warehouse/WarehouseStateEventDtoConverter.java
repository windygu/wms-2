package org.dddml.wms.domain.warehouse;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class WarehouseStateEventDtoConverter {

    public WarehouseStateEventDto toWarehouseStateEventDto(AbstractWarehouseStateEvent stateEvent) {
        if (stateEvent instanceof AbstractWarehouseStateEvent.AbstractWarehouseStateCreated) {
            WarehouseStateEvent.WarehouseStateCreated e = (WarehouseStateEvent.WarehouseStateCreated) stateEvent;
            return toWarehouseStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractWarehouseStateEvent.AbstractWarehouseStateMergePatched) {
            WarehouseStateEvent.WarehouseStateMergePatched e = (WarehouseStateEvent.WarehouseStateMergePatched) stateEvent;
            return toWarehouseStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractWarehouseStateEvent.AbstractWarehouseStateDeleted) {
            WarehouseStateEvent.WarehouseStateDeleted e = (WarehouseStateEvent.WarehouseStateDeleted) stateEvent;
            return toWarehouseStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public WarehouseStateEventDto.WarehouseStateCreatedDto toWarehouseStateCreatedDto(WarehouseStateEvent.WarehouseStateCreated e) {
        WarehouseStateEventDto.WarehouseStateCreatedDto dto = new WarehouseStateEventDto.WarehouseStateCreatedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setWarehouseName(e.getWarehouseName());
        dto.setDescription(e.getDescription());
        dto.setIsInTransit(e.getIsInTransit());
        dto.setActive(e.getActive());
        return dto;
    }

    public WarehouseStateEventDto.WarehouseStateMergePatchedDto toWarehouseStateMergePatchedDto(WarehouseStateEvent.WarehouseStateMergePatched e) {
        WarehouseStateEventDto.WarehouseStateMergePatchedDto dto = new WarehouseStateEventDto.WarehouseStateMergePatchedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setWarehouseName(e.getWarehouseName());
        dto.setDescription(e.getDescription());
        dto.setIsInTransit(e.getIsInTransit());
        dto.setActive(e.getActive());
        dto.setIsPropertyWarehouseNameRemoved(e.getIsPropertyWarehouseNameRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyIsInTransitRemoved(e.getIsPropertyIsInTransitRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public WarehouseStateEventDto.WarehouseStateDeletedDto toWarehouseStateDeletedDto(WarehouseStateEvent.WarehouseStateDeleted e) {
        WarehouseStateEventDto.WarehouseStateDeletedDto dto = new WarehouseStateEventDto.WarehouseStateDeletedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

