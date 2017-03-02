package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class AttributeValueStateEventDtoConverter {

    public AttributeValueStateEventDto toAttributeValueStateEventDto(AbstractAttributeValueStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            AttributeValueStateEvent.AttributeValueStateCreated e = (AttributeValueStateEvent.AttributeValueStateCreated) stateEvent;
            return toAttributeValueStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            AttributeValueStateEvent.AttributeValueStateMergePatched e = (AttributeValueStateEvent.AttributeValueStateMergePatched) stateEvent;
            return toAttributeValueStateMergePatchedDto(e);
        } else if (StateEventType.REMOVED.equals(stateEvent.getStateEventType())) {
            AttributeValueStateEvent.AttributeValueStateRemoved e = (AttributeValueStateEvent.AttributeValueStateRemoved) stateEvent;
            return toAttributeValueStateRemovedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public AttributeValueStateEventDto.AttributeValueStateCreatedDto toAttributeValueStateCreatedDto(AttributeValueStateEvent.AttributeValueStateCreated e) {
        AttributeValueStateEventDto.AttributeValueStateCreatedDto dto = new AttributeValueStateEventDto.AttributeValueStateCreatedDto();
        dto.setStateEventId(new AttributeValueStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setDescription(e.getDescription());
        dto.setReferenceId(e.getReferenceId());
        dto.setActive(e.getActive());
        return dto;
    }

    public AttributeValueStateEventDto.AttributeValueStateMergePatchedDto toAttributeValueStateMergePatchedDto(AttributeValueStateEvent.AttributeValueStateMergePatched e) {
        AttributeValueStateEventDto.AttributeValueStateMergePatchedDto dto = new AttributeValueStateEventDto.AttributeValueStateMergePatchedDto();
        dto.setStateEventId(new AttributeValueStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setDescription(e.getDescription());
        dto.setReferenceId(e.getReferenceId());
        dto.setActive(e.getActive());
        dto.setIsPropertyNameRemoved(e.getIsPropertyNameRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyReferenceIdRemoved(e.getIsPropertyReferenceIdRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public AttributeValueStateEventDto.AttributeValueStateRemovedDto toAttributeValueStateRemovedDto(AttributeValueStateEvent.AttributeValueStateRemoved e) {
        AttributeValueStateEventDto.AttributeValueStateRemovedDto dto = new AttributeValueStateEventDto.AttributeValueStateRemovedDto();
        dto.setStateEventId(new AttributeValueStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

