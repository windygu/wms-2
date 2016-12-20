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

	public partial class UserPermissionState : UserPermissionStateProperties, IUserPermissionState
	{

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

		public virtual string UpdatedBy { get; set; }

		public virtual DateTime UpdatedAt { get; set; }

		public virtual bool Deleted { get; set; }


		#region IIdentity implementation

        private UserPermissionId _userPermissionId = new UserPermissionId();

        public virtual UserPermissionId UserPermissionId 
        {
            get { return this._userPermissionId; }
            set { this._userPermissionId = value; }
        }

		UserPermissionId IGlobalIdentity<UserPermissionId>.GlobalId {
			get {
				return  this.UserPermissionId;
			}
		}

        string ILocalIdentity<string>.LocalId
        {
            get
            {
                return this.PermissionId;
            }
        }


        public override string UserId {
			get {
				return this.UserPermissionId.UserId;
			}
			set {
				this.UserPermissionId.UserId = value;
			}
		}

        public override string PermissionId {
			get {
				return this.UserPermissionId.PermissionId;
			}
			set {
				this.UserPermissionId.PermissionId = value;
			}
		}

		#endregion



		#region IActive implementation

		bool IActive.IsActive()
		{
			return this.Active;
		}

		#endregion

		#region IDeleted implementation

		bool IDeleted.Deleted
		{
			get
			{
				return this.Deleted;
			}
		}

		#endregion

		#region ICreated implementation

		string ICreated<string>.CreatedBy
		{
			get
			{
				return this.CreatedBy;
			}
			set
			{
				this.CreatedBy = value;
			}
		}

		DateTime ICreated<string>.CreatedAt
		{
			get
			{
				return this.CreatedAt;
			}
			set
			{
				this.CreatedAt = value;
			}
		}

		#endregion

		#region IUpdated implementation

		string IUpdated<string>.UpdatedBy
		{
			get { return this.UpdatedBy; }
			set { this.UpdatedBy = value; }
		}

		DateTime IUpdated<string>.UpdatedAt
		{
			get { return this.UpdatedAt; }
			set { this.UpdatedAt = value; }
		}

		#endregion

		#region IVersioned implementation

		long IEntityVersioned<long>.EntityVersion
		{
			get
			{
				return this.Version;
			}
		}


		#endregion

        bool IUserPermissionState.IsUnsaved
        {
            get { return this.Version == VersionZero; }
        }

		public static long VersionZero
		{
			get
			{
				return (long)0;
			}
		}


        public virtual bool StateReadOnly { get; set; }

        bool IState.ReadOnly
        {
            get { return this.StateReadOnly; }
            set { this.StateReadOnly = value; }
        }
	
        private bool _forReapplying;

        public virtual bool ForReapplying
        {
            get { return _forReapplying; }
            set { _forReapplying = value; } 
        }

        public UserPermissionState() : this(false)
        {
        }

        public UserPermissionState(bool forReapplying)
        {
            this._forReapplying = forReapplying;
            InitializeProperties();
        }


		public virtual void When(IUserPermissionStateCreated e)
		{
			ThrowOnWrongEvent(e);
            this.Active = (e.Active != null && e.Active.HasValue) ? e.Active.Value : default(bool);

			this.Deleted = false;

			this.CreatedBy = e.CreatedBy;
			this.CreatedAt = e.CreatedAt;


		}


		public virtual void When(IUserPermissionStateMergePatched e)
		{
			ThrowOnWrongEvent(e);

			if (e.Active == null)
			{
				if (e.IsPropertyActiveRemoved)
				{
					this.Active = default(bool);
				}
			}
			else
			{
				this.Active = (e.Active != null && e.Active.HasValue) ? e.Active.Value : default(bool);
			}


			this.UpdatedBy = e.CreatedBy;
			this.UpdatedAt = e.CreatedAt;


		}

		public virtual void When(IUserPermissionStateRemoved e)
		{
			ThrowOnWrongEvent(e);

			this.Deleted = true;
			this.UpdatedBy = e.CreatedBy;
			this.UpdatedAt = e.CreatedAt;

		}


		public virtual void Mutate(IEvent e)
		{
            StateReadOnly = false;
			((dynamic)this).When((dynamic)e);
		}

        protected void ThrowOnWrongEvent(IUserPermissionStateEvent stateEvent)
        {
            var id = new System.Text.StringBuilder(); 
            id.Append("[").Append("UserPermission|");

            var stateEntityIdUserId = (this as IGlobalIdentity<UserPermissionId>).GlobalId.UserId;
            var eventEntityIdUserId = stateEvent.StateEventId.UserId;
            if (stateEntityIdUserId != eventEntityIdUserId)
            {
                throw DomainError.Named("mutateWrongEntity", "Entity Id UserId {0} in state but entity id UserId {1} in event", stateEntityIdUserId, eventEntityIdUserId);
            }
            id.Append(stateEntityIdUserId).Append(",");

            var stateEntityIdPermissionId = (this as IGlobalIdentity<UserPermissionId>).GlobalId.PermissionId;
            var eventEntityIdPermissionId = stateEvent.StateEventId.PermissionId;
            if (stateEntityIdPermissionId != eventEntityIdPermissionId)
            {
                throw DomainError.Named("mutateWrongEntity", "Entity Id PermissionId {0} in state but entity id PermissionId {1} in event", stateEntityIdPermissionId, eventEntityIdPermissionId);
            }
            id.Append(stateEntityIdPermissionId).Append(",");

            id.Append("]");

            if (ForReapplying) { return; }
            var stateVersion = this.Version;
            var eventVersion = stateEvent.Version;
            if (UserPermissionState.VersionZero == eventVersion)
            {
                eventVersion = stateEvent.Version = stateVersion;
            }
            if (stateVersion != eventVersion)
            {
                throw OptimisticConcurrencyException.Create(stateVersion, eventVersion, id.ToString());
            }
        }
    }

}

