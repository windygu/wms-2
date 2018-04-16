package org.dddml.wms.domain.inventorypostingrule;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InventoryPostingRuleStateEventDtoConverter {

    public InventoryPostingRuleStateEventDto toInventoryPostingRuleStateEventDto(AbstractInventoryPostingRuleEvent stateEvent) {
        if (stateEvent instanceof AbstractInventoryPostingRuleEvent.AbstractInventoryPostingRuleStateCreated) {
            InventoryPostingRuleEvent.InventoryPostingRuleStateCreated e = (InventoryPostingRuleEvent.InventoryPostingRuleStateCreated) stateEvent;
            return toInventoryPostingRuleStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractInventoryPostingRuleEvent.AbstractInventoryPostingRuleStateMergePatched) {
            InventoryPostingRuleEvent.InventoryPostingRuleStateMergePatched e = (InventoryPostingRuleEvent.InventoryPostingRuleStateMergePatched) stateEvent;
            return toInventoryPostingRuleStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractInventoryPostingRuleEvent.AbstractInventoryPostingRuleStateDeleted) {
            InventoryPostingRuleEvent.InventoryPostingRuleStateDeleted e = (InventoryPostingRuleEvent.InventoryPostingRuleStateDeleted) stateEvent;
            return toInventoryPostingRuleStateDeletedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public InventoryPostingRuleStateEventDto.InventoryPostingRuleStateCreatedDto toInventoryPostingRuleStateCreatedDto(InventoryPostingRuleEvent.InventoryPostingRuleStateCreated e) {
        InventoryPostingRuleStateEventDto.InventoryPostingRuleStateCreatedDto dto = new InventoryPostingRuleStateEventDto.InventoryPostingRuleStateCreatedDto();
        dto.setInventoryPostingRuleEventId(e.getInventoryPostingRuleEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setTriggerInventoryItemId(e.getTriggerInventoryItemId());
        dto.setOutputInventoryItemId(e.getOutputInventoryItemId());
        dto.setTriggerAccountName(e.getTriggerAccountName());
        dto.setOutputAccountName(e.getOutputAccountName());
        dto.setIsOutputNegated(e.getIsOutputNegated());
        dto.setActive(e.getActive());
        return dto;
    }

    public InventoryPostingRuleStateEventDto.InventoryPostingRuleStateMergePatchedDto toInventoryPostingRuleStateMergePatchedDto(InventoryPostingRuleEvent.InventoryPostingRuleStateMergePatched e) {
        InventoryPostingRuleStateEventDto.InventoryPostingRuleStateMergePatchedDto dto = new InventoryPostingRuleStateEventDto.InventoryPostingRuleStateMergePatchedDto();
        dto.setInventoryPostingRuleEventId(e.getInventoryPostingRuleEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setTriggerInventoryItemId(e.getTriggerInventoryItemId());
        dto.setOutputInventoryItemId(e.getOutputInventoryItemId());
        dto.setTriggerAccountName(e.getTriggerAccountName());
        dto.setOutputAccountName(e.getOutputAccountName());
        dto.setIsOutputNegated(e.getIsOutputNegated());
        dto.setActive(e.getActive());
        dto.setIsPropertyTriggerInventoryItemIdRemoved(e.getIsPropertyTriggerInventoryItemIdRemoved());
        dto.setIsPropertyOutputInventoryItemIdRemoved(e.getIsPropertyOutputInventoryItemIdRemoved());
        dto.setIsPropertyTriggerAccountNameRemoved(e.getIsPropertyTriggerAccountNameRemoved());
        dto.setIsPropertyOutputAccountNameRemoved(e.getIsPropertyOutputAccountNameRemoved());
        dto.setIsPropertyIsOutputNegatedRemoved(e.getIsPropertyIsOutputNegatedRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public InventoryPostingRuleStateEventDto.InventoryPostingRuleStateDeletedDto toInventoryPostingRuleStateDeletedDto(InventoryPostingRuleEvent.InventoryPostingRuleStateDeleted e) {
        InventoryPostingRuleStateEventDto.InventoryPostingRuleStateDeletedDto dto = new InventoryPostingRuleStateEventDto.InventoryPostingRuleStateDeletedDto();
        dto.setInventoryPostingRuleEventId(e.getInventoryPostingRuleEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

