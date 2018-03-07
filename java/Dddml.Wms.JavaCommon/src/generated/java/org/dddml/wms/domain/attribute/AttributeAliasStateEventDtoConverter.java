package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class AttributeAliasStateEventDtoConverter {

    public AttributeAliasStateEventDto toAttributeAliasStateEventDto(AbstractAttributeAliasStateEvent stateEvent) {
        if (stateEvent instanceof AbstractAttributeAliasStateEvent.AbstractAttributeAliasStateCreated) {
            AttributeAliasStateEvent.AttributeAliasStateCreated e = (AttributeAliasStateEvent.AttributeAliasStateCreated) stateEvent;
            return toAttributeAliasStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractAttributeAliasStateEvent.AbstractAttributeAliasStateMergePatched) {
            AttributeAliasStateEvent.AttributeAliasStateMergePatched e = (AttributeAliasStateEvent.AttributeAliasStateMergePatched) stateEvent;
            return toAttributeAliasStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractAttributeAliasStateEvent.AbstractAttributeAliasStateRemoved) {
            AttributeAliasStateEvent.AttributeAliasStateRemoved e = (AttributeAliasStateEvent.AttributeAliasStateRemoved) stateEvent;
            return toAttributeAliasStateRemovedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public AttributeAliasStateEventDto.AttributeAliasStateCreatedDto toAttributeAliasStateCreatedDto(AttributeAliasStateEvent.AttributeAliasStateCreated e) {
        AttributeAliasStateEventDto.AttributeAliasStateCreatedDto dto = new AttributeAliasStateEventDto.AttributeAliasStateCreatedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setActive(e.getActive());
        return dto;
    }

    public AttributeAliasStateEventDto.AttributeAliasStateMergePatchedDto toAttributeAliasStateMergePatchedDto(AttributeAliasStateEvent.AttributeAliasStateMergePatched e) {
        AttributeAliasStateEventDto.AttributeAliasStateMergePatchedDto dto = new AttributeAliasStateEventDto.AttributeAliasStateMergePatchedDto();
        dto.setStateEventId(e.getStateEventId());
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


    public AttributeAliasStateEventDto.AttributeAliasStateRemovedDto toAttributeAliasStateRemovedDto(AttributeAliasStateEvent.AttributeAliasStateRemoved e) {
        AttributeAliasStateEventDto.AttributeAliasStateRemovedDto dto = new AttributeAliasStateEventDto.AttributeAliasStateRemovedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

