﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateUomDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Uom;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.Uom
{
	public abstract partial class UomApplicationServiceBase : IUomApplicationService, IApplicationService
	{
		protected abstract IEventStore EventStore { get; }

		protected abstract IUomStateRepository StateRepository { get; }

		protected abstract IUomStateQueryRepository StateQueryRepository { get; }

        private IAggregateEventListener<IUomAggregate, IUomState> _aggregateEventListener;

        public virtual IAggregateEventListener<IUomAggregate, IUomState> AggregateEventListener
        {
            get { return _aggregateEventListener; }
            set { _aggregateEventListener = value; }
        }

		protected UomApplicationServiceBase()
		{
		}

		protected virtual void Update(IUomCommand c, Action<IUomAggregate> action)
		{
			var aggregateId = c.AggregateId;
			var state = StateRepository.Get(aggregateId, false);
			var aggregate = GetUomAggregate(state);

			var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);

			var repeated = IsRepeatedCommand(c, eventStoreAggregateId, state);
			if (repeated) { return; }

			aggregate.ThrowOnInvalidStateTransition(c);
			action(aggregate);
			Persist(eventStoreAggregateId, aggregate, state);
		}

        private void Persist(IEventStoreAggregateId eventStoreAggregateId, IUomAggregate aggregate, IUomState state)
        {
            EventStore.AppendEvents(eventStoreAggregateId, ((IUomStateProperties)state).Version, aggregate.Changes, () => { StateRepository.Save(state); });
            if (AggregateEventListener != null) 
            {
                AggregateEventListener.EventAppended(new AggregateEvent<IUomAggregate, IUomState>(aggregate, state, aggregate.Changes));
            }
        }

        public virtual void Initialize(IUomStateCreated stateCreated)
        {
            var aggregateId = stateCreated.StateEventId.UomId;
            var state = new UomState();
            state.UomId = aggregateId;
            var aggregate = (UomAggregate)GetUomAggregate(state);

            var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);
            aggregate.Apply(stateCreated);
            Persist(eventStoreAggregateId, aggregate, state);
        }

		protected bool IsRepeatedCommand(IUomCommand command, IEventStoreAggregateId eventStoreAggregateId, IUomState state)
		{
			bool repeated = false;
			if (((IUomStateProperties)state).Version > command.AggregateVersion)
			{
				var lastEvent = EventStore.FindLastEvent(typeof(IUomStateEvent), eventStoreAggregateId, command.AggregateVersion);
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


		public virtual void When(ICreateUom c)
		{
			Update(c, ar => ar.Create(c));
		}

		public virtual void When(IMergePatchUom c)
		{
			Update(c, ar => ar.MergePatch(c));
		}

		public virtual void When(IDeleteUom c)
		{
			Update(c, ar => ar.Delete(c));
		}

        public virtual IUomState Get(string uomId)
        {
            var state = StateRepository.Get(uomId, true);
            return state;
        }

        public virtual IEnumerable<IUomState> GetAll(int firstResult, int maxResults)
		{
            var states = StateQueryRepository.GetAll(firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IUomState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IUomState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IUomState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
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

	    public virtual IUomStateEvent GetStateEvent(string uomId, long version)
        {
            var e = (IUomStateEvent)EventStore.GetStateEvent(ToEventStoreAggregateId(uomId), version);
            if (e != null)
            {
                e.ReadOnly = true;
            }
            else if (version == -1)
            {
                return GetStateEvent(uomId, 0);
            }
            return e;
        }

        public virtual IUomState GetHistoryState(string uomId, long version)
        {
            var eventStream = EventStore.LoadEventStream(typeof(IUomStateEvent), ToEventStoreAggregateId(uomId), version - 1);
            return new UomState(eventStream.Events);
        }


		public abstract IUomAggregate GetUomAggregate(IUomState state);

		public abstract IEventStoreAggregateId ToEventStoreAggregateId(string aggregateId);


	}

}

