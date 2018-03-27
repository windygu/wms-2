package org.dddml.wms.domain.picklist;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PicklistRoleStateEventDtoConverter {

    public PicklistRoleStateEventDto toPicklistRoleStateEventDto(AbstractPicklistRoleStateEvent stateEvent) {
        if (stateEvent instanceof AbstractPicklistRoleStateEvent.AbstractPicklistRoleStateCreated) {
            PicklistRoleStateEvent.PicklistRoleStateCreated e = (PicklistRoleStateEvent.PicklistRoleStateCreated) stateEvent;
            return toPicklistRoleStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPicklistRoleStateEvent.AbstractPicklistRoleStateMergePatched) {
            PicklistRoleStateEvent.PicklistRoleStateMergePatched e = (PicklistRoleStateEvent.PicklistRoleStateMergePatched) stateEvent;
            return toPicklistRoleStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractPicklistRoleStateEvent.AbstractPicklistRoleStateRemoved) {
            PicklistRoleStateEvent.PicklistRoleStateRemoved e = (PicklistRoleStateEvent.PicklistRoleStateRemoved) stateEvent;
            return toPicklistRoleStateRemovedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public PicklistRoleStateEventDto.PicklistRoleStateCreatedDto toPicklistRoleStateCreatedDto(PicklistRoleStateEvent.PicklistRoleStateCreated e) {
        PicklistRoleStateEventDto.PicklistRoleStateCreatedDto dto = new PicklistRoleStateEventDto.PicklistRoleStateCreatedDto();
        dto.setPicklistRoleEventId(e.getPicklistRoleEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedByUserLogin(e.getCreatedByUserLogin());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        return dto;
    }

    public PicklistRoleStateEventDto.PicklistRoleStateMergePatchedDto toPicklistRoleStateMergePatchedDto(PicklistRoleStateEvent.PicklistRoleStateMergePatched e) {
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


    public PicklistRoleStateEventDto.PicklistRoleStateRemovedDto toPicklistRoleStateRemovedDto(PicklistRoleStateEvent.PicklistRoleStateRemoved e) {
        PicklistRoleStateEventDto.PicklistRoleStateRemovedDto dto = new PicklistRoleStateEventDto.PicklistRoleStateRemovedDto();
        dto.setPicklistRoleEventId(e.getPicklistRoleEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedByUserLogin(e.getCreatedByUserLogin());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

