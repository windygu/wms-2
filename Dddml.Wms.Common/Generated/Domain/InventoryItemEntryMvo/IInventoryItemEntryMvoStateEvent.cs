﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryItemEntryMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryItemEntryMvo;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryItemEntryMvo
{
	public interface IInventoryItemEntryMvoStateEvent : IEvent, IStateEventDto, IGlobalIdentity<InventoryItemEntryMvoStateEventId>, ICreated<string>
	{
		InventoryItemEntryMvoStateEventId StateEventId { get; }

        bool ReadOnly { get; set; }

		decimal? QuantityOnHand { get; set; }

		decimal? QuantityInTransit { get; set; }

		decimal? QuantityReserved { get; set; }

		decimal? QuantityOccupied { get; set; }

		decimal? QuantityVirtual { get; set; }

		InventoryItemSourceVO Source { get; set; }

		long? Version { get; set; }

		decimal? InventoryItemQuantityOnHand { get; set; }

		decimal? InventoryItemQuantityInTransit { get; set; }

		decimal? InventoryItemQuantityReserved { get; set; }

		decimal? InventoryItemQuantityOccupied { get; set; }

		decimal? InventoryItemQuantityVirtual { get; set; }

		string InventoryItemCreatedBy { get; set; }

		DateTime? InventoryItemCreatedAt { get; set; }

		string InventoryItemUpdatedBy { get; set; }

		DateTime? InventoryItemUpdatedAt { get; set; }

	}

	public interface IInventoryItemEntryMvoStateCreated : IInventoryItemEntryMvoStateEvent//, IInventoryItemEntryMvoStateProperties
	{
	
	}


	public interface IInventoryItemEntryMvoStateMergePatched : IInventoryItemEntryMvoStateEvent//, IInventoryItemEntryMvoStateProperties
	{
		bool IsPropertyQuantityOnHandRemoved { get; set; }

		bool IsPropertyQuantityInTransitRemoved { get; set; }

		bool IsPropertyQuantityReservedRemoved { get; set; }

		bool IsPropertyQuantityOccupiedRemoved { get; set; }

		bool IsPropertyQuantityVirtualRemoved { get; set; }

		bool IsPropertySourceRemoved { get; set; }

		bool IsPropertyVersionRemoved { get; set; }

		bool IsPropertyInventoryItemQuantityOnHandRemoved { get; set; }

		bool IsPropertyInventoryItemQuantityInTransitRemoved { get; set; }

		bool IsPropertyInventoryItemQuantityReservedRemoved { get; set; }

		bool IsPropertyInventoryItemQuantityOccupiedRemoved { get; set; }

		bool IsPropertyInventoryItemQuantityVirtualRemoved { get; set; }

		bool IsPropertyInventoryItemCreatedByRemoved { get; set; }

		bool IsPropertyInventoryItemCreatedAtRemoved { get; set; }

		bool IsPropertyInventoryItemUpdatedByRemoved { get; set; }

		bool IsPropertyInventoryItemUpdatedAtRemoved { get; set; }


	}


}

