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

	public static partial class OrderShipGroupStateInterfaceExtension
	{

        public static IOrderShipGroupCommand ToCreateOrMergePatchOrderShipGroup<TCreateOrderShipGroup, TMergePatchOrderShipGroup>(this IOrderShipGroupState state)
            where TCreateOrderShipGroup : ICreateOrderShipGroup, new()
            where TMergePatchOrderShipGroup : IMergePatchOrderShipGroup, new()
        {
            bool bUnsaved = ((IOrderShipGroupState)state).IsUnsaved;
            if (bUnsaved)
            {
                return state.ToCreateOrderShipGroup<TCreateOrderShipGroup>();
            }
            else 
            {
                return state.ToMergePatchOrderShipGroup<TMergePatchOrderShipGroup>();
            }
        }

        public static TRemoveOrderShipGroup ToRemoveOrderShipGroup<TRemoveOrderShipGroup>(this IOrderShipGroupState state)
            where TRemoveOrderShipGroup : IRemoveOrderShipGroup, new()
        {
            var cmd = new TRemoveOrderShipGroup();
            cmd.ShipGroupSeqId = state.ShipGroupSeqId;
            return cmd;
        }

        public static TMergePatchOrderShipGroup ToMergePatchOrderShipGroup<TMergePatchOrderShipGroup>(this IOrderShipGroupState state)
            where TMergePatchOrderShipGroup : IMergePatchOrderShipGroup, new()
        {
            var cmd = new TMergePatchOrderShipGroup();

            cmd.ShipGroupSeqId = state.ShipGroupSeqId;
            cmd.ShipmentMethodTypeId = state.ShipmentMethodTypeId;
            cmd.SupplierPartyId = state.SupplierPartyId;
            cmd.VendorPartyId = state.VendorPartyId;
            cmd.CarrierPartyId = state.CarrierPartyId;
            cmd.CarrierRoleTypeId = state.CarrierRoleTypeId;
            cmd.FacilityId = state.FacilityId;
            cmd.ContactMechId = state.ContactMechId;
            cmd.TelecomContactMechId = state.TelecomContactMechId;
            cmd.TrackingNumber = state.TrackingNumber;
            cmd.ShippingInstructions = state.ShippingInstructions;
            cmd.MaySplit = state.MaySplit;
            cmd.GiftMessage = state.GiftMessage;
            cmd.IsGift = state.IsGift;
            cmd.ShipAfterDate = state.ShipAfterDate;
            cmd.ShipByDate = state.ShipByDate;
            cmd.EstimatedShipDate = state.EstimatedShipDate;
            cmd.EstimatedDeliveryDate = state.EstimatedDeliveryDate;
            cmd.PickwaveId = state.PickwaveId;
            cmd.Active = ((IOrderShipGroupStateProperties)state).Active;
            cmd.OrderId = state.OrderId;
            
            if (state.ShipmentMethodTypeId == null) { cmd.IsPropertyShipmentMethodTypeIdRemoved = true; }
            if (state.SupplierPartyId == null) { cmd.IsPropertySupplierPartyIdRemoved = true; }
            if (state.VendorPartyId == null) { cmd.IsPropertyVendorPartyIdRemoved = true; }
            if (state.CarrierPartyId == null) { cmd.IsPropertyCarrierPartyIdRemoved = true; }
            if (state.CarrierRoleTypeId == null) { cmd.IsPropertyCarrierRoleTypeIdRemoved = true; }
            if (state.FacilityId == null) { cmd.IsPropertyFacilityIdRemoved = true; }
            if (state.ContactMechId == null) { cmd.IsPropertyContactMechIdRemoved = true; }
            if (state.TelecomContactMechId == null) { cmd.IsPropertyTelecomContactMechIdRemoved = true; }
            if (state.TrackingNumber == null) { cmd.IsPropertyTrackingNumberRemoved = true; }
            if (state.ShippingInstructions == null) { cmd.IsPropertyShippingInstructionsRemoved = true; }
            if (state.MaySplit == null) { cmd.IsPropertyMaySplitRemoved = true; }
            if (state.GiftMessage == null) { cmd.IsPropertyGiftMessageRemoved = true; }
            if (state.IsGift == null) { cmd.IsPropertyIsGiftRemoved = true; }
            if (state.ShipAfterDate == null) { cmd.IsPropertyShipAfterDateRemoved = true; }
            if (state.ShipByDate == null) { cmd.IsPropertyShipByDateRemoved = true; }
            if (state.EstimatedShipDate == null) { cmd.IsPropertyEstimatedShipDateRemoved = true; }
            if (state.EstimatedDeliveryDate == null) { cmd.IsPropertyEstimatedDeliveryDateRemoved = true; }
            if (state.PickwaveId == null) { cmd.IsPropertyPickwaveIdRemoved = true; }
            return cmd;
        }

        public static TCreateOrderShipGroup ToCreateOrderShipGroup<TCreateOrderShipGroup>(this IOrderShipGroupState state)
            where TCreateOrderShipGroup : ICreateOrderShipGroup, new()
        {
            var cmd = new TCreateOrderShipGroup();

            cmd.ShipGroupSeqId = state.ShipGroupSeqId;
            cmd.ShipmentMethodTypeId = state.ShipmentMethodTypeId;
            cmd.SupplierPartyId = state.SupplierPartyId;
            cmd.VendorPartyId = state.VendorPartyId;
            cmd.CarrierPartyId = state.CarrierPartyId;
            cmd.CarrierRoleTypeId = state.CarrierRoleTypeId;
            cmd.FacilityId = state.FacilityId;
            cmd.ContactMechId = state.ContactMechId;
            cmd.TelecomContactMechId = state.TelecomContactMechId;
            cmd.TrackingNumber = state.TrackingNumber;
            cmd.ShippingInstructions = state.ShippingInstructions;
            cmd.MaySplit = state.MaySplit;
            cmd.GiftMessage = state.GiftMessage;
            cmd.IsGift = state.IsGift;
            cmd.ShipAfterDate = state.ShipAfterDate;
            cmd.ShipByDate = state.ShipByDate;
            cmd.EstimatedShipDate = state.EstimatedShipDate;
            cmd.EstimatedDeliveryDate = state.EstimatedDeliveryDate;
            cmd.PickwaveId = state.PickwaveId;
            cmd.Active = ((IOrderShipGroupStateProperties)state).Active;
            cmd.OrderId = state.OrderId;
            return cmd;
        }
		

	}

}

