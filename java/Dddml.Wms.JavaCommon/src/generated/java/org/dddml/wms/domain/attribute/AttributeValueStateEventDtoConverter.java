package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class AttributeValueStateEventDtoConverter {

    public AttributeValueStateEventDto toAttributeValueStateEventDto(AbstractAttributeValueStateEvent stateEvent) {
        if (stateEvent instanceof AbstractAttributeValueStateEvent.AbstractAttributeValueStateCreated) {
            AttributeValueStateEvent.AttributeValueStateCreated e = (AttributeValueStateEvent.AttributeValueStateCreated) stateEvent;
            return toAttributeValueStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractAttributeValueStateEvent.AbstractAttributeValueStateMergePatched) {
            AttributeValueStateEvent.AttributeValueStateMergePatched e = (AttributeValueStateEvent.AttributeValueStateMergePatched) stateEvent;
            return toAttributeValueStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractAttributeValueStateEvent.AbstractAttributeValueStateRemoved) {
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
        dto.setAttributeValueName(e.getAttributeValueName());
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
        dto.setAttributeValueName(e.getAttributeValueName());
        dto.setDescription(e.getDescription());
        dto.setReferenceId(e.getReferenceId());
        dto.setActive(e.getActive());
        dto.setIsPropertyAttributeValueNameRemoved(e.getIsPropertyAttributeValueNameRemoved());
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

