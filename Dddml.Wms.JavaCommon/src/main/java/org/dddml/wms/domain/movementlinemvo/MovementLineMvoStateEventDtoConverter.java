package org.dddml.wms.domain.movementlinemvo;

import java.util.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class MovementLineMvoStateEventDtoConverter {

    public MovementLineMvoStateEventDto toMovementLineMvoStateEventDto(AbstractMovementLineMvoStateEvent stateEvent) {
        if (stateEvent instanceof AbstractMovementLineMvoStateEvent.AbstractMovementLineMvoStateCreated) {
            MovementLineMvoStateEvent.MovementLineMvoStateCreated e = (MovementLineMvoStateEvent.MovementLineMvoStateCreated) stateEvent;
            return toMovementLineMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractMovementLineMvoStateEvent.AbstractMovementLineMvoStateMergePatched) {
            MovementLineMvoStateEvent.MovementLineMvoStateMergePatched e = (MovementLineMvoStateEvent.MovementLineMvoStateMergePatched) stateEvent;
            return toMovementLineMvoStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractMovementLineMvoStateEvent.AbstractMovementLineMvoStateDeleted) {
            MovementLineMvoStateEvent.MovementLineMvoStateDeleted e = (MovementLineMvoStateEvent.MovementLineMvoStateDeleted) stateEvent;
            return toMovementLineMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public MovementLineMvoStateEventDto.MovementLineMvoStateCreatedDto toMovementLineMvoStateCreatedDto(MovementLineMvoStateEvent.MovementLineMvoStateCreated e) {
        MovementLineMvoStateEventDto.MovementLineMvoStateCreatedDto dto = new MovementLineMvoStateEventDto.MovementLineMvoStateCreatedDto();
        dto.setStateEventId(new MovementLineMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setMovementQuantity(e.getMovementQuantity());
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

    public MovementLineMvoStateEventDto.MovementLineMvoStateMergePatchedDto toMovementLineMvoStateMergePatchedDto(MovementLineMvoStateEvent.MovementLineMvoStateMergePatched e) {
        MovementLineMvoStateEventDto.MovementLineMvoStateMergePatchedDto dto = new MovementLineMvoStateEventDto.MovementLineMvoStateMergePatchedDto();
        dto.setStateEventId(new MovementLineMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setMovementQuantity(e.getMovementQuantity());
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
        dto.setIsPropertyMovementQuantityRemoved(e.getIsPropertyMovementQuantityRemoved());
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


    public MovementLineMvoStateEventDto.MovementLineMvoStateDeletedDto toMovementLineMvoStateDeletedDto(MovementLineMvoStateEvent.MovementLineMvoStateDeleted e) {
        MovementLineMvoStateEventDto.MovementLineMvoStateDeletedDto dto = new MovementLineMvoStateEventDto.MovementLineMvoStateDeletedDto();
        dto.setStateEventId(new MovementLineMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

