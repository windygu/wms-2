﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;

namespace Dddml.Wms.Domain
{

	public abstract class UserStateEventBase : IUserStateEvent
	{

		public virtual UserStateEventId StateEventId { get; set; }

		public virtual string UserName { get; set; }

		public virtual int? AccessFailedCount { get; set; }

		public virtual string Email { get; set; }

		public virtual bool? EmailConfirmed { get; set; }

		public virtual bool? LockoutEnabled { get; set; }

		public virtual DateTime? LockoutEndDateUtc { get; set; }

		public virtual string PasswordHash { get; set; }

		public virtual string PhoneNumber { get; set; }

		public virtual bool? PhoneNumberConfirmed { get; set; }

		public virtual bool? TwoFactorEnabled { get; set; }

		public virtual string SecurityStamp { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

        public virtual string CommandId { get; set; }

		UserStateEventId IGlobalIdentity<UserStateEventId>.GlobalId {
			get {
				return this.StateEventId;
			}
		}

        public virtual bool StateEventReadOnly { get; set; }

        bool IUserStateEvent.ReadOnly
        {
            get
            {
                return this.StateEventReadOnly;
            }
            set
            {
                this.StateEventReadOnly = value;
            }
        }


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

        protected UserStateEventBase()
        {
        }

        protected UserStateEventBase(UserStateEventId stateEventId)
        {
            this.StateEventId = stateEventId;
        }

		protected IUserRoleStateEventDao UserRoleStateEventDao
		{
			get { return ApplicationContext.Current["UserRoleStateEventDao"] as IUserRoleStateEventDao; }
		}

        protected UserRoleStateEventId NewUserRoleStateEventId(string roleId)
        {
            var stateEventId = new UserRoleStateEventId(this.StateEventId.UserId, roleId, this.StateEventId.Version);
            return stateEventId;
        }


        protected void ThrowOnInconsistentEventIds(IUserRoleStateEvent e)
        {
            ThrowOnInconsistentEventIds(this, e);
        }

		public static void ThrowOnInconsistentEventIds(IUserStateEvent oe, IUserRoleStateEvent e)
		{
			if (!oe.StateEventId.UserId.Equals(e.StateEventId.UserId))
			{ 
				throw DomainError.Named("inconsistentEventIds", "Outer Id UserId {0} but inner id UserId {1}", 
					oe.StateEventId.UserId, e.StateEventId.UserId);
			}
		}


		protected IUserClaimStateEventDao UserClaimStateEventDao
		{
			get { return ApplicationContext.Current["UserClaimStateEventDao"] as IUserClaimStateEventDao; }
		}

        protected UserClaimStateEventId NewUserClaimStateEventId(int claimId)
        {
            var stateEventId = new UserClaimStateEventId(this.StateEventId.UserId, claimId, this.StateEventId.Version);
            return stateEventId;
        }


        protected void ThrowOnInconsistentEventIds(IUserClaimStateEvent e)
        {
            ThrowOnInconsistentEventIds(this, e);
        }

		public static void ThrowOnInconsistentEventIds(IUserStateEvent oe, IUserClaimStateEvent e)
		{
			if (!oe.StateEventId.UserId.Equals(e.StateEventId.UserId))
			{ 
				throw DomainError.Named("inconsistentEventIds", "Outer Id UserId {0} but inner id UserId {1}", 
					oe.StateEventId.UserId, e.StateEventId.UserId);
			}
		}


		protected IUserPermissionStateEventDao UserPermissionStateEventDao
		{
			get { return ApplicationContext.Current["UserPermissionStateEventDao"] as IUserPermissionStateEventDao; }
		}

        protected UserPermissionStateEventId NewUserPermissionStateEventId(string permissionId)
        {
            var stateEventId = new UserPermissionStateEventId(this.StateEventId.UserId, permissionId, this.StateEventId.Version);
            return stateEventId;
        }


        protected void ThrowOnInconsistentEventIds(IUserPermissionStateEvent e)
        {
            ThrowOnInconsistentEventIds(this, e);
        }

		public static void ThrowOnInconsistentEventIds(IUserStateEvent oe, IUserPermissionStateEvent e)
		{
			if (!oe.StateEventId.UserId.Equals(e.StateEventId.UserId))
			{ 
				throw DomainError.Named("inconsistentEventIds", "Outer Id UserId {0} but inner id UserId {1}", 
					oe.StateEventId.UserId, e.StateEventId.UserId);
			}
		}


		protected IUserLoginStateEventDao UserLoginStateEventDao
		{
			get { return ApplicationContext.Current["UserLoginStateEventDao"] as IUserLoginStateEventDao; }
		}

        protected UserLoginStateEventId NewUserLoginStateEventId(LoginKey loginKey)
        {
            var stateEventId = new UserLoginStateEventId(this.StateEventId.UserId, loginKey, this.StateEventId.Version);
            return stateEventId;
        }


        protected void ThrowOnInconsistentEventIds(IUserLoginStateEvent e)
        {
            ThrowOnInconsistentEventIds(this, e);
        }

		public static void ThrowOnInconsistentEventIds(IUserStateEvent oe, IUserLoginStateEvent e)
		{
			if (!oe.StateEventId.UserId.Equals(e.StateEventId.UserId))
			{ 
				throw DomainError.Named("inconsistentEventIds", "Outer Id UserId {0} but inner id UserId {1}", 
					oe.StateEventId.UserId, e.StateEventId.UserId);
			}
		}



        string IStateEventDto.StateEventType
        {
            get { return this.GetStateEventType(); }
        }

        protected abstract string GetStateEventType();

	}

