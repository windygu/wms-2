package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;

public class RolePermissionStateEventDtoConverter {

    public RolePermissionStateEventDto toRolePermissionStateEventDto(AbstractRolePermissionStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            RolePermissionStateEvent.RolePermissionStateCreated e = (RolePermissionStateEvent.RolePermissionStateCreated) stateEvent;
            return toRolePermissionStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            RolePermissionStateEvent.RolePermissionStateMergePatched e = (RolePermissionStateEvent.RolePermissionStateMergePatched) stateEvent;
            return toRolePermissionStateMergePatchedDto(e);
        } else if (StateEventType.DELETED.equals(stateEvent.getStateEventType())) {
            RolePermissionStateEvent.RolePermissionStateDeleted e = (RolePermissionStateEvent.RolePermissionStateDeleted) stateEvent;
            return toRolePermissionStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public RolePermissionStateEventDto.RolePermissionStateCreatedDto toRolePermissionStateCreatedDto(RolePermissionStateEvent.RolePermissionStateCreated e) {
        RolePermissionStateEventDto.RolePermissionStateCreatedDto dto = new RolePermissionStateEventDto.RolePermissionStateCreatedDto();
        dto.setStateEventId(new RolePermissionStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        return dto;
    }

    public RolePermissionStateEventDto.RolePermissionStateMergePatchedDto toRolePermissionStateMergePatchedDto(RolePermissionStateEvent.RolePermissionStateMergePatched e) {
        RolePermissionStateEventDto.RolePermissionStateMergePatchedDto dto = new RolePermissionStateEventDto.RolePermissionStateMergePatchedDto();
        dto.setStateEventId(new RolePermissionStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public RolePermissionStateEventDto.RolePermissionStateDeletedDto toRolePermissionStateDeletedDto(RolePermissionStateEvent.RolePermissionStateDeleted e) {
        RolePermissionStateEventDto.RolePermissionStateDeletedDto dto = new RolePermissionStateEventDto.RolePermissionStateDeletedDto();
        dto.setStateEventId(new RolePermissionStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

