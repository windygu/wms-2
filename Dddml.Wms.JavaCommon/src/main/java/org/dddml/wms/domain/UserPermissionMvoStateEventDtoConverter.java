package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;

public class UserPermissionMvoStateEventDtoConverter {

    public UserPermissionMvoStateEventDto toUserPermissionMvoStateEventDto(AbstractUserPermissionMvoStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            UserPermissionMvoStateEvent.UserPermissionMvoStateCreated e = (UserPermissionMvoStateEvent.UserPermissionMvoStateCreated) stateEvent;
            return toUserPermissionMvoStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            UserPermissionMvoStateEvent.UserPermissionMvoStateMergePatched e = (UserPermissionMvoStateEvent.UserPermissionMvoStateMergePatched) stateEvent;
            return toUserPermissionMvoStateMergePatchedDto(e);
        } else if (StateEventType.DELETED.equals(stateEvent.getStateEventType())) {
            UserPermissionMvoStateEvent.UserPermissionMvoStateDeleted e = (UserPermissionMvoStateEvent.UserPermissionMvoStateDeleted) stateEvent;
            return toUserPermissionMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public UserPermissionMvoStateEventDto.UserPermissionMvoStateCreatedDto toUserPermissionMvoStateCreatedDto(UserPermissionMvoStateEvent.UserPermissionMvoStateCreated e) {
        UserPermissionMvoStateEventDto.UserPermissionMvoStateCreatedDto dto = new UserPermissionMvoStateEventDto.UserPermissionMvoStateCreatedDto();
        dto.setStateEventId(new UserPermissionMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setUserUserName(e.getUserUserName());
        dto.setUserAccessFailedCount(e.getUserAccessFailedCount());
        dto.setUserEmail(e.getUserEmail());
        dto.setUserEmailConfirmed(e.getUserEmailConfirmed());
        dto.setUserLockoutEnabled(e.getUserLockoutEnabled());
        dto.setUserLockoutEndDateUtc(e.getUserLockoutEndDateUtc());
        dto.setUserPasswordHash(e.getUserPasswordHash());
        dto.setUserPhoneNumber(e.getUserPhoneNumber());
        dto.setUserPhoneNumberConfirmed(e.getUserPhoneNumberConfirmed());
        dto.setUserTwoFactorEnabled(e.getUserTwoFactorEnabled());
        dto.setUserSecurityStamp(e.getUserSecurityStamp());
        dto.setUserCreatedBy(e.getUserCreatedBy());
        dto.setUserCreatedAt(e.getUserCreatedAt());
        dto.setUserUpdatedBy(e.getUserUpdatedBy());
        dto.setUserUpdatedAt(e.getUserUpdatedAt());
        dto.setUserActive(e.getUserActive());
        dto.setUserDeleted(e.getUserDeleted());
        return dto;
    }

    public UserPermissionMvoStateEventDto.UserPermissionMvoStateMergePatchedDto toUserPermissionMvoStateMergePatchedDto(UserPermissionMvoStateEvent.UserPermissionMvoStateMergePatched e) {
        UserPermissionMvoStateEventDto.UserPermissionMvoStateMergePatchedDto dto = new UserPermissionMvoStateEventDto.UserPermissionMvoStateMergePatchedDto();
        dto.setStateEventId(new UserPermissionMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setUserUserName(e.getUserUserName());
        dto.setUserAccessFailedCount(e.getUserAccessFailedCount());
        dto.setUserEmail(e.getUserEmail());
        dto.setUserEmailConfirmed(e.getUserEmailConfirmed());
        dto.setUserLockoutEnabled(e.getUserLockoutEnabled());
        dto.setUserLockoutEndDateUtc(e.getUserLockoutEndDateUtc());
        dto.setUserPasswordHash(e.getUserPasswordHash());
        dto.setUserPhoneNumber(e.getUserPhoneNumber());
        dto.setUserPhoneNumberConfirmed(e.getUserPhoneNumberConfirmed());
        dto.setUserTwoFactorEnabled(e.getUserTwoFactorEnabled());
        dto.setUserSecurityStamp(e.getUserSecurityStamp());
        dto.setUserCreatedBy(e.getUserCreatedBy());
        dto.setUserCreatedAt(e.getUserCreatedAt());
        dto.setUserUpdatedBy(e.getUserUpdatedBy());
        dto.setUserUpdatedAt(e.getUserUpdatedAt());
        dto.setUserActive(e.getUserActive());
        dto.setUserDeleted(e.getUserDeleted());
        dto.setIsPropertyVersionRemoved(e.getIsPropertyVersionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        dto.setIsPropertyUserUserNameRemoved(e.getIsPropertyUserUserNameRemoved());
        dto.setIsPropertyUserAccessFailedCountRemoved(e.getIsPropertyUserAccessFailedCountRemoved());
        dto.setIsPropertyUserEmailRemoved(e.getIsPropertyUserEmailRemoved());
        dto.setIsPropertyUserEmailConfirmedRemoved(e.getIsPropertyUserEmailConfirmedRemoved());
        dto.setIsPropertyUserLockoutEnabledRemoved(e.getIsPropertyUserLockoutEnabledRemoved());
        dto.setIsPropertyUserLockoutEndDateUtcRemoved(e.getIsPropertyUserLockoutEndDateUtcRemoved());
        dto.setIsPropertyUserPasswordHashRemoved(e.getIsPropertyUserPasswordHashRemoved());
        dto.setIsPropertyUserPhoneNumberRemoved(e.getIsPropertyUserPhoneNumberRemoved());
        dto.setIsPropertyUserPhoneNumberConfirmedRemoved(e.getIsPropertyUserPhoneNumberConfirmedRemoved());
        dto.setIsPropertyUserTwoFactorEnabledRemoved(e.getIsPropertyUserTwoFactorEnabledRemoved());
        dto.setIsPropertyUserSecurityStampRemoved(e.getIsPropertyUserSecurityStampRemoved());
        dto.setIsPropertyUserCreatedByRemoved(e.getIsPropertyUserCreatedByRemoved());
        dto.setIsPropertyUserCreatedAtRemoved(e.getIsPropertyUserCreatedAtRemoved());
        dto.setIsPropertyUserUpdatedByRemoved(e.getIsPropertyUserUpdatedByRemoved());
        dto.setIsPropertyUserUpdatedAtRemoved(e.getIsPropertyUserUpdatedAtRemoved());
        dto.setIsPropertyUserActiveRemoved(e.getIsPropertyUserActiveRemoved());
        dto.setIsPropertyUserDeletedRemoved(e.getIsPropertyUserDeletedRemoved());
        return dto;
    }


    public UserPermissionMvoStateEventDto.UserPermissionMvoStateDeletedDto toUserPermissionMvoStateDeletedDto(UserPermissionMvoStateEvent.UserPermissionMvoStateDeleted e) {
        UserPermissionMvoStateEventDto.UserPermissionMvoStateDeletedDto dto = new UserPermissionMvoStateEventDto.UserPermissionMvoStateDeletedDto();
        dto.setStateEventId(new UserPermissionMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

