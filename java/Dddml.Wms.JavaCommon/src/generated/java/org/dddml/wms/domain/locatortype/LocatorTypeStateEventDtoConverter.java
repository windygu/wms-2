package org.dddml.wms.domain.locatortype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class LocatorTypeStateEventDtoConverter {

    public LocatorTypeStateEventDto toLocatorTypeStateEventDto(AbstractLocatorTypeEvent stateEvent) {
        if (stateEvent instanceof AbstractLocatorTypeEvent.AbstractLocatorTypeStateCreated) {
            LocatorTypeEvent.LocatorTypeStateCreated e = (LocatorTypeEvent.LocatorTypeStateCreated) stateEvent;
            return toLocatorTypeStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractLocatorTypeEvent.AbstractLocatorTypeStateMergePatched) {
            LocatorTypeEvent.LocatorTypeStateMergePatched e = (LocatorTypeEvent.LocatorTypeStateMergePatched) stateEvent;
            return toLocatorTypeStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractLocatorTypeEvent.AbstractLocatorTypeStateDeleted) {
            LocatorTypeEvent.LocatorTypeStateDeleted e = (LocatorTypeEvent.LocatorTypeStateDeleted) stateEvent;
            return toLocatorTypeStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public LocatorTypeStateEventDto.LocatorTypeStateCreatedDto toLocatorTypeStateCreatedDto(LocatorTypeEvent.LocatorTypeStateCreated e) {
        LocatorTypeStateEventDto.LocatorTypeStateCreatedDto dto = new LocatorTypeStateEventDto.LocatorTypeStateCreatedDto();
        dto.setLocatorTypeEventId(e.getLocatorTypeEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public LocatorTypeStateEventDto.LocatorTypeStateMergePatchedDto toLocatorTypeStateMergePatchedDto(LocatorTypeEvent.LocatorTypeStateMergePatched e) {
        LocatorTypeStateEventDto.LocatorTypeStateMergePatchedDto dto = new LocatorTypeStateEventDto.LocatorTypeStateMergePatchedDto();
        dto.setLocatorTypeEventId(e.getLocatorTypeEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public LocatorTypeStateEventDto.LocatorTypeStateDeletedDto toLocatorTypeStateDeletedDto(LocatorTypeEvent.LocatorTypeStateDeleted e) {
        LocatorTypeStateEventDto.LocatorTypeStateDeletedDto dto = new LocatorTypeStateEventDto.LocatorTypeStateDeletedDto();
        dto.setLocatorTypeEventId(e.getLocatorTypeEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

