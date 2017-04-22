﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateLocatorDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Locator;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.Locator
{
	public abstract partial class LocatorApplicationServiceBase : ILocatorApplicationService, IApplicationService
	{
		protected abstract IEventStore EventStore { get; }

		protected abstract ILocatorStateRepository StateRepository { get; }

		protected abstract ILocatorStateQueryRepository StateQueryRepository { get; }

		protected LocatorApplicationServiceBase()
		{
		}

		protected virtual void Update(ILocatorCommand c, Action<ILocatorAggregate> action)
		{
			var aggregateId = c.AggregateId;
			var state = StateRepository.Get(aggregateId, false);
			var aggregate = GetLocatorAggregate(state);

			var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);

			var repeated = IsRepeatedCommand(c, eventStoreAggregateId, state);
			if (repeated) { return; }

			aggregate.ThrowOnInvalidStateTransition(c);
			action(aggregate);
			Persist(eventStoreAggregateId, aggregate, state);
		}

        private void Persist(IEventStoreAggregateId eventStoreAggregateId, ILocatorAggregate aggregate, ILocatorState state)
        {
            EventStore.AppendEvents(eventStoreAggregateId, ((ILocatorStateProperties)state).Version, aggregate.Changes, () => { StateRepository.Save(state); });
        }

        public virtual void Initialize(ILocatorStateCreated stateCreated)
        {
            var aggregateId = stateCreated.StateEventId.LocatorId;
            var state = new LocatorState();
            state.LocatorId = aggregateId;
            var aggregate = (LocatorAggregate)GetLocatorAggregate(state);

            var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);
            aggregate.Apply(stateCreated);
            Persist(eventStoreAggregateId, aggregate, state);
        }

		protected bool IsRepeatedCommand(ILocatorCommand command, IEventStoreAggregateId eventStoreAggregateId, ILocatorState state)
		{
			bool repeated = false;
			if (((ILocatorStateProperties)state).Version > command.AggregateVersion)
			{
				var lastEvent = EventStore.FindLastEvent(typeof(ILocatorStateEvent), eventStoreAggregateId, command.AggregateVersion);
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


		public virtual void When(ICreateLocator c)
		{
			Update(c, ar => ar.Create(c));
		}

		public virtual void When(IMergePatchLocator c)
		{
			Update(c, ar => ar.MergePatch(c));
		}

		public virtual void When(IDeleteLocator c)
		{
			Update(c, ar => ar.Delete(c));
		}

        public virtual ILocatorState Get(string locatorId)
        {
            var state = StateRepository.Get(locatorId, true);
            return state;
        }

        public virtual IEnumerable<ILocatorState> GetAll(int firstResult, int maxResults)
		{
            var states = StateQueryRepository.GetAll(firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<ILocatorState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<ILocatorState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<ILocatorState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
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

	    public virtual ILocatorStateEvent GetStateEvent(string locatorId, long version)
        {
            var e = (ILocatorStateEvent)EventStore.GetStateEvent(ToEventStoreAggregateId(locatorId), version);
            if (e != null)
            {
                e.ReadOnly = true;
            }
            else if (version == -1)
            {
                return GetStateEvent(locatorId, 0);
            }
            return e;
        }

        public virtual ILocatorState GetHistoryState(string locatorId, long version)
        {
            var eventStream = EventStore.LoadEventStream(typeof(ILocatorStateEvent), ToEventStoreAggregateId(locatorId), version - 1);
            return new LocatorState(eventStream.Events);
        }


		public abstract ILocatorAggregate GetLocatorAggregate(ILocatorState state);

		public abstract IEventStoreAggregateId ToEventStoreAggregateId(string aggregateId);


	}

}

