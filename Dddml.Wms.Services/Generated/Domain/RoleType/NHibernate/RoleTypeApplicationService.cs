﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateRoleTypeDomainNHibernate.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.RoleType;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using Spring.Transaction.Interceptor;

namespace Dddml.Wms.Domain.RoleType.NHibernate
{

	public partial class RoleTypeApplicationService : RoleTypeApplicationServiceBase
	{

		private IEventStore _eventStore;

		protected override IEventStore EventStore
		{
			get
			{
				return _eventStore;
			}
		}

		private IRoleTypeStateRepository _stateRepository;

		protected override IRoleTypeStateRepository StateRepository
		{
			get
			{
				return _stateRepository;
			}
		}

		private IRoleTypeStateQueryRepository _stateQueryRepository;

		protected override IRoleTypeStateQueryRepository StateQueryRepository
		{
			get
			{
				return _stateQueryRepository;
			}
		}

		public RoleTypeApplicationService(IEventStore eventStore, IRoleTypeStateRepository stateRepository, IRoleTypeStateQueryRepository stateQueryRepository)
		{
			this._eventStore = eventStore;
			this._stateRepository = stateRepository;
			this._stateQueryRepository = stateQueryRepository;
		}

		public override IEventStoreAggregateId ToEventStoreAggregateId(string aggregateId)
		{
			return new EventStoreAggregateId(aggregateId);
		}

		public override IRoleTypeAggregate GetRoleTypeAggregate(IRoleTypeState state)
		{
			return new RoleTypeAggregate(state);
		}

	}

}
