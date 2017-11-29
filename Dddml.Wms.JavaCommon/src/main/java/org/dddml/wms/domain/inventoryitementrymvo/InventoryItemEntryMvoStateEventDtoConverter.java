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
        dto.setQuantityOnHand(e.getQuantityOnHand());
        dto.setQuantityReserved(e.getQuantityReserved());
        dto.setQuantityOccupied(e.getQuantityOccupied());
        dto.setQuantityVirtual(e.getQuantityVirtual());
        dto.setSource((e.getSource() == null) ? null : new InventoryItemSourceVODtoWrapper(e.getSource()));
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
        dto.setQuantityOnHand(e.getQuantityOnHand());
        dto.setQuantityReserved(e.getQuantityReserved());
        dto.setQuantityOccupied(e.getQuantityOccupied());
        dto.setQuantityVirtual(e.getQuantityVirtual());
        dto.setSource((e.getSource() == null) ? null : new InventoryItemSourceVODtoWrapper(e.getSource()));
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
        dto.setIsPropertyQuantityOnHandRemoved(e.getIsPropertyQuantityOnHandRemoved());
        dto.setIsPropertyQuantityReservedRemoved(e.getIsPropertyQuantityReservedRemoved());
        dto.setIsPropertyQuantityOccupiedRemoved(e.getIsPropertyQuantityOccupiedRemoved());
        dto.setIsPropertyQuantityVirtualRemoved(e.getIsPropertyQuantityVirtualRemoved());
        dto.setIsPropertySourceRemoved(e.getIsPropertySourceRemoved());
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

