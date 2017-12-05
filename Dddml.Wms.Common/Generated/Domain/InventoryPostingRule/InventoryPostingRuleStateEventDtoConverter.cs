﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryPostingRuleDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryPostingRule;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryPostingRule
{

    public class InventoryPostingRuleStateEventDtoConverter
    {
        public virtual InventoryPostingRuleStateCreatedOrMergePatchedOrDeletedDto ToInventoryPostingRuleStateEventDto(IInventoryPostingRuleStateEvent stateEvent)
        {
            if (stateEvent.StateEventType == StateEventType.Created)
            {
                var e = (IInventoryPostingRuleStateCreated)stateEvent;
                return ToInventoryPostingRuleStateCreatedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.MergePatched)
            {
                var e = (IInventoryPostingRuleStateMergePatched)stateEvent;
                return ToInventoryPostingRuleStateMergePatchedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.Deleted)
            {
                var e = (IInventoryPostingRuleStateDeleted)stateEvent;
                return ToInventoryPostingRuleStateDeletedDto(e);
            }
            throw DomainError.Named("invalidStateEventType", String.Format("Invalid state event type: {0}", stateEvent.StateEventType));
        }

        public virtual InventoryPostingRuleStateCreatedDto ToInventoryPostingRuleStateCreatedDto(IInventoryPostingRuleStateCreated e)
        {
            var dto = new InventoryPostingRuleStateCreatedDto();
            dto.StateEventId = new InventoryPostingRuleStateEventIdDtoWrapper(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.Trigger = (e.Trigger == null) ? null : new InventoryItemIdDtoWrapper(e.Trigger);
            dto.Output = (e.Output == null) ? null : new InventoryItemIdDtoWrapper(e.Output);
            dto.IsOutputNegated = e.IsOutputNegated;
            dto.Active = e.Active;
            return dto;
        }

        public virtual InventoryPostingRuleStateMergePatchedDto ToInventoryPostingRuleStateMergePatchedDto(IInventoryPostingRuleStateMergePatched e)
        {
            var dto = new InventoryPostingRuleStateMergePatchedDto();
            dto.StateEventId = new InventoryPostingRuleStateEventIdDtoWrapper(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.Trigger = (e.Trigger == null) ? null : new InventoryItemIdDtoWrapper(e.Trigger);
            dto.Output = (e.Output == null) ? null : new InventoryItemIdDtoWrapper(e.Output);
            dto.IsOutputNegated = e.IsOutputNegated;
            dto.Active = e.Active;
            dto.IsPropertyTriggerRemoved = e.IsPropertyTriggerRemoved;
            dto.IsPropertyOutputRemoved = e.IsPropertyOutputRemoved;
            dto.IsPropertyIsOutputNegatedRemoved = e.IsPropertyIsOutputNegatedRemoved;
            dto.IsPropertyActiveRemoved = e.IsPropertyActiveRemoved;

            return dto;
        }


        public virtual InventoryPostingRuleStateDeletedDto ToInventoryPostingRuleStateDeletedDto(IInventoryPostingRuleStateDeleted e)
        {
            var dto = new InventoryPostingRuleStateDeletedDto();
            dto.StateEventId = new InventoryPostingRuleStateEventIdDtoWrapper(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;

            return dto;
        }


    }


}

