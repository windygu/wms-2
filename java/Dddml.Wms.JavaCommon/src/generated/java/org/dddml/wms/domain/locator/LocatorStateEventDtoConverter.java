package org.dddml.wms.domain.locator;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class LocatorStateEventDtoConverter {

    public LocatorStateEventDto toLocatorStateEventDto(AbstractLocatorStateEvent stateEvent) {
        if (stateEvent instanceof AbstractLocatorStateEvent.AbstractLocatorStateCreated) {
            LocatorStateEvent.LocatorStateCreated e = (LocatorStateEvent.LocatorStateCreated) stateEvent;
            return toLocatorStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractLocatorStateEvent.AbstractLocatorStateMergePatched) {
            LocatorStateEvent.LocatorStateMergePatched e = (LocatorStateEvent.LocatorStateMergePatched) stateEvent;
            return toLocatorStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractLocatorStateEvent.AbstractLocatorStateDeleted) {
            LocatorStateEvent.LocatorStateDeleted e = (LocatorStateEvent.LocatorStateDeleted) stateEvent;
            return toLocatorStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public LocatorStateEventDto.LocatorStateCreatedDto toLocatorStateCreatedDto(LocatorStateEvent.LocatorStateCreated e) {
        LocatorStateEventDto.LocatorStateCreatedDto dto = new LocatorStateEventDto.LocatorStateCreatedDto();
        dto.setStateEventId(new LocatorStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setWarehouseId(e.getWarehouseId());
        dto.setParentLocatorId(e.getParentLocatorId());
        dto.setLocatorType(e.getLocatorType());
        dto.setPriorityNumber(e.getPriorityNumber());
        dto.setIsDefault(e.getIsDefault());
        dto.setX(e.getX());
        dto.setY(e.getY());
        dto.setZ(e.getZ());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public LocatorStateEventDto.LocatorStateMergePatchedDto toLocatorStateMergePatchedDto(LocatorStateEvent.LocatorStateMergePatched e) {
        LocatorStateEventDto.LocatorStateMergePatchedDto dto = new LocatorStateEventDto.LocatorStateMergePatchedDto();
        dto.setStateEventId(new LocatorStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setWarehouseId(e.getWarehouseId());
        dto.setParentLocatorId(e.getParentLocatorId());
        dto.setLocatorType(e.getLocatorType());
        dto.setPriorityNumber(e.getPriorityNumber());
        dto.setIsDefault(e.getIsDefault());
        dto.setX(e.getX());
        dto.setY(e.getY());
        dto.setZ(e.getZ());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyWarehouseIdRemoved(e.getIsPropertyWarehouseIdRemoved());
        dto.setIsPropertyParentLocatorIdRemoved(e.getIsPropertyParentLocatorIdRemoved());
        dto.setIsPropertyLocatorTypeRemoved(e.getIsPropertyLocatorTypeRemoved());
        dto.setIsPropertyPriorityNumberRemoved(e.getIsPropertyPriorityNumberRemoved());
        dto.setIsPropertyIsDefaultRemoved(e.getIsPropertyIsDefaultRemoved());
        dto.setIsPropertyXRemoved(e.getIsPropertyXRemoved());
        dto.setIsPropertyYRemoved(e.getIsPropertyYRemoved());
        dto.setIsPropertyZRemoved(e.getIsPropertyZRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public LocatorStateEventDto.LocatorStateDeletedDto toLocatorStateDeletedDto(LocatorStateEvent.LocatorStateDeleted e) {
        LocatorStateEventDto.LocatorStateDeletedDto dto = new LocatorStateEventDto.LocatorStateDeletedDto();
        dto.setStateEventId(new LocatorStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

