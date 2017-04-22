﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAttributeUseMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.AttributeUseMvo;
using Dddml.Wms.Domain.AttributeSet;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.AttributeUseMvo
{
	public abstract partial class AttributeUseMvoApplicationServiceBase : IAttributeUseMvoApplicationService, IApplicationService
	{
		protected abstract IEventStore EventStore { get; }

		protected abstract IAttributeUseMvoStateRepository StateRepository { get; }

		protected abstract IAttributeUseMvoStateQueryRepository StateQueryRepository { get; }

		protected AttributeUseMvoApplicationServiceBase()
		{
		}

		protected virtual void Update(IAttributeUseMvoCommand c, Action<IAttributeUseMvoAggregate> action)
		{
			var aggregateId = c.AggregateId;
			var state = StateRepository.Get(aggregateId, false);
			var aggregate = GetAttributeUseMvoAggregate(state);

			var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);

			var repeated = IsRepeatedCommand(c, eventStoreAggregateId, state);
			if (repeated) { return; }

			aggregate.ThrowOnInvalidStateTransition(c);
			action(aggregate);
			Persist(eventStoreAggregateId, aggregate, state);
		}

        private void Persist(IEventStoreAggregateId eventStoreAggregateId, IAttributeUseMvoAggregate aggregate, IAttributeUseMvoState state)
        {
            EventStore.AppendEvents(eventStoreAggregateId, ((IAttributeUseMvoStateProperties)state).AttributeSetVersion, aggregate.Changes, () => { StateRepository.Save(state); });
        }

        public virtual void Initialize(IAttributeUseMvoStateCreated stateCreated)
        {
            var aggregateId = stateCreated.StateEventId.AttributeSetAttributeUseId;
            var state = new AttributeUseMvoState();
            state.AttributeSetAttributeUseId = aggregateId;
            var aggregate = (AttributeUseMvoAggregate)GetAttributeUseMvoAggregate(state);

            var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);
            aggregate.Apply(stateCreated);
            Persist(eventStoreAggregateId, aggregate, state);
        }

		protected bool IsRepeatedCommand(IAttributeUseMvoCommand command, IEventStoreAggregateId eventStoreAggregateId, IAttributeUseMvoState state)
		{
			bool repeated = false;
			if (((IAttributeUseMvoStateProperties)state).AttributeSetVersion > command.AggregateVersion)
			{
				var lastEvent = EventStore.FindLastEvent(typeof(IAttributeUseMvoStateEvent), eventStoreAggregateId, command.AggregateVersion);
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


		public virtual void When(ICreateAttributeUseMvo c)
		{
			Update(c, ar => ar.Create(c));
		}

		public virtual void When(IMergePatchAttributeUseMvo c)
		{
			Update(c, ar => ar.MergePatch(c));
		}

		public virtual void When(IDeleteAttributeUseMvo c)
		{
			Update(c, ar => ar.Delete(c));
		}

        public virtual IAttributeUseMvoState Get(AttributeSetAttributeUseId attributeSetAttributeUseId)
        {
            var state = StateRepository.Get(attributeSetAttributeUseId, true);
            return state;
        }

        public virtual IEnumerable<IAttributeUseMvoState> GetAll(int firstResult, int maxResults)
		{
            var states = StateQueryRepository.GetAll(firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IAttributeUseMvoState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IAttributeUseMvoState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IAttributeUseMvoState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
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

	    public virtual IAttributeUseMvoStateEvent GetStateEvent(AttributeSetAttributeUseId attributeSetAttributeUseId, long version)
        {
            var e = (IAttributeUseMvoStateEvent)EventStore.GetStateEvent(ToEventStoreAggregateId(attributeSetAttributeUseId), version);
            if (e != null)
            {
                e.ReadOnly = true;
            }
            else if (version == -1)
            {
                return GetStateEvent(attributeSetAttributeUseId, 0);
            }
            return e;
        }

        public virtual IAttributeUseMvoState GetHistoryState(AttributeSetAttributeUseId attributeSetAttributeUseId, long version)
        {
            var eventStream = EventStore.LoadEventStream(typeof(IAttributeUseMvoStateEvent), ToEventStoreAggregateId(attributeSetAttributeUseId), version - 1);
            return new AttributeUseMvoState(eventStream.Events);
        }


		public abstract IAttributeUseMvoAggregate GetAttributeUseMvoAggregate(IAttributeUseMvoState state);

		public abstract IEventStoreAggregateId ToEventStoreAggregateId(AttributeSetAttributeUseId aggregateId);


	}

}