	public class UserStateCreated : UserStateEventBase, IUserStateCreated, ISaveable
	{
		public UserStateCreated ()
		{
		}

		public UserStateCreated (UserStateEventId stateEventId) : base(stateEventId)
		{
		}

		private Dictionary<UserRoleStateEventId, IUserRoleStateCreated> _userRoleEvents = new Dictionary<UserRoleStateEventId, IUserRoleStateCreated>();
		
        private IEnumerable<IUserRoleStateCreated> _readOnlyUserRoleEvents;

        public virtual IEnumerable<IUserRoleStateCreated> UserRoleEvents
        {
            get
            {
                if (!StateEventReadOnly)
                {
					return this._userRoleEvents.Values;
                }
                else
                {
                    if (_readOnlyUserRoleEvents != null) { return _readOnlyUserRoleEvents; }
                    var eventDao = UserRoleStateEventDao;
                    var eL = new List<IUserRoleStateCreated>();
                    foreach (var e in eventDao.FindByUserStateEventId(this.StateEventId))
                    {
                        e.ReadOnly = true;
                        eL.Add((IUserRoleStateCreated)e);
                    }
                    return (_readOnlyUserRoleEvents = eL);
                }
            }
            set 
            {
                if (value != null)
                {
                    foreach (var e in value)
                    {
                        AddUserRoleEvent(e);
                    }
                }
                else { this._userRoleEvents.Clear(); }
            }
        }
	
		public virtual void AddUserRoleEvent(IUserRoleStateCreated e)
		{
			ThrowOnInconsistentEventIds(e);
			this._userRoleEvents[e.StateEventId] = e;
		}

        public virtual IUserRoleStateCreated NewUserRoleStateCreated(string roleId)
        {
            var stateEvent = new UserRoleStateCreated(NewUserRoleStateEventId(roleId));
            return stateEvent;
        }

		private Dictionary<UserClaimStateEventId, IUserClaimStateCreated> _userClaimEvents = new Dictionary<UserClaimStateEventId, IUserClaimStateCreated>();
		
        private IEnumerable<IUserClaimStateCreated> _readOnlyUserClaimEvents;

        public virtual IEnumerable<IUserClaimStateCreated> UserClaimEvents
        {
            get
            {
                if (!StateEventReadOnly)
                {
					return this._userClaimEvents.Values;
                }
                else
                {
                    if (_readOnlyUserClaimEvents != null) { return _readOnlyUserClaimEvents; }
                    var eventDao = UserClaimStateEventDao;
                    var eL = new List<IUserClaimStateCreated>();
                    foreach (var e in eventDao.FindByUserStateEventId(this.StateEventId))
                    {
                        e.ReadOnly = true;
                        eL.Add((IUserClaimStateCreated)e);
                    }
                    return (_readOnlyUserClaimEvents = eL);
                }
            }
            set 
            {
                if (value != null)
                {
                    foreach (var e in value)
                    {
                        AddUserClaimEvent(e);
                    }
                }
                else { this._userClaimEvents.Clear(); }
            }
        }
	
		public virtual void AddUserClaimEvent(IUserClaimStateCreated e)
		{
			ThrowOnInconsistentEventIds(e);
			this._userClaimEvents[e.StateEventId] = e;
		}

