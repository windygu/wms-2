﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateShipmentDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Shipment;

namespace Dddml.Wms.Domain.Shipment
{
	public interface IItemIssuanceEvent : IEvent, IEventDto, IGlobalIdentity<ItemIssuanceEventId>, ICreated<string>
	{
		ItemIssuanceEventId ItemIssuanceEventId { get; }

        bool ReadOnly { get; set; }

		// Outer Id:
		//string ShipmentId { get; set; }

	}

    public interface IItemIssuanceStateEvent : IItemIssuanceEvent
    {
		long Version { get; set; }

		string OrderId { get; set; }

		string OrderItemSeqId { get; set; }

		string ShipGroupSeqId { get; set; }

		string ProductId { get; set; }

		string LocatorId { get; set; }

		string AttributeSetInstanceId { get; set; }

		string ShipmentItemSeqId { get; set; }

		string FixedAssetId { get; set; }

		string MaintHistSeqId { get; set; }

		DateTime? IssuedDateTime { get; set; }

		string IssuedByUserLoginId { get; set; }

		decimal? Quantity { get; set; }

		decimal? CancelQuantity { get; set; }

		bool? Active { get; set; }

    }
   
	public interface IItemIssuanceStateCreated : IItemIssuanceStateEvent
	{
	
	}


	public interface IItemIssuanceStateMergePatched : IItemIssuanceStateEvent
	{
		bool IsPropertyOrderIdRemoved { get; set; }

		bool IsPropertyOrderItemSeqIdRemoved { get; set; }

		bool IsPropertyShipGroupSeqIdRemoved { get; set; }

		bool IsPropertyProductIdRemoved { get; set; }

		bool IsPropertyLocatorIdRemoved { get; set; }

		bool IsPropertyAttributeSetInstanceIdRemoved { get; set; }

		bool IsPropertyShipmentItemSeqIdRemoved { get; set; }

		bool IsPropertyFixedAssetIdRemoved { get; set; }

		bool IsPropertyMaintHistSeqIdRemoved { get; set; }

		bool IsPropertyIssuedDateTimeRemoved { get; set; }

		bool IsPropertyIssuedByUserLoginIdRemoved { get; set; }

		bool IsPropertyQuantityRemoved { get; set; }

		bool IsPropertyCancelQuantityRemoved { get; set; }

		bool IsPropertyActiveRemoved { get; set; }


	}

	public interface IItemIssuanceStateRemoved : IItemIssuanceStateEvent
	{
	}


}

