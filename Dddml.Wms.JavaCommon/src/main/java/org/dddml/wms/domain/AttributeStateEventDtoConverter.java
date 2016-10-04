package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;

public class AttributeStateEventDtoConverter {

    public AttributeStateEventDto toAttributeStateEventDto(AbstractAttributeStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            AttributeStateEvent.AttributeStateCreated e = (AttributeStateEvent.AttributeStateCreated) stateEvent;
            return toAttributeStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            AttributeStateEvent.AttributeStateMergePatched e = (AttributeStateEvent.AttributeStateMergePatched) stateEvent;
            return toAttributeStateMergePatchedDto(e);
        } else if (StateEventType.DELETED.equals(stateEvent.getStateEventType())) {
            AttributeStateEvent.AttributeStateDeleted e = (AttributeStateEvent.AttributeStateDeleted) stateEvent;
            return toAttributeStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public AttributeStateEventDto.AttributeStateCreatedDto toAttributeStateCreatedDto(AttributeStateEvent.AttributeStateCreated e) {
        AttributeStateEventDto.AttributeStateCreatedDto dto = new AttributeStateEventDto.AttributeStateCreatedDto();
        dto.setStateEventId(new AttributeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setOrganizationId(e.getOrganizationId());
        dto.setDescription(e.getDescription());
        dto.setIsMandatory(e.getIsMandatory());
        dto.setIsInstanceAttribute(e.getIsInstanceAttribute());
        dto.setAttributeValueType(e.getAttributeValueType());
        dto.setAttributeValueLength(e.getAttributeValueLength());
        dto.setIsList(e.getIsList());
        dto.setFieldName(e.getFieldName());
        dto.setReferenceId(e.getReferenceId());
        dto.setActive(e.getActive());
        List<AttributeValueStateEventDto.AttributeValueStateCreatedDto> attributeValueEvents = new ArrayList<>();
        for (AttributeValueStateEvent.AttributeValueStateCreated ee : e.getAttributeValueEvents()) {
            AttributeValueStateEventDto.AttributeValueStateCreatedDto eeDto = getAttributeValueStateEventDtoConverter().toAttributeValueStateCreatedDto(ee);
            attributeValueEvents.add(eeDto);
        }
        dto.setAttributeValueEvents(attributeValueEvents.toArray(new AttributeValueStateEventDto.AttributeValueStateCreatedDto[0]));

        return dto;
    }

    public AttributeStateEventDto.AttributeStateMergePatchedDto toAttributeStateMergePatchedDto(AttributeStateEvent.AttributeStateMergePatched e) {
        AttributeStateEventDto.AttributeStateMergePatchedDto dto = new AttributeStateEventDto.AttributeStateMergePatchedDto();
        dto.setStateEventId(new AttributeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setOrganizationId(e.getOrganizationId());
        dto.setDescription(e.getDescription());
        dto.setIsMandatory(e.getIsMandatory());
        dto.setIsInstanceAttribute(e.getIsInstanceAttribute());
        dto.setAttributeValueType(e.getAttributeValueType());
        dto.setAttributeValueLength(e.getAttributeValueLength());
        dto.setIsList(e.getIsList());
        dto.setFieldName(e.getFieldName());
        dto.setReferenceId(e.getReferenceId());
        dto.setActive(e.getActive());
        dto.setIsPropertyNameRemoved(e.getIsPropertyNameRemoved());
        dto.setIsPropertyOrganizationIdRemoved(e.getIsPropertyOrganizationIdRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyIsMandatoryRemoved(e.getIsPropertyIsMandatoryRemoved());
        dto.setIsPropertyIsInstanceAttributeRemoved(e.getIsPropertyIsInstanceAttributeRemoved());
        dto.setIsPropertyAttributeValueTypeRemoved(e.getIsPropertyAttributeValueTypeRemoved());
        dto.setIsPropertyAttributeValueLengthRemoved(e.getIsPropertyAttributeValueLengthRemoved());
        dto.setIsPropertyIsListRemoved(e.getIsPropertyIsListRemoved());
        dto.setIsPropertyFieldNameRemoved(e.getIsPropertyFieldNameRemoved());
        dto.setIsPropertyReferenceIdRemoved(e.getIsPropertyReferenceIdRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        List<AttributeValueStateEventDto> attributeValueEvents = new ArrayList<>();
        for (AttributeValueStateEvent ee : e.getAttributeValueEvents()) {
            AttributeValueStateEventDto eeDto = getAttributeValueStateEventDtoConverter().toAttributeValueStateEventDto((AbstractAttributeValueStateEvent) ee);
            attributeValueEvents.add(eeDto);
        }
        dto.setAttributeValueEvents(attributeValueEvents.toArray(new AttributeValueStateEventDto[0]));

        return dto;
    }


    public AttributeStateEventDto.AttributeStateDeletedDto toAttributeStateDeletedDto(AttributeStateEvent.AttributeStateDeleted e) {
        AttributeStateEventDto.AttributeStateDeletedDto dto = new AttributeStateEventDto.AttributeStateDeletedDto();
        dto.setStateEventId(new AttributeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        List<AttributeValueStateEventDto.AttributeValueStateRemovedDto> attributeValueEvents = new ArrayList<>();
        for (AttributeValueStateEvent.AttributeValueStateRemoved ee : e.getAttributeValueEvents()) {
            AttributeValueStateEventDto.AttributeValueStateRemovedDto eeDto = getAttributeValueStateEventDtoConverter().toAttributeValueStateRemovedDto(ee);
            attributeValueEvents.add(eeDto);
        }
        dto.setAttributeValueEvents(attributeValueEvents.toArray(new AttributeValueStateEventDto.AttributeValueStateRemovedDto[0]));

        return dto;
    }

    protected AttributeValueStateEventDtoConverter getAttributeValueStateEventDtoConverter() {
        return new AttributeValueStateEventDtoConverter();
    }

}

