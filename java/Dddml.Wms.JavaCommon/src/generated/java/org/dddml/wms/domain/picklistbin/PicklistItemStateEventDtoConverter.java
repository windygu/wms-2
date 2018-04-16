package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PicklistItemStateEventDtoConverter {

    public PicklistItemStateEventDto toPicklistItemStateEventDto(AbstractPicklistItemEvent stateEvent) {
        if (stateEvent instanceof AbstractPicklistItemEvent.AbstractPicklistItemStateCreated) {
            PicklistItemEvent.PicklistItemStateCreated e = (PicklistItemEvent.PicklistItemStateCreated) stateEvent;
            return toPicklistItemStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPicklistItemEvent.AbstractPicklistItemStateMergePatched) {
            PicklistItemEvent.PicklistItemStateMergePatched e = (PicklistItemEvent.PicklistItemStateMergePatched) stateEvent;
            return toPicklistItemStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractPicklistItemEvent.AbstractPicklistItemStateRemoved) {
            PicklistItemEvent.PicklistItemStateRemoved e = (PicklistItemEvent.PicklistItemStateRemoved) stateEvent;
            return toPicklistItemStateRemovedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public PicklistItemStateEventDto.PicklistItemStateCreatedDto toPicklistItemStateCreatedDto(PicklistItemEvent.PicklistItemStateCreated e) {
        PicklistItemStateEventDto.PicklistItemStateCreatedDto dto = new PicklistItemStateEventDto.PicklistItemStateCreatedDto();
        dto.setPicklistItemEventId(e.getPicklistItemEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setItemStatusId(e.getItemStatusId());
        dto.setQuantity(e.getQuantity());
        dto.setActive(e.getActive());
        return dto;
    }

    public PicklistItemStateEventDto.PicklistItemStateMergePatchedDto toPicklistItemStateMergePatchedDto(PicklistItemEvent.PicklistItemStateMergePatched e) {
        PicklistItemStateEventDto.PicklistItemStateMergePatchedDto dto = new PicklistItemStateEventDto.PicklistItemStateMergePatchedDto();
        dto.setPicklistItemEventId(e.getPicklistItemEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setItemStatusId(e.getItemStatusId());
        dto.setQuantity(e.getQuantity());
        dto.setActive(e.getActive());
        dto.setIsPropertyItemStatusIdRemoved(e.getIsPropertyItemStatusIdRemoved());
        dto.setIsPropertyQuantityRemoved(e.getIsPropertyQuantityRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public PicklistItemStateEventDto.PicklistItemStateRemovedDto toPicklistItemStateRemovedDto(PicklistItemEvent.PicklistItemStateRemoved e) {
        PicklistItemStateEventDto.PicklistItemStateRemovedDto dto = new PicklistItemStateEventDto.PicklistItemStateRemovedDto();
        dto.setPicklistItemEventId(e.getPicklistItemEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

