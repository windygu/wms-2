package org.dddml.wms.domain.movementtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class MovementTypeStateEventDtoConverter {

    public MovementTypeStateEventDto toMovementTypeStateEventDto(AbstractMovementTypeStateEvent stateEvent) {
        if (stateEvent instanceof AbstractMovementTypeStateEvent.AbstractMovementTypeStateCreated) {
            MovementTypeStateEvent.MovementTypeStateCreated e = (MovementTypeStateEvent.MovementTypeStateCreated) stateEvent;
            return toMovementTypeStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractMovementTypeStateEvent.AbstractMovementTypeStateMergePatched) {
            MovementTypeStateEvent.MovementTypeStateMergePatched e = (MovementTypeStateEvent.MovementTypeStateMergePatched) stateEvent;
            return toMovementTypeStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractMovementTypeStateEvent.AbstractMovementTypeStateDeleted) {
            MovementTypeStateEvent.MovementTypeStateDeleted e = (MovementTypeStateEvent.MovementTypeStateDeleted) stateEvent;
            return toMovementTypeStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public MovementTypeStateEventDto.MovementTypeStateCreatedDto toMovementTypeStateCreatedDto(MovementTypeStateEvent.MovementTypeStateCreated e) {
        MovementTypeStateEventDto.MovementTypeStateCreatedDto dto = new MovementTypeStateEventDto.MovementTypeStateCreatedDto();
        dto.setStateEventId(new MovementTypeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public MovementTypeStateEventDto.MovementTypeStateMergePatchedDto toMovementTypeStateMergePatchedDto(MovementTypeStateEvent.MovementTypeStateMergePatched e) {
        MovementTypeStateEventDto.MovementTypeStateMergePatchedDto dto = new MovementTypeStateEventDto.MovementTypeStateMergePatchedDto();
        dto.setStateEventId(new MovementTypeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public MovementTypeStateEventDto.MovementTypeStateDeletedDto toMovementTypeStateDeletedDto(MovementTypeStateEvent.MovementTypeStateDeleted e) {
        MovementTypeStateEventDto.MovementTypeStateDeletedDto dto = new MovementTypeStateEventDto.MovementTypeStateDeletedDto();
        dto.setStateEventId(new MovementTypeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

