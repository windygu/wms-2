﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateLotDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Lot;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.Lot
{
	public abstract partial class LotApplicationServiceBase : ILotApplicationService, IApplicationService
	{
		protected abstract IEventStore EventStore { get; }

		protected abstract ILotStateRepository StateRepository { get; }

		protected abstract ILotStateQueryRepository StateQueryRepository { get; }

        private IAggregateEventListener<ILotAggregate, ILotState> _aggregateEventListener;

        public virtual IAggregateEventListener<ILotAggregate, ILotState> AggregateEventListener
        {
            get { return _aggregateEventListener; }
            set { _aggregateEventListener = value; }
        }

		protected LotApplicationServiceBase()
		{
		}

		protected virtual void Update(ILotCommand c, Action<ILotAggregate> action)
		{
			var aggregateId = c.AggregateId;
			var state = StateRepository.Get(aggregateId, false);
			var aggregate = GetLotAggregate(state);

			var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);

			var repeated = IsRepeatedCommand(c, eventStoreAggregateId, state);
			if (repeated) { return; }

			aggregate.ThrowOnInvalidStateTransition(c);
			action(aggregate);
			Persist(eventStoreAggregateId, aggregate, state);
		}

        private void Persist(IEventStoreAggregateId eventStoreAggregateId, ILotAggregate aggregate, ILotState state)
        {
            EventStore.AppendEvents(eventStoreAggregateId, ((ILotStateProperties)state).Version, aggregate.Changes, () => { StateRepository.Save(state); });
            if (AggregateEventListener != null) 
            {
                AggregateEventListener.EventAppended(new AggregateEvent<ILotAggregate, ILotState>(aggregate, state, aggregate.Changes));
            }
        }

        public virtual void Initialize(ILotStateCreated stateCreated)
        {
            var aggregateId = stateCreated.StateEventId.LotId;
            var state = new LotState();
            state.LotId = aggregateId;
            var aggregate = (LotAggregate)GetLotAggregate(state);

            var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);
            aggregate.Apply(stateCreated);
            Persist(eventStoreAggregateId, aggregate, state);
        }

		protected bool IsRepeatedCommand(ILotCommand command, IEventStoreAggregateId eventStoreAggregateId, ILotState state)
		{
			bool repeated = false;
			if (((ILotStateProperties)state).Version > command.AggregateVersion)
			{
				var lastEvent = EventStore.FindLastEvent(typeof(ILotStateEvent), eventStoreAggregateId, command.AggregateVersion);
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


		public virtual void When(ICreateLot c)
		{
			Update(c, ar => ar.Create(c));
		}

		public virtual void When(IMergePatchLot c)
		{
			Update(c, ar => ar.MergePatch(c));
		}

		public virtual void When(IDeleteLot c)
		{
			Update(c, ar => ar.Delete(c));
		}

        public virtual ILotState Get(string lotId)
        {
            var state = StateRepository.Get(lotId, true);
            return state;
        }

        public virtual IEnumerable<ILotState> GetAll(int firstResult, int maxResults)
		{
            var states = StateQueryRepository.GetAll(firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<ILotState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<ILotState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<ILotState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
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

	    public virtual ILotStateEvent GetStateEvent(string lotId, long version)
        {
            var e = (ILotStateEvent)EventStore.GetStateEvent(ToEventStoreAggregateId(lotId), version);
            if (e != null)
            {
                e.ReadOnly = true;
            }
            else if (version == -1)
            {
                return GetStateEvent(lotId, 0);
            }
            return e;
        }

        public virtual ILotState GetHistoryState(string lotId, long version)
        {
            var eventStream = EventStore.LoadEventStream(typeof(ILotStateEvent), ToEventStoreAggregateId(lotId), version - 1);
            return new LotState(eventStream.Events);
        }


		public abstract ILotAggregate GetLotAggregate(ILotState state);

		public abstract IEventStoreAggregateId ToEventStoreAggregateId(string aggregateId);


	}

}
