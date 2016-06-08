﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainNHibernateAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using Spring.Transaction.Interceptor;

namespace Dddml.Wms.Domain.NHibernate
{

	public class InOutLineMvoApplicationService : InOutLineMvoApplicationServiceBase
	{

		private IEventStore _eventStore;

		protected override IEventStore EventStore
		{
			get
			{
				return _eventStore;
			}
		}

		private IInOutLineMvoStateRepository _stateRepository;

		protected override IInOutLineMvoStateRepository StateRepository
		{
			get
			{
				return _stateRepository;
			}
		}

		public InOutLineMvoApplicationService(IEventStore eventStore, IInOutLineMvoStateRepository stateRepository)
		{
			this._eventStore = eventStore;
			this._stateRepository = stateRepository;
		}

		public override IEventStoreAggregateId ToEventStoreAaggregateId(InOutLineId aggregateId)
		{
			return new EventStoreAggregateId(aggregateId);
		}

		public override IInOutLineMvoAggregate GetInOutLineMvoAggregate(IInOutLineMvoState state)
		{
			return new InOutLineMvoAggregate(state);
		}

	}

}

