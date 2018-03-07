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
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setOnHandQuantity(e.getOnHandQuantity());
        dto.setInTransitQuantity(e.getInTransitQuantity());
        dto.setReservedQuantity(e.getReservedQuantity());
        dto.setOccupiedQuantity(e.getOccupiedQuantity());
        dto.setVirtualQuantity(e.getVirtualQuantity());
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
        dto.setStateEventId(e.getStateEventId());
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

