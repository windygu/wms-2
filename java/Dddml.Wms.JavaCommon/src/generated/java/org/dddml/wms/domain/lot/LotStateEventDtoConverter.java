package org.dddml.wms.domain.lot;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class LotStateEventDtoConverter {

    public LotStateEventDto toLotStateEventDto(AbstractLotStateEvent stateEvent) {
        if (stateEvent instanceof AbstractLotStateEvent.AbstractLotStateCreated) {
            LotStateEvent.LotStateCreated e = (LotStateEvent.LotStateCreated) stateEvent;
            return toLotStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractLotStateEvent.AbstractLotStateMergePatched) {
            LotStateEvent.LotStateMergePatched e = (LotStateEvent.LotStateMergePatched) stateEvent;
            return toLotStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractLotStateEvent.AbstractLotStateDeleted) {
            LotStateEvent.LotStateDeleted e = (LotStateEvent.LotStateDeleted) stateEvent;
            return toLotStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public LotStateEventDto.LotStateCreatedDto toLotStateCreatedDto(LotStateEvent.LotStateCreated e) {
        LotStateEventDto.LotStateCreatedDto dto = new LotStateEventDto.LotStateCreatedDto();
        dto.setStateEventId(new LotStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setQuantity(e.getQuantity());
        dto.setExpirationDate(e.getExpirationDate());
        dto.setActive(e.getActive());
        return dto;
    }

    public LotStateEventDto.LotStateMergePatchedDto toLotStateMergePatchedDto(LotStateEvent.LotStateMergePatched e) {
        LotStateEventDto.LotStateMergePatchedDto dto = new LotStateEventDto.LotStateMergePatchedDto();
        dto.setStateEventId(new LotStateEventIdDtoWrapper(e.getStateEventId()));
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


    public LotStateEventDto.LotStateDeletedDto toLotStateDeletedDto(LotStateEvent.LotStateDeleted e) {
        LotStateEventDto.LotStateDeletedDto dto = new LotStateEventDto.LotStateDeletedDto();
        dto.setStateEventId(new LotStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

