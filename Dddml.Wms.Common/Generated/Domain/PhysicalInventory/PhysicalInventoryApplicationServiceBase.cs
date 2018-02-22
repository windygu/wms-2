﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePhysicalInventoryDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PhysicalInventory;
using Dddml.Wms.Domain.InventoryItem;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.PhysicalInventory
{
	public abstract partial class PhysicalInventoryApplicationServiceBase : IPhysicalInventoryApplicationService, IApplicationService
	{
		protected abstract IEventStore EventStore { get; }

		protected abstract IPhysicalInventoryStateRepository StateRepository { get; }

		protected abstract IPhysicalInventoryStateQueryRepository StateQueryRepository { get; }

        private IAggregateEventListener<IPhysicalInventoryAggregate, IPhysicalInventoryState> _aggregateEventListener;

        public virtual IAggregateEventListener<IPhysicalInventoryAggregate, IPhysicalInventoryState> AggregateEventListener
        {
            get { return _aggregateEventListener; }
            set { _aggregateEventListener = value; }
        }

		protected PhysicalInventoryApplicationServiceBase()
		{
		}

		protected virtual void Update(IPhysicalInventoryCommand c, Action<IPhysicalInventoryAggregate> action)
		{
			var aggregateId = c.AggregateId;
			var state = StateRepository.Get(aggregateId, false);
			var aggregate = GetPhysicalInventoryAggregate(state);

			var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);

			var repeated = IsRepeatedCommand(c, eventStoreAggregateId, state);
			if (repeated) { return; }

			aggregate.ThrowOnInvalidStateTransition(c);
			action(aggregate);
			Persist(eventStoreAggregateId, aggregate, state);
		}

        private void Persist(IEventStoreAggregateId eventStoreAggregateId, IPhysicalInventoryAggregate aggregate, IPhysicalInventoryState state)
        {
            EventStore.AppendEvents(eventStoreAggregateId, ((IPhysicalInventoryStateProperties)state).Version, aggregate.Changes, () => { StateRepository.Save(state); });
            if (AggregateEventListener != null) 
            {
                AggregateEventListener.EventAppended(new AggregateEvent<IPhysicalInventoryAggregate, IPhysicalInventoryState>(aggregate, state, aggregate.Changes));
            }
        }

        public virtual void Initialize(IPhysicalInventoryStateCreated stateCreated)
        {
            var aggregateId = stateCreated.StateEventId.DocumentNumber;
            var state = new PhysicalInventoryState();
            state.DocumentNumber = aggregateId;
            var aggregate = (PhysicalInventoryAggregate)GetPhysicalInventoryAggregate(state);

            var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);
            aggregate.Apply(stateCreated);
            Persist(eventStoreAggregateId, aggregate, state);
        }

		protected bool IsRepeatedCommand(IPhysicalInventoryCommand command, IEventStoreAggregateId eventStoreAggregateId, IPhysicalInventoryState state)
		{
			bool repeated = false;
			if (((IPhysicalInventoryStateProperties)state).Version > command.AggregateVersion)
			{
				var lastEvent = EventStore.FindLastEvent(typeof(IPhysicalInventoryStateEvent), eventStoreAggregateId, command.AggregateVersion);
				if (lastEvent != null && lastEvent.CommandId == command.CommandId)
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


		public virtual void When(ICreatePhysicalInventory c)
		{
			Update(c, ar => ar.Create(c));
		}

		public virtual void When(IMergePatchPhysicalInventory c)
		{
			Update(c, ar => ar.MergePatch(c));
		}

		public virtual void When(PhysicalInventoryCommands.DocumentAction c)
		{
			Update(c, ar => ar.DocumentAction(c.Value, c.Version, c.CommandId, c.RequesterId));
		}

        public virtual IPhysicalInventoryState Get(string documentNumber)
        {
            var state = StateRepository.Get(documentNumber, true);
            return state;
        }

        public virtual IEnumerable<IPhysicalInventoryState> GetAll(int firstResult, int maxResults)
		{
            var states = StateQueryRepository.GetAll(firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IPhysicalInventoryState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IPhysicalInventoryState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IPhysicalInventoryState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
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

	    public virtual IPhysicalInventoryStateEvent GetStateEvent(string documentNumber, long version)
        {
            var e = (IPhysicalInventoryStateEvent)EventStore.GetStateEvent(ToEventStoreAggregateId(documentNumber), version);
            if (e != null)
            {
                e.ReadOnly = true;
            }
            else if (version == -1)
            {
                return GetStateEvent(documentNumber, 0);
            }
            return e;
        }

        public virtual IPhysicalInventoryState GetHistoryState(string documentNumber, long version)
        {
            var eventStream = EventStore.LoadEventStream(typeof(IPhysicalInventoryStateEvent), ToEventStoreAggregateId(documentNumber), version - 1);
            return new PhysicalInventoryState(eventStream.Events);
        }

        public virtual IPhysicalInventoryLineState GetPhysicalInventoryLine(string physicalInventoryDocumentNumber, InventoryItemId inventoryItemId)
        {
            return StateQueryRepository.GetPhysicalInventoryLine(physicalInventoryDocumentNumber, inventoryItemId);
        }


		public abstract IPhysicalInventoryAggregate GetPhysicalInventoryAggregate(IPhysicalInventoryState state);

		public abstract IEventStoreAggregateId ToEventStoreAggregateId(string aggregateId);


	}

}

