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

	public interface ISellableInventoryItemEntryStateProperties
	{
		long EntrySeqId { get; set; }

		decimal SellableQuantity { get; set; }

		InventoryPRTriggeredId SourceEventId { get; set; }

		long Version { get; set; }

		// Outer Id:

		InventoryItemId SellableInventoryItemId { get; set; }

	}

}
