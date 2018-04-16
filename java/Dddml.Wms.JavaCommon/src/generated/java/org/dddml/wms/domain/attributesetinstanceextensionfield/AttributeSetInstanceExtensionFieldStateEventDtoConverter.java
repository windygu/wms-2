package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class AttributeSetInstanceExtensionFieldStateEventDtoConverter {

    public AttributeSetInstanceExtensionFieldStateEventDto toAttributeSetInstanceExtensionFieldStateEventDto(AbstractAttributeSetInstanceExtensionFieldEvent stateEvent) {
        if (stateEvent instanceof AbstractAttributeSetInstanceExtensionFieldEvent.AbstractAttributeSetInstanceExtensionFieldStateCreated) {
            AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateCreated e = (AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateCreated) stateEvent;
            return toAttributeSetInstanceExtensionFieldStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractAttributeSetInstanceExtensionFieldEvent.AbstractAttributeSetInstanceExtensionFieldStateMergePatched) {
            AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateMergePatched e = (AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateMergePatched) stateEvent;
            return toAttributeSetInstanceExtensionFieldStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractAttributeSetInstanceExtensionFieldEvent.AbstractAttributeSetInstanceExtensionFieldStateDeleted) {
            AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateDeleted e = (AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateDeleted) stateEvent;
            return toAttributeSetInstanceExtensionFieldStateDeletedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateCreatedDto toAttributeSetInstanceExtensionFieldStateCreatedDto(AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateCreated e) {
        AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateCreatedDto dto = new AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateCreatedDto();
        dto.setAttributeSetInstanceExtensionFieldEventId(e.getAttributeSetInstanceExtensionFieldEventId());
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

    public AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateMergePatchedDto toAttributeSetInstanceExtensionFieldStateMergePatchedDto(AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateMergePatched e) {
        AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateMergePatchedDto dto = new AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateMergePatchedDto();
        dto.setAttributeSetInstanceExtensionFieldEventId(e.getAttributeSetInstanceExtensionFieldEventId());
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


    public AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateDeletedDto toAttributeSetInstanceExtensionFieldStateDeletedDto(AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateDeleted e) {
        AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateDeletedDto dto = new AttributeSetInstanceExtensionFieldStateEventDto.AttributeSetInstanceExtensionFieldStateDeletedDto();
        dto.setAttributeSetInstanceExtensionFieldEventId(e.getAttributeSetInstanceExtensionFieldEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

