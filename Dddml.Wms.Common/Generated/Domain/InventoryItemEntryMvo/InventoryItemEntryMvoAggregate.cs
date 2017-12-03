﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryItemEntryMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryItemEntryMvo;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryItemEntryMvo
{
    public partial class InventoryItemEntryMvoAggregate : AggregateBase, IInventoryItemEntryMvoAggregate
    {

        readonly IInventoryItemEntryMvoState _state;

        readonly IList<IEvent> _changes = new List<IEvent>();

        public IInventoryItemEntryMvoState State
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

        InventoryItemEntryId IGlobalIdentity<InventoryItemEntryId>.GlobalId
        {
            get
            {
                return this._state.GlobalId;
            }
        }

        #endregion


        public InventoryItemEntryMvoAggregate(IInventoryItemEntryMvoState state)
        {
            _state = state;
        }


        public virtual void ThrowOnInvalidStateTransition(ICommand c)
        {
            if (((IInventoryItemEntryMvoStateProperties)_state).InventoryItemVersion == InventoryItemEntryMvoState.VersionZero)
            {
                if (IsCommandCreate((IInventoryItemEntryMvoCommand)c))
                {
                    return;
                }
                throw DomainError.Named("premature", "Can't do anything to unexistent aggregate");
            }
            if (IsCommandCreate((IInventoryItemEntryMvoCommand)c))
                throw DomainError.Named("rebirth", "Can't create aggregate that already exists");
        }

        private static bool IsCommandCreate(IInventoryItemEntryMvoCommand c)
        {
            return c.InventoryItemVersion == InventoryItemEntryMvoState.VersionZero;
        }

        protected internal virtual void Apply(IEvent e)
        {
            OnApplying(e);
            _state.Mutate(e);
            _changes.Add(e);
        }

        public virtual void Create(ICreateInventoryItemEntryMvo c)
        {
            IInventoryItemEntryMvoStateCreated e = Map(c);
            Apply(e);
        }

        public virtual void MergePatch(IMergePatchInventoryItemEntryMvo c)
        {
            IInventoryItemEntryMvoStateMergePatched e = Map(c);
            Apply(e);
        }


        protected virtual IInventoryItemEntryMvoStateCreated Map(ICreateInventoryItemEntryMvo c)
        {
			var stateEventId = new InventoryItemEntryMvoStateEventId(c.InventoryItemEntryId, c.InventoryItemVersion);
            IInventoryItemEntryMvoStateCreated e = NewInventoryItemEntryMvoStateCreated(stateEventId);
		
            e.QuantityOnHand = c.QuantityOnHand;
            e.QuantityReserved = c.QuantityReserved;
            e.QuantityOccupied = c.QuantityOccupied;
            e.QuantityVirtual = c.QuantityVirtual;
            e.Source = c.Source;
            e.Version = c.Version;
            e.InventoryItemQuantityOnHand = c.InventoryItemQuantityOnHand;
            e.InventoryItemQuantityReserved = c.InventoryItemQuantityReserved;
            e.InventoryItemQuantityOccupied = c.InventoryItemQuantityOccupied;
            e.InventoryItemQuantityVirtual = c.InventoryItemQuantityVirtual;
            e.InventoryItemCreatedBy = c.InventoryItemCreatedBy;
            e.InventoryItemCreatedAt = c.InventoryItemCreatedAt;
            e.InventoryItemUpdatedBy = c.InventoryItemUpdatedBy;
            e.InventoryItemUpdatedAt = c.InventoryItemUpdatedAt;
            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = DateTime.Now;
			var inventoryItemVersion = c.InventoryItemVersion;


            return e;
        }

        protected virtual IInventoryItemEntryMvoStateMergePatched Map(IMergePatchInventoryItemEntryMvo c)
        {
			var stateEventId = new InventoryItemEntryMvoStateEventId(c.InventoryItemEntryId, c.InventoryItemVersion);
            IInventoryItemEntryMvoStateMergePatched e = NewInventoryItemEntryMvoStateMergePatched(stateEventId);

            e.QuantityOnHand = c.QuantityOnHand;
            e.QuantityReserved = c.QuantityReserved;
            e.QuantityOccupied = c.QuantityOccupied;
            e.QuantityVirtual = c.QuantityVirtual;
            e.Source = c.Source;
            e.Version = c.Version;
            e.InventoryItemQuantityOnHand = c.InventoryItemQuantityOnHand;
            e.InventoryItemQuantityReserved = c.InventoryItemQuantityReserved;
            e.InventoryItemQuantityOccupied = c.InventoryItemQuantityOccupied;
            e.InventoryItemQuantityVirtual = c.InventoryItemQuantityVirtual;
            e.InventoryItemCreatedBy = c.InventoryItemCreatedBy;
            e.InventoryItemCreatedAt = c.InventoryItemCreatedAt;
            e.InventoryItemUpdatedBy = c.InventoryItemUpdatedBy;
            e.InventoryItemUpdatedAt = c.InventoryItemUpdatedAt;
            e.IsPropertyQuantityOnHandRemoved = c.IsPropertyQuantityOnHandRemoved;
            e.IsPropertyQuantityReservedRemoved = c.IsPropertyQuantityReservedRemoved;
            e.IsPropertyQuantityOccupiedRemoved = c.IsPropertyQuantityOccupiedRemoved;
            e.IsPropertyQuantityVirtualRemoved = c.IsPropertyQuantityVirtualRemoved;
            e.IsPropertySourceRemoved = c.IsPropertySourceRemoved;
            e.IsPropertyVersionRemoved = c.IsPropertyVersionRemoved;
            e.IsPropertyInventoryItemQuantityOnHandRemoved = c.IsPropertyInventoryItemQuantityOnHandRemoved;
            e.IsPropertyInventoryItemQuantityReservedRemoved = c.IsPropertyInventoryItemQuantityReservedRemoved;
            e.IsPropertyInventoryItemQuantityOccupiedRemoved = c.IsPropertyInventoryItemQuantityOccupiedRemoved;
            e.IsPropertyInventoryItemQuantityVirtualRemoved = c.IsPropertyInventoryItemQuantityVirtualRemoved;
            e.IsPropertyInventoryItemCreatedByRemoved = c.IsPropertyInventoryItemCreatedByRemoved;
            e.IsPropertyInventoryItemCreatedAtRemoved = c.IsPropertyInventoryItemCreatedAtRemoved;
            e.IsPropertyInventoryItemUpdatedByRemoved = c.IsPropertyInventoryItemUpdatedByRemoved;
            e.IsPropertyInventoryItemUpdatedAtRemoved = c.IsPropertyInventoryItemUpdatedAtRemoved;

            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = DateTime.Now;

			var inventoryItemVersion = c.InventoryItemVersion;


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

        protected InventoryItemEntryMvoStateCreated NewInventoryItemEntryMvoStateCreated(string commandId, string requesterId)
        {
            var stateEventId = new InventoryItemEntryMvoStateEventId(_state.InventoryItemEntryId, ((IInventoryItemEntryMvoStateProperties)_state).InventoryItemVersion);
            var e = NewInventoryItemEntryMvoStateCreated(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = DateTime.Now;

            return e;
        }

        protected InventoryItemEntryMvoStateMergePatched NewInventoryItemEntryMvoStateMergePatched(string commandId, string requesterId)
        {
            var stateEventId = new InventoryItemEntryMvoStateEventId(_state.InventoryItemEntryId, ((IInventoryItemEntryMvoStateProperties)_state).InventoryItemVersion);
            var e = NewInventoryItemEntryMvoStateMergePatched(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = DateTime.Now;

            return e;
        }


////////////////////////

		private InventoryItemEntryMvoStateCreated NewInventoryItemEntryMvoStateCreated(InventoryItemEntryMvoStateEventId stateEventId)
		{
			return new InventoryItemEntryMvoStateCreated(stateEventId);			
		}

        private InventoryItemEntryMvoStateMergePatched NewInventoryItemEntryMvoStateMergePatched(InventoryItemEntryMvoStateEventId stateEventId)
		{
			return new InventoryItemEntryMvoStateMergePatched(stateEventId);
		}


    }

}

