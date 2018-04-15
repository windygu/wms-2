package org.dddml.wms.domain.damagereason;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class DamageReasonStateEventDtoConverter {

    public DamageReasonStateEventDto toDamageReasonStateEventDto(AbstractDamageReasonEvent stateEvent) {
        if (stateEvent instanceof AbstractDamageReasonEvent.AbstractDamageReasonStateCreated) {
            DamageReasonEvent.DamageReasonStateCreated e = (DamageReasonEvent.DamageReasonStateCreated) stateEvent;
            return toDamageReasonStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractDamageReasonEvent.AbstractDamageReasonStateMergePatched) {
            DamageReasonEvent.DamageReasonStateMergePatched e = (DamageReasonEvent.DamageReasonStateMergePatched) stateEvent;
            return toDamageReasonStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractDamageReasonEvent.AbstractDamageReasonStateDeleted) {
            DamageReasonEvent.DamageReasonStateDeleted e = (DamageReasonEvent.DamageReasonStateDeleted) stateEvent;
            return toDamageReasonStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public DamageReasonStateEventDto.DamageReasonStateCreatedDto toDamageReasonStateCreatedDto(DamageReasonEvent.DamageReasonStateCreated e) {
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

    public DamageReasonStateEventDto.DamageReasonStateMergePatchedDto toDamageReasonStateMergePatchedDto(DamageReasonEvent.DamageReasonStateMergePatched e) {
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


    public DamageReasonStateEventDto.DamageReasonStateDeletedDto toDamageReasonStateDeletedDto(DamageReasonEvent.DamageReasonStateDeleted e) {
        DamageReasonStateEventDto.DamageReasonStateDeletedDto dto = new DamageReasonStateEventDto.DamageReasonStateDeletedDto();
        dto.setDamageReasonEventId(e.getDamageReasonEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

