package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;

public class AttributeUseStateEventDtoConverter {

    public AttributeUseStateEventDto toAttributeUseStateEventDto(AbstractAttributeUseStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            AttributeUseStateEvent.AttributeUseStateCreated e = (AttributeUseStateEvent.AttributeUseStateCreated) stateEvent;
            return toAttributeUseStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            AttributeUseStateEvent.AttributeUseStateMergePatched e = (AttributeUseStateEvent.AttributeUseStateMergePatched) stateEvent;
            return toAttributeUseStateMergePatchedDto(e);
        } else if (StateEventType.REMOVED.equals(stateEvent.getStateEventType())) {
            AttributeUseStateEvent.AttributeUseStateRemoved e = (AttributeUseStateEvent.AttributeUseStateRemoved) stateEvent;
            return toAttributeUseStateRemovedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public AttributeUseStateEventDto.AttributeUseStateCreatedDto toAttributeUseStateCreatedDto(AttributeUseStateEvent.AttributeUseStateCreated e) {
        AttributeUseStateEventDto.AttributeUseStateCreatedDto dto = new AttributeUseStateEventDto.AttributeUseStateCreatedDto();
        dto.setStateEventId(new AttributeUseStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setSequenceNumber(e.getSequenceNumber());
        dto.setActive(e.getActive());
        return dto;
    }

    public AttributeUseStateEventDto.AttributeUseStateMergePatchedDto toAttributeUseStateMergePatchedDto(AttributeUseStateEvent.AttributeUseStateMergePatched e) {
        AttributeUseStateEventDto.AttributeUseStateMergePatchedDto dto = new AttributeUseStateEventDto.AttributeUseStateMergePatchedDto();
        dto.setStateEventId(new AttributeUseStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setSequenceNumber(e.getSequenceNumber());
        dto.setActive(e.getActive());
        dto.setIsPropertySequenceNumberRemoved(e.getIsPropertySequenceNumberRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public AttributeUseStateEventDto.AttributeUseStateRemovedDto toAttributeUseStateRemovedDto(AttributeUseStateEvent.AttributeUseStateRemoved e) {
        AttributeUseStateEventDto.AttributeUseStateRemovedDto dto = new AttributeUseStateEventDto.AttributeUseStateRemovedDto();
        dto.setStateEventId(new AttributeUseStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

