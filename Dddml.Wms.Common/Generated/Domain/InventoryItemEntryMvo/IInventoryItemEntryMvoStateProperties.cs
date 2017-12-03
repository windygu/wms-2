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

	public interface IInventoryItemEntryMvoStateProperties
	{
		InventoryItemEntryId InventoryItemEntryId { get; set; }

		decimal QuantityOnHand { get; set; }

		decimal QuantityReserved { get; set; }

		decimal QuantityOccupied { get; set; }

		decimal QuantityVirtual { get; set; }

		InventoryItemSourceVO Source { get; set; }

		long Version { get; set; }

		decimal InventoryItemQuantityOnHand { get; set; }

		decimal InventoryItemQuantityReserved { get; set; }

		decimal InventoryItemQuantityOccupied { get; set; }

		decimal InventoryItemQuantityVirtual { get; set; }

		long InventoryItemVersion { get; set; }

		string InventoryItemCreatedBy { get; set; }

		DateTime InventoryItemCreatedAt { get; set; }

		string InventoryItemUpdatedBy { get; set; }

		DateTime InventoryItemUpdatedAt { get; set; }

	}

}
