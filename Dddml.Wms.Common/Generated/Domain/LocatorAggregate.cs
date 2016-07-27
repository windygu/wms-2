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
    public partial class LocatorAggregate : AggregateBase, ILocatorAggregate
    {

        readonly ILocatorState _state;

        readonly IList<IEvent> _changes = new List<IEvent>();

        public ILocatorState State
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


        public LocatorAggregate(ILocatorState state)
        {
            _state = state;
        }


        public virtual void ThrowOnInvalidStateTransition(ICommand c)
        {
            if (((ILocatorStateProperties)_state).Version == LocatorState.VersionZero)
            {
                if (IsCommandCreate((ILocatorCommand)c))
                {
                    return;
                }
                throw DomainError.Named("premature", "Can't do anything to unexistent aggregate");
            }
            if (_state.Deleted)
            {
                throw DomainError.Named("zombie", "Can't do anything to deleted aggregate.");
            }
            if (IsCommandCreate((ILocatorCommand)c))
                throw DomainError.Named("rebirth", "Can't create aggregate that already exists");
        }

        private static bool IsCommandCreate(ILocatorCommand c)
        {
            return c.Version == LocatorState.VersionZero;
        }

        protected virtual void Apply(IEvent e)
        {
            OnApplying(e);
            _state.Mutate(e);
            _changes.Add(e);
        }

        public virtual void Create(ICreateLocator c)
        {
            ILocatorStateCreated e = Map(c);
            Apply(e);
        }

        public virtual void MergePatch(IMergePatchLocator c)
        {
            ILocatorStateMergePatched e = Map(c);
            Apply(e);
        }

        public virtual void Delete(IDeleteLocator c)
        {
            ILocatorStateDeleted e = Map(c);
            Apply(e);
        }


        protected virtual ILocatorStateCreated Map(ICreateLocator c)
        {
			var stateEventId = new LocatorStateEventId(c.LocatorId, c.Version);
            ILocatorStateCreated e = NewLocatorStateCreated(stateEventId);
		
            e.WarehouseId = c.WarehouseId;
            e.ParentLocatorId = c.ParentLocatorId;
            e.LocatorType = c.LocatorType;
            e.PriorityNumber = c.PriorityNumber;
            e.IsDefault = c.IsDefault;
            e.X = c.X;
            e.Y = c.Y;
            e.Z = c.Z;
            e.Active = c.Active;
            ReflectUtils.CopyPropertyValue("CommandId", c, e);


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = DateTime.Now;
			var version = c.Version;


            return e;
        }

        protected virtual ILocatorStateMergePatched Map(IMergePatchLocator c)
        {
			var stateEventId = new LocatorStateEventId(c.LocatorId, c.Version);
            ILocatorStateMergePatched e = NewLocatorStateMergePatched(stateEventId);

            e.WarehouseId = c.WarehouseId;
            e.ParentLocatorId = c.ParentLocatorId;
            e.LocatorType = c.LocatorType;
            e.PriorityNumber = c.PriorityNumber;
            e.IsDefault = c.IsDefault;
            e.X = c.X;
            e.Y = c.Y;
            e.Z = c.Z;
            e.Active = c.Active;
            e.IsPropertyWarehouseIdRemoved = c.IsPropertyWarehouseIdRemoved;
            e.IsPropertyParentLocatorIdRemoved = c.IsPropertyParentLocatorIdRemoved;
            e.IsPropertyLocatorTypeRemoved = c.IsPropertyLocatorTypeRemoved;
            e.IsPropertyPriorityNumberRemoved = c.IsPropertyPriorityNumberRemoved;
            e.IsPropertyIsDefaultRemoved = c.IsPropertyIsDefaultRemoved;
            e.IsPropertyXRemoved = c.IsPropertyXRemoved;
            e.IsPropertyYRemoved = c.IsPropertyYRemoved;
            e.IsPropertyZRemoved = c.IsPropertyZRemoved;
            e.IsPropertyActiveRemoved = c.IsPropertyActiveRemoved;

            ReflectUtils.CopyPropertyValue("CommandId", c, e);


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = DateTime.Now;

			var version = c.Version;


            return e;
        }

        protected virtual ILocatorStateDeleted Map(IDeleteLocator c)
        {
			var stateEventId = new LocatorStateEventId(c.LocatorId, c.Version);
            ILocatorStateDeleted e = NewLocatorStateDeleted(stateEventId);
			
            ReflectUtils.CopyPropertyValue("CommandId", c, e);


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = DateTime.Now;


            return e;
        }

        private void SetNullInnerIdOrThrowOnInconsistentIds(object innerObject, string innerIdName, object innerIdValue, string outerIdName, object outerIdValue)
        {
            if (innerIdValue == null)
            {
                ReflectUtils.SetPropertyValue(innerIdName, innerObject, outerIdValue);
            }
            else if (!Object.Equals(innerIdValue, outerIdValue))
            {
                if (innerIdValue is string && outerIdValue is string && ((string)innerIdValue).Normalize() == ((string)outerIdValue).Normalize())
                {
                    return;
                }
                throw DomainError.Named("inconsistentId", "Outer {0} {1} NOT equals inner {2} {3}", outerIdName, outerIdValue, innerIdName, innerIdValue);
            }
        }

////////////////////////

        protected LocatorStateCreated NewLocatorStateCreated(string commandId, string requesterId)
        {
            var stateEventId = new LocatorStateEventId(_state.LocatorId, ((ILocatorStateProperties)_state).Version);
            var e = NewLocatorStateCreated(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = DateTime.Now;

            return e;
        }

        protected LocatorStateMergePatched NewLocatorStateMergePatched(string commandId, string requesterId)
        {
            var stateEventId = new LocatorStateEventId(_state.LocatorId, ((ILocatorStateProperties)_state).Version);
            var e = NewLocatorStateMergePatched(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = DateTime.Now;

            return e;
        }


        protected LocatorStateDeleted NewLocatorStateDeleted(string commandId, string requesterId)
        {
            var stateEventId = new LocatorStateEventId(_state.LocatorId, ((ILocatorStateProperties)_state).Version);
            var e = NewLocatorStateDeleted(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = DateTime.Now;

            return e;
        }

////////////////////////

		private LocatorStateCreated NewLocatorStateCreated(LocatorStateEventId stateEventId)
		{
			return new LocatorStateCreated(stateEventId);			
		}

        private LocatorStateMergePatched NewLocatorStateMergePatched(LocatorStateEventId stateEventId)
		{
			return new LocatorStateMergePatched(stateEventId);
		}

        private LocatorStateDeleted NewLocatorStateDeleted(LocatorStateEventId stateEventId)
		{
			return new LocatorStateDeleted(stateEventId);
		}


    }

}

