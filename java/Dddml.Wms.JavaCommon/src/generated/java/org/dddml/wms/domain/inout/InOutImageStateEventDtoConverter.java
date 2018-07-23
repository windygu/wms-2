package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InOutImageStateEventDtoConverter {

    public InOutImageStateEventDto toInOutImageStateEventDto(AbstractInOutImageEvent stateEvent) {
        if (stateEvent instanceof AbstractInOutImageEvent.AbstractInOutImageStateCreated) {
            InOutImageEvent.InOutImageStateCreated e = (InOutImageEvent.InOutImageStateCreated) stateEvent;
            return toInOutImageStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractInOutImageEvent.AbstractInOutImageStateMergePatched) {
            InOutImageEvent.InOutImageStateMergePatched e = (InOutImageEvent.InOutImageStateMergePatched) stateEvent;
            return toInOutImageStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractInOutImageEvent.AbstractInOutImageStateRemoved) {
            InOutImageEvent.InOutImageStateRemoved e = (InOutImageEvent.InOutImageStateRemoved) stateEvent;
            return toInOutImageStateRemovedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public InOutImageStateEventDto.InOutImageStateCreatedDto toInOutImageStateCreatedDto(InOutImageEvent.InOutImageStateCreated e) {
        InOutImageStateEventDto.InOutImageStateCreatedDto dto = new InOutImageStateEventDto.InOutImageStateCreatedDto();
        dto.setInOutImageEventId(e.getInOutImageEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setUrl(e.getUrl());
        dto.setActive(e.getActive());
        return dto;
    }

    public InOutImageStateEventDto.InOutImageStateMergePatchedDto toInOutImageStateMergePatchedDto(InOutImageEvent.InOutImageStateMergePatched e) {
        InOutImageStateEventDto.InOutImageStateMergePatchedDto dto = new InOutImageStateEventDto.InOutImageStateMergePatchedDto();
        dto.setInOutImageEventId(e.getInOutImageEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setUrl(e.getUrl());
        dto.setActive(e.getActive());
        dto.setIsPropertyUrlRemoved(e.getIsPropertyUrlRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public InOutImageStateEventDto.InOutImageStateRemovedDto toInOutImageStateRemovedDto(InOutImageEvent.InOutImageStateRemoved e) {
        InOutImageStateEventDto.InOutImageStateRemovedDto dto = new InOutImageStateEventDto.InOutImageStateRemovedDto();
        dto.setInOutImageEventId(e.getInOutImageEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

