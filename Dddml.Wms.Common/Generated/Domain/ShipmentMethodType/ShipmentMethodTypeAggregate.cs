﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateShipmentMethodTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ShipmentMethodType;

namespace Dddml.Wms.Domain.ShipmentMethodType
{
    public partial class ShipmentMethodTypeAggregate : AggregateBase, IShipmentMethodTypeAggregate
    {

        readonly IShipmentMethodTypeState _state;

        readonly IList<IEvent> _changes = new List<IEvent>();

        public IShipmentMethodTypeState State
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


        public ShipmentMethodTypeAggregate(IShipmentMethodTypeState state)
        {
            _state = state;
        }


        public virtual void ThrowOnInvalidStateTransition(ICommand c)
        {
            if (((IShipmentMethodTypeStateProperties)_state).Version == ShipmentMethodTypeState.VersionZero)
            {
                if (IsCommandCreate((IShipmentMethodTypeCommand)c))
                {
                    return;
                }
                throw DomainError.Named("premature", "Can't do anything to unexistent aggregate");
            }
            if (_state.Deleted)
            {
                throw DomainError.Named("zombie", "Can't do anything to deleted aggregate.");
            }
            if (IsCommandCreate((IShipmentMethodTypeCommand)c))
                throw DomainError.Named("rebirth", "Can't create aggregate that already exists");
        }

        private static bool IsCommandCreate(IShipmentMethodTypeCommand c)
        {
            return c.Version == ShipmentMethodTypeState.VersionZero;
        }

        protected internal virtual void Apply(IEvent e)
        {
            OnApplying(e);
            _state.Mutate(e);
            _changes.Add(e);
        }

        public virtual void Create(ICreateShipmentMethodType c)
        {
            IShipmentMethodTypeStateCreated e = Map(c);
            Apply(e);
        }

        public virtual void MergePatch(IMergePatchShipmentMethodType c)
        {
            IShipmentMethodTypeStateMergePatched e = Map(c);
            Apply(e);
        }

        public virtual void Delete(IDeleteShipmentMethodType c)
        {
            IShipmentMethodTypeStateDeleted e = Map(c);
            Apply(e);
        }


        protected virtual IShipmentMethodTypeStateCreated Map(ICreateShipmentMethodType c)
        {
			var stateEventId = new ShipmentMethodTypeEventId(c.ShipmentMethodTypeId, c.Version);
            IShipmentMethodTypeStateCreated e = NewShipmentMethodTypeStateCreated(stateEventId);
		
            e.Description = c.Description;
            e.SequenceNum = c.SequenceNum;
            e.Active = c.Active;
            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();
			var version = c.Version;


            return e;
        }

        protected virtual IShipmentMethodTypeStateMergePatched Map(IMergePatchShipmentMethodType c)
        {
			var stateEventId = new ShipmentMethodTypeEventId(c.ShipmentMethodTypeId, c.Version);
            IShipmentMethodTypeStateMergePatched e = NewShipmentMethodTypeStateMergePatched(stateEventId);

            e.Description = c.Description;
            e.SequenceNum = c.SequenceNum;
            e.Active = c.Active;
            e.IsPropertyDescriptionRemoved = c.IsPropertyDescriptionRemoved;
            e.IsPropertySequenceNumRemoved = c.IsPropertySequenceNumRemoved;
            e.IsPropertyActiveRemoved = c.IsPropertyActiveRemoved;

            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

			var version = c.Version;


            return e;
        }

        protected virtual IShipmentMethodTypeStateDeleted Map(IDeleteShipmentMethodType c)
        {
			var stateEventId = new ShipmentMethodTypeEventId(c.ShipmentMethodTypeId, c.Version);
            IShipmentMethodTypeStateDeleted e = NewShipmentMethodTypeStateDeleted(stateEventId);
			
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

        protected ShipmentMethodTypeStateCreated NewShipmentMethodTypeStateCreated(long version, string commandId, string requesterId)
        {
            var stateEventId = new ShipmentMethodTypeEventId(_state.ShipmentMethodTypeId, version);
            var e = NewShipmentMethodTypeStateCreated(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }

        protected ShipmentMethodTypeStateMergePatched NewShipmentMethodTypeStateMergePatched(long version, string commandId, string requesterId)
        {
            var stateEventId = new ShipmentMethodTypeEventId(_state.ShipmentMethodTypeId, version);
            var e = NewShipmentMethodTypeStateMergePatched(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }


        protected ShipmentMethodTypeStateDeleted NewShipmentMethodTypeStateDeleted(long version, string commandId, string requesterId)
        {
            var stateEventId = new ShipmentMethodTypeEventId(_state.ShipmentMethodTypeId, version);
            var e = NewShipmentMethodTypeStateDeleted(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }

////////////////////////

		private ShipmentMethodTypeStateCreated NewShipmentMethodTypeStateCreated(ShipmentMethodTypeEventId stateEventId)
		{
			return new ShipmentMethodTypeStateCreated(stateEventId);			
		}

        private ShipmentMethodTypeStateMergePatched NewShipmentMethodTypeStateMergePatched(ShipmentMethodTypeEventId stateEventId)
		{
			return new ShipmentMethodTypeStateMergePatched(stateEventId);
		}

        private ShipmentMethodTypeStateDeleted NewShipmentMethodTypeStateDeleted(ShipmentMethodTypeEventId stateEventId)
		{
			return new ShipmentMethodTypeStateDeleted(stateEventId);
		}
    }

}

