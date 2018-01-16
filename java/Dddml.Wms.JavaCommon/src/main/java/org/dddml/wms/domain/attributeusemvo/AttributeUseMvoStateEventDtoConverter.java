package org.dddml.wms.domain.attributeusemvo;

import java.util.*;
import org.dddml.wms.domain.attributeset.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class AttributeUseMvoStateEventDtoConverter {

    public AttributeUseMvoStateEventDto toAttributeUseMvoStateEventDto(AbstractAttributeUseMvoStateEvent stateEvent) {
        if (stateEvent instanceof AbstractAttributeUseMvoStateEvent.AbstractAttributeUseMvoStateCreated) {
            AttributeUseMvoStateEvent.AttributeUseMvoStateCreated e = (AttributeUseMvoStateEvent.AttributeUseMvoStateCreated) stateEvent;
            return toAttributeUseMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractAttributeUseMvoStateEvent.AbstractAttributeUseMvoStateMergePatched) {
            AttributeUseMvoStateEvent.AttributeUseMvoStateMergePatched e = (AttributeUseMvoStateEvent.AttributeUseMvoStateMergePatched) stateEvent;
            return toAttributeUseMvoStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractAttributeUseMvoStateEvent.AbstractAttributeUseMvoStateDeleted) {
            AttributeUseMvoStateEvent.AttributeUseMvoStateDeleted e = (AttributeUseMvoStateEvent.AttributeUseMvoStateDeleted) stateEvent;
            return toAttributeUseMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public AttributeUseMvoStateEventDto.AttributeUseMvoStateCreatedDto toAttributeUseMvoStateCreatedDto(AttributeUseMvoStateEvent.AttributeUseMvoStateCreated e) {
        AttributeUseMvoStateEventDto.AttributeUseMvoStateCreatedDto dto = new AttributeUseMvoStateEventDto.AttributeUseMvoStateCreatedDto();
        dto.setStateEventId(new AttributeUseMvoStateEventIdDtoWrapper(e.getStateEventId()));
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

    public AttributeUseMvoStateEventDto.AttributeUseMvoStateMergePatchedDto toAttributeUseMvoStateMergePatchedDto(AttributeUseMvoStateEvent.AttributeUseMvoStateMergePatched e) {
        AttributeUseMvoStateEventDto.AttributeUseMvoStateMergePatchedDto dto = new AttributeUseMvoStateEventDto.AttributeUseMvoStateMergePatchedDto();
        dto.setStateEventId(new AttributeUseMvoStateEventIdDtoWrapper(e.getStateEventId()));
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


    public AttributeUseMvoStateEventDto.AttributeUseMvoStateDeletedDto toAttributeUseMvoStateDeletedDto(AttributeUseMvoStateEvent.AttributeUseMvoStateDeleted e) {
        AttributeUseMvoStateEventDto.AttributeUseMvoStateDeletedDto dto = new AttributeUseMvoStateEventDto.AttributeUseMvoStateDeletedDto();
        dto.setStateEventId(new AttributeUseMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

