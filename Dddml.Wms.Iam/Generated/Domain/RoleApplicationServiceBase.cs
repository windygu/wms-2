﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain
{
	public abstract partial class RoleApplicationServiceBase : IRoleApplicationService, IApplicationService
	{
		protected abstract IEventStore EventStore { get; }

		protected abstract IRoleStateRepository StateRepository { get; }

		protected abstract IRoleStateQueryRepository StateQueryRepository { get; }

		protected RoleApplicationServiceBase()
		{
		}

		protected virtual void Update(IRoleCommand c, Action<IRoleAggregate> action)
		{
			var aggregateId = c.AggregateId;
			var state = StateRepository.Get(aggregateId, false);
			var aggregate = GetRoleAggregate(state);

			var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);

			var repeated = IsRepeatedCommand(c, eventStoreAggregateId, state);
			if (repeated) { return; }

			aggregate.ThrowOnInvalidStateTransition(c);
			action(aggregate);
			EventStore.AppendEvents(eventStoreAggregateId, ((IRoleStateProperties)state).Version, aggregate.Changes, () => { StateRepository.Save(state); });
		}


		protected bool IsRepeatedCommand(IRoleCommand command, IEventStoreAggregateId eventStoreAggregateId, IRoleState state)
		{
			bool repeated = false;
			if (((IRoleStateProperties)state).Version > command.AggregateVersion)
			{
				var lastEvent = EventStore.FindLastEvent(typeof(IRoleStateEvent), eventStoreAggregateId, command.AggregateVersion);
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


		public virtual void When(ICreateRole c)
		{
			Update(c, ar => ar.Create(c));
		}

		public virtual void When(IMergePatchRole c)
		{
			Update(c, ar => ar.MergePatch(c));
		}

		public virtual void When(IDeleteRole c)
		{
			Update(c, ar => ar.Delete(c));
		}

        public virtual IRoleState Get(string roleId)
        {
            var state = StateRepository.Get(roleId, true);
            return state;
        }

        public virtual IEnumerable<IRoleState> GetAll(int firstResult, int maxResults)
		{
            var states = StateQueryRepository.GetAll(firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IRoleState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IRoleState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IRoleState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
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

	    public virtual IRoleStateEvent GetStateEvent(string roleId, long version)
        {
            var e = (IRoleStateEvent)EventStore.GetStateEvent(ToEventStoreAggregateId(roleId), version);
            if (e != null)
            {
                e.ReadOnly = true;
            }
            else if (version == -1)
            {
                return GetStateEvent(roleId, 0);
            }
            return e;
        }

        public virtual IRoleState GetHistoryState(string roleId, long version)
        {
            var eventStream = EventStore.LoadEventStream(typeof(IRoleStateEvent), ToEventStoreAggregateId(roleId), version - 1);
            return new RoleState(eventStream.Events);
        }


		public abstract IRoleAggregate GetRoleAggregate(IRoleState state);

		public abstract IEventStoreAggregateId ToEventStoreAggregateId(string aggregateId);


	}

}
