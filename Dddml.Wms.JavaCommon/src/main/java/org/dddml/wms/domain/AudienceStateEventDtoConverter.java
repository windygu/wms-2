package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;

public class AudienceStateEventDtoConverter {

    public AudienceStateEventDto toAudienceStateEventDto(AbstractAudienceStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            AudienceStateEvent.AudienceStateCreated e = (AudienceStateEvent.AudienceStateCreated) stateEvent;
            return toAudienceStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            AudienceStateEvent.AudienceStateMergePatched e = (AudienceStateEvent.AudienceStateMergePatched) stateEvent;
            return toAudienceStateMergePatchedDto(e);
        } else if (StateEventType.DELETED.equals(stateEvent.getStateEventType())) {
            AudienceStateEvent.AudienceStateDeleted e = (AudienceStateEvent.AudienceStateDeleted) stateEvent;
            return toAudienceStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public AudienceStateEventDto.AudienceStateCreatedDto toAudienceStateCreatedDto(AudienceStateEvent.AudienceStateCreated e) {
        AudienceStateEventDto.AudienceStateCreatedDto dto = new AudienceStateEventDto.AudienceStateCreatedDto();
        dto.setStateEventId(new AudienceStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setBase64Secret(e.getBase64Secret());
        dto.setActive(e.getActive());
        return dto;
    }

    public AudienceStateEventDto.AudienceStateMergePatchedDto toAudienceStateMergePatchedDto(AudienceStateEvent.AudienceStateMergePatched e) {
        AudienceStateEventDto.AudienceStateMergePatchedDto dto = new AudienceStateEventDto.AudienceStateMergePatchedDto();
        dto.setStateEventId(new AudienceStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setBase64Secret(e.getBase64Secret());
        dto.setActive(e.getActive());
        dto.setIsPropertyNameRemoved(e.getIsPropertyNameRemoved());
        dto.setIsPropertyBase64SecretRemoved(e.getIsPropertyBase64SecretRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public AudienceStateEventDto.AudienceStateDeletedDto toAudienceStateDeletedDto(AudienceStateEvent.AudienceStateDeleted e) {
        AudienceStateEventDto.AudienceStateDeletedDto dto = new AudienceStateEventDto.AudienceStateDeletedDto();
        dto.setStateEventId(new AudienceStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

