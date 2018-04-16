package org.dddml.wms.domain.movement;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class MovementLineStateEventDtoConverter {

    public MovementLineStateEventDto toMovementLineStateEventDto(AbstractMovementLineEvent stateEvent) {
        if (stateEvent instanceof AbstractMovementLineEvent.AbstractMovementLineStateCreated) {
            MovementLineEvent.MovementLineStateCreated e = (MovementLineEvent.MovementLineStateCreated) stateEvent;
            return toMovementLineStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractMovementLineEvent.AbstractMovementLineStateMergePatched) {
            MovementLineEvent.MovementLineStateMergePatched e = (MovementLineEvent.MovementLineStateMergePatched) stateEvent;
            return toMovementLineStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractMovementLineEvent.AbstractMovementLineStateRemoved) {
            MovementLineEvent.MovementLineStateRemoved e = (MovementLineEvent.MovementLineStateRemoved) stateEvent;
            return toMovementLineStateRemovedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public MovementLineStateEventDto.MovementLineStateCreatedDto toMovementLineStateCreatedDto(MovementLineEvent.MovementLineStateCreated e) {
        MovementLineStateEventDto.MovementLineStateCreatedDto dto = new MovementLineStateEventDto.MovementLineStateCreatedDto();
        dto.setMovementLineEventId(e.getMovementLineEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setMovementQuantity(e.getMovementQuantity());
        dto.setProductId(e.getProductId());
        dto.setLocatorIdFrom(e.getLocatorIdFrom());
        dto.setLocatorIdTo(e.getLocatorIdTo());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setProcessed(e.getProcessed());
        dto.setReversalLineNumber(e.getReversalLineNumber());
        dto.setActive(e.getActive());
        return dto;
    }

    public MovementLineStateEventDto.MovementLineStateMergePatchedDto toMovementLineStateMergePatchedDto(MovementLineEvent.MovementLineStateMergePatched e) {
        MovementLineStateEventDto.MovementLineStateMergePatchedDto dto = new MovementLineStateEventDto.MovementLineStateMergePatchedDto();
        dto.setMovementLineEventId(e.getMovementLineEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setMovementQuantity(e.getMovementQuantity());
        dto.setProductId(e.getProductId());
        dto.setLocatorIdFrom(e.getLocatorIdFrom());
        dto.setLocatorIdTo(e.getLocatorIdTo());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setProcessed(e.getProcessed());
        dto.setReversalLineNumber(e.getReversalLineNumber());
        dto.setActive(e.getActive());
        dto.setIsPropertyMovementQuantityRemoved(e.getIsPropertyMovementQuantityRemoved());
        dto.setIsPropertyProductIdRemoved(e.getIsPropertyProductIdRemoved());
        dto.setIsPropertyLocatorIdFromRemoved(e.getIsPropertyLocatorIdFromRemoved());
        dto.setIsPropertyLocatorIdToRemoved(e.getIsPropertyLocatorIdToRemoved());
        dto.setIsPropertyAttributeSetInstanceIdRemoved(e.getIsPropertyAttributeSetInstanceIdRemoved());
        dto.setIsPropertyProcessedRemoved(e.getIsPropertyProcessedRemoved());
        dto.setIsPropertyReversalLineNumberRemoved(e.getIsPropertyReversalLineNumberRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public MovementLineStateEventDto.MovementLineStateRemovedDto toMovementLineStateRemovedDto(MovementLineEvent.MovementLineStateRemoved e) {
        MovementLineStateEventDto.MovementLineStateRemovedDto dto = new MovementLineStateEventDto.MovementLineStateRemovedDto();
        dto.setMovementLineEventId(e.getMovementLineEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

