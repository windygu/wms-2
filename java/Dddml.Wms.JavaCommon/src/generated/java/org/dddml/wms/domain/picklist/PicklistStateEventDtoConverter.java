package org.dddml.wms.domain.picklist;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PicklistStateEventDtoConverter {

    public PicklistStateEventDto toPicklistStateEventDto(AbstractPicklistStateEvent stateEvent) {
        if (stateEvent instanceof AbstractPicklistStateEvent.AbstractPicklistStateCreated) {
            PicklistStateEvent.PicklistStateCreated e = (PicklistStateEvent.PicklistStateCreated) stateEvent;
            return toPicklistStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPicklistStateEvent.AbstractPicklistStateMergePatched) {
            PicklistStateEvent.PicklistStateMergePatched e = (PicklistStateEvent.PicklistStateMergePatched) stateEvent;
            return toPicklistStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractPicklistStateEvent.AbstractPicklistStateDeleted) {
            PicklistStateEvent.PicklistStateDeleted e = (PicklistStateEvent.PicklistStateDeleted) stateEvent;
            return toPicklistStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public PicklistStateEventDto.PicklistStateCreatedDto toPicklistStateCreatedDto(PicklistStateEvent.PicklistStateCreated e) {
        PicklistStateEventDto.PicklistStateCreatedDto dto = new PicklistStateEventDto.PicklistStateCreatedDto();
        dto.setPicklistEventId(e.getPicklistEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedByUserLogin(e.getCreatedByUserLogin());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setFacilityId(e.getFacilityId());
        dto.setShipmentMethodTypeId(e.getShipmentMethodTypeId());
        dto.setStatusId(e.getStatusId());
        dto.setPicklistDate(e.getPicklistDate());
        dto.setActive(e.getActive());
        List<PicklistRoleStateEventDto.PicklistRoleStateCreatedDto> picklistRoleEvents = new ArrayList<>();
        for (PicklistRoleStateEvent.PicklistRoleStateCreated ee : e.getPicklistRoleEvents()) {
            PicklistRoleStateEventDto.PicklistRoleStateCreatedDto eeDto = getPicklistRoleStateEventDtoConverter().toPicklistRoleStateCreatedDto(ee);
            picklistRoleEvents.add(eeDto);
        }
        dto.setPicklistRoleEvents(picklistRoleEvents.toArray(new PicklistRoleStateEventDto.PicklistRoleStateCreatedDto[0]));

        return dto;
    }

    public PicklistStateEventDto.PicklistStateMergePatchedDto toPicklistStateMergePatchedDto(PicklistStateEvent.PicklistStateMergePatched e) {
        PicklistStateEventDto.PicklistStateMergePatchedDto dto = new PicklistStateEventDto.PicklistStateMergePatchedDto();
        dto.setPicklistEventId(e.getPicklistEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedByUserLogin(e.getCreatedByUserLogin());
        dto.setCommandId(e.getCommandId());
        dto.setDescription(e.getDescription());
        dto.setFacilityId(e.getFacilityId());
        dto.setShipmentMethodTypeId(e.getShipmentMethodTypeId());
        dto.setStatusId(e.getStatusId());
        dto.setPicklistDate(e.getPicklistDate());
        dto.setActive(e.getActive());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyFacilityIdRemoved(e.getIsPropertyFacilityIdRemoved());
        dto.setIsPropertyShipmentMethodTypeIdRemoved(e.getIsPropertyShipmentMethodTypeIdRemoved());
        dto.setIsPropertyStatusIdRemoved(e.getIsPropertyStatusIdRemoved());
        dto.setIsPropertyPicklistDateRemoved(e.getIsPropertyPicklistDateRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        List<PicklistRoleStateEventDto> picklistRoleEvents = new ArrayList<>();
        for (PicklistRoleStateEvent ee : e.getPicklistRoleEvents()) {
            PicklistRoleStateEventDto eeDto = getPicklistRoleStateEventDtoConverter().toPicklistRoleStateEventDto((AbstractPicklistRoleStateEvent) ee);
            picklistRoleEvents.add(eeDto);
        }
        dto.setPicklistRoleEvents(picklistRoleEvents.toArray(new PicklistRoleStateEventDto[0]));

        return dto;
    }


    public PicklistStateEventDto.PicklistStateDeletedDto toPicklistStateDeletedDto(PicklistStateEvent.PicklistStateDeleted e) {
        PicklistStateEventDto.PicklistStateDeletedDto dto = new PicklistStateEventDto.PicklistStateDeletedDto();
        dto.setPicklistEventId(e.getPicklistEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedByUserLogin(e.getCreatedByUserLogin());
        dto.setCommandId(e.getCommandId());
        List<PicklistRoleStateEventDto.PicklistRoleStateRemovedDto> picklistRoleEvents = new ArrayList<>();
        for (PicklistRoleStateEvent.PicklistRoleStateRemoved ee : e.getPicklistRoleEvents()) {
            PicklistRoleStateEventDto.PicklistRoleStateRemovedDto eeDto = getPicklistRoleStateEventDtoConverter().toPicklistRoleStateRemovedDto(ee);
            picklistRoleEvents.add(eeDto);
        }
        dto.setPicklistRoleEvents(picklistRoleEvents.toArray(new PicklistRoleStateEventDto.PicklistRoleStateRemovedDto[0]));

        return dto;
    }

    protected PicklistRoleStateEventDtoConverter getPicklistRoleStateEventDtoConverter() {
        return new PicklistRoleStateEventDtoConverter();
    }

}

