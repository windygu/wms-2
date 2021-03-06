﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateFacilityDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Facility;

namespace Dddml.Wms.Domain.Facility
{

	public static partial class FacilityStateInterfaceExtension
	{

        public static IFacilityCommand ToCreateOrMergePatchFacility<TCreateFacility, TMergePatchFacility>(this IFacilityState state)
            where TCreateFacility : ICreateFacility, new()
            where TMergePatchFacility : IMergePatchFacility, new()
        {
            bool bUnsaved = ((IFacilityState)state).IsUnsaved;
            if (bUnsaved)
            {
                return state.ToCreateFacility<TCreateFacility>();
            }
            else 
            {
                return state.ToMergePatchFacility<TMergePatchFacility>();
            }
        }

        public static TDeleteFacility ToDeleteFacility<TDeleteFacility>(this IFacilityState state)
            where TDeleteFacility : IDeleteFacility, new()
        {
            var cmd = new TDeleteFacility();
            cmd.FacilityId = state.FacilityId;
            cmd.Version = ((IFacilityStateProperties)state).Version;

            return cmd;
        }

        public static TMergePatchFacility ToMergePatchFacility<TMergePatchFacility>(this IFacilityState state)
            where TMergePatchFacility : IMergePatchFacility, new()
        {
            var cmd = new TMergePatchFacility();

            cmd.Version = ((IFacilityStateProperties)state).Version;

            cmd.FacilityId = state.FacilityId;
            cmd.FacilityTypeId = state.FacilityTypeId;
            cmd.ParentFacilityId = state.ParentFacilityId;
            cmd.OwnerPartyId = state.OwnerPartyId;
            cmd.DefaultInventoryItemTypeId = state.DefaultInventoryItemTypeId;
            cmd.FacilityName = state.FacilityName;
            cmd.PrimaryFacilityGroupId = state.PrimaryFacilityGroupId;
            cmd.OldSquareFootage = state.OldSquareFootage;
            cmd.FacilitySize = state.FacilitySize;
            cmd.FacilitySizeUomId = state.FacilitySizeUomId;
            cmd.ProductStoreId = state.ProductStoreId;
            cmd.DefaultDaysToShip = state.DefaultDaysToShip;
            cmd.OpenedDate = state.OpenedDate;
            cmd.ClosedDate = state.ClosedDate;
            cmd.Description = state.Description;
            cmd.DefaultDimensionUomId = state.DefaultDimensionUomId;
            cmd.DefaultWeightUomId = state.DefaultWeightUomId;
            cmd.GeoPointId = state.GeoPointId;
            cmd.Active = ((IFacilityStateProperties)state).Active;
            
            if (state.FacilityTypeId == null) { cmd.IsPropertyFacilityTypeIdRemoved = true; }
            if (state.ParentFacilityId == null) { cmd.IsPropertyParentFacilityIdRemoved = true; }
            if (state.OwnerPartyId == null) { cmd.IsPropertyOwnerPartyIdRemoved = true; }
            if (state.DefaultInventoryItemTypeId == null) { cmd.IsPropertyDefaultInventoryItemTypeIdRemoved = true; }
            if (state.FacilityName == null) { cmd.IsPropertyFacilityNameRemoved = true; }
            if (state.PrimaryFacilityGroupId == null) { cmd.IsPropertyPrimaryFacilityGroupIdRemoved = true; }
            if (state.OldSquareFootage == null) { cmd.IsPropertyOldSquareFootageRemoved = true; }
            if (state.FacilitySize == null) { cmd.IsPropertyFacilitySizeRemoved = true; }
            if (state.FacilitySizeUomId == null) { cmd.IsPropertyFacilitySizeUomIdRemoved = true; }
            if (state.ProductStoreId == null) { cmd.IsPropertyProductStoreIdRemoved = true; }
            if (state.DefaultDaysToShip == null) { cmd.IsPropertyDefaultDaysToShipRemoved = true; }
            if (state.OpenedDate == null) { cmd.IsPropertyOpenedDateRemoved = true; }
            if (state.ClosedDate == null) { cmd.IsPropertyClosedDateRemoved = true; }
            if (state.Description == null) { cmd.IsPropertyDescriptionRemoved = true; }
            if (state.DefaultDimensionUomId == null) { cmd.IsPropertyDefaultDimensionUomIdRemoved = true; }
            if (state.DefaultWeightUomId == null) { cmd.IsPropertyDefaultWeightUomIdRemoved = true; }
            if (state.GeoPointId == null) { cmd.IsPropertyGeoPointIdRemoved = true; }
            return cmd;
        }

        public static TCreateFacility ToCreateFacility<TCreateFacility>(this IFacilityState state)
            where TCreateFacility : ICreateFacility, new()
        {
            var cmd = new TCreateFacility();

            cmd.Version = ((IFacilityStateProperties)state).Version;

            cmd.FacilityId = state.FacilityId;
            cmd.FacilityTypeId = state.FacilityTypeId;
            cmd.ParentFacilityId = state.ParentFacilityId;
            cmd.OwnerPartyId = state.OwnerPartyId;
            cmd.DefaultInventoryItemTypeId = state.DefaultInventoryItemTypeId;
            cmd.FacilityName = state.FacilityName;
            cmd.PrimaryFacilityGroupId = state.PrimaryFacilityGroupId;
            cmd.OldSquareFootage = state.OldSquareFootage;
            cmd.FacilitySize = state.FacilitySize;
            cmd.FacilitySizeUomId = state.FacilitySizeUomId;
            cmd.ProductStoreId = state.ProductStoreId;
            cmd.DefaultDaysToShip = state.DefaultDaysToShip;
            cmd.OpenedDate = state.OpenedDate;
            cmd.ClosedDate = state.ClosedDate;
            cmd.Description = state.Description;
            cmd.DefaultDimensionUomId = state.DefaultDimensionUomId;
            cmd.DefaultWeightUomId = state.DefaultWeightUomId;
            cmd.GeoPointId = state.GeoPointId;
            cmd.Active = ((IFacilityStateProperties)state).Active;
            return cmd;
        }
		

	}

}

