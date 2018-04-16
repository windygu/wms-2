package org.dddml.wms.domain.uom;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class UomStateEventDtoConverter {

    public UomStateEventDto toUomStateEventDto(AbstractUomEvent stateEvent) {
        if (stateEvent instanceof AbstractUomEvent.AbstractUomStateCreated) {
            UomEvent.UomStateCreated e = (UomEvent.UomStateCreated) stateEvent;
            return toUomStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractUomEvent.AbstractUomStateMergePatched) {
            UomEvent.UomStateMergePatched e = (UomEvent.UomStateMergePatched) stateEvent;
            return toUomStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractUomEvent.AbstractUomStateDeleted) {
            UomEvent.UomStateDeleted e = (UomEvent.UomStateDeleted) stateEvent;
            return toUomStateDeletedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public UomStateEventDto.UomStateCreatedDto toUomStateCreatedDto(UomEvent.UomStateCreated e) {
        UomStateEventDto.UomStateCreatedDto dto = new UomStateEventDto.UomStateCreatedDto();
        dto.setUomEventId(e.getUomEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setUomTypeId(e.getUomTypeId());
        dto.setAbbreviation(e.getAbbreviation());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public UomStateEventDto.UomStateMergePatchedDto toUomStateMergePatchedDto(UomEvent.UomStateMergePatched e) {
        UomStateEventDto.UomStateMergePatchedDto dto = new UomStateEventDto.UomStateMergePatchedDto();
        dto.setUomEventId(e.getUomEventId());
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


    public UomStateEventDto.UomStateDeletedDto toUomStateDeletedDto(UomEvent.UomStateDeleted e) {
        UomStateEventDto.UomStateDeletedDto dto = new UomStateEventDto.UomStateDeletedDto();
        dto.setUomEventId(e.getUomEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

