﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryItemRequirementEntryMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryItemRequirementEntryMvo;
using Dddml.Wms.Domain.InventoryItemRequirement;
using Dddml.Wms.Domain.InventoryPRTriggered;

namespace Dddml.Wms.Domain.InventoryItemRequirementEntryMvo
{

	public static partial class InventoryItemRequirementEntryMvoStateInterfaceExtension
	{

        public static IInventoryItemRequirementEntryMvoCommand ToCreateOrMergePatchInventoryItemRequirementEntryMvo<TCreateInventoryItemRequirementEntryMvo, TMergePatchInventoryItemRequirementEntryMvo>(this IInventoryItemRequirementEntryMvoState state)
            where TCreateInventoryItemRequirementEntryMvo : ICreateInventoryItemRequirementEntryMvo, new()
            where TMergePatchInventoryItemRequirementEntryMvo : IMergePatchInventoryItemRequirementEntryMvo, new()
        {
            bool bUnsaved = ((IInventoryItemRequirementEntryMvoState)state).IsUnsaved;
            if (bUnsaved)
            {
                return state.ToCreateInventoryItemRequirementEntryMvo<TCreateInventoryItemRequirementEntryMvo>();
            }
            else 
            {
                return state.ToMergePatchInventoryItemRequirementEntryMvo<TMergePatchInventoryItemRequirementEntryMvo>();
            }
        }

        public static TDeleteInventoryItemRequirementEntryMvo ToDeleteInventoryItemRequirementEntryMvo<TDeleteInventoryItemRequirementEntryMvo>(this IInventoryItemRequirementEntryMvoState state)
            where TDeleteInventoryItemRequirementEntryMvo : IDeleteInventoryItemRequirementEntryMvo, new()
        {
            var cmd = new TDeleteInventoryItemRequirementEntryMvo();
            cmd.InventoryItemRequirementEntryId = state.InventoryItemRequirementEntryId;
            cmd.InventoryItemRequirementVersion = ((IInventoryItemRequirementEntryMvoStateProperties)state).InventoryItemRequirementVersion;

            return cmd;
        }

        public static TMergePatchInventoryItemRequirementEntryMvo ToMergePatchInventoryItemRequirementEntryMvo<TMergePatchInventoryItemRequirementEntryMvo>(this IInventoryItemRequirementEntryMvoState state)
            where TMergePatchInventoryItemRequirementEntryMvo : IMergePatchInventoryItemRequirementEntryMvo, new()
        {
            var cmd = new TMergePatchInventoryItemRequirementEntryMvo();

            cmd.InventoryItemRequirementVersion = ((IInventoryItemRequirementEntryMvoStateProperties)state).InventoryItemRequirementVersion;

            cmd.InventoryItemRequirementEntryId = state.InventoryItemRequirementEntryId;
            cmd.Quantity = state.Quantity;
            cmd.SourceEventId = state.SourceEventId;
            cmd.Version = ((IInventoryItemRequirementEntryMvoStateProperties)state).Version;
            cmd.InventoryItemRequirementQuantity = state.InventoryItemRequirementQuantity;
            cmd.InventoryItemRequirementCreatedBy = state.InventoryItemRequirementCreatedBy;
            cmd.InventoryItemRequirementCreatedAt = state.InventoryItemRequirementCreatedAt;
            cmd.InventoryItemRequirementUpdatedBy = state.InventoryItemRequirementUpdatedBy;
            cmd.InventoryItemRequirementUpdatedAt = state.InventoryItemRequirementUpdatedAt;
            
            if (state.SourceEventId == null) { cmd.IsPropertySourceEventIdRemoved = true; }
            if (state.InventoryItemRequirementCreatedBy == null) { cmd.IsPropertyInventoryItemRequirementCreatedByRemoved = true; }
            if (state.InventoryItemRequirementUpdatedBy == null) { cmd.IsPropertyInventoryItemRequirementUpdatedByRemoved = true; }
            return cmd;
        }

        public static TCreateInventoryItemRequirementEntryMvo ToCreateInventoryItemRequirementEntryMvo<TCreateInventoryItemRequirementEntryMvo>(this IInventoryItemRequirementEntryMvoState state)
            where TCreateInventoryItemRequirementEntryMvo : ICreateInventoryItemRequirementEntryMvo, new()
        {
            var cmd = new TCreateInventoryItemRequirementEntryMvo();

            cmd.InventoryItemRequirementVersion = ((IInventoryItemRequirementEntryMvoStateProperties)state).InventoryItemRequirementVersion;

            cmd.InventoryItemRequirementEntryId = state.InventoryItemRequirementEntryId;
            cmd.Quantity = state.Quantity;
            cmd.SourceEventId = state.SourceEventId;
            cmd.Version = ((IInventoryItemRequirementEntryMvoStateProperties)state).Version;
            cmd.InventoryItemRequirementQuantity = state.InventoryItemRequirementQuantity;
            cmd.InventoryItemRequirementCreatedBy = state.InventoryItemRequirementCreatedBy;
            cmd.InventoryItemRequirementCreatedAt = state.InventoryItemRequirementCreatedAt;
            cmd.InventoryItemRequirementUpdatedBy = state.InventoryItemRequirementUpdatedBy;
            cmd.InventoryItemRequirementUpdatedAt = state.InventoryItemRequirementUpdatedAt;
            return cmd;
        }
		

	}

}
