﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInOutDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InOut;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.InOut
{
	public abstract partial class InOutApplicationServiceBase : IInOutApplicationService, IApplicationService
	{
		protected abstract IEventStore EventStore { get; }

		protected abstract IInOutStateRepository StateRepository { get; }

		protected abstract IInOutStateQueryRepository StateQueryRepository { get; }

        private IAggregateEventListener<IInOutAggregate, IInOutState> _aggregateEventListener;

        public virtual IAggregateEventListener<IInOutAggregate, IInOutState> AggregateEventListener
        {
            get { return _aggregateEventListener; }
            set { _aggregateEventListener = value; }
        }

		protected InOutApplicationServiceBase()
		{
		}

		protected virtual void Update(IInOutCommand c, Action<IInOutAggregate> action)
		{
			var aggregateId = c.AggregateId;
			var state = StateRepository.Get(aggregateId, false);
			var aggregate = GetInOutAggregate(state);

			var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);

			var repeated = IsRepeatedCommand(c, eventStoreAggregateId, state);
			if (repeated) { return; }

			aggregate.ThrowOnInvalidStateTransition(c);
			action(aggregate);
			Persist(eventStoreAggregateId, aggregate, state);
		}

        private void Persist(IEventStoreAggregateId eventStoreAggregateId, IInOutAggregate aggregate, IInOutState state)
        {
            EventStore.AppendEvents(eventStoreAggregateId, ((IInOutStateProperties)state).Version, aggregate.Changes, () => { StateRepository.Save(state); });
            if (AggregateEventListener != null) 
            {
                AggregateEventListener.EventAppended(new AggregateEvent<IInOutAggregate, IInOutState>(aggregate, state, aggregate.Changes));
            }
        }

        public virtual void Initialize(IInOutStateCreated stateCreated)
        {
            var aggregateId = stateCreated.InOutEventId.DocumentNumber;
            var state = new InOutState();
            state.DocumentNumber = aggregateId;
            var aggregate = (InOutAggregate)GetInOutAggregate(state);

            var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);
            aggregate.Apply(stateCreated);
            Persist(eventStoreAggregateId, aggregate, state);
        }

		protected bool IsRepeatedCommand(IInOutCommand command, IEventStoreAggregateId eventStoreAggregateId, IInOutState state)
		{
			bool repeated = false;
			if (((IInOutStateProperties)state).Version > command.AggregateVersion)
			{
				var lastEvent = EventStore.GetEvent(typeof(IInOutEvent), eventStoreAggregateId, command.AggregateVersion);
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


		public virtual void When(ICreateInOut c)
		{
			Update(c, ar => ar.Create(c));
		}

		public virtual void When(IMergePatchInOut c)
		{
			Update(c, ar => ar.MergePatch(c));
		}

		public virtual void When(InOutCommands.Complete c)
		{
			Update(c, ar => ar.Complete(c.Version, c.CommandId, c.RequesterId));
		}

		public virtual void When(InOutCommands.Close c)
		{
			Update(c, ar => ar.Close(c.Version, c.CommandId, c.RequesterId));
		}

		public virtual void When(InOutCommands.Void c)
		{
			Update(c, ar => ar.Void(c.Version, c.CommandId, c.RequesterId));
		}

		public virtual void When(InOutCommands.Reverse c)
		{
			Update(c, ar => ar.Reverse(c.Version, c.CommandId, c.RequesterId));
		}

		public virtual void When(InOutCommands.AddLine c)
		{
			Update(c, ar => ar.AddLine(c.LineNumber, c.LocatorId, c.ProductId, c.AttributeSetInstance, c.DamageStatusId, c.Description, c.QuantityUomId, c.MovementQuantity, c.Version, c.CommandId, c.RequesterId));
		}

		public virtual void When(InOutCommands.DocumentAction c)
		{
			Update(c, ar => ar.DocumentAction(c.Value, c.Version, c.CommandId, c.RequesterId));
		}

        public virtual IInOutState Get(string documentNumber)
        {
            var state = StateRepository.Get(documentNumber, true);
            return state;
        }

        public virtual IEnumerable<IInOutState> GetAll(int firstResult, int maxResults)
		{
            var states = StateQueryRepository.GetAll(firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IInOutState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IInOutState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IInOutState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
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

	    public virtual IInOutEvent GetEvent(string documentNumber, long version)
        {
            var e = (IInOutEvent)EventStore.GetEvent(ToEventStoreAggregateId(documentNumber), version);
            if (e != null)
            {
                e.ReadOnly = true;
            }
            else if (version == -1)
            {
                return GetEvent(documentNumber, 0);
            }
            return e;
        }

        public virtual IInOutState GetHistoryState(string documentNumber, long version)
        {
            var eventStream = EventStore.LoadEventStream(typeof(IInOutEvent), ToEventStoreAggregateId(documentNumber), version - 1);
            return new InOutState(eventStream.Events);
        }

        public virtual IInOutImageState GetInOutImage(string inOutDocumentNumber, string sequenceId)
        {
            return StateQueryRepository.GetInOutImage(inOutDocumentNumber, sequenceId);
        }

        public IEnumerable<IInOutImageState> GetInOutImages(string inOutDocumentNumber)
        {
            return StateQueryRepository.GetInOutImages(inOutDocumentNumber);
        }

        public virtual IInOutLineState GetInOutLine(string inOutDocumentNumber, string lineNumber)
        {
            return StateQueryRepository.GetInOutLine(inOutDocumentNumber, lineNumber);
        }

        public IEnumerable<IInOutLineState> GetInOutLines(string inOutDocumentNumber)
        {
            return StateQueryRepository.GetInOutLines(inOutDocumentNumber);
        }

        public virtual IInOutLineImageState GetInOutLineImage(string inOutDocumentNumber, string inOutLineLineNumber, string sequenceId)
        {
            return StateQueryRepository.GetInOutLineImage(inOutDocumentNumber, inOutLineLineNumber, sequenceId);
        }

        public IEnumerable<IInOutLineImageState> GetInOutLineImages(string inOutDocumentNumber, string inOutLineLineNumber)
        {
            return StateQueryRepository.GetInOutLineImages(inOutDocumentNumber, inOutLineLineNumber);
        }


		public abstract IInOutAggregate GetInOutAggregate(IInOutState state);

		public abstract IEventStoreAggregateId ToEventStoreAggregateId(string aggregateId);


	}

}

