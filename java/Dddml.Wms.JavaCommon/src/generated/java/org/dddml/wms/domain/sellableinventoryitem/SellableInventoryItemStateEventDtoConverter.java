package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class SellableInventoryItemStateEventDtoConverter {

    public SellableInventoryItemStateEventDto toSellableInventoryItemStateEventDto(AbstractSellableInventoryItemEvent stateEvent) {
        if (stateEvent instanceof AbstractSellableInventoryItemEvent.AbstractSellableInventoryItemStateCreated) {
            SellableInventoryItemEvent.SellableInventoryItemStateCreated e = (SellableInventoryItemEvent.SellableInventoryItemStateCreated) stateEvent;
            return toSellableInventoryItemStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractSellableInventoryItemEvent.AbstractSellableInventoryItemStateMergePatched) {
            SellableInventoryItemEvent.SellableInventoryItemStateMergePatched e = (SellableInventoryItemEvent.SellableInventoryItemStateMergePatched) stateEvent;
            return toSellableInventoryItemStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public SellableInventoryItemStateEventDto.SellableInventoryItemStateCreatedDto toSellableInventoryItemStateCreatedDto(SellableInventoryItemEvent.SellableInventoryItemStateCreated e) {
        SellableInventoryItemStateEventDto.SellableInventoryItemStateCreatedDto dto = new SellableInventoryItemStateEventDto.SellableInventoryItemStateCreatedDto();
        dto.setSellableInventoryItemEventId(e.getSellableInventoryItemEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setSellableQuantity(e.getSellableQuantity());
        List<SellableInventoryItemEntryStateEventDto.SellableInventoryItemEntryStateCreatedDto> sellableInventoryItemEntryEvents = new ArrayList<>();
        for (SellableInventoryItemEntryEvent.SellableInventoryItemEntryStateCreated ee : e.getSellableInventoryItemEntryEvents()) {
            SellableInventoryItemEntryStateEventDto.SellableInventoryItemEntryStateCreatedDto eeDto = getSellableInventoryItemEntryStateEventDtoConverter().toSellableInventoryItemEntryStateCreatedDto(ee);
            sellableInventoryItemEntryEvents.add(eeDto);
        }
        dto.setSellableInventoryItemEntryEvents(sellableInventoryItemEntryEvents.toArray(new SellableInventoryItemEntryStateEventDto.SellableInventoryItemEntryStateCreatedDto[0]));

        return dto;
    }

    public SellableInventoryItemStateEventDto.SellableInventoryItemStateMergePatchedDto toSellableInventoryItemStateMergePatchedDto(SellableInventoryItemEvent.SellableInventoryItemStateMergePatched e) {
        SellableInventoryItemStateEventDto.SellableInventoryItemStateMergePatchedDto dto = new SellableInventoryItemStateEventDto.SellableInventoryItemStateMergePatchedDto();
        dto.setSellableInventoryItemEventId(e.getSellableInventoryItemEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setSellableQuantity(e.getSellableQuantity());
        dto.setIsPropertySellableQuantityRemoved(e.getIsPropertySellableQuantityRemoved());
        List<SellableInventoryItemEntryStateEventDto> sellableInventoryItemEntryEvents = new ArrayList<>();
        for (SellableInventoryItemEntryEvent ee : e.getSellableInventoryItemEntryEvents()) {
            SellableInventoryItemEntryStateEventDto eeDto = getSellableInventoryItemEntryStateEventDtoConverter().toSellableInventoryItemEntryStateEventDto((AbstractSellableInventoryItemEntryEvent) ee);
            sellableInventoryItemEntryEvents.add(eeDto);
        }
        dto.setSellableInventoryItemEntryEvents(sellableInventoryItemEntryEvents.toArray(new SellableInventoryItemEntryStateEventDto[0]));

        return dto;
    }


    protected SellableInventoryItemEntryStateEventDtoConverter getSellableInventoryItemEntryStateEventDtoConverter() {
        return new SellableInventoryItemEntryStateEventDtoConverter();
    }

}

