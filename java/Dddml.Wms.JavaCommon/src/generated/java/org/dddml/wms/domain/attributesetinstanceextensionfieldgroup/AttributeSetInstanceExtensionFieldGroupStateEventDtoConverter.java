package org.dddml.wms.domain.attributesetinstanceextensionfieldgroup;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class AttributeSetInstanceExtensionFieldGroupStateEventDtoConverter {

    public AttributeSetInstanceExtensionFieldGroupStateEventDto toAttributeSetInstanceExtensionFieldGroupStateEventDto(AbstractAttributeSetInstanceExtensionFieldGroupStateEvent stateEvent) {
        if (stateEvent instanceof AbstractAttributeSetInstanceExtensionFieldGroupStateEvent.AbstractAttributeSetInstanceExtensionFieldGroupStateCreated) {
            AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateCreated e = (AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateCreated) stateEvent;
            return toAttributeSetInstanceExtensionFieldGroupStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractAttributeSetInstanceExtensionFieldGroupStateEvent.AbstractAttributeSetInstanceExtensionFieldGroupStateMergePatched) {
            AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateMergePatched e = (AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateMergePatched) stateEvent;
            return toAttributeSetInstanceExtensionFieldGroupStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractAttributeSetInstanceExtensionFieldGroupStateEvent.AbstractAttributeSetInstanceExtensionFieldGroupStateDeleted) {
            AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateDeleted e = (AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateDeleted) stateEvent;
            return toAttributeSetInstanceExtensionFieldGroupStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateCreatedDto toAttributeSetInstanceExtensionFieldGroupStateCreatedDto(AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateCreated e) {
        AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateCreatedDto dto = new AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateCreatedDto();
        dto.setStateEventId(e.getStateEventId());
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

    public AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateMergePatchedDto toAttributeSetInstanceExtensionFieldGroupStateMergePatchedDto(AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateMergePatched e) {
        AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateMergePatchedDto dto = new AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateMergePatchedDto();
        dto.setStateEventId(e.getStateEventId());
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


    public AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateDeletedDto toAttributeSetInstanceExtensionFieldGroupStateDeletedDto(AttributeSetInstanceExtensionFieldGroupStateEvent.AttributeSetInstanceExtensionFieldGroupStateDeleted e) {
        AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateDeletedDto dto = new AttributeSetInstanceExtensionFieldGroupStateEventDto.AttributeSetInstanceExtensionFieldGroupStateDeletedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

