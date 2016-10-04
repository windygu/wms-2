package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;

public class PermissionStateEventDtoConverter {

    public PermissionStateEventDto toPermissionStateEventDto(AbstractPermissionStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            PermissionStateEvent.PermissionStateCreated e = (PermissionStateEvent.PermissionStateCreated) stateEvent;
            return toPermissionStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            PermissionStateEvent.PermissionStateMergePatched e = (PermissionStateEvent.PermissionStateMergePatched) stateEvent;
            return toPermissionStateMergePatchedDto(e);
        } else if (StateEventType.DELETED.equals(stateEvent.getStateEventType())) {
            PermissionStateEvent.PermissionStateDeleted e = (PermissionStateEvent.PermissionStateDeleted) stateEvent;
            return toPermissionStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public PermissionStateEventDto.PermissionStateCreatedDto toPermissionStateCreatedDto(PermissionStateEvent.PermissionStateCreated e) {
        PermissionStateEventDto.PermissionStateCreatedDto dto = new PermissionStateEventDto.PermissionStateCreatedDto();
        dto.setStateEventId(new PermissionStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setParentPermissionId(e.getParentPermissionId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public PermissionStateEventDto.PermissionStateMergePatchedDto toPermissionStateMergePatchedDto(PermissionStateEvent.PermissionStateMergePatched e) {
        PermissionStateEventDto.PermissionStateMergePatchedDto dto = new PermissionStateEventDto.PermissionStateMergePatchedDto();
        dto.setStateEventId(new PermissionStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setName(e.getName());
        dto.setParentPermissionId(e.getParentPermissionId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyNameRemoved(e.getIsPropertyNameRemoved());
        dto.setIsPropertyParentPermissionIdRemoved(e.getIsPropertyParentPermissionIdRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public PermissionStateEventDto.PermissionStateDeletedDto toPermissionStateDeletedDto(PermissionStateEvent.PermissionStateDeleted e) {
        PermissionStateEventDto.PermissionStateDeletedDto dto = new PermissionStateEventDto.PermissionStateDeletedDto();
        dto.setStateEventId(new PermissionStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

