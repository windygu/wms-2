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
        dto.setMovementTypeId(e.getMovementTypeId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        List<MovementLineStateEventDto.MovementLineStateCreatedDto> movementLineEvents = new ArrayList<>();
        for (MovementLineStateEvent.MovementLineStateCreated ee : e.getMovementLineEvents()) {
            MovementLineStateEventDto.MovementLineStateCreatedDto eeDto = getMovementLineStateEventDtoConverter().toMovementLineStateCreatedDto(ee);
            movementLineEvents.add(eeDto);
        }
        dto.setMovementLineEvents(movementLineEvents.toArray(new MovementLineStateEventDto.MovementLineStateCreatedDto[0]));

        List<MovementConfirmationLineStateEventDto.MovementConfirmationLineStateCreatedDto> movementConfirmationLineEvents = new ArrayList<>();
        for (MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated ee : e.getMovementConfirmationLineEvents()) {
            MovementConfirmationLineStateEventDto.MovementConfirmationLineStateCreatedDto eeDto = getMovementConfirmationLineStateEventDtoConverter().toMovementConfirmationLineStateCreatedDto(ee);
            movementConfirmationLineEvents.add(eeDto);
        }
        dto.setMovementConfirmationLineEvents(movementConfirmationLineEvents.toArray(new MovementConfirmationLineStateEventDto.MovementConfirmationLineStateCreatedDto[0]));

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
        dto.setMovementTypeId(e.getMovementTypeId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyDocumentTypeIdRemoved(e.getIsPropertyDocumentTypeIdRemoved());
        dto.setIsPropertyDocumentStatusIdRemoved(e.getIsPropertyDocumentStatusIdRemoved());
        dto.setIsPropertyMovementTypeIdRemoved(e.getIsPropertyMovementTypeIdRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        List<MovementLineStateEventDto> movementLineEvents = new ArrayList<>();
        for (MovementLineStateEvent ee : e.getMovementLineEvents()) {
            MovementLineStateEventDto eeDto = getMovementLineStateEventDtoConverter().toMovementLineStateEventDto((AbstractMovementLineStateEvent) ee);
            movementLineEvents.add(eeDto);
        }
        dto.setMovementLineEvents(movementLineEvents.toArray(new MovementLineStateEventDto[0]));

        List<MovementConfirmationLineStateEventDto> movementConfirmationLineEvents = new ArrayList<>();
        for (MovementConfirmationLineStateEvent ee : e.getMovementConfirmationLineEvents()) {
            MovementConfirmationLineStateEventDto eeDto = getMovementConfirmationLineStateEventDtoConverter().toMovementConfirmationLineStateEventDto((AbstractMovementConfirmationLineStateEvent) ee);
            movementConfirmationLineEvents.add(eeDto);
        }
        dto.setMovementConfirmationLineEvents(movementConfirmationLineEvents.toArray(new MovementConfirmationLineStateEventDto[0]));

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

        List<MovementConfirmationLineStateEventDto.MovementConfirmationLineStateRemovedDto> movementConfirmationLineEvents = new ArrayList<>();
        for (MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved ee : e.getMovementConfirmationLineEvents()) {
            MovementConfirmationLineStateEventDto.MovementConfirmationLineStateRemovedDto eeDto = getMovementConfirmationLineStateEventDtoConverter().toMovementConfirmationLineStateRemovedDto(ee);
            movementConfirmationLineEvents.add(eeDto);
        }
        dto.setMovementConfirmationLineEvents(movementConfirmationLineEvents.toArray(new MovementConfirmationLineStateEventDto.MovementConfirmationLineStateRemovedDto[0]));

        return dto;
    }

    protected MovementLineStateEventDtoConverter getMovementLineStateEventDtoConverter() {
        return new MovementLineStateEventDtoConverter();
    }

    protected MovementConfirmationLineStateEventDtoConverter getMovementConfirmationLineStateEventDtoConverter() {
        return new MovementConfirmationLineStateEventDtoConverter();
    }

}

