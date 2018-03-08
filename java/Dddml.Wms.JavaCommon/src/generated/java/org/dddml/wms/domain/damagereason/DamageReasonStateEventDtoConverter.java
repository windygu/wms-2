package org.dddml.wms.domain.damagereason;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class DamageReasonStateEventDtoConverter {

    public DamageReasonStateEventDto toDamageReasonStateEventDto(AbstractDamageReasonStateEvent stateEvent) {
        if (stateEvent instanceof AbstractDamageReasonStateEvent.AbstractDamageReasonStateCreated) {
            DamageReasonStateEvent.DamageReasonStateCreated e = (DamageReasonStateEvent.DamageReasonStateCreated) stateEvent;
            return toDamageReasonStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractDamageReasonStateEvent.AbstractDamageReasonStateMergePatched) {
            DamageReasonStateEvent.DamageReasonStateMergePatched e = (DamageReasonStateEvent.DamageReasonStateMergePatched) stateEvent;
            return toDamageReasonStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractDamageReasonStateEvent.AbstractDamageReasonStateDeleted) {
            DamageReasonStateEvent.DamageReasonStateDeleted e = (DamageReasonStateEvent.DamageReasonStateDeleted) stateEvent;
            return toDamageReasonStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public DamageReasonStateEventDto.DamageReasonStateCreatedDto toDamageReasonStateCreatedDto(DamageReasonStateEvent.DamageReasonStateCreated e) {
        DamageReasonStateEventDto.DamageReasonStateCreatedDto dto = new DamageReasonStateEventDto.DamageReasonStateCreatedDto();
        dto.setDamageReasonEventId(e.getDamageReasonEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setSequenceId(e.getSequenceId());
        dto.setActive(e.getActive());
        return dto;
    }

    public DamageReasonStateEventDto.DamageReasonStateMergePatchedDto toDamageReasonStateMergePatchedDto(DamageReasonStateEvent.DamageReasonStateMergePatched e) {
        DamageReasonStateEventDto.DamageReasonStateMergePatchedDto dto = new DamageReasonStateEventDto.DamageReasonStateMergePatchedDto();
        dto.setDamageReasonEventId(e.getDamageReasonEventId());
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


    public DamageReasonStateEventDto.DamageReasonStateDeletedDto toDamageReasonStateDeletedDto(DamageReasonStateEvent.DamageReasonStateDeleted e) {
        DamageReasonStateEventDto.DamageReasonStateDeletedDto dto = new DamageReasonStateEventDto.DamageReasonStateDeletedDto();
        dto.setDamageReasonEventId(e.getDamageReasonEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

