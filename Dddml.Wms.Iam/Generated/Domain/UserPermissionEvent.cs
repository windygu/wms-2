﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.User;

namespace Dddml.Wms.Domain.User
{

	public abstract class UserPermissionEventBase : IUserPermissionEvent
	{

		public virtual UserPermissionEventId UserPermissionEventId { get; set; }

        public virtual string PermissionId
        {
            get { return UserPermissionEventId.PermissionId; }
            set { UserPermissionEventId.PermissionId = value; }
        }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

        string IEvent.CommandId { get { return this.CommandId; } set { this.CommandId = value; } }

		UserPermissionEventId IGlobalIdentity<UserPermissionEventId>.GlobalId {
			get
			{
				return this.UserPermissionEventId;
			}
		}

        public virtual bool EventReadOnly { get; set; }

        bool IUserPermissionEvent.ReadOnly
        {
            get
            {
                return this.EventReadOnly;
            }
            set
            {
                this.EventReadOnly = value;
            }
        }

		public virtual long Version { get; set; }


		string ICreated<string>.CreatedBy {
			get {
				return this.CreatedBy;
			}
			set {
				this.CreatedBy = value;
			}
		}

		DateTime ICreated<string>.CreatedAt {
			get {
				return this.CreatedAt;
			}
			set {
				this.CreatedAt = value;
			}
		}

        protected UserPermissionEventBase()
        {
        }

        protected UserPermissionEventBase(UserPermissionEventId stateEventId)
        {
            this.UserPermissionEventId = stateEventId;
        }


        string IEventDto.EventType
        {
            get { return this.GetEventType(); }
        }

        protected abstract string GetEventType();

	}

    public abstract class UserPermissionStateEventBase : UserPermissionEventBase, IUserPermissionStateEvent
    {

		public virtual bool? Active { get; set; }

        protected UserPermissionStateEventBase() : base()
        {
        }

        protected UserPermissionStateEventBase(UserPermissionEventId stateEventId) : base(stateEventId)
        {
        }

    }

	public class UserPermissionStateCreated : UserPermissionStateEventBase, IUserPermissionStateCreated
	{
		public UserPermissionStateCreated () : this(new UserPermissionEventId())
		{
		}

		public UserPermissionStateCreated (UserPermissionEventId stateEventId) : base(stateEventId)
		{
		}


        protected override string GetEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Created;
        }

	}


	public class UserPermissionStateMergePatched : UserPermissionStateEventBase, IUserPermissionStateMergePatched
	{
		public virtual bool IsPropertyActiveRemoved { get; set; }


		public UserPermissionStateMergePatched ()
		{
		}

		public UserPermissionStateMergePatched (UserPermissionEventId stateEventId) : base(stateEventId)
		{
		}


        protected override string GetEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.MergePatched;
        }

	}


	public class UserPermissionStateRemoved : UserPermissionStateEventBase, IUserPermissionStateRemoved
	{
		public UserPermissionStateRemoved ()
		{
		}

		public UserPermissionStateRemoved (UserPermissionEventId stateEventId) : base(stateEventId)
		{
		}

        protected override string GetEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Removed;
        }



	}



}
