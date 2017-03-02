package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class WarehouseStateEventDtoConverter {

    public WarehouseStateEventDto toWarehouseStateEventDto(AbstractWarehouseStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            WarehouseStateEvent.WarehouseStateCreated e = (WarehouseStateEvent.WarehouseStateCreated) stateEvent;
            return toWarehouseStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            WarehouseStateEvent.WarehouseStateMergePatched e = (WarehouseStateEvent.WarehouseStateMergePatched) stateEvent;
            return toWarehouseStateMergePatchedDto(e);
        } else if (StateEventType.DELETED.equals(stateEvent.getStateEventType())) {
            WarehouseStateEvent.WarehouseStateDeleted e = (WarehouseStateEvent.WarehouseStateDeleted) stateEvent;
            return toWarehouseStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public WarehouseStateEventDto.WarehouseStateCreatedDto toWarehouseStateCreatedDto(WarehouseStateEvent.WarehouseStateCreated e) {
        WarehouseStateEventDto.WarehouseStateCreatedDto dto = new WarehouseStateEventDto.WarehouseStateCreatedDto();
        dto.setStateEventId(new WarehouseStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setDescription(e.getDescription());
        dto.setIsInTransit(e.getIsInTransit());
        dto.setActive(e.getActive());
        return dto;
    }

    public WarehouseStateEventDto.WarehouseStateMergePatchedDto toWarehouseStateMergePatchedDto(WarehouseStateEvent.WarehouseStateMergePatched e) {
        WarehouseStateEventDto.WarehouseStateMergePatchedDto dto = new WarehouseStateEventDto.WarehouseStateMergePatchedDto();
        dto.setStateEventId(new WarehouseStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setDescription(e.getDescription());
        dto.setIsInTransit(e.getIsInTransit());
        dto.setActive(e.getActive());
        dto.setIsPropertyNameRemoved(e.getIsPropertyNameRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyIsInTransitRemoved(e.getIsPropertyIsInTransitRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public WarehouseStateEventDto.WarehouseStateDeletedDto toWarehouseStateDeletedDto(WarehouseStateEvent.WarehouseStateDeleted e) {
        WarehouseStateEventDto.WarehouseStateDeletedDto dto = new WarehouseStateEventDto.WarehouseStateDeletedDto();
        dto.setStateEventId(new WarehouseStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

