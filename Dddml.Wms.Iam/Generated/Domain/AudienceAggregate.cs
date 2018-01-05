﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Audience;

namespace Dddml.Wms.Domain.Audience
{
    public partial class AudienceAggregate : AggregateBase, IAudienceAggregate
    {

        readonly IAudienceState _state;

        readonly IList<IEvent> _changes = new List<IEvent>();

        public IAudienceState State
        {
            get
            {
                return _state;
            }
        }

        public IList<IEvent> Changes
        {
            get
            {
                return _changes;
            }
        }

        #region IIdentity implementation

        string IGlobalIdentity<string>.GlobalId
        {
            get
            {
                return this._state.GlobalId;
            }
        }

        #endregion


        public AudienceAggregate(IAudienceState state)
        {
            _state = state;
        }


        public virtual void ThrowOnInvalidStateTransition(ICommand c)
        {
            if (((IAudienceStateProperties)_state).Version == AudienceState.VersionZero)
            {
                if (IsCommandCreate((IAudienceCommand)c))
                {
                    return;
                }
                throw DomainError.Named("premature", "Can't do anything to unexistent aggregate");
            }
            if (_state.Deleted)
            {
                throw DomainError.Named("zombie", "Can't do anything to deleted aggregate.");
            }
            if (IsCommandCreate((IAudienceCommand)c))
                throw DomainError.Named("rebirth", "Can't create aggregate that already exists");
        }

        private static bool IsCommandCreate(IAudienceCommand c)
        {
            return c.Version == AudienceState.VersionZero;
        }

        protected internal virtual void Apply(IEvent e)
        {
            OnApplying(e);
            _state.Mutate(e);
            _changes.Add(e);
        }

        public virtual void Create(ICreateAudience c)
        {
            IAudienceStateCreated e = Map(c);
            Apply(e);
        }

        public virtual void MergePatch(IMergePatchAudience c)
        {
            IAudienceStateMergePatched e = Map(c);
            Apply(e);
        }

        public virtual void Delete(IDeleteAudience c)
        {
            IAudienceStateDeleted e = Map(c);
            Apply(e);
        }


        protected virtual IAudienceStateCreated Map(ICreateAudience c)
        {
			var stateEventId = new AudienceStateEventId(c.ClientId, c.Version);
            IAudienceStateCreated e = NewAudienceStateCreated(stateEventId);
		
            e.Name = c.Name;
            e.Base64Secret = c.Base64Secret;
            e.Active = c.Active;
            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();
			var version = c.Version;


            return e;
        }

        protected virtual IAudienceStateMergePatched Map(IMergePatchAudience c)
        {
			var stateEventId = new AudienceStateEventId(c.ClientId, c.Version);
            IAudienceStateMergePatched e = NewAudienceStateMergePatched(stateEventId);

            e.Name = c.Name;
            e.Base64Secret = c.Base64Secret;
            e.Active = c.Active;
            e.IsPropertyNameRemoved = c.IsPropertyNameRemoved;
            e.IsPropertyBase64SecretRemoved = c.IsPropertyBase64SecretRemoved;
            e.IsPropertyActiveRemoved = c.IsPropertyActiveRemoved;

            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

			var version = c.Version;


            return e;
        }

        protected virtual IAudienceStateDeleted Map(IDeleteAudience c)
        {
			var stateEventId = new AudienceStateEventId(c.ClientId, c.Version);
            IAudienceStateDeleted e = NewAudienceStateDeleted(stateEventId);
			
            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();


            return e;
        }

        private void ThrowOnInconsistentIds(object innerObject, string innerIdName, object innerIdValue, string outerIdName, object outerIdValue)
        {
            if (!Object.Equals(innerIdValue, outerIdValue))
            {
                if (innerIdValue is string && outerIdValue is string && ((string)innerIdValue).Normalize() == ((string)outerIdValue).Normalize())
                {
                    return;
                }
                throw DomainError.Named("inconsistentId", "Outer {0} {1} NOT equals inner {2} {3}", outerIdName, outerIdValue, innerIdName, innerIdValue);
            }
        }

////////////////////////

        protected AudienceStateCreated NewAudienceStateCreated(string commandId, string requesterId)
        {
            var stateEventId = new AudienceStateEventId(_state.ClientId, ((IAudienceStateProperties)_state).Version);
            var e = NewAudienceStateCreated(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }

        protected AudienceStateMergePatched NewAudienceStateMergePatched(string commandId, string requesterId)
        {
            var stateEventId = new AudienceStateEventId(_state.ClientId, ((IAudienceStateProperties)_state).Version);
            var e = NewAudienceStateMergePatched(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }


        protected AudienceStateDeleted NewAudienceStateDeleted(string commandId, string requesterId)
        {
            var stateEventId = new AudienceStateEventId(_state.ClientId, ((IAudienceStateProperties)_state).Version);
            var e = NewAudienceStateDeleted(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }

////////////////////////

		private AudienceStateCreated NewAudienceStateCreated(AudienceStateEventId stateEventId)
		{
			return new AudienceStateCreated(stateEventId);			
		}

        private AudienceStateMergePatched NewAudienceStateMergePatched(AudienceStateEventId stateEventId)
		{
			return new AudienceStateMergePatched(stateEventId);
		}

        private AudienceStateDeleted NewAudienceStateDeleted(AudienceStateEventId stateEventId)
		{
			return new AudienceStateDeleted(stateEventId);
		}
    }

}

