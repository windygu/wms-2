package org.dddml.wms.domain.inventorypostingrule;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InventoryPostingRuleStateEventDtoConverter {

    public InventoryPostingRuleStateEventDto toInventoryPostingRuleStateEventDto(AbstractInventoryPostingRuleStateEvent stateEvent) {
        if (stateEvent instanceof AbstractInventoryPostingRuleStateEvent.AbstractInventoryPostingRuleStateCreated) {
            InventoryPostingRuleStateEvent.InventoryPostingRuleStateCreated e = (InventoryPostingRuleStateEvent.InventoryPostingRuleStateCreated) stateEvent;
            return toInventoryPostingRuleStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractInventoryPostingRuleStateEvent.AbstractInventoryPostingRuleStateMergePatched) {
            InventoryPostingRuleStateEvent.InventoryPostingRuleStateMergePatched e = (InventoryPostingRuleStateEvent.InventoryPostingRuleStateMergePatched) stateEvent;
            return toInventoryPostingRuleStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractInventoryPostingRuleStateEvent.AbstractInventoryPostingRuleStateDeleted) {
            InventoryPostingRuleStateEvent.InventoryPostingRuleStateDeleted e = (InventoryPostingRuleStateEvent.InventoryPostingRuleStateDeleted) stateEvent;
            return toInventoryPostingRuleStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public InventoryPostingRuleStateEventDto.InventoryPostingRuleStateCreatedDto toInventoryPostingRuleStateCreatedDto(InventoryPostingRuleStateEvent.InventoryPostingRuleStateCreated e) {
        InventoryPostingRuleStateEventDto.InventoryPostingRuleStateCreatedDto dto = new InventoryPostingRuleStateEventDto.InventoryPostingRuleStateCreatedDto();
        dto.setStateEventId(new InventoryPostingRuleStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setTrigger((e.getTrigger() == null) ? null : new InventoryItemIdDtoWrapper(e.getTrigger()));
        dto.setOutput((e.getOutput() == null) ? null : new InventoryItemIdDtoWrapper(e.getOutput()));
        dto.setIsOutputNegated(e.getIsOutputNegated());
        dto.setActive(e.getActive());
        return dto;
    }

    public InventoryPostingRuleStateEventDto.InventoryPostingRuleStateMergePatchedDto toInventoryPostingRuleStateMergePatchedDto(InventoryPostingRuleStateEvent.InventoryPostingRuleStateMergePatched e) {
        InventoryPostingRuleStateEventDto.InventoryPostingRuleStateMergePatchedDto dto = new InventoryPostingRuleStateEventDto.InventoryPostingRuleStateMergePatchedDto();
        dto.setStateEventId(new InventoryPostingRuleStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setTrigger((e.getTrigger() == null) ? null : new InventoryItemIdDtoWrapper(e.getTrigger()));
        dto.setOutput((e.getOutput() == null) ? null : new InventoryItemIdDtoWrapper(e.getOutput()));
        dto.setIsOutputNegated(e.getIsOutputNegated());
        dto.setActive(e.getActive());
        dto.setIsPropertyTriggerRemoved(e.getIsPropertyTriggerRemoved());
        dto.setIsPropertyOutputRemoved(e.getIsPropertyOutputRemoved());
        dto.setIsPropertyIsOutputNegatedRemoved(e.getIsPropertyIsOutputNegatedRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public InventoryPostingRuleStateEventDto.InventoryPostingRuleStateDeletedDto toInventoryPostingRuleStateDeletedDto(InventoryPostingRuleStateEvent.InventoryPostingRuleStateDeleted e) {
        InventoryPostingRuleStateEventDto.InventoryPostingRuleStateDeletedDto dto = new InventoryPostingRuleStateEventDto.InventoryPostingRuleStateDeletedDto();
        dto.setStateEventId(new InventoryPostingRuleStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

