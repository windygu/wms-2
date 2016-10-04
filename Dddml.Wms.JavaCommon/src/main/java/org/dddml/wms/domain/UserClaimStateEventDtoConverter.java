package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;

public class UserClaimStateEventDtoConverter {

    public UserClaimStateEventDto toUserClaimStateEventDto(AbstractUserClaimStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            UserClaimStateEvent.UserClaimStateCreated e = (UserClaimStateEvent.UserClaimStateCreated) stateEvent;
            return toUserClaimStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            UserClaimStateEvent.UserClaimStateMergePatched e = (UserClaimStateEvent.UserClaimStateMergePatched) stateEvent;
            return toUserClaimStateMergePatchedDto(e);
        } else if (StateEventType.REMOVED.equals(stateEvent.getStateEventType())) {
            UserClaimStateEvent.UserClaimStateRemoved e = (UserClaimStateEvent.UserClaimStateRemoved) stateEvent;
            return toUserClaimStateRemovedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public UserClaimStateEventDto.UserClaimStateCreatedDto toUserClaimStateCreatedDto(UserClaimStateEvent.UserClaimStateCreated e) {
        UserClaimStateEventDto.UserClaimStateCreatedDto dto = new UserClaimStateEventDto.UserClaimStateCreatedDto();
        dto.setStateEventId(new UserClaimStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setClaimType(e.getClaimType());
        dto.setClaimValue(e.getClaimValue());
        dto.setActive(e.getActive());
        return dto;
    }

    public UserClaimStateEventDto.UserClaimStateMergePatchedDto toUserClaimStateMergePatchedDto(UserClaimStateEvent.UserClaimStateMergePatched e) {
        UserClaimStateEventDto.UserClaimStateMergePatchedDto dto = new UserClaimStateEventDto.UserClaimStateMergePatchedDto();
        dto.setStateEventId(new UserClaimStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setClaimType(e.getClaimType());
        dto.setClaimValue(e.getClaimValue());
        dto.setActive(e.getActive());
        dto.setIsPropertyClaimTypeRemoved(e.getIsPropertyClaimTypeRemoved());
        dto.setIsPropertyClaimValueRemoved(e.getIsPropertyClaimValueRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public UserClaimStateEventDto.UserClaimStateRemovedDto toUserClaimStateRemovedDto(UserClaimStateEvent.UserClaimStateRemoved e) {
        UserClaimStateEventDto.UserClaimStateRemovedDto dto = new UserClaimStateEventDto.UserClaimStateRemovedDto();
        dto.setStateEventId(new UserClaimStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

