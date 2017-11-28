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
        dto.setStateEventId(new InventoryItemEntryStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setQuantityOnHandVar(e.getQuantityOnHandVar());
        dto.setQuantityReservedVar(e.getQuantityReservedVar());
        dto.setQuantityOccupiedVar(e.getQuantityOccupiedVar());
        dto.setQuantityVirtualVar(e.getQuantityVirtualVar());
        dto.setEventVO((e.getEventVO() == null) ? null : new InventoryItemEventVODtoWrapper(e.getEventVO()));
        dto.setActive(e.getActive());
        return dto;
    }

}

