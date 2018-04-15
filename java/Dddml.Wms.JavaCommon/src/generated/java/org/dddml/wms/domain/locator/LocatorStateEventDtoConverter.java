package org.dddml.wms.domain.locator;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class LocatorStateEventDtoConverter {

    public LocatorStateEventDto toLocatorStateEventDto(AbstractLocatorEvent stateEvent) {
        if (stateEvent instanceof AbstractLocatorEvent.AbstractLocatorStateCreated) {
            LocatorEvent.LocatorStateCreated e = (LocatorEvent.LocatorStateCreated) stateEvent;
            return toLocatorStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractLocatorEvent.AbstractLocatorStateMergePatched) {
            LocatorEvent.LocatorStateMergePatched e = (LocatorEvent.LocatorStateMergePatched) stateEvent;
            return toLocatorStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractLocatorEvent.AbstractLocatorStateDeleted) {
            LocatorEvent.LocatorStateDeleted e = (LocatorEvent.LocatorStateDeleted) stateEvent;
            return toLocatorStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public LocatorStateEventDto.LocatorStateCreatedDto toLocatorStateCreatedDto(LocatorEvent.LocatorStateCreated e) {
        LocatorStateEventDto.LocatorStateCreatedDto dto = new LocatorStateEventDto.LocatorStateCreatedDto();
        dto.setLocatorEventId(e.getLocatorEventId());
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
        dto.setLocatorTypeId(e.getLocatorTypeId());
        dto.setActive(e.getActive());
        return dto;
    }

    public LocatorStateEventDto.LocatorStateMergePatchedDto toLocatorStateMergePatchedDto(LocatorEvent.LocatorStateMergePatched e) {
        LocatorStateEventDto.LocatorStateMergePatchedDto dto = new LocatorStateEventDto.LocatorStateMergePatchedDto();
        dto.setLocatorEventId(e.getLocatorEventId());
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
        dto.setLocatorTypeId(e.getLocatorTypeId());
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
        dto.setIsPropertyLocatorTypeIdRemoved(e.getIsPropertyLocatorTypeIdRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public LocatorStateEventDto.LocatorStateDeletedDto toLocatorStateDeletedDto(LocatorEvent.LocatorStateDeleted e) {
        LocatorStateEventDto.LocatorStateDeletedDto dto = new LocatorStateEventDto.LocatorStateDeletedDto();
        dto.setLocatorEventId(e.getLocatorEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

