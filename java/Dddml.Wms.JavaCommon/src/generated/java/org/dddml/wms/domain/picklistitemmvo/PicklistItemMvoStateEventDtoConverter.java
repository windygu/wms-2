package org.dddml.wms.domain.picklistitemmvo;

import java.util.*;
import org.dddml.wms.domain.picklistbin.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class PicklistItemMvoStateEventDtoConverter {

    public PicklistItemMvoStateEventDto toPicklistItemMvoStateEventDto(AbstractPicklistItemMvoEvent stateEvent) {
        if (stateEvent instanceof AbstractPicklistItemMvoEvent.AbstractPicklistItemMvoStateCreated) {
            PicklistItemMvoEvent.PicklistItemMvoStateCreated e = (PicklistItemMvoEvent.PicklistItemMvoStateCreated) stateEvent;
            return toPicklistItemMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractPicklistItemMvoEvent.AbstractPicklistItemMvoStateMergePatched) {
            PicklistItemMvoEvent.PicklistItemMvoStateMergePatched e = (PicklistItemMvoEvent.PicklistItemMvoStateMergePatched) stateEvent;
            return toPicklistItemMvoStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractPicklistItemMvoEvent.AbstractPicklistItemMvoStateDeleted) {
            PicklistItemMvoEvent.PicklistItemMvoStateDeleted e = (PicklistItemMvoEvent.PicklistItemMvoStateDeleted) stateEvent;
            return toPicklistItemMvoStateDeletedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public PicklistItemMvoStateEventDto.PicklistItemMvoStateCreatedDto toPicklistItemMvoStateCreatedDto(PicklistItemMvoEvent.PicklistItemMvoStateCreated e) {
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

    public PicklistItemMvoStateEventDto.PicklistItemMvoStateMergePatchedDto toPicklistItemMvoStateMergePatchedDto(PicklistItemMvoEvent.PicklistItemMvoStateMergePatched e) {
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


    public PicklistItemMvoStateEventDto.PicklistItemMvoStateDeletedDto toPicklistItemMvoStateDeletedDto(PicklistItemMvoEvent.PicklistItemMvoStateDeleted e) {
        PicklistItemMvoStateEventDto.PicklistItemMvoStateDeletedDto dto = new PicklistItemMvoStateEventDto.PicklistItemMvoStateDeletedDto();
        dto.setPicklistItemMvoEventId(e.getPicklistItemMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

