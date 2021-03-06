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

	public static partial class ShipmentImageStateExtension
	{

        public static IShipmentImageCommand ToCreateOrMergePatchShipmentImage(this ShipmentImageState state)
        {
            return state.ToCreateOrMergePatchShipmentImage<CreateShipmentImage, MergePatchShipmentImage>();
        }

        public static RemoveShipmentImage ToRemoveShipmentImage(this ShipmentImageState state)
        {
            return state.ToRemoveShipmentImage<RemoveShipmentImage>();
        }

        public static MergePatchShipmentImage ToMergePatchShipmentImage(this ShipmentImageState state)
        {
            return state.ToMergePatchShipmentImage<MergePatchShipmentImage>();
        }

        public static CreateShipmentImage ToCreateShipmentImage(this ShipmentImageState state)
        {
            return state.ToCreateShipmentImage<CreateShipmentImage>();
        }
		

	}

}

