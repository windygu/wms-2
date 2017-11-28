package org.dddml.wms.domain.inventoryitemeventtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InventoryItemEventTypeStateEventDtoConverter {

    public InventoryItemEventTypeStateEventDto toInventoryItemEventTypeStateEventDto(AbstractInventoryItemEventTypeStateEvent stateEvent) {
        if (stateEvent instanceof AbstractInventoryItemEventTypeStateEvent.AbstractInventoryItemEventTypeStateCreated) {
            InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateCreated e = (InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateCreated) stateEvent;
            return toInventoryItemEventTypeStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractInventoryItemEventTypeStateEvent.AbstractInventoryItemEventTypeStateMergePatched) {
            InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateMergePatched e = (InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateMergePatched) stateEvent;
            return toInventoryItemEventTypeStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractInventoryItemEventTypeStateEvent.AbstractInventoryItemEventTypeStateDeleted) {
            InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateDeleted e = (InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateDeleted) stateEvent;
            return toInventoryItemEventTypeStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public InventoryItemEventTypeStateEventDto.InventoryItemEventTypeStateCreatedDto toInventoryItemEventTypeStateCreatedDto(InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateCreated e) {
        InventoryItemEventTypeStateEventDto.InventoryItemEventTypeStateCreatedDto dto = new InventoryItemEventTypeStateEventDto.InventoryItemEventTypeStateCreatedDto();
        dto.setStateEventId(new InventoryItemEventTypeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public InventoryItemEventTypeStateEventDto.InventoryItemEventTypeStateMergePatchedDto toInventoryItemEventTypeStateMergePatchedDto(InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateMergePatched e) {
        InventoryItemEventTypeStateEventDto.InventoryItemEventTypeStateMergePatchedDto dto = new InventoryItemEventTypeStateEventDto.InventoryItemEventTypeStateMergePatchedDto();
        dto.setStateEventId(new InventoryItemEventTypeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public InventoryItemEventTypeStateEventDto.InventoryItemEventTypeStateDeletedDto toInventoryItemEventTypeStateDeletedDto(InventoryItemEventTypeStateEvent.InventoryItemEventTypeStateDeleted e) {
        InventoryItemEventTypeStateEventDto.InventoryItemEventTypeStateDeletedDto dto = new InventoryItemEventTypeStateEventDto.InventoryItemEventTypeStateDeletedDto();
        dto.setStateEventId(new InventoryItemEventTypeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

