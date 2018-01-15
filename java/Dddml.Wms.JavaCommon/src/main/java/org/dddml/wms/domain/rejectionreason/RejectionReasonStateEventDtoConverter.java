package org.dddml.wms.domain.rejectionreason;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class RejectionReasonStateEventDtoConverter {

    public RejectionReasonStateEventDto toRejectionReasonStateEventDto(AbstractRejectionReasonStateEvent stateEvent) {
        if (stateEvent instanceof AbstractRejectionReasonStateEvent.AbstractRejectionReasonStateCreated) {
            RejectionReasonStateEvent.RejectionReasonStateCreated e = (RejectionReasonStateEvent.RejectionReasonStateCreated) stateEvent;
            return toRejectionReasonStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractRejectionReasonStateEvent.AbstractRejectionReasonStateMergePatched) {
            RejectionReasonStateEvent.RejectionReasonStateMergePatched e = (RejectionReasonStateEvent.RejectionReasonStateMergePatched) stateEvent;
            return toRejectionReasonStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractRejectionReasonStateEvent.AbstractRejectionReasonStateDeleted) {
            RejectionReasonStateEvent.RejectionReasonStateDeleted e = (RejectionReasonStateEvent.RejectionReasonStateDeleted) stateEvent;
            return toRejectionReasonStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public RejectionReasonStateEventDto.RejectionReasonStateCreatedDto toRejectionReasonStateCreatedDto(RejectionReasonStateEvent.RejectionReasonStateCreated e) {
        RejectionReasonStateEventDto.RejectionReasonStateCreatedDto dto = new RejectionReasonStateEventDto.RejectionReasonStateCreatedDto();
        dto.setStateEventId(new RejectionReasonStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public RejectionReasonStateEventDto.RejectionReasonStateMergePatchedDto toRejectionReasonStateMergePatchedDto(RejectionReasonStateEvent.RejectionReasonStateMergePatched e) {
        RejectionReasonStateEventDto.RejectionReasonStateMergePatchedDto dto = new RejectionReasonStateEventDto.RejectionReasonStateMergePatchedDto();
        dto.setStateEventId(new RejectionReasonStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public RejectionReasonStateEventDto.RejectionReasonStateDeletedDto toRejectionReasonStateDeletedDto(RejectionReasonStateEvent.RejectionReasonStateDeleted e) {
        RejectionReasonStateEventDto.RejectionReasonStateDeletedDto dto = new RejectionReasonStateEventDto.RejectionReasonStateDeletedDto();
        dto.setStateEventId(new RejectionReasonStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

