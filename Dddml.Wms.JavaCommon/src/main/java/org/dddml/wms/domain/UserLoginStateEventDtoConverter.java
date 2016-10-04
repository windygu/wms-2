package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;

public class UserLoginStateEventDtoConverter {

    public UserLoginStateEventDto toUserLoginStateEventDto(AbstractUserLoginStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            UserLoginStateEvent.UserLoginStateCreated e = (UserLoginStateEvent.UserLoginStateCreated) stateEvent;
            return toUserLoginStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            UserLoginStateEvent.UserLoginStateMergePatched e = (UserLoginStateEvent.UserLoginStateMergePatched) stateEvent;
            return toUserLoginStateMergePatchedDto(e);
        } else if (StateEventType.REMOVED.equals(stateEvent.getStateEventType())) {
            UserLoginStateEvent.UserLoginStateRemoved e = (UserLoginStateEvent.UserLoginStateRemoved) stateEvent;
            return toUserLoginStateRemovedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public UserLoginStateEventDto.UserLoginStateCreatedDto toUserLoginStateCreatedDto(UserLoginStateEvent.UserLoginStateCreated e) {
        UserLoginStateEventDto.UserLoginStateCreatedDto dto = new UserLoginStateEventDto.UserLoginStateCreatedDto();
        dto.setStateEventId(new UserLoginStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        return dto;
    }

    public UserLoginStateEventDto.UserLoginStateMergePatchedDto toUserLoginStateMergePatchedDto(UserLoginStateEvent.UserLoginStateMergePatched e) {
        UserLoginStateEventDto.UserLoginStateMergePatchedDto dto = new UserLoginStateEventDto.UserLoginStateMergePatchedDto();
        dto.setStateEventId(new UserLoginStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setActive(e.getActive());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public UserLoginStateEventDto.UserLoginStateRemovedDto toUserLoginStateRemovedDto(UserLoginStateEvent.UserLoginStateRemoved e) {
        UserLoginStateEventDto.UserLoginStateRemovedDto dto = new UserLoginStateEventDto.UserLoginStateRemovedDto();
        dto.setStateEventId(new UserLoginStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

