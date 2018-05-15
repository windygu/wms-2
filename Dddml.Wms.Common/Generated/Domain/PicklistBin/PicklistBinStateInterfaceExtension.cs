﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePicklistBinDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PicklistBin;

namespace Dddml.Wms.Domain.PicklistBin
{

	public static partial class PicklistBinStateInterfaceExtension
	{

        public static IPicklistBinCommand ToCreateOrMergePatchPicklistBin<TCreatePicklistBin, TMergePatchPicklistBin, TCreatePicklistItem, TMergePatchPicklistItem>(this IPicklistBinState state)
            where TCreatePicklistBin : ICreatePicklistBin, new()
            where TMergePatchPicklistBin : IMergePatchPicklistBin, new()
            where TCreatePicklistItem : ICreatePicklistItem, new()
            where TMergePatchPicklistItem : IMergePatchPicklistItem, new()
        {
            bool bUnsaved = ((IPicklistBinState)state).IsUnsaved;
            if (bUnsaved)
            {
                return state.ToCreatePicklistBin<TCreatePicklistBin, TCreatePicklistItem>();
            }
            else 
            {
                return state.ToMergePatchPicklistBin<TMergePatchPicklistBin, TCreatePicklistItem, TMergePatchPicklistItem>();
            }
        }

        public static TDeletePicklistBin ToDeletePicklistBin<TDeletePicklistBin>(this IPicklistBinState state)
            where TDeletePicklistBin : IDeletePicklistBin, new()
        {
            var cmd = new TDeletePicklistBin();
            cmd.PicklistBinId = state.PicklistBinId;
            cmd.Version = ((IPicklistBinStateProperties)state).Version;

            return cmd;
        }

        public static TMergePatchPicklistBin ToMergePatchPicklistBin<TMergePatchPicklistBin, TCreatePicklistItem, TMergePatchPicklistItem>(this IPicklistBinState state)
            where TMergePatchPicklistBin : IMergePatchPicklistBin, new()
            where TCreatePicklistItem : ICreatePicklistItem, new()
            where TMergePatchPicklistItem : IMergePatchPicklistItem, new()
        {
            var cmd = new TMergePatchPicklistBin();

            cmd.Version = ((IPicklistBinStateProperties)state).Version;

            cmd.PicklistBinId = state.PicklistBinId;
            cmd.PicklistId = state.PicklistId;
            cmd.BinLocationNumber = state.BinLocationNumber;
            cmd.PrimaryOrderId = state.PrimaryOrderId;
            cmd.PrimaryShipGroupSeqId = state.PrimaryShipGroupSeqId;
            cmd.Active = ((IPicklistBinStateProperties)state).Active;
            
            if (state.PicklistId == null) { cmd.IsPropertyPicklistIdRemoved = true; }
            if (state.BinLocationNumber == null) { cmd.IsPropertyBinLocationNumberRemoved = true; }
            if (state.PrimaryOrderId == null) { cmd.IsPropertyPrimaryOrderIdRemoved = true; }
            if (state.PrimaryShipGroupSeqId == null) { cmd.IsPropertyPrimaryShipGroupSeqIdRemoved = true; }
            foreach (var d in state.PicklistItems)
            {
                var c = d.ToCreateOrMergePatchPicklistItem<TCreatePicklistItem, TMergePatchPicklistItem>();
                cmd.PicklistItemCommands.Add(c);
            }
            return cmd;
        }

        public static TCreatePicklistBin ToCreatePicklistBin<TCreatePicklistBin, TCreatePicklistItem>(this IPicklistBinState state)
            where TCreatePicklistBin : ICreatePicklistBin, new()
            where TCreatePicklistItem : ICreatePicklistItem, new()
        {
            var cmd = new TCreatePicklistBin();

            cmd.Version = ((IPicklistBinStateProperties)state).Version;

            cmd.PicklistBinId = state.PicklistBinId;
            cmd.PicklistId = state.PicklistId;
            cmd.BinLocationNumber = state.BinLocationNumber;
            cmd.PrimaryOrderId = state.PrimaryOrderId;
            cmd.PrimaryShipGroupSeqId = state.PrimaryShipGroupSeqId;
            cmd.Active = ((IPicklistBinStateProperties)state).Active;
            foreach (var d in state.PicklistItems)
            {
                var c = d.ToCreatePicklistItem<TCreatePicklistItem>();
                cmd.PicklistItems.Add(c);
            }
            return cmd;
        }
		

	}

}
