package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;

public class UserRoleMvoStateEventDtoConverter {

    public UserRoleMvoStateEventDto toUserRoleMvoStateEventDto(AbstractUserRoleMvoStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            UserRoleMvoStateEvent.UserRoleMvoStateCreated e = (UserRoleMvoStateEvent.UserRoleMvoStateCreated) stateEvent;
            return toUserRoleMvoStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            UserRoleMvoStateEvent.UserRoleMvoStateMergePatched e = (UserRoleMvoStateEvent.UserRoleMvoStateMergePatched) stateEvent;
            return toUserRoleMvoStateMergePatchedDto(e);
        } else if (StateEventType.DELETED.equals(stateEvent.getStateEventType())) {
            UserRoleMvoStateEvent.UserRoleMvoStateDeleted e = (UserRoleMvoStateEvent.UserRoleMvoStateDeleted) stateEvent;
            return toUserRoleMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public UserRoleMvoStateEventDto.UserRoleMvoStateCreatedDto toUserRoleMvoStateCreatedDto(UserRoleMvoStateEvent.UserRoleMvoStateCreated e) {
        UserRoleMvoStateEventDto.UserRoleMvoStateCreatedDto dto = new UserRoleMvoStateEventDto.UserRoleMvoStateCreatedDto();
        dto.setStateEventId(new UserRoleMvoStateEventIdDtoWrapper(e.getStateEventId()));
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

    public UserRoleMvoStateEventDto.UserRoleMvoStateMergePatchedDto toUserRoleMvoStateMergePatchedDto(UserRoleMvoStateEvent.UserRoleMvoStateMergePatched e) {
        UserRoleMvoStateEventDto.UserRoleMvoStateMergePatchedDto dto = new UserRoleMvoStateEventDto.UserRoleMvoStateMergePatchedDto();
        dto.setStateEventId(new UserRoleMvoStateEventIdDtoWrapper(e.getStateEventId()));
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


    public UserRoleMvoStateEventDto.UserRoleMvoStateDeletedDto toUserRoleMvoStateDeletedDto(UserRoleMvoStateEvent.UserRoleMvoStateDeleted e) {
        UserRoleMvoStateEventDto.UserRoleMvoStateDeletedDto dto = new UserRoleMvoStateEventDto.UserRoleMvoStateDeletedDto();
        dto.setStateEventId(new UserRoleMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

