﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrderItemShipGrpInvReservationDomainNHibernate.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.OrderItemShipGrpInvReservation;
using Dddml.Wms.Specialization.NHibernate;
using NHibernate;
using Spring.Transaction.Interceptor;

namespace Dddml.Wms.Domain.OrderItemShipGrpInvReservation.NHibernate
{

	public partial class OrderItemShipGrpInvReservationApplicationService : OrderItemShipGrpInvReservationApplicationServiceBase
	{

		private IEventStore _eventStore;

		protected override IEventStore EventStore
		{
			get
			{
				return _eventStore;
			}
		}

		private IOrderItemShipGrpInvReservationStateRepository _stateRepository;

		protected override IOrderItemShipGrpInvReservationStateRepository StateRepository
		{
			get
			{
				return _stateRepository;
			}
		}

		private IOrderItemShipGrpInvReservationStateQueryRepository _stateQueryRepository;

		protected override IOrderItemShipGrpInvReservationStateQueryRepository StateQueryRepository
		{
			get
			{
				return _stateQueryRepository;
			}
		}

		public OrderItemShipGrpInvReservationApplicationService(IEventStore eventStore, IOrderItemShipGrpInvReservationStateRepository stateRepository, IOrderItemShipGrpInvReservationStateQueryRepository stateQueryRepository)
		{
			this._eventStore = eventStore;
			this._stateRepository = stateRepository;
			this._stateQueryRepository = stateQueryRepository;
		}

		public override IEventStoreAggregateId ToEventStoreAggregateId(OrderItemShipGrpInvResId aggregateId)
		{
			return new EventStoreAggregateId(aggregateId);
		}

		public override IOrderItemShipGrpInvReservationAggregate GetOrderItemShipGrpInvReservationAggregate(IOrderItemShipGrpInvReservationState state)
		{
			return new OrderItemShipGrpInvReservationAggregate(state);
		}

	}

}

