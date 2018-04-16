package org.dddml.wms.domain.attributesetinstanceextensionfieldgroup;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class AttributeSetInstanceExtensionFieldGroupStateEventDtoConverter {

    public AttributeSetInstanceExtensionFieldGroupStateEventDto toAttributeSetInstanceExtensionFieldGroupStateEventDto(AbstractAttributeSetInstanceExtensionFieldGroupEvent stateEvent) {
        if (stateEvent instanceof AbstractAttributeSetInstanceExtensionFieldGroupEvent.AbstractAttributeSetInstanceExtensionFieldGroupStateCreated) {
            AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateCreated e = (AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateCreated) stateEvent;
            return toAttributeSetInstanceExtensionFieldGroupStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractAttributeSetInstanceExtensionFieldGroupEvent.AbstractAttributeSetInstanceExtensionFieldGroupStateMergePatched) {
            AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateMergePatched e = (AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateMergePatched) stateEvent;
            return toAttributeSetInstanceExtensionFieldGroupStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractAttributeSetInstanceExtensionFieldGroupEvent.AbstractAttributeSetInstanceExtensionFieldGroupStateDeleted) {
            AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateDeleted e = (AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateDeleted) stateEvent;
            return toAttributeSetInstanceExtensionFieldGroupStateDeletedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateCreatedDto toAttributeSetInstanceExtensionFieldGroupStateCreatedDto(AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateCreated e) {
        AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateCreatedDto dto = new AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateCreatedDto();
        dto.setAttributeSetInstanceExtensionFieldGroupEventId(e.getAttributeSetInstanceExtensionFieldGroupEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setFieldType(e.getFieldType());
        dto.setFieldLength(e.getFieldLength());
        dto.setFieldCount(e.getFieldCount());
        dto.setNameFormat(e.getNameFormat());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateMergePatchedDto toAttributeSetInstanceExtensionFieldGroupStateMergePatchedDto(AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateMergePatched e) {
        AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateMergePatchedDto dto = new AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateMergePatchedDto();
        dto.setAttributeSetInstanceExtensionFieldGroupEventId(e.getAttributeSetInstanceExtensionFieldGroupEventId());
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
        return dto;
    }


    public AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateDeletedDto toAttributeSetInstanceExtensionFieldGroupStateDeletedDto(AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateDeleted e) {
        AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateDeletedDto dto = new AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateDeletedDto();
        dto.setAttributeSetInstanceExtensionFieldGroupEventId(e.getAttributeSetInstanceExtensionFieldGroupEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

