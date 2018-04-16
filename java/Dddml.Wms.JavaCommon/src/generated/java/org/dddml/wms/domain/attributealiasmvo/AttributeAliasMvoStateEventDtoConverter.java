package org.dddml.wms.domain.attributealiasmvo;

import java.util.*;
import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class AttributeAliasMvoStateEventDtoConverter {

    public AttributeAliasMvoStateEventDto toAttributeAliasMvoStateEventDto(AbstractAttributeAliasMvoEvent stateEvent) {
        if (stateEvent instanceof AbstractAttributeAliasMvoEvent.AbstractAttributeAliasMvoStateCreated) {
            AttributeAliasMvoEvent.AttributeAliasMvoStateCreated e = (AttributeAliasMvoEvent.AttributeAliasMvoStateCreated) stateEvent;
            return toAttributeAliasMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractAttributeAliasMvoEvent.AbstractAttributeAliasMvoStateMergePatched) {
            AttributeAliasMvoEvent.AttributeAliasMvoStateMergePatched e = (AttributeAliasMvoEvent.AttributeAliasMvoStateMergePatched) stateEvent;
            return toAttributeAliasMvoStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractAttributeAliasMvoEvent.AbstractAttributeAliasMvoStateDeleted) {
            AttributeAliasMvoEvent.AttributeAliasMvoStateDeleted e = (AttributeAliasMvoEvent.AttributeAliasMvoStateDeleted) stateEvent;
            return toAttributeAliasMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public AttributeAliasMvoStateEventDto.AttributeAliasMvoStateCreatedDto toAttributeAliasMvoStateCreatedDto(AttributeAliasMvoEvent.AttributeAliasMvoStateCreated e) {
        AttributeAliasMvoStateEventDto.AttributeAliasMvoStateCreatedDto dto = new AttributeAliasMvoStateEventDto.AttributeAliasMvoStateCreatedDto();
        dto.setAttributeAliasMvoEventId(e.getAttributeAliasMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
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

    public AttributeAliasMvoStateEventDto.AttributeAliasMvoStateMergePatchedDto toAttributeAliasMvoStateMergePatchedDto(AttributeAliasMvoEvent.AttributeAliasMvoStateMergePatched e) {
        AttributeAliasMvoStateEventDto.AttributeAliasMvoStateMergePatchedDto dto = new AttributeAliasMvoStateEventDto.AttributeAliasMvoStateMergePatchedDto();
        dto.setAttributeAliasMvoEventId(e.getAttributeAliasMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
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
        dto.setIsPropertyNameRemoved(e.getIsPropertyNameRemoved());
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


    public AttributeAliasMvoStateEventDto.AttributeAliasMvoStateDeletedDto toAttributeAliasMvoStateDeletedDto(AttributeAliasMvoEvent.AttributeAliasMvoStateDeleted e) {
        AttributeAliasMvoStateEventDto.AttributeAliasMvoStateDeletedDto dto = new AttributeAliasMvoStateEventDto.AttributeAliasMvoStateDeletedDto();
        dto.setAttributeAliasMvoEventId(e.getAttributeAliasMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

