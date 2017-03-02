package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class AttributeValueMvoStateEventDtoConverter {

    public AttributeValueMvoStateEventDto toAttributeValueMvoStateEventDto(AbstractAttributeValueMvoStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            AttributeValueMvoStateEvent.AttributeValueMvoStateCreated e = (AttributeValueMvoStateEvent.AttributeValueMvoStateCreated) stateEvent;
            return toAttributeValueMvoStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            AttributeValueMvoStateEvent.AttributeValueMvoStateMergePatched e = (AttributeValueMvoStateEvent.AttributeValueMvoStateMergePatched) stateEvent;
            return toAttributeValueMvoStateMergePatchedDto(e);
        } else if (StateEventType.DELETED.equals(stateEvent.getStateEventType())) {
            AttributeValueMvoStateEvent.AttributeValueMvoStateDeleted e = (AttributeValueMvoStateEvent.AttributeValueMvoStateDeleted) stateEvent;
            return toAttributeValueMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public AttributeValueMvoStateEventDto.AttributeValueMvoStateCreatedDto toAttributeValueMvoStateCreatedDto(AttributeValueMvoStateEvent.AttributeValueMvoStateCreated e) {
        AttributeValueMvoStateEventDto.AttributeValueMvoStateCreatedDto dto = new AttributeValueMvoStateEventDto.AttributeValueMvoStateCreatedDto();
        dto.setStateEventId(new AttributeValueMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setDescription(e.getDescription());
        dto.setReferenceId(e.getReferenceId());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setAttributeName(e.getAttributeName());
        dto.setAttributeOrganizationId(e.getAttributeOrganizationId());
        dto.setAttributeDescription(e.getAttributeDescription());
        dto.setAttributeIsMandatory(e.getAttributeIsMandatory());
        dto.setAttributeIsInstanceAttribute(e.getAttributeIsInstanceAttribute());
        dto.setAttributeAttributeValueType(e.getAttributeAttributeValueType());
        dto.setAttributeAttributeValueLength(e.getAttributeAttributeValueLength());
        dto.setAttributeIsList(e.getAttributeIsList());
        dto.setAttributeFieldName(e.getAttributeFieldName());
        dto.setAttributeReferenceId(e.getAttributeReferenceId());
        dto.setAttributeCreatedBy(e.getAttributeCreatedBy());
        dto.setAttributeCreatedAt(e.getAttributeCreatedAt());
        dto.setAttributeUpdatedBy(e.getAttributeUpdatedBy());
        dto.setAttributeUpdatedAt(e.getAttributeUpdatedAt());
        dto.setAttributeActive(e.getAttributeActive());
        dto.setAttributeDeleted(e.getAttributeDeleted());
        return dto;
    }

    public AttributeValueMvoStateEventDto.AttributeValueMvoStateMergePatchedDto toAttributeValueMvoStateMergePatchedDto(AttributeValueMvoStateEvent.AttributeValueMvoStateMergePatched e) {
        AttributeValueMvoStateEventDto.AttributeValueMvoStateMergePatchedDto dto = new AttributeValueMvoStateEventDto.AttributeValueMvoStateMergePatchedDto();
        dto.setStateEventId(new AttributeValueMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setDescription(e.getDescription());
        dto.setReferenceId(e.getReferenceId());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setAttributeName(e.getAttributeName());
        dto.setAttributeOrganizationId(e.getAttributeOrganizationId());
        dto.setAttributeDescription(e.getAttributeDescription());
        dto.setAttributeIsMandatory(e.getAttributeIsMandatory());
        dto.setAttributeIsInstanceAttribute(e.getAttributeIsInstanceAttribute());
        dto.setAttributeAttributeValueType(e.getAttributeAttributeValueType());
        dto.setAttributeAttributeValueLength(e.getAttributeAttributeValueLength());
        dto.setAttributeIsList(e.getAttributeIsList());
        dto.setAttributeFieldName(e.getAttributeFieldName());
        dto.setAttributeReferenceId(e.getAttributeReferenceId());
        dto.setAttributeCreatedBy(e.getAttributeCreatedBy());
        dto.setAttributeCreatedAt(e.getAttributeCreatedAt());
        dto.setAttributeUpdatedBy(e.getAttributeUpdatedBy());
        dto.setAttributeUpdatedAt(e.getAttributeUpdatedAt());
        dto.setAttributeActive(e.getAttributeActive());
        dto.setAttributeDeleted(e.getAttributeDeleted());
        dto.setIsPropertyNameRemoved(e.getIsPropertyNameRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyReferenceIdRemoved(e.getIsPropertyReferenceIdRemoved());
        dto.setIsPropertyVersionRemoved(e.getIsPropertyVersionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        dto.setIsPropertyAttributeNameRemoved(e.getIsPropertyAttributeNameRemoved());
        dto.setIsPropertyAttributeOrganizationIdRemoved(e.getIsPropertyAttributeOrganizationIdRemoved());
        dto.setIsPropertyAttributeDescriptionRemoved(e.getIsPropertyAttributeDescriptionRemoved());
        dto.setIsPropertyAttributeIsMandatoryRemoved(e.getIsPropertyAttributeIsMandatoryRemoved());
        dto.setIsPropertyAttributeIsInstanceAttributeRemoved(e.getIsPropertyAttributeIsInstanceAttributeRemoved());
        dto.setIsPropertyAttributeAttributeValueTypeRemoved(e.getIsPropertyAttributeAttributeValueTypeRemoved());
        dto.setIsPropertyAttributeAttributeValueLengthRemoved(e.getIsPropertyAttributeAttributeValueLengthRemoved());
        dto.setIsPropertyAttributeIsListRemoved(e.getIsPropertyAttributeIsListRemoved());
        dto.setIsPropertyAttributeFieldNameRemoved(e.getIsPropertyAttributeFieldNameRemoved());
        dto.setIsPropertyAttributeReferenceIdRemoved(e.getIsPropertyAttributeReferenceIdRemoved());
        dto.setIsPropertyAttributeCreatedByRemoved(e.getIsPropertyAttributeCreatedByRemoved());
        dto.setIsPropertyAttributeCreatedAtRemoved(e.getIsPropertyAttributeCreatedAtRemoved());
        dto.setIsPropertyAttributeUpdatedByRemoved(e.getIsPropertyAttributeUpdatedByRemoved());
        dto.setIsPropertyAttributeUpdatedAtRemoved(e.getIsPropertyAttributeUpdatedAtRemoved());
        dto.setIsPropertyAttributeActiveRemoved(e.getIsPropertyAttributeActiveRemoved());
        dto.setIsPropertyAttributeDeletedRemoved(e.getIsPropertyAttributeDeletedRemoved());
        return dto;
    }


    public AttributeValueMvoStateEventDto.AttributeValueMvoStateDeletedDto toAttributeValueMvoStateDeletedDto(AttributeValueMvoStateEvent.AttributeValueMvoStateDeleted e) {
        AttributeValueMvoStateEventDto.AttributeValueMvoStateDeletedDto dto = new AttributeValueMvoStateEventDto.AttributeValueMvoStateDeletedDto();
        dto.setStateEventId(new AttributeValueMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

