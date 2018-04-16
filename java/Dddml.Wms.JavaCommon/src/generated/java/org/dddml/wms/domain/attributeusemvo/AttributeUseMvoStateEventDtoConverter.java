package org.dddml.wms.domain.attributeusemvo;

import java.util.*;
import org.dddml.wms.domain.attributeset.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class AttributeUseMvoStateEventDtoConverter {

    public AttributeUseMvoStateEventDto toAttributeUseMvoStateEventDto(AbstractAttributeUseMvoEvent stateEvent) {
        if (stateEvent instanceof AbstractAttributeUseMvoEvent.AbstractAttributeUseMvoStateCreated) {
            AttributeUseMvoEvent.AttributeUseMvoStateCreated e = (AttributeUseMvoEvent.AttributeUseMvoStateCreated) stateEvent;
            return toAttributeUseMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractAttributeUseMvoEvent.AbstractAttributeUseMvoStateMergePatched) {
            AttributeUseMvoEvent.AttributeUseMvoStateMergePatched e = (AttributeUseMvoEvent.AttributeUseMvoStateMergePatched) stateEvent;
            return toAttributeUseMvoStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractAttributeUseMvoEvent.AbstractAttributeUseMvoStateDeleted) {
            AttributeUseMvoEvent.AttributeUseMvoStateDeleted e = (AttributeUseMvoEvent.AttributeUseMvoStateDeleted) stateEvent;
            return toAttributeUseMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public AttributeUseMvoStateEventDto.AttributeUseMvoStateCreatedDto toAttributeUseMvoStateCreatedDto(AttributeUseMvoEvent.AttributeUseMvoStateCreated e) {
        AttributeUseMvoStateEventDto.AttributeUseMvoStateCreatedDto dto = new AttributeUseMvoStateEventDto.AttributeUseMvoStateCreatedDto();
        dto.setAttributeUseMvoEventId(e.getAttributeUseMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setSequenceNumber(e.getSequenceNumber());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setAttributeSetAttributeSetName(e.getAttributeSetAttributeSetName());
        dto.setAttributeSetOrganizationId(e.getAttributeSetOrganizationId());
        dto.setAttributeSetDescription(e.getAttributeSetDescription());
        dto.setAttributeSetReferenceId(e.getAttributeSetReferenceId());
        dto.setAttributeSetIsInstanceAttributeSet(e.getAttributeSetIsInstanceAttributeSet());
        dto.setAttributeSetIsMandatory(e.getAttributeSetIsMandatory());
        dto.setAttributeSetCreatedBy(e.getAttributeSetCreatedBy());
        dto.setAttributeSetCreatedAt(e.getAttributeSetCreatedAt());
        dto.setAttributeSetUpdatedBy(e.getAttributeSetUpdatedBy());
        dto.setAttributeSetUpdatedAt(e.getAttributeSetUpdatedAt());
        dto.setAttributeSetActive(e.getAttributeSetActive());
        dto.setAttributeSetDeleted(e.getAttributeSetDeleted());
        return dto;
    }

    public AttributeUseMvoStateEventDto.AttributeUseMvoStateMergePatchedDto toAttributeUseMvoStateMergePatchedDto(AttributeUseMvoEvent.AttributeUseMvoStateMergePatched e) {
        AttributeUseMvoStateEventDto.AttributeUseMvoStateMergePatchedDto dto = new AttributeUseMvoStateEventDto.AttributeUseMvoStateMergePatchedDto();
        dto.setAttributeUseMvoEventId(e.getAttributeUseMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setSequenceNumber(e.getSequenceNumber());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setAttributeSetAttributeSetName(e.getAttributeSetAttributeSetName());
        dto.setAttributeSetOrganizationId(e.getAttributeSetOrganizationId());
        dto.setAttributeSetDescription(e.getAttributeSetDescription());
        dto.setAttributeSetReferenceId(e.getAttributeSetReferenceId());
        dto.setAttributeSetIsInstanceAttributeSet(e.getAttributeSetIsInstanceAttributeSet());
        dto.setAttributeSetIsMandatory(e.getAttributeSetIsMandatory());
        dto.setAttributeSetCreatedBy(e.getAttributeSetCreatedBy());
        dto.setAttributeSetCreatedAt(e.getAttributeSetCreatedAt());
        dto.setAttributeSetUpdatedBy(e.getAttributeSetUpdatedBy());
        dto.setAttributeSetUpdatedAt(e.getAttributeSetUpdatedAt());
        dto.setAttributeSetActive(e.getAttributeSetActive());
        dto.setAttributeSetDeleted(e.getAttributeSetDeleted());
        dto.setIsPropertySequenceNumberRemoved(e.getIsPropertySequenceNumberRemoved());
        dto.setIsPropertyVersionRemoved(e.getIsPropertyVersionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        dto.setIsPropertyAttributeSetAttributeSetNameRemoved(e.getIsPropertyAttributeSetAttributeSetNameRemoved());
        dto.setIsPropertyAttributeSetOrganizationIdRemoved(e.getIsPropertyAttributeSetOrganizationIdRemoved());
        dto.setIsPropertyAttributeSetDescriptionRemoved(e.getIsPropertyAttributeSetDescriptionRemoved());
        dto.setIsPropertyAttributeSetReferenceIdRemoved(e.getIsPropertyAttributeSetReferenceIdRemoved());
        dto.setIsPropertyAttributeSetIsInstanceAttributeSetRemoved(e.getIsPropertyAttributeSetIsInstanceAttributeSetRemoved());
        dto.setIsPropertyAttributeSetIsMandatoryRemoved(e.getIsPropertyAttributeSetIsMandatoryRemoved());
        dto.setIsPropertyAttributeSetCreatedByRemoved(e.getIsPropertyAttributeSetCreatedByRemoved());
        dto.setIsPropertyAttributeSetCreatedAtRemoved(e.getIsPropertyAttributeSetCreatedAtRemoved());
        dto.setIsPropertyAttributeSetUpdatedByRemoved(e.getIsPropertyAttributeSetUpdatedByRemoved());
        dto.setIsPropertyAttributeSetUpdatedAtRemoved(e.getIsPropertyAttributeSetUpdatedAtRemoved());
        dto.setIsPropertyAttributeSetActiveRemoved(e.getIsPropertyAttributeSetActiveRemoved());
        dto.setIsPropertyAttributeSetDeletedRemoved(e.getIsPropertyAttributeSetDeletedRemoved());
        return dto;
    }


    public AttributeUseMvoStateEventDto.AttributeUseMvoStateDeletedDto toAttributeUseMvoStateDeletedDto(AttributeUseMvoEvent.AttributeUseMvoStateDeleted e) {
        AttributeUseMvoStateEventDto.AttributeUseMvoStateDeletedDto dto = new AttributeUseMvoStateEventDto.AttributeUseMvoStateDeletedDto();
        dto.setAttributeUseMvoEventId(e.getAttributeUseMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

