package org.dddml.wms.domain.picklist;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PicklistRoleStateEventDtoConverter {

    public PicklistRoleStateEventDto toPicklistRoleStateEventDto(AbstractPicklistRoleEvent stateEvent) {
        if (stateEvent instanceof AbstractPicklistRoleEvent.AbstractPicklistRoleStateCreated) {
            PicklistRoleEvent.PicklistRoleStateCreated e = (PicklistRoleEvent.PicklistRoleStateCreated) stateEvent;
            return toPicklistRoleStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPicklistRoleEvent.AbstractPicklistRoleStateMergePatched) {
            PicklistRoleEvent.PicklistRoleStateMergePatched e = (PicklistRoleEvent.PicklistRoleStateMergePatched) stateEvent;
            return toPicklistRoleStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractPicklistRoleEvent.AbstractPicklistRoleStateRemoved) {
            PicklistRoleEvent.PicklistRoleStateRemoved e = (PicklistRoleEvent.PicklistRoleStateRemoved) stateEvent;
            return toPicklistRoleStateRemovedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public PicklistRoleStateEventDto.PicklistRoleStateCreatedDto toPicklistRoleStateCreatedDto(PicklistRoleEvent.PicklistRoleStateCreated e) {
        PicklistRoleStateEventDto.PicklistRoleStateCreatedDto dto = new PicklistRoleStateEventDto.PicklistRoleStateCreatedDto();
        dto.setPicklistRoleEventId(e.getPicklistRoleEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedByUserLogin(e.getCreatedByUserLogin());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        return dto;
    }

    public PicklistRoleStateEventDto.PicklistRoleStateMergePatchedDto toPicklistRoleStateMergePatchedDto(PicklistRoleEvent.PicklistRoleStateMergePatched e) {
        PicklistRoleStateEventDto.PicklistRoleStateMergePatchedDto dto = new PicklistRoleStateEventDto.PicklistRoleStateMergePatchedDto();
        dto.setPicklistRoleEventId(e.getPicklistRoleEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedByUserLogin(e.getCreatedByUserLogin());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public PicklistRoleStateEventDto.PicklistRoleStateRemovedDto toPicklistRoleStateRemovedDto(PicklistRoleEvent.PicklistRoleStateRemoved e) {
        PicklistRoleStateEventDto.PicklistRoleStateRemovedDto dto = new PicklistRoleStateEventDto.PicklistRoleStateRemovedDto();
        dto.setPicklistRoleEventId(e.getPicklistRoleEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedByUserLogin(e.getCreatedByUserLogin());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

