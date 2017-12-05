﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryPostingRuleDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryPostingRule;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryPostingRule
{

	public static partial class InventoryPostingRuleStateInterfaceExtension
	{

        public static IInventoryPostingRuleCommand ToCreateOrMergePatchInventoryPostingRule<TCreateInventoryPostingRule, TMergePatchInventoryPostingRule>(this IInventoryPostingRuleState state)
            where TCreateInventoryPostingRule : ICreateInventoryPostingRule, new()
            where TMergePatchInventoryPostingRule : IMergePatchInventoryPostingRule, new()
        {
            bool bUnsaved = ((IInventoryPostingRuleState)state).IsUnsaved;
            if (bUnsaved)
            {
                return state.ToCreateInventoryPostingRule<TCreateInventoryPostingRule>();
            }
            else 
            {
                return state.ToMergePatchInventoryPostingRule<TMergePatchInventoryPostingRule>();
            }
        }

        public static TDeleteInventoryPostingRule ToDeleteInventoryPostingRule<TDeleteInventoryPostingRule>(this IInventoryPostingRuleState state)
            where TDeleteInventoryPostingRule : IDeleteInventoryPostingRule, new()
        {
            var cmd = new TDeleteInventoryPostingRule();
            cmd.InventoryPostingRuleId = state.InventoryPostingRuleId;
            cmd.Version = ((IInventoryPostingRuleStateProperties)state).Version;

            return cmd;
        }

        public static TMergePatchInventoryPostingRule ToMergePatchInventoryPostingRule<TMergePatchInventoryPostingRule>(this IInventoryPostingRuleState state)
            where TMergePatchInventoryPostingRule : IMergePatchInventoryPostingRule, new()
        {
            var cmd = new TMergePatchInventoryPostingRule();

            cmd.Version = ((IInventoryPostingRuleStateProperties)state).Version;

            cmd.InventoryPostingRuleId = state.InventoryPostingRuleId;
            cmd.Trigger = state.Trigger;
            cmd.Output = state.Output;
            cmd.Active = ((IInventoryPostingRuleStateProperties)state).Active;
            
            if (state.Trigger == null) { cmd.IsPropertyTriggerRemoved = true; }
            if (state.Output == null) { cmd.IsPropertyOutputRemoved = true; }
            return cmd;
        }

        public static TCreateInventoryPostingRule ToCreateInventoryPostingRule<TCreateInventoryPostingRule>(this IInventoryPostingRuleState state)
            where TCreateInventoryPostingRule : ICreateInventoryPostingRule, new()
        {
            var cmd = new TCreateInventoryPostingRule();

            cmd.Version = ((IInventoryPostingRuleStateProperties)state).Version;

            cmd.InventoryPostingRuleId = state.InventoryPostingRuleId;
            cmd.Trigger = state.Trigger;
            cmd.Output = state.Output;
            cmd.Active = ((IInventoryPostingRuleStateProperties)state).Active;
            return cmd;
        }
		

	}

}
