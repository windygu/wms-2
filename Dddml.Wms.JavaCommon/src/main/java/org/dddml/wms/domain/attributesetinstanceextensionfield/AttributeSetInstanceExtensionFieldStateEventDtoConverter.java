package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class AttributeSetInstanceExtensionFieldStateEventDtoConverter {

    public AttributeSetInstanceExtensionFieldStateEventDto toAttributeSetInstanceExtensionFieldStateEventDto(AbstractAttributeSetInstanceExtensionFieldStateEvent stateEvent) {
        if (stateEvent instanceof AbstractAttributeSetInstanceExtensionFieldStateEvent.AbstractAttributeSetInstanceExtensionFieldStateCreated) {
            AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateCreated e = (AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateCreated) stateEvent;
            return toAttributeSetInstanceExtensionFieldStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractAttributeSetInstanceExtensionFieldStateEvent.AbstractAttributeSetInstanceExtensionFieldStateMergePatched) {
            AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateMergePatched e = (AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateMergePatched) stateEvent;
            return toAttributeSetInstanceExtensionFieldStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractAttributeSetInstanceExtensionFieldStateEvent.AbstractAttributeSetInstanceExtensionFieldStateDeleted) {
            AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateDeleted e = (AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateDeleted) stateEvent;
            return toAttributeSetInstanceExtensionFieldStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateCreatedDto toAttributeSetInstanceExtensionFieldStateCreatedDto(AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateCreated e) {
        AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateCreatedDto dto = new AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateCreatedDto();
        dto.setStateEventId(new AttributeSetInstanceExtensionFieldStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setType(e.getType());
        dto.setLength(e.getLength());
        dto.setAlias(e.getAlias());
        dto.setDescription(e.getDescription());
        dto.setGroupId(e.getGroupId());
        dto.setActive(e.getActive());
        return dto;
    }

    public AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateMergePatchedDto toAttributeSetInstanceExtensionFieldStateMergePatchedDto(AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateMergePatched e) {
        AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateMergePatchedDto dto = new AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateMergePatchedDto();
        dto.setStateEventId(new AttributeSetInstanceExtensionFieldStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setType(e.getType());
        dto.setLength(e.getLength());
        dto.setAlias(e.getAlias());
        dto.setDescription(e.getDescription());
        dto.setGroupId(e.getGroupId());
        dto.setActive(e.getActive());
        dto.setIsPropertyTypeRemoved(e.getIsPropertyTypeRemoved());
        dto.setIsPropertyLengthRemoved(e.getIsPropertyLengthRemoved());
        dto.setIsPropertyAliasRemoved(e.getIsPropertyAliasRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyGroupIdRemoved(e.getIsPropertyGroupIdRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateDeletedDto toAttributeSetInstanceExtensionFieldStateDeletedDto(AttributeSetInstanceExtensionFieldStateEvent.AttributeSetInstanceExtensionFieldStateDeleted e) {
        AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateDeletedDto dto = new AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateDeletedDto();
        dto.setStateEventId(new AttributeSetInstanceExtensionFieldStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

