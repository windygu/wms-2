﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateSellableInventoryItemDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.SellableInventoryItem;
using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Domain.InventoryPRTriggered;

namespace Dddml.Wms.Domain.SellableInventoryItem
{
	public interface ISellableInventoryItemStateEvent : IEvent, IStateEventDto, IGlobalIdentity<SellableInventoryItemStateEventId>, ICreated<string>
	{
		SellableInventoryItemStateEventId StateEventId { get; }

        bool ReadOnly { get; set; }

		decimal? QuantitySellable { get; set; }

	}

	public interface ISellableInventoryItemStateCreated : ISellableInventoryItemStateEvent//, ISellableInventoryItemStateProperties
	{
		IEnumerable<ISellableInventoryItemEntryStateCreated> SellableInventoryItemEntryEvents { get; }
		
		void AddSellableInventoryItemEntryEvent(ISellableInventoryItemEntryStateCreated e);

		ISellableInventoryItemEntryStateCreated NewSellableInventoryItemEntryStateCreated(long entrySeqId);

	
	}


	public interface ISellableInventoryItemStateMergePatched : ISellableInventoryItemStateEvent//, ISellableInventoryItemStateProperties
	{
		bool IsPropertyQuantitySellableRemoved { get; set; }

		IEnumerable<ISellableInventoryItemEntryStateEvent> SellableInventoryItemEntryEvents { get; }
		
		void AddSellableInventoryItemEntryEvent(ISellableInventoryItemEntryStateEvent e);

		ISellableInventoryItemEntryStateCreated NewSellableInventoryItemEntryStateCreated(long entrySeqId);


	}


}

