package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;

public class RoleStateEventDtoConverter {

    public RoleStateEventDto toRoleStateEventDto(AbstractRoleStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            RoleStateEvent.RoleStateCreated e = (RoleStateEvent.RoleStateCreated) stateEvent;
            return toRoleStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            RoleStateEvent.RoleStateMergePatched e = (RoleStateEvent.RoleStateMergePatched) stateEvent;
            return toRoleStateMergePatchedDto(e);
        } else if (StateEventType.DELETED.equals(stateEvent.getStateEventType())) {
            RoleStateEvent.RoleStateDeleted e = (RoleStateEvent.RoleStateDeleted) stateEvent;
            return toRoleStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public RoleStateEventDto.RoleStateCreatedDto toRoleStateCreatedDto(RoleStateEvent.RoleStateCreated e) {
        RoleStateEventDto.RoleStateCreatedDto dto = new RoleStateEventDto.RoleStateCreatedDto();
        dto.setStateEventId(new RoleStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public RoleStateEventDto.RoleStateMergePatchedDto toRoleStateMergePatchedDto(RoleStateEvent.RoleStateMergePatched e) {
        RoleStateEventDto.RoleStateMergePatchedDto dto = new RoleStateEventDto.RoleStateMergePatchedDto();
        dto.setStateEventId(new RoleStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyNameRemoved(e.getIsPropertyNameRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public RoleStateEventDto.RoleStateDeletedDto toRoleStateDeletedDto(RoleStateEvent.RoleStateDeleted e) {
        RoleStateEventDto.RoleStateDeletedDto dto = new RoleStateEventDto.RoleStateDeletedDto();
        dto.setStateEventId(new RoleStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

