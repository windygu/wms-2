package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class AttributeUseStateEventDtoConverter {

    public AttributeUseStateEventDto toAttributeUseStateEventDto(AbstractAttributeUseEvent stateEvent) {
        if (stateEvent instanceof AbstractAttributeUseEvent.AbstractAttributeUseStateCreated) {
            AttributeUseEvent.AttributeUseStateCreated e = (AttributeUseEvent.AttributeUseStateCreated) stateEvent;
            return toAttributeUseStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractAttributeUseEvent.AbstractAttributeUseStateMergePatched) {
            AttributeUseEvent.AttributeUseStateMergePatched e = (AttributeUseEvent.AttributeUseStateMergePatched) stateEvent;
            return toAttributeUseStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractAttributeUseEvent.AbstractAttributeUseStateRemoved) {
            AttributeUseEvent.AttributeUseStateRemoved e = (AttributeUseEvent.AttributeUseStateRemoved) stateEvent;
            return toAttributeUseStateRemovedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public AttributeUseStateEventDto.AttributeUseStateCreatedDto toAttributeUseStateCreatedDto(AttributeUseEvent.AttributeUseStateCreated e) {
        AttributeUseStateEventDto.AttributeUseStateCreatedDto dto = new AttributeUseStateEventDto.AttributeUseStateCreatedDto();
        dto.setAttributeUseEventId(e.getAttributeUseEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setSequenceNumber(e.getSequenceNumber());
        dto.setActive(e.getActive());
        return dto;
    }

    public AttributeUseStateEventDto.AttributeUseStateMergePatchedDto toAttributeUseStateMergePatchedDto(AttributeUseEvent.AttributeUseStateMergePatched e) {
        AttributeUseStateEventDto.AttributeUseStateMergePatchedDto dto = new AttributeUseStateEventDto.AttributeUseStateMergePatchedDto();
        dto.setAttributeUseEventId(e.getAttributeUseEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setSequenceNumber(e.getSequenceNumber());
        dto.setActive(e.getActive());
        dto.setIsPropertySequenceNumberRemoved(e.getIsPropertySequenceNumberRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public AttributeUseStateEventDto.AttributeUseStateRemovedDto toAttributeUseStateRemovedDto(AttributeUseEvent.AttributeUseStateRemoved e) {
        AttributeUseStateEventDto.AttributeUseStateRemovedDto dto = new AttributeUseStateEventDto.AttributeUseStateRemovedDto();
        dto.setAttributeUseEventId(e.getAttributeUseEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

