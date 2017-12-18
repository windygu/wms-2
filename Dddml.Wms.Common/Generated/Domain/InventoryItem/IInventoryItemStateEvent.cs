﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryItemDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryItem
{
	public interface IInventoryItemStateEvent : IEvent, IStateEventDto, IGlobalIdentity<InventoryItemStateEventId>, ICreated<string>
	{
		InventoryItemStateEventId StateEventId { get; }

        bool ReadOnly { get; set; }

		decimal? QuantityOnHand { get; set; }

		decimal? QuantityInTransit { get; set; }

		decimal? QuantityReserved { get; set; }

		decimal? QuantityOccupied { get; set; }

		decimal? QuantityVirtual { get; set; }

	}

	public interface IInventoryItemStateCreated : IInventoryItemStateEvent//, IInventoryItemStateProperties
	{
		IEnumerable<IInventoryItemEntryStateCreated> InventoryItemEntryEvents { get; }
		
		void AddInventoryItemEntryEvent(IInventoryItemEntryStateCreated e);

		IInventoryItemEntryStateCreated NewInventoryItemEntryStateCreated(long entrySeqId);

	
	}


	public interface IInventoryItemStateMergePatched : IInventoryItemStateEvent//, IInventoryItemStateProperties
	{
		bool IsPropertyQuantityOnHandRemoved { get; set; }

		bool IsPropertyQuantityInTransitRemoved { get; set; }

		bool IsPropertyQuantityReservedRemoved { get; set; }

		bool IsPropertyQuantityOccupiedRemoved { get; set; }

		bool IsPropertyQuantityVirtualRemoved { get; set; }

		IEnumerable<IInventoryItemEntryStateEvent> InventoryItemEntryEvents { get; }
		
		void AddInventoryItemEntryEvent(IInventoryItemEntryStateEvent e);

		IInventoryItemEntryStateCreated NewInventoryItemEntryStateCreated(long entrySeqId);


	}


}

