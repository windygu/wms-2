﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryPRTriggeredDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryPRTriggered;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryPRTriggered
{
    public partial class InventoryPRTriggeredAggregate : AggregateBase, IInventoryPRTriggeredAggregate
    {

        readonly IInventoryPRTriggeredState _state;

        readonly IList<IEvent> _changes = new List<IEvent>();

        public IInventoryPRTriggeredState State
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

        InventoryPRTriggeredId IGlobalIdentity<InventoryPRTriggeredId>.GlobalId
        {
            get
            {
                return this._state.GlobalId;
            }
        }

        #endregion


        public InventoryPRTriggeredAggregate(IInventoryPRTriggeredState state)
        {
            _state = state;
        }


        public virtual void ThrowOnInvalidStateTransition(ICommand c)
        {
            if (((IInventoryPRTriggeredStateProperties)_state).Version == InventoryPRTriggeredState.VersionZero)
            {
                if (IsCommandCreate((IInventoryPRTriggeredCommand)c))
                {
                    return;
                }
                throw DomainError.Named("premature", "Can't do anything to unexistent aggregate");
            }
            if (IsCommandCreate((IInventoryPRTriggeredCommand)c))
                throw DomainError.Named("rebirth", "Can't create aggregate that already exists");
        }

        private static bool IsCommandCreate(IInventoryPRTriggeredCommand c)
        {
            return c.Version == InventoryPRTriggeredState.VersionZero;
        }

        protected internal virtual void Apply(IEvent e)
        {
            OnApplying(e);
            _state.Mutate(e);
            _changes.Add(e);
        }

        public virtual void Create(ICreateInventoryPRTriggered c)
        {
            IInventoryPRTriggeredStateCreated e = Map(c);
            Apply(e);
        }

        public virtual void MergePatch(IMergePatchInventoryPRTriggered c)
        {
            IInventoryPRTriggeredStateMergePatched e = Map(c);
            Apply(e);
        }


        protected virtual IInventoryPRTriggeredStateCreated Map(ICreateInventoryPRTriggered c)
        {
			var stateEventId = new InventoryPRTriggeredStateEventId(c.InventoryPRTriggeredId, c.Version);
            IInventoryPRTriggeredStateCreated e = NewInventoryPRTriggeredStateCreated(stateEventId);
		
            e.IsProcessed = c.IsProcessed;
            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = DateTime.Now;
			var version = c.Version;


            return e;
        }

        protected virtual IInventoryPRTriggeredStateMergePatched Map(IMergePatchInventoryPRTriggered c)
        {
			var stateEventId = new InventoryPRTriggeredStateEventId(c.InventoryPRTriggeredId, c.Version);
            IInventoryPRTriggeredStateMergePatched e = NewInventoryPRTriggeredStateMergePatched(stateEventId);

            e.IsProcessed = c.IsProcessed;
            e.IsPropertyIsProcessedRemoved = c.IsPropertyIsProcessedRemoved;

            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = DateTime.Now;

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

        protected InventoryPRTriggeredStateCreated NewInventoryPRTriggeredStateCreated(string commandId, string requesterId)
        {
            var stateEventId = new InventoryPRTriggeredStateEventId(_state.InventoryPRTriggeredId, ((IInventoryPRTriggeredStateProperties)_state).Version);
            var e = NewInventoryPRTriggeredStateCreated(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = DateTime.Now;

            return e;
        }

        protected InventoryPRTriggeredStateMergePatched NewInventoryPRTriggeredStateMergePatched(string commandId, string requesterId)
        {
            var stateEventId = new InventoryPRTriggeredStateEventId(_state.InventoryPRTriggeredId, ((IInventoryPRTriggeredStateProperties)_state).Version);
            var e = NewInventoryPRTriggeredStateMergePatched(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = DateTime.Now;

            return e;
        }


////////////////////////

		private InventoryPRTriggeredStateCreated NewInventoryPRTriggeredStateCreated(InventoryPRTriggeredStateEventId stateEventId)
		{
			return new InventoryPRTriggeredStateCreated(stateEventId);			
		}

        private InventoryPRTriggeredStateMergePatched NewInventoryPRTriggeredStateMergePatched(InventoryPRTriggeredStateEventId stateEventId)
		{
			return new InventoryPRTriggeredStateMergePatched(stateEventId);
		}


    }

}

