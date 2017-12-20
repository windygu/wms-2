package org.dddml.wms.domain.movement;

import java.util.*;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class MovementStateEventDtoConverter {

    public MovementStateEventDto toMovementStateEventDto(AbstractMovementStateEvent stateEvent) {
        if (stateEvent instanceof AbstractMovementStateEvent.AbstractMovementStateCreated) {
            MovementStateEvent.MovementStateCreated e = (MovementStateEvent.MovementStateCreated) stateEvent;
            return toMovementStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractMovementStateEvent.AbstractMovementStateMergePatched) {
            MovementStateEvent.MovementStateMergePatched e = (MovementStateEvent.MovementStateMergePatched) stateEvent;
            return toMovementStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractMovementStateEvent.AbstractMovementStateDeleted) {
            MovementStateEvent.MovementStateDeleted e = (MovementStateEvent.MovementStateDeleted) stateEvent;
            return toMovementStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public MovementStateEventDto.MovementStateCreatedDto toMovementStateCreatedDto(MovementStateEvent.MovementStateCreated e) {
        MovementStateEventDto.MovementStateCreatedDto dto = new MovementStateEventDto.MovementStateCreatedDto();
        dto.setStateEventId(new MovementStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDocumentTypeId(e.getDocumentTypeId());
        dto.setDocumentStatusId(e.getDocumentStatusId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        List<MovementLineStateEventDto.MovementLineStateCreatedDto> movementLineEvents = new ArrayList<>();
        for (MovementLineStateEvent.MovementLineStateCreated ee : e.getMovementLineEvents()) {
            MovementLineStateEventDto.MovementLineStateCreatedDto eeDto = getMovementLineStateEventDtoConverter().toMovementLineStateCreatedDto(ee);
            movementLineEvents.add(eeDto);
        }
        dto.setMovementLineEvents(movementLineEvents.toArray(new MovementLineStateEventDto.MovementLineStateCreatedDto[0]));

        return dto;
    }

    public MovementStateEventDto.MovementStateMergePatchedDto toMovementStateMergePatchedDto(MovementStateEvent.MovementStateMergePatched e) {
        MovementStateEventDto.MovementStateMergePatchedDto dto = new MovementStateEventDto.MovementStateMergePatchedDto();
        dto.setStateEventId(new MovementStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDocumentTypeId(e.getDocumentTypeId());
        dto.setDocumentStatusId(e.getDocumentStatusId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyDocumentTypeIdRemoved(e.getIsPropertyDocumentTypeIdRemoved());
        dto.setIsPropertyDocumentStatusIdRemoved(e.getIsPropertyDocumentStatusIdRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        List<MovementLineStateEventDto> movementLineEvents = new ArrayList<>();
        for (MovementLineStateEvent ee : e.getMovementLineEvents()) {
            MovementLineStateEventDto eeDto = getMovementLineStateEventDtoConverter().toMovementLineStateEventDto((AbstractMovementLineStateEvent) ee);
            movementLineEvents.add(eeDto);
        }
        dto.setMovementLineEvents(movementLineEvents.toArray(new MovementLineStateEventDto[0]));

        return dto;
    }


    public MovementStateEventDto.MovementStateDeletedDto toMovementStateDeletedDto(MovementStateEvent.MovementStateDeleted e) {
        MovementStateEventDto.MovementStateDeletedDto dto = new MovementStateEventDto.MovementStateDeletedDto();
        dto.setStateEventId(new MovementStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        List<MovementLineStateEventDto.MovementLineStateRemovedDto> movementLineEvents = new ArrayList<>();
        for (MovementLineStateEvent.MovementLineStateRemoved ee : e.getMovementLineEvents()) {
            MovementLineStateEventDto.MovementLineStateRemovedDto eeDto = getMovementLineStateEventDtoConverter().toMovementLineStateRemovedDto(ee);
            movementLineEvents.add(eeDto);
        }
        dto.setMovementLineEvents(movementLineEvents.toArray(new MovementLineStateEventDto.MovementLineStateRemovedDto[0]));

        return dto;
    }

    protected MovementLineStateEventDtoConverter getMovementLineStateEventDtoConverter() {
        return new MovementLineStateEventDtoConverter();
    }

}

