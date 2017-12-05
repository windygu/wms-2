﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryPostingRuleDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryPostingRule;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryPostingRule
{
    public partial class InventoryPostingRuleAggregate : AggregateBase, IInventoryPostingRuleAggregate
    {

        readonly IInventoryPostingRuleState _state;

        readonly IList<IEvent> _changes = new List<IEvent>();

        public IInventoryPostingRuleState State
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


        public InventoryPostingRuleAggregate(IInventoryPostingRuleState state)
        {
            _state = state;
        }


        public virtual void ThrowOnInvalidStateTransition(ICommand c)
        {
            if (((IInventoryPostingRuleStateProperties)_state).Version == InventoryPostingRuleState.VersionZero)
            {
                if (IsCommandCreate((IInventoryPostingRuleCommand)c))
                {
                    return;
                }
                throw DomainError.Named("premature", "Can't do anything to unexistent aggregate");
            }
            if (_state.Deleted)
            {
                throw DomainError.Named("zombie", "Can't do anything to deleted aggregate.");
            }
            if (IsCommandCreate((IInventoryPostingRuleCommand)c))
                throw DomainError.Named("rebirth", "Can't create aggregate that already exists");
        }

        private static bool IsCommandCreate(IInventoryPostingRuleCommand c)
        {
            return c.Version == InventoryPostingRuleState.VersionZero;
        }

        protected internal virtual void Apply(IEvent e)
        {
            OnApplying(e);
            _state.Mutate(e);
            _changes.Add(e);
        }

        public virtual void Create(ICreateInventoryPostingRule c)
        {
            IInventoryPostingRuleStateCreated e = Map(c);
            Apply(e);
        }

        public virtual void MergePatch(IMergePatchInventoryPostingRule c)
        {
            IInventoryPostingRuleStateMergePatched e = Map(c);
            Apply(e);
        }

        public virtual void Delete(IDeleteInventoryPostingRule c)
        {
            IInventoryPostingRuleStateDeleted e = Map(c);
            Apply(e);
        }


        protected virtual IInventoryPostingRuleStateCreated Map(ICreateInventoryPostingRule c)
        {
			var stateEventId = new InventoryPostingRuleStateEventId(c.InventoryPostingRuleId, c.Version);
            IInventoryPostingRuleStateCreated e = NewInventoryPostingRuleStateCreated(stateEventId);
		
            e.Trigger = c.Trigger;
            e.Output = c.Output;
            e.IsOutputNegated = c.IsOutputNegated;
            e.Active = c.Active;
            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = DateTime.Now;
			var version = c.Version;


            return e;
        }

        protected virtual IInventoryPostingRuleStateMergePatched Map(IMergePatchInventoryPostingRule c)
        {
			var stateEventId = new InventoryPostingRuleStateEventId(c.InventoryPostingRuleId, c.Version);
            IInventoryPostingRuleStateMergePatched e = NewInventoryPostingRuleStateMergePatched(stateEventId);

            e.Trigger = c.Trigger;
            e.Output = c.Output;
            e.IsOutputNegated = c.IsOutputNegated;
            e.Active = c.Active;
            e.IsPropertyTriggerRemoved = c.IsPropertyTriggerRemoved;
            e.IsPropertyOutputRemoved = c.IsPropertyOutputRemoved;
            e.IsPropertyIsOutputNegatedRemoved = c.IsPropertyIsOutputNegatedRemoved;
            e.IsPropertyActiveRemoved = c.IsPropertyActiveRemoved;

            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = DateTime.Now;

			var version = c.Version;


            return e;
        }

        protected virtual IInventoryPostingRuleStateDeleted Map(IDeleteInventoryPostingRule c)
        {
			var stateEventId = new InventoryPostingRuleStateEventId(c.InventoryPostingRuleId, c.Version);
            IInventoryPostingRuleStateDeleted e = NewInventoryPostingRuleStateDeleted(stateEventId);
			
            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = DateTime.Now;


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

        protected InventoryPostingRuleStateCreated NewInventoryPostingRuleStateCreated(string commandId, string requesterId)
        {
            var stateEventId = new InventoryPostingRuleStateEventId(_state.InventoryPostingRuleId, ((IInventoryPostingRuleStateProperties)_state).Version);
            var e = NewInventoryPostingRuleStateCreated(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = DateTime.Now;

            return e;
        }

        protected InventoryPostingRuleStateMergePatched NewInventoryPostingRuleStateMergePatched(string commandId, string requesterId)
        {
            var stateEventId = new InventoryPostingRuleStateEventId(_state.InventoryPostingRuleId, ((IInventoryPostingRuleStateProperties)_state).Version);
            var e = NewInventoryPostingRuleStateMergePatched(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = DateTime.Now;

            return e;
        }


        protected InventoryPostingRuleStateDeleted NewInventoryPostingRuleStateDeleted(string commandId, string requesterId)
        {
            var stateEventId = new InventoryPostingRuleStateEventId(_state.InventoryPostingRuleId, ((IInventoryPostingRuleStateProperties)_state).Version);
            var e = NewInventoryPostingRuleStateDeleted(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = DateTime.Now;

            return e;
        }

////////////////////////

		private InventoryPostingRuleStateCreated NewInventoryPostingRuleStateCreated(InventoryPostingRuleStateEventId stateEventId)
		{
			return new InventoryPostingRuleStateCreated(stateEventId);			
		}

        private InventoryPostingRuleStateMergePatched NewInventoryPostingRuleStateMergePatched(InventoryPostingRuleStateEventId stateEventId)
		{
			return new InventoryPostingRuleStateMergePatched(stateEventId);
		}

        private InventoryPostingRuleStateDeleted NewInventoryPostingRuleStateDeleted(InventoryPostingRuleStateEventId stateEventId)
		{
			return new InventoryPostingRuleStateDeleted(stateEventId);
		}

    }

}

