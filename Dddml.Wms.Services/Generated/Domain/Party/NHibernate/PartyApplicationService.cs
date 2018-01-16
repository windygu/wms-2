﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePartyDomainNHibernate.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Party;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using Spring.Transaction.Interceptor;

namespace Dddml.Wms.Domain.Party.NHibernate
{

	public partial class PartyApplicationService : PartyApplicationServiceBase
	{

		private IEventStore _eventStore;

		protected override IEventStore EventStore
		{
			get
			{
				return _eventStore;
			}
		}

		private IPartyStateRepository _stateRepository;

		protected override IPartyStateRepository StateRepository
		{
			get
			{
				return _stateRepository;
			}
		}

		private IPartyStateQueryRepository _stateQueryRepository;

		protected override IPartyStateQueryRepository StateQueryRepository
		{
			get
			{
				return _stateQueryRepository;
			}
		}

		public PartyApplicationService(IEventStore eventStore, IPartyStateRepository stateRepository, IPartyStateQueryRepository stateQueryRepository)
		{
			this._eventStore = eventStore;
			this._stateRepository = stateRepository;
			this._stateQueryRepository = stateQueryRepository;
		}

		public override IEventStoreAggregateId ToEventStoreAggregateId(string aggregateId)
		{
			return new EventStoreAggregateId(aggregateId);
		}

		public override IPartyAggregate GetPartyAggregate(IPartyState state)
		{
			return new PartyAggregate(state);
		}

	}

}
