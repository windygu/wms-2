package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PicklistBinStateEventDtoConverter {

    public PicklistBinStateEventDto toPicklistBinStateEventDto(AbstractPicklistBinEvent stateEvent) {
        if (stateEvent instanceof AbstractPicklistBinEvent.AbstractPicklistBinStateCreated) {
            PicklistBinEvent.PicklistBinStateCreated e = (PicklistBinEvent.PicklistBinStateCreated) stateEvent;
            return toPicklistBinStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPicklistBinEvent.AbstractPicklistBinStateMergePatched) {
            PicklistBinEvent.PicklistBinStateMergePatched e = (PicklistBinEvent.PicklistBinStateMergePatched) stateEvent;
            return toPicklistBinStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractPicklistBinEvent.AbstractPicklistBinStateDeleted) {
            PicklistBinEvent.PicklistBinStateDeleted e = (PicklistBinEvent.PicklistBinStateDeleted) stateEvent;
            return toPicklistBinStateDeletedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public PicklistBinStateEventDto.PicklistBinStateCreatedDto toPicklistBinStateCreatedDto(PicklistBinEvent.PicklistBinStateCreated e) {
        PicklistBinStateEventDto.PicklistBinStateCreatedDto dto = new PicklistBinStateEventDto.PicklistBinStateCreatedDto();
        dto.setPicklistBinEventId(e.getPicklistBinEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setPicklistId(e.getPicklistId());
        dto.setBinLocationNumber(e.getBinLocationNumber());
        dto.setPrimaryOrderId(e.getPrimaryOrderId());
        dto.setPrimaryShipGroupSeqId(e.getPrimaryShipGroupSeqId());
        dto.setActive(e.getActive());
        List<PicklistItemStateEventDto.PicklistItemStateCreatedDto> picklistItemEvents = new ArrayList<>();
        for (PicklistItemEvent.PicklistItemStateCreated ee : e.getPicklistItemEvents()) {
            PicklistItemStateEventDto.PicklistItemStateCreatedDto eeDto = getPicklistItemStateEventDtoConverter().toPicklistItemStateCreatedDto(ee);
            picklistItemEvents.add(eeDto);
        }
        dto.setPicklistItemEvents(picklistItemEvents.toArray(new PicklistItemStateEventDto.PicklistItemStateCreatedDto[0]));

        return dto;
    }

    public PicklistBinStateEventDto.PicklistBinStateMergePatchedDto toPicklistBinStateMergePatchedDto(PicklistBinEvent.PicklistBinStateMergePatched e) {
        PicklistBinStateEventDto.PicklistBinStateMergePatchedDto dto = new PicklistBinStateEventDto.PicklistBinStateMergePatchedDto();
        dto.setPicklistBinEventId(e.getPicklistBinEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setPicklistId(e.getPicklistId());
        dto.setBinLocationNumber(e.getBinLocationNumber());
        dto.setPrimaryOrderId(e.getPrimaryOrderId());
        dto.setPrimaryShipGroupSeqId(e.getPrimaryShipGroupSeqId());
        dto.setActive(e.getActive());
        dto.setIsPropertyPicklistIdRemoved(e.getIsPropertyPicklistIdRemoved());
        dto.setIsPropertyBinLocationNumberRemoved(e.getIsPropertyBinLocationNumberRemoved());
        dto.setIsPropertyPrimaryOrderIdRemoved(e.getIsPropertyPrimaryOrderIdRemoved());
        dto.setIsPropertyPrimaryShipGroupSeqIdRemoved(e.getIsPropertyPrimaryShipGroupSeqIdRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        List<PicklistItemStateEventDto> picklistItemEvents = new ArrayList<>();
        for (PicklistItemEvent ee : e.getPicklistItemEvents()) {
            PicklistItemStateEventDto eeDto = getPicklistItemStateEventDtoConverter().toPicklistItemStateEventDto((AbstractPicklistItemEvent) ee);
            picklistItemEvents.add(eeDto);
        }
        dto.setPicklistItemEvents(picklistItemEvents.toArray(new PicklistItemStateEventDto[0]));

        return dto;
    }


    public PicklistBinStateEventDto.PicklistBinStateDeletedDto toPicklistBinStateDeletedDto(PicklistBinEvent.PicklistBinStateDeleted e) {
        PicklistBinStateEventDto.PicklistBinStateDeletedDto dto = new PicklistBinStateEventDto.PicklistBinStateDeletedDto();
        dto.setPicklistBinEventId(e.getPicklistBinEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        List<PicklistItemStateEventDto.PicklistItemStateRemovedDto> picklistItemEvents = new ArrayList<>();
        for (PicklistItemEvent.PicklistItemStateRemoved ee : e.getPicklistItemEvents()) {
            PicklistItemStateEventDto.PicklistItemStateRemovedDto eeDto = getPicklistItemStateEventDtoConverter().toPicklistItemStateRemovedDto(ee);
            picklistItemEvents.add(eeDto);
        }
        dto.setPicklistItemEvents(picklistItemEvents.toArray(new PicklistItemStateEventDto.PicklistItemStateRemovedDto[0]));

        return dto;
    }

    protected PicklistItemStateEventDtoConverter getPicklistItemStateEventDtoConverter() {
        return new PicklistItemStateEventDtoConverter();
    }

}

