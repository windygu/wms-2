﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;

namespace Dddml.Wms.Domain
{

    public class UserPermissionMvoStateEventDtoConverter
    {
        public virtual UserPermissionMvoStateCreatedOrMergePatchedOrDeletedDto ToUserPermissionMvoStateEventDto(IUserPermissionMvoStateEvent stateEvent)
        {
            if (stateEvent.StateEventType == StateEventType.Created)
            {
                var e = (IUserPermissionMvoStateCreated)stateEvent;
                return ToUserPermissionMvoStateCreatedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.MergePatched)
            {
                var e = (IUserPermissionMvoStateMergePatched)stateEvent;
                return ToUserPermissionMvoStateMergePatchedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.Deleted)
            {
                var e = (IUserPermissionMvoStateDeleted)stateEvent;
                return ToUserPermissionMvoStateDeletedDto(e);
            }

            throw DomainError.Named("invalidStateEventType", String.Format("Invalid state event type: {0}", stateEvent.StateEventType));
        }

        public virtual UserPermissionMvoStateCreatedDto ToUserPermissionMvoStateCreatedDto(IUserPermissionMvoStateCreated e)
        {
            var dto = new UserPermissionMvoStateCreatedDto();
            dto.StateEventId = new UserPermissionMvoStateEventIdDto(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.Version = e.Version;
            dto.Active = e.Active;
            dto.UserUserName = e.UserUserName;
            dto.UserAccessFailedCount = e.UserAccessFailedCount;
            dto.UserEmail = e.UserEmail;
            dto.UserEmailConfirmed = e.UserEmailConfirmed;
            dto.UserLockoutEnabled = e.UserLockoutEnabled;
            dto.UserLockoutEndDateUtc = e.UserLockoutEndDateUtc;
            dto.UserPasswordHash = e.UserPasswordHash;
            dto.UserPhoneNumber = e.UserPhoneNumber;
            dto.UserPhoneNumberConfirmed = e.UserPhoneNumberConfirmed;
            dto.UserTwoFactorEnabled = e.UserTwoFactorEnabled;
            dto.UserSecurityStamp = e.UserSecurityStamp;
            dto.UserCreatedBy = e.UserCreatedBy;
            dto.UserCreatedAt = e.UserCreatedAt;
            dto.UserUpdatedBy = e.UserUpdatedBy;
            dto.UserUpdatedAt = e.UserUpdatedAt;
            dto.UserActive = e.UserActive;
            dto.UserDeleted = e.UserDeleted;
            return dto;
        }

        public virtual UserPermissionMvoStateMergePatchedDto ToUserPermissionMvoStateMergePatchedDto(IUserPermissionMvoStateMergePatched e)
        {
            var dto = new UserPermissionMvoStateMergePatchedDto();
            dto.StateEventId = new UserPermissionMvoStateEventIdDto(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.Version = e.Version;
            dto.Active = e.Active;
            dto.UserUserName = e.UserUserName;
            dto.UserAccessFailedCount = e.UserAccessFailedCount;
            dto.UserEmail = e.UserEmail;
            dto.UserEmailConfirmed = e.UserEmailConfirmed;
            dto.UserLockoutEnabled = e.UserLockoutEnabled;
            dto.UserLockoutEndDateUtc = e.UserLockoutEndDateUtc;
            dto.UserPasswordHash = e.UserPasswordHash;
            dto.UserPhoneNumber = e.UserPhoneNumber;
            dto.UserPhoneNumberConfirmed = e.UserPhoneNumberConfirmed;
            dto.UserTwoFactorEnabled = e.UserTwoFactorEnabled;
            dto.UserSecurityStamp = e.UserSecurityStamp;
            dto.UserCreatedBy = e.UserCreatedBy;
            dto.UserCreatedAt = e.UserCreatedAt;
            dto.UserUpdatedBy = e.UserUpdatedBy;
            dto.UserUpdatedAt = e.UserUpdatedAt;
            dto.UserActive = e.UserActive;
            dto.UserDeleted = e.UserDeleted;
            dto.IsPropertyVersionRemoved = e.IsPropertyVersionRemoved;
            dto.IsPropertyActiveRemoved = e.IsPropertyActiveRemoved;
            dto.IsPropertyUserUserNameRemoved = e.IsPropertyUserUserNameRemoved;
            dto.IsPropertyUserAccessFailedCountRemoved = e.IsPropertyUserAccessFailedCountRemoved;
            dto.IsPropertyUserEmailRemoved = e.IsPropertyUserEmailRemoved;
            dto.IsPropertyUserEmailConfirmedRemoved = e.IsPropertyUserEmailConfirmedRemoved;
            dto.IsPropertyUserLockoutEnabledRemoved = e.IsPropertyUserLockoutEnabledRemoved;
            dto.IsPropertyUserLockoutEndDateUtcRemoved = e.IsPropertyUserLockoutEndDateUtcRemoved;
            dto.IsPropertyUserPasswordHashRemoved = e.IsPropertyUserPasswordHashRemoved;
            dto.IsPropertyUserPhoneNumberRemoved = e.IsPropertyUserPhoneNumberRemoved;
            dto.IsPropertyUserPhoneNumberConfirmedRemoved = e.IsPropertyUserPhoneNumberConfirmedRemoved;
            dto.IsPropertyUserTwoFactorEnabledRemoved = e.IsPropertyUserTwoFactorEnabledRemoved;
            dto.IsPropertyUserSecurityStampRemoved = e.IsPropertyUserSecurityStampRemoved;
            dto.IsPropertyUserCreatedByRemoved = e.IsPropertyUserCreatedByRemoved;
            dto.IsPropertyUserCreatedAtRemoved = e.IsPropertyUserCreatedAtRemoved;
            dto.IsPropertyUserUpdatedByRemoved = e.IsPropertyUserUpdatedByRemoved;
            dto.IsPropertyUserUpdatedAtRemoved = e.IsPropertyUserUpdatedAtRemoved;
            dto.IsPropertyUserActiveRemoved = e.IsPropertyUserActiveRemoved;
            dto.IsPropertyUserDeletedRemoved = e.IsPropertyUserDeletedRemoved;

            return dto;
        }


        public virtual UserPermissionMvoStateDeletedDto ToUserPermissionMvoStateDeletedDto(IUserPermissionMvoStateDeleted e)
        {
            var dto = new UserPermissionMvoStateDeletedDto();
            dto.StateEventId = new UserPermissionMvoStateEventIdDto(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;

            return dto;
        }


    }


}

