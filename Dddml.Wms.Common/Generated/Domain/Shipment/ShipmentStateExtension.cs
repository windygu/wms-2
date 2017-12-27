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

	public static partial class ShipmentStateExtension
	{

        public static IShipmentCommand ToCreateOrMergePatchShipment(this ShipmentState state)
        {
            return state.ToCreateOrMergePatchShipment<CreateShipment, MergePatchShipment, CreateShipmentItem, MergePatchShipmentItem>();
        }

        public static DeleteShipment ToDeleteShipment(this ShipmentState state)
        {
            return state.ToDeleteShipment<DeleteShipment>();
        }

        public static MergePatchShipment ToMergePatchShipment(this ShipmentState state)
        {
            return state.ToMergePatchShipment<MergePatchShipment, CreateShipmentItem, MergePatchShipmentItem>();
        }

        public static CreateShipment ToCreateShipment(this ShipmentState state)
        {
            return state.ToCreateShipment<CreateShipment, CreateShipmentItem>();
        }
		

	}

}
