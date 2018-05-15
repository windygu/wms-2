﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePicklistItemMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PicklistItemMvo;
using Dddml.Wms.Domain.PicklistBin;

namespace Dddml.Wms.Domain.PicklistItemMvo
{

	public interface IPicklistItemMvoStateProperties
	{
		PicklistBinPicklistItemId PicklistBinPicklistItemId { get; set; }

		string ItemStatusId { get; set; }

		decimal? Quantity { get; set; }

		long Version { get; set; }

		bool Active { get; set; }

		string PicklistBinPicklistId { get; set; }

		long? PicklistBinBinLocationNumber { get; set; }

		string PicklistBinPrimaryOrderId { get; set; }

		long? PicklistBinPrimaryShipGroupSeqId { get; set; }

		long PicklistBinVersion { get; set; }

		string PicklistBinCreatedBy { get; set; }

		DateTime PicklistBinCreatedAt { get; set; }

		string PicklistBinUpdatedBy { get; set; }

		DateTime PicklistBinUpdatedAt { get; set; }

		bool PicklistBinActive { get; set; }

		bool PicklistBinDeleted { get; set; }

	}

}