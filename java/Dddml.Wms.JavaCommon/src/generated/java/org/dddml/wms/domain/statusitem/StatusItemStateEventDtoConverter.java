package org.dddml.wms.domain.statusitem;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class StatusItemStateEventDtoConverter {

    public StatusItemStateEventDto toStatusItemStateEventDto(AbstractStatusItemEvent stateEvent) {
        if (stateEvent instanceof AbstractStatusItemEvent.AbstractStatusItemStateCreated) {
            StatusItemEvent.StatusItemStateCreated e = (StatusItemEvent.StatusItemStateCreated) stateEvent;
            return toStatusItemStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractStatusItemEvent.AbstractStatusItemStateMergePatched) {
            StatusItemEvent.StatusItemStateMergePatched e = (StatusItemEvent.StatusItemStateMergePatched) stateEvent;
            return toStatusItemStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public StatusItemStateEventDto.StatusItemStateCreatedDto toStatusItemStateCreatedDto(StatusItemEvent.StatusItemStateCreated e) {
        StatusItemStateEventDto.StatusItemStateCreatedDto dto = new StatusItemStateEventDto.StatusItemStateCreatedDto();
        dto.setStatusItemEventId(e.getStatusItemEventId());
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

    public StatusItemStateEventDto.StatusItemStateMergePatchedDto toStatusItemStateMergePatchedDto(StatusItemEvent.StatusItemStateMergePatched e) {
        StatusItemStateEventDto.StatusItemStateMergePatchedDto dto = new StatusItemStateEventDto.StatusItemStateMergePatchedDto();
        dto.setStatusItemEventId(e.getStatusItemEventId());
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