        public virtual IUserClaimStateCreated NewUserClaimStateCreated(int claimId)
        {
            var stateEvent = new UserClaimStateCreated(NewUserClaimStateEventId(claimId));
            return stateEvent;
        }

		private Dictionary<UserPermissionStateEventId, IUserPermissionStateCreated> _userPermissionEvents = new Dictionary<UserPermissionStateEventId, IUserPermissionStateCreated>();
		
        private IEnumerable<IUserPermissionStateCreated> _readOnlyUserPermissionEvents;

        public virtual IEnumerable<IUserPermissionStateCreated> UserPermissionEvents
        {
            get
            {
                if (!StateEventReadOnly)
                {
					return this._userPermissionEvents.Values;
                }
                else
                {
                    if (_readOnlyUserPermissionEvents != null) { return _readOnlyUserPermissionEvents; }
                    var eventDao = UserPermissionStateEventDao;
                    var eL = new List<IUserPermissionStateCreated>();
                    foreach (var e in eventDao.FindByUserStateEventId(this.StateEventId))
                    {
                        e.ReadOnly = true;
                        eL.Add((IUserPermissionStateCreated)e);
                    }
                    return (_readOnlyUserPermissionEvents = eL);
                }
            }
            set 
            {
                if (value != null)
                {
                    foreach (var e in value)
                    {
                        AddUserPermissionEvent(e);
                    }
                }
                else { this._userPermissionEvents.Clear(); }
            }
        }
	
		public virtual void AddUserPermissionEvent(IUserPermissionStateCreated e)
		{
			ThrowOnInconsistentEventIds(e);
			this._userPermissionEvents[e.StateEventId] = e;
		}

        public virtual IUserPermissionStateCreated NewUserPermissionStateCreated(string permissionId)
        {
            var stateEvent = new UserPermissionStateCreated(NewUserPermissionStateEventId(permissionId));
            return stateEvent;
        }

		private Dictionary<UserLoginStateEventId, IUserLoginStateCreated> _userLoginEvents = new Dictionary<UserLoginStateEventId, IUserLoginStateCreated>();
		
        private IEnumerable<IUserLoginStateCreated> _readOnlyUserLoginEvents;

        public virtual IEnumerable<IUserLoginStateCreated> UserLoginEvents
        {
            get
            {
                if (!StateEventReadOnly)
                {
					return this._userLoginEvents.Values;
                }
                else
                {
                    if (_readOnlyUserLoginEvents != null) { return _readOnlyUserLoginEvents; }
                    var eventDao = UserLoginStateEventDao;
                    var eL = new List<IUserLoginStateCreated>();
                    foreach (var e in eventDao.FindByUserStateEventId(this.StateEventId))
                    {
                        e.ReadOnly = true;
                        eL.Add((IUserLoginStateCreated)e);
                    }
                    return (_readOnlyUserLoginEvents = eL);
                }
            }
            set 
            {
                if (value != null)
                {
                    foreach (var e in value)
                    {
                        AddUserLoginEvent(e);
                    }
                }
                else { this._userLoginEvents.Clear(); }
            }
        }
	
		public virtual void AddUserLoginEvent(IUserLoginStateCreated e)
		{
			ThrowOnInconsistentEventIds(e);
			this._userLoginEvents[e.StateEventId] = e;
		}

        public virtual IUserLoginStateCreated NewUserLoginStateCreated(LoginKey loginKey)
        {
            var stateEvent = new UserLoginStateCreated(NewUserLoginStateEventId(loginKey));
            return stateEvent;
        }

		public virtual void Save ()
		{
			foreach (IUserRoleStateCreated e in this.UserRoleEvents) {
				UserRoleStateEventDao.Save(e);
			}
			foreach (IUserClaimStateCreated e in this.UserClaimEvents) {
				UserClaimStateEventDao.Save(e);
			}
			foreach (IUserPermissionStateCreated e in this.UserPermissionEvents) {
				UserPermissionStateEventDao.Save(e);
			}
			foreach (IUserLoginStateCreated e in this.UserLoginEvents) {
				UserLoginStateEventDao.Save(e);
			}
		}

        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Created;
        }

	}


	public class UserStateMergePatched : UserStateEventBase, IUserStateMergePatched, ISaveable
	{
		public virtual bool IsPropertyUserNameRemoved { get; set; }

