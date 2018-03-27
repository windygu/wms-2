﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePicklistRoleMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PicklistRoleMvo;
using Dddml.Wms.Domain.Picklist;

namespace Dddml.Wms.Domain.PicklistRoleMvo
{

	public interface IPicklistRoleMvoStateProperties
	{
		PicklistRoleId PicklistRoleId { get; set; }

		long Version { get; set; }

		bool Active { get; set; }

		string PicklistDescription { get; set; }

		string PicklistFacilityId { get; set; }

		string PicklistShipmentMethodTypeId { get; set; }

		string PicklistStatusId { get; set; }

		DateTime? PicklistPicklistDate { get; set; }

		string PicklistCreatedByUserLogin { get; set; }

		string PicklistLastModifiedByUserLogin { get; set; }

		long? PicklistPickwaveId { get; set; }

		long PicklistVersion { get; set; }

		DateTime PicklistCreatedAt { get; set; }

		DateTime PicklistUpdatedAt { get; set; }

		bool PicklistActive { get; set; }

		bool PicklistDeleted { get; set; }

	}

}
