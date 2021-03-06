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

	public static partial class ShipmentReceiptImageStateExtension
	{

        public static IShipmentReceiptImageCommand ToCreateOrMergePatchShipmentReceiptImage(this ShipmentReceiptImageState state)
        {
            return state.ToCreateOrMergePatchShipmentReceiptImage<CreateShipmentReceiptImage, MergePatchShipmentReceiptImage>();
        }

        public static RemoveShipmentReceiptImage ToRemoveShipmentReceiptImage(this ShipmentReceiptImageState state)
        {
            return state.ToRemoveShipmentReceiptImage<RemoveShipmentReceiptImage>();
        }

        public static MergePatchShipmentReceiptImage ToMergePatchShipmentReceiptImage(this ShipmentReceiptImageState state)
        {
            return state.ToMergePatchShipmentReceiptImage<MergePatchShipmentReceiptImage>();
        }

        public static CreateShipmentReceiptImage ToCreateShipmentReceiptImage(this ShipmentReceiptImageState state)
        {
            return state.ToCreateShipmentReceiptImage<CreateShipmentReceiptImage>();
        }
		

	}

}

