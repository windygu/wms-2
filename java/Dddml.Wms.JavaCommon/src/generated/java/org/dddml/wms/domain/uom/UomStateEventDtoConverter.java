package org.dddml.wms.domain.uom;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class UomStateEventDtoConverter {

    public UomStateEventDto toUomStateEventDto(AbstractUomStateEvent stateEvent) {
        if (stateEvent instanceof AbstractUomStateEvent.AbstractUomStateCreated) {
            UomStateEvent.UomStateCreated e = (UomStateEvent.UomStateCreated) stateEvent;
            return toUomStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractUomStateEvent.AbstractUomStateMergePatched) {
            UomStateEvent.UomStateMergePatched e = (UomStateEvent.UomStateMergePatched) stateEvent;
            return toUomStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractUomStateEvent.AbstractUomStateDeleted) {
            UomStateEvent.UomStateDeleted e = (UomStateEvent.UomStateDeleted) stateEvent;
            return toUomStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public UomStateEventDto.UomStateCreatedDto toUomStateCreatedDto(UomStateEvent.UomStateCreated e) {
        UomStateEventDto.UomStateCreatedDto dto = new UomStateEventDto.UomStateCreatedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setUomTypeId(e.getUomTypeId());
        dto.setAbbreviation(e.getAbbreviation());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public UomStateEventDto.UomStateMergePatchedDto toUomStateMergePatchedDto(UomStateEvent.UomStateMergePatched e) {
        UomStateEventDto.UomStateMergePatchedDto dto = new UomStateEventDto.UomStateMergePatchedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setUomTypeId(e.getUomTypeId());
        dto.setAbbreviation(e.getAbbreviation());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        dto.setIsPropertyUomTypeIdRemoved(e.getIsPropertyUomTypeIdRemoved());
        dto.setIsPropertyAbbreviationRemoved(e.getIsPropertyAbbreviationRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public UomStateEventDto.UomStateDeletedDto toUomStateDeletedDto(UomStateEvent.UomStateDeleted e) {
        UomStateEventDto.UomStateDeletedDto dto = new UomStateEventDto.UomStateDeletedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

