﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateSupplierProductDomainNHibernate.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.SupplierProduct;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using Spring.Transaction.Interceptor;

namespace Dddml.Wms.Domain.SupplierProduct.NHibernate
{

	public class SupplierProductApplicationService : SupplierProductApplicationServiceBase
	{

		private IEventStore _eventStore;

		protected override IEventStore EventStore
		{
			get
			{
				return _eventStore;
			}
		}

		private ISupplierProductStateRepository _stateRepository;

		protected override ISupplierProductStateRepository StateRepository
		{
			get
			{
				return _stateRepository;
			}
		}

		private ISupplierProductStateQueryRepository _stateQueryRepository;

		protected override ISupplierProductStateQueryRepository StateQueryRepository
		{
			get
			{
				return _stateQueryRepository;
			}
		}

		public SupplierProductApplicationService(IEventStore eventStore, ISupplierProductStateRepository stateRepository, ISupplierProductStateQueryRepository stateQueryRepository)
		{
			this._eventStore = eventStore;
			this._stateRepository = stateRepository;
			this._stateQueryRepository = stateQueryRepository;
		}

		public override IEventStoreAggregateId ToEventStoreAggregateId(SupplierProductId aggregateId)
		{
			return new EventStoreAggregateId(aggregateId);
		}

		public override ISupplierProductAggregate GetSupplierProductAggregate(ISupplierProductState state)
		{
			return new SupplierProductAggregate(state);
		}

	}

}
