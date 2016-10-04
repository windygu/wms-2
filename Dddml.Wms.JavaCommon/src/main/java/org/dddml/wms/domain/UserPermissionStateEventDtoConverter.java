package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;

public class UserPermissionStateEventDtoConverter {

    public UserPermissionStateEventDto toUserPermissionStateEventDto(AbstractUserPermissionStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            UserPermissionStateEvent.UserPermissionStateCreated e = (UserPermissionStateEvent.UserPermissionStateCreated) stateEvent;
            return toUserPermissionStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            UserPermissionStateEvent.UserPermissionStateMergePatched e = (UserPermissionStateEvent.UserPermissionStateMergePatched) stateEvent;
            return toUserPermissionStateMergePatchedDto(e);
        } else if (StateEventType.REMOVED.equals(stateEvent.getStateEventType())) {
            UserPermissionStateEvent.UserPermissionStateRemoved e = (UserPermissionStateEvent.UserPermissionStateRemoved) stateEvent;
            return toUserPermissionStateRemovedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public UserPermissionStateEventDto.UserPermissionStateCreatedDto toUserPermissionStateCreatedDto(UserPermissionStateEvent.UserPermissionStateCreated e) {
        UserPermissionStateEventDto.UserPermissionStateCreatedDto dto = new UserPermissionStateEventDto.UserPermissionStateCreatedDto();
        dto.setStateEventId(new UserPermissionStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        return dto;
    }

    public UserPermissionStateEventDto.UserPermissionStateMergePatchedDto toUserPermissionStateMergePatchedDto(UserPermissionStateEvent.UserPermissionStateMergePatched e) {
        UserPermissionStateEventDto.UserPermissionStateMergePatchedDto dto = new UserPermissionStateEventDto.UserPermissionStateMergePatchedDto();
        dto.setStateEventId(new UserPermissionStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public UserPermissionStateEventDto.UserPermissionStateRemovedDto toUserPermissionStateRemovedDto(UserPermissionStateEvent.UserPermissionStateRemoved e) {
        UserPermissionStateEventDto.UserPermissionStateRemovedDto dto = new UserPermissionStateEventDto.UserPermissionStateRemovedDto();
        dto.setStateEventId(new UserPermissionStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

