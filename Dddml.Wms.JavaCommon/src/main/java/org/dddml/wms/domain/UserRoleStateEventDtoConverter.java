package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;

public class UserRoleStateEventDtoConverter {

    public UserRoleStateEventDto toUserRoleStateEventDto(AbstractUserRoleStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            UserRoleStateEvent.UserRoleStateCreated e = (UserRoleStateEvent.UserRoleStateCreated) stateEvent;
            return toUserRoleStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            UserRoleStateEvent.UserRoleStateMergePatched e = (UserRoleStateEvent.UserRoleStateMergePatched) stateEvent;
            return toUserRoleStateMergePatchedDto(e);
        } else if (StateEventType.REMOVED.equals(stateEvent.getStateEventType())) {
            UserRoleStateEvent.UserRoleStateRemoved e = (UserRoleStateEvent.UserRoleStateRemoved) stateEvent;
            return toUserRoleStateRemovedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public UserRoleStateEventDto.UserRoleStateCreatedDto toUserRoleStateCreatedDto(UserRoleStateEvent.UserRoleStateCreated e) {
        UserRoleStateEventDto.UserRoleStateCreatedDto dto = new UserRoleStateEventDto.UserRoleStateCreatedDto();
        dto.setStateEventId(new UserRoleStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        return dto;
    }

    public UserRoleStateEventDto.UserRoleStateMergePatchedDto toUserRoleStateMergePatchedDto(UserRoleStateEvent.UserRoleStateMergePatched e) {
        UserRoleStateEventDto.UserRoleStateMergePatchedDto dto = new UserRoleStateEventDto.UserRoleStateMergePatchedDto();
        dto.setStateEventId(new UserRoleStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public UserRoleStateEventDto.UserRoleStateRemovedDto toUserRoleStateRemovedDto(UserRoleStateEvent.UserRoleStateRemoved e) {
        UserRoleStateEventDto.UserRoleStateRemovedDto dto = new UserRoleStateEventDto.UserRoleStateRemovedDto();
        dto.setStateEventId(new UserRoleStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

