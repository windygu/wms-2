package org.dddml.wms.domain.product;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class GoodIdentificationStateEventDtoConverter {

    public GoodIdentificationStateEventDto toGoodIdentificationStateEventDto(AbstractGoodIdentificationEvent stateEvent) {
        if (stateEvent instanceof AbstractGoodIdentificationEvent.AbstractGoodIdentificationStateCreated) {
            GoodIdentificationEvent.GoodIdentificationStateCreated e = (GoodIdentificationEvent.GoodIdentificationStateCreated) stateEvent;
            return toGoodIdentificationStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractGoodIdentificationEvent.AbstractGoodIdentificationStateMergePatched) {
            GoodIdentificationEvent.GoodIdentificationStateMergePatched e = (GoodIdentificationEvent.GoodIdentificationStateMergePatched) stateEvent;
            return toGoodIdentificationStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractGoodIdentificationEvent.AbstractGoodIdentificationStateRemoved) {
            GoodIdentificationEvent.GoodIdentificationStateRemoved e = (GoodIdentificationEvent.GoodIdentificationStateRemoved) stateEvent;
            return toGoodIdentificationStateRemovedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public GoodIdentificationStateEventDto.GoodIdentificationStateCreatedDto toGoodIdentificationStateCreatedDto(GoodIdentificationEvent.GoodIdentificationStateCreated e) {
        GoodIdentificationStateEventDto.GoodIdentificationStateCreatedDto dto = new GoodIdentificationStateEventDto.GoodIdentificationStateCreatedDto();
        dto.setGoodIdentificationEventId(e.getGoodIdentificationEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setIdValue(e.getIdValue());
        dto.setActive(e.getActive());
        return dto;
    }

    public GoodIdentificationStateEventDto.GoodIdentificationStateMergePatchedDto toGoodIdentificationStateMergePatchedDto(GoodIdentificationEvent.GoodIdentificationStateMergePatched e) {
        GoodIdentificationStateEventDto.GoodIdentificationStateMergePatchedDto dto = new GoodIdentificationStateEventDto.GoodIdentificationStateMergePatchedDto();
        dto.setGoodIdentificationEventId(e.getGoodIdentificationEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setIdValue(e.getIdValue());
        dto.setActive(e.getActive());
        dto.setIsPropertyIdValueRemoved(e.getIsPropertyIdValueRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public GoodIdentificationStateEventDto.GoodIdentificationStateRemovedDto toGoodIdentificationStateRemovedDto(GoodIdentificationEvent.GoodIdentificationStateRemoved e) {
        GoodIdentificationStateEventDto.GoodIdentificationStateRemovedDto dto = new GoodIdentificationStateEventDto.GoodIdentificationStateRemovedDto();
        dto.setGoodIdentificationEventId(e.getGoodIdentificationEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

