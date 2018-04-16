package org.dddml.wms.domain.lot;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class LotStateEventDtoConverter {

    public LotStateEventDto toLotStateEventDto(AbstractLotEvent stateEvent) {
        if (stateEvent instanceof AbstractLotEvent.AbstractLotStateCreated) {
            LotEvent.LotStateCreated e = (LotEvent.LotStateCreated) stateEvent;
            return toLotStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractLotEvent.AbstractLotStateMergePatched) {
            LotEvent.LotStateMergePatched e = (LotEvent.LotStateMergePatched) stateEvent;
            return toLotStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractLotEvent.AbstractLotStateDeleted) {
            LotEvent.LotStateDeleted e = (LotEvent.LotStateDeleted) stateEvent;
            return toLotStateDeletedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public LotStateEventDto.LotStateCreatedDto toLotStateCreatedDto(LotEvent.LotStateCreated e) {
        LotStateEventDto.LotStateCreatedDto dto = new LotStateEventDto.LotStateCreatedDto();
        dto.setLotEventId(e.getLotEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setQuantity(e.getQuantity());
        dto.setExpirationDate(e.getExpirationDate());
        dto.setActive(e.getActive());
        return dto;
    }

    public LotStateEventDto.LotStateMergePatchedDto toLotStateMergePatchedDto(LotEvent.LotStateMergePatched e) {
        LotStateEventDto.LotStateMergePatchedDto dto = new LotStateEventDto.LotStateMergePatchedDto();
        dto.setLotEventId(e.getLotEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setQuantity(e.getQuantity());
        dto.setExpirationDate(e.getExpirationDate());
        dto.setActive(e.getActive());
        dto.setIsPropertyQuantityRemoved(e.getIsPropertyQuantityRemoved());
        dto.setIsPropertyExpirationDateRemoved(e.getIsPropertyExpirationDateRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public LotStateEventDto.LotStateDeletedDto toLotStateDeletedDto(LotEvent.LotStateDeleted e) {
        LotStateEventDto.LotStateDeletedDto dto = new LotStateEventDto.LotStateDeletedDto();
        dto.setLotEventId(e.getLotEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

