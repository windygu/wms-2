package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InOutLineImageStateEventDtoConverter {

    public InOutLineImageStateEventDto toInOutLineImageStateEventDto(AbstractInOutLineImageEvent stateEvent) {
        if (stateEvent instanceof AbstractInOutLineImageEvent.AbstractInOutLineImageStateCreated) {
            InOutLineImageEvent.InOutLineImageStateCreated e = (InOutLineImageEvent.InOutLineImageStateCreated) stateEvent;
            return toInOutLineImageStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractInOutLineImageEvent.AbstractInOutLineImageStateMergePatched) {
            InOutLineImageEvent.InOutLineImageStateMergePatched e = (InOutLineImageEvent.InOutLineImageStateMergePatched) stateEvent;
            return toInOutLineImageStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractInOutLineImageEvent.AbstractInOutLineImageStateRemoved) {
            InOutLineImageEvent.InOutLineImageStateRemoved e = (InOutLineImageEvent.InOutLineImageStateRemoved) stateEvent;
            return toInOutLineImageStateRemovedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public InOutLineImageStateEventDto.InOutLineImageStateCreatedDto toInOutLineImageStateCreatedDto(InOutLineImageEvent.InOutLineImageStateCreated e) {
        InOutLineImageStateEventDto.InOutLineImageStateCreatedDto dto = new InOutLineImageStateEventDto.InOutLineImageStateCreatedDto();
        dto.setInOutLineImageEventId(e.getInOutLineImageEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setUrl(e.getUrl());
        dto.setActive(e.getActive());
        return dto;
    }

    public InOutLineImageStateEventDto.InOutLineImageStateMergePatchedDto toInOutLineImageStateMergePatchedDto(InOutLineImageEvent.InOutLineImageStateMergePatched e) {
        InOutLineImageStateEventDto.InOutLineImageStateMergePatchedDto dto = new InOutLineImageStateEventDto.InOutLineImageStateMergePatchedDto();
        dto.setInOutLineImageEventId(e.getInOutLineImageEventId());
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


    public InOutLineImageStateEventDto.InOutLineImageStateRemovedDto toInOutLineImageStateRemovedDto(InOutLineImageEvent.InOutLineImageStateRemoved e) {
        InOutLineImageStateEventDto.InOutLineImageStateRemovedDto dto = new InOutLineImageStateEventDto.InOutLineImageStateRemovedDto();
        dto.setInOutLineImageEventId(e.getInOutLineImageEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

