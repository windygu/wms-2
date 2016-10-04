package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;

public class AttributeSetInstanceExtensionFieldStateEventDtoConverter {

    public AttributeSetInstanceExtensionFieldStateEventDto toAttributeSetInstanceExtensionFieldStateEventDto(AbstractAttributeSetInstanceExtensionFieldStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateCreated e = (AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateCreated) stateEvent;
            return toAttributeSetInstanceExtensionFieldStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateMergePatched e = (AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateMergePatched) stateEvent;
            return toAttributeSetInstanceExtensionFieldStateMergePatchedDto(e);
        } else if (StateEventType.REMOVED.equals(stateEvent.getStateEventType())) {
            AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateRemoved e = (AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateRemoved) stateEvent;
            return toAttributeSetInstanceExtensionFieldStateRemovedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateCreatedDto toAttributeSetInstanceExtensionFieldStateCreatedDto(AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateCreated e) {
        AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateCreatedDto dto = new AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateCreatedDto();
        dto.setStateEventId(new AttributeSetInstanceExtensionFieldStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setType(e.getType());
        dto.setLength(e.getLength());
        dto.setAlias(e.getAlias());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateMergePatchedDto toAttributeSetInstanceExtensionFieldStateMergePatchedDto(AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateMergePatched e) {
        AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateMergePatchedDto dto = new AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateMergePatchedDto();
        dto.setStateEventId(new AttributeSetInstanceExtensionFieldStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setType(e.getType());
        dto.setLength(e.getLength());
        dto.setAlias(e.getAlias());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyNameRemoved(e.getIsPropertyNameRemoved());
        dto.setIsPropertyTypeRemoved(e.getIsPropertyTypeRemoved());
        dto.setIsPropertyLengthRemoved(e.getIsPropertyLengthRemoved());
        dto.setIsPropertyAliasRemoved(e.getIsPropertyAliasRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateRemovedDto toAttributeSetInstanceExtensionFieldStateRemovedDto(AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateRemoved e) {
        AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateRemovedDto dto = new AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateRemovedDto();
        dto.setStateEventId(new AttributeSetInstanceExtensionFieldStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

