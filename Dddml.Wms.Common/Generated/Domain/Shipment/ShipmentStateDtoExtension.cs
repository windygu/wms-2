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

	public static partial class ShipmentStateDtoExtension
	{

        public static IShipmentCommand ToCreateOrMergePatchShipment(this ShipmentStateDtoWrapper state)
        {
            return state.ToCreateOrMergePatchShipment<CreateShipmentDto, MergePatchShipmentDto, CreateShipmentItemDto, MergePatchShipmentItemDto>();
        }

        public static DeleteShipmentDto ToDeleteShipment(this ShipmentStateDtoWrapper state)
        {
            return state.ToDeleteShipment<DeleteShipmentDto>();
        }

        public static MergePatchShipmentDto ToMergePatchShipment(this ShipmentStateDtoWrapper state)
        {
            return state.ToMergePatchShipment<MergePatchShipmentDto, CreateShipmentItemDto, MergePatchShipmentItemDto>();
        }

        public static CreateShipmentDto ToCreateShipment(this ShipmentStateDtoWrapper state)
        {
            return state.ToCreateShipment<CreateShipmentDto, CreateShipmentItemDto>();
        }
		

	}

}

