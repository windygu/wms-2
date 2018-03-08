package org.dddml.wms.domain.attributevaluemvo;

import java.util.*;
import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class AttributeValueMvoStateEventDtoConverter {

    public AttributeValueMvoStateEventDto toAttributeValueMvoStateEventDto(AbstractAttributeValueMvoStateEvent stateEvent) {
        if (stateEvent instanceof AbstractAttributeValueMvoStateEvent.AbstractAttributeValueMvoStateCreated) {
            AttributeValueMvoStateEvent.AttributeValueMvoStateCreated e = (AttributeValueMvoStateEvent.AttributeValueMvoStateCreated) stateEvent;
            return toAttributeValueMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractAttributeValueMvoStateEvent.AbstractAttributeValueMvoStateMergePatched) {
            AttributeValueMvoStateEvent.AttributeValueMvoStateMergePatched e = (AttributeValueMvoStateEvent.AttributeValueMvoStateMergePatched) stateEvent;
            return toAttributeValueMvoStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractAttributeValueMvoStateEvent.AbstractAttributeValueMvoStateDeleted) {
            AttributeValueMvoStateEvent.AttributeValueMvoStateDeleted e = (AttributeValueMvoStateEvent.AttributeValueMvoStateDeleted) stateEvent;
            return toAttributeValueMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public AttributeValueMvoStateEventDto.AttributeValueMvoStateCreatedDto toAttributeValueMvoStateCreatedDto(AttributeValueMvoStateEvent.AttributeValueMvoStateCreated e) {
        AttributeValueMvoStateEventDto.AttributeValueMvoStateCreatedDto dto = new AttributeValueMvoStateEventDto.AttributeValueMvoStateCreatedDto();
        dto.setAttributeValueMvoEventId(e.getAttributeValueMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setAttributeValueName(e.getAttributeValueName());
        dto.setDescription(e.getDescription());
        dto.setReferenceId(e.getReferenceId());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setAttributeAttributeName(e.getAttributeAttributeName());
        dto.setAttributeOrganizationId(e.getAttributeOrganizationId());
        dto.setAttributeDescription(e.getAttributeDescription());
        dto.setAttributeIsMandatory(e.getAttributeIsMandatory());
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
        dto.setAttributeValueMvoEventId(e.getAttributeValueMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setAttributeValueName(e.getAttributeValueName());
        dto.setDescription(e.getDescription());
        dto.setReferenceId(e.getReferenceId());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setAttributeAttributeName(e.getAttributeAttributeName());
        dto.setAttributeOrganizationId(e.getAttributeOrganizationId());
        dto.setAttributeDescription(e.getAttributeDescription());
        dto.setAttributeIsMandatory(e.getAttributeIsMandatory());
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
        dto.setIsPropertyAttributeValueNameRemoved(e.getIsPropertyAttributeValueNameRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyReferenceIdRemoved(e.getIsPropertyReferenceIdRemoved());
        dto.setIsPropertyVersionRemoved(e.getIsPropertyVersionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        dto.setIsPropertyAttributeAttributeNameRemoved(e.getIsPropertyAttributeAttributeNameRemoved());
        dto.setIsPropertyAttributeOrganizationIdRemoved(e.getIsPropertyAttributeOrganizationIdRemoved());
        dto.setIsPropertyAttributeDescriptionRemoved(e.getIsPropertyAttributeDescriptionRemoved());
        dto.setIsPropertyAttributeIsMandatoryRemoved(e.getIsPropertyAttributeIsMandatoryRemoved());
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
        dto.setAttributeValueMvoEventId(e.getAttributeValueMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

