package org.dddml.wms.domain.warehouse;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class WarehouseStateEventDtoConverter {

    public WarehouseStateEventDto toWarehouseStateEventDto(AbstractWarehouseEvent stateEvent) {
        if (stateEvent instanceof AbstractWarehouseEvent.AbstractWarehouseStateCreated) {
            WarehouseEvent.WarehouseStateCreated e = (WarehouseEvent.WarehouseStateCreated) stateEvent;
            return toWarehouseStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractWarehouseEvent.AbstractWarehouseStateMergePatched) {
            WarehouseEvent.WarehouseStateMergePatched e = (WarehouseEvent.WarehouseStateMergePatched) stateEvent;
            return toWarehouseStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractWarehouseEvent.AbstractWarehouseStateDeleted) {
            WarehouseEvent.WarehouseStateDeleted e = (WarehouseEvent.WarehouseStateDeleted) stateEvent;
            return toWarehouseStateDeletedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public WarehouseStateEventDto.WarehouseStateCreatedDto toWarehouseStateCreatedDto(WarehouseEvent.WarehouseStateCreated e) {
        WarehouseStateEventDto.WarehouseStateCreatedDto dto = new WarehouseStateEventDto.WarehouseStateCreatedDto();
        dto.setWarehouseEventId(e.getWarehouseEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setWarehouseName(e.getWarehouseName());
        dto.setDescription(e.getDescription());
        dto.setIsInTransit(e.getIsInTransit());
        dto.setActive(e.getActive());
        return dto;
    }

    public WarehouseStateEventDto.WarehouseStateMergePatchedDto toWarehouseStateMergePatchedDto(WarehouseEvent.WarehouseStateMergePatched e) {
        WarehouseStateEventDto.WarehouseStateMergePatchedDto dto = new WarehouseStateEventDto.WarehouseStateMergePatchedDto();
        dto.setWarehouseEventId(e.getWarehouseEventId());
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


    public WarehouseStateEventDto.WarehouseStateDeletedDto toWarehouseStateDeletedDto(WarehouseEvent.WarehouseStateDeleted e) {
        WarehouseStateEventDto.WarehouseStateDeletedDto dto = new WarehouseStateEventDto.WarehouseStateDeletedDto();
        dto.setWarehouseEventId(e.getWarehouseEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

