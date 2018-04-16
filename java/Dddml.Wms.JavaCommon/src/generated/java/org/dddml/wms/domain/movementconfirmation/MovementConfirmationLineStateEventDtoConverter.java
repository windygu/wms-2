package org.dddml.wms.domain.movementconfirmation;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class MovementConfirmationLineStateEventDtoConverter {

    public MovementConfirmationLineStateEventDto toMovementConfirmationLineStateEventDto(AbstractMovementConfirmationLineEvent stateEvent) {
        if (stateEvent instanceof AbstractMovementConfirmationLineEvent.AbstractMovementConfirmationLineStateCreated) {
            MovementConfirmationLineEvent.MovementConfirmationLineStateCreated e = (MovementConfirmationLineEvent.MovementConfirmationLineStateCreated) stateEvent;
            return toMovementConfirmationLineStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractMovementConfirmationLineEvent.AbstractMovementConfirmationLineStateMergePatched) {
            MovementConfirmationLineEvent.MovementConfirmationLineStateMergePatched e = (MovementConfirmationLineEvent.MovementConfirmationLineStateMergePatched) stateEvent;
            return toMovementConfirmationLineStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractMovementConfirmationLineEvent.AbstractMovementConfirmationLineStateRemoved) {
            MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved e = (MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved) stateEvent;
            return toMovementConfirmationLineStateRemovedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public MovementConfirmationLineStateEventDto.MovementConfirmationLineStateCreatedDto toMovementConfirmationLineStateCreatedDto(MovementConfirmationLineEvent.MovementConfirmationLineStateCreated e) {
        MovementConfirmationLineStateEventDto.MovementConfirmationLineStateCreatedDto dto = new MovementConfirmationLineStateEventDto.MovementConfirmationLineStateCreatedDto();
        dto.setMovementConfirmationLineEventId(e.getMovementConfirmationLineEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setMovementLineNumber(e.getMovementLineNumber());
        dto.setTargetQuantity(e.getTargetQuantity());
        dto.setConfirmedQuantity(e.getConfirmedQuantity());
        dto.setDifferenceQuantity(e.getDifferenceQuantity());
        dto.setScrappedQuantity(e.getScrappedQuantity());
        dto.setDescription(e.getDescription());
        dto.setProcessed(e.getProcessed());
        dto.setActive(e.getActive());
        return dto;
    }

    public MovementConfirmationLineStateEventDto.MovementConfirmationLineStateMergePatchedDto toMovementConfirmationLineStateMergePatchedDto(MovementConfirmationLineEvent.MovementConfirmationLineStateMergePatched e) {
        MovementConfirmationLineStateEventDto.MovementConfirmationLineStateMergePatchedDto dto = new MovementConfirmationLineStateEventDto.MovementConfirmationLineStateMergePatchedDto();
        dto.setMovementConfirmationLineEventId(e.getMovementConfirmationLineEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setMovementLineNumber(e.getMovementLineNumber());
        dto.setTargetQuantity(e.getTargetQuantity());
        dto.setConfirmedQuantity(e.getConfirmedQuantity());
        dto.setDifferenceQuantity(e.getDifferenceQuantity());
        dto.setScrappedQuantity(e.getScrappedQuantity());
        dto.setDescription(e.getDescription());
        dto.setProcessed(e.getProcessed());
        dto.setActive(e.getActive());
        dto.setIsPropertyMovementLineNumberRemoved(e.getIsPropertyMovementLineNumberRemoved());
        dto.setIsPropertyTargetQuantityRemoved(e.getIsPropertyTargetQuantityRemoved());
        dto.setIsPropertyConfirmedQuantityRemoved(e.getIsPropertyConfirmedQuantityRemoved());
        dto.setIsPropertyDifferenceQuantityRemoved(e.getIsPropertyDifferenceQuantityRemoved());
        dto.setIsPropertyScrappedQuantityRemoved(e.getIsPropertyScrappedQuantityRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyProcessedRemoved(e.getIsPropertyProcessedRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public MovementConfirmationLineStateEventDto.MovementConfirmationLineStateRemovedDto toMovementConfirmationLineStateRemovedDto(MovementConfirmationLineEvent.MovementConfirmationLineStateRemoved e) {
        MovementConfirmationLineStateEventDto.MovementConfirmationLineStateRemovedDto dto = new MovementConfirmationLineStateEventDto.MovementConfirmationLineStateRemovedDto();
        dto.setMovementConfirmationLineEventId(e.getMovementConfirmationLineEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

