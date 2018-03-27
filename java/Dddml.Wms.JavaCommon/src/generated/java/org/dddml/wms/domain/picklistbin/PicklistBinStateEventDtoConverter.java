package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PicklistBinStateEventDtoConverter {

    public PicklistBinStateEventDto toPicklistBinStateEventDto(AbstractPicklistBinStateEvent stateEvent) {
        if (stateEvent instanceof AbstractPicklistBinStateEvent.AbstractPicklistBinStateCreated) {
            PicklistBinStateEvent.PicklistBinStateCreated e = (PicklistBinStateEvent.PicklistBinStateCreated) stateEvent;
            return toPicklistBinStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPicklistBinStateEvent.AbstractPicklistBinStateMergePatched) {
            PicklistBinStateEvent.PicklistBinStateMergePatched e = (PicklistBinStateEvent.PicklistBinStateMergePatched) stateEvent;
            return toPicklistBinStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractPicklistBinStateEvent.AbstractPicklistBinStateDeleted) {
            PicklistBinStateEvent.PicklistBinStateDeleted e = (PicklistBinStateEvent.PicklistBinStateDeleted) stateEvent;
            return toPicklistBinStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public PicklistBinStateEventDto.PicklistBinStateCreatedDto toPicklistBinStateCreatedDto(PicklistBinStateEvent.PicklistBinStateCreated e) {
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
        for (PicklistItemStateEvent.PicklistItemStateCreated ee : e.getPicklistItemEvents()) {
            PicklistItemStateEventDto.PicklistItemStateCreatedDto eeDto = getPicklistItemStateEventDtoConverter().toPicklistItemStateCreatedDto(ee);
            picklistItemEvents.add(eeDto);
        }
        dto.setPicklistItemEvents(picklistItemEvents.toArray(new PicklistItemStateEventDto.PicklistItemStateCreatedDto[0]));

        return dto;
    }

    public PicklistBinStateEventDto.PicklistBinStateMergePatchedDto toPicklistBinStateMergePatchedDto(PicklistBinStateEvent.PicklistBinStateMergePatched e) {
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
        for (PicklistItemStateEvent ee : e.getPicklistItemEvents()) {
            PicklistItemStateEventDto eeDto = getPicklistItemStateEventDtoConverter().toPicklistItemStateEventDto((AbstractPicklistItemStateEvent) ee);
            picklistItemEvents.add(eeDto);
        }
        dto.setPicklistItemEvents(picklistItemEvents.toArray(new PicklistItemStateEventDto[0]));

        return dto;
    }


    public PicklistBinStateEventDto.PicklistBinStateDeletedDto toPicklistBinStateDeletedDto(PicklistBinStateEvent.PicklistBinStateDeleted e) {
        PicklistBinStateEventDto.PicklistBinStateDeletedDto dto = new PicklistBinStateEventDto.PicklistBinStateDeletedDto();
        dto.setPicklistBinEventId(e.getPicklistBinEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        List<PicklistItemStateEventDto.PicklistItemStateRemovedDto> picklistItemEvents = new ArrayList<>();
        for (PicklistItemStateEvent.PicklistItemStateRemoved ee : e.getPicklistItemEvents()) {
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

