﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateShipmentTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ShipmentType;

namespace Dddml.Wms.Domain.ShipmentType
{
    public partial class ShipmentTypeAggregate : AggregateBase, IShipmentTypeAggregate
    {

        readonly IShipmentTypeState _state;

        readonly IList<IEvent> _changes = new List<IEvent>();

        public IShipmentTypeState State
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


        public ShipmentTypeAggregate(IShipmentTypeState state)
        {
            _state = state;
        }


        public virtual void ThrowOnInvalidStateTransition(ICommand c)
        {
            if (((IShipmentTypeStateProperties)_state).Version == ShipmentTypeState.VersionZero)
            {
                if (IsCommandCreate((IShipmentTypeCommand)c))
                {
                    return;
                }
                throw DomainError.Named("premature", "Can't do anything to unexistent aggregate");
            }
            if (IsCommandCreate((IShipmentTypeCommand)c))
                throw DomainError.Named("rebirth", "Can't create aggregate that already exists");
        }

        private static bool IsCommandCreate(IShipmentTypeCommand c)
        {
            return c.Version == ShipmentTypeState.VersionZero;
        }

        protected internal virtual void Apply(IEvent e)
        {
            OnApplying(e);
            _state.Mutate(e);
            _changes.Add(e);
        }

        public virtual void Create(ICreateShipmentType c)
        {
            IShipmentTypeStateCreated e = Map(c);
            Apply(e);
        }

        public virtual void MergePatch(IMergePatchShipmentType c)
        {
            IShipmentTypeStateMergePatched e = Map(c);
            Apply(e);
        }


        protected virtual IShipmentTypeStateCreated Map(ICreateShipmentType c)
        {
			var stateEventId = new ShipmentTypeStateEventId(c.ShipmentTypeId, c.Version);
            IShipmentTypeStateCreated e = NewShipmentTypeStateCreated(stateEventId);
		
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

        protected virtual IShipmentTypeStateMergePatched Map(IMergePatchShipmentType c)
        {
			var stateEventId = new ShipmentTypeStateEventId(c.ShipmentTypeId, c.Version);
            IShipmentTypeStateMergePatched e = NewShipmentTypeStateMergePatched(stateEventId);

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

        protected ShipmentTypeStateCreated NewShipmentTypeStateCreated(string commandId, string requesterId)
        {
            var stateEventId = new ShipmentTypeStateEventId(_state.ShipmentTypeId, ((IShipmentTypeStateProperties)_state).Version);
            var e = NewShipmentTypeStateCreated(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }

        protected ShipmentTypeStateMergePatched NewShipmentTypeStateMergePatched(string commandId, string requesterId)
        {
            var stateEventId = new ShipmentTypeStateEventId(_state.ShipmentTypeId, ((IShipmentTypeStateProperties)_state).Version);
            var e = NewShipmentTypeStateMergePatched(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }


////////////////////////

		private ShipmentTypeStateCreated NewShipmentTypeStateCreated(ShipmentTypeStateEventId stateEventId)
		{
			return new ShipmentTypeStateCreated(stateEventId);			
		}

        private ShipmentTypeStateMergePatched NewShipmentTypeStateMergePatched(ShipmentTypeStateEventId stateEventId)
		{
			return new ShipmentTypeStateMergePatched(stateEventId);
		}

    }

}

