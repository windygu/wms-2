package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InventoryItemEntryStateEventDtoConverter {

    public InventoryItemEntryStateEventDto toInventoryItemEntryStateEventDto(AbstractInventoryItemEntryStateEvent stateEvent) {
        if (stateEvent instanceof AbstractInventoryItemEntryStateEvent.AbstractInventoryItemEntryStateCreated) {
            InventoryItemEntryStateEvent.InventoryItemEntryStateCreated e = (InventoryItemEntryStateEvent.InventoryItemEntryStateCreated) stateEvent;
            return toInventoryItemEntryStateCreatedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public InventoryItemEntryStateEventDto.InventoryItemEntryStateCreatedDto toInventoryItemEntryStateCreatedDto(InventoryItemEntryStateEvent.InventoryItemEntryStateCreated e) {
        InventoryItemEntryStateEventDto.InventoryItemEntryStateCreatedDto dto = new InventoryItemEntryStateEventDto.InventoryItemEntryStateCreatedDto();
        dto.setStateEventId(e.getStateEventId());
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

