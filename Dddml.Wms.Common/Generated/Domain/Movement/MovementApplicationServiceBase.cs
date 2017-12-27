﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateMovementDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Movement;
using Dddml.Support.Criterion;

namespace Dddml.Wms.Domain.Movement
{
	public abstract partial class MovementApplicationServiceBase : IMovementApplicationService, IApplicationService
	{
		protected abstract IEventStore EventStore { get; }

		protected abstract IMovementStateRepository StateRepository { get; }

		protected abstract IMovementStateQueryRepository StateQueryRepository { get; }

        private IAggregateEventListener<IMovementAggregate, IMovementState> _aggregateEventListener;

        public virtual IAggregateEventListener<IMovementAggregate, IMovementState> AggregateEventListener
        {
            get { return _aggregateEventListener; }
            set { _aggregateEventListener = value; }
        }

		protected MovementApplicationServiceBase()
		{
		}

		protected virtual void Update(IMovementCommand c, Action<IMovementAggregate> action)
		{
			var aggregateId = c.AggregateId;
			var state = StateRepository.Get(aggregateId, false);
			var aggregate = GetMovementAggregate(state);

			var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);

			var repeated = IsRepeatedCommand(c, eventStoreAggregateId, state);
			if (repeated) { return; }

			aggregate.ThrowOnInvalidStateTransition(c);
			action(aggregate);
			Persist(eventStoreAggregateId, aggregate, state);
		}

        private void Persist(IEventStoreAggregateId eventStoreAggregateId, IMovementAggregate aggregate, IMovementState state)
        {
            EventStore.AppendEvents(eventStoreAggregateId, ((IMovementStateProperties)state).Version, aggregate.Changes, () => { StateRepository.Save(state); });
            if (AggregateEventListener != null) 
            {
                AggregateEventListener.EventAppended(new AggregateEvent<IMovementAggregate, IMovementState>(aggregate, state, aggregate.Changes));
            }
        }

        public virtual void Initialize(IMovementStateCreated stateCreated)
        {
            var aggregateId = stateCreated.StateEventId.DocumentNumber;
            var state = new MovementState();
            state.DocumentNumber = aggregateId;
            var aggregate = (MovementAggregate)GetMovementAggregate(state);

            var eventStoreAggregateId = ToEventStoreAggregateId(aggregateId);
            aggregate.Apply(stateCreated);
            Persist(eventStoreAggregateId, aggregate, state);
        }

		protected bool IsRepeatedCommand(IMovementCommand command, IEventStoreAggregateId eventStoreAggregateId, IMovementState state)
		{
			bool repeated = false;
			if (((IMovementStateProperties)state).Version > command.AggregateVersion)
			{
				var lastEvent = EventStore.FindLastEvent(typeof(IMovementStateEvent), eventStoreAggregateId, command.AggregateVersion);
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


		public virtual void When(ICreateMovement c)
		{
			Update(c, ar => ar.Create(c));
		}

		public virtual void When(IMergePatchMovement c)
		{
			Update(c, ar => ar.MergePatch(c));
		}

		public virtual void When(IDeleteMovement c)
		{
			Update(c, ar => ar.Delete(c));
		}

        public virtual IMovementState Get(string documentNumber)
        {
            var state = StateRepository.Get(documentNumber, true);
            return state;
        }

        public virtual IEnumerable<IMovementState> GetAll(int firstResult, int maxResults)
		{
            var states = StateQueryRepository.GetAll(firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IMovementState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IMovementState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
		{
            var states = StateQueryRepository.Get(filter, orders, firstResult, maxResults);
			return states;
		}

        public virtual IEnumerable<IMovementState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
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

	    public virtual IMovementStateEvent GetStateEvent(string documentNumber, long version)
        {
            var e = (IMovementStateEvent)EventStore.GetStateEvent(ToEventStoreAggregateId(documentNumber), version);
            if (e != null)
            {
                e.ReadOnly = true;
            }
            else if (version == -1)
            {
                return GetStateEvent(documentNumber, 0);
            }
            return e;
        }

        public virtual IMovementState GetHistoryState(string documentNumber, long version)
        {
            var eventStream = EventStore.LoadEventStream(typeof(IMovementStateEvent), ToEventStoreAggregateId(documentNumber), version - 1);
            return new MovementState(eventStream.Events);
        }

        public virtual IMovementLineState GetMovementLine(string movementDocumentNumber, string lineNumber)
        {
            return StateQueryRepository.GetMovementLine(movementDocumentNumber, lineNumber);
        }


		public abstract IMovementAggregate GetMovementAggregate(IMovementState state);

		public abstract IEventStoreAggregateId ToEventStoreAggregateId(string aggregateId);


	}

}
