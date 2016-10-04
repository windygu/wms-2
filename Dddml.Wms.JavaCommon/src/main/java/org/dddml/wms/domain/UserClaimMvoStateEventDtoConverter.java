package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;

public class UserClaimMvoStateEventDtoConverter {

    public UserClaimMvoStateEventDto toUserClaimMvoStateEventDto(AbstractUserClaimMvoStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            UserClaimMvoStateEvent.UserClaimMvoStateCreated e = (UserClaimMvoStateEvent.UserClaimMvoStateCreated) stateEvent;
            return toUserClaimMvoStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            UserClaimMvoStateEvent.UserClaimMvoStateMergePatched e = (UserClaimMvoStateEvent.UserClaimMvoStateMergePatched) stateEvent;
            return toUserClaimMvoStateMergePatchedDto(e);
        } else if (StateEventType.DELETED.equals(stateEvent.getStateEventType())) {
            UserClaimMvoStateEvent.UserClaimMvoStateDeleted e = (UserClaimMvoStateEvent.UserClaimMvoStateDeleted) stateEvent;
            return toUserClaimMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public UserClaimMvoStateEventDto.UserClaimMvoStateCreatedDto toUserClaimMvoStateCreatedDto(UserClaimMvoStateEvent.UserClaimMvoStateCreated e) {
        UserClaimMvoStateEventDto.UserClaimMvoStateCreatedDto dto = new UserClaimMvoStateEventDto.UserClaimMvoStateCreatedDto();
        dto.setStateEventId(new UserClaimMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setClaimType(e.getClaimType());
        dto.setClaimValue(e.getClaimValue());
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

    public UserClaimMvoStateEventDto.UserClaimMvoStateMergePatchedDto toUserClaimMvoStateMergePatchedDto(UserClaimMvoStateEvent.UserClaimMvoStateMergePatched e) {
        UserClaimMvoStateEventDto.UserClaimMvoStateMergePatchedDto dto = new UserClaimMvoStateEventDto.UserClaimMvoStateMergePatchedDto();
        dto.setStateEventId(new UserClaimMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setClaimType(e.getClaimType());
        dto.setClaimValue(e.getClaimValue());
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
        dto.setIsPropertyClaimTypeRemoved(e.getIsPropertyClaimTypeRemoved());
        dto.setIsPropertyClaimValueRemoved(e.getIsPropertyClaimValueRemoved());
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


    public UserClaimMvoStateEventDto.UserClaimMvoStateDeletedDto toUserClaimMvoStateDeletedDto(UserClaimMvoStateEvent.UserClaimMvoStateDeleted e) {
        UserClaimMvoStateEventDto.UserClaimMvoStateDeletedDto dto = new UserClaimMvoStateEventDto.UserClaimMvoStateDeletedDto();
        dto.setStateEventId(new UserClaimMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

