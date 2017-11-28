package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InventoryItemStateEventDtoConverter {

    public InventoryItemStateEventDto toInventoryItemStateEventDto(AbstractInventoryItemStateEvent stateEvent) {
        if (stateEvent instanceof AbstractInventoryItemStateEvent.AbstractInventoryItemStateCreated) {
            InventoryItemStateEvent.InventoryItemStateCreated e = (InventoryItemStateEvent.InventoryItemStateCreated) stateEvent;
            return toInventoryItemStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractInventoryItemStateEvent.AbstractInventoryItemStateMergePatched) {
            InventoryItemStateEvent.InventoryItemStateMergePatched e = (InventoryItemStateEvent.InventoryItemStateMergePatched) stateEvent;
            return toInventoryItemStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public InventoryItemStateEventDto.InventoryItemStateCreatedDto toInventoryItemStateCreatedDto(InventoryItemStateEvent.InventoryItemStateCreated e) {
        InventoryItemStateEventDto.InventoryItemStateCreatedDto dto = new InventoryItemStateEventDto.InventoryItemStateCreatedDto();
        dto.setStateEventId(new InventoryItemStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setQuantityOnHand(e.getQuantityOnHand());
        dto.setQuantityReserved(e.getQuantityReserved());
        dto.setQuantityOccupied(e.getQuantityOccupied());
        dto.setQuantityVirtual(e.getQuantityVirtual());
        List<InventoryItemEntryStateEventDto.InventoryItemEntryStateCreatedDto> inventoryItemEntryEvents = new ArrayList<>();
        for (InventoryItemEntryStateEvent.InventoryItemEntryStateCreated ee : e.getInventoryItemEntryEvents()) {
            InventoryItemEntryStateEventDto.InventoryItemEntryStateCreatedDto eeDto = getInventoryItemEntryStateEventDtoConverter().toInventoryItemEntryStateCreatedDto(ee);
            inventoryItemEntryEvents.add(eeDto);
        }
        dto.setInventoryItemEntryEvents(inventoryItemEntryEvents.toArray(new InventoryItemEntryStateEventDto.InventoryItemEntryStateCreatedDto[0]));

        return dto;
    }

    public InventoryItemStateEventDto.InventoryItemStateMergePatchedDto toInventoryItemStateMergePatchedDto(InventoryItemStateEvent.InventoryItemStateMergePatched e) {
        InventoryItemStateEventDto.InventoryItemStateMergePatchedDto dto = new InventoryItemStateEventDto.InventoryItemStateMergePatchedDto();
        dto.setStateEventId(new InventoryItemStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setQuantityOnHand(e.getQuantityOnHand());
        dto.setQuantityReserved(e.getQuantityReserved());
        dto.setQuantityOccupied(e.getQuantityOccupied());
        dto.setQuantityVirtual(e.getQuantityVirtual());
        dto.setIsPropertyQuantityOnHandRemoved(e.getIsPropertyQuantityOnHandRemoved());
        dto.setIsPropertyQuantityReservedRemoved(e.getIsPropertyQuantityReservedRemoved());
        dto.setIsPropertyQuantityOccupiedRemoved(e.getIsPropertyQuantityOccupiedRemoved());
        dto.setIsPropertyQuantityVirtualRemoved(e.getIsPropertyQuantityVirtualRemoved());
        List<InventoryItemEntryStateEventDto> inventoryItemEntryEvents = new ArrayList<>();
        for (InventoryItemEntryStateEvent ee : e.getInventoryItemEntryEvents()) {
            InventoryItemEntryStateEventDto eeDto = getInventoryItemEntryStateEventDtoConverter().toInventoryItemEntryStateEventDto((AbstractInventoryItemEntryStateEvent) ee);
            inventoryItemEntryEvents.add(eeDto);
        }
        dto.setInventoryItemEntryEvents(inventoryItemEntryEvents.toArray(new InventoryItemEntryStateEventDto[0]));

        return dto;
    }


    protected InventoryItemEntryStateEventDtoConverter getInventoryItemEntryStateEventDtoConverter() {
        return new InventoryItemEntryStateEventDtoConverter();
    }

}

