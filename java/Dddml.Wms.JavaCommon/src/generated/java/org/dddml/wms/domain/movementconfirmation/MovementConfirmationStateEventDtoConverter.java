package org.dddml.wms.domain.movementconfirmation;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class MovementConfirmationStateEventDtoConverter {

    public MovementConfirmationStateEventDto toMovementConfirmationStateEventDto(AbstractMovementConfirmationStateEvent stateEvent) {
        if (stateEvent instanceof AbstractMovementConfirmationStateEvent.AbstractMovementConfirmationStateCreated) {
            MovementConfirmationStateEvent.MovementConfirmationStateCreated e = (MovementConfirmationStateEvent.MovementConfirmationStateCreated) stateEvent;
            return toMovementConfirmationStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractMovementConfirmationStateEvent.AbstractMovementConfirmationStateMergePatched) {
            MovementConfirmationStateEvent.MovementConfirmationStateMergePatched e = (MovementConfirmationStateEvent.MovementConfirmationStateMergePatched) stateEvent;
            return toMovementConfirmationStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractMovementConfirmationStateEvent.AbstractMovementConfirmationStateDeleted) {
            MovementConfirmationStateEvent.MovementConfirmationStateDeleted e = (MovementConfirmationStateEvent.MovementConfirmationStateDeleted) stateEvent;
            return toMovementConfirmationStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public MovementConfirmationStateEventDto.MovementConfirmationStateCreatedDto toMovementConfirmationStateCreatedDto(MovementConfirmationStateEvent.MovementConfirmationStateCreated e) {
        MovementConfirmationStateEventDto.MovementConfirmationStateCreatedDto dto = new MovementConfirmationStateEventDto.MovementConfirmationStateCreatedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDocumentStatusId(e.getDocumentStatusId());
        dto.setMovementDocumentNumber(e.getMovementDocumentNumber());
        dto.setIsApproved(e.getIsApproved());
        dto.setApprovalAmount(e.getApprovalAmount());
        dto.setProcessed(e.getProcessed());
        dto.setProcessing(e.getProcessing());
        dto.setDocumentTypeId(e.getDocumentTypeId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        List<MovementConfirmationLineStateEventDto.MovementConfirmationLineStateCreatedDto> movementConfirmationLineEvents = new ArrayList<>();
        for (MovementConfirmationLineStateEvent.MovementConfirmationLineStateCreated ee : e.getMovementConfirmationLineEvents()) {
            MovementConfirmationLineStateEventDto.MovementConfirmationLineStateCreatedDto eeDto = getMovementConfirmationLineStateEventDtoConverter().toMovementConfirmationLineStateCreatedDto(ee);
            movementConfirmationLineEvents.add(eeDto);
        }
        dto.setMovementConfirmationLineEvents(movementConfirmationLineEvents.toArray(new MovementConfirmationLineStateEventDto.MovementConfirmationLineStateCreatedDto[0]));

        return dto;
    }

    public MovementConfirmationStateEventDto.MovementConfirmationStateMergePatchedDto toMovementConfirmationStateMergePatchedDto(MovementConfirmationStateEvent.MovementConfirmationStateMergePatched e) {
        MovementConfirmationStateEventDto.MovementConfirmationStateMergePatchedDto dto = new MovementConfirmationStateEventDto.MovementConfirmationStateMergePatchedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDocumentStatusId(e.getDocumentStatusId());
        dto.setMovementDocumentNumber(e.getMovementDocumentNumber());
        dto.setIsApproved(e.getIsApproved());
        dto.setApprovalAmount(e.getApprovalAmount());
        dto.setProcessed(e.getProcessed());
        dto.setProcessing(e.getProcessing());
        dto.setDocumentTypeId(e.getDocumentTypeId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyDocumentStatusIdRemoved(e.getIsPropertyDocumentStatusIdRemoved());
        dto.setIsPropertyMovementDocumentNumberRemoved(e.getIsPropertyMovementDocumentNumberRemoved());
        dto.setIsPropertyIsApprovedRemoved(e.getIsPropertyIsApprovedRemoved());
        dto.setIsPropertyApprovalAmountRemoved(e.getIsPropertyApprovalAmountRemoved());
        dto.setIsPropertyProcessedRemoved(e.getIsPropertyProcessedRemoved());
        dto.setIsPropertyProcessingRemoved(e.getIsPropertyProcessingRemoved());
        dto.setIsPropertyDocumentTypeIdRemoved(e.getIsPropertyDocumentTypeIdRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        List<MovementConfirmationLineStateEventDto> movementConfirmationLineEvents = new ArrayList<>();
        for (MovementConfirmationLineStateEvent ee : e.getMovementConfirmationLineEvents()) {
            MovementConfirmationLineStateEventDto eeDto = getMovementConfirmationLineStateEventDtoConverter().toMovementConfirmationLineStateEventDto((AbstractMovementConfirmationLineStateEvent) ee);
            movementConfirmationLineEvents.add(eeDto);
        }
        dto.setMovementConfirmationLineEvents(movementConfirmationLineEvents.toArray(new MovementConfirmationLineStateEventDto[0]));

        return dto;
    }


    public MovementConfirmationStateEventDto.MovementConfirmationStateDeletedDto toMovementConfirmationStateDeletedDto(MovementConfirmationStateEvent.MovementConfirmationStateDeleted e) {
        MovementConfirmationStateEventDto.MovementConfirmationStateDeletedDto dto = new MovementConfirmationStateEventDto.MovementConfirmationStateDeletedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        List<MovementConfirmationLineStateEventDto.MovementConfirmationLineStateRemovedDto> movementConfirmationLineEvents = new ArrayList<>();
        for (MovementConfirmationLineStateEvent.MovementConfirmationLineStateRemoved ee : e.getMovementConfirmationLineEvents()) {
            MovementConfirmationLineStateEventDto.MovementConfirmationLineStateRemovedDto eeDto = getMovementConfirmationLineStateEventDtoConverter().toMovementConfirmationLineStateRemovedDto(ee);
            movementConfirmationLineEvents.add(eeDto);
        }
        dto.setMovementConfirmationLineEvents(movementConfirmationLineEvents.toArray(new MovementConfirmationLineStateEventDto.MovementConfirmationLineStateRemovedDto[0]));

        return dto;
    }

    protected MovementConfirmationLineStateEventDtoConverter getMovementConfirmationLineStateEventDtoConverter() {
        return new MovementConfirmationLineStateEventDtoConverter();
    }

}

