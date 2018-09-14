﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInOutNoticeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InOutNotice;

namespace Dddml.Wms.Domain.InOutNotice
{
	public interface IInOutNoticeCommand : IAggregateCommand<string, long>, ICommandDto
	{
		long Version { get; set; }

		string InOutNoticeId { get; set; }

	}


	public interface ICreateOrMergePatchOrDeleteInOutNotice : IInOutNoticeCommand
	{

		string WarehouseId { get; set; }

		string InOutNoticeType { get; set; }

		string TelecomContactMechId { get; set; }

		string TrackingNumber { get; set; }

		string ContactPartyId { get; set; }

		string VehiclePlateNumber { get; set; }

		string ShippingInstructions { get; set; }

		DateTime? EstimatedShipDate { get; set; }

		DateTime? EstimatedDeliveryDate { get; set; }

		bool? Active { get; set; }


	}

	public interface ICreateInOutNotice : ICreateOrMergePatchOrDeleteInOutNotice
	{
	}

	public interface IMergePatchInOutNotice : ICreateOrMergePatchOrDeleteInOutNotice
	{

		bool IsPropertyWarehouseIdRemoved { get; set; }

		bool IsPropertyInOutNoticeTypeRemoved { get; set; }

		bool IsPropertyTelecomContactMechIdRemoved { get; set; }

		bool IsPropertyTrackingNumberRemoved { get; set; }

		bool IsPropertyContactPartyIdRemoved { get; set; }

		bool IsPropertyVehiclePlateNumberRemoved { get; set; }

		bool IsPropertyShippingInstructionsRemoved { get; set; }

		bool IsPropertyEstimatedShipDateRemoved { get; set; }

		bool IsPropertyEstimatedDeliveryDateRemoved { get; set; }

		bool IsPropertyActiveRemoved { get; set; }


	}

	public interface IDeleteInOutNotice : ICreateOrMergePatchOrDeleteInOutNotice
	{
	}


}

