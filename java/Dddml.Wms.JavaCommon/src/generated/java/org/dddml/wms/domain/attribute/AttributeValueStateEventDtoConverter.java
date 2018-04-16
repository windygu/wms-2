package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class AttributeValueStateEventDtoConverter {

    public AttributeValueStateEventDto toAttributeValueStateEventDto(AbstractAttributeValueEvent stateEvent) {
        if (stateEvent instanceof AbstractAttributeValueEvent.AbstractAttributeValueStateCreated) {
            AttributeValueEvent.AttributeValueStateCreated e = (AttributeValueEvent.AttributeValueStateCreated) stateEvent;
            return toAttributeValueStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractAttributeValueEvent.AbstractAttributeValueStateMergePatched) {
            AttributeValueEvent.AttributeValueStateMergePatched e = (AttributeValueEvent.AttributeValueStateMergePatched) stateEvent;
            return toAttributeValueStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractAttributeValueEvent.AbstractAttributeValueStateRemoved) {
            AttributeValueEvent.AttributeValueStateRemoved e = (AttributeValueEvent.AttributeValueStateRemoved) stateEvent;
            return toAttributeValueStateRemovedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public AttributeValueStateEventDto.AttributeValueStateCreatedDto toAttributeValueStateCreatedDto(AttributeValueEvent.AttributeValueStateCreated e) {
        AttributeValueStateEventDto.AttributeValueStateCreatedDto dto = new AttributeValueStateEventDto.AttributeValueStateCreatedDto();
        dto.setAttributeValueEventId(e.getAttributeValueEventId());
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

    public AttributeValueStateEventDto.AttributeValueStateMergePatchedDto toAttributeValueStateMergePatchedDto(AttributeValueEvent.AttributeValueStateMergePatched e) {
        AttributeValueStateEventDto.AttributeValueStateMergePatchedDto dto = new AttributeValueStateEventDto.AttributeValueStateMergePatchedDto();
        dto.setAttributeValueEventId(e.getAttributeValueEventId());
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


    public AttributeValueStateEventDto.AttributeValueStateRemovedDto toAttributeValueStateRemovedDto(AttributeValueEvent.AttributeValueStateRemoved e) {
        AttributeValueStateEventDto.AttributeValueStateRemovedDto dto = new AttributeValueStateEventDto.AttributeValueStateRemovedDto();
        dto.setAttributeValueEventId(e.getAttributeValueEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

