﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateShipmentMethodTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ShipmentMethodType;

namespace Dddml.Wms.Domain.ShipmentMethodType
{

	public static partial class ShipmentMethodTypeStateInterfaceExtension
	{

        public static IShipmentMethodTypeCommand ToCreateOrMergePatchShipmentMethodType<TCreateShipmentMethodType, TMergePatchShipmentMethodType>(this IShipmentMethodTypeState state)
            where TCreateShipmentMethodType : ICreateShipmentMethodType, new()
            where TMergePatchShipmentMethodType : IMergePatchShipmentMethodType, new()
        {
            bool bUnsaved = ((IShipmentMethodTypeState)state).IsUnsaved;
            if (bUnsaved)
            {
                return state.ToCreateShipmentMethodType<TCreateShipmentMethodType>();
            }
            else 
            {
                return state.ToMergePatchShipmentMethodType<TMergePatchShipmentMethodType>();
            }
        }

        public static TDeleteShipmentMethodType ToDeleteShipmentMethodType<TDeleteShipmentMethodType>(this IShipmentMethodTypeState state)
            where TDeleteShipmentMethodType : IDeleteShipmentMethodType, new()
        {
            var cmd = new TDeleteShipmentMethodType();
            cmd.ShipmentMethodTypeId = state.ShipmentMethodTypeId;
            cmd.Version = ((IShipmentMethodTypeStateProperties)state).Version;

            return cmd;
        }

        public static TMergePatchShipmentMethodType ToMergePatchShipmentMethodType<TMergePatchShipmentMethodType>(this IShipmentMethodTypeState state)
            where TMergePatchShipmentMethodType : IMergePatchShipmentMethodType, new()
        {
            var cmd = new TMergePatchShipmentMethodType();

            cmd.Version = ((IShipmentMethodTypeStateProperties)state).Version;

            cmd.ShipmentMethodTypeId = state.ShipmentMethodTypeId;
            cmd.Description = state.Description;
            cmd.SequenceNum = state.SequenceNum;
            cmd.Active = ((IShipmentMethodTypeStateProperties)state).Active;
            
            if (state.Description == null) { cmd.IsPropertyDescriptionRemoved = true; }
            if (state.SequenceNum == null) { cmd.IsPropertySequenceNumRemoved = true; }
            return cmd;
        }

        public static TCreateShipmentMethodType ToCreateShipmentMethodType<TCreateShipmentMethodType>(this IShipmentMethodTypeState state)
            where TCreateShipmentMethodType : ICreateShipmentMethodType, new()
        {
            var cmd = new TCreateShipmentMethodType();

            cmd.Version = ((IShipmentMethodTypeStateProperties)state).Version;

            cmd.ShipmentMethodTypeId = state.ShipmentMethodTypeId;
            cmd.Description = state.Description;
            cmd.SequenceNum = state.SequenceNum;
            cmd.Active = ((IShipmentMethodTypeStateProperties)state).Active;
            return cmd;
        }
		

	}

}
