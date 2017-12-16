package org.dddml.wms.domain.statusitem;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class StatusItemStateEventDtoConverter {

    public StatusItemStateEventDto toStatusItemStateEventDto(AbstractStatusItemStateEvent stateEvent) {
        if (stateEvent instanceof AbstractStatusItemStateEvent.AbstractStatusItemStateCreated) {
            StatusItemStateEvent.StatusItemStateCreated e = (StatusItemStateEvent.StatusItemStateCreated) stateEvent;
            return toStatusItemStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractStatusItemStateEvent.AbstractStatusItemStateMergePatched) {
            StatusItemStateEvent.StatusItemStateMergePatched e = (StatusItemStateEvent.StatusItemStateMergePatched) stateEvent;
            return toStatusItemStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public StatusItemStateEventDto.StatusItemStateCreatedDto toStatusItemStateCreatedDto(StatusItemStateEvent.StatusItemStateCreated e) {
        StatusItemStateEventDto.StatusItemStateCreatedDto dto = new StatusItemStateEventDto.StatusItemStateCreatedDto();
        dto.setStateEventId(new StatusItemStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setStatusTypeId(e.getStatusTypeId());
        dto.setStatusCode(e.getStatusCode());
        dto.setSequenceId(e.getSequenceId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public StatusItemStateEventDto.StatusItemStateMergePatchedDto toStatusItemStateMergePatchedDto(StatusItemStateEvent.StatusItemStateMergePatched e) {
        StatusItemStateEventDto.StatusItemStateMergePatchedDto dto = new StatusItemStateEventDto.StatusItemStateMergePatchedDto();
        dto.setStateEventId(new StatusItemStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setStatusTypeId(e.getStatusTypeId());
        dto.setStatusCode(e.getStatusCode());
        dto.setSequenceId(e.getSequenceId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyStatusTypeIdRemoved(e.getIsPropertyStatusTypeIdRemoved());
        dto.setIsPropertyStatusCodeRemoved(e.getIsPropertyStatusCodeRemoved());
        dto.setIsPropertySequenceIdRemoved(e.getIsPropertySequenceIdRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


}

