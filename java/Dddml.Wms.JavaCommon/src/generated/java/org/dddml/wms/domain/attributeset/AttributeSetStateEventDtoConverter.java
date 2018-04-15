package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class AttributeSetStateEventDtoConverter {

    public AttributeSetStateEventDto toAttributeSetStateEventDto(AbstractAttributeSetEvent stateEvent) {
        if (stateEvent instanceof AbstractAttributeSetEvent.AbstractAttributeSetStateCreated) {
            AttributeSetEvent.AttributeSetStateCreated e = (AttributeSetEvent.AttributeSetStateCreated) stateEvent;
            return toAttributeSetStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractAttributeSetEvent.AbstractAttributeSetStateMergePatched) {
            AttributeSetEvent.AttributeSetStateMergePatched e = (AttributeSetEvent.AttributeSetStateMergePatched) stateEvent;
            return toAttributeSetStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractAttributeSetEvent.AbstractAttributeSetStateDeleted) {
            AttributeSetEvent.AttributeSetStateDeleted e = (AttributeSetEvent.AttributeSetStateDeleted) stateEvent;
            return toAttributeSetStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public AttributeSetStateEventDto.AttributeSetStateCreatedDto toAttributeSetStateCreatedDto(AttributeSetEvent.AttributeSetStateCreated e) {
        AttributeSetStateEventDto.AttributeSetStateCreatedDto dto = new AttributeSetStateEventDto.AttributeSetStateCreatedDto();
        dto.setAttributeSetEventId(e.getAttributeSetEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setAttributeSetName(e.getAttributeSetName());
        dto.setOrganizationId(e.getOrganizationId());
        dto.setDescription(e.getDescription());
        dto.setReferenceId(e.getReferenceId());
        dto.setIsInstanceAttributeSet(e.getIsInstanceAttributeSet());
        dto.setIsMandatory(e.getIsMandatory());
        dto.setActive(e.getActive());
        List<AttributeUseStateEventDto.AttributeUseStateCreatedDto> attributeUseEvents = new ArrayList<>();
        for (AttributeUseEvent.AttributeUseStateCreated ee : e.getAttributeUseEvents()) {
            AttributeUseStateEventDto.AttributeUseStateCreatedDto eeDto = getAttributeUseStateEventDtoConverter().toAttributeUseStateCreatedDto(ee);
            attributeUseEvents.add(eeDto);
        }
        dto.setAttributeUseEvents(attributeUseEvents.toArray(new AttributeUseStateEventDto.AttributeUseStateCreatedDto[0]));

        return dto;
    }

    public AttributeSetStateEventDto.AttributeSetStateMergePatchedDto toAttributeSetStateMergePatchedDto(AttributeSetEvent.AttributeSetStateMergePatched e) {
        AttributeSetStateEventDto.AttributeSetStateMergePatchedDto dto = new AttributeSetStateEventDto.AttributeSetStateMergePatchedDto();
        dto.setAttributeSetEventId(e.getAttributeSetEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setAttributeSetName(e.getAttributeSetName());
        dto.setOrganizationId(e.getOrganizationId());
        dto.setDescription(e.getDescription());
        dto.setReferenceId(e.getReferenceId());
        dto.setIsInstanceAttributeSet(e.getIsInstanceAttributeSet());
        dto.setIsMandatory(e.getIsMandatory());
        dto.setActive(e.getActive());
        dto.setIsPropertyAttributeSetNameRemoved(e.getIsPropertyAttributeSetNameRemoved());
        dto.setIsPropertyOrganizationIdRemoved(e.getIsPropertyOrganizationIdRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyReferenceIdRemoved(e.getIsPropertyReferenceIdRemoved());
        dto.setIsPropertyIsInstanceAttributeSetRemoved(e.getIsPropertyIsInstanceAttributeSetRemoved());
        dto.setIsPropertyIsMandatoryRemoved(e.getIsPropertyIsMandatoryRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        List<AttributeUseStateEventDto> attributeUseEvents = new ArrayList<>();
        for (AttributeUseEvent ee : e.getAttributeUseEvents()) {
            AttributeUseStateEventDto eeDto = getAttributeUseStateEventDtoConverter().toAttributeUseStateEventDto((AbstractAttributeUseEvent) ee);
            attributeUseEvents.add(eeDto);
        }
        dto.setAttributeUseEvents(attributeUseEvents.toArray(new AttributeUseStateEventDto[0]));

        return dto;
    }


    public AttributeSetStateEventDto.AttributeSetStateDeletedDto toAttributeSetStateDeletedDto(AttributeSetEvent.AttributeSetStateDeleted e) {
        AttributeSetStateEventDto.AttributeSetStateDeletedDto dto = new AttributeSetStateEventDto.AttributeSetStateDeletedDto();
        dto.setAttributeSetEventId(e.getAttributeSetEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        List<AttributeUseStateEventDto.AttributeUseStateRemovedDto> attributeUseEvents = new ArrayList<>();
        for (AttributeUseEvent.AttributeUseStateRemoved ee : e.getAttributeUseEvents()) {
            AttributeUseStateEventDto.AttributeUseStateRemovedDto eeDto = getAttributeUseStateEventDtoConverter().toAttributeUseStateRemovedDto(ee);
            attributeUseEvents.add(eeDto);
        }
        dto.setAttributeUseEvents(attributeUseEvents.toArray(new AttributeUseStateEventDto.AttributeUseStateRemovedDto[0]));

        return dto;
    }

    protected AttributeUseStateEventDtoConverter getAttributeUseStateEventDtoConverter() {
        return new AttributeUseStateEventDtoConverter();
    }

}

