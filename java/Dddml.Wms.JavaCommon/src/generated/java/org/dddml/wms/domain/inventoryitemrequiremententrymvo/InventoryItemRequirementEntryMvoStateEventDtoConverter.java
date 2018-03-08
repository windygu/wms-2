package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import java.util.*;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InventoryItemRequirementEntryMvoStateEventDtoConverter {

    public InventoryItemRequirementEntryMvoStateEventDto toInventoryItemRequirementEntryMvoStateEventDto(AbstractInventoryItemRequirementEntryMvoStateEvent stateEvent) {
        if (stateEvent instanceof AbstractInventoryItemRequirementEntryMvoStateEvent.AbstractInventoryItemRequirementEntryMvoStateCreated) {
            InventoryItemRequirementEntryMvoStateEvent.InventoryItemRequirementEntryMvoStateCreated e = (InventoryItemRequirementEntryMvoStateEvent.InventoryItemRequirementEntryMvoStateCreated) stateEvent;
            return toInventoryItemRequirementEntryMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractInventoryItemRequirementEntryMvoStateEvent.AbstractInventoryItemRequirementEntryMvoStateMergePatched) {
            InventoryItemRequirementEntryMvoStateEvent.InventoryItemRequirementEntryMvoStateMergePatched e = (InventoryItemRequirementEntryMvoStateEvent.InventoryItemRequirementEntryMvoStateMergePatched) stateEvent;
            return toInventoryItemRequirementEntryMvoStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public InventoryItemRequirementEntryMvoStateEventDto.InventoryItemRequirementEntryMvoStateCreatedDto toInventoryItemRequirementEntryMvoStateCreatedDto(InventoryItemRequirementEntryMvoStateEvent.InventoryItemRequirementEntryMvoStateCreated e) {
        InventoryItemRequirementEntryMvoStateEventDto.InventoryItemRequirementEntryMvoStateCreatedDto dto = new InventoryItemRequirementEntryMvoStateEventDto.InventoryItemRequirementEntryMvoStateCreatedDto();
        dto.setInventoryItemRequirementEntryMvoEventId(e.getInventoryItemRequirementEntryMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setQuantity(e.getQuantity());
        dto.setSourceEventId(e.getSourceEventId());
        dto.setVersion(e.getVersion());
        dto.setInventoryItemRequirementQuantity(e.getInventoryItemRequirementQuantity());
        dto.setInventoryItemRequirementCreatedBy(e.getInventoryItemRequirementCreatedBy());
        dto.setInventoryItemRequirementCreatedAt(e.getInventoryItemRequirementCreatedAt());
        dto.setInventoryItemRequirementUpdatedBy(e.getInventoryItemRequirementUpdatedBy());
        dto.setInventoryItemRequirementUpdatedAt(e.getInventoryItemRequirementUpdatedAt());
        return dto;
    }

    public InventoryItemRequirementEntryMvoStateEventDto.InventoryItemRequirementEntryMvoStateMergePatchedDto toInventoryItemRequirementEntryMvoStateMergePatchedDto(InventoryItemRequirementEntryMvoStateEvent.InventoryItemRequirementEntryMvoStateMergePatched e) {
        InventoryItemRequirementEntryMvoStateEventDto.InventoryItemRequirementEntryMvoStateMergePatchedDto dto = new InventoryItemRequirementEntryMvoStateEventDto.InventoryItemRequirementEntryMvoStateMergePatchedDto();
        dto.setInventoryItemRequirementEntryMvoEventId(e.getInventoryItemRequirementEntryMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setQuantity(e.getQuantity());
        dto.setSourceEventId(e.getSourceEventId());
        dto.setVersion(e.getVersion());
        dto.setInventoryItemRequirementQuantity(e.getInventoryItemRequirementQuantity());
        dto.setInventoryItemRequirementCreatedBy(e.getInventoryItemRequirementCreatedBy());
        dto.setInventoryItemRequirementCreatedAt(e.getInventoryItemRequirementCreatedAt());
        dto.setInventoryItemRequirementUpdatedBy(e.getInventoryItemRequirementUpdatedBy());
        dto.setInventoryItemRequirementUpdatedAt(e.getInventoryItemRequirementUpdatedAt());
        dto.setIsPropertyQuantityRemoved(e.getIsPropertyQuantityRemoved());
        dto.setIsPropertySourceEventIdRemoved(e.getIsPropertySourceEventIdRemoved());
        dto.setIsPropertyVersionRemoved(e.getIsPropertyVersionRemoved());
        dto.setIsPropertyInventoryItemRequirementQuantityRemoved(e.getIsPropertyInventoryItemRequirementQuantityRemoved());
        dto.setIsPropertyInventoryItemRequirementCreatedByRemoved(e.getIsPropertyInventoryItemRequirementCreatedByRemoved());
        dto.setIsPropertyInventoryItemRequirementCreatedAtRemoved(e.getIsPropertyInventoryItemRequirementCreatedAtRemoved());
        dto.setIsPropertyInventoryItemRequirementUpdatedByRemoved(e.getIsPropertyInventoryItemRequirementUpdatedByRemoved());
        dto.setIsPropertyInventoryItemRequirementUpdatedAtRemoved(e.getIsPropertyInventoryItemRequirementUpdatedAtRemoved());
        return dto;
    }


}

