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
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.InventoryPRTriggered
{
	public abstract partial class InventoryPRTriggeredApplicationServiceBase : IInventoryPRTriggeredApplicationService, IApplicationService
	{
		protected abstract IInventoryPRTriggeredStateRepository StateRepository { get; }

		protected abstract IInventoryPRTriggeredStateQueryRepository StateQueryRepository { get; }

		protected InventoryPRTriggeredApplicationServiceBase()
		{
		}

		protected virtual void Update(IInventoryPRTriggeredCommand c, Action<IInventoryPRTriggeredAggregate> action)
		{
			var aggregateId = c.AggregateId;
			var state = StateRepository.Get(aggregateId, false);
			var aggregate = GetInventoryPRTriggeredAggregate(state);

			var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);

			var repeated = IsRepeatedCommand(c, eventStoreAggregateId, state);
			if (repeated) { return; }

			aggregate.ThrowOnInvalidStateTransition(c);
			action(aggregate);
			Persist(eventStoreAggregateId, aggregate, state);
		}

        private void Persist(IEventStoreAggregateId eventStoreAggregateId, IInventoryPRTriggeredAggregate aggregate, IInventoryPRTriggeredState state)
        {
            StateRepository.Save(state);
        }

        public virtual void Initialize(IInventoryPRTriggeredStateCreated stateCreated)
        {
            var aggregateId = stateCreated.StateEventId.InventoryPRTriggeredId;
            var state = new InventoryPRTriggeredState();
            state.InventoryPRTriggeredId = aggregateId;
            var aggregate = (InventoryPRTriggeredAggregate)GetInventoryPRTriggeredAggregate(state);

            var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);
            aggregate.Apply(stateCreated);
            Persist(eventStoreAggregateId, aggregate, state);
        }

		protected bool IsRepeatedCommand(IInventoryPRTriggeredCommand command, IEventStoreAggregateId eventStoreAggregateId, IInventoryPRTriggeredState state)
		{
			bool repeated = false;
			if (((IInventoryPRTriggeredStateProperties)state).Version == command.AggregateVersion + 1)
			{
				if (state.CommandId == command.CommandId)
				{
					repeated = true;
				}
			}
			return repeated;
		}


		public virtual void Execute(object command)
		{
			((dynamic)this).When((dynamic)command);
		}


		public virtual void When(ICreateInventoryPRTriggered c)
		{
			Update(c, ar => ar.Create(c));
		}

		public virtual void When(IMergePatchInventoryPRTriggered c)
		{
			Update(c, ar => ar.MergePatch(c));
		}

        public virtual IInventoryPRTriggeredState Get(InventoryPRTriggeredId inventoryPRTriggeredId)
        {
            var state = StateRepository.Get(inventoryPRTriggeredId, true);
            return state;
        }

        public virtual IEnumerable<IInventoryPRTriggeredState> GetAll(int firstResult, int maxResults)
		{
            var states = StateQueryRepository.GetAll(firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IInventoryPRTriggeredState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IInventoryPRTriggeredState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IInventoryPRTriggeredState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var states = StateQueryRepository.GetByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
			return states;
        }

        public virtual long GetCount(IEnumerable<KeyValuePair<string, object>> filter)
		{
            return StateQueryRepository.GetCount(filter);
		}

        public virtual long GetCount(ICriterion filter)
		{
            return StateQueryRepository.GetCount(filter);
		}


		public abstract IInventoryPRTriggeredAggregate GetInventoryPRTriggeredAggregate(IInventoryPRTriggeredState state);

		public abstract IEventStoreAggregateId ToEventStoreAggregateId(InventoryPRTriggeredId aggregateId);


	}

}

