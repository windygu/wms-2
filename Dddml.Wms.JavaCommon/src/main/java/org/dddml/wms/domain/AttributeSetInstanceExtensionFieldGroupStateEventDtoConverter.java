package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class AttributeSetInstanceExtensionFieldGroupStateEventDtoConverter {

    public AttributeSetInstanceExtensionFieldGroupStateEventDto toAttributeSetInstanceExtensionFieldGroupStateEventDto(AbstractAttributeSetInstanceExtensionFieldGroupStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateCreated e = (AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateCreated) stateEvent;
            return toAttributeSetInstanceExtensionFieldGroupStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateMergePatched e = (AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateMergePatched) stateEvent;
            return toAttributeSetInstanceExtensionFieldGroupStateMergePatchedDto(e);
        } else if (StateEventType.DELETED.equals(stateEvent.getStateEventType())) {
            AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateDeleted e = (AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateDeleted) stateEvent;
            return toAttributeSetInstanceExtensionFieldGroupStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateCreatedDto toAttributeSetInstanceExtensionFieldGroupStateCreatedDto(AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateCreated e) {
        AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateCreatedDto dto = new AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateCreatedDto();
        dto.setStateEventId(new AttributeSetInstanceExtensionFieldGroupStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setFieldType(e.getFieldType());
        dto.setFieldLength(e.getFieldLength());
        dto.setFieldCount(e.getFieldCount());
        dto.setNameFormat(e.getNameFormat());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        List<AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateCreatedDto> attributeSetInstanceExtensionFieldEvents = new ArrayList<>();
        for (AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateCreated ee : e.getAttributeSetInstanceExtensionFieldEvents()) {
            AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateCreatedDto eeDto = getAttributeSetInstanceExtensionFieldStateEventDtoConverter().toAttributeSetInstanceExtensionFieldStateCreatedDto(ee);
            attributeSetInstanceExtensionFieldEvents.add(eeDto);
        }
        dto.setAttributeSetInstanceExtensionFieldEvents(attributeSetInstanceExtensionFieldEvents.toArray(new AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateCreatedDto[0]));

        return dto;
    }

    public AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateMergePatchedDto toAttributeSetInstanceExtensionFieldGroupStateMergePatchedDto(AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateMergePatched e) {
        AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateMergePatchedDto dto = new AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateMergePatchedDto();
        dto.setStateEventId(new AttributeSetInstanceExtensionFieldGroupStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setFieldType(e.getFieldType());
        dto.setFieldLength(e.getFieldLength());
        dto.setFieldCount(e.getFieldCount());
        dto.setNameFormat(e.getNameFormat());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyFieldTypeRemoved(e.getIsPropertyFieldTypeRemoved());
        dto.setIsPropertyFieldLengthRemoved(e.getIsPropertyFieldLengthRemoved());
        dto.setIsPropertyFieldCountRemoved(e.getIsPropertyFieldCountRemoved());
        dto.setIsPropertyNameFormatRemoved(e.getIsPropertyNameFormatRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        List<AttributeSetInstanceExtensionFieldStateEventDto> attributeSetInstanceExtensionFieldEvents = new ArrayList<>();
        for (AttributeSetInstanceExtensionFieldStateEvent ee : e.getAttributeSetInstanceExtensionFieldEvents()) {
            AttributeSetInstanceExtensionFieldStateEventDto eeDto = getAttributeSetInstanceExtensionFieldStateEventDtoConverter().toAttributeSetInstanceExtensionFieldStateEventDto((AbstractAttributeSetInstanceExtensionFieldStateEvent) ee);
            attributeSetInstanceExtensionFieldEvents.add(eeDto);
        }
        dto.setAttributeSetInstanceExtensionFieldEvents(attributeSetInstanceExtensionFieldEvents.toArray(new AttributeSetInstanceExtensionFieldStateEventDto[0]));

        return dto;
    }


    public AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateDeletedDto toAttributeSetInstanceExtensionFieldGroupStateDeletedDto(AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateDeleted e) {
        AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateDeletedDto dto = new AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateDeletedDto();
        dto.setStateEventId(new AttributeSetInstanceExtensionFieldGroupStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        List<AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateRemovedDto> attributeSetInstanceExtensionFieldEvents = new ArrayList<>();
        for (AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateRemoved ee : e.getAttributeSetInstanceExtensionFieldEvents()) {
            AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateRemovedDto eeDto = getAttributeSetInstanceExtensionFieldStateEventDtoConverter().toAttributeSetInstanceExtensionFieldStateRemovedDto(ee);
            attributeSetInstanceExtensionFieldEvents.add(eeDto);
        }
        dto.setAttributeSetInstanceExtensionFieldEvents(attributeSetInstanceExtensionFieldEvents.toArray(new AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateRemovedDto[0]));

        return dto;
    }

    protected AttributeSetInstanceExtensionFieldStateEventDtoConverter getAttributeSetInstanceExtensionFieldStateEventDtoConverter() {
        return new AttributeSetInstanceExtensionFieldStateEventDtoConverter();
    }

}

