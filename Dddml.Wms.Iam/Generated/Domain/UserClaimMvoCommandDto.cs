﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.UserClaimMvo;
using Dddml.Wms.Domain.User;

namespace Dddml.Wms.Domain.UserClaimMvo
{

	public abstract class UserClaimMvoCommandDtoBase : ICommandDto, ICreateUserClaimMvo, IMergePatchUserClaimMvo, IDeleteUserClaimMvo
	{

		UserClaimId IAggregateCommand<UserClaimId, long>.AggregateId
		{
			get
			{
				return ((ICreateOrMergePatchOrDeleteUserClaimMvo)this).UserClaimId;
			}
		}


		long IAggregateCommand<UserClaimId, long>.AggregateVersion
		{
			get
			{
				return this.UserVersion != null ? this.UserVersion.Value : default(long);
			}
		}

        long IUserClaimMvoCommand.UserVersion
        {
            get { return this.UserVersion != null ? this.UserVersion.Value : default(long); }
            set { this.UserVersion = value; }
        }

		public virtual long? UserVersion { get; set; }

		public virtual string RequesterId { get; set; }

		public virtual string CommandId { get; set; }

        object ICommand.RequesterId
        {
            get { return this.RequesterId; }
            set { this.RequesterId = (string)value; }
        }

        string ICommand.CommandId
        {
            get { return this.CommandId; }
            set { this.CommandId = value; }
        }

		public virtual UserClaimId UserClaimId { get; set; }

		public virtual string ClaimType { get; set; }

		public virtual string ClaimValue { get; set; }

