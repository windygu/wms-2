package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class SellableInventoryItemStateEventDtoConverter {

    public SellableInventoryItemStateEventDto toSellableInventoryItemStateEventDto(AbstractSellableInventoryItemStateEvent stateEvent) {
        if (stateEvent instanceof AbstractSellableInventoryItemStateEvent.AbstractSellableInventoryItemStateCreated) {
            SellableInventoryItemStateEvent.SellableInventoryItemStateCreated e = (SellableInventoryItemStateEvent.SellableInventoryItemStateCreated) stateEvent;
            return toSellableInventoryItemStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractSellableInventoryItemStateEvent.AbstractSellableInventoryItemStateMergePatched) {
            SellableInventoryItemStateEvent.SellableInventoryItemStateMergePatched e = (SellableInventoryItemStateEvent.SellableInventoryItemStateMergePatched) stateEvent;
            return toSellableInventoryItemStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public SellableInventoryItemStateEventDto.SellableInventoryItemStateCreatedDto toSellableInventoryItemStateCreatedDto(SellableInventoryItemStateEvent.SellableInventoryItemStateCreated e) {
        SellableInventoryItemStateEventDto.SellableInventoryItemStateCreatedDto dto = new SellableInventoryItemStateEventDto.SellableInventoryItemStateCreatedDto();
        dto.setStateEventId(new SellableInventoryItemStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setQuantitySellable(e.getQuantitySellable());
        List<SellableInventoryItemEntryStateEventDto.SellableInventoryItemEntryStateCreatedDto> sellableInventoryItemEntryEvents = new ArrayList<>();
        for (SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated ee : e.getSellableInventoryItemEntryEvents()) {
            SellableInventoryItemEntryStateEventDto.SellableInventoryItemEntryStateCreatedDto eeDto = getSellableInventoryItemEntryStateEventDtoConverter().toSellableInventoryItemEntryStateCreatedDto(ee);
            sellableInventoryItemEntryEvents.add(eeDto);
        }
        dto.setSellableInventoryItemEntryEvents(sellableInventoryItemEntryEvents.toArray(new SellableInventoryItemEntryStateEventDto.SellableInventoryItemEntryStateCreatedDto[0]));

        return dto;
    }

    public SellableInventoryItemStateEventDto.SellableInventoryItemStateMergePatchedDto toSellableInventoryItemStateMergePatchedDto(SellableInventoryItemStateEvent.SellableInventoryItemStateMergePatched e) {
        SellableInventoryItemStateEventDto.SellableInventoryItemStateMergePatchedDto dto = new SellableInventoryItemStateEventDto.SellableInventoryItemStateMergePatchedDto();
        dto.setStateEventId(new SellableInventoryItemStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setQuantitySellable(e.getQuantitySellable());
        dto.setIsPropertyQuantitySellableRemoved(e.getIsPropertyQuantitySellableRemoved());
        List<SellableInventoryItemEntryStateEventDto> sellableInventoryItemEntryEvents = new ArrayList<>();
        for (SellableInventoryItemEntryStateEvent ee : e.getSellableInventoryItemEntryEvents()) {
            SellableInventoryItemEntryStateEventDto eeDto = getSellableInventoryItemEntryStateEventDtoConverter().toSellableInventoryItemEntryStateEventDto((AbstractSellableInventoryItemEntryStateEvent) ee);
            sellableInventoryItemEntryEvents.add(eeDto);
        }
        dto.setSellableInventoryItemEntryEvents(sellableInventoryItemEntryEvents.toArray(new SellableInventoryItemEntryStateEventDto[0]));

        return dto;
    }


    protected SellableInventoryItemEntryStateEventDtoConverter getSellableInventoryItemEntryStateEventDtoConverter() {
        return new SellableInventoryItemEntryStateEventDtoConverter();
    }

}

