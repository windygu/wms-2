﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateLocatorTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.LocatorType;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.LocatorType
{
	public abstract partial class LocatorTypeApplicationServiceBase : ILocatorTypeApplicationService, IApplicationService
	{
		protected abstract IEventStore EventStore { get; }

		protected abstract ILocatorTypeStateRepository StateRepository { get; }

		protected abstract ILocatorTypeStateQueryRepository StateQueryRepository { get; }

        private IAggregateEventListener<ILocatorTypeAggregate, ILocatorTypeState> _aggregateEventListener;

        public virtual IAggregateEventListener<ILocatorTypeAggregate, ILocatorTypeState> AggregateEventListener
        {
            get { return _aggregateEventListener; }
            set { _aggregateEventListener = value; }
        }

		protected LocatorTypeApplicationServiceBase()
		{
		}

		protected virtual void Update(ILocatorTypeCommand c, Action<ILocatorTypeAggregate> action)
		{
			var aggregateId = c.AggregateId;
			var state = StateRepository.Get(aggregateId, false);
			var aggregate = GetLocatorTypeAggregate(state);

			var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);

			var repeated = IsRepeatedCommand(c, eventStoreAggregateId, state);
			if (repeated) { return; }

			aggregate.ThrowOnInvalidStateTransition(c);
			action(aggregate);
			Persist(eventStoreAggregateId, aggregate, state);
		}

        private void Persist(IEventStoreAggregateId eventStoreAggregateId, ILocatorTypeAggregate aggregate, ILocatorTypeState state)
        {
            EventStore.AppendEvents(eventStoreAggregateId, ((ILocatorTypeStateProperties)state).Version, aggregate.Changes, () => { StateRepository.Save(state); });
            if (AggregateEventListener != null) 
            {
                AggregateEventListener.EventAppended(new AggregateEvent<ILocatorTypeAggregate, ILocatorTypeState>(aggregate, state, aggregate.Changes));
            }
        }

        public virtual void Initialize(ILocatorTypeStateCreated stateCreated)
        {
            var aggregateId = stateCreated.LocatorTypeEventId.LocatorTypeId;
            var state = new LocatorTypeState();
            state.LocatorTypeId = aggregateId;
            var aggregate = (LocatorTypeAggregate)GetLocatorTypeAggregate(state);

            var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);
            aggregate.Apply(stateCreated);
            Persist(eventStoreAggregateId, aggregate, state);
        }

		protected bool IsRepeatedCommand(ILocatorTypeCommand command, IEventStoreAggregateId eventStoreAggregateId, ILocatorTypeState state)
		{
			bool repeated = false;
			if (((ILocatorTypeStateProperties)state).Version > command.AggregateVersion)
			{
				var lastEvent = EventStore.FindLastEvent(typeof(ILocatorTypeStateEvent), eventStoreAggregateId, command.AggregateVersion);
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


		public virtual void When(ICreateLocatorType c)
		{
			Update(c, ar => ar.Create(c));
		}

		public virtual void When(IMergePatchLocatorType c)
		{
			Update(c, ar => ar.MergePatch(c));
		}

		public virtual void When(IDeleteLocatorType c)
		{
			Update(c, ar => ar.Delete(c));
		}

        public virtual ILocatorTypeState Get(string locatorTypeId)
        {
            var state = StateRepository.Get(locatorTypeId, true);
            return state;
        }

        public virtual IEnumerable<ILocatorTypeState> GetAll(int firstResult, int maxResults)
		{
            var states = StateQueryRepository.GetAll(firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<ILocatorTypeState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<ILocatorTypeState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<ILocatorTypeState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
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

	    public virtual ILocatorTypeStateEvent GetStateEvent(string locatorTypeId, long version)
        {
            var e = (ILocatorTypeStateEvent)EventStore.GetStateEvent(ToEventStoreAggregateId(locatorTypeId), version);
            if (e != null)
            {
                e.ReadOnly = true;
            }
            else if (version == -1)
            {
                return GetStateEvent(locatorTypeId, 0);
            }
            return e;
        }

        public virtual ILocatorTypeState GetHistoryState(string locatorTypeId, long version)
        {
            var eventStream = EventStore.LoadEventStream(typeof(ILocatorTypeStateEvent), ToEventStoreAggregateId(locatorTypeId), version - 1);
            return new LocatorTypeState(eventStream.Events);
        }


		public abstract ILocatorTypeAggregate GetLocatorTypeAggregate(ILocatorTypeState state);

		public abstract IEventStoreAggregateId ToEventStoreAggregateId(string aggregateId);


	}

}

