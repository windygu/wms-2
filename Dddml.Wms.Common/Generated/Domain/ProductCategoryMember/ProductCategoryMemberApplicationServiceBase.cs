﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateProductCategoryMemberDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ProductCategoryMember;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.ProductCategoryMember
{
	public abstract partial class ProductCategoryMemberApplicationServiceBase : IProductCategoryMemberApplicationService, IApplicationService
	{
		protected abstract IEventStore EventStore { get; }

		protected abstract IProductCategoryMemberStateRepository StateRepository { get; }

		protected abstract IProductCategoryMemberStateQueryRepository StateQueryRepository { get; }

        private IAggregateEventListener<IProductCategoryMemberAggregate, IProductCategoryMemberState> _aggregateEventListener;

        public virtual IAggregateEventListener<IProductCategoryMemberAggregate, IProductCategoryMemberState> AggregateEventListener
        {
            get { return _aggregateEventListener; }
            set { _aggregateEventListener = value; }
        }

		protected ProductCategoryMemberApplicationServiceBase()
		{
		}

		protected virtual void Update(IProductCategoryMemberCommand c, Action<IProductCategoryMemberAggregate> action)
		{
			var aggregateId = c.AggregateId;
			var state = StateRepository.Get(aggregateId, false);
			var aggregate = GetProductCategoryMemberAggregate(state);

			var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);

			var repeated = IsRepeatedCommand(c, eventStoreAggregateId, state);
			if (repeated) { return; }

			aggregate.ThrowOnInvalidStateTransition(c);
			action(aggregate);
			Persist(eventStoreAggregateId, aggregate, state);
		}

        private void Persist(IEventStoreAggregateId eventStoreAggregateId, IProductCategoryMemberAggregate aggregate, IProductCategoryMemberState state)
        {
            EventStore.AppendEvents(eventStoreAggregateId, ((IProductCategoryMemberStateProperties)state).Version, aggregate.Changes, () => { StateRepository.Save(state); });
            if (AggregateEventListener != null) 
            {
                AggregateEventListener.EventAppended(new AggregateEvent<IProductCategoryMemberAggregate, IProductCategoryMemberState>(aggregate, state, aggregate.Changes));
            }
        }

        public virtual void Initialize(IProductCategoryMemberStateCreated stateCreated)
        {
            var aggregateId = stateCreated.StateEventId.ProductCategoryMemberId;
            var state = new ProductCategoryMemberState();
            state.ProductCategoryMemberId = aggregateId;
            var aggregate = (ProductCategoryMemberAggregate)GetProductCategoryMemberAggregate(state);

            var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);
            aggregate.Apply(stateCreated);
            Persist(eventStoreAggregateId, aggregate, state);
        }

		protected bool IsRepeatedCommand(IProductCategoryMemberCommand command, IEventStoreAggregateId eventStoreAggregateId, IProductCategoryMemberState state)
		{
			bool repeated = false;
			if (((IProductCategoryMemberStateProperties)state).Version > command.AggregateVersion)
			{
				var lastEvent = EventStore.FindLastEvent(typeof(IProductCategoryMemberStateEvent), eventStoreAggregateId, command.AggregateVersion);
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


		public virtual void When(ICreateProductCategoryMember c)
		{
			Update(c, ar => ar.Create(c));
		}

		public virtual void When(IMergePatchProductCategoryMember c)
		{
			Update(c, ar => ar.MergePatch(c));
		}

        public virtual IProductCategoryMemberState Get(ProductCategoryMemberId productCategoryMemberId)
        {
            var state = StateRepository.Get(productCategoryMemberId, true);
            return state;
        }

        public virtual IEnumerable<IProductCategoryMemberState> GetAll(int firstResult, int maxResults)
		{
            var states = StateQueryRepository.GetAll(firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IProductCategoryMemberState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IProductCategoryMemberState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IProductCategoryMemberState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
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

	    public virtual IProductCategoryMemberStateEvent GetStateEvent(ProductCategoryMemberId productCategoryMemberId, long version)
        {
            var e = (IProductCategoryMemberStateEvent)EventStore.GetStateEvent(ToEventStoreAggregateId(productCategoryMemberId), version);
            if (e != null)
            {
                e.ReadOnly = true;
            }
            else if (version == -1)
            {
                return GetStateEvent(productCategoryMemberId, 0);
            }
            return e;
        }

        public virtual IProductCategoryMemberState GetHistoryState(ProductCategoryMemberId productCategoryMemberId, long version)
        {
            var eventStream = EventStore.LoadEventStream(typeof(IProductCategoryMemberStateEvent), ToEventStoreAggregateId(productCategoryMemberId), version - 1);
            return new ProductCategoryMemberState(eventStream.Events);
        }


		public abstract IProductCategoryMemberAggregate GetProductCategoryMemberAggregate(IProductCategoryMemberState state);

		public abstract IEventStoreAggregateId ToEventStoreAggregateId(ProductCategoryMemberId aggregateId);


	}

}

