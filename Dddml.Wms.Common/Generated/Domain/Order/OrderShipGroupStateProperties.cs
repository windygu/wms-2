﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrderDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Order;
using Dddml.Wms.Domain.PartyRole;

namespace Dddml.Wms.Domain.Order
{

	public abstract class OrderShipGroupStateProperties : IOrderShipGroupStateProperties
	{
		public virtual string ShipGroupSeqId { get; set; }

		public virtual string ShipmentMethodTypeId { get; set; }

		public virtual string SupplierPartyId { get; set; }

		public virtual string VendorPartyId { get; set; }

		public virtual string CarrierPartyId { get; set; }

		public virtual string CarrierRoleTypeId { get; set; }

		public virtual string FacilityId { get; set; }

		public virtual string DestinationFacilityId { get; set; }

		public virtual string ContactMechId { get; set; }

		public virtual string TelecomContactMechId { get; set; }

		public virtual string TrackingNumber { get; set; }

		public virtual string ContactPartyId { get; set; }

		public virtual string VehiclePlateNumber { get; set; }

		public virtual string ShippingInstructions { get; set; }

		public virtual string MaySplit { get; set; }

		public virtual string GiftMessage { get; set; }

		public virtual string IsGift { get; set; }

		public virtual DateTime? ShipAfterDate { get; set; }

		public virtual DateTime? ShipByDate { get; set; }

		public virtual DateTime? EstimatedShipDate { get; set; }

		public virtual DateTime? EstimatedDeliveryDate { get; set; }

		public virtual long? PickwaveId { get; set; }

		public virtual int NumberOfPackages { get; set; }

		public virtual int NumberOfContainers { get; set; }

		public virtual int NumberOfPakagesPerContainer { get; set; }

		public virtual string OrderShipGroupStatusId { get; set; }

		public virtual long Version { get; set; }

		public virtual bool Active { get; set; }

		// Outer Id:

		public virtual string OrderId { get; set; }

        protected virtual void InitializeProperties()
        { 
        }

	}
}
