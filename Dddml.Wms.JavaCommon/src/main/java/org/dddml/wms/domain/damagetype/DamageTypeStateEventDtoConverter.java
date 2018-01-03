package org.dddml.wms.domain.damagetype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class DamageTypeStateEventDtoConverter {

    public DamageTypeStateEventDto toDamageTypeStateEventDto(AbstractDamageTypeStateEvent stateEvent) {
        if (stateEvent instanceof AbstractDamageTypeStateEvent.AbstractDamageTypeStateCreated) {
            DamageTypeStateEvent.DamageTypeStateCreated e = (DamageTypeStateEvent.DamageTypeStateCreated) stateEvent;
            return toDamageTypeStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractDamageTypeStateEvent.AbstractDamageTypeStateMergePatched) {
            DamageTypeStateEvent.DamageTypeStateMergePatched e = (DamageTypeStateEvent.DamageTypeStateMergePatched) stateEvent;
            return toDamageTypeStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractDamageTypeStateEvent.AbstractDamageTypeStateDeleted) {
            DamageTypeStateEvent.DamageTypeStateDeleted e = (DamageTypeStateEvent.DamageTypeStateDeleted) stateEvent;
            return toDamageTypeStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public DamageTypeStateEventDto.DamageTypeStateCreatedDto toDamageTypeStateCreatedDto(DamageTypeStateEvent.DamageTypeStateCreated e) {
        DamageTypeStateEventDto.DamageTypeStateCreatedDto dto = new DamageTypeStateEventDto.DamageTypeStateCreatedDto();
        dto.setStateEventId(new DamageTypeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setSequenceId(e.getSequenceId());
        dto.setDefaultHandlingMethodId(e.getDefaultHandlingMethodId());
        dto.setActive(e.getActive());
        return dto;
    }

    public DamageTypeStateEventDto.DamageTypeStateMergePatchedDto toDamageTypeStateMergePatchedDto(DamageTypeStateEvent.DamageTypeStateMergePatched e) {
        DamageTypeStateEventDto.DamageTypeStateMergePatchedDto dto = new DamageTypeStateEventDto.DamageTypeStateMergePatchedDto();
        dto.setStateEventId(new DamageTypeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setSequenceId(e.getSequenceId());
        dto.setDefaultHandlingMethodId(e.getDefaultHandlingMethodId());
        dto.setActive(e.getActive());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertySequenceIdRemoved(e.getIsPropertySequenceIdRemoved());
        dto.setIsPropertyDefaultHandlingMethodIdRemoved(e.getIsPropertyDefaultHandlingMethodIdRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public DamageTypeStateEventDto.DamageTypeStateDeletedDto toDamageTypeStateDeletedDto(DamageTypeStateEvent.DamageTypeStateDeleted e) {
        DamageTypeStateEventDto.DamageTypeStateDeletedDto dto = new DamageTypeStateEventDto.DamageTypeStateDeletedDto();
        dto.setStateEventId(new DamageTypeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

