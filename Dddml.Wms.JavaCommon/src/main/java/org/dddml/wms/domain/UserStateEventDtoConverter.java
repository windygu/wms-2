package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;

public class UserStateEventDtoConverter {

    public UserStateEventDto toUserStateEventDto(AbstractUserStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            UserStateEvent.UserStateCreated e = (UserStateEvent.UserStateCreated) stateEvent;
            return toUserStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            UserStateEvent.UserStateMergePatched e = (UserStateEvent.UserStateMergePatched) stateEvent;
            return toUserStateMergePatchedDto(e);
        } else if (StateEventType.DELETED.equals(stateEvent.getStateEventType())) {
            UserStateEvent.UserStateDeleted e = (UserStateEvent.UserStateDeleted) stateEvent;
            return toUserStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public UserStateEventDto.UserStateCreatedDto toUserStateCreatedDto(UserStateEvent.UserStateCreated e) {
        UserStateEventDto.UserStateCreatedDto dto = new UserStateEventDto.UserStateCreatedDto();
        dto.setStateEventId(new UserStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setUserName(e.getUserName());
        dto.setAccessFailedCount(e.getAccessFailedCount());
        dto.setEmail(e.getEmail());
        dto.setEmailConfirmed(e.getEmailConfirmed());
        dto.setLockoutEnabled(e.getLockoutEnabled());
        dto.setLockoutEndDateUtc(e.getLockoutEndDateUtc());
        dto.setPasswordHash(e.getPasswordHash());
        dto.setPhoneNumber(e.getPhoneNumber());
        dto.setPhoneNumberConfirmed(e.getPhoneNumberConfirmed());
        dto.setTwoFactorEnabled(e.getTwoFactorEnabled());
        dto.setSecurityStamp(e.getSecurityStamp());
        dto.setActive(e.getActive());
        List<UserRoleStateEventDto.UserRoleStateCreatedDto> userRoleEvents = new ArrayList<>();
        for (UserRoleStateEvent.UserRoleStateCreated ee : e.getUserRoleEvents()) {
            UserRoleStateEventDto.UserRoleStateCreatedDto eeDto = getUserRoleStateEventDtoConverter().toUserRoleStateCreatedDto(ee);
            userRoleEvents.add(eeDto);
        }
        dto.setUserRoleEvents(userRoleEvents.toArray(new UserRoleStateEventDto.UserRoleStateCreatedDto[0]));

        List<UserClaimStateEventDto.UserClaimStateCreatedDto> userClaimEvents = new ArrayList<>();
        for (UserClaimStateEvent.UserClaimStateCreated ee : e.getUserClaimEvents()) {
            UserClaimStateEventDto.UserClaimStateCreatedDto eeDto = getUserClaimStateEventDtoConverter().toUserClaimStateCreatedDto(ee);
            userClaimEvents.add(eeDto);
        }
        dto.setUserClaimEvents(userClaimEvents.toArray(new UserClaimStateEventDto.UserClaimStateCreatedDto[0]));

        List<UserPermissionStateEventDto.UserPermissionStateCreatedDto> userPermissionEvents = new ArrayList<>();
        for (UserPermissionStateEvent.UserPermissionStateCreated ee : e.getUserPermissionEvents()) {
            UserPermissionStateEventDto.UserPermissionStateCreatedDto eeDto = getUserPermissionStateEventDtoConverter().toUserPermissionStateCreatedDto(ee);
            userPermissionEvents.add(eeDto);
        }
        dto.setUserPermissionEvents(userPermissionEvents.toArray(new UserPermissionStateEventDto.UserPermissionStateCreatedDto[0]));

        List<UserLoginStateEventDto.UserLoginStateCreatedDto> userLoginEvents = new ArrayList<>();
        for (UserLoginStateEvent.UserLoginStateCreated ee : e.getUserLoginEvents()) {
            UserLoginStateEventDto.UserLoginStateCreatedDto eeDto = getUserLoginStateEventDtoConverter().toUserLoginStateCreatedDto(ee);
            userLoginEvents.add(eeDto);
        }
        dto.setUserLoginEvents(userLoginEvents.toArray(new UserLoginStateEventDto.UserLoginStateCreatedDto[0]));

        return dto;
    }

    public UserStateEventDto.UserStateMergePatchedDto toUserStateMergePatchedDto(UserStateEvent.UserStateMergePatched e) {
        UserStateEventDto.UserStateMergePatchedDto dto = new UserStateEventDto.UserStateMergePatchedDto();
        dto.setStateEventId(new UserStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setUserName(e.getUserName());
        dto.setAccessFailedCount(e.getAccessFailedCount());
        dto.setEmail(e.getEmail());
        dto.setEmailConfirmed(e.getEmailConfirmed());
        dto.setLockoutEnabled(e.getLockoutEnabled());
        dto.setLockoutEndDateUtc(e.getLockoutEndDateUtc());
        dto.setPasswordHash(e.getPasswordHash());
        dto.setPhoneNumber(e.getPhoneNumber());
        dto.setPhoneNumberConfirmed(e.getPhoneNumberConfirmed());
        dto.setTwoFactorEnabled(e.getTwoFactorEnabled());
        dto.setSecurityStamp(e.getSecurityStamp());
        dto.setActive(e.getActive());
        dto.setIsPropertyUserNameRemoved(e.getIsPropertyUserNameRemoved());
        dto.setIsPropertyAccessFailedCountRemoved(e.getIsPropertyAccessFailedCountRemoved());
        dto.setIsPropertyEmailRemoved(e.getIsPropertyEmailRemoved());
        dto.setIsPropertyEmailConfirmedRemoved(e.getIsPropertyEmailConfirmedRemoved());
        dto.setIsPropertyLockoutEnabledRemoved(e.getIsPropertyLockoutEnabledRemoved());
        dto.setIsPropertyLockoutEndDateUtcRemoved(e.getIsPropertyLockoutEndDateUtcRemoved());
        dto.setIsPropertyPasswordHashRemoved(e.getIsPropertyPasswordHashRemoved());
        dto.setIsPropertyPhoneNumberRemoved(e.getIsPropertyPhoneNumberRemoved());
        dto.setIsPropertyPhoneNumberConfirmedRemoved(e.getIsPropertyPhoneNumberConfirmedRemoved());
        dto.setIsPropertyTwoFactorEnabledRemoved(e.getIsPropertyTwoFactorEnabledRemoved());
        dto.setIsPropertySecurityStampRemoved(e.getIsPropertySecurityStampRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        List<UserRoleStateEventDto> userRoleEvents = new ArrayList<>();
        for (UserRoleStateEvent ee : e.getUserRoleEvents()) {
            UserRoleStateEventDto eeDto = getUserRoleStateEventDtoConverter().toUserRoleStateEventDto((AbstractUserRoleStateEvent) ee);
            userRoleEvents.add(eeDto);
        }
        dto.setUserRoleEvents(userRoleEvents.toArray(new UserRoleStateEventDto[0]));

        List<UserClaimStateEventDto> userClaimEvents = new ArrayList<>();
        for (UserClaimStateEvent ee : e.getUserClaimEvents()) {
            UserClaimStateEventDto eeDto = getUserClaimStateEventDtoConverter().toUserClaimStateEventDto((AbstractUserClaimStateEvent) ee);
            userClaimEvents.add(eeDto);
        }
        dto.setUserClaimEvents(userClaimEvents.toArray(new UserClaimStateEventDto[0]));

        List<UserPermissionStateEventDto> userPermissionEvents = new ArrayList<>();
        for (UserPermissionStateEvent ee : e.getUserPermissionEvents()) {
            UserPermissionStateEventDto eeDto = getUserPermissionStateEventDtoConverter().toUserPermissionStateEventDto((AbstractUserPermissionStateEvent) ee);
            userPermissionEvents.add(eeDto);
        }
        dto.setUserPermissionEvents(userPermissionEvents.toArray(new UserPermissionStateEventDto[0]));

        List<UserLoginStateEventDto> userLoginEvents = new ArrayList<>();
        for (UserLoginStateEvent ee : e.getUserLoginEvents()) {
            UserLoginStateEventDto eeDto = getUserLoginStateEventDtoConverter().toUserLoginStateEventDto((AbstractUserLoginStateEvent) ee);
            userLoginEvents.add(eeDto);
        }
        dto.setUserLoginEvents(userLoginEvents.toArray(new UserLoginStateEventDto[0]));

        return dto;
    }


    public UserStateEventDto.UserStateDeletedDto toUserStateDeletedDto(UserStateEvent.UserStateDeleted e) {
        UserStateEventDto.UserStateDeletedDto dto = new UserStateEventDto.UserStateDeletedDto();
        dto.setStateEventId(new UserStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        List<UserRoleStateEventDto.UserRoleStateRemovedDto> userRoleEvents = new ArrayList<>();
        for (UserRoleStateEvent.UserRoleStateRemoved ee : e.getUserRoleEvents()) {
            UserRoleStateEventDto.UserRoleStateRemovedDto eeDto = getUserRoleStateEventDtoConverter().toUserRoleStateRemovedDto(ee);
            userRoleEvents.add(eeDto);
        }
        dto.setUserRoleEvents(userRoleEvents.toArray(new UserRoleStateEventDto.UserRoleStateRemovedDto[0]));

        List<UserClaimStateEventDto.UserClaimStateRemovedDto> userClaimEvents = new ArrayList<>();
        for (UserClaimStateEvent.UserClaimStateRemoved ee : e.getUserClaimEvents()) {
            UserClaimStateEventDto.UserClaimStateRemovedDto eeDto = getUserClaimStateEventDtoConverter().toUserClaimStateRemovedDto(ee);
            userClaimEvents.add(eeDto);
        }
        dto.setUserClaimEvents(userClaimEvents.toArray(new UserClaimStateEventDto.UserClaimStateRemovedDto[0]));

        List<UserPermissionStateEventDto.UserPermissionStateRemovedDto> userPermissionEvents = new ArrayList<>();
        for (UserPermissionStateEvent.UserPermissionStateRemoved ee : e.getUserPermissionEvents()) {
            UserPermissionStateEventDto.UserPermissionStateRemovedDto eeDto = getUserPermissionStateEventDtoConverter().toUserPermissionStateRemovedDto(ee);
            userPermissionEvents.add(eeDto);
        }
        dto.setUserPermissionEvents(userPermissionEvents.toArray(new UserPermissionStateEventDto.UserPermissionStateRemovedDto[0]));

        List<UserLoginStateEventDto.UserLoginStateRemovedDto> userLoginEvents = new ArrayList<>();
        for (UserLoginStateEvent.UserLoginStateRemoved ee : e.getUserLoginEvents()) {
            UserLoginStateEventDto.UserLoginStateRemovedDto eeDto = getUserLoginStateEventDtoConverter().toUserLoginStateRemovedDto(ee);
            userLoginEvents.add(eeDto);
        }
        dto.setUserLoginEvents(userLoginEvents.toArray(new UserLoginStateEventDto.UserLoginStateRemovedDto[0]));

        return dto;
    }

    protected UserRoleStateEventDtoConverter getUserRoleStateEventDtoConverter() {
        return new UserRoleStateEventDtoConverter();
    }

    protected UserClaimStateEventDtoConverter getUserClaimStateEventDtoConverter() {
        return new UserClaimStateEventDtoConverter();
    }

    protected UserPermissionStateEventDtoConverter getUserPermissionStateEventDtoConverter() {
        return new UserPermissionStateEventDtoConverter();
    }

    protected UserLoginStateEventDtoConverter getUserLoginStateEventDtoConverter() {
        return new UserLoginStateEventDtoConverter();
    }

}

