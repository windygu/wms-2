﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateGoodIdentificationTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.GoodIdentificationType;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.GoodIdentificationType
{
	public abstract partial class GoodIdentificationTypeApplicationServiceBase : IGoodIdentificationTypeApplicationService, IApplicationService
	{
		protected abstract IEventStore EventStore { get; }

		protected abstract IGoodIdentificationTypeStateRepository StateRepository { get; }

		protected abstract IGoodIdentificationTypeStateQueryRepository StateQueryRepository { get; }

        private IAggregateEventListener<IGoodIdentificationTypeAggregate, IGoodIdentificationTypeState> _aggregateEventListener;

        public virtual IAggregateEventListener<IGoodIdentificationTypeAggregate, IGoodIdentificationTypeState> AggregateEventListener
        {
            get { return _aggregateEventListener; }
            set { _aggregateEventListener = value; }
        }

		protected GoodIdentificationTypeApplicationServiceBase()
		{
		}

		protected virtual void Update(IGoodIdentificationTypeCommand c, Action<IGoodIdentificationTypeAggregate> action)
		{
			var aggregateId = c.AggregateId;
			var state = StateRepository.Get(aggregateId, false);
			var aggregate = GetGoodIdentificationTypeAggregate(state);

			var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);

			var repeated = IsRepeatedCommand(c, eventStoreAggregateId, state);
			if (repeated) { return; }

			aggregate.ThrowOnInvalidStateTransition(c);
			action(aggregate);
			Persist(eventStoreAggregateId, aggregate, state);
		}

        private void Persist(IEventStoreAggregateId eventStoreAggregateId, IGoodIdentificationTypeAggregate aggregate, IGoodIdentificationTypeState state)
        {
            EventStore.AppendEvents(eventStoreAggregateId, ((IGoodIdentificationTypeStateProperties)state).Version, aggregate.Changes, () => { StateRepository.Save(state); });
            if (AggregateEventListener != null) 
            {
                AggregateEventListener.EventAppended(new AggregateEvent<IGoodIdentificationTypeAggregate, IGoodIdentificationTypeState>(aggregate, state, aggregate.Changes));
            }
        }

        public virtual void Initialize(IGoodIdentificationTypeStateCreated stateCreated)
        {
            var aggregateId = stateCreated.GoodIdentificationTypeEventId.GoodIdentificationTypeId;
            var state = new GoodIdentificationTypeState();
            state.GoodIdentificationTypeId = aggregateId;
            var aggregate = (GoodIdentificationTypeAggregate)GetGoodIdentificationTypeAggregate(state);

            var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);
            aggregate.Apply(stateCreated);
            Persist(eventStoreAggregateId, aggregate, state);
        }

		protected bool IsRepeatedCommand(IGoodIdentificationTypeCommand command, IEventStoreAggregateId eventStoreAggregateId, IGoodIdentificationTypeState state)
		{
			bool repeated = false;
			if (((IGoodIdentificationTypeStateProperties)state).Version > command.AggregateVersion)
			{
				var lastEvent = EventStore.GetEvent(typeof(IGoodIdentificationTypeEvent), eventStoreAggregateId, command.AggregateVersion);
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


		public virtual void When(ICreateGoodIdentificationType c)
		{
			Update(c, ar => ar.Create(c));
		}

		public virtual void When(IMergePatchGoodIdentificationType c)
		{
			Update(c, ar => ar.MergePatch(c));
		}

		public virtual void When(IDeleteGoodIdentificationType c)
		{
			Update(c, ar => ar.Delete(c));
		}

        public virtual IGoodIdentificationTypeState Get(string goodIdentificationTypeId)
        {
            var state = StateRepository.Get(goodIdentificationTypeId, true);
            return state;
        }

        public virtual IEnumerable<IGoodIdentificationTypeState> GetAll(int firstResult, int maxResults)
		{
            var states = StateQueryRepository.GetAll(firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IGoodIdentificationTypeState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IGoodIdentificationTypeState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IGoodIdentificationTypeState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
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

	    public virtual IGoodIdentificationTypeEvent GetEvent(string goodIdentificationTypeId, long version)
        {
            var e = (IGoodIdentificationTypeEvent)EventStore.GetEvent(ToEventStoreAggregateId(goodIdentificationTypeId), version);
            if (e != null)
            {
                e.ReadOnly = true;
            }
            else if (version == -1)
            {
                return GetEvent(goodIdentificationTypeId, 0);
            }
            return e;
        }

        public virtual IGoodIdentificationTypeState GetHistoryState(string goodIdentificationTypeId, long version)
        {
            var eventStream = EventStore.LoadEventStream(typeof(IGoodIdentificationTypeEvent), ToEventStoreAggregateId(goodIdentificationTypeId), version - 1);
            return new GoodIdentificationTypeState(eventStream.Events);
        }


		public abstract IGoodIdentificationTypeAggregate GetGoodIdentificationTypeAggregate(IGoodIdentificationTypeState state);

		public abstract IEventStoreAggregateId ToEventStoreAggregateId(string aggregateId);


	}

}
