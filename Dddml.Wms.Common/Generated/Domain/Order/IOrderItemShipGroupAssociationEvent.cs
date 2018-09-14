﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrderDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Order;
using Dddml.Wms.Domain.PartyRole;

namespace Dddml.Wms.Domain.Order
{
	public interface IOrderItemShipGroupAssociationEvent : IEvent, IEventDto, IGlobalIdentity<OrderItemShipGroupAssociationEventId>, ICreated<string>
	{
		OrderItemShipGroupAssociationEventId OrderItemShipGroupAssociationEventId { get; }

        bool ReadOnly { get; set; }

		// Outer Id:
		//string OrderId { get; set; }

		// Outer Id:
		//string OrderShipGroupShipGroupSeqId { get; set; }

	}

    public interface IOrderItemShipGroupAssociationStateEvent : IOrderItemShipGroupAssociationEvent
    {
		long Version { get; set; }

		decimal? Quantity { get; set; }

		decimal? CancelQuantity { get; set; }

		int? NumberOfPackages { get; set; }

		int? NumberOfContainers { get; set; }

		int? NumberOfPakagesPerContainer { get; set; }

		string OrderItemShipGroupAssociationKey { get; set; }

		bool? Active { get; set; }

    }
   
	public interface IOrderItemShipGroupAssociationStateCreated : IOrderItemShipGroupAssociationStateEvent
	{
	
	}


	public interface IOrderItemShipGroupAssociationStateMergePatched : IOrderItemShipGroupAssociationStateEvent
	{
		bool IsPropertyQuantityRemoved { get; set; }

		bool IsPropertyCancelQuantityRemoved { get; set; }

		bool IsPropertyNumberOfPackagesRemoved { get; set; }

		bool IsPropertyNumberOfContainersRemoved { get; set; }

		bool IsPropertyNumberOfPakagesPerContainerRemoved { get; set; }

		bool IsPropertyOrderItemShipGroupAssociationKeyRemoved { get; set; }

		bool IsPropertyActiveRemoved { get; set; }


	}

	public interface IOrderItemShipGroupAssociationStateRemoved : IOrderItemShipGroupAssociationStateEvent
	{
	}


}

