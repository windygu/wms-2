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
	public interface ISellableInventoryItemEntryCommand : ICommand, ICommandDto
	{
		// Outer Id:

		InventoryItemId SellableInventoryItemId { get; set; }

		long EntrySeqId { get; set; }

	}


	public interface ICreateOrMergePatchOrRemoveSellableInventoryItemEntry : ISellableInventoryItemEntryCommand
	{

		decimal? QuantitySellable { get; set; }

		InventoryPRTriggeredId SourceEventId { get; set; }

		bool? Active { get; set; }


	}

	public interface ICreateSellableInventoryItemEntry : ICreateOrMergePatchOrRemoveSellableInventoryItemEntry
	{
	}


}

