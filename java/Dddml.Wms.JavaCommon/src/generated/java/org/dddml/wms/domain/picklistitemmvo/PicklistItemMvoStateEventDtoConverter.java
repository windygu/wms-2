package org.dddml.wms.domain.picklistitemmvo;

import java.util.*;
import org.dddml.wms.domain.picklistbin.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PicklistItemMvoStateEventDtoConverter {

    public PicklistItemMvoStateEventDto toPicklistItemMvoStateEventDto(AbstractPicklistItemMvoStateEvent stateEvent) {
        if (stateEvent instanceof AbstractPicklistItemMvoStateEvent.AbstractPicklistItemMvoStateCreated) {
            PicklistItemMvoStateEvent.PicklistItemMvoStateCreated e = (PicklistItemMvoStateEvent.PicklistItemMvoStateCreated) stateEvent;
            return toPicklistItemMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPicklistItemMvoStateEvent.AbstractPicklistItemMvoStateMergePatched) {
            PicklistItemMvoStateEvent.PicklistItemMvoStateMergePatched e = (PicklistItemMvoStateEvent.PicklistItemMvoStateMergePatched) stateEvent;
            return toPicklistItemMvoStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractPicklistItemMvoStateEvent.AbstractPicklistItemMvoStateDeleted) {
            PicklistItemMvoStateEvent.PicklistItemMvoStateDeleted e = (PicklistItemMvoStateEvent.PicklistItemMvoStateDeleted) stateEvent;
            return toPicklistItemMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public PicklistItemMvoStateEventDto.PicklistItemMvoStateCreatedDto toPicklistItemMvoStateCreatedDto(PicklistItemMvoStateEvent.PicklistItemMvoStateCreated e) {
        PicklistItemMvoStateEventDto.PicklistItemMvoStateCreatedDto dto = new PicklistItemMvoStateEventDto.PicklistItemMvoStateCreatedDto();
        dto.setPicklistItemMvoEventId(e.getPicklistItemMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setItemStatusId(e.getItemStatusId());
        dto.setQuantity(e.getQuantity());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setPicklistBinPicklistId(e.getPicklistBinPicklistId());
        dto.setPicklistBinBinLocationNumber(e.getPicklistBinBinLocationNumber());
        dto.setPicklistBinPrimaryOrderId(e.getPicklistBinPrimaryOrderId());
        dto.setPicklistBinPrimaryShipGroupSeqId(e.getPicklistBinPrimaryShipGroupSeqId());
        dto.setPicklistBinCreatedBy(e.getPicklistBinCreatedBy());
        dto.setPicklistBinCreatedAt(e.getPicklistBinCreatedAt());
        dto.setPicklistBinUpdatedBy(e.getPicklistBinUpdatedBy());
        dto.setPicklistBinUpdatedAt(e.getPicklistBinUpdatedAt());
        dto.setPicklistBinActive(e.getPicklistBinActive());
        dto.setPicklistBinDeleted(e.getPicklistBinDeleted());
        return dto;
    }

    public PicklistItemMvoStateEventDto.PicklistItemMvoStateMergePatchedDto toPicklistItemMvoStateMergePatchedDto(PicklistItemMvoStateEvent.PicklistItemMvoStateMergePatched e) {
        PicklistItemMvoStateEventDto.PicklistItemMvoStateMergePatchedDto dto = new PicklistItemMvoStateEventDto.PicklistItemMvoStateMergePatchedDto();
        dto.setPicklistItemMvoEventId(e.getPicklistItemMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setItemStatusId(e.getItemStatusId());
        dto.setQuantity(e.getQuantity());
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setPicklistBinPicklistId(e.getPicklistBinPicklistId());
        dto.setPicklistBinBinLocationNumber(e.getPicklistBinBinLocationNumber());
        dto.setPicklistBinPrimaryOrderId(e.getPicklistBinPrimaryOrderId());
        dto.setPicklistBinPrimaryShipGroupSeqId(e.getPicklistBinPrimaryShipGroupSeqId());
        dto.setPicklistBinCreatedBy(e.getPicklistBinCreatedBy());
        dto.setPicklistBinCreatedAt(e.getPicklistBinCreatedAt());
        dto.setPicklistBinUpdatedBy(e.getPicklistBinUpdatedBy());
        dto.setPicklistBinUpdatedAt(e.getPicklistBinUpdatedAt());
        dto.setPicklistBinActive(e.getPicklistBinActive());
        dto.setPicklistBinDeleted(e.getPicklistBinDeleted());
        dto.setIsPropertyItemStatusIdRemoved(e.getIsPropertyItemStatusIdRemoved());
        dto.setIsPropertyQuantityRemoved(e.getIsPropertyQuantityRemoved());
        dto.setIsPropertyVersionRemoved(e.getIsPropertyVersionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        dto.setIsPropertyPicklistBinPicklistIdRemoved(e.getIsPropertyPicklistBinPicklistIdRemoved());
        dto.setIsPropertyPicklistBinBinLocationNumberRemoved(e.getIsPropertyPicklistBinBinLocationNumberRemoved());
        dto.setIsPropertyPicklistBinPrimaryOrderIdRemoved(e.getIsPropertyPicklistBinPrimaryOrderIdRemoved());
        dto.setIsPropertyPicklistBinPrimaryShipGroupSeqIdRemoved(e.getIsPropertyPicklistBinPrimaryShipGroupSeqIdRemoved());
        dto.setIsPropertyPicklistBinCreatedByRemoved(e.getIsPropertyPicklistBinCreatedByRemoved());
        dto.setIsPropertyPicklistBinCreatedAtRemoved(e.getIsPropertyPicklistBinCreatedAtRemoved());
        dto.setIsPropertyPicklistBinUpdatedByRemoved(e.getIsPropertyPicklistBinUpdatedByRemoved());
        dto.setIsPropertyPicklistBinUpdatedAtRemoved(e.getIsPropertyPicklistBinUpdatedAtRemoved());
        dto.setIsPropertyPicklistBinActiveRemoved(e.getIsPropertyPicklistBinActiveRemoved());
        dto.setIsPropertyPicklistBinDeletedRemoved(e.getIsPropertyPicklistBinDeletedRemoved());
        return dto;
    }


    public PicklistItemMvoStateEventDto.PicklistItemMvoStateDeletedDto toPicklistItemMvoStateDeletedDto(PicklistItemMvoStateEvent.PicklistItemMvoStateDeleted e) {
        PicklistItemMvoStateEventDto.PicklistItemMvoStateDeletedDto dto = new PicklistItemMvoStateEventDto.PicklistItemMvoStateDeletedDto();
        dto.setPicklistItemMvoEventId(e.getPicklistItemMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

