package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InventoryItemStateEventDtoConverter {

    public InventoryItemStateEventDto toInventoryItemStateEventDto(AbstractInventoryItemEvent stateEvent) {
        if (stateEvent instanceof AbstractInventoryItemEvent.AbstractInventoryItemStateCreated) {
            InventoryItemEvent.InventoryItemStateCreated e = (InventoryItemEvent.InventoryItemStateCreated) stateEvent;
            return toInventoryItemStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractInventoryItemEvent.AbstractInventoryItemStateMergePatched) {
            InventoryItemEvent.InventoryItemStateMergePatched e = (InventoryItemEvent.InventoryItemStateMergePatched) stateEvent;
            return toInventoryItemStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public InventoryItemStateEventDto.InventoryItemStateCreatedDto toInventoryItemStateCreatedDto(InventoryItemEvent.InventoryItemStateCreated e) {
        InventoryItemStateEventDto.InventoryItemStateCreatedDto dto = new InventoryItemStateEventDto.InventoryItemStateCreatedDto();
        dto.setInventoryItemEventId(e.getInventoryItemEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setOnHandQuantity(e.getOnHandQuantity());
        dto.setInTransitQuantity(e.getInTransitQuantity());
        dto.setReservedQuantity(e.getReservedQuantity());
        dto.setOccupiedQuantity(e.getOccupiedQuantity());
        dto.setVirtualQuantity(e.getVirtualQuantity());
        List<InventoryItemEntryStateEventDto.InventoryItemEntryStateCreatedDto> inventoryItemEntryEvents = new ArrayList<>();
        for (InventoryItemEntryEvent.InventoryItemEntryStateCreated ee : e.getInventoryItemEntryEvents()) {
            InventoryItemEntryStateEventDto.InventoryItemEntryStateCreatedDto eeDto = getInventoryItemEntryStateEventDtoConverter().toInventoryItemEntryStateCreatedDto(ee);
            inventoryItemEntryEvents.add(eeDto);
        }
        dto.setInventoryItemEntryEvents(inventoryItemEntryEvents.toArray(new InventoryItemEntryStateEventDto.InventoryItemEntryStateCreatedDto[0]));

        return dto;
    }

    public InventoryItemStateEventDto.InventoryItemStateMergePatchedDto toInventoryItemStateMergePatchedDto(InventoryItemEvent.InventoryItemStateMergePatched e) {
        InventoryItemStateEventDto.InventoryItemStateMergePatchedDto dto = new InventoryItemStateEventDto.InventoryItemStateMergePatchedDto();
        dto.setInventoryItemEventId(e.getInventoryItemEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setOnHandQuantity(e.getOnHandQuantity());
        dto.setInTransitQuantity(e.getInTransitQuantity());
        dto.setReservedQuantity(e.getReservedQuantity());
        dto.setOccupiedQuantity(e.getOccupiedQuantity());
        dto.setVirtualQuantity(e.getVirtualQuantity());
        dto.setIsPropertyOnHandQuantityRemoved(e.getIsPropertyOnHandQuantityRemoved());
        dto.setIsPropertyInTransitQuantityRemoved(e.getIsPropertyInTransitQuantityRemoved());
        dto.setIsPropertyReservedQuantityRemoved(e.getIsPropertyReservedQuantityRemoved());
        dto.setIsPropertyOccupiedQuantityRemoved(e.getIsPropertyOccupiedQuantityRemoved());
        dto.setIsPropertyVirtualQuantityRemoved(e.getIsPropertyVirtualQuantityRemoved());
        List<InventoryItemEntryStateEventDto> inventoryItemEntryEvents = new ArrayList<>();
        for (InventoryItemEntryEvent ee : e.getInventoryItemEntryEvents()) {
            InventoryItemEntryStateEventDto eeDto = getInventoryItemEntryStateEventDtoConverter().toInventoryItemEntryStateEventDto((AbstractInventoryItemEntryEvent) ee);
            inventoryItemEntryEvents.add(eeDto);
        }
        dto.setInventoryItemEntryEvents(inventoryItemEntryEvents.toArray(new InventoryItemEntryStateEventDto[0]));

        return dto;
    }


    protected InventoryItemEntryStateEventDtoConverter getInventoryItemEntryStateEventDtoConverter() {
        return new InventoryItemEntryStateEventDtoConverter();
    }

}