		public virtual bool IsPropertyAccessFailedCountRemoved { get; set; }

		public virtual bool IsPropertyEmailRemoved { get; set; }

		public virtual bool IsPropertyEmailConfirmedRemoved { get; set; }

		public virtual bool IsPropertyLockoutEnabledRemoved { get; set; }

		public virtual bool IsPropertyLockoutEndDateUtcRemoved { get; set; }

		public virtual bool IsPropertyPasswordHashRemoved { get; set; }

		public virtual bool IsPropertyPhoneNumberRemoved { get; set; }

		public virtual bool IsPropertyPhoneNumberConfirmedRemoved { get; set; }

		public virtual bool IsPropertyTwoFactorEnabledRemoved { get; set; }

		public virtual bool IsPropertySecurityStampRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }


		public UserStateMergePatched ()
		{
		}

		public UserStateMergePatched (UserStateEventId stateEventId) : base(stateEventId)
		{
		}

		private Dictionary<UserRoleStateEventId, IUserRoleStateEvent> _userRoleEvents = new Dictionary<UserRoleStateEventId, IUserRoleStateEvent>();

	    private IEnumerable<IUserRoleStateEvent> _readOnlyUserRoleEvents;
		
        public virtual IEnumerable<IUserRoleStateEvent> UserRoleEvents
        {
            get
            {
                if (!StateEventReadOnly)
                {
					return this._userRoleEvents.Values;
                }
                else
                {
                    if (_readOnlyUserRoleEvents != null) { return _readOnlyUserRoleEvents; }
                    var eventDao = UserRoleStateEventDao;
                    var eL = new List<IUserRoleStateEvent>();
                    foreach (var e in eventDao.FindByUserStateEventId(this.StateEventId))
                    {
                        e.ReadOnly = true;
                        eL.Add((IUserRoleStateEvent)e);
                    }
                    return (_readOnlyUserRoleEvents = eL);
                }
            }
            set 
            {
                if (value != null)
                {
                    foreach (var e in value)
                    {
                        AddUserRoleEvent(e);
                    }
                }
                else { this._userRoleEvents.Clear(); }
            }
        }

		public virtual void AddUserRoleEvent(IUserRoleStateEvent e)
		{
			ThrowOnInconsistentEventIds(e);
			this._userRoleEvents[e.StateEventId] = e;
		}

        public virtual IUserRoleStateCreated NewUserRoleStateCreated(string roleId)
        {
            var stateEvent = new UserRoleStateCreated(NewUserRoleStateEventId(roleId));
            return stateEvent;
        }

        public virtual IUserRoleStateMergePatched NewUserRoleStateMergePatched(string roleId)
        {
            var stateEvent = new UserRoleStateMergePatched(NewUserRoleStateEventId(roleId));
            return stateEvent;
        }

        public virtual IUserRoleStateRemoved NewUserRoleStateRemoved(string roleId)
        {
            var stateEvent = new UserRoleStateRemoved(NewUserRoleStateEventId(roleId));
            return stateEvent;
        }

		private Dictionary<UserClaimStateEventId, IUserClaimStateEvent> _userClaimEvents = new Dictionary<UserClaimStateEventId, IUserClaimStateEvent>();

	    private IEnumerable<IUserClaimStateEvent> _readOnlyUserClaimEvents;
		
        public virtual IEnumerable<IUserClaimStateEvent> UserClaimEvents
        {
            get
            {
                if (!StateEventReadOnly)
                {
					return this._userClaimEvents.Values;
                }
                else
                {
                    if (_readOnlyUserClaimEvents != null) { return _readOnlyUserClaimEvents; }
                    var eventDao = UserClaimStateEventDao;
                    var eL = new List<IUserClaimStateEvent>();
                    foreach (var e in eventDao.FindByUserStateEventId(this.StateEventId))
                    {
                        e.ReadOnly = true;
                        eL.Add((IUserClaimStateEvent)e);
                    }
                    return (_readOnlyUserClaimEvents = eL);
                }
            }
            set 
            {
                if (value != null)
                {
                    foreach (var e in value)
                    {
                        AddUserClaimEvent(e);
                    }
                }
                else { this._userClaimEvents.Clear(); }
            }
        }

		public virtual void AddUserClaimEvent(IUserClaimStateEvent e)
		{
			ThrowOnInconsistentEventIds(e);
			this._userClaimEvents[e.StateEventId] = e;
		}