		public virtual long? Version { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string UserUserName { get; set; }

		public virtual int? UserAccessFailedCount { get; set; }

		public virtual string UserEmail { get; set; }

		public virtual bool? UserEmailConfirmed { get; set; }

		public virtual bool? UserLockoutEnabled { get; set; }

		public virtual DateTime? UserLockoutEndDateUtc { get; set; }

		public virtual string UserPasswordHash { get; set; }

		public virtual string UserPhoneNumber { get; set; }

		public virtual bool? UserPhoneNumberConfirmed { get; set; }

		public virtual bool? UserTwoFactorEnabled { get; set; }

		public virtual string UserSecurityStamp { get; set; }

		public virtual string UserCreatedBy { get; set; }

		public virtual DateTime? UserCreatedAt { get; set; }

		public virtual string UserUpdatedBy { get; set; }

		public virtual DateTime? UserUpdatedAt { get; set; }

		public virtual bool? UserActive { get; set; }

		public virtual bool? UserDeleted { get; set; }

		public virtual bool? IsPropertyClaimTypeRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyClaimTypeRemoved
        {
            get
            {
                var b = this.IsPropertyClaimTypeRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyClaimTypeRemoved = value;
            }
        }

		public virtual bool? IsPropertyClaimValueRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyClaimValueRemoved
        {
            get
            {
                var b = this.IsPropertyClaimValueRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyClaimValueRemoved = value;
            }
        }

		public virtual bool? IsPropertyVersionRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyVersionRemoved
        {
            get
            {
                var b = this.IsPropertyVersionRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyVersionRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyActiveRemoved
        {
            get
            {
                var b = this.IsPropertyActiveRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyActiveRemoved = value;
            }
        }

		public virtual bool? IsPropertyUserUserNameRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyUserUserNameRemoved
        {
            get
            {
                var b = this.IsPropertyUserUserNameRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyUserUserNameRemoved = value;
            }
        }

		public virtual bool? IsPropertyUserAccessFailedCountRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyUserAccessFailedCountRemoved
        {
            get
            {
                var b = this.IsPropertyUserAccessFailedCountRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyUserAccessFailedCountRemoved = value;
            }
        }

		public virtual bool? IsPropertyUserEmailRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyUserEmailRemoved
        {
            get
            {
                var b = this.IsPropertyUserEmailRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyUserEmailRemoved = value;
            }
        }

		public virtual bool? IsPropertyUserEmailConfirmedRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyUserEmailConfirmedRemoved
        {
            get
            {
                var b = this.IsPropertyUserEmailConfirmedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyUserEmailConfirmedRemoved = value;
            }
        }

		public virtual bool? IsPropertyUserLockoutEnabledRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyUserLockoutEnabledRemoved
        {
            get
            {
                var b = this.IsPropertyUserLockoutEnabledRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyUserLockoutEnabledRemoved = value;
            }
        }

		public virtual bool? IsPropertyUserLockoutEndDateUtcRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyUserLockoutEndDateUtcRemoved
        {
            get
            {
                var b = this.IsPropertyUserLockoutEndDateUtcRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyUserLockoutEndDateUtcRemoved = value;
            }
        }

		public virtual bool? IsPropertyUserPasswordHashRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyUserPasswordHashRemoved
        {
            get
            {
                var b = this.IsPropertyUserPasswordHashRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyUserPasswordHashRemoved = value;
            }
        }

		public virtual bool? IsPropertyUserPhoneNumberRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyUserPhoneNumberRemoved
        {
            get
            {
                var b = this.IsPropertyUserPhoneNumberRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyUserPhoneNumberRemoved = value;
            }
        }

		public virtual bool? IsPropertyUserPhoneNumberConfirmedRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyUserPhoneNumberConfirmedRemoved
        {
            get
            {
                var b = this.IsPropertyUserPhoneNumberConfirmedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyUserPhoneNumberConfirmedRemoved = value;
            }
        }

		public virtual bool? IsPropertyUserTwoFactorEnabledRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyUserTwoFactorEnabledRemoved
        {
            get
            {
                var b = this.IsPropertyUserTwoFactorEnabledRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyUserTwoFactorEnabledRemoved = value;
            }
        }

		public virtual bool? IsPropertyUserSecurityStampRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyUserSecurityStampRemoved
        {
            get
            {
                var b = this.IsPropertyUserSecurityStampRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyUserSecurityStampRemoved = value;
            }
        }

		public virtual bool? IsPropertyUserCreatedByRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyUserCreatedByRemoved
        {
            get
            {
                var b = this.IsPropertyUserCreatedByRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyUserCreatedByRemoved = value;
            }
        }

		public virtual bool? IsPropertyUserCreatedAtRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyUserCreatedAtRemoved
        {
            get
            {
                var b = this.IsPropertyUserCreatedAtRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyUserCreatedAtRemoved = value;
            }
        }

		public virtual bool? IsPropertyUserUpdatedByRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyUserUpdatedByRemoved
        {
            get
            {
                var b = this.IsPropertyUserUpdatedByRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyUserUpdatedByRemoved = value;
            }
        }

		public virtual bool? IsPropertyUserUpdatedAtRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyUserUpdatedAtRemoved
        {
            get
            {
                var b = this.IsPropertyUserUpdatedAtRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyUserUpdatedAtRemoved = value;
            }
        }

		public virtual bool? IsPropertyUserActiveRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyUserActiveRemoved
        {
            get
            {
                var b = this.IsPropertyUserActiveRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyUserActiveRemoved = value;
            }
        }

		public virtual bool? IsPropertyUserDeletedRemoved { get; set; }

        bool IMergePatchUserClaimMvo.IsPropertyUserDeletedRemoved
        {
            get
            {
                var b = this.IsPropertyUserDeletedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyUserDeletedRemoved = value;
            }
        }


        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();

	}


    public class CreateOrMergePatchOrDeleteUserClaimMvoDto : UserClaimMvoCommandDtoBase
    {
        private string _commandType;

        public virtual string CommandType
        {
            get { return _commandType; }
            set { _commandType = value; }
        }

        protected override string GetCommandType()
        {
            return this._commandType;
        }

    }



	public class CreateUserClaimMvoDto : CreateOrMergePatchOrDeleteUserClaimMvoDto
	{

        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Create;
        }

	}


	public class MergePatchUserClaimMvoDto : CreateOrMergePatchOrDeleteUserClaimMvoDto
	{

        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.MergePatch;
        }

	}

	public class DeleteUserClaimMvoDto : CreateOrMergePatchOrDeleteUserClaimMvoDto
	{
        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Delete;
        }


        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

	}

    public static partial class UserClaimMvoCommandDtos
    {

    }

}

