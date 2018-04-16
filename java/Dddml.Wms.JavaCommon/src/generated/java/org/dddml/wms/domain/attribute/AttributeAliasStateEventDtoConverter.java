package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class AttributeAliasStateEventDtoConverter {

    public AttributeAliasStateEventDto toAttributeAliasStateEventDto(AbstractAttributeAliasEvent stateEvent) {
        if (stateEvent instanceof AbstractAttributeAliasEvent.AbstractAttributeAliasStateCreated) {
            AttributeAliasEvent.AttributeAliasStateCreated e = (AttributeAliasEvent.AttributeAliasStateCreated) stateEvent;
            return toAttributeAliasStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractAttributeAliasEvent.AbstractAttributeAliasStateMergePatched) {
            AttributeAliasEvent.AttributeAliasStateMergePatched e = (AttributeAliasEvent.AttributeAliasStateMergePatched) stateEvent;
            return toAttributeAliasStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractAttributeAliasEvent.AbstractAttributeAliasStateRemoved) {
            AttributeAliasEvent.AttributeAliasStateRemoved e = (AttributeAliasEvent.AttributeAliasStateRemoved) stateEvent;
            return toAttributeAliasStateRemovedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public AttributeAliasStateEventDto.AttributeAliasStateCreatedDto toAttributeAliasStateCreatedDto(AttributeAliasEvent.AttributeAliasStateCreated e) {
        AttributeAliasStateEventDto.AttributeAliasStateCreatedDto dto = new AttributeAliasStateEventDto.AttributeAliasStateCreatedDto();
        dto.setAttributeAliasEventId(e.getAttributeAliasEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setActive(e.getActive());
        return dto;
    }

    public AttributeAliasStateEventDto.AttributeAliasStateMergePatchedDto toAttributeAliasStateMergePatchedDto(AttributeAliasEvent.AttributeAliasStateMergePatched e) {
        AttributeAliasStateEventDto.AttributeAliasStateMergePatchedDto dto = new AttributeAliasStateEventDto.AttributeAliasStateMergePatchedDto();
        dto.setAttributeAliasEventId(e.getAttributeAliasEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setActive(e.getActive());
        dto.setIsPropertyNameRemoved(e.getIsPropertyNameRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public AttributeAliasStateEventDto.AttributeAliasStateRemovedDto toAttributeAliasStateRemovedDto(AttributeAliasEvent.AttributeAliasStateRemoved e) {
        AttributeAliasStateEventDto.AttributeAliasStateRemovedDto dto = new AttributeAliasStateEventDto.AttributeAliasStateRemovedDto();
        dto.setAttributeAliasEventId(e.getAttributeAliasEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