        public virtual IUserClaimStateCreated NewUserClaimStateCreated(int claimId)
        {
            var stateEvent = new UserClaimStateCreated(NewUserClaimStateEventId(claimId));
            return stateEvent;
        }

        public virtual IUserClaimStateMergePatched NewUserClaimStateMergePatched(int claimId)
        {
            var stateEvent = new UserClaimStateMergePatched(NewUserClaimStateEventId(claimId));
            return stateEvent;
        }

        public virtual IUserClaimStateRemoved NewUserClaimStateRemoved(int claimId)
        {
            var stateEvent = new UserClaimStateRemoved(NewUserClaimStateEventId(claimId));
            return stateEvent;
        }

		private Dictionary<UserPermissionStateEventId, IUserPermissionStateEvent> _userPermissionEvents = new Dictionary<UserPermissionStateEventId, IUserPermissionStateEvent>();

	    private IEnumerable<IUserPermissionStateEvent> _readOnlyUserPermissionEvents;
		
        public virtual IEnumerable<IUserPermissionStateEvent> UserPermissionEvents
        {
            get
            {
                if (!StateEventReadOnly)
                {
					return this._userPermissionEvents.Values;
                }
                else
                {
                    if (_readOnlyUserPermissionEvents != null) { return _readOnlyUserPermissionEvents; }
                    var eventDao = UserPermissionStateEventDao;
                    var eL = new List<IUserPermissionStateEvent>();
                    foreach (var e in eventDao.FindByUserStateEventId(this.StateEventId))
                    {
                        e.ReadOnly = true;
                        eL.Add((IUserPermissionStateEvent)e);
                    }
                    return (_readOnlyUserPermissionEvents = eL);
                }
            }
            set 
            {
                if (value != null)
                {
                    foreach (var e in value)
                    {
                        AddUserPermissionEvent(e);
                    }
                }
                else { this._userPermissionEvents.Clear(); }
            }
        }

		public virtual void AddUserPermissionEvent(IUserPermissionStateEvent e)
		{
			ThrowOnInconsistentEventIds(e);
			this._userPermissionEvents[e.StateEventId] = e;
		}

        public virtual IUserPermissionStateCreated NewUserPermissionStateCreated(string permissionId)
        {
            var stateEvent = new UserPermissionStateCreated(NewUserPermissionStateEventId(permissionId));
            return stateEvent;
        }

        public virtual IUserPermissionStateMergePatched NewUserPermissionStateMergePatched(string permissionId)
        {
            var stateEvent = new UserPermissionStateMergePatched(NewUserPermissionStateEventId(permissionId));
            return stateEvent;
        }

        public virtual IUserPermissionStateRemoved NewUserPermissionStateRemoved(string permissionId)
        {
            var stateEvent = new UserPermissionStateRemoved(NewUserPermissionStateEventId(permissionId));
            return stateEvent;
        }

		private Dictionary<UserLoginStateEventId, IUserLoginStateEvent> _userLoginEvents = new Dictionary<UserLoginStateEventId, IUserLoginStateEvent>();

	    private IEnumerable<IUserLoginStateEvent> _readOnlyUserLoginEvents;
		
        public virtual IEnumerable<IUserLoginStateEvent> UserLoginEvents
        {
            get
            {
                if (!StateEventReadOnly)
                {
					return this._userLoginEvents.Values;
                }
                else
                {
                    if (_readOnlyUserLoginEvents != null) { return _readOnlyUserLoginEvents; }
                    var eventDao = UserLoginStateEventDao;
                    var eL = new List<IUserLoginStateEvent>();
                    foreach (var e in eventDao.FindByUserStateEventId(this.StateEventId))
                    {
                        e.ReadOnly = true;
                        eL.Add((IUserLoginStateEvent)e);
                    }
                    return (_readOnlyUserLoginEvents = eL);
                }
            }
            set 
            {
                if (value != null)
                {
                    foreach (var e in value)
                    {
                        AddUserLoginEvent(e);
                    }
                }
                else { this._userLoginEvents.Clear(); }
            }
        }

		public virtual void AddUserLoginEvent(IUserLoginStateEvent e)
		{
			ThrowOnInconsistentEventIds(e);
			this._userLoginEvents[e.StateEventId] = e;
		}

        public virtual IUserLoginStateCreated NewUserLoginStateCreated(LoginKey loginKey)
        {
            var stateEvent = new UserLoginStateCreated(NewUserLoginStateEventId(loginKey));
            return stateEvent;
        }

