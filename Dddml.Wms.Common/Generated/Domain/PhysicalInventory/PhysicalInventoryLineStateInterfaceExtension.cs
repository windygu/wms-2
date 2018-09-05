﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePhysicalInventoryDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PhysicalInventory;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.PhysicalInventory
{

	public static partial class PhysicalInventoryLineStateInterfaceExtension
	{

        public static IPhysicalInventoryLineCommand ToCreateOrMergePatchPhysicalInventoryLine<TCreatePhysicalInventoryLine, TMergePatchPhysicalInventoryLine>(this IPhysicalInventoryLineState state)
            where TCreatePhysicalInventoryLine : ICreatePhysicalInventoryLine, new()
            where TMergePatchPhysicalInventoryLine : IMergePatchPhysicalInventoryLine, new()
        {
            bool bUnsaved = ((IPhysicalInventoryLineState)state).IsUnsaved;
            if (bUnsaved)
            {
                return state.ToCreatePhysicalInventoryLine<TCreatePhysicalInventoryLine>();
            }
            else 
            {
                return state.ToMergePatchPhysicalInventoryLine<TMergePatchPhysicalInventoryLine>();
            }
        }

        public static TRemovePhysicalInventoryLine ToRemovePhysicalInventoryLine<TRemovePhysicalInventoryLine>(this IPhysicalInventoryLineState state)
            where TRemovePhysicalInventoryLine : IRemovePhysicalInventoryLine, new()
        {
            var cmd = new TRemovePhysicalInventoryLine();
            cmd.InventoryItemId = state.InventoryItemId;
            return cmd;
        }

        public static TMergePatchPhysicalInventoryLine ToMergePatchPhysicalInventoryLine<TMergePatchPhysicalInventoryLine>(this IPhysicalInventoryLineState state)
            where TMergePatchPhysicalInventoryLine : IMergePatchPhysicalInventoryLine, new()
        {
            var cmd = new TMergePatchPhysicalInventoryLine();

            cmd.InventoryItemId = state.InventoryItemId;
            cmd.BookQuantity = state.BookQuantity;
            cmd.CountedQuantity = state.CountedQuantity;
            cmd.Processed = state.Processed;
            cmd.LineNumber = state.LineNumber;
            cmd.ReversalLineNumber = state.ReversalLineNumber;
            cmd.Description = state.Description;
            cmd.PhysicalInventoryDocumentNumber = state.PhysicalInventoryDocumentNumber;
            
            if (state.LineNumber == null) { cmd.IsPropertyLineNumberRemoved = true; }
            if (state.ReversalLineNumber == null) { cmd.IsPropertyReversalLineNumberRemoved = true; }
            if (state.Description == null) { cmd.IsPropertyDescriptionRemoved = true; }
            return cmd;
        }

        public static TCreatePhysicalInventoryLine ToCreatePhysicalInventoryLine<TCreatePhysicalInventoryLine>(this IPhysicalInventoryLineState state)
            where TCreatePhysicalInventoryLine : ICreatePhysicalInventoryLine, new()
        {
            var cmd = new TCreatePhysicalInventoryLine();

            cmd.InventoryItemId = state.InventoryItemId;
            cmd.BookQuantity = state.BookQuantity;
            cmd.CountedQuantity = state.CountedQuantity;
            cmd.Processed = state.Processed;
            cmd.LineNumber = state.LineNumber;
            cmd.ReversalLineNumber = state.ReversalLineNumber;
            cmd.Description = state.Description;
            cmd.PhysicalInventoryDocumentNumber = state.PhysicalInventoryDocumentNumber;
            return cmd;
        }
		

	}

}

