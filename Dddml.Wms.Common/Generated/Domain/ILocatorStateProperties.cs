﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;

namespace Dddml.Wms.Domain
{

	public interface ILocatorStateProperties
	{
		string LocatorId { get; set; }

		string WarehouseId { get; set; }

		string ParentLocatorId { get; set; }

		string LocatorType { get; set; }

		string PriorityNumber { get; set; }

		bool IsDefault { get; set; }

		string X { get; set; }

		string Y { get; set; }

		string Z { get; set; }

		long Version { get; set; }

		bool Active { get; set; }


	}

}
