package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class AttributeSetStateEventDtoConverter {

    public AttributeSetStateEventDto toAttributeSetStateEventDto(AbstractAttributeSetStateEvent stateEvent) {
        if (stateEvent instanceof AbstractAttributeSetStateEvent.AbstractAttributeSetStateCreated) {
            AttributeSetStateEvent.AttributeSetStateCreated e = (AttributeSetStateEvent.AttributeSetStateCreated) stateEvent;
            return toAttributeSetStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractAttributeSetStateEvent.AbstractAttributeSetStateMergePatched) {
            AttributeSetStateEvent.AttributeSetStateMergePatched e = (AttributeSetStateEvent.AttributeSetStateMergePatched) stateEvent;
            return toAttributeSetStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractAttributeSetStateEvent.AbstractAttributeSetStateDeleted) {
            AttributeSetStateEvent.AttributeSetStateDeleted e = (AttributeSetStateEvent.AttributeSetStateDeleted) stateEvent;
            return toAttributeSetStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public AttributeSetStateEventDto.AttributeSetStateCreatedDto toAttributeSetStateCreatedDto(AttributeSetStateEvent.AttributeSetStateCreated e) {
        AttributeSetStateEventDto.AttributeSetStateCreatedDto dto = new AttributeSetStateEventDto.AttributeSetStateCreatedDto();
        dto.setStateEventId(new AttributeSetStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setAttributeSetName(e.getAttributeSetName());
        dto.setOrganizationId(e.getOrganizationId());
        dto.setDescription(e.getDescription());
        dto.setSerialNumberAttributeId(e.getSerialNumberAttributeId());
        dto.setLotAttributeId(e.getLotAttributeId());
        dto.setReferenceId(e.getReferenceId());
        dto.setIsInstanceAttributeSet(e.getIsInstanceAttributeSet());
        dto.setIsMandatory(e.getIsMandatory());
        dto.setActive(e.getActive());
        List<AttributeUseStateEventDto.AttributeUseStateCreatedDto> attributeUseEvents = new ArrayList<>();
        for (AttributeUseStateEvent.AttributeUseStateCreated ee : e.getAttributeUseEvents()) {
            AttributeUseStateEventDto.AttributeUseStateCreatedDto eeDto = getAttributeUseStateEventDtoConverter().toAttributeUseStateCreatedDto(ee);
            attributeUseEvents.add(eeDto);
        }
        dto.setAttributeUseEvents(attributeUseEvents.toArray(new AttributeUseStateEventDto.AttributeUseStateCreatedDto[0]));

        return dto;
    }

    public AttributeSetStateEventDto.AttributeSetStateMergePatchedDto toAttributeSetStateMergePatchedDto(AttributeSetStateEvent.AttributeSetStateMergePatched e) {
        AttributeSetStateEventDto.AttributeSetStateMergePatchedDto dto = new AttributeSetStateEventDto.AttributeSetStateMergePatchedDto();
        dto.setStateEventId(new AttributeSetStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setAttributeSetName(e.getAttributeSetName());
        dto.setOrganizationId(e.getOrganizationId());
        dto.setDescription(e.getDescription());
        dto.setSerialNumberAttributeId(e.getSerialNumberAttributeId());
        dto.setLotAttributeId(e.getLotAttributeId());
        dto.setReferenceId(e.getReferenceId());
        dto.setIsInstanceAttributeSet(e.getIsInstanceAttributeSet());
        dto.setIsMandatory(e.getIsMandatory());
        dto.setActive(e.getActive());
        dto.setIsPropertyAttributeSetNameRemoved(e.getIsPropertyAttributeSetNameRemoved());
        dto.setIsPropertyOrganizationIdRemoved(e.getIsPropertyOrganizationIdRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertySerialNumberAttributeIdRemoved(e.getIsPropertySerialNumberAttributeIdRemoved());
        dto.setIsPropertyLotAttributeIdRemoved(e.getIsPropertyLotAttributeIdRemoved());
        dto.setIsPropertyReferenceIdRemoved(e.getIsPropertyReferenceIdRemoved());
        dto.setIsPropertyIsInstanceAttributeSetRemoved(e.getIsPropertyIsInstanceAttributeSetRemoved());
        dto.setIsPropertyIsMandatoryRemoved(e.getIsPropertyIsMandatoryRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        List<AttributeUseStateEventDto> attributeUseEvents = new ArrayList<>();
        for (AttributeUseStateEvent ee : e.getAttributeUseEvents()) {
            AttributeUseStateEventDto eeDto = getAttributeUseStateEventDtoConverter().toAttributeUseStateEventDto((AbstractAttributeUseStateEvent) ee);
            attributeUseEvents.add(eeDto);
        }
        dto.setAttributeUseEvents(attributeUseEvents.toArray(new AttributeUseStateEventDto[0]));

        return dto;
    }


    public AttributeSetStateEventDto.AttributeSetStateDeletedDto toAttributeSetStateDeletedDto(AttributeSetStateEvent.AttributeSetStateDeleted e) {
        AttributeSetStateEventDto.AttributeSetStateDeletedDto dto = new AttributeSetStateEventDto.AttributeSetStateDeletedDto();
        dto.setStateEventId(new AttributeSetStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        List<AttributeUseStateEventDto.AttributeUseStateRemovedDto> attributeUseEvents = new ArrayList<>();
        for (AttributeUseStateEvent.AttributeUseStateRemoved ee : e.getAttributeUseEvents()) {
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

