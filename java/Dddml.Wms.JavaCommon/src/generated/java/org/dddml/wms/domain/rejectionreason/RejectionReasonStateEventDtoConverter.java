package org.dddml.wms.domain.rejectionreason;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class RejectionReasonStateEventDtoConverter {

    public RejectionReasonStateEventDto toRejectionReasonStateEventDto(AbstractRejectionReasonEvent stateEvent) {
        if (stateEvent instanceof AbstractRejectionReasonEvent.AbstractRejectionReasonStateCreated) {
            RejectionReasonEvent.RejectionReasonStateCreated e = (RejectionReasonEvent.RejectionReasonStateCreated) stateEvent;
            return toRejectionReasonStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractRejectionReasonEvent.AbstractRejectionReasonStateMergePatched) {
            RejectionReasonEvent.RejectionReasonStateMergePatched e = (RejectionReasonEvent.RejectionReasonStateMergePatched) stateEvent;
            return toRejectionReasonStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractRejectionReasonEvent.AbstractRejectionReasonStateDeleted) {
            RejectionReasonEvent.RejectionReasonStateDeleted e = (RejectionReasonEvent.RejectionReasonStateDeleted) stateEvent;
            return toRejectionReasonStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public RejectionReasonStateEventDto.RejectionReasonStateCreatedDto toRejectionReasonStateCreatedDto(RejectionReasonEvent.RejectionReasonStateCreated e) {
        RejectionReasonStateEventDto.RejectionReasonStateCreatedDto dto = new RejectionReasonStateEventDto.RejectionReasonStateCreatedDto();
        dto.setRejectionReasonEventId(e.getRejectionReasonEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public RejectionReasonStateEventDto.RejectionReasonStateMergePatchedDto toRejectionReasonStateMergePatchedDto(RejectionReasonEvent.RejectionReasonStateMergePatched e) {
        RejectionReasonStateEventDto.RejectionReasonStateMergePatchedDto dto = new RejectionReasonStateEventDto.RejectionReasonStateMergePatchedDto();
        dto.setRejectionReasonEventId(e.getRejectionReasonEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public RejectionReasonStateEventDto.RejectionReasonStateDeletedDto toRejectionReasonStateDeletedDto(RejectionReasonEvent.RejectionReasonStateDeleted e) {
        RejectionReasonStateEventDto.RejectionReasonStateDeletedDto dto = new RejectionReasonStateEventDto.RejectionReasonStateDeletedDto();
        dto.setRejectionReasonEventId(e.getRejectionReasonEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