        public virtual IUserLoginStateMergePatched NewUserLoginStateMergePatched(LoginKey loginKey)
        {
            var stateEvent = new UserLoginStateMergePatched(NewUserLoginStateEventId(loginKey));
            return stateEvent;
        }

        public virtual IUserLoginStateRemoved NewUserLoginStateRemoved(LoginKey loginKey)
        {
            var stateEvent = new UserLoginStateRemoved(NewUserLoginStateEventId(loginKey));
            return stateEvent;
        }

		public virtual void Save ()
		{
			foreach (IUserRoleStateEvent e in this.UserRoleEvents) {
				UserRoleStateEventDao.Save(e);
			}
			foreach (IUserClaimStateEvent e in this.UserClaimEvents) {
				UserClaimStateEventDao.Save(e);
			}
			foreach (IUserPermissionStateEvent e in this.UserPermissionEvents) {
				UserPermissionStateEventDao.Save(e);
			}
			foreach (IUserLoginStateEvent e in this.UserLoginEvents) {
				UserLoginStateEventDao.Save(e);
			}
		}

        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.MergePatched;
        }

	}


	public class UserStateDeleted : UserStateEventBase, IUserStateDeleted, ISaveable
	{
		public UserStateDeleted ()
		{
		}

		public UserStateDeleted (UserStateEventId stateEventId) : base(stateEventId)
		{
		}

        protected override string GetStateEventType()
        {
            return Dddml.Wms.Specialization.StateEventType.Deleted;
        }

		private Dictionary<UserRoleStateEventId, IUserRoleStateRemoved> _userRoleEvents = new Dictionary<UserRoleStateEventId, IUserRoleStateRemoved>();
		
        private IEnumerable<IUserRoleStateRemoved> _readOnlyUserRoleEvents;

        public virtual IEnumerable<IUserRoleStateRemoved> UserRoleEvents
        {
            get
            {
                if (!StateEventReadOnly)
                {
					return this._userRoleEvents.Values;
                }
                else
                {
                    if (_readOnlyUserRoleEvents != null) { return _readOnlyUserRoleEvents; }
                    var eventDao = UserRoleStateEventDao;
                    var eL = new List<IUserRoleStateRemoved>();
                    foreach (var e in eventDao.FindByUserStateEventId(this.StateEventId))
                    {
                        e.ReadOnly = true;
                        eL.Add((IUserRoleStateRemoved)e);
                    }
                    return (_readOnlyUserRoleEvents = eL);
                }
            }
            set 
            {
                if (value != null)
                {
                    foreach (var e in value)
                    {
                        AddUserRoleEvent(e);
                    }
                }
                else { this._userRoleEvents.Clear(); }
            }
        }
	
		public virtual void AddUserRoleEvent(IUserRoleStateRemoved e)
		{
			ThrowOnInconsistentEventIds(e);
			this._userRoleEvents[e.StateEventId] = e;
		}

        public virtual IUserRoleStateRemoved NewUserRoleStateRemoved(string roleId)
        {
            var stateEvent = new UserRoleStateRemoved(NewUserRoleStateEventId(roleId));
            return stateEvent;
        }

		private Dictionary<UserClaimStateEventId, IUserClaimStateRemoved> _userClaimEvents = new Dictionary<UserClaimStateEventId, IUserClaimStateRemoved>();
		
        private IEnumerable<IUserClaimStateRemoved> _readOnlyUserClaimEvents;

        public virtual IEnumerable<IUserClaimStateRemoved> UserClaimEvents
        {
            get
            {
                if (!StateEventReadOnly)
                {
					return this._userClaimEvents.Values;
                }
                else
                {
                    if (_readOnlyUserClaimEvents != null) { return _readOnlyUserClaimEvents; }
                    var eventDao = UserClaimStateEventDao;
                    var eL = new List<IUserClaimStateRemoved>();
                    foreach (var e in eventDao.FindByUserStateEventId(this.StateEventId))
                    {
                        e.ReadOnly = true;
                        eL.Add((IUserClaimStateRemoved)e);
                    }
                    return (_readOnlyUserClaimEvents = eL);
                }
            }
            set 
            {
                if (value != null)
                {
                    foreach (var e in value)
                    {
                        AddUserClaimEvent(e);
                    }
                }
                else { this._userClaimEvents.Clear(); }
            }
        }
	
		public virtual void AddUserClaimEvent(IUserClaimStateRemoved e)
		{
			ThrowOnInconsistentEventIds(e);
			this._userClaimEvents[e.StateEventId] = e;
		}

        public virtual IUserClaimStateRemoved NewUserClaimStateRemoved(int claimId)
        {
            var stateEvent = new UserClaimStateRemoved(NewUserClaimStateEventId(claimId));
            return stateEvent;
        }

		private Dictionary<UserPermissionStateEventId, IUserPermissionStateRemoved> _userPermissionEvents = new Dictionary<UserPermissionStateEventId, IUserPermissionStateRemoved>();
		
        private IEnumerable<IUserPermissionStateRemoved> _readOnlyUserPermissionEvents;

        public virtual IEnumerable<IUserPermissionStateRemoved> UserPermissionEvents
        {
            get
            {
                if (!StateEventReadOnly)
                {
					return this._userPermissionEvents.Values;
                }
                else
                {
                    if (_readOnlyUserPermissionEvents != null) { return _readOnlyUserPermissionEvents; }
                    var eventDao = UserPermissionStateEventDao;
                    var eL = new List<IUserPermissionStateRemoved>();
                    foreach (var e in eventDao.FindByUserStateEventId(this.StateEventId))
                    {
                        e.ReadOnly = true;
                        eL.Add((IUserPermissionStateRemoved)e);
                    }
                    return (_readOnlyUserPermissionEvents = eL);
                }
            }
            set 
            {
                if (value != null)
                {
                    foreach (var e in value)
                    {
                        AddUserPermissionEvent(e);
                    }
                }
                else { this._userPermissionEvents.Clear(); }
            }
        }
	
		public virtual void AddUserPermissionEvent(IUserPermissionStateRemoved e)
		{
			ThrowOnInconsistentEventIds(e);
			this._userPermissionEvents[e.StateEventId] = e;
		}

        public virtual IUserPermissionStateRemoved NewUserPermissionStateRemoved(string permissionId)
        {
            var stateEvent = new UserPermissionStateRemoved(NewUserPermissionStateEventId(permissionId));
            return stateEvent;
        }

		private Dictionary<UserLoginStateEventId, IUserLoginStateRemoved> _userLoginEvents = new Dictionary<UserLoginStateEventId, IUserLoginStateRemoved>();
		
        private IEnumerable<IUserLoginStateRemoved> _readOnlyUserLoginEvents;

        public virtual IEnumerable<IUserLoginStateRemoved> UserLoginEvents
        {
            get
            {
                if (!StateEventReadOnly)
                {
					return this._userLoginEvents.Values;
                }
                else
                {
                    if (_readOnlyUserLoginEvents != null) { return _readOnlyUserLoginEvents; }
                    var eventDao = UserLoginStateEventDao;
                    var eL = new List<IUserLoginStateRemoved>();
                    foreach (var e in eventDao.FindByUserStateEventId(this.StateEventId))
                    {
                        e.ReadOnly = true;
                        eL.Add((IUserLoginStateRemoved)e);
                    }
                    return (_readOnlyUserLoginEvents = eL);
                }
            }
            set 
            {
                if (value != null)
                {
                    foreach (var e in value)
                    {
                        AddUserLoginEvent(e);
                    }
                }
                else { this._userLoginEvents.Clear(); }
            }
        }
	
		public virtual void AddUserLoginEvent(IUserLoginStateRemoved e)
		{
			ThrowOnInconsistentEventIds(e);
			this._userLoginEvents[e.StateEventId] = e;
		}

        public virtual IUserLoginStateRemoved NewUserLoginStateRemoved(LoginKey loginKey)
        {
            var stateEvent = new UserLoginStateRemoved(NewUserLoginStateEventId(loginKey));
            return stateEvent;
        }

		public virtual void Save ()
		{
			foreach (IUserRoleStateRemoved e in this.UserRoleEvents) {
				UserRoleStateEventDao.Save(e);
			}
			foreach (IUserClaimStateRemoved e in this.UserClaimEvents) {
				UserClaimStateEventDao.Save(e);
			}
			foreach (IUserPermissionStateRemoved e in this.UserPermissionEvents) {
				UserPermissionStateEventDao.Save(e);
			}
			foreach (IUserLoginStateRemoved e in this.UserLoginEvents) {
				UserLoginStateEventDao.Save(e);
			}
		}


	}



}

