package org.dddml.wms.domain.damagehandlingmethod;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class DamageHandlingMethodStateEventDtoConverter {

    public DamageHandlingMethodStateEventDto toDamageHandlingMethodStateEventDto(AbstractDamageHandlingMethodStateEvent stateEvent) {
        if (stateEvent instanceof AbstractDamageHandlingMethodStateEvent.AbstractDamageHandlingMethodStateCreated) {
            DamageHandlingMethodStateEvent.DamageHandlingMethodStateCreated e = (DamageHandlingMethodStateEvent.DamageHandlingMethodStateCreated) stateEvent;
            return toDamageHandlingMethodStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractDamageHandlingMethodStateEvent.AbstractDamageHandlingMethodStateMergePatched) {
            DamageHandlingMethodStateEvent.DamageHandlingMethodStateMergePatched e = (DamageHandlingMethodStateEvent.DamageHandlingMethodStateMergePatched) stateEvent;
            return toDamageHandlingMethodStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractDamageHandlingMethodStateEvent.AbstractDamageHandlingMethodStateDeleted) {
            DamageHandlingMethodStateEvent.DamageHandlingMethodStateDeleted e = (DamageHandlingMethodStateEvent.DamageHandlingMethodStateDeleted) stateEvent;
            return toDamageHandlingMethodStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public DamageHandlingMethodStateEventDto.DamageHandlingMethodStateCreatedDto toDamageHandlingMethodStateCreatedDto(DamageHandlingMethodStateEvent.DamageHandlingMethodStateCreated e) {
        DamageHandlingMethodStateEventDto.DamageHandlingMethodStateCreatedDto dto = new DamageHandlingMethodStateEventDto.DamageHandlingMethodStateCreatedDto();
        dto.setStateEventId(new DamageHandlingMethodStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setSequenceId(e.getSequenceId());
        dto.setActive(e.getActive());
        return dto;
    }

    public DamageHandlingMethodStateEventDto.DamageHandlingMethodStateMergePatchedDto toDamageHandlingMethodStateMergePatchedDto(DamageHandlingMethodStateEvent.DamageHandlingMethodStateMergePatched e) {
        DamageHandlingMethodStateEventDto.DamageHandlingMethodStateMergePatchedDto dto = new DamageHandlingMethodStateEventDto.DamageHandlingMethodStateMergePatchedDto();
        dto.setStateEventId(new DamageHandlingMethodStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setSequenceId(e.getSequenceId());
        dto.setActive(e.getActive());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertySequenceIdRemoved(e.getIsPropertySequenceIdRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public DamageHandlingMethodStateEventDto.DamageHandlingMethodStateDeletedDto toDamageHandlingMethodStateDeletedDto(DamageHandlingMethodStateEvent.DamageHandlingMethodStateDeleted e) {
        DamageHandlingMethodStateEventDto.DamageHandlingMethodStateDeletedDto dto = new DamageHandlingMethodStateEventDto.DamageHandlingMethodStateDeletedDto();
        dto.setStateEventId(new DamageHandlingMethodStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

