package org.dddml.wms.domain.movementconfirmationlinemvo;

import java.util.*;
import org.dddml.wms.domain.movementconfirmation.*;
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
        dto.setMovementConfirmationLineMvoEventId(e.getMovementConfirmationLineMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setMovementLineNumber(e.getMovementLineNumber());
        dto.setTargetQuantity(e.getTargetQuantity());
        dto.setConfirmedQuantity(e.getConfirmedQuantity());
        dto.setDifferenceQuantity(e.getDifferenceQuantity());
        dto.setScrappedQuantity(e.getScrappedQuantity());
        dto.setDescription(e.getDescription());
        dto.setProcessed(e.getProcessed());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setMovementConfirmationDocumentStatusId(e.getMovementConfirmationDocumentStatusId());
        dto.setMovementConfirmationMovementDocumentNumber(e.getMovementConfirmationMovementDocumentNumber());
        dto.setMovementConfirmationIsApproved(e.getMovementConfirmationIsApproved());
        dto.setMovementConfirmationApprovalAmount(e.getMovementConfirmationApprovalAmount());
        dto.setMovementConfirmationProcessed(e.getMovementConfirmationProcessed());
        dto.setMovementConfirmationProcessing(e.getMovementConfirmationProcessing());
        dto.setMovementConfirmationDocumentTypeId(e.getMovementConfirmationDocumentTypeId());
        dto.setMovementConfirmationDescription(e.getMovementConfirmationDescription());
        dto.setMovementConfirmationCreatedBy(e.getMovementConfirmationCreatedBy());
        dto.setMovementConfirmationCreatedAt(e.getMovementConfirmationCreatedAt());
        dto.setMovementConfirmationUpdatedBy(e.getMovementConfirmationUpdatedBy());
        dto.setMovementConfirmationUpdatedAt(e.getMovementConfirmationUpdatedAt());
        dto.setMovementConfirmationActive(e.getMovementConfirmationActive());
        dto.setMovementConfirmationDeleted(e.getMovementConfirmationDeleted());
        return dto;
    }

    public MovementConfirmationLineMvoStateEventDto.MovementConfirmationLineMvoStateMergePatchedDto toMovementConfirmationLineMvoStateMergePatchedDto(MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateMergePatched e) {
        MovementConfirmationLineMvoStateEventDto.MovementConfirmationLineMvoStateMergePatchedDto dto = new MovementConfirmationLineMvoStateEventDto.MovementConfirmationLineMvoStateMergePatchedDto();
        dto.setMovementConfirmationLineMvoEventId(e.getMovementConfirmationLineMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setMovementLineNumber(e.getMovementLineNumber());
        dto.setTargetQuantity(e.getTargetQuantity());
        dto.setConfirmedQuantity(e.getConfirmedQuantity());
        dto.setDifferenceQuantity(e.getDifferenceQuantity());
        dto.setScrappedQuantity(e.getScrappedQuantity());
        dto.setDescription(e.getDescription());
        dto.setProcessed(e.getProcessed());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setMovementConfirmationDocumentStatusId(e.getMovementConfirmationDocumentStatusId());
        dto.setMovementConfirmationMovementDocumentNumber(e.getMovementConfirmationMovementDocumentNumber());
        dto.setMovementConfirmationIsApproved(e.getMovementConfirmationIsApproved());
        dto.setMovementConfirmationApprovalAmount(e.getMovementConfirmationApprovalAmount());
        dto.setMovementConfirmationProcessed(e.getMovementConfirmationProcessed());
        dto.setMovementConfirmationProcessing(e.getMovementConfirmationProcessing());
        dto.setMovementConfirmationDocumentTypeId(e.getMovementConfirmationDocumentTypeId());
        dto.setMovementConfirmationDescription(e.getMovementConfirmationDescription());
        dto.setMovementConfirmationCreatedBy(e.getMovementConfirmationCreatedBy());
        dto.setMovementConfirmationCreatedAt(e.getMovementConfirmationCreatedAt());
        dto.setMovementConfirmationUpdatedBy(e.getMovementConfirmationUpdatedBy());
        dto.setMovementConfirmationUpdatedAt(e.getMovementConfirmationUpdatedAt());
        dto.setMovementConfirmationActive(e.getMovementConfirmationActive());
        dto.setMovementConfirmationDeleted(e.getMovementConfirmationDeleted());
        dto.setIsPropertyMovementLineNumberRemoved(e.getIsPropertyMovementLineNumberRemoved());
        dto.setIsPropertyTargetQuantityRemoved(e.getIsPropertyTargetQuantityRemoved());
        dto.setIsPropertyConfirmedQuantityRemoved(e.getIsPropertyConfirmedQuantityRemoved());
        dto.setIsPropertyDifferenceQuantityRemoved(e.getIsPropertyDifferenceQuantityRemoved());
        dto.setIsPropertyScrappedQuantityRemoved(e.getIsPropertyScrappedQuantityRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyProcessedRemoved(e.getIsPropertyProcessedRemoved());
        dto.setIsPropertyVersionRemoved(e.getIsPropertyVersionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        dto.setIsPropertyMovementConfirmationDocumentStatusIdRemoved(e.getIsPropertyMovementConfirmationDocumentStatusIdRemoved());
        dto.setIsPropertyMovementConfirmationMovementDocumentNumberRemoved(e.getIsPropertyMovementConfirmationMovementDocumentNumberRemoved());
        dto.setIsPropertyMovementConfirmationIsApprovedRemoved(e.getIsPropertyMovementConfirmationIsApprovedRemoved());
        dto.setIsPropertyMovementConfirmationApprovalAmountRemoved(e.getIsPropertyMovementConfirmationApprovalAmountRemoved());
        dto.setIsPropertyMovementConfirmationProcessedRemoved(e.getIsPropertyMovementConfirmationProcessedRemoved());
        dto.setIsPropertyMovementConfirmationProcessingRemoved(e.getIsPropertyMovementConfirmationProcessingRemoved());
        dto.setIsPropertyMovementConfirmationDocumentTypeIdRemoved(e.getIsPropertyMovementConfirmationDocumentTypeIdRemoved());
        dto.setIsPropertyMovementConfirmationDescriptionRemoved(e.getIsPropertyMovementConfirmationDescriptionRemoved());
        dto.setIsPropertyMovementConfirmationCreatedByRemoved(e.getIsPropertyMovementConfirmationCreatedByRemoved());
        dto.setIsPropertyMovementConfirmationCreatedAtRemoved(e.getIsPropertyMovementConfirmationCreatedAtRemoved());
        dto.setIsPropertyMovementConfirmationUpdatedByRemoved(e.getIsPropertyMovementConfirmationUpdatedByRemoved());
        dto.setIsPropertyMovementConfirmationUpdatedAtRemoved(e.getIsPropertyMovementConfirmationUpdatedAtRemoved());
        dto.setIsPropertyMovementConfirmationActiveRemoved(e.getIsPropertyMovementConfirmationActiveRemoved());
        dto.setIsPropertyMovementConfirmationDeletedRemoved(e.getIsPropertyMovementConfirmationDeletedRemoved());
        return dto;
    }


    public MovementConfirmationLineMvoStateEventDto.MovementConfirmationLineMvoStateDeletedDto toMovementConfirmationLineMvoStateDeletedDto(MovementConfirmationLineMvoStateEvent.MovementConfirmationLineMvoStateDeleted e) {
        MovementConfirmationLineMvoStateEventDto.MovementConfirmationLineMvoStateDeletedDto dto = new MovementConfirmationLineMvoStateEventDto.MovementConfirmationLineMvoStateDeletedDto();
        dto.setMovementConfirmationLineMvoEventId(e.getMovementConfirmationLineMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

