﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateShipmentDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Shipment;

namespace Dddml.Wms.Domain.Shipment
{

	public abstract class ShipmentStateProperties : IShipmentStateProperties
	{
		public virtual string ShipmentId { get; set; }

		public virtual string ShipmentTypeId { get; set; }

		public virtual string StatusId { get; set; }

		public virtual string PrimaryOrderId { get; set; }

		public virtual string PrimaryReturnId { get; set; }

		public virtual string PrimaryShipGroupSeqId { get; set; }

		public virtual string PicklistBinId { get; set; }

		public virtual string BolNumber { get; set; }

		public virtual string SealNumber { get; set; }

		public virtual string VehicleId { get; set; }

		public virtual string ExternalOrderNumber { get; set; }

		public virtual string Carrier { get; set; }

		public virtual DateTime? DateShipped { get; set; }

		public virtual DateTime? EstimatedReadyDate { get; set; }

		public virtual DateTime? EstimatedShipDate { get; set; }

		public virtual string EstimatedShipWorkEffId { get; set; }

		public virtual DateTime? EstimatedArrivalDate { get; set; }

		public virtual string EstimatedArrivalWorkEffId { get; set; }

		public virtual DateTime? LatestCancelDate { get; set; }

		public virtual decimal? EstimatedShipCost { get; set; }

		public virtual string CurrencyUomId { get; set; }

		public virtual string HandlingInstructions { get; set; }

		public virtual string OriginFacilityId { get; set; }

		public virtual string DestinationFacilityId { get; set; }

		public virtual string OriginContactMechId { get; set; }

		public virtual string OriginTelecomNumberId { get; set; }

		public virtual string DestinationContactMechId { get; set; }

		public virtual string DestinationTelecomNumberId { get; set; }

		public virtual string PartyIdTo { get; set; }

		public virtual string PartyIdFrom { get; set; }

		public virtual decimal? AdditionalShippingCharge { get; set; }

		public virtual string AddtlShippingChargeDesc { get; set; }

		public virtual long Version { get; set; }

		public virtual bool Active { get; set; }

        protected virtual void InitializeProperties()
        { 
        }

	}
}
