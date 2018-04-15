package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InventoryItemEntryStateEventDtoConverter {

    public InventoryItemEntryStateEventDto toInventoryItemEntryStateEventDto(AbstractInventoryItemEntryEvent stateEvent) {
        if (stateEvent instanceof AbstractInventoryItemEntryEvent.AbstractInventoryItemEntryStateCreated) {
            InventoryItemEntryEvent.InventoryItemEntryStateCreated e = (InventoryItemEntryEvent.InventoryItemEntryStateCreated) stateEvent;
            return toInventoryItemEntryStateCreatedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public InventoryItemEntryStateEventDto.InventoryItemEntryStateCreatedDto toInventoryItemEntryStateCreatedDto(InventoryItemEntryEvent.InventoryItemEntryStateCreated e) {
        InventoryItemEntryStateEventDto.InventoryItemEntryStateCreatedDto dto = new InventoryItemEntryStateEventDto.InventoryItemEntryStateCreatedDto();
        dto.setInventoryItemEntryEventId(e.getInventoryItemEntryEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setOnHandQuantity(e.getOnHandQuantity());
        dto.setInTransitQuantity(e.getInTransitQuantity());
        dto.setReservedQuantity(e.getReservedQuantity());
        dto.setOccupiedQuantity(e.getOccupiedQuantity());
        dto.setVirtualQuantity(e.getVirtualQuantity());
        dto.setSource(e.getSource());
        return dto;
    }

}

