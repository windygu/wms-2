﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePickwaveDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Pickwave;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.Pickwave
{
	public abstract partial class PickwaveApplicationServiceBase : IPickwaveApplicationService, IApplicationService
	{
		protected abstract IEventStore EventStore { get; }

		protected abstract IPickwaveStateRepository StateRepository { get; }

		protected abstract IPickwaveStateQueryRepository StateQueryRepository { get; }

        private IAggregateEventListener<IPickwaveAggregate, IPickwaveState> _aggregateEventListener;

        public virtual IAggregateEventListener<IPickwaveAggregate, IPickwaveState> AggregateEventListener
        {
            get { return _aggregateEventListener; }
            set { _aggregateEventListener = value; }
        }

		protected PickwaveApplicationServiceBase()
		{
		}

		protected virtual void Update(IPickwaveCommand c, Action<IPickwaveAggregate> action)
		{
			var aggregateId = c.AggregateId;
			var state = StateRepository.Get(aggregateId, false);
			var aggregate = GetPickwaveAggregate(state);

			var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);

			var repeated = IsRepeatedCommand(c, eventStoreAggregateId, state);
			if (repeated) { return; }

			aggregate.ThrowOnInvalidStateTransition(c);
			action(aggregate);
			Persist(eventStoreAggregateId, aggregate, state);
		}

        private void Persist(IEventStoreAggregateId eventStoreAggregateId, IPickwaveAggregate aggregate, IPickwaveState state)
        {
            EventStore.AppendEvents(eventStoreAggregateId, ((IPickwaveStateProperties)state).Version, aggregate.Changes, () => { StateRepository.Save(state); });
            if (AggregateEventListener != null) 
            {
                AggregateEventListener.EventAppended(new AggregateEvent<IPickwaveAggregate, IPickwaveState>(aggregate, state, aggregate.Changes));
            }
        }

        public virtual void Initialize(IPickwaveStateCreated stateCreated)
        {
            var aggregateId = stateCreated.PickwaveEventId.PickwaveId;
            var state = new PickwaveState();
            state.PickwaveId = aggregateId;
            var aggregate = (PickwaveAggregate)GetPickwaveAggregate(state);

            var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);
            aggregate.Apply(stateCreated);
            Persist(eventStoreAggregateId, aggregate, state);
        }

		protected bool IsRepeatedCommand(IPickwaveCommand command, IEventStoreAggregateId eventStoreAggregateId, IPickwaveState state)
		{
			bool repeated = false;
			if (((IPickwaveStateProperties)state).Version > command.AggregateVersion)
			{
				var lastEvent = EventStore.FindLastEvent(typeof(IPickwaveStateEvent), eventStoreAggregateId, command.AggregateVersion);
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


		public virtual void When(ICreatePickwave c)
		{
			Update(c, ar => ar.Create(c));
		}

		public virtual void When(IMergePatchPickwave c)
		{
			Update(c, ar => ar.MergePatch(c));
		}

		public virtual void When(IDeletePickwave c)
		{
			Update(c, ar => ar.Delete(c));
		}

        public virtual IPickwaveState Get(long? pickwaveId)
        {
            var state = StateRepository.Get(pickwaveId, true);
            return state;
        }

        public virtual IEnumerable<IPickwaveState> GetAll(int firstResult, int maxResults)
		{
            var states = StateQueryRepository.GetAll(firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IPickwaveState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IPickwaveState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IPickwaveState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
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

	    public virtual IPickwaveStateEvent GetStateEvent(long? pickwaveId, long version)
        {
            var e = (IPickwaveStateEvent)EventStore.GetStateEvent(ToEventStoreAggregateId(pickwaveId), version);
            if (e != null)
            {
                e.ReadOnly = true;
            }
            else if (version == -1)
            {
                return GetStateEvent(pickwaveId, 0);
            }
            return e;
        }

        public virtual IPickwaveState GetHistoryState(long? pickwaveId, long version)
        {
            var eventStream = EventStore.LoadEventStream(typeof(IPickwaveStateEvent), ToEventStoreAggregateId(pickwaveId), version - 1);
            return new PickwaveState(eventStream.Events);
        }


		public abstract IPickwaveAggregate GetPickwaveAggregate(IPickwaveState state);

		public abstract IEventStoreAggregateId ToEventStoreAggregateId(long? aggregateId);


	}

}

