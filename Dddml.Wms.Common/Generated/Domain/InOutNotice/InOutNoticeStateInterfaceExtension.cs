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

	public static partial class InOutNoticeStateInterfaceExtension
	{

        public static IInOutNoticeCommand ToCreateOrMergePatchInOutNotice<TCreateInOutNotice, TMergePatchInOutNotice>(this IInOutNoticeState state)
            where TCreateInOutNotice : ICreateInOutNotice, new()
            where TMergePatchInOutNotice : IMergePatchInOutNotice, new()
        {
            bool bUnsaved = ((IInOutNoticeState)state).IsUnsaved;
            if (bUnsaved)
            {
                return state.ToCreateInOutNotice<TCreateInOutNotice>();
            }
            else 
            {
                return state.ToMergePatchInOutNotice<TMergePatchInOutNotice>();
            }
        }

        public static TDeleteInOutNotice ToDeleteInOutNotice<TDeleteInOutNotice>(this IInOutNoticeState state)
            where TDeleteInOutNotice : IDeleteInOutNotice, new()
        {
            var cmd = new TDeleteInOutNotice();
            cmd.InOutNoticeId = state.InOutNoticeId;
            cmd.Version = ((IInOutNoticeStateProperties)state).Version;

            return cmd;
        }

        public static TMergePatchInOutNotice ToMergePatchInOutNotice<TMergePatchInOutNotice>(this IInOutNoticeState state)
            where TMergePatchInOutNotice : IMergePatchInOutNotice, new()
        {
            var cmd = new TMergePatchInOutNotice();

            cmd.Version = ((IInOutNoticeStateProperties)state).Version;

            cmd.InOutNoticeId = state.InOutNoticeId;
            cmd.WarehouseId = state.WarehouseId;
            cmd.InOutNoticeType = state.InOutNoticeType;
            cmd.TelecomContactMechId = state.TelecomContactMechId;
            cmd.TrackingNumber = state.TrackingNumber;
            cmd.ContactPartyId = state.ContactPartyId;
            cmd.VehiclePlateNumber = state.VehiclePlateNumber;
            cmd.ShippingInstructions = state.ShippingInstructions;
            cmd.EstimatedShipDate = state.EstimatedShipDate;
            cmd.EstimatedDeliveryDate = state.EstimatedDeliveryDate;
            cmd.IsScheduleNeeded = state.IsScheduleNeeded;
            cmd.Active = ((IInOutNoticeStateProperties)state).Active;
            
            if (state.WarehouseId == null) { cmd.IsPropertyWarehouseIdRemoved = true; }
            if (state.InOutNoticeType == null) { cmd.IsPropertyInOutNoticeTypeRemoved = true; }
            if (state.TelecomContactMechId == null) { cmd.IsPropertyTelecomContactMechIdRemoved = true; }
            if (state.TrackingNumber == null) { cmd.IsPropertyTrackingNumberRemoved = true; }
            if (state.ContactPartyId == null) { cmd.IsPropertyContactPartyIdRemoved = true; }
            if (state.VehiclePlateNumber == null) { cmd.IsPropertyVehiclePlateNumberRemoved = true; }
            if (state.ShippingInstructions == null) { cmd.IsPropertyShippingInstructionsRemoved = true; }
            if (state.EstimatedShipDate == null) { cmd.IsPropertyEstimatedShipDateRemoved = true; }
            if (state.EstimatedDeliveryDate == null) { cmd.IsPropertyEstimatedDeliveryDateRemoved = true; }
            return cmd;
        }

        public static TCreateInOutNotice ToCreateInOutNotice<TCreateInOutNotice>(this IInOutNoticeState state)
            where TCreateInOutNotice : ICreateInOutNotice, new()
        {
            var cmd = new TCreateInOutNotice();

            cmd.Version = ((IInOutNoticeStateProperties)state).Version;

            cmd.InOutNoticeId = state.InOutNoticeId;
            cmd.WarehouseId = state.WarehouseId;
            cmd.InOutNoticeType = state.InOutNoticeType;
            cmd.TelecomContactMechId = state.TelecomContactMechId;
            cmd.TrackingNumber = state.TrackingNumber;
            cmd.ContactPartyId = state.ContactPartyId;
            cmd.VehiclePlateNumber = state.VehiclePlateNumber;
            cmd.ShippingInstructions = state.ShippingInstructions;
            cmd.EstimatedShipDate = state.EstimatedShipDate;
            cmd.EstimatedDeliveryDate = state.EstimatedDeliveryDate;
            cmd.IsScheduleNeeded = state.IsScheduleNeeded;
            cmd.Active = ((IInOutNoticeStateProperties)state).Active;
            return cmd;
        }
		

	}

}

