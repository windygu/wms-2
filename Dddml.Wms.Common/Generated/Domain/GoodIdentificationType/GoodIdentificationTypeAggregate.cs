﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateGoodIdentificationTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.GoodIdentificationType;

namespace Dddml.Wms.Domain.GoodIdentificationType
{
    public partial class GoodIdentificationTypeAggregate : AggregateBase, IGoodIdentificationTypeAggregate
    {

        readonly IGoodIdentificationTypeState _state;

        readonly IList<IEvent> _changes = new List<IEvent>();

        public IGoodIdentificationTypeState State
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


        public GoodIdentificationTypeAggregate(IGoodIdentificationTypeState state)
        {
            _state = state;
        }


        public virtual void ThrowOnInvalidStateTransition(ICommand c)
        {
            if (((IGoodIdentificationTypeStateProperties)_state).Version == GoodIdentificationTypeState.VersionZero)
            {
                if (IsCommandCreate((IGoodIdentificationTypeCommand)c))
                {
                    return;
                }
                throw DomainError.Named("premature", "Can't do anything to unexistent aggregate");
            }
            if (_state.Deleted)
            {
                throw DomainError.Named("zombie", "Can't do anything to deleted aggregate.");
            }
            if (IsCommandCreate((IGoodIdentificationTypeCommand)c))
                throw DomainError.Named("rebirth", "Can't create aggregate that already exists");
        }

        private static bool IsCommandCreate(IGoodIdentificationTypeCommand c)
        {
            return c.Version == GoodIdentificationTypeState.VersionZero;
        }

        protected internal virtual void Apply(IEvent e)
        {
            OnApplying(e);
            _state.Mutate(e);
            _changes.Add(e);
        }

        public virtual void Create(ICreateGoodIdentificationType c)
        {
            IGoodIdentificationTypeStateCreated e = Map(c);
            Apply(e);
        }

        public virtual void MergePatch(IMergePatchGoodIdentificationType c)
        {
            IGoodIdentificationTypeStateMergePatched e = Map(c);
            Apply(e);
        }

        public virtual void Delete(IDeleteGoodIdentificationType c)
        {
            IGoodIdentificationTypeStateDeleted e = Map(c);
            Apply(e);
        }


        protected virtual IGoodIdentificationTypeStateCreated Map(ICreateGoodIdentificationType c)
        {
			var stateEventId = new GoodIdentificationTypeEventId(c.GoodIdentificationTypeId, c.Version);
            IGoodIdentificationTypeStateCreated e = NewGoodIdentificationTypeStateCreated(stateEventId);
		
            e.ParentTypeId = c.ParentTypeId;
            e.HasTable = c.HasTable;
            e.Description = c.Description;
            e.Active = c.Active;
            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();
			var version = c.Version;


            return e;
        }

        protected virtual IGoodIdentificationTypeStateMergePatched Map(IMergePatchGoodIdentificationType c)
        {
			var stateEventId = new GoodIdentificationTypeEventId(c.GoodIdentificationTypeId, c.Version);
            IGoodIdentificationTypeStateMergePatched e = NewGoodIdentificationTypeStateMergePatched(stateEventId);

            e.ParentTypeId = c.ParentTypeId;
            e.HasTable = c.HasTable;
            e.Description = c.Description;
            e.Active = c.Active;
            e.IsPropertyParentTypeIdRemoved = c.IsPropertyParentTypeIdRemoved;
            e.IsPropertyHasTableRemoved = c.IsPropertyHasTableRemoved;
            e.IsPropertyDescriptionRemoved = c.IsPropertyDescriptionRemoved;
            e.IsPropertyActiveRemoved = c.IsPropertyActiveRemoved;

            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

			var version = c.Version;


            return e;
        }

        protected virtual IGoodIdentificationTypeStateDeleted Map(IDeleteGoodIdentificationType c)
        {
			var stateEventId = new GoodIdentificationTypeEventId(c.GoodIdentificationTypeId, c.Version);
            IGoodIdentificationTypeStateDeleted e = NewGoodIdentificationTypeStateDeleted(stateEventId);
			
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

        protected GoodIdentificationTypeStateCreated NewGoodIdentificationTypeStateCreated(long version, string commandId, string requesterId)
        {
            var stateEventId = new GoodIdentificationTypeEventId(_state.GoodIdentificationTypeId, version);
            var e = NewGoodIdentificationTypeStateCreated(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }

        protected GoodIdentificationTypeStateMergePatched NewGoodIdentificationTypeStateMergePatched(long version, string commandId, string requesterId)
        {
            var stateEventId = new GoodIdentificationTypeEventId(_state.GoodIdentificationTypeId, version);
            var e = NewGoodIdentificationTypeStateMergePatched(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }


        protected GoodIdentificationTypeStateDeleted NewGoodIdentificationTypeStateDeleted(long version, string commandId, string requesterId)
        {
            var stateEventId = new GoodIdentificationTypeEventId(_state.GoodIdentificationTypeId, version);
            var e = NewGoodIdentificationTypeStateDeleted(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }

////////////////////////

		private GoodIdentificationTypeStateCreated NewGoodIdentificationTypeStateCreated(GoodIdentificationTypeEventId stateEventId)
		{
			return new GoodIdentificationTypeStateCreated(stateEventId);			
		}

        private GoodIdentificationTypeStateMergePatched NewGoodIdentificationTypeStateMergePatched(GoodIdentificationTypeEventId stateEventId)
		{
			return new GoodIdentificationTypeStateMergePatched(stateEventId);
		}

        private GoodIdentificationTypeStateDeleted NewGoodIdentificationTypeStateDeleted(GoodIdentificationTypeEventId stateEventId)
		{
			return new GoodIdentificationTypeStateDeleted(stateEventId);
		}
    }

}

