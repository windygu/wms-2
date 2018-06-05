package org.dddml.wms.domain.goodidentificationtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class GoodIdentificationTypeStateEventDtoConverter {

    public GoodIdentificationTypeStateEventDto toGoodIdentificationTypeStateEventDto(AbstractGoodIdentificationTypeEvent stateEvent) {
        if (stateEvent instanceof AbstractGoodIdentificationTypeEvent.AbstractGoodIdentificationTypeStateCreated) {
            GoodIdentificationTypeEvent.GoodIdentificationTypeStateCreated e = (GoodIdentificationTypeEvent.GoodIdentificationTypeStateCreated) stateEvent;
            return toGoodIdentificationTypeStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractGoodIdentificationTypeEvent.AbstractGoodIdentificationTypeStateMergePatched) {
            GoodIdentificationTypeEvent.GoodIdentificationTypeStateMergePatched e = (GoodIdentificationTypeEvent.GoodIdentificationTypeStateMergePatched) stateEvent;
            return toGoodIdentificationTypeStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractGoodIdentificationTypeEvent.AbstractGoodIdentificationTypeStateDeleted) {
            GoodIdentificationTypeEvent.GoodIdentificationTypeStateDeleted e = (GoodIdentificationTypeEvent.GoodIdentificationTypeStateDeleted) stateEvent;
            return toGoodIdentificationTypeStateDeletedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public GoodIdentificationTypeStateEventDto.GoodIdentificationTypeStateCreatedDto toGoodIdentificationTypeStateCreatedDto(GoodIdentificationTypeEvent.GoodIdentificationTypeStateCreated e) {
        GoodIdentificationTypeStateEventDto.GoodIdentificationTypeStateCreatedDto dto = new GoodIdentificationTypeStateEventDto.GoodIdentificationTypeStateCreatedDto();
        dto.setGoodIdentificationTypeEventId(e.getGoodIdentificationTypeEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setParentTypeId(e.getParentTypeId());
        dto.setHasTable(e.getHasTable());
        dto.setDescription(e.getDescription());
        dto.setActive(e.getActive());
        return dto;
    }

    public GoodIdentificationTypeStateEventDto.GoodIdentificationTypeStateMergePatchedDto toGoodIdentificationTypeStateMergePatchedDto(GoodIdentificationTypeEvent.GoodIdentificationTypeStateMergePatched e) {
        GoodIdentificationTypeStateEventDto.GoodIdentificationTypeStateMergePatchedDto dto = new GoodIdentificationTypeStateEventDto.GoodIdentificationTypeStateMergePatchedDto();
        dto.setGoodIdentificationTypeEventId(e.getGoodIdentificationTypeEventId());
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


    public GoodIdentificationTypeStateEventDto.GoodIdentificationTypeStateDeletedDto toGoodIdentificationTypeStateDeletedDto(GoodIdentificationTypeEvent.GoodIdentificationTypeStateDeleted e) {
        GoodIdentificationTypeStateEventDto.GoodIdentificationTypeStateDeletedDto dto = new GoodIdentificationTypeStateEventDto.GoodIdentificationTypeStateDeletedDto();
        dto.setGoodIdentificationTypeEventId(e.getGoodIdentificationTypeEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

