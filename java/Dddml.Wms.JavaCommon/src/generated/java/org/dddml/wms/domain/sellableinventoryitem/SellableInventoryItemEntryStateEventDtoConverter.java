package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class SellableInventoryItemEntryStateEventDtoConverter {

    public SellableInventoryItemEntryStateEventDto toSellableInventoryItemEntryStateEventDto(AbstractSellableInventoryItemEntryStateEvent stateEvent) {
        if (stateEvent instanceof AbstractSellableInventoryItemEntryStateEvent.AbstractSellableInventoryItemEntryStateCreated) {
            SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated e = (SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated) stateEvent;
            return toSellableInventoryItemEntryStateCreatedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public SellableInventoryItemEntryStateEventDto.SellableInventoryItemEntryStateCreatedDto toSellableInventoryItemEntryStateCreatedDto(SellableInventoryItemEntryStateEvent.SellableInventoryItemEntryStateCreated e) {
        SellableInventoryItemEntryStateEventDto.SellableInventoryItemEntryStateCreatedDto dto = new SellableInventoryItemEntryStateEventDto.SellableInventoryItemEntryStateCreatedDto();
        dto.setSellableInventoryItemEntryEventId(e.getSellableInventoryItemEntryEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setSellableQuantity(e.getSellableQuantity());
        dto.setSourceEventId(e.getSourceEventId());
        return dto;
    }

}

