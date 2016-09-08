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
	public abstract partial class PersonApplicationServiceBase : IPersonApplicationService, IApplicationService
	{
		protected abstract IEventStore EventStore { get; }

		protected abstract IPersonStateRepository StateRepository { get; }

		protected PersonApplicationServiceBase()
		{
		}

		protected virtual void Update(IPersonCommand c, Action<IPersonAggregate> action)
		{
			var aggregateId = c.AggregateId;
			var state = StateRepository.Get(aggregateId);
			var aggregate = GetPersonAggregate(state);

			var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);

			var repeated = IsRepeatedCommand(c, eventStoreAggregateId, state);
			if (repeated) { return; }

			aggregate.ThrowOnInvalidStateTransition(c);
			action(aggregate);
			EventStore.AppendEvents(eventStoreAggregateId, ((IPersonStateProperties)state).Version, aggregate.Changes, () => { StateRepository.Save(state); });
		}


		protected bool IsRepeatedCommand(IPersonCommand command, IEventStoreAggregateId eventStoreAggregateId, IPersonState state)
		{
			bool repeated = false;
			if (((IPersonStateProperties)state).Version > command.AggregateVersion)
			{
				var lastEvent = EventStore.FindLastEvent(typeof(IPersonStateEvent), eventStoreAggregateId, command.AggregateVersion);
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


		public virtual void When(ICreatePerson c)
		{
			Update(c, ar => ar.Create(c));
		}

		public virtual void When(IMergePatchPerson c)
		{
			Update(c, ar => ar.MergePatch(c));
		}

		public virtual void When(IDeletePerson c)
		{
			Update(c, ar => ar.Delete(c));
		}

        public virtual IPersonState Get(PersonalName personalName)
        {

            var state = StateRepository.Get(personalName, true);
            return state;
        }

        public virtual IEnumerable<IPersonState> GetAll(int firstResult, int maxResults)
		{
            var states = StateRepository.GetAll(firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IPersonState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IPersonState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IPersonState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            var states = StateRepository.GetByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
			return states;
        }

        public virtual long GetCount(IEnumerable<KeyValuePair<string, object>> filter)
		{
            return StateRepository.GetCount(filter);
		}

        public virtual long GetCount(ICriterion filter)
		{
            return StateRepository.GetCount(filter);
		}

	    public virtual IPersonStateEvent GetStateEvent(PersonalName personalName, long version)
        {
            var e = (IPersonStateEvent)EventStore.GetStateEvent(ToEventStoreAggregateId(personalName), version);
            if (e != null)
            {
                e.ReadOnly = true;
            }
            else if (version == -1)
            {
                return GetStateEvent(personalName, 0);
            }
            return e;
        }


        public virtual IYearPlanState GetYearPlan(PersonalName personalName, int year)
        {
            return StateRepository.GetYearPlan(personalName, year);
        }

        public virtual IMonthPlanState GetMonthPlan(PersonalName personalName, int year, int month)
        {
            return StateRepository.GetMonthPlan(personalName, year, month);
        }

        public virtual IDayPlanState GetDayPlan(PersonalName personalName, int year, int month, int day)
        {
            return StateRepository.GetDayPlan(personalName, year, month, day);
        }


		public abstract IPersonAggregate GetPersonAggregate(IPersonState state);

		public abstract IEventStoreAggregateId ToEventStoreAggregateId(PersonalName aggregateId);


	}

}

