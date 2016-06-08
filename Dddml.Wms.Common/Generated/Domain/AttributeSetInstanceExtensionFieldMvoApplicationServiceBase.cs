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
	public abstract partial class AttributeSetInstanceExtensionFieldMvoApplicationServiceBase : IAttributeSetInstanceExtensionFieldMvoApplicationService, IApplicationService
	{
		protected abstract IEventStore EventStore { get; }

		protected abstract IAttributeSetInstanceExtensionFieldMvoStateRepository StateRepository { get; }

		protected AttributeSetInstanceExtensionFieldMvoApplicationServiceBase()
		{
		}

		protected virtual void Update(IAttributeSetInstanceExtensionFieldMvoCommand c, Action<IAttributeSetInstanceExtensionFieldMvoAggregate> action)
		{
			var aggregateId = c.AggregateId;
			var state = StateRepository.Get(aggregateId);
			var aggregate = GetAttributeSetInstanceExtensionFieldMvoAggregate(state);

			var eventStoreAaggregateId = ToEventStoreAaggregateId(aggregateId);

			var repeated = IsRepeatedCommand(c, eventStoreAaggregateId, state);
			if (repeated) { return; }

			aggregate.ThrowOnInvalidStateTransition(c);
			action(aggregate);
			EventStore.AppendEvents(ToEventStoreAaggregateId(aggregateId), ((IAttributeSetInstanceExtensionFieldMvoStateProperties)state).AttrSetInstEFGroupVersion, aggregate.Changes, () => { StateRepository.Save(state); });
		}


		protected bool IsRepeatedCommand(IAttributeSetInstanceExtensionFieldMvoCommand command, IEventStoreAggregateId eventStoreAaggregateId, IAttributeSetInstanceExtensionFieldMvoState state)
		{
			bool repeated = false;
			if (((IAttributeSetInstanceExtensionFieldMvoStateProperties)state).AttrSetInstEFGroupVersion > command.AggregateVersion)
			{
				var lastEvent = EventStore.FindLastEvent(typeof(IAttributeSetInstanceExtensionFieldMvoStateEvent), eventStoreAaggregateId, command.AggregateVersion);
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


		public virtual void When(ICreateAttributeSetInstanceExtensionFieldMvo c)
		{
			Update(c, ar => ar.Create(c));
		}

		public virtual void When(IMergePatchAttributeSetInstanceExtensionFieldMvo c)
		{
			Update(c, ar => ar.MergePatch(c));
		}

		public virtual void When(IDeleteAttributeSetInstanceExtensionFieldMvo c)
		{
			Update(c, ar => ar.Delete(c));
		}

 		public virtual IAttributeSetInstanceExtensionFieldMvoState Get(AttributeSetInstanceExtensionFieldId attributeSetInstanceExtensionFieldId)
		{
            var state = StateRepository.Get(attributeSetInstanceExtensionFieldId);
			return state;
		}

        public virtual IEnumerable<IAttributeSetInstanceExtensionFieldMvoState> GetAll(int firstResult, int maxResults)
		{
            var states = StateRepository.GetAll(firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IAttributeSetInstanceExtensionFieldMvoState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IAttributeSetInstanceExtensionFieldMvoState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateRepository.Get(filter, orders, firstResult, maxResults);
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

	    public virtual IAttributeSetInstanceExtensionFieldMvoStateEvent GetStateEvent(AttributeSetInstanceExtensionFieldId attributeSetInstanceExtensionFieldId, long version)
        {
            var e = (IAttributeSetInstanceExtensionFieldMvoStateEvent)EventStore.GetStateEvent(ToEventStoreAaggregateId(attributeSetInstanceExtensionFieldId), version);
            if (e != null)
            {
                e.ReadOnly = true;
            }
            return e;
        }


		public abstract IAttributeSetInstanceExtensionFieldMvoAggregate GetAttributeSetInstanceExtensionFieldMvoAggregate(IAttributeSetInstanceExtensionFieldMvoState state);

		public abstract IEventStoreAggregateId ToEventStoreAaggregateId(AttributeSetInstanceExtensionFieldId aggregateId);


	}

}

