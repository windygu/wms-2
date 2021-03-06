﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateWarehouseDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Warehouse;

namespace Dddml.Wms.Domain.Warehouse
{
    public partial class WarehouseAggregate : AggregateBase, IWarehouseAggregate
    {

        readonly IWarehouseState _state;

        readonly IList<IEvent> _changes = new List<IEvent>();

        public IWarehouseState State
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


        public WarehouseAggregate(IWarehouseState state)
        {
            _state = state;
        }


        public virtual void ThrowOnInvalidStateTransition(ICommand c)
        {
            if (((IWarehouseStateProperties)_state).Version == WarehouseState.VersionZero)
            {
                if (IsCommandCreate((IWarehouseCommand)c))
                {
                    return;
                }
                throw DomainError.Named("premature", "Can't do anything to unexistent aggregate");
            }
            if (_state.Deleted)
            {
                throw DomainError.Named("zombie", "Can't do anything to deleted aggregate.");
            }
            if (IsCommandCreate((IWarehouseCommand)c))
                throw DomainError.Named("rebirth", "Can't create aggregate that already exists");
        }

        private static bool IsCommandCreate(IWarehouseCommand c)
        {
            return c.Version == WarehouseState.VersionZero;
        }

        protected internal virtual void Apply(IEvent e)
        {
            OnApplying(e);
            _state.Mutate(e);
            _changes.Add(e);
        }

        public virtual void Create(ICreateWarehouse c)
        {
            IWarehouseStateCreated e = Map(c);
            Apply(e);
        }

        public virtual void MergePatch(IMergePatchWarehouse c)
        {
            IWarehouseStateMergePatched e = Map(c);
            Apply(e);
        }

        public virtual void Delete(IDeleteWarehouse c)
        {
            IWarehouseStateDeleted e = Map(c);
            Apply(e);
        }


        protected virtual IWarehouseStateCreated Map(ICreateWarehouse c)
        {
			var stateEventId = new WarehouseEventId(c.WarehouseId, c.Version);
            IWarehouseStateCreated e = NewWarehouseStateCreated(stateEventId);
		
            e.WarehouseName = c.WarehouseName;
            e.Description = c.Description;
            e.IsInTransit = c.IsInTransit;
            e.Active = c.Active;
            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();
			var version = c.Version;


            return e;
        }

        protected virtual IWarehouseStateMergePatched Map(IMergePatchWarehouse c)
        {
			var stateEventId = new WarehouseEventId(c.WarehouseId, c.Version);
            IWarehouseStateMergePatched e = NewWarehouseStateMergePatched(stateEventId);

            e.WarehouseName = c.WarehouseName;
            e.Description = c.Description;
            e.IsInTransit = c.IsInTransit;
            e.Active = c.Active;
            e.IsPropertyWarehouseNameRemoved = c.IsPropertyWarehouseNameRemoved;
            e.IsPropertyDescriptionRemoved = c.IsPropertyDescriptionRemoved;
            e.IsPropertyIsInTransitRemoved = c.IsPropertyIsInTransitRemoved;
            e.IsPropertyActiveRemoved = c.IsPropertyActiveRemoved;

            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

			var version = c.Version;


            return e;
        }

        protected virtual IWarehouseStateDeleted Map(IDeleteWarehouse c)
        {
			var stateEventId = new WarehouseEventId(c.WarehouseId, c.Version);
            IWarehouseStateDeleted e = NewWarehouseStateDeleted(stateEventId);
			
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

        protected WarehouseStateCreated NewWarehouseStateCreated(long version, string commandId, string requesterId)
        {
            var stateEventId = new WarehouseEventId(_state.WarehouseId, version);
            var e = NewWarehouseStateCreated(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }

        protected WarehouseStateMergePatched NewWarehouseStateMergePatched(long version, string commandId, string requesterId)
        {
            var stateEventId = new WarehouseEventId(_state.WarehouseId, version);
            var e = NewWarehouseStateMergePatched(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }


        protected WarehouseStateDeleted NewWarehouseStateDeleted(long version, string commandId, string requesterId)
        {
            var stateEventId = new WarehouseEventId(_state.WarehouseId, version);
            var e = NewWarehouseStateDeleted(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }

////////////////////////

		private WarehouseStateCreated NewWarehouseStateCreated(WarehouseEventId stateEventId)
		{
			return new WarehouseStateCreated(stateEventId);			
		}

        private WarehouseStateMergePatched NewWarehouseStateMergePatched(WarehouseEventId stateEventId)
		{
			return new WarehouseStateMergePatched(stateEventId);
		}

        private WarehouseStateDeleted NewWarehouseStateDeleted(WarehouseEventId stateEventId)
		{
			return new WarehouseStateDeleted(stateEventId);
		}
    }

}

