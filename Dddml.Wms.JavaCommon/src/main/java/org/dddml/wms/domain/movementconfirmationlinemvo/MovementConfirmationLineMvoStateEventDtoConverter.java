package org.dddml.wms.domain.movementconfirmationlinemvo;

import java.util.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class MovementConfirmationLineMvoStateEventDtoConverter {

    public MovementConfirmationLineMvoStateEventDto toMovementConfirmationLineMvoStateEventDto(AbstractMovementConfirmationLineMvoStateEvent stateEvent) {
        if (stateEvent instanceof AbstractMovementConfirmationLineMvoStateEvent.AbstractMovementConfirmationLineMvoStateCreated) {
            MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateCreated e = (MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateCreated) stateEvent;
            return toMovementConfirmationLineMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractMovementConfirmationLineMvoStateEvent.AbstractMovementConfirmationLineMvoStateMergePatched) {
            MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateMergePatched e = (MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateMergePatched) stateEvent;
            return toMovementConfirmationLineMvoStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractMovementConfirmationLineMvoStateEvent.AbstractMovementConfirmationLineMvoStateDeleted) {
            MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateDeleted e = (MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateDeleted) stateEvent;
            return toMovementConfirmationLineMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public MovementConfirmationLineMvoStateEventDto.MovementConfirmationLineMvoStateCreatedDto toMovementConfirmationLineMvoStateCreatedDto(MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateCreated e) {
        MovementConfirmationLineMvoStateEventDto.MovementConfirmationLineMvoStateCreatedDto dto = new MovementConfirmationLineMvoStateEventDto.MovementConfirmationLineMvoStateCreatedDto();
        dto.setStateEventId(new MovementConfirmationLineMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setTargetQuantity(e.getTargetQuantity());
        dto.setConfirmedQuantity(e.getConfirmedQuantity());
        dto.setDifferenceQuantity(e.getDifferenceQuantity());
        dto.setScrappedQuantity(e.getScrappedQuantity());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setMovementDocumentTypeId(e.getMovementDocumentTypeId());
        dto.setMovementDocumentStatusId(e.getMovementDocumentStatusId());
        dto.setMovementMovementTypeId(e.getMovementMovementTypeId());
        dto.setMovementDescription(e.getMovementDescription());
        dto.setMovementCreatedBy(e.getMovementCreatedBy());
        dto.setMovementCreatedAt(e.getMovementCreatedAt());
        dto.setMovementUpdatedBy(e.getMovementUpdatedBy());
        dto.setMovementUpdatedAt(e.getMovementUpdatedAt());
        dto.setMovementActive(e.getMovementActive());
        dto.setMovementDeleted(e.getMovementDeleted());
        return dto;
    }

    public MovementConfirmationLineMvoStateEventDto.MovementConfirmationLineMvoStateMergePatchedDto toMovementConfirmationLineMvoStateMergePatchedDto(MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateMergePatched e) {
        MovementConfirmationLineMvoStateEventDto.MovementConfirmationLineMvoStateMergePatchedDto dto = new MovementConfirmationLineMvoStateEventDto.MovementConfirmationLineMvoStateMergePatchedDto();
        dto.setStateEventId(new MovementConfirmationLineMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setTargetQuantity(e.getTargetQuantity());
        dto.setConfirmedQuantity(e.getConfirmedQuantity());
        dto.setDifferenceQuantity(e.getDifferenceQuantity());
        dto.setScrappedQuantity(e.getScrappedQuantity());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setMovementDocumentTypeId(e.getMovementDocumentTypeId());
        dto.setMovementDocumentStatusId(e.getMovementDocumentStatusId());
        dto.setMovementMovementTypeId(e.getMovementMovementTypeId());
        dto.setMovementDescription(e.getMovementDescription());
        dto.setMovementCreatedBy(e.getMovementCreatedBy());
        dto.setMovementCreatedAt(e.getMovementCreatedAt());
        dto.setMovementUpdatedBy(e.getMovementUpdatedBy());
        dto.setMovementUpdatedAt(e.getMovementUpdatedAt());
        dto.setMovementActive(e.getMovementActive());
        dto.setMovementDeleted(e.getMovementDeleted());
        dto.setIsPropertyTargetQuantityRemoved(e.getIsPropertyTargetQuantityRemoved());
        dto.setIsPropertyConfirmedQuantityRemoved(e.getIsPropertyConfirmedQuantityRemoved());
        dto.setIsPropertyDifferenceQuantityRemoved(e.getIsPropertyDifferenceQuantityRemoved());
        dto.setIsPropertyScrappedQuantityRemoved(e.getIsPropertyScrappedQuantityRemoved());
        dto.setIsPropertyVersionRemoved(e.getIsPropertyVersionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        dto.setIsPropertyMovementDocumentTypeIdRemoved(e.getIsPropertyMovementDocumentTypeIdRemoved());
        dto.setIsPropertyMovementDocumentStatusIdRemoved(e.getIsPropertyMovementDocumentStatusIdRemoved());
        dto.setIsPropertyMovementMovementTypeIdRemoved(e.getIsPropertyMovementMovementTypeIdRemoved());
        dto.setIsPropertyMovementDescriptionRemoved(e.getIsPropertyMovementDescriptionRemoved());
        dto.setIsPropertyMovementCreatedByRemoved(e.getIsPropertyMovementCreatedByRemoved());
        dto.setIsPropertyMovementCreatedAtRemoved(e.getIsPropertyMovementCreatedAtRemoved());
        dto.setIsPropertyMovementUpdatedByRemoved(e.getIsPropertyMovementUpdatedByRemoved());
        dto.setIsPropertyMovementUpdatedAtRemoved(e.getIsPropertyMovementUpdatedAtRemoved());
        dto.setIsPropertyMovementActiveRemoved(e.getIsPropertyMovementActiveRemoved());
        dto.setIsPropertyMovementDeletedRemoved(e.getIsPropertyMovementDeletedRemoved());
        return dto;
    }


    public MovementConfirmationLineMvoStateEventDto.MovementConfirmationLineMvoStateDeletedDto toMovementConfirmationLineMvoStateDeletedDto(MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateDeleted e) {
        MovementConfirmationLineMvoStateEventDto.MovementConfirmationLineMvoStateDeletedDto dto = new MovementConfirmationLineMvoStateEventDto.MovementConfirmationLineMvoStateDeletedDto();
        dto.setStateEventId(new MovementConfirmationLineMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

