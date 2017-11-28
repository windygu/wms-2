package org.dddml.wms.domain.inventoryitementrymvo;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InventoryItemEntryMvoStateEventDtoConverter {

    public InventoryItemEntryMvoStateEventDto toInventoryItemEntryMvoStateEventDto(AbstractInventoryItemEntryMvoStateEvent stateEvent) {
        if (stateEvent instanceof AbstractInventoryItemEntryMvoStateEvent.AbstractInventoryItemEntryMvoStateCreated) {
            InventoryItemEntryMvoStateEvent.InventoryItemEntryMvoStateCreated e = (InventoryItemEntryMvoStateEvent.InventoryItemEntryMvoStateCreated) stateEvent;
            return toInventoryItemEntryMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractInventoryItemEntryMvoStateEvent.AbstractInventoryItemEntryMvoStateMergePatched) {
            InventoryItemEntryMvoStateEvent.InventoryItemEntryMvoStateMergePatched e = (InventoryItemEntryMvoStateEvent.InventoryItemEntryMvoStateMergePatched) stateEvent;
            return toInventoryItemEntryMvoStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public InventoryItemEntryMvoStateEventDto.InventoryItemEntryMvoStateCreatedDto toInventoryItemEntryMvoStateCreatedDto(InventoryItemEntryMvoStateEvent.InventoryItemEntryMvoStateCreated e) {
        InventoryItemEntryMvoStateEventDto.InventoryItemEntryMvoStateCreatedDto dto = new InventoryItemEntryMvoStateEventDto.InventoryItemEntryMvoStateCreatedDto();
        dto.setStateEventId(new InventoryItemEntryMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setQuantityOnHandVar(e.getQuantityOnHandVar());
        dto.setQuantityReservedVar(e.getQuantityReservedVar());
        dto.setQuantityOccupiedVar(e.getQuantityOccupiedVar());
        dto.setQuantityVirtualVar(e.getQuantityVirtualVar());
        dto.setEventVO((e.getEventVO() == null) ? null : new InventoryItemEventVODtoWrapper(e.getEventVO()));
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setInventoryItemQuantityOnHand(e.getInventoryItemQuantityOnHand());
        dto.setInventoryItemQuantityReserved(e.getInventoryItemQuantityReserved());
        dto.setInventoryItemQuantityOccupied(e.getInventoryItemQuantityOccupied());
        dto.setInventoryItemQuantityVirtual(e.getInventoryItemQuantityVirtual());
        dto.setInventoryItemCreatedBy(e.getInventoryItemCreatedBy());
        dto.setInventoryItemCreatedAt(e.getInventoryItemCreatedAt());
        dto.setInventoryItemUpdatedBy(e.getInventoryItemUpdatedBy());
        dto.setInventoryItemUpdatedAt(e.getInventoryItemUpdatedAt());
        return dto;
    }

    public InventoryItemEntryMvoStateEventDto.InventoryItemEntryMvoStateMergePatchedDto toInventoryItemEntryMvoStateMergePatchedDto(InventoryItemEntryMvoStateEvent.InventoryItemEntryMvoStateMergePatched e) {
        InventoryItemEntryMvoStateEventDto.InventoryItemEntryMvoStateMergePatchedDto dto = new InventoryItemEntryMvoStateEventDto.InventoryItemEntryMvoStateMergePatchedDto();
        dto.setStateEventId(new InventoryItemEntryMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setQuantityOnHandVar(e.getQuantityOnHandVar());
        dto.setQuantityReservedVar(e.getQuantityReservedVar());
        dto.setQuantityOccupiedVar(e.getQuantityOccupiedVar());
        dto.setQuantityVirtualVar(e.getQuantityVirtualVar());
        dto.setEventVO((e.getEventVO() == null) ? null : new InventoryItemEventVODtoWrapper(e.getEventVO()));
        dto.setVersion(e.getVersion());
        dto.setActive(e.getActive());
        dto.setInventoryItemQuantityOnHand(e.getInventoryItemQuantityOnHand());
        dto.setInventoryItemQuantityReserved(e.getInventoryItemQuantityReserved());
        dto.setInventoryItemQuantityOccupied(e.getInventoryItemQuantityOccupied());
        dto.setInventoryItemQuantityVirtual(e.getInventoryItemQuantityVirtual());
        dto.setInventoryItemCreatedBy(e.getInventoryItemCreatedBy());
        dto.setInventoryItemCreatedAt(e.getInventoryItemCreatedAt());
        dto.setInventoryItemUpdatedBy(e.getInventoryItemUpdatedBy());
        dto.setInventoryItemUpdatedAt(e.getInventoryItemUpdatedAt());
        dto.setIsPropertyQuantityOnHandVarRemoved(e.getIsPropertyQuantityOnHandVarRemoved());
        dto.setIsPropertyQuantityReservedVarRemoved(e.getIsPropertyQuantityReservedVarRemoved());
        dto.setIsPropertyQuantityOccupiedVarRemoved(e.getIsPropertyQuantityOccupiedVarRemoved());
        dto.setIsPropertyQuantityVirtualVarRemoved(e.getIsPropertyQuantityVirtualVarRemoved());
        dto.setIsPropertyEventVORemoved(e.getIsPropertyEventVORemoved());
        dto.setIsPropertyVersionRemoved(e.getIsPropertyVersionRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        dto.setIsPropertyInventoryItemQuantityOnHandRemoved(e.getIsPropertyInventoryItemQuantityOnHandRemoved());
        dto.setIsPropertyInventoryItemQuantityReservedRemoved(e.getIsPropertyInventoryItemQuantityReservedRemoved());
        dto.setIsPropertyInventoryItemQuantityOccupiedRemoved(e.getIsPropertyInventoryItemQuantityOccupiedRemoved());
        dto.setIsPropertyInventoryItemQuantityVirtualRemoved(e.getIsPropertyInventoryItemQuantityVirtualRemoved());
        dto.setIsPropertyInventoryItemCreatedByRemoved(e.getIsPropertyInventoryItemCreatedByRemoved());
        dto.setIsPropertyInventoryItemCreatedAtRemoved(e.getIsPropertyInventoryItemCreatedAtRemoved());
        dto.setIsPropertyInventoryItemUpdatedByRemoved(e.getIsPropertyInventoryItemUpdatedByRemoved());
        dto.setIsPropertyInventoryItemUpdatedAtRemoved(e.getIsPropertyInventoryItemUpdatedAtRemoved());
        return dto;
    }


}

