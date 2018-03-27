package org.dddml.wms.domain.pickwave;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PickwaveStateEventDtoConverter {

    public PickwaveStateEventDto toPickwaveStateEventDto(AbstractPickwaveStateEvent stateEvent) {
        if (stateEvent instanceof AbstractPickwaveStateEvent.AbstractPickwaveStateCreated) {
            PickwaveStateEvent.PickwaveStateCreated e = (PickwaveStateEvent.PickwaveStateCreated) stateEvent;
            return toPickwaveStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPickwaveStateEvent.AbstractPickwaveStateMergePatched) {
            PickwaveStateEvent.PickwaveStateMergePatched e = (PickwaveStateEvent.PickwaveStateMergePatched) stateEvent;
            return toPickwaveStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractPickwaveStateEvent.AbstractPickwaveStateDeleted) {
            PickwaveStateEvent.PickwaveStateDeleted e = (PickwaveStateEvent.PickwaveStateDeleted) stateEvent;
            return toPickwaveStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public PickwaveStateEventDto.PickwaveStateCreatedDto toPickwaveStateCreatedDto(PickwaveStateEvent.PickwaveStateCreated e) {
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

    public PickwaveStateEventDto.PickwaveStateMergePatchedDto toPickwaveStateMergePatchedDto(PickwaveStateEvent.PickwaveStateMergePatched e) {
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


    public PickwaveStateEventDto.PickwaveStateDeletedDto toPickwaveStateDeletedDto(PickwaveStateEvent.PickwaveStateDeleted e) {
        PickwaveStateEventDto.PickwaveStateDeletedDto dto = new PickwaveStateEventDto.PickwaveStateDeletedDto();
        dto.setPickwaveEventId(e.getPickwaveEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

