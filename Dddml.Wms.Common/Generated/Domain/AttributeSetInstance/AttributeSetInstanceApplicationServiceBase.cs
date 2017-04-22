﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAttributeSetInstanceDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.AttributeSetInstance;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.AttributeSetInstance
{
	public abstract partial class AttributeSetInstanceApplicationServiceBase : IAttributeSetInstanceApplicationService, IApplicationService
	{
		protected abstract IEventStore EventStore { get; }

		protected abstract IAttributeSetInstanceStateRepository StateRepository { get; }

		protected abstract IAttributeSetInstanceStateQueryRepository StateQueryRepository { get; }

		protected abstract IIdGenerator<string, ICreateAttributeSetInstance, IAttributeSetInstanceState> IdGenerator { get; }
		
		protected AttributeSetInstanceApplicationServiceBase()
		{
		}

        public virtual string CreateWithoutId(ICreateAttributeSetInstance c)
        {
            string idObj = IdGenerator.GenerateId(c);
            var state = StateRepository.Get(idObj, true);
            if (state != null)
            {
                if (IdGenerator.Equals((ICreateAttributeSetInstance)c, state))
                {
                    return state.AttributeSetInstanceId;
                }

                if (IdGenerator.IsSurrogateIdEnabled())
                {
                    idObj = IdGenerator.GetNextId();
                }
                else
                {
                    throw DomainError.Named("instanceExist", "the instance already exist, Id: {0}, aggreate name: {1}", idObj, "AttributeSetInstance");
                }
            }
            ((ICreateOrMergePatchOrDeleteAttributeSetInstance)c).AttributeSetInstanceId = idObj;
            When((ICreateAttributeSetInstance)c);
            return idObj;

        }

		protected virtual void Update(IAttributeSetInstanceCommand c, Action<IAttributeSetInstanceAggregate> action)
		{
			var aggregateId = c.AggregateId;
			var state = StateRepository.Get(aggregateId, false);
			var aggregate = GetAttributeSetInstanceAggregate(state);

			var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);

			var repeated = IsRepeatedCommand(c, eventStoreAggregateId, state);
			if (repeated) { return; }

			aggregate.ThrowOnInvalidStateTransition(c);
			action(aggregate);
			Persist(eventStoreAggregateId, aggregate, state);
		}

        private void Persist(IEventStoreAggregateId eventStoreAggregateId, IAttributeSetInstanceAggregate aggregate, IAttributeSetInstanceState state)
        {
            EventStore.AppendEvents(eventStoreAggregateId, ((IAttributeSetInstanceStateProperties)state).Version, aggregate.Changes, () => {});
        }

        public virtual void Initialize(IAttributeSetInstanceStateCreated stateCreated)
        {
            var aggregateId = stateCreated.StateEventId.AttributeSetInstanceId;
            var state = new AttributeSetInstanceState();
            state.AttributeSetInstanceId = aggregateId;
            var aggregate = (AttributeSetInstanceAggregate)GetAttributeSetInstanceAggregate(state);

            var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);
            aggregate.Apply(stateCreated);
            Persist(eventStoreAggregateId, aggregate, state);
        }

		protected bool IsRepeatedCommand(IAttributeSetInstanceCommand command, IEventStoreAggregateId eventStoreAggregateId, IAttributeSetInstanceState state)
		{
			bool repeated = false;
			if (((IAttributeSetInstanceStateProperties)state).Version > command.AggregateVersion)
			{
				var lastEvent = EventStore.FindLastEvent(typeof(IAttributeSetInstanceStateEvent), eventStoreAggregateId, command.AggregateVersion);
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


		public virtual void When(ICreateAttributeSetInstance c)
		{
			Update(c, ar => ar.Create(c));
		}

        public virtual IAttributeSetInstanceState Get(string attributeSetInstanceId)
        {
            var state = StateRepository.Get(attributeSetInstanceId, true);
            return state;
        }

        public virtual IEnumerable<IAttributeSetInstanceState> GetAll(int firstResult, int maxResults)
		{
            var states = StateQueryRepository.GetAll(firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IAttributeSetInstanceState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IAttributeSetInstanceState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IAttributeSetInstanceState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
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

	    public virtual IAttributeSetInstanceStateEvent GetStateEvent(string attributeSetInstanceId, long version)
        {
            var e = (IAttributeSetInstanceStateEvent)EventStore.GetStateEvent(ToEventStoreAggregateId(attributeSetInstanceId), version);
            if (e != null)
            {
                e.ReadOnly = true;
            }
            else if (version == -1)
            {
                return GetStateEvent(attributeSetInstanceId, 0);
            }
            return e;
        }

        public virtual IAttributeSetInstanceState GetHistoryState(string attributeSetInstanceId, long version)
        {
            var eventStream = EventStore.LoadEventStream(typeof(IAttributeSetInstanceStateEvent), ToEventStoreAggregateId(attributeSetInstanceId), version - 1);
            return new AttributeSetInstanceState(eventStream.Events);
        }


		public abstract IAttributeSetInstanceAggregate GetAttributeSetInstanceAggregate(IAttributeSetInstanceState state);

		public abstract IEventStoreAggregateId ToEventStoreAggregateId(string aggregateId);


	}

}

