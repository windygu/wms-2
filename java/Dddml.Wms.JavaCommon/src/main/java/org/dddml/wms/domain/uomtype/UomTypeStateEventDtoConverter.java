package org.dddml.wms.domain.uomtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class UomTypeStateEventDtoConverter {

    public UomTypeStateEventDto toUomTypeStateEventDto(AbstractUomTypeStateEvent stateEvent) {
        if (stateEvent instanceof AbstractUomTypeStateEvent.AbstractUomTypeStateCreated) {
            UomTypeStateEvent.UomTypeStateCreated e = (UomTypeStateEvent.UomTypeStateCreated) stateEvent;
            return toUomTypeStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractUomTypeStateEvent.AbstractUomTypeStateMergePatched) {
            UomTypeStateEvent.UomTypeStateMergePatched e = (UomTypeStateEvent.UomTypeStateMergePatched) stateEvent;
            return toUomTypeStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractUomTypeStateEvent.AbstractUomTypeStateDeleted) {
            UomTypeStateEvent.UomTypeStateDeleted e = (UomTypeStateEvent.UomTypeStateDeleted) stateEvent;
            return toUomTypeStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public UomTypeStateEventDto.UomTypeStateCreatedDto toUomTypeStateCreatedDto(UomTypeStateEvent.UomTypeStateCreated e) {
        UomTypeStateEventDto.UomTypeStateCreatedDto dto = new UomTypeStateEventDto.UomTypeStateCreatedDto();
        dto.setStateEventId(new UomTypeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setParentTypeId(e.getParentTypeId());
        dto.setHasTable(e.getHasTable());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public UomTypeStateEventDto.UomTypeStateMergePatchedDto toUomTypeStateMergePatchedDto(UomTypeStateEvent.UomTypeStateMergePatched e) {
        UomTypeStateEventDto.UomTypeStateMergePatchedDto dto = new UomTypeStateEventDto.UomTypeStateMergePatchedDto();
        dto.setStateEventId(new UomTypeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setParentTypeId(e.getParentTypeId());
        dto.setHasTable(e.getHasTable());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyParentTypeIdRemoved(e.getIsPropertyParentTypeIdRemoved());
        dto.setIsPropertyHasTableRemoved(e.getIsPropertyHasTableRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public UomTypeStateEventDto.UomTypeStateDeletedDto toUomTypeStateDeletedDto(UomTypeStateEvent.UomTypeStateDeleted e) {
        UomTypeStateEventDto.UomTypeStateDeletedDto dto = new UomTypeStateEventDto.UomTypeStateDeletedDto();
        dto.setStateEventId(new UomTypeStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

