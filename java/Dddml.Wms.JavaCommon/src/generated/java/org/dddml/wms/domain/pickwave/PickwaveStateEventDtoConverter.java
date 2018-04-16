package org.dddml.wms.domain.pickwave;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PickwaveStateEventDtoConverter {

    public PickwaveStateEventDto toPickwaveStateEventDto(AbstractPickwaveEvent stateEvent) {
        if (stateEvent instanceof AbstractPickwaveEvent.AbstractPickwaveStateCreated) {
            PickwaveEvent.PickwaveStateCreated e = (PickwaveEvent.PickwaveStateCreated) stateEvent;
            return toPickwaveStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPickwaveEvent.AbstractPickwaveStateMergePatched) {
            PickwaveEvent.PickwaveStateMergePatched e = (PickwaveEvent.PickwaveStateMergePatched) stateEvent;
            return toPickwaveStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractPickwaveEvent.AbstractPickwaveStateDeleted) {
            PickwaveEvent.PickwaveStateDeleted e = (PickwaveEvent.PickwaveStateDeleted) stateEvent;
            return toPickwaveStateDeletedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public PickwaveStateEventDto.PickwaveStateCreatedDto toPickwaveStateCreatedDto(PickwaveEvent.PickwaveStateCreated e) {
        PickwaveStateEventDto.PickwaveStateCreatedDto dto = new PickwaveStateEventDto.PickwaveStateCreatedDto();
        dto.setPickwaveEventId(e.getPickwaveEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setStatusId(e.getStatusId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public PickwaveStateEventDto.PickwaveStateMergePatchedDto toPickwaveStateMergePatchedDto(PickwaveEvent.PickwaveStateMergePatched e) {
        PickwaveStateEventDto.PickwaveStateMergePatchedDto dto = new PickwaveStateEventDto.PickwaveStateMergePatchedDto();
        dto.setPickwaveEventId(e.getPickwaveEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setStatusId(e.getStatusId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyStatusIdRemoved(e.getIsPropertyStatusIdRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public PickwaveStateEventDto.PickwaveStateDeletedDto toPickwaveStateDeletedDto(PickwaveEvent.PickwaveStateDeleted e) {
        PickwaveStateEventDto.PickwaveStateDeletedDto dto = new PickwaveStateEventDto.PickwaveStateDeletedDto();
        dto.setPickwaveEventId(e.getPickwaveEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

